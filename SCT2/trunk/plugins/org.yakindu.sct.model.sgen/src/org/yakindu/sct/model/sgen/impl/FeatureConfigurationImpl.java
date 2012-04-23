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
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.SGenPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Feature Configuration</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.FeatureConfigurationImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.FeatureConfigurationImpl#getParameterValues <em>Parameter Values</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureConfigurationImpl extends EObjectImpl implements
		FeatureConfiguration {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected FeatureType type;

	/**
	 * The cached value of the '{@link #getParameterValues()
	 * <em>Parameter Values</em>}' containment reference list. <!--
	 * begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @see #getParameterValues()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureParameterValue> parameterValues;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureConfigurationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGenPackage.Literals.FEATURE_CONFIGURATION;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (FeatureType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SGenPackage.FEATURE_CONFIGURATION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(FeatureType newType) {
		FeatureType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGenPackage.FEATURE_CONFIGURATION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FeatureParameterValue> getParameterValues() {
		if (parameterValues == null) {
			parameterValues = new EObjectContainmentWithInverseEList<FeatureParameterValue>(FeatureParameterValue.class, this, SGenPackage.FEATURE_CONFIGURATION__PARAMETER_VALUES, SGenPackage.FEATURE_PARAMETER_VALUE__FEATURE_CONFIGURATION);
		}
		return parameterValues;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public FeatureParameterValue getParameterValue(String parameterName) {
		if(parameterValues == null)
			return null;
		for (FeatureParameterValue value : parameterValues) {
			if (value.getParameter().getName() != null
					&& value.getParameter().getName().equals(parameterName)) {
				return value;
			}
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGenPackage.FEATURE_CONFIGURATION__PARAMETER_VALUES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameterValues()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd,
			int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGenPackage.FEATURE_CONFIGURATION__PARAMETER_VALUES:
				return ((InternalEList<?>)getParameterValues()).basicRemove(otherEnd, msgs);
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
			case SGenPackage.FEATURE_CONFIGURATION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case SGenPackage.FEATURE_CONFIGURATION__PARAMETER_VALUES:
				return getParameterValues();
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
			case SGenPackage.FEATURE_CONFIGURATION__TYPE:
				setType((FeatureType)newValue);
				return;
			case SGenPackage.FEATURE_CONFIGURATION__PARAMETER_VALUES:
				getParameterValues().clear();
				getParameterValues().addAll((Collection<? extends FeatureParameterValue>)newValue);
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
			case SGenPackage.FEATURE_CONFIGURATION__TYPE:
				setType((FeatureType)null);
				return;
			case SGenPackage.FEATURE_CONFIGURATION__PARAMETER_VALUES:
				getParameterValues().clear();
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
			case SGenPackage.FEATURE_CONFIGURATION__TYPE:
				return type != null;
			case SGenPackage.FEATURE_CONFIGURATION__PARAMETER_VALUES:
				return parameterValues != null && !parameterValues.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} // FeatureConfigurationImpl
