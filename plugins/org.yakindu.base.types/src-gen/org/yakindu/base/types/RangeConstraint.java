/**
 */
package org.yakindu.base.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Constraint</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.RangeConstraint#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link org.yakindu.base.types.RangeConstraint#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getRangeConstraint()
 * @model
 * @generated
 */
public interface RangeConstraint extends TypeConstraint {
	/**
	 * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Lower Bound</em>' attribute.
	 * @see #setLowerBound(long)
	 * @see org.yakindu.base.types.TypesPackage#getRangeConstraint_LowerBound()
	 * @model
	 * @generated
	 */
	long getLowerBound();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.RangeConstraint#getLowerBound <em>Lower Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Lower Bound</em>' attribute.
	 * @see #getLowerBound()
	 * @generated
	 */
	void setLowerBound(long value);

	/**
	 * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Upper Bound</em>' attribute.
	 * @see #setUpperBound(long)
	 * @see org.yakindu.base.types.TypesPackage#getRangeConstraint_UpperBound()
	 * @model
	 * @generated
	 */
	long getUpperBound();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.RangeConstraint#getUpperBound <em>Upper Bound</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Upper Bound</em>' attribute.
	 * @see #getUpperBound()
	 * @generated
	 */
	void setUpperBound(long value);

} // RangeConstraint
