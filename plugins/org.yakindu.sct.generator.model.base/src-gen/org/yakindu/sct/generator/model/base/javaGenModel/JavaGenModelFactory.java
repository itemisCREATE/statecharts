/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.base.javaGenModel;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.generator.model.base.javaGenModel.JavaGenModelPackage
 * @generated
 */
public interface JavaGenModelFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  JavaGenModelFactory eINSTANCE = org.yakindu.sct.generator.model.base.javaGenModel.impl.JavaGenModelFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Outlet Configuration Custom</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Outlet Configuration Custom</em>'.
   * @generated
   */
  OutletConfigurationCustom createOutletConfigurationCustom();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  JavaGenModelPackage getJavaGenModelPackage();

} //JavaGenModelFactory
