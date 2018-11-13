/**
 */
package org.yakindu.base.types.impl;

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
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.types.AnnotatableElement;
import org.yakindu.base.types.Annotation;
import org.yakindu.base.types.PackageMember;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypeAlias;
import org.yakindu.base.types.TypeSpecifier;
import org.yakindu.base.types.TypesPackage;
import org.yakindu.base.types.TypesUtil;

/**
 * <!-- begin-user-doc --> An implementation of the model object '
 * <em><b>Type Alias</b></em>'. <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.types.impl.TypeAliasImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.TypeAliasImpl#getTypeSpecifier <em>Type Specifier</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.TypeAliasImpl#getName <em>Name</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.TypeAliasImpl#getId <em>Id</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.TypeAliasImpl#getAnnotations <em>Annotations</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.TypeAliasImpl#isAbstract <em>Abstract</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.TypeAliasImpl#isVisible <em>Visible</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.TypeAliasImpl#getSuperTypes <em>Super Types</em>}</li>
 * </ul>
 *
 * @generated
 */
public class TypeAliasImpl extends EObjectImpl implements TypeAlias {
	/**
	 * The cached value of the '{@link #getTypeSpecifier() <em>Type Specifier</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeSpecifier()
	 * @generated
	 * @ordered
	 */
	protected TypeSpecifier typeSpecifier;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

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
	 * The cached value of the '{@link #getAnnotations() <em>Annotations</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAnnotations()
	 * @generated
	 * @ordered
	 */
	protected EList<Annotation> annotations;

