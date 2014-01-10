/**
 */
package org.yakindu.sct.model.sexec.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.sct.model.sexec.Reaction;
import org.yakindu.sct.model.sexec.SexecPackage;
import org.yakindu.sct.model.sexec.TraceReactionWillFire;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trace Reaction Will Fire</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.impl.TraceReactionWillFireImpl#getReaction <em>Reaction</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TraceReactionWillFireImpl extends TraceImpl implements TraceReactionWillFire {
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
	protected TraceReactionWillFireImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return SexecPackage.Literals.TRACE_REACTION_WILL_FIRE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Reaction getReaction() {
		if (reaction != null && reaction.eIsProxy()) {
			InternalEObject oldReaction = (InternalEObject)reaction;
			reaction = (Reaction)eResolveProxy(oldReaction);
			if (reaction != oldReaction) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, SexecPackage.TRACE_REACTION_WILL_FIRE__REACTION, oldReaction, reaction));
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
	public void setReaction(Reaction newReaction) {
		Reaction oldReaction = reaction;
		reaction = newReaction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, SexecPackage.TRACE_REACTION_WILL_FIRE__REACTION, oldReaction, reaction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case SexecPackage.TRACE_REACTION_WILL_FIRE__REACTION:
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
			case SexecPackage.TRACE_REACTION_WILL_FIRE__REACTION:
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
			case SexecPackage.TRACE_REACTION_WILL_FIRE__REACTION:
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
			case SexecPackage.TRACE_REACTION_WILL_FIRE__REACTION:
				return reaction != null;
		}
		return super.eIsSet(featureID);
	}

} //TraceReactionWillFireImpl
