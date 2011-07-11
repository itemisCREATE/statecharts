/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.DataTypeSpecifier;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.DataTypeSpecifierImpl#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.DataTypeSpecifierImpl#getDefinedType <em>Defined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DataTypeSpecifierImpl extends MinimalEObjectImpl.Container implements DataTypeSpecifier {
	/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected DataType type;
	/**
	 * The cached value of the '{@link #getDefinedType() <em>Defined Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefinedType()
	 * @generated
	 * @ordered
	 */
	protected DataType definedType;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataTypeSpecifierImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.DATA_TYPE_SPECIFIER;
	}

	public DataType getType() {
		DataType type = getTypeGen();
		if (type == null) {
			type = getDefinedType();
		}
		return type;
	}
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getTypeGen() {
		if (type != null && type.eIsProxy()) {
			InternalEObject oldType = (InternalEObject)type;
			type = (DataType)eResolveProxy(oldType);
			if (type != oldType) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AstPackage.DATA_TYPE_SPECIFIER__TYPE, oldType, type));
			}
		}
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType basicGetType() {
		return type;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(DataType newType) {
		DataType oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.DATA_TYPE_SPECIFIER__TYPE, oldType, type));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDefinedType() {
		return definedType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefinedType(DataType newDefinedType, NotificationChain msgs) {
		DataType oldDefinedType = definedType;
		definedType = newDefinedType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.DATA_TYPE_SPECIFIER__DEFINED_TYPE, oldDefinedType, newDefinedType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefinedType(DataType newDefinedType) {
		if (newDefinedType != definedType) {
			NotificationChain msgs = null;
			if (definedType != null)
				msgs = ((InternalEObject)definedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.DATA_TYPE_SPECIFIER__DEFINED_TYPE, null, msgs);
			if (newDefinedType != null)
				msgs = ((InternalEObject)newDefinedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.DATA_TYPE_SPECIFIER__DEFINED_TYPE, null, msgs);
			msgs = basicSetDefinedType(newDefinedType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.DATA_TYPE_SPECIFIER__DEFINED_TYPE, newDefinedType, newDefinedType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.DATA_TYPE_SPECIFIER__DEFINED_TYPE:
				return basicSetDefinedType(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstPackage.DATA_TYPE_SPECIFIER__TYPE:
				if (resolve) return getType();
				return basicGetType();
			case AstPackage.DATA_TYPE_SPECIFIER__DEFINED_TYPE:
				return getDefinedType();
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
			case AstPackage.DATA_TYPE_SPECIFIER__TYPE:
				setType((DataType)newValue);
				return;
			case AstPackage.DATA_TYPE_SPECIFIER__DEFINED_TYPE:
				setDefinedType((DataType)newValue);
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
			case AstPackage.DATA_TYPE_SPECIFIER__TYPE:
				setType((DataType)null);
				return;
			case AstPackage.DATA_TYPE_SPECIFIER__DEFINED_TYPE:
				setDefinedType((DataType)null);
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
			case AstPackage.DATA_TYPE_SPECIFIER__TYPE:
				return type != null;
			case AstPackage.DATA_TYPE_SPECIFIER__DEFINED_TYPE:
				return definedType != null;
		}
		return super.eIsSet(featureID);
	}

} //DataTypeSpecifierImpl
