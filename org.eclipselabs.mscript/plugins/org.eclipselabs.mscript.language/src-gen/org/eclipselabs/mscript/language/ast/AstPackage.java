/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast;

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
 * @see org.eclipselabs.mscript.language.ast.AstFactory
 * @model kind="package"
 * @generated
 */
public interface AstPackage extends EPackage
{
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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.EnumerationDefinitionImpl <em>Enumeration Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.EnumerationDefinitionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEnumerationDefinition()
   * @generated
   */
  int ENUMERATION_DEFINITION = 3;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.EnumerationLiteralDeclarationImpl <em>Enumeration Literal Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.EnumerationLiteralDeclarationImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEnumerationLiteralDeclaration()
   * @generated
   */
  int ENUMERATION_LITERAL_DECLARATION = 4;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.TypeAliasDefinitionImpl <em>Type Alias Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.TypeAliasDefinitionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTypeAliasDefinition()
   * @generated
   */
  int TYPE_ALIAS_DEFINITION = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ALIAS_DEFINITION__NAME = DATA_TYPE_DEFINITION__NAME;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ALIAS_DEFINITION__TYPE = DATA_TYPE_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Alias Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_ALIAS_DEFINITION_FEATURE_COUNT = DATA_TYPE_DEFINITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RecordDefinitionImpl <em>Record Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.RecordDefinitionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRecordDefinition()
   * @generated
   */
  int RECORD_DEFINITION = 6;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_DEFINITION__NAME = DATA_TYPE_DEFINITION__NAME;

  /**
   * The feature id for the '<em><b>Field Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_DEFINITION__FIELD_DECLARATIONS = DATA_TYPE_DEFINITION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Record Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_DEFINITION_FEATURE_COUNT = DATA_TYPE_DEFINITION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RecordFieldDeclarationImpl <em>Record Field Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.RecordFieldDeclarationImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRecordFieldDeclaration()
   * @generated
   */
  int RECORD_FIELD_DECLARATION = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_DECLARATION__TYPE = 1;

  /**
   * The number of structural features of the '<em>Record Field Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_FIELD_DECLARATION_FEATURE_COUNT = 2;

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
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__NAME = DEFINITION__NAME;

  /**
   * The feature id for the '<em><b>Stateful</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__STATEFUL = DEFINITION_FEATURE_COUNT + 0;

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
   * The feature id for the '<em><b>Assertions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__ASSERTIONS = DEFINITION_FEATURE_COUNT + 4;

  /**
   * The feature id for the '<em><b>Function Object Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__FUNCTION_OBJECT_DECLARATIONS = DEFINITION_FEATURE_COUNT + 5;

  /**
   * The feature id for the '<em><b>State Variable Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__STATE_VARIABLE_DECLARATIONS = DEFINITION_FEATURE_COUNT + 6;

  /**
   * The feature id for the '<em><b>Equations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__EQUATIONS = DEFINITION_FEATURE_COUNT + 7;

  /**
   * The number of structural features of the '<em>Function Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION_FEATURE_COUNT = DEFINITION_FEATURE_COUNT + 8;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ParameterDeclarationImpl <em>Parameter Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ParameterDeclarationImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getParameterDeclaration()
   * @generated
   */
  int PARAMETER_DECLARATION = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLARATION__NAME = 0;

  /**
   * The number of structural features of the '<em>Parameter Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.AssertionImpl <em>Assertion</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.AssertionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAssertion()
   * @generated
   */
  int ASSERTION = 10;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.StateVariableDeclarationImpl <em>State Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.StateVariableDeclarationImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStateVariableDeclaration()
   * @generated
   */
  int STATE_VARIABLE_DECLARATION = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_VARIABLE_DECLARATION__NAME = 0;

  /**
   * The number of structural features of the '<em>State Variable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATE_VARIABLE_DECLARATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.FunctionObjectDeclarationImpl <em>Function Object Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.FunctionObjectDeclarationImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFunctionObjectDeclaration()
   * @generated
   */
  int FUNCTION_OBJECT_DECLARATION = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_OBJECT_DECLARATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Function Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_OBJECT_DECLARATION__FUNCTION_NAME = 1;

  /**
   * The feature id for the '<em><b>Template Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_OBJECT_DECLARATION__TEMPLATE_ARGUMENTS = 2;

  /**
   * The number of structural features of the '<em>Function Object Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_OBJECT_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.EquationImpl <em>Equation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.EquationImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEquation()
   * @generated
   */
  int EQUATION = 13;

  /**
   * The feature id for the '<em><b>Left Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUATION__LEFT_HAND_SIDE = 0;

  /**
   * The feature id for the '<em><b>Right Hand Side</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUATION__RIGHT_HAND_SIDE = 1;

  /**
   * The number of structural features of the '<em>Equation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.DataTypeSpecifierImpl <em>Data Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.DataTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getDataTypeSpecifier()
   * @generated
   */
  int DATA_TYPE_SPECIFIER = 14;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_SPECIFIER__DIMENSIONS = 0;

  /**
   * The number of structural features of the '<em>Data Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_SPECIFIER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.PrimitiveTypeSpecifierImpl <em>Primitive Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.PrimitiveTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPrimitiveTypeSpecifier()
   * @generated
   */
  int PRIMITIVE_TYPE_SPECIFIER = 15;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE_SPECIFIER__DIMENSIONS = DATA_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The number of structural features of the '<em>Primitive Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE_SPECIFIER_FEATURE_COUNT = DATA_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.NumericTypeSpecifierImpl <em>Numeric Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.NumericTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNumericTypeSpecifier()
   * @generated
   */
  int NUMERIC_TYPE_SPECIFIER = 16;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_TYPE_SPECIFIER__DIMENSIONS = PRIMITIVE_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_TYPE_SPECIFIER__UNIT = PRIMITIVE_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Numeric Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_TYPE_SPECIFIER_FEATURE_COUNT = PRIMITIVE_TYPE_SPECIFIER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RealTypeSpecifierImpl <em>Real Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.RealTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRealTypeSpecifier()
   * @generated
   */
  int REAL_TYPE_SPECIFIER = 17;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_TYPE_SPECIFIER__DIMENSIONS = NUMERIC_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_TYPE_SPECIFIER__UNIT = NUMERIC_TYPE_SPECIFIER__UNIT;

  /**
   * The number of structural features of the '<em>Real Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_TYPE_SPECIFIER_FEATURE_COUNT = NUMERIC_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IntegerTypeSpecifierImpl <em>Integer Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.IntegerTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIntegerTypeSpecifier()
   * @generated
   */
  int INTEGER_TYPE_SPECIFIER = 18;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE_SPECIFIER__DIMENSIONS = NUMERIC_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE_SPECIFIER__UNIT = NUMERIC_TYPE_SPECIFIER__UNIT;

