/**
 */
package org.yakindu.base.types;

import org.yakindu.base.base.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.types.PackageMember#getId <em>Id</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.types.TypesPackage#getPackageMember()
 * @model
 * @generated
 */
public interface PackageMember extends NamedElement, AnnotatableElement {

	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see org.yakindu.base.types.TypesPackage#getPackageMember_Id()
	 * @model id="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getId();

} // PackageMember
