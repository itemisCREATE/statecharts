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
package org.yakindu.model.sct.statechart.util;

import java.util.Map;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.ResourceLocator;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.util.EObjectValidator;
import org.yakindu.model.sct.statechart.*;
import org.yakindu.model.sct.statechart.Choice;
import org.yakindu.model.sct.statechart.Declaration;
import org.yakindu.model.sct.statechart.Effect;
import org.yakindu.model.sct.statechart.Entry;
import org.yakindu.model.sct.statechart.EntryKind;
import org.yakindu.model.sct.statechart.Event;
import org.yakindu.model.sct.statechart.Exit;
import org.yakindu.model.sct.statechart.ExpressionElement;
import org.yakindu.model.sct.statechart.FinalState;
import org.yakindu.model.sct.statechart.Junction;
import org.yakindu.model.sct.statechart.NamedElement;
import org.yakindu.model.sct.statechart.Pseudostate;
import org.yakindu.model.sct.statechart.Reaction;
import org.yakindu.model.sct.statechart.ReactiveElement;
import org.yakindu.model.sct.statechart.Region;
import org.yakindu.model.sct.statechart.Scope;
import org.yakindu.model.sct.statechart.ScopedElement;
import org.yakindu.model.sct.statechart.State;
import org.yakindu.model.sct.statechart.Statechart;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.model.sct.statechart.Transition;
import org.yakindu.model.sct.statechart.Trigger;
import org.yakindu.model.sct.statechart.Variable;
import org.yakindu.model.sct.statechart.Vertex;

/**
 * <!-- begin-user-doc --> The <b>Validator</b> for the model. <!-- end-user-doc
 * -->
 * 
 * @see org.yakindu.model.sct.statechart.StatechartPackage
 * @generated
 */
public class StatechartValidator extends EObjectValidator {
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
	public static final StatechartValidator INSTANCE = new StatechartValidator();

