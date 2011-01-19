/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.model.sct.statechart;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Real Variable</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.model.sct.statechart.RealVariable#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.model.sct.statechart.StatechartPackage#getRealVariable()
 * @model
 * @generated
 */
public interface RealVariable extends Variable {
	/**
	 * Returns the value of the '<em><b>Value</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.model.sct.statechart.RealVariableValue#get_ <em></em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' containment reference.
	 * @see #setValue(RealVariableValue)
	 * @see org.yakindu.model.sct.statechart.StatechartPackage#getRealVariable_Value()
	 * @see org.yakindu.model.sct.statechart.RealVariableValue#get_
	 * @model opposite="_" containment="true" required="true" ordered="false"
	 * @generated
	 */
	RealVariableValue getValue();

	/**
	 * Sets the value of the '{@link org.yakindu.model.sct.statechart.RealVariable#getValue <em>Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' containment reference.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(RealVariableValue value);

} // RealVariable
