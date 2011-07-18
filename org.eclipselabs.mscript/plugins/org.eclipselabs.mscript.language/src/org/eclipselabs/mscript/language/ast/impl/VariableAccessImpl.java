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
import org.eclipselabs.mscript.language.ast.VariableAccess;
import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Variable Access</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.VariableAccessImpl#getStepExpression <em>Step Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class VariableAccessImpl extends FeatureCallImpl implements VariableAccess {
	/**
	 * The cached value of the '{@link #getStepExpression() <em>Step Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getStepExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression stepExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected VariableAccessImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.VARIABLE_ACCESS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getStepExpression() {
		return stepExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetStepExpression(Expression newStepExpression, NotificationChain msgs) {
		Expression oldStepExpression = stepExpression;
		stepExpression = newStepExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.VARIABLE_ACCESS__STEP_EXPRESSION, oldStepExpression, newStepExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStepExpression(Expression newStepExpression) {
		if (newStepExpression != stepExpression) {
			NotificationChain msgs = null;
			if (stepExpression != null)
				msgs = ((InternalEObject)stepExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.VARIABLE_ACCESS__STEP_EXPRESSION, null, msgs);
			if (newStepExpression != null)
				msgs = ((InternalEObject)newStepExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.VARIABLE_ACCESS__STEP_EXPRESSION, null, msgs);
			msgs = basicSetStepExpression(newStepExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.VARIABLE_ACCESS__STEP_EXPRESSION, newStepExpression, newStepExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.VARIABLE_ACCESS__STEP_EXPRESSION:
				return basicSetStepExpression(null, msgs);
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
			case AstPackage.VARIABLE_ACCESS__STEP_EXPRESSION:
				return getStepExpression();
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
			case AstPackage.VARIABLE_ACCESS__STEP_EXPRESSION:
				setStepExpression((Expression)newValue);
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
			case AstPackage.VARIABLE_ACCESS__STEP_EXPRESSION:
				setStepExpression((Expression)null);
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
			case AstPackage.VARIABLE_ACCESS__STEP_EXPRESSION:
				return stepExpression != null;
		}
		return super.eIsSet(featureID);
	}

} //VariableAccessImpl
