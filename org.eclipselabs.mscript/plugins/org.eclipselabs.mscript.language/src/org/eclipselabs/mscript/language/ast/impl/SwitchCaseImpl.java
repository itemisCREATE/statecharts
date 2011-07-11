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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.SwitchCase;
import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Case</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.SwitchCaseImpl#getCaseExpression <em>Case Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.SwitchCaseImpl#getResultExpression <em>Result Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchCaseImpl extends MinimalEObjectImpl.Container implements SwitchCase {
	/**
	 * The cached value of the '{@link #getCaseExpression() <em>Case Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCaseExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression caseExpression;

	/**
	 * The cached value of the '{@link #getResultExpression() <em>Result Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression resultExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchCaseImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.SWITCH_CASE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getCaseExpression() {
		return caseExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCaseExpression(Expression newCaseExpression, NotificationChain msgs) {
		Expression oldCaseExpression = caseExpression;
		caseExpression = newCaseExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.SWITCH_CASE__CASE_EXPRESSION, oldCaseExpression, newCaseExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setCaseExpression(Expression newCaseExpression) {
		if (newCaseExpression != caseExpression) {
			NotificationChain msgs = null;
			if (caseExpression != null)
				msgs = ((InternalEObject)caseExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.SWITCH_CASE__CASE_EXPRESSION, null, msgs);
			if (newCaseExpression != null)
				msgs = ((InternalEObject)newCaseExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.SWITCH_CASE__CASE_EXPRESSION, null, msgs);
			msgs = basicSetCaseExpression(newCaseExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.SWITCH_CASE__CASE_EXPRESSION, newCaseExpression, newCaseExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getResultExpression() {
		return resultExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetResultExpression(Expression newResultExpression, NotificationChain msgs) {
		Expression oldResultExpression = resultExpression;
		resultExpression = newResultExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.SWITCH_CASE__RESULT_EXPRESSION, oldResultExpression, newResultExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setResultExpression(Expression newResultExpression) {
		if (newResultExpression != resultExpression) {
			NotificationChain msgs = null;
			if (resultExpression != null)
				msgs = ((InternalEObject)resultExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.SWITCH_CASE__RESULT_EXPRESSION, null, msgs);
			if (newResultExpression != null)
				msgs = ((InternalEObject)newResultExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.SWITCH_CASE__RESULT_EXPRESSION, null, msgs);
			msgs = basicSetResultExpression(newResultExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.SWITCH_CASE__RESULT_EXPRESSION, newResultExpression, newResultExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.SWITCH_CASE__CASE_EXPRESSION:
				return basicSetCaseExpression(null, msgs);
			case AstPackage.SWITCH_CASE__RESULT_EXPRESSION:
				return basicSetResultExpression(null, msgs);
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
			case AstPackage.SWITCH_CASE__CASE_EXPRESSION:
				return getCaseExpression();
			case AstPackage.SWITCH_CASE__RESULT_EXPRESSION:
				return getResultExpression();
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
			case AstPackage.SWITCH_CASE__CASE_EXPRESSION:
				setCaseExpression((Expression)newValue);
				return;
			case AstPackage.SWITCH_CASE__RESULT_EXPRESSION:
				setResultExpression((Expression)newValue);
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
			case AstPackage.SWITCH_CASE__CASE_EXPRESSION:
				setCaseExpression((Expression)null);
				return;
			case AstPackage.SWITCH_CASE__RESULT_EXPRESSION:
				setResultExpression((Expression)null);
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
			case AstPackage.SWITCH_CASE__CASE_EXPRESSION:
				return caseExpression != null;
			case AstPackage.SWITCH_CASE__RESULT_EXPRESSION:
				return resultExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //SwitchCaseImpl
