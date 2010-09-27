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
 * A representation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.statechart.statechart.Region#getVertices <em>Vertices</em>}</li>
 *   <li>{@link org.yakindu.sct.model.statechart.statechart.Region#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.statechart.statechart.Region#getStatechart <em>Statechart</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getRegion()
 * @model
 * @generated
 */
public interface Region extends EObject {
	/**
	 * Returns the value of the '<em><b>Vertices</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.statechart.statechart.Vertex}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.statechart.statechart.Vertex#getContainingRegion <em>Containing Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertices</em>' containment reference list.
	 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getRegion_Vertices()
	 * @see org.yakindu.sct.model.statechart.statechart.Vertex#getContainingRegion
	 * @model opposite="containingRegion" containment="true" ordered="false"
	 * @generated
	 */
	EList<Vertex> getVertices();

	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.statechart.statechart.Transition}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.statechart.statechart.Transition#getRegion <em>Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getRegion_Transitions()
	 * @see org.yakindu.sct.model.statechart.statechart.Transition#getRegion
	 * @model opposite="region" containment="true" ordered="false"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Statechart</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.statechart.statechart.Statechart#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Statechart</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Statechart</em>' container reference.
	 * @see #setStatechart(Statechart)
	 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getRegion_Statechart()
	 * @see org.yakindu.sct.model.statechart.statechart.Statechart#getRegions
	 * @model opposite="regions" transient="false" ordered="false"
	 * @generated
	 */
	Statechart getStatechart();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.statechart.statechart.Region#getStatechart <em>Statechart</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Statechart</em>' container reference.
	 * @see #getStatechart()
	 * @generated
	 */
	void setStatechart(Statechart value);

} // Region
