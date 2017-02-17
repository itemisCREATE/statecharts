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
import org.yakindu.base.types.PackageMember;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeConstraint;
import org.yakindu.base.types.TypesPackage;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Complex Type</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.types.impl.ComplexTypeImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.ComplexTypeImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.ComplexTypeImpl#getConstraint <em>Constraint</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.ComplexTypeImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.ComplexTypeImpl#isVisible <em>Visible</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.ComplexTypeImpl#getFeatures <em>Features</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.ComplexTypeImpl#getSuperTypes <em>Super Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComplexTypeImpl extends GenericElementImpl implements ComplexType {
	/**
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The default value of the '{@link #getId() <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getId()
	 * @generated
	 * @ordered
	 */
	protected static final String ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getConstraint() <em>Constraint</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConstraint()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeConstraint> constraint;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected boolean abstract_ = ABSTRACT_EDEFAULT;

	/**
	 * The default value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected static final boolean VISIBLE_EDEFAULT = true;

	/**
	 * The cached value of the '{@link #isVisible() <em>Visible</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isVisible()
	 * @generated
	 * @ordered
	 */
	protected boolean visible = VISIBLE_EDEFAULT;

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
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectResolvingEList<Annotation>(Annotation.class, this, TypesPackage.COMPLEX_TYPE__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getId() {
		// TODO: implement this method to return the 'Id' attribute
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeConstraint> getConstraint() {
		if (constraint == null) {
			constraint = new EObjectContainmentEList<TypeConstraint>(TypeConstraint.class, this, TypesPackage.COMPLEX_TYPE__CONSTRAINT);
		}
		return constraint;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.COMPLEX_TYPE__ABSTRACT, oldAbstract, abstract_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isVisible() {
		return visible;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setVisible(boolean newVisible) {
		boolean oldVisible = visible;
		visible = newVisible;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.COMPLEX_TYPE__VISIBLE, oldVisible, visible));
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
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getOriginType() {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
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
			case TypesPackage.COMPLEX_TYPE__CONSTRAINT:
				return ((InternalEList<?>)getConstraint()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.COMPLEX_TYPE__ANNOTATIONS:
				return getAnnotations();
			case TypesPackage.COMPLEX_TYPE__ID:
				return getId();
			case TypesPackage.COMPLEX_TYPE__CONSTRAINT:
				return getConstraint();
			case TypesPackage.COMPLEX_TYPE__ABSTRACT:
				return isAbstract();
			case TypesPackage.COMPLEX_TYPE__VISIBLE:
				return isVisible();
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
			case TypesPackage.COMPLEX_TYPE__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case TypesPackage.COMPLEX_TYPE__CONSTRAINT:
				getConstraint().clear();
				getConstraint().addAll((Collection<? extends TypeConstraint>)newValue);
				return;
			case TypesPackage.COMPLEX_TYPE__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case TypesPackage.COMPLEX_TYPE__VISIBLE:
				setVisible((Boolean)newValue);
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
			case TypesPackage.COMPLEX_TYPE__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case TypesPackage.COMPLEX_TYPE__CONSTRAINT:
				getConstraint().clear();
				return;
			case TypesPackage.COMPLEX_TYPE__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case TypesPackage.COMPLEX_TYPE__VISIBLE:
				setVisible(VISIBLE_EDEFAULT);
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
			case TypesPackage.COMPLEX_TYPE__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case TypesPackage.COMPLEX_TYPE__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case TypesPackage.COMPLEX_TYPE__CONSTRAINT:
				return constraint != null && !constraint.isEmpty();
			case TypesPackage.COMPLEX_TYPE__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case TypesPackage.COMPLEX_TYPE__VISIBLE:
				return visible != VISIBLE_EDEFAULT;
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
		if (baseClass == AnnotatableElement.class) {
			switch (derivedFeatureID) {
				case TypesPackage.COMPLEX_TYPE__ANNOTATIONS: return TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == PackageMember.class) {
			switch (derivedFeatureID) {
				case TypesPackage.COMPLEX_TYPE__ID: return TypesPackage.PACKAGE_MEMBER__ID;
				default: return -1;
			}
		}
		if (baseClass == Type.class) {
			switch (derivedFeatureID) {
				case TypesPackage.COMPLEX_TYPE__CONSTRAINT: return TypesPackage.TYPE__CONSTRAINT;
				case TypesPackage.COMPLEX_TYPE__ABSTRACT: return TypesPackage.TYPE__ABSTRACT;
				case TypesPackage.COMPLEX_TYPE__VISIBLE: return TypesPackage.TYPE__VISIBLE;
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
		if (baseClass == AnnotatableElement.class) {
			switch (baseFeatureID) {
				case TypesPackage.ANNOTATABLE_ELEMENT__ANNOTATIONS: return TypesPackage.COMPLEX_TYPE__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == PackageMember.class) {
			switch (baseFeatureID) {
				case TypesPackage.PACKAGE_MEMBER__ID: return TypesPackage.COMPLEX_TYPE__ID;
				default: return -1;
			}
		}
		if (baseClass == Type.class) {
			switch (baseFeatureID) {
				case TypesPackage.TYPE__CONSTRAINT: return TypesPackage.COMPLEX_TYPE__CONSTRAINT;
				case TypesPackage.TYPE__ABSTRACT: return TypesPackage.COMPLEX_TYPE__ABSTRACT;
				case TypesPackage.TYPE__VISIBLE: return TypesPackage.COMPLEX_TYPE__VISIBLE;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
		result.append(" (abstract: ");
		result.append(abstract_);
		result.append(", visible: ");
		result.append(visible);
		result.append(')');
		return result.toString();
	}

} // ComplexTypeImpl
