/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sruntime;

import org.yakindu.base.base.NamedElement;

import org.yakindu.base.types.Type;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sruntime.ExecutionSlot#getValue <em>Value</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.ExecutionSlot#getFqName <em>Fq Name</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.ExecutionSlot#isWritable <em>Writable</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sruntime.ExecutionSlot#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sruntime.SRuntimePackage#getExecutionSlot()
 * @model abstract="true"
 * @generated
 */
public interface ExecutionSlot extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(Object)
	 * @see org.yakindu.sct.model.sruntime.SRuntimePackage#getExecutionSlot_Value()
	 * @model unique="false" dataType="org.yakindu.sct.model.sruntime.JavaObject"
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sruntime.ExecutionSlot#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * Returns the value of the '<em><b>Fq Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Fq Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Fq Name</em>' attribute.
	 * @see #setFqName(String)
	 * @see org.yakindu.sct.model.sruntime.SRuntimePackage#getExecutionSlot_FqName()
	 * @model unique="false"
	 * @generated
	 */
	String getFqName();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sruntime.ExecutionSlot#getFqName <em>Fq Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Fq Name</em>' attribute.
	 * @see #getFqName()
	 * @generated
	 */
	void setFqName(String value);

	/**
	 * Returns the value of the '<em><b>Writable</b></em>' attribute.
	 * The default value is <code>"true"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Writable</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Writable</em>' attribute.
	 * @see #setWritable(boolean)
	 * @see org.yakindu.sct.model.sruntime.SRuntimePackage#getExecutionSlot_Writable()
	 * @model default="true" unique="false"
	 * @generated
	 */
	boolean isWritable();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sruntime.ExecutionSlot#isWritable <em>Writable</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Writable</em>' attribute.
	 * @see #isWritable()
	 * @generated
	 */
	void setWritable(boolean value);

	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(Type)
	 * @see org.yakindu.sct.model.sruntime.SRuntimePackage#getExecutionSlot_Type()
	 * @model
	 * @generated
	 */
	Type getType();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sruntime.ExecutionSlot#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(Type value);

} // ExecutionSlot
