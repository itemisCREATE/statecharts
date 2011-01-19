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

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Behaviored Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.model.sct.statechart.BehavioredElement#getEvents <em>Events</em>}</li>
 *   <li>{@link org.yakindu.model.sct.statechart.BehavioredElement#getVariables <em>Variables</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.model.sct.statechart.StatechartPackage#getBehavioredElement()
 * @model abstract="true"
 * @generated
 */
public interface BehavioredElement extends EObject {
	/**
	 * Returns the value of the '<em><b>Events</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.model.sct.statechart.Event}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.model.sct.statechart.Event#get_ <em></em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Events</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Events</em>' containment reference list.
	 * @see org.yakindu.model.sct.statechart.StatechartPackage#getBehavioredElement_Events()
	 * @see org.yakindu.model.sct.statechart.Event#get_
	 * @model opposite="_" containment="true" ordered="false"
	 * @generated
	 */
	EList<Event> getEvents();

	/**
	 * Returns the value of the '<em><b>Variables</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.model.sct.statechart.Variable}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.model.sct.statechart.Variable#get_ <em></em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variables</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variables</em>' containment reference list.
	 * @see org.yakindu.model.sct.statechart.StatechartPackage#getBehavioredElement_Variables()
	 * @see org.yakindu.model.sct.statechart.Variable#get_
	 * @model opposite="_" containment="true" ordered="false"
	 * @generated
	 */
	EList<Variable> getVariables();

} // BehavioredElement
