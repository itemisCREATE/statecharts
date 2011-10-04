/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unschedule Time Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.UnscheduleTimeEvent#getTimeEvent <em>Time Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getUnscheduleTimeEvent()
 * @model
 * @generated
 */
public interface UnscheduleTimeEvent extends Step {
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
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getUnscheduleTimeEvent_TimeEvent()
	 * @model
	 * @generated
	 */
	TimeEvent getTimeEvent();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.UnscheduleTimeEvent#getTimeEvent <em>Time Event</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Time Event</em>' reference.
	 * @see #getTimeEvent()
	 * @generated
	 */
	void setTimeEvent(TimeEvent value);

} // UnscheduleTimeEvent
