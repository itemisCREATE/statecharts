/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.mscript.language.il.ILPackage;
import org.eclipselabs.mscript.language.il.StatefulVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Stateful Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.StatefulVariableDeclarationImpl#getCircularBufferSize <em>Circular Buffer Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class StatefulVariableDeclarationImpl extends VariableDeclarationImpl implements StatefulVariableDeclaration {
	/**
	 * The default value of the '{@link #getCircularBufferSize() <em>Circular Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCircularBufferSize()
	 * @generated
	 * @ordered
	 */
	protected static final int CIRCULAR_BUFFER_SIZE_EDEFAULT = 1;
	/**
	 * The cached value of the '{@link #getCircularBufferSize() <em>Circular Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCircularBufferSize()
	 * @generated
	 * @ordered
	 */
	protected int circularBufferSize = CIRCULAR_BUFFER_SIZE_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StatefulVariableDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ILPackage.Literals.STATEFUL_VARIABLE_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getCircularBufferSize() {
		return circularBufferSize;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCircularBufferSize(int newCircularBufferSize) {
		int oldCircularBufferSize = circularBufferSize;
		circularBufferSize = newCircularBufferSize;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ILPackage.STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE, oldCircularBufferSize, circularBufferSize));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ILPackage.STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE:
				return getCircularBufferSize();
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
			case ILPackage.STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE:
				setCircularBufferSize((Integer)newValue);
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
			case ILPackage.STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE:
				setCircularBufferSize(CIRCULAR_BUFFER_SIZE_EDEFAULT);
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
			case ILPackage.STATEFUL_VARIABLE_DECLARATION__CIRCULAR_BUFFER_SIZE:
				return circularBufferSize != CIRCULAR_BUFFER_SIZE_EDEFAULT;
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
		result.append(" (circularBufferSize: ");
		result.append(circularBufferSize);
		result.append(')');
		return result.toString();
	}

} //StatefulVariableDeclarationImpl
