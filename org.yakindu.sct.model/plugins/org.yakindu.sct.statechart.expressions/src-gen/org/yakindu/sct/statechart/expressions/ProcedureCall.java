/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Procedure Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.ProcedureCall#getProcedure <em>Procedure</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getProcedureCall()
 * @model
 * @generated
 */
public interface ProcedureCall extends Statement
{
  /**
   * Returns the value of the '<em><b>Procedure</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Procedure</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Procedure</em>' containment reference.
   * @see #setProcedure(Procedure)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getProcedureCall_Procedure()
   * @model containment="true"
   * @generated
   */
  Procedure getProcedure();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.ProcedureCall#getProcedure <em>Procedure</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Procedure</em>' containment reference.
   * @see #getProcedure()
   * @generated
   */
  void setProcedure(Procedure value);

} // ProcedureCall
