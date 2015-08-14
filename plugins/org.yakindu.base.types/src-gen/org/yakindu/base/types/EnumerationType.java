/**
 */
package org.yakindu.base.types;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enumeration Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.EnumerationType#getEnumerator <em>Enumerator</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getEnumerationType()
 * @model
 * @generated
 */
public interface EnumerationType extends PrimitiveType {

	/**
	 * Returns the value of the '<em><b>Enumerator</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Enumerator}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.types.Enumerator#getOwningEnumeration <em>Owning Enumeration</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enumerator</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enumerator</em>' containment reference list.
	 * @see org.yakindu.base.types.TypesPackage#getEnumerationType_Enumerator()
	 * @see org.yakindu.base.types.Enumerator#getOwningEnumeration
	 * @model opposite="owningEnumeration" containment="true"
	 * @generated
	 */
	EList<Enumerator> getEnumerator();
} // EnumerationType
