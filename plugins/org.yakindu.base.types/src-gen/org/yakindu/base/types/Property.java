/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.base.types;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Property</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.types.Property#isConst <em>Const</em>}</li>
 *   <li>{@link org.yakindu.base.types.Property#isReadonly <em>Readonly</em>}</li>
 *   <li>{@link org.yakindu.base.types.Property#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.types.TypesPackage#getProperty()
 * @model
 * @generated
 */
public interface Property extends TypedDeclaration {

	/**
	 * Returns the value of the '<em><b>Const</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Const</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Const</em>' attribute.
	 * @see #setConst(boolean)
	 * @see org.yakindu.base.types.TypesPackage#getProperty_Const()
	 * @model
	 * @generated
	 */
	boolean isConst();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.Property#isConst <em>Const</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Const</em>' attribute.
	 * @see #isConst()
	 * @generated
	 */
	void setConst(boolean value);

	/**
	 * Returns the value of the '<em><b>Readonly</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Readonly</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Readonly</em>' attribute.
	 * @see #setReadonly(boolean)
	 * @see org.yakindu.base.types.TypesPackage#getProperty_Readonly()
	 * @model
	 * @generated
	 */
	boolean isReadonly();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.Property#isReadonly <em>Readonly</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Readonly</em>' attribute.
	 * @see #isReadonly()
	 * @generated
	 */
	void setReadonly(boolean value);

	/**
	 * Returns the value of the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Value</em>' containment reference.
	 * @see #setInitialValue(Expression)
	 * @see org.yakindu.base.types.TypesPackage#getProperty_InitialValue()
	 * @model containment="true"
	 * @generated
	 */
	Expression getInitialValue();

	/**
	 * Sets the value of the '{@link org.yakindu.base.types.Property#getInitialValue <em>Initial Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Value</em>' containment reference.
	 * @see #getInitialValue()
	 * @generated
	 */
	void setInitialValue(Expression value);
} // Property
