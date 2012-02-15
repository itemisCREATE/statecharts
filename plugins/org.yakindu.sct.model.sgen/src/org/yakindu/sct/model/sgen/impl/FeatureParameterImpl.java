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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.base.impl.NamedElementImpl;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.ParameterTypes;
import org.yakindu.sct.model.sgen.SGenPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Feature Parameter</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.FeatureParameterImpl#getFeatureType <em>Feature Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.FeatureParameterImpl#isOptional <em>Optional</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.FeatureParameterImpl#getParameterType <em>Parameter Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class FeatureParameterImpl extends NamedElementImpl implements FeatureParameter {
	/**
	 * The default value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected static final boolean OPTIONAL_EDEFAULT = false;
	/**
	 * The cached value of the '{@link #isOptional() <em>Optional</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isOptional()
	 * @generated
	 * @ordered
	 */
	protected boolean optional = OPTIONAL_EDEFAULT;
	/**
	 * The default value of the '{@link #getParameterType() <em>Parameter Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterType()
	 * @generated
	 * @ordered
	 */
	protected static final ParameterTypes PARAMETER_TYPE_EDEFAULT = ParameterTypes.STRING;
	/**
	 * The cached value of the '{@link #getParameterType() <em>Parameter Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameterType()
	 * @generated
	 * @ordered
	 */
	protected ParameterTypes parameterType = PARAMETER_TYPE_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FeatureParameterImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGenPackage.Literals.FEATURE_PARAMETER;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FeatureType getFeatureType() {
		if (eContainerFeatureID() != SGenPackage.FEATURE_PARAMETER__FEATURE_TYPE) return null;
		return (FeatureType)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetFeatureType(FeatureType newFeatureType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newFeatureType, SGenPackage.FEATURE_PARAMETER__FEATURE_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFeatureType(FeatureType newFeatureType) {
		if (newFeatureType != eInternalContainer() || (eContainerFeatureID() != SGenPackage.FEATURE_PARAMETER__FEATURE_TYPE && newFeatureType != null)) {
			if (EcoreUtil.isAncestor(this, newFeatureType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newFeatureType != null)
				msgs = ((InternalEObject)newFeatureType).eInverseAdd(this, SGenPackage.FEATURE_TYPE__PARAMETERS, FeatureType.class, msgs);
			msgs = basicSetFeatureType(newFeatureType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGenPackage.FEATURE_PARAMETER__FEATURE_TYPE, newFeatureType, newFeatureType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isOptional() {
		return optional;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOptional(boolean newOptional) {
		boolean oldOptional = optional;
		optional = newOptional;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGenPackage.FEATURE_PARAMETER__OPTIONAL, oldOptional, optional));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ParameterTypes getParameterType() {
		return parameterType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParameterType(ParameterTypes newParameterType) {
		ParameterTypes oldParameterType = parameterType;
		parameterType = newParameterType == null ? PARAMETER_TYPE_EDEFAULT : newParameterType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGenPackage.FEATURE_PARAMETER__PARAMETER_TYPE, oldParameterType, parameterType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGenPackage.FEATURE_PARAMETER__FEATURE_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetFeatureType((FeatureType)otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case SGenPackage.FEATURE_PARAMETER__FEATURE_TYPE:
				return basicSetFeatureType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case SGenPackage.FEATURE_PARAMETER__FEATURE_TYPE:
				return eInternalContainer().eInverseRemove(this, SGenPackage.FEATURE_TYPE__PARAMETERS, FeatureType.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SGenPackage.FEATURE_PARAMETER__FEATURE_TYPE:
				return getFeatureType();
			case SGenPackage.FEATURE_PARAMETER__OPTIONAL:
				return isOptional();
			case SGenPackage.FEATURE_PARAMETER__PARAMETER_TYPE:
				return getParameterType();
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
			case SGenPackage.FEATURE_PARAMETER__FEATURE_TYPE:
				setFeatureType((FeatureType)newValue);
				return;
			case SGenPackage.FEATURE_PARAMETER__OPTIONAL:
				setOptional((Boolean)newValue);
				return;
			case SGenPackage.FEATURE_PARAMETER__PARAMETER_TYPE:
				setParameterType((ParameterTypes)newValue);
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
			case SGenPackage.FEATURE_PARAMETER__FEATURE_TYPE:
				setFeatureType((FeatureType)null);
				return;
			case SGenPackage.FEATURE_PARAMETER__OPTIONAL:
				setOptional(OPTIONAL_EDEFAULT);
				return;
			case SGenPackage.FEATURE_PARAMETER__PARAMETER_TYPE:
				setParameterType(PARAMETER_TYPE_EDEFAULT);
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
			case SGenPackage.FEATURE_PARAMETER__FEATURE_TYPE:
				return getFeatureType() != null;
			case SGenPackage.FEATURE_PARAMETER__OPTIONAL:
				return optional != OPTIONAL_EDEFAULT;
			case SGenPackage.FEATURE_PARAMETER__PARAMETER_TYPE:
				return parameterType != PARAMETER_TYPE_EDEFAULT;
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
		result.append(" (optional: ");
		result.append(optional);
		result.append(", parameterType: ");
		result.append(parameterType);
		result.append(')');
		return result.toString();
	}

} //FeatureParameterImpl
