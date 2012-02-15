/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sgen.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.SGenPackage;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Generator Entry</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl#getStatechart <em>Statechart</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl#getFeatures <em>Features</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneratorEntryImpl extends EObjectImpl implements GeneratorEntry {
	/**
	 * The cached value of the '{@link #getStatechart() <em>Statechart</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getStatechart()
	 * @generated
	 * @ordered
	 */
	protected Statechart statechart;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureConfiguration> features;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected GeneratorEntryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGenPackage.Literals.GENERATOR_ENTRY;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Statechart getStatechart() {
		if (statechart != null && statechart.eIsProxy()) {
			InternalEObject oldStatechart = (InternalEObject)statechart;
			statechart = (Statechart)eResolveProxy(oldStatechart);
			if (statechart != oldStatechart) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SGenPackage.GENERATOR_ENTRY__STATECHART, oldStatechart, statechart));
			}
		}
		return statechart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Statechart basicGetStatechart() {
		return statechart;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatechart(Statechart newStatechart) {
		Statechart oldStatechart = statechart;
		statechart = newStatechart;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGenPackage.GENERATOR_ENTRY__STATECHART, oldStatechart, statechart));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureConfiguration> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<FeatureConfiguration>(FeatureConfiguration.class, this, SGenPackage.GENERATOR_ENTRY__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public FeatureConfiguration getFeatureConfiguration(String featureName) {
		for (FeatureConfiguration configuration : features) {
			if (configuration.getType().getName() != null
					&& configuration.getType().getName().equals(featureName))
				return configuration;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGenPackage.GENERATOR_ENTRY__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SGenPackage.GENERATOR_ENTRY__STATECHART:
				if (resolve) return getStatechart();
				return basicGetStatechart();
			case SGenPackage.GENERATOR_ENTRY__FEATURES:
				return getFeatures();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SGenPackage.GENERATOR_ENTRY__STATECHART:
				setStatechart((Statechart)newValue);
				return;
			case SGenPackage.GENERATOR_ENTRY__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends FeatureConfiguration>)newValue);
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
			case SGenPackage.GENERATOR_ENTRY__STATECHART:
				setStatechart((Statechart)null);
				return;
			case SGenPackage.GENERATOR_ENTRY__FEATURES:
				getFeatures().clear();
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
			case SGenPackage.GENERATOR_ENTRY__STATECHART:
				return statechart != null;
			case SGenPackage.GENERATOR_ENTRY__FEATURES:
				return features != null && !features.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // GeneratorEntryImpl
