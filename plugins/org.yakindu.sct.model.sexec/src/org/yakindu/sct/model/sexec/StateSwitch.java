/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>State Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.StateSwitch#getCases <em>Cases</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.StateSwitch#getStateConfigurationIdx <em>State Configuration Idx</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getStateSwitch()
 * @model
 * @generated
 */
public interface StateSwitch extends Step {
	/**
	 * Returns the value of the '<em><b>Cases</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sexec.StateCase}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Cases</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Cases</em>' containment reference list.
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getStateSwitch_Cases()
	 * @model containment="true"
	 * @generated
	 */
	EList<StateCase> getCases();

	/**
	 * Returns the value of the '<em><b>State Configuration Idx</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Configuration Idx</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Configuration Idx</em>' attribute.
	 * @see #setStateConfigurationIdx(int)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getStateSwitch_StateConfigurationIdx()
	 * @model default="0"
	 * @generated
	 */
	int getStateConfigurationIdx();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.StateSwitch#getStateConfigurationIdx <em>State Configuration Idx</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Configuration Idx</em>' attribute.
	 * @see #getStateConfigurationIdx()
	 * @generated
	 */
	void setStateConfigurationIdx(int value);

} // StateSwitch