  /**
   * The number of structural features of the '<em>Integer Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE_SPECIFIER_FEATURE_COUNT = NUMERIC_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ComplexTypeSpecifierImpl <em>Complex Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ComplexTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getComplexTypeSpecifier()
   * @generated
   */
  int COMPLEX_TYPE_SPECIFIER = 19;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_TYPE_SPECIFIER__DIMENSIONS = NUMERIC_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_TYPE_SPECIFIER__UNIT = NUMERIC_TYPE_SPECIFIER__UNIT;

  /**
   * The number of structural features of the '<em>Complex Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_TYPE_SPECIFIER_FEATURE_COUNT = NUMERIC_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.GaussianTypeSpecifierImpl <em>Gaussian Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.GaussianTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getGaussianTypeSpecifier()
   * @generated
   */
  int GAUSSIAN_TYPE_SPECIFIER = 20;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAUSSIAN_TYPE_SPECIFIER__DIMENSIONS = NUMERIC_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAUSSIAN_TYPE_SPECIFIER__UNIT = NUMERIC_TYPE_SPECIFIER__UNIT;

  /**
   * The number of structural features of the '<em>Gaussian Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAUSSIAN_TYPE_SPECIFIER_FEATURE_COUNT = NUMERIC_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.BooleanTypeSpecifierImpl <em>Boolean Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.BooleanTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBooleanTypeSpecifier()
   * @generated
   */
  int BOOLEAN_TYPE_SPECIFIER = 21;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE_SPECIFIER__DIMENSIONS = PRIMITIVE_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The number of structural features of the '<em>Boolean Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_TYPE_SPECIFIER_FEATURE_COUNT = PRIMITIVE_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.StringTypeSpecifierImpl <em>String Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.StringTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStringTypeSpecifier()
   * @generated
   */
  int STRING_TYPE_SPECIFIER = 22;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE_SPECIFIER__DIMENSIONS = PRIMITIVE_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The number of structural features of the '<em>String Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_TYPE_SPECIFIER_FEATURE_COUNT = PRIMITIVE_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.NamedTypeSpecifierImpl <em>Named Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.NamedTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNamedTypeSpecifier()
   * @generated
   */
  int NAMED_TYPE_SPECIFIER = 23;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE_SPECIFIER__DIMENSIONS = DATA_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The feature id for the '<em><b>Type Reference</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE_SPECIFIER__TYPE_REFERENCE = DATA_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Named Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_TYPE_SPECIFIER_FEATURE_COUNT = DATA_TYPE_SPECIFIER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayDimensionSpecificationImpl <em>Array Dimension Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ArrayDimensionSpecificationImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayDimensionSpecification()
   * @generated
   */
  int ARRAY_DIMENSION_SPECIFICATION = 24;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_DIMENSION_SPECIFICATION__SIZE = 0;

  /**
   * The number of structural features of the '<em>Array Dimension Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_DIMENSION_SPECIFICATION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 25;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LetExpressionImpl <em>Let Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.LetExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLetExpression()
   * @generated
   */
  int LET_EXPRESSION = 26;

  /**
   * The feature id for the '<em><b>Variable Declarations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPRESSION__VARIABLE_DECLARATIONS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPRESSION__TARGET_EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Let Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LetExpressionVariableDeclarationImpl <em>Let Expression Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.LetExpressionVariableDeclarationImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLetExpressionVariableDeclaration()
   * @generated
   */
  int LET_EXPRESSION_VARIABLE_DECLARATION = 27;

  /**
   * The feature id for the '<em><b>Names</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXPRESSION_VARIABLE_DECLARATION__NAMES = 0;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IfExpressionImpl <em>If Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.IfExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIfExpression()
   * @generated
   */
  int IF_EXPRESSION = 28;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION__STATIC = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION__CONDITION = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION__THEN_EXPRESSION = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION__ELSE_EXPRESSION = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>If Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.SwitchExpressionImpl <em>Switch Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.SwitchExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getSwitchExpression()
   * @generated
   */
  int SWITCH_EXPRESSION = 29;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_EXPRESSION__STATIC = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Control Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_EXPRESSION__CONTROL_EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Cases</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_EXPRESSION__CASES = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Default Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_EXPRESSION__DEFAULT_EXPRESSION = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Switch Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SWITCH_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.SwitchCaseImpl <em>Switch Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.SwitchCaseImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getSwitchCase()
   * @generated
   */
  int SWITCH_CASE = 30;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.AdditiveExpressionPartImpl <em>Additive Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.AdditiveExpressionPartImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAdditiveExpressionPart()
   * @generated
   */
  int ADDITIVE_EXPRESSION_PART = 31;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_PART__OPERATOR = 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_PART__OPERAND = 1;

  /**
   * The number of structural features of the '<em>Additive Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.MultiplicativeExpressionPartImpl <em>Multiplicative Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.MultiplicativeExpressionPartImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplicativeExpressionPart()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION_PART = 32;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_PART__OPERATOR = 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_PART__OPERAND = 1;

  /**
   * The number of structural features of the '<em>Multiplicative Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.LiteralImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 33;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.NumericLiteralImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNumericLiteral()
   * @generated
   */
  int NUMERIC_LITERAL = 34;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_LITERAL__MODIFIER = LITERAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_LITERAL__UNIT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Numeric Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERIC_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RealLiteralImpl <em>Real Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.RealLiteralImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRealLiteral()
   * @generated
   */
  int REAL_LITERAL = 35;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__MODIFIER = NUMERIC_LITERAL__MODIFIER;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__UNIT = NUMERIC_LITERAL__UNIT;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__VALUE = NUMERIC_LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Real Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_FEATURE_COUNT = NUMERIC_LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.IntegerLiteralImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIntegerLiteral()
   * @generated
   */
  int INTEGER_LITERAL = 36;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL__MODIFIER = NUMERIC_LITERAL__MODIFIER;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL__UNIT = NUMERIC_LITERAL__UNIT;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL__VALUE = NUMERIC_LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Integer Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL_FEATURE_COUNT = NUMERIC_LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.BooleanLiteralImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 37;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.StringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.StringLiteralImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStringLiteral()
   * @generated
   */
  int STRING_LITERAL = 38;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallPartImpl <em>Feature Call Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.FeatureCallPartImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFeatureCallPart()
   * @generated
   */
  int FEATURE_CALL_PART = 39;

