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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.ExecutionEvent#isRaised <em>Raised</em>}</li>
 *   <li>{@link org.yakindu.sct.simulation.core.sruntime.ExecutionEvent#getDirection <em>Direction</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getExecutionEvent()
 * @model
 * @generated
 */
public interface ExecutionEvent extends ExecutionSlot {
	/**
	 * Returns the value of the '<em><b>Raised</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Raised</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Raised</em>' attribute.
	 * @see #setRaised(boolean)
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getExecutionEvent_Raised()
	 * @model
	 * @generated
	 */
	boolean isRaised();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.simulation.core.sruntime.ExecutionEvent#isRaised <em>Raised</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Raised</em>' attribute.
	 * @see #isRaised()
	 * @generated
	 */
	void setRaised(boolean value);

	/**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.sct.simulation.core.sruntime.EventDirection}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direction</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.yakindu.sct.simulation.core.sruntime.EventDirection
	 * @see #setDirection(EventDirection)
	 * @see org.yakindu.sct.simulation.core.sruntime.SRuntimePackage#getExecutionEvent_Direction()
	 * @model
	 * @generated
	 */
	EventDirection getDirection();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.simulation.core.sruntime.ExecutionEvent#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.yakindu.sct.simulation.core.sruntime.EventDirection
	 * @see #getDirection()
	 * @generated
	 */
	void setDirection(EventDirection value);

} // ExecutionEvent
