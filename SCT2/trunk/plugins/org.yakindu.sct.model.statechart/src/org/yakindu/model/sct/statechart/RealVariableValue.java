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
package org.yakindu.model.sct.statechart;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real Variable Value</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.model.sct.statechart.RealVariableValue#get_ <em></em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.model.sct.statechart.StatechartPackage#getRealVariableValue()
 * @model
 * @generated
 */
public interface RealVariableValue extends EObject {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String copyright = "Copyright (c) 2011 committers of YAKINDU and others.\r\nAll rights reserved. This program and the accompanying materials\r\nare made available under the terms of the Eclipse Public License v1.0\r\nwhich accompanies this distribution, and is available at\r\nhttp://www.eclipse.org/legal/epl-v10.html\r\nContributors:\r\ncommitters of YAKINDU - initial API and implementation\r\n";

	/**
	 * Returns the value of the '<em><b></b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.model.sct.statechart.RealVariable#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em></em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em></em>' container reference.
	 * @see #set_(RealVariable)
	 * @see org.yakindu.model.sct.statechart.StatechartPackage#getRealVariableValue__()
	 * @see org.yakindu.model.sct.statechart.RealVariable#getValue
	 * @model opposite="value" required="true" transient="false" ordered="false"
	 * @generated
	 */
	RealVariable get_();

	/**
	 * Sets the value of the '{@link org.yakindu.model.sct.statechart.RealVariableValue#get_ <em></em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em></em>' container reference.
	 * @see #get_()
	 * @generated
	 */
	void set_(RealVariable value);

} // RealVariableValue
