/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sgraph;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgraph.State#getSubRegions <em>Sub Regions</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.State#getSubstatechart <em>Substatechart</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.State#isSubmachineState <em>Submachine State</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.State#isCompositeState <em>Composite State</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.State#isSimpleState <em>Simple State</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NameIsNotEmpty'"
 * @generated
 */
public interface State extends Vertex, ExpressionElement, ReactiveElement, ScopedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * Returns the value of the '<em><b>Sub Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sgraph.Region}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Regions</em>' containment reference list.
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState_SubRegions()
	 * @model containment="true" ordered="false"
	 * @generated
	 */
	EList<Region> getSubRegions();

	/**
	 * Returns the value of the '<em><b>Substatechart</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Substatechart</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Substatechart</em>' reference.
	 * @see #setSubstatechart(Statechart)
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState_Substatechart()
	 * @model
	 * @generated
	 */
	Statechart getSubstatechart();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgraph.State#getSubstatechart <em>Substatechart</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Substatechart</em>' reference.
	 * @see #getSubstatechart()
	 * @generated
	 */
	void setSubstatechart(Statechart value);

	/**
	 * Returns the value of the '<em><b>Submachine State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Submachine State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Submachine State</em>' attribute.
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState_SubmachineState()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isSubmachineState();

	/**
	 * Returns the value of the '<em><b>Composite State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite State</em>' attribute.
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState_CompositeState()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isCompositeState();

	/**
	 * Returns the value of the '<em><b>Simple State</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple State</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple State</em>' attribute.
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState_SimpleState()
	 * @model transient="true" changeable="false" volatile="true"
	 * @generated
	 */
	boolean isSimpleState();

} // State
