/**
 */
package org.yakindu.sct.model.sexec;

import org.yakindu.base.types.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Local Variable Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.LocalVariableDefinition#getVariable <em>Variable</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.LocalVariableDefinition#getInitialValue <em>Initial Value</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getLocalVariableDefinition()
 * @model
 * @generated
 */
public interface LocalVariableDefinition extends Step {
	/**
	 * Returns the value of the '<em><b>Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable</em>' containment reference.
	 * @see #setVariable(Property)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getLocalVariableDefinition_Variable()
	 * @model containment="true"
	 * @generated
	 */
	Property getVariable();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.LocalVariableDefinition#getVariable <em>Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable</em>' containment reference.
	 * @see #getVariable()
	 * @generated
	 */
	void setVariable(Property value);

	/**
	 * Returns the value of the '<em><b>Initial Value</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Value</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Value</em>' containment reference.
	 * @see #setInitialValue(org.yakindu.base.types.Expression)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getLocalVariableDefinition_InitialValue()
	 * @model containment="true"
	 * @generated
	 */
	org.yakindu.base.types.Expression getInitialValue();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.LocalVariableDefinition#getInitialValue <em>Initial Value</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Value</em>' containment reference.
	 * @see #getInitialValue()
	 * @generated
	 */
	void setInitialValue(org.yakindu.base.types.Expression value);

} // LocalVariableDefinition
