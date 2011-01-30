/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.ArrayDimension#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayDimension()
 * @model
 * @generated
 */
public interface ArrayDimension extends EObject {
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayDimension_Size()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.typesystem.ArrayDimension#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

} // ArrayDimension
