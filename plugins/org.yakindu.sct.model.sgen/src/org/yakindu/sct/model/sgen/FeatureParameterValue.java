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

import org.eclipse.emf.ecore.EObject;
import org.yakindu.base.types.Expression;

/**
 * <!-- begin-user-doc --> A representation of the model object '
 * <em><b>Feature Parameter Value</b></em>'. <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sgen.FeatureParameterValue#getParameter <em>Parameter</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.FeatureParameterValue#getFeatureConfiguration <em>Feature Configuration</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sgen.FeatureParameterValue#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureParameterValue()
 * @model
 * @generated
 */
public interface FeatureParameterValue extends EObject {
	/**
	 * Returns the value of the '<em><b>Parameter</b></em>' reference. <!--
	 * begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parameter</em>' reference isn't clear, there
	 * really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * 
	 * @return the value of the '<em>Parameter</em>' reference.
	 * @see #setParameter(FeatureParameter)
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureParameterValue_Parameter()
	 * @model
	 * @generated
	 */
	FeatureParameter getParameter();

	/**
	 * Sets the value of the '
	 * {@link org.yakindu.sct.model.sgen.FeatureParameterValue#getParameter
	 * <em>Parameter</em>}' reference. <!-- begin-user-doc --> <!-- end-user-doc
	 * -->
	 * 
	 * @param value
	 *            the new value of the '<em>Parameter</em>' reference.
	 * @see #getParameter()
	 * @generated
	 */
	void setParameter(FeatureParameter value);

	/**
	 * Returns the value of the '<em><b>Feature Configuration</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.sgen.FeatureConfiguration#getParameterValues <em>Parameter Values</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Configuration</em>' container
	 * reference isn't clear, there really should be more of a description
	 * here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Configuration</em>' container reference.
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureParameterValue_FeatureConfiguration()
	 * @see org.yakindu.sct.model.sgen.FeatureConfiguration#getParameterValues
	 * @model opposite="parameterValues" transient="false" changeable="false"
	 * @generated
	 */
	FeatureConfiguration getFeatureConfiguration();

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't
	 * clear, there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(Expression)
	 * @see org.yakindu.sct.model.sgen.SGenPackage#getFeatureParameterValue_Expression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sgen.FeatureParameterValue#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setValue(String string);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setValue(boolean boolean_);

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	String getStringValue();

	/**
	 * <!-- begin-user-doc --> <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean getBooleanValue();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
	void setValue(int value);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	int getIntegerValue();
	

} // FeatureParameterValue
