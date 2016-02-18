/**
 */
package org.yakindu.base.base;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.base.DomainElement#getDomainID <em>Domain ID</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.base.BasePackage#getDomainElement()
 * @model
 * @generated
 */
public interface DomainElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Domain ID</b></em>' attribute.
	 * The default value is <code>"org.yakindu.domain.default"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain ID</em>' attribute.
	 * @see #setDomainID(String)
	 * @see org.yakindu.base.base.BasePackage#getDomainElement_DomainID()
	 * @model default="org.yakindu.domain.default"
	 * @generated
	 */
	String getDomainID();

	/**
	 * Sets the value of the '{@link org.yakindu.base.base.DomainElement#getDomainID <em>Domain ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain ID</em>' attribute.
	 * @see #getDomainID()
	 * @generated
	 */
	void setDomainID(String value);

} // DomainElement
