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
import org.eclipselabs.mscript.language.ast.Block;
import org.eclipselabs.mscript.language.ast.IfCase;
import org.eclipselabs.mscript.language.ast.IfStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.IfStatementImpl#getCases <em>Cases</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.IfStatementImpl#getElseBody <em>Else Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IfStatementImpl extends StatementImpl implements IfStatement
{
  /**
   * The cached value of the '{@link #getCases() <em>Cases</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCases()
   * @generated
   * @ordered
   */
  protected EList<IfCase> cases;

  /**
   * The cached value of the '{@link #getElseBody() <em>Else Body</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElseBody()
   * @generated
   * @ordered
   */
  protected Block elseBody;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IfStatementImpl()
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
    return AstPackage.Literals.IF_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<IfCase> getCases()
  {
    if (cases == null)
    {
      cases = new EObjectContainmentEList<IfCase>(IfCase.class, this, AstPackage.IF_STATEMENT__CASES);
    }
    return cases;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Block getElseBody()
  {
    return elseBody;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetElseBody(Block newElseBody, NotificationChain msgs)
  {
    Block oldElseBody = elseBody;
    elseBody = newElseBody;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.IF_STATEMENT__ELSE_BODY, oldElseBody, newElseBody);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElseBody(Block newElseBody)
  {
    if (newElseBody != elseBody)
    {
      NotificationChain msgs = null;
      if (elseBody != null)
        msgs = ((InternalEObject)elseBody).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.IF_STATEMENT__ELSE_BODY, null, msgs);
      if (newElseBody != null)
        msgs = ((InternalEObject)newElseBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.IF_STATEMENT__ELSE_BODY, null, msgs);
      msgs = basicSetElseBody(newElseBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.IF_STATEMENT__ELSE_BODY, newElseBody, newElseBody));
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
      case AstPackage.IF_STATEMENT__CASES:
        return ((InternalEList<?>)getCases()).basicRemove(otherEnd, msgs);
      case AstPackage.IF_STATEMENT__ELSE_BODY:
        return basicSetElseBody(null, msgs);
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
      case AstPackage.IF_STATEMENT__CASES:
        return getCases();
      case AstPackage.IF_STATEMENT__ELSE_BODY:
        return getElseBody();
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
      case AstPackage.IF_STATEMENT__CASES:
        getCases().clear();
        getCases().addAll((Collection<? extends IfCase>)newValue);
        return;
      case AstPackage.IF_STATEMENT__ELSE_BODY:
        setElseBody((Block)newValue);
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
      case AstPackage.IF_STATEMENT__CASES:
        getCases().clear();
        return;
      case AstPackage.IF_STATEMENT__ELSE_BODY:
        setElseBody((Block)null);
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
      case AstPackage.IF_STATEMENT__CASES:
        return cases != null && !cases.isEmpty();
      case AstPackage.IF_STATEMENT__ELSE_BODY:
        return elseBody != null;
    }
    return super.eIsSet(featureID);
  }

} //IfStatementImpl
