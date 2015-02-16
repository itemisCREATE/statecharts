/**
 */
package org.yakindu.base.types;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Domain</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.Domain#getDomainID <em>Domain ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getDomain()
 * @model
 * @generated
 */
public interface Domain extends EObject {
	/**
	 * Returns the value of the '<em><b>Domain ID</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain ID</em>' attribute.
	 * @see #setDomainID(String)
	 * @see org.yakindu.base.types.TypesPackage#getDomain_DomainID()
	 * @model
	 * @generated
	 */
	String getDomainID();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.Domain#getDomainID <em>Domain ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain ID</em>' attribute.
	 * @see #getDomainID()
	 * @generated
	 */
	void setDomainID(String value);

} // Domain
