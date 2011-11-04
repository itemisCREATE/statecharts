/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.yakindu.sct.model.sgen.GeneratorConfiguration;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.sgen.StatechartReferences;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Generator Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.GeneratorModelImpl#getConfiguration <em>Configuration</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.GeneratorModelImpl#getStatechartReferences <em>Statechart References</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneratorModelImpl extends EObjectImpl implements GeneratorModel {
	/**
	 * The cached value of the '{@link #getConfiguration() <em>Configuration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfiguration()
	 * @generated
	 * @ordered
	 */
	protected GeneratorConfiguration configuration;

	/**
	 * The cached value of the '{@link #getStatechartReferences() <em>Statechart References</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStatechartReferences()
	 * @generated
	 * @ordered
	 */
	protected StatechartReferences statechartReferences;

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
	public GeneratorConfiguration getConfiguration() {
		return configuration;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetConfiguration(GeneratorConfiguration newConfiguration, NotificationChain msgs) {
		GeneratorConfiguration oldConfiguration = configuration;
		configuration = newConfiguration;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SGenPackage.GENERATOR_MODEL__CONFIGURATION, oldConfiguration, newConfiguration);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfiguration(GeneratorConfiguration newConfiguration) {
		if (newConfiguration != configuration) {
			NotificationChain msgs = null;
			if (configuration != null)
				msgs = ((InternalEObject)configuration).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SGenPackage.GENERATOR_MODEL__CONFIGURATION, null, msgs);
			if (newConfiguration != null)
				msgs = ((InternalEObject)newConfiguration).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SGenPackage.GENERATOR_MODEL__CONFIGURATION, null, msgs);
			msgs = basicSetConfiguration(newConfiguration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGenPackage.GENERATOR_MODEL__CONFIGURATION, newConfiguration, newConfiguration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StatechartReferences getStatechartReferences() {
		return statechartReferences;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStatechartReferences(StatechartReferences newStatechartReferences, NotificationChain msgs) {
		StatechartReferences oldStatechartReferences = statechartReferences;
		statechartReferences = newStatechartReferences;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, SGenPackage.GENERATOR_MODEL__STATECHART_REFERENCES, oldStatechartReferences, newStatechartReferences);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatechartReferences(StatechartReferences newStatechartReferences) {
		if (newStatechartReferences != statechartReferences) {
			NotificationChain msgs = null;
			if (statechartReferences != null)
				msgs = ((InternalEObject)statechartReferences).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - SGenPackage.GENERATOR_MODEL__STATECHART_REFERENCES, null, msgs);
			if (newStatechartReferences != null)
				msgs = ((InternalEObject)newStatechartReferences).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - SGenPackage.GENERATOR_MODEL__STATECHART_REFERENCES, null, msgs);
			msgs = basicSetStatechartReferences(newStatechartReferences, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGenPackage.GENERATOR_MODEL__STATECHART_REFERENCES, newStatechartReferences, newStatechartReferences));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGenPackage.GENERATOR_MODEL__CONFIGURATION:
				return basicSetConfiguration(null, msgs);
			case SGenPackage.GENERATOR_MODEL__STATECHART_REFERENCES:
				return basicSetStatechartReferences(null, msgs);
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
			case SGenPackage.GENERATOR_MODEL__CONFIGURATION:
				return getConfiguration();
			case SGenPackage.GENERATOR_MODEL__STATECHART_REFERENCES:
				return getStatechartReferences();
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
			case SGenPackage.GENERATOR_MODEL__CONFIGURATION:
				setConfiguration((GeneratorConfiguration)newValue);
				return;
			case SGenPackage.GENERATOR_MODEL__STATECHART_REFERENCES:
				setStatechartReferences((StatechartReferences)newValue);
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
			case SGenPackage.GENERATOR_MODEL__CONFIGURATION:
				setConfiguration((GeneratorConfiguration)null);
				return;
			case SGenPackage.GENERATOR_MODEL__STATECHART_REFERENCES:
				setStatechartReferences((StatechartReferences)null);
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
			case SGenPackage.GENERATOR_MODEL__CONFIGURATION:
				return configuration != null;
			case SGenPackage.GENERATOR_MODEL__STATECHART_REFERENCES:
				return statechartReferences != null;
		}
		return super.eIsSet(featureID);
	}

} //GeneratorModelImpl
