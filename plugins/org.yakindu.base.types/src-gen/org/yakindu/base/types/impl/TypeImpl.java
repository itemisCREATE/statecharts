/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.base.types.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.base.impl.NamedElementImpl;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.Library;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.base.types.impl.TypeImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.TypeImpl#getSuperTypes <em>Super Types</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.TypeImpl#getOwningLibrary <em>Owning Library</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeImpl extends NamedElementImpl implements Type {
	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Feature> features;

	/**
	 * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> superTypes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Feature> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentWithInverseEList<Feature>(Feature.class, this, TypesPackage.TYPE__FEATURES, TypesPackage.FEATURE__OWNING_TYPE);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getSuperTypes() {
		if (superTypes == null) {
			superTypes = new EObjectResolvingEList<Type>(Type.class, this, TypesPackage.TYPE__SUPER_TYPES);
		}
		return superTypes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Library getOwningLibrary() {
		if (eContainerFeatureID() != TypesPackage.TYPE__OWNING_LIBRARY) return null;
		return (Library)eContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningLibrary(Library newOwningLibrary, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningLibrary, TypesPackage.TYPE__OWNING_LIBRARY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningLibrary(Library newOwningLibrary) {
		if (newOwningLibrary != eInternalContainer() || (eContainerFeatureID() != TypesPackage.TYPE__OWNING_LIBRARY && newOwningLibrary != null)) {
			if (EcoreUtil.isAncestor(this, newOwningLibrary))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningLibrary != null)
				msgs = ((InternalEObject)newOwningLibrary).eInverseAdd(this, TypesPackage.LIBRARY__TYPES, Library.class, msgs);
			msgs = basicSetOwningLibrary(newOwningLibrary, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.TYPE__OWNING_LIBRARY, newOwningLibrary, newOwningLibrary));
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
			case TypesPackage.TYPE__FEATURES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeatures()).basicAdd(otherEnd, msgs);
			case TypesPackage.TYPE__OWNING_LIBRARY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningLibrary((Library)otherEnd, msgs);
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
			case TypesPackage.TYPE__FEATURES:
				return ((InternalEList<?>)getFeatures()).basicRemove(otherEnd, msgs);
			case TypesPackage.TYPE__OWNING_LIBRARY:
				return basicSetOwningLibrary(null, msgs);
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
			case TypesPackage.TYPE__OWNING_LIBRARY:
				return eInternalContainer().eInverseRemove(this, TypesPackage.LIBRARY__TYPES, Library.class, msgs);
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
			case TypesPackage.TYPE__FEATURES:
				return getFeatures();
			case TypesPackage.TYPE__SUPER_TYPES:
				return getSuperTypes();
			case TypesPackage.TYPE__OWNING_LIBRARY:
				return getOwningLibrary();
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
			case TypesPackage.TYPE__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Feature>)newValue);
				return;
			case TypesPackage.TYPE__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends Type>)newValue);
				return;
			case TypesPackage.TYPE__OWNING_LIBRARY:
				setOwningLibrary((Library)newValue);
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
			case TypesPackage.TYPE__FEATURES:
				getFeatures().clear();
				return;
			case TypesPackage.TYPE__SUPER_TYPES:
				getSuperTypes().clear();
				return;
			case TypesPackage.TYPE__OWNING_LIBRARY:
				setOwningLibrary((Library)null);
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
			case TypesPackage.TYPE__FEATURES:
				return features != null && !features.isEmpty();
			case TypesPackage.TYPE__SUPER_TYPES:
				return superTypes != null && !superTypes.isEmpty();
			case TypesPackage.TYPE__OWNING_LIBRARY:
				return getOwningLibrary() != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String toString() {
		return name;
	}

} //TypeImpl
