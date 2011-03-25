/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.statechart.expressions;

import org.yakindu.model.sct.statechart.Variable;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.VariableDefinition#isReadonly <em>Readonly</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.VariableDefinition#isExternal <em>External</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.VariableDefinition#getType <em>Type</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.VariableDefinition#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getVariableDefinition()
 * @model
 * @generated
 */
public interface VariableDefinition extends Definition, Variable
{
  /**
   * Returns the value of the '<em><b>Readonly</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Readonly</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Readonly</em>' attribute.
   * @see #setReadonly(boolean)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getVariableDefinition_Readonly()
   * @model
   * @generated
   */
  boolean isReadonly();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.VariableDefinition#isReadonly <em>Readonly</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Readonly</em>' attribute.
   * @see #isReadonly()
   * @generated
   */
  void setReadonly(boolean value);

  /**
   * Returns the value of the '<em><b>External</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>External</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>External</em>' attribute.
   * @see #setExternal(boolean)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getVariableDefinition_External()
   * @model
   * @generated
   */
  boolean isExternal();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.VariableDefinition#isExternal <em>External</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>External</em>' attribute.
   * @see #isExternal()
   * @generated
   */
  void setExternal(boolean value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link org.yakindu.sct.statechart.expressions.Type}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.Type
   * @see #setType(Type)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getVariableDefinition_Type()
   * @model
   * @generated
   */
  Type getType();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.VariableDefinition#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.Type
   * @see #getType()
   * @generated
   */
  void setType(Type value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(String)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getVariableDefinition_Value()
   * @model
   * @generated
   */
  String getValue();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.VariableDefinition#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(String value);

} // VariableDefinition
