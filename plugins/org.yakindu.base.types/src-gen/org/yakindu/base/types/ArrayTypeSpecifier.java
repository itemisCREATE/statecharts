/**
 */
package org.yakindu.base.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Array Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.types.ArrayTypeSpecifier#getSize <em>Size</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.types.TypesPackage#getArrayTypeSpecifier()
 * @model
 * @generated
 */
public interface ArrayTypeSpecifier extends TypeSpecifier {
	/**
	 * Returns the value of the '<em><b>Size</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Size</em>' attribute.
	 * @see #setSize(int)
	 * @see org.yakindu.base.types.TypesPackage#getArrayTypeSpecifier_Size()
	 * @model
	 * @generated
	 */
	int getSize();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.ArrayTypeSpecifier#getSize <em>Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Size</em>' attribute.
	 * @see #getSize()
	 * @generated
	 */
	void setSize(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	Type getElementType();

} // ArrayTypeSpecifier
