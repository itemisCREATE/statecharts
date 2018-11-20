/**
 * Copyright (c) 2012-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.sgraph.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * 
 * All validation contraints for the meta model elements {@link Region}
 * 
 */
public class RegionValidator extends AbstractSGraphValidator {

	private static final String REGION_REQUIRES_DEFAULT_ENTRY_IF_ENTERED_BY_SHALLOW_HISTORY_MSG = "The region can't be entered using the shallow history. Add a default entry node.";
	public static final String REGION_REQUIRES_DEFAULT_ENTRY_IF_ENTERED_BY_SHALLOW_HISTORY_CODE = "region.RequiresDefaultEntryIfEnteredByShallowHistory";

	@Check(CheckType.FAST)
	public void checkRegionRequiresDefaultEntryIfEnteredByShallowHistory(Region region) {
		List<Entry> shallowHistories = region.getVertices().stream()
				.filter(v -> v instanceof Entry && ((Entry) v).getKind() == EntryKind.SHALLOW_HISTORY)
				.map(entry -> (Entry) entry).collect(Collectors.toList());

		for (Entry e : shallowHistories) {
			List<Region> regions = new ArrayList<>();
			for (Vertex v : e.getParentRegion().getVertices()) {
				if (v instanceof CompositeElement) {
					regions.addAll(((CompositeElement) v).getRegions());
				}
			}
			for (Region r : regions) {
				Entry defaultEntry = null;
				for (Vertex v : r.getVertices()) {
					if (v instanceof Entry && ((Entry) v).isDefault()) {
						defaultEntry = (Entry) v;
						break;
					}
				}
				if (defaultEntry == null) {
					error(REGION_REQUIRES_DEFAULT_ENTRY_IF_ENTERED_BY_SHALLOW_HISTORY_MSG, r, null, -1,
							REGION_REQUIRES_DEFAULT_ENTRY_IF_ENTERED_BY_SHALLOW_HISTORY_CODE);
				}
			}
		}
	}

	private final static String REGION_NO_MULTIPLE_DEFAULT_ENTRIES_MSG = "There are multiple default entry nodes (one without a name and one named 'default') in this region.";
	public final static String REGION_MUST_NOT_HAVE_MULTIPLE_DEFAULT_ENTRIES_CODE = "region.MustNotHaveMultipleDefaultEntries";

	@Check
	public void checkRegionMustNotHaveMultipleDefaultEntries(Entry entry) {
		Region region = (Region) entry.eContainer();
		List<Entry> initialEntires = region.getVertices().stream().filter(Entry.class::isInstance)
				.map(Entry.class::cast).filter(v -> v.getKind() == EntryKind.INITIAL).collect(Collectors.toList());
		boolean unamedEntryExists = initialEntires.stream().filter(v -> v.getName().trim().equals("")).count() > 0;
		boolean defaultNamedEntryExists = initialEntires.stream()
				.filter(v -> v.getName().trim().equalsIgnoreCase("default")).count() > 0;
		if (unamedEntryExists && defaultNamedEntryExists) {
			error(REGION_NO_MULTIPLE_DEFAULT_ENTRIES_MSG, region, null, -1,
					REGION_MUST_NOT_HAVE_MULTIPLE_DEFAULT_ENTRIES_CODE);
		}
	}

	private static final String REGION_NO_EXIT_ON_TOP_LEVEL_MSG = "Exit node in top level region not supported - use final states instead.";
	public static final String REGION_NO_EXIT_ON_TOP_LEVEL_CODE = "region.NoExitOnTopLevel";

	@Check(CheckType.FAST)
	public void checkRegionNoExitOnTopLevel(Region region) {
		if (region.getComposite() instanceof Statechart) {
			region.getVertices().stream().filter(v -> v instanceof Exit).forEach(
					exit -> error(REGION_NO_EXIT_ON_TOP_LEVEL_MSG, exit, null, -1, REGION_NO_EXIT_ON_TOP_LEVEL_CODE));

		}
	}

	private static final String REGION_ENTRY_TARGET_MUST_BE_CHILD_MSG = "Entry target must be child of the region.";
	public static final String REGION_ENTRY_TARGET_MUST_BE_CHILD_CODE = "region.EntryTargetMustBeChild";

	@Check(CheckType.FAST)
	public void checkRegionEntryTargetMustBeChild(Region region) {
		region.getVertices().stream().filter(v -> v instanceof Entry)
				.forEach(entry -> entry.getOutgoingTransitions().stream().forEach(t -> {
					if (!isChildOrSibling(t.getSource(), t.getTarget())) {
						error(REGION_ENTRY_TARGET_MUST_BE_CHILD_MSG, t, null, -1,
								REGION_ENTRY_TARGET_MUST_BE_CHILD_CODE);
					}
				}));

	}
	
	private static final String REGION_NEEDS_DEFAULT_ENTRY_WHEN_HISTORY_HAS_NO_OUTGOING_MSG = "The region should have a default entry pointing to the initial state.";
	public static final String REGION_NEEDS_DEFAULT_ENTRY_WHEN_HISTORY_HAS_NO_OUTGOING_CODE = "region.HistoryWithoutOutgoingNeedsDefaultEntry";
	
	@Check(CheckType.FAST)
	public void checkDefaultEntryExistsWhenHistoryHasNoOutgoingTransition(Region region) {
		if (existsHistoryWithoutOutgoingTransition(region) && !existsDefaultEntry(region)) {
			warning(REGION_NEEDS_DEFAULT_ENTRY_WHEN_HISTORY_HAS_NO_OUTGOING_MSG, region, null, -1,
					REGION_NEEDS_DEFAULT_ENTRY_WHEN_HISTORY_HAS_NO_OUTGOING_CODE);
		}
	}

	protected boolean existsDefaultEntry(Region region) {
		Stream<Entry> entries = region.getVertices().stream().filter(Entry.class::isInstance).map(Entry.class::cast);
		return entries.filter(v -> v.getKind() == EntryKind.INITIAL).anyMatch(v -> v.isDefault());
	}

	protected boolean existsHistoryWithoutOutgoingTransition(Region region) {
		Stream<Entry> entries = region.getVertices().stream().filter(Entry.class::isInstance).map(Entry.class::cast);
		return entries.filter(v -> v.getKind() == EntryKind.SHALLOW_HISTORY || v.getKind() == EntryKind.DEEP_HISTORY)
				.anyMatch(v -> v.getOutgoingTransitions().isEmpty());
	}

	protected boolean isChildOrSibling(Vertex source, Vertex target) {
		TreeIterator<EObject> iter = source.getParentRegion().eAllContents();
		while (iter.hasNext()) {
			if (target == iter.next()) {
				return true;
			}
		}
		return false;
	}

}
