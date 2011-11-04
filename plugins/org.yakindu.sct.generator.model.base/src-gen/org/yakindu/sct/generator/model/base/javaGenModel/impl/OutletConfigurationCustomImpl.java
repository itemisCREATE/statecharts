/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.base.javaGenModel.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.sct.generator.model.base.javaGenModel.JavaGenModelPackage;
import org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom;

import org.yakindu.sct.model.sgen.impl.OutletConfigurationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Outlet Configuration Custom</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.generator.model.base.javaGenModel.impl.OutletConfigurationCustomImpl#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.yakindu.sct.generator.model.base.javaGenModel.impl.OutletConfigurationCustomImpl#getTargetFolder <em>Target Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class OutletConfigurationCustomImpl extends OutletConfigurationImpl implements OutletConfigurationCustom
{
  /**
   * The default value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProjectName()
   * @generated
   * @ordered
   */
  protected static final String PROJECT_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getProjectName() <em>Project Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getProjectName()
   * @generated
   * @ordered
   */
  protected String projectName = PROJECT_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getTargetFolder() <em>Target Folder</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetFolder()
   * @generated
   * @ordered
   */
  protected static final String TARGET_FOLDER_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTargetFolder() <em>Target Folder</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetFolder()
   * @generated
   * @ordered
   */
  protected String targetFolder = TARGET_FOLDER_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected OutletConfigurationCustomImpl()
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
    return JavaGenModelPackage.Literals.OUTLET_CONFIGURATION_CUSTOM;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getProjectName()
  {
    return projectName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setProjectName(String newProjectName)
  {
    String oldProjectName = projectName;
    projectName = newProjectName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JavaGenModelPackage.OUTLET_CONFIGURATION_CUSTOM__PROJECT_NAME, oldProjectName, projectName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTargetFolder()
  {
    return targetFolder;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetFolder(String newTargetFolder)
  {
    String oldTargetFolder = targetFolder;
    targetFolder = newTargetFolder;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JavaGenModelPackage.OUTLET_CONFIGURATION_CUSTOM__TARGET_FOLDER, oldTargetFolder, targetFolder));
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
      case JavaGenModelPackage.OUTLET_CONFIGURATION_CUSTOM__PROJECT_NAME:
        return getProjectName();
      case JavaGenModelPackage.OUTLET_CONFIGURATION_CUSTOM__TARGET_FOLDER:
        return getTargetFolder();
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
      case JavaGenModelPackage.OUTLET_CONFIGURATION_CUSTOM__PROJECT_NAME:
        setProjectName((String)newValue);
        return;
      case JavaGenModelPackage.OUTLET_CONFIGURATION_CUSTOM__TARGET_FOLDER:
        setTargetFolder((String)newValue);
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
      case JavaGenModelPackage.OUTLET_CONFIGURATION_CUSTOM__PROJECT_NAME:
        setProjectName(PROJECT_NAME_EDEFAULT);
        return;
      case JavaGenModelPackage.OUTLET_CONFIGURATION_CUSTOM__TARGET_FOLDER:
        setTargetFolder(TARGET_FOLDER_EDEFAULT);
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
      case JavaGenModelPackage.OUTLET_CONFIGURATION_CUSTOM__PROJECT_NAME:
        return PROJECT_NAME_EDEFAULT == null ? projectName != null : !PROJECT_NAME_EDEFAULT.equals(projectName);
      case JavaGenModelPackage.OUTLET_CONFIGURATION_CUSTOM__TARGET_FOLDER:
        return TARGET_FOLDER_EDEFAULT == null ? targetFolder != null : !TARGET_FOLDER_EDEFAULT.equals(targetFolder);
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
    result.append(" (projectName: ");
    result.append(projectName);
    result.append(", targetFolder: ");
    result.append(targetFolder);
    result.append(')');
    return result.toString();
  }

} //OutletConfigurationCustomImpl
