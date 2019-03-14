/**
 */
package org.yakindu.base.expressions.expressions.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;
import org.yakindu.base.expressions.expressions.*;
import org.yakindu.base.expressions.expressions.AdditiveOperator;
import org.yakindu.base.expressions.expressions.Argument;
import org.yakindu.base.expressions.expressions.AssignmentExpression;
import org.yakindu.base.expressions.expressions.AssignmentOperator;
import org.yakindu.base.expressions.expressions.BinaryLiteral;
import org.yakindu.base.expressions.expressions.BitwiseAndExpression;
import org.yakindu.base.expressions.expressions.BitwiseOperator;
import org.yakindu.base.expressions.expressions.BitwiseOrExpression;
import org.yakindu.base.expressions.expressions.BitwiseXorExpression;
import org.yakindu.base.expressions.expressions.BlockExpression;
import org.yakindu.base.expressions.expressions.BoolLiteral;
import org.yakindu.base.expressions.expressions.ConditionalExpression;
import org.yakindu.base.expressions.expressions.DoubleLiteral;
import org.yakindu.base.expressions.expressions.ElementReferenceExpression;
import org.yakindu.base.expressions.expressions.EventRaisingExpression;
import org.yakindu.base.expressions.expressions.EventValueReferenceExpression;
import org.yakindu.base.expressions.expressions.ExpressionsFactory;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.FeatureCall;
import org.yakindu.base.expressions.expressions.FloatLiteral;
import org.yakindu.base.expressions.expressions.HexLiteral;
import org.yakindu.base.expressions.expressions.IfExpression;
import org.yakindu.base.expressions.expressions.IntLiteral;
import org.yakindu.base.expressions.expressions.LogicalAndExpression;
import org.yakindu.base.expressions.expressions.LogicalNotExpression;
import org.yakindu.base.expressions.expressions.LogicalOperator;
import org.yakindu.base.expressions.expressions.LogicalOrExpression;
import org.yakindu.base.expressions.expressions.LogicalRelationExpression;
import org.yakindu.base.expressions.expressions.MetaCall;
import org.yakindu.base.expressions.expressions.MultiplicativeOperator;
import org.yakindu.base.expressions.expressions.NullLiteral;
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression;
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression;
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression;
import org.yakindu.base.expressions.expressions.ParenthesizedExpression;
import org.yakindu.base.expressions.expressions.PostFixOperator;
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression;
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression;
import org.yakindu.base.expressions.expressions.RelationalOperator;
import org.yakindu.base.expressions.expressions.ReturnExpression;
import org.yakindu.base.expressions.expressions.ShiftExpression;
import org.yakindu.base.expressions.expressions.ShiftOperator;
import org.yakindu.base.expressions.expressions.StringLiteral;
import org.yakindu.base.expressions.expressions.SwitchCase;
import org.yakindu.base.expressions.expressions.SwitchExpression;
import org.yakindu.base.expressions.expressions.TypeCastExpression;
import org.yakindu.base.expressions.expressions.UnaryOperator;
import org.yakindu.base.expressions.expressions.WhileExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ExpressionsFactoryImpl extends EFactoryImpl implements ExpressionsFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ExpressionsFactory init() {
		try {
			ExpressionsFactory theExpressionsFactory = (ExpressionsFactory)EPackage.Registry.INSTANCE.getEFactory(ExpressionsPackage.eNS_URI);
			if (theExpressionsFactory != null) {
				return theExpressionsFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ExpressionsFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsFactoryImpl() {
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
			case ExpressionsPackage.BOOL_LITERAL: return createBoolLiteral();
			case ExpressionsPackage.INT_LITERAL: return createIntLiteral();
			case ExpressionsPackage.DOUBLE_LITERAL: return createDoubleLiteral();
			case ExpressionsPackage.FLOAT_LITERAL: return createFloatLiteral();
			case ExpressionsPackage.HEX_LITERAL: return createHexLiteral();
			case ExpressionsPackage.BINARY_LITERAL: return createBinaryLiteral();
			case ExpressionsPackage.STRING_LITERAL: return createStringLiteral();
			case ExpressionsPackage.NULL_LITERAL: return createNullLiteral();
			case ExpressionsPackage.ASSIGNMENT_EXPRESSION: return createAssignmentExpression();
			case ExpressionsPackage.CONDITIONAL_EXPRESSION: return createConditionalExpression();
			case ExpressionsPackage.LOGICAL_OR_EXPRESSION: return createLogicalOrExpression();
			case ExpressionsPackage.LOGICAL_AND_EXPRESSION: return createLogicalAndExpression();
			case ExpressionsPackage.LOGICAL_NOT_EXPRESSION: return createLogicalNotExpression();
			case ExpressionsPackage.BITWISE_XOR_EXPRESSION: return createBitwiseXorExpression();
			case ExpressionsPackage.BITWISE_OR_EXPRESSION: return createBitwiseOrExpression();
			case ExpressionsPackage.BITWISE_AND_EXPRESSION: return createBitwiseAndExpression();
			case ExpressionsPackage.LOGICAL_RELATION_EXPRESSION: return createLogicalRelationExpression();
			case ExpressionsPackage.SHIFT_EXPRESSION: return createShiftExpression();
			case ExpressionsPackage.NUMERICAL_ADD_SUBTRACT_EXPRESSION: return createNumericalAddSubtractExpression();
			case ExpressionsPackage.NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION: return createNumericalMultiplyDivideExpression();
			case ExpressionsPackage.NUMERICAL_UNARY_EXPRESSION: return createNumericalUnaryExpression();
			case ExpressionsPackage.POST_FIX_UNARY_EXPRESSION: return createPostFixUnaryExpression();
			case ExpressionsPackage.PRIMITIVE_VALUE_EXPRESSION: return createPrimitiveValueExpression();
			case ExpressionsPackage.FEATURE_CALL: return createFeatureCall();
			case ExpressionsPackage.META_CALL: return createMetaCall();
			case ExpressionsPackage.ELEMENT_REFERENCE_EXPRESSION: return createElementReferenceExpression();
			case ExpressionsPackage.PARENTHESIZED_EXPRESSION: return createParenthesizedExpression();
			case ExpressionsPackage.TYPE_CAST_EXPRESSION: return createTypeCastExpression();
			case ExpressionsPackage.ARGUMENT: return createArgument();
			case ExpressionsPackage.IF_EXPRESSION: return createIfExpression();
			case ExpressionsPackage.BLOCK_EXPRESSION: return createBlockExpression();
			case ExpressionsPackage.WHILE_EXPRESSION: return createWhileExpression();
			case ExpressionsPackage.RETURN_EXPRESSION: return createReturnExpression();
			case ExpressionsPackage.SWITCH_EXPRESSION: return createSwitchExpression();
			case ExpressionsPackage.SWITCH_CASE: return createSwitchCase();
			case ExpressionsPackage.EVENT_RAISING_EXPRESSION: return createEventRaisingExpression();
			case ExpressionsPackage.EVENT_VALUE_REFERENCE_EXPRESSION: return createEventValueReferenceExpression();
			case ExpressionsPackage.FOR_EXPRESSION: return createForExpression();
			case ExpressionsPackage.THROW_EXPRESSION: return createThrowExpression();
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
			case ExpressionsPackage.ASSIGNMENT_OPERATOR:
				return createAssignmentOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.SHIFT_OPERATOR:
				return createShiftOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.ADDITIVE_OPERATOR:
				return createAdditiveOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.MULTIPLICATIVE_OPERATOR:
				return createMultiplicativeOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.UNARY_OPERATOR:
				return createUnaryOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.RELATIONAL_OPERATOR:
				return createRelationalOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.LOGICAL_OPERATOR:
				return createLogicalOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.BITWISE_OPERATOR:
				return createBitwiseOperatorFromString(eDataType, initialValue);
			case ExpressionsPackage.POST_FIX_OPERATOR:
				return createPostFixOperatorFromString(eDataType, initialValue);
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
			case ExpressionsPackage.ASSIGNMENT_OPERATOR:
				return convertAssignmentOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.SHIFT_OPERATOR:
				return convertShiftOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.ADDITIVE_OPERATOR:
				return convertAdditiveOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.MULTIPLICATIVE_OPERATOR:
				return convertMultiplicativeOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.UNARY_OPERATOR:
				return convertUnaryOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.RELATIONAL_OPERATOR:
				return convertRelationalOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.LOGICAL_OPERATOR:
				return convertLogicalOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.BITWISE_OPERATOR:
				return convertBitwiseOperatorToString(eDataType, instanceValue);
			case ExpressionsPackage.POST_FIX_OPERATOR:
				return convertPostFixOperatorToString(eDataType, instanceValue);
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
	public BoolLiteral createBoolLiteral() {
		BoolLiteralImpl boolLiteral = new BoolLiteralImpl();
		return boolLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IntLiteral createIntLiteral() {
		IntLiteralImpl intLiteral = new IntLiteralImpl();
		return intLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public DoubleLiteral createDoubleLiteral() {
		DoubleLiteralImpl doubleLiteral = new DoubleLiteralImpl();
		return doubleLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FloatLiteral createFloatLiteral() {
		FloatLiteralImpl floatLiteral = new FloatLiteralImpl();
		return floatLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public HexLiteral createHexLiteral() {
		HexLiteralImpl hexLiteral = new HexLiteralImpl();
		return hexLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BinaryLiteral createBinaryLiteral() {
		BinaryLiteralImpl binaryLiteral = new BinaryLiteralImpl();
		return binaryLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public StringLiteral createStringLiteral() {
		StringLiteralImpl stringLiteral = new StringLiteralImpl();
		return stringLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NullLiteral createNullLiteral() {
		NullLiteralImpl nullLiteral = new NullLiteralImpl();
		return nullLiteral;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public AssignmentExpression createAssignmentExpression() {
		AssignmentExpressionImpl assignmentExpression = new AssignmentExpressionImpl();
		return assignmentExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ConditionalExpression createConditionalExpression() {
		ConditionalExpressionImpl conditionalExpression = new ConditionalExpressionImpl();
		return conditionalExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LogicalOrExpression createLogicalOrExpression() {
		LogicalOrExpressionImpl logicalOrExpression = new LogicalOrExpressionImpl();
		return logicalOrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LogicalAndExpression createLogicalAndExpression() {
		LogicalAndExpressionImpl logicalAndExpression = new LogicalAndExpressionImpl();
		return logicalAndExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LogicalNotExpression createLogicalNotExpression() {
		LogicalNotExpressionImpl logicalNotExpression = new LogicalNotExpressionImpl();
		return logicalNotExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BitwiseXorExpression createBitwiseXorExpression() {
		BitwiseXorExpressionImpl bitwiseXorExpression = new BitwiseXorExpressionImpl();
		return bitwiseXorExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BitwiseOrExpression createBitwiseOrExpression() {
		BitwiseOrExpressionImpl bitwiseOrExpression = new BitwiseOrExpressionImpl();
		return bitwiseOrExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BitwiseAndExpression createBitwiseAndExpression() {
		BitwiseAndExpressionImpl bitwiseAndExpression = new BitwiseAndExpressionImpl();
		return bitwiseAndExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public LogicalRelationExpression createLogicalRelationExpression() {
		LogicalRelationExpressionImpl logicalRelationExpression = new LogicalRelationExpressionImpl();
		return logicalRelationExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ShiftExpression createShiftExpression() {
		ShiftExpressionImpl shiftExpression = new ShiftExpressionImpl();
		return shiftExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumericalAddSubtractExpression createNumericalAddSubtractExpression() {
		NumericalAddSubtractExpressionImpl numericalAddSubtractExpression = new NumericalAddSubtractExpressionImpl();
		return numericalAddSubtractExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumericalMultiplyDivideExpression createNumericalMultiplyDivideExpression() {
		NumericalMultiplyDivideExpressionImpl numericalMultiplyDivideExpression = new NumericalMultiplyDivideExpressionImpl();
		return numericalMultiplyDivideExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NumericalUnaryExpression createNumericalUnaryExpression() {
		NumericalUnaryExpressionImpl numericalUnaryExpression = new NumericalUnaryExpressionImpl();
		return numericalUnaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PrimitiveValueExpression createPrimitiveValueExpression() {
		PrimitiveValueExpressionImpl primitiveValueExpression = new PrimitiveValueExpressionImpl();
		return primitiveValueExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public FeatureCall createFeatureCall() {
		FeatureCallImpl featureCall = new FeatureCallImpl();
		return featureCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public MetaCall createMetaCall() {
		MetaCallImpl metaCall = new MetaCallImpl();
		return metaCall;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ElementReferenceExpression createElementReferenceExpression() {
		ElementReferenceExpressionImpl elementReferenceExpression = new ElementReferenceExpressionImpl();
		return elementReferenceExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ParenthesizedExpression createParenthesizedExpression() {
		ParenthesizedExpressionImpl parenthesizedExpression = new ParenthesizedExpressionImpl();
		return parenthesizedExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public TypeCastExpression createTypeCastExpression() {
		TypeCastExpressionImpl typeCastExpression = new TypeCastExpressionImpl();
		return typeCastExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Argument createArgument() {
		ArgumentImpl argument = new ArgumentImpl();
		return argument;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public IfExpression createIfExpression() {
		IfExpressionImpl ifExpression = new IfExpressionImpl();
		return ifExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public BlockExpression createBlockExpression() {
		BlockExpressionImpl blockExpression = new BlockExpressionImpl();
		return blockExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public WhileExpression createWhileExpression() {
		WhileExpressionImpl whileExpression = new WhileExpressionImpl();
		return whileExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ReturnExpression createReturnExpression() {
		ReturnExpressionImpl returnExpression = new ReturnExpressionImpl();
		return returnExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SwitchExpression createSwitchExpression() {
		SwitchExpressionImpl switchExpression = new SwitchExpressionImpl();
		return switchExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public SwitchCase createSwitchCase() {
		SwitchCaseImpl switchCase = new SwitchCaseImpl();
		return switchCase;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventRaisingExpression createEventRaisingExpression() {
		EventRaisingExpressionImpl eventRaisingExpression = new EventRaisingExpressionImpl();
		return eventRaisingExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EventValueReferenceExpression createEventValueReferenceExpression() {
		EventValueReferenceExpressionImpl eventValueReferenceExpression = new EventValueReferenceExpressionImpl();
		return eventValueReferenceExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ForExpression createForExpression() {
		ForExpressionImpl forExpression = new ForExpressionImpl();
		return forExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ThrowExpression createThrowExpression() {
		ThrowExpressionImpl throwExpression = new ThrowExpressionImpl();
		return throwExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public PostFixUnaryExpression createPostFixUnaryExpression() {
		PostFixUnaryExpressionImpl postFixUnaryExpression = new PostFixUnaryExpressionImpl();
		return postFixUnaryExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AssignmentOperator createAssignmentOperatorFromString(EDataType eDataType, String initialValue) {
		AssignmentOperator result = AssignmentOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAssignmentOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ShiftOperator createShiftOperatorFromString(EDataType eDataType, String initialValue) {
		ShiftOperator result = ShiftOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertShiftOperatorToString(EDataType eDataType, Object instanceValue) {
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
	public LogicalOperator createLogicalOperatorFromString(EDataType eDataType, String initialValue) {
		LogicalOperator result = LogicalOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertLogicalOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public BitwiseOperator createBitwiseOperatorFromString(EDataType eDataType, String initialValue) {
		BitwiseOperator result = BitwiseOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertBitwiseOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PostFixOperator createPostFixOperatorFromString(EDataType eDataType, String initialValue) {
		PostFixOperator result = PostFixOperator.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPostFixOperatorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExpressionsPackage getExpressionsPackage() {
		return (ExpressionsPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ExpressionsPackage getPackage() {
		return ExpressionsPackage.eINSTANCE;
	}

} //ExpressionsFactoryImpl
