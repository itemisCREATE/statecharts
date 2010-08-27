/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.damos.scripting.mscript;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.damos.scripting.mscript.MscriptPackage
 * @generated
 */
public interface MscriptFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  MscriptFactory eINSTANCE = org.eclipselabs.damos.scripting.mscript.impl.MscriptFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Mscript</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Mscript</em>'.
   * @generated
   */
  Mscript createMscript();

  /**
   * Returns a new object of class '<em>Package Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Definition</em>'.
   * @generated
   */
  PackageDefinition createPackageDefinition();

  /**
   * Returns a new object of class '<em>Package Definition Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Package Definition Element</em>'.
   * @generated
   */
  PackageDefinitionElement createPackageDefinitionElement();

  /**
   * Returns a new object of class '<em>Enumeration Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumeration Definition</em>'.
   * @generated
   */
  EnumerationDefinition createEnumerationDefinition();

  /**
   * Returns a new object of class '<em>Enumeration Literal Definition</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Enumeration Literal Definition</em>'.
   * @generated
   */
  EnumerationLiteralDefinition createEnumerationLiteralDefinition();

  /**
   * Returns a new object of class '<em>Data Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Data Type Specifier</em>'.
   * @generated
   */
  DataTypeSpecifier createDataTypeSpecifier();

  /**
   * Returns a new object of class '<em>Primitive Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primitive Type Specifier</em>'.
   * @generated
   */
  PrimitiveTypeSpecifier createPrimitiveTypeSpecifier();

  /**
   * Returns a new object of class '<em>Numerical Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical Type Specifier</em>'.
   * @generated
   */
  NumericalTypeSpecifier createNumericalTypeSpecifier();

  /**
   * Returns a new object of class '<em>Real Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Real Type Specifier</em>'.
   * @generated
   */
  RealTypeSpecifier createRealTypeSpecifier();

  /**
   * Returns a new object of class '<em>Integer Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer Type Specifier</em>'.
   * @generated
   */
  IntegerTypeSpecifier createIntegerTypeSpecifier();

  /**
   * Returns a new object of class '<em>Boolean Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Type Specifier</em>'.
   * @generated
   */
  BooleanTypeSpecifier createBooleanTypeSpecifier();

  /**
   * Returns a new object of class '<em>String Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Type Specifier</em>'.
   * @generated
   */
  StringTypeSpecifier createStringTypeSpecifier();

  /**
   * Returns a new object of class '<em>Complex Type Specifier</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Complex Type Specifier</em>'.
   * @generated
   */
  ComplexTypeSpecifier createComplexTypeSpecifier();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Conditional Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Expression</em>'.
   * @generated
   */
  ConditionalExpression createConditionalExpression();

  /**
   * Returns a new object of class '<em>Conditional Expression Case</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Conditional Expression Case</em>'.
   * @generated
   */
  ConditionalExpressionCase createConditionalExpressionCase();

  /**
   * Returns a new object of class '<em>Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal</em>'.
   * @generated
   */
  Literal createLiteral();

  /**
   * Returns a new object of class '<em>Numerical Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Numerical Literal</em>'.
   * @generated
   */
  NumericalLiteral createNumericalLiteral();

  /**
   * Returns a new object of class '<em>Real Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Real Literal</em>'.
   * @generated
   */
  RealLiteral createRealLiteral();

  /**
   * Returns a new object of class '<em>Integer Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Integer Literal</em>'.
   * @generated
   */
  IntegerLiteral createIntegerLiteral();

  /**
   * Returns a new object of class '<em>Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Literal</em>'.
   * @generated
   */
  BooleanLiteral createBooleanLiteral();

  /**
   * Returns a new object of class '<em>String Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Literal</em>'.
   * @generated
   */
  StringLiteral createStringLiteral();

  /**
   * Returns a new object of class '<em>Name</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name</em>'.
   * @generated
   */
  Name createName();

  /**
   * Returns a new object of class '<em>Function Argument List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Argument List</em>'.
   * @generated
   */
  FunctionArgumentList createFunctionArgumentList();

  /**
   * Returns a new object of class '<em>Named Argument</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Argument</em>'.
   * @generated
   */
  NamedArgument createNamedArgument();

  /**
   * Returns a new object of class '<em>Symbol Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Symbol Reference</em>'.
   * @generated
   */
  SymbolReference createSymbolReference();

  /**
   * Returns a new object of class '<em>Component Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Component Reference</em>'.
   * @generated
   */
  ComponentReference createComponentReference();

  /**
   * Returns a new object of class '<em>Array Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Reference</em>'.
   * @generated
   */
  ArrayReference createArrayReference();

  /**
   * Returns a new object of class '<em>Member Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Member Reference</em>'.
   * @generated
   */
  MemberReference createMemberReference();

  /**
   * Returns a new object of class '<em>Subscript</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Subscript</em>'.
   * @generated
   */
  Subscript createSubscript();

  /**
   * Returns a new object of class '<em>Colon Subscript</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Colon Subscript</em>'.
   * @generated
   */
  ColonSubscript createColonSubscript();

  /**
   * Returns a new object of class '<em>Expression Subscript</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression Subscript</em>'.
   * @generated
   */
  ExpressionSubscript createExpressionSubscript();

  /**
   * Returns a new object of class '<em>Array Concatenation Operator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Concatenation Operator</em>'.
   * @generated
   */
  ArrayConcatenationOperator createArrayConcatenationOperator();

  /**
   * Returns a new object of class '<em>Array Construction Operator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Construction Operator</em>'.
   * @generated
   */
  ArrayConstructionOperator createArrayConstructionOperator();

  /**
   * Returns a new object of class '<em>Expression List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression List</em>'.
   * @generated
   */
  ExpressionList createExpressionList();

  /**
   * Returns a new object of class '<em>Parenthesized Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parenthesized Expression</em>'.
   * @generated
   */
  ParenthesizedExpression createParenthesizedExpression();

  /**
   * Returns a new object of class '<em>Begin Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Begin Expression</em>'.
   * @generated
   */
  BeginExpression createBeginExpression();

  /**
   * Returns a new object of class '<em>End Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>End Expression</em>'.
   * @generated
   */
  EndExpression createEndExpression();

  /**
   * Returns a new object of class '<em>Unit Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unit Expression</em>'.
   * @generated
   */
  UnitExpression createUnitExpression();

  /**
   * Returns a new object of class '<em>Unit Expression Numerator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unit Expression Numerator</em>'.
   * @generated
   */
  UnitExpressionNumerator createUnitExpressionNumerator();

  /**
   * Returns a new object of class '<em>Unit Expression Denominator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unit Expression Denominator</em>'.
   * @generated
   */
  UnitExpressionDenominator createUnitExpressionDenominator();

  /**
   * Returns a new object of class '<em>Unit Expression Factor</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unit Expression Factor</em>'.
   * @generated
   */
  UnitExpressionFactor createUnitExpressionFactor();

  /**
   * Returns a new object of class '<em>Unit Expression Exponent</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unit Expression Exponent</em>'.
   * @generated
   */
  UnitExpressionExponent createUnitExpressionExponent();

  /**
   * Returns a new object of class '<em>Range Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Range Expression</em>'.
   * @generated
   */
  RangeExpression createRangeExpression();

  /**
   * Returns a new object of class '<em>Logical Or Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Or Expression</em>'.
   * @generated
   */
  LogicalOrExpression createLogicalOrExpression();

  /**
   * Returns a new object of class '<em>Logical And Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical And Expression</em>'.
   * @generated
   */
  LogicalAndExpression createLogicalAndExpression();

  /**
   * Returns a new object of class '<em>Logical Not Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Logical Not Expression</em>'.
   * @generated
   */
  LogicalNotExpression createLogicalNotExpression();

  /**
   * Returns a new object of class '<em>Relational Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Relational Expression</em>'.
   * @generated
   */
  RelationalExpression createRelationalExpression();

  /**
   * Returns a new object of class '<em>Add Subtract Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Add Subtract Expression</em>'.
   * @generated
   */
  AddSubtractExpression createAddSubtractExpression();

  /**
   * Returns a new object of class '<em>Multiply Divide Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiply Divide Expression</em>'.
   * @generated
   */
  MultiplyDivideExpression createMultiplyDivideExpression();

  /**
   * Returns a new object of class '<em>Power Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Power Expression</em>'.
   * @generated
   */
  PowerExpression createPowerExpression();

  /**
   * Returns a new object of class '<em>Unary Minus Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unary Minus Expression</em>'.
   * @generated
   */
  UnaryMinusExpression createUnaryMinusExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  MscriptPackage getMscriptPackage();

} //MscriptFactory
