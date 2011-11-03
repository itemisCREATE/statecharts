/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.sct.model.sgen.Configuration;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.SGenPackage;

import org.yakindu.sct.model.sgraph.Statechart;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generator Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.GeneratorModelImpl#getConfigurations <em>Configurations</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.GeneratorModelImpl#getStatecharts <em>Statecharts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneratorModelImpl extends EObjectImpl implements GeneratorModel {
	/**
	 * The cached value of the '{@link #getConfigurations() <em>Configurations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfigurations()
	 * @generated
	 * @ordered
	 */
	protected EList<Configuration> configurations;

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
	protected GeneratorModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGenPackage.Literals.GENERATOR_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Configuration> getConfigurations() {
		if (configurations == null) {
			configurations = new EObjectContainmentEList<Configuration>(Configuration.class, this, SGenPackage.GENERATOR_MODEL__CONFIGURATIONS);
		}
		return configurations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Statechart> getStatecharts() {
		if (statecharts == null) {
			statecharts = new EObjectResolvingEList<Statechart>(Statechart.class, this, SGenPackage.GENERATOR_MODEL__STATECHARTS);
		}
		return statecharts;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGenPackage.GENERATOR_MODEL__CONFIGURATIONS:
				return ((InternalEList<?>)getConfigurations()).basicRemove(otherEnd, msgs);
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
			case SGenPackage.GENERATOR_MODEL__CONFIGURATIONS:
				return getConfigurations();
			case SGenPackage.GENERATOR_MODEL__STATECHARTS:
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
			case SGenPackage.GENERATOR_MODEL__CONFIGURATIONS:
				getConfigurations().clear();
				getConfigurations().addAll((Collection<? extends Configuration>)newValue);
				return;
			case SGenPackage.GENERATOR_MODEL__STATECHARTS:
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
			case SGenPackage.GENERATOR_MODEL__CONFIGURATIONS:
				getConfigurations().clear();
				return;
			case SGenPackage.GENERATOR_MODEL__STATECHARTS:
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
			case SGenPackage.GENERATOR_MODEL__CONFIGURATIONS:
				return configurations != null && !configurations.isEmpty();
			case SGenPackage.GENERATOR_MODEL__STATECHARTS:
				return statecharts != null && !statecharts.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //GeneratorModelImpl
