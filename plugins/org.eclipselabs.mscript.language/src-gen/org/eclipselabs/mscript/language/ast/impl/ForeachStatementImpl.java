/**
 * <copyright>
 * </copyright>
 *
 */
package org.eclipselabs.mscript.language.ast.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.BlockStatement;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.ForeachStatement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Foreach Statement</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ForeachStatementImpl#getElementName <em>Element Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ForeachStatementImpl#getCollectionExpression <em>Collection Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.ForeachStatementImpl#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ForeachStatementImpl extends StatementImpl implements ForeachStatement
{
  /**
   * The default value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementName()
   * @generated
   * @ordered
   */
  protected static final String ELEMENT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getElementName() <em>Element Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getElementName()
   * @generated
   * @ordered
   */
  protected String elementName = ELEMENT_NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getCollectionExpression() <em>Collection Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCollectionExpression()
   * @generated
   * @ordered
   */
  protected Expression collectionExpression;

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
  protected ForeachStatementImpl()
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
    return AstPackage.Literals.FOREACH_STATEMENT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getElementName()
  {
    return elementName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setElementName(String newElementName)
  {
    String oldElementName = elementName;
    elementName = newElementName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FOREACH_STATEMENT__ELEMENT_NAME, oldElementName, elementName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getCollectionExpression()
  {
    return collectionExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetCollectionExpression(Expression newCollectionExpression, NotificationChain msgs)
  {
    Expression oldCollectionExpression = collectionExpression;
    collectionExpression = newCollectionExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FOREACH_STATEMENT__COLLECTION_EXPRESSION, oldCollectionExpression, newCollectionExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCollectionExpression(Expression newCollectionExpression)
  {
    if (newCollectionExpression != collectionExpression)
    {
      NotificationChain msgs = null;
      if (collectionExpression != null)
        msgs = ((InternalEObject)collectionExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOREACH_STATEMENT__COLLECTION_EXPRESSION, null, msgs);
      if (newCollectionExpression != null)
        msgs = ((InternalEObject)newCollectionExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOREACH_STATEMENT__COLLECTION_EXPRESSION, null, msgs);
      msgs = basicSetCollectionExpression(newCollectionExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FOREACH_STATEMENT__COLLECTION_EXPRESSION, newCollectionExpression, newCollectionExpression));
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.FOREACH_STATEMENT__BODY, oldBody, newBody);
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
        msgs = ((InternalEObject)body).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOREACH_STATEMENT__BODY, null, msgs);
      if (newBody != null)
        msgs = ((InternalEObject)newBody).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.FOREACH_STATEMENT__BODY, null, msgs);
      msgs = basicSetBody(newBody, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.FOREACH_STATEMENT__BODY, newBody, newBody));
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
      case AstPackage.FOREACH_STATEMENT__COLLECTION_EXPRESSION:
        return basicSetCollectionExpression(null, msgs);
      case AstPackage.FOREACH_STATEMENT__BODY:
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
      case AstPackage.FOREACH_STATEMENT__ELEMENT_NAME:
        return getElementName();
      case AstPackage.FOREACH_STATEMENT__COLLECTION_EXPRESSION:
        return getCollectionExpression();
      case AstPackage.FOREACH_STATEMENT__BODY:
        return getBody();
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
    switch (featureID)
    {
      case AstPackage.FOREACH_STATEMENT__ELEMENT_NAME:
        setElementName((String)newValue);
        return;
      case AstPackage.FOREACH_STATEMENT__COLLECTION_EXPRESSION:
        setCollectionExpression((Expression)newValue);
        return;
      case AstPackage.FOREACH_STATEMENT__BODY:
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
      case AstPackage.FOREACH_STATEMENT__ELEMENT_NAME:
        setElementName(ELEMENT_NAME_EDEFAULT);
        return;
      case AstPackage.FOREACH_STATEMENT__COLLECTION_EXPRESSION:
        setCollectionExpression((Expression)null);
        return;
      case AstPackage.FOREACH_STATEMENT__BODY:
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
      case AstPackage.FOREACH_STATEMENT__ELEMENT_NAME:
        return ELEMENT_NAME_EDEFAULT == null ? elementName != null : !ELEMENT_NAME_EDEFAULT.equals(elementName);
      case AstPackage.FOREACH_STATEMENT__COLLECTION_EXPRESSION:
        return collectionExpression != null;
      case AstPackage.FOREACH_STATEMENT__BODY:
        return body != null;
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
    result.append(" (elementName: ");
    result.append(elementName);
    result.append(')');
    return result.toString();
  }

} //ForeachStatementImpl