	/**
	 * The default value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @see #isAbstract()
	 * @generated
	 * @ordered
	 */
	protected static final boolean ABSTRACT_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isAbstract() <em>Abstract</em>}' attribute.
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
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
	 * The cached value of the '{@link #getSuperTypes() <em>Super Types</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSuperTypes()
	 * @generated
	 * @ordered
	 */
	protected EList<TypeSpecifier> superTypes;

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	protected TypeAliasImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.TYPE_ALIAS;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		Type type = basicGetType();
		return type != null && type.eIsProxy() ? (Type)eResolveProxy((InternalEObject)type) : type;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated NOT
	 */
	public Type basicGetType() {
		if (getTypeSpecifier() != null) {
			return getTypeSpecifier().getType();
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TypeSpecifier getTypeSpecifier() {
		return typeSpecifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTypeSpecifier(TypeSpecifier newTypeSpecifier, NotificationChain msgs) {
		TypeSpecifier oldTypeSpecifier = typeSpecifier;
		typeSpecifier = newTypeSpecifier;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TypesPackage.TYPE_ALIAS__TYPE_SPECIFIER, oldTypeSpecifier, newTypeSpecifier);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTypeSpecifier(TypeSpecifier newTypeSpecifier) {
		if (newTypeSpecifier != typeSpecifier) {
			NotificationChain msgs = null;
			if (typeSpecifier != null)
				msgs = ((InternalEObject)typeSpecifier).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TypesPackage.TYPE_ALIAS__TYPE_SPECIFIER, null, msgs);
			if (newTypeSpecifier != null)
				msgs = ((InternalEObject)newTypeSpecifier).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TypesPackage.TYPE_ALIAS__TYPE_SPECIFIER, null, msgs);
			msgs = basicSetTypeSpecifier(newTypeSpecifier, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.TYPE_ALIAS__TYPE_SPECIFIER, newTypeSpecifier, newTypeSpecifier));
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.TYPE_ALIAS__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Annotation> getAnnotations() {
		if (annotations == null) {
			annotations = new EObjectContainmentEList<Annotation>(Annotation.class, this, TypesPackage.TYPE_ALIAS__ANNOTATIONS);
		}
		return annotations;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Annotation getAnnotationOfType(String typeName) {
		// TODO: implement this method
		// Ensure that you remove @generated or mark it @generated NOT
		throw new UnsupportedOperationException();
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAbstract() {
		return abstract_;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	public void setAbstract(boolean newAbstract) {
		boolean oldAbstract = abstract_;
		abstract_ = newAbstract;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.TYPE_ALIAS__ABSTRACT, oldAbstract, abstract_));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.TYPE_ALIAS__VISIBLE, oldVisible, visible));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<TypeSpecifier> getSuperTypes() {
		if (superTypes == null) {
			superTypes = new EObjectContainmentEList<TypeSpecifier>(TypeSpecifier.class, this, TypesPackage.TYPE_ALIAS__SUPER_TYPES);
		}
		return superTypes;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * 
	 * @generated NOT
	 */
	public Type getOriginType() {
		Type baseType = getType();
		if (baseType instanceof TypeAlias && baseType != this)
			return ((TypeAlias) baseType).getOriginType();
		return baseType;
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.TYPE_ALIAS__TYPE_SPECIFIER:
				return basicSetTypeSpecifier(null, msgs);
			case TypesPackage.TYPE_ALIAS__ANNOTATIONS:
				return ((InternalEList<?>)getAnnotations()).basicRemove(otherEnd, msgs);
			case TypesPackage.TYPE_ALIAS__SUPER_TYPES:
				return ((InternalEList<?>)getSuperTypes()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.TYPE_ALIAS__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case TypesPackage.TYPE_ALIAS__TYPE_SPECIFIER:
				return getTypeSpecifier();
			case TypesPackage.TYPE_ALIAS__NAME:
				return getName();
			case TypesPackage.TYPE_ALIAS__ID:
				return getId();
			case TypesPackage.TYPE_ALIAS__ANNOTATIONS:
				return getAnnotations();
			case TypesPackage.TYPE_ALIAS__ABSTRACT:
				return isAbstract();
			case TypesPackage.TYPE_ALIAS__VISIBLE:
				return isVisible();
			case TypesPackage.TYPE_ALIAS__SUPER_TYPES:
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
			case TypesPackage.TYPE_ALIAS__TYPE_SPECIFIER:
				setTypeSpecifier((TypeSpecifier)newValue);
				return;
			case TypesPackage.TYPE_ALIAS__NAME:
				setName((String)newValue);
				return;
			case TypesPackage.TYPE_ALIAS__ANNOTATIONS:
				getAnnotations().clear();
				getAnnotations().addAll((Collection<? extends Annotation>)newValue);
				return;
			case TypesPackage.TYPE_ALIAS__ABSTRACT:
				setAbstract((Boolean)newValue);
				return;
			case TypesPackage.TYPE_ALIAS__VISIBLE:
				setVisible((Boolean)newValue);
				return;
			case TypesPackage.TYPE_ALIAS__SUPER_TYPES:
				getSuperTypes().clear();
				getSuperTypes().addAll((Collection<? extends TypeSpecifier>)newValue);
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
			case TypesPackage.TYPE_ALIAS__TYPE_SPECIFIER:
				setTypeSpecifier((TypeSpecifier)null);
				return;
			case TypesPackage.TYPE_ALIAS__NAME:
				setName(NAME_EDEFAULT);
				return;
			case TypesPackage.TYPE_ALIAS__ANNOTATIONS:
				getAnnotations().clear();
				return;
			case TypesPackage.TYPE_ALIAS__ABSTRACT:
				setAbstract(ABSTRACT_EDEFAULT);
				return;
			case TypesPackage.TYPE_ALIAS__VISIBLE:
				setVisible(VISIBLE_EDEFAULT);
				return;
			case TypesPackage.TYPE_ALIAS__SUPER_TYPES:
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
			case TypesPackage.TYPE_ALIAS__TYPE:
				return basicGetType() != null;
			case TypesPackage.TYPE_ALIAS__TYPE_SPECIFIER:
				return typeSpecifier != null;
			case TypesPackage.TYPE_ALIAS__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case TypesPackage.TYPE_ALIAS__ID:
				return ID_EDEFAULT == null ? getId() != null : !ID_EDEFAULT.equals(getId());
			case TypesPackage.TYPE_ALIAS__ANNOTATIONS:
				return annotations != null && !annotations.isEmpty();
			case TypesPackage.TYPE_ALIAS__ABSTRACT:
				return abstract_ != ABSTRACT_EDEFAULT;
			case TypesPackage.TYPE_ALIAS__VISIBLE:
				return visible != VISIBLE_EDEFAULT;
			case TypesPackage.TYPE_ALIAS__SUPER_TYPES:
				return superTypes != null && !superTypes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eBaseStructuralFeatureID(int derivedFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (derivedFeatureID) {
				case TypesPackage.TYPE_ALIAS__NAME: return BasePackage.NAMED_ELEMENT__NAME;
				default: return -1;
			}
		}
		if (baseClass == AnnotatableElement.class) {
			switch (derivedFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PackageMember.class) {
			switch (derivedFeatureID) {
				case TypesPackage.TYPE_ALIAS__ID: return TypesPackage.PACKAGE_MEMBER__ID;
				case TypesPackage.TYPE_ALIAS__ANNOTATIONS: return TypesPackage.PACKAGE_MEMBER__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == Type.class) {
			switch (derivedFeatureID) {
				case TypesPackage.TYPE_ALIAS__ABSTRACT: return TypesPackage.TYPE__ABSTRACT;
				case TypesPackage.TYPE_ALIAS__VISIBLE: return TypesPackage.TYPE__VISIBLE;
				case TypesPackage.TYPE_ALIAS__SUPER_TYPES: return TypesPackage.TYPE__SUPER_TYPES;
				default: return -1;
			}
		}
		return super.eBaseStructuralFeatureID(derivedFeatureID, baseClass);
	}

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public int eDerivedStructuralFeatureID(int baseFeatureID, Class<?> baseClass) {
		if (baseClass == NamedElement.class) {
			switch (baseFeatureID) {
				case BasePackage.NAMED_ELEMENT__NAME: return TypesPackage.TYPE_ALIAS__NAME;
				default: return -1;
			}
		}
		if (baseClass == AnnotatableElement.class) {
			switch (baseFeatureID) {
				default: return -1;
			}
		}
		if (baseClass == PackageMember.class) {
			switch (baseFeatureID) {
				case TypesPackage.PACKAGE_MEMBER__ID: return TypesPackage.TYPE_ALIAS__ID;
				case TypesPackage.PACKAGE_MEMBER__ANNOTATIONS: return TypesPackage.TYPE_ALIAS__ANNOTATIONS;
				default: return -1;
			}
		}
		if (baseClass == Type.class) {
			switch (baseFeatureID) {
				case TypesPackage.TYPE__ABSTRACT: return TypesPackage.TYPE_ALIAS__ABSTRACT;
				case TypesPackage.TYPE__VISIBLE: return TypesPackage.TYPE_ALIAS__VISIBLE;
				case TypesPackage.TYPE__SUPER_TYPES: return TypesPackage.TYPE_ALIAS__SUPER_TYPES;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
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
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@Override
	public String getId() {
		return TypesUtil.computeQID(this);
	}

} // TypeAliasImpl
