/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.java.javaGen;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.yakindu.sct.model.sgen.SGenPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see org.yakindu.sct.generator.model.java.javaGen.JavaGenFactory
 * @model kind="package"
 * @generated
 */
public interface JavaGenPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "javaGen";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.yakindu.org/sct/generator/model/java/JavaGen";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "javaGen";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  JavaGenPackage eINSTANCE = org.yakindu.sct.generator.model.java.javaGen.impl.JavaGenPackageImpl.init();

  /**
   * The meta object id for the '{@link org.yakindu.sct.generator.model.java.javaGen.impl.NamingConfigurationImpl <em>Naming Configuration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.generator.model.java.javaGen.impl.NamingConfigurationImpl
   * @see org.yakindu.sct.generator.model.java.javaGen.impl.JavaGenPackageImpl#getNamingConfiguration()
   * @generated
   */
  int NAMING_CONFIGURATION = 0;

  /**
   * The feature id for the '<em><b>Interface Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMING_CONFIGURATION__INTERFACE_PACKAGE_NAME = SGenPackage.CONFIGURATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Implementation Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMING_CONFIGURATION__IMPLEMENTATION_PACKAGE_NAME = SGenPackage.CONFIGURATION_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Copyright</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMING_CONFIGURATION__COPYRIGHT = SGenPackage.CONFIGURATION_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Naming Configuration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMING_CONFIGURATION_FEATURE_COUNT = SGenPackage.CONFIGURATION_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link org.yakindu.sct.generator.model.java.javaGen.impl.ExecutionTypeConfigurationImpl <em>Execution Type Configuration</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.generator.model.java.javaGen.impl.ExecutionTypeConfigurationImpl
   * @see org.yakindu.sct.generator.model.java.javaGen.impl.JavaGenPackageImpl#getExecutionTypeConfiguration()
   * @generated
   */
  int EXECUTION_TYPE_CONFIGURATION = 1;

  /**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTION_TYPE_CONFIGURATION__TYPE = SGenPackage.CONFIGURATION_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Execution Type Configuration</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXECUTION_TYPE_CONFIGURATION_FEATURE_COUNT = SGenPackage.CONFIGURATION_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link org.yakindu.sct.generator.model.java.javaGen.ExecutionType <em>Execution Type</em>}' enum.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.generator.model.java.javaGen.ExecutionType
   * @see org.yakindu.sct.generator.model.java.javaGen.impl.JavaGenPackageImpl#getExecutionType()
   * @generated
   */
  int EXECUTION_TYPE = 2;


  /**
   * Returns the meta object for class '{@link org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration <em>Naming Configuration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Naming Configuration</em>'.
   * @see org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration
   * @generated
   */
  EClass getNamingConfiguration();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration#getInterfacePackageName <em>Interface Package Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Interface Package Name</em>'.
   * @see org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration#getInterfacePackageName()
   * @see #getNamingConfiguration()
   * @generated
   */
  EAttribute getNamingConfiguration_InterfacePackageName();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration#getImplementationPackageName <em>Implementation Package Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Implementation Package Name</em>'.
   * @see org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration#getImplementationPackageName()
   * @see #getNamingConfiguration()
   * @generated
   */
  EAttribute getNamingConfiguration_ImplementationPackageName();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration#getCopyright <em>Copyright</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Copyright</em>'.
   * @see org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration#getCopyright()
   * @see #getNamingConfiguration()
   * @generated
   */
  EAttribute getNamingConfiguration_Copyright();

  /**
   * Returns the meta object for class '{@link org.yakindu.sct.generator.model.java.javaGen.ExecutionTypeConfiguration <em>Execution Type Configuration</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Execution Type Configuration</em>'.
   * @see org.yakindu.sct.generator.model.java.javaGen.ExecutionTypeConfiguration
   * @generated
   */
  EClass getExecutionTypeConfiguration();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.generator.model.java.javaGen.ExecutionTypeConfiguration#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see org.yakindu.sct.generator.model.java.javaGen.ExecutionTypeConfiguration#getType()
   * @see #getExecutionTypeConfiguration()
   * @generated
   */
  EAttribute getExecutionTypeConfiguration_Type();

  /**
   * Returns the meta object for enum '{@link org.yakindu.sct.generator.model.java.javaGen.ExecutionType <em>Execution Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for enum '<em>Execution Type</em>'.
   * @see org.yakindu.sct.generator.model.java.javaGen.ExecutionType
   * @generated
   */
  EEnum getExecutionType();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  JavaGenFactory getJavaGenFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link org.yakindu.sct.generator.model.java.javaGen.impl.NamingConfigurationImpl <em>Naming Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.generator.model.java.javaGen.impl.NamingConfigurationImpl
     * @see org.yakindu.sct.generator.model.java.javaGen.impl.JavaGenPackageImpl#getNamingConfiguration()
     * @generated
     */
    EClass NAMING_CONFIGURATION = eINSTANCE.getNamingConfiguration();

    /**
     * The meta object literal for the '<em><b>Interface Package Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMING_CONFIGURATION__INTERFACE_PACKAGE_NAME = eINSTANCE.getNamingConfiguration_InterfacePackageName();

    /**
     * The meta object literal for the '<em><b>Implementation Package Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMING_CONFIGURATION__IMPLEMENTATION_PACKAGE_NAME = eINSTANCE.getNamingConfiguration_ImplementationPackageName();

    /**
     * The meta object literal for the '<em><b>Copyright</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMING_CONFIGURATION__COPYRIGHT = eINSTANCE.getNamingConfiguration_Copyright();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.generator.model.java.javaGen.impl.ExecutionTypeConfigurationImpl <em>Execution Type Configuration</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.generator.model.java.javaGen.impl.ExecutionTypeConfigurationImpl
     * @see org.yakindu.sct.generator.model.java.javaGen.impl.JavaGenPackageImpl#getExecutionTypeConfiguration()
     * @generated
     */
    EClass EXECUTION_TYPE_CONFIGURATION = eINSTANCE.getExecutionTypeConfiguration();

    /**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXECUTION_TYPE_CONFIGURATION__TYPE = eINSTANCE.getExecutionTypeConfiguration_Type();

    /**
     * The meta object literal for the '{@link org.yakindu.sct.generator.model.java.javaGen.ExecutionType <em>Execution Type</em>}' enum.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.generator.model.java.javaGen.ExecutionType
     * @see org.yakindu.sct.generator.model.java.javaGen.impl.JavaGenPackageImpl#getExecutionType()
     * @generated
     */
    EEnum EXECUTION_TYPE = eINSTANCE.getExecutionType();

  }

} //JavaGenPackage
