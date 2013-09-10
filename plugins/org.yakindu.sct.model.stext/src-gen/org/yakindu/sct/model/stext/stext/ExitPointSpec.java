/**
 */
package org.yakindu.sct.model.stext.stext;

import org.yakindu.sct.model.sgraph.ReactionProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Exit Point Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.ExitPointSpec#getExitpoint <em>Exitpoint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getExitPointSpec()
 * @model
 * @generated
 */
public interface ExitPointSpec extends ReactionProperty
{
  /**
	 * Returns the value of the '<em><b>Exitpoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Exitpoint</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Exitpoint</em>' attribute.
	 * @see #setExitpoint(String)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getExitPointSpec_Exitpoint()
	 * @model
	 * @generated
	 */
  String getExitpoint();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.ExitPointSpec#getExitpoint <em>Exitpoint</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exitpoint</em>' attribute.
	 * @see #getExitpoint()
	 * @generated
	 */
  void setExitpoint(String value);

} // ExitPointSpec
