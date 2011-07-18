/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.eclipselabs.mscript.language.ast.AstPackage
 * @generated
 */
public interface AstFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AstFactory eINSTANCE = org.eclipselabs.mscript.language.ast.impl.AstFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Module</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Module</em>'.
	 * @generated
	 */
	Module createModule();

	/**
	 * Returns a new object of class '<em>Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Definition</em>'.
	 * @generated
	 */
	Definition createDefinition();

	/**
	 * Returns a new object of class '<em>Data Type Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Definition</em>'.
	 * @generated
	 */
	DataTypeDefinition createDataTypeDefinition();

	/**
	 * Returns a new object of class '<em>Enumeration Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Definition</em>'.
	 * @generated
	 */
	EnumerationDefinition createEnumerationDefinition();

	/**
	 * Returns a new object of class '<em>Enumeration Literal Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Enumeration Literal Declaration</em>'.
	 * @generated
	 */
	EnumerationLiteralDeclaration createEnumerationLiteralDeclaration();

	/**
	 * Returns a new object of class '<em>Type Alias Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Alias Definition</em>'.
	 * @generated
	 */
	TypeAliasDefinition createTypeAliasDefinition();

	/**
	 * Returns a new object of class '<em>Record Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Record Definition</em>'.
	 * @generated
	 */
	RecordDefinition createRecordDefinition();

	/**
	 * Returns a new object of class '<em>Record Field Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Record Field Declaration</em>'.
	 * @generated
	 */
	RecordFieldDeclaration createRecordFieldDeclaration();

	/**
	 * Returns a new object of class '<em>Function Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Definition</em>'.
	 * @generated
	 */
	FunctionDefinition createFunctionDefinition();

	/**
	 * Returns a new object of class '<em>Parameter Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Parameter Declaration</em>'.
	 * @generated
	 */
	ParameterDeclaration createParameterDeclaration();

	/**
	 * Returns a new object of class '<em>Assertion</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Assertion</em>'.
	 * @generated
	 */
	Assertion createAssertion();

	/**
	 * Returns a new object of class '<em>State Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>State Variable Declaration</em>'.
	 * @generated
	 */
	StateVariableDeclaration createStateVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Function Object Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Object Declaration</em>'.
	 * @generated
	 */
	FunctionObjectDeclaration createFunctionObjectDeclaration();

	/**
	 * Returns a new object of class '<em>Equation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equation</em>'.
	 * @generated
	 */
	Equation createEquation();

	/**
	 * Returns a new object of class '<em>Data Type Specifier</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Type Specifier</em>'.
	 * @generated
	 */
	DataTypeSpecifier createDataTypeSpecifier();

	/**
	 * Returns a new object of class '<em>Let Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Expression</em>'.
	 * @generated
	 */
	LetExpression createLetExpression();

	/**
	 * Returns a new object of class '<em>Let Expression Variable Declaration</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Expression Variable Declaration</em>'.
	 * @generated
	 */
	LetExpressionVariableDeclaration createLetExpressionVariableDeclaration();

	/**
	 * Returns a new object of class '<em>Let Expression Variable Declaration Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Let Expression Variable Declaration Part</em>'.
	 * @generated
	 */
	LetExpressionVariableDeclarationPart createLetExpressionVariableDeclarationPart();

	/**
	 * Returns a new object of class '<em>If Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>If Expression</em>'.
	 * @generated
	 */
	IfExpression createIfExpression();

	/**
	 * Returns a new object of class '<em>Switch Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Expression</em>'.
	 * @generated
	 */
	SwitchExpression createSwitchExpression();

	/**
	 * Returns a new object of class '<em>Switch Case</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Switch Case</em>'.
	 * @generated
	 */
	SwitchCase createSwitchCase();

	/**
	 * Returns a new object of class '<em>Additive Expression Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Additive Expression Part</em>'.
	 * @generated
	 */
	AdditiveExpressionPart createAdditiveExpressionPart();

	/**
	 * Returns a new object of class '<em>Multiplicative Expression Part</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicative Expression Part</em>'.
	 * @generated
	 */
	MultiplicativeExpressionPart createMultiplicativeExpressionPart();

	/**
	 * Returns a new object of class '<em>Array Element Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Element Access</em>'.
	 * @generated
	 */
	ArrayElementAccess createArrayElementAccess();

	/**
	 * Returns a new object of class '<em>Array Subscript</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Subscript</em>'.
	 * @generated
	 */
	ArraySubscript createArraySubscript();

	/**
	 * Returns a new object of class '<em>Iteration Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration Call</em>'.
	 * @generated
	 */
	IterationCall createIterationCall();

	/**
	 * Returns a new object of class '<em>Iteration Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration Variable</em>'.
	 * @generated
	 */
	IterationVariable createIterationVariable();

	/**
	 * Returns a new object of class '<em>Iteration Accumulator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Iteration Accumulator</em>'.
	 * @generated
	 */
	IterationAccumulator createIterationAccumulator();

	/**
	 * Returns a new object of class '<em>Array Construction Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Construction Operator</em>'.
	 * @generated
	 */
	ArrayConstructionOperator createArrayConstructionOperator();

	/**
	 * Returns a new object of class '<em>Array Construction Iteration Clause</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Construction Iteration Clause</em>'.
	 * @generated
	 */
	ArrayConstructionIterationClause createArrayConstructionIterationClause();

	/**
	 * Returns a new object of class '<em>Array Concatenation Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Array Concatenation Operator</em>'.
	 * @generated
	 */
	ArrayConcatenationOperator createArrayConcatenationOperator();

	/**
	 * Returns a new object of class '<em>Expression List</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Expression List</em>'.
	 * @generated
	 */
	ExpressionList createExpressionList();

	/**
	 * Returns a new object of class '<em>Unit Construction Operator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unit Construction Operator</em>'.
	 * @generated
	 */
	UnitConstructionOperator createUnitConstructionOperator();

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
	 * Returns a new object of class '<em>Range Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Range Expression</em>'.
	 * @generated
	 */
	RangeExpression createRangeExpression();

	/**
	 * Returns a new object of class '<em>Implies Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Implies Expression</em>'.
	 * @generated
	 */
	ImpliesExpression createImpliesExpression();

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
	 * Returns a new object of class '<em>Equality Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Equality Expression</em>'.
	 * @generated
	 */
	EqualityExpression createEqualityExpression();

	/**
	 * Returns a new object of class '<em>Relational Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Relational Expression</em>'.
	 * @generated
	 */
	RelationalExpression createRelationalExpression();

	/**
	 * Returns a new object of class '<em>Type Test Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Type Test Expression</em>'.
	 * @generated
	 */
	TypeTestExpression createTypeTestExpression();

	/**
	 * Returns a new object of class '<em>Additive Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Additive Expression</em>'.
	 * @generated
	 */
	AdditiveExpression createAdditiveExpression();

	/**
	 * Returns a new object of class '<em>Multiplicative Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Multiplicative Expression</em>'.
	 * @generated
	 */
	MultiplicativeExpression createMultiplicativeExpression();

	/**
	 * Returns a new object of class '<em>Power Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Power Expression</em>'.
	 * @generated
	 */
	PowerExpression createPowerExpression();

	/**
	 * Returns a new object of class '<em>Unary Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Unary Expression</em>'.
	 * @generated
	 */
	UnaryExpression createUnaryExpression();

	/**
	 * Returns a new object of class '<em>Postfix Expression</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postfix Expression</em>'.
	 * @generated
	 */
	PostfixExpression createPostfixExpression();

	/**
	 * Returns a new object of class '<em>Variable Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Variable Access</em>'.
	 * @generated
	 */
	VariableAccess createVariableAccess();

	/**
	 * Returns a new object of class '<em>Function Call</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function Call</em>'.
	 * @generated
	 */
	FunctionCall createFunctionCall();

	/**
	 * Returns a new object of class '<em>Member Variable Access</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Member Variable Access</em>'.
	 * @generated
	 */
	MemberVariableAccess createMemberVariableAccess();

	/**
	 * Returns a new object of class '<em>Builtin Definition</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Definition</em>'.
	 * @generated
	 */
	BuiltinDefinition createBuiltinDefinition();

	/**
	 * Returns a new object of class '<em>Builtin Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Function</em>'.
	 * @generated
	 */
	BuiltinFunction createBuiltinFunction();

	/**
	 * Returns a new object of class '<em>Builtin Variable</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Builtin Variable</em>'.
	 * @generated
	 */
	BuiltinVariable createBuiltinVariable();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AstPackage getAstPackage();

} //AstFactory
