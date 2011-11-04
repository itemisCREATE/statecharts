/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.java.javaGen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.sct.generator.model.java.javaGen.ExecutionType;
import org.yakindu.sct.generator.model.java.javaGen.ExecutionTypeConfiguration;
import org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage;

import org.yakindu.sct.model.sgen.impl.ConfigurationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Execution Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.generator.model.java.javaGen.impl.ExecutionTypeConfigurationImpl#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExecutionTypeConfigurationImpl extends ConfigurationImpl implements ExecutionTypeConfiguration
{
  /**
   * The default value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected static final ExecutionType TYPE_EDEFAULT = ExecutionType.CYCLE_BASED;

  /**
   * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getType()
   * @generated
   * @ordered
   */
  protected ExecutionType type = TYPE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExecutionTypeConfigurationImpl()
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
    return JavaGenPackage.Literals.EXECUTION_TYPE_CONFIGURATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExecutionType getType()
  {
    return type;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setType(ExecutionType newType)
  {
    ExecutionType oldType = type;
    type = newType == null ? TYPE_EDEFAULT : newType;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JavaGenPackage.EXECUTION_TYPE_CONFIGURATION__TYPE, oldType, type));
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
      case JavaGenPackage.EXECUTION_TYPE_CONFIGURATION__TYPE:
        return getType();
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
      case JavaGenPackage.EXECUTION_TYPE_CONFIGURATION__TYPE:
        setType((ExecutionType)newValue);
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
      case JavaGenPackage.EXECUTION_TYPE_CONFIGURATION__TYPE:
        setType(TYPE_EDEFAULT);
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
      case JavaGenPackage.EXECUTION_TYPE_CONFIGURATION__TYPE:
        return type != TYPE_EDEFAULT;
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
    result.append(" (type: ");
    result.append(type);
    result.append(')');
    return result.toString();
  }

} //ExecutionTypeConfigurationImpl
