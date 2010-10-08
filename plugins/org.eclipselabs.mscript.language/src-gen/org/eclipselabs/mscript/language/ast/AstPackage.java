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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.MscriptImpl <em>Mscript</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.MscriptImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMscript()
   * @generated
   */
  int MSCRIPT = 0;

  /**
   * The feature id for the '<em><b>Packages</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSCRIPT__PACKAGES = 0;

  /**
   * The number of structural features of the '<em>Mscript</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MSCRIPT_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.PackageDefinitionElementImpl <em>Package Definition Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.PackageDefinitionElementImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPackageDefinitionElement()
   * @generated
   */
  int PACKAGE_DEFINITION_ELEMENT = 2;

  /**
   * The number of structural features of the '<em>Package Definition Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.PackageDefinitionImpl <em>Package Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.PackageDefinitionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPackageDefinition()
   * @generated
   */
  int PACKAGE_DEFINITION = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DEFINITION__NAME = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Elements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DEFINITION__ELEMENTS = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Package Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DEFINITION_FEATURE_COUNT = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 2;

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
  int ENUMERATION_DEFINITION__NAME = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Literals</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_DEFINITION__LITERALS = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Enumeration Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_DEFINITION_FEATURE_COUNT = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 2;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.TypeDefinitionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTypeDefinition()
   * @generated
   */
  int TYPE_DEFINITION = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEFINITION__NAME = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEFINITION__TYPE = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_DEFINITION_FEATURE_COUNT = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.VariableDeclarationImpl <em>Variable Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.VariableDeclarationImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getVariableDeclaration()
   * @generated
   */
  int VARIABLE_DECLARATION = 6;

  /**
   * The feature id for the '<em><b>Modifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__MODIFIER = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__NAME = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__TYPE = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Initial Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION__INITIAL_VALUE = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Variable Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_DECLARATION_FEATURE_COUNT = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.VariableModifierImpl <em>Variable Modifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.VariableModifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getVariableModifier()
   * @generated
   */
  int VARIABLE_MODIFIER = 7;

  /**
   * The feature id for the '<em><b>Auto</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_MODIFIER__AUTO = 0;

  /**
   * The feature id for the '<em><b>Constant</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_MODIFIER__CONSTANT = 1;

  /**
   * The number of structural features of the '<em>Variable Modifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int VARIABLE_MODIFIER_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RecordDefinitionImpl <em>Record Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.RecordDefinitionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRecordDefinition()
   * @generated
   */
  int RECORD_DEFINITION = 8;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_DEFINITION__NAME = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Fields</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_DEFINITION__FIELDS = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Record Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RECORD_DEFINITION_FEATURE_COUNT = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RecordFieldDeclarationImpl <em>Record Field Declaration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.RecordFieldDeclarationImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRecordFieldDeclaration()
   * @generated
   */
  int RECORD_FIELD_DECLARATION = 9;

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
  int FUNCTION_DEFINITION = 10;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__NAME = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__PARAMETERS = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Precondition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__PRECONDITION = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION__BODY = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Function Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_DEFINITION_FEATURE_COUNT = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 4;

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
   * The feature id for the '<em><b>Reference</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLARATION__REFERENCE = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLARATION__NAME = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLARATION__TYPE = 2;

  /**
   * The number of structural features of the '<em>Parameter Declaration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_DECLARATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.CheckDefinitionImpl <em>Check Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.CheckDefinitionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getCheckDefinition()
   * @generated
   */
  int CHECK_DEFINITION = 12;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_DEFINITION__NAME = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_DEFINITION__PARAMETERS = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_DEFINITION__BODY = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Check Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_DEFINITION_FEATURE_COUNT = PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.StatementImpl <em>Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.StatementImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getStatement()
   * @generated
   */
  int STATEMENT = 13;

  /**
   * The number of structural features of the '<em>Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STATEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.BlockImpl <em>Block</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.BlockImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBlock()
   * @generated
   */
  int BLOCK = 14;

  /**
   * The feature id for the '<em><b>Statements</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK__STATEMENTS = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Block</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BLOCK_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallStatementImpl <em>Feature Call Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.FeatureCallStatementImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFeatureCallStatement()
   * @generated
   */
  int FEATURE_CALL_STATEMENT = 15;

  /**
   * The feature id for the '<em><b>Feature Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL_STATEMENT__FEATURE_CALL = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Assigned Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL_STATEMENT__ASSIGNED_VALUE = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Feature Call Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IfStatementImpl <em>If Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.IfStatementImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIfStatement()
   * @generated
   */
  int IF_STATEMENT = 16;

  /**
   * The feature id for the '<em><b>Cases</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__CASES = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Else Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT__ELSE_BODY = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>If Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IfCaseImpl <em>If Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.IfCaseImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIfCase()
   * @generated
   */
  int IF_CASE = 17;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CASE__CONDITION = 0;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CASE__BODY = 1;

  /**
   * The number of structural features of the '<em>If Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_CASE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.WhileStatementImpl <em>While Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.WhileStatementImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getWhileStatement()
   * @generated
   */
  int WHILE_STATEMENT = 18;

  /**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int WHILE_STATEMENT__PREDICATE = STATEMENT_FEATURE_COUNT + 0;

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
  int DO_WHILE_STATEMENT = 19;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_WHILE_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Predicate</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_WHILE_STATEMENT__PREDICATE = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Do While Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DO_WHILE_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ForeachStatementImpl <em>Foreach Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ForeachStatementImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getForeachStatement()
   * @generated
   */
  int FOREACH_STATEMENT = 20;

  /**
   * The feature id for the '<em><b>Element Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREACH_STATEMENT__ELEMENT_NAME = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Collection Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREACH_STATEMENT__COLLECTION_EXPRESSION = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Body</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREACH_STATEMENT__BODY = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Foreach Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FOREACH_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ReturnStatementImpl <em>Return Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ReturnStatementImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getReturnStatement()
   * @generated
   */
  int RETURN_STATEMENT = 21;

  /**
   * The feature id for the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_STATEMENT__VALUE = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Return Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RETURN_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.CheckStatusStatementImpl <em>Check Status Statement</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.CheckStatusStatementImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getCheckStatusStatement()
   * @generated
   */
  int CHECK_STATUS_STATEMENT = 22;

  /**
   * The feature id for the '<em><b>Kind</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_STATUS_STATEMENT__KIND = STATEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Message</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_STATUS_STATEMENT__MESSAGE = STATEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Check Status Statement</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CHECK_STATUS_STATEMENT_FEATURE_COUNT = STATEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.TypeSpecifierImpl <em>Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.TypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTypeSpecifier()
   * @generated
   */
  int TYPE_SPECIFIER = 23;

  /**
   * The number of structural features of the '<em>Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_SPECIFIER_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.DataTypeSpecifierImpl <em>Data Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.DataTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getDataTypeSpecifier()
   * @generated
   */
  int DATA_TYPE_SPECIFIER = 24;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_SPECIFIER__DIMENSIONS = TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Data Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DATA_TYPE_SPECIFIER_FEATURE_COUNT = TYPE_SPECIFIER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.PrimitiveTypeSpecifierImpl <em>Primitive Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.PrimitiveTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPrimitiveTypeSpecifier()
   * @generated
   */
  int PRIMITIVE_TYPE_SPECIFIER = 25;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.NumericalTypeSpecifierImpl <em>Numerical Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.NumericalTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNumericalTypeSpecifier()
   * @generated
   */
  int NUMERICAL_TYPE_SPECIFIER = 26;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_TYPE_SPECIFIER__DIMENSIONS = PRIMITIVE_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_TYPE_SPECIFIER__UNIT = PRIMITIVE_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Numerical Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_TYPE_SPECIFIER_FEATURE_COUNT = PRIMITIVE_TYPE_SPECIFIER_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RealTypeSpecifierImpl <em>Real Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.RealTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRealTypeSpecifier()
   * @generated
   */
  int REAL_TYPE_SPECIFIER = 27;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_TYPE_SPECIFIER__DIMENSIONS = NUMERICAL_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_TYPE_SPECIFIER__UNIT = NUMERICAL_TYPE_SPECIFIER__UNIT;

  /**
   * The number of structural features of the '<em>Real Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_TYPE_SPECIFIER_FEATURE_COUNT = NUMERICAL_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IntegerTypeSpecifierImpl <em>Integer Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.IntegerTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIntegerTypeSpecifier()
   * @generated
   */
  int INTEGER_TYPE_SPECIFIER = 28;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE_SPECIFIER__DIMENSIONS = NUMERICAL_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE_SPECIFIER__UNIT = NUMERICAL_TYPE_SPECIFIER__UNIT;

  /**
   * The number of structural features of the '<em>Integer Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_TYPE_SPECIFIER_FEATURE_COUNT = NUMERICAL_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ComplexTypeSpecifierImpl <em>Complex Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ComplexTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getComplexTypeSpecifier()
   * @generated
   */
  int COMPLEX_TYPE_SPECIFIER = 29;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_TYPE_SPECIFIER__DIMENSIONS = NUMERICAL_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_TYPE_SPECIFIER__UNIT = NUMERICAL_TYPE_SPECIFIER__UNIT;

  /**
   * The number of structural features of the '<em>Complex Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPLEX_TYPE_SPECIFIER_FEATURE_COUNT = NUMERICAL_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.GaussianTypeSpecifierImpl <em>Gaussian Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.GaussianTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getGaussianTypeSpecifier()
   * @generated
   */
  int GAUSSIAN_TYPE_SPECIFIER = 30;

  /**
   * The feature id for the '<em><b>Dimensions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAUSSIAN_TYPE_SPECIFIER__DIMENSIONS = NUMERICAL_TYPE_SPECIFIER__DIMENSIONS;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAUSSIAN_TYPE_SPECIFIER__UNIT = NUMERICAL_TYPE_SPECIFIER__UNIT;

  /**
   * The number of structural features of the '<em>Gaussian Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int GAUSSIAN_TYPE_SPECIFIER_FEATURE_COUNT = NUMERICAL_TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.BooleanTypeSpecifierImpl <em>Boolean Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.BooleanTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBooleanTypeSpecifier()
   * @generated
   */
  int BOOLEAN_TYPE_SPECIFIER = 31;

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
  int STRING_TYPE_SPECIFIER = 32;

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
  int NAMED_TYPE_SPECIFIER = 33;

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
  int ARRAY_DIMENSION_SPECIFICATION = 34;

  /**
   * The feature id for the '<em><b>Unspecified</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_DIMENSION_SPECIFICATION__UNSPECIFIED = 0;

  /**
   * The feature id for the '<em><b>Size</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_DIMENSION_SPECIFICATION__SIZE = 1;

  /**
   * The feature id for the '<em><b>Begin Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_DIMENSION_SPECIFICATION__BEGIN_INDEX = 2;

  /**
   * The feature id for the '<em><b>End Index</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_DIMENSION_SPECIFICATION__END_INDEX = 3;

  /**
   * The number of structural features of the '<em>Array Dimension Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_DIMENSION_SPECIFICATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitTypeSpecifierImpl <em>Unit Type Specifier</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.UnitTypeSpecifierImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitTypeSpecifier()
   * @generated
   */
  int UNIT_TYPE_SPECIFIER = 35;

  /**
   * The number of structural features of the '<em>Unit Type Specifier</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_TYPE_SPECIFIER_FEATURE_COUNT = TYPE_SPECIFIER_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 36;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ConditionalExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getConditionalExpression()
   * @generated
   */
  int CONDITIONAL_EXPRESSION = 37;

  /**
   * The feature id for the '<em><b>Cases</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__CASES = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION__ELSE_EXPRESSION = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Conditional Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ConditionalExpressionCaseImpl <em>Conditional Expression Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ConditionalExpressionCaseImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getConditionalExpressionCase()
   * @generated
   */
  int CONDITIONAL_EXPRESSION_CASE = 38;

  /**
   * The feature id for the '<em><b>Condition Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Conditional Expression Case</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONDITIONAL_EXPRESSION_CASE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.AddSubtractExpressionPartImpl <em>Add Subtract Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.AddSubtractExpressionPartImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAddSubtractExpressionPart()
   * @generated
   */
  int ADD_SUBTRACT_EXPRESSION_PART = 39;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_SUBTRACT_EXPRESSION_PART__OPERATOR = 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_SUBTRACT_EXPRESSION_PART__OPERAND = 1;

  /**
   * The number of structural features of the '<em>Add Subtract Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_SUBTRACT_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.MultiplyDivideExpressionPartImpl <em>Multiply Divide Expression Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.MultiplyDivideExpressionPartImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplyDivideExpressionPart()
   * @generated
   */
  int MULTIPLY_DIVIDE_EXPRESSION_PART = 40;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY_DIVIDE_EXPRESSION_PART__OPERATOR = 0;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY_DIVIDE_EXPRESSION_PART__OPERAND = 1;

  /**
   * The number of structural features of the '<em>Multiply Divide Expression Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY_DIVIDE_EXPRESSION_PART_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallPartImpl <em>Feature Call Part</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.FeatureCallPartImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFeatureCallPart()
   * @generated
   */
  int FEATURE_CALL_PART = 41;

  /**
   * The number of structural features of the '<em>Feature Call Part</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_CALL_PART_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.FeatureReferenceImpl <em>Feature Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.FeatureReferenceImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFeatureReference()
   * @generated
   */
  int FEATURE_REFERENCE = 42;

  /**
   * The feature id for the '<em><b>Feature Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_REFERENCE__FEATURE_NAME = FEATURE_CALL_PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Feature Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FEATURE_REFERENCE_FEATURE_COUNT = FEATURE_CALL_PART_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayElementReferenceImpl <em>Array Element Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ArrayElementReferenceImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayElementReference()
   * @generated
   */
  int ARRAY_ELEMENT_REFERENCE = 43;

  /**
   * The feature id for the '<em><b>Subscripts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ELEMENT_REFERENCE__SUBSCRIPTS = FEATURE_CALL_PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array Element Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_ELEMENT_REFERENCE_FEATURE_COUNT = FEATURE_CALL_PART_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.OperationCallImpl <em>Operation Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.OperationCallImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getOperationCall()
   * @generated
   */
  int OPERATION_CALL = 44;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL__ARGUMENTS = FEATURE_CALL_PART_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Operation Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CALL_FEATURE_COUNT = FEATURE_CALL_PART_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.LiteralImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 45;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.NumericalLiteralImpl <em>Numerical Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.NumericalLiteralImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNumericalLiteral()
   * @generated
   */
  int NUMERICAL_LITERAL = 46;

  /**
   * The feature id for the '<em><b>Imaginary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_LITERAL__IMAGINARY = LITERAL_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_LITERAL__UNIT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Numerical Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RealLiteralImpl <em>Real Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.RealLiteralImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRealLiteral()
   * @generated
   */
  int REAL_LITERAL = 47;

  /**
   * The feature id for the '<em><b>Imaginary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__IMAGINARY = NUMERICAL_LITERAL__IMAGINARY;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__UNIT = NUMERICAL_LITERAL__UNIT;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL__VALUE = NUMERICAL_LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Real Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REAL_LITERAL_FEATURE_COUNT = NUMERICAL_LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.IntegerLiteralImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIntegerLiteral()
   * @generated
   */
  int INTEGER_LITERAL = 48;

  /**
   * The feature id for the '<em><b>Imaginary</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL__IMAGINARY = NUMERICAL_LITERAL__IMAGINARY;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL__UNIT = NUMERICAL_LITERAL__UNIT;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL__VALUE = NUMERICAL_LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Integer Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INTEGER_LITERAL_FEATURE_COUNT = NUMERICAL_LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.BooleanLiteralImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 49;

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
  int STRING_LITERAL = 50;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.QualifiedNameImpl <em>Qualified Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.QualifiedNameImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getQualifiedName()
   * @generated
   */
  int QUALIFIED_NAME = 51;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.SymbolReferenceImpl <em>Symbol Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.SymbolReferenceImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getSymbolReference()
   * @generated
   */
  int SYMBOL_REFERENCE = 52;

  /**
   * The feature id for the '<em><b>Global</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMBOL_REFERENCE__GLOBAL = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMBOL_REFERENCE__NAME = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Symbol Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SYMBOL_REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.SubscriptImpl <em>Subscript</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.SubscriptImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getSubscript()
   * @generated
   */
  int SUBSCRIPT = 53;

  /**
   * The feature id for the '<em><b>All</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSCRIPT__ALL = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSCRIPT__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Subscript</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSCRIPT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.MatrixConstructionOperatorImpl <em>Matrix Construction Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.MatrixConstructionOperatorImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMatrixConstructionOperator()
   * @generated
   */
  int MATRIX_CONSTRUCTION_OPERATOR = 54;

  /**
   * The feature id for the '<em><b>Expression Lists</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_CONSTRUCTION_OPERATOR__EXPRESSION_LISTS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Matrix Construction Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MATRIX_CONSTRUCTION_OPERATOR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.ExpressionListImpl <em>Expression List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.ExpressionListImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getExpressionList()
   * @generated
   */
  int EXPRESSION_LIST = 55;

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
  int UNIT_CONSTRUCTION_OPERATOR = 56;

  /**
   * The feature id for the '<em><b>Unit Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_CONSTRUCTION_OPERATOR__UNIT_EXPRESSION = EXPRESSION_FEATURE_COUNT + 0;

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
  int PARENTHESIZED_EXPRESSION = 57;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.BeginExpressionImpl <em>Begin Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.BeginExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBeginExpression()
   * @generated
   */
  int BEGIN_EXPRESSION = 58;

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
  int END_EXPRESSION = 59;

  /**
   * The number of structural features of the '<em>End Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int END_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionImpl <em>Unit Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpression()
   * @generated
   */
  int UNIT_EXPRESSION = 60;

  /**
   * The feature id for the '<em><b>Unspecified</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION__UNSPECIFIED = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION__EXPRESSION = 1;

  /**
   * The feature id for the '<em><b>Numerator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION__NUMERATOR = 2;

  /**
   * The feature id for the '<em><b>Denominator</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION__DENOMINATOR = 3;

  /**
   * The number of structural features of the '<em>Unit Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNIT_EXPRESSION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionNumeratorImpl <em>Unit Expression Numerator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionNumeratorImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpressionNumerator()
   * @generated
   */
  int UNIT_EXPRESSION_NUMERATOR = 61;

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
  int UNIT_EXPRESSION_DENOMINATOR = 62;

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
  int UNIT_EXPRESSION_FACTOR = 63;

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
  int UNIT_EXPRESSION_EXPONENT = 64;

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
  int RANGE_EXPRESSION = 65;

  /**
   * The feature id for the '<em><b>Begin</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_EXPRESSION__BEGIN = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>End</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_EXPRESSION__END = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Increment</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_EXPRESSION__INCREMENT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Range Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.LogicalOrExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLogicalOrExpression()
   * @generated
   */
  int LOGICAL_OR_EXPRESSION = 66;

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
  int LOGICAL_AND_EXPRESSION = 67;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.LogicalNotExpressionImpl <em>Logical Not Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.LogicalNotExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLogicalNotExpression()
   * @generated
   */
  int LOGICAL_NOT_EXPRESSION = 68;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.RelationalExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 69;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Type Test</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__TYPE_TEST = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__TYPE = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Operator</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.AddSubtractExpressionImpl <em>Add Subtract Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.AddSubtractExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAddSubtractExpression()
   * @generated
   */
  int ADD_SUBTRACT_EXPRESSION = 70;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_SUBTRACT_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_SUBTRACT_EXPRESSION__RIGHT_PARTS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Add Subtract Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_SUBTRACT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.MultiplyDivideExpressionImpl <em>Multiply Divide Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.MultiplyDivideExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplyDivideExpression()
   * @generated
   */
  int MULTIPLY_DIVIDE_EXPRESSION = 71;

  /**
   * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Right Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY_DIVIDE_EXPRESSION__RIGHT_PARTS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Multiply Divide Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY_DIVIDE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.PowerExpressionImpl <em>Power Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.PowerExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPowerExpression()
   * @generated
   */
  int POWER_EXPRESSION = 72;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.impl.UnaryMinusExpressionImpl <em>Unary Minus Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.impl.UnaryMinusExpressionImpl
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnaryMinusExpression()
   * @generated
   */
  int UNARY_MINUS_EXPRESSION = 73;

  /**
   * The feature id for the '<em><b>Operand</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_MINUS_EXPRESSION__OPERAND = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Unary Minus Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNARY_MINUS_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

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
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.CheckStatusKind <em>Check Status Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.CheckStatusKind
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getCheckStatusKind()
   * @generated
   */
  int CHECK_STATUS_KIND = 75;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.RelationalOperator
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getRelationalOperator()
   * @generated
   */
  int RELATIONAL_OPERATOR = 76;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.AddSubtractOperator <em>Add Subtract Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.AddSubtractOperator
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAddSubtractOperator()
   * @generated
   */
  int ADD_SUBTRACT_OPERATOR = 77;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.MultiplyDivideOperator <em>Multiply Divide Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.MultiplyDivideOperator
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplyDivideOperator()
   * @generated
   */
  int MULTIPLY_DIVIDE_OPERATOR = 78;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.PowerOperator <em>Power Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.PowerOperator
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPowerOperator()
   * @generated
   */
  int POWER_OPERATOR = 79;

  /**
   * The meta object id for the '{@link org.eclipselabs.mscript.language.ast.BooleanKind <em>Boolean Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.mscript.language.ast.BooleanKind
   * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBooleanKind()
   * @generated
   */
  int BOOLEAN_KIND = 80;


  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Mscript <em>Mscript</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mscript</em>'.
   * @see org.eclipselabs.mscript.language.ast.Mscript
   * @generated
   */
  EClass getMscript();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.Mscript#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Packages</em>'.
   * @see org.eclipselabs.mscript.language.ast.Mscript#getPackages()
   * @see #getMscript()
   * @generated
   */
  EReference getMscript_Packages();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.PackageDefinition <em>Package Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Definition</em>'.
   * @see org.eclipselabs.mscript.language.ast.PackageDefinition
   * @generated
   */
  EClass getPackageDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.PackageDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.PackageDefinition#getName()
   * @see #getPackageDefinition()
   * @generated
   */
  EReference getPackageDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.PackageDefinition#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipselabs.mscript.language.ast.PackageDefinition#getElements()
   * @see #getPackageDefinition()
   * @generated
   */
  EReference getPackageDefinition_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.PackageDefinitionElement <em>Package Definition Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Definition Element</em>'.
   * @see org.eclipselabs.mscript.language.ast.PackageDefinitionElement
   * @generated
   */
  EClass getPackageDefinitionElement();

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
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.EnumerationDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.EnumerationDefinition#getName()
   * @see #getEnumerationDefinition()
   * @generated
   */
  EAttribute getEnumerationDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.EnumerationDefinition#getLiterals <em>Literals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Literals</em>'.
   * @see org.eclipselabs.mscript.language.ast.EnumerationDefinition#getLiterals()
   * @see #getEnumerationDefinition()
   * @generated
   */
  EReference getEnumerationDefinition_Literals();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.TypeDefinition <em>Type Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Definition</em>'.
   * @see org.eclipselabs.mscript.language.ast.TypeDefinition
   * @generated
   */
  EClass getTypeDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.TypeDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.TypeDefinition#getName()
   * @see #getTypeDefinition()
   * @generated
   */
  EAttribute getTypeDefinition_Name();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.TypeDefinition#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipselabs.mscript.language.ast.TypeDefinition#getType()
   * @see #getTypeDefinition()
   * @generated
   */
  EReference getTypeDefinition_Type();

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
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.VariableDeclaration#getModifier <em>Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Modifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.VariableDeclaration#getModifier()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_Modifier();

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
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.VariableDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipselabs.mscript.language.ast.VariableDeclaration#getType()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_Type();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.VariableDeclaration#getInitialValue <em>Initial Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Initial Value</em>'.
   * @see org.eclipselabs.mscript.language.ast.VariableDeclaration#getInitialValue()
   * @see #getVariableDeclaration()
   * @generated
   */
  EReference getVariableDeclaration_InitialValue();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.VariableModifier <em>Variable Modifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Variable Modifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.VariableModifier
   * @generated
   */
  EClass getVariableModifier();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.VariableModifier#getAuto <em>Auto</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Auto</em>'.
   * @see org.eclipselabs.mscript.language.ast.VariableModifier#getAuto()
   * @see #getVariableModifier()
   * @generated
   */
  EAttribute getVariableModifier_Auto();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.VariableModifier#getConstant <em>Constant</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Constant</em>'.
   * @see org.eclipselabs.mscript.language.ast.VariableModifier#getConstant()
   * @see #getVariableModifier()
   * @generated
   */
  EAttribute getVariableModifier_Constant();

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
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.RecordDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.RecordDefinition#getName()
   * @see #getRecordDefinition()
   * @generated
   */
  EAttribute getRecordDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.RecordDefinition#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Fields</em>'.
   * @see org.eclipselabs.mscript.language.ast.RecordDefinition#getFields()
   * @see #getRecordDefinition()
   * @generated
   */
  EReference getRecordDefinition_Fields();

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
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getName()
   * @see #getFunctionDefinition()
   * @generated
   */
  EAttribute getFunctionDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getParameters()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getPrecondition <em>Precondition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Precondition</em>'.
   * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getPrecondition()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Precondition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.FunctionDefinition#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.eclipselabs.mscript.language.ast.FunctionDefinition#getBody()
   * @see #getFunctionDefinition()
   * @generated
   */
  EReference getFunctionDefinition_Body();

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
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.ParameterDeclaration#isReference <em>Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Reference</em>'.
   * @see org.eclipselabs.mscript.language.ast.ParameterDeclaration#isReference()
   * @see #getParameterDeclaration()
   * @generated
   */
  EAttribute getParameterDeclaration_Reference();

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
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ParameterDeclaration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipselabs.mscript.language.ast.ParameterDeclaration#getType()
   * @see #getParameterDeclaration()
   * @generated
   */
  EReference getParameterDeclaration_Type();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.CheckDefinition <em>Check Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Check Definition</em>'.
   * @see org.eclipselabs.mscript.language.ast.CheckDefinition
   * @generated
   */
  EClass getCheckDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.CheckDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.CheckDefinition#getName()
   * @see #getCheckDefinition()
   * @generated
   */
  EAttribute getCheckDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.CheckDefinition#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see org.eclipselabs.mscript.language.ast.CheckDefinition#getParameters()
   * @see #getCheckDefinition()
   * @generated
   */
  EReference getCheckDefinition_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.CheckDefinition#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.eclipselabs.mscript.language.ast.CheckDefinition#getBody()
   * @see #getCheckDefinition()
   * @generated
   */
  EReference getCheckDefinition_Body();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Block <em>Block</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Block</em>'.
   * @see org.eclipselabs.mscript.language.ast.Block
   * @generated
   */
  EClass getBlock();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.Block#getStatements <em>Statements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Statements</em>'.
   * @see org.eclipselabs.mscript.language.ast.Block#getStatements()
   * @see #getBlock()
   * @generated
   */
  EReference getBlock_Statements();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.FeatureCallStatement <em>Feature Call Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Call Statement</em>'.
   * @see org.eclipselabs.mscript.language.ast.FeatureCallStatement
   * @generated
   */
  EClass getFeatureCallStatement();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.FeatureCallStatement#getFeatureCall <em>Feature Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Feature Call</em>'.
   * @see org.eclipselabs.mscript.language.ast.FeatureCallStatement#getFeatureCall()
   * @see #getFeatureCallStatement()
   * @generated
   */
  EReference getFeatureCallStatement_FeatureCall();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.FeatureCallStatement#getAssignedValue <em>Assigned Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Assigned Value</em>'.
   * @see org.eclipselabs.mscript.language.ast.FeatureCallStatement#getAssignedValue()
   * @see #getFeatureCallStatement()
   * @generated
   */
  EReference getFeatureCallStatement_AssignedValue();

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
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.IfStatement#getCases <em>Cases</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Cases</em>'.
   * @see org.eclipselabs.mscript.language.ast.IfStatement#getCases()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_Cases();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IfStatement#getElseBody <em>Else Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Body</em>'.
   * @see org.eclipselabs.mscript.language.ast.IfStatement#getElseBody()
   * @see #getIfStatement()
   * @generated
   */
  EReference getIfStatement_ElseBody();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.IfCase <em>If Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Case</em>'.
   * @see org.eclipselabs.mscript.language.ast.IfCase
   * @generated
   */
  EClass getIfCase();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IfCase#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see org.eclipselabs.mscript.language.ast.IfCase#getCondition()
   * @see #getIfCase()
   * @generated
   */
  EReference getIfCase_Condition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.IfCase#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.eclipselabs.mscript.language.ast.IfCase#getBody()
   * @see #getIfCase()
   * @generated
   */
  EReference getIfCase_Body();

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
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.WhileStatement#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Predicate</em>'.
   * @see org.eclipselabs.mscript.language.ast.WhileStatement#getPredicate()
   * @see #getWhileStatement()
   * @generated
   */
  EReference getWhileStatement_Predicate();

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
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.DoWhileStatement#getPredicate <em>Predicate</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Predicate</em>'.
   * @see org.eclipselabs.mscript.language.ast.DoWhileStatement#getPredicate()
   * @see #getDoWhileStatement()
   * @generated
   */
  EReference getDoWhileStatement_Predicate();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ForeachStatement <em>Foreach Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Foreach Statement</em>'.
   * @see org.eclipselabs.mscript.language.ast.ForeachStatement
   * @generated
   */
  EClass getForeachStatement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.ForeachStatement#getElementName <em>Element Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Element Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.ForeachStatement#getElementName()
   * @see #getForeachStatement()
   * @generated
   */
  EAttribute getForeachStatement_ElementName();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ForeachStatement#getCollectionExpression <em>Collection Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Collection Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.ForeachStatement#getCollectionExpression()
   * @see #getForeachStatement()
   * @generated
   */
  EReference getForeachStatement_CollectionExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ForeachStatement#getBody <em>Body</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Body</em>'.
   * @see org.eclipselabs.mscript.language.ast.ForeachStatement#getBody()
   * @see #getForeachStatement()
   * @generated
   */
  EReference getForeachStatement_Body();

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
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ReturnStatement#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Value</em>'.
   * @see org.eclipselabs.mscript.language.ast.ReturnStatement#getValue()
   * @see #getReturnStatement()
   * @generated
   */
  EReference getReturnStatement_Value();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.CheckStatusStatement <em>Check Status Statement</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Check Status Statement</em>'.
   * @see org.eclipselabs.mscript.language.ast.CheckStatusStatement
   * @generated
   */
  EClass getCheckStatusStatement();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.CheckStatusStatement#getKind <em>Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Kind</em>'.
   * @see org.eclipselabs.mscript.language.ast.CheckStatusStatement#getKind()
   * @see #getCheckStatusStatement()
   * @generated
   */
  EAttribute getCheckStatusStatement_Kind();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.CheckStatusStatement#getMessage <em>Message</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Message</em>'.
   * @see org.eclipselabs.mscript.language.ast.CheckStatusStatement#getMessage()
   * @see #getCheckStatusStatement()
   * @generated
   */
  EReference getCheckStatusStatement_Message();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.TypeSpecifier <em>Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Specifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.TypeSpecifier
   * @generated
   */
  EClass getTypeSpecifier();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.NumericalTypeSpecifier <em>Numerical Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Type Specifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.NumericalTypeSpecifier
   * @generated
   */
  EClass getNumericalTypeSpecifier();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.NumericalTypeSpecifier#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit</em>'.
   * @see org.eclipselabs.mscript.language.ast.NumericalTypeSpecifier#getUnit()
   * @see #getNumericalTypeSpecifier()
   * @generated
   */
  EReference getNumericalTypeSpecifier_Unit();

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
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#isUnspecified <em>Unspecified</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unspecified</em>'.
   * @see org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#isUnspecified()
   * @see #getArrayDimensionSpecification()
   * @generated
   */
  EAttribute getArrayDimensionSpecification_Unspecified();

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
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getBeginIndex <em>Begin Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Begin Index</em>'.
   * @see org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getBeginIndex()
   * @see #getArrayDimensionSpecification()
   * @generated
   */
  EReference getArrayDimensionSpecification_BeginIndex();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getEndIndex <em>End Index</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>End Index</em>'.
   * @see org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification#getEndIndex()
   * @see #getArrayDimensionSpecification()
   * @generated
   */
  EReference getArrayDimensionSpecification_EndIndex();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.UnitTypeSpecifier <em>Unit Type Specifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Type Specifier</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitTypeSpecifier
   * @generated
   */
  EClass getUnitTypeSpecifier();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.ConditionalExpression
   * @generated
   */
  EClass getConditionalExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.ConditionalExpression#getCases <em>Cases</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Cases</em>'.
   * @see org.eclipselabs.mscript.language.ast.ConditionalExpression#getCases()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_Cases();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ConditionalExpression#getElseExpression <em>Else Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.ConditionalExpression#getElseExpression()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_ElseExpression();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ConditionalExpressionCase <em>Conditional Expression Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Expression Case</em>'.
   * @see org.eclipselabs.mscript.language.ast.ConditionalExpressionCase
   * @generated
   */
  EClass getConditionalExpressionCase();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ConditionalExpressionCase#getConditionExpression <em>Condition Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.ConditionalExpressionCase#getConditionExpression()
   * @see #getConditionalExpressionCase()
   * @generated
   */
  EReference getConditionalExpressionCase_ConditionExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ConditionalExpressionCase#getThenExpression <em>Then Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.ConditionalExpressionCase#getThenExpression()
   * @see #getConditionalExpressionCase()
   * @generated
   */
  EReference getConditionalExpressionCase_ThenExpression();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.AddSubtractExpressionPart <em>Add Subtract Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Add Subtract Expression Part</em>'.
   * @see org.eclipselabs.mscript.language.ast.AddSubtractExpressionPart
   * @generated
   */
  EClass getAddSubtractExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.AddSubtractExpressionPart#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipselabs.mscript.language.ast.AddSubtractExpressionPart#getOperator()
   * @see #getAddSubtractExpressionPart()
   * @generated
   */
  EAttribute getAddSubtractExpressionPart_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.AddSubtractExpressionPart#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.eclipselabs.mscript.language.ast.AddSubtractExpressionPart#getOperand()
   * @see #getAddSubtractExpressionPart()
   * @generated
   */
  EReference getAddSubtractExpressionPart_Operand();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.MultiplyDivideExpressionPart <em>Multiply Divide Expression Part</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiply Divide Expression Part</em>'.
   * @see org.eclipselabs.mscript.language.ast.MultiplyDivideExpressionPart
   * @generated
   */
  EClass getMultiplyDivideExpressionPart();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.MultiplyDivideExpressionPart#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipselabs.mscript.language.ast.MultiplyDivideExpressionPart#getOperator()
   * @see #getMultiplyDivideExpressionPart()
   * @generated
   */
  EAttribute getMultiplyDivideExpressionPart_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.MultiplyDivideExpressionPart#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.eclipselabs.mscript.language.ast.MultiplyDivideExpressionPart#getOperand()
   * @see #getMultiplyDivideExpressionPart()
   * @generated
   */
  EReference getMultiplyDivideExpressionPart_Operand();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.FeatureReference <em>Feature Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Feature Reference</em>'.
   * @see org.eclipselabs.mscript.language.ast.FeatureReference
   * @generated
   */
  EClass getFeatureReference();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.FeatureReference#getFeatureName <em>Feature Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Feature Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.FeatureReference#getFeatureName()
   * @see #getFeatureReference()
   * @generated
   */
  EAttribute getFeatureReference_FeatureName();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.ArrayElementReference <em>Array Element Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Element Reference</em>'.
   * @see org.eclipselabs.mscript.language.ast.ArrayElementReference
   * @generated
   */
  EClass getArrayElementReference();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.ArrayElementReference#getSubscripts <em>Subscripts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Subscripts</em>'.
   * @see org.eclipselabs.mscript.language.ast.ArrayElementReference#getSubscripts()
   * @see #getArrayElementReference()
   * @generated
   */
  EReference getArrayElementReference_Subscripts();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.OperationCall <em>Operation Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Call</em>'.
   * @see org.eclipselabs.mscript.language.ast.OperationCall
   * @generated
   */
  EClass getOperationCall();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.OperationCall#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see org.eclipselabs.mscript.language.ast.OperationCall#getArguments()
   * @see #getOperationCall()
   * @generated
   */
  EReference getOperationCall_Arguments();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.NumericalLiteral <em>Numerical Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Literal</em>'.
   * @see org.eclipselabs.mscript.language.ast.NumericalLiteral
   * @generated
   */
  EClass getNumericalLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.NumericalLiteral#isImaginary <em>Imaginary</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Imaginary</em>'.
   * @see org.eclipselabs.mscript.language.ast.NumericalLiteral#isImaginary()
   * @see #getNumericalLiteral()
   * @generated
   */
  EAttribute getNumericalLiteral_Imaginary();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.NumericalLiteral#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit</em>'.
   * @see org.eclipselabs.mscript.language.ast.NumericalLiteral#getUnit()
   * @see #getNumericalLiteral()
   * @generated
   */
  EReference getNumericalLiteral_Unit();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.SymbolReference <em>Symbol Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Symbol Reference</em>'.
   * @see org.eclipselabs.mscript.language.ast.SymbolReference
   * @generated
   */
  EClass getSymbolReference();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.SymbolReference#isGlobal <em>Global</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Global</em>'.
   * @see org.eclipselabs.mscript.language.ast.SymbolReference#isGlobal()
   * @see #getSymbolReference()
   * @generated
   */
  EAttribute getSymbolReference_Global();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.SymbolReference#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.eclipselabs.mscript.language.ast.SymbolReference#getName()
   * @see #getSymbolReference()
   * @generated
   */
  EReference getSymbolReference_Name();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.Subscript <em>Subscript</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subscript</em>'.
   * @see org.eclipselabs.mscript.language.ast.Subscript
   * @generated
   */
  EClass getSubscript();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.Subscript#isAll <em>All</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>All</em>'.
   * @see org.eclipselabs.mscript.language.ast.Subscript#isAll()
   * @see #getSubscript()
   * @generated
   */
  EAttribute getSubscript_All();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.Subscript#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.Subscript#getExpression()
   * @see #getSubscript()
   * @generated
   */
  EReference getSubscript_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.MatrixConstructionOperator <em>Matrix Construction Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Matrix Construction Operator</em>'.
   * @see org.eclipselabs.mscript.language.ast.MatrixConstructionOperator
   * @generated
   */
  EClass getMatrixConstructionOperator();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.MatrixConstructionOperator#getExpressionLists <em>Expression Lists</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Lists</em>'.
   * @see org.eclipselabs.mscript.language.ast.MatrixConstructionOperator#getExpressionLists()
   * @see #getMatrixConstructionOperator()
   * @generated
   */
  EReference getMatrixConstructionOperator_ExpressionLists();

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
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.UnitConstructionOperator#getUnitExpression <em>Unit Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitConstructionOperator#getUnitExpression()
   * @see #getUnitConstructionOperator()
   * @generated
   */
  EReference getUnitConstructionOperator_UnitExpression();

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
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.ParenthesizedExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.ParenthesizedExpression#getExpression()
   * @see #getParenthesizedExpression()
   * @generated
   */
  EReference getParenthesizedExpression_Expression();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.UnitExpression <em>Unit Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpression
   * @generated
   */
  EClass getUnitExpression();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.UnitExpression#isUnspecified <em>Unspecified</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Unspecified</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpression#isUnspecified()
   * @see #getUnitExpression()
   * @generated
   */
  EAttribute getUnitExpression_Unspecified();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.UnitExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnitExpression#getExpression()
   * @see #getUnitExpression()
   * @generated
   */
  EReference getUnitExpression_Expression();

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
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.RangeExpression#getBegin <em>Begin</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Begin</em>'.
   * @see org.eclipselabs.mscript.language.ast.RangeExpression#getBegin()
   * @see #getRangeExpression()
   * @generated
   */
  EReference getRangeExpression_Begin();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.RangeExpression#getEnd <em>End</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>End</em>'.
   * @see org.eclipselabs.mscript.language.ast.RangeExpression#getEnd()
   * @see #getRangeExpression()
   * @generated
   */
  EReference getRangeExpression_End();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.RangeExpression#getIncrement <em>Increment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Increment</em>'.
   * @see org.eclipselabs.mscript.language.ast.RangeExpression#getIncrement()
   * @see #getRangeExpression()
   * @generated
   */
  EReference getRangeExpression_Increment();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.LogicalNotExpression <em>Logical Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Not Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.LogicalNotExpression
   * @generated
   */
  EClass getLogicalNotExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.LogicalNotExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.eclipselabs.mscript.language.ast.LogicalNotExpression#getOperand()
   * @see #getLogicalNotExpression()
   * @generated
   */
  EReference getLogicalNotExpression_Operand();

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
   * Returns the meta object for the attribute '{@link org.eclipselabs.mscript.language.ast.RelationalExpression#isTypeTest <em>Type Test</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type Test</em>'.
   * @see org.eclipselabs.mscript.language.ast.RelationalExpression#isTypeTest()
   * @see #getRelationalExpression()
   * @generated
   */
  EAttribute getRelationalExpression_TypeTest();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.RelationalExpression#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Type</em>'.
   * @see org.eclipselabs.mscript.language.ast.RelationalExpression#getType()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Type();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.AddSubtractExpression <em>Add Subtract Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Add Subtract Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.AddSubtractExpression
   * @generated
   */
  EClass getAddSubtractExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.AddSubtractExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.eclipselabs.mscript.language.ast.AddSubtractExpression#getLeftOperand()
   * @see #getAddSubtractExpression()
   * @generated
   */
  EReference getAddSubtractExpression_LeftOperand();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.AddSubtractExpression#getRightParts <em>Right Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Right Parts</em>'.
   * @see org.eclipselabs.mscript.language.ast.AddSubtractExpression#getRightParts()
   * @see #getAddSubtractExpression()
   * @generated
   */
  EReference getAddSubtractExpression_RightParts();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.MultiplyDivideExpression <em>Multiply Divide Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiply Divide Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.MultiplyDivideExpression
   * @generated
   */
  EClass getMultiplyDivideExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.MultiplyDivideExpression#getLeftOperand <em>Left Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Left Operand</em>'.
   * @see org.eclipselabs.mscript.language.ast.MultiplyDivideExpression#getLeftOperand()
   * @see #getMultiplyDivideExpression()
   * @generated
   */
  EReference getMultiplyDivideExpression_LeftOperand();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.mscript.language.ast.MultiplyDivideExpression#getRightParts <em>Right Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Right Parts</em>'.
   * @see org.eclipselabs.mscript.language.ast.MultiplyDivideExpression#getRightParts()
   * @see #getMultiplyDivideExpression()
   * @generated
   */
  EReference getMultiplyDivideExpression_RightParts();

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
   * Returns the meta object for class '{@link org.eclipselabs.mscript.language.ast.UnaryMinusExpression <em>Unary Minus Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Minus Expression</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnaryMinusExpression
   * @generated
   */
  EClass getUnaryMinusExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.mscript.language.ast.UnaryMinusExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.eclipselabs.mscript.language.ast.UnaryMinusExpression#getOperand()
   * @see #getUnaryMinusExpression()
   * @generated
   */
  EReference getUnaryMinusExpression_Operand();

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
   * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.CheckStatusKind <em>Check Status Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Check Status Kind</em>'.
   * @see org.eclipselabs.mscript.language.ast.CheckStatusKind
   * @generated
   */
  EEnum getCheckStatusKind();

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
   * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.AddSubtractOperator <em>Add Subtract Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Add Subtract Operator</em>'.
   * @see org.eclipselabs.mscript.language.ast.AddSubtractOperator
   * @generated
   */
  EEnum getAddSubtractOperator();

  /**
   * Returns the meta object for enum '{@link org.eclipselabs.mscript.language.ast.MultiplyDivideOperator <em>Multiply Divide Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Multiply Divide Operator</em>'.
   * @see org.eclipselabs.mscript.language.ast.MultiplyDivideOperator
   * @generated
   */
  EEnum getMultiplyDivideOperator();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.MscriptImpl <em>Mscript</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.MscriptImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMscript()
     * @generated
     */
    EClass MSCRIPT = eINSTANCE.getMscript();

    /**
     * The meta object literal for the '<em><b>Packages</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MSCRIPT__PACKAGES = eINSTANCE.getMscript_Packages();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.PackageDefinitionImpl <em>Package Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.PackageDefinitionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPackageDefinition()
     * @generated
     */
    EClass PACKAGE_DEFINITION = eINSTANCE.getPackageDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DEFINITION__NAME = eINSTANCE.getPackageDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PACKAGE_DEFINITION__ELEMENTS = eINSTANCE.getPackageDefinition_Elements();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.PackageDefinitionElementImpl <em>Package Definition Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.PackageDefinitionElementImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getPackageDefinitionElement()
     * @generated
     */
    EClass PACKAGE_DEFINITION_ELEMENT = eINSTANCE.getPackageDefinitionElement();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUMERATION_DEFINITION__NAME = eINSTANCE.getEnumerationDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Literals</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ENUMERATION_DEFINITION__LITERALS = eINSTANCE.getEnumerationDefinition_Literals();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.TypeDefinitionImpl <em>Type Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.TypeDefinitionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTypeDefinition()
     * @generated
     */
    EClass TYPE_DEFINITION = eINSTANCE.getTypeDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_DEFINITION__NAME = eINSTANCE.getTypeDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_DEFINITION__TYPE = eINSTANCE.getTypeDefinition_Type();

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
     * The meta object literal for the '<em><b>Modifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__MODIFIER = eINSTANCE.getVariableDeclaration_Modifier();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_DECLARATION__NAME = eINSTANCE.getVariableDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__TYPE = eINSTANCE.getVariableDeclaration_Type();

    /**
     * The meta object literal for the '<em><b>Initial Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference VARIABLE_DECLARATION__INITIAL_VALUE = eINSTANCE.getVariableDeclaration_InitialValue();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.VariableModifierImpl <em>Variable Modifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.VariableModifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getVariableModifier()
     * @generated
     */
    EClass VARIABLE_MODIFIER = eINSTANCE.getVariableModifier();

    /**
     * The meta object literal for the '<em><b>Auto</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_MODIFIER__AUTO = eINSTANCE.getVariableModifier_Auto();

    /**
     * The meta object literal for the '<em><b>Constant</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute VARIABLE_MODIFIER__CONSTANT = eINSTANCE.getVariableModifier_Constant();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RECORD_DEFINITION__NAME = eINSTANCE.getRecordDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RECORD_DEFINITION__FIELDS = eINSTANCE.getRecordDefinition_Fields();

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
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FUNCTION_DEFINITION__NAME = eINSTANCE.getFunctionDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__PARAMETERS = eINSTANCE.getFunctionDefinition_Parameters();

    /**
     * The meta object literal for the '<em><b>Precondition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__PRECONDITION = eINSTANCE.getFunctionDefinition_Precondition();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_DEFINITION__BODY = eINSTANCE.getFunctionDefinition_Body();

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
     * The meta object literal for the '<em><b>Reference</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER_DECLARATION__REFERENCE = eINSTANCE.getParameterDeclaration_Reference();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER_DECLARATION__NAME = eINSTANCE.getParameterDeclaration_Name();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_DECLARATION__TYPE = eINSTANCE.getParameterDeclaration_Type();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.CheckDefinitionImpl <em>Check Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.CheckDefinitionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getCheckDefinition()
     * @generated
     */
    EClass CHECK_DEFINITION = eINSTANCE.getCheckDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHECK_DEFINITION__NAME = eINSTANCE.getCheckDefinition_Name();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHECK_DEFINITION__PARAMETERS = eINSTANCE.getCheckDefinition_Parameters();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHECK_DEFINITION__BODY = eINSTANCE.getCheckDefinition_Body();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.BlockImpl <em>Block</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.BlockImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getBlock()
     * @generated
     */
    EClass BLOCK = eINSTANCE.getBlock();

    /**
     * The meta object literal for the '<em><b>Statements</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference BLOCK__STATEMENTS = eINSTANCE.getBlock_Statements();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.FeatureCallStatementImpl <em>Feature Call Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.FeatureCallStatementImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFeatureCallStatement()
     * @generated
     */
    EClass FEATURE_CALL_STATEMENT = eINSTANCE.getFeatureCallStatement();

    /**
     * The meta object literal for the '<em><b>Feature Call</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_CALL_STATEMENT__FEATURE_CALL = eINSTANCE.getFeatureCallStatement_FeatureCall();

    /**
     * The meta object literal for the '<em><b>Assigned Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FEATURE_CALL_STATEMENT__ASSIGNED_VALUE = eINSTANCE.getFeatureCallStatement_AssignedValue();

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
     * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__CASES = eINSTANCE.getIfStatement_Cases();

    /**
     * The meta object literal for the '<em><b>Else Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_STATEMENT__ELSE_BODY = eINSTANCE.getIfStatement_ElseBody();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.IfCaseImpl <em>If Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.IfCaseImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getIfCase()
     * @generated
     */
    EClass IF_CASE = eINSTANCE.getIfCase();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_CASE__CONDITION = eINSTANCE.getIfCase_Condition();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_CASE__BODY = eINSTANCE.getIfCase_Body();

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
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference WHILE_STATEMENT__PREDICATE = eINSTANCE.getWhileStatement_Predicate();

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
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DO_WHILE_STATEMENT__BODY = eINSTANCE.getDoWhileStatement_Body();

    /**
     * The meta object literal for the '<em><b>Predicate</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DO_WHILE_STATEMENT__PREDICATE = eINSTANCE.getDoWhileStatement_Predicate();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ForeachStatementImpl <em>Foreach Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.ForeachStatementImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getForeachStatement()
     * @generated
     */
    EClass FOREACH_STATEMENT = eINSTANCE.getForeachStatement();

    /**
     * The meta object literal for the '<em><b>Element Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FOREACH_STATEMENT__ELEMENT_NAME = eINSTANCE.getForeachStatement_ElementName();

    /**
     * The meta object literal for the '<em><b>Collection Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOREACH_STATEMENT__COLLECTION_EXPRESSION = eINSTANCE.getForeachStatement_CollectionExpression();

    /**
     * The meta object literal for the '<em><b>Body</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FOREACH_STATEMENT__BODY = eINSTANCE.getForeachStatement_Body();

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
     * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RETURN_STATEMENT__VALUE = eINSTANCE.getReturnStatement_Value();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.CheckStatusStatementImpl <em>Check Status Statement</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.CheckStatusStatementImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getCheckStatusStatement()
     * @generated
     */
    EClass CHECK_STATUS_STATEMENT = eINSTANCE.getCheckStatusStatement();

    /**
     * The meta object literal for the '<em><b>Kind</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CHECK_STATUS_STATEMENT__KIND = eINSTANCE.getCheckStatusStatement_Kind();

    /**
     * The meta object literal for the '<em><b>Message</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CHECK_STATUS_STATEMENT__MESSAGE = eINSTANCE.getCheckStatusStatement_Message();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.TypeSpecifierImpl <em>Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.TypeSpecifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getTypeSpecifier()
     * @generated
     */
    EClass TYPE_SPECIFIER = eINSTANCE.getTypeSpecifier();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.NumericalTypeSpecifierImpl <em>Numerical Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.NumericalTypeSpecifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNumericalTypeSpecifier()
     * @generated
     */
    EClass NUMERICAL_TYPE_SPECIFIER = eINSTANCE.getNumericalTypeSpecifier();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_TYPE_SPECIFIER__UNIT = eINSTANCE.getNumericalTypeSpecifier_Unit();

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
     * The meta object literal for the '<em><b>Unspecified</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ARRAY_DIMENSION_SPECIFICATION__UNSPECIFIED = eINSTANCE.getArrayDimensionSpecification_Unspecified();

    /**
     * The meta object literal for the '<em><b>Size</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_DIMENSION_SPECIFICATION__SIZE = eINSTANCE.getArrayDimensionSpecification_Size();

    /**
     * The meta object literal for the '<em><b>Begin Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_DIMENSION_SPECIFICATION__BEGIN_INDEX = eINSTANCE.getArrayDimensionSpecification_BeginIndex();

    /**
     * The meta object literal for the '<em><b>End Index</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_DIMENSION_SPECIFICATION__END_INDEX = eINSTANCE.getArrayDimensionSpecification_EndIndex();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitTypeSpecifierImpl <em>Unit Type Specifier</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.UnitTypeSpecifierImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitTypeSpecifier()
     * @generated
     */
    EClass UNIT_TYPE_SPECIFIER = eINSTANCE.getUnitTypeSpecifier();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.ConditionalExpressionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getConditionalExpression()
     * @generated
     */
    EClass CONDITIONAL_EXPRESSION = eINSTANCE.getConditionalExpression();

    /**
     * The meta object literal for the '<em><b>Cases</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__CASES = eINSTANCE.getConditionalExpression_Cases();

    /**
     * The meta object literal for the '<em><b>Else Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION__ELSE_EXPRESSION = eINSTANCE.getConditionalExpression_ElseExpression();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ConditionalExpressionCaseImpl <em>Conditional Expression Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.ConditionalExpressionCaseImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getConditionalExpressionCase()
     * @generated
     */
    EClass CONDITIONAL_EXPRESSION_CASE = eINSTANCE.getConditionalExpressionCase();

    /**
     * The meta object literal for the '<em><b>Condition Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION_CASE__CONDITION_EXPRESSION = eINSTANCE.getConditionalExpressionCase_ConditionExpression();

    /**
     * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONDITIONAL_EXPRESSION_CASE__THEN_EXPRESSION = eINSTANCE.getConditionalExpressionCase_ThenExpression();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.AddSubtractExpressionPartImpl <em>Add Subtract Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.AddSubtractExpressionPartImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAddSubtractExpressionPart()
     * @generated
     */
    EClass ADD_SUBTRACT_EXPRESSION_PART = eINSTANCE.getAddSubtractExpressionPart();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADD_SUBTRACT_EXPRESSION_PART__OPERATOR = eINSTANCE.getAddSubtractExpressionPart_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD_SUBTRACT_EXPRESSION_PART__OPERAND = eINSTANCE.getAddSubtractExpressionPart_Operand();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.MultiplyDivideExpressionPartImpl <em>Multiply Divide Expression Part</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.MultiplyDivideExpressionPartImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplyDivideExpressionPart()
     * @generated
     */
    EClass MULTIPLY_DIVIDE_EXPRESSION_PART = eINSTANCE.getMultiplyDivideExpressionPart();

    /**
     * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLY_DIVIDE_EXPRESSION_PART__OPERATOR = eINSTANCE.getMultiplyDivideExpressionPart_Operator();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLY_DIVIDE_EXPRESSION_PART__OPERAND = eINSTANCE.getMultiplyDivideExpressionPart_Operand();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.FeatureReferenceImpl <em>Feature Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.FeatureReferenceImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getFeatureReference()
     * @generated
     */
    EClass FEATURE_REFERENCE = eINSTANCE.getFeatureReference();

    /**
     * The meta object literal for the '<em><b>Feature Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FEATURE_REFERENCE__FEATURE_NAME = eINSTANCE.getFeatureReference_FeatureName();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.ArrayElementReferenceImpl <em>Array Element Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.ArrayElementReferenceImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getArrayElementReference()
     * @generated
     */
    EClass ARRAY_ELEMENT_REFERENCE = eINSTANCE.getArrayElementReference();

    /**
     * The meta object literal for the '<em><b>Subscripts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_ELEMENT_REFERENCE__SUBSCRIPTS = eINSTANCE.getArrayElementReference_Subscripts();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.OperationCallImpl <em>Operation Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.OperationCallImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getOperationCall()
     * @generated
     */
    EClass OPERATION_CALL = eINSTANCE.getOperationCall();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CALL__ARGUMENTS = eINSTANCE.getOperationCall_Arguments();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.NumericalLiteralImpl <em>Numerical Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.NumericalLiteralImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getNumericalLiteral()
     * @generated
     */
    EClass NUMERICAL_LITERAL = eINSTANCE.getNumericalLiteral();

    /**
     * The meta object literal for the '<em><b>Imaginary</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NUMERICAL_LITERAL__IMAGINARY = eINSTANCE.getNumericalLiteral_Imaginary();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_LITERAL__UNIT = eINSTANCE.getNumericalLiteral_Unit();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.SymbolReferenceImpl <em>Symbol Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.SymbolReferenceImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getSymbolReference()
     * @generated
     */
    EClass SYMBOL_REFERENCE = eINSTANCE.getSymbolReference();

    /**
     * The meta object literal for the '<em><b>Global</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SYMBOL_REFERENCE__GLOBAL = eINSTANCE.getSymbolReference_Global();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SYMBOL_REFERENCE__NAME = eINSTANCE.getSymbolReference_Name();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.SubscriptImpl <em>Subscript</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.SubscriptImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getSubscript()
     * @generated
     */
    EClass SUBSCRIPT = eINSTANCE.getSubscript();

    /**
     * The meta object literal for the '<em><b>All</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SUBSCRIPT__ALL = eINSTANCE.getSubscript_All();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SUBSCRIPT__EXPRESSION = eINSTANCE.getSubscript_Expression();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.MatrixConstructionOperatorImpl <em>Matrix Construction Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.MatrixConstructionOperatorImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMatrixConstructionOperator()
     * @generated
     */
    EClass MATRIX_CONSTRUCTION_OPERATOR = eINSTANCE.getMatrixConstructionOperator();

    /**
     * The meta object literal for the '<em><b>Expression Lists</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MATRIX_CONSTRUCTION_OPERATOR__EXPRESSION_LISTS = eINSTANCE.getMatrixConstructionOperator_ExpressionLists();

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
     * The meta object literal for the '<em><b>Unit Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT_CONSTRUCTION_OPERATOR__UNIT_EXPRESSION = eINSTANCE.getUnitConstructionOperator_UnitExpression();

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
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARENTHESIZED_EXPRESSION__EXPRESSION = eINSTANCE.getParenthesizedExpression_Expression();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionImpl <em>Unit Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.UnitExpressionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnitExpression()
     * @generated
     */
    EClass UNIT_EXPRESSION = eINSTANCE.getUnitExpression();

    /**
     * The meta object literal for the '<em><b>Unspecified</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute UNIT_EXPRESSION__UNSPECIFIED = eINSTANCE.getUnitExpression_Unspecified();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNIT_EXPRESSION__EXPRESSION = eINSTANCE.getUnitExpression_Expression();

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
     * The meta object literal for the '<em><b>Begin</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANGE_EXPRESSION__BEGIN = eINSTANCE.getRangeExpression_Begin();

    /**
     * The meta object literal for the '<em><b>End</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANGE_EXPRESSION__END = eINSTANCE.getRangeExpression_End();

    /**
     * The meta object literal for the '<em><b>Increment</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANGE_EXPRESSION__INCREMENT = eINSTANCE.getRangeExpression_Increment();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.LogicalNotExpressionImpl <em>Logical Not Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.LogicalNotExpressionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getLogicalNotExpression()
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
     * The meta object literal for the '<em><b>Type Test</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONAL_EXPRESSION__TYPE_TEST = eINSTANCE.getRelationalExpression_TypeTest();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__TYPE = eINSTANCE.getRelationalExpression_Type();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.AddSubtractExpressionImpl <em>Add Subtract Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.AddSubtractExpressionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAddSubtractExpression()
     * @generated
     */
    EClass ADD_SUBTRACT_EXPRESSION = eINSTANCE.getAddSubtractExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD_SUBTRACT_EXPRESSION__LEFT_OPERAND = eINSTANCE.getAddSubtractExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Right Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD_SUBTRACT_EXPRESSION__RIGHT_PARTS = eINSTANCE.getAddSubtractExpression_RightParts();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.MultiplyDivideExpressionImpl <em>Multiply Divide Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.MultiplyDivideExpressionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplyDivideExpression()
     * @generated
     */
    EClass MULTIPLY_DIVIDE_EXPRESSION = eINSTANCE.getMultiplyDivideExpression();

    /**
     * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLY_DIVIDE_EXPRESSION__LEFT_OPERAND = eINSTANCE.getMultiplyDivideExpression_LeftOperand();

    /**
     * The meta object literal for the '<em><b>Right Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLY_DIVIDE_EXPRESSION__RIGHT_PARTS = eINSTANCE.getMultiplyDivideExpression_RightParts();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.impl.UnaryMinusExpressionImpl <em>Unary Minus Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.impl.UnaryMinusExpressionImpl
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getUnaryMinusExpression()
     * @generated
     */
    EClass UNARY_MINUS_EXPRESSION = eINSTANCE.getUnaryMinusExpression();

    /**
     * The meta object literal for the '<em><b>Operand</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference UNARY_MINUS_EXPRESSION__OPERAND = eINSTANCE.getUnaryMinusExpression_Operand();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.CheckStatusKind <em>Check Status Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.CheckStatusKind
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getCheckStatusKind()
     * @generated
     */
    EEnum CHECK_STATUS_KIND = eINSTANCE.getCheckStatusKind();

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
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.AddSubtractOperator <em>Add Subtract Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.AddSubtractOperator
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getAddSubtractOperator()
     * @generated
     */
    EEnum ADD_SUBTRACT_OPERATOR = eINSTANCE.getAddSubtractOperator();

    /**
     * The meta object literal for the '{@link org.eclipselabs.mscript.language.ast.MultiplyDivideOperator <em>Multiply Divide Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.mscript.language.ast.MultiplyDivideOperator
     * @see org.eclipselabs.mscript.language.ast.impl.AstPackageImpl#getMultiplyDivideOperator()
     * @generated
     */
    EEnum MULTIPLY_DIVIDE_OPERATOR = eINSTANCE.getMultiplyDivideOperator();

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
