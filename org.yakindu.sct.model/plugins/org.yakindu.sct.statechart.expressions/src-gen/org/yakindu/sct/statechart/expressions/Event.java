/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.statechart.expressions;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.statechart.expressions.Event#getName <em>Name</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.Event#getDirection <em>Direction</em>}</li>
 *   <li>{@link org.yakindu.sct.statechart.expressions.Event#getTime <em>Time</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getEvent()
 * @model
 * @generated
 */
public interface Event extends Statement
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getEvent_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.Event#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Direction</b></em>' attribute.
   * The literals are from the enumeration {@link org.yakindu.sct.statechart.expressions.DirectionKind}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Direction</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Direction</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.DirectionKind
   * @see #setDirection(DirectionKind)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getEvent_Direction()
   * @model
   * @generated
   */
  DirectionKind getDirection();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.Event#getDirection <em>Direction</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Direction</em>' attribute.
   * @see org.yakindu.sct.statechart.expressions.DirectionKind
   * @see #getDirection()
   * @generated
   */
  void setDirection(DirectionKind value);

  /**
   * Returns the value of the '<em><b>Time</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Time</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Time</em>' containment reference.
   * @see #setTime(TimeConstant)
   * @see org.yakindu.sct.statechart.expressions.ExpressionsPackage#getEvent_Time()
   * @model containment="true"
   * @generated
   */
  TimeConstant getTime();

  /**
   * Sets the value of the '{@link org.yakindu.sct.statechart.expressions.Event#getTime <em>Time</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Time</em>' containment reference.
   * @see #getTime()
   * @generated
   */
  void setTime(TimeConstant value);

} // Event
