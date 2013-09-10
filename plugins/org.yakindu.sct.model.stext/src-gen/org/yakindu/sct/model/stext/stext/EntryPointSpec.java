/**
 */
package org.yakindu.sct.model.stext.stext;

import org.yakindu.sct.model.sgraph.ReactionProperty;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Entry Point Spec</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.EntryPointSpec#getEntrypoint <em>Entrypoint</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getEntryPointSpec()
 * @model
 * @generated
 */
public interface EntryPointSpec extends ReactionProperty
{
  /**
	 * Returns the value of the '<em><b>Entrypoint</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entrypoint</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Entrypoint</em>' attribute.
	 * @see #setEntrypoint(String)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getEntryPointSpec_Entrypoint()
	 * @model
	 * @generated
	 */
  String getEntrypoint();

  /**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.EntryPointSpec#getEntrypoint <em>Entrypoint</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Entrypoint</em>' attribute.
	 * @see #getEntrypoint()
	 * @generated
	 */
  void setEntrypoint(String value);

} // EntryPointSpec