  /**
   * The number of structural features of the '<em>Feature Call Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL_PART_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.NameComponentImpl <em>Name Component</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.NameComponentImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNameComponent()
   * @generated
   */
  int NAME_COMPONENT = 40;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_COMPONENT__IDENTIFIER = FEATURE_CALL_PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Name Component</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_COMPONENT_FEATURE_COUNT = FEATURE_CALL_PART_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayElementAccessImpl <em>Array Element Access</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ArrayElementAccessImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayElementAccess()
   * @generated
   */
  int ARRAY_ELEMENT_ACCESS = 41;

  /**
   * The feature id for the '<em><b>Subscripts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ELEMENT_ACCESS__SUBSCRIPTS = FEATURE_CALL_PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array Element Access</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ELEMENT_ACCESS_FEATURE_COUNT = FEATURE_CALL_PART_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ArraySubscriptImpl <em>Array Subscript</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ArraySubscriptImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArraySubscript()
   * @generated
   */
  int ARRAY_SUBSCRIPT = 42;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.OperationArgumentListImpl <em>Operation Argument List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.OperationArgumentListImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getOperationArgumentList()
   * @generated
   */
  int OPERATION_ARGUMENT_LIST = 43;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_ARGUMENT_LIST__ARGUMENTS = FEATURE_CALL_PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Operation Argument List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_ARGUMENT_LIST_FEATURE_COUNT = FEATURE_CALL_PART_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IterationCallImpl <em>Iteration Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.IterationCallImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIterationCall()
   * @generated
   */
  int ITERATION_CALL = 44;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_CALL__NAME = FEATURE_CALL_PART_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Variables</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_CALL__VARIABLES = FEATURE_CALL_PART_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Accumulator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_CALL__ACCUMULATOR = FEATURE_CALL_PART_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Break Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_CALL__BREAK_CONDITION = FEATURE_CALL_PART_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_CALL__EXPRESSION = FEATURE_CALL_PART_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Iteration Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_CALL_FEATURE_COUNT = FEATURE_CALL_PART_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IterationVariableImpl <em>Iteration Variable</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.IterationVariableImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIterationVariable()
   * @generated
   */
  int ITERATION_VARIABLE = 45;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_VARIABLE__NAME = 0;

  /**
   * The number of structural features of the '<em>Iteration Variable</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_VARIABLE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IterationAccumulatorImpl <em>Iteration Accumulator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.IterationAccumulatorImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIterationAccumulator()
   * @generated
   */
  int ITERATION_ACCUMULATOR = 46;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_ACCUMULATOR__NAME = 0;

  /**
   * The feature id for the '<em><b>Initializer</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_ACCUMULATOR__INITIALIZER = 1;

  /**
   * The number of structural features of the '<em>Iteration Accumulator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ITERATION_ACCUMULATOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayConstructionOperatorImpl <em>Array Construction Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ArrayConstructionOperatorImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayConstructionOperator()
   * @generated
   */
  int ARRAY_CONSTRUCTION_OPERATOR = 47;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_CONSTRUCTION_OPERATOR__EXPRESSIONS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Iteration Clauses</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_CONSTRUCTION_OPERATOR__ITERATION_CLAUSES = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Array Construction Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_CONSTRUCTION_OPERATOR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayConstructionIterationClauseImpl <em>Array Construction Iteration Clause</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ArrayConstructionIterationClauseImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayConstructionIterationClause()
   * @generated
   */
  int ARRAY_CONSTRUCTION_ITERATION_CLAUSE = 48;

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
  int ARRAY_CONCATENATION_OPERATOR = 49;

  /**
   * The feature id for the '<em><b>Rows</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_CONCATENATION_OPERATOR__ROWS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array Concatenation Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_CONCATENATION_OPERATOR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ExpressionListImpl <em>Expression List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ExpressionListImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getExpressionList()
   * @generated
   */
  int EXPRESSION_LIST = 50;

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
  int UNIT_CONSTRUCTION_OPERATOR = 51;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_CONSTRUCTION_OPERATOR__UNIT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Unit Construction Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_CONSTRUCTION_OPERATOR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ParenthesizedExpressionImpl <em>Parenthesized Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ParenthesizedExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getParenthesizedExpression()
   * @generated
   */
  int PARENTHESIZED_EXPRESSION = 52;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENTHESIZED_EXPRESSION__EXPRESSIONS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Parenthesized Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARENTHESIZED_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.BeginExpressionImpl <em>Begin Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.BeginExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBeginExpression()
   * @generated
   */
  int BEGIN_EXPRESSION = 53;

  /**
   * The number of structural features of the '<em>Begin Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEGIN_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.EndExpressionImpl <em>End Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.EndExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEndExpression()
   * @generated
   */
  int END_EXPRESSION = 54;

  /**
   * The number of structural features of the '<em>End Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int END_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.QualifiedNameImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getQualifiedName()
   * @generated
   */
  int QUALIFIED_NAME = 55;

  /**
   * The feature id for the '<em><b>Identifiers</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME__IDENTIFIERS = 0;

  /**
   * The number of structural features of the '<em>Qualified Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int QUALIFIED_NAME_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionImpl <em>Unit Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpression()
   * @generated
   */
  int UNIT_EXPRESSION = 56;

  /**
   * The feature id for the '<em><b>Numerator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION__NUMERATOR = 0;

  /**
   * The feature id for the '<em><b>Denominator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION__DENOMINATOR = 1;

  /**
   * The number of structural features of the '<em>Unit Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionNumeratorImpl <em>Unit Expression Numerator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionNumeratorImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpressionNumerator()
   * @generated
   */
  int UNIT_EXPRESSION_NUMERATOR = 57;

  /**
   * The feature id for the '<em><b>One</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_NUMERATOR__ONE = 0;

  /**
   * The feature id for the '<em><b>Factors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_NUMERATOR__FACTORS = 1;

  /**
   * The number of structural features of the '<em>Unit Expression Numerator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_NUMERATOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionDenominatorImpl <em>Unit Expression Denominator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionDenominatorImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpressionDenominator()
   * @generated
   */
  int UNIT_EXPRESSION_DENOMINATOR = 58;

  /**
   * The feature id for the '<em><b>Factors</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_DENOMINATOR__FACTORS = 0;

  /**
   * The number of structural features of the '<em>Unit Expression Denominator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_DENOMINATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionFactorImpl <em>Unit Expression Factor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionFactorImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpressionFactor()
   * @generated
   */
  int UNIT_EXPRESSION_FACTOR = 59;

