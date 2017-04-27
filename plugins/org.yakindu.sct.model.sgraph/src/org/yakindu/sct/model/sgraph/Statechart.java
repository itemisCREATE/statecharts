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
import org.yakindu.base.base.DomainElement;
import org.yakindu.base.base.NamedElement;
import org.yakindu.base.types.Annotation;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Statechart</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgraph.Statechart#getAnnotation <em>Annotation</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getStatechart()
 * @model
 * @generated
 */
public interface Statechart extends SpecificationElement, ReactiveElement, ScopedElement, CompositeElement, NamedElement, DocumentedElement, DomainElement {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * Returns the value of the '<em><b>Annotation</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Annotation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Annotation</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Annotation</em>' containment reference list.
	 * @see org.yakindu.sct.model.sgraph.SGraphPackage#getStatechart_Annotation()
	 * @model containment="true" resolveProxies="true" transient="true"
	 * @generated
	 */
	EList<Annotation> getAnnotation();

} // Statechart
