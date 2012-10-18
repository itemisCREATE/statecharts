/**
 * Copyright (c) 2012 committers of YAKINDU and others.
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
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * 
 * @author terfloth
 * @author muelder
 * @author bohl - migrated to xtext infrastruture
 */

public class SGraphJavaValidator extends AbstractDeclarativeValidator {

	public static final String ISSUE_STATE_WITHOUT_NAME = "A state must have a name.";
	public static final String ISSUE_NODE_NOT_REACHABLE = "Node is not reachable due to missing incoming transition.";
	public static final String ISSUE_FINAL_STATE_OUTGOING_TRANSITION = "A final state should have no outgoing transition.";
	public static final String ISSUE_STATE_WITHOUT_OUTGOING_TRANSITION = "A state should have at least one outgoing transition.";
	public static final String ISSUE_INITIAL_ENTRY_WITH_IN_TRANS = "Initial entry should have no incoming transition.";
	public static final String ISSUE_INITIAL_ENTRY_WITHOUT_OUT_TRANS = "Initial entry should have a single outgoing transition";
	public static final String ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS = "Entries must not have more than one outgoing transition";
	public static final String ISSUE_ENTRY_WITH_TRIGGER = "Outgoing Transitions from Entries can not have a Trigger or Guard.";
	public static final String ISSUE_CHOICE_WITHOUT_OUTGOING_TRANSITION = "A choice must have at least one outgoing transition.";
	public static final String ISSUE_SUBMACHINE_UNRESOLVABLE = "Referenced Substatemachine '%s'does not exist!";

	@Check(CheckType.FAST)
	public void vertexNotReachable(Vertex vertex) {
		if (vertex instanceof State) {
			TreeIterator<EObject> eAllContents = vertex.eAllContents();
			while (eAllContents.hasNext()) {
				EObject next = eAllContents.next();
				if (next instanceof State) {
					EList<Transition> incomingTransitions = ((org.yakindu.sct.model.sgraph.State) next) // State
							.getIncomingTransitions();
					for (Transition transition : incomingTransitions) {
						if (EcoreUtil
								.isAncestor(vertex, transition.getSource())) {
							error(ISSUE_NODE_NOT_REACHABLE, vertex, null, -1);
						}
					}
				}
			}

		} else if (vertex.getIncomingTransitions().size() == 0
				&& !(vertex instanceof Entry)) {
			error(ISSUE_NODE_NOT_REACHABLE, vertex, null, -1);
		}

	}

	@Check(CheckType.FAST)
	public void incomingTransitionCount(Vertex vertex) {
		if (vertex.getIncomingTransitions().size() > 0
				&& vertex instanceof Entry
				&& ((Entry) vertex).getKind().equals(EntryKind.INITIAL)) {
			warning(ISSUE_INITIAL_ENTRY_WITH_IN_TRANS, vertex, null, -1);
		}
	}

	@Check(CheckType.FAST)
	public void checkUnresolvableSubmachine(
			org.yakindu.sct.model.sgraph.State state) {
		if (state.getSubstatechartId() == null)
			return;
		Statechart substatechart = state.getSubstatechart();
		if (substatechart == null) {
			error(String.format(ISSUE_SUBMACHINE_UNRESOLVABLE,
					state.getSubstatechartId()), null);
		} else if (substatechart.eIsProxy()) {
			substatechart = (Statechart) EcoreUtil
					.resolve(substatechart, state);
			if (substatechart.eIsProxy()) {
				error(String.format(ISSUE_SUBMACHINE_UNRESOLVABLE,
						state.getSubstatechartId()), null);
			}
		}
	}

	@Check(CheckType.FAST)
	public void outgoingTransitionCount(FinalState finalState) {
		if ((finalState.getOutgoingTransitions().size() > 0)) {
			warning(ISSUE_FINAL_STATE_OUTGOING_TRANSITION, finalState, null, -1);
		}
	}

	@Check(CheckType.FAST)
	public void nameIsNotEmpty(org.yakindu.sct.model.sgraph.State state) {
		if ((state.getName() == null || state.getName().trim().length() == 0)
				&& !(state instanceof FinalState)) {
			error(ISSUE_STATE_WITHOUT_NAME, state, null, -1);
		}
	}

	@Check(CheckType.FAST)
	public void outgoingTransitionCount(Choice choice) {
		// Choice without outgoing transition
		if (choice.getOutgoingTransitions().size() == 0) {
			error(ISSUE_CHOICE_WITHOUT_OUTGOING_TRANSITION, choice, null, -1);
		}
	}

	@Check(CheckType.FAST)
	public void disallowTrigger(Entry entry) {
		for (Transition transition : entry.getOutgoingTransitions()) {
			if (transition.getTrigger() != null) {
				error(ISSUE_ENTRY_WITH_TRIGGER, entry, null, -1);
			}
		}
	}

	@Check(CheckType.FAST)
	public void outgoingTransitionCount(Entry entry) {
		if (entry.getOutgoingTransitions().size() == 0
				&& ((Entry) entry).getKind().equals(EntryKind.INITIAL)) {
			warning(ISSUE_INITIAL_ENTRY_WITHOUT_OUT_TRANS, entry, null, -1);
		}
		if (entry.getOutgoingTransitions().size() > 1) {
			error(ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS, entry, null, -1);
		}
	}

	@Override
	protected List<EPackage> getEPackages() {
		List<EPackage> result = new ArrayList<EPackage>();
		result.add(EPackage.Registry.INSTANCE
				.getEPackage("http://www.yakindu.org/sct/sgraph/2.0.0"));
		result.add(EPackage.Registry.INSTANCE
				.getEPackage("http://www.yakindu.org/base/base/2.0.0"));
		result.add(EPackage.Registry.INSTANCE
				.getEPackage("http://www.yakindu.org/base/types/2.0.0"));
		return result;
	}

	@Override
	public boolean isLanguageSpecific() {
		return false;
	}

	@Override
	protected boolean isResponsible(Map<Object, Object> context, EObject eObject) {
		return true;
	}
}
