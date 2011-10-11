/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.TimeEvent;
import org.yakindu.sct.model.sexec.UnscheduleTimeEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unschedule Time Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.UnscheduleTimeEventImpl#getTimeEvent <em>Time Event</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnscheduleTimeEventImpl extends StepImpl implements UnscheduleTimeEvent {
	/**
	 * The cached value of the '{@link #getTimeEvent() <em>Time Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTimeEvent()
	 * @generated
	 * @ordered
	 */
	protected TimeEvent timeEvent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnscheduleTimeEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.UNSCHEDULE_TIME_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeEvent getTimeEvent() {
		if (timeEvent != null && timeEvent.eIsProxy()) {
			InternalEObject oldTimeEvent = (InternalEObject)timeEvent;
			timeEvent = (TimeEvent)eResolveProxy(oldTimeEvent);
			if (timeEvent != oldTimeEvent) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.UNSCHEDULE_TIME_EVENT__TIME_EVENT, oldTimeEvent, timeEvent));
			}
		}
		return timeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TimeEvent basicGetTimeEvent() {
		return timeEvent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTimeEvent(TimeEvent newTimeEvent) {
		TimeEvent oldTimeEvent = timeEvent;
		timeEvent = newTimeEvent;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.UNSCHEDULE_TIME_EVENT__TIME_EVENT, oldTimeEvent, timeEvent));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SexecPackage.UNSCHEDULE_TIME_EVENT__TIME_EVENT:
				if (resolve) return getTimeEvent();
				return basicGetTimeEvent();
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
			case SexecPackage.UNSCHEDULE_TIME_EVENT__TIME_EVENT:
				setTimeEvent((TimeEvent)newValue);
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
			case SexecPackage.UNSCHEDULE_TIME_EVENT__TIME_EVENT:
				setTimeEvent((TimeEvent)null);
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
			case SexecPackage.UNSCHEDULE_TIME_EVENT__TIME_EVENT:
				return timeEvent != null;
		}
		return super.eIsSet(featureID);
	}

} //UnscheduleTimeEventImpl