	/**
	 * A constant for the {@link org.eclipse.emf.common.util.Diagnostic#getSource() source} of diagnostic {@link org.eclipse.emf.common.util.Diagnostic#getCode() codes} from this package.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see org.eclipse.emf.common.util.Diagnostic#getSource()
	 * @see org.eclipse.emf.common.util.Diagnostic#getCode()
	 * @generated
	 */
	public static final String DIAGNOSTIC_SOURCE = "org.yakindu.model.sct.statechart";

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
	public StatechartValidator() {
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
	  return StatechartPackage.eINSTANCE;
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
			case StatechartPackage.PSEUDOSTATE:
				return validatePseudostate((Pseudostate)value, diagnostics, context);
			case StatechartPackage.VERTEX:
				return validateVertex((Vertex)value, diagnostics, context);
			case StatechartPackage.NAMED_ELEMENT:
				return validateNamedElement((NamedElement)value, diagnostics, context);
			case StatechartPackage.REGION:
				return validateRegion((Region)value, diagnostics, context);
			case StatechartPackage.TRANSITION:
				return validateTransition((Transition)value, diagnostics, context);
			case StatechartPackage.FINAL_STATE:
				return validateFinalState((FinalState)value, diagnostics, context);
			case StatechartPackage.STATE:
				return validateState((State)value, diagnostics, context);
			case StatechartPackage.VARIABLE:
				return validateVariable((Variable)value, diagnostics, context);
			case StatechartPackage.JUNCTION:
				return validateJunction((Junction)value, diagnostics, context);
			case StatechartPackage.EVENT:
				return validateEvent((Event)value, diagnostics, context);
			case StatechartPackage.CHOICE:
				return validateChoice((Choice)value, diagnostics, context);
			case StatechartPackage.STATECHART:
				return validateStatechart((Statechart)value, diagnostics, context);
			case StatechartPackage.ENTRY:
				return validateEntry((Entry)value, diagnostics, context);
			case StatechartPackage.TRIGGER:
				return validateTrigger((Trigger)value, diagnostics, context);
			case StatechartPackage.EFFECT:
				return validateEffect((Effect)value, diagnostics, context);
			case StatechartPackage.EXPRESSION_ELEMENT:
				return validateExpressionElement((ExpressionElement)value, diagnostics, context);
			case StatechartPackage.DECLARATION:
				return validateDeclaration((Declaration)value, diagnostics, context);
			case StatechartPackage.REACTION:
				return validateReaction((Reaction)value, diagnostics, context);
			case StatechartPackage.REACTIVE_ELEMENT:
				return validateReactiveElement((ReactiveElement)value, diagnostics, context);
			case StatechartPackage.EXIT:
				return validateExit((Exit)value, diagnostics, context);
			case StatechartPackage.SCOPE:
				return validateScope((Scope)value, diagnostics, context);
			case StatechartPackage.SCOPED_ELEMENT:
				return validateScopedElement((ScopedElement)value, diagnostics, context);
			case StatechartPackage.ENTRY_KIND:
				return validateEntryKind((EntryKind)value, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateVertex_OutgoingTransitionCount(pseudostate, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateVertex_OutgoingTransitionCount(vertex, diagnostics, context);
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
		if (vertex.getIncomingTransitions().size() == 0
				&& !(vertex instanceof Entry)) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.ERROR,
						DIAGNOSTIC_SOURCE, 0,
						"A state must have at least one outgoing transition!",
						new Object[] { vertex }));
			}
			return false;
		}
		return true;
	}

	/**
	 * Validates the OutgoingTransitionCount constraint of '<em>Vertex</em>'.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public boolean validateVertex_OutgoingTransitionCount(Vertex vertex,
			DiagnosticChain diagnostics, Map<Object, Object> context) {

		if (vertex.getOutgoingTransitions().size() == 0
				&& !(vertex instanceof FinalState)) {
			if (diagnostics != null) {
				diagnostics
						.add(new BasicDiagnostic(
								Diagnostic.WARNING,
								DIAGNOSTIC_SOURCE,
								0,
								"A state should have at least one outgoing transition.",
								new Object[] { vertex }));
			}
			return false;
		}
		return true;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean validateNamedElement(NamedElement namedElement,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(namedElement, diagnostics, context);
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

		int entryCount = 0;
		EList<Vertex> vertices = region.getVertices();
		for (Vertex vertex : vertices) {
			if (vertex instanceof Entry) {
				entryCount++;
			}
		}
		if (entryCount != 1) {
			if (diagnostics != null) {
				diagnostics.add(new BasicDiagnostic(Diagnostic.WARNING,
						DIAGNOSTIC_SOURCE, 0,
						"A region must contain exactly one initial state!",
						new Object[] { region }));
			}
			return false;
		}
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
		if (result || diagnostics != null) result &= validateVertex_OutgoingTransitionCount(finalState, diagnostics, context);
		if (result || diagnostics != null) result &= validateState_NameIsNotEmpty(finalState, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= validateVertex_OutgoingTransitionCount(state, diagnostics, context);
		if (result || diagnostics != null) result &= validateState_NameIsNotEmpty(state, diagnostics, context);
		return result;
	}

	/**
	 * Validates the NameIsNotEmpty constraint of '<em>State</em>'. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated
	 */
	public boolean validateState_NameIsNotEmpty(State state,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		// TODO implement the constraint
		// -> specify the condition that violates the constraint
		// -> verify the diagnostic details, including severity, code, and message
		// Ensure that you remove @generated or mark it @generated NOT
		if (false) {
			if (diagnostics != null) {
				diagnostics.add
					(createDiagnostic
						(Diagnostic.ERROR,
						 DIAGNOSTIC_SOURCE,
						 0,
						 "_UI_GenericConstraint_diagnostic",
						 new Object[] { "NameIsNotEmpty", getObjectLabel(state, context) },
						 new Object[] { state },
						 context));
			}
			return false;
		}
		return true;
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
	public boolean validateJunction(Junction junction,
			DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (!validate_NoCircularContainment(junction, diagnostics, context)) return false;
		boolean result = validate_EveryMultiplicityConforms(junction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryDataValueConforms(junction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryReferenceIsContained(junction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryBidirectionalReferenceIsPaired(junction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryProxyResolves(junction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_UniqueID(junction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryKeyUnique(junction, diagnostics, context);
		if (result || diagnostics != null) result &= validate_EveryMapEntryUnique(junction, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_IncomingTransitionCount(junction, diagnostics, context);
		if (result || diagnostics != null) result &= validateVertex_OutgoingTransitionCount(junction, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= validateVertex_OutgoingTransitionCount(choice, diagnostics, context);
		return result;
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
		if (result || diagnostics != null) result &= validateVertex_OutgoingTransitionCount(entry, diagnostics, context);
		return result;
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
	public boolean validateExpressionElement(
			ExpressionElement expressionElement, DiagnosticChain diagnostics,
			Map<Object, Object> context) {
		return validate_EveryDefaultConstraint(expressionElement, diagnostics, context);
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
		if (result || diagnostics != null) result &= validateVertex_OutgoingTransitionCount(exit, diagnostics, context);
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
	public boolean validateEntryKind(EntryKind entryKind,
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

} // StatechartValidator
