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

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.base.types.ComplexType;
import org.yakindu.base.types.Feature;
import org.yakindu.base.types.Operation;
import org.yakindu.base.types.Parameter;
import org.yakindu.base.types.Type;
import org.yakindu.base.types.TypedElement;
import org.yakindu.base.types.TypesPackage;

import org.yakindu.sct.model.sgraph.impl.DeclarationImpl;

import org.yakindu.sct.model.stext.stext.OperationDefinition;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Operation Definition</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl#getTypeArguments <em>Type Arguments</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl#getOwningType <em>Owning Type</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.OperationDefinitionImpl#getParameters <em>Parameters</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OperationDefinitionImpl extends DeclarationImpl implements OperationDefinition {
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
	 * The cached value of the '{@link #getParameters() <em>Parameters</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getParameters()
	 * @generated
	 * @ordered
	 */
	protected EList<Parameter> parameters;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected OperationDefinitionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return StextPackage.Literals.OPERATION_DEFINITION;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, StextPackage.OPERATION_DEFINITION__TYPE, oldType, type));
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
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.OPERATION_DEFINITION__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Type> getTypeArguments() {
		if (typeArguments == null) {
			typeArguments = new EObjectResolvingEList<Type>(Type.class, this, StextPackage.OPERATION_DEFINITION__TYPE_ARGUMENTS);
		}
		return typeArguments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComplexType getOwningType() {
		if (eContainerFeatureID() != StextPackage.OPERATION_DEFINITION__OWNING_TYPE) return null;
		return (ComplexType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningType(ComplexType newOwningType, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningType, StextPackage.OPERATION_DEFINITION__OWNING_TYPE, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningType(ComplexType newOwningType) {
		if (newOwningType != eInternalContainer() || (eContainerFeatureID() != StextPackage.OPERATION_DEFINITION__OWNING_TYPE && newOwningType != null)) {
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
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.OPERATION_DEFINITION__OWNING_TYPE, newOwningType, newOwningType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Parameter> getParameters() {
		if (parameters == null) {
			parameters = new EObjectContainmentWithInverseEList<Parameter>(Parameter.class, this, StextPackage.OPERATION_DEFINITION__PARAMETERS, TypesPackage.PARAMETER__OWNING_OPERATION);
		}
		return parameters;
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
			case StextPackage.OPERATION_DEFINITION__OWNING_TYPE:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningType((ComplexType)otherEnd, msgs);
			case StextPackage.OPERATION_DEFINITION__PARAMETERS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getParameters()).basicAdd(otherEnd, msgs);
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
			case StextPackage.OPERATION_DEFINITION__OWNING_TYPE:
				return basicSetOwningType(null, msgs);
			case StextPackage.OPERATION_DEFINITION__PARAMETERS:
				return ((InternalEList<?>)getParameters()).basicRemove(otherEnd, msgs);
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
			case StextPackage.OPERATION_DEFINITION__OWNING_TYPE:
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
			case StextPackage.OPERATION_DEFINITION__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case StextPackage.OPERATION_DEFINITION__TYPE_ARGUMENTS:
				return getTypeArguments();
			case StextPackage.OPERATION_DEFINITION__OWNING_TYPE:
				return getOwningType();
			case StextPackage.OPERATION_DEFINITION__PARAMETERS:
				return getParameters();
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
			case StextPackage.OPERATION_DEFINITION__TYPE:
				setType((Type)newValue);
				return;
			case StextPackage.OPERATION_DEFINITION__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				getTypeArguments().addAll((Collection<? extends Type>)newValue);
				return;
			case StextPackage.OPERATION_DEFINITION__OWNING_TYPE:
				setOwningType((ComplexType)newValue);
				return;
			case StextPackage.OPERATION_DEFINITION__PARAMETERS:
				getParameters().clear();
				getParameters().addAll((Collection<? extends Parameter>)newValue);
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
			case StextPackage.OPERATION_DEFINITION__TYPE:
				setType((Type)null);
				return;
			case StextPackage.OPERATION_DEFINITION__TYPE_ARGUMENTS:
				getTypeArguments().clear();
				return;
			case StextPackage.OPERATION_DEFINITION__OWNING_TYPE:
				setOwningType((ComplexType)null);
				return;
			case StextPackage.OPERATION_DEFINITION__PARAMETERS:
				getParameters().clear();
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
			case StextPackage.OPERATION_DEFINITION__TYPE:
				return type != null;
			case StextPackage.OPERATION_DEFINITION__TYPE_ARGUMENTS:
				return typeArguments != null && !typeArguments.isEmpty();
			case StextPackage.OPERATION_DEFINITION__OWNING_TYPE:
				return getOwningType() != null;
			case StextPackage.OPERATION_DEFINITION__PARAMETERS:
				return parameters != null && !parameters.isEmpty();
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
				case StextPackage.OPERATION_DEFINITION__TYPE: return TypesPackage.TYPED_ELEMENT__TYPE;
				case StextPackage.OPERATION_DEFINITION__TYPE_ARGUMENTS: return TypesPackage.TYPED_ELEMENT__TYPE_ARGUMENTS;
				default: return -1;
			}
		}
		if (baseClass == Feature.class) {
			switch (derivedFeatureID) {
				case StextPackage.OPERATION_DEFINITION__OWNING_TYPE: return TypesPackage.FEATURE__OWNING_TYPE;
				default: return -1;
			}
		}
		if (baseClass == Operation.class) {
			switch (derivedFeatureID) {
				case StextPackage.OPERATION_DEFINITION__PARAMETERS: return TypesPackage.OPERATION__PARAMETERS;
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
				case TypesPackage.TYPED_ELEMENT__TYPE: return StextPackage.OPERATION_DEFINITION__TYPE;
				case TypesPackage.TYPED_ELEMENT__TYPE_ARGUMENTS: return StextPackage.OPERATION_DEFINITION__TYPE_ARGUMENTS;
				default: return -1;
			}
		}
		if (baseClass == Feature.class) {
			switch (baseFeatureID) {
				case TypesPackage.FEATURE__OWNING_TYPE: return StextPackage.OPERATION_DEFINITION__OWNING_TYPE;
				default: return -1;
			}
		}
		if (baseClass == Operation.class) {
			switch (baseFeatureID) {
				case TypesPackage.OPERATION__PARAMETERS: return StextPackage.OPERATION_DEFINITION__PARAMETERS;
				default: return -1;
			}
		}
		return super.eDerivedStructuralFeatureID(baseFeatureID, baseClass);
	}

} //OperationDefinitionImpl
