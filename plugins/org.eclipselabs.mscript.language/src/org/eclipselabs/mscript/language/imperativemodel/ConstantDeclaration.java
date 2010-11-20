/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel;

import org.eclipselabs.mscript.language.interpreter.value.IValue;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constant Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.ConstantDeclaration#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getConstantDeclaration()
 * @model
 * @generated
 */
public interface ConstantDeclaration extends VariableDeclaration {

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(IValue)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getConstantDeclaration_Value()
	 * @model dataType="org.eclipselabs.mscript.language.imperativemodel.IValue" transient="true"
	 * @generated
	 */
	IValue getValue();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.ConstantDeclaration#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(IValue value);
} // ConstantDeclaration
