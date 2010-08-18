/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

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
 * @see org.eclipselabs.damos.scripting.mscript.MscriptFactory
 * @model kind="package"
 * @generated
 */
public interface MscriptPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "mscript";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.eclipselabs.org/damos/Mscript/1.0.0";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "mscript";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MscriptPackage eINSTANCE = org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl.init();

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ModelImpl <em>Model</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ModelImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getModel()
   * @generated
   */
  int MODEL = 0;

  /**
   * The number of structural features of the '<em>Model</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODEL_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.MscriptImpl <em>Mscript</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getMscript()
   * @generated
   */
  int MSCRIPT = 1;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.PackageDefinitionElementImpl <em>Package Definition Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.PackageDefinitionElementImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getPackageDefinitionElement()
   * @generated
   */
  int PACKAGE_DEFINITION_ELEMENT = 3;

  /**
   * The number of structural features of the '<em>Package Definition Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PACKAGE_DEFINITION_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.PackageDefinitionImpl <em>Package Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.PackageDefinitionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getPackageDefinition()
   * @generated
   */
  int PACKAGE_DEFINITION = 2;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.EnumerationDefinitionImpl <em>Enumeration Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.EnumerationDefinitionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getEnumerationDefinition()
   * @generated
   */
  int ENUMERATION_DEFINITION = 4;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.EnumerationLiteralDefinitionImpl <em>Enumeration Literal Definition</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.EnumerationLiteralDefinitionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getEnumerationLiteralDefinition()
   * @generated
   */
  int ENUMERATION_LITERAL_DEFINITION = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_LITERAL_DEFINITION__NAME = 0;

  /**
   * The number of structural features of the '<em>Enumeration Literal Definition</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ENUMERATION_LITERAL_DEFINITION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ExpressionImpl <em>Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getExpression()
   * @generated
   */
  int EXPRESSION = 6;

  /**
   * The number of structural features of the '<em>Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_FEATURE_COUNT = MODEL_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ConditionalExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getConditionalExpression()
   * @generated
   */
  int CONDITIONAL_EXPRESSION = 7;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ConditionalExpressionCaseImpl <em>Conditional Expression Case</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ConditionalExpressionCaseImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getConditionalExpressionCase()
   * @generated
   */
  int CONDITIONAL_EXPRESSION_CASE = 8;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.LiteralImpl <em>Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.LiteralImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getLiteral()
   * @generated
   */
  int LITERAL = 9;

  /**
   * The number of structural features of the '<em>Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LITERAL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.NumericalLiteralImpl <em>Numerical Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.NumericalLiteralImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getNumericalLiteral()
   * @generated
   */
  int NUMERICAL_LITERAL = 10;

  /**
   * The feature id for the '<em><b>Unit</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_LITERAL__UNIT = LITERAL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Numerical Literal</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMERICAL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.RealLiteralImpl <em>Real Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.RealLiteralImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getRealLiteral()
   * @generated
   */
  int REAL_LITERAL = 11;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.IntegerLiteralImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getIntegerLiteral()
   * @generated
   */
  int INTEGER_LITERAL = 12;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.BooleanLiteralImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getBooleanLiteral()
   * @generated
   */
  int BOOLEAN_LITERAL = 13;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.StringLiteralImpl <em>String Literal</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.StringLiteralImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getStringLiteral()
   * @generated
   */
  int STRING_LITERAL = 14;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.FunctionCallImpl <em>Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.FunctionCallImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getFunctionCall()
   * @generated
   */
  int FUNCTION_CALL = 15;

  /**
   * The feature id for the '<em><b>Argument List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL__ARGUMENT_LIST = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.NamedFunctionCallImpl <em>Named Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.NamedFunctionCallImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getNamedFunctionCall()
   * @generated
   */
  int NAMED_FUNCTION_CALL = 16;

  /**
   * The feature id for the '<em><b>Argument List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_FUNCTION_CALL__ARGUMENT_LIST = FUNCTION_CALL__ARGUMENT_LIST;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_FUNCTION_CALL__NAME = FUNCTION_CALL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Named Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_FUNCTION_CALL_FEATURE_COUNT = FUNCTION_CALL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.NameImpl <em>Name</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.NameImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getName_()
   * @generated
   */
  int NAME = 17;

  /**
   * The feature id for the '<em><b>Global</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME__GLOBAL = 0;

  /**
   * The feature id for the '<em><b>Identifiers</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME__IDENTIFIERS = 1;

  /**
   * The number of structural features of the '<em>Name</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.KeywordFunctionCallImpl <em>Keyword Function Call</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.KeywordFunctionCallImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getKeywordFunctionCall()
   * @generated
   */
  int KEYWORD_FUNCTION_CALL = 18;

  /**
   * The feature id for the '<em><b>Argument List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_FUNCTION_CALL__ARGUMENT_LIST = FUNCTION_CALL__ARGUMENT_LIST;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_FUNCTION_CALL__NAME = FUNCTION_CALL_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Keyword Function Call</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEYWORD_FUNCTION_CALL_FEATURE_COUNT = FUNCTION_CALL_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.FunctionArgumentListImpl <em>Function Argument List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.FunctionArgumentListImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getFunctionArgumentList()
   * @generated
   */
  int FUNCTION_ARGUMENT_LIST = 19;

  /**
   * The feature id for the '<em><b>Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ARGUMENT_LIST__ARGUMENTS = 0;

  /**
   * The feature id for the '<em><b>Named Arguments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ARGUMENT_LIST__NAMED_ARGUMENTS = 1;

  /**
   * The number of structural features of the '<em>Function Argument List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FUNCTION_ARGUMENT_LIST_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.NamedArgumentImpl <em>Named Argument</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.NamedArgumentImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getNamedArgument()
   * @generated
   */
  int NAMED_ARGUMENT = 20;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ARGUMENT__IDENTIFIER = 0;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ARGUMENT__EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Named Argument</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ARGUMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ComponentReferenceImpl <em>Component Reference</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ComponentReferenceImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getComponentReference()
   * @generated
   */
  int COMPONENT_REFERENCE = 21;

  /**
   * The feature id for the '<em><b>Global</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_REFERENCE__GLOBAL = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Segments</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_REFERENCE__SEGMENTS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Component Reference</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_REFERENCE_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ComponentReferenceSegmentImpl <em>Component Reference Segment</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ComponentReferenceSegmentImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getComponentReferenceSegment()
   * @generated
   */
  int COMPONENT_REFERENCE_SEGMENT = 22;

  /**
   * The feature id for the '<em><b>Identifier</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_REFERENCE_SEGMENT__IDENTIFIER = 0;

  /**
   * The feature id for the '<em><b>Subscript List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_REFERENCE_SEGMENT__SUBSCRIPT_LIST = 1;

  /**
   * The number of structural features of the '<em>Component Reference Segment</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COMPONENT_REFERENCE_SEGMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ArraySubscriptListImpl <em>Array Subscript List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ArraySubscriptListImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getArraySubscriptList()
   * @generated
   */
  int ARRAY_SUBSCRIPT_LIST = 23;

  /**
   * The feature id for the '<em><b>Subscripts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_SUBSCRIPT_LIST__SUBSCRIPTS = 0;

  /**
   * The number of structural features of the '<em>Array Subscript List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_SUBSCRIPT_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.SubscriptImpl <em>Subscript</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.SubscriptImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getSubscript()
   * @generated
   */
  int SUBSCRIPT = 24;

  /**
   * The number of structural features of the '<em>Subscript</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SUBSCRIPT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ColonSubscriptImpl <em>Colon Subscript</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ColonSubscriptImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getColonSubscript()
   * @generated
   */
  int COLON_SUBSCRIPT = 25;

  /**
   * The number of structural features of the '<em>Colon Subscript</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLON_SUBSCRIPT_FEATURE_COUNT = SUBSCRIPT_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ExpressionSubscriptImpl <em>Expression Subscript</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ExpressionSubscriptImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getExpressionSubscript()
   * @generated
   */
  int EXPRESSION_SUBSCRIPT = 26;

  /**
   * The feature id for the '<em><b>Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_SUBSCRIPT__EXPRESSION = SUBSCRIPT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Expression Subscript</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESSION_SUBSCRIPT_FEATURE_COUNT = SUBSCRIPT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ArrayConcatenationOperatorImpl <em>Array Concatenation Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ArrayConcatenationOperatorImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getArrayConcatenationOperator()
   * @generated
   */
  int ARRAY_CONCATENATION_OPERATOR = 27;

  /**
   * The feature id for the '<em><b>Expression Lists</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_CONCATENATION_OPERATOR__EXPRESSION_LISTS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array Concatenation Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_CONCATENATION_OPERATOR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ArrayConstructionOperatorImpl <em>Array Construction Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ArrayConstructionOperatorImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getArrayConstructionOperator()
   * @generated
   */
  int ARRAY_CONSTRUCTION_OPERATOR = 28;

  /**
   * The feature id for the '<em><b>Argument List</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_CONSTRUCTION_OPERATOR__ARGUMENT_LIST = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Array Construction Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ARRAY_CONSTRUCTION_OPERATOR_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ExpressionListImpl <em>Expression List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ExpressionListImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getExpressionList()
   * @generated
   */
  int EXPRESSION_LIST = 29;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ParenthesizedExpressionImpl <em>Parenthesized Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.ParenthesizedExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getParenthesizedExpression()
   * @generated
   */
  int PARENTHESIZED_EXPRESSION = 30;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.BeginExpressionImpl <em>Begin Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.BeginExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getBeginExpression()
   * @generated
   */
  int BEGIN_EXPRESSION = 31;

  /**
   * The number of structural features of the '<em>Begin Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BEGIN_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.EndExpressionImpl <em>End Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.EndExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getEndExpression()
   * @generated
   */
  int END_EXPRESSION = 32;

  /**
   * The number of structural features of the '<em>End Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int END_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionImpl <em>Unit Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getUnitExpression()
   * @generated
   */
  int UNIT_EXPRESSION = 33;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionNumeratorImpl <em>Unit Expression Numerator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionNumeratorImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getUnitExpressionNumerator()
   * @generated
   */
  int UNIT_EXPRESSION_NUMERATOR = 34;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionDenominatorImpl <em>Unit Expression Denominator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionDenominatorImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getUnitExpressionDenominator()
   * @generated
   */
  int UNIT_EXPRESSION_DENOMINATOR = 35;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionFactorImpl <em>Unit Expression Factor</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionFactorImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getUnitExpressionFactor()
   * @generated
   */
  int UNIT_EXPRESSION_FACTOR = 36;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionExponentImpl <em>Unit Expression Exponent</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionExponentImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getUnitExpressionExponent()
   * @generated
   */
  int UNIT_EXPRESSION_EXPONENT = 37;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.RangeExpressionImpl <em>Range Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.RangeExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getRangeExpression()
   * @generated
   */
  int RANGE_EXPRESSION = 38;

  /**
   * The feature id for the '<em><b>Expressions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_EXPRESSION__EXPRESSIONS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Range Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RANGE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.LogicalOrExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getLogicalOrExpression()
   * @generated
   */
  int LOGICAL_OR_EXPRESSION = 39;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.LogicalAndExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getLogicalAndExpression()
   * @generated
   */
  int LOGICAL_AND_EXPRESSION = 40;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.LogicalNotExpressionImpl <em>Logical Not Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.LogicalNotExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getLogicalNotExpression()
   * @generated
   */
  int LOGICAL_NOT_EXPRESSION = 41;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.RelationalExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getRelationalExpression()
   * @generated
   */
  int RELATIONAL_EXPRESSION = 42;

  /**
   * The feature id for the '<em><b>Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operators</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION__OPERATORS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Relational Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RELATIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.AddSubtractExpressionImpl <em>Add Subtract Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.AddSubtractExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getAddSubtractExpression()
   * @generated
   */
  int ADD_SUBTRACT_EXPRESSION = 43;

  /**
   * The feature id for the '<em><b>Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_SUBTRACT_EXPRESSION__OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operators</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_SUBTRACT_EXPRESSION__OPERATORS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Add Subtract Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ADD_SUBTRACT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.MultiplyDivideExpressionImpl <em>Multiply Divide Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.MultiplyDivideExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getMultiplyDivideExpression()
   * @generated
   */
  int MULTIPLY_DIVIDE_EXPRESSION = 44;

  /**
   * The feature id for the '<em><b>Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY_DIVIDE_EXPRESSION__OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Operators</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY_DIVIDE_EXPRESSION__OPERATORS = EXPRESSION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Multiply Divide Expression</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLY_DIVIDE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.PowerExpressionImpl <em>Power Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.PowerExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getPowerExpression()
   * @generated
   */
  int POWER_EXPRESSION = 45;

  /**
   * The feature id for the '<em><b>Operands</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int POWER_EXPRESSION__OPERANDS = EXPRESSION_FEATURE_COUNT + 0;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.impl.UnaryMinusExpressionImpl <em>Unary Minus Expression</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.impl.UnaryMinusExpressionImpl
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getUnaryMinusExpression()
   * @generated
   */
  int UNARY_MINUS_EXPRESSION = 46;

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
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.RelationalOperator <em>Relational Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.RelationalOperator
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getRelationalOperator()
   * @generated
   */
  int RELATIONAL_OPERATOR = 47;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.AddSubtractOperator <em>Add Subtract Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.AddSubtractOperator
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getAddSubtractOperator()
   * @generated
   */
  int ADD_SUBTRACT_OPERATOR = 48;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.MultiplyDivideOperator <em>Multiply Divide Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.MultiplyDivideOperator
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getMultiplyDivideOperator()
   * @generated
   */
  int MULTIPLY_DIVIDE_OPERATOR = 49;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.PowerOperator <em>Power Operator</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.PowerOperator
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getPowerOperator()
   * @generated
   */
  int POWER_OPERATOR = 50;

  /**
   * The meta object id for the '{@link org.eclipselabs.damos.scripting.mscript.BooleanKind <em>Boolean Kind</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipselabs.damos.scripting.mscript.BooleanKind
   * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getBooleanKind()
   * @generated
   */
  int BOOLEAN_KIND = 51;


  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.Model <em>Model</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.Model
   * @generated
   */
  EClass getModel();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.Mscript <em>Mscript</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Mscript</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.Mscript
   * @generated
   */
  EClass getMscript();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.Mscript#getPackages <em>Packages</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Packages</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.Mscript#getPackages()
   * @see #getMscript()
   * @generated
   */
  EReference getMscript_Packages();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.PackageDefinition <em>Package Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Definition</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.PackageDefinition
   * @generated
   */
  EClass getPackageDefinition();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.PackageDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.PackageDefinition#getName()
   * @see #getPackageDefinition()
   * @generated
   */
  EReference getPackageDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.PackageDefinition#getElements <em>Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Elements</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.PackageDefinition#getElements()
   * @see #getPackageDefinition()
   * @generated
   */
  EReference getPackageDefinition_Elements();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.PackageDefinitionElement <em>Package Definition Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Package Definition Element</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.PackageDefinitionElement
   * @generated
   */
  EClass getPackageDefinitionElement();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.EnumerationDefinition <em>Enumeration Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumeration Definition</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.EnumerationDefinition
   * @generated
   */
  EClass getEnumerationDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.EnumerationDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.EnumerationDefinition#getName()
   * @see #getEnumerationDefinition()
   * @generated
   */
  EAttribute getEnumerationDefinition_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.EnumerationDefinition#getLiterals <em>Literals</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Literals</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.EnumerationDefinition#getLiterals()
   * @see #getEnumerationDefinition()
   * @generated
   */
  EReference getEnumerationDefinition_Literals();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.EnumerationLiteralDefinition <em>Enumeration Literal Definition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Enumeration Literal Definition</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.EnumerationLiteralDefinition
   * @generated
   */
  EClass getEnumerationLiteralDefinition();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.EnumerationLiteralDefinition#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.EnumerationLiteralDefinition#getName()
   * @see #getEnumerationLiteralDefinition()
   * @generated
   */
  EAttribute getEnumerationLiteralDefinition_Name();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.Expression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.Expression
   * @generated
   */
  EClass getExpression();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.ConditionalExpression <em>Conditional Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ConditionalExpression
   * @generated
   */
  EClass getConditionalExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.ConditionalExpression#getCases <em>Cases</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Cases</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ConditionalExpression#getCases()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_Cases();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.ConditionalExpression#getElseExpression <em>Else Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ConditionalExpression#getElseExpression()
   * @see #getConditionalExpression()
   * @generated
   */
  EReference getConditionalExpression_ElseExpression();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.ConditionalExpressionCase <em>Conditional Expression Case</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conditional Expression Case</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ConditionalExpressionCase
   * @generated
   */
  EClass getConditionalExpressionCase();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.ConditionalExpressionCase#getConditionExpression <em>Condition Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ConditionalExpressionCase#getConditionExpression()
   * @see #getConditionalExpressionCase()
   * @generated
   */
  EReference getConditionalExpressionCase_ConditionExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.ConditionalExpressionCase#getThenExpression <em>Then Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ConditionalExpressionCase#getThenExpression()
   * @see #getConditionalExpressionCase()
   * @generated
   */
  EReference getConditionalExpressionCase_ThenExpression();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.Literal <em>Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Literal</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.Literal
   * @generated
   */
  EClass getLiteral();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.NumericalLiteral <em>Numerical Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Numerical Literal</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.NumericalLiteral
   * @generated
   */
  EClass getNumericalLiteral();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.NumericalLiteral#getUnit <em>Unit</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Unit</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.NumericalLiteral#getUnit()
   * @see #getNumericalLiteral()
   * @generated
   */
  EReference getNumericalLiteral_Unit();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.RealLiteral <em>Real Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Real Literal</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.RealLiteral
   * @generated
   */
  EClass getRealLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.RealLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.RealLiteral#getValue()
   * @see #getRealLiteral()
   * @generated
   */
  EAttribute getRealLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.IntegerLiteral <em>Integer Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Integer Literal</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.IntegerLiteral
   * @generated
   */
  EClass getIntegerLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.IntegerLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.IntegerLiteral#getValue()
   * @see #getIntegerLiteral()
   * @generated
   */
  EAttribute getIntegerLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.BooleanLiteral <em>Boolean Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.BooleanLiteral
   * @generated
   */
  EClass getBooleanLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.BooleanLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.BooleanLiteral#getValue()
   * @see #getBooleanLiteral()
   * @generated
   */
  EAttribute getBooleanLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.StringLiteral <em>String Literal</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.StringLiteral
   * @generated
   */
  EClass getStringLiteral();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.StringLiteral#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.StringLiteral#getValue()
   * @see #getStringLiteral()
   * @generated
   */
  EAttribute getStringLiteral_Value();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.FunctionCall <em>Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Call</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.FunctionCall
   * @generated
   */
  EClass getFunctionCall();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.FunctionCall#getArgumentList <em>Argument List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Argument List</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.FunctionCall#getArgumentList()
   * @see #getFunctionCall()
   * @generated
   */
  EReference getFunctionCall_ArgumentList();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.NamedFunctionCall <em>Named Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Function Call</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.NamedFunctionCall
   * @generated
   */
  EClass getNamedFunctionCall();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.NamedFunctionCall#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.NamedFunctionCall#getName()
   * @see #getNamedFunctionCall()
   * @generated
   */
  EReference getNamedFunctionCall_Name();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.Name <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.Name
   * @generated
   */
  EClass getName_();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.Name#isGlobal <em>Global</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Global</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.Name#isGlobal()
   * @see #getName_()
   * @generated
   */
  EAttribute getName_Global();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipselabs.damos.scripting.mscript.Name#getIdentifiers <em>Identifiers</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Identifiers</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.Name#getIdentifiers()
   * @see #getName_()
   * @generated
   */
  EAttribute getName_Identifiers();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.KeywordFunctionCall <em>Keyword Function Call</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Keyword Function Call</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.KeywordFunctionCall
   * @generated
   */
  EClass getKeywordFunctionCall();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.KeywordFunctionCall#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.KeywordFunctionCall#getName()
   * @see #getKeywordFunctionCall()
   * @generated
   */
  EAttribute getKeywordFunctionCall_Name();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.FunctionArgumentList <em>Function Argument List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Function Argument List</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.FunctionArgumentList
   * @generated
   */
  EClass getFunctionArgumentList();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.FunctionArgumentList#getArguments <em>Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Arguments</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.FunctionArgumentList#getArguments()
   * @see #getFunctionArgumentList()
   * @generated
   */
  EReference getFunctionArgumentList_Arguments();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.FunctionArgumentList#getNamedArguments <em>Named Arguments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Named Arguments</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.FunctionArgumentList#getNamedArguments()
   * @see #getFunctionArgumentList()
   * @generated
   */
  EReference getFunctionArgumentList_NamedArguments();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.NamedArgument <em>Named Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Argument</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.NamedArgument
   * @generated
   */
  EClass getNamedArgument();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.NamedArgument#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Identifier</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.NamedArgument#getIdentifier()
   * @see #getNamedArgument()
   * @generated
   */
  EAttribute getNamedArgument_Identifier();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.NamedArgument#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.NamedArgument#getExpression()
   * @see #getNamedArgument()
   * @generated
   */
  EReference getNamedArgument_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.ComponentReference <em>Component Reference</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Reference</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ComponentReference
   * @generated
   */
  EClass getComponentReference();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.ComponentReference#isGlobal <em>Global</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Global</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ComponentReference#isGlobal()
   * @see #getComponentReference()
   * @generated
   */
  EAttribute getComponentReference_Global();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.ComponentReference#getSegments <em>Segments</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Segments</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ComponentReference#getSegments()
   * @see #getComponentReference()
   * @generated
   */
  EReference getComponentReference_Segments();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment <em>Component Reference Segment</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Component Reference Segment</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment
   * @generated
   */
  EClass getComponentReferenceSegment();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment#getIdentifier <em>Identifier</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Identifier</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment#getIdentifier()
   * @see #getComponentReferenceSegment()
   * @generated
   */
  EAttribute getComponentReferenceSegment_Identifier();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment#getSubscriptList <em>Subscript List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Subscript List</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ComponentReferenceSegment#getSubscriptList()
   * @see #getComponentReferenceSegment()
   * @generated
   */
  EReference getComponentReferenceSegment_SubscriptList();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.ArraySubscriptList <em>Array Subscript List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Subscript List</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ArraySubscriptList
   * @generated
   */
  EClass getArraySubscriptList();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.ArraySubscriptList#getSubscripts <em>Subscripts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Subscripts</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ArraySubscriptList#getSubscripts()
   * @see #getArraySubscriptList()
   * @generated
   */
  EReference getArraySubscriptList_Subscripts();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.Subscript <em>Subscript</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Subscript</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.Subscript
   * @generated
   */
  EClass getSubscript();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.ColonSubscript <em>Colon Subscript</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Colon Subscript</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ColonSubscript
   * @generated
   */
  EClass getColonSubscript();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.ExpressionSubscript <em>Expression Subscript</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression Subscript</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ExpressionSubscript
   * @generated
   */
  EClass getExpressionSubscript();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.ExpressionSubscript#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ExpressionSubscript#getExpression()
   * @see #getExpressionSubscript()
   * @generated
   */
  EReference getExpressionSubscript_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.ArrayConcatenationOperator <em>Array Concatenation Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Concatenation Operator</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ArrayConcatenationOperator
   * @generated
   */
  EClass getArrayConcatenationOperator();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.ArrayConcatenationOperator#getExpressionLists <em>Expression Lists</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expression Lists</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ArrayConcatenationOperator#getExpressionLists()
   * @see #getArrayConcatenationOperator()
   * @generated
   */
  EReference getArrayConcatenationOperator_ExpressionLists();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.ArrayConstructionOperator <em>Array Construction Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Array Construction Operator</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ArrayConstructionOperator
   * @generated
   */
  EClass getArrayConstructionOperator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.ArrayConstructionOperator#getArgumentList <em>Argument List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Argument List</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ArrayConstructionOperator#getArgumentList()
   * @see #getArrayConstructionOperator()
   * @generated
   */
  EReference getArrayConstructionOperator_ArgumentList();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.ExpressionList <em>Expression List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Expression List</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ExpressionList
   * @generated
   */
  EClass getExpressionList();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.ExpressionList#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ExpressionList#getExpressions()
   * @see #getExpressionList()
   * @generated
   */
  EReference getExpressionList_Expressions();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.ParenthesizedExpression <em>Parenthesized Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parenthesized Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ParenthesizedExpression
   * @generated
   */
  EClass getParenthesizedExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.ParenthesizedExpression#getExpression <em>Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.ParenthesizedExpression#getExpression()
   * @see #getParenthesizedExpression()
   * @generated
   */
  EReference getParenthesizedExpression_Expression();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.BeginExpression <em>Begin Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Begin Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.BeginExpression
   * @generated
   */
  EClass getBeginExpression();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.EndExpression <em>End Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>End Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.EndExpression
   * @generated
   */
  EClass getEndExpression();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.UnitExpression <em>Unit Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpression
   * @generated
   */
  EClass getUnitExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.UnitExpression#getNumerator <em>Numerator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Numerator</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpression#getNumerator()
   * @see #getUnitExpression()
   * @generated
   */
  EReference getUnitExpression_Numerator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.UnitExpression#getDenominator <em>Denominator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Denominator</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpression#getDenominator()
   * @see #getUnitExpression()
   * @generated
   */
  EReference getUnitExpression_Denominator();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator <em>Unit Expression Numerator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expression Numerator</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator
   * @generated
   */
  EClass getUnitExpressionNumerator();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator#getOne <em>One</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>One</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator#getOne()
   * @see #getUnitExpressionNumerator()
   * @generated
   */
  EAttribute getUnitExpressionNumerator_One();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator#getFactors <em>Factors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Factors</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionNumerator#getFactors()
   * @see #getUnitExpressionNumerator()
   * @generated
   */
  EReference getUnitExpressionNumerator_Factors();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionDenominator <em>Unit Expression Denominator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expression Denominator</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionDenominator
   * @generated
   */
  EClass getUnitExpressionDenominator();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionDenominator#getFactors <em>Factors</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Factors</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionDenominator#getFactors()
   * @see #getUnitExpressionDenominator()
   * @generated
   */
  EReference getUnitExpressionDenominator_Factors();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor <em>Unit Expression Factor</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expression Factor</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor
   * @generated
   */
  EClass getUnitExpressionFactor();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operand</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor#getOperand()
   * @see #getUnitExpressionFactor()
   * @generated
   */
  EAttribute getUnitExpressionFactor_Operand();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor#getExponent <em>Exponent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exponent</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor#getExponent()
   * @see #getUnitExpressionFactor()
   * @generated
   */
  EReference getUnitExpressionFactor_Exponent();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionExponent <em>Unit Expression Exponent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unit Expression Exponent</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionExponent
   * @generated
   */
  EClass getUnitExpressionExponent();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionExponent#isNegative <em>Negative</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Negative</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionExponent#isNegative()
   * @see #getUnitExpressionExponent()
   * @generated
   */
  EAttribute getUnitExpressionExponent_Negative();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.UnitExpressionExponent#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnitExpressionExponent#getValue()
   * @see #getUnitExpressionExponent()
   * @generated
   */
  EAttribute getUnitExpressionExponent_Value();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.RangeExpression <em>Range Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Range Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.RangeExpression
   * @generated
   */
  EClass getRangeExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.RangeExpression#getExpressions <em>Expressions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Expressions</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.RangeExpression#getExpressions()
   * @see #getRangeExpression()
   * @generated
   */
  EReference getRangeExpression_Expressions();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.LogicalOrExpression <em>Logical Or Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Or Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.LogicalOrExpression
   * @generated
   */
  EClass getLogicalOrExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.LogicalOrExpression#getOperands <em>Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operands</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.LogicalOrExpression#getOperands()
   * @see #getLogicalOrExpression()
   * @generated
   */
  EReference getLogicalOrExpression_Operands();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.LogicalAndExpression <em>Logical And Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical And Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.LogicalAndExpression
   * @generated
   */
  EClass getLogicalAndExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.LogicalAndExpression#getOperands <em>Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operands</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.LogicalAndExpression#getOperands()
   * @see #getLogicalAndExpression()
   * @generated
   */
  EReference getLogicalAndExpression_Operands();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.LogicalNotExpression <em>Logical Not Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Logical Not Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.LogicalNotExpression
   * @generated
   */
  EClass getLogicalNotExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.LogicalNotExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.LogicalNotExpression#getOperand()
   * @see #getLogicalNotExpression()
   * @generated
   */
  EReference getLogicalNotExpression_Operand();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.RelationalExpression <em>Relational Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Relational Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.RelationalExpression
   * @generated
   */
  EClass getRelationalExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.RelationalExpression#getOperands <em>Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operands</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.RelationalExpression#getOperands()
   * @see #getRelationalExpression()
   * @generated
   */
  EReference getRelationalExpression_Operands();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipselabs.damos.scripting.mscript.RelationalExpression#getOperators <em>Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Operators</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.RelationalExpression#getOperators()
   * @see #getRelationalExpression()
   * @generated
   */
  EAttribute getRelationalExpression_Operators();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.AddSubtractExpression <em>Add Subtract Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Add Subtract Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.AddSubtractExpression
   * @generated
   */
  EClass getAddSubtractExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.AddSubtractExpression#getOperands <em>Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operands</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.AddSubtractExpression#getOperands()
   * @see #getAddSubtractExpression()
   * @generated
   */
  EReference getAddSubtractExpression_Operands();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipselabs.damos.scripting.mscript.AddSubtractExpression#getOperators <em>Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Operators</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.AddSubtractExpression#getOperators()
   * @see #getAddSubtractExpression()
   * @generated
   */
  EAttribute getAddSubtractExpression_Operators();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression <em>Multiply Divide Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiply Divide Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression
   * @generated
   */
  EClass getMultiplyDivideExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression#getOperands <em>Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operands</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression#getOperands()
   * @see #getMultiplyDivideExpression()
   * @generated
   */
  EReference getMultiplyDivideExpression_Operands();

  /**
   * Returns the meta object for the attribute list '{@link org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression#getOperators <em>Operators</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Operators</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.MultiplyDivideExpression#getOperators()
   * @see #getMultiplyDivideExpression()
   * @generated
   */
  EAttribute getMultiplyDivideExpression_Operators();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.PowerExpression <em>Power Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Power Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.PowerExpression
   * @generated
   */
  EClass getPowerExpression();

  /**
   * Returns the meta object for the containment reference list '{@link org.eclipselabs.damos.scripting.mscript.PowerExpression#getOperands <em>Operands</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Operands</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.PowerExpression#getOperands()
   * @see #getPowerExpression()
   * @generated
   */
  EReference getPowerExpression_Operands();

  /**
   * Returns the meta object for the attribute '{@link org.eclipselabs.damos.scripting.mscript.PowerExpression#getOperator <em>Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Operator</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.PowerExpression#getOperator()
   * @see #getPowerExpression()
   * @generated
   */
  EAttribute getPowerExpression_Operator();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.PowerExpression#getExponent <em>Exponent</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Exponent</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.PowerExpression#getExponent()
   * @see #getPowerExpression()
   * @generated
   */
  EReference getPowerExpression_Exponent();

  /**
   * Returns the meta object for class '{@link org.eclipselabs.damos.scripting.mscript.UnaryMinusExpression <em>Unary Minus Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unary Minus Expression</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnaryMinusExpression
   * @generated
   */
  EClass getUnaryMinusExpression();

  /**
   * Returns the meta object for the containment reference '{@link org.eclipselabs.damos.scripting.mscript.UnaryMinusExpression#getOperand <em>Operand</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Operand</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.UnaryMinusExpression#getOperand()
   * @see #getUnaryMinusExpression()
   * @generated
   */
  EReference getUnaryMinusExpression_Operand();

  /**
   * Returns the meta object for enum '{@link org.eclipselabs.damos.scripting.mscript.RelationalOperator <em>Relational Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Relational Operator</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.RelationalOperator
   * @generated
   */
  EEnum getRelationalOperator();

  /**
   * Returns the meta object for enum '{@link org.eclipselabs.damos.scripting.mscript.AddSubtractOperator <em>Add Subtract Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Add Subtract Operator</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.AddSubtractOperator
   * @generated
   */
  EEnum getAddSubtractOperator();

  /**
   * Returns the meta object for enum '{@link org.eclipselabs.damos.scripting.mscript.MultiplyDivideOperator <em>Multiply Divide Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Multiply Divide Operator</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.MultiplyDivideOperator
   * @generated
   */
  EEnum getMultiplyDivideOperator();

  /**
   * Returns the meta object for enum '{@link org.eclipselabs.damos.scripting.mscript.PowerOperator <em>Power Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Power Operator</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.PowerOperator
   * @generated
   */
  EEnum getPowerOperator();

  /**
   * Returns the meta object for enum '{@link org.eclipselabs.damos.scripting.mscript.BooleanKind <em>Boolean Kind</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Boolean Kind</em>'.
   * @see org.eclipselabs.damos.scripting.mscript.BooleanKind
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
  MscriptFactory getMscriptFactory();

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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ModelImpl <em>Model</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ModelImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getModel()
     * @generated
     */
    EClass MODEL = eINSTANCE.getModel();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.MscriptImpl <em>Mscript</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getMscript()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.PackageDefinitionImpl <em>Package Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.PackageDefinitionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getPackageDefinition()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.PackageDefinitionElementImpl <em>Package Definition Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.PackageDefinitionElementImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getPackageDefinitionElement()
     * @generated
     */
    EClass PACKAGE_DEFINITION_ELEMENT = eINSTANCE.getPackageDefinitionElement();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.EnumerationDefinitionImpl <em>Enumeration Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.EnumerationDefinitionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getEnumerationDefinition()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.EnumerationLiteralDefinitionImpl <em>Enumeration Literal Definition</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.EnumerationLiteralDefinitionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getEnumerationLiteralDefinition()
     * @generated
     */
    EClass ENUMERATION_LITERAL_DEFINITION = eINSTANCE.getEnumerationLiteralDefinition();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ENUMERATION_LITERAL_DEFINITION__NAME = eINSTANCE.getEnumerationLiteralDefinition_Name();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ExpressionImpl <em>Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getExpression()
     * @generated
     */
    EClass EXPRESSION = eINSTANCE.getExpression();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ConditionalExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getConditionalExpression()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ConditionalExpressionCaseImpl <em>Conditional Expression Case</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ConditionalExpressionCaseImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getConditionalExpressionCase()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.LiteralImpl <em>Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.LiteralImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getLiteral()
     * @generated
     */
    EClass LITERAL = eINSTANCE.getLiteral();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.NumericalLiteralImpl <em>Numerical Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.NumericalLiteralImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getNumericalLiteral()
     * @generated
     */
    EClass NUMERICAL_LITERAL = eINSTANCE.getNumericalLiteral();

    /**
     * The meta object literal for the '<em><b>Unit</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMERICAL_LITERAL__UNIT = eINSTANCE.getNumericalLiteral_Unit();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.RealLiteralImpl <em>Real Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.RealLiteralImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getRealLiteral()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.IntegerLiteralImpl <em>Integer Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.IntegerLiteralImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getIntegerLiteral()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.BooleanLiteralImpl <em>Boolean Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.BooleanLiteralImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getBooleanLiteral()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.StringLiteralImpl <em>String Literal</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.StringLiteralImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getStringLiteral()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.FunctionCallImpl <em>Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.FunctionCallImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getFunctionCall()
     * @generated
     */
    EClass FUNCTION_CALL = eINSTANCE.getFunctionCall();

    /**
     * The meta object literal for the '<em><b>Argument List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_CALL__ARGUMENT_LIST = eINSTANCE.getFunctionCall_ArgumentList();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.NamedFunctionCallImpl <em>Named Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.NamedFunctionCallImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getNamedFunctionCall()
     * @generated
     */
    EClass NAMED_FUNCTION_CALL = eINSTANCE.getNamedFunctionCall();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_FUNCTION_CALL__NAME = eINSTANCE.getNamedFunctionCall_Name();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.NameImpl <em>Name</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.NameImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getName_()
     * @generated
     */
    EClass NAME = eINSTANCE.getName_();

    /**
     * The meta object literal for the '<em><b>Global</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAME__GLOBAL = eINSTANCE.getName_Global();

    /**
     * The meta object literal for the '<em><b>Identifiers</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAME__IDENTIFIERS = eINSTANCE.getName_Identifiers();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.KeywordFunctionCallImpl <em>Keyword Function Call</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.KeywordFunctionCallImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getKeywordFunctionCall()
     * @generated
     */
    EClass KEYWORD_FUNCTION_CALL = eINSTANCE.getKeywordFunctionCall();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEYWORD_FUNCTION_CALL__NAME = eINSTANCE.getKeywordFunctionCall_Name();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.FunctionArgumentListImpl <em>Function Argument List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.FunctionArgumentListImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getFunctionArgumentList()
     * @generated
     */
    EClass FUNCTION_ARGUMENT_LIST = eINSTANCE.getFunctionArgumentList();

    /**
     * The meta object literal for the '<em><b>Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_ARGUMENT_LIST__ARGUMENTS = eINSTANCE.getFunctionArgumentList_Arguments();

    /**
     * The meta object literal for the '<em><b>Named Arguments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference FUNCTION_ARGUMENT_LIST__NAMED_ARGUMENTS = eINSTANCE.getFunctionArgumentList_NamedArguments();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.NamedArgumentImpl <em>Named Argument</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.NamedArgumentImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getNamedArgument()
     * @generated
     */
    EClass NAMED_ARGUMENT = eINSTANCE.getNamedArgument();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_ARGUMENT__IDENTIFIER = eINSTANCE.getNamedArgument_Identifier();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAMED_ARGUMENT__EXPRESSION = eINSTANCE.getNamedArgument_Expression();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ComponentReferenceImpl <em>Component Reference</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ComponentReferenceImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getComponentReference()
     * @generated
     */
    EClass COMPONENT_REFERENCE = eINSTANCE.getComponentReference();

    /**
     * The meta object literal for the '<em><b>Global</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPONENT_REFERENCE__GLOBAL = eINSTANCE.getComponentReference_Global();

    /**
     * The meta object literal for the '<em><b>Segments</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_REFERENCE__SEGMENTS = eINSTANCE.getComponentReference_Segments();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ComponentReferenceSegmentImpl <em>Component Reference Segment</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ComponentReferenceSegmentImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getComponentReferenceSegment()
     * @generated
     */
    EClass COMPONENT_REFERENCE_SEGMENT = eINSTANCE.getComponentReferenceSegment();

    /**
     * The meta object literal for the '<em><b>Identifier</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute COMPONENT_REFERENCE_SEGMENT__IDENTIFIER = eINSTANCE.getComponentReferenceSegment_Identifier();

    /**
     * The meta object literal for the '<em><b>Subscript List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COMPONENT_REFERENCE_SEGMENT__SUBSCRIPT_LIST = eINSTANCE.getComponentReferenceSegment_SubscriptList();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ArraySubscriptListImpl <em>Array Subscript List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ArraySubscriptListImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getArraySubscriptList()
     * @generated
     */
    EClass ARRAY_SUBSCRIPT_LIST = eINSTANCE.getArraySubscriptList();

    /**
     * The meta object literal for the '<em><b>Subscripts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_SUBSCRIPT_LIST__SUBSCRIPTS = eINSTANCE.getArraySubscriptList_Subscripts();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.SubscriptImpl <em>Subscript</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.SubscriptImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getSubscript()
     * @generated
     */
    EClass SUBSCRIPT = eINSTANCE.getSubscript();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ColonSubscriptImpl <em>Colon Subscript</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ColonSubscriptImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getColonSubscript()
     * @generated
     */
    EClass COLON_SUBSCRIPT = eINSTANCE.getColonSubscript();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ExpressionSubscriptImpl <em>Expression Subscript</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ExpressionSubscriptImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getExpressionSubscript()
     * @generated
     */
    EClass EXPRESSION_SUBSCRIPT = eINSTANCE.getExpressionSubscript();

    /**
     * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESSION_SUBSCRIPT__EXPRESSION = eINSTANCE.getExpressionSubscript_Expression();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ArrayConcatenationOperatorImpl <em>Array Concatenation Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ArrayConcatenationOperatorImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getArrayConcatenationOperator()
     * @generated
     */
    EClass ARRAY_CONCATENATION_OPERATOR = eINSTANCE.getArrayConcatenationOperator();

    /**
     * The meta object literal for the '<em><b>Expression Lists</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_CONCATENATION_OPERATOR__EXPRESSION_LISTS = eINSTANCE.getArrayConcatenationOperator_ExpressionLists();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ArrayConstructionOperatorImpl <em>Array Construction Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ArrayConstructionOperatorImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getArrayConstructionOperator()
     * @generated
     */
    EClass ARRAY_CONSTRUCTION_OPERATOR = eINSTANCE.getArrayConstructionOperator();

    /**
     * The meta object literal for the '<em><b>Argument List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ARRAY_CONSTRUCTION_OPERATOR__ARGUMENT_LIST = eINSTANCE.getArrayConstructionOperator_ArgumentList();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ExpressionListImpl <em>Expression List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ExpressionListImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getExpressionList()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.ParenthesizedExpressionImpl <em>Parenthesized Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.ParenthesizedExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getParenthesizedExpression()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.BeginExpressionImpl <em>Begin Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.BeginExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getBeginExpression()
     * @generated
     */
    EClass BEGIN_EXPRESSION = eINSTANCE.getBeginExpression();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.EndExpressionImpl <em>End Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.EndExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getEndExpression()
     * @generated
     */
    EClass END_EXPRESSION = eINSTANCE.getEndExpression();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionImpl <em>Unit Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getUnitExpression()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionNumeratorImpl <em>Unit Expression Numerator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionNumeratorImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getUnitExpressionNumerator()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionDenominatorImpl <em>Unit Expression Denominator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionDenominatorImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getUnitExpressionDenominator()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionFactorImpl <em>Unit Expression Factor</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionFactorImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getUnitExpressionFactor()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionExponentImpl <em>Unit Expression Exponent</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.UnitExpressionExponentImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getUnitExpressionExponent()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.RangeExpressionImpl <em>Range Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.RangeExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getRangeExpression()
     * @generated
     */
    EClass RANGE_EXPRESSION = eINSTANCE.getRangeExpression();

    /**
     * The meta object literal for the '<em><b>Expressions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RANGE_EXPRESSION__EXPRESSIONS = eINSTANCE.getRangeExpression_Expressions();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.LogicalOrExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getLogicalOrExpression()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.LogicalAndExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getLogicalAndExpression()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.LogicalNotExpressionImpl <em>Logical Not Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.LogicalNotExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getLogicalNotExpression()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.RelationalExpressionImpl <em>Relational Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.RelationalExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getRelationalExpression()
     * @generated
     */
    EClass RELATIONAL_EXPRESSION = eINSTANCE.getRelationalExpression();

    /**
     * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RELATIONAL_EXPRESSION__OPERANDS = eINSTANCE.getRelationalExpression_Operands();

    /**
     * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RELATIONAL_EXPRESSION__OPERATORS = eINSTANCE.getRelationalExpression_Operators();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.AddSubtractExpressionImpl <em>Add Subtract Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.AddSubtractExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getAddSubtractExpression()
     * @generated
     */
    EClass ADD_SUBTRACT_EXPRESSION = eINSTANCE.getAddSubtractExpression();

    /**
     * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference ADD_SUBTRACT_EXPRESSION__OPERANDS = eINSTANCE.getAddSubtractExpression_Operands();

    /**
     * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ADD_SUBTRACT_EXPRESSION__OPERATORS = eINSTANCE.getAddSubtractExpression_Operators();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.MultiplyDivideExpressionImpl <em>Multiply Divide Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.MultiplyDivideExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getMultiplyDivideExpression()
     * @generated
     */
    EClass MULTIPLY_DIVIDE_EXPRESSION = eINSTANCE.getMultiplyDivideExpression();

    /**
     * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MULTIPLY_DIVIDE_EXPRESSION__OPERANDS = eINSTANCE.getMultiplyDivideExpression_Operands();

    /**
     * The meta object literal for the '<em><b>Operators</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLY_DIVIDE_EXPRESSION__OPERATORS = eINSTANCE.getMultiplyDivideExpression_Operators();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.PowerExpressionImpl <em>Power Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.PowerExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getPowerExpression()
     * @generated
     */
    EClass POWER_EXPRESSION = eINSTANCE.getPowerExpression();

    /**
     * The meta object literal for the '<em><b>Operands</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference POWER_EXPRESSION__OPERANDS = eINSTANCE.getPowerExpression_Operands();

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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.impl.UnaryMinusExpressionImpl <em>Unary Minus Expression</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.impl.UnaryMinusExpressionImpl
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getUnaryMinusExpression()
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
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.RelationalOperator <em>Relational Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.RelationalOperator
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getRelationalOperator()
     * @generated
     */
    EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.AddSubtractOperator <em>Add Subtract Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.AddSubtractOperator
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getAddSubtractOperator()
     * @generated
     */
    EEnum ADD_SUBTRACT_OPERATOR = eINSTANCE.getAddSubtractOperator();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.MultiplyDivideOperator <em>Multiply Divide Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.MultiplyDivideOperator
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getMultiplyDivideOperator()
     * @generated
     */
    EEnum MULTIPLY_DIVIDE_OPERATOR = eINSTANCE.getMultiplyDivideOperator();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.PowerOperator <em>Power Operator</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.PowerOperator
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getPowerOperator()
     * @generated
     */
    EEnum POWER_OPERATOR = eINSTANCE.getPowerOperator();

    /**
     * The meta object literal for the '{@link org.eclipselabs.damos.scripting.mscript.BooleanKind <em>Boolean Kind</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.eclipselabs.damos.scripting.mscript.BooleanKind
     * @see org.eclipselabs.damos.scripting.mscript.impl.MscriptPackageImpl#getBooleanKind()
     * @generated
     */
    EEnum BOOLEAN_KIND = eINSTANCE.getBooleanKind();

  }

} //MscriptPackage
