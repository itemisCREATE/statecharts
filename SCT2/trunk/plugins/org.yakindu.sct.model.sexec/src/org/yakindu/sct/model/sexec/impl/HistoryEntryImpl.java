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
import org.yakindu.sct.model.sexec.HistoryEntry;
import org.yakindu.sct.model.sexec.Sequence;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.Step;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>History Entry</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.HistoryEntryImpl#getInitialStep <em>Initial Step</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.HistoryEntryImpl#isDeep <em>Deep</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.HistoryEntryImpl#getRegion <em>Region</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.HistoryEntryImpl#getHistoryStep <em>History Step</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class HistoryEntryImpl extends StepImpl implements HistoryEntry {
	/**
	 * The cached value of the '{@link #getInitialStep() <em>Initial Step</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInitialStep()
	 * @generated
	 * @ordered
	 */
	protected Step initialStep;

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
	 * The cached value of the '{@link #getRegion() <em>Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRegion()
	 * @generated
	 * @ordered
	 */
	protected ExecutionRegion region;

	/**
	 * The cached value of the '{@link #getHistoryStep() <em>History Step</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistoryStep()
	 * @generated
	 * @ordered
	 */
	protected Step historyStep;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected HistoryEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.HISTORY_ENTRY;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Step getInitialStep() {
		return initialStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetInitialStep(Step newInitialStep, NotificationChain msgs) {
		Step oldInitialStep = initialStep;
		initialStep = newInitialStep;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.HISTORY_ENTRY__INITIAL_STEP, oldInitialStep, newInitialStep);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInitialStep(Step newInitialStep) {
		if (newInitialStep != initialStep) {
			NotificationChain msgs = null;
			if (initialStep != null)
				msgs = ((InternalEObject)initialStep).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.HISTORY_ENTRY__INITIAL_STEP, null, msgs);
			if (newInitialStep != null)
				msgs = ((InternalEObject)newInitialStep).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.HISTORY_ENTRY__INITIAL_STEP, null, msgs);
			msgs = basicSetInitialStep(newInitialStep, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.HISTORY_ENTRY__INITIAL_STEP, newInitialStep, newInitialStep));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.HISTORY_ENTRY__DEEP, oldDeep, deep));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.HISTORY_ENTRY__REGION, oldRegion, region));
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
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.HISTORY_ENTRY__REGION, oldRegion, region));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Step getHistoryStep() {
		return historyStep;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetHistoryStep(Step newHistoryStep, NotificationChain msgs) {
		Step oldHistoryStep = historyStep;
		historyStep = newHistoryStep;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SexecPackage.HISTORY_ENTRY__HISTORY_STEP, oldHistoryStep, newHistoryStep);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHistoryStep(Step newHistoryStep) {
		if (newHistoryStep != historyStep) {
			NotificationChain msgs = null;
			if (historyStep != null)
				msgs = ((InternalEObject)historyStep).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SexecPackage.HISTORY_ENTRY__HISTORY_STEP, null, msgs);
			if (newHistoryStep != null)
				msgs = ((InternalEObject)newHistoryStep).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SexecPackage.HISTORY_ENTRY__HISTORY_STEP, null, msgs);
			msgs = basicSetHistoryStep(newHistoryStep, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.HISTORY_ENTRY__HISTORY_STEP, newHistoryStep, newHistoryStep));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SexecPackage.HISTORY_ENTRY__INITIAL_STEP:
				return basicSetInitialStep(null, msgs);
			case SexecPackage.HISTORY_ENTRY__HISTORY_STEP:
				return basicSetHistoryStep(null, msgs);
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
			case SexecPackage.HISTORY_ENTRY__INITIAL_STEP:
				return getInitialStep();
			case SexecPackage.HISTORY_ENTRY__DEEP:
				return isDeep();
			case SexecPackage.HISTORY_ENTRY__REGION:
				if (resolve) return getRegion();
				return basicGetRegion();
			case SexecPackage.HISTORY_ENTRY__HISTORY_STEP:
				return getHistoryStep();
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
			case SexecPackage.HISTORY_ENTRY__INITIAL_STEP:
				setInitialStep((Step)newValue);
				return;
			case SexecPackage.HISTORY_ENTRY__DEEP:
				setDeep((Boolean)newValue);
				return;
			case SexecPackage.HISTORY_ENTRY__REGION:
				setRegion((ExecutionRegion)newValue);
				return;
			case SexecPackage.HISTORY_ENTRY__HISTORY_STEP:
				setHistoryStep((Step)newValue);
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
			case SexecPackage.HISTORY_ENTRY__INITIAL_STEP:
				setInitialStep((Step)null);
				return;
			case SexecPackage.HISTORY_ENTRY__DEEP:
				setDeep(DEEP_EDEFAULT);
				return;
			case SexecPackage.HISTORY_ENTRY__REGION:
				setRegion((ExecutionRegion)null);
				return;
			case SexecPackage.HISTORY_ENTRY__HISTORY_STEP:
				setHistoryStep((Step)null);
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
			case SexecPackage.HISTORY_ENTRY__INITIAL_STEP:
				return initialStep != null;
			case SexecPackage.HISTORY_ENTRY__DEEP:
				return deep != DEEP_EDEFAULT;
			case SexecPackage.HISTORY_ENTRY__REGION:
				return region != null;
			case SexecPackage.HISTORY_ENTRY__HISTORY_STEP:
				return historyStep != null;
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

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (deep: ");
		result.append(deep);
		result.append(')');
		return result.toString();
	}

} //HistoryEntryImpl
