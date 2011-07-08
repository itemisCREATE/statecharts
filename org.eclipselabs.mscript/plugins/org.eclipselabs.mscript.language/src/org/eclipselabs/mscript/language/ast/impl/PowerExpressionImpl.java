/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.PowerExpression;
import org.eclipselabs.mscript.language.ast.PowerOperator;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Power Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.PowerExpressionImpl#getOperand <em>Operand</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.PowerExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.PowerExpressionImpl#getExponent <em>Exponent</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PowerExpressionImpl extends ExpressionImpl implements PowerExpression {
	/**
	 * The cached value of the '{@link #getOperand() <em>Operand</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperand()
	 * @generated
	 * @ordered
	 */
	protected Expression operand;

	/**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected static final PowerOperator OPERATOR_EDEFAULT = PowerOperator.POWER;

	/**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
	protected PowerOperator operator = OPERATOR_EDEFAULT;

	/**
	 * The cached value of the '{@link #getExponent() <em>Exponent</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExponent()
	 * @generated
	 * @ordered
	 */
	protected Expression exponent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PowerExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.POWER_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getOperand() {
		return operand;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOperand(Expression newOperand, NotificationChain msgs) {
		Expression oldOperand = operand;
		operand = newOperand;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.POWER_EXPRESSION__OPERAND, oldOperand, newOperand);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperand(Expression newOperand) {
		if (newOperand != operand) {
			NotificationChain msgs = null;
			if (operand != null)
				msgs = ((InternalEObject)operand).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.POWER_EXPRESSION__OPERAND, null, msgs);
			if (newOperand != null)
				msgs = ((InternalEObject)newOperand).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.POWER_EXPRESSION__OPERAND, null, msgs);
			msgs = basicSetOperand(newOperand, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.POWER_EXPRESSION__OPERAND, newOperand, newOperand));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PowerOperator getOperator() {
		return operator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOperator(PowerOperator newOperator) {
		PowerOperator oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.POWER_EXPRESSION__OPERATOR, oldOperator, operator));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getExponent() {
		return exponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetExponent(Expression newExponent, NotificationChain msgs) {
		Expression oldExponent = exponent;
		exponent = newExponent;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.POWER_EXPRESSION__EXPONENT, oldExponent, newExponent);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExponent(Expression newExponent) {
		if (newExponent != exponent) {
			NotificationChain msgs = null;
			if (exponent != null)
				msgs = ((InternalEObject)exponent).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.POWER_EXPRESSION__EXPONENT, null, msgs);
			if (newExponent != null)
				msgs = ((InternalEObject)newExponent).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.POWER_EXPRESSION__EXPONENT, null, msgs);
			msgs = basicSetExponent(newExponent, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.POWER_EXPRESSION__EXPONENT, newExponent, newExponent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.POWER_EXPRESSION__OPERAND:
				return basicSetOperand(null, msgs);
			case AstPackage.POWER_EXPRESSION__EXPONENT:
				return basicSetExponent(null, msgs);
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
			case AstPackage.POWER_EXPRESSION__OPERAND:
				return getOperand();
			case AstPackage.POWER_EXPRESSION__OPERATOR:
				return getOperator();
			case AstPackage.POWER_EXPRESSION__EXPONENT:
				return getExponent();
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
			case AstPackage.POWER_EXPRESSION__OPERAND:
				setOperand((Expression)newValue);
				return;
			case AstPackage.POWER_EXPRESSION__OPERATOR:
				setOperator((PowerOperator)newValue);
				return;
			case AstPackage.POWER_EXPRESSION__EXPONENT:
				setExponent((Expression)newValue);
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
			case AstPackage.POWER_EXPRESSION__OPERAND:
				setOperand((Expression)null);
				return;
			case AstPackage.POWER_EXPRESSION__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case AstPackage.POWER_EXPRESSION__EXPONENT:
				setExponent((Expression)null);
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
			case AstPackage.POWER_EXPRESSION__OPERAND:
				return operand != null;
			case AstPackage.POWER_EXPRESSION__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
			case AstPackage.POWER_EXPRESSION__EXPONENT:
				return exponent != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (operator: ");
		result.append(operator);
		result.append(')');
		return result.toString();
	}

} //PowerExpressionImpl
