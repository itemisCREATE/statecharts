/**
 * <copyright>
 * </copyright>
 *
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
import org.eclipselabs.mscript.language.ast.ConditionalExpression;
import org.eclipselabs.mscript.language.ast.ConditionalExpressionCase;
import org.eclipselabs.mscript.language.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Conditional Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ConditionalExpressionImpl#getCases <em>Cases</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ConditionalExpressionImpl#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConditionalExpressionImpl extends ExpressionImpl implements ConditionalExpression
{
  /**
   * The cached value of the '{@link #getCases() <em>Cases</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCases()
   * @generated
   * @ordered
   */
  protected EList<ConditionalExpressionCase> cases;

  /**
   * The cached value of the '{@link #getElseExpression() <em>Else Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseExpression()
   * @generated
   * @ordered
   */
  protected Expression elseExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConditionalExpressionImpl()
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
    return AstPackage.Literals.CONDITIONAL_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConditionalExpressionCase> getCases()
  {
    if (cases == null)
    {
      cases = new EObjectContainmentEList<ConditionalExpressionCase>(ConditionalExpressionCase.class, this, AstPackage.CONDITIONAL_EXPRESSION__CASES);
    }
    return cases;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getElseExpression()
  {
    return elseExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseExpression(Expression newElseExpression, NotificationChain msgs)
  {
    Expression oldElseExpression = elseExpression;
    elseExpression = newElseExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL_EXPRESSION__ELSE_EXPRESSION, oldElseExpression, newElseExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElseExpression(Expression newElseExpression)
  {
    if (newElseExpression != elseExpression)
    {
      NotificationChain msgs = null;
      if (elseExpression != null)
        msgs = ((InternalEObject)elseExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.CONDITIONAL_EXPRESSION__ELSE_EXPRESSION, null, msgs);
      if (newElseExpression != null)
        msgs = ((InternalEObject)newElseExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.CONDITIONAL_EXPRESSION__ELSE_EXPRESSION, null, msgs);
      msgs = basicSetElseExpression(newElseExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.CONDITIONAL_EXPRESSION__ELSE_EXPRESSION, newElseExpression, newElseExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case AstPackage.CONDITIONAL_EXPRESSION__CASES:
        return ((InternalEList<?>)getCases()).basicRemove(otherEnd, msgs);
      case AstPackage.CONDITIONAL_EXPRESSION__ELSE_EXPRESSION:
        return basicSetElseExpression(null, msgs);
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
    switch (featureID)
    {
      case AstPackage.CONDITIONAL_EXPRESSION__CASES:
        return getCases();
      case AstPackage.CONDITIONAL_EXPRESSION__ELSE_EXPRESSION:
        return getElseExpression();
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
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case AstPackage.CONDITIONAL_EXPRESSION__CASES:
        getCases().clear();
        getCases().addAll((Collection<? extends ConditionalExpressionCase>)newValue);
        return;
      case AstPackage.CONDITIONAL_EXPRESSION__ELSE_EXPRESSION:
        setElseExpression((Expression)newValue);
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
    switch (featureID)
    {
      case AstPackage.CONDITIONAL_EXPRESSION__CASES:
        getCases().clear();
        return;
      case AstPackage.CONDITIONAL_EXPRESSION__ELSE_EXPRESSION:
        setElseExpression((Expression)null);
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
    switch (featureID)
    {
      case AstPackage.CONDITIONAL_EXPRESSION__CASES:
        return cases != null && !cases.isEmpty();
      case AstPackage.CONDITIONAL_EXPRESSION__ELSE_EXPRESSION:
        return elseExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //ConditionalExpressionImpl
