/**
 */
package org.yakindu.base.expressions.expressions.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.yakindu.base.expressions.expressions.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage
 * @generated
 */
public class ExpressionsAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ExpressionsPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressionsAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ExpressionsPackage.eINSTANCE;
		}
	}

	/**
	 * Returns whether this factory is applicable for the type of the object.
	 * <!-- begin-user-doc -->
	 * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
	 * <!-- end-user-doc -->
	 * @return whether this factory is applicable for the type of the object.
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object object) {
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
			return ((EObject)object).eClass().getEPackage() == modelPackage;
		}
		return false;
	}

	/**
	 * The switch that delegates to the <code>createXXX</code> methods.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExpressionsSwitch<Adapter> modelSwitch =
		new ExpressionsSwitch<Adapter>() {
			@Override
			public Adapter caseExpression(Expression object) {
				return createExpressionAdapter();
			}
			@Override
			public Adapter caseLiteral(Literal object) {
				return createLiteralAdapter();
			}
			@Override
			public Adapter caseBoolLiteral(BoolLiteral object) {
				return createBoolLiteralAdapter();
			}
			@Override
			public Adapter caseIntLiteral(IntLiteral object) {
				return createIntLiteralAdapter();
			}
			@Override
			public Adapter caseDoubleLiteral(DoubleLiteral object) {
				return createDoubleLiteralAdapter();
			}
			@Override
			public Adapter caseFloatLiteral(FloatLiteral object) {
				return createFloatLiteralAdapter();
			}
			@Override
			public Adapter caseHexLiteral(HexLiteral object) {
				return createHexLiteralAdapter();
			}
			@Override
			public Adapter caseStringLiteral(StringLiteral object) {
				return createStringLiteralAdapter();
			}
			@Override
			public Adapter caseNullLiteral(NullLiteral object) {
				return createNullLiteralAdapter();
			}
			@Override
			public Adapter caseAssignmentExpression(AssignmentExpression object) {
				return createAssignmentExpressionAdapter();
			}
			@Override
			public Adapter caseConditionalExpression(ConditionalExpression object) {
				return createConditionalExpressionAdapter();
			}
			@Override
			public Adapter caseLogicalOrExpression(LogicalOrExpression object) {
				return createLogicalOrExpressionAdapter();
			}
			@Override
			public Adapter caseLogicalAndExpression(LogicalAndExpression object) {
				return createLogicalAndExpressionAdapter();
			}
			@Override
			public Adapter caseLogicalNotExpression(LogicalNotExpression object) {
				return createLogicalNotExpressionAdapter();
			}
			@Override
			public Adapter caseBitwiseXorExpression(BitwiseXorExpression object) {
				return createBitwiseXorExpressionAdapter();
			}
			@Override
			public Adapter caseBitwiseOrExpression(BitwiseOrExpression object) {
				return createBitwiseOrExpressionAdapter();
			}
			@Override
			public Adapter caseBitwiseAndExpression(BitwiseAndExpression object) {
				return createBitwiseAndExpressionAdapter();
			}
			@Override
			public Adapter caseLogicalRelationExpression(LogicalRelationExpression object) {
				return createLogicalRelationExpressionAdapter();
			}
			@Override
			public Adapter caseShiftExpression(ShiftExpression object) {
				return createShiftExpressionAdapter();
			}
			@Override
			public Adapter caseNumericalAddSubtractExpression(NumericalAddSubtractExpression object) {
				return createNumericalAddSubtractExpressionAdapter();
			}
			@Override
			public Adapter caseNumericalMultiplyDivideExpression(NumericalMultiplyDivideExpression object) {
				return createNumericalMultiplyDivideExpressionAdapter();
			}
			@Override
			public Adapter caseNumericalUnaryExpression(NumericalUnaryExpression object) {
				return createNumericalUnaryExpressionAdapter();
			}
			@Override
			public Adapter casePrimitiveValueExpression(PrimitiveValueExpression object) {
				return createPrimitiveValueExpressionAdapter();
			}
			@Override
			public Adapter caseFeatureCall(FeatureCall object) {
				return createFeatureCallAdapter();
			}
			@Override
			public Adapter caseElementReferenceExpression(ElementReferenceExpression object) {
				return createElementReferenceExpressionAdapter();
			}
			@Override
			public Adapter caseParenthesizedExpression(ParenthesizedExpression object) {
				return createParenthesizedExpressionAdapter();
			}
			@Override
			public Adapter caseTypeCastExpression(TypeCastExpression object) {
				return createTypeCastExpressionAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
				return createEObjectAdapter();
			}
		};

	/**
	 * Creates an adapter for the <code>target</code>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param target the object to adapt.
	 * @return the adapter for the <code>target</code>.
	 * @generated
	 */
	@Override
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.Expression <em>Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.Expression
	 * @generated
	 */
	public Adapter createExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.Literal <em>Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.Literal
	 * @generated
	 */
	public Adapter createLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.BoolLiteral <em>Bool Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.BoolLiteral
	 * @generated
	 */
	public Adapter createBoolLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.IntLiteral <em>Int Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.IntLiteral
	 * @generated
	 */
	public Adapter createIntLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.DoubleLiteral <em>Double Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.DoubleLiteral
	 * @generated
	 */
	public Adapter createDoubleLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.FloatLiteral <em>Float Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.FloatLiteral
	 * @generated
	 */
	public Adapter createFloatLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.HexLiteral <em>Hex Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.HexLiteral
	 * @generated
	 */
	public Adapter createHexLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.StringLiteral <em>String Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.StringLiteral
	 * @generated
	 */
	public Adapter createStringLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.NullLiteral <em>Null Literal</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.NullLiteral
	 * @generated
	 */
	public Adapter createNullLiteralAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.AssignmentExpression <em>Assignment Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.AssignmentExpression
	 * @generated
	 */
	public Adapter createAssignmentExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.ConditionalExpression <em>Conditional Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.ConditionalExpression
	 * @generated
	 */
	public Adapter createConditionalExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.LogicalOrExpression <em>Logical Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.LogicalOrExpression
	 * @generated
	 */
	public Adapter createLogicalOrExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.LogicalAndExpression <em>Logical And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.LogicalAndExpression
	 * @generated
	 */
	public Adapter createLogicalAndExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.LogicalNotExpression <em>Logical Not Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.LogicalNotExpression
	 * @generated
	 */
	public Adapter createLogicalNotExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.BitwiseXorExpression <em>Bitwise Xor Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.BitwiseXorExpression
	 * @generated
	 */
	public Adapter createBitwiseXorExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.BitwiseOrExpression <em>Bitwise Or Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.BitwiseOrExpression
	 * @generated
	 */
	public Adapter createBitwiseOrExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.BitwiseAndExpression <em>Bitwise And Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.BitwiseAndExpression
	 * @generated
	 */
	public Adapter createBitwiseAndExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.LogicalRelationExpression <em>Logical Relation Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.LogicalRelationExpression
	 * @generated
	 */
	public Adapter createLogicalRelationExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.ShiftExpression <em>Shift Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.ShiftExpression
	 * @generated
	 */
	public Adapter createShiftExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression <em>Numerical Add Subtract Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
	 * @generated
	 */
	public Adapter createNumericalAddSubtractExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression <em>Numerical Multiply Divide Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
	 * @generated
	 */
	public Adapter createNumericalMultiplyDivideExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.NumericalUnaryExpression <em>Numerical Unary Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.NumericalUnaryExpression
	 * @generated
	 */
	public Adapter createNumericalUnaryExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.PrimitiveValueExpression <em>Primitive Value Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.PrimitiveValueExpression
	 * @generated
	 */
	public Adapter createPrimitiveValueExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.FeatureCall <em>Feature Call</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.FeatureCall
	 * @generated
	 */
	public Adapter createFeatureCallAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.ElementReferenceExpression <em>Element Reference Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.ElementReferenceExpression
	 * @generated
	 */
	public Adapter createElementReferenceExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.ParenthesizedExpression <em>Parenthesized Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.ParenthesizedExpression
	 * @generated
	 */
	public Adapter createParenthesizedExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link org.yakindu.base.expressions.expressions.TypeCastExpression <em>Type Cast Expression</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see org.yakindu.base.expressions.expressions.TypeCastExpression
	 * @generated
	 */
	public Adapter createTypeCastExpressionAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for the default case.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @generated
	 */
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ExpressionsAdapterFactory
