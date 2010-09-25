/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.ArrayType#getElementType <em>Element Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.ArrayType#getDimensions <em>Dimensions</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.ArrayType#getDimensionality <em>Dimensionality</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.ArrayType#getRowSize <em>Row Size</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.ArrayType#getColumnSize <em>Column Size</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.ArrayType#isDimensional <em>Dimensional</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.ArrayType#isMultidimensional <em>Multidimensional</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayType()
 * @model
 * @generated
 */
public interface ArrayType extends DataType {
	/**
	 * Returns the value of the '<em><b>Element Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element Type</em>' reference.
	 * @see #setElementType(DataType)
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayType_ElementType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getElementType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.typesystem.ArrayType#getElementType <em>Element Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element Type</em>' reference.
	 * @see #getElementType()
	 * @generated
	 */
	void setElementType(DataType value);

	/**
	 * Returns the value of the '<em><b>Dimensions</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.typesystem.ArrayDimension}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensions</em>' containment reference list.
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayType_Dimensions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<ArrayDimension> getDimensions();

	/**
	 * Returns the value of the '<em><b>Dimensionality</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensionality</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensionality</em>' attribute.
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayType_Dimensionality()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	int getDimensionality();

	/**
	 * Returns the value of the '<em><b>Row Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Row Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Row Size</em>' attribute.
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayType_RowSize()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	int getRowSize();

	/**
	 * Returns the value of the '<em><b>Column Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Column Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Column Size</em>' attribute.
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayType_ColumnSize()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	int getColumnSize();

	/**
	 * Returns the value of the '<em><b>Dimensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Dimensional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Dimensional</em>' attribute.
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayType_Dimensional()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isDimensional();

	/**
	 * Returns the value of the '<em><b>Multidimensional</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Multidimensional</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Multidimensional</em>' attribute.
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getArrayType_Multidimensional()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	boolean isMultidimensional();

} // ArrayType
