/**
 * <copyright>
 * </copyright>
 *

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.StatechartDefinitionImpl <em>Statechart Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.StatechartDefinitionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStatechartDefinition()
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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.StateDeclarationImpl <em>State Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.StateDeclarationImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStateDeclaration()
   * @generated
   */
  int STATE_DECLARATION = 6;

  /**
   * The feature id for the '<em><b>Scope</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_DECLARATION__SCOPE = 0;

  /**
   * The number of structural features of the '<em>State Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.TransitionStatementImpl <em>Transition Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.TransitionStatementImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTransitionStatement()
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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EventDerivationImpl <em>Event Derivation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EventDerivationImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventDerivation()
   * @generated
   */
  int EVENT_DERIVATION = 8;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionImpl <em>Reaction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ReactionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReaction()
   * @generated
   */
  int REACTION = 9;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl <em>Local Reaction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLocalReaction()
   * @generated
   */
  int LOCAL_REACTION = 10;

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
   * The feature id for the '<em><b>Properties</b></em>' containment reference.
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
  int TRANSITION_REACTION = 11;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionPropertiesImpl <em>Reaction Properties</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ReactionPropertiesImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReactionProperties()
   * @generated
   */
  int REACTION_PROPERTIES = 12;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionPropertyImpl <em>Reaction Property</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ReactionPropertyImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReactionProperty()
   * @generated
   */
  int REACTION_PROPERTY = 13;

  /**
   * The number of structural features of the '<em>Reaction Property</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_PROPERTY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionPriorityImpl <em>Reaction Priority</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ReactionPriorityImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReactionPriority()
   * @generated
   */
  int REACTION_PRIORITY = 14;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EntryPointSpecImpl <em>Entry Point Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EntryPointSpecImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEntryPointSpec()
   * @generated
   */
  int ENTRY_POINT_SPEC = 15;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ExitPointSpecImpl <em>Exit Point Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ExitPointSpecImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getExitPointSpec()
   * @generated
   */
  int EXIT_POINT_SPEC = 16;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EventSpecImpl <em>Event Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EventSpecImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventSpec()
   * @generated
   */
  int EVENT_SPEC = 17;

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
  int REGULAR_EVENT_SPEC = 18;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.TimeEventSpecImpl <em>Time Event Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.TimeEventSpecImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTimeEventSpec()
   * @generated
   */
  int TIME_EVENT_SPEC = 19;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.BuiltinEventSpecImpl <em>Builtin Event Spec</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.BuiltinEventSpecImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getBuiltinEventSpec()
   * @generated
   */
  int BUILTIN_EVENT_SPEC = 20;

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
  int ENTRY_EVENT = 21;

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
  int EXIT_EVENT = 22;

  /**
   * The number of structural features of the '<em>Exit Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXIT_EVENT_FEATURE_COUNT = BUILTIN_EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.OnCycleEventImpl <em>On Cycle Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.OnCycleEventImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getOnCycleEvent()
   * @generated
   */
  int ON_CYCLE_EVENT = 23;

  /**
   * The number of structural features of the '<em>On Cycle Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ON_CYCLE_EVENT_FEATURE_COUNT = BUILTIN_EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.AlwaysEventImpl <em>Always Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.AlwaysEventImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getAlwaysEvent()
   * @generated
   */
  int ALWAYS_EVENT = 24;

  /**
   * The number of structural features of the '<em>Always Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ALWAYS_EVENT_FEATURE_COUNT = BUILTIN_EVENT_SPEC_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.StatementImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 25;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.AssignmentImpl <em>Assignment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.AssignmentImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getAssignment()
   * @generated
   */
  int ASSIGNMENT = 26;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EventRaisingImpl <em>Event Raising</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EventRaisingImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventRaising()
   * @generated
   */
  int EVENT_RAISING = 27;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.OperationCallStatementImpl <em>Operation Call Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.OperationCallStatementImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getOperationCallStatement()
   * @generated
   */
  int OPERATION_CALL_STATEMENT = 28;

  /**
   * The feature id for the '<em><b>Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL_STATEMENT__CALL = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Operation Call Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 29;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.SimpleScopeImpl <em>Simple Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.SimpleScopeImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getSimpleScope()
   * @generated
   */
  int SIMPLE_SCOPE = 30;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.InterfaceScopeImpl <em>Interface Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.InterfaceScopeImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getInterfaceScope()
   * @generated
   */
  int INTERFACE_SCOPE = 31;

  /**
   * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE__DECLARATIONS = SGraphPackage.SCOPE__DECLARATIONS;

  /**
   * The feature id for the '<em><b>Events</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE__EVENTS = SGraphPackage.SCOPE__EVENTS;

  /**
   * The feature id for the '<em><b>Variables</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE__VARIABLES = SGraphPackage.SCOPE__VARIABLES;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE__NAME = SGraphPackage.SCOPE_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Interface Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERFACE_SCOPE_FEATURE_COUNT = SGraphPackage.SCOPE_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.InternalScopeImpl <em>Internal Scope</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.InternalScopeImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getInternalScope()
   * @generated
   */
  int INTERNAL_SCOPE = 32;

  /**
   * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_SCOPE__DECLARATIONS = SGraphPackage.SCOPE__DECLARATIONS;

  /**
   * The feature id for the '<em><b>Events</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_SCOPE__EVENTS = SGraphPackage.SCOPE__EVENTS;

  /**
   * The feature id for the '<em><b>Variables</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_SCOPE__VARIABLES = SGraphPackage.SCOPE__VARIABLES;

  /**
   * The number of structural features of the '<em>Internal Scope</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTERNAL_SCOPE_FEATURE_COUNT = SGraphPackage.SCOPE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl <em>Event Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventDefinition()
   * @generated
   */
  int EVENT_DEFINITION = 33;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__NAME = SGraphPackage.EVENT__NAME;

  /**
   * The feature id for the '<em><b>Direction</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__DIRECTION = SGraphPackage.EVENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__TYPE = SGraphPackage.EVENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Derivation</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EVENT_DEFINITION__DERIVATION = SGraphPackage.EVENT_FEATURE_COUNT + 2;

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
  int VARIABLE_DEFINITION = 34;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__NAME = SGraphPackage.VARIABLE__NAME;

  /**
   * The feature id for the '<em><b>Readonly</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__READONLY = SGraphPackage.VARIABLE_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>External</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__EXTERNAL = SGraphPackage.VARIABLE_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__TYPE = SGraphPackage.VARIABLE_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Initial Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION__INITIAL_VALUE = SGraphPackage.VARIABLE_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Variable Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DEFINITION_FEATURE_COUNT = SGraphPackage.VARIABLE_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ClockImpl <em>Clock</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ClockImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getClock()
   * @generated
   */
  int CLOCK = 35;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK__NAME = SGraphPackage.DECLARATION__NAME;

  /**
   * The number of structural features of the '<em>Clock</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLOCK_FEATURE_COUNT = SGraphPackage.DECLARATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.OperationImpl <em>Operation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.OperationImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getOperation()
   * @generated
   */
  int OPERATION = 36;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__NAME = SGraphPackage.DECLARATION__NAME;

  /**
   * The feature id for the '<em><b>Param Types</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__PARAM_TYPES = SGraphPackage.DECLARATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION__TYPE = SGraphPackage.DECLARATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Operation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_FEATURE_COUNT = SGraphPackage.DECLARATION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EntrypointImpl <em>Entrypoint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EntrypointImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEntrypoint()
   * @generated
   */
  int ENTRYPOINT = 37;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRYPOINT__NAME = SGraphPackage.DECLARATION__NAME;

  /**
   * The number of structural features of the '<em>Entrypoint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTRYPOINT_FEATURE_COUNT = SGraphPackage.DECLARATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ExitpointImpl <em>Exitpoint</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ExitpointImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getExitpoint()
   * @generated
   */
  int EXITPOINT = 38;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXITPOINT__NAME = SGraphPackage.DECLARATION__NAME;

  /**
   * The number of structural features of the '<em>Exitpoint</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXITPOINT_FEATURE_COUNT = SGraphPackage.DECLARATION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionTriggerImpl <em>Reaction Trigger</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ReactionTriggerImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReactionTrigger()
   * @generated
   */
  int REACTION_TRIGGER = 39;

  /**
   * The feature id for the '<em><b>Triggers</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_TRIGGER__TRIGGERS = SGraphPackage.TRIGGER_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Guard Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_TRIGGER__GUARD_EXPRESSION = SGraphPackage.TRIGGER_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Reaction Trigger</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REACTION_TRIGGER_FEATURE_COUNT = SGraphPackage.TRIGGER_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionEffectImpl <em>Reaction Effect</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ReactionEffectImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReactionEffect()
   * @generated
   */
  int REACTION_EFFECT = 40;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EnterEventImpl <em>Enter Event</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.EnterEventImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEnterEvent()
   * @generated
   */
  int ENTER_EVENT = 41;

  /**
   * The number of structural features of the '<em>Enter Event</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENTER_EVENT_FEATURE_COUNT = ENTRY_EVENT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.LogicalOrExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLogicalOrExpression()
   * @generated
   */
  int LOGICAL_OR_EXPRESSION = 42;

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
  int LOGICAL_AND_EXPRESSION = 43;

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
  int LOGICAL_NOT_EXPRESSION = 44;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.LogicalRelationExpressionImpl <em>Logical Relation Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.LogicalRelationExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLogicalRelationExpression()
   * @generated
   */
  int LOGICAL_RELATION_EXPRESSION = 45;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.NumericalAddSubtractExpressionImpl <em>Numerical Add Subtract Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.NumericalAddSubtractExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getNumericalAddSubtractExpression()
   * @generated
   */
  int NUMERICAL_ADD_SUBTRACT_EXPRESSION = 46;

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
  int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION = 47;

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
  int NUMERICAL_UNARY_EXPRESSION = 48;

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
  int PRIMITIVE_VALUE_EXPRESSION = 49;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ElementReferenceExpressionImpl <em>Element Reference Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.ElementReferenceExpressionImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getElementReferenceExpression()
   * @generated
   */
  int ELEMENT_REFERENCE_EXPRESSION = 50;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.OperationCallImpl <em>Operation Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.impl.OperationCallImpl
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getOperationCall()
   * @generated
   */
  int OPERATION_CALL = 51;

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
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.Direction <em>Direction</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.Direction
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getDirection()
   * @generated
   */
  int DIRECTION = 52;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.AdditiveOperator <em>Additive Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.AdditiveOperator
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getAdditiveOperator()
   * @generated
   */
  int ADDITIVE_OPERATOR = 53;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.MultiplicativeOperator
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getMultiplicativeOperator()
   * @generated
   */
  int MULTIPLICATIVE_OPERATOR = 54;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.UnaryOperator <em>Unary Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.UnaryOperator
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getUnaryOperator()
   * @generated
   */
  int UNARY_OPERATOR = 55;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.RelationalOperator
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getRelationalOperator()
   * @generated
   */
  int RELATIONAL_OPERATOR = 56;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.TimeUnit <em>Time Unit</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.TimeUnit
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTimeUnit()
   * @generated
   */
  int TIME_UNIT = 57;

  /**
   * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.Type <em>Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.model.stext.stext.Type
   * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getType()
   * @generated
   */
  int TYPE = 58;


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
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.StatechartDefinition <em>Statechart Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statechart Definition</em>'.
   * @see org.yakindu.sct.model.stext.stext.StatechartDefinition
   * @generated
   */
  EClass getStatechartDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.stext.stext.StatechartDefinition#getDefinitionScopes <em>Definition Scopes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definition Scopes</em>'.
   * @see org.yakindu.sct.model.stext.stext.StatechartDefinition#getDefinitionScopes()
   * @see #getStatechartDefinition()
   * @generated
   */
  EReference getStatechartDefinition_DefinitionScopes();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.StateDeclaration <em>State Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>State Declaration</em>'.
   * @see org.yakindu.sct.model.stext.stext.StateDeclaration
   * @generated
   */
  EClass getStateDeclaration();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.StateDeclaration#getScope <em>Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Scope</em>'.
   * @see org.yakindu.sct.model.stext.stext.StateDeclaration#getScope()
   * @see #getStateDeclaration()
   * @generated
   */
  EReference getStateDeclaration_Scope();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.TransitionStatement <em>Transition Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transition Statement</em>'.
   * @see org.yakindu.sct.model.stext.stext.TransitionStatement
   * @generated
   */
  EClass getTransitionStatement();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.EventDerivation <em>Event Derivation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Derivation</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventDerivation
   * @generated
   */
  EClass getEventDerivation();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.EventDerivation#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventDerivation#getCondition()
   * @see #getEventDerivation()
   * @generated
   */
  EReference getEventDerivation_Condition();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.EventDerivation#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventDerivation#getValue()
   * @see #getEventDerivation()
   * @generated
   */
  EReference getEventDerivation_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.Reaction <em>Reaction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reaction</em>'.
   * @see org.yakindu.sct.model.stext.stext.Reaction
   * @generated
   */
  EClass getReaction();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.Reaction#getTrigger <em>Trigger</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Trigger</em>'.
   * @see org.yakindu.sct.model.stext.stext.Reaction#getTrigger()
   * @see #getReaction()
   * @generated
   */
  EReference getReaction_Trigger();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.Reaction#getEffect <em>Effect</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Effect</em>'.
   * @see org.yakindu.sct.model.stext.stext.Reaction#getEffect()
   * @see #getReaction()
   * @generated
   */
  EReference getReaction_Effect();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.Reaction#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Properties</em>'.
   * @see org.yakindu.sct.model.stext.stext.Reaction#getProperties()
   * @see #getReaction()
   * @generated
   */
  EReference getReaction_Properties();

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
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ReactionProperties <em>Reaction Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reaction Properties</em>'.
   * @see org.yakindu.sct.model.stext.stext.ReactionProperties
   * @generated
   */
  EClass getReactionProperties();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.stext.stext.ReactionProperties#getProperties <em>Properties</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Properties</em>'.
   * @see org.yakindu.sct.model.stext.stext.ReactionProperties#getProperties()
   * @see #getReactionProperties()
   * @generated
   */
  EReference getReactionProperties_Properties();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ReactionProperty <em>Reaction Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reaction Property</em>'.
   * @see org.yakindu.sct.model.stext.stext.ReactionProperty
   * @generated
   */
  EClass getReactionProperty();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ReactionPriority <em>Reaction Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Reaction Priority</em>'.
   * @see org.yakindu.sct.model.stext.stext.ReactionPriority
   * @generated
   */
  EClass getReactionPriority();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.ReactionPriority#getPriority <em>Priority</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Priority</em>'.
   * @see org.yakindu.sct.model.stext.stext.ReactionPriority#getPriority()
   * @see #getReactionPriority()
   * @generated
   */
  EAttribute getReactionPriority_Priority();

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
   * Returns the meta object for the reference '{@link org.yakindu.sct.model.stext.stext.EntryPointSpec#getEntrypoint <em>Entrypoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Entrypoint</em>'.
   * @see org.yakindu.sct.model.stext.stext.EntryPointSpec#getEntrypoint()
   * @see #getEntryPointSpec()
   * @generated
   */
  EReference getEntryPointSpec_Entrypoint();

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
   * Returns the meta object for the reference '{@link org.yakindu.sct.model.stext.stext.ExitPointSpec#getExitpoint <em>Exitpoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Exitpoint</em>'.
   * @see org.yakindu.sct.model.stext.stext.ExitPointSpec#getExitpoint()
   * @see #getExitPointSpec()
   * @generated
   */
  EReference getExitPointSpec_Exitpoint();

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
   * Returns the meta object for the reference '{@link org.yakindu.sct.model.stext.stext.RegularEventSpec#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Event</em>'.
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
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.TimeEventSpec#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.TimeEventSpec#getValue()
   * @see #getTimeEventSpec()
   * @generated
   */
  EAttribute getTimeEventSpec_Value();

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
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.OnCycleEvent <em>On Cycle Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>On Cycle Event</em>'.
   * @see org.yakindu.sct.model.stext.stext.OnCycleEvent
   * @generated
   */
  EClass getOnCycleEvent();

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
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.Statement <em>Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Statement</em>'.
   * @see org.yakindu.sct.model.stext.stext.Statement
   * @generated
   */
  EClass getStatement();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.Assignment <em>Assignment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Assignment</em>'.
   * @see org.yakindu.sct.model.stext.stext.Assignment
   * @generated
   */
  EClass getAssignment();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.model.stext.stext.Assignment#getVarRef <em>Var Ref</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Var Ref</em>'.
   * @see org.yakindu.sct.model.stext.stext.Assignment#getVarRef()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_VarRef();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.Assignment#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.Assignment#getExpression()
   * @see #getAssignment()
   * @generated
   */
  EReference getAssignment_Expression();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.EventRaising <em>Event Raising</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Event Raising</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventRaising
   * @generated
   */
  EClass getEventRaising();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.model.stext.stext.EventRaising#getEvent <em>Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Event</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventRaising#getEvent()
   * @see #getEventRaising()
   * @generated
   */
  EReference getEventRaising_Event();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.EventRaising#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventRaising#getValue()
   * @see #getEventRaising()
   * @generated
   */
  EReference getEventRaising_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.OperationCallStatement <em>Operation Call Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Call Statement</em>'.
   * @see org.yakindu.sct.model.stext.stext.OperationCallStatement
   * @generated
   */
  EClass getOperationCallStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.OperationCallStatement#getCall <em>Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Call</em>'.
   * @see org.yakindu.sct.model.stext.stext.OperationCallStatement#getCall()
   * @see #getOperationCallStatement()
   * @generated
   */
  EReference getOperationCallStatement_Call();

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
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.SimpleScope <em>Simple Scope</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Scope</em>'.
   * @see org.yakindu.sct.model.stext.stext.SimpleScope
   * @generated
   */
  EClass getSimpleScope();

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
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.InterfaceScope#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.yakindu.sct.model.stext.stext.InterfaceScope#getName()
   * @see #getInterfaceScope()
   * @generated
   */
  EAttribute getInterfaceScope_Name();

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
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.EventDefinition#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventDefinition#getType()
   * @see #getEventDefinition()
   * @generated
   */
  EAttribute getEventDefinition_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.EventDefinition#getDerivation <em>Derivation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Derivation</em>'.
   * @see org.yakindu.sct.model.stext.stext.EventDefinition#getDerivation()
   * @see #getEventDefinition()
   * @generated
   */
  EReference getEventDefinition_Derivation();

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
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.VariableDefinition#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.yakindu.sct.model.stext.stext.VariableDefinition#getType()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_Type();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.VariableDefinition#getInitialValue <em>Initial Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Initial Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.VariableDefinition#getInitialValue()
   * @see #getVariableDefinition()
   * @generated
   */
  EAttribute getVariableDefinition_InitialValue();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.Clock <em>Clock</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Clock</em>'.
   * @see org.yakindu.sct.model.stext.stext.Clock
   * @generated
   */
  EClass getClock();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.Operation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation</em>'.
   * @see org.yakindu.sct.model.stext.stext.Operation
   * @generated
   */
  EClass getOperation();

  /**
   * Returns the meta object for the attribute list '{@link org.yakindu.sct.model.stext.stext.Operation#getParamTypes <em>Param Types</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Param Types</em>'.
   * @see org.yakindu.sct.model.stext.stext.Operation#getParamTypes()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_ParamTypes();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.Operation#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.yakindu.sct.model.stext.stext.Operation#getType()
   * @see #getOperation()
   * @generated
   */
  EAttribute getOperation_Type();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.Entrypoint <em>Entrypoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Entrypoint</em>'.
   * @see org.yakindu.sct.model.stext.stext.Entrypoint
   * @generated
   */
  EClass getEntrypoint();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.Exitpoint <em>Exitpoint</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exitpoint</em>'.
   * @see org.yakindu.sct.model.stext.stext.Exitpoint
   * @generated
   */
  EClass getExitpoint();

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
   * Returns the meta object for the containment reference '{@link org.yakindu.sct.model.stext.stext.ReactionTrigger#getGuardExpression <em>Guard Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Guard Expression</em>'.
   * @see org.yakindu.sct.model.stext.stext.ReactionTrigger#getGuardExpression()
   * @see #getReactionTrigger()
   * @generated
   */
  EReference getReactionTrigger_GuardExpression();

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
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.EnterEvent <em>Enter Event</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enter Event</em>'.
   * @see org.yakindu.sct.model.stext.stext.EnterEvent
   * @generated
   */
  EClass getEnterEvent();

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
   * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.PrimitiveValueExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.PrimitiveValueExpression#getValue()
   * @see #getPrimitiveValueExpression()
   * @generated
   */
  EAttribute getPrimitiveValueExpression_Value();

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
   * Returns the meta object for the reference '{@link org.yakindu.sct.model.stext.stext.ElementReferenceExpression#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Value</em>'.
   * @see org.yakindu.sct.model.stext.stext.ElementReferenceExpression#getValue()
   * @see #getElementReferenceExpression()
   * @generated
   */
  EReference getElementReferenceExpression_Value();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.OperationCall <em>Operation Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Call</em>'.
   * @see org.yakindu.sct.model.stext.stext.OperationCall
   * @generated
   */
  EClass getOperationCall();

  /**
   * Returns the meta object for the reference '{@link org.yakindu.sct.model.stext.stext.OperationCall#getOperation <em>Operation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Operation</em>'.
   * @see org.yakindu.sct.model.stext.stext.OperationCall#getOperation()
   * @see #getOperationCall()
   * @generated
   */
  EReference getOperationCall_Operation();

  /**
   * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.stext.stext.OperationCall#getArgs <em>Args</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Args</em>'.
   * @see org.yakindu.sct.model.stext.stext.OperationCall#getArgs()
   * @see #getOperationCall()
   * @generated
   */
  EReference getOperationCall_Args();

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
   * Returns the meta object for enum '{@link org.yakindu.sct.model.stext.stext.Type <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Type</em>'.
   * @see org.yakindu.sct.model.stext.stext.Type
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.StatechartDefinitionImpl <em>Statechart Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.StatechartDefinitionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStatechartDefinition()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.StateDeclarationImpl <em>State Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.StateDeclarationImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStateDeclaration()
     * @generated
     */
    EClass STATE_DECLARATION = eINSTANCE.getStateDeclaration();

    /**
     * The meta object literal for the '<em><b>Scope</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference STATE_DECLARATION__SCOPE = eINSTANCE.getStateDeclaration_Scope();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.TransitionStatementImpl <em>Transition Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.TransitionStatementImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTransitionStatement()
     * @generated
     */
    EClass TRANSITION_STATEMENT = eINSTANCE.getTransitionStatement();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.EventDerivationImpl <em>Event Derivation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.EventDerivationImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventDerivation()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionImpl <em>Reaction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ReactionImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReaction()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionPropertiesImpl <em>Reaction Properties</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ReactionPropertiesImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReactionProperties()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionPropertyImpl <em>Reaction Property</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ReactionPropertyImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReactionProperty()
     * @generated
     */
    EClass REACTION_PROPERTY = eINSTANCE.getReactionProperty();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ReactionPriorityImpl <em>Reaction Priority</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ReactionPriorityImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getReactionPriority()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.EntryPointSpecImpl <em>Entry Point Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.EntryPointSpecImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEntryPointSpec()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ExitPointSpecImpl <em>Exit Point Spec</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ExitPointSpecImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getExitPointSpec()
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
     * The meta object literal for the '<em><b>Event</b></em>' reference feature.
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.OnCycleEventImpl <em>On Cycle Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.OnCycleEventImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getOnCycleEvent()
     * @generated
     */
    EClass ON_CYCLE_EVENT = eINSTANCE.getOnCycleEvent();

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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.StatementImpl <em>Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.StatementImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getStatement()
     * @generated
     */
    EClass STATEMENT = eINSTANCE.getStatement();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.AssignmentImpl <em>Assignment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.AssignmentImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getAssignment()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.EventRaisingImpl <em>Event Raising</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.EventRaisingImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventRaising()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.OperationCallStatementImpl <em>Operation Call Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.OperationCallStatementImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getOperationCallStatement()
     * @generated
     */
    EClass OPERATION_CALL_STATEMENT = eINSTANCE.getOperationCallStatement();

    /**
     * The meta object literal for the '<em><b>Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CALL_STATEMENT__CALL = eINSTANCE.getOperationCallStatement_Call();

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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.SimpleScopeImpl <em>Simple Scope</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.SimpleScopeImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getSimpleScope()
     * @generated
     */
    EClass SIMPLE_SCOPE = eINSTANCE.getSimpleScope();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTERFACE_SCOPE__NAME = eINSTANCE.getInterfaceScope_Name();

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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ClockImpl <em>Clock</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ClockImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getClock()
     * @generated
     */
    EClass CLOCK = eINSTANCE.getClock();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.OperationImpl <em>Operation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.OperationImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getOperation()
     * @generated
     */
    EClass OPERATION = eINSTANCE.getOperation();

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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.EntrypointImpl <em>Entrypoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.EntrypointImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEntrypoint()
     * @generated
     */
    EClass ENTRYPOINT = eINSTANCE.getEntrypoint();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ExitpointImpl <em>Exitpoint</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.ExitpointImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getExitpoint()
     * @generated
     */
    EClass EXITPOINT = eINSTANCE.getExitpoint();

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
     * The meta object literal for the '<em><b>Guard Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REACTION_TRIGGER__GUARD_EXPRESSION = eINSTANCE.getReactionTrigger_GuardExpression();

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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.EnterEventImpl <em>Enter Event</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.EnterEventImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEnterEvent()
     * @generated
     */
    EClass ENTER_EVENT = eINSTANCE.getEnterEvent();

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
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PRIMITIVE_VALUE_EXPRESSION__VALUE = eINSTANCE.getPrimitiveValueExpression_Value();

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
     * The meta object literal for the '<em><b>Value</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ELEMENT_REFERENCE_EXPRESSION__VALUE = eINSTANCE.getElementReferenceExpression_Value();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.OperationCallImpl <em>Operation Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.impl.OperationCallImpl
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getOperationCall()
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
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.Direction <em>Direction</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.Direction
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getDirection()
     * @generated
     */
    EEnum DIRECTION = eINSTANCE.getDirection();

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

    /**
     * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.Type <em>Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.model.stext.stext.Type
     * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getType()
     * @generated
     */
    EEnum TYPE = eINSTANCE.getType();

  }

} //StextPackage
