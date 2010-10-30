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
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipselabs.mscript.language.ast.AssertionDeclaration;
import org.eclipselabs.mscript.language.ast.AssertionStatusKind;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Assertion Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.AssertionDeclarationImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.AssertionDeclarationImpl#getPredicate <em>Predicate</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.AssertionDeclarationImpl#getStatusKind <em>Status Kind</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.AssertionDeclarationImpl#getMessage <em>Message</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AssertionDeclarationImpl extends MinimalEObjectImpl.Container implements AssertionDeclaration
{
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
   * The cached value of the '{@link #getPredicate() <em>Predicate</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPredicate()
   * @generated
   * @ordered
   */
  protected Expression predicate;

  /**
   * The default value of the '{@link #getStatusKind() <em>Status Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatusKind()
   * @generated
   * @ordered
   */
  protected static final AssertionStatusKind STATUS_KIND_EDEFAULT = AssertionStatusKind.INFO;

  /**
   * The cached value of the '{@link #getStatusKind() <em>Status Kind</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getStatusKind()
   * @generated
   * @ordered
   */
  protected AssertionStatusKind statusKind = STATUS_KIND_EDEFAULT;

  /**
   * The cached value of the '{@link #getMessage() <em>Message</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessage()
   * @generated
   * @ordered
   */
  protected Expression message;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AssertionDeclarationImpl()
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
    return AstPackage.Literals.ASSERTION_DECLARATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStatic()
  {
    return static_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatic(boolean newStatic)
  {
    boolean oldStatic = static_;
    static_ = newStatic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ASSERTION_DECLARATION__STATIC, oldStatic, static_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getPredicate()
  {
    return predicate;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPredicate(Expression newPredicate, NotificationChain msgs)
  {
    Expression oldPredicate = predicate;
    predicate = newPredicate;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.ASSERTION_DECLARATION__PREDICATE, oldPredicate, newPredicate);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPredicate(Expression newPredicate)
  {
    if (newPredicate != predicate)
    {
      NotificationChain msgs = null;
      if (predicate != null)
        msgs = ((InternalEObject)predicate).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.ASSERTION_DECLARATION__PREDICATE, null, msgs);
      if (newPredicate != null)
        msgs = ((InternalEObject)newPredicate).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.ASSERTION_DECLARATION__PREDICATE, null, msgs);
      msgs = basicSetPredicate(newPredicate, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ASSERTION_DECLARATION__PREDICATE, newPredicate, newPredicate));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AssertionStatusKind getStatusKind()
  {
    return statusKind;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatusKind(AssertionStatusKind newStatusKind)
  {
    AssertionStatusKind oldStatusKind = statusKind;
    statusKind = newStatusKind == null ? STATUS_KIND_EDEFAULT : newStatusKind;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ASSERTION_DECLARATION__STATUS_KIND, oldStatusKind, statusKind));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Expression getMessage()
  {
    return message;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMessage(Expression newMessage, NotificationChain msgs)
  {
    Expression oldMessage = message;
    message = newMessage;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, AstPackage.ASSERTION_DECLARATION__MESSAGE, oldMessage, newMessage);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessage(Expression newMessage)
  {
    if (newMessage != message)
    {
      NotificationChain msgs = null;
      if (message != null)
        msgs = ((InternalEObject)message).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - AstPackage.ASSERTION_DECLARATION__MESSAGE, null, msgs);
      if (newMessage != null)
        msgs = ((InternalEObject)newMessage).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - AstPackage.ASSERTION_DECLARATION__MESSAGE, null, msgs);
      msgs = basicSetMessage(newMessage, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AstPackage.ASSERTION_DECLARATION__MESSAGE, newMessage, newMessage));
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
      case AstPackage.ASSERTION_DECLARATION__PREDICATE:
        return basicSetPredicate(null, msgs);
      case AstPackage.ASSERTION_DECLARATION__MESSAGE:
        return basicSetMessage(null, msgs);
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
      case AstPackage.ASSERTION_DECLARATION__STATIC:
        return isStatic();
      case AstPackage.ASSERTION_DECLARATION__PREDICATE:
        return getPredicate();
      case AstPackage.ASSERTION_DECLARATION__STATUS_KIND:
        return getStatusKind();
      case AstPackage.ASSERTION_DECLARATION__MESSAGE:
        return getMessage();
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
      case AstPackage.ASSERTION_DECLARATION__STATIC:
        setStatic((Boolean)newValue);
        return;
      case AstPackage.ASSERTION_DECLARATION__PREDICATE:
        setPredicate((Expression)newValue);
        return;
      case AstPackage.ASSERTION_DECLARATION__STATUS_KIND:
        setStatusKind((AssertionStatusKind)newValue);
        return;
      case AstPackage.ASSERTION_DECLARATION__MESSAGE:
        setMessage((Expression)newValue);
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
      case AstPackage.ASSERTION_DECLARATION__STATIC:
        setStatic(STATIC_EDEFAULT);
        return;
      case AstPackage.ASSERTION_DECLARATION__PREDICATE:
        setPredicate((Expression)null);
        return;
      case AstPackage.ASSERTION_DECLARATION__STATUS_KIND:
        setStatusKind(STATUS_KIND_EDEFAULT);
        return;
      case AstPackage.ASSERTION_DECLARATION__MESSAGE:
        setMessage((Expression)null);
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
      case AstPackage.ASSERTION_DECLARATION__STATIC:
        return static_ != STATIC_EDEFAULT;
      case AstPackage.ASSERTION_DECLARATION__PREDICATE:
        return predicate != null;
      case AstPackage.ASSERTION_DECLARATION__STATUS_KIND:
        return statusKind != STATUS_KIND_EDEFAULT;
      case AstPackage.ASSERTION_DECLARATION__MESSAGE:
        return message != null;
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
    result.append(" (static: ");
    result.append(static_);
    result.append(", statusKind: ");
    result.append(statusKind);
    result.append(')');
    return result.toString();
  }

} //AssertionDeclarationImpl
