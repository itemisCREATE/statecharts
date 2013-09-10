/**
 */
package org.yakindu.sct.model.stext.stext;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transition Root</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.TransitionRoot#getDef <em>Def</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getTransitionRoot()
 * @model
 * @generated
 */
public interface TransitionRoot extends DefRoot
{
  /**
   * Returns the value of the '<em><b>Def</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Def</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Def</em>' containment reference.
   * @see #setDef(TransitionSpecification)
   * @see org.yakindu.sct.model.stext.stext.StextPackage#getTransitionRoot_Def()
   * @model containment="true"
   * @generated
   */
  TransitionSpecification getDef();

  /**
   * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.TransitionRoot#getDef <em>Def</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Def</em>' containment reference.
   * @see #getDef()
   * @generated
   */
  void setDef(TransitionSpecification value);

} // TransitionRoot
