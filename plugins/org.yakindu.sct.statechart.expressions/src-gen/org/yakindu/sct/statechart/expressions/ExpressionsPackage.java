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
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.RootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.RootImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRoot()
   * @generated
   */
  int ROOT = 0;

  /**
   * The feature id for the '<em><b>Roots</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT__ROOTS = 0;

  /**
   * The number of structural features of the '<em>Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ROOT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.DefRootImpl <em>Def Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.DefRootImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDefRoot()
   * @generated
   */
  int DEF_ROOT = 1;

  /**
   * The number of structural features of the '<em>Def Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEF_ROOT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.StatechartRootImpl <em>Statechart Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.StatechartRootImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStatechartRoot()
   * @generated
   */
  int STATECHART_ROOT = 2;

  /**
   * The feature id for the '<em><b>Def</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_ROOT__DEF = DEF_ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Statechart Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_ROOT_FEATURE_COUNT = DEF_ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.StateRootImpl <em>State Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.StateRootImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStateRoot()
   * @generated
   */
  int STATE_ROOT = 3;

  /**
   * The feature id for the '<em><b>Def</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ROOT__DEF = DEF_ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>State Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_ROOT_FEATURE_COUNT = DEF_ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.TransitionRootImpl <em>Transition Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.TransitionRootImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTransitionRoot()
   * @generated
   */
  int TRANSITION_ROOT = 4;

  /**
   * The feature id for the '<em><b>Def</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_ROOT__DEF = DEF_ROOT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Transition Root</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_ROOT_FEATURE_COUNT = DEF_ROOT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.StatechartDefinitionImpl <em>Statechart Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.StatechartDefinitionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStatechartDefinition()
   * @generated
   */
  int STATECHART_DEFINITION = 5;

  /**
   * The feature id for the '<em><b>Definition Scopes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_DEFINITION__DEFINITION_SCOPES = 0;

  /**
   * The number of structural features of the '<em>Statechart Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_DEFINITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.StateDefinitionImpl <em>State Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.StateDefinitionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStateDefinition()
   * @generated
   */
  int STATE_DEFINITION = 6;

  /**
   * The number of structural features of the '<em>State Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_DEFINITION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.TransitionStatementImpl <em>Transition Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.TransitionStatementImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTransitionStatement()
   * @generated
   */
  int TRANSITION_STATEMENT = 7;

  /**
   * The number of structural features of the '<em>Transition Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ScopeImpl <em>Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ScopeImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getScope()
   * @generated
   */
  int SCOPE = 8;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE__DEFINITIONS = 0;

  /**
   * The number of structural features of the '<em>Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SCOPE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.SimpleScopeImpl <em>Simple Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.SimpleScopeImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getSimpleScope()
   * @generated
   */
  int SIMPLE_SCOPE = 9;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SCOPE__DEFINITIONS = STATE_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SCOPE_FEATURE_COUNT = STATE_DEFINITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.StatechartScopeImpl <em>Statechart Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.StatechartScopeImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStatechartScope()
   * @generated
   */
  int STATECHART_SCOPE = 10;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_SCOPE__DEFINITIONS = SCOPE__DEFINITIONS;

  /**
   * The number of structural features of the '<em>Statechart Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_SCOPE_FEATURE_COUNT = SCOPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.InterfaceScopeImpl <em>Interface Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.InterfaceScopeImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getInterfaceScope()
   * @generated
   */
  int INTERFACE_SCOPE = 11;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE__DEFINITIONS = STATECHART_SCOPE__DEFINITIONS;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE__NAME = STATECHART_SCOPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Interface Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE_FEATURE_COUNT = STATECHART_SCOPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.InternalScopeImpl <em>Internal Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.InternalScopeImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getInternalScope()
   * @generated
   */
  int INTERNAL_SCOPE = 12;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_SCOPE__DEFINITIONS = STATECHART_SCOPE__DEFINITIONS;

  /**
   * The number of structural features of the '<em>Internal Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_SCOPE_FEATURE_COUNT = STATECHART_SCOPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.DefinitionImpl <em>Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.DefinitionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDefinition()
   * @generated
   */
  int DEFINITION = 13;

  /**
   * The number of structural features of the '<em>Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFINITION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EventDefinitionImpl <em>Event Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EventDefinitionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEventDefinition()
   * @generated
   */
  int EVENT_DEFINITION = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__NAME = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__DIRECTION = DEFINITION_FEATURE_COUNT + 1;

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
  int EVENT_DERIVATION = 15;

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
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.VariableDefinitionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getVariableDefinition()
   * @generated
   */
  int VARIABLE_DEFINITION = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__NAME = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Readonly</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__READONLY = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>External</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__EXTERNAL = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__TYPE = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Initial Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__INITIAL_VALUE = DEFINITION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Variable Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 5;

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
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.OperationImpl <em>Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.OperationImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 18;

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
  int ENTRYPOINT = 19;

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
  int EXITPOINT = 20;

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
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ReactionImpl <em>Reaction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ReactionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getReaction()
   * @generated
   */
  int REACTION = 21;

  /**
   * The feature id for the '<em><b>Trigger</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION__TRIGGER = 0;

  /**
   * The feature id for the '<em><b>Effect</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION__EFFECT = 1;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION__PROPERTIES = 2;

  /**
   * The number of structural features of the '<em>Reaction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.LocalReactionImpl <em>Local Reaction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.LocalReactionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLocalReaction()
   * @generated
   */
  int LOCAL_REACTION = 22;

  /**
   * The feature id for the '<em><b>Trigger</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_REACTION__TRIGGER = DEFINITION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Effect</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_REACTION__EFFECT = DEFINITION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_REACTION__PROPERTIES = DEFINITION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Local Reaction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_REACTION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.TransitionReactionImpl <em>Transition Reaction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.TransitionReactionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTransitionReaction()
   * @generated
   */
  int TRANSITION_REACTION = 23;

  /**
   * The feature id for the '<em><b>Trigger</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_REACTION__TRIGGER = TRANSITION_STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Effect</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_REACTION__EFFECT = TRANSITION_STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_REACTION__PROPERTIES = TRANSITION_STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Transition Reaction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_REACTION_FEATURE_COUNT = TRANSITION_STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ReactionTriggerImpl <em>Reaction Trigger</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ReactionTriggerImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getReactionTrigger()
   * @generated
   */
  int REACTION_TRIGGER = 24;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_TRIGGER__TRIGGERS = 0;

  /**
   * The feature id for the '<em><b>Guard Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_TRIGGER__GUARD_EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Reaction Trigger</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_TRIGGER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EffectImpl <em>Effect</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EffectImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEffect()
   * @generated
   */
  int EFFECT = 25;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EFFECT__ACTIONS = 0;

  /**
   * The number of structural features of the '<em>Effect</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EFFECT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ReactionPropertiesImpl <em>Reaction Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ReactionPropertiesImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getReactionProperties()
   * @generated
   */
  int REACTION_PROPERTIES = 26;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_PROPERTIES__PROPERTIES = 0;

  /**
   * The number of structural features of the '<em>Reaction Properties</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_PROPERTIES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ReactionPropertyImpl <em>Reaction Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ReactionPropertyImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getReactionProperty()
   * @generated
   */
  int REACTION_PROPERTY = 27;

  /**
   * The number of structural features of the '<em>Reaction Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_PROPERTY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ReactionPriorityImpl <em>Reaction Priority</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ReactionPriorityImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getReactionPriority()
   * @generated
   */
  int REACTION_PRIORITY = 28;

  /**
   * The feature id for the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_PRIORITY__PRIORITY = REACTION_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Reaction Priority</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_PRIORITY_FEATURE_COUNT = REACTION_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EntryPointSpecImpl <em>Entry Point Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EntryPointSpecImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEntryPointSpec()
   * @generated
   */
  int ENTRY_POINT_SPEC = 29;

  /**
   * The feature id for the '<em><b>Entrypoint</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_POINT_SPEC__ENTRYPOINT = REACTION_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Entry Point Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_POINT_SPEC_FEATURE_COUNT = REACTION_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ExitPointSpecImpl <em>Exit Point Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ExitPointSpecImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExitPointSpec()
   * @generated
   */
  int EXIT_POINT_SPEC = 30;

  /**
   * The feature id for the '<em><b>Exitpoint</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_POINT_SPEC__EXITPOINT = REACTION_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Exit Point Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_POINT_SPEC_FEATURE_COUNT = REACTION_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EventSpecImpl <em>Event Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EventSpecImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEventSpec()
   * @generated
   */
  int EVENT_SPEC = 31;

  /**
   * The number of structural features of the '<em>Event Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_SPEC_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.RegularEventSpecImpl <em>Regular Event Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.RegularEventSpecImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRegularEventSpec()
   * @generated
   */
  int REGULAR_EVENT_SPEC = 32;

  /**
   * The feature id for the '<em><b>Event</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGULAR_EVENT_SPEC__EVENT = EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Regular Event Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REGULAR_EVENT_SPEC_FEATURE_COUNT = EVENT_SPEC_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.TimeEventSpecImpl <em>Time Event Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.TimeEventSpecImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTimeEventSpec()
   * @generated
   */
  int TIME_EVENT_SPEC = 33;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_EVENT_SPEC__VALUE = EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_EVENT_SPEC__UNIT = EVENT_SPEC_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Time Event Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_EVENT_SPEC_FEATURE_COUNT = EVENT_SPEC_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.BuiltinEventSpecImpl <em>Builtin Event Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.BuiltinEventSpecImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getBuiltinEventSpec()
   * @generated
   */
  int BUILTIN_EVENT_SPEC = 34;

  /**
   * The number of structural features of the '<em>Builtin Event Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILTIN_EVENT_SPEC_FEATURE_COUNT = EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EntryEventImpl <em>Entry Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EntryEventImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEntryEvent()
   * @generated
   */
  int ENTRY_EVENT = 35;

  /**
   * The number of structural features of the '<em>Entry Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_EVENT_FEATURE_COUNT = BUILTIN_EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ExitEventImpl <em>Exit Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ExitEventImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExitEvent()
   * @generated
   */
  int EXIT_EVENT = 36;

  /**
   * The number of structural features of the '<em>Exit Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_EVENT_FEATURE_COUNT = BUILTIN_EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.OnCycleEventImpl <em>On Cycle Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.OnCycleEventImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getOnCycleEvent()
   * @generated
   */
  int ON_CYCLE_EVENT = 37;

  /**
   * The number of structural features of the '<em>On Cycle Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ON_CYCLE_EVENT_FEATURE_COUNT = BUILTIN_EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.AlwaysEventImpl <em>Always Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.AlwaysEventImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getAlwaysEvent()
   * @generated
   */
  int ALWAYS_EVENT = 38;

  /**
   * The number of structural features of the '<em>Always Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALWAYS_EVENT_FEATURE_COUNT = BUILTIN_EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.StatementImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 39;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.AssignmentImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 40;

  /**
   * The feature id for the '<em><b>Var Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__VAR_REF = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Assignment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EventRaisingImpl <em>Event Raising</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EventRaisingImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEventRaising()
   * @generated
   */
  int EVENT_RAISING = 41;

  /**
   * The feature id for the '<em><b>Event</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_RAISING__EVENT = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_RAISING__VALUE = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Event Raising</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_RAISING_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 42;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.EnterEventImpl <em>Enter Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.EnterEventImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEnterEvent()
   * @generated
   */
  int ENTER_EVENT = 43;

  /**
   * The number of structural features of the '<em>Enter Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTER_EVENT_FEATURE_COUNT = ENTRY_EVENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.LogicalOrExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLogicalOrExpression()
   * @generated
   */
  int LOGICAL_OR_EXPRESSION = 44;

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
  int LOGICAL_AND_EXPRESSION = 45;

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
  int LOGICAL_NOT_EXPRESSION = 46;

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
  int LOGICAL_RELATION_EXPRESSION = 47;

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
  int NUMERICAL_ADD_SUBTRACT_EXPRESSION = 48;

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
  int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION = 49;

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
  int NUMERICAL_UNARY_EXPRESSION = 50;

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
  int PRIMITIVE_VALUE_EXPRESSION = 51;

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
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.ElementReferenceExpressionImpl <em>Element Reference Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.ElementReferenceExpressionImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getElementReferenceExpression()
   * @generated
   */
  int ELEMENT_REFERENCE_EXPRESSION = 52;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_REFERENCE_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Element Reference Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_REFERENCE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.impl.OperationCallImpl <em>Operation Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.impl.OperationCallImpl
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getOperationCall()
   * @generated
   */
  int OPERATION_CALL = 53;

  /**
   * The feature id for the '<em><b>Operation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL__OPERATION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL__ARGS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Operation Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.Direction <em>Direction</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.Direction
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDirection()
   * @generated
   */
  int DIRECTION = 54;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.AdditiveOperator <em>Additive Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.AdditiveOperator
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getAdditiveOperator()
   * @generated
   */
  int ADDITIVE_OPERATOR = 55;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.MultiplicativeOperator
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getMultiplicativeOperator()
   * @generated
   */
  int MULTIPLICATIVE_OPERATOR = 56;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.UnaryOperator <em>Unary Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.UnaryOperator
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getUnaryOperator()
   * @generated
   */
  int UNARY_OPERATOR = 57;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.RelationalOperator
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRelationalOperator()
   * @generated
   */
  int RELATIONAL_OPERATOR = 58;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.TimeUnit <em>Time Unit</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.TimeUnit
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTimeUnit()
   * @generated
   */
  int TIME_UNIT = 59;

  /**
   * The meta object id for the '{@link org.yakindu.sct.statechart.expressions.Type <em>Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.statechart.expressions.Type
   * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getType()
   * @generated
   */
  int TYPE = 60;


  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see org.yakindu.sct.statechart.expressions.Root
   * @generated
   */
  EClass getRoot();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.Root#getRoots <em>Roots</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Roots</em>'.
   * @see org.yakindu.sct.statechart.expressions.Root#getRoots()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_Roots();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.DefRoot <em>Def Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Def Root</em>'.
   * @see org.yakindu.sct.statechart.expressions.DefRoot
   * @generated
   */
  EClass getDefRoot();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.StatechartRoot <em>Statechart Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statechart Root</em>'.
   * @see org.yakindu.sct.statechart.expressions.StatechartRoot
   * @generated
   */
  EClass getStatechartRoot();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.StatechartRoot#getDef <em>Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Def</em>'.
   * @see org.yakindu.sct.statechart.expressions.StatechartRoot#getDef()
   * @see #getStatechartRoot()
   * @generated
   */
  EReference getStatechartRoot_Def();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.StateRoot <em>State Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Root</em>'.
   * @see org.yakindu.sct.statechart.expressions.StateRoot
   * @generated
   */
  EClass getStateRoot();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.StateRoot#getDef <em>Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Def</em>'.
   * @see org.yakindu.sct.statechart.expressions.StateRoot#getDef()
   * @see #getStateRoot()
   * @generated
   */
  EReference getStateRoot_Def();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.TransitionRoot <em>Transition Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Root</em>'.
   * @see org.yakindu.sct.statechart.expressions.TransitionRoot
   * @generated
   */
  EClass getTransitionRoot();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.TransitionRoot#getDef <em>Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Def</em>'.
   * @see org.yakindu.sct.statechart.expressions.TransitionRoot#getDef()
   * @see #getTransitionRoot()
   * @generated
   */
  EReference getTransitionRoot_Def();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.StatechartDefinition <em>Statechart Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statechart Definition</em>'.
   * @see org.yakindu.sct.statechart.expressions.StatechartDefinition
   * @generated
   */
  EClass getStatechartDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.StatechartDefinition#getDefinitionScopes <em>Definition Scopes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definition Scopes</em>'.
   * @see org.yakindu.sct.statechart.expressions.StatechartDefinition#getDefinitionScopes()
   * @see #getStatechartDefinition()
   * @generated
   */
  EReference getStatechartDefinition_DefinitionScopes();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.StateDefinition <em>State Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Definition</em>'.
   * @see org.yakindu.sct.statechart.expressions.StateDefinition
   * @generated
   */
  EClass getStateDefinition();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.TransitionStatement <em>Transition Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Statement</em>'.
   * @see org.yakindu.sct.statechart.expressions.TransitionStatement
   * @generated
   */
  EClass getTransitionStatement();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Scope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Scope</em>'.
   * @see org.yakindu.sct.statechart.expressions.Scope
   * @generated
   */
  EClass getScope();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.Scope#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see org.yakindu.sct.statechart.expressions.Scope#getDefinitions()
   * @see #getScope()
   * @generated
   */
  EReference getScope_Definitions();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.SimpleScope <em>Simple Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Scope</em>'.
   * @see org.yakindu.sct.statechart.expressions.SimpleScope
   * @generated
   */
  EClass getSimpleScope();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.StatechartScope <em>Statechart Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statechart Scope</em>'.
   * @see org.yakindu.sct.statechart.expressions.StatechartScope
   * @generated
   */
  EClass getStatechartScope();

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
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.VariableDefinition#getInitialValue <em>Initial Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Initial Value</em>'.
   * @see org.yakindu.sct.statechart.expressions.VariableDefinition#getInitialValue()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_InitialValue();

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
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Reaction <em>Reaction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reaction</em>'.
   * @see org.yakindu.sct.statechart.expressions.Reaction
   * @generated
   */
  EClass getReaction();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.Reaction#getTrigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Trigger</em>'.
   * @see org.yakindu.sct.statechart.expressions.Reaction#getTrigger()
   * @see #getReaction()
   * @generated
   */
  EReference getReaction_Trigger();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.Reaction#getEffect <em>Effect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Effect</em>'.
   * @see org.yakindu.sct.statechart.expressions.Reaction#getEffect()
   * @see #getReaction()
   * @generated
   */
  EReference getReaction_Effect();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.Reaction#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Properties</em>'.
   * @see org.yakindu.sct.statechart.expressions.Reaction#getProperties()
   * @see #getReaction()
   * @generated
   */
  EReference getReaction_Properties();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.LocalReaction <em>Local Reaction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Local Reaction</em>'.
   * @see org.yakindu.sct.statechart.expressions.LocalReaction
   * @generated
   */
  EClass getLocalReaction();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.TransitionReaction <em>Transition Reaction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Reaction</em>'.
   * @see org.yakindu.sct.statechart.expressions.TransitionReaction
   * @generated
   */
  EClass getTransitionReaction();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.ReactionTrigger <em>Reaction Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reaction Trigger</em>'.
   * @see org.yakindu.sct.statechart.expressions.ReactionTrigger
   * @generated
   */
  EClass getReactionTrigger();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.ReactionTrigger#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Triggers</em>'.
   * @see org.yakindu.sct.statechart.expressions.ReactionTrigger#getTriggers()
   * @see #getReactionTrigger()
   * @generated
   */
  EReference getReactionTrigger_Triggers();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.ReactionTrigger#getGuardExpression <em>Guard Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.ReactionTrigger#getGuardExpression()
   * @see #getReactionTrigger()
   * @generated
   */
  EReference getReactionTrigger_GuardExpression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Effect <em>Effect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Effect</em>'.
   * @see org.yakindu.sct.statechart.expressions.Effect
   * @generated
   */
  EClass getEffect();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.Effect#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actions</em>'.
   * @see org.yakindu.sct.statechart.expressions.Effect#getActions()
   * @see #getEffect()
   * @generated
   */
  EReference getEffect_Actions();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.ReactionProperties <em>Reaction Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reaction Properties</em>'.
   * @see org.yakindu.sct.statechart.expressions.ReactionProperties
   * @generated
   */
  EClass getReactionProperties();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.ReactionProperties#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see org.yakindu.sct.statechart.expressions.ReactionProperties#getProperties()
   * @see #getReactionProperties()
   * @generated
   */
  EReference getReactionProperties_Properties();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.ReactionProperty <em>Reaction Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reaction Property</em>'.
   * @see org.yakindu.sct.statechart.expressions.ReactionProperty
   * @generated
   */
  EClass getReactionProperty();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.ReactionPriority <em>Reaction Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reaction Priority</em>'.
   * @see org.yakindu.sct.statechart.expressions.ReactionPriority
   * @generated
   */
  EClass getReactionPriority();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.ReactionPriority#getPriority <em>Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priority</em>'.
   * @see org.yakindu.sct.statechart.expressions.ReactionPriority#getPriority()
   * @see #getReactionPriority()
   * @generated
   */
  EAttribute getReactionPriority_Priority();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.EntryPointSpec <em>Entry Point Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry Point Spec</em>'.
   * @see org.yakindu.sct.statechart.expressions.EntryPointSpec
   * @generated
   */
  EClass getEntryPointSpec();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.statechart.expressions.EntryPointSpec#getEntrypoint <em>Entrypoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Entrypoint</em>'.
   * @see org.yakindu.sct.statechart.expressions.EntryPointSpec#getEntrypoint()
   * @see #getEntryPointSpec()
   * @generated
   */
  EReference getEntryPointSpec_Entrypoint();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.ExitPointSpec <em>Exit Point Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exit Point Spec</em>'.
   * @see org.yakindu.sct.statechart.expressions.ExitPointSpec
   * @generated
   */
  EClass getExitPointSpec();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.statechart.expressions.ExitPointSpec#getExitpoint <em>Exitpoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Exitpoint</em>'.
   * @see org.yakindu.sct.statechart.expressions.ExitPointSpec#getExitpoint()
   * @see #getExitPointSpec()
   * @generated
   */
  EReference getExitPointSpec_Exitpoint();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.EventSpec <em>Event Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Spec</em>'.
   * @see org.yakindu.sct.statechart.expressions.EventSpec
   * @generated
   */
  EClass getEventSpec();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.RegularEventSpec <em>Regular Event Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Regular Event Spec</em>'.
   * @see org.yakindu.sct.statechart.expressions.RegularEventSpec
   * @generated
   */
  EClass getRegularEventSpec();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.statechart.expressions.RegularEventSpec#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Event</em>'.
   * @see org.yakindu.sct.statechart.expressions.RegularEventSpec#getEvent()
   * @see #getRegularEventSpec()
   * @generated
   */
  EReference getRegularEventSpec_Event();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.TimeEventSpec <em>Time Event Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Event Spec</em>'.
   * @see org.yakindu.sct.statechart.expressions.TimeEventSpec
   * @generated
   */
  EClass getTimeEventSpec();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.TimeEventSpec#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.yakindu.sct.statechart.expressions.TimeEventSpec#getValue()
   * @see #getTimeEventSpec()
   * @generated
   */
  EAttribute getTimeEventSpec_Value();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.statechart.expressions.TimeEventSpec#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.yakindu.sct.statechart.expressions.TimeEventSpec#getUnit()
   * @see #getTimeEventSpec()
   * @generated
   */
  EAttribute getTimeEventSpec_Unit();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.BuiltinEventSpec <em>Builtin Event Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Builtin Event Spec</em>'.
   * @see org.yakindu.sct.statechart.expressions.BuiltinEventSpec
   * @generated
   */
  EClass getBuiltinEventSpec();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.EntryEvent <em>Entry Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry Event</em>'.
   * @see org.yakindu.sct.statechart.expressions.EntryEvent
   * @generated
   */
  EClass getEntryEvent();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.ExitEvent <em>Exit Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exit Event</em>'.
   * @see org.yakindu.sct.statechart.expressions.ExitEvent
   * @generated
   */
  EClass getExitEvent();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.OnCycleEvent <em>On Cycle Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>On Cycle Event</em>'.
   * @see org.yakindu.sct.statechart.expressions.OnCycleEvent
   * @generated
   */
  EClass getOnCycleEvent();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.AlwaysEvent <em>Always Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Always Event</em>'.
   * @see org.yakindu.sct.statechart.expressions.AlwaysEvent
   * @generated
   */
  EClass getAlwaysEvent();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see org.yakindu.sct.statechart.expressions.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see org.yakindu.sct.statechart.expressions.Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.statechart.expressions.Assignment#getVarRef <em>Var Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Var Ref</em>'.
   * @see org.yakindu.sct.statechart.expressions.Assignment#getVarRef()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_VarRef();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.Assignment#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.Assignment#getExpression()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Expression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.EventRaising <em>Event Raising</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Raising</em>'.
   * @see org.yakindu.sct.statechart.expressions.EventRaising
   * @generated
   */
  EClass getEventRaising();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.statechart.expressions.EventRaising#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Event</em>'.
   * @see org.yakindu.sct.statechart.expressions.EventRaising#getEvent()
   * @see #getEventRaising()
   * @generated
   */
  EReference getEventRaising_Event();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.statechart.expressions.EventRaising#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.yakindu.sct.statechart.expressions.EventRaising#getValue()
   * @see #getEventRaising()
   * @generated
   */
  EReference getEventRaising_Value();

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
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.EnterEvent <em>Enter Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enter Event</em>'.
   * @see org.yakindu.sct.statechart.expressions.EnterEvent
   * @generated
   */
  EClass getEnterEvent();

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
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.ElementReferenceExpression <em>Element Reference Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Reference Expression</em>'.
   * @see org.yakindu.sct.statechart.expressions.ElementReferenceExpression
   * @generated
   */
  EClass getElementReferenceExpression();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.statechart.expressions.ElementReferenceExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.yakindu.sct.statechart.expressions.ElementReferenceExpression#getValue()
   * @see #getElementReferenceExpression()
   * @generated
   */
  EReference getElementReferenceExpression_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.statechart.expressions.OperationCall <em>Operation Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Call</em>'.
   * @see org.yakindu.sct.statechart.expressions.OperationCall
   * @generated
   */
  EClass getOperationCall();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.statechart.expressions.OperationCall#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Operation</em>'.
   * @see org.yakindu.sct.statechart.expressions.OperationCall#getOperation()
   * @see #getOperationCall()
   * @generated
   */
  EReference getOperationCall_Operation();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.statechart.expressions.OperationCall#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.yakindu.sct.statechart.expressions.OperationCall#getArgs()
   * @see #getOperationCall()
   * @generated
   */
  EReference getOperationCall_Args();

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
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.RootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.RootImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRoot()
     * @generated
     */
    EClass ROOT = eINSTANCE.getRoot();

    /**
     * The meta object literal for the '<em><b>Roots</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ROOT__ROOTS = eINSTANCE.getRoot_Roots();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.DefRootImpl <em>Def Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.DefRootImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getDefRoot()
     * @generated
     */
    EClass DEF_ROOT = eINSTANCE.getDefRoot();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.StatechartRootImpl <em>Statechart Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.StatechartRootImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStatechartRoot()
     * @generated
     */
    EClass STATECHART_ROOT = eINSTANCE.getStatechartRoot();

    /**
     * The meta object literal for the '<em><b>Def</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATECHART_ROOT__DEF = eINSTANCE.getStatechartRoot_Def();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.StateRootImpl <em>State Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.StateRootImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStateRoot()
     * @generated
     */
    EClass STATE_ROOT = eINSTANCE.getStateRoot();

    /**
     * The meta object literal for the '<em><b>Def</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_ROOT__DEF = eINSTANCE.getStateRoot_Def();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.TransitionRootImpl <em>Transition Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.TransitionRootImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTransitionRoot()
     * @generated
     */
    EClass TRANSITION_ROOT = eINSTANCE.getTransitionRoot();

    /**
     * The meta object literal for the '<em><b>Def</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_ROOT__DEF = eINSTANCE.getTransitionRoot_Def();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.StatechartDefinitionImpl <em>Statechart Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.StatechartDefinitionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStatechartDefinition()
     * @generated
     */
    EClass STATECHART_DEFINITION = eINSTANCE.getStatechartDefinition();

    /**
     * The meta object literal for the '<em><b>Definition Scopes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATECHART_DEFINITION__DEFINITION_SCOPES = eINSTANCE.getStatechartDefinition_DefinitionScopes();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.StateDefinitionImpl <em>State Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.StateDefinitionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStateDefinition()
     * @generated
     */
    EClass STATE_DEFINITION = eINSTANCE.getStateDefinition();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.TransitionStatementImpl <em>Transition Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.TransitionStatementImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTransitionStatement()
     * @generated
     */
    EClass TRANSITION_STATEMENT = eINSTANCE.getTransitionStatement();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ScopeImpl <em>Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ScopeImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getScope()
     * @generated
     */
    EClass SCOPE = eINSTANCE.getScope();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SCOPE__DEFINITIONS = eINSTANCE.getScope_Definitions();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.SimpleScopeImpl <em>Simple Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.SimpleScopeImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getSimpleScope()
     * @generated
     */
    EClass SIMPLE_SCOPE = eINSTANCE.getSimpleScope();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.StatechartScopeImpl <em>Statechart Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.StatechartScopeImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStatechartScope()
     * @generated
     */
    EClass STATECHART_SCOPE = eINSTANCE.getStatechartScope();

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
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DEFINITION__TYPE = eINSTANCE.getVariableDefinition_Type();

    /**
     * The meta object literal for the '<em><b>Initial Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DEFINITION__INITIAL_VALUE = eINSTANCE.getVariableDefinition_InitialValue();

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
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ReactionImpl <em>Reaction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ReactionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getReaction()
     * @generated
     */
    EClass REACTION = eINSTANCE.getReaction();

    /**
     * The meta object literal for the '<em><b>Trigger</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REACTION__TRIGGER = eINSTANCE.getReaction_Trigger();

    /**
     * The meta object literal for the '<em><b>Effect</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REACTION__EFFECT = eINSTANCE.getReaction_Effect();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REACTION__PROPERTIES = eINSTANCE.getReaction_Properties();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.LocalReactionImpl <em>Local Reaction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.LocalReactionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getLocalReaction()
     * @generated
     */
    EClass LOCAL_REACTION = eINSTANCE.getLocalReaction();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.TransitionReactionImpl <em>Transition Reaction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.TransitionReactionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTransitionReaction()
     * @generated
     */
    EClass TRANSITION_REACTION = eINSTANCE.getTransitionReaction();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ReactionTriggerImpl <em>Reaction Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ReactionTriggerImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getReactionTrigger()
     * @generated
     */
    EClass REACTION_TRIGGER = eINSTANCE.getReactionTrigger();

    /**
     * The meta object literal for the '<em><b>Triggers</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REACTION_TRIGGER__TRIGGERS = eINSTANCE.getReactionTrigger_Triggers();

    /**
     * The meta object literal for the '<em><b>Guard Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REACTION_TRIGGER__GUARD_EXPRESSION = eINSTANCE.getReactionTrigger_GuardExpression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.EffectImpl <em>Effect</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.EffectImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEffect()
     * @generated
     */
    EClass EFFECT = eINSTANCE.getEffect();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EFFECT__ACTIONS = eINSTANCE.getEffect_Actions();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ReactionPropertiesImpl <em>Reaction Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ReactionPropertiesImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getReactionProperties()
     * @generated
     */
    EClass REACTION_PROPERTIES = eINSTANCE.getReactionProperties();

    /**
     * The meta object literal for the '<em><b>Properties</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REACTION_PROPERTIES__PROPERTIES = eINSTANCE.getReactionProperties_Properties();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ReactionPropertyImpl <em>Reaction Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ReactionPropertyImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getReactionProperty()
     * @generated
     */
    EClass REACTION_PROPERTY = eINSTANCE.getReactionProperty();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ReactionPriorityImpl <em>Reaction Priority</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ReactionPriorityImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getReactionPriority()
     * @generated
     */
    EClass REACTION_PRIORITY = eINSTANCE.getReactionPriority();

    /**
     * The meta object literal for the '<em><b>Priority</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REACTION_PRIORITY__PRIORITY = eINSTANCE.getReactionPriority_Priority();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.EntryPointSpecImpl <em>Entry Point Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.EntryPointSpecImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEntryPointSpec()
     * @generated
     */
    EClass ENTRY_POINT_SPEC = eINSTANCE.getEntryPointSpec();

    /**
     * The meta object literal for the '<em><b>Entrypoint</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENTRY_POINT_SPEC__ENTRYPOINT = eINSTANCE.getEntryPointSpec_Entrypoint();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ExitPointSpecImpl <em>Exit Point Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ExitPointSpecImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExitPointSpec()
     * @generated
     */
    EClass EXIT_POINT_SPEC = eINSTANCE.getExitPointSpec();

    /**
     * The meta object literal for the '<em><b>Exitpoint</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXIT_POINT_SPEC__EXITPOINT = eINSTANCE.getExitPointSpec_Exitpoint();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.EventSpecImpl <em>Event Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.EventSpecImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEventSpec()
     * @generated
     */
    EClass EVENT_SPEC = eINSTANCE.getEventSpec();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.RegularEventSpecImpl <em>Regular Event Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.RegularEventSpecImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getRegularEventSpec()
     * @generated
     */
    EClass REGULAR_EVENT_SPEC = eINSTANCE.getRegularEventSpec();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REGULAR_EVENT_SPEC__EVENT = eINSTANCE.getRegularEventSpec_Event();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.TimeEventSpecImpl <em>Time Event Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.TimeEventSpecImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getTimeEventSpec()
     * @generated
     */
    EClass TIME_EVENT_SPEC = eINSTANCE.getTimeEventSpec();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_EVENT_SPEC__VALUE = eINSTANCE.getTimeEventSpec_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_EVENT_SPEC__UNIT = eINSTANCE.getTimeEventSpec_Unit();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.BuiltinEventSpecImpl <em>Builtin Event Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.BuiltinEventSpecImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getBuiltinEventSpec()
     * @generated
     */
    EClass BUILTIN_EVENT_SPEC = eINSTANCE.getBuiltinEventSpec();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.EntryEventImpl <em>Entry Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.EntryEventImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEntryEvent()
     * @generated
     */
    EClass ENTRY_EVENT = eINSTANCE.getEntryEvent();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ExitEventImpl <em>Exit Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ExitEventImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getExitEvent()
     * @generated
     */
    EClass EXIT_EVENT = eINSTANCE.getExitEvent();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.OnCycleEventImpl <em>On Cycle Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.OnCycleEventImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getOnCycleEvent()
     * @generated
     */
    EClass ON_CYCLE_EVENT = eINSTANCE.getOnCycleEvent();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.AlwaysEventImpl <em>Always Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.AlwaysEventImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getAlwaysEvent()
     * @generated
     */
    EClass ALWAYS_EVENT = eINSTANCE.getAlwaysEvent();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.StatementImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.AssignmentImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getAssignment()
     * @generated
     */
    EClass ASSIGNMENT = eINSTANCE.getAssignment();

    /**
     * The meta object literal for the '<em><b>Var Ref</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__VAR_REF = eINSTANCE.getAssignment_VarRef();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT__EXPRESSION = eINSTANCE.getAssignment_Expression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.EventRaisingImpl <em>Event Raising</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.EventRaisingImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEventRaising()
     * @generated
     */
    EClass EVENT_RAISING = eINSTANCE.getEventRaising();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_RAISING__EVENT = eINSTANCE.getEventRaising_Event();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_RAISING__VALUE = eINSTANCE.getEventRaising_Value();

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
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.EnterEventImpl <em>Enter Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.EnterEventImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getEnterEvent()
     * @generated
     */
    EClass ENTER_EVENT = eINSTANCE.getEnterEvent();

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
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.ElementReferenceExpressionImpl <em>Element Reference Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.ElementReferenceExpressionImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getElementReferenceExpression()
     * @generated
     */
    EClass ELEMENT_REFERENCE_EXPRESSION = eINSTANCE.getElementReferenceExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_REFERENCE_EXPRESSION__VALUE = eINSTANCE.getElementReferenceExpression_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.statechart.expressions.impl.OperationCallImpl <em>Operation Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.statechart.expressions.impl.OperationCallImpl
     * @see org.yakindu.sct.statechart.expressions.impl.ExpressionsPackageImpl#getOperationCall()
     * @generated
     */
    EClass OPERATION_CALL = eINSTANCE.getOperationCall();

    /**
     * The meta object literal for the '<em><b>Operation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CALL__OPERATION = eINSTANCE.getOperationCall_Operation();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CALL__ARGS = eINSTANCE.getOperationCall_Args();

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
