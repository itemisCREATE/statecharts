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


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Submachine State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgraph.SubmachineState#getSubstatechart <em>Substatechart</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getSubmachineState()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='SubStatechartExists SubStatechartIsNotACycle'"
 * @generated
 */
public interface SubmachineState extends AbstractState {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

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
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getSubmachineState_Substatechart()
	 * @model
	 * @generated
	 */
	Statechart getSubstatechart();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgraph.SubmachineState#getSubstatechart <em>Substatechart</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Substatechart</em>' reference.
	 * @see #getSubstatechart()
	 * @generated
	 */
	void setSubstatechart(Statechart value);

} // SubmachineState
