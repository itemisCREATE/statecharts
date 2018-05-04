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

import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * 
 * All validation contraints for the meta model elements {@link Entry}
 *
 */
public class EntryValidator extends AbstractSGraphValidator {


	private static final String REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NO_DEFAULT_ENTRY_MSG = "The region can't be entered using the shallow history. Add a default entry node.";
	public static final String REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NO_DEFAULT_ENTRY_CODE = "entry.region.default";

	private static final String REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NON_CONNECTED_DEFAULT_ENTRY_MSG = "The region can't be entered using the shallow history. Add a transition from default entry to a state.";
	public static final String REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NON_CONNECTED_DEFAULT_ENTRY_CODE = "entry.in.transition";

	private final static String REGION_MULTIPLE_DEFAULT_ENTRIES_MSG = "There are multiple default entry nodes (one without a name and one named 'default') in this region.";
	public final static String REGION_MULTIPLE_DEFAULT_ENTRIES_CODE = "region.duplicate.entry";


	
	
	private static final String ENTRY_TRANSITIONS_NO_IN_IF_INITIAL_MSG  = "Initial entry should have no incoming transition.";
	public static final String  ENTRY_TRANSITIONS_NO_IN_IF_INITIAL_CODE = "entry.transitions.NoInIfInitial";

	@Check(CheckType.FAST)
	public void checkEntryTransitionsNoInIfInitial(Entry entry) {
		if (entry.getIncomingTransitions().size() > 0 && entry.getKind().equals(EntryKind.INITIAL)) {
			warning(ENTRY_TRANSITIONS_NO_IN_IF_INITIAL_MSG, entry, null, -1, ENTRY_TRANSITIONS_NO_IN_IF_INITIAL_CODE);
		}
	}


	private static final String ENTRY_TRANSITIONS_REQUIRE_OUT_IF_INITIAL_MSG  = "Initial entry must have an outgoing transition.";
	public static final String  ENTRY_TRANSITIONS_REQUIRE_OUT_IF_INITIAL_CODE = "entry.transitions.RequireOutIfInitial";

	@Check(CheckType.FAST)
	public void checkEntryTransitionsRequireOneOutIfInitial(Entry entry) {
		if (entry.getKind().equals(EntryKind.INITIAL) && entry.getOutgoingTransitions().size() == 0 ) {
			error(ENTRY_TRANSITIONS_REQUIRE_OUT_IF_INITIAL_MSG, entry, null, -1, ENTRY_TRANSITIONS_REQUIRE_OUT_IF_INITIAL_CODE);
		}
	}

		
	private static final String ENTRY_TRANSITIONS_NO_MULTIPLE_OUT_MSG  = "Entries must not have more than one outgoing transition.";
	public static final String  ENTRY_TRANSITIONS_NO_MULTIPLE_OUT_CODE = "entry.transitions.NoMultipleOut";

	@Check(CheckType.FAST)
	public void checkEntryTransitionsNoMultipleOut(Entry entry) {
		if (entry.getOutgoingTransitions().size() > 1) {
			error(ENTRY_TRANSITIONS_NO_MULTIPLE_OUT_MSG, entry, null, -1, ENTRY_TRANSITIONS_NO_MULTIPLE_OUT_CODE);
		}
	}

	
	private static final String ENTRY_TRANSITIONS_NO_TRIGGER_ON_OUT_MSG = "Outgoing transitions from entry points must not have a trigger or guard.";
	public static final String ENTRY_TRANSITIONS_NO_TRIGGER_ON_OUT_CODE = "entry.transitions.NoTriggerOnOut";

	@Check(CheckType.FAST)
	public void checkEntryTransitionsNoTriggerOnOut(Entry entry) {
		for (Transition transition : entry.getOutgoingTransitions()) {
			if (transition.getTrigger() != null) {
				error(ENTRY_TRANSITIONS_NO_TRIGGER_ON_OUT_MSG, entry, null, -1, ENTRY_TRANSITIONS_NO_TRIGGER_ON_OUT_CODE);
			}
		}
	}

	@Check(CheckType.FAST)
	public void regionCantBeEnteredUsingShallowHistory(Entry e) {
		if (e.getKind() == EntryKind.SHALLOW_HISTORY) {
			List<Region> regions = new ArrayList<>();
			for (Vertex v : e.getParentRegion().getVertices()) {
				if (v instanceof CompositeElement) {
					regions.addAll(((CompositeElement) v).getRegions());
				}
			}
			for (Region r : regions) {
				Entry defaultEntry = null;
				for (Vertex v : r.getVertices()) {
					if (v instanceof Entry) {
						String name = v.getName().trim().toLowerCase();
						if (name != null || "".equals(name) || "default".equals(name)) {
							defaultEntry = (Entry) v;
							break;
						}
					}
				}
				if (defaultEntry == null) {
					error(REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NO_DEFAULT_ENTRY_MSG, r, null, -1,
							REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NO_DEFAULT_ENTRY_CODE);
				} else if (defaultEntry.getOutgoingTransitions().size() != 1) {
					error(REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NON_CONNECTED_DEFAULT_ENTRY_MSG, r, null, -1,
							REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NON_CONNECTED_DEFAULT_ENTRY_CODE);
				}
			}

		}

	}

	@Check
	public void checkOnlyOneDefaultEntryPermitted(Entry entry) {
		Region region = (Region) entry.eContainer();
		List<Entry> initialEntires = region.getVertices().stream().filter(Entry.class::isInstance)
				.map(Entry.class::cast).filter(v -> v.getKind() == EntryKind.INITIAL).collect(Collectors.toList());
		boolean unamedEntryExists = initialEntires.stream().filter(v -> v.getName().equals("")).count() > 0;
		boolean defaultNamedEntryExists = initialEntires.stream()
				.filter(v -> v.getName().trim().equalsIgnoreCase("default")).count() > 0;
		if (unamedEntryExists && defaultNamedEntryExists) {
			error(REGION_MULTIPLE_DEFAULT_ENTRIES_MSG, region, null, -1, REGION_MULTIPLE_DEFAULT_ENTRIES_CODE);
		}
	}

}
