/**
 */
package org.yakindu.sct.model.stext.stext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Regular Event Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.RegularEventSpec#getEvent <em>Event</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getRegularEventSpec()
 * @model
 * @generated
 */
public interface RegularEventSpec extends EventSpec
{
  /**
	 * Returns the value of the '<em><b>Event</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Event</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Event</em>' containment reference.
	 * @see #setEvent(Expression)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getRegularEventSpec_Event()
	 * @model containment="true"
	 * @generated
	 */
  Expression getEvent();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.RegularEventSpec#getEvent <em>Event</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Event</em>' containment reference.
	 * @see #getEvent()
	 * @generated
	 */
  void setEvent(Expression value);

} // RegularEventSpec
