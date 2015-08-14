/**
 */
package org.yakindu.base.types.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.base.impl.NamedElementImpl;
import org.yakindu.base.types.EnumerationType;
import org.yakindu.base.types.Enumerator;
import org.yakindu.base.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumerator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.base.types.impl.EnumeratorImpl#getOwningEnumeration <em>Owning Enumeration</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.EnumeratorImpl#getLiteralValue <em>Literal Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumeratorImpl extends NamedElementImpl implements Enumerator {
	/**
	 * The default value of the '{@link #getLiteralValue() <em>Literal Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralValue()
	 * @generated
	 * @ordered
	 */
	protected static final Object LITERAL_VALUE_EDEFAULT = null;
	/**
	 * The cached value of the '{@link #getLiteralValue() <em>Literal Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiteralValue()
	 * @generated
	 * @ordered
	 */
	protected Object literalValue = LITERAL_VALUE_EDEFAULT;
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumeratorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypesPackage.Literals.ENUMERATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationType getOwningEnumeration() {
		if (eContainerFeatureID() != TypesPackage.ENUMERATOR__OWNING_ENUMERATION) return null;
		return (EnumerationType)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetOwningEnumeration(EnumerationType newOwningEnumeration, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newOwningEnumeration, TypesPackage.ENUMERATOR__OWNING_ENUMERATION, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setOwningEnumeration(EnumerationType newOwningEnumeration) {
		if (newOwningEnumeration != eInternalContainer() || (eContainerFeatureID() != TypesPackage.ENUMERATOR__OWNING_ENUMERATION && newOwningEnumeration != null)) {
			if (EcoreUtil.isAncestor(this, newOwningEnumeration))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newOwningEnumeration != null)
				msgs = ((InternalEObject)newOwningEnumeration).eInverseAdd(this, TypesPackage.ENUMERATION_TYPE__ENUMERATOR, EnumerationType.class, msgs);
			msgs = basicSetOwningEnumeration(newOwningEnumeration, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.ENUMERATOR__OWNING_ENUMERATION, newOwningEnumeration, newOwningEnumeration));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object getLiteralValue() {
		return literalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLiteralValue(Object newLiteralValue) {
		Object oldLiteralValue = literalValue;
		literalValue = newLiteralValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.ENUMERATOR__LITERAL_VALUE, oldLiteralValue, literalValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.ENUMERATOR__OWNING_ENUMERATION:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetOwningEnumeration((EnumerationType)otherEnd, msgs);
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
			case TypesPackage.ENUMERATOR__OWNING_ENUMERATION:
				return basicSetOwningEnumeration(null, msgs);
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
			case TypesPackage.ENUMERATOR__OWNING_ENUMERATION:
				return eInternalContainer().eInverseRemove(this, TypesPackage.ENUMERATION_TYPE__ENUMERATOR, EnumerationType.class, msgs);
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
			case TypesPackage.ENUMERATOR__OWNING_ENUMERATION:
				return getOwningEnumeration();
			case TypesPackage.ENUMERATOR__LITERAL_VALUE:
				return getLiteralValue();
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
			case TypesPackage.ENUMERATOR__OWNING_ENUMERATION:
				setOwningEnumeration((EnumerationType)newValue);
				return;
			case TypesPackage.ENUMERATOR__LITERAL_VALUE:
				setLiteralValue(newValue);
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
			case TypesPackage.ENUMERATOR__OWNING_ENUMERATION:
				setOwningEnumeration((EnumerationType)null);
				return;
			case TypesPackage.ENUMERATOR__LITERAL_VALUE:
				setLiteralValue(LITERAL_VALUE_EDEFAULT);
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
			case TypesPackage.ENUMERATOR__OWNING_ENUMERATION:
				return getOwningEnumeration() != null;
			case TypesPackage.ENUMERATOR__LITERAL_VALUE:
				return LITERAL_VALUE_EDEFAULT == null ? literalValue != null : !LITERAL_VALUE_EDEFAULT.equals(literalValue);
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
		result.append(" (literalValue: ");
		result.append(literalValue);
		result.append(')');
		return result.toString();
	}

} //EnumeratorImpl
