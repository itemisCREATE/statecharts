/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.SwitchCase;
import org.eclipselabs.mscript.language.ast.SwitchExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.SwitchExpressionImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.SwitchExpressionImpl#getControlExpression <em>Control Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.SwitchExpressionImpl#getCases <em>Cases</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.SwitchExpressionImpl#getDefaultExpression <em>Default Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchExpressionImpl extends ExpressionImpl implements SwitchExpression {
	/**
	 * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected static final boolean STATIC_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isStatic()
	 * @generated
	 * @ordered
	 */
	protected boolean static_ = STATIC_EDEFAULT;

	/**
	 * The cached value of the '{@link #getControlExpression() <em>Control Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getControlExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression controlExpression;

	/**
	 * The cached value of the '{@link #getCases() <em>Cases</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCases()
	 * @generated
	 * @ordered
	 */
	protected EList<SwitchCase> cases;

	/**
	 * The cached value of the '{@link #getDefaultExpression() <em>Default Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDefaultExpression()
	 * @generated
	 * @ordered
	 */
	protected Expression defaultExpression;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SwitchExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.SWITCH_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isStatic() {
		return static_;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setStatic(boolean newStatic) {
		boolean oldStatic = static_;
		static_ = newStatic;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.SWITCH_EXPRESSION__STATIC, oldStatic, static_));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getControlExpression() {
		return controlExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetControlExpression(Expression newControlExpression, NotificationChain msgs) {
		Expression oldControlExpression = controlExpression;
		controlExpression = newControlExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.SWITCH_EXPRESSION__CONTROL_EXPRESSION, oldControlExpression, newControlExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setControlExpression(Expression newControlExpression) {
		if (newControlExpression != controlExpression) {
			NotificationChain msgs = null;
			if (controlExpression != null)
				msgs = ((InternalEObject)controlExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.SWITCH_EXPRESSION__CONTROL_EXPRESSION, null, msgs);
			if (newControlExpression != null)
				msgs = ((InternalEObject)newControlExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.SWITCH_EXPRESSION__CONTROL_EXPRESSION, null, msgs);
			msgs = basicSetControlExpression(newControlExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.SWITCH_EXPRESSION__CONTROL_EXPRESSION, newControlExpression, newControlExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<SwitchCase> getCases() {
		if (cases == null) {
			cases = new EObjectContainmentEList<SwitchCase>(SwitchCase.class, this, AstPackage.SWITCH_EXPRESSION__CASES);
		}
		return cases;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Expression getDefaultExpression() {
		return defaultExpression;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetDefaultExpression(Expression newDefaultExpression, NotificationChain msgs) {
		Expression oldDefaultExpression = defaultExpression;
		defaultExpression = newDefaultExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.SWITCH_EXPRESSION__DEFAULT_EXPRESSION, oldDefaultExpression, newDefaultExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setDefaultExpression(Expression newDefaultExpression) {
		if (newDefaultExpression != defaultExpression) {
			NotificationChain msgs = null;
			if (defaultExpression != null)
				msgs = ((InternalEObject)defaultExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.SWITCH_EXPRESSION__DEFAULT_EXPRESSION, null, msgs);
			if (newDefaultExpression != null)
				msgs = ((InternalEObject)newDefaultExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.SWITCH_EXPRESSION__DEFAULT_EXPRESSION, null, msgs);
			msgs = basicSetDefaultExpression(newDefaultExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.SWITCH_EXPRESSION__DEFAULT_EXPRESSION, newDefaultExpression, newDefaultExpression));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.SWITCH_EXPRESSION__CONTROL_EXPRESSION:
				return basicSetControlExpression(null, msgs);
			case AstPackage.SWITCH_EXPRESSION__CASES:
				return ((InternalEList<?>)getCases()).basicRemove(otherEnd, msgs);
			case AstPackage.SWITCH_EXPRESSION__DEFAULT_EXPRESSION:
				return basicSetDefaultExpression(null, msgs);
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
			case AstPackage.SWITCH_EXPRESSION__STATIC:
				return isStatic();
			case AstPackage.SWITCH_EXPRESSION__CONTROL_EXPRESSION:
				return getControlExpression();
			case AstPackage.SWITCH_EXPRESSION__CASES:
				return getCases();
			case AstPackage.SWITCH_EXPRESSION__DEFAULT_EXPRESSION:
				return getDefaultExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AstPackage.SWITCH_EXPRESSION__STATIC:
				setStatic((Boolean)newValue);
				return;
			case AstPackage.SWITCH_EXPRESSION__CONTROL_EXPRESSION:
				setControlExpression((Expression)newValue);
				return;
			case AstPackage.SWITCH_EXPRESSION__CASES:
				getCases().clear();
				getCases().addAll((Collection<? extends SwitchCase>)newValue);
				return;
			case AstPackage.SWITCH_EXPRESSION__DEFAULT_EXPRESSION:
				setDefaultExpression((Expression)newValue);
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
			case AstPackage.SWITCH_EXPRESSION__STATIC:
				setStatic(STATIC_EDEFAULT);
				return;
			case AstPackage.SWITCH_EXPRESSION__CONTROL_EXPRESSION:
				setControlExpression((Expression)null);
				return;
			case AstPackage.SWITCH_EXPRESSION__CASES:
				getCases().clear();
				return;
			case AstPackage.SWITCH_EXPRESSION__DEFAULT_EXPRESSION:
				setDefaultExpression((Expression)null);
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
			case AstPackage.SWITCH_EXPRESSION__STATIC:
				return static_ != STATIC_EDEFAULT;
			case AstPackage.SWITCH_EXPRESSION__CONTROL_EXPRESSION:
				return controlExpression != null;
			case AstPackage.SWITCH_EXPRESSION__CASES:
				return cases != null && !cases.isEmpty();
			case AstPackage.SWITCH_EXPRESSION__DEFAULT_EXPRESSION:
				return defaultExpression != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (static: ");
		result.append(static_);
		result.append(')');
		return result.toString();
	}

} //SwitchExpressionImpl