  /**
   * The feature id for the '<em><b>Operand</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_FACTOR__OPERAND = 0;

  /**
   * The feature id for the '<em><b>Exponent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_FACTOR__EXPONENT = 1;

  /**
   * The number of structural features of the '<em>Unit Expression Factor</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_FACTOR_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionExponentImpl <em>Unit Expression Exponent</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionExponentImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpressionExponent()
   * @generated
   */
  int UNIT_EXPRESSION_EXPONENT = 60;

  /**
   * The feature id for the '<em><b>Negative</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_EXPONENT__NEGATIVE = 0;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_EXPONENT__VALUE = 1;

  /**
   * The number of structural features of the '<em>Unit Expression Exponent</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_EXPONENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RangeExpressionImpl <em>Range Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.RangeExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRangeExpression()
   * @generated
   */
  int RANGE_EXPRESSION = 61;

  /**
   * The feature id for the '<em><b>Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_EXPRESSION__OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Range Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ImpliesExpressionImpl <em>Implies Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ImpliesExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getImpliesExpression()
   * @generated
   */
  int IMPLIES_EXPRESSION = 62;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLIES_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLIES_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Implies Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IMPLIES_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.LogicalOrExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLogicalOrExpression()
   * @generated
   */
  int LOGICAL_OR_EXPRESSION = 63;

  /**
   * The feature id for the '<em><b>Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION__OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Logical Or Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.LogicalAndExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLogicalAndExpression()
   * @generated
   */
  int LOGICAL_AND_EXPRESSION = 64;

  /**
   * The feature id for the '<em><b>Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION__OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Logical And Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LOGICAL_AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.EqualityExpressionImpl <em>Equality Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.EqualityExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEqualityExpression()
   * @generated
   */
  int EQUALITY_EXPRESSION = 65;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Equality Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EQUALITY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.RelationalExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 66;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.TypeTestExpressionImpl <em>Type Test Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.TypeTestExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTypeTestExpression()
   * @generated
   */
  int TYPE_TEST_EXPRESSION = 67;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_TEST_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_TEST_EXPRESSION__TYPE = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type Test Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_TEST_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.AdditiveExpressionImpl <em>Additive Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.AdditiveExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAdditiveExpression()
   * @generated
   */
  int ADDITIVE_EXPRESSION = 68;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION__RIGHT_PARTS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Additive Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADDITIVE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.MultiplicativeExpressionImpl <em>Multiplicative Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.MultiplicativeExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplicativeExpression()
   * @generated
   */
  int MULTIPLICATIVE_EXPRESSION = 69;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION__RIGHT_PARTS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Multiplicative Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICATIVE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.PowerExpressionImpl <em>Power Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.PowerExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPowerExpression()
   * @generated
   */
  int POWER_EXPRESSION = 70;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POWER_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POWER_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Exponent</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POWER_EXPRESSION__EXPONENT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Power Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POWER_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.UnaryExpressionImpl <em>Unary Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.UnaryExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnaryExpression()
   * @generated
   */
  int UNARY_EXPRESSION = 71;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Unary Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.PostfixExpressionImpl <em>Postfix Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.PostfixExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPostfixExpression()
   * @generated
   */
  int POSTFIX_EXPRESSION = 72;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Postfix Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POSTFIX_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.SimpleNameImpl <em>Simple Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.SimpleNameImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getSimpleName()
   * @generated
   */
  int SIMPLE_NAME = 73;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_NAME__IDENTIFIER = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Simple Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SIMPLE_NAME_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallImpl <em>Feature Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.FeatureCallImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFeatureCall()
   * @generated
   */
  int FEATURE_CALL = 74;

