/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.CallableElement;
import org.eclipselabs.mscript.language.ast.MemberVariableAccess;
import org.eclipselabs.mscript.typesystem.Expression;
import org.eclipselabs.mscript.typesystem.impl.ExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Member Variable Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.MemberVariableAccessImpl#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.MemberVariableAccessImpl#getMemberVariable <em>Member Variable</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class MemberVariableAccessImpl extends ExpressionImpl implements MemberVariableAccess {
	/**
	 * The cached value of the '{@link #getTarget() <em>Target</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTarget()
	 * @generated
	 * @ordered
	 */
	protected Expression target;

	/**
	 * The cached value of the '{@link #getMemberVariable() <em>Member Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getMemberVariable()
	 * @generated
	 * @ordered
	 */
	protected CallableElement memberVariable;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MemberVariableAccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.MEMBER_VARIABLE_ACCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getTarget() {
		return target;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetTarget(Expression newTarget, NotificationChain msgs) {
		Expression oldTarget = target;
		target = newTarget;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.MEMBER_VARIABLE_ACCESS__TARGET, oldTarget, newTarget);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTarget(Expression newTarget) {
		if (newTarget != target) {
			NotificationChain msgs = null;
			if (target != null)
				msgs = ((InternalEObject)target).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.MEMBER_VARIABLE_ACCESS__TARGET, null, msgs);
			if (newTarget != null)
				msgs = ((InternalEObject)newTarget).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.MEMBER_VARIABLE_ACCESS__TARGET, null, msgs);
			msgs = basicSetTarget(newTarget, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.MEMBER_VARIABLE_ACCESS__TARGET, newTarget, newTarget));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallableElement getMemberVariable() {
		if (memberVariable != null && memberVariable.eIsProxy()) {
			InternalEObject oldMemberVariable = (InternalEObject)memberVariable;
			memberVariable = (CallableElement)eResolveProxy(oldMemberVariable);
			if (memberVariable != oldMemberVariable) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AstPackage.MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE, oldMemberVariable, memberVariable));
			}
		}
		return memberVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CallableElement basicGetMemberVariable() {
		return memberVariable;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setMemberVariable(CallableElement newMemberVariable) {
		CallableElement oldMemberVariable = memberVariable;
		memberVariable = newMemberVariable;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE, oldMemberVariable, memberVariable));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.MEMBER_VARIABLE_ACCESS__TARGET:
				return basicSetTarget(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AstPackage.MEMBER_VARIABLE_ACCESS__TARGET:
				return getTarget();
			case AstPackage.MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE:
				if (resolve) return getMemberVariable();
				return basicGetMemberVariable();
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
			case AstPackage.MEMBER_VARIABLE_ACCESS__TARGET:
				setTarget((Expression)newValue);
				return;
			case AstPackage.MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE:
				setMemberVariable((CallableElement)newValue);
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
			case AstPackage.MEMBER_VARIABLE_ACCESS__TARGET:
				setTarget((Expression)null);
				return;
			case AstPackage.MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE:
				setMemberVariable((CallableElement)null);
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
			case AstPackage.MEMBER_VARIABLE_ACCESS__TARGET:
				return target != null;
			case AstPackage.MEMBER_VARIABLE_ACCESS__MEMBER_VARIABLE:
				return memberVariable != null;
		}
		return super.eIsSet(featureID);
	}

} //MemberVariableAccessImpl
