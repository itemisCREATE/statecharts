/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.eclipselabs.mscript.language.ast.*;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveOperator;
import org.eclipselabs.mscript.language.ast.AdditiveStepExpression;
import org.eclipselabs.mscript.language.ast.ArrayConcatenationOperator;
import org.eclipselabs.mscript.language.ast.ArrayConstructionIterationClause;
import org.eclipselabs.mscript.language.ast.ArrayConstructionOperator;
import org.eclipselabs.mscript.language.ast.ArrayElementAccess;
import org.eclipselabs.mscript.language.ast.ArraySubscript;
import org.eclipselabs.mscript.language.ast.Assertion;
import org.eclipselabs.mscript.language.ast.AssertionStatusKind;
import org.eclipselabs.mscript.language.ast.AstFactory;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.BeginExpression;
import org.eclipselabs.mscript.language.ast.BuiltinDefinition;
import org.eclipselabs.mscript.language.ast.BuiltinFunction;
import org.eclipselabs.mscript.language.ast.BuiltinVariable;
import org.eclipselabs.mscript.language.ast.DataTypeSpecifier;
import org.eclipselabs.mscript.language.ast.EndExpression;
import org.eclipselabs.mscript.language.ast.EnumerationDefinition;
import org.eclipselabs.mscript.language.ast.EnumerationLiteralDeclaration;
import org.eclipselabs.mscript.language.ast.EqualityExpression;
import org.eclipselabs.mscript.language.ast.EqualityOperator;
import org.eclipselabs.mscript.language.ast.Equation;
import org.eclipselabs.mscript.language.ast.ExpressionList;
import org.eclipselabs.mscript.language.ast.FunctionCall;
import org.eclipselabs.mscript.language.ast.FunctionDefinition;
import org.eclipselabs.mscript.language.ast.FunctionObjectDeclaration;
import org.eclipselabs.mscript.language.ast.IfExpression;
import org.eclipselabs.mscript.language.ast.ImpliesExpression;
import org.eclipselabs.mscript.language.ast.IterationAccumulator;
import org.eclipselabs.mscript.language.ast.IterationCall;
import org.eclipselabs.mscript.language.ast.IterationVariable;
import org.eclipselabs.mscript.language.ast.LetExpression;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclaration;
import org.eclipselabs.mscript.language.ast.LetExpressionVariableDeclarationPart;
import org.eclipselabs.mscript.language.ast.LogicalAndExpression;
import org.eclipselabs.mscript.language.ast.LogicalOrExpression;
import org.eclipselabs.mscript.language.ast.MemberVariableAccess;
import org.eclipselabs.mscript.language.ast.Module;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeOperator;
import org.eclipselabs.mscript.language.ast.NegateStepExpression;
import org.eclipselabs.mscript.language.ast.ParameterDeclaration;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.PostfixExpression;
import org.eclipselabs.mscript.language.ast.PostfixOperator;
import org.eclipselabs.mscript.language.ast.PowerExpression;
import org.eclipselabs.mscript.language.ast.PowerOperator;
import org.eclipselabs.mscript.language.ast.RangeExpression;
import org.eclipselabs.mscript.language.ast.RangeStepExpression;
import org.eclipselabs.mscript.language.ast.RecordDefinition;
import org.eclipselabs.mscript.language.ast.RecordFieldDeclaration;
import org.eclipselabs.mscript.language.ast.RelationalExpression;
import org.eclipselabs.mscript.language.ast.RelationalOperator;
import org.eclipselabs.mscript.language.ast.StateVariableDeclaration;
import org.eclipselabs.mscript.language.ast.StepLiteral;
import org.eclipselabs.mscript.language.ast.StepN;
import org.eclipselabs.mscript.language.ast.SwitchCase;
import org.eclipselabs.mscript.language.ast.SwitchExpression;
import org.eclipselabs.mscript.language.ast.TypeAliasDefinition;
import org.eclipselabs.mscript.language.ast.TypeTestExpression;
import org.eclipselabs.mscript.language.ast.UnaryExpression;
import org.eclipselabs.mscript.language.ast.UnaryOperator;
import org.eclipselabs.mscript.language.ast.UnitConstructionOperator;
import org.eclipselabs.mscript.language.ast.VariableAccess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AstFactoryImpl extends EFactoryImpl implements AstFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AstFactory init() {
		try {
			AstFactory theAstFactory = (AstFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.eclipselabs.org/mscript/AST/1.0.0"); 
			if (theAstFactory != null) {
				return theAstFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AstFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AstFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AstPackage.MODULE: return createModule();
			case AstPackage.ENUMERATION_DEFINITION: return createEnumerationDefinition();
			case AstPackage.ENUMERATION_LITERAL_DECLARATION: return createEnumerationLiteralDeclaration();
			case AstPackage.TYPE_ALIAS_DEFINITION: return createTypeAliasDefinition();
			case AstPackage.RECORD_DEFINITION: return createRecordDefinition();
			case AstPackage.RECORD_FIELD_DECLARATION: return createRecordFieldDeclaration();
			case AstPackage.FUNCTION_DEFINITION: return createFunctionDefinition();
			case AstPackage.STATIC_TEST: return createStaticTest();
			case AstPackage.PARAMETER_DECLARATION: return createParameterDeclaration();
			case AstPackage.ASSERTION: return createAssertion();
			case AstPackage.STATE_VARIABLE_DECLARATION: return createStateVariableDeclaration();
			case AstPackage.FUNCTION_OBJECT_DECLARATION: return createFunctionObjectDeclaration();
			case AstPackage.EQUATION: return createEquation();
			case AstPackage.DATA_TYPE_SPECIFIER: return createDataTypeSpecifier();
			case AstPackage.LET_EXPRESSION: return createLetExpression();
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION: return createLetExpressionVariableDeclaration();
			case AstPackage.LET_EXPRESSION_VARIABLE_DECLARATION_PART: return createLetExpressionVariableDeclarationPart();
			case AstPackage.IF_EXPRESSION: return createIfExpression();
			case AstPackage.SWITCH_EXPRESSION: return createSwitchExpression();
			case AstPackage.SWITCH_CASE: return createSwitchCase();
			case AstPackage.ARRAY_ELEMENT_ACCESS: return createArrayElementAccess();
			case AstPackage.ARRAY_SUBSCRIPT: return createArraySubscript();
			case AstPackage.ITERATION_CALL: return createIterationCall();
			case AstPackage.ITERATION_VARIABLE: return createIterationVariable();
			case AstPackage.ITERATION_ACCUMULATOR: return createIterationAccumulator();
			case AstPackage.ARRAY_CONSTRUCTION_OPERATOR: return createArrayConstructionOperator();
			case AstPackage.ARRAY_CONSTRUCTION_ITERATION_CLAUSE: return createArrayConstructionIterationClause();
			case AstPackage.ARRAY_CONCATENATION_OPERATOR: return createArrayConcatenationOperator();
			case AstPackage.EXPRESSION_LIST: return createExpressionList();
			case AstPackage.UNIT_CONSTRUCTION_OPERATOR: return createUnitConstructionOperator();
			case AstPackage.PARENTHESIZED_EXPRESSION: return createParenthesizedExpression();
			case AstPackage.BEGIN_EXPRESSION: return createBeginExpression();
			case AstPackage.END_EXPRESSION: return createEndExpression();
			case AstPackage.RANGE_EXPRESSION: return createRangeExpression();
			case AstPackage.IMPLIES_EXPRESSION: return createImpliesExpression();
			case AstPackage.LOGICAL_OR_EXPRESSION: return createLogicalOrExpression();
			case AstPackage.LOGICAL_AND_EXPRESSION: return createLogicalAndExpression();
			case AstPackage.EQUALITY_EXPRESSION: return createEqualityExpression();
			case AstPackage.RELATIONAL_EXPRESSION: return createRelationalExpression();
			case AstPackage.TYPE_TEST_EXPRESSION: return createTypeTestExpression();
			case AstPackage.ADDITIVE_EXPRESSION: return createAdditiveExpression();
			case AstPackage.MULTIPLICATIVE_EXPRESSION: return createMultiplicativeExpression();
			case AstPackage.POWER_EXPRESSION: return createPowerExpression();
			case AstPackage.UNARY_EXPRESSION: return createUnaryExpression();
			case AstPackage.POSTFIX_EXPRESSION: return createPostfixExpression();
			case AstPackage.VARIABLE_ACCESS: return createVariableAccess();
			case AstPackage.RANGE_STEP_EXPRESSION: return createRangeStepExpression();
			case AstPackage.ADDITIVE_STEP_EXPRESSION: return createAdditiveStepExpression();
			case AstPackage.NEGATE_STEP_EXPRESSION: return createNegateStepExpression();
			case AstPackage.STEP_LITERAL: return createStepLiteral();
			case AstPackage.STEP_N: return createStepN();
			case AstPackage.FUNCTION_CALL: return createFunctionCall();
			case AstPackage.MEMBER_VARIABLE_ACCESS: return createMemberVariableAccess();
			case AstPackage.BUILTIN_DEFINITION: return createBuiltinDefinition();
			case AstPackage.BUILTIN_FUNCTION: return createBuiltinFunction();
			case AstPackage.BUILTIN_VARIABLE: return createBuiltinVariable();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case AstPackage.ASSERTION_STATUS_KIND:
				return createAssertionStatusKindFromString(eDataType, initialValue);
			case AstPackage.EQUALITY_OPERATOR:
				return createEqualityOperatorFromString(eDataType, initialValue);
			case AstPackage.RELATIONAL_OPERATOR:
				return createRelationalOperatorFromString(eDataType, initialValue);
			case AstPackage.ADDITIVE_OPERATOR:
				return createAdditiveOperatorFromString(eDataType, initialValue);
			case AstPackage.MULTIPLICATIVE_OPERATOR:
				return createMultiplicativeOperatorFromString(eDataType, initialValue);
			case AstPackage.POWER_OPERATOR:
				return createPowerOperatorFromString(eDataType, initialValue);
			case AstPackage.UNARY_OPERATOR:
				return createUnaryOperatorFromString(eDataType, initialValue);
			case AstPackage.POSTFIX_OPERATOR:
				return createPostfixOperatorFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case AstPackage.ASSERTION_STATUS_KIND:
				return convertAssertionStatusKindToString(eDataType, instanceValue);
			case AstPackage.EQUALITY_OPERATOR:
				return convertEqualityOperatorToString(eDataType, instanceValue);
			case AstPackage.RELATIONAL_OPERATOR:
				return convertRelationalOperatorToString(eDataType, instanceValue);
			case AstPackage.ADDITIVE_OPERATOR:
				return convertAdditiveOperatorToString(eDataType, instanceValue);
			case AstPackage.MULTIPLICATIVE_OPERATOR:
				return convertMultiplicativeOperatorToString(eDataType, instanceValue);
			case AstPackage.POWER_OPERATOR:
				return convertPowerOperatorToString(eDataType, instanceValue);
			case AstPackage.UNARY_OPERATOR:
				return convertUnaryOperatorToString(eDataType, instanceValue);
			case AstPackage.POSTFIX_OPERATOR:
				return convertPostfixOperatorToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Module createModule() {
		ModuleImpl module = new ModuleImpl();
		return module;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationDefinition createEnumerationDefinition() {
		EnumerationDefinitionImpl enumerationDefinition = new EnumerationDefinitionImpl();
		return enumerationDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteralDeclaration createEnumerationLiteralDeclaration() {
		EnumerationLiteralDeclarationImpl enumerationLiteralDeclaration = new EnumerationLiteralDeclarationImpl();
		return enumerationLiteralDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeAliasDefinition createTypeAliasDefinition() {
		TypeAliasDefinitionImpl typeAliasDefinition = new TypeAliasDefinitionImpl();
		return typeAliasDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordDefinition createRecordDefinition() {
		RecordDefinitionImpl recordDefinition = new RecordDefinitionImpl();
		return recordDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecordFieldDeclaration createRecordFieldDeclaration() {
		RecordFieldDeclarationImpl recordFieldDeclaration = new RecordFieldDeclarationImpl();
		return recordFieldDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionDefinition createFunctionDefinition() {
		FunctionDefinitionImpl functionDefinition = new FunctionDefinitionImpl();
		return functionDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StaticTest createStaticTest() {
		StaticTestImpl staticTest = new StaticTestImpl();
		return staticTest;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterDeclaration createParameterDeclaration() {
		ParameterDeclarationImpl parameterDeclaration = new ParameterDeclarationImpl();
		return parameterDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Assertion createAssertion() {
		AssertionImpl assertion = new AssertionImpl();
		return assertion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVariableDeclaration createStateVariableDeclaration() {
		StateVariableDeclarationImpl stateVariableDeclaration = new StateVariableDeclarationImpl();
		return stateVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionObjectDeclaration createFunctionObjectDeclaration() {
		FunctionObjectDeclarationImpl functionObjectDeclaration = new FunctionObjectDeclarationImpl();
		return functionObjectDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Equation createEquation() {
		EquationImpl equation = new EquationImpl();
		return equation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataTypeSpecifier createDataTypeSpecifier() {
		DataTypeSpecifierImpl dataTypeSpecifier = new DataTypeSpecifierImpl();
		return dataTypeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpression createLetExpression() {
		LetExpressionImpl letExpression = new LetExpressionImpl();
		return letExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpressionVariableDeclaration createLetExpressionVariableDeclaration() {
		LetExpressionVariableDeclarationImpl letExpressionVariableDeclaration = new LetExpressionVariableDeclarationImpl();
		return letExpressionVariableDeclaration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LetExpressionVariableDeclarationPart createLetExpressionVariableDeclarationPart() {
		LetExpressionVariableDeclarationPartImpl letExpressionVariableDeclarationPart = new LetExpressionVariableDeclarationPartImpl();
		return letExpressionVariableDeclarationPart;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IfExpression createIfExpression() {
		IfExpressionImpl ifExpression = new IfExpressionImpl();
		return ifExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchExpression createSwitchExpression() {
		SwitchExpressionImpl switchExpression = new SwitchExpressionImpl();
		return switchExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SwitchCase createSwitchCase() {
		SwitchCaseImpl switchCase = new SwitchCaseImpl();
		return switchCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayElementAccess createArrayElementAccess() {
		ArrayElementAccessImpl arrayElementAccess = new ArrayElementAccessImpl();
		return arrayElementAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArraySubscript createArraySubscript() {
		ArraySubscriptImpl arraySubscript = new ArraySubscriptImpl();
		return arraySubscript;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationCall createIterationCall() {
		IterationCallImpl iterationCall = new IterationCallImpl();
		return iterationCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationVariable createIterationVariable() {
		IterationVariableImpl iterationVariable = new IterationVariableImpl();
		return iterationVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IterationAccumulator createIterationAccumulator() {
		IterationAccumulatorImpl iterationAccumulator = new IterationAccumulatorImpl();
		return iterationAccumulator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayConstructionOperator createArrayConstructionOperator() {
		ArrayConstructionOperatorImpl arrayConstructionOperator = new ArrayConstructionOperatorImpl();
		return arrayConstructionOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayConstructionIterationClause createArrayConstructionIterationClause() {
		ArrayConstructionIterationClauseImpl arrayConstructionIterationClause = new ArrayConstructionIterationClauseImpl();
		return arrayConstructionIterationClause;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ArrayConcatenationOperator createArrayConcatenationOperator() {
		ArrayConcatenationOperatorImpl arrayConcatenationOperator = new ArrayConcatenationOperatorImpl();
		return arrayConcatenationOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionList createExpressionList() {
		ExpressionListImpl expressionList = new ExpressionListImpl();
		return expressionList;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnitConstructionOperator createUnitConstructionOperator() {
		UnitConstructionOperatorImpl unitConstructionOperator = new UnitConstructionOperatorImpl();
		return unitConstructionOperator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParenthesizedExpression createParenthesizedExpression() {
		ParenthesizedExpressionImpl parenthesizedExpression = new ParenthesizedExpressionImpl();
		return parenthesizedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BeginExpression createBeginExpression() {
		BeginExpressionImpl beginExpression = new BeginExpressionImpl();
		return beginExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EndExpression createEndExpression() {
		EndExpressionImpl endExpression = new EndExpressionImpl();
		return endExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeExpression createRangeExpression() {
		RangeExpressionImpl rangeExpression = new RangeExpressionImpl();
		return rangeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ImpliesExpression createImpliesExpression() {
		ImpliesExpressionImpl impliesExpression = new ImpliesExpressionImpl();
		return impliesExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalOrExpression createLogicalOrExpression() {
		LogicalOrExpressionImpl logicalOrExpression = new LogicalOrExpressionImpl();
		return logicalOrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LogicalAndExpression createLogicalAndExpression() {
		LogicalAndExpressionImpl logicalAndExpression = new LogicalAndExpressionImpl();
		return logicalAndExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityExpression createEqualityExpression() {
		EqualityExpressionImpl equalityExpression = new EqualityExpressionImpl();
		return equalityExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalExpression createRelationalExpression() {
		RelationalExpressionImpl relationalExpression = new RelationalExpressionImpl();
		return relationalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeTestExpression createTypeTestExpression() {
		TypeTestExpressionImpl typeTestExpression = new TypeTestExpressionImpl();
		return typeTestExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveExpression createAdditiveExpression() {
		AdditiveExpressionImpl additiveExpression = new AdditiveExpressionImpl();
		return additiveExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicativeExpression createMultiplicativeExpression() {
		MultiplicativeExpressionImpl multiplicativeExpression = new MultiplicativeExpressionImpl();
		return multiplicativeExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerExpression createPowerExpression() {
		PowerExpressionImpl powerExpression = new PowerExpressionImpl();
		return powerExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryExpression createUnaryExpression() {
		UnaryExpressionImpl unaryExpression = new UnaryExpressionImpl();
		return unaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixExpression createPostfixExpression() {
		PostfixExpressionImpl postfixExpression = new PostfixExpressionImpl();
		return postfixExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VariableAccess createVariableAccess() {
		VariableAccessImpl variableAccess = new VariableAccessImpl();
		return variableAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RangeStepExpression createRangeStepExpression() {
		RangeStepExpressionImpl rangeStepExpression = new RangeStepExpressionImpl();
		return rangeStepExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveStepExpression createAdditiveStepExpression() {
		AdditiveStepExpressionImpl additiveStepExpression = new AdditiveStepExpressionImpl();
		return additiveStepExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NegateStepExpression createNegateStepExpression() {
		NegateStepExpressionImpl negateStepExpression = new NegateStepExpressionImpl();
		return negateStepExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepLiteral createStepLiteral() {
		StepLiteralImpl stepLiteral = new StepLiteralImpl();
		return stepLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StepN createStepN() {
		StepNImpl stepN = new StepNImpl();
		return stepN;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FunctionCall createFunctionCall() {
		FunctionCallImpl functionCall = new FunctionCallImpl();
		return functionCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MemberVariableAccess createMemberVariableAccess() {
		MemberVariableAccessImpl memberVariableAccess = new MemberVariableAccessImpl();
		return memberVariableAccess;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinDefinition createBuiltinDefinition() {
		BuiltinDefinitionImpl builtinDefinition = new BuiltinDefinitionImpl();
		return builtinDefinition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinFunction createBuiltinFunction() {
		BuiltinFunctionImpl builtinFunction = new BuiltinFunctionImpl();
		return builtinFunction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BuiltinVariable createBuiltinVariable() {
		BuiltinVariableImpl builtinVariable = new BuiltinVariableImpl();
		return builtinVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssertionStatusKind createAssertionStatusKindFromString(EDataType eDataType, String initialValue) {
		AssertionStatusKind result = AssertionStatusKind.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssertionStatusKindToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EqualityOperator createEqualityOperatorFromString(EDataType eDataType, String initialValue) {
		EqualityOperator result = EqualityOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertEqualityOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RelationalOperator createRelationalOperatorFromString(EDataType eDataType, String initialValue) {
		RelationalOperator result = RelationalOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRelationalOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AdditiveOperator createAdditiveOperatorFromString(EDataType eDataType, String initialValue) {
		AdditiveOperator result = AdditiveOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAdditiveOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public MultiplicativeOperator createMultiplicativeOperatorFromString(EDataType eDataType, String initialValue) {
		MultiplicativeOperator result = MultiplicativeOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertMultiplicativeOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerOperator createPowerOperatorFromString(EDataType eDataType, String initialValue) {
		PowerOperator result = PowerOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPowerOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UnaryOperator createUnaryOperatorFromString(EDataType eDataType, String initialValue) {
		UnaryOperator result = UnaryOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUnaryOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostfixOperator createPostfixOperatorFromString(EDataType eDataType, String initialValue) {
		PostfixOperator result = PostfixOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPostfixOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AstPackage getAstPackage() {
		return (AstPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static AstPackage getPackage() {
		return AstPackage.eINSTANCE;
	}

} //AstFactoryImpl
