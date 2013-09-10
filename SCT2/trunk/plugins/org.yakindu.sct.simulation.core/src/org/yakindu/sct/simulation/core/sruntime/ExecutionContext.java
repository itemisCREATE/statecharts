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

import java.util.List;

import org.eclipse.emf.ecore.EObject;

import org.yakindu.base.base.NamedElement;

import org.yakindu.sct.model.sgraph.RegularState;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.ExecutionContext#getActiveStates <em>Active States</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.ExecutionContext#getExecutedElements <em>Executed Elements</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.ExecutionContext#getSuspendedElements <em>Suspended Elements</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.ExecutionContext#isSnapshot <em>Snapshot</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getExecutionContext()
 * @model
 * @generated
 */
public interface ExecutionContext extends NamedElement, CompositeSlot {
	/**
	 * Returns the value of the '<em><b>Active States</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sgraph.RegularState}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Active States</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Active States</em>' reference list.
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getExecutionContext_ActiveStates()
	 * @model
	 * @generated
	 */
	List<RegularState> getActiveStates();

	/**
	 * Returns the value of the '<em><b>Executed Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Executed Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Executed Elements</em>' reference list.
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getExecutionContext_ExecutedElements()
	 * @model
	 * @generated
	 */
	List<EObject> getExecutedElements();

	/**
	 * Returns the value of the '<em><b>Suspended Elements</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Suspended Elements</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Suspended Elements</em>' reference list.
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getExecutionContext_SuspendedElements()
	 * @model
	 * @generated
	 */
	List<EObject> getSuspendedElements();

	/**
	 * Returns the value of the '<em><b>Snapshot</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Snapshot</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Snapshot</em>' attribute.
	 * @see #setSnapshot(boolean)
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getExecutionContext_Snapshot()
	 * @model
	 * @generated
	 */
	boolean isSnapshot();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.simulation.core.sruntime.ExecutionContext#isSnapshot <em>Snapshot</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Snapshot</em>' attribute.
	 * @see #isSnapshot()
	 * @generated
	 */
	void setSnapshot(boolean value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	List<ExecutionEvent> getRaisedEvents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	List<ExecutionEvent> getScheduledEvents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ExecutionVariable getVariable(String qualifiedName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	ExecutionEvent getEvent(String qualifiedName);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	List<RegularState> getAllActiveStates();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	List<ExecutionEvent> getAllEvents();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	List<ExecutionVariable> getAllVariables();

} // ExecutionContext
