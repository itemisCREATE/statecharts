/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sexec;

import org.yakindu.base.types.ComplexType;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#isLeaf <em>Leaf</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getEntryAction <em>Entry Action</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionState#getExitAction <em>Exit Action</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState()
 * @model
 * @generated
 */
public interface ExecutionState extends ExecutionNode, ExecutionScope {
	/**
	 * Returns the value of the '<em><b>Entry Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Entry Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Entry Action</em>' containment reference.
	 * @see #setEntryAction(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_EntryAction()
	 * @model containment="true"
	 * @generated
	 */
	Step getEntryAction();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#getEntryAction <em>Entry Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entry Action</em>' containment reference.
	 * @see #getEntryAction()
	 * @generated
	 */
	void setEntryAction(Step value);

	/**
	 * Returns the value of the '<em><b>Exit Action</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Action</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Action</em>' containment reference.
	 * @see #setExitAction(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_ExitAction()
	 * @model containment="true"
	 * @generated
	 */
	Step getExitAction();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#getExitAction <em>Exit Action</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit Action</em>' containment reference.
	 * @see #getExitAction()
	 * @generated
	 */
	void setExitAction(Step value);

	/**
	 * Returns the value of the '<em><b>Leaf</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leaf</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaf</em>' attribute.
	 * @see #setLeaf(boolean)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionState_Leaf()
	 * @model default="false"
	 * @generated
	 */
	boolean isLeaf();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionState#isLeaf <em>Leaf</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Leaf</em>' attribute.
	 * @see #isLeaf()
	 * @generated
	 */
	void setLeaf(boolean value);

} // ExecutionState
