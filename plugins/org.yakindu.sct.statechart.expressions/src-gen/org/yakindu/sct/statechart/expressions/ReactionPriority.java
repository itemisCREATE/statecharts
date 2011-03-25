/**
 * <copyright>
 * </copyright>
 *
 */
package org.yakindu.sct.statechart.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reaction Priority</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.ReactionPriority#getPriority <em>Priority</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getReactionPriority()
 * @model
 * @generated
 */
public interface ReactionPriority extends ReactionProperty
{
  /**
   * Returns the value of the '<em><b>Priority</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Priority</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Priority</em>' attribute.
   * @see #setPriority(int)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getReactionPriority_Priority()
   * @model
   * @generated
   */
  int getPriority();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.ReactionPriority#getPriority <em>Priority</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Priority</em>' attribute.
   * @see #getPriority()
   * @generated
   */
  void setPriority(int value);

} // ReactionPriority
