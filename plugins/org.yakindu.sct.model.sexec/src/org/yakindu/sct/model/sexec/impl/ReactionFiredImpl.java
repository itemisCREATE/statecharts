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
package org.yakindu.sct.model.sexec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.ReactionFired;
import org.yakindu.sct.model.sexec.SexecPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Reaction Fired</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.ReactionFiredImpl#getReaction <em>Reaction</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ReactionFiredImpl extends TraceImpl implements ReactionFired {
	/**
	 * The cached value of the '{@link #getReaction() <em>Reaction</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReaction()
	 * @generated
	 * @ordered
	 */
	protected Reaction reaction;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReactionFiredImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.REACTION_FIRED;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Reaction getReaction() {
		if (reaction != null && reaction.eIsProxy()) {
			InternalEObject oldReaction = (InternalEObject)reaction;
			reaction = (Reaction)eResolveProxy(oldReaction);
			if (reaction != oldReaction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.REACTION_FIRED__REACTION, oldReaction, reaction));
			}
		}
		return reaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reaction basicGetReaction() {
		return reaction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setReaction(Reaction newReaction) {
		Reaction oldReaction = reaction;
		reaction = newReaction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.REACTION_FIRED__REACTION, oldReaction, reaction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SexecPackage.REACTION_FIRED__REACTION:
				if (resolve) return getReaction();
				return basicGetReaction();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case SexecPackage.REACTION_FIRED__REACTION:
				setReaction((Reaction)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case SexecPackage.REACTION_FIRED__REACTION:
				setReaction((Reaction)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case SexecPackage.REACTION_FIRED__REACTION:
				return reaction != null;
		}
		return super.eIsSet(featureID);
	}

} //ReactionFiredImpl
