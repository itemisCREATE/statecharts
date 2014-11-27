/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;

import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Event;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypedElement;
import org.yakindu.base.types.TypesPackage;

import org.yakindu.sct.model.sgraph.impl.EventImpl;

import org.yakindu.sct.model.stext.stext.Direction;
import org.yakindu.sct.model.stext.stext.EventDefinition;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Event Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl#getTypeArguments <em>Type Arguments</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl#getOwningType <em>Owning Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.EventDefinitionImpl#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EventDefinitionImpl extends EventImpl implements EventDefinition {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected Type type;

	/**
	 * The cached value of the '{@link #getTypeArguments() <em>Type Arguments</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTypeArguments()
	 * @generated
	 * @ordered
	 */
	protected EList<Type> typeArguments;

	/**
	 * The default value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected static final Direction DIRECTION_EDEFAULT = Direction.LOCAL;

	/**
	 * The cached value of the '{@link #getDirection() <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDirection()
	 * @generated
	 * @ordered
	 */
	protected Direction direction = DIRECTION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EventDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StextPackage.Literals.EVENT_DEFINITION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type getType() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (Type)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StextPackage.EVENT_DEFINITION__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Type basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(Type newType) {
		Type oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.EVENT_DEFINITION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getTypeArguments() {
		if (typeArguments == null) {
			typeArguments = new EObjectResolvingEList<Type>(Type.class, this, StextPackage.EVENT_DEFINITION__TYPE_ARGUMENTS);
		}
		return typeArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexType getOwningType() {
		if (eContainerFeatureID() != StextPackage.EVENT_DEFINITION__OWNING_TYPE) return null;
		return (ComplexType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningType(ComplexType newOwningType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningType, StextPackage.EVENT_DEFINITION__OWNING_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningType(ComplexType newOwningType) {
		if (newOwningType != eInternalContainer() || (eContainerFeatureID() != StextPackage.EVENT_DEFINITION__OWNING_TYPE && newOwningType != null)) {
			if (EcoreUtil.isAncestor(this, newOwningType))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningType != null)
				msgs = ((InternalEObject)newOwningType).eInverseAdd(this, TypesPackage.COMPLEX_TYPE__FEATURES, ComplexType.class, msgs);
			msgs = basicSetOwningType(newOwningType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.EVENT_DEFINITION__OWNING_TYPE, newOwningType, newOwningType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDirection(Direction newDirection) {
		Direction oldDirection = direction;
		direction = newDirection == null ? DIRECTION_EDEFAULT : newDirection;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.EVENT_DEFINITION__DIRECTION, oldDirection, direction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case StextPackage.EVENT_DEFINITION__OWNING_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningType((ComplexType)otherEnd, msgs);
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
			case StextPackage.EVENT_DEFINITION__OWNING_TYPE:
				return basicSetOwningType(null, msgs);
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
			case StextPackage.EVENT_DEFINITION__OWNING_TYPE:
				return eInternalContainer().eInverseRemove(this, TypesPackage.COMPLEX_TYPE__FEATURES, ComplexType.class, msgs);
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
			case StextPackage.EVENT_DEFINITION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case StextPackage.EVENT_DEFINITION__TYPE_ARGUMENTS:
				return getTypeArguments();
			case StextPackage.EVENT_DEFINITION__OWNING_TYPE:
				return getOwningType();
			case StextPackage.EVENT_DEFINITION__DIRECTION:
				return getDirection();
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
			case StextPackage.EVENT_DEFINITION__TYPE:
				setType((Type)newValue);
				return;
			case StextPackage.EVENT_DEFINITION__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				getTypeArguments().addAll((Collection<? extends Type>)newValue);
				return;
			case StextPackage.EVENT_DEFINITION__OWNING_TYPE:
				setOwningType((ComplexType)newValue);
				return;
			case StextPackage.EVENT_DEFINITION__DIRECTION:
				setDirection((Direction)newValue);
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
			case StextPackage.EVENT_DEFINITION__TYPE:
				setType((Type)null);
				return;
			case StextPackage.EVENT_DEFINITION__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				return;
			case StextPackage.EVENT_DEFINITION__OWNING_TYPE:
				setOwningType((ComplexType)null);
				return;
			case StextPackage.EVENT_DEFINITION__DIRECTION:
				setDirection(DIRECTION_EDEFAULT);
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
			case StextPackage.EVENT_DEFINITION__TYPE:
				return type != null;
			case StextPackage.EVENT_DEFINITION__TYPE_ARGUMENTS:
				return typeArguments != null && !typeArguments.isEmpty();
			case StextPackage.EVENT_DEFINITION__OWNING_TYPE:
				return getOwningType() != null;
			case StextPackage.EVENT_DEFINITION__DIRECTION:
				return direction != DIRECTION_EDEFAULT;
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
		if (baseClass == TypedElement.class) {
			switch (derivedFeatureID) {
				case StextPackage.EVENT_DEFINITION__TYPE: return TypesPackage.TYPED_ELEMENT__TYPE;
				case StextPackage.EVENT_DEFINITION__TYPE_ARGUMENTS: return TypesPackage.TYPED_ELEMENT__TYPE_ARGUMENTS;
				default: return -1;
			}
		}
		if (baseClass == Feature.class) {
			switch (derivedFeatureID) {
				case StextPackage.EVENT_DEFINITION__OWNING_TYPE: return TypesPackage.FEATURE__OWNING_TYPE;
				default: return -1;
			}
		}
		if (baseClass == Event.class) {
			switch (derivedFeatureID) {
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
		if (baseClass == TypedElement.class) {
			switch (baseFeatureID) {
				case TypesPackage.TYPED_ELEMENT__TYPE: return StextPackage.EVENT_DEFINITION__TYPE;
				case TypesPackage.TYPED_ELEMENT__TYPE_ARGUMENTS: return StextPackage.EVENT_DEFINITION__TYPE_ARGUMENTS;
				default: return -1;
			}
		}
		if (baseClass == Feature.class) {
			switch (baseFeatureID) {
				case TypesPackage.FEATURE__OWNING_TYPE: return StextPackage.EVENT_DEFINITION__OWNING_TYPE;
				default: return -1;
			}
		}
		if (baseClass == Event.class) {
			switch (baseFeatureID) {
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
		result.append(" (direction: ");
		result.append(direction);
		result.append(')');
		return result.toString();
	}

} //EventDefinitionImpl
