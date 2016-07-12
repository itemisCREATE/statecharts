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
package org.yakindu.sct.model.sexec;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reaction Fired</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.ReactionFired#getReaction <em>Reaction</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getReactionFired()
 * @model
 * @generated
 */
public interface ReactionFired extends Trace {
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
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getReactionFired_Reaction()
	 * @model
	 * @generated
	 */
	Reaction getReaction();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.ReactionFired#getReaction <em>Reaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Reaction</em>' reference.
	 * @see #getReaction()
	 * @generated
	 */
	void setReaction(Reaction value);

} // ReactionFired
