/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Point Format</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getIntegerLength <em>Integer Length</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getFractionLength <em>Fraction Length</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getWordSize <em>Word Size</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getOperations <em>Operations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFixedPointFormat()
 * @model
 * @generated
 */
public interface FixedPointFormat extends NumberFormat {
	/**
	 * Returns the value of the '<em><b>Integer Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Integer Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integer Length</em>' attribute.
	 * @see #setIntegerLength(int)
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFixedPointFormat_IntegerLength()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getIntegerLength();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getIntegerLength <em>Integer Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integer Length</em>' attribute.
	 * @see #getIntegerLength()
	 * @generated
	 */
	void setIntegerLength(int value);

	/**
	 * Returns the value of the '<em><b>Fraction Length</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fraction Length</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fraction Length</em>' attribute.
	 * @see #setFractionLength(int)
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFixedPointFormat_FractionLength()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getFractionLength();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat#getFractionLength <em>Fraction Length</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fraction Length</em>' attribute.
	 * @see #getFractionLength()
	 * @generated
	 */
	void setFractionLength(int value);

	/**
	 * Returns the value of the '<em><b>Word Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Word Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Word Size</em>' attribute.
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFixedPointFormat_WordSize()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true" ordered="false"
	 * @generated
	 */
	int getWordSize();

	/**
	 * Returns the value of the '<em><b>Operations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Operations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Operations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFixedPointFormat_Operations()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<FixedPointOperation> getOperations();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model ordered="false" kindRequired="true" kindOrdered="false"
	 * @generated
	 */
	FixedPointOperation getOperation(FixedPointOperationKind kind);

} // FixedPointFormat
