/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.model.statechart.statechart;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Vertex</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.statechart.statechart.Vertex#getIncomingTransitions <em>Incoming Transitions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.statechart.statechart.Vertex#getOutgoingTransitions <em>Outgoing Transitions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.statechart.statechart.Vertex#getContainingRegion <em>Containing Region</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getVertex()
 * @model abstract="true"
 * @generated
 */
public interface Vertex extends EObject {
	/**
	 * Returns the value of the '<em><b>Incoming Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.statechart.statechart.Transition}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.statechart.statechart.Transition#getTarget <em>Target</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Incoming Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Incoming Transitions</em>' reference list.
	 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getVertex_IncomingTransitions()
	 * @see org.yakindu.sct.model.statechart.statechart.Transition#getTarget
	 * @model opposite="target" ordered="false"
	 * @generated
	 */
	EList<Transition> getIncomingTransitions();

	/**
	 * Returns the value of the '<em><b>Outgoing Transitions</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.statechart.statechart.Transition}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.statechart.statechart.Transition#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outgoing Transitions</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outgoing Transitions</em>' reference list.
	 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getVertex_OutgoingTransitions()
	 * @see org.yakindu.sct.model.statechart.statechart.Transition#getSource
	 * @model opposite="source" ordered="false"
	 * @generated
	 */
	EList<Transition> getOutgoingTransitions();

	/**
	 * Returns the value of the '<em><b>Containing Region</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.statechart.statechart.Region#getVertices <em>Vertices</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Containing Region</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Containing Region</em>' container reference.
	 * @see #setContainingRegion(Region)
	 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getVertex_ContainingRegion()
	 * @see org.yakindu.sct.model.statechart.statechart.Region#getVertices
	 * @model opposite="vertices" required="true" transient="false" ordered="false"
	 * @generated
	 */
	Region getContainingRegion();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.statechart.statechart.Vertex#getContainingRegion <em>Containing Region</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Containing Region</em>' container reference.
	 * @see #getContainingRegion()
	 * @generated
	 */
	void setContainingRegion(Region value);

} // Vertex
