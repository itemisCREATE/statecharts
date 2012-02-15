/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;

import org.yakindu.base.base.NamedElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.Reaction#getCheck <em>Check</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.Reaction#getEffect <em>Effect</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.Reaction#isTransition <em>Transition</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getReaction()
 * @model
 * @generated
 */
public interface Reaction extends MappedElement, NamedElement {
	/**
	 * Returns the value of the '<em><b>Check</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Check</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Check</em>' containment reference.
	 * @see #setCheck(Check)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getReaction_Check()
	 * @model containment="true"
	 * @generated
	 */
	Check getCheck();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.Reaction#getCheck <em>Check</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Check</em>' containment reference.
	 * @see #getCheck()
	 * @generated
	 */
	void setCheck(Check value);

	/**
	 * Returns the value of the '<em><b>Effect</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Effect</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Effect</em>' containment reference.
	 * @see #setEffect(Step)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getReaction_Effect()
	 * @model containment="true"
	 * @generated
	 */
	Step getEffect();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.Reaction#getEffect <em>Effect</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Effect</em>' containment reference.
	 * @see #getEffect()
	 * @generated
	 */
	void setEffect(Step value);

	/**
	 * Returns the value of the '<em><b>Transition</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transition</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Transition</em>' attribute.
	 * @see #setTransition(boolean)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getReaction_Transition()
	 * @model
	 * @generated
	 */
	boolean isTransition();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.Reaction#isTransition <em>Transition</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transition</em>' attribute.
	 * @see #isTransition()
	 * @generated
	 */
	void setTransition(boolean value);

} // Reaction
