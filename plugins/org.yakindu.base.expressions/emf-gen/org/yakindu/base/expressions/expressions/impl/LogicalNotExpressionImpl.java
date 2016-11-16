/**
 */
package org.yakindu.base.expressions.expressions.impl;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.LogicalNotExpression;
import org.yakindu.base.expressions.expressions.LogicalOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical Not Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class LogicalNotExpressionImpl extends UnaryExpressionImpl implements LogicalNotExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogicalNotExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.LOGICAL_NOT_EXPRESSION;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Enumerator getOperator() {
		return LogicalOperator.NOT;
	}

} //LogicalNotExpressionImpl
