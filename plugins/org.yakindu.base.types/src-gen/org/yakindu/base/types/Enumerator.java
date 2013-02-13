/**
 */
package org.yakindu.base.types;

import org.yakindu.base.base.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumerator</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.Enumerator#getOwningEnumeration <em>Owning Enumeration</em>}</li>
 *   <li>{@link org.yakindu.base.types.Enumerator#getLiteralValue <em>Literal Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getEnumerator()
 * @model
 * @generated
 */
public interface Enumerator extends NamedElement {

	/**
	 * Returns the value of the '<em><b>Owning Enumeration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.types.EnumerationType#getEnumerator <em>Enumerator</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owning Enumeration</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owning Enumeration</em>' container reference.
	 * @see #setOwningEnumeration(EnumerationType)
	 * @see org.yakindu.base.types.TypesPackage#getEnumerator_OwningEnumeration()
	 * @see org.yakindu.base.types.EnumerationType#getEnumerator
	 * @model opposite="enumerator" transient="false"
	 * @generated
	 */
	EnumerationType getOwningEnumeration();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.Enumerator#getOwningEnumeration <em>Owning Enumeration</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owning Enumeration</em>' container reference.
	 * @see #getOwningEnumeration()
	 * @generated
	 */
	void setOwningEnumeration(EnumerationType value);

	/**
	 * Returns the value of the '<em><b>Literal Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Literal Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Literal Value</em>' attribute.
	 * @see #setLiteralValue(Object)
	 * @see org.yakindu.base.types.TypesPackage#getEnumerator_LiteralValue()
	 * @model
	 * @generated
	 */
	Object getLiteralValue();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.Enumerator#getLiteralValue <em>Literal Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Literal Value</em>' attribute.
	 * @see #getLiteralValue()
	 * @generated
	 */
	void setLiteralValue(Object value);
} // Enumerator
