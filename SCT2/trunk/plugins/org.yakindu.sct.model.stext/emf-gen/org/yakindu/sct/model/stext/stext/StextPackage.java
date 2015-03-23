/**
 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.types.TypesPackage;
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
public interface StextPackage extends EPackage {
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
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ImportScopeImpl <em>Import Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.impl.ImportScopeImpl
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getImportScope()
	 * @generated
	 */
	int IMPORT_SCOPE = 11;

	/**
	 * The feature id for the '<em><b>Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_SCOPE__DECLARATIONS = STATECHART_SCOPE__DECLARATIONS;

	/**
	 * The feature id for the '<em><b>Events</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_SCOPE__EVENTS = STATECHART_SCOPE__EVENTS;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_SCOPE__VARIABLES = STATECHART_SCOPE__VARIABLES;

	/**
	 * The feature id for the '<em><b>Imports</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_SCOPE__IMPORTS = STATECHART_SCOPE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Import Scope</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_SCOPE_FEATURE_COUNT = STATECHART_SCOPE_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ImportImpl <em>Import</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.impl.ImportImpl
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getImport()
	 * @generated
	 */
	int IMPORT = 12;

	/**
	 * The feature id for the '<em><b>Imported Namespace</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT__IMPORTED_NAMESPACE = 0;

	/**
	 * The number of structural features of the '<em>Import</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPORT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl <em>Event Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventDefinition()
	 * @generated
	 */
	int EVENT_DEFINITION = 13;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__TYPE = TypesPackage.EVENT__TYPE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__TYPE_ARGUMENTS = TypesPackage.EVENT__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__NAME = TypesPackage.EVENT__NAME;

	/**
	 * The feature id for the '<em><b>Direction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION__DIRECTION = TypesPackage.EVENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_DEFINITION_FEATURE_COUNT = TypesPackage.EVENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.VariableDefinitionImpl <em>Variable Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.impl.VariableDefinitionImpl
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getVariableDefinition()
	 * @generated
	 */
	int VARIABLE_DEFINITION = 14;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DEFINITION__TYPE = TypesPackage.PROPERTY__TYPE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DEFINITION__TYPE_ARGUMENTS = TypesPackage.PROPERTY__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DEFINITION__NAME = TypesPackage.PROPERTY__NAME;

	/**
	 * The feature id for the '<em><b>Const</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DEFINITION__CONST = TypesPackage.PROPERTY_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DEFINITION__READONLY = TypesPackage.PROPERTY_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>External</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DEFINITION__EXTERNAL = TypesPackage.PROPERTY_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DEFINITION__INITIAL_VALUE = TypesPackage.PROPERTY_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Variable Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DEFINITION_FEATURE_COUNT = TypesPackage.PROPERTY_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl <em>Operation Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getOperationDefinition()
	 * @generated
	 */
	int OPERATION_DEFINITION = 15;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__TYPE = TypesPackage.OPERATION__TYPE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__TYPE_ARGUMENTS = TypesPackage.OPERATION__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__NAME = TypesPackage.OPERATION__NAME;

	/**
	 * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION__PARAMETERS = TypesPackage.OPERATION__PARAMETERS;

	/**
	 * The number of structural features of the '<em>Operation Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OPERATION_DEFINITION_FEATURE_COUNT = TypesPackage.OPERATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.TypeAliasDefinitionImpl <em>Type Alias Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.impl.TypeAliasDefinitionImpl
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTypeAliasDefinition()
	 * @generated
	 */
	int TYPE_ALIAS_DEFINITION = 16;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS_DEFINITION__TYPE = TypesPackage.TYPE_ALIAS__TYPE;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS_DEFINITION__TYPE_ARGUMENTS = TypesPackage.TYPE_ALIAS__TYPE_ARGUMENTS;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS_DEFINITION__NAME = TypesPackage.TYPE_ALIAS__NAME;

	/**
	 * The feature id for the '<em><b>Constraint</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS_DEFINITION__CONSTRAINT = TypesPackage.TYPE_ALIAS__CONSTRAINT;

	/**
	 * The feature id for the '<em><b>Abstract</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS_DEFINITION__ABSTRACT = TypesPackage.TYPE_ALIAS__ABSTRACT;

	/**
	 * The number of structural features of the '<em>Type Alias Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_ALIAS_DEFINITION_FEATURE_COUNT = TypesPackage.TYPE_ALIAS_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl <em>Local Reaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.impl.LocalReactionImpl
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getLocalReaction()
	 * @generated
	 */
	int LOCAL_REACTION = 17;

	/**
	 * The feature id for the '<em><b>Trigger</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_REACTION__TRIGGER = SGraphPackage.REACTION__TRIGGER;

	/**
	 * The feature id for the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_REACTION__EFFECT = SGraphPackage.REACTION__EFFECT;

	/**
	 * The feature id for the '<em><b>Properties</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_REACTION__PROPERTIES = SGraphPackage.REACTION__PROPERTIES;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_REACTION__TYPE = SGraphPackage.REACTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type Arguments</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_REACTION__TYPE_ARGUMENTS = SGraphPackage.REACTION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_REACTION__NAME = SGraphPackage.REACTION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Local Reaction</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOCAL_REACTION_FEATURE_COUNT = SGraphPackage.REACTION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.TransitionReactionImpl <em>Transition Reaction</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.impl.TransitionReactionImpl
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTransitionReaction()
	 * @generated
	 */
	int TRANSITION_REACTION = 18;

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
	int GUARD = 19;

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
	int ENTRY_POINT_SPEC = 20;

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
	int EXIT_POINT_SPEC = 21;

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
	int EVENT_SPEC = 22;

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
	int REGULAR_EVENT_SPEC = 23;

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
	int TIME_EVENT_SPEC = 24;

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
	int BUILTIN_EVENT_SPEC = 25;

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
	int ENTRY_EVENT = 26;

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
	int EXIT_EVENT = 27;

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
	int ALWAYS_EVENT = 28;

	/**
	 * The number of structural features of the '<em>Always Event</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALWAYS_EVENT_FEATURE_COUNT = BUILTIN_EVENT_SPEC_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.SimpleScopeImpl <em>Simple Scope</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.impl.SimpleScopeImpl
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getSimpleScope()
	 * @generated
	 */
	int SIMPLE_SCOPE = 29;

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
	int REACTION_TRIGGER = 30;

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
	int DEFAULT_TRIGGER = 31;

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
	int REACTION_EFFECT = 32;

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
	int EVENT_RAISING_EXPRESSION = 33;

	/**
	 * The feature id for the '<em><b>Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_RAISING_EXPRESSION__EVENT = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_RAISING_EXPRESSION__VALUE = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Event Raising Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_RAISING_EXPRESSION_FEATURE_COUNT = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.EventValueReferenceExpressionImpl <em>Event Value Reference Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.impl.EventValueReferenceExpressionImpl
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getEventValueReferenceExpression()
	 * @generated
	 */
	int EVENT_VALUE_REFERENCE_EXPRESSION = 34;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_VALUE_REFERENCE_EXPRESSION__VALUE = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Event Value Reference Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EVENT_VALUE_REFERENCE_EXPRESSION_FEATURE_COUNT = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.impl.ActiveStateReferenceExpressionImpl <em>Active State Reference Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.impl.ActiveStateReferenceExpressionImpl
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getActiveStateReferenceExpression()
	 * @generated
	 */
	int ACTIVE_STATE_REFERENCE_EXPRESSION = 35;

	/**
	 * The feature id for the '<em><b>Value</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_STATE_REFERENCE_EXPRESSION__VALUE = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Active State Reference Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ACTIVE_STATE_REFERENCE_EXPRESSION_FEATURE_COUNT = ExpressionsPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.Direction <em>Direction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.Direction
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getDirection()
	 * @generated
	 */
	int DIRECTION = 36;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.TimeEventType <em>Time Event Type</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.TimeEventType
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTimeEventType()
	 * @generated
	 */
	int TIME_EVENT_TYPE = 37;

	/**
	 * The meta object id for the '{@link org.yakindu.sct.model.stext.stext.TimeUnit <em>Time Unit</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.sct.model.stext.stext.TimeUnit
	 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTimeUnit()
	 * @generated
	 */
	int TIME_UNIT = 38;


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
	 * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.ImportScope <em>Import Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import Scope</em>'.
	 * @see org.yakindu.sct.model.stext.stext.ImportScope
	 * @generated
	 */
	EClass getImportScope();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.sct.model.stext.stext.ImportScope#getImports <em>Imports</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Imports</em>'.
	 * @see org.yakindu.sct.model.stext.stext.ImportScope#getImports()
	 * @see #getImportScope()
	 * @generated
	 */
	EReference getImportScope_Imports();

	/**
	 * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.Import <em>Import</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Import</em>'.
	 * @see org.yakindu.sct.model.stext.stext.Import
	 * @generated
	 */
	EClass getImport();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.Import#getImportedNamespace <em>Imported Namespace</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Imported Namespace</em>'.
	 * @see org.yakindu.sct.model.stext.stext.Import#getImportedNamespace()
	 * @see #getImport()
	 * @generated
	 */
	EAttribute getImport_ImportedNamespace();

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
	 * Returns the meta object for the attribute '{@link org.yakindu.sct.model.stext.stext.VariableDefinition#isConst <em>Const</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Const</em>'.
	 * @see org.yakindu.sct.model.stext.stext.VariableDefinition#isConst()
	 * @see #getVariableDefinition()
	 * @generated
	 */
	EAttribute getVariableDefinition_Const();

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
	 * Returns the meta object for class '{@link org.yakindu.sct.model.stext.stext.TypeAliasDefinition <em>Type Alias Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Alias Definition</em>'.
	 * @see org.yakindu.sct.model.stext.stext.TypeAliasDefinition
	 * @generated
	 */
	EClass getTypeAliasDefinition();

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
	interface Literals {
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
		 * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ImportScopeImpl <em>Import Scope</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.stext.stext.impl.ImportScopeImpl
		 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getImportScope()
		 * @generated
		 */
		EClass IMPORT_SCOPE = eINSTANCE.getImportScope();

		/**
		 * The meta object literal for the '<em><b>Imports</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPORT_SCOPE__IMPORTS = eINSTANCE.getImportScope_Imports();

		/**
		 * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.ImportImpl <em>Import</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.stext.stext.impl.ImportImpl
		 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getImport()
		 * @generated
		 */
		EClass IMPORT = eINSTANCE.getImport();

		/**
		 * The meta object literal for the '<em><b>Imported Namespace</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IMPORT__IMPORTED_NAMESPACE = eINSTANCE.getImport_ImportedNamespace();

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
		 * The meta object literal for the '<em><b>Const</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DEFINITION__CONST = eINSTANCE.getVariableDefinition_Const();

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
		 * The meta object literal for the '{@link org.yakindu.sct.model.stext.stext.impl.TypeAliasDefinitionImpl <em>Type Alias Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.sct.model.stext.stext.impl.TypeAliasDefinitionImpl
		 * @see org.yakindu.sct.model.stext.stext.impl.StextPackageImpl#getTypeAliasDefinition()
		 * @generated
		 */
		EClass TYPE_ALIAS_DEFINITION = eINSTANCE.getTypeAliasDefinition();

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
