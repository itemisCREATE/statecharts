/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipse.uml2.common.util.DerivedUnionEObjectEList;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.Enumeration;
import org.eclipselabs.damos.typesystem.EnumerationLiteral;
import org.eclipselabs.damos.typesystem.NamedElement;
import org.eclipselabs.damos.typesystem.OperatorKind;
import org.eclipselabs.damos.typesystem.TypeSystemPackage;
import org.eclipselabs.damos.typesystem.internal.operations.DataTypeOperations;
import org.eclipselabs.damos.typesystem.internal.operations.EnumerationOperations;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.impl.EnumerationImpl#getOwnedMembers <em>Owned Members</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.impl.EnumerationImpl#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EnumerationImpl extends NamespaceImpl implements Enumeration {
	/**
	 * The cached value of the '{@link #getLiterals() <em>Literals</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLiterals()
	 * @generated
	 * @ordered
	 */
	protected EList<EnumerationLiteral> literals;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnumerationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return TypeSystemPackage.Literals.ENUMERATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<NamedElement> getOwnedMembers() {
		return new DerivedUnionEObjectEList<NamedElement>(NamedElement.class, this, TypeSystemPackage.ENUMERATION__OWNED_MEMBERS, OWNED_MEMBERS_ESUBSETS);
	}

	/**
	 * The array of subset feature identifiers for the '{@link #getOwnedMembers() <em>Owned Members</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getOwnedMembers()
	 * @generated
	 * @ordered
	 */
	protected static final int[] OWNED_MEMBERS_ESUBSETS = new int[] {TypeSystemPackage.ENUMERATION__LITERALS};

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<EnumerationLiteral> getLiterals() {
		if (literals == null) {
			literals = new EObjectContainmentWithInverseEList<EnumerationLiteral>(EnumerationLiteral.class, this, TypeSystemPackage.ENUMERATION__LITERALS, TypeSystemPackage.ENUMERATION_LITERAL__ENUMERATION);
		}
		return literals;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType evaluate(OperatorKind operator, DataType other) {
		return DataTypeOperations.evaluate(this, operator, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isAssignableFrom(DataType other) {
		return DataTypeOperations.isAssignableFrom(this, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataType convertTo(DataType other) {
		return DataTypeOperations.convertTo(this, other);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EnumerationLiteral getLiteral(String name) {
		return EnumerationOperations.getLiteral(this, name);
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
			case TypeSystemPackage.ENUMERATION__LITERALS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getLiterals()).basicAdd(otherEnd, msgs);
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
			case TypeSystemPackage.ENUMERATION__LITERALS:
				return ((InternalEList<?>)getLiterals()).basicRemove(otherEnd, msgs);
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
			case TypeSystemPackage.ENUMERATION__LITERALS:
				return getLiterals();
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
			case TypeSystemPackage.ENUMERATION__LITERALS:
				getLiterals().clear();
				getLiterals().addAll((Collection<? extends EnumerationLiteral>)newValue);
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
			case TypeSystemPackage.ENUMERATION__LITERALS:
				getLiterals().clear();
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
			case TypeSystemPackage.ENUMERATION__LITERALS:
				return literals != null && !literals.isEmpty();
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
			|| eIsSet(TypeSystemPackage.ENUMERATION__LITERALS);
	}

} //EnumerationImpl
