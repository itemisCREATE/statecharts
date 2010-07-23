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
 * A representation of the model object '<em><b>Namespace</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.Namespace#getMembers <em>Members</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.Namespace#getOwnedMembers <em>Owned Members</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getNamespace()
 * @model abstract="true"
 * @generated
 */
public interface Namespace extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Members</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.typesystem.NamedElement}.
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Members</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Members</em>' reference list.
	 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getNamespace_Members()
	 * @model transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<NamedElement> getMembers();

	/**
	 * Returns the value of the '<em><b>Owned Members</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.typesystem.NamedElement}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.typesystem.NamedElement#getNamespace <em>Namespace</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.eclipselabs.damos.typesystem.Namespace#getMembers() <em>Members</em>}'</li>
	 * </ul>
	 * </p>
	 * This feature is a derived union.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Members</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Members</em>' reference list.
	 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getNamespace_OwnedMembers()
	 * @see org.eclipselabs.damos.typesystem.NamedElement#getNamespace
	 * @model opposite="namespace" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	EList<NamedElement> getOwnedMembers();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" nameRequired="true" nameOrdered="false"
	 * @generated
	 */
	NamedElement getMember(String name);

} // Namespace
