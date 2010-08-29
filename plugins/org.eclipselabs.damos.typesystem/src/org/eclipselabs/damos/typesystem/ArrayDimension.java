/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Dimension</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.ArrayDimension#getFromIndex <em>From Index</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.ArrayDimension#getToIndex <em>To Index</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.ArrayDimension#getSize <em>Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getArrayDimension()
 * @model
 * @generated
 */
public interface ArrayDimension extends EObject {
	/**
	 * Returns the value of the '<em><b>From Index</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>From Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>From Index</em>' attribute.
	 * @see #setFromIndex(int)
	 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getArrayDimension_FromIndex()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getFromIndex();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.typesystem.ArrayDimension#getFromIndex <em>From Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>From Index</em>' attribute.
	 * @see #getFromIndex()
	 * @generated
	 */
	void setFromIndex(int value);

	/**
	 * Returns the value of the '<em><b>To Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>To Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>To Index</em>' attribute.
	 * @see #setToIndex(int)
	 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getArrayDimension_ToIndex()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getToIndex();

	/**
	 * Sets the value of the '{@link org.eclipselabs.damos.typesystem.ArrayDimension#getToIndex <em>To Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>To Index</em>' attribute.
	 * @see #getToIndex()
	 * @generated
	 */
	void setToIndex(int value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getArrayDimension_Size()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	int getSize();

} // ArrayDimension
