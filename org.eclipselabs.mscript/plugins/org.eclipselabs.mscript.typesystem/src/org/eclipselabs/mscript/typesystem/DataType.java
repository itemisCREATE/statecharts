/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem;

import org.eclipse.emf.ecore.EObject;

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
public interface DataType extends EObject {

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" operatorRequired="true"
	 * @generated
	 */
	DataType evaluate(OperatorKind operator, DataType other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" operatorRequired="true" nRequired="true"
	 * @generated
	 */
	DataType evaluate(OperatorKind operator, int n);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" otherRequired="true"
	 * @generated
	 */
	boolean isAssignableFrom(DataType other);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" otherRequired="true"
	 * @generated
	 */
	boolean isEquivalentTo(DataType other);
} // DataType
