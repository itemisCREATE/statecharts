/**
 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.yakindu.sct.model.sgraph.SGraphPackage;

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
 * @see org.yakindu.sct.model.stext.stext.StextFactory
 * @model kind="package"
 * @generated
 */
public interface StextPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "stext";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.yakindu.org/sct/statechart/SText";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "stext";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  StextPackage eINSTANCE = org.yakindu.sct.model.stext.stext.impl.StextPackageImpl.init();

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.RootImpl <em>Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.RootImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getRoot()
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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.DefRootImpl <em>Def Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.DefRootImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getDefRoot()
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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.StatechartRootImpl <em>Statechart Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.StatechartRootImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStatechartRoot()
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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.StateRootImpl <em>State Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.StateRootImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStateRoot()
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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.TransitionRootImpl <em>Transition Root</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.TransitionRootImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTransitionRoot()
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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.StatechartSpecificationImpl <em>Statechart Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.StatechartSpecificationImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStatechartSpecification()
   * @generated
   */
  int STATECHART_SPECIFICATION = 5;

  /**
   * The feature id for the '<em><b>Scopes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_SPECIFICATION__SCOPES = SGraphPackage.SCOPED_ELEMENT__SCOPES;

  /**
   * The feature id for the '<em><b>Namespace</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_SPECIFICATION__NAMESPACE = SGraphPackage.SCOPED_ELEMENT__NAMESPACE;

  /**
   * The number of structural features of the '<em>Statechart Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_SPECIFICATION_FEATURE_COUNT = SGraphPackage.SCOPED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.StateSpecificationImpl <em>State Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.StateSpecificationImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStateSpecification()
   * @generated
   */
  int STATE_SPECIFICATION = 6;

  /**
   * The feature id for the '<em><b>Scope</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_SPECIFICATION__SCOPE = 0;

  /**
   * The number of structural features of the '<em>State Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_SPECIFICATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.TransitionSpecificationImpl <em>Transition Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.TransitionSpecificationImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTransitionSpecification()
   * @generated
   */
  int TRANSITION_SPECIFICATION = 7;

  /**
   * The feature id for the '<em><b>Reaction</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_SPECIFICATION__REACTION = 0;

  /**
   * The number of structural features of the '<em>Transition Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_SPECIFICATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.StatechartScopeImpl <em>Statechart Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.StatechartScopeImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStatechartScope()
   * @generated
   */
  int STATECHART_SCOPE = 8;

  /**
   * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_SCOPE__DECLARATIONS = SGraphPackage.SCOPE__DECLARATIONS;

  /**
   * The feature id for the '<em><b>Events</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_SCOPE__EVENTS = SGraphPackage.SCOPE__EVENTS;

  /**
   * The feature id for the '<em><b>Variables</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_SCOPE__VARIABLES = SGraphPackage.SCOPE__VARIABLES;

  /**
   * The number of structural features of the '<em>Statechart Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATECHART_SCOPE_FEATURE_COUNT = SGraphPackage.SCOPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.InterfaceScopeImpl <em>Interface Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.InterfaceScopeImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getInterfaceScope()
   * @generated
   */
  int INTERFACE_SCOPE = 9;

  /**
   * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE__DECLARATIONS = STATECHART_SCOPE__DECLARATIONS;

  /**
   * The feature id for the '<em><b>Events</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE__EVENTS = STATECHART_SCOPE__EVENTS;

  /**
   * The feature id for the '<em><b>Variables</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE__VARIABLES = STATECHART_SCOPE__VARIABLES;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.InternalScopeImpl <em>Internal Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.InternalScopeImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getInternalScope()
   * @generated
   */
  int INTERNAL_SCOPE = 10;

  /**
   * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_SCOPE__DECLARATIONS = STATECHART_SCOPE__DECLARATIONS;

  /**
   * The feature id for the '<em><b>Events</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_SCOPE__EVENTS = STATECHART_SCOPE__EVENTS;

  /**
   * The feature id for the '<em><b>Variables</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_SCOPE__VARIABLES = STATECHART_SCOPE__VARIABLES;

  /**
   * The number of structural features of the '<em>Internal Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_SCOPE_FEATURE_COUNT = STATECHART_SCOPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl <em>Event Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventDefinition()
   * @generated
   */
  int EVENT_DEFINITION = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__NAME = SGraphPackage.EVENT__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__TYPE = SGraphPackage.EVENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owning Type</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__OWNING_TYPE = SGraphPackage.EVENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__DIRECTION = SGraphPackage.EVENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Event Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION_FEATURE_COUNT = SGraphPackage.EVENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.VariableDefinitionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getVariableDefinition()
   * @generated
   */
  int VARIABLE_DEFINITION = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__NAME = SGraphPackage.VARIABLE__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__TYPE = SGraphPackage.VARIABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owning Type</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__OWNING_TYPE = SGraphPackage.VARIABLE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Readonly</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__READONLY = SGraphPackage.VARIABLE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>External</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__EXTERNAL = SGraphPackage.VARIABLE_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__INITIAL_VALUE = SGraphPackage.VARIABLE_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Variable Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION_FEATURE_COUNT = SGraphPackage.VARIABLE_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl <em>Operation Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getOperationDefinition()
   * @generated
   */
  int OPERATION_DEFINITION = 13;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DEFINITION__NAME = SGraphPackage.DECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DEFINITION__TYPE = SGraphPackage.DECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owning Type</b></em>' container reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DEFINITION__OWNING_TYPE = SGraphPackage.DECLARATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DEFINITION__PARAMETERS = SGraphPackage.DECLARATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Operation Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_DEFINITION_FEATURE_COUNT = SGraphPackage.DECLARATION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl <em>Local Reaction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLocalReaction()
   * @generated
   */
  int LOCAL_REACTION = 14;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_REACTION__NAME = SGraphPackage.DECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Trigger</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_REACTION__TRIGGER = SGraphPackage.DECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Effect</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_REACTION__EFFECT = SGraphPackage.DECLARATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_REACTION__PROPERTIES = SGraphPackage.DECLARATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Local Reaction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOCAL_REACTION_FEATURE_COUNT = SGraphPackage.DECLARATION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.TransitionReactionImpl <em>Transition Reaction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.TransitionReactionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTransitionReaction()
   * @generated
   */
  int TRANSITION_REACTION = 15;

  /**
   * The feature id for the '<em><b>Trigger</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_REACTION__TRIGGER = SGraphPackage.REACTION__TRIGGER;

  /**
   * The feature id for the '<em><b>Effect</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_REACTION__EFFECT = SGraphPackage.REACTION__EFFECT;

  /**
   * The feature id for the '<em><b>Properties</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_REACTION__PROPERTIES = SGraphPackage.REACTION__PROPERTIES;

  /**
   * The number of structural features of the '<em>Transition Reaction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSITION_REACTION_FEATURE_COUNT = SGraphPackage.REACTION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.GuardImpl <em>Guard</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.GuardImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getGuard()
   * @generated
   */
  int GUARD = 16;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD__EXPRESSION = 0;

  /**
   * The number of structural features of the '<em>Guard</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GUARD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EntryPointSpecImpl <em>Entry Point Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EntryPointSpecImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEntryPointSpec()
   * @generated
   */
  int ENTRY_POINT_SPEC = 17;

  /**
   * The feature id for the '<em><b>Entrypoint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_POINT_SPEC__ENTRYPOINT = SGraphPackage.REACTION_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Entry Point Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_POINT_SPEC_FEATURE_COUNT = SGraphPackage.REACTION_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ExitPointSpecImpl <em>Exit Point Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ExitPointSpecImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getExitPointSpec()
   * @generated
   */
  int EXIT_POINT_SPEC = 18;

  /**
   * The feature id for the '<em><b>Exitpoint</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_POINT_SPEC__EXITPOINT = SGraphPackage.REACTION_PROPERTY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Exit Point Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_POINT_SPEC_FEATURE_COUNT = SGraphPackage.REACTION_PROPERTY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EventSpecImpl <em>Event Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EventSpecImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventSpec()
   * @generated
   */
  int EVENT_SPEC = 19;

  /**
   * The number of structural features of the '<em>Event Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_SPEC_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.RegularEventSpecImpl <em>Regular Event Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.RegularEventSpecImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getRegularEventSpec()
   * @generated
   */
  int REGULAR_EVENT_SPEC = 20;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference.
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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.TimeEventSpecImpl <em>Time Event Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.TimeEventSpecImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTimeEventSpec()
   * @generated
   */
  int TIME_EVENT_SPEC = 21;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_EVENT_SPEC__TYPE = EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_EVENT_SPEC__VALUE = EVENT_SPEC_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Unit</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_EVENT_SPEC__UNIT = EVENT_SPEC_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Time Event Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TIME_EVENT_SPEC_FEATURE_COUNT = EVENT_SPEC_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.BuiltinEventSpecImpl <em>Builtin Event Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.BuiltinEventSpecImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getBuiltinEventSpec()
   * @generated
   */
  int BUILTIN_EVENT_SPEC = 22;

  /**
   * The number of structural features of the '<em>Builtin Event Spec</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BUILTIN_EVENT_SPEC_FEATURE_COUNT = EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EntryEventImpl <em>Entry Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EntryEventImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEntryEvent()
   * @generated
   */
  int ENTRY_EVENT = 23;

  /**
   * The number of structural features of the '<em>Entry Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRY_EVENT_FEATURE_COUNT = BUILTIN_EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ExitEventImpl <em>Exit Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ExitEventImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getExitEvent()
   * @generated
   */
  int EXIT_EVENT = 24;

  /**
   * The number of structural features of the '<em>Exit Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_EVENT_FEATURE_COUNT = BUILTIN_EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.AlwaysEventImpl <em>Always Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.AlwaysEventImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getAlwaysEvent()
   * @generated
   */
  int ALWAYS_EVENT = 25;

  /**
   * The number of structural features of the '<em>Always Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALWAYS_EVENT_FEATURE_COUNT = BUILTIN_EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 26;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = SGraphPackage.STATEMENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.LiteralImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 27;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.BoolLiteralImpl <em>Bool Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.BoolLiteralImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getBoolLiteral()
   * @generated
   */
  int BOOL_LITERAL = 28;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Bool Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.IntLiteralImpl <em>Int Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.IntLiteralImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getIntLiteral()
   * @generated
   */
  int INT_LITERAL = 29;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Int Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INT_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.RealLiteralImpl <em>Real Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.RealLiteralImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getRealLiteral()
   * @generated
   */
  int REAL_LITERAL = 30;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Real Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.HexLiteralImpl <em>Hex Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.HexLiteralImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getHexLiteral()
   * @generated
   */
  int HEX_LITERAL = 31;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEX_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Hex Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HEX_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.StringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.StringLiteralImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStringLiteral()
   * @generated
   */
  int STRING_LITERAL = 32;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.SimpleScopeImpl <em>Simple Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.SimpleScopeImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getSimpleScope()
   * @generated
   */
  int SIMPLE_SCOPE = 33;

  /**
   * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SCOPE__DECLARATIONS = SGraphPackage.SCOPE__DECLARATIONS;

  /**
   * The feature id for the '<em><b>Events</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SCOPE__EVENTS = SGraphPackage.SCOPE__EVENTS;

  /**
   * The feature id for the '<em><b>Variables</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SCOPE__VARIABLES = SGraphPackage.SCOPE__VARIABLES;

  /**
   * The number of structural features of the '<em>Simple Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_SCOPE_FEATURE_COUNT = SGraphPackage.SCOPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionTriggerImpl <em>Reaction Trigger</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ReactionTriggerImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReactionTrigger()
   * @generated
   */
  int REACTION_TRIGGER = 34;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_TRIGGER__TRIGGERS = SGraphPackage.TRIGGER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Guard</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_TRIGGER__GUARD = SGraphPackage.TRIGGER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Reaction Trigger</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_TRIGGER_FEATURE_COUNT = SGraphPackage.TRIGGER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.DefaultTriggerImpl <em>Default Trigger</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.DefaultTriggerImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getDefaultTrigger()
   * @generated
   */
  int DEFAULT_TRIGGER = 35;

  /**
   * The number of structural features of the '<em>Default Trigger</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEFAULT_TRIGGER_FEATURE_COUNT = SGraphPackage.TRIGGER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionEffectImpl <em>Reaction Effect</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ReactionEffectImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReactionEffect()
   * @generated
   */
  int REACTION_EFFECT = 36;

  /**
   * The feature id for the '<em><b>Actions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_EFFECT__ACTIONS = SGraphPackage.EFFECT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Reaction Effect</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_EFFECT_FEATURE_COUNT = SGraphPackage.EFFECT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EventRaisingExpressionImpl <em>Event Raising Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EventRaisingExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventRaisingExpression()
   * @generated
   */
  int EVENT_RAISING_EXPRESSION = 37;

  /**
   * The feature id for the '<em><b>Event</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_RAISING_EXPRESSION__EVENT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_RAISING_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Event Raising Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_RAISING_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.AssignmentExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getAssignmentExpression()
   * @generated
   */
  int ASSIGNMENT_EXPRESSION = 38;

  /**
   * The feature id for the '<em><b>Var Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__VAR_REF = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Assignment Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ASSIGNMENT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ConditionalExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getConditionalExpression()
   * @generated
   */
  int CONDITIONAL_EXPRESSION = 39;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__CONDITION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>True Case</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__TRUE_CASE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>False Case</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__FALSE_CASE = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Conditional Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.LogicalOrExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLogicalOrExpression()
   * @generated
   */
  int LOGICAL_OR_EXPRESSION = 40;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.LogicalAndExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLogicalAndExpression()
   * @generated
   */
  int LOGICAL_AND_EXPRESSION = 41;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.LogicalNotExpressionImpl <em>Logical Not Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.LogicalNotExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLogicalNotExpression()
   * @generated
   */
  int LOGICAL_NOT_EXPRESSION = 42;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.BitwiseXorExpressionImpl <em>Bitwise Xor Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.BitwiseXorExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getBitwiseXorExpression()
   * @generated
   */
  int BITWISE_XOR_EXPRESSION = 43;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_XOR_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_XOR_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Bitwise Xor Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_XOR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.BitwiseOrExpressionImpl <em>Bitwise Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.BitwiseOrExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getBitwiseOrExpression()
   * @generated
   */
  int BITWISE_OR_EXPRESSION = 44;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_OR_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_OR_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Bitwise Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.BitwiseAndExpressionImpl <em>Bitwise And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.BitwiseAndExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getBitwiseAndExpression()
   * @generated
   */
  int BITWISE_AND_EXPRESSION = 45;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_AND_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_AND_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Bitwise And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BITWISE_AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.LogicalRelationExpressionImpl <em>Logical Relation Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.LogicalRelationExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLogicalRelationExpression()
   * @generated
   */
  int LOGICAL_RELATION_EXPRESSION = 46;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ShiftExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getShiftExpression()
   * @generated
   */
  int SHIFT_EXPRESSION = 47;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Shift Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SHIFT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.NumericalAddSubtractExpressionImpl <em>Numerical Add Subtract Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.NumericalAddSubtractExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getNumericalAddSubtractExpression()
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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.NumericalMultiplyDivideExpressionImpl <em>Numerical Multiply Divide Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.NumericalMultiplyDivideExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getNumericalMultiplyDivideExpression()
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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.NumericalUnaryExpressionImpl <em>Numerical Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.NumericalUnaryExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getNumericalUnaryExpression()
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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.PrimitiveValueExpressionImpl <em>Primitive Value Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.PrimitiveValueExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getPrimitiveValueExpression()
   * @generated
   */
  int PRIMITIVE_VALUE_EXPRESSION = 51;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.FeatureCallImpl <em>Feature Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.FeatureCallImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getFeatureCall()
   * @generated
   */
  int FEATURE_CALL = 52;

  /**
   * The feature id for the '<em><b>Owner</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL__OWNER = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Feature</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL__FEATURE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Operation Call</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL__OPERATION_CALL = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL__ARGS = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Feature Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ElementReferenceExpressionImpl <em>Element Reference Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ElementReferenceExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getElementReferenceExpression()
   * @generated
   */
  int ELEMENT_REFERENCE_EXPRESSION = 53;

  /**
   * The feature id for the '<em><b>Reference</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_REFERENCE_EXPRESSION__REFERENCE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operation Call</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_REFERENCE_EXPRESSION__OPERATION_CALL = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Args</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_REFERENCE_EXPRESSION__ARGS = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Element Reference Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ELEMENT_REFERENCE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EventValueReferenceExpressionImpl <em>Event Value Reference Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EventValueReferenceExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventValueReferenceExpression()
   * @generated
   */
  int EVENT_VALUE_REFERENCE_EXPRESSION = 54;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_VALUE_REFERENCE_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Event Value Reference Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_VALUE_REFERENCE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ActiveStateReferenceExpressionImpl <em>Active State Reference Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ActiveStateReferenceExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getActiveStateReferenceExpression()
   * @generated
   */
  int ACTIVE_STATE_REFERENCE_EXPRESSION = 55;

  /**
   * The feature id for the '<em><b>Value</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVE_STATE_REFERENCE_EXPRESSION__VALUE = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Active State Reference Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ACTIVE_STATE_REFERENCE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ParenthesizedExpressionImpl <em>Parenthesized Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ParenthesizedExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getParenthesizedExpression()
   * @generated
   */
  int PARENTHESIZED_EXPRESSION = 56;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENTHESIZED_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Parenthesized Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENTHESIZED_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.Direction <em>Direction</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.Direction
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getDirection()
   * @generated
   */
  int DIRECTION = 57;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.TimeEventType <em>Time Event Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.TimeEventType
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTimeEventType()
   * @generated
   */
  int TIME_EVENT_TYPE = 58;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.AssignmentOperator <em>Assignment Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.AssignmentOperator
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getAssignmentOperator()
   * @generated
   */
  int ASSIGNMENT_OPERATOR = 59;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.ShiftOperator <em>Shift Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.ShiftOperator
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getShiftOperator()
   * @generated
   */
  int SHIFT_OPERATOR = 60;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.AdditiveOperator <em>Additive Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.AdditiveOperator
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getAdditiveOperator()
   * @generated
   */
  int ADDITIVE_OPERATOR = 61;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.MultiplicativeOperator
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getMultiplicativeOperator()
   * @generated
   */
  int MULTIPLICATIVE_OPERATOR = 62;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.UnaryOperator <em>Unary Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.UnaryOperator
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getUnaryOperator()
   * @generated
   */
  int UNARY_OPERATOR = 63;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.RelationalOperator
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getRelationalOperator()
   * @generated
   */
  int RELATIONAL_OPERATOR = 64;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.TimeUnit <em>Time Unit</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.TimeUnit
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTimeUnit()
   * @generated
   */
  int TIME_UNIT = 65;


  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.Root <em>Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Root</em>'.
   * @see org.yakindu.sct.model.stext.stext.Root
   * @generated
   */
  EClass getRoot();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.stext.stext.Root#getRoots <em>Roots</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Roots</em>'.
   * @see org.yakindu.sct.model.stext.stext.Root#getRoots()
   * @see #getRoot()
   * @generated
   */
  EReference getRoot_Roots();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.DefRoot <em>Def Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Def Root</em>'.
   * @see org.yakindu.sct.model.stext.stext.DefRoot
   * @generated
   */
  EClass getDefRoot();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.StatechartRoot <em>Statechart Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statechart Root</em>'.
   * @see org.yakindu.sct.model.stext.stext.StatechartRoot
   * @generated
   */
  EClass getStatechartRoot();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.StatechartRoot#getDef <em>Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Def</em>'.
   * @see org.yakindu.sct.model.stext.stext.StatechartRoot#getDef()
   * @see #getStatechartRoot()
   * @generated
   */
  EReference getStatechartRoot_Def();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.StateRoot <em>State Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Root</em>'.
   * @see org.yakindu.sct.model.stext.stext.StateRoot
   * @generated
   */
  EClass getStateRoot();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.StateRoot#getDef <em>Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Def</em>'.
   * @see org.yakindu.sct.model.stext.stext.StateRoot#getDef()
   * @see #getStateRoot()
   * @generated
   */
  EReference getStateRoot_Def();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.TransitionRoot <em>Transition Root</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Root</em>'.
   * @see org.yakindu.sct.model.stext.stext.TransitionRoot
   * @generated
   */
  EClass getTransitionRoot();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.TransitionRoot#getDef <em>Def</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Def</em>'.
   * @see org.yakindu.sct.model.stext.stext.TransitionRoot#getDef()
   * @see #getTransitionRoot()
   * @generated
   */
  EReference getTransitionRoot_Def();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.StatechartSpecification <em>Statechart Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statechart Specification</em>'.
   * @see org.yakindu.sct.model.stext.stext.StatechartSpecification
   * @generated
   */
  EClass getStatechartSpecification();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.StateSpecification <em>State Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Specification</em>'.
   * @see org.yakindu.sct.model.stext.stext.StateSpecification
   * @generated
   */
  EClass getStateSpecification();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.StateSpecification#getScope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Scope</em>'.
   * @see org.yakindu.sct.model.stext.stext.StateSpecification#getScope()
   * @see #getStateSpecification()
   * @generated
   */
  EReference getStateSpecification_Scope();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.TransitionSpecification <em>Transition Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Specification</em>'.
   * @see org.yakindu.sct.model.stext.stext.TransitionSpecification
   * @generated
   */
  EClass getTransitionSpecification();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.TransitionSpecification#getReaction <em>Reaction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Reaction</em>'.
   * @see org.yakindu.sct.model.stext.stext.TransitionSpecification#getReaction()
   * @see #getTransitionSpecification()
   * @generated
   */
  EReference getTransitionSpecification_Reaction();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.StatechartScope <em>Statechart Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statechart Scope</em>'.
   * @see org.yakindu.sct.model.stext.stext.StatechartScope
   * @generated
   */
  EClass getStatechartScope();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.InterfaceScope <em>Interface Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Interface Scope</em>'.
   * @see org.yakindu.sct.model.stext.stext.InterfaceScope
   * @generated
   */
  EClass getInterfaceScope();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.InternalScope <em>Internal Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Internal Scope</em>'.
   * @see org.yakindu.sct.model.stext.stext.InternalScope
   * @generated
   */
  EClass getInternalScope();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.EventDefinition <em>Event Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Definition</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventDefinition
   * @generated
   */
  EClass getEventDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.EventDefinition#getDirection <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Direction</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventDefinition#getDirection()
   * @see #getEventDefinition()
   * @generated
   */
  EAttribute getEventDefinition_Direction();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.VariableDefinition <em>Variable Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Definition</em>'.
   * @see org.yakindu.sct.model.stext.stext.VariableDefinition
   * @generated
   */
  EClass getVariableDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.VariableDefinition#isReadonly <em>Readonly</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Readonly</em>'.
   * @see org.yakindu.sct.model.stext.stext.VariableDefinition#isReadonly()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_Readonly();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.VariableDefinition#isExternal <em>External</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>External</em>'.
   * @see org.yakindu.sct.model.stext.stext.VariableDefinition#isExternal()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_External();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.VariableDefinition#getInitialValue <em>Initial Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initial Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.VariableDefinition#getInitialValue()
   * @see #getVariableDefinition()
   * @generated
   */
  EReference getVariableDefinition_InitialValue();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.OperationDefinition <em>Operation Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Definition</em>'.
   * @see org.yakindu.sct.model.stext.stext.OperationDefinition
   * @generated
   */
  EClass getOperationDefinition();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.LocalReaction <em>Local Reaction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Local Reaction</em>'.
   * @see org.yakindu.sct.model.stext.stext.LocalReaction
   * @generated
   */
  EClass getLocalReaction();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.TransitionReaction <em>Transition Reaction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Reaction</em>'.
   * @see org.yakindu.sct.model.stext.stext.TransitionReaction
   * @generated
   */
  EClass getTransitionReaction();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.Guard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Guard</em>'.
   * @see org.yakindu.sct.model.stext.stext.Guard
   * @generated
   */
  EClass getGuard();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.Guard#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.Guard#getExpression()
   * @see #getGuard()
   * @generated
   */
  EReference getGuard_Expression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.EntryPointSpec <em>Entry Point Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry Point Spec</em>'.
   * @see org.yakindu.sct.model.stext.stext.EntryPointSpec
   * @generated
   */
  EClass getEntryPointSpec();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.EntryPointSpec#getEntrypoint <em>Entrypoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Entrypoint</em>'.
   * @see org.yakindu.sct.model.stext.stext.EntryPointSpec#getEntrypoint()
   * @see #getEntryPointSpec()
   * @generated
   */
  EAttribute getEntryPointSpec_Entrypoint();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ExitPointSpec <em>Exit Point Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exit Point Spec</em>'.
   * @see org.yakindu.sct.model.stext.stext.ExitPointSpec
   * @generated
   */
  EClass getExitPointSpec();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.ExitPointSpec#getExitpoint <em>Exitpoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Exitpoint</em>'.
   * @see org.yakindu.sct.model.stext.stext.ExitPointSpec#getExitpoint()
   * @see #getExitPointSpec()
   * @generated
   */
  EAttribute getExitPointSpec_Exitpoint();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.EventSpec <em>Event Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Spec</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventSpec
   * @generated
   */
  EClass getEventSpec();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.RegularEventSpec <em>Regular Event Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Regular Event Spec</em>'.
   * @see org.yakindu.sct.model.stext.stext.RegularEventSpec
   * @generated
   */
  EClass getRegularEventSpec();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.RegularEventSpec#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Event</em>'.
   * @see org.yakindu.sct.model.stext.stext.RegularEventSpec#getEvent()
   * @see #getRegularEventSpec()
   * @generated
   */
  EReference getRegularEventSpec_Event();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.TimeEventSpec <em>Time Event Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Time Event Spec</em>'.
   * @see org.yakindu.sct.model.stext.stext.TimeEventSpec
   * @generated
   */
  EClass getTimeEventSpec();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.TimeEventSpec#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.yakindu.sct.model.stext.stext.TimeEventSpec#getType()
   * @see #getTimeEventSpec()
   * @generated
   */
  EAttribute getTimeEventSpec_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.TimeEventSpec#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.TimeEventSpec#getValue()
   * @see #getTimeEventSpec()
   * @generated
   */
  EReference getTimeEventSpec_Value();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.TimeEventSpec#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unit</em>'.
   * @see org.yakindu.sct.model.stext.stext.TimeEventSpec#getUnit()
   * @see #getTimeEventSpec()
   * @generated
   */
  EAttribute getTimeEventSpec_Unit();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.BuiltinEventSpec <em>Builtin Event Spec</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Builtin Event Spec</em>'.
   * @see org.yakindu.sct.model.stext.stext.BuiltinEventSpec
   * @generated
   */
  EClass getBuiltinEventSpec();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.EntryEvent <em>Entry Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entry Event</em>'.
   * @see org.yakindu.sct.model.stext.stext.EntryEvent
   * @generated
   */
  EClass getEntryEvent();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ExitEvent <em>Exit Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exit Event</em>'.
   * @see org.yakindu.sct.model.stext.stext.ExitEvent
   * @generated
   */
  EClass getExitEvent();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.AlwaysEvent <em>Always Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Always Event</em>'.
   * @see org.yakindu.sct.model.stext.stext.AlwaysEvent
   * @generated
   */
  EClass getAlwaysEvent();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.yakindu.sct.model.stext.stext.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.BoolLiteral <em>Bool Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bool Literal</em>'.
   * @see org.yakindu.sct.model.stext.stext.BoolLiteral
   * @generated
   */
  EClass getBoolLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.BoolLiteral#isValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.BoolLiteral#isValue()
   * @see #getBoolLiteral()
   * @generated
   */
  EAttribute getBoolLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.IntLiteral <em>Int Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Int Literal</em>'.
   * @see org.yakindu.sct.model.stext.stext.IntLiteral
   * @generated
   */
  EClass getIntLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.IntLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.IntLiteral#getValue()
   * @see #getIntLiteral()
   * @generated
   */
  EAttribute getIntLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.RealLiteral <em>Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Literal</em>'.
   * @see org.yakindu.sct.model.stext.stext.RealLiteral
   * @generated
   */
  EClass getRealLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.RealLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.RealLiteral#getValue()
   * @see #getRealLiteral()
   * @generated
   */
  EAttribute getRealLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.HexLiteral <em>Hex Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hex Literal</em>'.
   * @see org.yakindu.sct.model.stext.stext.HexLiteral
   * @generated
   */
  EClass getHexLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.HexLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.HexLiteral#getValue()
   * @see #getHexLiteral()
   * @generated
   */
  EAttribute getHexLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see org.yakindu.sct.model.stext.stext.StringLiteral
   * @generated
   */
  EClass getStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.StringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.StringLiteral#getValue()
   * @see #getStringLiteral()
   * @generated
   */
  EAttribute getStringLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.SimpleScope <em>Simple Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Scope</em>'.
   * @see org.yakindu.sct.model.stext.stext.SimpleScope
   * @generated
   */
  EClass getSimpleScope();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ReactionTrigger <em>Reaction Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reaction Trigger</em>'.
   * @see org.yakindu.sct.model.stext.stext.ReactionTrigger
   * @generated
   */
  EClass getReactionTrigger();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.stext.stext.ReactionTrigger#getTriggers <em>Triggers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Triggers</em>'.
   * @see org.yakindu.sct.model.stext.stext.ReactionTrigger#getTriggers()
   * @see #getReactionTrigger()
   * @generated
   */
  EReference getReactionTrigger_Triggers();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.ReactionTrigger#getGuard <em>Guard</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard</em>'.
   * @see org.yakindu.sct.model.stext.stext.ReactionTrigger#getGuard()
   * @see #getReactionTrigger()
   * @generated
   */
  EReference getReactionTrigger_Guard();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.DefaultTrigger <em>Default Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Default Trigger</em>'.
   * @see org.yakindu.sct.model.stext.stext.DefaultTrigger
   * @generated
   */
  EClass getDefaultTrigger();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ReactionEffect <em>Reaction Effect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reaction Effect</em>'.
   * @see org.yakindu.sct.model.stext.stext.ReactionEffect
   * @generated
   */
  EClass getReactionEffect();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.stext.stext.ReactionEffect#getActions <em>Actions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Actions</em>'.
   * @see org.yakindu.sct.model.stext.stext.ReactionEffect#getActions()
   * @see #getReactionEffect()
   * @generated
   */
  EReference getReactionEffect_Actions();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.EventRaisingExpression <em>Event Raising Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Raising Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventRaisingExpression
   * @generated
   */
  EClass getEventRaisingExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.EventRaisingExpression#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Event</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventRaisingExpression#getEvent()
   * @see #getEventRaisingExpression()
   * @generated
   */
  EReference getEventRaisingExpression_Event();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.EventRaisingExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventRaisingExpression#getValue()
   * @see #getEventRaisingExpression()
   * @generated
   */
  EReference getEventRaisingExpression_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.AssignmentExpression <em>Assignment Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.AssignmentExpression
   * @generated
   */
  EClass getAssignmentExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.AssignmentExpression#getVarRef <em>Var Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Var Ref</em>'.
   * @see org.yakindu.sct.model.stext.stext.AssignmentExpression#getVarRef()
   * @see #getAssignmentExpression()
   * @generated
   */
  EReference getAssignmentExpression_VarRef();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.AssignmentExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.model.stext.stext.AssignmentExpression#getOperator()
   * @see #getAssignmentExpression()
   * @generated
   */
  EAttribute getAssignmentExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.AssignmentExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.AssignmentExpression#getExpression()
   * @see #getAssignmentExpression()
   * @generated
   */
  EReference getAssignmentExpression_Expression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.ConditionalExpression
   * @generated
   */
  EClass getConditionalExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.ConditionalExpression#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.yakindu.sct.model.stext.stext.ConditionalExpression#getCondition()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_Condition();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.ConditionalExpression#getTrueCase <em>True Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>True Case</em>'.
   * @see org.yakindu.sct.model.stext.stext.ConditionalExpression#getTrueCase()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_TrueCase();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.ConditionalExpression#getFalseCase <em>False Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>False Case</em>'.
   * @see org.yakindu.sct.model.stext.stext.ConditionalExpression#getFalseCase()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_FalseCase();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.LogicalOrExpression <em>Logical Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Or Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.LogicalOrExpression
   * @generated
   */
  EClass getLogicalOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.LogicalOrExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.LogicalOrExpression#getLeftOperand()
   * @see #getLogicalOrExpression()
   * @generated
   */
  EReference getLogicalOrExpression_LeftOperand();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.LogicalOrExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.LogicalOrExpression#getRightOperand()
   * @see #getLogicalOrExpression()
   * @generated
   */
  EReference getLogicalOrExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.LogicalAndExpression <em>Logical And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical And Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.LogicalAndExpression
   * @generated
   */
  EClass getLogicalAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.LogicalAndExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.LogicalAndExpression#getLeftOperand()
   * @see #getLogicalAndExpression()
   * @generated
   */
  EReference getLogicalAndExpression_LeftOperand();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.LogicalAndExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.LogicalAndExpression#getRightOperand()
   * @see #getLogicalAndExpression()
   * @generated
   */
  EReference getLogicalAndExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.LogicalNotExpression <em>Logical Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Not Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.LogicalNotExpression
   * @generated
   */
  EClass getLogicalNotExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.LogicalNotExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.LogicalNotExpression#getOperand()
   * @see #getLogicalNotExpression()
   * @generated
   */
  EReference getLogicalNotExpression_Operand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.BitwiseXorExpression <em>Bitwise Xor Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bitwise Xor Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.BitwiseXorExpression
   * @generated
   */
  EClass getBitwiseXorExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.BitwiseXorExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.BitwiseXorExpression#getLeftOperand()
   * @see #getBitwiseXorExpression()
   * @generated
   */
  EReference getBitwiseXorExpression_LeftOperand();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.BitwiseXorExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.BitwiseXorExpression#getRightOperand()
   * @see #getBitwiseXorExpression()
   * @generated
   */
  EReference getBitwiseXorExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.BitwiseOrExpression <em>Bitwise Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bitwise Or Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.BitwiseOrExpression
   * @generated
   */
  EClass getBitwiseOrExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.BitwiseOrExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.BitwiseOrExpression#getLeftOperand()
   * @see #getBitwiseOrExpression()
   * @generated
   */
  EReference getBitwiseOrExpression_LeftOperand();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.BitwiseOrExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.BitwiseOrExpression#getRightOperand()
   * @see #getBitwiseOrExpression()
   * @generated
   */
  EReference getBitwiseOrExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.BitwiseAndExpression <em>Bitwise And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Bitwise And Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.BitwiseAndExpression
   * @generated
   */
  EClass getBitwiseAndExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.BitwiseAndExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.BitwiseAndExpression#getLeftOperand()
   * @see #getBitwiseAndExpression()
   * @generated
   */
  EReference getBitwiseAndExpression_LeftOperand();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.BitwiseAndExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.BitwiseAndExpression#getRightOperand()
   * @see #getBitwiseAndExpression()
   * @generated
   */
  EReference getBitwiseAndExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.LogicalRelationExpression <em>Logical Relation Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Relation Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.LogicalRelationExpression
   * @generated
   */
  EClass getLogicalRelationExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.LogicalRelationExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.LogicalRelationExpression#getLeftOperand()
   * @see #getLogicalRelationExpression()
   * @generated
   */
  EReference getLogicalRelationExpression_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.LogicalRelationExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.model.stext.stext.LogicalRelationExpression#getOperator()
   * @see #getLogicalRelationExpression()
   * @generated
   */
  EAttribute getLogicalRelationExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.LogicalRelationExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.LogicalRelationExpression#getRightOperand()
   * @see #getLogicalRelationExpression()
   * @generated
   */
  EReference getLogicalRelationExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ShiftExpression <em>Shift Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Shift Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.ShiftExpression
   * @generated
   */
  EClass getShiftExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.ShiftExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.ShiftExpression#getLeftOperand()
   * @see #getShiftExpression()
   * @generated
   */
  EReference getShiftExpression_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.ShiftExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.model.stext.stext.ShiftExpression#getOperator()
   * @see #getShiftExpression()
   * @generated
   */
  EAttribute getShiftExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.ShiftExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.ShiftExpression#getRightOperand()
   * @see #getShiftExpression()
   * @generated
   */
  EReference getShiftExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression <em>Numerical Add Subtract Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Add Subtract Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression
   * @generated
   */
  EClass getNumericalAddSubtractExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression#getLeftOperand()
   * @see #getNumericalAddSubtractExpression()
   * @generated
   */
  EReference getNumericalAddSubtractExpression_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression#getOperator()
   * @see #getNumericalAddSubtractExpression()
   * @generated
   */
  EAttribute getNumericalAddSubtractExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression#getRightOperand()
   * @see #getNumericalAddSubtractExpression()
   * @generated
   */
  EReference getNumericalAddSubtractExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression <em>Numerical Multiply Divide Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Multiply Divide Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
   * @generated
   */
  EClass getNumericalMultiplyDivideExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression#getLeftOperand()
   * @see #getNumericalMultiplyDivideExpression()
   * @generated
   */
  EReference getNumericalMultiplyDivideExpression_LeftOperand();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression#getOperator()
   * @see #getNumericalMultiplyDivideExpression()
   * @generated
   */
  EAttribute getNumericalMultiplyDivideExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression#getRightOperand <em>Right Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Right Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression#getRightOperand()
   * @see #getNumericalMultiplyDivideExpression()
   * @generated
   */
  EReference getNumericalMultiplyDivideExpression_RightOperand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.NumericalUnaryExpression <em>Numerical Unary Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Unary Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.NumericalUnaryExpression
   * @generated
   */
  EClass getNumericalUnaryExpression();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.NumericalUnaryExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.yakindu.sct.model.stext.stext.NumericalUnaryExpression#getOperator()
   * @see #getNumericalUnaryExpression()
   * @generated
   */
  EAttribute getNumericalUnaryExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.NumericalUnaryExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.yakindu.sct.model.stext.stext.NumericalUnaryExpression#getOperand()
   * @see #getNumericalUnaryExpression()
   * @generated
   */
  EReference getNumericalUnaryExpression_Operand();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.PrimitiveValueExpression <em>Primitive Value Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Value Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
   * @generated
   */
  EClass getPrimitiveValueExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.PrimitiveValueExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.PrimitiveValueExpression#getValue()
   * @see #getPrimitiveValueExpression()
   * @generated
   */
  EReference getPrimitiveValueExpression_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.FeatureCall <em>Feature Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Call</em>'.
   * @see org.yakindu.sct.model.stext.stext.FeatureCall
   * @generated
   */
  EClass getFeatureCall();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.FeatureCall#getOwner <em>Owner</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owner</em>'.
   * @see org.yakindu.sct.model.stext.stext.FeatureCall#getOwner()
   * @see #getFeatureCall()
   * @generated
   */
  EReference getFeatureCall_Owner();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.model.stext.stext.FeatureCall#getFeature <em>Feature</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Feature</em>'.
   * @see org.yakindu.sct.model.stext.stext.FeatureCall#getFeature()
   * @see #getFeatureCall()
   * @generated
   */
  EReference getFeatureCall_Feature();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.FeatureCall#isOperationCall <em>Operation Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operation Call</em>'.
   * @see org.yakindu.sct.model.stext.stext.FeatureCall#isOperationCall()
   * @see #getFeatureCall()
   * @generated
   */
  EAttribute getFeatureCall_OperationCall();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.stext.stext.FeatureCall#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.yakindu.sct.model.stext.stext.FeatureCall#getArgs()
   * @see #getFeatureCall()
   * @generated
   */
  EReference getFeatureCall_Args();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ElementReferenceExpression <em>Element Reference Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element Reference Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.ElementReferenceExpression
   * @generated
   */
  EClass getElementReferenceExpression();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.model.stext.stext.ElementReferenceExpression#getReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Reference</em>'.
   * @see org.yakindu.sct.model.stext.stext.ElementReferenceExpression#getReference()
   * @see #getElementReferenceExpression()
   * @generated
   */
  EReference getElementReferenceExpression_Reference();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.ElementReferenceExpression#isOperationCall <em>Operation Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operation Call</em>'.
   * @see org.yakindu.sct.model.stext.stext.ElementReferenceExpression#isOperationCall()
   * @see #getElementReferenceExpression()
   * @generated
   */
  EAttribute getElementReferenceExpression_OperationCall();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.stext.stext.ElementReferenceExpression#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.yakindu.sct.model.stext.stext.ElementReferenceExpression#getArgs()
   * @see #getElementReferenceExpression()
   * @generated
   */
  EReference getElementReferenceExpression_Args();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.EventValueReferenceExpression <em>Event Value Reference Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Value Reference Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
   * @generated
   */
  EClass getEventValueReferenceExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.EventValueReferenceExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventValueReferenceExpression#getValue()
   * @see #getEventValueReferenceExpression()
   * @generated
   */
  EReference getEventValueReferenceExpression_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression <em>Active State Reference Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Active State Reference Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
   * @generated
   */
  EClass getActiveStateReferenceExpression();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression#getValue()
   * @see #getActiveStateReferenceExpression()
   * @generated
   */
  EReference getActiveStateReferenceExpression_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ParenthesizedExpression <em>Parenthesized Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parenthesized Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.ParenthesizedExpression
   * @generated
   */
  EClass getParenthesizedExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.ParenthesizedExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.ParenthesizedExpression#getExpression()
   * @see #getParenthesizedExpression()
   * @generated
   */
  EReference getParenthesizedExpression_Expression();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.model.stext.stext.Direction <em>Direction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Direction</em>'.
   * @see org.yakindu.sct.model.stext.stext.Direction
   * @generated
   */
  EEnum getDirection();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.model.stext.stext.TimeEventType <em>Time Event Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Time Event Type</em>'.
   * @see org.yakindu.sct.model.stext.stext.TimeEventType
   * @generated
   */
  EEnum getTimeEventType();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.model.stext.stext.AssignmentOperator <em>Assignment Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Assignment Operator</em>'.
   * @see org.yakindu.sct.model.stext.stext.AssignmentOperator
   * @generated
   */
  EEnum getAssignmentOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.model.stext.stext.ShiftOperator <em>Shift Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Shift Operator</em>'.
   * @see org.yakindu.sct.model.stext.stext.ShiftOperator
   * @generated
   */
  EEnum getShiftOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.model.stext.stext.AdditiveOperator <em>Additive Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Additive Operator</em>'.
   * @see org.yakindu.sct.model.stext.stext.AdditiveOperator
   * @generated
   */
  EEnum getAdditiveOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.model.stext.stext.MultiplicativeOperator <em>Multiplicative Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Multiplicative Operator</em>'.
   * @see org.yakindu.sct.model.stext.stext.MultiplicativeOperator
   * @generated
   */
  EEnum getMultiplicativeOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.model.stext.stext.UnaryOperator <em>Unary Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Unary Operator</em>'.
   * @see org.yakindu.sct.model.stext.stext.UnaryOperator
   * @generated
   */
  EEnum getUnaryOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.model.stext.stext.RelationalOperator <em>Relational Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Relational Operator</em>'.
   * @see org.yakindu.sct.model.stext.stext.RelationalOperator
   * @generated
   */
  EEnum getRelationalOperator();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.model.stext.stext.TimeUnit <em>Time Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Time Unit</em>'.
   * @see org.yakindu.sct.model.stext.stext.TimeUnit
   * @generated
   */
  EEnum getTimeUnit();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  StextFactory getStextFactory();

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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.RootImpl <em>Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.RootImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getRoot()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.DefRootImpl <em>Def Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.DefRootImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getDefRoot()
     * @generated
     */
    EClass DEF_ROOT = eINSTANCE.getDefRoot();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.StatechartRootImpl <em>Statechart Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.StatechartRootImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStatechartRoot()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.StateRootImpl <em>State Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.StateRootImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStateRoot()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.TransitionRootImpl <em>Transition Root</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.TransitionRootImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTransitionRoot()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.StatechartSpecificationImpl <em>Statechart Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.StatechartSpecificationImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStatechartSpecification()
     * @generated
     */
    EClass STATECHART_SPECIFICATION = eINSTANCE.getStatechartSpecification();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.StateSpecificationImpl <em>State Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.StateSpecificationImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStateSpecification()
     * @generated
     */
    EClass STATE_SPECIFICATION = eINSTANCE.getStateSpecification();

    /**
     * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_SPECIFICATION__SCOPE = eINSTANCE.getStateSpecification_Scope();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.TransitionSpecificationImpl <em>Transition Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.TransitionSpecificationImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTransitionSpecification()
     * @generated
     */
    EClass TRANSITION_SPECIFICATION = eINSTANCE.getTransitionSpecification();

    /**
     * The meta object literal for the '<em><b>Reaction</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSITION_SPECIFICATION__REACTION = eINSTANCE.getTransitionSpecification_Reaction();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.StatechartScopeImpl <em>Statechart Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.StatechartScopeImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStatechartScope()
     * @generated
     */
    EClass STATECHART_SCOPE = eINSTANCE.getStatechartScope();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.InterfaceScopeImpl <em>Interface Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.InterfaceScopeImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getInterfaceScope()
     * @generated
     */
    EClass INTERFACE_SCOPE = eINSTANCE.getInterfaceScope();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.InternalScopeImpl <em>Internal Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.InternalScopeImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getInternalScope()
     * @generated
     */
    EClass INTERNAL_SCOPE = eINSTANCE.getInternalScope();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl <em>Event Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventDefinition()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.VariableDefinitionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getVariableDefinition()
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
     * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DEFINITION__INITIAL_VALUE = eINSTANCE.getVariableDefinition_InitialValue();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl <em>Operation Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getOperationDefinition()
     * @generated
     */
    EClass OPERATION_DEFINITION = eINSTANCE.getOperationDefinition();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl <em>Local Reaction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLocalReaction()
     * @generated
     */
    EClass LOCAL_REACTION = eINSTANCE.getLocalReaction();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.TransitionReactionImpl <em>Transition Reaction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.TransitionReactionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTransitionReaction()
     * @generated
     */
    EClass TRANSITION_REACTION = eINSTANCE.getTransitionReaction();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.GuardImpl <em>Guard</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.GuardImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getGuard()
     * @generated
     */
    EClass GUARD = eINSTANCE.getGuard();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference GUARD__EXPRESSION = eINSTANCE.getGuard_Expression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.EntryPointSpecImpl <em>Entry Point Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.EntryPointSpecImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEntryPointSpec()
     * @generated
     */
    EClass ENTRY_POINT_SPEC = eINSTANCE.getEntryPointSpec();

    /**
     * The meta object literal for the '<em><b>Entrypoint</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENTRY_POINT_SPEC__ENTRYPOINT = eINSTANCE.getEntryPointSpec_Entrypoint();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ExitPointSpecImpl <em>Exit Point Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ExitPointSpecImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getExitPointSpec()
     * @generated
     */
    EClass EXIT_POINT_SPEC = eINSTANCE.getExitPointSpec();

    /**
     * The meta object literal for the '<em><b>Exitpoint</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXIT_POINT_SPEC__EXITPOINT = eINSTANCE.getExitPointSpec_Exitpoint();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.EventSpecImpl <em>Event Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.EventSpecImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventSpec()
     * @generated
     */
    EClass EVENT_SPEC = eINSTANCE.getEventSpec();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.RegularEventSpecImpl <em>Regular Event Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.RegularEventSpecImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getRegularEventSpec()
     * @generated
     */
    EClass REGULAR_EVENT_SPEC = eINSTANCE.getRegularEventSpec();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REGULAR_EVENT_SPEC__EVENT = eINSTANCE.getRegularEventSpec_Event();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.TimeEventSpecImpl <em>Time Event Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.TimeEventSpecImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTimeEventSpec()
     * @generated
     */
    EClass TIME_EVENT_SPEC = eINSTANCE.getTimeEventSpec();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_EVENT_SPEC__TYPE = eINSTANCE.getTimeEventSpec_Type();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TIME_EVENT_SPEC__VALUE = eINSTANCE.getTimeEventSpec_Value();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TIME_EVENT_SPEC__UNIT = eINSTANCE.getTimeEventSpec_Unit();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.BuiltinEventSpecImpl <em>Builtin Event Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.BuiltinEventSpecImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getBuiltinEventSpec()
     * @generated
     */
    EClass BUILTIN_EVENT_SPEC = eINSTANCE.getBuiltinEventSpec();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.EntryEventImpl <em>Entry Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.EntryEventImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEntryEvent()
     * @generated
     */
    EClass ENTRY_EVENT = eINSTANCE.getEntryEvent();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ExitEventImpl <em>Exit Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ExitEventImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getExitEvent()
     * @generated
     */
    EClass EXIT_EVENT = eINSTANCE.getExitEvent();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.AlwaysEventImpl <em>Always Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.AlwaysEventImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getAlwaysEvent()
     * @generated
     */
    EClass ALWAYS_EVENT = eINSTANCE.getAlwaysEvent();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.LiteralImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.BoolLiteralImpl <em>Bool Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.BoolLiteralImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getBoolLiteral()
     * @generated
     */
    EClass BOOL_LITERAL = eINSTANCE.getBoolLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOL_LITERAL__VALUE = eINSTANCE.getBoolLiteral_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.IntLiteralImpl <em>Int Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.IntLiteralImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getIntLiteral()
     * @generated
     */
    EClass INT_LITERAL = eINSTANCE.getIntLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INT_LITERAL__VALUE = eINSTANCE.getIntLiteral_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.RealLiteralImpl <em>Real Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.RealLiteralImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getRealLiteral()
     * @generated
     */
    EClass REAL_LITERAL = eINSTANCE.getRealLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REAL_LITERAL__VALUE = eINSTANCE.getRealLiteral_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.HexLiteralImpl <em>Hex Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.HexLiteralImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getHexLiteral()
     * @generated
     */
    EClass HEX_LITERAL = eINSTANCE.getHexLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute HEX_LITERAL__VALUE = eINSTANCE.getHexLiteral_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.StringLiteralImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStringLiteral()
     * @generated
     */
    EClass STRING_LITERAL = eINSTANCE.getStringLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_LITERAL__VALUE = eINSTANCE.getStringLiteral_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.SimpleScopeImpl <em>Simple Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.SimpleScopeImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getSimpleScope()
     * @generated
     */
    EClass SIMPLE_SCOPE = eINSTANCE.getSimpleScope();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionTriggerImpl <em>Reaction Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ReactionTriggerImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReactionTrigger()
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
     * The meta object literal for the '<em><b>Guard</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REACTION_TRIGGER__GUARD = eINSTANCE.getReactionTrigger_Guard();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.DefaultTriggerImpl <em>Default Trigger</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.DefaultTriggerImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getDefaultTrigger()
     * @generated
     */
    EClass DEFAULT_TRIGGER = eINSTANCE.getDefaultTrigger();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionEffectImpl <em>Reaction Effect</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ReactionEffectImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReactionEffect()
     * @generated
     */
    EClass REACTION_EFFECT = eINSTANCE.getReactionEffect();

    /**
     * The meta object literal for the '<em><b>Actions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REACTION_EFFECT__ACTIONS = eINSTANCE.getReactionEffect_Actions();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.EventRaisingExpressionImpl <em>Event Raising Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.EventRaisingExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventRaisingExpression()
     * @generated
     */
    EClass EVENT_RAISING_EXPRESSION = eINSTANCE.getEventRaisingExpression();

    /**
     * The meta object literal for the '<em><b>Event</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_RAISING_EXPRESSION__EVENT = eINSTANCE.getEventRaisingExpression_Event();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_RAISING_EXPRESSION__VALUE = eINSTANCE.getEventRaisingExpression_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.AssignmentExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getAssignmentExpression()
     * @generated
     */
    EClass ASSIGNMENT_EXPRESSION = eINSTANCE.getAssignmentExpression();

    /**
     * The meta object literal for the '<em><b>Var Ref</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_EXPRESSION__VAR_REF = eINSTANCE.getAssignmentExpression_VarRef();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ASSIGNMENT_EXPRESSION__OPERATOR = eINSTANCE.getAssignmentExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ASSIGNMENT_EXPRESSION__EXPRESSION = eINSTANCE.getAssignmentExpression_Expression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ConditionalExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getConditionalExpression()
     * @generated
     */
    EClass CONDITIONAL_EXPRESSION = eINSTANCE.getConditionalExpression();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__CONDITION = eINSTANCE.getConditionalExpression_Condition();

    /**
     * The meta object literal for the '<em><b>True Case</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__TRUE_CASE = eINSTANCE.getConditionalExpression_TrueCase();

    /**
     * The meta object literal for the '<em><b>False Case</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__FALSE_CASE = eINSTANCE.getConditionalExpression_FalseCase();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.LogicalOrExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLogicalOrExpression()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.LogicalAndExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLogicalAndExpression()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.LogicalNotExpressionImpl <em>Logical Not Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.LogicalNotExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLogicalNotExpression()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.BitwiseXorExpressionImpl <em>Bitwise Xor Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.BitwiseXorExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getBitwiseXorExpression()
     * @generated
     */
    EClass BITWISE_XOR_EXPRESSION = eINSTANCE.getBitwiseXorExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_XOR_EXPRESSION__LEFT_OPERAND = eINSTANCE.getBitwiseXorExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_XOR_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getBitwiseXorExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.BitwiseOrExpressionImpl <em>Bitwise Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.BitwiseOrExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getBitwiseOrExpression()
     * @generated
     */
    EClass BITWISE_OR_EXPRESSION = eINSTANCE.getBitwiseOrExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_OR_EXPRESSION__LEFT_OPERAND = eINSTANCE.getBitwiseOrExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_OR_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getBitwiseOrExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.BitwiseAndExpressionImpl <em>Bitwise And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.BitwiseAndExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getBitwiseAndExpression()
     * @generated
     */
    EClass BITWISE_AND_EXPRESSION = eINSTANCE.getBitwiseAndExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_AND_EXPRESSION__LEFT_OPERAND = eINSTANCE.getBitwiseAndExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BITWISE_AND_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getBitwiseAndExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.LogicalRelationExpressionImpl <em>Logical Relation Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.LogicalRelationExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLogicalRelationExpression()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ShiftExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getShiftExpression()
     * @generated
     */
    EClass SHIFT_EXPRESSION = eINSTANCE.getShiftExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHIFT_EXPRESSION__LEFT_OPERAND = eINSTANCE.getShiftExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SHIFT_EXPRESSION__OPERATOR = eINSTANCE.getShiftExpression_Operator();

    /**
     * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SHIFT_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getShiftExpression_RightOperand();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.NumericalAddSubtractExpressionImpl <em>Numerical Add Subtract Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.NumericalAddSubtractExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getNumericalAddSubtractExpression()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.NumericalMultiplyDivideExpressionImpl <em>Numerical Multiply Divide Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.NumericalMultiplyDivideExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getNumericalMultiplyDivideExpression()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.NumericalUnaryExpressionImpl <em>Numerical Unary Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.NumericalUnaryExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getNumericalUnaryExpression()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.PrimitiveValueExpressionImpl <em>Primitive Value Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.PrimitiveValueExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getPrimitiveValueExpression()
     * @generated
     */
    EClass PRIMITIVE_VALUE_EXPRESSION = eINSTANCE.getPrimitiveValueExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PRIMITIVE_VALUE_EXPRESSION__VALUE = eINSTANCE.getPrimitiveValueExpression_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.FeatureCallImpl <em>Feature Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.FeatureCallImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getFeatureCall()
     * @generated
     */
    EClass FEATURE_CALL = eINSTANCE.getFeatureCall();

    /**
     * The meta object literal for the '<em><b>Owner</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_CALL__OWNER = eINSTANCE.getFeatureCall_Owner();

    /**
     * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_CALL__FEATURE = eINSTANCE.getFeatureCall_Feature();

    /**
     * The meta object literal for the '<em><b>Operation Call</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE_CALL__OPERATION_CALL = eINSTANCE.getFeatureCall_OperationCall();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_CALL__ARGS = eINSTANCE.getFeatureCall_Args();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ElementReferenceExpressionImpl <em>Element Reference Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ElementReferenceExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getElementReferenceExpression()
     * @generated
     */
    EClass ELEMENT_REFERENCE_EXPRESSION = eINSTANCE.getElementReferenceExpression();

    /**
     * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_REFERENCE_EXPRESSION__REFERENCE = eINSTANCE.getElementReferenceExpression_Reference();

    /**
     * The meta object literal for the '<em><b>Operation Call</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ELEMENT_REFERENCE_EXPRESSION__OPERATION_CALL = eINSTANCE.getElementReferenceExpression_OperationCall();

    /**
     * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_REFERENCE_EXPRESSION__ARGS = eINSTANCE.getElementReferenceExpression_Args();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.EventValueReferenceExpressionImpl <em>Event Value Reference Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.EventValueReferenceExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventValueReferenceExpression()
     * @generated
     */
    EClass EVENT_VALUE_REFERENCE_EXPRESSION = eINSTANCE.getEventValueReferenceExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EVENT_VALUE_REFERENCE_EXPRESSION__VALUE = eINSTANCE.getEventValueReferenceExpression_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ActiveStateReferenceExpressionImpl <em>Active State Reference Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ActiveStateReferenceExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getActiveStateReferenceExpression()
     * @generated
     */
    EClass ACTIVE_STATE_REFERENCE_EXPRESSION = eINSTANCE.getActiveStateReferenceExpression();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ACTIVE_STATE_REFERENCE_EXPRESSION__VALUE = eINSTANCE.getActiveStateReferenceExpression_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ParenthesizedExpressionImpl <em>Parenthesized Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ParenthesizedExpressionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getParenthesizedExpression()
     * @generated
     */
    EClass PARENTHESIZED_EXPRESSION = eINSTANCE.getParenthesizedExpression();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARENTHESIZED_EXPRESSION__EXPRESSION = eINSTANCE.getParenthesizedExpression_Expression();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.Direction <em>Direction</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.Direction
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getDirection()
     * @generated
     */
    EEnum DIRECTION = eINSTANCE.getDirection();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.TimeEventType <em>Time Event Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.TimeEventType
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTimeEventType()
     * @generated
     */
    EEnum TIME_EVENT_TYPE = eINSTANCE.getTimeEventType();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.AssignmentOperator <em>Assignment Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.AssignmentOperator
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getAssignmentOperator()
     * @generated
     */
    EEnum ASSIGNMENT_OPERATOR = eINSTANCE.getAssignmentOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.ShiftOperator <em>Shift Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.ShiftOperator
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getShiftOperator()
     * @generated
     */
    EEnum SHIFT_OPERATOR = eINSTANCE.getShiftOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.AdditiveOperator <em>Additive Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.AdditiveOperator
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getAdditiveOperator()
     * @generated
     */
    EEnum ADDITIVE_OPERATOR = eINSTANCE.getAdditiveOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.MultiplicativeOperator
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getMultiplicativeOperator()
     * @generated
     */
    EEnum MULTIPLICATIVE_OPERATOR = eINSTANCE.getMultiplicativeOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.UnaryOperator <em>Unary Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.UnaryOperator
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getUnaryOperator()
     * @generated
     */
    EEnum UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.RelationalOperator <em>Relational Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.RelationalOperator
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getRelationalOperator()
     * @generated
     */
    EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.TimeUnit <em>Time Unit</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.TimeUnit
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTimeUnit()
     * @generated
     */
    EEnum TIME_UNIT = eINSTANCE.getTimeUnit();

  }

} //StextPackage
