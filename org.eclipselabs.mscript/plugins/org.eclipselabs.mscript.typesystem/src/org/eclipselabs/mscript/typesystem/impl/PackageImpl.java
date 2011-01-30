/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.typesystem.NamedElement;
import org.eclipselabs.mscript.typesystem.PackageableElement;
import org.eclipselabs.mscript.typesystem.TypeSystemPackage;
import org.eclipselabs.mscript.typesystem.internal.util.DerivedUnionEObjectEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.impl.PackageImpl#getOwnedMembers <em>Owned Members</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.impl.PackageImpl#getPackagedElements <em>Packaged Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PackageImpl extends NamespaceImpl implements org.eclipselabs.mscript.typesystem.Package {
	/**
	 * The cached value of the '{@link #getPackagedElements() <em>Packaged Elements</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPackagedElements()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageableElement> packagedElements;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PackageImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypeSystemPackage.Literals.PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedElement> getOwnedMembers() {
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this, TypeSystemPackage.PACKAGE__OWNED_MEMBERS, OWNED_MEMBERS_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Members</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBERS_ESUBSETS = new int[] {TypeSystemPackage.PACKAGE__PACKAGED_ELEMENTS};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageableElement> getPackagedElements() {
		if (packagedElements == null) {
			packagedElements = new EObjectContainmentEList<PackageableElement>(PackageableElement.class, this, TypeSystemPackage.PACKAGE__PACKAGED_ELEMENTS);
		}
		return packagedElements;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypeSystemPackage.PACKAGE__PACKAGED_ELEMENTS:
				return ((InternalEList<?>)getPackagedElements()).basicRemove(otherEnd, msgs);
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
			case TypeSystemPackage.PACKAGE__PACKAGED_ELEMENTS:
				return getPackagedElements();
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
			case TypeSystemPackage.PACKAGE__PACKAGED_ELEMENTS:
				getPackagedElements().clear();
				getPackagedElements().addAll((Collection<? extends PackageableElement>)newValue);
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
			case TypeSystemPackage.PACKAGE__PACKAGED_ELEMENTS:
				getPackagedElements().clear();
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
			case TypeSystemPackage.PACKAGE__PACKAGED_ELEMENTS:
				return packagedElements != null && !packagedElements.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isSetOwnedMembers() {
		return super.isSetOwnedMembers()
			|| eIsSet(TypeSystemPackage.PACKAGE__PACKAGED_ELEMENTS);
	}

} //PackageImpl
