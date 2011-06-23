/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il;

import org.eclipselabs.mscript.computation.core.value.IValue;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Template Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.il.TemplateVariableDeclaration#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.il.ILPackage#getTemplateVariableDeclaration()
 * @model
 * @generated
 */
public interface TemplateVariableDeclaration extends VariableDeclaration {

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
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getTemplateVariableDeclaration_Value()
	 * @model dataType="org.eclipselabs.mscript.language.il.IValue"
	 * @generated
	 */
	IValue getValue();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.il.TemplateVariableDeclaration#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(IValue value);
} // TemplateVariableDeclaration
