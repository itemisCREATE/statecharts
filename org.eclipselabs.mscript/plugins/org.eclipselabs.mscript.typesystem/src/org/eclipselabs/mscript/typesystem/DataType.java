/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem;




/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see org.eclipselabs.mscript.typesystem.TypeSystemPackage#getDataType()
 * @model abstract="true"
 * @generated
 */
public interface DataType extends Type {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" operatorRequired="true" operatorOrdered="false" otherOrdered="false"
	 * @generated
	 */
	DataType evaluate(OperatorKind operator, DataType other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" exponentRequired="true" exponentOrdered="false"
	 * @generated
	 */
	DataType evaluatePower(int exponent);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" ordered="false" otherRequired="true" otherOrdered="false"
	 * @generated
	 */
	boolean isAssignableFrom(DataType other);

} // DataType
