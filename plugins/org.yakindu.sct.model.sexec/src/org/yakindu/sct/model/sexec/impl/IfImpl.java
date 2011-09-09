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
import org.yakindu.sct.model.sexec.If;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.Step;
import org.yakindu.sct.model.sgraph.Statement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.IfImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.IfImpl#getThenStep <em>Then Step</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.IfImpl#getElseStep <em>Else Step</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfImpl extends StepImpl implements If {
	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Statement condition;

	/**
	 * The cached value of the '{@link #getThenStep() <em>Then Step</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThenStep()
	 * @generated
	 * @ordered
	 */
	protected Step thenStep;

	/**
	 * The cached value of the '{@link #getElseStep() <em>Else Step</em>}' reference.
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
	public Statement getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Statement newCondition, NotificationChain msgs) {
		Statement oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.IF__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCondition(Statement newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.IF__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.IF__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.IF__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Step getThenStep() {
		if (thenStep != null && thenStep.eIsProxy()) {
			InternalEObject oldThenStep = (InternalEObject)thenStep;
			thenStep = (Step)eResolveProxy(oldThenStep);
			if (thenStep != oldThenStep) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.IF__THEN_STEP, oldThenStep, thenStep));
			}
		}
		return thenStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Step basicGetThenStep() {
		return thenStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setThenStep(Step newThenStep) {
		Step oldThenStep = thenStep;
		thenStep = newThenStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.IF__THEN_STEP, oldThenStep, thenStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Step getElseStep() {
		if (elseStep != null && elseStep.eIsProxy()) {
			InternalEObject oldElseStep = (InternalEObject)elseStep;
			elseStep = (Step)eResolveProxy(oldElseStep);
			if (elseStep != oldElseStep) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.IF__ELSE_STEP, oldElseStep, elseStep));
			}
		}
		return elseStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Step basicGetElseStep() {
		return elseStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElseStep(Step newElseStep) {
		Step oldElseStep = elseStep;
		elseStep = newElseStep;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.IF__ELSE_STEP, oldElseStep, elseStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SexecPackage.IF__CONDITION:
				return basicSetCondition(null, msgs);
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
			case SexecPackage.IF__CONDITION:
				return getCondition();
			case SexecPackage.IF__THEN_STEP:
				if (resolve) return getThenStep();
				return basicGetThenStep();
			case SexecPackage.IF__ELSE_STEP:
				if (resolve) return getElseStep();
				return basicGetElseStep();
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
			case SexecPackage.IF__CONDITION:
				setCondition((Statement)newValue);
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
			case SexecPackage.IF__CONDITION:
				setCondition((Statement)null);
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
			case SexecPackage.IF__CONDITION:
				return condition != null;
			case SexecPackage.IF__THEN_STEP:
				return thenStep != null;
			case SexecPackage.IF__ELSE_STEP:
				return elseStep != null;
		}
		return super.eIsSet(featureID);
	}

} //IfImpl
