/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.java.javaGen.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage;
import org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration;

import org.yakindu.sct.model.sgen.impl.ConfigurationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Naming Configuration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.yakindu.sct.generator.model.java.javaGen.impl.NamingConfigurationImpl#getInterfacePackageName <em>Interface Package Name</em>}</li>
 *   <li>{@link org.yakindu.sct.generator.model.java.javaGen.impl.NamingConfigurationImpl#getImplementationPackageName <em>Implementation Package Name</em>}</li>
 *   <li>{@link org.yakindu.sct.generator.model.java.javaGen.impl.NamingConfigurationImpl#getCopyright <em>Copyright</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class NamingConfigurationImpl extends ConfigurationImpl implements NamingConfiguration
{
  /**
   * The default value of the '{@link #getInterfacePackageName() <em>Interface Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterfacePackageName()
   * @generated
   * @ordered
   */
  protected static final String INTERFACE_PACKAGE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getInterfacePackageName() <em>Interface Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInterfacePackageName()
   * @generated
   * @ordered
   */
  protected String interfacePackageName = INTERFACE_PACKAGE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getImplementationPackageName() <em>Implementation Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplementationPackageName()
   * @generated
   * @ordered
   */
  protected static final String IMPLEMENTATION_PACKAGE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getImplementationPackageName() <em>Implementation Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImplementationPackageName()
   * @generated
   * @ordered
   */
  protected String implementationPackageName = IMPLEMENTATION_PACKAGE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getCopyright() <em>Copyright</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCopyright()
   * @generated
   * @ordered
   */
  protected static final String COPYRIGHT_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getCopyright() <em>Copyright</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getCopyright()
   * @generated
   * @ordered
   */
  protected String copyright = COPYRIGHT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected NamingConfigurationImpl()
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
    return JavaGenPackage.Literals.NAMING_CONFIGURATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getInterfacePackageName()
  {
    return interfacePackageName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setInterfacePackageName(String newInterfacePackageName)
  {
    String oldInterfacePackageName = interfacePackageName;
    interfacePackageName = newInterfacePackageName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JavaGenPackage.NAMING_CONFIGURATION__INTERFACE_PACKAGE_NAME, oldInterfacePackageName, interfacePackageName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getImplementationPackageName()
  {
    return implementationPackageName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImplementationPackageName(String newImplementationPackageName)
  {
    String oldImplementationPackageName = implementationPackageName;
    implementationPackageName = newImplementationPackageName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JavaGenPackage.NAMING_CONFIGURATION__IMPLEMENTATION_PACKAGE_NAME, oldImplementationPackageName, implementationPackageName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getCopyright()
  {
    return copyright;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setCopyright(String newCopyright)
  {
    String oldCopyright = copyright;
    copyright = newCopyright;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, JavaGenPackage.NAMING_CONFIGURATION__COPYRIGHT, oldCopyright, copyright));
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
      case JavaGenPackage.NAMING_CONFIGURATION__INTERFACE_PACKAGE_NAME:
        return getInterfacePackageName();
      case JavaGenPackage.NAMING_CONFIGURATION__IMPLEMENTATION_PACKAGE_NAME:
        return getImplementationPackageName();
      case JavaGenPackage.NAMING_CONFIGURATION__COPYRIGHT:
        return getCopyright();
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
      case JavaGenPackage.NAMING_CONFIGURATION__INTERFACE_PACKAGE_NAME:
        setInterfacePackageName((String)newValue);
        return;
      case JavaGenPackage.NAMING_CONFIGURATION__IMPLEMENTATION_PACKAGE_NAME:
        setImplementationPackageName((String)newValue);
        return;
      case JavaGenPackage.NAMING_CONFIGURATION__COPYRIGHT:
        setCopyright((String)newValue);
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
      case JavaGenPackage.NAMING_CONFIGURATION__INTERFACE_PACKAGE_NAME:
        setInterfacePackageName(INTERFACE_PACKAGE_NAME_EDEFAULT);
        return;
      case JavaGenPackage.NAMING_CONFIGURATION__IMPLEMENTATION_PACKAGE_NAME:
        setImplementationPackageName(IMPLEMENTATION_PACKAGE_NAME_EDEFAULT);
        return;
      case JavaGenPackage.NAMING_CONFIGURATION__COPYRIGHT:
        setCopyright(COPYRIGHT_EDEFAULT);
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
      case JavaGenPackage.NAMING_CONFIGURATION__INTERFACE_PACKAGE_NAME:
        return INTERFACE_PACKAGE_NAME_EDEFAULT == null ? interfacePackageName != null : !INTERFACE_PACKAGE_NAME_EDEFAULT.equals(interfacePackageName);
      case JavaGenPackage.NAMING_CONFIGURATION__IMPLEMENTATION_PACKAGE_NAME:
        return IMPLEMENTATION_PACKAGE_NAME_EDEFAULT == null ? implementationPackageName != null : !IMPLEMENTATION_PACKAGE_NAME_EDEFAULT.equals(implementationPackageName);
      case JavaGenPackage.NAMING_CONFIGURATION__COPYRIGHT:
        return COPYRIGHT_EDEFAULT == null ? copyright != null : !COPYRIGHT_EDEFAULT.equals(copyright);
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
    result.append(" (interfacePackageName: ");
    result.append(interfacePackageName);
    result.append(", implementationPackageName: ");
    result.append(implementationPackageName);
    result.append(", copyright: ");
    result.append(copyright);
    result.append(')');
    return result.toString();
  }

} //NamingConfigurationImpl
