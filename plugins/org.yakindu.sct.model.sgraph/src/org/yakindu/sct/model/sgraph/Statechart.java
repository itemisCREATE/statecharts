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
import org.yakindu.base.base.DocumentedElement;
import org.yakindu.base.base.NamedElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statechart</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgraph.Statechart#getImports <em>Imports</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgraph.Statechart#getDomainID <em>Domain ID</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getStatechart()
 * @model
 * @generated
 */
public interface Statechart extends SpecificationElement, ReactiveElement, ScopedElement, CompositeElement, NamedElement, DocumentedElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * Returns the value of the '<em><b>Imports</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sgraph.Import}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Imports</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Imports</em>' containment reference list.
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getStatechart_Imports()
	 * @model containment="true" resolveProxies="true"
	 * @generated
	 */
	EList<Import> getImports();

	/**
	 * Returns the value of the '<em><b>Domain ID</b></em>' attribute.
	 * The default value is <code>"org.yakindu.domain.default"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Domain ID</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Domain ID</em>' attribute.
	 * @see #setDomainID(String)
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getStatechart_DomainID()
	 * @model default="org.yakindu.domain.default"
	 * @generated
	 */
	String getDomainID();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgraph.Statechart#getDomainID <em>Domain ID</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Domain ID</em>' attribute.
	 * @see #getDomainID()
	 * @generated
	 */
	void setDomainID(String value);

} // Statechart
