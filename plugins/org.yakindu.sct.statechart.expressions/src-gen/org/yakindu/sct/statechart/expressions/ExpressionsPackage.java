/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.statechart.expressions;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.statechart.expressions.ExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionsPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "expressions";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.yakindu.org/sct/statechart/Expressions";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "expressions";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExpressionsPackage eINSTANCE = org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl.init();

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EntryRuleImpl <em>Entry Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EntryRuleImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEntryRule()
   * @generated
   */
  int ENTRY_RULE = 0;

  /**
   * The feature id for the '<em><b>Entry</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_RULE__ENTRY = 0;

  /**
   * The number of structural features of the '<em>Entry Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.StateExpressionImpl <em>State Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.StateExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStateExpression()
   * @generated
   */
  int STATE_EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Entry Expression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_EXPRESSION__ENTRY_EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Exit Expression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_EXPRESSION__EXIT_EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Ontick Expression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_EXPRESSION__ONTICK_EXPRESSION = 2;

  /**
   * The number of structural features of the '<em>State Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_EXPRESSION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EntryExpressionImpl <em>Entry Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EntryExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEntryExpression()
   * @generated
   */
  int ENTRY_EXPRESSION = 2;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_EXPRESSION__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Entry Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ExitExpressionImpl <em>Exit Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ExitExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExitExpression()
   * @generated
   */
  int EXIT_EXPRESSION = 3;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_EXPRESSION__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Exit Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.OnTickExpressionImpl <em>On Tick Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.OnTickExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getOnTickExpression()
   * @generated
   */
  int ON_TICK_EXPRESSION = 4;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ON_TICK_EXPRESSION__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>On Tick Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ON_TICK_EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.DefinitionImpl <em>Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.DefinitionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDefinition()
   * @generated
   */
  int DEFINITION = 10;

  /**
   * The number of structural features of the '<em>Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.CustomTransitionExpressionImpl <em>Custom Transition Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.CustomTransitionExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getCustomTransitionExpression()
   * @generated
   */
  int CUSTOM_TRANSITION_EXPRESSION = 5;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_TRANSITION_EXPRESSION__TRIGGERS = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Guard Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_TRANSITION_EXPRESSION__GUARD_EXPRESSION = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Action</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_TRANSITION_EXPRESSION__ACTION = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Custom Transition Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CUSTOM_TRANSITION_EXPRESSION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ElementDefinitionImpl <em>Element Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ElementDefinitionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getElementDefinition()
   * @generated
   */
  int ELEMENT_DEFINITION = 6;

  /**
   * The feature id for the '<em><b>Definition Scopes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_DEFINITION__DEFINITION_SCOPES = 0;

  /**
   * The number of structural features of the '<em>Element Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_DEFINITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.DefinitionScopeImpl <em>Definition Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.DefinitionScopeImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDefinitionScope()
   * @generated
   */
  int DEFINITION_SCOPE = 7;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_SCOPE__DEFINITIONS = 0;

  /**
   * The number of structural features of the '<em>Definition Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_SCOPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.InterfaceScopeImpl <em>Interface Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.InterfaceScopeImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getInterfaceScope()
   * @generated
   */
  int INTERFACE_SCOPE = 8;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE__DEFINITIONS = DEFINITION_SCOPE__DEFINITIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE__NAME = DEFINITION_SCOPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Interface Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE_FEATURE_COUNT = DEFINITION_SCOPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.InternalScopeImpl <em>Internal Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.InternalScopeImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getInternalScope()
   * @generated
   */
  int INTERNAL_SCOPE = 9;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_SCOPE__DEFINITIONS = DEFINITION_SCOPE__DEFINITIONS;

  /**
   * The number of structural features of the '<em>Internal Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_SCOPE_FEATURE_COUNT = DEFINITION_SCOPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.VariableDefinitionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getVariableDefinition()
   * @generated
   */
  int VARIABLE_DEFINITION = 11;

  /**
   * The feature id for the '<em><b>Readonly</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__READONLY = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>External</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__EXTERNAL = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__NAME = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__TYPE = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__VALUE = DEFINITION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Variable Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EventDefinitionImpl <em>Event Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EventDefinitionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEventDefinition()
   * @generated
   */
  int EVENT_DEFINITION = 12;

  /**
   * The feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__DIRECTION = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__NAME = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__TYPE = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Derivation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__DERIVATION = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Event Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EventDerivationImpl <em>Event Derivation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EventDerivationImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEventDerivation()
   * @generated
   */
  int EVENT_DERIVATION = 13;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DERIVATION__CONDITION = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DERIVATION__VALUE = 1;

  /**
   * The number of structural features of the '<em>Event Derivation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DERIVATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.OperationImpl <em>Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.OperationImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__NAME = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Param Types</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__PARAM_TYPES = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__TYPE = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EntrypointImpl <em>Entrypoint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EntrypointImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEntrypoint()
   * @generated
   */
  int ENTRYPOINT = 15;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRYPOINT__NAME = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Entrypoint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRYPOINT_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ExitpointImpl <em>Exitpoint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ExitpointImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExitpoint()
   * @generated
   */
  int EXITPOINT = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXITPOINT__NAME = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Exitpoint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXITPOINT_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ClockImpl <em>Clock</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ClockImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getClock()
   * @generated
   */
  int CLOCK = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK__NAME = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Clock</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ExpressionRuleImpl <em>Expression Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionRuleImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExpressionRule()
   * @generated
   */
  int EXPRESSION_RULE = 18;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_RULE__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Expression Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.RaiseEventExpressionImpl <em>Raise Event Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.RaiseEventExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRaiseEventExpression()
   * @generated
   */
  int RAISE_EVENT_EXPRESSION = 19;

  /**
   * The feature id for the '<em><b>Event</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RAISE_EVENT_EXPRESSION__EVENT = 0;

  /**
   * The number of structural features of the '<em>Raise Event Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RAISE_EVENT_EXPRESSION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 20;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.LogicalOrExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalOrExpression()
   * @generated
   */
  int LOGICAL_OR_EXPRESSION = 21;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Logical Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.LogicalAndExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalAndExpression()
   * @generated
   */
  int LOGICAL_AND_EXPRESSION = 22;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Logical And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalNotExpressionImpl <em>Logical Not Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.LogicalNotExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalNotExpression()
   * @generated
   */
  int LOGICAL_NOT_EXPRESSION = 23;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_NOT_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Logical Not Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_NOT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalRelationExpressionImpl <em>Logical Relation Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.LogicalRelationExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalRelationExpression()
   * @generated
   */
  int LOGICAL_RELATION_EXPRESSION = 24;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_RELATION_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_RELATION_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_RELATION_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Logical Relation Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_RELATION_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.NumericalAddSubtractExpressionImpl <em>Numerical Add Subtract Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.NumericalAddSubtractExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getNumericalAddSubtractExpression()
   * @generated
   */
  int NUMERICAL_ADD_SUBTRACT_EXPRESSION = 25;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_ADD_SUBTRACT_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_ADD_SUBTRACT_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_ADD_SUBTRACT_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Numerical Add Subtract Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_ADD_SUBTRACT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.NumericalMultiplyDivideExpressionImpl <em>Numerical Multiply Divide Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.NumericalMultiplyDivideExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getNumericalMultiplyDivideExpression()
   * @generated
   */
  int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION = 26;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Numerical Multiply Divide Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.NumericalUnaryExpressionImpl <em>Numerical Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.NumericalUnaryExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getNumericalUnaryExpression()
   * @generated
   */
  int NUMERICAL_UNARY_EXPRESSION = 27;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_UNARY_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_UNARY_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Numerical Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.PrimitiveValueExpressionImpl <em>Primitive Value Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.PrimitiveValueExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getPrimitiveValueExpression()
   * @generated
   */
  int PRIMITIVE_VALUE_EXPRESSION = 28;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_VALUE_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Primitive Value Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_VALUE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.PropertyReferenceExpressionImpl <em>Property Reference Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.PropertyReferenceExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getPropertyReferenceExpression()
   * @generated
   */
  int PROPERTY_REFERENCE_EXPRESSION = 29;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REFERENCE_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Property Reference Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PROPERTY_REFERENCE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.Direction <em>Direction</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.Direction
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDirection()
   * @generated
   */
  int DIRECTION = 30;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.AdditiveOperator <em>Additive Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.AdditiveOperator
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getAdditiveOperator()
   * @generated
   */
  int ADDITIVE_OPERATOR = 31;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.MultiplicativeOperator
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getMultiplicativeOperator()
   * @generated
   */
  int MULTIPLICATIVE_OPERATOR = 32;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.UnaryOperator <em>Unary Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.UnaryOperator
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getUnaryOperator()
   * @generated
   */
  int UNARY_OPERATOR = 33;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.RelationalOperator
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRelationalOperator()
   * @generated
   */
  int RELATIONAL_OPERATOR = 34;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.DirectionKind <em>Direction Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.DirectionKind
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDirectionKind()
   * @generated
   */
  int DIRECTION_KIND = 35;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.TimeUnit <em>Time Unit</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.TimeUnit
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTimeUnit()
   * @generated
   */
  int TIME_UNIT = 36;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.Type <em>Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.Type
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getType()
   * @generated
   */
  int TYPE = 37;


  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.EntryRule <em>Entry Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry Rule</em>'.
   * @see org.yakindu.sct.statechart.expressions.EntryRule
   * @generated
   */
  EClass getEntryRule();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.EntryRule#getEntry <em>Entry</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Entry</em>'.
   * @see org.yakindu.sct.statechart.expressions.EntryRule#getEntry()
   * @see #getEntryRule()
   * @generated
   */
  EReference getEntryRule_Entry();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.StateExpression <em>State Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.StateExpression
   * @generated
   */
  EClass getStateExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.StateExpression#getEntryExpression <em>Entry Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Entry Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.StateExpression#getEntryExpression()
   * @see #getStateExpression()
   * @generated
   */
  EReference getStateExpression_EntryExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.StateExpression#getExitExpression <em>Exit Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Exit Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.StateExpression#getExitExpression()
   * @see #getStateExpression()
   * @generated
   */
  EReference getStateExpression_ExitExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.StateExpression#getOntickExpression <em>Ontick Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ontick Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.StateExpression#getOntickExpression()
   * @see #getStateExpression()
   * @generated
   */
  EReference getStateExpression_OntickExpression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.EntryExpression <em>Entry Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.EntryExpression
   * @generated
   */
  EClass getEntryExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.EntryExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.EntryExpression#getExpression()
   * @see #getEntryExpression()
   * @generated
   */
  EReference getEntryExpression_Expression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.ExitExpression <em>Exit Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exit Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.ExitExpression
   * @generated
   */
  EClass getExitExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.ExitExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.ExitExpression#getExpression()
   * @see #getExitExpression()
   * @generated
   */
  EReference getExitExpression_Expression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.OnTickExpression <em>On Tick Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>On Tick Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.OnTickExpression
   * @generated
   */
  EClass getOnTickExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.OnTickExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.OnTickExpression#getExpression()
   * @see #getOnTickExpression()
   * @generated
   */
  EReference getOnTickExpression_Expression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.CustomTransitionExpression <em>Custom Transition Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Custom Transition Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.CustomTransitionExpression
   * @generated
   */
  EClass getCustomTransitionExpression();

  /**
   * Returns the meta object for the reference list '{@link org.yakindu.sct.statechart.expressions.CustomTransitionExpression#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Triggers</em>'.
   * @see org.yakindu.sct.statechart.expressions.CustomTransitionExpression#getTriggers()
   * @see #getCustomTransitionExpression()
   * @generated
   */
  EReference getCustomTransitionExpression_Triggers();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.CustomTransitionExpression#getGuardExpression <em>Guard Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.CustomTransitionExpression#getGuardExpression()
   * @see #getCustomTransitionExpression()
   * @generated
   */
  EReference getCustomTransitionExpression_GuardExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.CustomTransitionExpression#getAction <em>Action</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Action</em>'.
   * @see org.yakindu.sct.statechart.expressions.CustomTransitionExpression#getAction()
   * @see #getCustomTransitionExpression()
   * @generated
   */
  EReference getCustomTransitionExpression_Action();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.ElementDefinition <em>Element Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Definition</em>'.
   * @see org.yakindu.sct.statechart.expressions.ElementDefinition
   * @generated
   */
  EClass getElementDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.ElementDefinition#getDefinitionScopes <em>Definition Scopes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definition Scopes</em>'.
   * @see org.yakindu.sct.statechart.expressions.ElementDefinition#getDefinitionScopes()
   * @see #getElementDefinition()
   * @generated
   */
  EReference getElementDefinition_DefinitionScopes();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.DefinitionScope <em>Definition Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definition Scope</em>'.
   * @see org.yakindu.sct.statechart.expressions.DefinitionScope
   * @generated
   */
  EClass getDefinitionScope();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.DefinitionScope#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see org.yakindu.sct.statechart.expressions.DefinitionScope#getDefinitions()
   * @see #getDefinitionScope()
   * @generated
   */
  EReference getDefinitionScope_Definitions();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.InterfaceScope <em>Interface Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface Scope</em>'.
   * @see org.yakindu.sct.statechart.expressions.InterfaceScope
   * @generated
   */
  EClass getInterfaceScope();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.InterfaceScope#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.yakindu.sct.statechart.expressions.InterfaceScope#getName()
   * @see #getInterfaceScope()
   * @generated
   */
  EAttribute getInterfaceScope_Name();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.InternalScope <em>Internal Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Internal Scope</em>'.
   * @see org.yakindu.sct.statechart.expressions.InternalScope
   * @generated
   */
  EClass getInternalScope();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Definition <em>Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Definition</em>'.
   * @see org.yakindu.sct.statechart.expressions.Definition
   * @generated
   */
  EClass getDefinition();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.VariableDefinition <em>Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Definition</em>'.
   * @see org.yakindu.sct.statechart.expressions.VariableDefinition
   * @generated
   */
  EClass getVariableDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.VariableDefinition#isReadonly <em>Readonly</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Readonly</em>'.
   * @see org.yakindu.sct.statechart.expressions.VariableDefinition#isReadonly()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_Readonly();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.VariableDefinition#isExternal <em>External</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>External</em>'.
   * @see org.yakindu.sct.statechart.expressions.VariableDefinition#isExternal()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_External();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.VariableDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.yakindu.sct.statechart.expressions.VariableDefinition#getName()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_Name();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.VariableDefinition#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.yakindu.sct.statechart.expressions.VariableDefinition#getType()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_Type();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.VariableDefinition#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.yakindu.sct.statechart.expressions.VariableDefinition#getValue()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.EventDefinition <em>Event Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Definition</em>'.
   * @see org.yakindu.sct.statechart.expressions.EventDefinition
   * @generated
   */
  EClass getEventDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.EventDefinition#getDirection <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Direction</em>'.
   * @see org.yakindu.sct.statechart.expressions.EventDefinition#getDirection()
   * @see #getEventDefinition()
   * @generated
   */
  EAttribute getEventDefinition_Direction();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.EventDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.yakindu.sct.statechart.expressions.EventDefinition#getName()
   * @see #getEventDefinition()
   * @generated
   */
  EAttribute getEventDefinition_Name();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.EventDefinition#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.yakindu.sct.statechart.expressions.EventDefinition#getType()
   * @see #getEventDefinition()
   * @generated
   */
  EAttribute getEventDefinition_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.EventDefinition#getDerivation <em>Derivation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Derivation</em>'.
   * @see org.yakindu.sct.statechart.expressions.EventDefinition#getDerivation()
   * @see #getEventDefinition()
   * @generated
   */
  EReference getEventDefinition_Derivation();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.EventDerivation <em>Event Derivation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Derivation</em>'.
   * @see org.yakindu.sct.statechart.expressions.EventDerivation
   * @generated
   */
  EClass getEventDerivation();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.EventDerivation#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.yakindu.sct.statechart.expressions.EventDerivation#getCondition()
   * @see #getEventDerivation()
   * @generated
   */
  EReference getEventDerivation_Condition();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.EventDerivation#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.yakindu.sct.statechart.expressions.EventDerivation#getValue()
   * @see #getEventDerivation()
   * @generated
   */
  EReference getEventDerivation_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation</em>'.
   * @see org.yakindu.sct.statechart.expressions.Operation
   * @generated
   */
  EClass getOperation();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.Operation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.yakindu.sct.statechart.expressions.Operation#getName()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_Name();

  /**
   * Returns the meta object for the attribute list '{@link org.yakindu.sct.statechart.expressions.Operation#getParamTypes <em>Param Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Param Types</em>'.
   * @see org.yakindu.sct.statechart.expressions.Operation#getParamTypes()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_ParamTypes();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.Operation#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.yakindu.sct.statechart.expressions.Operation#getType()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_Type();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Entrypoint <em>Entrypoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entrypoint</em>'.
   * @see org.yakindu.sct.statechart.expressions.Entrypoint
   * @generated
   */
  EClass getEntrypoint();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.Entrypoint#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.yakindu.sct.statechart.expressions.Entrypoint#getName()
   * @see #getEntrypoint()
   * @generated
   */
  EAttribute getEntrypoint_Name();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Exitpoint <em>Exitpoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exitpoint</em>'.
   * @see org.yakindu.sct.statechart.expressions.Exitpoint
   * @generated
   */
  EClass getExitpoint();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.Exitpoint#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.yakindu.sct.statechart.expressions.Exitpoint#getName()
   * @see #getExitpoint()
   * @generated
   */
  EAttribute getExitpoint_Name();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Clock <em>Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Clock</em>'.
   * @see org.yakindu.sct.statechart.expressions.Clock
   * @generated
   */
  EClass getClock();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.Clock#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.yakindu.sct.statechart.expressions.Clock#getName()
   * @see #getClock()
   * @generated
   */
  EAttribute getClock_Name();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.ExpressionRule <em>Expression Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Rule</em>'.
   * @see org.yakindu.sct.statechart.expressions.ExpressionRule
   * @generated
   */
  EClass getExpressionRule();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.ExpressionRule#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.ExpressionRule#getExpression()
   * @see #getExpressionRule()
   * @generated
   */
  EReference getExpressionRule_Expression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.RaiseEventExpression <em>Raise Event Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Raise Event Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.RaiseEventExpression
   * @generated
   */
  EClass getRaiseEventExpression();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.statechart.expressions.RaiseEventExpression#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Event</em>'.
   * @see org.yakindu.sct.statechart.expressions.RaiseEventExpression#getEvent()
   * @see #getRaiseEventExpression()
   * @generated
   */
  EReference getRaiseEventExpression_Event();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.LogicalOrExpression <em>Logical Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Or Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalOrExpression
   * @generated
   */
  EClass getLogicalOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalOrExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalOrExpression#getLeftOperand()
   * @see #getLogicalOrExpression()
   * @generated
   */
  EReference getLogicalOrExpression_LeftOperand();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalOrExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalOrExpression#getRightOperand()
   * @see #getLogicalOrExpression()
   * @generated
   */
  EReference getLogicalOrExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.LogicalAndExpression <em>Logical And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical And Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalAndExpression
   * @generated
   */
  EClass getLogicalAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalAndExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalAndExpression#getLeftOperand()
   * @see #getLogicalAndExpression()
   * @generated
   */
  EReference getLogicalAndExpression_LeftOperand();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalAndExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalAndExpression#getRightOperand()
   * @see #getLogicalAndExpression()
   * @generated
   */
  EReference getLogicalAndExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.LogicalNotExpression <em>Logical Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Not Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalNotExpression
   * @generated
   */
  EClass getLogicalNotExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalNotExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalNotExpression#getOperand()
   * @see #getLogicalNotExpression()
   * @generated
   */
  EReference getLogicalNotExpression_Operand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.LogicalRelationExpression <em>Logical Relation Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Relation Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalRelationExpression
   * @generated
   */
  EClass getLogicalRelationExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalRelationExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalRelationExpression#getLeftOperand()
   * @see #getLogicalRelationExpression()
   * @generated
   */
  EReference getLogicalRelationExpression_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.LogicalRelationExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalRelationExpression#getOperator()
   * @see #getLogicalRelationExpression()
   * @generated
   */
  EAttribute getLogicalRelationExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.LogicalRelationExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.LogicalRelationExpression#getRightOperand()
   * @see #getLogicalRelationExpression()
   * @generated
   */
  EReference getLogicalRelationExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression <em>Numerical Add Subtract Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Add Subtract Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression
   * @generated
   */
  EClass getNumericalAddSubtractExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression#getLeftOperand()
   * @see #getNumericalAddSubtractExpression()
   * @generated
   */
  EReference getNumericalAddSubtractExpression_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression#getOperator()
   * @see #getNumericalAddSubtractExpression()
   * @generated
   */
  EAttribute getNumericalAddSubtractExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalAddSubtractExpression#getRightOperand()
   * @see #getNumericalAddSubtractExpression()
   * @generated
   */
  EReference getNumericalAddSubtractExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression <em>Numerical Multiply Divide Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Multiply Divide Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression
   * @generated
   */
  EClass getNumericalMultiplyDivideExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression#getLeftOperand()
   * @see #getNumericalMultiplyDivideExpression()
   * @generated
   */
  EReference getNumericalMultiplyDivideExpression_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression#getOperator()
   * @see #getNumericalMultiplyDivideExpression()
   * @generated
   */
  EAttribute getNumericalMultiplyDivideExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalMultiplyDivideExpression#getRightOperand()
   * @see #getNumericalMultiplyDivideExpression()
   * @generated
   */
  EReference getNumericalMultiplyDivideExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.NumericalUnaryExpression <em>Numerical Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Unary Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalUnaryExpression
   * @generated
   */
  EClass getNumericalUnaryExpression();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.NumericalUnaryExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalUnaryExpression#getOperator()
   * @see #getNumericalUnaryExpression()
   * @generated
   */
  EAttribute getNumericalUnaryExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.NumericalUnaryExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.yakindu.sct.statechart.expressions.NumericalUnaryExpression#getOperand()
   * @see #getNumericalUnaryExpression()
   * @generated
   */
  EReference getNumericalUnaryExpression_Operand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.PrimitiveValueExpression <em>Primitive Value Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Value Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.PrimitiveValueExpression
   * @generated
   */
  EClass getPrimitiveValueExpression();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.PrimitiveValueExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.yakindu.sct.statechart.expressions.PrimitiveValueExpression#getValue()
   * @see #getPrimitiveValueExpression()
   * @generated
   */
  EAttribute getPrimitiveValueExpression_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.PropertyReferenceExpression <em>Property Reference Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Property Reference Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.PropertyReferenceExpression
   * @generated
   */
  EClass getPropertyReferenceExpression();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.statechart.expressions.PropertyReferenceExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.yakindu.sct.statechart.expressions.PropertyReferenceExpression#getValue()
   * @see #getPropertyReferenceExpression()
   * @generated
   */
  EReference getPropertyReferenceExpression_Value();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.Direction <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Direction</em>'.
   * @see org.yakindu.sct.statechart.expressions.Direction
   * @generated
   */
  EEnum getDirection();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.AdditiveOperator <em>Additive Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Additive Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.AdditiveOperator
   * @generated
   */
  EEnum getAdditiveOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.MultiplicativeOperator <em>Multiplicative Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Multiplicative Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.MultiplicativeOperator
   * @generated
   */
  EEnum getMultiplicativeOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.UnaryOperator <em>Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Unary Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.UnaryOperator
   * @generated
   */
  EEnum getUnaryOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.RelationalOperator <em>Relational Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Relational Operator</em>'.
   * @see org.yakindu.sct.statechart.expressions.RelationalOperator
   * @generated
   */
  EEnum getRelationalOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.DirectionKind <em>Direction Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Direction Kind</em>'.
   * @see org.yakindu.sct.statechart.expressions.DirectionKind
   * @generated
   */
  EEnum getDirectionKind();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.TimeUnit <em>Time Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Time Unit</em>'.
   * @see org.yakindu.sct.statechart.expressions.TimeUnit
   * @generated
   */
  EEnum getTimeUnit();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.statechart.expressions.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Type</em>'.
   * @see org.yakindu.sct.statechart.expressions.Type
   * @generated
   */
  EEnum getType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  ExpressionsFactory getExpressionsFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.EntryRuleImpl <em>Entry Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.EntryRuleImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEntryRule()
     * @generated
     */
    EClass ENTRY_RULE = eINSTANCE.getEntryRule();

    /**
     * The meta object literal for the '<em><b>Entry</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTRY_RULE__ENTRY = eINSTANCE.getEntryRule_Entry();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.StateExpressionImpl <em>State Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.StateExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStateExpression()
     * @generated
     */
    EClass STATE_EXPRESSION = eINSTANCE.getStateExpression();

    /**
     * The meta object literal for the '<em><b>Entry Expression</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_EXPRESSION__ENTRY_EXPRESSION = eINSTANCE.getStateExpression_EntryExpression();

    /**
     * The meta object literal for the '<em><b>Exit Expression</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_EXPRESSION__EXIT_EXPRESSION = eINSTANCE.getStateExpression_ExitExpression();

    /**
     * The meta object literal for the '<em><b>Ontick Expression</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_EXPRESSION__ONTICK_EXPRESSION = eINSTANCE.getStateExpression_OntickExpression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.EntryExpressionImpl <em>Entry Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.EntryExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEntryExpression()
     * @generated
     */
    EClass ENTRY_EXPRESSION = eINSTANCE.getEntryExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTRY_EXPRESSION__EXPRESSION = eINSTANCE.getEntryExpression_Expression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ExitExpressionImpl <em>Exit Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ExitExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExitExpression()
     * @generated
     */
    EClass EXIT_EXPRESSION = eINSTANCE.getExitExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXIT_EXPRESSION__EXPRESSION = eINSTANCE.getExitExpression_Expression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.OnTickExpressionImpl <em>On Tick Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.OnTickExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getOnTickExpression()
     * @generated
     */
    EClass ON_TICK_EXPRESSION = eINSTANCE.getOnTickExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ON_TICK_EXPRESSION__EXPRESSION = eINSTANCE.getOnTickExpression_Expression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.CustomTransitionExpressionImpl <em>Custom Transition Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.CustomTransitionExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getCustomTransitionExpression()
     * @generated
     */
    EClass CUSTOM_TRANSITION_EXPRESSION = eINSTANCE.getCustomTransitionExpression();

    /**
     * The meta object literal for the '<em><b>Triggers</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CUSTOM_TRANSITION_EXPRESSION__TRIGGERS = eINSTANCE.getCustomTransitionExpression_Triggers();

    /**
     * The meta object literal for the '<em><b>Guard Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CUSTOM_TRANSITION_EXPRESSION__GUARD_EXPRESSION = eINSTANCE.getCustomTransitionExpression_GuardExpression();

    /**
     * The meta object literal for the '<em><b>Action</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CUSTOM_TRANSITION_EXPRESSION__ACTION = eINSTANCE.getCustomTransitionExpression_Action();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ElementDefinitionImpl <em>Element Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ElementDefinitionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getElementDefinition()
     * @generated
     */
    EClass ELEMENT_DEFINITION = eINSTANCE.getElementDefinition();

    /**
     * The meta object literal for the '<em><b>Definition Scopes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_DEFINITION__DEFINITION_SCOPES = eINSTANCE.getElementDefinition_DefinitionScopes();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.DefinitionScopeImpl <em>Definition Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.DefinitionScopeImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDefinitionScope()
     * @generated
     */
    EClass DEFINITION_SCOPE = eINSTANCE.getDefinitionScope();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEFINITION_SCOPE__DEFINITIONS = eINSTANCE.getDefinitionScope_Definitions();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.InterfaceScopeImpl <em>Interface Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.InterfaceScopeImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getInterfaceScope()
     * @generated
     */
    EClass INTERFACE_SCOPE = eINSTANCE.getInterfaceScope();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERFACE_SCOPE__NAME = eINSTANCE.getInterfaceScope_Name();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.InternalScopeImpl <em>Internal Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.InternalScopeImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getInternalScope()
     * @generated
     */
    EClass INTERNAL_SCOPE = eINSTANCE.getInternalScope();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.DefinitionImpl <em>Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.DefinitionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDefinition()
     * @generated
     */
    EClass DEFINITION = eINSTANCE.getDefinition();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.VariableDefinitionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getVariableDefinition()
     * @generated
     */
    EClass VARIABLE_DEFINITION = eINSTANCE.getVariableDefinition();

    /**
     * The meta object literal for the '<em><b>Readonly</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DEFINITION__READONLY = eINSTANCE.getVariableDefinition_Readonly();

    /**
     * The meta object literal for the '<em><b>External</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DEFINITION__EXTERNAL = eINSTANCE.getVariableDefinition_External();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DEFINITION__NAME = eINSTANCE.getVariableDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DEFINITION__TYPE = eINSTANCE.getVariableDefinition_Type();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DEFINITION__VALUE = eINSTANCE.getVariableDefinition_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.EventDefinitionImpl <em>Event Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.EventDefinitionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEventDefinition()
     * @generated
     */
    EClass EVENT_DEFINITION = eINSTANCE.getEventDefinition();

    /**
     * The meta object literal for the '<em><b>Direction</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_DEFINITION__DIRECTION = eINSTANCE.getEventDefinition_Direction();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_DEFINITION__NAME = eINSTANCE.getEventDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EVENT_DEFINITION__TYPE = eINSTANCE.getEventDefinition_Type();

    /**
     * The meta object literal for the '<em><b>Derivation</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_DEFINITION__DERIVATION = eINSTANCE.getEventDefinition_Derivation();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.EventDerivationImpl <em>Event Derivation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.EventDerivationImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEventDerivation()
     * @generated
     */
    EClass EVENT_DERIVATION = eINSTANCE.getEventDerivation();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_DERIVATION__CONDITION = eINSTANCE.getEventDerivation_Condition();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_DERIVATION__VALUE = eINSTANCE.getEventDerivation_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.OperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.OperationImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getOperation()
     * @generated
     */
    EClass OPERATION = eINSTANCE.getOperation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION__NAME = eINSTANCE.getOperation_Name();

    /**
     * The meta object literal for the '<em><b>Param Types</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION__PARAM_TYPES = eINSTANCE.getOperation_ParamTypes();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OPERATION__TYPE = eINSTANCE.getOperation_Type();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.EntrypointImpl <em>Entrypoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.EntrypointImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEntrypoint()
     * @generated
     */
    EClass ENTRYPOINT = eINSTANCE.getEntrypoint();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTRYPOINT__NAME = eINSTANCE.getEntrypoint_Name();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ExitpointImpl <em>Exitpoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ExitpointImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExitpoint()
     * @generated
     */
    EClass EXITPOINT = eINSTANCE.getExitpoint();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXITPOINT__NAME = eINSTANCE.getExitpoint_Name();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ClockImpl <em>Clock</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ClockImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getClock()
     * @generated
     */
    EClass CLOCK = eINSTANCE.getClock();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLOCK__NAME = eINSTANCE.getClock_Name();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ExpressionRuleImpl <em>Expression Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionRuleImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExpressionRule()
     * @generated
     */
    EClass EXPRESSION_RULE = eINSTANCE.getExpressionRule();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_RULE__EXPRESSION = eINSTANCE.getExpressionRule_Expression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.RaiseEventExpressionImpl <em>Raise Event Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.RaiseEventExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRaiseEventExpression()
     * @generated
     */
    EClass RAISE_EVENT_EXPRESSION = eINSTANCE.getRaiseEventExpression();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RAISE_EVENT_EXPRESSION__EVENT = eINSTANCE.getRaiseEventExpression_Event();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.LogicalOrExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalOrExpression()
     * @generated
     */
    EClass LOGICAL_OR_EXPRESSION = eINSTANCE.getLogicalOrExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_OR_EXPRESSION__LEFT_OPERAND = eINSTANCE.getLogicalOrExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_OR_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getLogicalOrExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.LogicalAndExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalAndExpression()
     * @generated
     */
    EClass LOGICAL_AND_EXPRESSION = eINSTANCE.getLogicalAndExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_AND_EXPRESSION__LEFT_OPERAND = eINSTANCE.getLogicalAndExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_AND_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getLogicalAndExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalNotExpressionImpl <em>Logical Not Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.LogicalNotExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalNotExpression()
     * @generated
     */
    EClass LOGICAL_NOT_EXPRESSION = eINSTANCE.getLogicalNotExpression();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_NOT_EXPRESSION__OPERAND = eINSTANCE.getLogicalNotExpression_Operand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalRelationExpressionImpl <em>Logical Relation Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.LogicalRelationExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalRelationExpression()
     * @generated
     */
    EClass LOGICAL_RELATION_EXPRESSION = eINSTANCE.getLogicalRelationExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_RELATION_EXPRESSION__LEFT_OPERAND = eINSTANCE.getLogicalRelationExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LOGICAL_RELATION_EXPRESSION__OPERATOR = eINSTANCE.getLogicalRelationExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_RELATION_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getLogicalRelationExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.NumericalAddSubtractExpressionImpl <em>Numerical Add Subtract Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.NumericalAddSubtractExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getNumericalAddSubtractExpression()
     * @generated
     */
    EClass NUMERICAL_ADD_SUBTRACT_EXPRESSION = eINSTANCE.getNumericalAddSubtractExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_ADD_SUBTRACT_EXPRESSION__LEFT_OPERAND = eINSTANCE.getNumericalAddSubtractExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERICAL_ADD_SUBTRACT_EXPRESSION__OPERATOR = eINSTANCE.getNumericalAddSubtractExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_ADD_SUBTRACT_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getNumericalAddSubtractExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.NumericalMultiplyDivideExpressionImpl <em>Numerical Multiply Divide Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.NumericalMultiplyDivideExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getNumericalMultiplyDivideExpression()
     * @generated
     */
    EClass NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION = eINSTANCE.getNumericalMultiplyDivideExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND = eINSTANCE.getNumericalMultiplyDivideExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__OPERATOR = eINSTANCE.getNumericalMultiplyDivideExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getNumericalMultiplyDivideExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.NumericalUnaryExpressionImpl <em>Numerical Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.NumericalUnaryExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getNumericalUnaryExpression()
     * @generated
     */
    EClass NUMERICAL_UNARY_EXPRESSION = eINSTANCE.getNumericalUnaryExpression();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERICAL_UNARY_EXPRESSION__OPERATOR = eINSTANCE.getNumericalUnaryExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_UNARY_EXPRESSION__OPERAND = eINSTANCE.getNumericalUnaryExpression_Operand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.PrimitiveValueExpressionImpl <em>Primitive Value Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.PrimitiveValueExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getPrimitiveValueExpression()
     * @generated
     */
    EClass PRIMITIVE_VALUE_EXPRESSION = eINSTANCE.getPrimitiveValueExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE_VALUE_EXPRESSION__VALUE = eINSTANCE.getPrimitiveValueExpression_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.PropertyReferenceExpressionImpl <em>Property Reference Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.PropertyReferenceExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getPropertyReferenceExpression()
     * @generated
     */
    EClass PROPERTY_REFERENCE_EXPRESSION = eINSTANCE.getPropertyReferenceExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PROPERTY_REFERENCE_EXPRESSION__VALUE = eINSTANCE.getPropertyReferenceExpression_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.Direction <em>Direction</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.Direction
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDirection()
     * @generated
     */
    EEnum DIRECTION = eINSTANCE.getDirection();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.AdditiveOperator <em>Additive Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.AdditiveOperator
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getAdditiveOperator()
     * @generated
     */
    EEnum ADDITIVE_OPERATOR = eINSTANCE.getAdditiveOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.MultiplicativeOperator
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getMultiplicativeOperator()
     * @generated
     */
    EEnum MULTIPLICATIVE_OPERATOR = eINSTANCE.getMultiplicativeOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.UnaryOperator <em>Unary Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.UnaryOperator
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getUnaryOperator()
     * @generated
     */
    EEnum UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.RelationalOperator <em>Relational Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.RelationalOperator
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRelationalOperator()
     * @generated
     */
    EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.DirectionKind <em>Direction Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.DirectionKind
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDirectionKind()
     * @generated
     */
    EEnum DIRECTION_KIND = eINSTANCE.getDirectionKind();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.TimeUnit <em>Time Unit</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.TimeUnit
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTimeUnit()
     * @generated
     */
    EEnum TIME_UNIT = eINSTANCE.getTimeUnit();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.Type <em>Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.Type
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getType()
     * @generated
     */
    EEnum TYPE = eINSTANCE.getType();

  }

} //ExpressionsPackage
