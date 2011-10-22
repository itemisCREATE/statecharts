/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipselabs.mscript.typesystem.TypeSystemPackage;

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
 * @see org.eclipselabs.mscript.language.ast.AstFactory
 * @model kind="package"
 * @generated
 */
public interface AstPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "ast";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.eclipselabs.org/mscript/AST/1.0.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ast";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AstPackage eINSTANCE = org.eclipselabs.mscript.language.ast.impl.AstPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ModuleImpl <em>Module</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ModuleImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getModule()
	 * @generated
	 */
	int MODULE = 0;

	/**
	 * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE__DEFINITIONS = 0;

	/**
	 * The number of structural features of the '<em>Module</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODULE_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.DefinitionImpl <em>Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.DefinitionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getDefinition()
	 * @generated
	 */
	int DEFINITION = 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEFINITION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.DataTypeDefinitionImpl <em>Data Type Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.DataTypeDefinitionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getDataTypeDefinition()
	 * @generated
	 */
	int DATA_TYPE_DEFINITION = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.EnumerationDefinitionImpl <em>Enumeration Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.EnumerationDefinitionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEnumerationDefinition()
	 * @generated
	 */
	int ENUMERATION_DEFINITION = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.EnumerationLiteralDeclarationImpl <em>Enumeration Literal Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.EnumerationLiteralDeclarationImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEnumerationLiteralDeclaration()
	 * @generated
	 */
	int ENUMERATION_LITERAL_DECLARATION = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFunctionDefinition()
	 * @generated
	 */
	int FUNCTION_DEFINITION = 8;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ParameterDeclarationImpl <em>Parameter Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ParameterDeclarationImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getParameterDeclaration()
	 * @generated
	 */
	int PARAMETER_DECLARATION = 11;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.AssertionImpl <em>Assertion</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.AssertionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAssertion()
	 * @generated
	 */
	int ASSERTION = 15;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.StateVariableDeclarationImpl <em>State Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.StateVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStateVariableDeclaration()
	 * @generated
	 */
	int STATE_VARIABLE_DECLARATION = 16;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.FunctionObjectDeclarationImpl <em>Function Object Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.FunctionObjectDeclarationImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFunctionObjectDeclaration()
	 * @generated
	 */
	int FUNCTION_OBJECT_DECLARATION = 17;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.EquationImpl <em>Equation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.EquationImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEquation()
	 * @generated
	 */
	int EQUATION = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION__NAME = DEFINITION__NAME;

	/**
	 * The number of structural features of the '<em>Data Type Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DEFINITION__NAME = DATA_TYPE_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Literal Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DEFINITION__LITERAL_DECLARATIONS = DATA_TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Enumeration Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_DEFINITION_FEATURE_COUNT = DATA_TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_DECLARATION__NAME = 0;

	/**
	 * The number of structural features of the '<em>Enumeration Literal Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ENUMERATION_LITERAL_DECLARATION_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.TypedefDeclarationImpl <em>Typedef Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.TypedefDeclarationImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTypedefDeclaration()
	 * @generated
	 */
	int TYPEDEF_DECLARATION = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF_DECLARATION__NAME = DATA_TYPE_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF_DECLARATION__TYPE = DATA_TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Typedef Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPEDEF_DECLARATION_FEATURE_COUNT = DATA_TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.StructDefinitionImpl <em>Struct Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.StructDefinitionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStructDefinition()
	 * @generated
	 */
	int STRUCT_DEFINITION = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_DEFINITION__NAME = DATA_TYPE_DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Member Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_DEFINITION__MEMBER_DECLARATIONS = DATA_TYPE_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Struct Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_DEFINITION_FEATURE_COUNT = DATA_TYPE_DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.StructMemberDeclarationImpl <em>Struct Member Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.StructMemberDeclarationImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStructMemberDeclaration()
	 * @generated
	 */
	int STRUCT_MEMBER_DECLARATION = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_MEMBER_DECLARATION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_MEMBER_DECLARATION__TYPE = 1;

	/**
	 * The number of structural features of the '<em>Struct Member Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STRUCT_MEMBER_DECLARATION_FEATURE_COUNT = 2;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__NAME = DEFINITION__NAME;

	/**
	 * The feature id for the '<em><b>Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__KIND = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Template Parameter Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS = DEFINITION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Input Parameter Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS = DEFINITION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Output Parameter Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS = DEFINITION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Checks</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__CHECKS = DEFINITION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Assertions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__ASSERTIONS = DEFINITION_FEATURE_COUNT + 5;

	/**
	 * The feature id for the '<em><b>Function Object Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__FUNCTION_OBJECT_DECLARATIONS = DEFINITION_FEATURE_COUNT + 6;

	/**
	 * The feature id for the '<em><b>State Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__STATE_VARIABLE_DECLARATIONS = DEFINITION_FEATURE_COUNT + 7;

	/**
	 * The feature id for the '<em><b>Equations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION__EQUATIONS = DEFINITION_FEATURE_COUNT + 8;

	/**
	 * The number of structural features of the '<em>Function Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 9;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.CheckImpl <em>Check</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.CheckImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getCheck()
	 * @generated
	 */
	int CHECK = 9;

	/**
	 * The feature id for the '<em><b>Function</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__FUNCTION = 0;

	/**
	 * The feature id for the '<em><b>Template Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__TEMPLATE_ARGUMENTS = 1;

	/**
	 * The feature id for the '<em><b>Input Parameter Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__INPUT_PARAMETER_TYPES = 2;

	/**
	 * The feature id for the '<em><b>Output Parameter Types</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK__OUTPUT_PARAMETER_TYPES = 3;

	/**
	 * The number of structural features of the '<em>Check</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CHECK_FEATURE_COUNT = 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.CallableElementImpl <em>Callable Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.CallableElementImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getCallableElement()
	 * @generated
	 */
	int CALLABLE_ELEMENT = 10;

	/**
	 * The number of structural features of the '<em>Callable Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CALLABLE_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION__NAME = CALLABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parameter Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARAMETER_DECLARATION_FEATURE_COUNT = CALLABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.TemplateParameterDeclarationImpl <em>Template Parameter Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.TemplateParameterDeclarationImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTemplateParameterDeclaration()
	 * @generated
	 */
	int TEMPLATE_PARAMETER_DECLARATION = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_DECLARATION__NAME = PARAMETER_DECLARATION__NAME;

	/**
	 * The number of structural features of the '<em>Template Parameter Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TEMPLATE_PARAMETER_DECLARATION_FEATURE_COUNT = PARAMETER_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.InputParameterDeclarationImpl <em>Input Parameter Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.InputParameterDeclarationImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getInputParameterDeclaration()
	 * @generated
	 */
	int INPUT_PARAMETER_DECLARATION = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PARAMETER_DECLARATION__NAME = PARAMETER_DECLARATION__NAME;

	/**
	 * The number of structural features of the '<em>Input Parameter Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INPUT_PARAMETER_DECLARATION_FEATURE_COUNT = PARAMETER_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.OutputParameterDeclarationImpl <em>Output Parameter Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.OutputParameterDeclarationImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getOutputParameterDeclaration()
	 * @generated
	 */
	int OUTPUT_PARAMETER_DECLARATION = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PARAMETER_DECLARATION__NAME = PARAMETER_DECLARATION__NAME;

	/**
	 * The number of structural features of the '<em>Output Parameter Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int OUTPUT_PARAMETER_DECLARATION_FEATURE_COUNT = PARAMETER_DECLARATION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION__STATIC = 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION__CONDITION = 1;

	/**
	 * The feature id for the '<em><b>Status Kind</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION__STATUS_KIND = 2;

	/**
	 * The feature id for the '<em><b>Message</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION__MESSAGE = 3;

	/**
	 * The number of structural features of the '<em>Assertion</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSERTION_FEATURE_COUNT = 4;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_DECLARATION__NAME = CALLABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>State Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATE_VARIABLE_DECLARATION_FEATURE_COUNT = CALLABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OBJECT_DECLARATION__NAME = CALLABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Function Name</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OBJECT_DECLARATION__FUNCTION_NAME = CALLABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Template Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OBJECT_DECLARATION__TEMPLATE_ARGUMENTS = CALLABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Function Object Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OBJECT_DECLARATION_FEATURE_COUNT = CALLABLE_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION__INITIAL = 0;

	/**
	 * The feature id for the '<em><b>Left Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION__LEFT_HAND_SIDE = 1;

	/**
	 * The feature id for the '<em><b>Right Hand Side</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION__RIGHT_HAND_SIDE = 2;

	/**
	 * The number of structural features of the '<em>Equation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUATION_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.DataTypeSpecifierImpl <em>Data Type Specifier</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.DataTypeSpecifierImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getDataTypeSpecifier()
	 * @generated
	 */
	int DATA_TYPE_SPECIFIER = 19;

	/**
	 * The feature id for the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_SPECIFIER__TYPE = 0;

	/**
	 * The feature id for the '<em><b>Defined Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_SPECIFIER__DEFINED_TYPE = 1;

	/**
	 * The number of structural features of the '<em>Data Type Specifier</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_TYPE_SPECIFIER_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LetExpressionImpl <em>Let Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.LetExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLetExpression()
	 * @generated
	 */
	int LET_EXPRESSION = 20;

	/**
	 * The feature id for the '<em><b>Variable Declarations</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXPRESSION__VARIABLE_DECLARATIONS = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Target Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXPRESSION__TARGET_EXPRESSION = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Let Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LetExpressionVariableDeclarationImpl <em>Let Expression Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.LetExpressionVariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLetExpressionVariableDeclaration()
	 * @generated
	 */
	int LET_EXPRESSION_VARIABLE_DECLARATION = 21;

	/**
	 * The feature id for the '<em><b>Parts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXPRESSION_VARIABLE_DECLARATION__PARTS = 0;

	/**
	 * The feature id for the '<em><b>Assigned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXPRESSION_VARIABLE_DECLARATION__ASSIGNED_EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Let Expression Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXPRESSION_VARIABLE_DECLARATION_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LetExpressionVariableDeclarationPartImpl <em>Let Expression Variable Declaration Part</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.LetExpressionVariableDeclarationPartImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLetExpressionVariableDeclarationPart()
	 * @generated
	 */
	int LET_EXPRESSION_VARIABLE_DECLARATION_PART = 22;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXPRESSION_VARIABLE_DECLARATION_PART__NAME = CALLABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Let Expression Variable Declaration Part</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LET_EXPRESSION_VARIABLE_DECLARATION_PART_FEATURE_COUNT = CALLABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IfExpressionImpl <em>If Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.IfExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIfExpression()
	 * @generated
	 */
	int IF_EXPRESSION = 23;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXPRESSION__STATIC = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXPRESSION__CONDITION = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXPRESSION__THEN_EXPRESSION = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXPRESSION__ELSE_EXPRESSION = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>If Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.SwitchExpressionImpl <em>Switch Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.SwitchExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getSwitchExpression()
	 * @generated
	 */
	int SWITCH_EXPRESSION = 24;

	/**
	 * The feature id for the '<em><b>Static</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXPRESSION__STATIC = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Control Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXPRESSION__CONTROL_EXPRESSION = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Cases</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXPRESSION__CASES = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Default Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXPRESSION__DEFAULT_EXPRESSION = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Switch Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.SwitchCaseImpl <em>Switch Case</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.SwitchCaseImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getSwitchCase()
	 * @generated
	 */
	int SWITCH_CASE = 25;

	/**
	 * The feature id for the '<em><b>Case Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE__CASE_EXPRESSION = 0;

	/**
	 * The feature id for the '<em><b>Result Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE__RESULT_EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Switch Case</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SWITCH_CASE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayElementAccessImpl <em>Array Element Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ArrayElementAccessImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayElementAccess()
	 * @generated
	 */
	int ARRAY_ELEMENT_ACCESS = 26;

	/**
	 * The feature id for the '<em><b>Array</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ELEMENT_ACCESS__ARRAY = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Subscripts</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ELEMENT_ACCESS__SUBSCRIPTS = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Array Element Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_ELEMENT_ACCESS_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ArraySubscriptImpl <em>Array Subscript</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ArraySubscriptImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArraySubscript()
	 * @generated
	 */
	int ARRAY_SUBSCRIPT = 27;

	/**
	 * The feature id for the '<em><b>Slice</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_SUBSCRIPT__SLICE = 0;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_SUBSCRIPT__EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Array Subscript</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_SUBSCRIPT_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IterationCallImpl <em>Iteration Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.IterationCallImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIterationCall()
	 * @generated
	 */
	int ITERATION_CALL = 28;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_CALL__TARGET = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_CALL__IDENTIFIER = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Variables</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_CALL__VARIABLES = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Accumulator</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_CALL__ACCUMULATOR = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Break Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_CALL__BREAK_CONDITION = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_CALL__EXPRESSION = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 5;

	/**
	 * The number of structural features of the '<em>Iteration Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_CALL_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 6;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IterationVariableImpl <em>Iteration Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.IterationVariableImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIterationVariable()
	 * @generated
	 */
	int ITERATION_VARIABLE = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_VARIABLE__NAME = CALLABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Iteration Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_VARIABLE_FEATURE_COUNT = CALLABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IterationAccumulatorImpl <em>Iteration Accumulator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.IterationAccumulatorImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIterationAccumulator()
	 * @generated
	 */
	int ITERATION_ACCUMULATOR = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_ACCUMULATOR__NAME = CALLABLE_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_ACCUMULATOR__INITIALIZER = CALLABLE_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Iteration Accumulator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ITERATION_ACCUMULATOR_FEATURE_COUNT = CALLABLE_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.DerivativeOperatorImpl <em>Derivative Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.DerivativeOperatorImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getDerivativeOperator()
	 * @generated
	 */
	int DERIVATIVE_OPERATOR = 31;

	/**
	 * The feature id for the '<em><b>Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATIVE_OPERATOR__VARIABLE = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Derivative Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DERIVATIVE_OPERATOR_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayConstructionOperatorImpl <em>Array Construction Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ArrayConstructionOperatorImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayConstructionOperator()
	 * @generated
	 */
	int ARRAY_CONSTRUCTION_OPERATOR = 32;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_CONSTRUCTION_OPERATOR__EXPRESSIONS = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iteration Clauses</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_CONSTRUCTION_OPERATOR__ITERATION_CLAUSES = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Array Construction Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_CONSTRUCTION_OPERATOR_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayConstructionIterationClauseImpl <em>Array Construction Iteration Clause</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ArrayConstructionIterationClauseImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayConstructionIterationClause()
	 * @generated
	 */
	int ARRAY_CONSTRUCTION_ITERATION_CLAUSE = 33;

	/**
	 * The feature id for the '<em><b>Variable Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_CONSTRUCTION_ITERATION_CLAUSE__VARIABLE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Collection Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION = 1;

	/**
	 * The number of structural features of the '<em>Array Construction Iteration Clause</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_CONSTRUCTION_ITERATION_CLAUSE_FEATURE_COUNT = 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayConcatenationOperatorImpl <em>Array Concatenation Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ArrayConcatenationOperatorImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayConcatenationOperator()
	 * @generated
	 */
	int ARRAY_CONCATENATION_OPERATOR = 34;

	/**
	 * The feature id for the '<em><b>Rows</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_CONCATENATION_OPERATOR__ROWS = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Array Concatenation Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ARRAY_CONCATENATION_OPERATOR_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ExpressionListImpl <em>Expression List</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ExpressionListImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getExpressionList()
	 * @generated
	 */
	int EXPRESSION_LIST = 35;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_LIST__EXPRESSIONS = 0;

	/**
	 * The number of structural features of the '<em>Expression List</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_LIST_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitConstructionOperatorImpl <em>Unit Construction Operator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.UnitConstructionOperatorImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitConstructionOperator()
	 * @generated
	 */
	int UNIT_CONSTRUCTION_OPERATOR = 36;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CONSTRUCTION_OPERATOR__UNIT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Unit Construction Operator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNIT_CONSTRUCTION_OPERATOR_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ParenthesizedExpressionImpl <em>Parenthesized Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ParenthesizedExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getParenthesizedExpression()
	 * @generated
	 */
	int PARENTHESIZED_EXPRESSION = 37;

	/**
	 * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENTHESIZED_EXPRESSION__EXPRESSIONS = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Parenthesized Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PARENTHESIZED_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.EndExpressionImpl <em>End Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.EndExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEndExpression()
	 * @generated
	 */
	int END_EXPRESSION = 38;

	/**
	 * The number of structural features of the '<em>End Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int END_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RangeExpressionImpl <em>Range Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.RangeExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRangeExpression()
	 * @generated
	 */
	int RANGE_EXPRESSION = 39;

	/**
	 * The feature id for the '<em><b>Operands</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_EXPRESSION__OPERANDS = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Range Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ImpliesExpressionImpl <em>Implies Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ImpliesExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getImpliesExpression()
	 * @generated
	 */
	int IMPLIES_EXPRESSION = 40;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_EXPRESSION__LEFT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_EXPRESSION__RIGHT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Implies Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IMPLIES_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.LogicalOrExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLogicalOrExpression()
	 * @generated
	 */
	int LOGICAL_OR_EXPRESSION = 41;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_OR_EXPRESSION__LEFT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_OR_EXPRESSION__RIGHT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Logical Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_OR_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.LogicalAndExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLogicalAndExpression()
	 * @generated
	 */
	int LOGICAL_AND_EXPRESSION = 42;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_AND_EXPRESSION__LEFT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_AND_EXPRESSION__RIGHT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Logical And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LOGICAL_AND_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.EqualityExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEqualityExpression()
	 * @generated
	 */
	int EQUALITY_EXPRESSION = 43;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_EXPRESSION__LEFT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_EXPRESSION__OPERATOR = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_EXPRESSION__RIGHT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Equality Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EQUALITY_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.RelationalExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRelationalExpression()
	 * @generated
	 */
	int RELATIONAL_EXPRESSION = 44;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION__LEFT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION__OPERATOR = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION__RIGHT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Relational Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RELATIONAL_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.TypeTestExpressionImpl <em>Type Test Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.TypeTestExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTypeTestExpression()
	 * @generated
	 */
	int TYPE_TEST_EXPRESSION = 45;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEST_EXPRESSION__EXPRESSION = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEST_EXPRESSION__TYPE = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Type Test Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TYPE_TEST_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.AdditiveExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAdditiveExpression()
	 * @generated
	 */
	int ADDITIVE_EXPRESSION = 46;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPRESSION__OPERATOR = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPRESSION__LEFT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPRESSION__RIGHT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Additive Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.MultiplicativeExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplicativeExpression()
	 * @generated
	 */
	int MULTIPLICATIVE_EXPRESSION = 47;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPRESSION__OPERATOR = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPRESSION__LEFT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPRESSION__RIGHT_OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Multiplicative Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.PowerExpressionImpl <em>Power Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.PowerExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPowerExpression()
	 * @generated
	 */
	int POWER_EXPRESSION = 48;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_EXPRESSION__OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_EXPRESSION__OPERATOR = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Exponent</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_EXPRESSION__EXPONENT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Power Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POWER_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.UnaryExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnaryExpression()
	 * @generated
	 */
	int UNARY_EXPRESSION = 49;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__OPERATOR = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION__OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Unary Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UNARY_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.PostfixExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPostfixExpression()
	 * @generated
	 */
	int POSTFIX_EXPRESSION = 50;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTFIX_EXPRESSION__OPERAND = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTFIX_EXPRESSION__OPERATOR = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Postfix Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTFIX_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallImpl <em>Feature Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.FeatureCallImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFeatureCall()
	 * @generated
	 */
	int FEATURE_CALL = 51;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL__FEATURE = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Feature Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.VariableAccessImpl <em>Variable Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.VariableAccessImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getVariableAccess()
	 * @generated
	 */
	int VARIABLE_ACCESS = 52;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__FEATURE = FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Step Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS__STEP_EXPRESSION = FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Variable Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_ACCESS_FEATURE_COUNT = FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.StepExpressionImpl <em>Step Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.StepExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStepExpression()
	 * @generated
	 */
	int STEP_EXPRESSION = 53;

	/**
	 * The number of structural features of the '<em>Step Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RangeStepExpressionImpl <em>Range Step Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.RangeStepExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRangeStepExpression()
	 * @generated
	 */
	int RANGE_STEP_EXPRESSION = 54;

	/**
	 * The feature id for the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_STEP_EXPRESSION__START = STEP_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_STEP_EXPRESSION__END = STEP_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Range Step Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RANGE_STEP_EXPRESSION_FEATURE_COUNT = STEP_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.AdditiveStepExpressionImpl <em>Additive Step Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.AdditiveStepExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAdditiveStepExpression()
	 * @generated
	 */
	int ADDITIVE_STEP_EXPRESSION = 55;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_STEP_EXPRESSION__OPERATOR = STEP_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_STEP_EXPRESSION__LEFT_OPERAND = STEP_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_STEP_EXPRESSION__RIGHT_OPERAND = STEP_EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Additive Step Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADDITIVE_STEP_EXPRESSION_FEATURE_COUNT = STEP_EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.NegateStepExpressionImpl <em>Negate Step Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.NegateStepExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNegateStepExpression()
	 * @generated
	 */
	int NEGATE_STEP_EXPRESSION = 56;

	/**
	 * The feature id for the '<em><b>Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATE_STEP_EXPRESSION__OPERAND = STEP_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Negate Step Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NEGATE_STEP_EXPRESSION_FEATURE_COUNT = STEP_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.PrimitiveStepExpressionImpl <em>Primitive Step Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.PrimitiveStepExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPrimitiveStepExpression()
	 * @generated
	 */
	int PRIMITIVE_STEP_EXPRESSION = 57;

	/**
	 * The number of structural features of the '<em>Primitive Step Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PRIMITIVE_STEP_EXPRESSION_FEATURE_COUNT = STEP_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.StepLiteralImpl <em>Step Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.StepLiteralImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStepLiteral()
	 * @generated
	 */
	int STEP_LITERAL = 58;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_LITERAL__VALUE = PRIMITIVE_STEP_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Step Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_LITERAL_FEATURE_COUNT = PRIMITIVE_STEP_EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.StepNImpl <em>Step N</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.StepNImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStepN()
	 * @generated
	 */
	int STEP_N = 59;

	/**
	 * The number of structural features of the '<em>Step N</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STEP_N_FEATURE_COUNT = PRIMITIVE_STEP_EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.FunctionCallImpl <em>Function Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.FunctionCallImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFunctionCall()
	 * @generated
	 */
	int FUNCTION_CALL = 60;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__FEATURE = FEATURE_CALL__FEATURE;

	/**
	 * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL__ARGUMENTS = FEATURE_CALL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Function Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_CALL_FEATURE_COUNT = FEATURE_CALL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.MemberVariableAccessImpl <em>Member Variable Access</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.MemberVariableAccessImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMemberVariableAccess()
	 * @generated
	 */
	int MEMBER_VARIABLE_ACCESS = 61;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_VARIABLE_ACCESS__TARGET = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Member Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Member Variable Access</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MEMBER_VARIABLE_ACCESS_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.AlgorithmExpressionImpl <em>Algorithm Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.AlgorithmExpressionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAlgorithmExpression()
	 * @generated
	 */
	int ALGORITHM_EXPRESSION = 62;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_EXPRESSION__BODY = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Algorithm Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ALGORITHM_EXPRESSION_FEATURE_COUNT = TypeSystemPackage.EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.StatementImpl <em>Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.StatementImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStatement()
	 * @generated
	 */
	int STATEMENT = 64;

	/**
	 * The number of structural features of the '<em>Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STATEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.CompoundImpl <em>Compound</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.CompoundImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getCompound()
	 * @generated
	 */
	int COMPOUND = 63;

	/**
	 * The feature id for the '<em><b>Statements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Compound</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPOUND_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.AssignmentImpl <em>Assignment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.AssignmentImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAssignment()
	 * @generated
	 */
	int ASSIGNMENT = 65;

	/**
	 * The feature id for the '<em><b>Target</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT__TARGET = STATEMENT_FEATURE_COUNT + 0;

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
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.VariableDeclarationImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getVariableDeclaration()
	 * @generated
	 */
	int VARIABLE_DECLARATION = 66;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__NAME = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION__INITIALIZER = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Variable Declaration</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VARIABLE_DECLARATION_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IfStatementImpl <em>If Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.IfStatementImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIfStatement()
	 * @generated
	 */
	int IF_STATEMENT = 67;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Then Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__THEN_STATEMENT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Else Statement</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT__ELSE_STATEMENT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>If Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.WhileStatementImpl <em>While Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.WhileStatementImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getWhileStatement()
	 * @generated
	 */
	int WHILE_STATEMENT = 68;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>While Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int WHILE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.DoWhileStatementImpl <em>Do While Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.DoWhileStatementImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getDoWhileStatement()
	 * @generated
	 */
	int DO_WHILE_STATEMENT = 69;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_WHILE_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_WHILE_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Do While Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DO_WHILE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ForStatementImpl <em>For Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ForStatementImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getForStatement()
	 * @generated
	 */
	int FOR_STATEMENT = 70;

	/**
	 * The feature id for the '<em><b>Declared Iteration Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__DECLARED_ITERATION_VARIABLE = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Iteration Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__ITERATION_VARIABLE = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Collection Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__COLLECTION_EXPRESSION = STATEMENT_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__CONDITION = STATEMENT_FEATURE_COUNT + 3;

	/**
	 * The feature id for the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 4;

	/**
	 * The number of structural features of the '<em>For Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FOR_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 5;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ContinueStatementImpl <em>Continue Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ContinueStatementImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getContinueStatement()
	 * @generated
	 */
	int CONTINUE_STATEMENT = 71;

	/**
	 * The number of structural features of the '<em>Continue Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONTINUE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.BreakStatementImpl <em>Break Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.BreakStatementImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBreakStatement()
	 * @generated
	 */
	int BREAK_STATEMENT = 72;

	/**
	 * The number of structural features of the '<em>Break Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BREAK_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.ReturnStatementImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getReturnStatement()
	 * @generated
	 */
	int RETURN_STATEMENT = 73;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT__EXPRESSION = STATEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Return Statement</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RETURN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.BuiltinDefinitionImpl <em>Builtin Definition</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.BuiltinDefinitionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBuiltinDefinition()
	 * @generated
	 */
	int BUILTIN_DEFINITION = 74;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILTIN_DEFINITION__NAME = DEFINITION__NAME;

	/**
	 * The number of structural features of the '<em>Builtin Definition</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILTIN_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.BuiltinFunctionImpl <em>Builtin Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.BuiltinFunctionImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBuiltinFunction()
	 * @generated
	 */
	int BUILTIN_FUNCTION = 75;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILTIN_FUNCTION__NAME = BUILTIN_DEFINITION__NAME;

	/**
	 * The number of structural features of the '<em>Builtin Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILTIN_FUNCTION_FEATURE_COUNT = BUILTIN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.BuiltinVariableImpl <em>Builtin Variable</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.impl.BuiltinVariableImpl
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBuiltinVariable()
	 * @generated
	 */
	int BUILTIN_VARIABLE = 76;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILTIN_VARIABLE__NAME = BUILTIN_DEFINITION__NAME;

	/**
	 * The number of structural features of the '<em>Builtin Variable</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BUILTIN_VARIABLE_FEATURE_COUNT = BUILTIN_DEFINITION_FEATURE_COUNT + 0;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.FunctionKind <em>Function Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.FunctionKind
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFunctionKind()
	 * @generated
	 */
	int FUNCTION_KIND = 77;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.AssertionStatusKind <em>Assertion Status Kind</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.AssertionStatusKind
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAssertionStatusKind()
	 * @generated
	 */
	int ASSERTION_STATUS_KIND = 78;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.EqualityOperator <em>Equality Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.EqualityOperator
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEqualityOperator()
	 * @generated
	 */
	int EQUALITY_OPERATOR = 79;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.RelationalOperator <em>Relational Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.RelationalOperator
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRelationalOperator()
	 * @generated
	 */
	int RELATIONAL_OPERATOR = 80;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.AdditiveOperator <em>Additive Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.AdditiveOperator
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAdditiveOperator()
	 * @generated
	 */
	int ADDITIVE_OPERATOR = 81;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.MultiplicativeOperator
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplicativeOperator()
	 * @generated
	 */
	int MULTIPLICATIVE_OPERATOR = 82;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.PowerOperator <em>Power Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.PowerOperator
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPowerOperator()
	 * @generated
	 */
	int POWER_OPERATOR = 83;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.UnaryOperator <em>Unary Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.UnaryOperator
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnaryOperator()
	 * @generated
	 */
	int UNARY_OPERATOR = 84;

	/**
	 * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.PostfixOperator <em>Postfix Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipselabs.mscript.language.ast.PostfixOperator
	 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPostfixOperator()
	 * @generated
	 */
	int POSTFIX_OPERATOR = 85;

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Module</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Module
	 * @generated
	 */
	EClass getModule();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.Module#getDefinitions <em>Definitions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Definitions</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Module#getDefinitions()
	 * @see #getModule()
	 * @generated
	 */
	EReference getModule_Definitions();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Definition <em>Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Definition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Definition
	 * @generated
	 */
	EClass getDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.Definition#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Definition#getName()
	 * @see #getDefinition()
	 * @generated
	 */
	EAttribute getDefinition_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.DataTypeDefinition <em>Data Type Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Definition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.DataTypeDefinition
	 * @generated
	 */
	EClass getDataTypeDefinition();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.EnumerationDefinition <em>Enumeration Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Definition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.EnumerationDefinition
	 * @generated
	 */
	EClass getEnumerationDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.EnumerationDefinition#getLiteralDeclarations <em>Literal Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Literal Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.ast.EnumerationDefinition#getLiteralDeclarations()
	 * @see #getEnumerationDefinition()
	 * @generated
	 */
	EReference getEnumerationDefinition_LiteralDeclarations();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.EnumerationLiteralDeclaration <em>Enumeration Literal Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Enumeration Literal Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.ast.EnumerationLiteralDeclaration
	 * @generated
	 */
	EClass getEnumerationLiteralDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.EnumerationLiteralDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.ast.EnumerationLiteralDeclaration#getName()
	 * @see #getEnumerationLiteralDeclaration()
	 * @generated
	 */
	EAttribute getEnumerationLiteralDeclaration_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.TypedefDeclaration <em>Typedef Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Typedef Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.ast.TypedefDeclaration
	 * @generated
	 */
	EClass getTypedefDeclaration();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.TypedefDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipselabs.mscript.language.ast.TypedefDeclaration#getType()
	 * @see #getTypedefDeclaration()
	 * @generated
	 */
	EReference getTypedefDeclaration_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.StructDefinition <em>Struct Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Struct Definition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.StructDefinition
	 * @generated
	 */
	EClass getStructDefinition();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.StructDefinition#getMemberDeclarations <em>Member Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Member Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.ast.StructDefinition#getMemberDeclarations()
	 * @see #getStructDefinition()
	 * @generated
	 */
	EReference getStructDefinition_MemberDeclarations();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.StructMemberDeclaration <em>Struct Member Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Struct Member Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.ast.StructMemberDeclaration
	 * @generated
	 */
	EClass getStructMemberDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.StructMemberDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.ast.StructMemberDeclaration#getName()
	 * @see #getStructMemberDeclaration()
	 * @generated
	 */
	EAttribute getStructMemberDeclaration_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.StructMemberDeclaration#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipselabs.mscript.language.ast.StructMemberDeclaration#getType()
	 * @see #getStructMemberDeclaration()
	 * @generated
	 */
	EReference getStructMemberDeclaration_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition <em>Function Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Definition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionDefinition
	 * @generated
	 */
	EClass getFunctionDefinition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getKind <em>Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Kind</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getKind()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EAttribute getFunctionDefinition_Kind();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getTemplateParameterDeclarations <em>Template Parameter Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template Parameter Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getTemplateParameterDeclarations()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EReference getFunctionDefinition_TemplateParameterDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getInputParameterDeclarations <em>Input Parameter Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Parameter Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getInputParameterDeclarations()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EReference getFunctionDefinition_InputParameterDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getOutputParameterDeclarations <em>Output Parameter Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Parameter Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getOutputParameterDeclarations()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EReference getFunctionDefinition_OutputParameterDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getChecks <em>Checks</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Checks</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getChecks()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EReference getFunctionDefinition_Checks();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getAssertions <em>Assertions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Assertions</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getAssertions()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EReference getFunctionDefinition_Assertions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getFunctionObjectDeclarations <em>Function Object Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Function Object Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getFunctionObjectDeclarations()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EReference getFunctionDefinition_FunctionObjectDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getStateVariableDeclarations <em>State Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>State Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getStateVariableDeclarations()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EReference getFunctionDefinition_StateVariableDeclarations();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getEquations <em>Equations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Equations</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getEquations()
	 * @see #getFunctionDefinition()
	 * @generated
	 */
	EReference getFunctionDefinition_Equations();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Check <em>Check</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Check</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Check
	 * @generated
	 */
	EClass getCheck();

	/**
	 * Returns the meta object for the container reference '{@link org.eclipselabs.mscript.language.ast.Check#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Function</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Check#getFunction()
	 * @see #getCheck()
	 * @generated
	 */
	EReference getCheck_Function();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.Check#getTemplateArguments <em>Template Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template Arguments</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Check#getTemplateArguments()
	 * @see #getCheck()
	 * @generated
	 */
	EReference getCheck_TemplateArguments();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.Check#getInputParameterTypes <em>Input Parameter Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Input Parameter Types</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Check#getInputParameterTypes()
	 * @see #getCheck()
	 * @generated
	 */
	EReference getCheck_InputParameterTypes();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.Check#getOutputParameterTypes <em>Output Parameter Types</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Output Parameter Types</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Check#getOutputParameterTypes()
	 * @see #getCheck()
	 * @generated
	 */
	EReference getCheck_OutputParameterTypes();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.CallableElement <em>Callable Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Callable Element</em>'.
	 * @see org.eclipselabs.mscript.language.ast.CallableElement
	 * @generated
	 */
	EClass getCallableElement();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ParameterDeclaration <em>Parameter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parameter Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ParameterDeclaration
	 * @generated
	 */
	EClass getParameterDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.ParameterDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ParameterDeclaration#getName()
	 * @see #getParameterDeclaration()
	 * @generated
	 */
	EAttribute getParameterDeclaration_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.TemplateParameterDeclaration <em>Template Parameter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Template Parameter Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.ast.TemplateParameterDeclaration
	 * @generated
	 */
	EClass getTemplateParameterDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.InputParameterDeclaration <em>Input Parameter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Input Parameter Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.ast.InputParameterDeclaration
	 * @generated
	 */
	EClass getInputParameterDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.OutputParameterDeclaration <em>Output Parameter Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Output Parameter Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.ast.OutputParameterDeclaration
	 * @generated
	 */
	EClass getOutputParameterDeclaration();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Assertion <em>Assertion</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assertion</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Assertion
	 * @generated
	 */
	EClass getAssertion();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.Assertion#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Assertion#isStatic()
	 * @see #getAssertion()
	 * @generated
	 */
	EAttribute getAssertion_Static();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.Assertion#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Assertion#getCondition()
	 * @see #getAssertion()
	 * @generated
	 */
	EReference getAssertion_Condition();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.Assertion#getStatusKind <em>Status Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Status Kind</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Assertion#getStatusKind()
	 * @see #getAssertion()
	 * @generated
	 */
	EAttribute getAssertion_StatusKind();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.Assertion#getMessage <em>Message</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Message</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Assertion#getMessage()
	 * @see #getAssertion()
	 * @generated
	 */
	EReference getAssertion_Message();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.StateVariableDeclaration <em>State Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>State Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.ast.StateVariableDeclaration
	 * @generated
	 */
	EClass getStateVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.StateVariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.ast.StateVariableDeclaration#getName()
	 * @see #getStateVariableDeclaration()
	 * @generated
	 */
	EAttribute getStateVariableDeclaration_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration <em>Function Object Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Object Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration
	 * @generated
	 */
	EClass getFunctionObjectDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration#getName()
	 * @see #getFunctionObjectDeclaration()
	 * @generated
	 */
	EAttribute getFunctionObjectDeclaration_Name();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration#getFunctionName <em>Function Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Function Name</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration#getFunctionName()
	 * @see #getFunctionObjectDeclaration()
	 * @generated
	 */
	EReference getFunctionObjectDeclaration_FunctionName();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration#getTemplateArguments <em>Template Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Template Arguments</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration#getTemplateArguments()
	 * @see #getFunctionObjectDeclaration()
	 * @generated
	 */
	EReference getFunctionObjectDeclaration_TemplateArguments();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Equation <em>Equation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equation</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Equation
	 * @generated
	 */
	EClass getEquation();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.Equation#isInitial <em>Initial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Initial</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Equation#isInitial()
	 * @see #getEquation()
	 * @generated
	 */
	EAttribute getEquation_Initial();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.Equation#getLeftHandSide <em>Left Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Hand Side</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Equation#getLeftHandSide()
	 * @see #getEquation()
	 * @generated
	 */
	EReference getEquation_LeftHandSide();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.Equation#getRightHandSide <em>Right Hand Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Hand Side</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Equation#getRightHandSide()
	 * @see #getEquation()
	 * @generated
	 */
	EReference getEquation_RightHandSide();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.DataTypeSpecifier <em>Data Type Specifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Type Specifier</em>'.
	 * @see org.eclipselabs.mscript.language.ast.DataTypeSpecifier
	 * @generated
	 */
	EClass getDataTypeSpecifier();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.ast.DataTypeSpecifier#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Type</em>'.
	 * @see org.eclipselabs.mscript.language.ast.DataTypeSpecifier#getType()
	 * @see #getDataTypeSpecifier()
	 * @generated
	 */
	EReference getDataTypeSpecifier_Type();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.DataTypeSpecifier#getDefinedType <em>Defined Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Defined Type</em>'.
	 * @see org.eclipselabs.mscript.language.ast.DataTypeSpecifier#getDefinedType()
	 * @see #getDataTypeSpecifier()
	 * @generated
	 */
	EReference getDataTypeSpecifier_DefinedType();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.LetExpression <em>Let Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LetExpression
	 * @generated
	 */
	EClass getLetExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.LetExpression#getVariableDeclarations <em>Variable Declarations</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variable Declarations</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LetExpression#getVariableDeclarations()
	 * @see #getLetExpression()
	 * @generated
	 */
	EReference getLetExpression_VariableDeclarations();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.LetExpression#getTargetExpression <em>Target Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LetExpression#getTargetExpression()
	 * @see #getLetExpression()
	 * @generated
	 */
	EReference getLetExpression_TargetExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration <em>Let Expression Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Expression Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration
	 * @generated
	 */
	EClass getLetExpressionVariableDeclaration();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Parts</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration#getParts()
	 * @see #getLetExpressionVariableDeclaration()
	 * @generated
	 */
	EReference getLetExpressionVariableDeclaration_Parts();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration#getAssignedExpression <em>Assigned Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Assigned Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration#getAssignedExpression()
	 * @see #getLetExpressionVariableDeclaration()
	 * @generated
	 */
	EReference getLetExpressionVariableDeclaration_AssignedExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclarationPart <em>Let Expression Variable Declaration Part</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Let Expression Variable Declaration Part</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclarationPart
	 * @generated
	 */
	EClass getLetExpressionVariableDeclarationPart();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclarationPart#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclarationPart#getName()
	 * @see #getLetExpressionVariableDeclarationPart()
	 * @generated
	 */
	EAttribute getLetExpressionVariableDeclarationPart_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.IfExpression <em>If Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IfExpression
	 * @generated
	 */
	EClass getIfExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.IfExpression#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IfExpression#isStatic()
	 * @see #getIfExpression()
	 * @generated
	 */
	EAttribute getIfExpression_Static();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IfExpression#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IfExpression#getCondition()
	 * @see #getIfExpression()
	 * @generated
	 */
	EReference getIfExpression_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IfExpression#getThenExpression <em>Then Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IfExpression#getThenExpression()
	 * @see #getIfExpression()
	 * @generated
	 */
	EReference getIfExpression_ThenExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IfExpression#getElseExpression <em>Else Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IfExpression#getElseExpression()
	 * @see #getIfExpression()
	 * @generated
	 */
	EReference getIfExpression_ElseExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.SwitchExpression <em>Switch Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.SwitchExpression
	 * @generated
	 */
	EClass getSwitchExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.SwitchExpression#isStatic <em>Static</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Static</em>'.
	 * @see org.eclipselabs.mscript.language.ast.SwitchExpression#isStatic()
	 * @see #getSwitchExpression()
	 * @generated
	 */
	EAttribute getSwitchExpression_Static();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.SwitchExpression#getControlExpression <em>Control Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Control Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.SwitchExpression#getControlExpression()
	 * @see #getSwitchExpression()
	 * @generated
	 */
	EReference getSwitchExpression_ControlExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.SwitchExpression#getCases <em>Cases</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Cases</em>'.
	 * @see org.eclipselabs.mscript.language.ast.SwitchExpression#getCases()
	 * @see #getSwitchExpression()
	 * @generated
	 */
	EReference getSwitchExpression_Cases();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.SwitchExpression#getDefaultExpression <em>Default Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Default Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.SwitchExpression#getDefaultExpression()
	 * @see #getSwitchExpression()
	 * @generated
	 */
	EReference getSwitchExpression_DefaultExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.SwitchCase <em>Switch Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Switch Case</em>'.
	 * @see org.eclipselabs.mscript.language.ast.SwitchCase
	 * @generated
	 */
	EClass getSwitchCase();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.SwitchCase#getCaseExpression <em>Case Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Case Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.SwitchCase#getCaseExpression()
	 * @see #getSwitchCase()
	 * @generated
	 */
	EReference getSwitchCase_CaseExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.SwitchCase#getResultExpression <em>Result Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Result Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.SwitchCase#getResultExpression()
	 * @see #getSwitchCase()
	 * @generated
	 */
	EReference getSwitchCase_ResultExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ArrayElementAccess <em>Array Element Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Element Access</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArrayElementAccess
	 * @generated
	 */
	EClass getArrayElementAccess();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ArrayElementAccess#getArray <em>Array</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Array</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArrayElementAccess#getArray()
	 * @see #getArrayElementAccess()
	 * @generated
	 */
	EReference getArrayElementAccess_Array();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.ArrayElementAccess#getSubscripts <em>Subscripts</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Subscripts</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArrayElementAccess#getSubscripts()
	 * @see #getArrayElementAccess()
	 * @generated
	 */
	EReference getArrayElementAccess_Subscripts();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ArraySubscript <em>Array Subscript</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Subscript</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArraySubscript
	 * @generated
	 */
	EClass getArraySubscript();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.ArraySubscript#isSlice <em>Slice</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Slice</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArraySubscript#isSlice()
	 * @see #getArraySubscript()
	 * @generated
	 */
	EAttribute getArraySubscript_Slice();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ArraySubscript#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArraySubscript#getExpression()
	 * @see #getArraySubscript()
	 * @generated
	 */
	EReference getArraySubscript_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.IterationCall <em>Iteration Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration Call</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IterationCall
	 * @generated
	 */
	EClass getIterationCall();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IterationCall#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IterationCall#getTarget()
	 * @see #getIterationCall()
	 * @generated
	 */
	EReference getIterationCall_Target();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.IterationCall#getIdentifier <em>Identifier</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Identifier</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IterationCall#getIdentifier()
	 * @see #getIterationCall()
	 * @generated
	 */
	EAttribute getIterationCall_Identifier();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.IterationCall#getVariables <em>Variables</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Variables</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IterationCall#getVariables()
	 * @see #getIterationCall()
	 * @generated
	 */
	EReference getIterationCall_Variables();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IterationCall#getAccumulator <em>Accumulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Accumulator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IterationCall#getAccumulator()
	 * @see #getIterationCall()
	 * @generated
	 */
	EReference getIterationCall_Accumulator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IterationCall#getBreakCondition <em>Break Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Break Condition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IterationCall#getBreakCondition()
	 * @see #getIterationCall()
	 * @generated
	 */
	EReference getIterationCall_BreakCondition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IterationCall#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IterationCall#getExpression()
	 * @see #getIterationCall()
	 * @generated
	 */
	EReference getIterationCall_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.IterationVariable <em>Iteration Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration Variable</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IterationVariable
	 * @generated
	 */
	EClass getIterationVariable();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.IterationVariable#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IterationVariable#getName()
	 * @see #getIterationVariable()
	 * @generated
	 */
	EAttribute getIterationVariable_Name();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.IterationAccumulator <em>Iteration Accumulator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Iteration Accumulator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IterationAccumulator
	 * @generated
	 */
	EClass getIterationAccumulator();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.IterationAccumulator#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IterationAccumulator#getName()
	 * @see #getIterationAccumulator()
	 * @generated
	 */
	EAttribute getIterationAccumulator_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IterationAccumulator#getInitializer <em>Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializer</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IterationAccumulator#getInitializer()
	 * @see #getIterationAccumulator()
	 * @generated
	 */
	EReference getIterationAccumulator_Initializer();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.DerivativeOperator <em>Derivative Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Derivative Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.DerivativeOperator
	 * @generated
	 */
	EClass getDerivativeOperator();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.ast.DerivativeOperator#getVariable <em>Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Variable</em>'.
	 * @see org.eclipselabs.mscript.language.ast.DerivativeOperator#getVariable()
	 * @see #getDerivativeOperator()
	 * @generated
	 */
	EReference getDerivativeOperator_Variable();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ArrayConstructionOperator <em>Array Construction Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Construction Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArrayConstructionOperator
	 * @generated
	 */
	EClass getArrayConstructionOperator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.ArrayConstructionOperator#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArrayConstructionOperator#getExpressions()
	 * @see #getArrayConstructionOperator()
	 * @generated
	 */
	EReference getArrayConstructionOperator_Expressions();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.ArrayConstructionOperator#getIterationClauses <em>Iteration Clauses</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Iteration Clauses</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArrayConstructionOperator#getIterationClauses()
	 * @see #getArrayConstructionOperator()
	 * @generated
	 */
	EReference getArrayConstructionOperator_IterationClauses();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause <em>Array Construction Iteration Clause</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Construction Iteration Clause</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause
	 * @generated
	 */
	EClass getArrayConstructionIterationClause();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause#getVariableName <em>Variable Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Variable Name</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause#getVariableName()
	 * @see #getArrayConstructionIterationClause()
	 * @generated
	 */
	EAttribute getArrayConstructionIterationClause_VariableName();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause#getCollectionExpression <em>Collection Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause#getCollectionExpression()
	 * @see #getArrayConstructionIterationClause()
	 * @generated
	 */
	EReference getArrayConstructionIterationClause_CollectionExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ArrayConcatenationOperator <em>Array Concatenation Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Array Concatenation Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArrayConcatenationOperator
	 * @generated
	 */
	EClass getArrayConcatenationOperator();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.ArrayConcatenationOperator#getRows <em>Rows</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Rows</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ArrayConcatenationOperator#getRows()
	 * @see #getArrayConcatenationOperator()
	 * @generated
	 */
	EReference getArrayConcatenationOperator_Rows();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ExpressionList <em>Expression List</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression List</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ExpressionList
	 * @generated
	 */
	EClass getExpressionList();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.ExpressionList#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ExpressionList#getExpressions()
	 * @see #getExpressionList()
	 * @generated
	 */
	EReference getExpressionList_Expressions();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.UnitConstructionOperator <em>Unit Construction Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unit Construction Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.UnitConstructionOperator
	 * @generated
	 */
	EClass getUnitConstructionOperator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.UnitConstructionOperator#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Unit</em>'.
	 * @see org.eclipselabs.mscript.language.ast.UnitConstructionOperator#getUnit()
	 * @see #getUnitConstructionOperator()
	 * @generated
	 */
	EReference getUnitConstructionOperator_Unit();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ParenthesizedExpression <em>Parenthesized Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parenthesized Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ParenthesizedExpression
	 * @generated
	 */
	EClass getParenthesizedExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.ParenthesizedExpression#getExpressions <em>Expressions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Expressions</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ParenthesizedExpression#getExpressions()
	 * @see #getParenthesizedExpression()
	 * @generated
	 */
	EReference getParenthesizedExpression_Expressions();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.EndExpression <em>End Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>End Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.EndExpression
	 * @generated
	 */
	EClass getEndExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.RangeExpression <em>Range Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.RangeExpression
	 * @generated
	 */
	EClass getRangeExpression();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.RangeExpression#getOperands <em>Operands</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Operands</em>'.
	 * @see org.eclipselabs.mscript.language.ast.RangeExpression#getOperands()
	 * @see #getRangeExpression()
	 * @generated
	 */
	EReference getRangeExpression_Operands();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ImpliesExpression <em>Implies Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Implies Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ImpliesExpression
	 * @generated
	 */
	EClass getImpliesExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ImpliesExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ImpliesExpression#getLeftOperand()
	 * @see #getImpliesExpression()
	 * @generated
	 */
	EReference getImpliesExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ImpliesExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ImpliesExpression#getRightOperand()
	 * @see #getImpliesExpression()
	 * @generated
	 */
	EReference getImpliesExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.LogicalOrExpression <em>Logical Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Or Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LogicalOrExpression
	 * @generated
	 */
	EClass getLogicalOrExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.LogicalOrExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LogicalOrExpression#getLeftOperand()
	 * @see #getLogicalOrExpression()
	 * @generated
	 */
	EReference getLogicalOrExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.LogicalOrExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LogicalOrExpression#getRightOperand()
	 * @see #getLogicalOrExpression()
	 * @generated
	 */
	EReference getLogicalOrExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.LogicalAndExpression <em>Logical And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical And Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LogicalAndExpression
	 * @generated
	 */
	EClass getLogicalAndExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.LogicalAndExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LogicalAndExpression#getLeftOperand()
	 * @see #getLogicalAndExpression()
	 * @generated
	 */
	EReference getLogicalAndExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.LogicalAndExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.LogicalAndExpression#getRightOperand()
	 * @see #getLogicalAndExpression()
	 * @generated
	 */
	EReference getLogicalAndExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.EqualityExpression <em>Equality Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Equality Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.EqualityExpression
	 * @generated
	 */
	EClass getEqualityExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.EqualityExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.EqualityExpression#getLeftOperand()
	 * @see #getEqualityExpression()
	 * @generated
	 */
	EReference getEqualityExpression_LeftOperand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.EqualityExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.EqualityExpression#getOperator()
	 * @see #getEqualityExpression()
	 * @generated
	 */
	EAttribute getEqualityExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.EqualityExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.EqualityExpression#getRightOperand()
	 * @see #getEqualityExpression()
	 * @generated
	 */
	EReference getEqualityExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.RelationalExpression <em>Relational Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Relational Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.RelationalExpression
	 * @generated
	 */
	EClass getRelationalExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.RelationalExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.RelationalExpression#getLeftOperand()
	 * @see #getRelationalExpression()
	 * @generated
	 */
	EReference getRelationalExpression_LeftOperand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.RelationalExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.RelationalExpression#getOperator()
	 * @see #getRelationalExpression()
	 * @generated
	 */
	EAttribute getRelationalExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.RelationalExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.RelationalExpression#getRightOperand()
	 * @see #getRelationalExpression()
	 * @generated
	 */
	EReference getRelationalExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.TypeTestExpression <em>Type Test Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Type Test Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.TypeTestExpression
	 * @generated
	 */
	EClass getTypeTestExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.TypeTestExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.TypeTestExpression#getExpression()
	 * @see #getTypeTestExpression()
	 * @generated
	 */
	EReference getTypeTestExpression_Expression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.TypeTestExpression#getType <em>Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Type</em>'.
	 * @see org.eclipselabs.mscript.language.ast.TypeTestExpression#getType()
	 * @see #getTypeTestExpression()
	 * @generated
	 */
	EReference getTypeTestExpression_Type();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.AdditiveExpression <em>Additive Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Additive Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.AdditiveExpression
	 * @generated
	 */
	EClass getAdditiveExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.AdditiveExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.AdditiveExpression#getOperator()
	 * @see #getAdditiveExpression()
	 * @generated
	 */
	EAttribute getAdditiveExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.AdditiveExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.AdditiveExpression#getLeftOperand()
	 * @see #getAdditiveExpression()
	 * @generated
	 */
	EReference getAdditiveExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.AdditiveExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.AdditiveExpression#getRightOperand()
	 * @see #getAdditiveExpression()
	 * @generated
	 */
	EReference getAdditiveExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.MultiplicativeExpression <em>Multiplicative Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Multiplicative Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.MultiplicativeExpression
	 * @generated
	 */
	EClass getMultiplicativeExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.MultiplicativeExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.MultiplicativeExpression#getOperator()
	 * @see #getMultiplicativeExpression()
	 * @generated
	 */
	EAttribute getMultiplicativeExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.MultiplicativeExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.MultiplicativeExpression#getLeftOperand()
	 * @see #getMultiplicativeExpression()
	 * @generated
	 */
	EReference getMultiplicativeExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.MultiplicativeExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.MultiplicativeExpression#getRightOperand()
	 * @see #getMultiplicativeExpression()
	 * @generated
	 */
	EReference getMultiplicativeExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.PowerExpression <em>Power Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Power Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.PowerExpression
	 * @generated
	 */
	EClass getPowerExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.PowerExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.PowerExpression#getOperand()
	 * @see #getPowerExpression()
	 * @generated
	 */
	EReference getPowerExpression_Operand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.PowerExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.PowerExpression#getOperator()
	 * @see #getPowerExpression()
	 * @generated
	 */
	EAttribute getPowerExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.PowerExpression#getExponent <em>Exponent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Exponent</em>'.
	 * @see org.eclipselabs.mscript.language.ast.PowerExpression#getExponent()
	 * @see #getPowerExpression()
	 * @generated
	 */
	EReference getPowerExpression_Exponent();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.UnaryExpression <em>Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Unary Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.UnaryExpression
	 * @generated
	 */
	EClass getUnaryExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.UnaryExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.UnaryExpression#getOperator()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EAttribute getUnaryExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.UnaryExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.UnaryExpression#getOperand()
	 * @see #getUnaryExpression()
	 * @generated
	 */
	EReference getUnaryExpression_Operand();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.PostfixExpression <em>Postfix Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postfix Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.PostfixExpression
	 * @generated
	 */
	EClass getPostfixExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.PostfixExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.PostfixExpression#getOperand()
	 * @see #getPostfixExpression()
	 * @generated
	 */
	EReference getPostfixExpression_Operand();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.PostfixExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.PostfixExpression#getOperator()
	 * @see #getPostfixExpression()
	 * @generated
	 */
	EAttribute getPostfixExpression_Operator();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.FeatureCall <em>Feature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Call</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FeatureCall
	 * @generated
	 */
	EClass getFeatureCall();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.ast.FeatureCall#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FeatureCall#getFeature()
	 * @see #getFeatureCall()
	 * @generated
	 */
	EReference getFeatureCall_Feature();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.VariableAccess <em>Variable Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Access</em>'.
	 * @see org.eclipselabs.mscript.language.ast.VariableAccess
	 * @generated
	 */
	EClass getVariableAccess();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.VariableAccess#getStepExpression <em>Step Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Step Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.VariableAccess#getStepExpression()
	 * @see #getVariableAccess()
	 * @generated
	 */
	EReference getVariableAccess_StepExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.StepExpression <em>Step Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.StepExpression
	 * @generated
	 */
	EClass getStepExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.RangeStepExpression <em>Range Step Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Range Step Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.RangeStepExpression
	 * @generated
	 */
	EClass getRangeStepExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.RangeStepExpression#getStart <em>Start</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Start</em>'.
	 * @see org.eclipselabs.mscript.language.ast.RangeStepExpression#getStart()
	 * @see #getRangeStepExpression()
	 * @generated
	 */
	EReference getRangeStepExpression_Start();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.RangeStepExpression#getEnd <em>End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>End</em>'.
	 * @see org.eclipselabs.mscript.language.ast.RangeStepExpression#getEnd()
	 * @see #getRangeStepExpression()
	 * @generated
	 */
	EReference getRangeStepExpression_End();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.AdditiveStepExpression <em>Additive Step Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Additive Step Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.AdditiveStepExpression
	 * @generated
	 */
	EClass getAdditiveStepExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.AdditiveStepExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.AdditiveStepExpression#getOperator()
	 * @see #getAdditiveStepExpression()
	 * @generated
	 */
	EAttribute getAdditiveStepExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.AdditiveStepExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.AdditiveStepExpression#getLeftOperand()
	 * @see #getAdditiveStepExpression()
	 * @generated
	 */
	EReference getAdditiveStepExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.AdditiveStepExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.AdditiveStepExpression#getRightOperand()
	 * @see #getAdditiveStepExpression()
	 * @generated
	 */
	EReference getAdditiveStepExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.NegateStepExpression <em>Negate Step Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Negate Step Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.NegateStepExpression
	 * @generated
	 */
	EClass getNegateStepExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.NegateStepExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.eclipselabs.mscript.language.ast.NegateStepExpression#getOperand()
	 * @see #getNegateStepExpression()
	 * @generated
	 */
	EReference getNegateStepExpression_Operand();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.PrimitiveStepExpression <em>Primitive Step Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Step Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.PrimitiveStepExpression
	 * @generated
	 */
	EClass getPrimitiveStepExpression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.StepLiteral <em>Step Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step Literal</em>'.
	 * @see org.eclipselabs.mscript.language.ast.StepLiteral
	 * @generated
	 */
	EClass getStepLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.StepLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.eclipselabs.mscript.language.ast.StepLiteral#getValue()
	 * @see #getStepLiteral()
	 * @generated
	 */
	EAttribute getStepLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.StepN <em>Step N</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Step N</em>'.
	 * @see org.eclipselabs.mscript.language.ast.StepN
	 * @generated
	 */
	EClass getStepN();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.FunctionCall <em>Function Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function Call</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionCall
	 * @generated
	 */
	EClass getFunctionCall();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.FunctionCall#getArguments <em>Arguments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Arguments</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionCall#getArguments()
	 * @see #getFunctionCall()
	 * @generated
	 */
	EReference getFunctionCall_Arguments();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.MemberVariableAccess <em>Member Variable Access</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Member Variable Access</em>'.
	 * @see org.eclipselabs.mscript.language.ast.MemberVariableAccess
	 * @generated
	 */
	EClass getMemberVariableAccess();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.MemberVariableAccess#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipselabs.mscript.language.ast.MemberVariableAccess#getTarget()
	 * @see #getMemberVariableAccess()
	 * @generated
	 */
	EReference getMemberVariableAccess_Target();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.ast.MemberVariableAccess#getMemberVariable <em>Member Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Member Variable</em>'.
	 * @see org.eclipselabs.mscript.language.ast.MemberVariableAccess#getMemberVariable()
	 * @see #getMemberVariableAccess()
	 * @generated
	 */
	EReference getMemberVariableAccess_MemberVariable();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.AlgorithmExpression <em>Algorithm Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Algorithm Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.AlgorithmExpression
	 * @generated
	 */
	EClass getAlgorithmExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.AlgorithmExpression#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipselabs.mscript.language.ast.AlgorithmExpression#getBody()
	 * @see #getAlgorithmExpression()
	 * @generated
	 */
	EReference getAlgorithmExpression_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Compound <em>Compound</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Compound</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Compound
	 * @generated
	 */
	EClass getCompound();

	/**
	 * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.Compound#getStatements <em>Statements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Statements</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Compound#getStatements()
	 * @see #getCompound()
	 * @generated
	 */
	EReference getCompound_Statements();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Statement <em>Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Statement</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Statement
	 * @generated
	 */
	EClass getStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Assignment <em>Assignment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Assignment
	 * @generated
	 */
	EClass getAssignment();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.Assignment#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Target</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Assignment#getTarget()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Target();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.Assignment#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.Assignment#getExpression()
	 * @see #getAssignment()
	 * @generated
	 */
	EReference getAssignment_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.VariableDeclaration <em>Variable Declaration</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Variable Declaration</em>'.
	 * @see org.eclipselabs.mscript.language.ast.VariableDeclaration
	 * @generated
	 */
	EClass getVariableDeclaration();

	/**
	 * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.VariableDeclaration#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see org.eclipselabs.mscript.language.ast.VariableDeclaration#getName()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EAttribute getVariableDeclaration_Name();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.VariableDeclaration#getInitializer <em>Initializer</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Initializer</em>'.
	 * @see org.eclipselabs.mscript.language.ast.VariableDeclaration#getInitializer()
	 * @see #getVariableDeclaration()
	 * @generated
	 */
	EReference getVariableDeclaration_Initializer();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.IfStatement <em>If Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>If Statement</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IfStatement
	 * @generated
	 */
	EClass getIfStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IfStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IfStatement#getCondition()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IfStatement#getThenStatement <em>Then Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Then Statement</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IfStatement#getThenStatement()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_ThenStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IfStatement#getElseStatement <em>Else Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Else Statement</em>'.
	 * @see org.eclipselabs.mscript.language.ast.IfStatement#getElseStatement()
	 * @see #getIfStatement()
	 * @generated
	 */
	EReference getIfStatement_ElseStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.WhileStatement <em>While Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>While Statement</em>'.
	 * @see org.eclipselabs.mscript.language.ast.WhileStatement
	 * @generated
	 */
	EClass getWhileStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.WhileStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.WhileStatement#getCondition()
	 * @see #getWhileStatement()
	 * @generated
	 */
	EReference getWhileStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.WhileStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipselabs.mscript.language.ast.WhileStatement#getBody()
	 * @see #getWhileStatement()
	 * @generated
	 */
	EReference getWhileStatement_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.DoWhileStatement <em>Do While Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Do While Statement</em>'.
	 * @see org.eclipselabs.mscript.language.ast.DoWhileStatement
	 * @generated
	 */
	EClass getDoWhileStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.DoWhileStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.DoWhileStatement#getCondition()
	 * @see #getDoWhileStatement()
	 * @generated
	 */
	EReference getDoWhileStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.DoWhileStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipselabs.mscript.language.ast.DoWhileStatement#getBody()
	 * @see #getDoWhileStatement()
	 * @generated
	 */
	EReference getDoWhileStatement_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ForStatement <em>For Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>For Statement</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ForStatement
	 * @generated
	 */
	EClass getForStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ForStatement#getDeclaredIterationVariable <em>Declared Iteration Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Declared Iteration Variable</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ForStatement#getDeclaredIterationVariable()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_DeclaredIterationVariable();

	/**
	 * Returns the meta object for the reference '{@link org.eclipselabs.mscript.language.ast.ForStatement#getIterationVariable <em>Iteration Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Iteration Variable</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ForStatement#getIterationVariable()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_IterationVariable();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ForStatement#getCollectionExpression <em>Collection Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Collection Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ForStatement#getCollectionExpression()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_CollectionExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ForStatement#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ForStatement#getCondition()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ForStatement#getBody <em>Body</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Body</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ForStatement#getBody()
	 * @see #getForStatement()
	 * @generated
	 */
	EReference getForStatement_Body();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ContinueStatement <em>Continue Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Continue Statement</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ContinueStatement
	 * @generated
	 */
	EClass getContinueStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.BreakStatement <em>Break Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Break Statement</em>'.
	 * @see org.eclipselabs.mscript.language.ast.BreakStatement
	 * @generated
	 */
	EClass getBreakStatement();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ReturnStatement <em>Return Statement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Return Statement</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ReturnStatement
	 * @generated
	 */
	EClass getReturnStatement();

	/**
	 * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ReturnStatement#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.eclipselabs.mscript.language.ast.ReturnStatement#getExpression()
	 * @see #getReturnStatement()
	 * @generated
	 */
	EReference getReturnStatement_Expression();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.BuiltinDefinition <em>Builtin Definition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Builtin Definition</em>'.
	 * @see org.eclipselabs.mscript.language.ast.BuiltinDefinition
	 * @generated
	 */
	EClass getBuiltinDefinition();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.BuiltinFunction <em>Builtin Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Builtin Function</em>'.
	 * @see org.eclipselabs.mscript.language.ast.BuiltinFunction
	 * @generated
	 */
	EClass getBuiltinFunction();

	/**
	 * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.BuiltinVariable <em>Builtin Variable</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Builtin Variable</em>'.
	 * @see org.eclipselabs.mscript.language.ast.BuiltinVariable
	 * @generated
	 */
	EClass getBuiltinVariable();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.FunctionKind <em>Function Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Function Kind</em>'.
	 * @see org.eclipselabs.mscript.language.ast.FunctionKind
	 * @generated
	 */
	EEnum getFunctionKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.AssertionStatusKind <em>Assertion Status Kind</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Assertion Status Kind</em>'.
	 * @see org.eclipselabs.mscript.language.ast.AssertionStatusKind
	 * @generated
	 */
	EEnum getAssertionStatusKind();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.EqualityOperator <em>Equality Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Equality Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.EqualityOperator
	 * @generated
	 */
	EEnum getEqualityOperator();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.RelationalOperator <em>Relational Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relational Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.RelationalOperator
	 * @generated
	 */
	EEnum getRelationalOperator();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.AdditiveOperator <em>Additive Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Additive Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.AdditiveOperator
	 * @generated
	 */
	EEnum getAdditiveOperator();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.MultiplicativeOperator <em>Multiplicative Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Multiplicative Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.MultiplicativeOperator
	 * @generated
	 */
	EEnum getMultiplicativeOperator();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.PowerOperator <em>Power Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Power Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.PowerOperator
	 * @generated
	 */
	EEnum getPowerOperator();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.UnaryOperator <em>Unary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.UnaryOperator
	 * @generated
	 */
	EEnum getUnaryOperator();

	/**
	 * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.PostfixOperator <em>Postfix Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Postfix Operator</em>'.
	 * @see org.eclipselabs.mscript.language.ast.PostfixOperator
	 * @generated
	 */
	EEnum getPostfixOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AstFactory getAstFactory();

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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ModuleImpl <em>Module</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ModuleImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getModule()
		 * @generated
		 */
		EClass MODULE = eINSTANCE.getModule();

		/**
		 * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MODULE__DEFINITIONS = eINSTANCE.getModule_Definitions();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.DefinitionImpl <em>Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.DefinitionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getDefinition()
		 * @generated
		 */
		EClass DEFINITION = eINSTANCE.getDefinition();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DEFINITION__NAME = eINSTANCE.getDefinition_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.DataTypeDefinitionImpl <em>Data Type Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.DataTypeDefinitionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getDataTypeDefinition()
		 * @generated
		 */
		EClass DATA_TYPE_DEFINITION = eINSTANCE.getDataTypeDefinition();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.EnumerationDefinitionImpl <em>Enumeration Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.EnumerationDefinitionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEnumerationDefinition()
		 * @generated
		 */
		EClass ENUMERATION_DEFINITION = eINSTANCE.getEnumerationDefinition();

		/**
		 * The meta object literal for the '<em><b>Literal Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ENUMERATION_DEFINITION__LITERAL_DECLARATIONS = eINSTANCE.getEnumerationDefinition_LiteralDeclarations();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.EnumerationLiteralDeclarationImpl <em>Enumeration Literal Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.EnumerationLiteralDeclarationImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEnumerationLiteralDeclaration()
		 * @generated
		 */
		EClass ENUMERATION_LITERAL_DECLARATION = eINSTANCE.getEnumerationLiteralDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ENUMERATION_LITERAL_DECLARATION__NAME = eINSTANCE.getEnumerationLiteralDeclaration_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.TypedefDeclarationImpl <em>Typedef Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.TypedefDeclarationImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTypedefDeclaration()
		 * @generated
		 */
		EClass TYPEDEF_DECLARATION = eINSTANCE.getTypedefDeclaration();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPEDEF_DECLARATION__TYPE = eINSTANCE.getTypedefDeclaration_Type();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.StructDefinitionImpl <em>Struct Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.StructDefinitionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStructDefinition()
		 * @generated
		 */
		EClass STRUCT_DEFINITION = eINSTANCE.getStructDefinition();

		/**
		 * The meta object literal for the '<em><b>Member Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCT_DEFINITION__MEMBER_DECLARATIONS = eINSTANCE.getStructDefinition_MemberDeclarations();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.StructMemberDeclarationImpl <em>Struct Member Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.StructMemberDeclarationImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStructMemberDeclaration()
		 * @generated
		 */
		EClass STRUCT_MEMBER_DECLARATION = eINSTANCE.getStructMemberDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STRUCT_MEMBER_DECLARATION__NAME = eINSTANCE.getStructMemberDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference STRUCT_MEMBER_DECLARATION__TYPE = eINSTANCE.getStructMemberDeclaration_Type();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl <em>Function Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.FunctionDefinitionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFunctionDefinition()
		 * @generated
		 */
		EClass FUNCTION_DEFINITION = eINSTANCE.getFunctionDefinition();

		/**
		 * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_DEFINITION__KIND = eINSTANCE.getFunctionDefinition_Kind();

		/**
		 * The meta object literal for the '<em><b>Template Parameter Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DEFINITION__TEMPLATE_PARAMETER_DECLARATIONS = eINSTANCE.getFunctionDefinition_TemplateParameterDeclarations();

		/**
		 * The meta object literal for the '<em><b>Input Parameter Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DEFINITION__INPUT_PARAMETER_DECLARATIONS = eINSTANCE.getFunctionDefinition_InputParameterDeclarations();

		/**
		 * The meta object literal for the '<em><b>Output Parameter Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DEFINITION__OUTPUT_PARAMETER_DECLARATIONS = eINSTANCE.getFunctionDefinition_OutputParameterDeclarations();

		/**
		 * The meta object literal for the '<em><b>Checks</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DEFINITION__CHECKS = eINSTANCE.getFunctionDefinition_Checks();

		/**
		 * The meta object literal for the '<em><b>Assertions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DEFINITION__ASSERTIONS = eINSTANCE.getFunctionDefinition_Assertions();

		/**
		 * The meta object literal for the '<em><b>Function Object Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DEFINITION__FUNCTION_OBJECT_DECLARATIONS = eINSTANCE.getFunctionDefinition_FunctionObjectDeclarations();

		/**
		 * The meta object literal for the '<em><b>State Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DEFINITION__STATE_VARIABLE_DECLARATIONS = eINSTANCE.getFunctionDefinition_StateVariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Equations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_DEFINITION__EQUATIONS = eINSTANCE.getFunctionDefinition_Equations();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.CheckImpl <em>Check</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.CheckImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getCheck()
		 * @generated
		 */
		EClass CHECK = eINSTANCE.getCheck();

		/**
		 * The meta object literal for the '<em><b>Function</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK__FUNCTION = eINSTANCE.getCheck_Function();

		/**
		 * The meta object literal for the '<em><b>Template Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK__TEMPLATE_ARGUMENTS = eINSTANCE.getCheck_TemplateArguments();

		/**
		 * The meta object literal for the '<em><b>Input Parameter Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK__INPUT_PARAMETER_TYPES = eINSTANCE.getCheck_InputParameterTypes();

		/**
		 * The meta object literal for the '<em><b>Output Parameter Types</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CHECK__OUTPUT_PARAMETER_TYPES = eINSTANCE.getCheck_OutputParameterTypes();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.CallableElementImpl <em>Callable Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.CallableElementImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getCallableElement()
		 * @generated
		 */
		EClass CALLABLE_ELEMENT = eINSTANCE.getCallableElement();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ParameterDeclarationImpl <em>Parameter Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ParameterDeclarationImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getParameterDeclaration()
		 * @generated
		 */
		EClass PARAMETER_DECLARATION = eINSTANCE.getParameterDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PARAMETER_DECLARATION__NAME = eINSTANCE.getParameterDeclaration_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.TemplateParameterDeclarationImpl <em>Template Parameter Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.TemplateParameterDeclarationImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTemplateParameterDeclaration()
		 * @generated
		 */
		EClass TEMPLATE_PARAMETER_DECLARATION = eINSTANCE.getTemplateParameterDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.InputParameterDeclarationImpl <em>Input Parameter Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.InputParameterDeclarationImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getInputParameterDeclaration()
		 * @generated
		 */
		EClass INPUT_PARAMETER_DECLARATION = eINSTANCE.getInputParameterDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.OutputParameterDeclarationImpl <em>Output Parameter Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.OutputParameterDeclarationImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getOutputParameterDeclaration()
		 * @generated
		 */
		EClass OUTPUT_PARAMETER_DECLARATION = eINSTANCE.getOutputParameterDeclaration();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.AssertionImpl <em>Assertion</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.AssertionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAssertion()
		 * @generated
		 */
		EClass ASSERTION = eINSTANCE.getAssertion();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERTION__STATIC = eINSTANCE.getAssertion_Static();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERTION__CONDITION = eINSTANCE.getAssertion_Condition();

		/**
		 * The meta object literal for the '<em><b>Status Kind</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSERTION__STATUS_KIND = eINSTANCE.getAssertion_StatusKind();

		/**
		 * The meta object literal for the '<em><b>Message</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSERTION__MESSAGE = eINSTANCE.getAssertion_Message();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.StateVariableDeclarationImpl <em>State Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.StateVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStateVariableDeclaration()
		 * @generated
		 */
		EClass STATE_VARIABLE_DECLARATION = eINSTANCE.getStateVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STATE_VARIABLE_DECLARATION__NAME = eINSTANCE.getStateVariableDeclaration_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.FunctionObjectDeclarationImpl <em>Function Object Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.FunctionObjectDeclarationImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFunctionObjectDeclaration()
		 * @generated
		 */
		EClass FUNCTION_OBJECT_DECLARATION = eINSTANCE.getFunctionObjectDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION_OBJECT_DECLARATION__NAME = eINSTANCE.getFunctionObjectDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Function Name</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_OBJECT_DECLARATION__FUNCTION_NAME = eINSTANCE.getFunctionObjectDeclaration_FunctionName();

		/**
		 * The meta object literal for the '<em><b>Template Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_OBJECT_DECLARATION__TEMPLATE_ARGUMENTS = eINSTANCE.getFunctionObjectDeclaration_TemplateArguments();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.EquationImpl <em>Equation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.EquationImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEquation()
		 * @generated
		 */
		EClass EQUATION = eINSTANCE.getEquation();

		/**
		 * The meta object literal for the '<em><b>Initial</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUATION__INITIAL = eINSTANCE.getEquation_Initial();

		/**
		 * The meta object literal for the '<em><b>Left Hand Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION__LEFT_HAND_SIDE = eINSTANCE.getEquation_LeftHandSide();

		/**
		 * The meta object literal for the '<em><b>Right Hand Side</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUATION__RIGHT_HAND_SIDE = eINSTANCE.getEquation_RightHandSide();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.DataTypeSpecifierImpl <em>Data Type Specifier</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.DataTypeSpecifierImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getDataTypeSpecifier()
		 * @generated
		 */
		EClass DATA_TYPE_SPECIFIER = eINSTANCE.getDataTypeSpecifier();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_SPECIFIER__TYPE = eINSTANCE.getDataTypeSpecifier_Type();

		/**
		 * The meta object literal for the '<em><b>Defined Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_TYPE_SPECIFIER__DEFINED_TYPE = eINSTANCE.getDataTypeSpecifier_DefinedType();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.LetExpressionImpl <em>Let Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.LetExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLetExpression()
		 * @generated
		 */
		EClass LET_EXPRESSION = eINSTANCE.getLetExpression();

		/**
		 * The meta object literal for the '<em><b>Variable Declarations</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXPRESSION__VARIABLE_DECLARATIONS = eINSTANCE.getLetExpression_VariableDeclarations();

		/**
		 * The meta object literal for the '<em><b>Target Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXPRESSION__TARGET_EXPRESSION = eINSTANCE.getLetExpression_TargetExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.LetExpressionVariableDeclarationImpl <em>Let Expression Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.LetExpressionVariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLetExpressionVariableDeclaration()
		 * @generated
		 */
		EClass LET_EXPRESSION_VARIABLE_DECLARATION = eINSTANCE.getLetExpressionVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXPRESSION_VARIABLE_DECLARATION__PARTS = eINSTANCE.getLetExpressionVariableDeclaration_Parts();

		/**
		 * The meta object literal for the '<em><b>Assigned Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference LET_EXPRESSION_VARIABLE_DECLARATION__ASSIGNED_EXPRESSION = eINSTANCE.getLetExpressionVariableDeclaration_AssignedExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.LetExpressionVariableDeclarationPartImpl <em>Let Expression Variable Declaration Part</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.LetExpressionVariableDeclarationPartImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLetExpressionVariableDeclarationPart()
		 * @generated
		 */
		EClass LET_EXPRESSION_VARIABLE_DECLARATION_PART = eINSTANCE.getLetExpressionVariableDeclarationPart();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute LET_EXPRESSION_VARIABLE_DECLARATION_PART__NAME = eINSTANCE.getLetExpressionVariableDeclarationPart_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.IfExpressionImpl <em>If Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.IfExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIfExpression()
		 * @generated
		 */
		EClass IF_EXPRESSION = eINSTANCE.getIfExpression();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute IF_EXPRESSION__STATIC = eINSTANCE.getIfExpression_Static();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXPRESSION__CONDITION = eINSTANCE.getIfExpression_Condition();

		/**
		 * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXPRESSION__THEN_EXPRESSION = eINSTANCE.getIfExpression_ThenExpression();

		/**
		 * The meta object literal for the '<em><b>Else Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_EXPRESSION__ELSE_EXPRESSION = eINSTANCE.getIfExpression_ElseExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.SwitchExpressionImpl <em>Switch Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.SwitchExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getSwitchExpression()
		 * @generated
		 */
		EClass SWITCH_EXPRESSION = eINSTANCE.getSwitchExpression();

		/**
		 * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SWITCH_EXPRESSION__STATIC = eINSTANCE.getSwitchExpression_Static();

		/**
		 * The meta object literal for the '<em><b>Control Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_EXPRESSION__CONTROL_EXPRESSION = eINSTANCE.getSwitchExpression_ControlExpression();

		/**
		 * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_EXPRESSION__CASES = eINSTANCE.getSwitchExpression_Cases();

		/**
		 * The meta object literal for the '<em><b>Default Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_EXPRESSION__DEFAULT_EXPRESSION = eINSTANCE.getSwitchExpression_DefaultExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.SwitchCaseImpl <em>Switch Case</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.SwitchCaseImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getSwitchCase()
		 * @generated
		 */
		EClass SWITCH_CASE = eINSTANCE.getSwitchCase();

		/**
		 * The meta object literal for the '<em><b>Case Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_CASE__CASE_EXPRESSION = eINSTANCE.getSwitchCase_CaseExpression();

		/**
		 * The meta object literal for the '<em><b>Result Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SWITCH_CASE__RESULT_EXPRESSION = eINSTANCE.getSwitchCase_ResultExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayElementAccessImpl <em>Array Element Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ArrayElementAccessImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayElementAccess()
		 * @generated
		 */
		EClass ARRAY_ELEMENT_ACCESS = eINSTANCE.getArrayElementAccess();

		/**
		 * The meta object literal for the '<em><b>Array</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_ELEMENT_ACCESS__ARRAY = eINSTANCE.getArrayElementAccess_Array();

		/**
		 * The meta object literal for the '<em><b>Subscripts</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_ELEMENT_ACCESS__SUBSCRIPTS = eINSTANCE.getArrayElementAccess_Subscripts();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ArraySubscriptImpl <em>Array Subscript</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ArraySubscriptImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArraySubscript()
		 * @generated
		 */
		EClass ARRAY_SUBSCRIPT = eINSTANCE.getArraySubscript();

		/**
		 * The meta object literal for the '<em><b>Slice</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARRAY_SUBSCRIPT__SLICE = eINSTANCE.getArraySubscript_Slice();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_SUBSCRIPT__EXPRESSION = eINSTANCE.getArraySubscript_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.IterationCallImpl <em>Iteration Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.IterationCallImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIterationCall()
		 * @generated
		 */
		EClass ITERATION_CALL = eINSTANCE.getIterationCall();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION_CALL__TARGET = eINSTANCE.getIterationCall_Target();

		/**
		 * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATION_CALL__IDENTIFIER = eINSTANCE.getIterationCall_Identifier();

		/**
		 * The meta object literal for the '<em><b>Variables</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION_CALL__VARIABLES = eINSTANCE.getIterationCall_Variables();

		/**
		 * The meta object literal for the '<em><b>Accumulator</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION_CALL__ACCUMULATOR = eINSTANCE.getIterationCall_Accumulator();

		/**
		 * The meta object literal for the '<em><b>Break Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION_CALL__BREAK_CONDITION = eINSTANCE.getIterationCall_BreakCondition();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION_CALL__EXPRESSION = eINSTANCE.getIterationCall_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.IterationVariableImpl <em>Iteration Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.IterationVariableImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIterationVariable()
		 * @generated
		 */
		EClass ITERATION_VARIABLE = eINSTANCE.getIterationVariable();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATION_VARIABLE__NAME = eINSTANCE.getIterationVariable_Name();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.IterationAccumulatorImpl <em>Iteration Accumulator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.IterationAccumulatorImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIterationAccumulator()
		 * @generated
		 */
		EClass ITERATION_ACCUMULATOR = eINSTANCE.getIterationAccumulator();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ITERATION_ACCUMULATOR__NAME = eINSTANCE.getIterationAccumulator_Name();

		/**
		 * The meta object literal for the '<em><b>Initializer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ITERATION_ACCUMULATOR__INITIALIZER = eINSTANCE.getIterationAccumulator_Initializer();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.DerivativeOperatorImpl <em>Derivative Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.DerivativeOperatorImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getDerivativeOperator()
		 * @generated
		 */
		EClass DERIVATIVE_OPERATOR = eINSTANCE.getDerivativeOperator();

		/**
		 * The meta object literal for the '<em><b>Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DERIVATIVE_OPERATOR__VARIABLE = eINSTANCE.getDerivativeOperator_Variable();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayConstructionOperatorImpl <em>Array Construction Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ArrayConstructionOperatorImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayConstructionOperator()
		 * @generated
		 */
		EClass ARRAY_CONSTRUCTION_OPERATOR = eINSTANCE.getArrayConstructionOperator();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_CONSTRUCTION_OPERATOR__EXPRESSIONS = eINSTANCE.getArrayConstructionOperator_Expressions();

		/**
		 * The meta object literal for the '<em><b>Iteration Clauses</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_CONSTRUCTION_OPERATOR__ITERATION_CLAUSES = eINSTANCE.getArrayConstructionOperator_IterationClauses();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayConstructionIterationClauseImpl <em>Array Construction Iteration Clause</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ArrayConstructionIterationClauseImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayConstructionIterationClause()
		 * @generated
		 */
		EClass ARRAY_CONSTRUCTION_ITERATION_CLAUSE = eINSTANCE.getArrayConstructionIterationClause();

		/**
		 * The meta object literal for the '<em><b>Variable Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ARRAY_CONSTRUCTION_ITERATION_CLAUSE__VARIABLE_NAME = eINSTANCE.getArrayConstructionIterationClause_VariableName();

		/**
		 * The meta object literal for the '<em><b>Collection Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_CONSTRUCTION_ITERATION_CLAUSE__COLLECTION_EXPRESSION = eINSTANCE.getArrayConstructionIterationClause_CollectionExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayConcatenationOperatorImpl <em>Array Concatenation Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ArrayConcatenationOperatorImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayConcatenationOperator()
		 * @generated
		 */
		EClass ARRAY_CONCATENATION_OPERATOR = eINSTANCE.getArrayConcatenationOperator();

		/**
		 * The meta object literal for the '<em><b>Rows</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ARRAY_CONCATENATION_OPERATOR__ROWS = eINSTANCE.getArrayConcatenationOperator_Rows();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ExpressionListImpl <em>Expression List</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ExpressionListImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getExpressionList()
		 * @generated
		 */
		EClass EXPRESSION_LIST = eINSTANCE.getExpressionList();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EXPRESSION_LIST__EXPRESSIONS = eINSTANCE.getExpressionList_Expressions();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitConstructionOperatorImpl <em>Unit Construction Operator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.UnitConstructionOperatorImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitConstructionOperator()
		 * @generated
		 */
		EClass UNIT_CONSTRUCTION_OPERATOR = eINSTANCE.getUnitConstructionOperator();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNIT_CONSTRUCTION_OPERATOR__UNIT = eINSTANCE.getUnitConstructionOperator_Unit();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ParenthesizedExpressionImpl <em>Parenthesized Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ParenthesizedExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getParenthesizedExpression()
		 * @generated
		 */
		EClass PARENTHESIZED_EXPRESSION = eINSTANCE.getParenthesizedExpression();

		/**
		 * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PARENTHESIZED_EXPRESSION__EXPRESSIONS = eINSTANCE.getParenthesizedExpression_Expressions();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.EndExpressionImpl <em>End Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.EndExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEndExpression()
		 * @generated
		 */
		EClass END_EXPRESSION = eINSTANCE.getEndExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.RangeExpressionImpl <em>Range Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.RangeExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRangeExpression()
		 * @generated
		 */
		EClass RANGE_EXPRESSION = eINSTANCE.getRangeExpression();

		/**
		 * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANGE_EXPRESSION__OPERANDS = eINSTANCE.getRangeExpression_Operands();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ImpliesExpressionImpl <em>Implies Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ImpliesExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getImpliesExpression()
		 * @generated
		 */
		EClass IMPLIES_EXPRESSION = eINSTANCE.getImpliesExpression();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLIES_EXPRESSION__LEFT_OPERAND = eINSTANCE.getImpliesExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IMPLIES_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getImpliesExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.LogicalOrExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLogicalOrExpression()
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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.LogicalAndExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLogicalAndExpression()
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
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.EqualityExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEqualityExpression()
		 * @generated
		 */
		EClass EQUALITY_EXPRESSION = eINSTANCE.getEqualityExpression();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUALITY_EXPRESSION__LEFT_OPERAND = eINSTANCE.getEqualityExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute EQUALITY_EXPRESSION__OPERATOR = eINSTANCE.getEqualityExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference EQUALITY_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getEqualityExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.RelationalExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRelationalExpression()
		 * @generated
		 */
		EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_EXPRESSION__LEFT_OPERAND = eINSTANCE.getRelationalExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RELATIONAL_EXPRESSION__OPERATOR = eINSTANCE.getRelationalExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RELATIONAL_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getRelationalExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.TypeTestExpressionImpl <em>Type Test Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.TypeTestExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTypeTestExpression()
		 * @generated
		 */
		EClass TYPE_TEST_EXPRESSION = eINSTANCE.getTypeTestExpression();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_TEST_EXPRESSION__EXPRESSION = eINSTANCE.getTypeTestExpression_Expression();

		/**
		 * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference TYPE_TEST_EXPRESSION__TYPE = eINSTANCE.getTypeTestExpression_Type();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.AdditiveExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAdditiveExpression()
		 * @generated
		 */
		EClass ADDITIVE_EXPRESSION = eINSTANCE.getAdditiveExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDITIVE_EXPRESSION__OPERATOR = eINSTANCE.getAdditiveExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDITIVE_EXPRESSION__LEFT_OPERAND = eINSTANCE.getAdditiveExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDITIVE_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getAdditiveExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.MultiplicativeExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplicativeExpression()
		 * @generated
		 */
		EClass MULTIPLICATIVE_EXPRESSION = eINSTANCE.getMultiplicativeExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute MULTIPLICATIVE_EXPRESSION__OPERATOR = eINSTANCE.getMultiplicativeExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICATIVE_EXPRESSION__LEFT_OPERAND = eINSTANCE.getMultiplicativeExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MULTIPLICATIVE_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getMultiplicativeExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.PowerExpressionImpl <em>Power Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.PowerExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPowerExpression()
		 * @generated
		 */
		EClass POWER_EXPRESSION = eINSTANCE.getPowerExpression();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_EXPRESSION__OPERAND = eINSTANCE.getPowerExpression_Operand();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POWER_EXPRESSION__OPERATOR = eINSTANCE.getPowerExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Exponent</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POWER_EXPRESSION__EXPONENT = eINSTANCE.getPowerExpression_Exponent();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.UnaryExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnaryExpression()
		 * @generated
		 */
		EClass UNARY_EXPRESSION = eINSTANCE.getUnaryExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute UNARY_EXPRESSION__OPERATOR = eINSTANCE.getUnaryExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference UNARY_EXPRESSION__OPERAND = eINSTANCE.getUnaryExpression_Operand();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.PostfixExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPostfixExpression()
		 * @generated
		 */
		EClass POSTFIX_EXPRESSION = eINSTANCE.getPostfixExpression();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference POSTFIX_EXPRESSION__OPERAND = eINSTANCE.getPostfixExpression_Operand();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute POSTFIX_EXPRESSION__OPERATOR = eINSTANCE.getPostfixExpression_Operator();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallImpl <em>Feature Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.FeatureCallImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFeatureCall()
		 * @generated
		 */
		EClass FEATURE_CALL = eINSTANCE.getFeatureCall();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CALL__FEATURE = eINSTANCE.getFeatureCall_Feature();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.VariableAccessImpl <em>Variable Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.VariableAccessImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getVariableAccess()
		 * @generated
		 */
		EClass VARIABLE_ACCESS = eINSTANCE.getVariableAccess();

		/**
		 * The meta object literal for the '<em><b>Step Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_ACCESS__STEP_EXPRESSION = eINSTANCE.getVariableAccess_StepExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.StepExpressionImpl <em>Step Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.StepExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStepExpression()
		 * @generated
		 */
		EClass STEP_EXPRESSION = eINSTANCE.getStepExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.RangeStepExpressionImpl <em>Range Step Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.RangeStepExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRangeStepExpression()
		 * @generated
		 */
		EClass RANGE_STEP_EXPRESSION = eINSTANCE.getRangeStepExpression();

		/**
		 * The meta object literal for the '<em><b>Start</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANGE_STEP_EXPRESSION__START = eINSTANCE.getRangeStepExpression_Start();

		/**
		 * The meta object literal for the '<em><b>End</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RANGE_STEP_EXPRESSION__END = eINSTANCE.getRangeStepExpression_End();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.AdditiveStepExpressionImpl <em>Additive Step Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.AdditiveStepExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAdditiveStepExpression()
		 * @generated
		 */
		EClass ADDITIVE_STEP_EXPRESSION = eINSTANCE.getAdditiveStepExpression();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ADDITIVE_STEP_EXPRESSION__OPERATOR = eINSTANCE.getAdditiveStepExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDITIVE_STEP_EXPRESSION__LEFT_OPERAND = eINSTANCE.getAdditiveStepExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ADDITIVE_STEP_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getAdditiveStepExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.NegateStepExpressionImpl <em>Negate Step Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.NegateStepExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNegateStepExpression()
		 * @generated
		 */
		EClass NEGATE_STEP_EXPRESSION = eINSTANCE.getNegateStepExpression();

		/**
		 * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NEGATE_STEP_EXPRESSION__OPERAND = eINSTANCE.getNegateStepExpression_Operand();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.PrimitiveStepExpressionImpl <em>Primitive Step Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.PrimitiveStepExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPrimitiveStepExpression()
		 * @generated
		 */
		EClass PRIMITIVE_STEP_EXPRESSION = eINSTANCE.getPrimitiveStepExpression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.StepLiteralImpl <em>Step Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.StepLiteralImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStepLiteral()
		 * @generated
		 */
		EClass STEP_LITERAL = eINSTANCE.getStepLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute STEP_LITERAL__VALUE = eINSTANCE.getStepLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.StepNImpl <em>Step N</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.StepNImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStepN()
		 * @generated
		 */
		EClass STEP_N = eINSTANCE.getStepN();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.FunctionCallImpl <em>Function Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.FunctionCallImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFunctionCall()
		 * @generated
		 */
		EClass FUNCTION_CALL = eINSTANCE.getFunctionCall();

		/**
		 * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION_CALL__ARGUMENTS = eINSTANCE.getFunctionCall_Arguments();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.MemberVariableAccessImpl <em>Member Variable Access</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.MemberVariableAccessImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMemberVariableAccess()
		 * @generated
		 */
		EClass MEMBER_VARIABLE_ACCESS = eINSTANCE.getMemberVariableAccess();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER_VARIABLE_ACCESS__TARGET = eINSTANCE.getMemberVariableAccess_Target();

		/**
		 * The meta object literal for the '<em><b>Member Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE = eINSTANCE.getMemberVariableAccess_MemberVariable();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.AlgorithmExpressionImpl <em>Algorithm Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.AlgorithmExpressionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAlgorithmExpression()
		 * @generated
		 */
		EClass ALGORITHM_EXPRESSION = eINSTANCE.getAlgorithmExpression();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ALGORITHM_EXPRESSION__BODY = eINSTANCE.getAlgorithmExpression_Body();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.CompoundImpl <em>Compound</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.CompoundImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getCompound()
		 * @generated
		 */
		EClass COMPOUND = eINSTANCE.getCompound();

		/**
		 * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPOUND__STATEMENTS = eINSTANCE.getCompound_Statements();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.StatementImpl <em>Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.StatementImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStatement()
		 * @generated
		 */
		EClass STATEMENT = eINSTANCE.getStatement();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.AssignmentImpl <em>Assignment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.AssignmentImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAssignment()
		 * @generated
		 */
		EClass ASSIGNMENT = eINSTANCE.getAssignment();

		/**
		 * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__TARGET = eINSTANCE.getAssignment_Target();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT__EXPRESSION = eINSTANCE.getAssignment_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.VariableDeclarationImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getVariableDeclaration()
		 * @generated
		 */
		EClass VARIABLE_DECLARATION = eINSTANCE.getVariableDeclaration();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VARIABLE_DECLARATION__NAME = eINSTANCE.getVariableDeclaration_Name();

		/**
		 * The meta object literal for the '<em><b>Initializer</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VARIABLE_DECLARATION__INITIALIZER = eINSTANCE.getVariableDeclaration_Initializer();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.IfStatementImpl <em>If Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.IfStatementImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIfStatement()
		 * @generated
		 */
		EClass IF_STATEMENT = eINSTANCE.getIfStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__CONDITION = eINSTANCE.getIfStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>Then Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__THEN_STATEMENT = eINSTANCE.getIfStatement_ThenStatement();

		/**
		 * The meta object literal for the '<em><b>Else Statement</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference IF_STATEMENT__ELSE_STATEMENT = eINSTANCE.getIfStatement_ElseStatement();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.WhileStatementImpl <em>While Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.WhileStatementImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getWhileStatement()
		 * @generated
		 */
		EClass WHILE_STATEMENT = eINSTANCE.getWhileStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_STATEMENT__CONDITION = eINSTANCE.getWhileStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference WHILE_STATEMENT__BODY = eINSTANCE.getWhileStatement_Body();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.DoWhileStatementImpl <em>Do While Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.DoWhileStatementImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getDoWhileStatement()
		 * @generated
		 */
		EClass DO_WHILE_STATEMENT = eINSTANCE.getDoWhileStatement();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DO_WHILE_STATEMENT__CONDITION = eINSTANCE.getDoWhileStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DO_WHILE_STATEMENT__BODY = eINSTANCE.getDoWhileStatement_Body();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ForStatementImpl <em>For Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ForStatementImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getForStatement()
		 * @generated
		 */
		EClass FOR_STATEMENT = eINSTANCE.getForStatement();

		/**
		 * The meta object literal for the '<em><b>Declared Iteration Variable</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__DECLARED_ITERATION_VARIABLE = eINSTANCE.getForStatement_DeclaredIterationVariable();

		/**
		 * The meta object literal for the '<em><b>Iteration Variable</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__ITERATION_VARIABLE = eINSTANCE.getForStatement_IterationVariable();

		/**
		 * The meta object literal for the '<em><b>Collection Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__COLLECTION_EXPRESSION = eINSTANCE.getForStatement_CollectionExpression();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__CONDITION = eINSTANCE.getForStatement_Condition();

		/**
		 * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FOR_STATEMENT__BODY = eINSTANCE.getForStatement_Body();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ContinueStatementImpl <em>Continue Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ContinueStatementImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getContinueStatement()
		 * @generated
		 */
		EClass CONTINUE_STATEMENT = eINSTANCE.getContinueStatement();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.BreakStatementImpl <em>Break Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.BreakStatementImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBreakStatement()
		 * @generated
		 */
		EClass BREAK_STATEMENT = eINSTANCE.getBreakStatement();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.ReturnStatementImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getReturnStatement()
		 * @generated
		 */
		EClass RETURN_STATEMENT = eINSTANCE.getReturnStatement();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RETURN_STATEMENT__EXPRESSION = eINSTANCE.getReturnStatement_Expression();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.BuiltinDefinitionImpl <em>Builtin Definition</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.BuiltinDefinitionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBuiltinDefinition()
		 * @generated
		 */
		EClass BUILTIN_DEFINITION = eINSTANCE.getBuiltinDefinition();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.BuiltinFunctionImpl <em>Builtin Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.BuiltinFunctionImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBuiltinFunction()
		 * @generated
		 */
		EClass BUILTIN_FUNCTION = eINSTANCE.getBuiltinFunction();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.BuiltinVariableImpl <em>Builtin Variable</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.impl.BuiltinVariableImpl
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBuiltinVariable()
		 * @generated
		 */
		EClass BUILTIN_VARIABLE = eINSTANCE.getBuiltinVariable();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.FunctionKind <em>Function Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.FunctionKind
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFunctionKind()
		 * @generated
		 */
		EEnum FUNCTION_KIND = eINSTANCE.getFunctionKind();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.AssertionStatusKind <em>Assertion Status Kind</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.AssertionStatusKind
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAssertionStatusKind()
		 * @generated
		 */
		EEnum ASSERTION_STATUS_KIND = eINSTANCE.getAssertionStatusKind();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.EqualityOperator <em>Equality Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.EqualityOperator
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEqualityOperator()
		 * @generated
		 */
		EEnum EQUALITY_OPERATOR = eINSTANCE.getEqualityOperator();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.RelationalOperator <em>Relational Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.RelationalOperator
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRelationalOperator()
		 * @generated
		 */
		EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.AdditiveOperator <em>Additive Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.AdditiveOperator
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAdditiveOperator()
		 * @generated
		 */
		EEnum ADDITIVE_OPERATOR = eINSTANCE.getAdditiveOperator();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.MultiplicativeOperator
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplicativeOperator()
		 * @generated
		 */
		EEnum MULTIPLICATIVE_OPERATOR = eINSTANCE.getMultiplicativeOperator();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.PowerOperator <em>Power Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.PowerOperator
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPowerOperator()
		 * @generated
		 */
		EEnum POWER_OPERATOR = eINSTANCE.getPowerOperator();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.UnaryOperator <em>Unary Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.UnaryOperator
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnaryOperator()
		 * @generated
		 */
		EEnum UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

		/**
		 * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.PostfixOperator <em>Postfix Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.eclipselabs.mscript.language.ast.PostfixOperator
		 * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPostfixOperator()
		 * @generated
		 */
		EEnum POSTFIX_OPERATOR = eINSTANCE.getPostfixOperator();

	}

} //AstPackage
