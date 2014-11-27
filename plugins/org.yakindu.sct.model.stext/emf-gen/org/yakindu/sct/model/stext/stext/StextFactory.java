/**
 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.model.stext.stext.StextPackage
 * @generated
 */
public interface StextFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	StextFactory eINSTANCE = org.yakindu.sct.model.stext.stext.impl.StextFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Root</em>'.
	 * @generated
	 */
	Root createRoot();

	/**
	 * Returns a new object of class '<em>Def Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Def Root</em>'.
	 * @generated
	 */
	DefRoot createDefRoot();

	/**
	 * Returns a new object of class '<em>Statechart Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statechart Root</em>'.
	 * @generated
	 */
	StatechartRoot createStatechartRoot();

	/**
	 * Returns a new object of class '<em>State Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Root</em>'.
	 * @generated
	 */
	StateRoot createStateRoot();

	/**
	 * Returns a new object of class '<em>Transition Root</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Root</em>'.
	 * @generated
	 */
	TransitionRoot createTransitionRoot();

	/**
	 * Returns a new object of class '<em>Statechart Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statechart Specification</em>'.
	 * @generated
	 */
	StatechartSpecification createStatechartSpecification();

	/**
	 * Returns a new object of class '<em>State Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Specification</em>'.
	 * @generated
	 */
	StateSpecification createStateSpecification();

	/**
	 * Returns a new object of class '<em>Transition Specification</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Specification</em>'.
	 * @generated
	 */
	TransitionSpecification createTransitionSpecification();

	/**
	 * Returns a new object of class '<em>Statechart Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Statechart Scope</em>'.
	 * @generated
	 */
	StatechartScope createStatechartScope();

	/**
	 * Returns a new object of class '<em>Interface Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Interface Scope</em>'.
	 * @generated
	 */
	InterfaceScope createInterfaceScope();

	/**
	 * Returns a new object of class '<em>Internal Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Internal Scope</em>'.
	 * @generated
	 */
	InternalScope createInternalScope();

	/**
	 * Returns a new object of class '<em>Import Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import Scope</em>'.
	 * @generated
	 */
	ImportScope createImportScope();

	/**
	 * Returns a new object of class '<em>Import</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Import</em>'.
	 * @generated
	 */
	Import createImport();

	/**
	 * Returns a new object of class '<em>Event Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Definition</em>'.
	 * @generated
	 */
	EventDefinition createEventDefinition();

	/**
	 * Returns a new object of class '<em>Variable Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Definition</em>'.
	 * @generated
	 */
	VariableDefinition createVariableDefinition();

	/**
	 * Returns a new object of class '<em>Operation Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Operation Definition</em>'.
	 * @generated
	 */
	OperationDefinition createOperationDefinition();

	/**
	 * Returns a new object of class '<em>Local Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Local Reaction</em>'.
	 * @generated
	 */
	LocalReaction createLocalReaction();

	/**
	 * Returns a new object of class '<em>Transition Reaction</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Transition Reaction</em>'.
	 * @generated
	 */
	TransitionReaction createTransitionReaction();

	/**
	 * Returns a new object of class '<em>Guard</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Guard</em>'.
	 * @generated
	 */
	Guard createGuard();

	/**
	 * Returns a new object of class '<em>Entry Point Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry Point Spec</em>'.
	 * @generated
	 */
	EntryPointSpec createEntryPointSpec();

	/**
	 * Returns a new object of class '<em>Exit Point Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exit Point Spec</em>'.
	 * @generated
	 */
	ExitPointSpec createExitPointSpec();

	/**
	 * Returns a new object of class '<em>Event Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Spec</em>'.
	 * @generated
	 */
	EventSpec createEventSpec();

	/**
	 * Returns a new object of class '<em>Regular Event Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Regular Event Spec</em>'.
	 * @generated
	 */
	RegularEventSpec createRegularEventSpec();

	/**
	 * Returns a new object of class '<em>Time Event Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Time Event Spec</em>'.
	 * @generated
	 */
	TimeEventSpec createTimeEventSpec();

	/**
	 * Returns a new object of class '<em>Builtin Event Spec</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Event Spec</em>'.
	 * @generated
	 */
	BuiltinEventSpec createBuiltinEventSpec();

	/**
	 * Returns a new object of class '<em>Entry Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Entry Event</em>'.
	 * @generated
	 */
	EntryEvent createEntryEvent();

	/**
	 * Returns a new object of class '<em>Exit Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Exit Event</em>'.
	 * @generated
	 */
	ExitEvent createExitEvent();

	/**
	 * Returns a new object of class '<em>Always Event</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Always Event</em>'.
	 * @generated
	 */
	AlwaysEvent createAlwaysEvent();

	/**
	 * Returns a new object of class '<em>Simple Scope</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Simple Scope</em>'.
	 * @generated
	 */
	SimpleScope createSimpleScope();

	/**
	 * Returns a new object of class '<em>Reaction Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reaction Trigger</em>'.
	 * @generated
	 */
	ReactionTrigger createReactionTrigger();

	/**
	 * Returns a new object of class '<em>Default Trigger</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Default Trigger</em>'.
	 * @generated
	 */
	DefaultTrigger createDefaultTrigger();

	/**
	 * Returns a new object of class '<em>Reaction Effect</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reaction Effect</em>'.
	 * @generated
	 */
	ReactionEffect createReactionEffect();

	/**
	 * Returns a new object of class '<em>Event Raising Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Raising Expression</em>'.
	 * @generated
	 */
	EventRaisingExpression createEventRaisingExpression();

	/**
	 * Returns a new object of class '<em>Event Value Reference Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Event Value Reference Expression</em>'.
	 * @generated
	 */
	EventValueReferenceExpression createEventValueReferenceExpression();

	/**
	 * Returns a new object of class '<em>Active State Reference Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Active State Reference Expression</em>'.
	 * @generated
	 */
	ActiveStateReferenceExpression createActiveStateReferenceExpression();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	StextPackage getStextPackage();

} //StextFactory
