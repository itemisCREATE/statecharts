/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.sct.model.stext.stext.AssignmentExpression;
import org.yakindu.sct.model.stext.stext.AssignmentOperator;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assignment Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.AssignmentExpressionImpl#getVarRef <em>Var Ref</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.AssignmentExpressionImpl#getOperator <em>Operator</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.AssignmentExpressionImpl#getExpression <em>Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssignmentExpressionImpl extends ExpressionImpl implements AssignmentExpression
{
  /**
	 * The cached value of the '{@link #getVarRef() <em>Var Ref</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVarRef()
	 * @generated
	 * @ordered
	 */
  protected Expression varRef;

  /**
	 * The default value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
  protected static final AssignmentOperator OPERATOR_EDEFAULT = AssignmentOperator.ASSIGN;

  /**
	 * The cached value of the '{@link #getOperator() <em>Operator</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getOperator()
	 * @generated
	 * @ordered
	 */
  protected AssignmentOperator operator = OPERATOR_EDEFAULT;

  /**
	 * The cached value of the '{@link #getExpression() <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getExpression()
	 * @generated
	 * @ordered
	 */
  protected Expression expression;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected AssignmentExpressionImpl()
  {
		super();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  protected EClass eStaticClass()
  {
		return StextPackage.Literals.ASSIGNMENT_EXPRESSION;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Expression getVarRef()
  {
		return varRef;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetVarRef(Expression newVarRef, NotificationChain msgs)
  {
		Expression oldVarRef = varRef;
		varRef = newVarRef;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StextPackage.ASSIGNMENT_EXPRESSION__VAR_REF, oldVarRef, newVarRef);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setVarRef(Expression newVarRef)
  {
		if (newVarRef != varRef) {
			NotificationChain msgs = null;
			if (varRef != null)
				msgs = ((InternalEObject)varRef).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.ASSIGNMENT_EXPRESSION__VAR_REF, null, msgs);
			if (newVarRef != null)
				msgs = ((InternalEObject)newVarRef).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.ASSIGNMENT_EXPRESSION__VAR_REF, null, msgs);
			msgs = basicSetVarRef(newVarRef, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.ASSIGNMENT_EXPRESSION__VAR_REF, newVarRef, newVarRef));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AssignmentOperator getOperator()
  {
		return operator;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setOperator(AssignmentOperator newOperator)
  {
		AssignmentOperator oldOperator = operator;
		operator = newOperator == null ? OPERATOR_EDEFAULT : newOperator;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.ASSIGNMENT_EXPRESSION__OPERATOR, oldOperator, operator));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Expression getExpression()
  {
		return expression;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public NotificationChain basicSetExpression(Expression newExpression, NotificationChain msgs)
  {
		Expression oldExpression = expression;
		expression = newExpression;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, StextPackage.ASSIGNMENT_EXPRESSION__EXPRESSION, oldExpression, newExpression);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setExpression(Expression newExpression)
  {
		if (newExpression != expression) {
			NotificationChain msgs = null;
			if (expression != null)
				msgs = ((InternalEObject)expression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - StextPackage.ASSIGNMENT_EXPRESSION__EXPRESSION, null, msgs);
			if (newExpression != null)
				msgs = ((InternalEObject)newExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - StextPackage.ASSIGNMENT_EXPRESSION__EXPRESSION, null, msgs);
			msgs = basicSetExpression(newExpression, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.ASSIGNMENT_EXPRESSION__EXPRESSION, newExpression, newExpression));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
		switch (featureID) {
			case StextPackage.ASSIGNMENT_EXPRESSION__VAR_REF:
				return basicSetVarRef(null, msgs);
			case StextPackage.ASSIGNMENT_EXPRESSION__EXPRESSION:
				return basicSetExpression(null, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
		switch (featureID) {
			case StextPackage.ASSIGNMENT_EXPRESSION__VAR_REF:
				return getVarRef();
			case StextPackage.ASSIGNMENT_EXPRESSION__OPERATOR:
				return getOperator();
			case StextPackage.ASSIGNMENT_EXPRESSION__EXPRESSION:
				return getExpression();
		}
		return super.eGet(featureID, resolve, coreType);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public void eSet(int featureID, Object newValue)
  {
		switch (featureID) {
			case StextPackage.ASSIGNMENT_EXPRESSION__VAR_REF:
				setVarRef((Expression)newValue);
				return;
			case StextPackage.ASSIGNMENT_EXPRESSION__OPERATOR:
				setOperator((AssignmentOperator)newValue);
				return;
			case StextPackage.ASSIGNMENT_EXPRESSION__EXPRESSION:
				setExpression((Expression)newValue);
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
  public void eUnset(int featureID)
  {
		switch (featureID) {
			case StextPackage.ASSIGNMENT_EXPRESSION__VAR_REF:
				setVarRef((Expression)null);
				return;
			case StextPackage.ASSIGNMENT_EXPRESSION__OPERATOR:
				setOperator(OPERATOR_EDEFAULT);
				return;
			case StextPackage.ASSIGNMENT_EXPRESSION__EXPRESSION:
				setExpression((Expression)null);
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
  public boolean eIsSet(int featureID)
  {
		switch (featureID) {
			case StextPackage.ASSIGNMENT_EXPRESSION__VAR_REF:
				return varRef != null;
			case StextPackage.ASSIGNMENT_EXPRESSION__OPERATOR:
				return operator != OPERATOR_EDEFAULT;
			case StextPackage.ASSIGNMENT_EXPRESSION__EXPRESSION:
				return expression != null;
		}
		return super.eIsSet(featureID);
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  @Override
  public String toString()
  {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (operator: ");
		result.append(operator);
		result.append(')');
		return result.toString();
	}

} //AssignmentExpressionImpl
