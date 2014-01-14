/**
 */
package org.yakindu.base.expressions.expressions;

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
 * @see org.yakindu.base.expressions.expressions.ExpressionsFactory
 * @model kind="package"
 * @generated
 */
public interface ExpressionsPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "expressions";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.yakindu.org/base/expressions/Expressions";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "expressions";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ExpressionsPackage eINSTANCE = org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl.init();

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getExpression()
	 * @generated
	 */
	int EXPRESSION = 0;

	/**
	 * The number of structural features of the '<em>Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESSION_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.LiteralImpl <em>Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.LiteralImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getLiteral()
	 * @generated
	 */
	int LITERAL = 1;

	/**
	 * The number of structural features of the '<em>Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LITERAL_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.BoolLiteralImpl <em>Bool Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.BoolLiteralImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getBoolLiteral()
	 * @generated
	 */
	int BOOL_LITERAL = 2;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Bool Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BOOL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.IntLiteralImpl <em>Int Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.IntLiteralImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getIntLiteral()
	 * @generated
	 */
	int INT_LITERAL = 3;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Int Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int INT_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.RealLiteralImpl <em>Real Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.RealLiteralImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getRealLiteral()
	 * @generated
	 */
	int REAL_LITERAL = 4;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Real Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REAL_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.HexLiteralImpl <em>Hex Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.HexLiteralImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getHexLiteral()
	 * @generated
	 */
	int HEX_LITERAL = 5;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEX_LITERAL__VALUE = LITERAL_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Hex Literal</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int HEX_LITERAL_FEATURE_COUNT = LITERAL_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.StringLiteralImpl <em>String Literal</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.StringLiteralImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getStringLiteral()
	 * @generated
	 */
	int STRING_LITERAL = 6;

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
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.AssignmentExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getAssignmentExpression()
	 * @generated
	 */
	int ASSIGNMENT_EXPRESSION = 7;

	/**
	 * The feature id for the '<em><b>Var Ref</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION__VAR_REF = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION__EXPRESSION = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Assignment Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ASSIGNMENT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.ConditionalExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getConditionalExpression()
	 * @generated
	 */
	int CONDITIONAL_EXPRESSION = 8;

	/**
	 * The feature id for the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EXPRESSION__CONDITION = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>True Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EXPRESSION__TRUE_CASE = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>False Case</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EXPRESSION__FALSE_CASE = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Conditional Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONDITIONAL_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.LogicalOrExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getLogicalOrExpression()
	 * @generated
	 */
	int LOGICAL_OR_EXPRESSION = 9;

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
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.LogicalAndExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getLogicalAndExpression()
	 * @generated
	 */
	int LOGICAL_AND_EXPRESSION = 10;

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
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.LogicalNotExpressionImpl <em>Logical Not Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.LogicalNotExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getLogicalNotExpression()
	 * @generated
	 */
	int LOGICAL_NOT_EXPRESSION = 11;

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
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.BitwiseXorExpressionImpl <em>Bitwise Xor Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.BitwiseXorExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getBitwiseXorExpression()
	 * @generated
	 */
	int BITWISE_XOR_EXPRESSION = 12;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_XOR_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_XOR_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bitwise Xor Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_XOR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.BitwiseOrExpressionImpl <em>Bitwise Or Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.BitwiseOrExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getBitwiseOrExpression()
	 * @generated
	 */
	int BITWISE_OR_EXPRESSION = 13;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_OR_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_OR_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bitwise Or Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_OR_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.BitwiseAndExpressionImpl <em>Bitwise And Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.BitwiseAndExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getBitwiseAndExpression()
	 * @generated
	 */
	int BITWISE_AND_EXPRESSION = 14;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_AND_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_AND_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Bitwise And Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int BITWISE_AND_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.LogicalRelationExpressionImpl <em>Logical Relation Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.LogicalRelationExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getLogicalRelationExpression()
	 * @generated
	 */
	int LOGICAL_RELATION_EXPRESSION = 15;

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
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.ShiftExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getShiftExpression()
	 * @generated
	 */
	int SHIFT_EXPRESSION = 16;

	/**
	 * The feature id for the '<em><b>Left Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIFT_EXPRESSION__LEFT_OPERAND = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operator</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIFT_EXPRESSION__OPERATOR = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Right Operand</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIFT_EXPRESSION__RIGHT_OPERAND = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Shift Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SHIFT_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.NumericalAddSubtractExpressionImpl <em>Numerical Add Subtract Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.NumericalAddSubtractExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getNumericalAddSubtractExpression()
	 * @generated
	 */
	int NUMERICAL_ADD_SUBTRACT_EXPRESSION = 17;

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
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.NumericalMultiplyDivideExpressionImpl <em>Numerical Multiply Divide Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.NumericalMultiplyDivideExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getNumericalMultiplyDivideExpression()
	 * @generated
	 */
	int NUMERICAL_MULTIPLY_DIVIDE_EXPRESSION = 18;

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
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.NumericalUnaryExpressionImpl <em>Numerical Unary Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.NumericalUnaryExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getNumericalUnaryExpression()
	 * @generated
	 */
	int NUMERICAL_UNARY_EXPRESSION = 19;

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
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.PrimitiveValueExpressionImpl <em>Primitive Value Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.PrimitiveValueExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getPrimitiveValueExpression()
	 * @generated
	 */
	int PRIMITIVE_VALUE_EXPRESSION = 20;

	/**
	 * The feature id for the '<em><b>Value</b></em>' containment reference.
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
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.FeatureCallImpl <em>Feature Call</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.FeatureCallImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getFeatureCall()
	 * @generated
	 */
	int FEATURE_CALL = 21;

	/**
	 * The feature id for the '<em><b>Owner</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL__OWNER = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Feature</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL__FEATURE = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Operation Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL__OPERATION_CALL = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The feature id for the '<em><b>Args</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL__ARGS = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The number of structural features of the '<em>Feature Call</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FEATURE_CALL_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 4;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.ElementReferenceExpressionImpl <em>Element Reference Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.ElementReferenceExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getElementReferenceExpression()
	 * @generated
	 */
	int ELEMENT_REFERENCE_EXPRESSION = 22;

	/**
	 * The feature id for the '<em><b>Reference</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REFERENCE_EXPRESSION__REFERENCE = EXPRESSION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Operation Call</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REFERENCE_EXPRESSION__OPERATION_CALL = EXPRESSION_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Args</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REFERENCE_EXPRESSION__ARGS = EXPRESSION_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Element Reference Expression</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_REFERENCE_EXPRESSION_FEATURE_COUNT = EXPRESSION_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.impl.ParenthesizedExpressionImpl <em>Parenthesized Expression</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.impl.ParenthesizedExpressionImpl
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getParenthesizedExpression()
	 * @generated
	 */
	int PARENTHESIZED_EXPRESSION = 23;

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
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.AssignmentOperator <em>Assignment Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.AssignmentOperator
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getAssignmentOperator()
	 * @generated
	 */
	int ASSIGNMENT_OPERATOR = 24;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.ShiftOperator <em>Shift Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.ShiftOperator
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getShiftOperator()
	 * @generated
	 */
	int SHIFT_OPERATOR = 25;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.AdditiveOperator <em>Additive Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.AdditiveOperator
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getAdditiveOperator()
	 * @generated
	 */
	int ADDITIVE_OPERATOR = 26;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.MultiplicativeOperator
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getMultiplicativeOperator()
	 * @generated
	 */
	int MULTIPLICATIVE_OPERATOR = 27;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.UnaryOperator <em>Unary Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.UnaryOperator
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getUnaryOperator()
	 * @generated
	 */
	int UNARY_OPERATOR = 28;

	/**
	 * The meta object id for the '{@link org.yakindu.base.expressions.expressions.RelationalOperator <em>Relational Operator</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.yakindu.base.expressions.expressions.RelationalOperator
	 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getRelationalOperator()
	 * @generated
	 */
	int RELATIONAL_OPERATOR = 29;


	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.Expression
	 * @generated
	 */
	EClass getExpression();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Literal</em>'.
	 * @see org.yakindu.base.expressions.expressions.Literal
	 * @generated
	 */
	EClass getLiteral();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.BoolLiteral <em>Bool Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bool Literal</em>'.
	 * @see org.yakindu.base.expressions.expressions.BoolLiteral
	 * @generated
	 */
	EClass getBoolLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.BoolLiteral#isValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.base.expressions.expressions.BoolLiteral#isValue()
	 * @see #getBoolLiteral()
	 * @generated
	 */
	EAttribute getBoolLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.IntLiteral <em>Int Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Int Literal</em>'.
	 * @see org.yakindu.base.expressions.expressions.IntLiteral
	 * @generated
	 */
	EClass getIntLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.IntLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.base.expressions.expressions.IntLiteral#getValue()
	 * @see #getIntLiteral()
	 * @generated
	 */
	EAttribute getIntLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.RealLiteral <em>Real Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Real Literal</em>'.
	 * @see org.yakindu.base.expressions.expressions.RealLiteral
	 * @generated
	 */
	EClass getRealLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.RealLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.base.expressions.expressions.RealLiteral#getValue()
	 * @see #getRealLiteral()
	 * @generated
	 */
	EAttribute getRealLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.HexLiteral <em>Hex Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Hex Literal</em>'.
	 * @see org.yakindu.base.expressions.expressions.HexLiteral
	 * @generated
	 */
	EClass getHexLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.HexLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.base.expressions.expressions.HexLiteral#getValue()
	 * @see #getHexLiteral()
	 * @generated
	 */
	EAttribute getHexLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>String Literal</em>'.
	 * @see org.yakindu.base.expressions.expressions.StringLiteral
	 * @generated
	 */
	EClass getStringLiteral();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.StringLiteral#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see org.yakindu.base.expressions.expressions.StringLiteral#getValue()
	 * @see #getStringLiteral()
	 * @generated
	 */
	EAttribute getStringLiteral_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.AssignmentExpression <em>Assignment Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Assignment Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.AssignmentExpression
	 * @generated
	 */
	EClass getAssignmentExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.AssignmentExpression#getVarRef <em>Var Ref</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Var Ref</em>'.
	 * @see org.yakindu.base.expressions.expressions.AssignmentExpression#getVarRef()
	 * @see #getAssignmentExpression()
	 * @generated
	 */
	EReference getAssignmentExpression_VarRef();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.AssignmentExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.yakindu.base.expressions.expressions.AssignmentExpression#getOperator()
	 * @see #getAssignmentExpression()
	 * @generated
	 */
	EAttribute getAssignmentExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.AssignmentExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.AssignmentExpression#getExpression()
	 * @see #getAssignmentExpression()
	 * @generated
	 */
	EReference getAssignmentExpression_Expression();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.ConditionalExpression <em>Conditional Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Conditional Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.ConditionalExpression
	 * @generated
	 */
	EClass getConditionalExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.ConditionalExpression#getCondition <em>Condition</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Condition</em>'.
	 * @see org.yakindu.base.expressions.expressions.ConditionalExpression#getCondition()
	 * @see #getConditionalExpression()
	 * @generated
	 */
	EReference getConditionalExpression_Condition();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.ConditionalExpression#getTrueCase <em>True Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>True Case</em>'.
	 * @see org.yakindu.base.expressions.expressions.ConditionalExpression#getTrueCase()
	 * @see #getConditionalExpression()
	 * @generated
	 */
	EReference getConditionalExpression_TrueCase();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.ConditionalExpression#getFalseCase <em>False Case</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>False Case</em>'.
	 * @see org.yakindu.base.expressions.expressions.ConditionalExpression#getFalseCase()
	 * @see #getConditionalExpression()
	 * @generated
	 */
	EReference getConditionalExpression_FalseCase();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.LogicalOrExpression <em>Logical Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Or Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.LogicalOrExpression
	 * @generated
	 */
	EClass getLogicalOrExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.LogicalOrExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.LogicalOrExpression#getLeftOperand()
	 * @see #getLogicalOrExpression()
	 * @generated
	 */
	EReference getLogicalOrExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.LogicalOrExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.LogicalOrExpression#getRightOperand()
	 * @see #getLogicalOrExpression()
	 * @generated
	 */
	EReference getLogicalOrExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.LogicalAndExpression <em>Logical And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical And Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.LogicalAndExpression
	 * @generated
	 */
	EClass getLogicalAndExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.LogicalAndExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.LogicalAndExpression#getLeftOperand()
	 * @see #getLogicalAndExpression()
	 * @generated
	 */
	EReference getLogicalAndExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.LogicalAndExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.LogicalAndExpression#getRightOperand()
	 * @see #getLogicalAndExpression()
	 * @generated
	 */
	EReference getLogicalAndExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.LogicalNotExpression <em>Logical Not Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Not Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.LogicalNotExpression
	 * @generated
	 */
	EClass getLogicalNotExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.LogicalNotExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.LogicalNotExpression#getOperand()
	 * @see #getLogicalNotExpression()
	 * @generated
	 */
	EReference getLogicalNotExpression_Operand();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.BitwiseXorExpression <em>Bitwise Xor Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bitwise Xor Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.BitwiseXorExpression
	 * @generated
	 */
	EClass getBitwiseXorExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.BitwiseXorExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.BitwiseXorExpression#getLeftOperand()
	 * @see #getBitwiseXorExpression()
	 * @generated
	 */
	EReference getBitwiseXorExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.BitwiseXorExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.BitwiseXorExpression#getRightOperand()
	 * @see #getBitwiseXorExpression()
	 * @generated
	 */
	EReference getBitwiseXorExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.BitwiseOrExpression <em>Bitwise Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bitwise Or Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.BitwiseOrExpression
	 * @generated
	 */
	EClass getBitwiseOrExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.BitwiseOrExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.BitwiseOrExpression#getLeftOperand()
	 * @see #getBitwiseOrExpression()
	 * @generated
	 */
	EReference getBitwiseOrExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.BitwiseOrExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.BitwiseOrExpression#getRightOperand()
	 * @see #getBitwiseOrExpression()
	 * @generated
	 */
	EReference getBitwiseOrExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.BitwiseAndExpression <em>Bitwise And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Bitwise And Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.BitwiseAndExpression
	 * @generated
	 */
	EClass getBitwiseAndExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.BitwiseAndExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.BitwiseAndExpression#getLeftOperand()
	 * @see #getBitwiseAndExpression()
	 * @generated
	 */
	EReference getBitwiseAndExpression_LeftOperand();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.BitwiseAndExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.BitwiseAndExpression#getRightOperand()
	 * @see #getBitwiseAndExpression()
	 * @generated
	 */
	EReference getBitwiseAndExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.LogicalRelationExpression <em>Logical Relation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Logical Relation Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.LogicalRelationExpression
	 * @generated
	 */
	EClass getLogicalRelationExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.LogicalRelationExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.LogicalRelationExpression#getLeftOperand()
	 * @see #getLogicalRelationExpression()
	 * @generated
	 */
	EReference getLogicalRelationExpression_LeftOperand();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.LogicalRelationExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.yakindu.base.expressions.expressions.LogicalRelationExpression#getOperator()
	 * @see #getLogicalRelationExpression()
	 * @generated
	 */
	EAttribute getLogicalRelationExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.LogicalRelationExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.LogicalRelationExpression#getRightOperand()
	 * @see #getLogicalRelationExpression()
	 * @generated
	 */
	EReference getLogicalRelationExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.ShiftExpression <em>Shift Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Shift Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.ShiftExpression
	 * @generated
	 */
	EClass getShiftExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.ShiftExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.ShiftExpression#getLeftOperand()
	 * @see #getShiftExpression()
	 * @generated
	 */
	EReference getShiftExpression_LeftOperand();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.ShiftExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.yakindu.base.expressions.expressions.ShiftExpression#getOperator()
	 * @see #getShiftExpression()
	 * @generated
	 */
	EAttribute getShiftExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.ShiftExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.ShiftExpression#getRightOperand()
	 * @see #getShiftExpression()
	 * @generated
	 */
	EReference getShiftExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression <em>Numerical Add Subtract Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numerical Add Subtract Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
	 * @generated
	 */
	EClass getNumericalAddSubtractExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression#getLeftOperand()
	 * @see #getNumericalAddSubtractExpression()
	 * @generated
	 */
	EReference getNumericalAddSubtractExpression_LeftOperand();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression#getOperator()
	 * @see #getNumericalAddSubtractExpression()
	 * @generated
	 */
	EAttribute getNumericalAddSubtractExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression#getRightOperand()
	 * @see #getNumericalAddSubtractExpression()
	 * @generated
	 */
	EReference getNumericalAddSubtractExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression <em>Numerical Multiply Divide Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numerical Multiply Divide Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
	 * @generated
	 */
	EClass getNumericalMultiplyDivideExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression#getLeftOperand <em>Left Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Left Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression#getLeftOperand()
	 * @see #getNumericalMultiplyDivideExpression()
	 * @generated
	 */
	EReference getNumericalMultiplyDivideExpression_LeftOperand();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression#getOperator()
	 * @see #getNumericalMultiplyDivideExpression()
	 * @generated
	 */
	EAttribute getNumericalMultiplyDivideExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression#getRightOperand <em>Right Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Right Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression#getRightOperand()
	 * @see #getNumericalMultiplyDivideExpression()
	 * @generated
	 */
	EReference getNumericalMultiplyDivideExpression_RightOperand();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.NumericalUnaryExpression <em>Numerical Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Numerical Unary Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.NumericalUnaryExpression
	 * @generated
	 */
	EClass getNumericalUnaryExpression();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.NumericalUnaryExpression#getOperator <em>Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operator</em>'.
	 * @see org.yakindu.base.expressions.expressions.NumericalUnaryExpression#getOperator()
	 * @see #getNumericalUnaryExpression()
	 * @generated
	 */
	EAttribute getNumericalUnaryExpression_Operator();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.NumericalUnaryExpression#getOperand <em>Operand</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Operand</em>'.
	 * @see org.yakindu.base.expressions.expressions.NumericalUnaryExpression#getOperand()
	 * @see #getNumericalUnaryExpression()
	 * @generated
	 */
	EReference getNumericalUnaryExpression_Operand();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.PrimitiveValueExpression <em>Primitive Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Primitive Value Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.PrimitiveValueExpression
	 * @generated
	 */
	EClass getPrimitiveValueExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.PrimitiveValueExpression#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Value</em>'.
	 * @see org.yakindu.base.expressions.expressions.PrimitiveValueExpression#getValue()
	 * @see #getPrimitiveValueExpression()
	 * @generated
	 */
	EReference getPrimitiveValueExpression_Value();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.FeatureCall <em>Feature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Feature Call</em>'.
	 * @see org.yakindu.base.expressions.expressions.FeatureCall
	 * @generated
	 */
	EClass getFeatureCall();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.FeatureCall#getOwner <em>Owner</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Owner</em>'.
	 * @see org.yakindu.base.expressions.expressions.FeatureCall#getOwner()
	 * @see #getFeatureCall()
	 * @generated
	 */
	EReference getFeatureCall_Owner();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.base.expressions.expressions.FeatureCall#getFeature <em>Feature</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Feature</em>'.
	 * @see org.yakindu.base.expressions.expressions.FeatureCall#getFeature()
	 * @see #getFeatureCall()
	 * @generated
	 */
	EReference getFeatureCall_Feature();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.FeatureCall#isOperationCall <em>Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation Call</em>'.
	 * @see org.yakindu.base.expressions.expressions.FeatureCall#isOperationCall()
	 * @see #getFeatureCall()
	 * @generated
	 */
	EAttribute getFeatureCall_OperationCall();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.base.expressions.expressions.FeatureCall#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Args</em>'.
	 * @see org.yakindu.base.expressions.expressions.FeatureCall#getArgs()
	 * @see #getFeatureCall()
	 * @generated
	 */
	EReference getFeatureCall_Args();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.ElementReferenceExpression <em>Element Reference Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Reference Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.ElementReferenceExpression
	 * @generated
	 */
	EClass getElementReferenceExpression();

	/**
	 * Returns the meta object for the reference '{@link org.yakindu.base.expressions.expressions.ElementReferenceExpression#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Reference</em>'.
	 * @see org.yakindu.base.expressions.expressions.ElementReferenceExpression#getReference()
	 * @see #getElementReferenceExpression()
	 * @generated
	 */
	EReference getElementReferenceExpression_Reference();

	/**
	 * Returns the meta object for the attribute '{@link org.yakindu.base.expressions.expressions.ElementReferenceExpression#isOperationCall <em>Operation Call</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Operation Call</em>'.
	 * @see org.yakindu.base.expressions.expressions.ElementReferenceExpression#isOperationCall()
	 * @see #getElementReferenceExpression()
	 * @generated
	 */
	EAttribute getElementReferenceExpression_OperationCall();

	/**
	 * Returns the meta object for the containment reference list '{@link org.yakindu.base.expressions.expressions.ElementReferenceExpression#getArgs <em>Args</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Args</em>'.
	 * @see org.yakindu.base.expressions.expressions.ElementReferenceExpression#getArgs()
	 * @see #getElementReferenceExpression()
	 * @generated
	 */
	EReference getElementReferenceExpression_Args();

	/**
	 * Returns the meta object for class '{@link org.yakindu.base.expressions.expressions.ParenthesizedExpression <em>Parenthesized Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Parenthesized Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.ParenthesizedExpression
	 * @generated
	 */
	EClass getParenthesizedExpression();

	/**
	 * Returns the meta object for the containment reference '{@link org.yakindu.base.expressions.expressions.ParenthesizedExpression#getExpression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Expression</em>'.
	 * @see org.yakindu.base.expressions.expressions.ParenthesizedExpression#getExpression()
	 * @see #getParenthesizedExpression()
	 * @generated
	 */
	EReference getParenthesizedExpression_Expression();

	/**
	 * Returns the meta object for enum '{@link org.yakindu.base.expressions.expressions.AssignmentOperator <em>Assignment Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Assignment Operator</em>'.
	 * @see org.yakindu.base.expressions.expressions.AssignmentOperator
	 * @generated
	 */
	EEnum getAssignmentOperator();

	/**
	 * Returns the meta object for enum '{@link org.yakindu.base.expressions.expressions.ShiftOperator <em>Shift Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Shift Operator</em>'.
	 * @see org.yakindu.base.expressions.expressions.ShiftOperator
	 * @generated
	 */
	EEnum getShiftOperator();

	/**
	 * Returns the meta object for enum '{@link org.yakindu.base.expressions.expressions.AdditiveOperator <em>Additive Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Additive Operator</em>'.
	 * @see org.yakindu.base.expressions.expressions.AdditiveOperator
	 * @generated
	 */
	EEnum getAdditiveOperator();

	/**
	 * Returns the meta object for enum '{@link org.yakindu.base.expressions.expressions.MultiplicativeOperator <em>Multiplicative Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Multiplicative Operator</em>'.
	 * @see org.yakindu.base.expressions.expressions.MultiplicativeOperator
	 * @generated
	 */
	EEnum getMultiplicativeOperator();

	/**
	 * Returns the meta object for enum '{@link org.yakindu.base.expressions.expressions.UnaryOperator <em>Unary Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Unary Operator</em>'.
	 * @see org.yakindu.base.expressions.expressions.UnaryOperator
	 * @generated
	 */
	EEnum getUnaryOperator();

	/**
	 * Returns the meta object for enum '{@link org.yakindu.base.expressions.expressions.RelationalOperator <em>Relational Operator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Relational Operator</em>'.
	 * @see org.yakindu.base.expressions.expressions.RelationalOperator
	 * @generated
	 */
	EEnum getRelationalOperator();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ExpressionsFactory getExpressionsFactory();

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
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.ExpressionImpl <em>Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getExpression()
		 * @generated
		 */
		EClass EXPRESSION = eINSTANCE.getExpression();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.LiteralImpl <em>Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.LiteralImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getLiteral()
		 * @generated
		 */
		EClass LITERAL = eINSTANCE.getLiteral();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.BoolLiteralImpl <em>Bool Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.BoolLiteralImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getBoolLiteral()
		 * @generated
		 */
		EClass BOOL_LITERAL = eINSTANCE.getBoolLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute BOOL_LITERAL__VALUE = eINSTANCE.getBoolLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.IntLiteralImpl <em>Int Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.IntLiteralImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getIntLiteral()
		 * @generated
		 */
		EClass INT_LITERAL = eINSTANCE.getIntLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute INT_LITERAL__VALUE = eINSTANCE.getIntLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.RealLiteralImpl <em>Real Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.RealLiteralImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getRealLiteral()
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
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.HexLiteralImpl <em>Hex Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.HexLiteralImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getHexLiteral()
		 * @generated
		 */
		EClass HEX_LITERAL = eINSTANCE.getHexLiteral();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute HEX_LITERAL__VALUE = eINSTANCE.getHexLiteral_Value();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.StringLiteralImpl <em>String Literal</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.StringLiteralImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getStringLiteral()
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
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.AssignmentExpressionImpl <em>Assignment Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.AssignmentExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getAssignmentExpression()
		 * @generated
		 */
		EClass ASSIGNMENT_EXPRESSION = eINSTANCE.getAssignmentExpression();

		/**
		 * The meta object literal for the '<em><b>Var Ref</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_EXPRESSION__VAR_REF = eINSTANCE.getAssignmentExpression_VarRef();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ASSIGNMENT_EXPRESSION__OPERATOR = eINSTANCE.getAssignmentExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Expression</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ASSIGNMENT_EXPRESSION__EXPRESSION = eINSTANCE.getAssignmentExpression_Expression();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.ConditionalExpressionImpl <em>Conditional Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.ConditionalExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getConditionalExpression()
		 * @generated
		 */
		EClass CONDITIONAL_EXPRESSION = eINSTANCE.getConditionalExpression();

		/**
		 * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_EXPRESSION__CONDITION = eINSTANCE.getConditionalExpression_Condition();

		/**
		 * The meta object literal for the '<em><b>True Case</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_EXPRESSION__TRUE_CASE = eINSTANCE.getConditionalExpression_TrueCase();

		/**
		 * The meta object literal for the '<em><b>False Case</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONDITIONAL_EXPRESSION__FALSE_CASE = eINSTANCE.getConditionalExpression_FalseCase();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.LogicalOrExpressionImpl <em>Logical Or Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.LogicalOrExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getLogicalOrExpression()
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
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.LogicalAndExpressionImpl <em>Logical And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.LogicalAndExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getLogicalAndExpression()
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
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.LogicalNotExpressionImpl <em>Logical Not Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.LogicalNotExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getLogicalNotExpression()
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
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.BitwiseXorExpressionImpl <em>Bitwise Xor Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.BitwiseXorExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getBitwiseXorExpression()
		 * @generated
		 */
		EClass BITWISE_XOR_EXPRESSION = eINSTANCE.getBitwiseXorExpression();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BITWISE_XOR_EXPRESSION__LEFT_OPERAND = eINSTANCE.getBitwiseXorExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BITWISE_XOR_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getBitwiseXorExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.BitwiseOrExpressionImpl <em>Bitwise Or Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.BitwiseOrExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getBitwiseOrExpression()
		 * @generated
		 */
		EClass BITWISE_OR_EXPRESSION = eINSTANCE.getBitwiseOrExpression();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BITWISE_OR_EXPRESSION__LEFT_OPERAND = eINSTANCE.getBitwiseOrExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BITWISE_OR_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getBitwiseOrExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.BitwiseAndExpressionImpl <em>Bitwise And Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.BitwiseAndExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getBitwiseAndExpression()
		 * @generated
		 */
		EClass BITWISE_AND_EXPRESSION = eINSTANCE.getBitwiseAndExpression();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BITWISE_AND_EXPRESSION__LEFT_OPERAND = eINSTANCE.getBitwiseAndExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference BITWISE_AND_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getBitwiseAndExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.LogicalRelationExpressionImpl <em>Logical Relation Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.LogicalRelationExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getLogicalRelationExpression()
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
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.ShiftExpressionImpl <em>Shift Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.ShiftExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getShiftExpression()
		 * @generated
		 */
		EClass SHIFT_EXPRESSION = eINSTANCE.getShiftExpression();

		/**
		 * The meta object literal for the '<em><b>Left Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHIFT_EXPRESSION__LEFT_OPERAND = eINSTANCE.getShiftExpression_LeftOperand();

		/**
		 * The meta object literal for the '<em><b>Operator</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute SHIFT_EXPRESSION__OPERATOR = eINSTANCE.getShiftExpression_Operator();

		/**
		 * The meta object literal for the '<em><b>Right Operand</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SHIFT_EXPRESSION__RIGHT_OPERAND = eINSTANCE.getShiftExpression_RightOperand();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.NumericalAddSubtractExpressionImpl <em>Numerical Add Subtract Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.NumericalAddSubtractExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getNumericalAddSubtractExpression()
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
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.NumericalMultiplyDivideExpressionImpl <em>Numerical Multiply Divide Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.NumericalMultiplyDivideExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getNumericalMultiplyDivideExpression()
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
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.NumericalUnaryExpressionImpl <em>Numerical Unary Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.NumericalUnaryExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getNumericalUnaryExpression()
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
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.PrimitiveValueExpressionImpl <em>Primitive Value Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.PrimitiveValueExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getPrimitiveValueExpression()
		 * @generated
		 */
		EClass PRIMITIVE_VALUE_EXPRESSION = eINSTANCE.getPrimitiveValueExpression();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PRIMITIVE_VALUE_EXPRESSION__VALUE = eINSTANCE.getPrimitiveValueExpression_Value();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.FeatureCallImpl <em>Feature Call</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.FeatureCallImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getFeatureCall()
		 * @generated
		 */
		EClass FEATURE_CALL = eINSTANCE.getFeatureCall();

		/**
		 * The meta object literal for the '<em><b>Owner</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CALL__OWNER = eINSTANCE.getFeatureCall_Owner();

		/**
		 * The meta object literal for the '<em><b>Feature</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CALL__FEATURE = eINSTANCE.getFeatureCall_Feature();

		/**
		 * The meta object literal for the '<em><b>Operation Call</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FEATURE_CALL__OPERATION_CALL = eINSTANCE.getFeatureCall_OperationCall();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FEATURE_CALL__ARGS = eINSTANCE.getFeatureCall_Args();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.ElementReferenceExpressionImpl <em>Element Reference Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.ElementReferenceExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getElementReferenceExpression()
		 * @generated
		 */
		EClass ELEMENT_REFERENCE_EXPRESSION = eINSTANCE.getElementReferenceExpression();

		/**
		 * The meta object literal for the '<em><b>Reference</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_REFERENCE_EXPRESSION__REFERENCE = eINSTANCE.getElementReferenceExpression_Reference();

		/**
		 * The meta object literal for the '<em><b>Operation Call</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_REFERENCE_EXPRESSION__OPERATION_CALL = eINSTANCE.getElementReferenceExpression_OperationCall();

		/**
		 * The meta object literal for the '<em><b>Args</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_REFERENCE_EXPRESSION__ARGS = eINSTANCE.getElementReferenceExpression_Args();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.impl.ParenthesizedExpressionImpl <em>Parenthesized Expression</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.impl.ParenthesizedExpressionImpl
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getParenthesizedExpression()
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
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.AssignmentOperator <em>Assignment Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.AssignmentOperator
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getAssignmentOperator()
		 * @generated
		 */
		EEnum ASSIGNMENT_OPERATOR = eINSTANCE.getAssignmentOperator();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.ShiftOperator <em>Shift Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.ShiftOperator
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getShiftOperator()
		 * @generated
		 */
		EEnum SHIFT_OPERATOR = eINSTANCE.getShiftOperator();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.AdditiveOperator <em>Additive Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.AdditiveOperator
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getAdditiveOperator()
		 * @generated
		 */
		EEnum ADDITIVE_OPERATOR = eINSTANCE.getAdditiveOperator();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.MultiplicativeOperator <em>Multiplicative Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.MultiplicativeOperator
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getMultiplicativeOperator()
		 * @generated
		 */
		EEnum MULTIPLICATIVE_OPERATOR = eINSTANCE.getMultiplicativeOperator();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.UnaryOperator <em>Unary Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.UnaryOperator
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getUnaryOperator()
		 * @generated
		 */
		EEnum UNARY_OPERATOR = eINSTANCE.getUnaryOperator();

		/**
		 * The meta object literal for the '{@link org.yakindu.base.expressions.expressions.RelationalOperator <em>Relational Operator</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see org.yakindu.base.expressions.expressions.RelationalOperator
		 * @see org.yakindu.base.expressions.expressions.impl.ExpressionsPackageImpl#getRelationalOperator()
		 * @generated
		 */
		EEnum RELATIONAL_OPERATOR = eINSTANCE.getRelationalOperator();

	}

} //ExpressionsPackage
