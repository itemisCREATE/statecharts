/**
 * Copyright (c) 2013 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.simulation.core.sruntime;

import org.yakindu.base.base.NamedElement;

import org.yakindu.base.types.ITypeSystem.InferredType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Slot</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.ExecutionSlot#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.ExecutionSlot#getValue <em>Value</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.ExecutionSlot#getQualifiedName <em>Qualified Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getExecutionSlot()
 * @model abstract="true"
 * @generated
 */
public interface ExecutionSlot extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(InferredType)
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getExecutionSlot_Type()
	 * @model dataType="org.yakindu.sct.simulation.core.sruntime.InferredType"
	 * @generated
	 */
	InferredType getType();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.simulation.core.sruntime.ExecutionSlot#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(InferredType value);

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
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getExecutionSlot_Value()
	 * @model dataType="org.yakindu.sct.simulation.core.sruntime.JavaObject"
	 * @generated
	 */
	Object getValue();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.simulation.core.sruntime.ExecutionSlot#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(Object value);

	/**
	 * Returns the value of the '<em><b>Qualified Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Qualified Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Qualified Name</em>' attribute.
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getExecutionSlot_QualifiedName()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	String getQualifiedName();

} // ExecutionSlot
