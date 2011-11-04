/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.generator.model.java.javaGen;

import org.yakindu.sct.model.sgen.Configuration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Execution Type Configuration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.generator.model.java.javaGen.ExecutionTypeConfiguration#getType <em>Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage#getExecutionTypeConfiguration()
 * @model
 * @generated
 */
public interface ExecutionTypeConfiguration extends Configuration
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.yakindu.sct.generator.model.java.javaGen.ExecutionType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.yakindu.sct.generator.model.java.javaGen.ExecutionType
   * @see #setType(ExecutionType)
   * @see org.yakindu.sct.generator.model.java.javaGen.JavaGenPackage#getExecutionTypeConfiguration_Type()
   * @model
   * @generated
   */
  ExecutionType getType();

  /**
   * Sets the value of the '{@link org.yakindu.sct.generator.model.java.javaGen.ExecutionTypeConfiguration#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.yakindu.sct.generator.model.java.javaGen.ExecutionType
   * @see #getType()
   * @generated
   */
  void setType(ExecutionType value);

} // ExecutionTypeConfiguration
