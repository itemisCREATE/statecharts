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
import org.eclipselabs.mscript.language.ast.BlockStatement;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.ForStatement;
import org.eclipselabs.mscript.language.ast.ForStatementInitializer;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ForStatementImpl#getInitializers <em>Initializers</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ForStatementImpl#getTestExpression <em>Test Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ForStatementImpl#getCountExpressions <em>Count Expressions</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ForStatementImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForStatementImpl extends StatementImpl implements ForStatement
{
  /**
   * The cached value of the '{@link #getInitializers() <em>Initializers</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInitializers()
   * @generated
   * @ordered
   */
  protected EList<ForStatementInitializer> initializers;

  /**
   * The cached value of the '{@link #getTestExpression() <em>Test Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTestExpression()
   * @generated
   * @ordered
   */
  protected Expression testExpression;

  /**
   * The cached value of the '{@link #getCountExpressions() <em>Count Expressions</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCountExpressions()
   * @generated
   * @ordered
   */
  protected EList<Expression> countExpressions;

  /**
   * The cached value of the '{@link #getBody() <em>Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBody()
   * @generated
   * @ordered
   */
  protected BlockStatement body;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ForStatementImpl()
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
    return AstPackage.Literals.FOR_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ForStatementInitializer> getInitializers()
  {
    if (initializers == null)
    {
      initializers = new EObjectContainmentEList<ForStatementInitializer>(ForStatementInitializer.class, this, AstPackage.FOR_STATEMENT__INITIALIZERS);
    }
    return initializers;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getTestExpression()
  {
    return testExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTestExpression(Expression newTestExpression, NotificationChain msgs)
  {
    Expression oldTestExpression = testExpression;
    testExpression = newTestExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__TEST_EXPRESSION, oldTestExpression, newTestExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTestExpression(Expression newTestExpression)
  {
    if (newTestExpression != testExpression)
    {
      NotificationChain msgs = null;
      if (testExpression != null)
        msgs = ((InternalEObject)testExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOR_STATEMENT__TEST_EXPRESSION, null, msgs);
      if (newTestExpression != null)
        msgs = ((InternalEObject)newTestExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOR_STATEMENT__TEST_EXPRESSION, null, msgs);
      msgs = basicSetTestExpression(newTestExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__TEST_EXPRESSION, newTestExpression, newTestExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getCountExpressions()
  {
    if (countExpressions == null)
    {
      countExpressions = new EObjectContainmentEList<Expression>(Expression.class, this, AstPackage.FOR_STATEMENT__COUNT_EXPRESSIONS);
    }
    return countExpressions;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BlockStatement getBody()
  {
    return body;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBody(BlockStatement newBody, NotificationChain msgs)
  {
    BlockStatement oldBody = body;
    body = newBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__BODY, oldBody, newBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBody(BlockStatement newBody)
  {
    if (newBody != body)
    {
      NotificationChain msgs = null;
      if (body != null)
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOR_STATEMENT__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOR_STATEMENT__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FOR_STATEMENT__BODY, newBody, newBody));
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
      case AstPackage.FOR_STATEMENT__INITIALIZERS:
        return ((InternalEList<?>)getInitializers()).basicRemove(otherEnd, msgs);
      case AstPackage.FOR_STATEMENT__TEST_EXPRESSION:
        return basicSetTestExpression(null, msgs);
      case AstPackage.FOR_STATEMENT__COUNT_EXPRESSIONS:
        return ((InternalEList<?>)getCountExpressions()).basicRemove(otherEnd, msgs);
      case AstPackage.FOR_STATEMENT__BODY:
        return basicSetBody(null, msgs);
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
      case AstPackage.FOR_STATEMENT__INITIALIZERS:
        return getInitializers();
      case AstPackage.FOR_STATEMENT__TEST_EXPRESSION:
        return getTestExpression();
      case AstPackage.FOR_STATEMENT__COUNT_EXPRESSIONS:
        return getCountExpressions();
      case AstPackage.FOR_STATEMENT__BODY:
        return getBody();
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
      case AstPackage.FOR_STATEMENT__INITIALIZERS:
        getInitializers().clear();
        getInitializers().addAll((Collection<? extends ForStatementInitializer>)newValue);
        return;
      case AstPackage.FOR_STATEMENT__TEST_EXPRESSION:
        setTestExpression((Expression)newValue);
        return;
      case AstPackage.FOR_STATEMENT__COUNT_EXPRESSIONS:
        getCountExpressions().clear();
        getCountExpressions().addAll((Collection<? extends Expression>)newValue);
        return;
      case AstPackage.FOR_STATEMENT__BODY:
        setBody((BlockStatement)newValue);
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
      case AstPackage.FOR_STATEMENT__INITIALIZERS:
        getInitializers().clear();
        return;
      case AstPackage.FOR_STATEMENT__TEST_EXPRESSION:
        setTestExpression((Expression)null);
        return;
      case AstPackage.FOR_STATEMENT__COUNT_EXPRESSIONS:
        getCountExpressions().clear();
        return;
      case AstPackage.FOR_STATEMENT__BODY:
        setBody((BlockStatement)null);
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
      case AstPackage.FOR_STATEMENT__INITIALIZERS:
        return initializers != null && !initializers.isEmpty();
      case AstPackage.FOR_STATEMENT__TEST_EXPRESSION:
        return testExpression != null;
      case AstPackage.FOR_STATEMENT__COUNT_EXPRESSIONS:
        return countExpressions != null && !countExpressions.isEmpty();
      case AstPackage.FOR_STATEMENT__BODY:
        return body != null;
    }
    return super.eIsSet(featureID);
  }

} //ForStatementImpl
