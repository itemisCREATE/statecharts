/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.java.javaGen.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.yakindu.sct.generator.model.java.javaGen.*;

import org.yakindu.sct.model.sgen.Configuration;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage
 * @generated
 */
public class JavaGenAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static JavaGenPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public JavaGenAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = JavaGenPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected JavaGenSwitch<Adapter> modelSwitch =
    new JavaGenSwitch<Adapter>()
    {
      @Override
      public Adapter caseNamingConfiguration(NamingConfiguration object)
      {
        return createNamingConfigurationAdapter();
      }
      @Override
      public Adapter caseExecutionTypeConfiguration(ExecutionTypeConfiguration object)
      {
        return createExecutionTypeConfigurationAdapter();
      }
      @Override
      public Adapter caseConfiguration(Configuration object)
      {
        return createConfigurationAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration <em>Naming Configuration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration
   * @generated
   */
  public Adapter createNamingConfigurationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.yakindu.sct.generator.model.java.javaGen.ExecutionTypeConfiguration <em>Execution Type Configuration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.yakindu.sct.generator.model.java.javaGen.ExecutionTypeConfiguration
   * @generated
   */
  public Adapter createExecutionTypeConfigurationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.yakindu.sct.model.sgen.Configuration <em>Configuration</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.yakindu.sct.model.sgen.Configuration
   * @generated
   */
  public Adapter createConfigurationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //JavaGenAdapterFactory
