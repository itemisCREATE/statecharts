/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sgraph.util;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.yakindu.sct.model.sgraph.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.sct.model.sgraph.Choice;
import org.yakindu.sct.model.sgraph.ChoiceKind;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Entry;
import org.yakindu.sct.model.sgraph.EntryKind;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.Exit;
import org.yakindu.sct.model.sgraph.FinalState;
import org.yakindu.sct.model.sgraph.Pseudostate;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.ReactiveElement;
import org.yakindu.sct.model.sgraph.Region;
import org.yakindu.sct.model.sgraph.RegularState;
import org.yakindu.sct.model.sgraph.SGraphPackage;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.SpecificationElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.model.sgraph.Statement;
import org.yakindu.sct.model.sgraph.Synchronization;
import org.yakindu.sct.model.sgraph.Transition;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Variable;
import org.yakindu.sct.model.sgraph.Vertex;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc
 * -->
 * 
 * @see org.yakindu.sct.model.sgraph.SGraphPackage
 * @generated
 */
public class SGraphValidator extends EObjectValidator {

	public static final String ISSUE_STATE_WITHOUT_NAME = "A state must have a name.";
	public static final String ISSUE_NODE_NOT_REACHABLE = "Node is not reachable due to missing incoming transition.";
	public static final String ISSUE_FINAL_STATE_OUTGOING_TRANSITION = "A final state should have no outgoing transition.";
	public static final String ISSUE_STATE_WITHOUT_OUTGOING_TRANSITION = "A state should have at least one outgoing transition.";
	public static final String ISSUE_INITIAL_ENTRY_WITH_IN_TRANS = "Initial entry should have no incoming transition.";
	public static final String ISSUE_INITIAL_ENTRY_WITHOUT_OUT_TRANS = "Initial entry should have a single outgoing transition";
	public final static String ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS = "Entries must not have more than one outgoing transition";
	public static final String ISSUE_SUBMACHINESTATE_WITHOUT_SUBMACHINE = "Selected Submachine can not be resolved.";
	public static final String ISSUE_SUBMACHINESTATE__CYCLE = "A submachine state can not contain itself as as Submachine.";
	public static final String ISSUE_ENTRY_WITH_TRIGGER = "Outgoing Transitions from Entries can not have a Trigger or Guard.";
	public static final String ISSUE_CHOICE_WITHOUT_OUTGOING_TRANSITION = "A choice must have at least one outgoing transition.";
	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * The cached model package
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public static final SGraphValidator INSTANCE = new SGraphValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.yakindu.sct.model.sgraph";

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	private static final int GENERATED_DIAGNOSTIC_CODE_COUNT = 0;

	/**
	 * A constant with a fixed name that can be used as the base value for additional hand written constants in a derived class.
	 * <!-- begin-user-doc
	 * --> <!-- end-user-doc -->
	 * @generated
	 */
	protected static final int DIAGNOSTIC_CODE_COUNT = GENERATED_DIAGNOSTIC_CODE_COUNT;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc --> <!--
	 * end-user-doc -->
	 * @generated
	 */
	public SGraphValidator() {
		super();
	}

