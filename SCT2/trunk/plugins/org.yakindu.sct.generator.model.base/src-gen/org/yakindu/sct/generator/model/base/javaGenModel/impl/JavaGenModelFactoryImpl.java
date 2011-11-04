/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.base.javaGenModel.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.yakindu.sct.generator.model.base.javaGenModel.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class JavaGenModelFactoryImpl extends EFactoryImpl implements JavaGenModelFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static JavaGenModelFactory init()
  {
    try
    {
      JavaGenModelFactory theJavaGenModelFactory = (JavaGenModelFactory)EPackage.Registry.INSTANCE.getEFactory("http://www.yakindu.org/sct/generator/BaseGenModel"); 
      if (theJavaGenModelFactory != null)
      {
        return theJavaGenModelFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new JavaGenModelFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaGenModelFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case JavaGenModelPackage.OUTLET_CONFIGURATION_CUSTOM: return createOutletConfigurationCustom();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OutletConfigurationCustom createOutletConfigurationCustom()
  {
    OutletConfigurationCustomImpl outletConfigurationCustom = new OutletConfigurationCustomImpl();
    return outletConfigurationCustom;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaGenModelPackage getJavaGenModelPackage()
  {
    return (JavaGenModelPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static JavaGenModelPackage getPackage()
  {
    return JavaGenModelPackage.eINSTANCE;
  }

} //JavaGenModelFactoryImpl
