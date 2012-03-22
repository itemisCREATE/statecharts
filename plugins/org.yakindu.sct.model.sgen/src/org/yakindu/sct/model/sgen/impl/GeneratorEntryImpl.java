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
import org.eclipse.emf.ecore.EObject;
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
 *   <li>{@link org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl#getElementRef <em>Element Ref</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.impl.GeneratorEntryImpl#getContentType <em>Content Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class GeneratorEntryImpl extends EObjectImpl implements GeneratorEntry {
	/**
	 * The cached value of the '{@link #getElementRef() <em>Element Ref</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementRef()
	 * @generated
	 * @ordered
	 */
	protected EObject elementRef;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<FeatureConfiguration> features;

	/**
	 * The default value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentType()
	 * @generated
	 * @ordered
	 */
	protected static final String CONTENT_TYPE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getContentType() <em>Content Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getContentType()
	 * @generated
	 * @ordered
	 */
	protected String contentType = CONTENT_TYPE_EDEFAULT;

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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject getElementRef() {
		if (elementRef != null && elementRef.eIsProxy()) {
			InternalEObject oldElementRef = (InternalEObject)elementRef;
			elementRef = eResolveProxy(oldElementRef);
			if (elementRef != oldElementRef) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SGenPackage.GENERATOR_ENTRY__ELEMENT_REF, oldElementRef, elementRef));
			}
		}
		return elementRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject basicGetElementRef() {
		return elementRef;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setElementRef(EObject newElementRef) {
		EObject oldElementRef = elementRef;
		elementRef = newElementRef;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGenPackage.GENERATOR_ENTRY__ELEMENT_REF, oldElementRef, elementRef));
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getContentType() {
		return contentType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setContentType(String newContentType) {
		String oldContentType = contentType;
		contentType = newContentType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SGenPackage.GENERATOR_ENTRY__CONTENT_TYPE, oldContentType, contentType));
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
			case SGenPackage.GENERATOR_ENTRY__ELEMENT_REF:
				if (resolve) return getElementRef();
				return basicGetElementRef();
			case SGenPackage.GENERATOR_ENTRY__FEATURES:
				return getFeatures();
			case SGenPackage.GENERATOR_ENTRY__CONTENT_TYPE:
				return getContentType();
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
			case SGenPackage.GENERATOR_ENTRY__ELEMENT_REF:
				setElementRef((EObject)newValue);
				return;
			case SGenPackage.GENERATOR_ENTRY__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends FeatureConfiguration>)newValue);
				return;
			case SGenPackage.GENERATOR_ENTRY__CONTENT_TYPE:
				setContentType((String)newValue);
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
			case SGenPackage.GENERATOR_ENTRY__ELEMENT_REF:
				setElementRef((EObject)null);
				return;
			case SGenPackage.GENERATOR_ENTRY__FEATURES:
				getFeatures().clear();
				return;
			case SGenPackage.GENERATOR_ENTRY__CONTENT_TYPE:
				setContentType(CONTENT_TYPE_EDEFAULT);
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
			case SGenPackage.GENERATOR_ENTRY__ELEMENT_REF:
				return elementRef != null;
			case SGenPackage.GENERATOR_ENTRY__FEATURES:
				return features != null && !features.isEmpty();
			case SGenPackage.GENERATOR_ENTRY__CONTENT_TYPE:
				return CONTENT_TYPE_EDEFAULT == null ? contentType != null : !CONTENT_TYPE_EDEFAULT.equals(contentType);
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
		result.append(" (contentType: ");
		result.append(contentType);
		result.append(')');
		return result.toString();
	}

} // GeneratorEntryImpl
