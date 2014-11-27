/**
 */
package org.yakindu.sct.model.stext.stext.util;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

import org.yakindu.base.base.NamedElement;

import org.yakindu.base.expressions.expressions.Expression;

import org.yakindu.base.types.Feature;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Property;
import org.yakindu.base.types.TypedElement;

import org.yakindu.sct.model.sgraph.Declaration;
import org.yakindu.sct.model.sgraph.Effect;
import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.Reaction;
import org.yakindu.sct.model.sgraph.ReactionProperty;
import org.yakindu.sct.model.sgraph.Scope;
import org.yakindu.sct.model.sgraph.ScopedElement;
import org.yakindu.sct.model.sgraph.Trigger;
import org.yakindu.sct.model.sgraph.Variable;

import org.yakindu.sct.model.stext.stext.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.model.stext.stext.StextPackage
 * @generated
 */
public class StextSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StextPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StextSwitch() {
		if (modelPackage == null) {
			modelPackage = StextPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case StextPackage.ROOT: {
				Root root = (Root)theEObject;
				T result = caseRoot(root);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.DEF_ROOT: {
				DefRoot defRoot = (DefRoot)theEObject;
				T result = caseDefRoot(defRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.STATECHART_ROOT: {
				StatechartRoot statechartRoot = (StatechartRoot)theEObject;
				T result = caseStatechartRoot(statechartRoot);
				if (result == null) result = caseDefRoot(statechartRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.STATE_ROOT: {
				StateRoot stateRoot = (StateRoot)theEObject;
				T result = caseStateRoot(stateRoot);
				if (result == null) result = caseDefRoot(stateRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.TRANSITION_ROOT: {
				TransitionRoot transitionRoot = (TransitionRoot)theEObject;
				T result = caseTransitionRoot(transitionRoot);
				if (result == null) result = caseDefRoot(transitionRoot);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.STATECHART_SPECIFICATION: {
				StatechartSpecification statechartSpecification = (StatechartSpecification)theEObject;
				T result = caseStatechartSpecification(statechartSpecification);
				if (result == null) result = caseScopedElement(statechartSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.STATE_SPECIFICATION: {
				StateSpecification stateSpecification = (StateSpecification)theEObject;
				T result = caseStateSpecification(stateSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.TRANSITION_SPECIFICATION: {
				TransitionSpecification transitionSpecification = (TransitionSpecification)theEObject;
				T result = caseTransitionSpecification(transitionSpecification);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.STATECHART_SCOPE: {
				StatechartScope statechartScope = (StatechartScope)theEObject;
				T result = caseStatechartScope(statechartScope);
				if (result == null) result = caseScope(statechartScope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.INTERFACE_SCOPE: {
				InterfaceScope interfaceScope = (InterfaceScope)theEObject;
				T result = caseInterfaceScope(interfaceScope);
				if (result == null) result = caseStatechartScope(interfaceScope);
				if (result == null) result = caseNamedElement(interfaceScope);
				if (result == null) result = caseScope(interfaceScope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.INTERNAL_SCOPE: {
				InternalScope internalScope = (InternalScope)theEObject;
				T result = caseInternalScope(internalScope);
				if (result == null) result = caseStatechartScope(internalScope);
				if (result == null) result = caseScope(internalScope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.IMPORT_SCOPE: {
				ImportScope importScope = (ImportScope)theEObject;
				T result = caseImportScope(importScope);
				if (result == null) result = caseStatechartScope(importScope);
				if (result == null) result = caseScope(importScope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.IMPORT: {
				Import import_ = (Import)theEObject;
				T result = caseImport(import_);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.EVENT_DEFINITION: {
				EventDefinition eventDefinition = (EventDefinition)theEObject;
				T result = caseEventDefinition(eventDefinition);
				if (result == null) result = caseEvent(eventDefinition);
				if (result == null) result = caseTypes_Event(eventDefinition);
				if (result == null) result = caseDeclaration(eventDefinition);
				if (result == null) result = caseFeature(eventDefinition);
				if (result == null) result = caseNamedElement(eventDefinition);
				if (result == null) result = caseTypedElement(eventDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.VARIABLE_DEFINITION: {
				VariableDefinition variableDefinition = (VariableDefinition)theEObject;
				T result = caseVariableDefinition(variableDefinition);
				if (result == null) result = caseVariable(variableDefinition);
				if (result == null) result = caseProperty(variableDefinition);
				if (result == null) result = caseDeclaration(variableDefinition);
				if (result == null) result = caseFeature(variableDefinition);
				if (result == null) result = caseNamedElement(variableDefinition);
				if (result == null) result = caseTypedElement(variableDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.OPERATION_DEFINITION: {
				OperationDefinition operationDefinition = (OperationDefinition)theEObject;
				T result = caseOperationDefinition(operationDefinition);
				if (result == null) result = caseDeclaration(operationDefinition);
				if (result == null) result = caseOperation(operationDefinition);
				if (result == null) result = caseFeature(operationDefinition);
				if (result == null) result = caseNamedElement(operationDefinition);
				if (result == null) result = caseTypedElement(operationDefinition);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.LOCAL_REACTION: {
				LocalReaction localReaction = (LocalReaction)theEObject;
				T result = caseLocalReaction(localReaction);
				if (result == null) result = caseDeclaration(localReaction);
				if (result == null) result = caseReaction(localReaction);
				if (result == null) result = caseNamedElement(localReaction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.TRANSITION_REACTION: {
				TransitionReaction transitionReaction = (TransitionReaction)theEObject;
				T result = caseTransitionReaction(transitionReaction);
				if (result == null) result = caseReaction(transitionReaction);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.GUARD: {
				Guard guard = (Guard)theEObject;
				T result = caseGuard(guard);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.ENTRY_POINT_SPEC: {
				EntryPointSpec entryPointSpec = (EntryPointSpec)theEObject;
				T result = caseEntryPointSpec(entryPointSpec);
				if (result == null) result = caseReactionProperty(entryPointSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.EXIT_POINT_SPEC: {
				ExitPointSpec exitPointSpec = (ExitPointSpec)theEObject;
				T result = caseExitPointSpec(exitPointSpec);
				if (result == null) result = caseReactionProperty(exitPointSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.EVENT_SPEC: {
				EventSpec eventSpec = (EventSpec)theEObject;
				T result = caseEventSpec(eventSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.REGULAR_EVENT_SPEC: {
				RegularEventSpec regularEventSpec = (RegularEventSpec)theEObject;
				T result = caseRegularEventSpec(regularEventSpec);
				if (result == null) result = caseEventSpec(regularEventSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.TIME_EVENT_SPEC: {
				TimeEventSpec timeEventSpec = (TimeEventSpec)theEObject;
				T result = caseTimeEventSpec(timeEventSpec);
				if (result == null) result = caseEventSpec(timeEventSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.BUILTIN_EVENT_SPEC: {
				BuiltinEventSpec builtinEventSpec = (BuiltinEventSpec)theEObject;
				T result = caseBuiltinEventSpec(builtinEventSpec);
				if (result == null) result = caseEventSpec(builtinEventSpec);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.ENTRY_EVENT: {
				EntryEvent entryEvent = (EntryEvent)theEObject;
				T result = caseEntryEvent(entryEvent);
				if (result == null) result = caseBuiltinEventSpec(entryEvent);
				if (result == null) result = caseEventSpec(entryEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.EXIT_EVENT: {
				ExitEvent exitEvent = (ExitEvent)theEObject;
				T result = caseExitEvent(exitEvent);
				if (result == null) result = caseBuiltinEventSpec(exitEvent);
				if (result == null) result = caseEventSpec(exitEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.ALWAYS_EVENT: {
				AlwaysEvent alwaysEvent = (AlwaysEvent)theEObject;
				T result = caseAlwaysEvent(alwaysEvent);
				if (result == null) result = caseBuiltinEventSpec(alwaysEvent);
				if (result == null) result = caseEventSpec(alwaysEvent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.SIMPLE_SCOPE: {
				SimpleScope simpleScope = (SimpleScope)theEObject;
				T result = caseSimpleScope(simpleScope);
				if (result == null) result = caseScope(simpleScope);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.REACTION_TRIGGER: {
				ReactionTrigger reactionTrigger = (ReactionTrigger)theEObject;
				T result = caseReactionTrigger(reactionTrigger);
				if (result == null) result = caseTrigger(reactionTrigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.DEFAULT_TRIGGER: {
				DefaultTrigger defaultTrigger = (DefaultTrigger)theEObject;
				T result = caseDefaultTrigger(defaultTrigger);
				if (result == null) result = caseTrigger(defaultTrigger);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.REACTION_EFFECT: {
				ReactionEffect reactionEffect = (ReactionEffect)theEObject;
				T result = caseReactionEffect(reactionEffect);
				if (result == null) result = caseEffect(reactionEffect);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.EVENT_RAISING_EXPRESSION: {
				EventRaisingExpression eventRaisingExpression = (EventRaisingExpression)theEObject;
				T result = caseEventRaisingExpression(eventRaisingExpression);
				if (result == null) result = caseExpression(eventRaisingExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.EVENT_VALUE_REFERENCE_EXPRESSION: {
				EventValueReferenceExpression eventValueReferenceExpression = (EventValueReferenceExpression)theEObject;
				T result = caseEventValueReferenceExpression(eventValueReferenceExpression);
				if (result == null) result = caseExpression(eventValueReferenceExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case StextPackage.ACTIVE_STATE_REFERENCE_EXPRESSION: {
				ActiveStateReferenceExpression activeStateReferenceExpression = (ActiveStateReferenceExpression)theEObject;
				T result = caseActiveStateReferenceExpression(activeStateReferenceExpression);
				if (result == null) result = caseExpression(activeStateReferenceExpression);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRoot(Root object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Def Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Def Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefRoot(DefRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statechart Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statechart Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatechartRoot(StatechartRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateRoot(StateRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Root</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Root</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionRoot(TransitionRoot object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statechart Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statechart Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatechartSpecification(StatechartSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>State Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>State Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStateSpecification(StateSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Specification</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Specification</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionSpecification(TransitionSpecification object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Statechart Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Statechart Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStatechartScope(StatechartScope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Interface Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Interface Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInterfaceScope(InterfaceScope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Internal Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Internal Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseInternalScope(InternalScope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImportScope(ImportScope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Import</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseImport(Import object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventDefinition(EventDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariableDefinition(VariableDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation Definition</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperationDefinition(OperationDefinition object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Local Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Local Reaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLocalReaction(LocalReaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transition Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transition Reaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTransitionReaction(TransitionReaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Guard</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Guard</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseGuard(Guard object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Point Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Point Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntryPointSpec(EntryPointSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exit Point Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exit Point Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExitPointSpec(ExitPointSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventSpec(EventSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Regular Event Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Regular Event Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRegularEventSpec(RegularEventSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Time Event Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Time Event Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTimeEventSpec(TimeEventSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Builtin Event Spec</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Builtin Event Spec</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseBuiltinEventSpec(BuiltinEventSpec object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Entry Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Entry Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEntryEvent(EntryEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Exit Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Exit Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExitEvent(ExitEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Always Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Always Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAlwaysEvent(AlwaysEvent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Simple Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Simple Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSimpleScope(SimpleScope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reaction Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reaction Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReactionTrigger(ReactionTrigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Default Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Default Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDefaultTrigger(DefaultTrigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reaction Effect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reaction Effect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReactionEffect(ReactionEffect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Raising Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Raising Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventRaisingExpression(EventRaisingExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event Value Reference Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event Value Reference Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEventValueReferenceExpression(EventValueReferenceExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Active State Reference Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Active State Reference Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseActiveStateReferenceExpression(ActiveStateReferenceExpression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scoped Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scoped Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScopedElement(ScopedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Scope</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Scope</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseScope(Scope object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNamedElement(NamedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Declaration</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeclaration(Declaration object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEvent(Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Typed Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypedElement(TypedElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Feature</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFeature(Feature object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Event</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Event</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTypes_Event(org.yakindu.base.types.Event object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Variable</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVariable(Variable object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseProperty(Property object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Operation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseOperation(Operation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reaction</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReaction(Reaction object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reaction Property</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reaction Property</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReactionProperty(ReactionProperty object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Trigger</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrigger(Trigger object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Effect</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Effect</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEffect(Effect object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Expression</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpression(Expression object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //StextSwitch
