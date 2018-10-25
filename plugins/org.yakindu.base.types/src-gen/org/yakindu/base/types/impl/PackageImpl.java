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
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.base.BasePackage;
import org.yakindu.base.base.DomainElement;
import org.yakindu.base.types.PackageMember;
import org.yakindu.base.types.TypesPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.types.impl.PackageImpl#getDomainID <em>Domain ID</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.PackageImpl#getMember <em>Member</em>}</li>
 *   <li>{@link org.yakindu.base.types.impl.PackageImpl#getImport <em>Import</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PackageImpl extends PackageMemberImpl implements org.yakindu.base.types.Package {
	/**
	 * The default value of the '{@link #getDomainID() <em>Domain ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainID()
	 * @generated
	 * @ordered
	 */
	protected static final String DOMAIN_ID_EDEFAULT = "org.yakindu.domain.default";
	/**
	 * The cached value of the '{@link #getDomainID() <em>Domain ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDomainID()
	 * @generated
	 * @ordered
	 */
	protected String domainID = DOMAIN_ID_EDEFAULT;
	/**
	 * The cached value of the '{@link #getMember() <em>Member</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMember()
	 * @generated
	 * @ordered
	 */
	protected EList<PackageMember> member;
	/**
	 * The cached value of the '{@link #getImport() <em>Import</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getImport()
	 * @generated
	 * @ordered
	 */
	protected EList<org.yakindu.base.types.Package> import_;
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
		return TypesPackage.Literals.PACKAGE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getDomainID() {
		return domainID;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDomainID(String newDomainID) {
		String oldDomainID = domainID;
		domainID = newDomainID;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TypesPackage.PACKAGE__DOMAIN_ID, oldDomainID, domainID));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PackageMember> getMember() {
		if (member == null) {
			member = new EObjectContainmentEList<PackageMember>(PackageMember.class, this, TypesPackage.PACKAGE__MEMBER);
		}
		return member;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<org.yakindu.base.types.Package> getImport() {
		if (import_ == null) {
			import_ = new EObjectResolvingEList<org.yakindu.base.types.Package>(org.yakindu.base.types.Package.class, this, TypesPackage.PACKAGE__IMPORT);
		}
		return import_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case TypesPackage.PACKAGE__MEMBER:
				return ((InternalEList<?>)getMember()).basicRemove(otherEnd, msgs);
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
			case TypesPackage.PACKAGE__DOMAIN_ID:
				return getDomainID();
			case TypesPackage.PACKAGE__MEMBER:
				return getMember();
			case TypesPackage.PACKAGE__IMPORT:
				return getImport();
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
			case TypesPackage.PACKAGE__DOMAIN_ID:
				setDomainID((String)newValue);
				return;
			case TypesPackage.PACKAGE__MEMBER:
				getMember().clear();
				getMember().addAll((Collection<? extends PackageMember>)newValue);
				return;
			case TypesPackage.PACKAGE__IMPORT:
				getImport().clear();
				getImport().addAll((Collection<? extends org.yakindu.base.types.Package>)newValue);
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
			case TypesPackage.PACKAGE__DOMAIN_ID:
				setDomainID(DOMAIN_ID_EDEFAULT);
				return;
			case TypesPackage.PACKAGE__MEMBER:
				getMember().clear();
				return;
			case TypesPackage.PACKAGE__IMPORT:
				getImport().clear();
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
			case TypesPackage.PACKAGE__DOMAIN_ID:
				return DOMAIN_ID_EDEFAULT == null ? domainID != null : !DOMAIN_ID_EDEFAULT.equals(domainID);
			case TypesPackage.PACKAGE__MEMBER:
				return member != null && !member.isEmpty();
			case TypesPackage.PACKAGE__IMPORT:
				return import_ != null && !import_.isEmpty();
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
		if (baseClass == DomainElement.class) {
			switch (derivedFeatureID) {
				case TypesPackage.PACKAGE__DOMAIN_ID: return BasePackage.DOMAIN_ELEMENT__DOMAIN_ID;
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
		if (baseClass == DomainElement.class) {
			switch (baseFeatureID) {
				case BasePackage.DOMAIN_ELEMENT__DOMAIN_ID: return TypesPackage.PACKAGE__DOMAIN_ID;
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

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (domainID: ");
		result.append(domainID);
		result.append(')');
		return result.toString();
	}

} //PackageImpl
