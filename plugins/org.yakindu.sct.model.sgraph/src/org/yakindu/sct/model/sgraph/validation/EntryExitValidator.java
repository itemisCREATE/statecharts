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
 * All validation contraints for the meta model elements {@link Entry} and
 * {@link Exit}
 *
 */
public class EntryExitValidator extends AbstractSGraphValidator {

	private static final String INITIAL_ENTRY_NO_IN_TRANSITION_MSG = "Initial entry should have no incoming transition.";
	public static final String INITIAL_ENTRY_NO_IN_TRANSITION_CODE = "entry.in.transition";

	public static final String ENTRY_WITH_MULTIPLE_OUT_TRANS_MSG = "Entries must not have more than one outgoing transition.";
	private static final String INITIAL_ENTRY_ONE_OUT_TRANSITION_MSG = "Initial entry should have exactly one outgoing transition.";
	public static final String INITIAL_ENTRY_ONE_OUT_TRANSITION_CODE = "entry.out.transition";

	private static final String EXIT_AT_LEAST_ONE_IN_TRANSITION_MSG = "Exit node should have at least one incoming transition.";
	public static final String EXIT_AT_LEAST_ONE_IN_TRANSITION_CODE = "exit.in.transition";

	private static final String EXIT_NO_OUTGOING_TRANSITION_MSG = "Exit node should have no outgoing transition.";
	public static final String EXIT_NO_OUTGOING_TRANSITION_CODE = "exit.out.transition";

	private static final String EXIT_NO_TOPLEVEL_REGION_MSG = "Exit node in top level region not supported - use final states instead.";
	public static final String EXIT_NO_TOPLEVEL_REGION_CODE = "exit.not.toplevel";

	private static final String ENTRY_NO_TRIGGER_MSG = "Outgoing transitions from entry points can not have a trigger or guard.";
	public static final String ENTRY_NO_TRIGGER_CODE = "entry.no.trigger";

	private static final String REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NO_DEFAULT_ENTRY_MSG = "The region can't be entered using the shallow history. Add a default entry node.";
	public static final String REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NO_DEFAULT_ENTRY_CODE = "entry.region.default";

	private static final String REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NON_CONNECTED_DEFAULT_ENTRY_MSG = "The region can't be entered using the shallow history. Add a transition from default entry to a state.";
	public static final String REGION_CANT_BE_ENTERED_USING_SHALLOW_HISTORY_NON_CONNECTED_DEFAULT_ENTRY_CODE = "entry.in.transition";

	private final static String REGION_MULTIPLE_DEFAULT_ENTRIES_MSG = "There are multiple default entry nodes (one without a name and one named 'default') in this region.";
	public final static String REGION_MULTIPLE_DEFAULT_ENTRIES_CODE = "region.duplicate.entry";

	@Check(CheckType.FAST)
	public void initialEntryWithoutIncomingTransitions(Entry entry) {
		if (entry.getIncomingTransitions().size() > 0 && entry.getKind().equals(EntryKind.INITIAL)) {
			warning(INITIAL_ENTRY_NO_IN_TRANSITION_MSG, entry, null, -1, INITIAL_ENTRY_NO_IN_TRANSITION_CODE);
		}
	}

	@Check(CheckType.FAST)
	public void initialEntryWithoutOutgoingTransition(Entry entry) {
		if (entry.getOutgoingTransitions().size() > 1) {
			error(ENTRY_WITH_MULTIPLE_OUT_TRANS_MSG, entry, null, -1, INITIAL_ENTRY_ONE_OUT_TRANSITION_CODE);
		} else if (entry.getOutgoingTransitions().size() != 1 && ((Entry) entry).getKind().equals(EntryKind.INITIAL)) {
			warning(INITIAL_ENTRY_ONE_OUT_TRANSITION_MSG, entry, null, -1, INITIAL_ENTRY_ONE_OUT_TRANSITION_CODE);
		}
	}

	@Check(CheckType.FAST)
	public void exitWithoutIncomingTransition(Exit exit) {
		if (exit.getIncomingTransitions().size() == 0) {
			warning(EXIT_AT_LEAST_ONE_IN_TRANSITION_MSG, exit, null, -1, EXIT_AT_LEAST_ONE_IN_TRANSITION_CODE);
		}
	}

	@Check(CheckType.FAST)
	public void exitWithOutgoingTransition(Exit exit) {
		if (exit.getOutgoingTransitions().size() > 0) {
			error(EXIT_NO_OUTGOING_TRANSITION_MSG, exit, null, -1, EXIT_NO_OUTGOING_TRANSITION_CODE);
		}
	}

	@Check(CheckType.FAST)
	public void exitOnStatechart(Exit exit) {
		if (exit.getParentRegion().getComposite() instanceof Statechart) {
			error(EXIT_NO_TOPLEVEL_REGION_MSG, exit, null, -1, EXIT_NO_TOPLEVEL_REGION_CODE);
		}
	}

	@Check(CheckType.FAST)
	public void disallowTrigger(Entry entry) {
		for (Transition transition : entry.getOutgoingTransitions()) {
			if (transition.getTrigger() != null) {
				error(ENTRY_NO_TRIGGER_MSG, entry, null, -1, ENTRY_NO_TRIGGER_CODE);
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
