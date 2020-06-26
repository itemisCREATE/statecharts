/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.base.types.impl.EventImpl;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.TimeEvent;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Time Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.TimeEventImpl#isPeriodic <em>Periodic</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TimeEventImpl extends EventImpl implements TimeEvent {
	/**
	 * The default value of the '{@link #isPeriodic() <em>Periodic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPeriodic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean PERIODIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isPeriodic() <em>Periodic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isPeriodic()
	 * @generated
	 * @ordered
	 */
	protected boolean periodic = PERIODIC_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.TIME_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isPeriodic() {
		return periodic;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setPeriodic(boolean newPeriodic) {
		boolean oldPeriodic = periodic;
		periodic = newPeriodic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.TIME_EVENT__PERIODIC, oldPeriodic, periodic));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SexecPackage.TIME_EVENT__PERIODIC:
				return isPeriodic();
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
			case SexecPackage.TIME_EVENT__PERIODIC:
				setPeriodic((Boolean)newValue);
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
			case SexecPackage.TIME_EVENT__PERIODIC:
				setPeriodic(PERIODIC_EDEFAULT);
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
			case SexecPackage.TIME_EVENT__PERIODIC:
				return periodic != PERIODIC_EDEFAULT;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (periodic: ");
		result.append(periodic);
		result.append(')');
		return result.toString();
	}

} //TimeEventImpl
