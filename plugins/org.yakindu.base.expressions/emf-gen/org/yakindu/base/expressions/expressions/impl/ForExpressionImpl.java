/**
 */
package org.yakindu.base.expressions.expressions.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.yakindu.base.expressions.expressions.ExpressionsPackage;
import org.yakindu.base.expressions.expressions.ForExpression;
import org.yakindu.base.types.Expression;
import org.yakindu.base.types.impl.ExpressionImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.ForExpressionImpl#getBody <em>Body</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.ForExpressionImpl#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.ForExpressionImpl#getVarInits <em>Var Inits</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.impl.ForExpressionImpl#getVarUpdates <em>Var Updates</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ForExpressionImpl extends ExpressionImpl implements ForExpression {
	/**
	 * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getBody()
	 * @generated
	 * @ordered
	 */
	protected Expression body;

	/**
	 * The cached value of the '{@link #getCondition() <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCondition()
	 * @generated
	 * @ordered
	 */
	protected Expression condition;

	/**
	 * The cached value of the '{@link #getVarInits() <em>Var Inits</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarInits()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> varInits;

	/**
	 * The cached value of the '{@link #getVarUpdates() <em>Var Updates</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVarUpdates()
	 * @generated
	 * @ordered
	 */
	protected EList<Expression> varUpdates;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ForExpressionImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ExpressionsPackage.Literals.FOR_EXPRESSION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getBody() {
		return body;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetBody(Expression newBody, NotificationChain msgs) {
		Expression oldBody = body;
		body = newBody;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.FOR_EXPRESSION__BODY, oldBody, newBody);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setBody(Expression newBody) {
		if (newBody != body) {
			NotificationChain msgs = null;
			if (body != null)
				msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.FOR_EXPRESSION__BODY, null, msgs);
			if (newBody != null)
				msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.FOR_EXPRESSION__BODY, null, msgs);
			msgs = basicSetBody(newBody, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.FOR_EXPRESSION__BODY, newBody, newBody));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Expression getCondition() {
		return condition;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetCondition(Expression newCondition, NotificationChain msgs) {
		Expression oldCondition = condition;
		condition = newCondition;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, ExpressionsPackage.FOR_EXPRESSION__CONDITION, oldCondition, newCondition);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void setCondition(Expression newCondition) {
		if (newCondition != condition) {
			NotificationChain msgs = null;
			if (condition != null)
				msgs = ((InternalEObject)condition).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.FOR_EXPRESSION__CONDITION, null, msgs);
			if (newCondition != null)
				msgs = ((InternalEObject)newCondition).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - ExpressionsPackage.FOR_EXPRESSION__CONDITION, null, msgs);
			msgs = basicSetCondition(newCondition, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.FOR_EXPRESSION__CONDITION, newCondition, newCondition));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Expression> getVarInits() {
		if (varInits == null) {
			varInits = new EObjectContainmentEList<Expression>(Expression.class, this, ExpressionsPackage.FOR_EXPRESSION__VAR_INITS);
		}
		return varInits;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EList<Expression> getVarUpdates() {
		if (varUpdates == null) {
			varUpdates = new EObjectContainmentEList<Expression>(Expression.class, this, ExpressionsPackage.FOR_EXPRESSION__VAR_UPDATES);
		}
		return varUpdates;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ExpressionsPackage.FOR_EXPRESSION__BODY:
				return basicSetBody(null, msgs);
			case ExpressionsPackage.FOR_EXPRESSION__CONDITION:
				return basicSetCondition(null, msgs);
			case ExpressionsPackage.FOR_EXPRESSION__VAR_INITS:
				return ((InternalEList<?>)getVarInits()).basicRemove(otherEnd, msgs);
			case ExpressionsPackage.FOR_EXPRESSION__VAR_UPDATES:
				return ((InternalEList<?>)getVarUpdates()).basicRemove(otherEnd, msgs);
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
			case ExpressionsPackage.FOR_EXPRESSION__BODY:
				return getBody();
			case ExpressionsPackage.FOR_EXPRESSION__CONDITION:
				return getCondition();
			case ExpressionsPackage.FOR_EXPRESSION__VAR_INITS:
				return getVarInits();
			case ExpressionsPackage.FOR_EXPRESSION__VAR_UPDATES:
				return getVarUpdates();
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
			case ExpressionsPackage.FOR_EXPRESSION__BODY:
				setBody((Expression)newValue);
				return;
			case ExpressionsPackage.FOR_EXPRESSION__CONDITION:
				setCondition((Expression)newValue);
				return;
			case ExpressionsPackage.FOR_EXPRESSION__VAR_INITS:
				getVarInits().clear();
				getVarInits().addAll((Collection<? extends Expression>)newValue);
				return;
			case ExpressionsPackage.FOR_EXPRESSION__VAR_UPDATES:
				getVarUpdates().clear();
				getVarUpdates().addAll((Collection<? extends Expression>)newValue);
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
			case ExpressionsPackage.FOR_EXPRESSION__BODY:
				setBody((Expression)null);
				return;
			case ExpressionsPackage.FOR_EXPRESSION__CONDITION:
				setCondition((Expression)null);
				return;
			case ExpressionsPackage.FOR_EXPRESSION__VAR_INITS:
				getVarInits().clear();
				return;
			case ExpressionsPackage.FOR_EXPRESSION__VAR_UPDATES:
				getVarUpdates().clear();
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
			case ExpressionsPackage.FOR_EXPRESSION__BODY:
				return body != null;
			case ExpressionsPackage.FOR_EXPRESSION__CONDITION:
				return condition != null;
			case ExpressionsPackage.FOR_EXPRESSION__VAR_INITS:
				return varInits != null && !varInits.isEmpty();
			case ExpressionsPackage.FOR_EXPRESSION__VAR_UPDATES:
				return varUpdates != null && !varUpdates.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ForExpressionImpl
