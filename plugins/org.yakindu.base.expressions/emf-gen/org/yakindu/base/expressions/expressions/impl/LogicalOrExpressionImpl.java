/**
 */
package org.yakindu.base.expressions.expressions.impl;

import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.emf.ecore.EClass;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.LogicalOperator;
import org.yakindu.base.expressions.expressions.LogicalOrExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical Or Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public class LogicalOrExpressionImpl extends BinaryExpressionImpl implements LogicalOrExpression {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected LogicalOrExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.LOGICAL_OR_EXPRESSION;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public Enumerator getOperator() {
		return LogicalOperator.OR;
	}
	
	
} //LogicalOrExpressionImpl
