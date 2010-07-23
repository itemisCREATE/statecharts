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
 * A representation of the model object '<em><b>Package</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.Package#getPackagedElements <em>Packaged Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getPackage()
 * @model
 * @generated
 */
public interface Package extends Namespace, PackageableElement {

	/**
	 * Returns the value of the '<em><b>Packaged Elements</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.typesystem.PackageableElement}.
	 * <p>
	 * This feature subsets the following features:
	 * <ul>
	 *   <li>'{@link org.eclipselabs.damos.typesystem.Namespace#getOwnedMembers() <em>Owned Members</em>}'</li>
	 * </ul>
	 * </p>
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Packaged Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Packaged Elements</em>' containment reference list.
	 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getPackage_PackagedElements()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<PackageableElement> getPackagedElements();

} // Package
