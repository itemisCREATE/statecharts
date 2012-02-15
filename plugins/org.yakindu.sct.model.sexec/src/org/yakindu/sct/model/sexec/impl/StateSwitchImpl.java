/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.sct.model.sexec.ExecutionRegion;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.StateCase;
import org.yakindu.sct.model.sexec.StateSwitch;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>State Switch</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.StateSwitchImpl#getCases <em>Cases</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.StateSwitchImpl#getStateConfigurationIdx <em>State Configuration Idx</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.StateSwitchImpl#getHistoryRegion <em>History Region</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StateSwitchImpl extends StepImpl implements StateSwitch {
	/**
	 * The cached value of the '{@link #getCases() <em>Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCases()
	 * @generated
	 * @ordered
	 */
	protected EList<StateCase> cases;

	/**
	 * The default value of the '{@link #getStateConfigurationIdx() <em>State Configuration Idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateConfigurationIdx()
	 * @generated
	 * @ordered
	 */
	protected static final int STATE_CONFIGURATION_IDX_EDEFAULT = 0;
	/**
	 * The cached value of the '{@link #getStateConfigurationIdx() <em>State Configuration Idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStateConfigurationIdx()
	 * @generated
	 * @ordered
	 */
	protected int stateConfigurationIdx = STATE_CONFIGURATION_IDX_EDEFAULT;

	/**
	 * The cached value of the '{@link #getHistoryRegion() <em>History Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHistoryRegion()
	 * @generated
	 * @ordered
	 */
	protected ExecutionRegion historyRegion;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateSwitchImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.STATE_SWITCH;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<StateCase> getCases() {
		if (cases == null) {
			cases = new EObjectContainmentEList<StateCase>(StateCase.class, this, SexecPackage.STATE_SWITCH__CASES);
		}
		return cases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getStateConfigurationIdx() {
		return stateConfigurationIdx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStateConfigurationIdx(int newStateConfigurationIdx) {
		int oldStateConfigurationIdx = stateConfigurationIdx;
		stateConfigurationIdx = newStateConfigurationIdx;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.STATE_SWITCH__STATE_CONFIGURATION_IDX, oldStateConfigurationIdx, stateConfigurationIdx));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionRegion getHistoryRegion() {
		if (historyRegion != null && historyRegion.eIsProxy()) {
			InternalEObject oldHistoryRegion = (InternalEObject)historyRegion;
			historyRegion = (ExecutionRegion)eResolveProxy(oldHistoryRegion);
			if (historyRegion != oldHistoryRegion) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.STATE_SWITCH__HISTORY_REGION, oldHistoryRegion, historyRegion));
			}
		}
		return historyRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExecutionRegion basicGetHistoryRegion() {
		return historyRegion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setHistoryRegion(ExecutionRegion newHistoryRegion) {
		ExecutionRegion oldHistoryRegion = historyRegion;
		historyRegion = newHistoryRegion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.STATE_SWITCH__HISTORY_REGION, oldHistoryRegion, historyRegion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SexecPackage.STATE_SWITCH__CASES:
				return ((InternalEList<?>)getCases()).basicRemove(otherEnd, msgs);
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
			case SexecPackage.STATE_SWITCH__CASES:
				return getCases();
			case SexecPackage.STATE_SWITCH__STATE_CONFIGURATION_IDX:
				return getStateConfigurationIdx();
			case SexecPackage.STATE_SWITCH__HISTORY_REGION:
				if (resolve) return getHistoryRegion();
				return basicGetHistoryRegion();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SexecPackage.STATE_SWITCH__CASES:
				getCases().clear();
				getCases().addAll((Collection<? extends StateCase>)newValue);
				return;
			case SexecPackage.STATE_SWITCH__STATE_CONFIGURATION_IDX:
				setStateConfigurationIdx((Integer)newValue);
				return;
			case SexecPackage.STATE_SWITCH__HISTORY_REGION:
				setHistoryRegion((ExecutionRegion)newValue);
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
			case SexecPackage.STATE_SWITCH__CASES:
				getCases().clear();
				return;
			case SexecPackage.STATE_SWITCH__STATE_CONFIGURATION_IDX:
				setStateConfigurationIdx(STATE_CONFIGURATION_IDX_EDEFAULT);
				return;
			case SexecPackage.STATE_SWITCH__HISTORY_REGION:
				setHistoryRegion((ExecutionRegion)null);
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
			case SexecPackage.STATE_SWITCH__CASES:
				return cases != null && !cases.isEmpty();
			case SexecPackage.STATE_SWITCH__STATE_CONFIGURATION_IDX:
				return stateConfigurationIdx != STATE_CONFIGURATION_IDX_EDEFAULT;
			case SexecPackage.STATE_SWITCH__HISTORY_REGION:
				return historyRegion != null;
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
		result.append(" (stateConfigurationIdx: ");
		result.append(stateConfigurationIdx);
		result.append(')');
		return result.toString();
	}

} //StateSwitchImpl
