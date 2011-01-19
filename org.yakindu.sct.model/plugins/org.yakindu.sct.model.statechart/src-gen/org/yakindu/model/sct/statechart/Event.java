/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.model.sct.statechart;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.model.sct.statechart.Event#get_ <em></em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.model.sct.statechart.StatechartPackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends NamedElement {
	/**
	 * Returns the value of the '<em><b></b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.model.sct.statechart.BehavioredElement#getEvents <em>Events</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em></em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em></em>' container reference.
	 * @see #set_(BehavioredElement)
	 * @see org.yakindu.model.sct.statechart.StatechartPackage#getEvent__()
	 * @see org.yakindu.model.sct.statechart.BehavioredElement#getEvents
	 * @model opposite="events" required="true" transient="false" ordered="false"
	 * @generated
	 */
	BehavioredElement get_();

	/**
	 * Sets the value of the '{@link org.yakindu.model.sct.statechart.Event#get_ <em></em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em></em>' container reference.
	 * @see #get_()
	 * @generated
	 */
	void set_(BehavioredElement value);

} // Event
