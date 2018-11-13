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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Schedule Time Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.ScheduleTimeEvent#getTimeEvent <em>Time Event</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ScheduleTimeEvent#getTimeValue <em>Time Value</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getScheduleTimeEvent()
 * @model
 * @generated
 */
public interface ScheduleTimeEvent extends Step {
	/**
	 * Returns the value of the '<em><b>Time Event</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Event</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Event</em>' reference.
	 * @see #setTimeEvent(TimeEvent)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getScheduleTimeEvent_TimeEvent()
	 * @model
	 * @generated
	 */
	TimeEvent getTimeEvent();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ScheduleTimeEvent#getTimeEvent <em>Time Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Event</em>' reference.
	 * @see #getTimeEvent()
	 * @generated
	 */
	void setTimeEvent(TimeEvent value);

	/**
	 * Returns the value of the '<em><b>Time Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Time Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Time Value</em>' containment reference.
	 * @see #setTimeValue(org.yakindu.base.types.Expression)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getScheduleTimeEvent_TimeValue()
	 * @model containment="true"
	 * @generated
	 */
	org.yakindu.base.types.Expression getTimeValue();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ScheduleTimeEvent#getTimeValue <em>Time Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Value</em>' containment reference.
	 * @see #getTimeValue()
	 * @generated
	 */
	void setTimeValue(org.yakindu.base.types.Expression value);

} // ScheduleTimeEvent
