/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipselabs.damos.typesystem.ArrayDimension;
import org.eclipselabs.damos.typesystem.TypeSystemPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Array Dimension</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.impl.ArrayDimensionImpl#getFromIndex <em>From Index</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.impl.ArrayDimensionImpl#getToIndex <em>To Index</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.impl.ArrayDimensionImpl#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ArrayDimensionImpl extends EObjectImpl implements ArrayDimension {
	/**
	 * The default value of the '{@link #getFromIndex() <em>From Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int FROM_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getFromIndex() <em>From Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFromIndex()
	 * @generated
	 * @ordered
	 */
	protected int fromIndex = FROM_INDEX_EDEFAULT;

	/**
	 * This is true if the From Index attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean fromIndexESet;

	/**
	 * The default value of the '{@link #getToIndex() <em>To Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToIndex()
	 * @generated
	 * @ordered
	 */
	protected static final int TO_INDEX_EDEFAULT = 0;

	/**
	 * The cached value of the '{@link #getToIndex() <em>To Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getToIndex()
	 * @generated
	 * @ordered
	 */
	protected int toIndex = TO_INDEX_EDEFAULT;

	/**
	 * This is true if the To Index attribute has been set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	protected boolean toIndexESet;

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
	public int getFromIndex() {
		return fromIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setFromIndex(int newFromIndex) {
		int oldFromIndex = fromIndex;
		fromIndex = newFromIndex;
		boolean oldFromIndexESet = fromIndexESet;
		fromIndexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypeSystemPackage.ARRAY_DIMENSION__FROM_INDEX, oldFromIndex, fromIndex, !oldFromIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetFromIndex() {
		int oldFromIndex = fromIndex;
		boolean oldFromIndexESet = fromIndexESet;
		fromIndex = FROM_INDEX_EDEFAULT;
		fromIndexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TypeSystemPackage.ARRAY_DIMENSION__FROM_INDEX, oldFromIndex, FROM_INDEX_EDEFAULT, oldFromIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetFromIndex() {
		return fromIndexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getToIndex() {
		return toIndex;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setToIndex(int newToIndex) {
		int oldToIndex = toIndex;
		toIndex = newToIndex;
		boolean oldToIndexESet = toIndexESet;
		toIndexESet = true;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypeSystemPackage.ARRAY_DIMENSION__TO_INDEX, oldToIndex, toIndex, !oldToIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void unsetToIndex() {
		int oldToIndex = toIndex;
		boolean oldToIndexESet = toIndexESet;
		toIndex = TO_INDEX_EDEFAULT;
		toIndexESet = false;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.UNSET, TypeSystemPackage.ARRAY_DIMENSION__TO_INDEX, oldToIndex, TO_INDEX_EDEFAULT, oldToIndexESet));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isSetToIndex() {
		return toIndexESet;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public int getSize() {
		return isSetFromIndex() && isSetToIndex() ? getToIndex() - getFromIndex() + 1 : -1;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TypeSystemPackage.ARRAY_DIMENSION__FROM_INDEX:
				return getFromIndex();
			case TypeSystemPackage.ARRAY_DIMENSION__TO_INDEX:
				return getToIndex();
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
			case TypeSystemPackage.ARRAY_DIMENSION__FROM_INDEX:
				setFromIndex((Integer)newValue);
				return;
			case TypeSystemPackage.ARRAY_DIMENSION__TO_INDEX:
				setToIndex((Integer)newValue);
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
			case TypeSystemPackage.ARRAY_DIMENSION__FROM_INDEX:
				unsetFromIndex();
				return;
			case TypeSystemPackage.ARRAY_DIMENSION__TO_INDEX:
				unsetToIndex();
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
			case TypeSystemPackage.ARRAY_DIMENSION__FROM_INDEX:
				return isSetFromIndex();
			case TypeSystemPackage.ARRAY_DIMENSION__TO_INDEX:
				return isSetToIndex();
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
		result.append(" (fromIndex: ");
		if (fromIndexESet) result.append(fromIndex); else result.append("<unset>");
		result.append(", toIndex: ");
		if (toIndexESet) result.append(toIndex); else result.append("<unset>");
		result.append(')');
		return result.toString();
	}

} //ArrayDimensionImpl
