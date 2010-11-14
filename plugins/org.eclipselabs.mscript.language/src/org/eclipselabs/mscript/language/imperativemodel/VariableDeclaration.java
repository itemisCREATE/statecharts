/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel;

import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getType <em>Type</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getInitializer <em>Initializer</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getRingBufferSize <em>Ring Buffer Size</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getVariableDeclaration()
 * @model
 * @generated
 */
public interface VariableDeclaration extends Statement {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getVariableDeclaration_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

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
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getVariableDeclaration_Type()
	 * @model required="true"
	 * @generated
	 */
	DataType getType();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(DataType value);

	/**
	 * Returns the value of the '<em><b>Initializer</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initializer</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initializer</em>' containment reference.
	 * @see #setInitializer(Expression)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getVariableDeclaration_Initializer()
	 * @model containment="true"
	 * @generated
	 */
	Expression getInitializer();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getInitializer <em>Initializer</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initializer</em>' containment reference.
	 * @see #getInitializer()
	 * @generated
	 */
	void setInitializer(Expression value);

	/**
	 * Returns the value of the '<em><b>Ring Buffer Size</b></em>' attribute.
	 * The default value is <code>"1"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Ring Buffer Size</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Ring Buffer Size</em>' attribute.
	 * @see #setRingBufferSize(int)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getVariableDeclaration_RingBufferSize()
	 * @model default="1"
	 * @generated
	 */
	int getRingBufferSize();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration#getRingBufferSize <em>Ring Buffer Size</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Ring Buffer Size</em>' attribute.
	 * @see #getRingBufferSize()
	 * @generated
	 */
	void setRingBufferSize(int value);

} // VariableDeclaration
