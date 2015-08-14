/**
 */
package org.yakindu.base.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Primitive Type</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.base.types.PrimitiveType#getBaseType <em>Base Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.base.types.TypesPackage#getPrimitiveType()
 * @model
 * @generated
 */
public interface PrimitiveType extends Type {

	/**
	 * Returns the value of the '<em><b>Base Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Base Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Base Type</em>' reference.
	 * @see #setBaseType(PrimitiveType)
	 * @see org.yakindu.base.types.TypesPackage#getPrimitiveType_BaseType()
	 * @model
	 * @generated
	 */
	PrimitiveType getBaseType();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.PrimitiveType#getBaseType <em>Base Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Base Type</em>' reference.
	 * @see #getBaseType()
	 * @generated
	 */
	void setBaseType(PrimitiveType value);
} // PrimitiveType
