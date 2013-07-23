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
import java.util.Iterator;
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

	/**
	 * Sorts the given elements in transition without and with
	 * {@link EntryPointSpec}s
	 * 
	 * @param elements
	 *            list of transitions to sort
	 * @return an array with the sorted elements. The first index contains a
	 *         list of the transitions without {@link EntryPointSpec}s. The
	 *         second index contains a list of the transitions with
	 *         {@link EntryPointSpec}s.
	 */
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

	/**
	 * Sorts the given elements in transition without and with
	 * {@link ExitPointSpec}s
	 * 
	 * @param elements
	 *            - list of transitions to sort
	 * @return an array with the sorted elements. The first index contains a
	 *         list of the transitions without {@link ExitPointSpec}s. The
	 *         second index contains a list of the transitions with
	 *         {@link ExitPointSpec}s.
	 */
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

	/**
	 * If a {@link Region} contains no 'default' named {@link entry} it is added
	 * as key to a map with a list of all entries of the region.
	 * 
	 * @param elements
	 *            - a list with {@link Region} elements.
	 * @return a map with a region (key) which contains no default {@link entry}
	 *         and a list of all {@link entry} elements of the {@link Region}
	 *         (value).
	 */
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

	/**
	 * If a {@link Region} contains no 'default' named {@link exit} it is added
	 * as key to a map with a list of all exits of the region.
	 * 
	 * @param elements
	 *            - a list with {@link Region} elements.
	 * @return a map with a region (key) which contains no default {@link exit}
	 *         and a list of all {@link exit} elements of the {@link Region}
	 *         (value).
	 */
	public static Map<Region, List<Exit>> getRegionsWithoutDefaultExit(
			List<Region> elements) {
		Map<Region, List<Exit>> regions = new HashMap<Region, List<Exit>>();
		for (Region region : elements) {
			boolean hasDefaultExit = false;
			final List<Exit> exits = getExits(region.eContents());
			if (!exits.isEmpty()) {
				for (Exit exit : exits) {
					if (isDefault(exit)) {
						hasDefaultExit = true;
						break;
					}
				}
			} else {
				hasDefaultExit = true;
			}

			if (!hasDefaultExit) {
				regions.put(region, exits);
			}
		}
		return regions;
	}

	/**
	 * Checks if the name of the given element matches the requirements to be a
	 * 'default' element.
	 * 
	 * @param element
	 *            - the {@link NamedElement}
	 * @return {@code true} if the name is null, empty or equals 'default'
	 *         (ignoring case).
	 */
	public static boolean isDefault(final NamedElement element) {
		return element.getName() == null
				|| (element.getName() != null && (element.getName().isEmpty() || element
						.getName().equalsIgnoreCase("default")));
	}

	/**
	 * Validates if the a {@link Transition} has an {@link ExitPointSpec} with
	 * the given name.
	 * 
	 * @param transition
	 *            - the transition to check
	 * @param name
	 *            - the name to check
	 * @return {@code true} if the transition contains an ExitPointSpec with the
	 *         name. Otherwise {@code false}.
	 */
	public static boolean isNamedExitTransition(Transition transition,
			String name) {

		boolean isNamedExitTransition = false;

		Iterator<ReactionProperty> propertyIt = transition.getProperties()
				.iterator();

		while (propertyIt.hasNext() && !isNamedExitTransition) {

			ReactionProperty property = propertyIt.next();

			if (property instanceof ExitPointSpec) {

				isNamedExitTransition = name.equals(((ExitPointSpec) property)
						.getExitpoint());
			}
		}

		return isNamedExitTransition;
	}

	public static boolean isDefaultExitTransition(Transition transition) {
		boolean isDefault = false;
		List<ExitPointSpec> exits = getExitPointSpecs(transition
				.getProperties());
		if (!exits.isEmpty()) {
			for (ExitPointSpec exit : exits) {
				if (exit.getExitpoint().equalsIgnoreCase("default")) {
					isDefault = true;
				}
			}
		} else {
			isDefault = true;
		}

		return isDefault;
	}

	/**
	 * Filters the given list of {@link ReactionProperty} to return only a list
	 * of {@link ExitPointSpec}.
	 * 
	 * @param elements
	 * 			- list of ReactionProperties
	 * @return
	 * 		A list of ExitPointSpecs.
	 */
	public static List<ExitPointSpec> getExitPointSpecs(
			List<ReactionProperty> elements) {
		List<ExitPointSpec> exits = new ArrayList<ExitPointSpec>();
		for (ReactionProperty element : elements) {
			if (element instanceof ExitPointSpec) {
				exits.add((ExitPointSpec) element);
			}
		}
		return exits;
	}

	public static List<Entry> getEntries(List<EObject> elements) {
		List<Entry> entries = new ArrayList<Entry>();
		for (EObject element : elements) {
			if (element instanceof Entry) {
				entries.add((Entry) element);
			}
		}
		return entries;
	}

	public static List<Exit> getExits(List<EObject> elements) {
		List<Exit> exits = new ArrayList<Exit>();
		for (EObject element : elements) {
			if (element instanceof Exit) {
				exits.add((Exit) element);
			}
		}
		return exits;
	}
}
