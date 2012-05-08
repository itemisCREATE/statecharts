/**
 */
package org.yakindu.sct.model.stext.stext.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.sct.model.stext.stext.EntryPointSpec;
import org.yakindu.sct.model.stext.stext.Entrypoint;
import org.yakindu.sct.model.stext.stext.StextPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Entry Point Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.impl.EntryPointSpecImpl#getEntrypoint <em>Entrypoint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class EntryPointSpecImpl extends ReactionPropertyImpl implements EntryPointSpec
{
  /**
   * The cached value of the '{@link #getEntrypoint() <em>Entrypoint</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEntrypoint()
   * @generated
   * @ordered
   */
  protected Entrypoint entrypoint;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected EntryPointSpecImpl()
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
    return StextPackage.Literals.ENTRY_POINT_SPEC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entrypoint getEntrypoint()
  {
    if (entrypoint != null && entrypoint.eIsProxy())
    {
      InternalEObject oldEntrypoint = (InternalEObject)entrypoint;
      entrypoint = (Entrypoint)eResolveProxy(oldEntrypoint);
      if (entrypoint != oldEntrypoint)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, StextPackage.ENTRY_POINT_SPEC__ENTRYPOINT, oldEntrypoint, entrypoint));
      }
    }
    return entrypoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Entrypoint basicGetEntrypoint()
  {
    return entrypoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setEntrypoint(Entrypoint newEntrypoint)
  {
    Entrypoint oldEntrypoint = entrypoint;
    entrypoint = newEntrypoint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, StextPackage.ENTRY_POINT_SPEC__ENTRYPOINT, oldEntrypoint, entrypoint));
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
      case StextPackage.ENTRY_POINT_SPEC__ENTRYPOINT:
        if (resolve) return getEntrypoint();
        return basicGetEntrypoint();
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
      case StextPackage.ENTRY_POINT_SPEC__ENTRYPOINT:
        setEntrypoint((Entrypoint)newValue);
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
      case StextPackage.ENTRY_POINT_SPEC__ENTRYPOINT:
        setEntrypoint((Entrypoint)null);
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
      case StextPackage.ENTRY_POINT_SPEC__ENTRYPOINT:
        return entrypoint != null;
    }
    return super.eIsSet(featureID);
  }

} //EntryPointSpecImpl
