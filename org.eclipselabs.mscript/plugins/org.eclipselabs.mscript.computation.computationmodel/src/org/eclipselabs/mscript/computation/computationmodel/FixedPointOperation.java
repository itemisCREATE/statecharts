/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Fixed Point Operation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation#getIntermediateWordSize <em>Intermediate Word Size</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation#isSaturate <em>Saturate</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFixedPointOperation()
 * @model
 * @generated
 */
public interface FixedPointOperation extends EObject {
	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind
	 * @see #setKind(FixedPointOperationKind)
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFixedPointOperation_Kind()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	FixedPointOperationKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(FixedPointOperationKind value);

	/**
	 * Returns the value of the '<em><b>Intermediate Word Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Intermediate Word Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Intermediate Word Size</em>' attribute.
	 * @see #setIntermediateWordSize(int)
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFixedPointOperation_IntermediateWordSize()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	int getIntermediateWordSize();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation#getIntermediateWordSize <em>Intermediate Word Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Intermediate Word Size</em>' attribute.
	 * @see #getIntermediateWordSize()
	 * @generated
	 */
	void setIntermediateWordSize(int value);

	/**
	 * Returns the value of the '<em><b>Saturate</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Saturate</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Saturate</em>' attribute.
	 * @see #setSaturate(boolean)
	 * @see org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage#getFixedPointOperation_Saturate()
	 * @model required="true" ordered="false"
	 * @generated
	 */
	boolean isSaturate();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation#isSaturate <em>Saturate</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Saturate</em>' attribute.
	 * @see #isSaturate()
	 * @generated
	 */
	void setSaturate(boolean value);

} // FixedPointOperation
