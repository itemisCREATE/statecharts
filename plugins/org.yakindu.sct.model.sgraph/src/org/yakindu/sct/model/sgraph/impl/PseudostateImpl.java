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
package org.yakindu.sct.model.sgraph.impl;

import org.eclipse.emf.ecore.EClass;
import org.yakindu.sct.model.sgraph.Pseudostate;
import org.yakindu.sct.model.sgraph.SGraphPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Pseudostate</b></em>'.
 * <!-- end-user-doc -->
 *
 * @generated
 */
public abstract class PseudostateImpl extends VertexImpl implements Pseudostate {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PseudostateImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SGraphPackage.Literals.PSEUDOSTATE;
	}

	/**
	 * Checks if the name of the given element matches the requirements to be a
	 * 'default' element.
	 *
	 * @param element
	 *            - the {@link NamedElement}
	 * @return {@code true} if the name is null, empty or equals 'default' (ignoring
	 *         case).
	 */
	
	
	/**
	 * Checks if the name matches the requirements to be a 'default' element.
	 *
	 * @return {@code true} if the name is null, empty or equals 'default'
	 *         (ignoring case and after whitespace trimming).
	 * 
	 * @generated NOT
	 */
	public boolean isDefault() {
		return getName() == null
				|| (getName() != null && (getName().trim().isEmpty() || getName().trim().equalsIgnoreCase("default")));
	}

} //PseudostateImpl
