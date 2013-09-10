/**
 */
package org.yakindu.sct.model.stext.stext;

import org.yakindu.sct.model.sgraph.Event;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Event Definition</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.EventDefinition#getDirection <em>Direction</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getEventDefinition()
 * @model
 * @generated
 */
public interface EventDefinition extends Event, org.yakindu.base.types.Event
{
  /**
	 * Returns the value of the '<em><b>Direction</b></em>' attribute.
	 * The literals are from the enumeration {@link org.yakindu.sct.model.stext.stext.Direction}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Direction</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Direction</em>' attribute.
	 * @see org.yakindu.sct.model.stext.stext.Direction
	 * @see #setDirection(Direction)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getEventDefinition_Direction()
	 * @model
	 * @generated
	 */
  Direction getDirection();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.EventDefinition#getDirection <em>Direction</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Direction</em>' attribute.
	 * @see org.yakindu.sct.model.stext.stext.Direction
	 * @see #getDirection()
	 * @generated
	 */
  void setDirection(Direction value);

} // EventDefinition
