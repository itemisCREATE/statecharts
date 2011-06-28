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

} // State