	/**
	 * Returns the package of this validator switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EPackage getEPackage() {
	  return SGraphPackage.eINSTANCE;
	}

	/**
	 * Calls <code>validateXXX</code> for the corresponding classifier of the model.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected boolean validate(int classifierID, Object value,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		switch (classifierID) {
			case SGraphPackage.PSEUDOSTATE:
				return validatePseudostate((Pseudostate)value, diagnostics, context);
			case SGraphPackage.VERTEX:
				return validateVertex((Vertex)value, diagnostics, context);
			case SGraphPackage.REGION:
				return validateRegion((Region)value, diagnostics, context);
			case SGraphPackage.TRANSITION:
				return validateTransition((Transition)value, diagnostics, context);
			case SGraphPackage.FINAL_STATE:
				return validateFinalState((FinalState)value, diagnostics, context);
			case SGraphPackage.VARIABLE:
				return validateVariable((Variable)value, diagnostics, context);
			case SGraphPackage.EVENT:
				return validateEvent((Event)value, diagnostics, context);
			case SGraphPackage.CHOICE:
				return validateChoice((Choice)value, diagnostics, context);
			case SGraphPackage.STATECHART:
				return validateStatechart((Statechart)value, diagnostics, context);
			case SGraphPackage.ENTRY:
				return validateEntry((Entry)value, diagnostics, context);
			case SGraphPackage.TRIGGER:
				return validateTrigger((Trigger)value, diagnostics, context);
			case SGraphPackage.EFFECT:
				return validateEffect((Effect)value, diagnostics, context);
			case SGraphPackage.SPECIFICATION_ELEMENT:
				return validateSpecificationElement((SpecificationElement)value, diagnostics, context);
			case SGraphPackage.DECLARATION:
				return validateDeclaration((Declaration)value, diagnostics, context);
			case SGraphPackage.REACTION:
				return validateReaction((Reaction)value, diagnostics, context);
			case SGraphPackage.REACTIVE_ELEMENT:
				return validateReactiveElement((ReactiveElement)value, diagnostics, context);
			case SGraphPackage.EXIT:
				return validateExit((Exit)value, diagnostics, context);
			case SGraphPackage.SCOPE:
				return validateScope((Scope)value, diagnostics, context);
			case SGraphPackage.SCOPED_ELEMENT:
				return validateScopedElement((ScopedElement)value, diagnostics, context);
			case SGraphPackage.SYNCHRONIZATION:
				return validateSynchronization((Synchronization)value, diagnostics, context);
			case SGraphPackage.STATE:
				return validateState((State)value, diagnostics, context);
			case SGraphPackage.STATEMENT:
				return validateStatement((Statement)value, diagnostics, context);
			case SGraphPackage.REGULAR_STATE:
				return validateRegularState((RegularState)value, diagnostics, context);
			case SGraphPackage.COMPOSITE_ELEMENT:
				return validateCompositeElement((CompositeElement)value, diagnostics, context);
			case SGraphPackage.ENTRY_KIND:
				return validateEntryKind((EntryKind)value, diagnostics, context);
			case SGraphPackage.CHOICE_KIND:
				return validateChoiceKind((ChoiceKind)value, diagnostics, context);
			default:
				return true;
		}
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validatePseudostate(Pseudostate pseudostate,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(pseudostate, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(pseudostate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(pseudostate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(pseudostate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(pseudostate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(pseudostate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(pseudostate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(pseudostate, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(pseudostate, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_IncomingTransitionCount(pseudostate, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVertex(Vertex vertex, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(vertex, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(vertex, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_IncomingTransitionCount(vertex, diagnostics, context);
		return result;
	}

	/**
	 * Validates the IncomingTransitionCount constraint of '<em>Vertex</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateVertex_IncomingTransitionCount(Vertex vertex,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (vertex instanceof State) {
			if (vertex.getIncomingTransitions().size() > 0) {
				return true;
			}
			TreeIterator<EObject> eAllContents = vertex.eAllContents();
			while (eAllContents.hasNext()) {
				EObject next = eAllContents.next();
				if (next instanceof State) {
					EList<Transition> incomingTransitions = ((State) next)
							.getIncomingTransitions();
					for (Transition transition : incomingTransitions) {
						if (!EcoreUtil.isAncestor(vertex,
								transition.getSource())) {
							return true;
						}
					}
				}
			}
			return error(vertex, diagnostics, ISSUE_NODE_NOT_REACHABLE);
		} else if (vertex.getIncomingTransitions().size() == 0
				&& !(vertex instanceof Entry)) {
			return error(vertex, diagnostics, ISSUE_NODE_NOT_REACHABLE);
		}
		if (vertex.getIncomingTransitions().size() > 0
				&& vertex instanceof Entry
				&& ((Entry) vertex).getKind().equals(EntryKind.INITIAL)) {
			return warning(vertex, diagnostics,
					ISSUE_INITIAL_ENTRY_WITH_IN_TRANS);
		}

		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegion(Region region, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(region, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(region, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(region, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(region, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(region, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(region, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(region, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(region, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(region, diagnostics, context);
		if (result || diagnostics != null) result &= validateRegion_ExactlyOneInitialState(region, diagnostics, context);
		return result;
	}

	/**
	 * Validates the ExactlyOneInitialState constraint of '<em>Region</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateRegion_ExactlyOneInitialState(Region region,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTransition(Transition transition,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(transition, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateFinalState(FinalState finalState,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(finalState, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(finalState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(finalState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(finalState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(finalState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(finalState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(finalState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(finalState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(finalState, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_IncomingTransitionCount(finalState, diagnostics, context);
		if (result || diagnostics != null) result &= validateFinalState_OutgoingTransitionCount(finalState, diagnostics, context);
		return result;
	}

	/**
	 * Validates the OutgoingTransitionCount constraint of '<em>Final State</em>
	 * '. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateFinalState_OutgoingTransitionCount(
			FinalState finalState, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if ((finalState.getOutgoingTransitions().size() > 0)) {
			return warning(finalState, diagnostics,
					ISSUE_FINAL_STATE_OUTGOING_TRANSITION);
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateState(State state, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(state, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(state, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(state, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_IncomingTransitionCount(state, diagnostics, context);
		if (result || diagnostics != null) result &= validateState_NameIsNotEmpty(state, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NameIsNotEmpty constraint of '<em>State</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateState_NameIsNotEmpty(State state,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if ((state.getName() == null || state.getName().trim().length() == 0)
				&& !(state instanceof FinalState)) {
			return error(state, diagnostics, ISSUE_STATE_WITHOUT_NAME);
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatement(Statement statement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(statement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateRegularState(RegularState regularState,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(regularState, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(regularState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(regularState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(regularState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(regularState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(regularState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(regularState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(regularState, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(regularState, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_IncomingTransitionCount(regularState, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateCompositeElement(CompositeElement compositeElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(compositeElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateVariable(Variable variable,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(variable, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEvent(Event event, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(event, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChoice(Choice choice, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(choice, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_IncomingTransitionCount(choice, diagnostics, context);
		if (result || diagnostics != null) result &= validateChoice_OutgoingTransitionCount(choice, diagnostics, context);
		return result;
	}

	/**
	 * Validates the OutgoingTransitionCount constraint of '<em>Choice</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateChoice_OutgoingTransitionCount(Choice choice,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// Choice without outgoing transition
		if (choice.getOutgoingTransitions().size() == 0) {
			return error(choice, diagnostics, ISSUE_CHOICE_WITHOUT_OUTGOING_TRANSITION);
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateStatechart(Statechart statechart,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(statechart, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntry(Entry entry, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(entry, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(entry, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(entry, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(entry, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(entry, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(entry, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(entry, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(entry, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(entry, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_IncomingTransitionCount(entry, diagnostics, context);
		if (result || diagnostics != null) result &= validateEntry_DisallowTrigger(entry, diagnostics, context);
		if (result || diagnostics != null) result &= validateEntry_OutgoingTransitionCount(entry, diagnostics, context);
		return result;
	}

	/**
	 * Validates the DisallowTrigger constraint of '<em>Entry</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateEntry_DisallowTrigger(Entry entry,
			DiagnosticChain diagnostics, Map<Object, Object> context) {

		for (Transition transition : entry.getOutgoingTransitions()) {
			if (transition.getTrigger() != null) {
				if (diagnostics != null) {
					diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
							DIAGNOSTIC_SOURCE, 0, ISSUE_ENTRY_WITH_TRIGGER,
							new Object[] { transition }));
				}
				return false;
			}
		}
		return true;
	}

	/**
	 * Validates the OutgoingTransitionCount constraint of '<em>Entry</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateEntry_OutgoingTransitionCount(Entry entry,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (entry.getOutgoingTransitions().size() == 0
				&& ((Entry) entry).getKind().equals(EntryKind.INITIAL)) {
			return warning(entry, diagnostics,
					ISSUE_INITIAL_ENTRY_WITHOUT_OUT_TRANS);
		}
		if (entry.getOutgoingTransitions().size() > 1) {
			return error(entry, diagnostics,
					ISSUE_ENTRY_WITH_MULTIPLE_OUT_TRANS);
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateTrigger(Trigger trigger,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(trigger, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEffect(Effect effect, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(effect, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSpecificationElement(
			SpecificationElement specificationElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(specificationElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateDeclaration(Declaration declaration,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(declaration, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReaction(Reaction reaction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(reaction, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateReactiveElement(ReactiveElement reactiveElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(reactiveElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateExit(Exit exit, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		if (!validate_NoCircularContainment(exit, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(exit, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(exit, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(exit, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(exit, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(exit, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(exit, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(exit, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(exit, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_IncomingTransitionCount(exit, diagnostics, context);
		return result;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScope(Scope scope, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(scope, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateScopedElement(ScopedElement scopedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(scopedElement, diagnostics, context);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateSynchronization(Synchronization synchronization,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(synchronization, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(synchronization, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_IncomingTransitionCount(synchronization, diagnostics, context);
		return result;
	}

	/**
	 * Validates the SubStatechartExists constraint of '
	 * <em>Submachine State</em>'. <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	// public boolean validateSubmachineState_SubStatechartExists(
	// State submachineState, DiagnosticChain diagnostics,
	// Map<Object, Object> context) {
	// if ((submachineState.getSubstatechart() == null || submachineState
	// .getSubstatechart().eIsProxy())) {
	// return error(submachineState, diagnostics,
	// ISSUE_SUBMACHINESTATE_WITHOUT_SUBMACHINE);
	// }
	// return true;
	//
	// }

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateEntryKind(EntryKind entryKind,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateChoiceKind(ChoiceKind choiceKind,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return true;
	}

	/**
	 * Returns the resource locator that will be used to fetch messages for this validator's diagnostics.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ResourceLocator getResourceLocator() {
		// TODO
		// Specialize this to return a resource locator for messages specific to this validator.
		// Ensure that you remove @generated or mark it @generated NOT
		return super.getResourceLocator();
	}

	protected boolean warning(Vertex vertex, DiagnosticChain diagnostics,
			String message) {
		if (diagnostics != null) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING,
					DIAGNOSTIC_SOURCE, 0, message, new Object[] { vertex }));
		}
		return false;
	}

	protected boolean error(Vertex vertex, DiagnosticChain diagnostics,
			String message) {
		if (diagnostics != null) {
			diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
					DIAGNOSTIC_SOURCE, 0, message, new Object[] { vertex }));
		}
		return false;
	}

} // StatechartValidator
