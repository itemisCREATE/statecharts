/**
 */
package org.yakindu.sct.model.sexec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.base.types.impl.OperationImpl;
import org.yakindu.sct.model.sexec.Method;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Method</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.MethodImpl#getBodySequence <em>Body Sequence</em>}</li>
 * </ul>
 *
 * @generated
 */
public class MethodImpl extends OperationImpl implements Method {
	/**
	 * The cached value of the '{@link #getBodySequence() <em>Body Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBodySequence()
	 * @generated
	 * @ordered
	 */
	protected Sequence bodySequence;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MethodImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.METHOD;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Sequence getBodySequence() {
		return bodySequence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBodySequence(Sequence newBodySequence, NotificationChain msgs) {
		Sequence oldBodySequence = bodySequence;
		bodySequence = newBodySequence;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.METHOD__BODY_SEQUENCE, oldBodySequence, newBodySequence);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBodySequence(Sequence newBodySequence) {
		if (newBodySequence != bodySequence) {
			NotificationChain msgs = null;
			if (bodySequence != null)
				msgs = ((InternalEObject)bodySequence).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.METHOD__BODY_SEQUENCE, null, msgs);
			if (newBodySequence != null)
				msgs = ((InternalEObject)newBodySequence).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.METHOD__BODY_SEQUENCE, null, msgs);
			msgs = basicSetBodySequence(newBodySequence, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.METHOD__BODY_SEQUENCE, newBodySequence, newBodySequence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SexecPackage.METHOD__BODY_SEQUENCE:
				return basicSetBodySequence(null, msgs);
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
			case SexecPackage.METHOD__BODY_SEQUENCE:
				return getBodySequence();
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
			case SexecPackage.METHOD__BODY_SEQUENCE:
				setBodySequence((Sequence)newValue);
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
			case SexecPackage.METHOD__BODY_SEQUENCE:
				setBodySequence((Sequence)null);
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
			case SexecPackage.METHOD__BODY_SEQUENCE:
				return bodySequence != null;
		}
		return super.eIsSet(featureID);
	}

} //MethodImpl
