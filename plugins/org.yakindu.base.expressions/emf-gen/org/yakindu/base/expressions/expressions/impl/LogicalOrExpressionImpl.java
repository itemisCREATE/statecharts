/**
 */
package org.yakindu.base.expressions.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.LogicalOrExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Logical Or Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.LogicalOrExpressionImpl#getLeftOperand <em>Left Operand</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.LogicalOrExpressionImpl#getRightOperand <em>Right Operand</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class LogicalOrExpressionImpl extends ExpressionImpl implements LogicalOrExpression {
	/**
	 * The cached value of the '{@link #getLeftOperand() <em>Left Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLeftOperand()
	 * @generated
	 * @ordered
	 */
	protected Expression leftOperand;

	/**
	 * The cached value of the '{@link #getRightOperand() <em>Right Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRightOperand()
	 * @generated
	 * @ordered
	 */
	protected Expression rightOperand;

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
	 * @generated
	 */
	public Expression getLeftOperand() {
		return leftOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetLeftOperand(Expression newLeftOperand, NotificationChain msgs) {
		Expression oldLeftOperand = leftOperand;
		leftOperand = newLeftOperand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.LOGICAL_OR_EXPRESSION__LEFT_OPERAND, oldLeftOperand, newLeftOperand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLeftOperand(Expression newLeftOperand) {
		if (newLeftOperand != leftOperand) {
			NotificationChain msgs = null;
			if (leftOperand != null)
				msgs = ((InternalEObject)leftOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.LOGICAL_OR_EXPRESSION__LEFT_OPERAND, null, msgs);
			if (newLeftOperand != null)
				msgs = ((InternalEObject)newLeftOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.LOGICAL_OR_EXPRESSION__LEFT_OPERAND, null, msgs);
			msgs = basicSetLeftOperand(newLeftOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.LOGICAL_OR_EXPRESSION__LEFT_OPERAND, newLeftOperand, newLeftOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getRightOperand() {
		return rightOperand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRightOperand(Expression newRightOperand, NotificationChain msgs) {
		Expression oldRightOperand = rightOperand;
		rightOperand = newRightOperand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.LOGICAL_OR_EXPRESSION__RIGHT_OPERAND, oldRightOperand, newRightOperand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRightOperand(Expression newRightOperand) {
		if (newRightOperand != rightOperand) {
			NotificationChain msgs = null;
			if (rightOperand != null)
				msgs = ((InternalEObject)rightOperand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.LOGICAL_OR_EXPRESSION__RIGHT_OPERAND, null, msgs);
			if (newRightOperand != null)
				msgs = ((InternalEObject)newRightOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.LOGICAL_OR_EXPRESSION__RIGHT_OPERAND, null, msgs);
			msgs = basicSetRightOperand(newRightOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.LOGICAL_OR_EXPRESSION__RIGHT_OPERAND, newRightOperand, newRightOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.LOGICAL_OR_EXPRESSION__LEFT_OPERAND:
				return basicSetLeftOperand(null, msgs);
			case ExpressionsPackage.LOGICAL_OR_EXPRESSION__RIGHT_OPERAND:
				return basicSetRightOperand(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ExpressionsPackage.LOGICAL_OR_EXPRESSION__LEFT_OPERAND:
				return getLeftOperand();
			case ExpressionsPackage.LOGICAL_OR_EXPRESSION__RIGHT_OPERAND:
				return getRightOperand();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ExpressionsPackage.LOGICAL_OR_EXPRESSION__LEFT_OPERAND:
				setLeftOperand((Expression)newValue);
				return;
			case ExpressionsPackage.LOGICAL_OR_EXPRESSION__RIGHT_OPERAND:
				setRightOperand((Expression)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.LOGICAL_OR_EXPRESSION__LEFT_OPERAND:
				setLeftOperand((Expression)null);
				return;
			case ExpressionsPackage.LOGICAL_OR_EXPRESSION__RIGHT_OPERAND:
				setRightOperand((Expression)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ExpressionsPackage.LOGICAL_OR_EXPRESSION__LEFT_OPERAND:
				return leftOperand != null;
			case ExpressionsPackage.LOGICAL_OR_EXPRESSION__RIGHT_OPERAND:
				return rightOperand != null;
		}
		return super.eIsSet(featureID);
	}

} //LogicalOrExpressionImpl
