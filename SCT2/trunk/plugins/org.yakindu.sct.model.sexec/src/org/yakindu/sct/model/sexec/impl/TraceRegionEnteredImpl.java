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

import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.TraceRegionEntered;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Region Entered</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.TraceRegionEnteredImpl#getRegion <em>Region</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceRegionEnteredImpl extends TraceImpl implements TraceRegionEntered {
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TraceRegionEnteredImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.TRACE_REGION_ENTERED;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.TRACE_REGION_ENTERED__REGION, oldRegion, region));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.TRACE_REGION_ENTERED__REGION, oldRegion, region));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SexecPackage.TRACE_REGION_ENTERED__REGION:
				if (resolve) return getRegion();
				return basicGetRegion();
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
			case SexecPackage.TRACE_REGION_ENTERED__REGION:
				setRegion((ExecutionRegion)newValue);
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
			case SexecPackage.TRACE_REGION_ENTERED__REGION:
				setRegion((ExecutionRegion)null);
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
			case SexecPackage.TRACE_REGION_ENTERED__REGION:
				return region != null;
		}
		return super.eIsSet(featureID);
	}

} //TraceRegionEnteredImpl
