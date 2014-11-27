/**
 */
package org.yakindu.sct.model.stext.stext.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

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
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.model.stext.stext.StextPackage
 * @generated
 */
public class StextAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static StextPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StextAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = StextPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StextSwitch<Adapter> modelSwitch =
		new StextSwitch<Adapter>() {
			@Override
			public Adapter caseRoot(Root object) {
				return createRootAdapter();
			}
			@Override
			public Adapter caseDefRoot(DefRoot object) {
				return createDefRootAdapter();
			}
			@Override
			public Adapter caseStatechartRoot(StatechartRoot object) {
				return createStatechartRootAdapter();
			}
			@Override
			public Adapter caseStateRoot(StateRoot object) {
				return createStateRootAdapter();
			}
			@Override
			public Adapter caseTransitionRoot(TransitionRoot object) {
				return createTransitionRootAdapter();
			}
			@Override
			public Adapter caseStatechartSpecification(StatechartSpecification object) {
				return createStatechartSpecificationAdapter();
			}
			@Override
			public Adapter caseStateSpecification(StateSpecification object) {
				return createStateSpecificationAdapter();
			}
			@Override
			public Adapter caseTransitionSpecification(TransitionSpecification object) {
				return createTransitionSpecificationAdapter();
			}
			@Override
			public Adapter caseStatechartScope(StatechartScope object) {
				return createStatechartScopeAdapter();
			}
			@Override
			public Adapter caseInterfaceScope(InterfaceScope object) {
				return createInterfaceScopeAdapter();
			}
			@Override
			public Adapter caseInternalScope(InternalScope object) {
				return createInternalScopeAdapter();
			}
			@Override
			public Adapter caseImportScope(ImportScope object) {
				return createImportScopeAdapter();
			}
			@Override
			public Adapter caseImport(Import object) {
				return createImportAdapter();
			}
			@Override
			public Adapter caseEventDefinition(EventDefinition object) {
				return createEventDefinitionAdapter();
			}
			@Override
			public Adapter caseVariableDefinition(VariableDefinition object) {
				return createVariableDefinitionAdapter();
			}
			@Override
			public Adapter caseOperationDefinition(OperationDefinition object) {
				return createOperationDefinitionAdapter();
			}
			@Override
			public Adapter caseLocalReaction(LocalReaction object) {
				return createLocalReactionAdapter();
			}
			@Override
			public Adapter caseTransitionReaction(TransitionReaction object) {
				return createTransitionReactionAdapter();
			}
			@Override
			public Adapter caseGuard(Guard object) {
				return createGuardAdapter();
			}
			@Override
			public Adapter caseEntryPointSpec(EntryPointSpec object) {
				return createEntryPointSpecAdapter();
			}
			@Override
			public Adapter caseExitPointSpec(ExitPointSpec object) {
				return createExitPointSpecAdapter();
			}
			@Override
			public Adapter caseEventSpec(EventSpec object) {
				return createEventSpecAdapter();
			}
			@Override
			public Adapter caseRegularEventSpec(RegularEventSpec object) {
				return createRegularEventSpecAdapter();
			}
			@Override
			public Adapter caseTimeEventSpec(TimeEventSpec object) {
				return createTimeEventSpecAdapter();
			}
			@Override
			public Adapter caseBuiltinEventSpec(BuiltinEventSpec object) {
				return createBuiltinEventSpecAdapter();
			}
			@Override
			public Adapter caseEntryEvent(EntryEvent object) {
				return createEntryEventAdapter();
			}
			@Override
			public Adapter caseExitEvent(ExitEvent object) {
				return createExitEventAdapter();
			}
			@Override
			public Adapter caseAlwaysEvent(AlwaysEvent object) {
				return createAlwaysEventAdapter();
			}
			@Override
			public Adapter caseSimpleScope(SimpleScope object) {
				return createSimpleScopeAdapter();
			}
			@Override
			public Adapter caseReactionTrigger(ReactionTrigger object) {
				return createReactionTriggerAdapter();
			}
			@Override
			public Adapter caseDefaultTrigger(DefaultTrigger object) {
				return createDefaultTriggerAdapter();
			}
			@Override
			public Adapter caseReactionEffect(ReactionEffect object) {
				return createReactionEffectAdapter();
			}
			@Override
			public Adapter caseEventRaisingExpression(EventRaisingExpression object) {
				return createEventRaisingExpressionAdapter();
			}
			@Override
			public Adapter caseEventValueReferenceExpression(EventValueReferenceExpression object) {
				return createEventValueReferenceExpressionAdapter();
			}
			@Override
			public Adapter caseActiveStateReferenceExpression(ActiveStateReferenceExpression object) {
				return createActiveStateReferenceExpressionAdapter();
			}
			@Override
			public Adapter caseScopedElement(ScopedElement object) {
				return createScopedElementAdapter();
			}
			@Override
			public Adapter caseScope(Scope object) {
				return createScopeAdapter();
			}
			@Override
			public Adapter caseNamedElement(NamedElement object) {
				return createNamedElementAdapter();
			}
			@Override
			public Adapter caseDeclaration(Declaration object) {
				return createDeclarationAdapter();
			}
			@Override
			public Adapter caseEvent(Event object) {
				return createEventAdapter();
			}
			@Override
			public Adapter caseTypedElement(TypedElement object) {
				return createTypedElementAdapter();
			}
			@Override
			public Adapter caseFeature(Feature object) {
				return createFeatureAdapter();
			}
			@Override
			public Adapter caseTypes_Event(org.yakindu.base.types.Event object) {
				return createTypes_EventAdapter();
			}
			@Override
			public Adapter caseVariable(Variable object) {
				return createVariableAdapter();
			}
			@Override
			public Adapter caseProperty(Property object) {
				return createPropertyAdapter();
			}
			@Override
			public Adapter caseOperation(Operation object) {
				return createOperationAdapter();
			}
			@Override
			public Adapter caseReaction(Reaction object) {
				return createReactionAdapter();
			}
			@Override
			public Adapter caseReactionProperty(ReactionProperty object) {
				return createReactionPropertyAdapter();
			}
			@Override
			public Adapter caseTrigger(Trigger object) {
				return createTriggerAdapter();
			}
			@Override
			public Adapter caseEffect(Effect object) {
				return createEffectAdapter();
			}
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.Root <em>Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.Root
	 * @generated
	 */
	public Adapter createRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.DefRoot <em>Def Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.DefRoot
	 * @generated
	 */
	public Adapter createDefRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.StatechartRoot <em>Statechart Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.StatechartRoot
	 * @generated
	 */
	public Adapter createStatechartRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.StateRoot <em>State Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.StateRoot
	 * @generated
	 */
	public Adapter createStateRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.TransitionRoot <em>Transition Root</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.TransitionRoot
	 * @generated
	 */
	public Adapter createTransitionRootAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.StatechartSpecification <em>Statechart Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.StatechartSpecification
	 * @generated
	 */
	public Adapter createStatechartSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.StateSpecification <em>State Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.StateSpecification
	 * @generated
	 */
	public Adapter createStateSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.TransitionSpecification <em>Transition Specification</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.TransitionSpecification
	 * @generated
	 */
	public Adapter createTransitionSpecificationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.StatechartScope <em>Statechart Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.StatechartScope
	 * @generated
	 */
	public Adapter createStatechartScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.InterfaceScope <em>Interface Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.InterfaceScope
	 * @generated
	 */
	public Adapter createInterfaceScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.InternalScope <em>Internal Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.InternalScope
	 * @generated
	 */
	public Adapter createInternalScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.ImportScope <em>Import Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.ImportScope
	 * @generated
	 */
	public Adapter createImportScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.Import
	 * @generated
	 */
	public Adapter createImportAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.EventDefinition <em>Event Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.EventDefinition
	 * @generated
	 */
	public Adapter createEventDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.VariableDefinition <em>Variable Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.VariableDefinition
	 * @generated
	 */
	public Adapter createVariableDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.OperationDefinition <em>Operation Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.OperationDefinition
	 * @generated
	 */
	public Adapter createOperationDefinitionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.LocalReaction <em>Local Reaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.LocalReaction
	 * @generated
	 */
	public Adapter createLocalReactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.TransitionReaction <em>Transition Reaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.TransitionReaction
	 * @generated
	 */
	public Adapter createTransitionReactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.Guard <em>Guard</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.Guard
	 * @generated
	 */
	public Adapter createGuardAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.EntryPointSpec <em>Entry Point Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.EntryPointSpec
	 * @generated
	 */
	public Adapter createEntryPointSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.ExitPointSpec <em>Exit Point Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.ExitPointSpec
	 * @generated
	 */
	public Adapter createExitPointSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.EventSpec <em>Event Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.EventSpec
	 * @generated
	 */
	public Adapter createEventSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.RegularEventSpec <em>Regular Event Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.RegularEventSpec
	 * @generated
	 */
	public Adapter createRegularEventSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.TimeEventSpec <em>Time Event Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.TimeEventSpec
	 * @generated
	 */
	public Adapter createTimeEventSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.BuiltinEventSpec <em>Builtin Event Spec</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.BuiltinEventSpec
	 * @generated
	 */
	public Adapter createBuiltinEventSpecAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.EntryEvent <em>Entry Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.EntryEvent
	 * @generated
	 */
	public Adapter createEntryEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.ExitEvent <em>Exit Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.ExitEvent
	 * @generated
	 */
	public Adapter createExitEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.AlwaysEvent <em>Always Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.AlwaysEvent
	 * @generated
	 */
	public Adapter createAlwaysEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.SimpleScope <em>Simple Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.SimpleScope
	 * @generated
	 */
	public Adapter createSimpleScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.ReactionTrigger <em>Reaction Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.ReactionTrigger
	 * @generated
	 */
	public Adapter createReactionTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.DefaultTrigger <em>Default Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.DefaultTrigger
	 * @generated
	 */
	public Adapter createDefaultTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.ReactionEffect <em>Reaction Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.ReactionEffect
	 * @generated
	 */
	public Adapter createReactionEffectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.EventRaisingExpression <em>Event Raising Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.EventRaisingExpression
	 * @generated
	 */
	public Adapter createEventRaisingExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.EventValueReferenceExpression <em>Event Value Reference Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
	 * @generated
	 */
	public Adapter createEventValueReferenceExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression <em>Active State Reference Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
	 * @generated
	 */
	public Adapter createActiveStateReferenceExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgraph.ScopedElement <em>Scoped Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sgraph.ScopedElement
	 * @generated
	 */
	public Adapter createScopedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgraph.Scope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sgraph.Scope
	 * @generated
	 */
	public Adapter createScopeAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.base.NamedElement <em>Named Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.base.NamedElement
	 * @generated
	 */
	public Adapter createNamedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgraph.Declaration <em>Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sgraph.Declaration
	 * @generated
	 */
	public Adapter createDeclarationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgraph.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sgraph.Event
	 * @generated
	 */
	public Adapter createEventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.TypedElement <em>Typed Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.TypedElement
	 * @generated
	 */
	public Adapter createTypedElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.Feature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.Feature
	 * @generated
	 */
	public Adapter createFeatureAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.Event <em>Event</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.Event
	 * @generated
	 */
	public Adapter createTypes_EventAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgraph.Variable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sgraph.Variable
	 * @generated
	 */
	public Adapter createVariableAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.Property <em>Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.Property
	 * @generated
	 */
	public Adapter createPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.types.Operation <em>Operation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.types.Operation
	 * @generated
	 */
	public Adapter createOperationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgraph.Reaction <em>Reaction</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sgraph.Reaction
	 * @generated
	 */
	public Adapter createReactionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgraph.ReactionProperty <em>Reaction Property</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sgraph.ReactionProperty
	 * @generated
	 */
	public Adapter createReactionPropertyAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgraph.Trigger <em>Trigger</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sgraph.Trigger
	 * @generated
	 */
	public Adapter createTriggerAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgraph.Effect <em>Effect</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.sct.model.sgraph.Effect
	 * @generated
	 */
	public Adapter createEffectAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //StextAdapterFactory
