/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.sgen.StatechartReferences;

import org.yakindu.sct.model.sgraph.Statechart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Statechart References</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.StatechartReferencesImpl#getStatecharts <em>Statecharts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class StatechartReferencesImpl extends EObjectImpl implements StatechartReferences {
	/**
	 * The cached value of the '{@link #getStatecharts() <em>Statecharts</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatecharts()
	 * @generated
	 * @ordered
	 */
	protected EList<Statechart> statecharts;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatechartReferencesImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGenPackage.Literals.STATECHART_REFERENCES;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statechart> getStatecharts() {
		if (statecharts == null) {
			statecharts = new EObjectResolvingEList<Statechart>(Statechart.class, this, SGenPackage.STATECHART_REFERENCES__STATECHARTS);
		}
		return statecharts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SGenPackage.STATECHART_REFERENCES__STATECHARTS:
				return getStatecharts();
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
			case SGenPackage.STATECHART_REFERENCES__STATECHARTS:
				getStatecharts().clear();
				getStatecharts().addAll((Collection<? extends Statechart>)newValue);
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
			case SGenPackage.STATECHART_REFERENCES__STATECHARTS:
				getStatecharts().clear();
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
			case SGenPackage.STATECHART_REFERENCES__STATECHARTS:
				return statecharts != null && !statecharts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //StatechartReferencesImpl
