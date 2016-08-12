/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sgen;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Generator Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.GeneratorConfiguration#getConfigurations <em>Configurations</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorConfiguration()
 * @model
 * @generated
 */
public interface GeneratorConfiguration extends EObject {
	/**
	 * Returns the value of the '<em><b>Configurations</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sgen.FeatureConfiguration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Configurations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Configurations</em>' containment reference list.
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getGeneratorConfiguration_Configurations()
	 * @model containment="true"
	 * @generated
	 */
	EList<FeatureConfiguration> getConfigurations();

} // GeneratorConfiguration
