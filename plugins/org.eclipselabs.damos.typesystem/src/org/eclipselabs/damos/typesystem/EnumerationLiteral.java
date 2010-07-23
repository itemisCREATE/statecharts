/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.EnumerationLiteral#getEnumeration <em>Enumeration</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getEnumerationLiteral()
 * @model
 * @generated
 */
public interface EnumerationLiteral extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Enumeration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.damos.typesystem.Enumeration#getLiterals <em>Literals</em>}'.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.eclipselabs.damos.typesystem.NamedElement#getNamespace() <em>Namespace</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumeration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumeration</em>' container reference.
	 * @see #setEnumeration(Enumeration)
	 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getEnumerationLiteral_Enumeration()
	 * @see org.eclipselabs.damos.typesystem.Enumeration#getLiterals
	 * @model opposite="literals" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Enumeration getEnumeration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.typesystem.EnumerationLiteral#getEnumeration <em>Enumeration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enumeration</em>' container reference.
	 * @see #getEnumeration()
	 * @generated
	 */
	void setEnumeration(Enumeration value);
} // EnumerationLiteral
