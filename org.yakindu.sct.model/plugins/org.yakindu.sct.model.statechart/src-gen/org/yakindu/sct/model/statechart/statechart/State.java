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

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.statechart.statechart.State#getRegions <em>Regions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.statechart.statechart.State#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getState()
 * @model
 * @generated
 */
public interface State extends Vertex, NamedElement {
	/**
	 * Returns the value of the '<em><b>Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.statechart.statechart.Region}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' containment reference list.
	 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getState_Regions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Region> getRegions();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' attribute.
	 * @see #setExpression(String)
	 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getState_Expression()
	 * @model
	 * @generated
	 */
	String getExpression();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.statechart.statechart.State#getExpression <em>Expression</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' attribute.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(String value);

} // State