  /**
   * The feature id for the '<em><b>Target</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL__TARGET = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL__PARTS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Feature Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.AssertionStatusKind <em>Assertion Status Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.AssertionStatusKind
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAssertionStatusKind()
   * @generated
   */
  int ASSERTION_STATUS_KIND = 75;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.EqualityOperator <em>Equality Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.EqualityOperator
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getEqualityOperator()
   * @generated
   */
  int EQUALITY_OPERATOR = 76;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.RelationalOperator
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRelationalOperator()
   * @generated
   */
  int RELATIONAL_OPERATOR = 77;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.AdditiveOperator <em>Additive Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.AdditiveOperator
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAdditiveOperator()
   * @generated
   */
  int ADDITIVE_OPERATOR = 78;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.MultiplicativeOperator
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplicativeOperator()
   * @generated
   */
  int MULTIPLICATIVE_OPERATOR = 79;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.PowerOperator <em>Power Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.PowerOperator
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPowerOperator()
   * @generated
   */
  int POWER_OPERATOR = 80;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.UnaryOperator <em>Unary Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.UnaryOperator
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnaryOperator()
   * @generated
   */
  int UNARY_OPERATOR = 81;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.PostfixOperator <em>Postfix Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.PostfixOperator
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPostfixOperator()
   * @generated
   */
  int POSTFIX_OPERATOR = 82;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.BooleanKind <em>Boolean Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.BooleanKind
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBooleanKind()
   * @generated
   */
  int BOOLEAN_KIND = 83;


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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.TypeAliasDefinition <em>Type Alias Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Alias Definition</em>'.
   * @see org.eclipselabs.mscript.language.ast.TypeAliasDefinition
   * @generated
   */
  EClass getTypeAliasDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.TypeAliasDefinition#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipselabs.mscript.language.ast.TypeAliasDefinition#getType()
   * @see #getTypeAliasDefinition()
   * @generated
   */
  EReference getTypeAliasDefinition_Type();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.RecordDefinition <em>Record Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Definition</em>'.
   * @see org.eclipselabs.mscript.language.ast.RecordDefinition
   * @generated
   */
  EClass getRecordDefinition();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.RecordDefinition#getFieldDeclarations <em>Field Declarations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Field Declarations</em>'.
   * @see org.eclipselabs.mscript.language.ast.RecordDefinition#getFieldDeclarations()
   * @see #getRecordDefinition()
   * @generated
   */
  EReference getRecordDefinition_FieldDeclarations();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.RecordFieldDeclaration <em>Record Field Declaration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Record Field Declaration</em>'.
   * @see org.eclipselabs.mscript.language.ast.RecordFieldDeclaration
   * @generated
   */
  EClass getRecordFieldDeclaration();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.RecordFieldDeclaration#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.RecordFieldDeclaration#getName()
   * @see #getRecordFieldDeclaration()
   * @generated
   */
  EAttribute getRecordFieldDeclaration_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.RecordFieldDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipselabs.mscript.language.ast.RecordFieldDeclaration#getType()
   * @see #getRecordFieldDeclaration()
   * @generated
   */
  EReference getRecordFieldDeclaration_Type();

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
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#isStateful <em>Stateful</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Stateful</em>'.
   * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#isStateful()
   * @see #getFunctionDefinition()
   * @generated
   */
  EAttribute getFunctionDefinition_Stateful();

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
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration#getFunctionName <em>Function Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Function Name</em>'.
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
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.DataTypeSpecifier#getDimensions <em>Dimensions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Dimensions</em>'.
   * @see org.eclipselabs.mscript.language.ast.DataTypeSpecifier#getDimensions()
   * @see #getDataTypeSpecifier()
   * @generated
   */
  EReference getDataTypeSpecifier_Dimensions();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.PrimitiveTypeSpecifier <em>Primitive Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Type Specifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.PrimitiveTypeSpecifier
   * @generated
   */
  EClass getPrimitiveTypeSpecifier();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.NumericTypeSpecifier <em>Numeric Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numeric Type Specifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.NumericTypeSpecifier
   * @generated
   */
  EClass getNumericTypeSpecifier();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.NumericTypeSpecifier#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit</em>'.
   * @see org.eclipselabs.mscript.language.ast.NumericTypeSpecifier#getUnit()
   * @see #getNumericTypeSpecifier()
   * @generated
   */
  EReference getNumericTypeSpecifier_Unit();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.RealTypeSpecifier <em>Real Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Type Specifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.RealTypeSpecifier
   * @generated
   */
  EClass getRealTypeSpecifier();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.IntegerTypeSpecifier <em>Integer Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Type Specifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.IntegerTypeSpecifier
   * @generated
   */
  EClass getIntegerTypeSpecifier();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ComplexTypeSpecifier <em>Complex Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Complex Type Specifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.ComplexTypeSpecifier
   * @generated
   */
  EClass getComplexTypeSpecifier();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.GaussianTypeSpecifier <em>Gaussian Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Gaussian Type Specifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.GaussianTypeSpecifier
   * @generated
   */
  EClass getGaussianTypeSpecifier();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.BooleanTypeSpecifier <em>Boolean Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Type Specifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.BooleanTypeSpecifier
   * @generated
   */
  EClass getBooleanTypeSpecifier();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.StringTypeSpecifier <em>String Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Type Specifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.StringTypeSpecifier
   * @generated
   */
  EClass getStringTypeSpecifier();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.NamedTypeSpecifier <em>Named Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Type Specifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.NamedTypeSpecifier
   * @generated
   */
  EClass getNamedTypeSpecifier();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.NamedTypeSpecifier#getTypeReference <em>Type Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type Reference</em>'.
   * @see org.eclipselabs.mscript.language.ast.NamedTypeSpecifier#getTypeReference()
   * @see #getNamedTypeSpecifier()
   * @generated
   */
  EReference getNamedTypeSpecifier_TypeReference();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification <em>Array Dimension Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Dimension Specification</em>'.
   * @see org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification
   * @generated
   */
  EClass getArrayDimensionSpecification();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getSize <em>Size</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Size</em>'.
   * @see org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getSize()
   * @see #getArrayDimensionSpecification()
   * @generated
   */
  EReference getArrayDimensionSpecification_Size();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.Expression
   * @generated
   */
  EClass getExpression();

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
   * Returns the meta object for the attribute list '{@link org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration#getNames <em>Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Names</em>'.
   * @see org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration#getNames()
   * @see #getLetExpressionVariableDeclaration()
   * @generated
   */
  EAttribute getLetExpressionVariableDeclaration_Names();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.AdditiveExpressionPart <em>Additive Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Additive Expression Part</em>'.
   * @see org.eclipselabs.mscript.language.ast.AdditiveExpressionPart
   * @generated
   */
  EClass getAdditiveExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.AdditiveExpressionPart#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipselabs.mscript.language.ast.AdditiveExpressionPart#getOperator()
   * @see #getAdditiveExpressionPart()
   * @generated
   */
  EAttribute getAdditiveExpressionPart_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.AdditiveExpressionPart#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.eclipselabs.mscript.language.ast.AdditiveExpressionPart#getOperand()
   * @see #getAdditiveExpressionPart()
   * @generated
   */
  EReference getAdditiveExpressionPart_Operand();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart <em>Multiplicative Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicative Expression Part</em>'.
   * @see org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart
   * @generated
   */
  EClass getMultiplicativeExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart#getOperator()
   * @see #getMultiplicativeExpressionPart()
   * @generated
   */
  EAttribute getMultiplicativeExpressionPart_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart#getOperand()
   * @see #getMultiplicativeExpressionPart()
   * @generated
   */
  EReference getMultiplicativeExpressionPart_Operand();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.eclipselabs.mscript.language.ast.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.NumericLiteral <em>Numeric Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numeric Literal</em>'.
   * @see org.eclipselabs.mscript.language.ast.NumericLiteral
   * @generated
   */
  EClass getNumericLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.NumericLiteral#getModifier <em>Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Modifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.NumericLiteral#getModifier()
   * @see #getNumericLiteral()
   * @generated
   */
  EAttribute getNumericLiteral_Modifier();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.NumericLiteral#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit</em>'.
   * @see org.eclipselabs.mscript.language.ast.NumericLiteral#getUnit()
   * @see #getNumericLiteral()
   * @generated
   */
  EReference getNumericLiteral_Unit();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.RealLiteral <em>Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Literal</em>'.
   * @see org.eclipselabs.mscript.language.ast.RealLiteral
   * @generated
   */
  EClass getRealLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.RealLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipselabs.mscript.language.ast.RealLiteral#getValue()
   * @see #getRealLiteral()
   * @generated
   */
  EAttribute getRealLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.IntegerLiteral <em>Integer Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Literal</em>'.
   * @see org.eclipselabs.mscript.language.ast.IntegerLiteral
   * @generated
   */
  EClass getIntegerLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.IntegerLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipselabs.mscript.language.ast.IntegerLiteral#getValue()
   * @see #getIntegerLiteral()
   * @generated
   */
  EAttribute getIntegerLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal</em>'.
   * @see org.eclipselabs.mscript.language.ast.BooleanLiteral
   * @generated
   */
  EClass getBooleanLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.BooleanLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipselabs.mscript.language.ast.BooleanLiteral#getValue()
   * @see #getBooleanLiteral()
   * @generated
   */
  EAttribute getBooleanLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see org.eclipselabs.mscript.language.ast.StringLiteral
   * @generated
   */
  EClass getStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.StringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipselabs.mscript.language.ast.StringLiteral#getValue()
   * @see #getStringLiteral()
   * @generated
   */
  EAttribute getStringLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.FeatureCallPart <em>Feature Call Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Call Part</em>'.
   * @see org.eclipselabs.mscript.language.ast.FeatureCallPart
   * @generated
   */
  EClass getFeatureCallPart();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.NameComponent <em>Name Component</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name Component</em>'.
   * @see org.eclipselabs.mscript.language.ast.NameComponent
   * @generated
   */
  EClass getNameComponent();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.NameComponent#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Identifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.NameComponent#getIdentifier()
   * @see #getNameComponent()
   * @generated
   */
  EAttribute getNameComponent_Identifier();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.OperationArgumentList <em>Operation Argument List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Argument List</em>'.
   * @see org.eclipselabs.mscript.language.ast.OperationArgumentList
   * @generated
   */
  EClass getOperationArgumentList();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.OperationArgumentList#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see org.eclipselabs.mscript.language.ast.OperationArgumentList#getArguments()
   * @see #getOperationArgumentList()
   * @generated
   */
  EReference getOperationArgumentList_Arguments();

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
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.IterationCall#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.IterationCall#getName()
   * @see #getIterationCall()
   * @generated
   */
  EAttribute getIterationCall_Name();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.BeginExpression <em>Begin Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Begin Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.BeginExpression
   * @generated
   */
  EClass getBeginExpression();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.QualifiedName <em>Qualified Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Qualified Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.QualifiedName
   * @generated
   */
  EClass getQualifiedName();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipselabs.mscript.language.ast.QualifiedName#getIdentifiers <em>Identifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Identifiers</em>'.
   * @see org.eclipselabs.mscript.language.ast.QualifiedName#getIdentifiers()
   * @see #getQualifiedName()
   * @generated
   */
  EAttribute getQualifiedName_Identifiers();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.UnitExpression <em>Unit Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpression
   * @generated
   */
  EClass getUnitExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.UnitExpression#getNumerator <em>Numerator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Numerator</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpression#getNumerator()
   * @see #getUnitExpression()
   * @generated
   */
  EReference getUnitExpression_Numerator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.UnitExpression#getDenominator <em>Denominator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Denominator</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpression#getDenominator()
   * @see #getUnitExpression()
   * @generated
   */
  EReference getUnitExpression_Denominator();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.UnitExpressionNumerator <em>Unit Expression Numerator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expression Numerator</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionNumerator
   * @generated
   */
  EClass getUnitExpressionNumerator();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.UnitExpressionNumerator#getOne <em>One</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>One</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionNumerator#getOne()
   * @see #getUnitExpressionNumerator()
   * @generated
   */
  EAttribute getUnitExpressionNumerator_One();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.UnitExpressionNumerator#getFactors <em>Factors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Factors</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionNumerator#getFactors()
   * @see #getUnitExpressionNumerator()
   * @generated
   */
  EReference getUnitExpressionNumerator_Factors();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.UnitExpressionDenominator <em>Unit Expression Denominator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expression Denominator</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionDenominator
   * @generated
   */
  EClass getUnitExpressionDenominator();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.UnitExpressionDenominator#getFactors <em>Factors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Factors</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionDenominator#getFactors()
   * @see #getUnitExpressionDenominator()
   * @generated
   */
  EReference getUnitExpressionDenominator_Factors();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.UnitExpressionFactor <em>Unit Expression Factor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expression Factor</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionFactor
   * @generated
   */
  EClass getUnitExpressionFactor();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.UnitExpressionFactor#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operand</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionFactor#getOperand()
   * @see #getUnitExpressionFactor()
   * @generated
   */
  EAttribute getUnitExpressionFactor_Operand();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.UnitExpressionFactor#getExponent <em>Exponent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exponent</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionFactor#getExponent()
   * @see #getUnitExpressionFactor()
   * @generated
   */
  EReference getUnitExpressionFactor_Exponent();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.UnitExpressionExponent <em>Unit Expression Exponent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expression Exponent</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionExponent
   * @generated
   */
  EClass getUnitExpressionExponent();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.UnitExpressionExponent#isNegative <em>Negative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Negative</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionExponent#isNegative()
   * @see #getUnitExpressionExponent()
   * @generated
   */
  EAttribute getUnitExpressionExponent_Negative();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.UnitExpressionExponent#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpressionExponent#getValue()
   * @see #getUnitExpressionExponent()
   * @generated
   */
  EAttribute getUnitExpressionExponent_Value();

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
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.LogicalOrExpression#getOperands <em>Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operands</em>'.
   * @see org.eclipselabs.mscript.language.ast.LogicalOrExpression#getOperands()
   * @see #getLogicalOrExpression()
   * @generated
   */
  EReference getLogicalOrExpression_Operands();

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
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.LogicalAndExpression#getOperands <em>Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operands</em>'.
   * @see org.eclipselabs.mscript.language.ast.LogicalAndExpression#getOperands()
   * @see #getLogicalAndExpression()
   * @generated
   */
  EReference getLogicalAndExpression_Operands();

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
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.AdditiveExpression#getRightParts <em>Right Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Right Parts</em>'.
   * @see org.eclipselabs.mscript.language.ast.AdditiveExpression#getRightParts()
   * @see #getAdditiveExpression()
   * @generated
   */
  EReference getAdditiveExpression_RightParts();

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
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.MultiplicativeExpression#getRightParts <em>Right Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Right Parts</em>'.
   * @see org.eclipselabs.mscript.language.ast.MultiplicativeExpression#getRightParts()
   * @see #getMultiplicativeExpression()
   * @generated
   */
  EReference getMultiplicativeExpression_RightParts();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.SimpleName <em>Simple Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Simple Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.SimpleName
   * @generated
   */
  EClass getSimpleName();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.SimpleName#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Identifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.SimpleName#getIdentifier()
   * @see #getSimpleName()
   * @generated
   */
  EAttribute getSimpleName_Identifier();

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
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.FeatureCall#getTarget <em>Target</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Target</em>'.
   * @see org.eclipselabs.mscript.language.ast.FeatureCall#getTarget()
   * @see #getFeatureCall()
   * @generated
   */
  EReference getFeatureCall_Target();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.FeatureCall#getParts <em>Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parts</em>'.
   * @see org.eclipselabs.mscript.language.ast.FeatureCall#getParts()
   * @see #getFeatureCall()
   * @generated
   */
  EReference getFeatureCall_Parts();

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
   * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.BooleanKind <em>Boolean Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Boolean Kind</em>'.
   * @see org.eclipselabs.mscript.language.ast.BooleanKind
   * @generated
   */
  EEnum getBooleanKind();

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
  interface Literals
  {
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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.TypeAliasDefinitionImpl <em>Type Alias Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.TypeAliasDefinitionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTypeAliasDefinition()
     * @generated
     */
    EClass TYPE_ALIAS_DEFINITION = eINSTANCE.getTypeAliasDefinition();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_ALIAS_DEFINITION__TYPE = eINSTANCE.getTypeAliasDefinition_Type();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.RecordDefinitionImpl <em>Record Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.RecordDefinitionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRecordDefinition()
     * @generated
     */
    EClass RECORD_DEFINITION = eINSTANCE.getRecordDefinition();

