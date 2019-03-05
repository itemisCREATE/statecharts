/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sruntime.impl;

import java.util.List;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.sct.model.sruntime.CompositeSlot;
import org.yakindu.sct.model.sruntime.ExecutionSlot;
import org.yakindu.sct.model.sruntime.ReferenceSlot;
import org.yakindu.sct.model.sruntime.SRuntimePackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object
 * '<em><b>Reference Slot</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sruntime.impl.ReferenceSlotImpl#getReference <em>Reference</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReferenceSlotImpl extends CompositeSlotImpl implements ReferenceSlot {
	/**
	 * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getReference()
	 * @generated
	 * @ordered
	 */
	protected ExecutionSlot reference;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ReferenceSlotImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SRuntimePackage.Literals.REFERENCE_SLOT;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public ExecutionSlot getReference() {
		if (reference != null && reference.eIsProxy()) {
			InternalEObject oldReference = (InternalEObject)reference;
			reference = (ExecutionSlot)eResolveProxy(oldReference);
			if (reference != oldReference) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SRuntimePackage.REFERENCE_SLOT__REFERENCE, oldReference, reference));
			}
		}
		return reference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionSlot basicGetReference() {
		return reference;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReference(ExecutionSlot newReference) {
		ExecutionSlot oldReference = reference;
		reference = newReference;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRuntimePackage.REFERENCE_SLOT__REFERENCE, oldReference, reference));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SRuntimePackage.REFERENCE_SLOT__REFERENCE:
				if (resolve) return getReference();
				return basicGetReference();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SRuntimePackage.REFERENCE_SLOT__REFERENCE:
				setReference((ExecutionSlot)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SRuntimePackage.REFERENCE_SLOT__REFERENCE:
				setReference((ExecutionSlot)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SRuntimePackage.REFERENCE_SLOT__REFERENCE:
				return reference != null;
		}
		return super.eIsSet(featureID);
	}

	@Override
	public List<ExecutionSlot> getSlots() {
		if (reference instanceof CompositeSlot) {
			return ((CompositeSlot) reference).getSlots();
		}
		return super.getSlots();
	}

} // ReferenceSlotImpl
