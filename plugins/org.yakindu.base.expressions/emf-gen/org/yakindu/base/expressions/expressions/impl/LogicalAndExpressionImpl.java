/**
 */
package org.yakindu.base.expressions.expressions.impl;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.LogicalAndExpression;
import org.yakindu.base.expressions.expressions.LogicalOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical And Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class LogicalAndExpressionImpl extends BinaryExpressionImpl implements LogicalAndExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogicalAndExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.LOGICAL_AND_EXPRESSION;
	}

	@Override
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Enumerator getOperator() {
		return LogicalOperator.AND;
	}
	
	

} //LogicalAndExpressionImpl