    /**
     * The meta object literal for the '<em><b>Field Declarations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_DEFINITION__FIELD_DECLARATIONS = eINSTANCE.getRecordDefinition_FieldDeclarations();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.RecordFieldDeclarationImpl <em>Record Field Declaration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.RecordFieldDeclarationImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRecordFieldDeclaration()
     * @generated
     */
    EClass RECORD_FIELD_DECLARATION = eINSTANCE.getRecordFieldDeclaration();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD_FIELD_DECLARATION__NAME = eINSTANCE.getRecordFieldDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_FIELD_DECLARATION__TYPE = eINSTANCE.getRecordFieldDeclaration_Type();

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
     * The meta object literal for the '<em><b>Stateful</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_DEFINITION__STATEFUL = eINSTANCE.getFunctionDefinition_Stateful();

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
     * The meta object literal for the '<em><b>Function Name</b></em>' containment reference feature.
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
     * The meta object literal for the '<em><b>Dimensions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DATA_TYPE_SPECIFIER__DIMENSIONS = eINSTANCE.getDataTypeSpecifier_Dimensions();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.PrimitiveTypeSpecifierImpl <em>Primitive Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.PrimitiveTypeSpecifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPrimitiveTypeSpecifier()
     * @generated
     */
    EClass PRIMITIVE_TYPE_SPECIFIER = eINSTANCE.getPrimitiveTypeSpecifier();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.NumericTypeSpecifierImpl <em>Numeric Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.NumericTypeSpecifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNumericTypeSpecifier()
     * @generated
     */
    EClass NUMERIC_TYPE_SPECIFIER = eINSTANCE.getNumericTypeSpecifier();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERIC_TYPE_SPECIFIER__UNIT = eINSTANCE.getNumericTypeSpecifier_Unit();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.RealTypeSpecifierImpl <em>Real Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.RealTypeSpecifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRealTypeSpecifier()
     * @generated
     */
    EClass REAL_TYPE_SPECIFIER = eINSTANCE.getRealTypeSpecifier();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.IntegerTypeSpecifierImpl <em>Integer Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.IntegerTypeSpecifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIntegerTypeSpecifier()
     * @generated
     */
    EClass INTEGER_TYPE_SPECIFIER = eINSTANCE.getIntegerTypeSpecifier();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ComplexTypeSpecifierImpl <em>Complex Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.ComplexTypeSpecifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getComplexTypeSpecifier()
     * @generated
     */
    EClass COMPLEX_TYPE_SPECIFIER = eINSTANCE.getComplexTypeSpecifier();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.GaussianTypeSpecifierImpl <em>Gaussian Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.GaussianTypeSpecifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getGaussianTypeSpecifier()
     * @generated
     */
    EClass GAUSSIAN_TYPE_SPECIFIER = eINSTANCE.getGaussianTypeSpecifier();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.BooleanTypeSpecifierImpl <em>Boolean Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.BooleanTypeSpecifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBooleanTypeSpecifier()
     * @generated
     */
    EClass BOOLEAN_TYPE_SPECIFIER = eINSTANCE.getBooleanTypeSpecifier();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.StringTypeSpecifierImpl <em>String Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.StringTypeSpecifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStringTypeSpecifier()
     * @generated
     */
    EClass STRING_TYPE_SPECIFIER = eINSTANCE.getStringTypeSpecifier();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.NamedTypeSpecifierImpl <em>Named Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.NamedTypeSpecifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNamedTypeSpecifier()
     * @generated
     */
    EClass NAMED_TYPE_SPECIFIER = eINSTANCE.getNamedTypeSpecifier();

