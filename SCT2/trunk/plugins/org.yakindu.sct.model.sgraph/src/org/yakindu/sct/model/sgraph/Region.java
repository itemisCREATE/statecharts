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
import org.yakindu.base.base.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Region</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgraph.Region#getVertices <em>Vertices</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.Region#getComposite <em>Composite</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getRegion()
 * @model
 * @generated
 */
public interface Region extends NamedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * Returns the value of the '<em><b>Vertices</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sgraph.Vertex}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.sgraph.Vertex#getParentRegion <em>Parent Region</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Vertices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vertices</em>' containment reference list.
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getRegion_Vertices()
	 * @see org.yakindu.sct.model.sgraph.Vertex#getParentRegion
	 * @model opposite="parentRegion" containment="true" resolveProxies="true" ordered="false"
	 * @generated
	 */
	EList<Vertex> getVertices();

	/**
	 * Returns the value of the '<em><b>Composite</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.sgraph.CompositeElement#getRegions <em>Regions</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Composite</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Composite</em>' container reference.
	 * @see #setComposite(CompositeElement)
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getRegion_Composite()
	 * @see org.yakindu.sct.model.sgraph.CompositeElement#getRegions
	 * @model opposite="regions" required="true" transient="false"
	 * @generated
	 */
	CompositeElement getComposite();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgraph.Region#getComposite <em>Composite</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Composite</em>' container reference.
	 * @see #getComposite()
	 * @generated
	 */
	void setComposite(CompositeElement value);

} // Region
