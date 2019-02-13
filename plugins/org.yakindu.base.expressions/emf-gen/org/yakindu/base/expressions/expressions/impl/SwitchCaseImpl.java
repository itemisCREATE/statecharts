/**
 */
package org.yakindu.base.expressions.expressions.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.SwitchCase;
import org.yakindu.base.types.Expression;
import org.yakindu.base.types.impl.ExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.SwitchCaseImpl#getCase <em>Case</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.SwitchCaseImpl#getThen <em>Then</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SwitchCaseImpl extends ExpressionImpl implements SwitchCase {
	/**
	 * The cached value of the '{@link #getCase() <em>Case</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCase()
	 * @generated
	 * @ordered
	 */
	protected Expression case_;

	/**
	 * The cached value of the '{@link #getThen() <em>Then</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThen()
	 * @generated
	 * @ordered
	 */
	protected Expression then;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.SWITCH_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getCase() {
		return case_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCase(Expression newCase, NotificationChain msgs) {
		Expression oldCase = case_;
		case_ = newCase;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.SWITCH_CASE__CASE, oldCase, newCase);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCase(Expression newCase) {
		if (newCase != case_) {
			NotificationChain msgs = null;
			if (case_ != null)
				msgs = ((InternalEObject)case_).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.SWITCH_CASE__CASE, null, msgs);
			if (newCase != null)
				msgs = ((InternalEObject)newCase).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.SWITCH_CASE__CASE, null, msgs);
			msgs = basicSetCase(newCase, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.SWITCH_CASE__CASE, newCase, newCase));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getThen() {
		return then;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThen(Expression newThen, NotificationChain msgs) {
		Expression oldThen = then;
		then = newThen;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.SWITCH_CASE__THEN, oldThen, newThen);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setThen(Expression newThen) {
		if (newThen != then) {
			NotificationChain msgs = null;
			if (then != null)
				msgs = ((InternalEObject)then).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.SWITCH_CASE__THEN, null, msgs);
			if (newThen != null)
				msgs = ((InternalEObject)newThen).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.SWITCH_CASE__THEN, null, msgs);
			msgs = basicSetThen(newThen, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.SWITCH_CASE__THEN, newThen, newThen));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.SWITCH_CASE__CASE:
				return basicSetCase(null, msgs);
			case ExpressionsPackage.SWITCH_CASE__THEN:
				return basicSetThen(null, msgs);
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
			case ExpressionsPackage.SWITCH_CASE__CASE:
				return getCase();
			case ExpressionsPackage.SWITCH_CASE__THEN:
				return getThen();
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
			case ExpressionsPackage.SWITCH_CASE__CASE:
				setCase((Expression)newValue);
				return;
			case ExpressionsPackage.SWITCH_CASE__THEN:
				setThen((Expression)newValue);
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
			case ExpressionsPackage.SWITCH_CASE__CASE:
				setCase((Expression)null);
				return;
			case ExpressionsPackage.SWITCH_CASE__THEN:
				setThen((Expression)null);
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
			case ExpressionsPackage.SWITCH_CASE__CASE:
				return case_ != null;
			case ExpressionsPackage.SWITCH_CASE__THEN:
				return then != null;
		}
		return super.eIsSet(featureID);
	}

} //SwitchCaseImpl
