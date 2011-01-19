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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.model.sct.statechart.Region#getTransitions <em>Transitions</em>}</li>
 *   <li>{@link org.yakindu.model.sct.statechart.Region#getVertices <em>Vertices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.model.sct.statechart.StatechartPackage#getRegion()
 * @model
 * @generated
 */
public interface Region extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Transitions</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.model.sct.statechart.Transition}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.model.sct.statechart.Transition#get_ <em></em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transitions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transitions</em>' containment reference list.
	 * @see org.yakindu.model.sct.statechart.StatechartPackage#getRegion_Transitions()
	 * @see org.yakindu.model.sct.statechart.Transition#get_
	 * @model opposite="_" containment="true" ordered="false"
	 * @generated
	 */
	EList<Transition> getTransitions();

	/**
	 * Returns the value of the '<em><b>Vertices</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.model.sct.statechart.Vertex}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.model.sct.statechart.Vertex#getParentRegion <em>Parent Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertices</em>' containment reference list.
	 * @see org.yakindu.model.sct.statechart.StatechartPackage#getRegion_Vertices()
	 * @see org.yakindu.model.sct.statechart.Vertex#getParentRegion
	 * @model opposite="parentRegion" containment="true" ordered="false"
	 * @generated
	 */
	EList<Vertex> getVertices();

} // Region
