/**
 */
package org.yakindu.base.types;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Package Member</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.PackageMember#getPackage <em>Package</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getPackageMember()
 * @model
 * @generated
 */
public interface PackageMember extends EObject {
	/**
	 * Returns the value of the '<em><b>Package</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.base.types.Package#getMembers <em>Members</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Package</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Package</em>' container reference.
	 * @see #setPackage(org.yakindu.base.types.Package)
	 * @see org.yakindu.base.types.TypesPackage#getPackageMember_Package()
	 * @see org.yakindu.base.types.Package#getMembers
	 * @model opposite="members" transient="false"
	 * @generated
	 */
	org.yakindu.base.types.Package getPackage();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.PackageMember#getPackage <em>Package</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Package</em>' container reference.
	 * @see #getPackage()
	 * @generated
	 */
	void setPackage(org.yakindu.base.types.Package value);

} // PackageMember
