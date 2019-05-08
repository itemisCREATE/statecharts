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
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.SaveHistory;
import org.yakindu.sct.model.sexec.SexecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Save History</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.SaveHistoryImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.SaveHistoryImpl#isDeep <em>Deep</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SaveHistoryImpl extends StepImpl implements SaveHistory {
	/**
	 * The cached value of the '{@link #getRegion() <em>Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected ExecutionRegion region;

	/**
	 * The default value of the '{@link #isDeep() <em>Deep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeep()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DEEP_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isDeep() <em>Deep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDeep()
	 * @generated
	 * @ordered
	 */
	protected boolean deep = DEEP_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SaveHistoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.SAVE_HISTORY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionRegion getRegion() {
		if (region != null && region.eIsProxy()) {
			InternalEObject oldRegion = (InternalEObject)region;
			region = (ExecutionRegion)eResolveProxy(oldRegion);
			if (region != oldRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.SAVE_HISTORY__REGION, oldRegion, region));
			}
		}
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionRegion basicGetRegion() {
		return region;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRegion(ExecutionRegion newRegion) {
		ExecutionRegion oldRegion = region;
		region = newRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.SAVE_HISTORY__REGION, oldRegion, region));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isDeep() {
		return deep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDeep(boolean newDeep) {
		boolean oldDeep = deep;
		deep = newDeep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.SAVE_HISTORY__DEEP, oldDeep, deep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SexecPackage.SAVE_HISTORY__REGION:
				if (resolve) return getRegion();
				return basicGetRegion();
			case SexecPackage.SAVE_HISTORY__DEEP:
				return isDeep();
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
			case SexecPackage.SAVE_HISTORY__REGION:
				setRegion((ExecutionRegion)newValue);
				return;
			case SexecPackage.SAVE_HISTORY__DEEP:
				setDeep((Boolean)newValue);
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
			case SexecPackage.SAVE_HISTORY__REGION:
				setRegion((ExecutionRegion)null);
				return;
			case SexecPackage.SAVE_HISTORY__DEEP:
				setDeep(DEEP_EDEFAULT);
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
			case SexecPackage.SAVE_HISTORY__REGION:
				return region != null;
			case SexecPackage.SAVE_HISTORY__DEEP:
				return deep != DEEP_EDEFAULT;
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
		result.append(" (deep: ");
		result.append(deep);
		result.append(')');
		return result.toString();
	}

} //SaveHistoryImpl
