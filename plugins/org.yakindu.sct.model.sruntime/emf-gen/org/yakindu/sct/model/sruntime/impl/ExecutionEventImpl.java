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

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.base.types.Direction;

import org.yakindu.sct.model.sruntime.ExecutionEvent;
import org.yakindu.sct.model.sruntime.SRuntimePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Event</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sruntime.impl.ExecutionEventImpl#isRaised <em>Raised</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.impl.ExecutionEventImpl#getDirection <em>Direction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ExecutionEventImpl extends ExecutionSlotImpl implements ExecutionEvent {
	/**
	 * The default value of the '{@link #isRaised() <em>Raised</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRaised()
	 * @generated
	 * @ordered
	 */
	protected static final boolean RAISED_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isRaised() <em>Raised</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isRaised()
	 * @generated
	 * @ordered
	 */
	protected boolean raised = RAISED_EDEFAULT;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final Direction DIRECTION_EDEFAULT = Direction.LOCAL;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected Direction direction = DIRECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionEventImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SRuntimePackage.Literals.EXECUTION_EVENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isRaised() {
		return raised;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRaised(boolean newRaised) {
		boolean oldRaised = raised;
		raised = newRaised;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRuntimePackage.EXECUTION_EVENT__RAISED, oldRaised, raised));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(Direction newDirection) {
		Direction oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SRuntimePackage.EXECUTION_EVENT__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SRuntimePackage.EXECUTION_EVENT__RAISED:
				return isRaised();
			case SRuntimePackage.EXECUTION_EVENT__DIRECTION:
				return getDirection();
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
			case SRuntimePackage.EXECUTION_EVENT__RAISED:
				setRaised((Boolean)newValue);
				return;
			case SRuntimePackage.EXECUTION_EVENT__DIRECTION:
				setDirection((Direction)newValue);
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
			case SRuntimePackage.EXECUTION_EVENT__RAISED:
				setRaised(RAISED_EDEFAULT);
				return;
			case SRuntimePackage.EXECUTION_EVENT__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
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
			case SRuntimePackage.EXECUTION_EVENT__RAISED:
				return raised != RAISED_EDEFAULT;
			case SRuntimePackage.EXECUTION_EVENT__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
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
		result.append(" (raised: ");
		result.append(raised);
		result.append(", direction: ");
		result.append(direction);
		result.append(')');
		return result.toString();
	}

} //ExecutionEventImpl
