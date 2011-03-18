/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Format Mapping</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping#getOwnedDataType <em>Owned Data Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping#getDataType <em>Data Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping#getNumberFormat <em>Number Format</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getNumberFormatMapping()
 * @model
 * @generated
 */
public interface NumberFormatMapping extends EObject {
	/**
	 * Returns the value of the '<em><b>Owned Data Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Owned Data Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Owned Data Type</em>' containment reference.
	 * @see #setOwnedDataType(DataType)
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getNumberFormatMapping_OwnedDataType()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	DataType getOwnedDataType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping#getOwnedDataType <em>Owned Data Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Owned Data Type</em>' containment reference.
	 * @see #getOwnedDataType()
	 * @generated
	 */
	void setOwnedDataType(DataType value);

	/**
	 * Returns the value of the '<em><b>Data Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Type</em>' reference.
	 * @see #setDataType(DataType)
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getNumberFormatMapping_DataType()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	DataType getDataType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping#getDataType <em>Data Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data Type</em>' reference.
	 * @see #getDataType()
	 * @generated
	 */
	void setDataType(DataType value);

	/**
	 * Returns the value of the '<em><b>Number Format</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Format</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Format</em>' reference.
	 * @see #setNumberFormat(NumberFormat)
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getNumberFormatMapping_NumberFormat()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	NumberFormat getNumberFormat();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping#getNumberFormat <em>Number Format</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Number Format</em>' reference.
	 * @see #getNumberFormat()
	 * @generated
	 */
	void setNumberFormat(NumberFormat value);

} // NumberFormatMapping
