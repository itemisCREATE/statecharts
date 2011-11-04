/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.base.javaGenModel;

import org.yakindu.sct.model.sgen.OutletConfiguration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Outlet Configuration Custom</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom#getTargetFolder <em>Target Folder</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.generator.model.base.javaGenModel.JavaGenModelPackage#getOutletConfigurationCustom()
 * @model
 * @generated
 */
public interface OutletConfigurationCustom extends OutletConfiguration
{
  /**
   * Returns the value of the '<em><b>Project Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Project Name</em>' attribute.
   * @see #setProjectName(String)
   * @see org.yakindu.sct.generator.model.base.javaGenModel.JavaGenModelPackage#getOutletConfigurationCustom_ProjectName()
   * @model
   * @generated
   */
  String getProjectName();

  /**
   * Sets the value of the '{@link org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom#getProjectName <em>Project Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Project Name</em>' attribute.
   * @see #getProjectName()
   * @generated
   */
  void setProjectName(String value);

  /**
   * Returns the value of the '<em><b>Target Folder</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Folder</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Folder</em>' attribute.
   * @see #setTargetFolder(String)
   * @see org.yakindu.sct.generator.model.base.javaGenModel.JavaGenModelPackage#getOutletConfigurationCustom_TargetFolder()
   * @model
   * @generated
   */
  String getTargetFolder();

  /**
   * Sets the value of the '{@link org.yakindu.sct.generator.model.base.javaGenModel.OutletConfigurationCustom#getTargetFolder <em>Target Folder</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Folder</em>' attribute.
   * @see #getTargetFolder()
   * @generated
   */
  void setTargetFolder(String value);

} // OutletConfigurationCustom
