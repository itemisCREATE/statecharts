/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>History Entry</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.HistoryEntry#getInitialStep <em>Initial Step</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.HistoryEntry#isDeep <em>Deep</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.HistoryEntry#getRegion <em>Region</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.HistoryEntry#getHistoryStep <em>History Step</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getHistoryEntry()
 * @model
 * @generated
 */
public interface HistoryEntry extends Step {
	/**
	 * Returns the value of the '<em><b>Initial Step</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial Step</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial Step</em>' containment reference.
	 * @see #setInitialStep(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getHistoryEntry_InitialStep()
	 * @model containment="true"
	 * @generated
	 */
	Step getInitialStep();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.HistoryEntry#getInitialStep <em>Initial Step</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial Step</em>' containment reference.
	 * @see #getInitialStep()
	 * @generated
	 */
	void setInitialStep(Step value);

	/**
	 * Returns the value of the '<em><b>Deep</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Deep</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Deep</em>' attribute.
	 * @see #setDeep(boolean)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getHistoryEntry_Deep()
	 * @model
	 * @generated
	 */
	boolean isDeep();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.HistoryEntry#isDeep <em>Deep</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Deep</em>' attribute.
	 * @see #isDeep()
	 * @generated
	 */
	void setDeep(boolean value);

	/**
	 * Returns the value of the '<em><b>Region</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Region</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Region</em>' reference.
	 * @see #setRegion(ExecutionRegion)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getHistoryEntry_Region()
	 * @model
	 * @generated
	 */
	ExecutionRegion getRegion();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.HistoryEntry#getRegion <em>Region</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Region</em>' reference.
	 * @see #getRegion()
	 * @generated
	 */
	void setRegion(ExecutionRegion value);

	/**
	 * Returns the value of the '<em><b>History Step</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>History Step</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>History Step</em>' containment reference.
	 * @see #setHistoryStep(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getHistoryEntry_HistoryStep()
	 * @model containment="true"
	 * @generated
	 */
	Step getHistoryStep();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.HistoryEntry#getHistoryStep <em>History Step</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>History Step</em>' containment reference.
	 * @see #getHistoryStep()
	 * @generated
	 */
	void setHistoryStep(Step value);

} // HistoryEntry
