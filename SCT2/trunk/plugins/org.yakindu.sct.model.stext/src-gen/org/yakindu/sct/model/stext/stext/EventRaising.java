/**
 * <copyright>
 * </copyright>
 *

 */
package org.yakindu.sct.model.stext.stext;

import org.yakindu.sct.model.sgraph.Event;
import org.yakindu.sct.model.sgraph.Statement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Raising</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.EventRaising#getEvent <em>Event</em>}</li>
 *   <li>{@link org.yakindu.sct.model.stext.stext.EventRaising#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getEventRaising()
 * @model
 * @generated
 */
public interface EventRaising extends Statement
{
  /**
   * Returns the value of the '<em><b>Event</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Event</em>' reference.
   * @see #setEvent(Event)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getEventRaising_Event()
   * @model
   * @generated
   */
  Event getEvent();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.EventRaising#getEvent <em>Event</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Event</em>' reference.
   * @see #getEvent()
   * @generated
   */
  void setEvent(Event value);

  /**
   * Returns the value of the '<em><b>Value</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Value</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' containment reference.
   * @see #setValue(Expression)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getEventRaising_Value()
   * @model containment="true"
   * @generated
   */
  Expression getValue();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.EventRaising#getValue <em>Value</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' containment reference.
   * @see #getValue()
   * @generated
   */
  void setValue(Expression value);

} // EventRaising