    /**
     * The meta object literal for the '<em><b>Type Reference</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_TYPE_SPECIFIER__TYPE_REFERENCE = eINSTANCE.getNamedTypeSpecifier_TypeReference();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayDimensionSpecificationImpl <em>Array Dimension Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.ArrayDimensionSpecificationImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayDimensionSpecification()
     * @generated
     */
    EClass ARRAY_DIMENSION_SPECIFICATION = eINSTANCE.getArrayDimensionSpecification();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_DIMENSION_SPECIFICATION__SIZE = eINSTANCE.getArrayDimensionSpecification_Size();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.ExpressionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

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
     * The meta object literal for the '<em><b>Names</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LET_EXPRESSION_VARIABLE_DECLARATION__NAMES = eINSTANCE.getLetExpressionVariableDeclaration_Names();

    /**
     * The meta object literal for the '<em><b>Assigned Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_EXPRESSION_VARIABLE_DECLARATION__ASSIGNED_EXPRESSION = eINSTANCE.getLetExpressionVariableDeclaration_AssignedExpression();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.AdditiveExpressionPartImpl <em>Additive Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.AdditiveExpressionPartImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAdditiveExpressionPart()
     * @generated
     */
    EClass ADDITIVE_EXPRESSION_PART = eINSTANCE.getAdditiveExpressionPart();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADDITIVE_EXPRESSION_PART__OPERATOR = eINSTANCE.getAdditiveExpressionPart_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION_PART__OPERAND = eINSTANCE.getAdditiveExpressionPart_Operand();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.MultiplicativeExpressionPartImpl <em>Multiplicative Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.MultiplicativeExpressionPartImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplicativeExpressionPart()
     * @generated
     */
    EClass MULTIPLICATIVE_EXPRESSION_PART = eINSTANCE.getMultiplicativeExpressionPart();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICATIVE_EXPRESSION_PART__OPERATOR = eINSTANCE.getMultiplicativeExpressionPart_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION_PART__OPERAND = eINSTANCE.getMultiplicativeExpressionPart_Operand();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.LiteralImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.NumericLiteralImpl <em>Numeric Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.NumericLiteralImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNumericLiteral()
     * @generated
     */
    EClass NUMERIC_LITERAL = eINSTANCE.getNumericLiteral();

