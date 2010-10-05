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
 *   <li>{@link org.eclipselabs.mscript.typesystem.ArrayDimension#getBeginIndex <em>Begin Index</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.ArrayDimension#getEndIndex <em>End Index</em>}</li>
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
	 * Returns the value of the '<em><b>Begin Index</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Begin Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Begin Index</em>' attribute.
	 * @see #setBeginIndex(int)
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayDimension_BeginIndex()
	 * @model default="1" required="true" ordered="false"
	 * @generated
	 */
	int getBeginIndex();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.typesystem.ArrayDimension#getBeginIndex <em>Begin Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Begin Index</em>' attribute.
	 * @see #getBeginIndex()
	 * @generated
	 */
	void setBeginIndex(int value);

	/**
	 * Returns the value of the '<em><b>End Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End Index</em>' attribute.
	 * @see #setEndIndex(int)
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayDimension_EndIndex()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getEndIndex();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.typesystem.ArrayDimension#getEndIndex <em>End Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End Index</em>' attribute.
	 * @see #getEndIndex()
	 * @generated
	 */
	void setEndIndex(int value);

	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayDimension_Size()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	int getSize();

} // ArrayDimension
