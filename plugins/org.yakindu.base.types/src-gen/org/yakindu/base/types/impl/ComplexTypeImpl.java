/**
 */
package org.yakindu.base.types.impl;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.types.AnnotatableElement;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Declaration;
import org.yakindu.base.types.GenericElement;
import org.yakindu.base.types.PackageMember;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeConstraint;
import org.yakindu.base.types.TypeParameter;
import org.yakindu.base.types.TypesPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Complex Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.types.impl.ComplexTypeImpl#getTypeParameters <em>Type Parameters</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.ComplexTypeImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.ComplexTypeImpl#getSuperTypes <em>Super Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexTypeImpl extends TypeImpl implements ComplexType {
	/**
	 * The cached value of the '{@link #getTypeParameters() <em>Type Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeParameter> typeParameters;

	/**
	 * The cached value of the '{@link #getFeatures() <em>Features</em>}' containment reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getFeatures()
	 * @generated
	 * @ordered
	 */
	protected EList<Declaration> features;

	/**
	 * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' reference list.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<ComplexType> superTypes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected ComplexTypeImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.COMPLEX_TYPE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeParameter> getTypeParameters() {
		if (typeParameters == null) {
			typeParameters = new EObjectContainmentEList<TypeParameter>(TypeParameter.class, this, TypesPackage.COMPLEX_TYPE__TYPE_PARAMETERS);
		}
		return typeParameters;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Declaration> getFeatures() {
		if (features == null) {
			features = new EObjectContainmentEList<Declaration>(Declaration.class, this, TypesPackage.COMPLEX_TYPE__FEATURES);
		}
		return features;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComplexType> getSuperTypes() {
		if (superTypes == null) {
			superTypes = new EObjectResolvingEList<ComplexType>(ComplexType.class, this, TypesPackage.COMPLEX_TYPE__SUPER_TYPES);
		}
		return superTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public EList<Declaration> getAllFeatures() {
		EList<Declaration> features = new BasicEList<Declaration>();
		collectFeatures(this, features, new HashSet<Type>());
		return features;
	}

	/**
	 * Performs a simple search to collect all features of the type and all
	 * super types.
	 * 
	 */
	protected void collectFeatures(Type type, List<Declaration> features, Set<Type> visited) {
		if (type == null || visited.contains(type))
			return;
		if (type instanceof ComplexType) {
			for (Type superType : ((ComplexType) type).getSuperTypes()) {
				collectFeatures(superType, features, visited);
			}
			features.addAll(((ComplexType) type).getFeatures());
		}
		visited.add(type);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.COMPLEX_TYPE__TYPE_PARAMETERS:
				return ((InternalEList<?>)getTypeParameters()).basicRemove(otherEnd, msgs);
			case TypesPackage.COMPLEX_TYPE__FEATURES:
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
			case TypesPackage.COMPLEX_TYPE__TYPE_PARAMETERS:
				return getTypeParameters();
			case TypesPackage.COMPLEX_TYPE__FEATURES:
				return getFeatures();
			case TypesPackage.COMPLEX_TYPE__SUPER_TYPES:
				return getSuperTypes();
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
			case TypesPackage.COMPLEX_TYPE__TYPE_PARAMETERS:
				getTypeParameters().clear();
				getTypeParameters().addAll((Collection<? extends TypeParameter>)newValue);
				return;
			case TypesPackage.COMPLEX_TYPE__FEATURES:
				getFeatures().clear();
				getFeatures().addAll((Collection<? extends Declaration>)newValue);
				return;
			case TypesPackage.COMPLEX_TYPE__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends ComplexType>)newValue);
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
			case TypesPackage.COMPLEX_TYPE__TYPE_PARAMETERS:
				getTypeParameters().clear();
				return;
			case TypesPackage.COMPLEX_TYPE__FEATURES:
				getFeatures().clear();
				return;
			case TypesPackage.COMPLEX_TYPE__SUPER_TYPES:
				getSuperTypes().clear();
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
			case TypesPackage.COMPLEX_TYPE__TYPE_PARAMETERS:
				return typeParameters != null && !typeParameters.isEmpty();
			case TypesPackage.COMPLEX_TYPE__FEATURES:
				return features != null && !features.isEmpty();
			case TypesPackage.COMPLEX_TYPE__SUPER_TYPES:
				return superTypes != null && !superTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == GenericElement.class) {
			switch (derivedFeatureID) {
				case TypesPackage.COMPLEX_TYPE__TYPE_PARAMETERS: return TypesPackage.GENERIC_ELEMENT__TYPE_PARAMETERS;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == GenericElement.class) {
			switch (baseFeatureID) {
				case TypesPackage.GENERIC_ELEMENT__TYPE_PARAMETERS: return TypesPackage.COMPLEX_TYPE__TYPE_PARAMETERS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} // ComplexTypeImpl
