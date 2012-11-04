/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;

import org.eclipse.emf.common.util.EList;
import org.yakindu.base.base.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Scope</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionScope#getStateVector <em>State Vector</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionScope#getSubScopes <em>Sub Scopes</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionScope#getSuperScope <em>Super Scope</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionScope#getEnterSequence <em>Enter Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionScope#getExitSequence <em>Exit Sequence</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.ExecutionScope#getInitSequence <em>Init Sequence</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionScope()
 * @model
 * @generated
 */
public interface ExecutionScope extends MappedElement, NamedElement {
	/**
	 * Returns the value of the '<em><b>State Vector</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Vector</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Vector</em>' containment reference.
	 * @see #setStateVector(StateVector)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionScope_StateVector()
	 * @model containment="true"
	 * @generated
	 */
	StateVector getStateVector();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionScope#getStateVector <em>State Vector</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>State Vector</em>' containment reference.
	 * @see #getStateVector()
	 * @generated
	 */
	void setStateVector(StateVector value);

	/**
	 * Returns the value of the '<em><b>Sub Scopes</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sexec.ExecutionScope}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.sexec.ExecutionScope#getSuperScope <em>Super Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sub Scopes</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sub Scopes</em>' reference list.
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionScope_SubScopes()
	 * @see org.yakindu.sct.model.sexec.ExecutionScope#getSuperScope
	 * @model opposite="superScope"
	 * @generated
	 */
	EList<ExecutionScope> getSubScopes();

	/**
	 * Returns the value of the '<em><b>Super Scope</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.sexec.ExecutionScope#getSubScopes <em>Sub Scopes</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Super Scope</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Super Scope</em>' reference.
	 * @see #setSuperScope(ExecutionScope)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionScope_SuperScope()
	 * @see org.yakindu.sct.model.sexec.ExecutionScope#getSubScopes
	 * @model opposite="subScopes"
	 * @generated
	 */
	ExecutionScope getSuperScope();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionScope#getSuperScope <em>Super Scope</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Super Scope</em>' reference.
	 * @see #getSuperScope()
	 * @generated
	 */
	void setSuperScope(ExecutionScope value);

	/**
	 * Returns the value of the '<em><b>Enter Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Enter Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Enter Sequence</em>' containment reference.
	 * @see #setEnterSequence(Sequence)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionScope_EnterSequence()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getEnterSequence();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionScope#getEnterSequence <em>Enter Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Enter Sequence</em>' containment reference.
	 * @see #getEnterSequence()
	 * @generated
	 */
	void setEnterSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>Exit Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Exit Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exit Sequence</em>' containment reference.
	 * @see #setExitSequence(Sequence)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionScope_ExitSequence()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getExitSequence();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionScope#getExitSequence <em>Exit Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exit Sequence</em>' containment reference.
	 * @see #getExitSequence()
	 * @generated
	 */
	void setExitSequence(Sequence value);

	/**
	 * Returns the value of the '<em><b>Init Sequence</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Init Sequence</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Init Sequence</em>' containment reference.
	 * @see #setInitSequence(Sequence)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getExecutionScope_InitSequence()
	 * @model containment="true"
	 * @generated
	 */
	Sequence getInitSequence();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ExecutionScope#getInitSequence <em>Init Sequence</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Init Sequence</em>' containment reference.
	 * @see #getInitSequence()
	 * @generated
	 */
	void setInitSequence(Sequence value);

} // ExecutionScope
