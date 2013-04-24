/**
 * Copyright (c) 2013 itemis AG and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 * 	itemis AG - initial API and implementation
 * 
 */
package org.yakindu.sct.model.stext.validation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.ReactionProperty;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.stext.stext.EntryPointSpec;
import org.yakindu.sct.model.stext.stext.ExitPointSpec;

public final class STextValidationModelUtils {

	private STextValidationModelUtils() {
	}

	// STEXT
	public static List<Transition>[] getEntrySpecSortedTransitions(
			List<Transition> elements) {
		@SuppressWarnings("unchecked")
		final List<Transition>[] transitions = new ArrayList[2];
		// first list contains Transitions without entry spec
		transitions[0] = new ArrayList<Transition>();
		// second list contains Transitions with entry spec
		transitions[1] = new ArrayList<Transition>();
		for (Transition transition : elements) {
			boolean hasEntrySpec = false;
			for (ReactionProperty property : transition.getProperties()) {
				if (property instanceof EntryPointSpec) {
					transitions[1].add(transition);
					hasEntrySpec = true;
					break;
				}
			}
			if (!hasEntrySpec) {
				transitions[0].add(transition);
			}
		}
		return transitions;
	}

	// STEXT
	public static List<Transition>[] getExitSpecSortedTransitions(
			List<Transition> elements) {
		@SuppressWarnings("unchecked")
		final List<Transition>[] transitions = new ArrayList[2];
		// first list contains Transitions without exit spec
		transitions[0] = new ArrayList<Transition>();
		// second list contains Transitions with exit spec
		transitions[1] = new ArrayList<Transition>();
		for (Transition transition : elements) {
			boolean hasExitSpec = false;
			for (ReactionProperty property : transition.getProperties()) {
				if (property instanceof ExitPointSpec) {
					transitions[1].add(transition);
					hasExitSpec = true;
					break;
				}
			}
			if (!hasExitSpec) {
				transitions[0].add(transition);
			}
		}
		return transitions;
	}

	// SGRAPH
	public static Map<Region, List<Entry>> getRegionsWithoutDefaultEntry(
			List<Region> elements) {
		Map<Region, List<Entry>> regions = new HashMap<Region, List<Entry>>();
		for (Region region : elements) {
			boolean hasDefaultEntry = false;
			final List<Entry> entries = getEntries(region.eContents());
			for (Entry entry : entries) {
				if (isDefault(entry)) {
					hasDefaultEntry = true;
					break;
				}
			}
			if (!hasDefaultEntry) {
				regions.put(region, entries);
			}
		}
		return regions;
	}

	// SGRAPH
	public static Map<Region, List<Exit>> getRegionsWithoutDefaultExit(
			List<Region> elements) {
		Map<Region, List<Exit>> regions = new HashMap<Region, List<Exit>>();
		for (Region region : elements) {
			boolean hasDefaultExit = false;
			final List<Exit> exits = getExits(region.eContents());
			for (Exit exit : exits) {
				if (isDefault(exit)) {
					hasDefaultExit = true;
					break;
				}
			}
			if (!hasDefaultExit) {
				regions.put(region, exits);
			}
		}
		return regions;
	}

	// BASE
	private static boolean isDefault(final NamedElement element) {
		return element.getName() == null
				|| (element.getName() != null && (element.getName().isEmpty() || element
						.getName().equalsIgnoreCase("default")));
	}

	// SGRAPH
	private static List<Entry> getEntries(List<EObject> elements) {
		List<Entry> entries = new ArrayList<Entry>();
		for (EObject element : elements) {
			if (element instanceof Entry) {
				entries.add((Entry) element);
			}
		}
		return entries;
	}

	// SGRAPH
	private static List<Exit> getExits(List<EObject> elements) {
		List<Exit> exits = new ArrayList<Exit>();
		for (EObject element : elements) {
			if (element instanceof Exit) {
				exits.add((Exit) element);
			}
		}
		return exits;
	}
}
