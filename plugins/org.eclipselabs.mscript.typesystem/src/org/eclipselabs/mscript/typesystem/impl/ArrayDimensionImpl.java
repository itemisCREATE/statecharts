/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.mscript.typesystem.ArrayDimension;
import org.eclipselabs.mscript.typesystem.TypeSystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Dimension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.impl.ArrayDimensionImpl#getBeginIndex <em>Begin Index</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.impl.ArrayDimensionImpl#getEndIndex <em>End Index</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.impl.ArrayDimensionImpl#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrayDimensionImpl extends EObjectImpl implements ArrayDimension {
	/**
	 * The default value of the '{@link #getBeginIndex() <em>Begin Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeginIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int BEGIN_INDEX_EDEFAULT = 1;

	/**
	 * The cached value of the '{@link #getBeginIndex() <em>Begin Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBeginIndex()
	 * @generated
	 * @ordered
	 */
	protected int beginIndex = BEGIN_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getEndIndex() <em>End Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int END_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getEndIndex() <em>End Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getEndIndex()
	 * @generated
	 * @ordered
	 */
	protected int endIndex = END_INDEX_EDEFAULT;

	/**
	 * The default value of the '{@link #getSize() <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSize()
	 * @generated
	 * @ordered
	 */
	protected static final int SIZE_EDEFAULT = 0;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ArrayDimensionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypeSystemPackage.Literals.ARRAY_DIMENSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getBeginIndex() {
		return beginIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setBeginIndex(int newBeginIndex) {
		int oldBeginIndex = beginIndex;
		beginIndex = newBeginIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypeSystemPackage.ARRAY_DIMENSION__BEGIN_INDEX, oldBeginIndex, beginIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getEndIndex() {
		return endIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEndIndex(int newEndIndex) {
		int oldEndIndex = endIndex;
		endIndex = newEndIndex;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypeSystemPackage.ARRAY_DIMENSION__END_INDEX, oldEndIndex, endIndex));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getSize() {
		return getEndIndex() - getBeginIndex() + 1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypeSystemPackage.ARRAY_DIMENSION__BEGIN_INDEX:
				return getBeginIndex();
			case TypeSystemPackage.ARRAY_DIMENSION__END_INDEX:
				return getEndIndex();
			case TypeSystemPackage.ARRAY_DIMENSION__SIZE:
				return getSize();
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
			case TypeSystemPackage.ARRAY_DIMENSION__BEGIN_INDEX:
				setBeginIndex((Integer)newValue);
				return;
			case TypeSystemPackage.ARRAY_DIMENSION__END_INDEX:
				setEndIndex((Integer)newValue);
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
			case TypeSystemPackage.ARRAY_DIMENSION__BEGIN_INDEX:
				setBeginIndex(BEGIN_INDEX_EDEFAULT);
				return;
			case TypeSystemPackage.ARRAY_DIMENSION__END_INDEX:
				setEndIndex(END_INDEX_EDEFAULT);
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
			case TypeSystemPackage.ARRAY_DIMENSION__BEGIN_INDEX:
				return beginIndex != BEGIN_INDEX_EDEFAULT;
			case TypeSystemPackage.ARRAY_DIMENSION__END_INDEX:
				return endIndex != END_INDEX_EDEFAULT;
			case TypeSystemPackage.ARRAY_DIMENSION__SIZE:
				return getSize() != SIZE_EDEFAULT;
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
		result.append(" (beginIndex: ");
		result.append(beginIndex);
		result.append(", endIndex: ");
		result.append(endIndex);
		result.append(')');
		return result.toString();
	}

} //ArrayDimensionImpl
