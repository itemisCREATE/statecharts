/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.Enumeration#getLiterals <em>Literals</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getEnumeration()
 * @model
 * @generated
 */
public interface Enumeration extends Namespace, DataType {
	/**
	 * Returns the value of the '<em><b>Literals</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.typesystem.EnumerationLiteral}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.typesystem.EnumerationLiteral#getEnumeration <em>Enumeration</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.eclipselabs.damos.typesystem.Namespace#getOwnedMembers() <em>Owned Members</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literals</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literals</em>' containment reference list.
	 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getEnumeration_Literals()
	 * @see org.eclipselabs.damos.typesystem.EnumerationLiteral#getEnumeration
	 * @model opposite="enumeration" containment="true"
	 * @generated
	 */
	EList<EnumerationLiteral> getLiterals();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	EnumerationLiteral getLiteral(String name);

} // Enumeration
