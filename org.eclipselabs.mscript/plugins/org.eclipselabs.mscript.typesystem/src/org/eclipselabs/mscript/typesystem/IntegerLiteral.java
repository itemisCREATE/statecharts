/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Integer Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.IntegerLiteral#getData <em>Data</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.IntegerLiteral#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getIntegerLiteral()
 * @model
 * @generated
 */
public interface IntegerLiteral extends NumericLiteral {
	/**
	 * Returns the value of the '<em><b>Data</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Data</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data</em>' attribute.
	 * @see #setData(IntegerData)
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getIntegerLiteral_Data()
	 * @model default="0" dataType="org.eclipselabs.mscript.typesystem.IntegerData"
	 * @generated
	 */
	IntegerData getData();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.typesystem.IntegerLiteral#getData <em>Data</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Data</em>' attribute.
	 * @see #getData()
	 * @generated
	 */
	void setData(IntegerData value);

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(long)
	 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getIntegerLiteral_Value()
	 * @model transient="true" volatile="true" derived="true"
	 * @generated
	 */
	long getValue();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.typesystem.IntegerLiteral#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(long value);

} // IntegerLiteral
