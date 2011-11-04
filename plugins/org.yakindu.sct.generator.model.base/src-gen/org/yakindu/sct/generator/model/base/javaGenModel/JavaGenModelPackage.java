/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.base.javaGenModel;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
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
 * @see org.yakindu.sct.generator.model.base.javaGenModel.JavaGenModelFactory
 * @model kind="package"
 * @generated
 */
public interface JavaGenModelPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "javaGenModel";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.yakindu.org/sct/generator/BaseGenModel";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "javaGenModel";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  JavaGenModelPackage eINSTANCE = org.yakindu.sct.generator.model.base.javaGenModel.impl.JavaGenModelPackageImpl.init();

  /**
   * The meta object id for the '{@link org.yakindu.sct.generator.model.base.javaGenModel.impl.OutletConfigurationCustomImpl <em>Outlet Configuration Custom</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.yakindu.sct.generator.model.base.javaGenModel.impl.OutletConfigurationCustomImpl
   * @see org.yakindu.sct.generator.model.base.javaGenModel.impl.JavaGenModelPackageImpl#getOutletConfigurationCustom()
   * @generated
   */
  int OUTLET_CONFIGURATION_CUSTOM = 0;

  /**
   * The feature id for the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTLET_CONFIGURATION_CUSTOM__PATH = SGenPackage.OUTLET_CONFIGURATION__PATH;

  /**
   * The feature id for the '<em><b>Override</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTLET_CONFIGURATION_CUSTOM__OVERRIDE = SGenPackage.OUTLET_CONFIGURATION__OVERRIDE;

  /**
   * The feature id for the '<em><b>Project Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTLET_CONFIGURATION_CUSTOM__PROJECT_NAME = SGenPackage.OUTLET_CONFIGURATION_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Target Folder</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTLET_CONFIGURATION_CUSTOM__TARGET_FOLDER = SGenPackage.OUTLET_CONFIGURATION_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Outlet Configuration Custom</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OUTLET_CONFIGURATION_CUSTOM_FEATURE_COUNT = SGenPackage.OUTLET_CONFIGURATION_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom <em>Outlet Configuration Custom</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Outlet Configuration Custom</em>'.
   * @see org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom
   * @generated
   */
  EClass getOutletConfigurationCustom();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom#getProjectName <em>Project Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Project Name</em>'.
   * @see org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom#getProjectName()
   * @see #getOutletConfigurationCustom()
   * @generated
   */
  EAttribute getOutletConfigurationCustom_ProjectName();

  /**
   * Returns the meta object for the attribute '{@link org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom#getTargetFolder <em>Target Folder</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Target Folder</em>'.
   * @see org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom#getTargetFolder()
   * @see #getOutletConfigurationCustom()
   * @generated
   */
  EAttribute getOutletConfigurationCustom_TargetFolder();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  JavaGenModelFactory getJavaGenModelFactory();

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
     * The meta object literal for the '{@link org.yakindu.sct.generator.model.base.javaGenModel.impl.OutletConfigurationCustomImpl <em>Outlet Configuration Custom</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.yakindu.sct.generator.model.base.javaGenModel.impl.OutletConfigurationCustomImpl
     * @see org.yakindu.sct.generator.model.base.javaGenModel.impl.JavaGenModelPackageImpl#getOutletConfigurationCustom()
     * @generated
     */
    EClass OUTLET_CONFIGURATION_CUSTOM = eINSTANCE.getOutletConfigurationCustom();

    /**
     * The meta object literal for the '<em><b>Project Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTLET_CONFIGURATION_CUSTOM__PROJECT_NAME = eINSTANCE.getOutletConfigurationCustom_ProjectName();

    /**
     * The meta object literal for the '<em><b>Target Folder</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute OUTLET_CONFIGURATION_CUSTOM__TARGET_FOLDER = eINSTANCE.getOutletConfigurationCustom_TargetFolder();

  }

} //JavaGenModelPackage
