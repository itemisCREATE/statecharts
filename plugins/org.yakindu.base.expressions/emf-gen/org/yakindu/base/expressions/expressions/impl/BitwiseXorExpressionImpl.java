/**
 */
package org.yakindu.base.expressions.expressions.impl;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.yakindu.base.expressions.expressions.BitwiseOperator;
import org.yakindu.base.expressions.expressions.BitwiseXorExpression;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Bitwise Xor Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class BitwiseXorExpressionImpl extends BinaryExpressionImpl implements BitwiseXorExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected BitwiseXorExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.BITWISE_XOR_EXPRESSION;
	}
	
	/**
	 * @generated NOT
	 */
	@Override
	public Enumerator getOperator() {
		return BitwiseOperator.XOR;
	}

} //BitwiseXorExpressionImpl
