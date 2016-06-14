/**
 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.TransitionSpecification#getReaction <em>Reaction</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getTransitionSpecification()
 * @model
 * @generated
 */
public interface TransitionSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Reaction</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Reaction</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Reaction</em>' containment reference.
	 * @see #setReaction(TransitionReaction)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getTransitionSpecification_Reaction()
	 * @model containment="true"
	 * @generated
	 */
	TransitionReaction getReaction();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.TransitionSpecification#getReaction <em>Reaction</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reaction</em>' containment reference.
	 * @see #getReaction()
	 * @generated
	 */
	void setReaction(TransitionReaction value);

} // TransitionSpecification
