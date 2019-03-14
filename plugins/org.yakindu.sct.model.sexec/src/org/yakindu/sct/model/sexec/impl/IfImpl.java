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
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.sct.model.sexec.Check;
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.Step;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.IfImpl#getCheck <em>Check</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.IfImpl#getThenStep <em>Then Step</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.IfImpl#getElseStep <em>Else Step</em>}</li>
 * </ul>
 *
 * @generated
 */
public class IfImpl extends StepImpl implements If {
	/**
	 * The cached value of the '{@link #getCheck() <em>Check</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCheck()
	 * @generated
	 * @ordered
	 */
	protected Check check;

	/**
	 * The cached value of the '{@link #getThenStep() <em>Then Step</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenStep()
	 * @generated
	 * @ordered
	 */
	protected Step thenStep;

	/**
	 * The cached value of the '{@link #getElseStep() <em>Else Step</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElseStep()
	 * @generated
	 * @ordered
	 */
	protected Step elseStep;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.IF;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Check getCheck() {
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
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.IF__CHECK, oldCheck, newCheck);
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
	public void setCheck(Check newCheck) {
		if (newCheck != check) {
			NotificationChain msgs = null;
			if (check != null)
				msgs = ((InternalEObject)check).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.IF__CHECK, null, msgs);
			if (newCheck != null)
				msgs = ((InternalEObject)newCheck).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.IF__CHECK, null, msgs);
			msgs = basicSetCheck(newCheck, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.IF__CHECK, newCheck, newCheck));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Step getThenStep() {
		return thenStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetThenStep(Step newThenStep, NotificationChain msgs) {
		Step oldThenStep = thenStep;
		thenStep = newThenStep;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.IF__THEN_STEP, oldThenStep, newThenStep);
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
	public void setThenStep(Step newThenStep) {
		if (newThenStep != thenStep) {
			NotificationChain msgs = null;
			if (thenStep != null)
				msgs = ((InternalEObject)thenStep).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.IF__THEN_STEP, null, msgs);
			if (newThenStep != null)
				msgs = ((InternalEObject)newThenStep).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.IF__THEN_STEP, null, msgs);
			msgs = basicSetThenStep(newThenStep, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.IF__THEN_STEP, newThenStep, newThenStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Step getElseStep() {
		return elseStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetElseStep(Step newElseStep, NotificationChain msgs) {
		Step oldElseStep = elseStep;
		elseStep = newElseStep;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.IF__ELSE_STEP, oldElseStep, newElseStep);
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
	public void setElseStep(Step newElseStep) {
		if (newElseStep != elseStep) {
			NotificationChain msgs = null;
			if (elseStep != null)
				msgs = ((InternalEObject)elseStep).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.IF__ELSE_STEP, null, msgs);
			if (newElseStep != null)
				msgs = ((InternalEObject)newElseStep).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.IF__ELSE_STEP, null, msgs);
			msgs = basicSetElseStep(newElseStep, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.IF__ELSE_STEP, newElseStep, newElseStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SexecPackage.IF__CHECK:
				return basicSetCheck(null, msgs);
			case SexecPackage.IF__THEN_STEP:
				return basicSetThenStep(null, msgs);
			case SexecPackage.IF__ELSE_STEP:
				return basicSetElseStep(null, msgs);
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
			case SexecPackage.IF__CHECK:
				return getCheck();
			case SexecPackage.IF__THEN_STEP:
				return getThenStep();
			case SexecPackage.IF__ELSE_STEP:
				return getElseStep();
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
			case SexecPackage.IF__CHECK:
				setCheck((Check)newValue);
				return;
			case SexecPackage.IF__THEN_STEP:
				setThenStep((Step)newValue);
				return;
			case SexecPackage.IF__ELSE_STEP:
				setElseStep((Step)newValue);
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
			case SexecPackage.IF__CHECK:
				setCheck((Check)null);
				return;
			case SexecPackage.IF__THEN_STEP:
				setThenStep((Step)null);
				return;
			case SexecPackage.IF__ELSE_STEP:
				setElseStep((Step)null);
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
			case SexecPackage.IF__CHECK:
				return check != null;
			case SexecPackage.IF__THEN_STEP:
				return thenStep != null;
			case SexecPackage.IF__ELSE_STEP:
				return elseStep != null;
		}
		return super.eIsSet(featureID);
	}

} //IfImpl