    /**
     * The meta object literal for the '<em><b>Modifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERIC_LITERAL__MODIFIER = eINSTANCE.getNumericLiteral_Modifier();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERIC_LITERAL__UNIT = eINSTANCE.getNumericLiteral_Unit();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.RealLiteralImpl <em>Real Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.RealLiteralImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRealLiteral()
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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.IntegerLiteralImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIntegerLiteral()
     * @generated
     */
    EClass INTEGER_LITERAL = eINSTANCE.getIntegerLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INTEGER_LITERAL__VALUE = eINSTANCE.getIntegerLiteral_Value();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.BooleanLiteralImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBooleanLiteral()
     * @generated
     */
    EClass BOOLEAN_LITERAL = eINSTANCE.getBooleanLiteral();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_LITERAL__VALUE = eINSTANCE.getBooleanLiteral_Value();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.StringLiteralImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStringLiteral()
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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallPartImpl <em>Feature Call Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.FeatureCallPartImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFeatureCallPart()
     * @generated
     */
    EClass FEATURE_CALL_PART = eINSTANCE.getFeatureCallPart();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.NameComponentImpl <em>Name Component</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.NameComponentImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNameComponent()
     * @generated
     */
    EClass NAME_COMPONENT = eINSTANCE.getNameComponent();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAME_COMPONENT__IDENTIFIER = eINSTANCE.getNameComponent_Identifier();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.OperationArgumentListImpl <em>Operation Argument List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.OperationArgumentListImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getOperationArgumentList()
     * @generated
     */
    EClass OPERATION_ARGUMENT_LIST = eINSTANCE.getOperationArgumentList();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_ARGUMENT_LIST__ARGUMENTS = eINSTANCE.getOperationArgumentList_Arguments();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ITERATION_CALL__NAME = eINSTANCE.getIterationCall_Name();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.BeginExpressionImpl <em>Begin Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.BeginExpressionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBeginExpression()
     * @generated
     */
    EClass BEGIN_EXPRESSION = eINSTANCE.getBeginExpression();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.QualifiedNameImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getQualifiedName()
     * @generated
     */
    EClass QUALIFIED_NAME = eINSTANCE.getQualifiedName();

    /**
     * The meta object literal for the '<em><b>Identifiers</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute QUALIFIED_NAME__IDENTIFIERS = eINSTANCE.getQualifiedName_Identifiers();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionImpl <em>Unit Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpression()
     * @generated
     */
    EClass UNIT_EXPRESSION = eINSTANCE.getUnitExpression();

    /**
     * The meta object literal for the '<em><b>Numerator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT_EXPRESSION__NUMERATOR = eINSTANCE.getUnitExpression_Numerator();

    /**
     * The meta object literal for the '<em><b>Denominator</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT_EXPRESSION__DENOMINATOR = eINSTANCE.getUnitExpression_Denominator();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionNumeratorImpl <em>Unit Expression Numerator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionNumeratorImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpressionNumerator()
     * @generated
     */
    EClass UNIT_EXPRESSION_NUMERATOR = eINSTANCE.getUnitExpressionNumerator();

    /**
     * The meta object literal for the '<em><b>One</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT_EXPRESSION_NUMERATOR__ONE = eINSTANCE.getUnitExpressionNumerator_One();

    /**
     * The meta object literal for the '<em><b>Factors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT_EXPRESSION_NUMERATOR__FACTORS = eINSTANCE.getUnitExpressionNumerator_Factors();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionDenominatorImpl <em>Unit Expression Denominator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionDenominatorImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpressionDenominator()
     * @generated
     */
    EClass UNIT_EXPRESSION_DENOMINATOR = eINSTANCE.getUnitExpressionDenominator();

    /**
     * The meta object literal for the '<em><b>Factors</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT_EXPRESSION_DENOMINATOR__FACTORS = eINSTANCE.getUnitExpressionDenominator_Factors();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionFactorImpl <em>Unit Expression Factor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionFactorImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpressionFactor()
     * @generated
     */
    EClass UNIT_EXPRESSION_FACTOR = eINSTANCE.getUnitExpressionFactor();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT_EXPRESSION_FACTOR__OPERAND = eINSTANCE.getUnitExpressionFactor_Operand();

    /**
     * The meta object literal for the '<em><b>Exponent</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT_EXPRESSION_FACTOR__EXPONENT = eINSTANCE.getUnitExpressionFactor_Exponent();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionExponentImpl <em>Unit Expression Exponent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionExponentImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpressionExponent()
     * @generated
     */
    EClass UNIT_EXPRESSION_EXPONENT = eINSTANCE.getUnitExpressionExponent();

    /**
     * The meta object literal for the '<em><b>Negative</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT_EXPRESSION_EXPONENT__NEGATIVE = eINSTANCE.getUnitExpressionExponent_Negative();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT_EXPRESSION_EXPONENT__VALUE = eINSTANCE.getUnitExpressionExponent_Value();

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
     * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_OR_EXPRESSION__OPERANDS = eINSTANCE.getLogicalOrExpression_Operands();

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
     * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LOGICAL_AND_EXPRESSION__OPERANDS = eINSTANCE.getLogicalAndExpression_Operands();

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
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__LEFT_OPERAND = eINSTANCE.getAdditiveExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Right Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADDITIVE_EXPRESSION__RIGHT_PARTS = eINSTANCE.getAdditiveExpression_RightParts();

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
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__LEFT_OPERAND = eINSTANCE.getMultiplicativeExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Right Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLICATIVE_EXPRESSION__RIGHT_PARTS = eINSTANCE.getMultiplicativeExpression_RightParts();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.SimpleNameImpl <em>Simple Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.SimpleNameImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getSimpleName()
     * @generated
     */
    EClass SIMPLE_NAME = eINSTANCE.getSimpleName();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SIMPLE_NAME__IDENTIFIER = eINSTANCE.getSimpleName_Identifier();

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
     * The meta object literal for the '<em><b>Target</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_CALL__TARGET = eINSTANCE.getFeatureCall_Target();

    /**
     * The meta object literal for the '<em><b>Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_CALL__PARTS = eINSTANCE.getFeatureCall_Parts();

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

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.BooleanKind <em>Boolean Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.BooleanKind
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBooleanKind()
     * @generated
     */
    EEnum BOOLEAN_KIND = eINSTANCE.getBooleanKind();

  }

} //AstPackage
