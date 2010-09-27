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
 * A representation of the model object '<em><b>Statechart</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.statechart.statechart.Statechart#getRegions <em>Regions</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getStatechart()
 * @model
 * @generated
 */
public interface Statechart extends EObject {
	/**
	 * Returns the value of the '<em><b>Regions</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.statechart.statechart.Region}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.statechart.statechart.Region#getStatechart <em>Statechart</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Regions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Regions</em>' containment reference list.
	 * @see org.yakindu.sct.model.statechart.statechart.StatechartPackage#getStatechart_Regions()
	 * @see org.yakindu.sct.model.statechart.statechart.Region#getStatechart
	 * @model opposite="statechart" containment="true" required="true" ordered="false"
	 * @generated
	 */
	EList<Region> getRegions();

} // Statechart
