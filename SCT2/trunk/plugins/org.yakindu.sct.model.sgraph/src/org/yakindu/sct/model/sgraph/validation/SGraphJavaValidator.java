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

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.validation.AbstractDeclarativeValidator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckType;
import org.eclipse.xtext.validation.EValidatorRegistrar;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Vertex;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;

import com.google.inject.Inject;

/**
 * This validator is intended to be used by a compositeValidator (See
 * {@link org.eclipse.xtext.validation.ComposedChecks}) of another language
 * specific validator. It does not register itself as an EValidator.
 * 
 * This validator checks for common graphical constraints for all kinds of state charts. 
 * 
 * @author terfloth
 * @author muelder
 * @author bohl - migrated to xtext infrastruture
 * @author schwertfeger
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
		if (!(vertex instanceof Entry)) {
			int incomingTransitions = 0;
			incomingTransitions += vertex.getIncomingTransitions().size();

			// in context of a state it is sufficient if a sub state is targeted
			// by
			// an external transition
			if (vertex instanceof org.yakindu.sct.model.sgraph.State) {
				TreeIterator<EObject> eAllContents = vertex.eAllContents();
				while (eAllContents.hasNext()) {
					EObject next = eAllContents.next();
					if (next instanceof org.yakindu.sct.model.sgraph.State) {
						for (Transition transition : ((org.yakindu.sct.model.sgraph.State) next)
								.getIncomingTransitions()) {
							if (!EcoreUtil.isAncestor(vertex,
									transition.getSource())) {
								incomingTransitions++;
							}
						}
					}
				}
			}

			if (incomingTransitions == 0) {
				error(ISSUE_NODE_NOT_REACHABLE, vertex, null, -1);
			}
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
		AbstractSCTResource eResource = (AbstractSCTResource) state.eResource();
		eResource.linkSubStatechart(state);
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
	public boolean isLanguageSpecific() {
		return false;
	}

	@Inject
	public void register(EValidatorRegistrar registrar) {
		// Do not register because this validator is only a composite #398987
	}
}
