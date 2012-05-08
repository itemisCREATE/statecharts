/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.yakindu.sct.model.stext.stext.ElementReferenceExpression;
import org.yakindu.sct.model.stext.stext.Expression;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.ElementReferenceExpressionImpl#getReference <em>Reference</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.ElementReferenceExpressionImpl#isOperationCall <em>Operation Call</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.ElementReferenceExpressionImpl#getArgs <em>Args</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementReferenceExpressionImpl extends ExpressionImpl implements ElementReferenceExpression
{
  /**
   * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReference()
   * @generated
   * @ordered
   */
  protected EObject reference;

  /**
   * The default value of the '{@link #isOperationCall() <em>Operation Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOperationCall()
   * @generated
   * @ordered
   */
  protected static final boolean OPERATION_CALL_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isOperationCall() <em>Operation Call</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isOperationCall()
   * @generated
   * @ordered
   */
  protected boolean operationCall = OPERATION_CALL_EDEFAULT;

  /**
   * The cached value of the '{@link #getArgs() <em>Args</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgs()
   * @generated
   * @ordered
   */
  protected EList<Expression> args;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ElementReferenceExpressionImpl()
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
    return StextPackage.Literals.ELEMENT_REFERENCE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject getReference()
  {
    if (reference != null && reference.eIsProxy())
    {
      InternalEObject oldReference = (InternalEObject)reference;
      reference = eResolveProxy(oldReference);
      if (reference != oldReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StextPackage.ELEMENT_REFERENCE_EXPRESSION__REFERENCE, oldReference, reference));
      }
    }
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EObject basicGetReference()
  {
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReference(EObject newReference)
  {
    EObject oldReference = reference;
    reference = newReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.ELEMENT_REFERENCE_EXPRESSION__REFERENCE, oldReference, reference));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isOperationCall()
  {
    return operationCall;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOperationCall(boolean newOperationCall)
  {
    boolean oldOperationCall = operationCall;
    operationCall = newOperationCall;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.ELEMENT_REFERENCE_EXPRESSION__OPERATION_CALL, oldOperationCall, operationCall));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Expression> getArgs()
  {
    if (args == null)
    {
      args = new EObjectContainmentEList<Expression>(Expression.class, this, StextPackage.ELEMENT_REFERENCE_EXPRESSION__ARGS);
    }
    return args;
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
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__ARGS:
        return ((InternalEList<?>)getArgs()).basicRemove(otherEnd, msgs);
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
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__REFERENCE:
        if (resolve) return getReference();
        return basicGetReference();
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__OPERATION_CALL:
        return isOperationCall();
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__ARGS:
        return getArgs();
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
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__REFERENCE:
        setReference((EObject)newValue);
        return;
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__OPERATION_CALL:
        setOperationCall((Boolean)newValue);
        return;
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__ARGS:
        getArgs().clear();
        getArgs().addAll((Collection<? extends Expression>)newValue);
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
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__REFERENCE:
        setReference((EObject)null);
        return;
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__OPERATION_CALL:
        setOperationCall(OPERATION_CALL_EDEFAULT);
        return;
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__ARGS:
        getArgs().clear();
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
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__REFERENCE:
        return reference != null;
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__OPERATION_CALL:
        return operationCall != OPERATION_CALL_EDEFAULT;
      case StextPackage.ELEMENT_REFERENCE_EXPRESSION__ARGS:
        return args != null && !args.isEmpty();
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
    result.append(" (operationCall: ");
    result.append(operationCall);
    result.append(')');
    return result.toString();
  }

} //ElementReferenceExpressionImpl
