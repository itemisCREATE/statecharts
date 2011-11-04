/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.java.javaGen;

import org.yakindu.sct.model.sgen.Configuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Naming Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration#getInterfacePackageName <em>Interface Package Name</em>}</li>
 *   <li>{@link org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration#getImplementationPackageName <em>Implementation Package Name</em>}</li>
 *   <li>{@link org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration#getCopyright <em>Copyright</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage#getNamingConfiguration()
 * @model
 * @generated
 */
public interface NamingConfiguration extends Configuration
{
  /**
   * Returns the value of the '<em><b>Interface Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interface Package Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interface Package Name</em>' attribute.
   * @see #setInterfacePackageName(String)
   * @see org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage#getNamingConfiguration_InterfacePackageName()
   * @model
   * @generated
   */
  String getInterfacePackageName();

  /**
   * Sets the value of the '{@link org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration#getInterfacePackageName <em>Interface Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interface Package Name</em>' attribute.
   * @see #getInterfacePackageName()
   * @generated
   */
  void setInterfacePackageName(String value);

  /**
   * Returns the value of the '<em><b>Implementation Package Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Implementation Package Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Implementation Package Name</em>' attribute.
   * @see #setImplementationPackageName(String)
   * @see org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage#getNamingConfiguration_ImplementationPackageName()
   * @model
   * @generated
   */
  String getImplementationPackageName();

  /**
   * Sets the value of the '{@link org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration#getImplementationPackageName <em>Implementation Package Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Implementation Package Name</em>' attribute.
   * @see #getImplementationPackageName()
   * @generated
   */
  void setImplementationPackageName(String value);

  /**
   * Returns the value of the '<em><b>Copyright</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Copyright</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Copyright</em>' attribute.
   * @see #setCopyright(String)
   * @see org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage#getNamingConfiguration_Copyright()
   * @model
   * @generated
   */
  String getCopyright();

  /**
   * Sets the value of the '{@link org.yakindu.sct.generator.model.java.javaGen.NamingConfiguration#getCopyright <em>Copyright</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Copyright</em>' attribute.
   * @see #getCopyright()
   * @generated
   */
  void setCopyright(String value);

} // NamingConfiguration
