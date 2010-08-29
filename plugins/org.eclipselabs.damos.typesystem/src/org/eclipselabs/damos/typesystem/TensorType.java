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
 * A representation of the model object '<em><b>Tensor Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.TensorType#getUnits <em>Units</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getTensorType()
 * @model
 * @generated
 */
public interface TensorType extends ArrayType {
	/**
	 * Returns the value of the '<em><b>Units</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.damos.typesystem.Unit}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Units</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Units</em>' containment reference list.
	 * @see #isSetUnits()
	 * @see #unsetUnits()
	 * @see org.eclipselabs.damos.typesystem.TypeSystemPackage#getTensorType_Units()
	 * @model containment="true" unsettable="true" ordered="false"
	 * @generated
	 */
	EList<Unit> getUnits();

	/**
	 * Unsets the value of the '{@link org.eclipselabs.damos.typesystem.TensorType#getUnits <em>Units</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isSetUnits()
	 * @see #getUnits()
	 * @generated
	 */
	void unsetUnits();

	/**
	 * Returns whether the value of the '{@link org.eclipselabs.damos.typesystem.TensorType#getUnits <em>Units</em>}' containment reference list is set.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return whether the value of the '<em>Units</em>' containment reference list is set.
	 * @see #unsetUnits()
	 * @see #getUnits()
	 * @generated
	 */
	boolean isSetUnits();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" indexRequired="true" indexOrdered="false"
	 * @generated
	 */
	Unit getUnit(int index);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" rowRequired="true" rowOrdered="false" columnRequired="true" columnOrdered="false"
	 * @generated
	 */
	Unit getUnit(int row, int column);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" indicesRequired="true" indicesMany="true" indicesOrdered="false"
	 * @generated
	 */
	Unit getUnit(EList<Integer> indices);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model indexRequired="true" indexOrdered="false" unitRequired="true" unitOrdered="false"
	 * @generated
	 */
	void setUnit(int index, Unit unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model rowRequired="true" rowOrdered="false" columnRequired="true" columnOrdered="false" unitRequired="true" unitOrdered="false"
	 * @generated
	 */
	void setUnit(int row, int column, Unit unit);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model indicesRequired="true" indicesMany="true" indicesOrdered="false" unitRequired="true" unitOrdered="false"
	 * @generated
	 */
	void setUnit(EList<Integer> indices, Unit unit);

} // TensorType
