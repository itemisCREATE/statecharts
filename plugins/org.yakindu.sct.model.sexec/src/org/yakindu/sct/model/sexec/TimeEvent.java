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
 * A representation of the model object '<em><b>Time Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.TimeEvent#isPeriodic <em>Periodic</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getTimeEvent()
 * @model
 * @generated
 */
public interface TimeEvent extends org.yakindu.base.types.Event {
	/**
	 * Returns the value of the '<em><b>Periodic</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Periodic</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Periodic</em>' attribute.
	 * @see #setPeriodic(boolean)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getTimeEvent_Periodic()
	 * @model default="false"
	 * @generated
	 */
	boolean isPeriodic();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.TimeEvent#isPeriodic <em>Periodic</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Periodic</em>' attribute.
	 * @see #isPeriodic()
	 * @generated
	 */
	void setPeriodic(boolean value);

} // TimeEvent
