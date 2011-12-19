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
 * A representation of the model object '<em><b>State</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgraph.State#isOrthogonal <em>Orthogonal</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.State#getSubstatechart <em>Substatechart</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.State#getSubstatechartId <em>Substatechart Id</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.State#isSubchart <em>Subchart</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.State#isSimple <em>Simple</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.State#isComposite <em>Composite</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.State#isLeaf <em>Leaf</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState()
 * @model annotation="http://www.eclipse.org/emf/2002/Ecore constraints='NameIsNotEmpty'"
 * @generated
 */
public interface State extends SpecificationElement, ReactiveElement, ScopedElement, RegularState, CompositeElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * Returns the value of the '<em><b>Orthogonal</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Orthogonal</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Orthogonal</em>' attribute.
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState_Orthogonal()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isOrthogonal();

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
	 * @model transient="true"
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
	 * Returns the value of the '<em><b>Substatechart Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Substatechart Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Substatechart Id</em>' attribute.
	 * @see #setSubstatechartId(String)
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState_SubstatechartId()
	 * @model
	 * @generated
	 */
	String getSubstatechartId();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgraph.State#getSubstatechartId <em>Substatechart Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Substatechart Id</em>' attribute.
	 * @see #getSubstatechartId()
	 * @generated
	 */
	void setSubstatechartId(String value);

	/**
	 * Returns the value of the '<em><b>Subchart</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Subchart</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subchart</em>' attribute.
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState_Subchart()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isSubchart();

	/**
	 * Returns the value of the '<em><b>Simple</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Simple</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Simple</em>' attribute.
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState_Simple()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isSimple();

	/**
	 * Returns the value of the '<em><b>Composite</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite</em>' attribute.
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState_Composite()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isComposite();

	/**
	 * Returns the value of the '<em><b>Leaf</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Leaf</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Leaf</em>' attribute.
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getState_Leaf()
	 * @model transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isLeaf();


} // State
