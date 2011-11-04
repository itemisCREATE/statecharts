/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.java.javaGen;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage
 * @generated
 */
public interface JavaGenFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  JavaGenFactory eINSTANCE = org.yakindu.sct.generator.model.java.javaGen.impl.JavaGenFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Naming Configuration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Naming Configuration</em>'.
   * @generated
   */
  NamingConfiguration createNamingConfiguration();

  /**
   * Returns a new object of class '<em>Execution Type Configuration</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Execution Type Configuration</em>'.
   * @generated
   */
  ExecutionTypeConfiguration createExecutionTypeConfiguration();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  JavaGenPackage getJavaGenPackage();

} //JavaGenFactory
