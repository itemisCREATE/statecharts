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
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.Statement;
import org.eclipselabs.mscript.language.ast.SwitchCase;
import org.eclipselabs.mscript.language.ast.SwitchStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Switch Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.SwitchStatementImpl#getControlExpression <em>Control Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.SwitchStatementImpl#getCases <em>Cases</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.SwitchStatementImpl#getDefaultStatements <em>Default Statements</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SwitchStatementImpl extends StatementImpl implements SwitchStatement
{
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
   * The cached value of the '{@link #getDefaultStatements() <em>Default Statements</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDefaultStatements()
   * @generated
   * @ordered
   */
  protected EList<Statement> defaultStatements;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SwitchStatementImpl()
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
    return AstPackage.Literals.SWITCH_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getControlExpression()
  {
    return controlExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetControlExpression(Expression newControlExpression, NotificationChain msgs)
  {
    Expression oldControlExpression = controlExpression;
    controlExpression = newControlExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.SWITCH_STATEMENT__CONTROL_EXPRESSION, oldControlExpression, newControlExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setControlExpression(Expression newControlExpression)
  {
    if (newControlExpression != controlExpression)
    {
      NotificationChain msgs = null;
      if (controlExpression != null)
        msgs = ((InternalEObject)controlExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.SWITCH_STATEMENT__CONTROL_EXPRESSION, null, msgs);
      if (newControlExpression != null)
        msgs = ((InternalEObject)newControlExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.SWITCH_STATEMENT__CONTROL_EXPRESSION, null, msgs);
      msgs = basicSetControlExpression(newControlExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.SWITCH_STATEMENT__CONTROL_EXPRESSION, newControlExpression, newControlExpression));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SwitchCase> getCases()
  {
    if (cases == null)
    {
      cases = new EObjectContainmentEList<SwitchCase>(SwitchCase.class, this, AstPackage.SWITCH_STATEMENT__CASES);
    }
    return cases;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Statement> getDefaultStatements()
  {
    if (defaultStatements == null)
    {
      defaultStatements = new EObjectContainmentEList<Statement>(Statement.class, this, AstPackage.SWITCH_STATEMENT__DEFAULT_STATEMENTS);
    }
    return defaultStatements;
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
      case AstPackage.SWITCH_STATEMENT__CONTROL_EXPRESSION:
        return basicSetControlExpression(null, msgs);
      case AstPackage.SWITCH_STATEMENT__CASES:
        return ((InternalEList<?>)getCases()).basicRemove(otherEnd, msgs);
      case AstPackage.SWITCH_STATEMENT__DEFAULT_STATEMENTS:
        return ((InternalEList<?>)getDefaultStatements()).basicRemove(otherEnd, msgs);
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
      case AstPackage.SWITCH_STATEMENT__CONTROL_EXPRESSION:
        return getControlExpression();
      case AstPackage.SWITCH_STATEMENT__CASES:
        return getCases();
      case AstPackage.SWITCH_STATEMENT__DEFAULT_STATEMENTS:
        return getDefaultStatements();
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
      case AstPackage.SWITCH_STATEMENT__CONTROL_EXPRESSION:
        setControlExpression((Expression)newValue);
        return;
      case AstPackage.SWITCH_STATEMENT__CASES:
        getCases().clear();
        getCases().addAll((Collection<? extends SwitchCase>)newValue);
        return;
      case AstPackage.SWITCH_STATEMENT__DEFAULT_STATEMENTS:
        getDefaultStatements().clear();
        getDefaultStatements().addAll((Collection<? extends Statement>)newValue);
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
      case AstPackage.SWITCH_STATEMENT__CONTROL_EXPRESSION:
        setControlExpression((Expression)null);
        return;
      case AstPackage.SWITCH_STATEMENT__CASES:
        getCases().clear();
        return;
      case AstPackage.SWITCH_STATEMENT__DEFAULT_STATEMENTS:
        getDefaultStatements().clear();
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
      case AstPackage.SWITCH_STATEMENT__CONTROL_EXPRESSION:
        return controlExpression != null;
      case AstPackage.SWITCH_STATEMENT__CASES:
        return cases != null && !cases.isEmpty();
      case AstPackage.SWITCH_STATEMENT__DEFAULT_STATEMENTS:
        return defaultStatements != null && !defaultStatements.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //SwitchStatementImpl
