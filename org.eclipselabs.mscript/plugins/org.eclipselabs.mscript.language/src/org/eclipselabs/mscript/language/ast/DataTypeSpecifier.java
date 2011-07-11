/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Type Specifier</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.DataTypeSpecifier#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.DataTypeSpecifier#getDefinedType <em>Defined Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getDataTypeSpecifier()
 * @model
 * @generated
 */
public interface DataTypeSpecifier extends EObject {

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(DataType)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getDataTypeSpecifier_Type()
	 * @model
	 * @generated
	 */
	DataType getType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.DataTypeSpecifier#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DataType value);

	/**
	 * Returns the value of the '<em><b>Defined Type</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Defined Type</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Defined Type</em>' containment reference.
	 * @see #setDefinedType(DataType)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getDataTypeSpecifier_DefinedType()
	 * @model containment="true"
	 * @generated
	 */
	DataType getDefinedType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.DataTypeSpecifier#getDefinedType <em>Defined Type</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Defined Type</em>' containment reference.
	 * @see #getDefinedType()
	 * @generated
	 */
	void setDefinedType(DataType value);
} // DataTypeSpecifier
