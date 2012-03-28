/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext.impl;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.yakindu.base.base.NamedElement;
import org.yakindu.sct.model.stext.stext.StextPackage;
import org.yakindu.sct.model.stext.stext.TypedElementReferenceExpression;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Typed Element Reference Expression</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.TypedElementReferenceExpressionImpl#getReference <em>Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypedElementReferenceExpressionImpl extends ExpressionImpl implements TypedElementReferenceExpression
{
  /**
   * The cached value of the '{@link #getReference() <em>Reference</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getReference()
   * @generated
   * @ordered
   */
  protected NamedElement reference;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypedElementReferenceExpressionImpl()
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
    return StextPackage.Literals.TYPED_ELEMENT_REFERENCE_EXPRESSION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement getReference()
  {
    if (reference != null && reference.eIsProxy())
    {
      InternalEObject oldReference = (InternalEObject)reference;
      reference = (NamedElement)eResolveProxy(oldReference);
      if (reference != oldReference)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StextPackage.TYPED_ELEMENT_REFERENCE_EXPRESSION__REFERENCE, oldReference, reference));
      }
    }
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement basicGetReference()
  {
    return reference;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setReference(NamedElement newReference)
  {
    NamedElement oldReference = reference;
    reference = newReference;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.TYPED_ELEMENT_REFERENCE_EXPRESSION__REFERENCE, oldReference, reference));
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
      case StextPackage.TYPED_ELEMENT_REFERENCE_EXPRESSION__REFERENCE:
        if (resolve) return getReference();
        return basicGetReference();
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
      case StextPackage.TYPED_ELEMENT_REFERENCE_EXPRESSION__REFERENCE:
        setReference((NamedElement)newValue);
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
      case StextPackage.TYPED_ELEMENT_REFERENCE_EXPRESSION__REFERENCE:
        setReference((NamedElement)null);
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
      case StextPackage.TYPED_ELEMENT_REFERENCE_EXPRESSION__REFERENCE:
        return reference != null;
    }
    return super.eIsSet(featureID);
  }

} //TypedElementReferenceExpressionImpl
