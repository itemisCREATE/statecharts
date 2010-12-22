/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computation Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.ComputationModel#getNumberFormats <em>Number Formats</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.ComputationModel#getNumberFormatMappings <em>Number Format Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getComputationModel()
 * @model
 * @generated
 */
public interface ComputationModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Number Formats</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.computation.computationmodel.NumberFormat}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Formats</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Formats</em>' containment reference list.
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getComputationModel_NumberFormats()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<NumberFormat> getNumberFormats();

	/**
	 * Returns the value of the '<em><b>Number Format Mappings</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Number Format Mappings</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Number Format Mappings</em>' containment reference list.
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getComputationModel_NumberFormatMappings()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<NumberFormatMapping> getNumberFormatMappings();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" dataTypeRequired="true" dataTypeOrdered="false"
	 * @generated
	 */
	NumberFormat getNumberFormat(DataType dataType);

} // ComputationModel
