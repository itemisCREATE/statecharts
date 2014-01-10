/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.base.expressions.expressions.Expression;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.CheckRef;
import org.yakindu.sct.model.sexec.SexecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Check Ref</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.CheckRefImpl#getCheck <em>Check</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CheckRefImpl extends CheckImpl implements CheckRef {
	/**
	 * The cached value of the '{@link #getCheck() <em>Check</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheck()
	 * @generated
	 * @ordered
	 */
	protected Check check;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CheckRefImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.CHECK_REF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Check getCheck() {
		if (check != null && check.eIsProxy()) {
			InternalEObject oldCheck = (InternalEObject)check;
			check = (Check)eResolveProxy(oldCheck);
			if (check != oldCheck) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.CHECK_REF__CHECK, oldCheck, check));
			}
		}
		return check;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Check basicGetCheck() {
		return check;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCheck(Check newCheck, NotificationChain msgs) {
		Check oldCheck = check;
		check = newCheck;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.CHECK_REF__CHECK, oldCheck, newCheck);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCheck(Check newCheck) {
		if (newCheck != check) {
			NotificationChain msgs = null;
			if (check != null)
				msgs = ((InternalEObject)check).eInverseRemove(this, SexecPackage.CHECK__REFS, Check.class, msgs);
			if (newCheck != null)
				msgs = ((InternalEObject)newCheck).eInverseAdd(this, SexecPackage.CHECK__REFS, Check.class, msgs);
			msgs = basicSetCheck(newCheck, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.CHECK_REF__CHECK, newCheck, newCheck));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SexecPackage.CHECK_REF__CHECK:
				if (check != null)
					msgs = ((InternalEObject)check).eInverseRemove(this, SexecPackage.CHECK__REFS, Check.class, msgs);
				return basicSetCheck((Check)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SexecPackage.CHECK_REF__CHECK:
				return basicSetCheck(null, msgs);
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
			case SexecPackage.CHECK_REF__CHECK:
				if (resolve) return getCheck();
				return basicGetCheck();
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
			case SexecPackage.CHECK_REF__CHECK:
				setCheck((Check)newValue);
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
			case SexecPackage.CHECK_REF__CHECK:
				setCheck((Check)null);
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
			case SexecPackage.CHECK_REF__CHECK:
				return check != null;
		}
		return super.eIsSet(featureID);
	}

	
	@Override
	public Expression getCondition() {
		return (check != null) ? check.getCondition() : null;
	}

	@Override
	public void setCondition(Expression newCondition) {
		if (check != null) check.setCondition(newCondition);
	}

	
	
} //CheckRefImpl
