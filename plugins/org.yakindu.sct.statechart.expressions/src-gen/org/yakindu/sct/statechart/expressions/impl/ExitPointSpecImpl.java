/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.sct.statechart.expressions.ExitPointSpec;
import org.yakindu.sct.statechart.expressions.Exitpoint;
import org.yakindu.sct.statechart.expressions.ExpressionsPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Exit Point Spec</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.impl.ExitPointSpecImpl#getExitpoint <em>Exitpoint</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExitPointSpecImpl extends ReactionPropertyImpl implements ExitPointSpec
{
  /**
   * The cached value of the '{@link #getExitpoint() <em>Exitpoint</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExitpoint()
   * @generated
   * @ordered
   */
  protected Exitpoint exitpoint;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExitPointSpecImpl()
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
    return ExpressionsPackage.Literals.EXIT_POINT_SPEC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exitpoint getExitpoint()
  {
    if (exitpoint != null && exitpoint.eIsProxy())
    {
      InternalEObject oldExitpoint = (InternalEObject)exitpoint;
      exitpoint = (Exitpoint)eResolveProxy(oldExitpoint);
      if (exitpoint != oldExitpoint)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, ExpressionsPackage.EXIT_POINT_SPEC__EXITPOINT, oldExitpoint, exitpoint));
      }
    }
    return exitpoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Exitpoint basicGetExitpoint()
  {
    return exitpoint;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExitpoint(Exitpoint newExitpoint)
  {
    Exitpoint oldExitpoint = exitpoint;
    exitpoint = newExitpoint;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, ExpressionsPackage.EXIT_POINT_SPEC__EXITPOINT, oldExitpoint, exitpoint));
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
      case ExpressionsPackage.EXIT_POINT_SPEC__EXITPOINT:
        if (resolve) return getExitpoint();
        return basicGetExitpoint();
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
      case ExpressionsPackage.EXIT_POINT_SPEC__EXITPOINT:
        setExitpoint((Exitpoint)newValue);
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
      case ExpressionsPackage.EXIT_POINT_SPEC__EXITPOINT:
        setExitpoint((Exitpoint)null);
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
      case ExpressionsPackage.EXIT_POINT_SPEC__EXITPOINT:
        return exitpoint != null;
    }
    return super.eIsSet(featureID);
  }

} //ExitPointSpecImpl
