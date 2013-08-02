/**
 */
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trace Reaction Will Fire</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.TraceReactionWillFire#getReaction <em>Reaction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getTraceReactionWillFire()
 * @model
 * @generated
 */
public interface TraceReactionWillFire extends Trace {
	/**
	 * Returns the value of the '<em><b>Reaction</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reaction</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reaction</em>' reference.
	 * @see #setReaction(Reaction)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getTraceReactionWillFire_Reaction()
	 * @model
	 * @generated
	 */
	Reaction getReaction();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.TraceReactionWillFire#getReaction <em>Reaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reaction</em>' reference.
	 * @see #getReaction()
	 * @generated
	 */
	void setReaction(Reaction value);

} // TraceReactionWillFire
