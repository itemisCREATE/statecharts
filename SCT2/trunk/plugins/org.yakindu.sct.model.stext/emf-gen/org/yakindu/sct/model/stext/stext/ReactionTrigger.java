/**
 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.common.util.EList;
import org.yakindu.sct.model.sgraph.Trigger;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reaction Trigger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ReactionTrigger#getTriggers <em>Triggers</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ReactionTrigger#getGuard <em>Guard</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getReactionTrigger()
 * @model
 * @generated
 */
public interface ReactionTrigger extends Trigger {
	/**
	 * Returns the value of the '<em><b>Triggers</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.stext.stext.EventSpec}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Triggers</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Triggers</em>' containment reference list.
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getReactionTrigger_Triggers()
	 * @model containment="true"
	 * @generated
	 */
	EList<EventSpec> getTriggers();

	/**
	 * Returns the value of the '<em><b>Guard</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Guard</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Guard</em>' containment reference.
	 * @see #setGuard(Guard)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getReactionTrigger_Guard()
	 * @model containment="true"
	 * @generated
	 */
	Guard getGuard();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.ReactionTrigger#getGuard <em>Guard</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Guard</em>' containment reference.
	 * @see #getGuard()
	 * @generated
	 */
	void setGuard(Guard value);

} // ReactionTrigger
