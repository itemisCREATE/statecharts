/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Number Format Mapping</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.impl.NumberFormatMappingImpl#getDataType <em>Data Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.impl.NumberFormatMappingImpl#getNumberFormat <em>Number Format</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NumberFormatMappingImpl extends EObjectImpl implements NumberFormatMapping {
	/**
	 * The cached value of the '{@link #getDataType() <em>Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataType()
	 * @generated
	 * @ordered
	 */
	protected DataType dataType;

	/**
	 * The cached value of the '{@link #getNumberFormat() <em>Number Format</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberFormat()
	 * @generated
	 * @ordered
	 */
	protected NumberFormat numberFormat;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NumberFormatMappingImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputationModelPackage.Literals.NUMBER_FORMAT_MAPPING;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType getDataType() {
		return dataType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDataType(DataType newDataType, NotificationChain msgs) {
		DataType oldDataType = dataType;
		dataType = newDataType;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ComputationModelPackage.NUMBER_FORMAT_MAPPING__DATA_TYPE, oldDataType, newDataType);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDataType(DataType newDataType) {
		if (newDataType != dataType) {
			NotificationChain msgs = null;
			if (dataType != null)
				msgs = ((InternalEObject)dataType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ComputationModelPackage.NUMBER_FORMAT_MAPPING__DATA_TYPE, null, msgs);
			if (newDataType != null)
				msgs = ((InternalEObject)newDataType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ComputationModelPackage.NUMBER_FORMAT_MAPPING__DATA_TYPE, null, msgs);
			msgs = basicSetDataType(newDataType, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationModelPackage.NUMBER_FORMAT_MAPPING__DATA_TYPE, newDataType, newDataType));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberFormat getNumberFormat() {
		if (numberFormat != null && numberFormat.eIsProxy()) {
			InternalEObject oldNumberFormat = (InternalEObject)numberFormat;
			numberFormat = (NumberFormat)eResolveProxy(oldNumberFormat);
			if (numberFormat != oldNumberFormat) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT, oldNumberFormat, numberFormat));
			}
		}
		return numberFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberFormat basicGetNumberFormat() {
		return numberFormat;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNumberFormat(NumberFormat newNumberFormat) {
		NumberFormat oldNumberFormat = numberFormat;
		numberFormat = newNumberFormat;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT, oldNumberFormat, numberFormat));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__DATA_TYPE:
				return basicSetDataType(null, msgs);
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
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__DATA_TYPE:
				return getDataType();
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
				if (resolve) return getNumberFormat();
				return basicGetNumberFormat();
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
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__DATA_TYPE:
				setDataType((DataType)newValue);
				return;
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
				setNumberFormat((NumberFormat)newValue);
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
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__DATA_TYPE:
				setDataType((DataType)null);
				return;
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
				setNumberFormat((NumberFormat)null);
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
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__DATA_TYPE:
				return dataType != null;
			case ComputationModelPackage.NUMBER_FORMAT_MAPPING__NUMBER_FORMAT:
				return numberFormat != null;
		}
		return super.eIsSet(featureID);
	}

} //NumberFormatMappingImpl
