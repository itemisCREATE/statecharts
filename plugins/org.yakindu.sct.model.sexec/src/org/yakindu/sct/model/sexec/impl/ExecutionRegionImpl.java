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
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.StateVector;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Region</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ExecutionRegionImpl#getHistoryStateVector <em>History State Vector</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionRegionImpl extends ExecutionScopeImpl implements ExecutionRegion {
	/**
	 * The cached value of the '{@link #getHistoryStateVector() <em>History State Vector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistoryStateVector()
	 * @generated
	 * @ordered
	 */
	protected StateVector historyStateVector;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionRegionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.EXECUTION_REGION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StateVector getHistoryStateVector() {
		return historyStateVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHistoryStateVector(StateVector newHistoryStateVector, NotificationChain msgs) {
		StateVector oldHistoryStateVector = historyStateVector;
		historyStateVector = newHistoryStateVector;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_REGION__HISTORY_STATE_VECTOR, oldHistoryStateVector, newHistoryStateVector);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHistoryStateVector(StateVector newHistoryStateVector) {
		if (newHistoryStateVector != historyStateVector) {
			NotificationChain msgs = null;
			if (historyStateVector != null)
				msgs = ((InternalEObject)historyStateVector).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_REGION__HISTORY_STATE_VECTOR, null, msgs);
			if (newHistoryStateVector != null)
				msgs = ((InternalEObject)newHistoryStateVector).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.EXECUTION_REGION__HISTORY_STATE_VECTOR, null, msgs);
			msgs = basicSetHistoryStateVector(newHistoryStateVector, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.EXECUTION_REGION__HISTORY_STATE_VECTOR, newHistoryStateVector, newHistoryStateVector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SexecPackage.EXECUTION_REGION__HISTORY_STATE_VECTOR:
				return basicSetHistoryStateVector(null, msgs);
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
			case SexecPackage.EXECUTION_REGION__HISTORY_STATE_VECTOR:
				return getHistoryStateVector();
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
			case SexecPackage.EXECUTION_REGION__HISTORY_STATE_VECTOR:
				setHistoryStateVector((StateVector)newValue);
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
			case SexecPackage.EXECUTION_REGION__HISTORY_STATE_VECTOR:
				setHistoryStateVector((StateVector)null);
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
			case SexecPackage.EXECUTION_REGION__HISTORY_STATE_VECTOR:
				return historyStateVector != null;
		}
		return super.eIsSet(featureID);
	}

} //ExecutionRegionImpl
