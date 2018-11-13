/**
 */
package org.yakindu.sct.model.stext.stext;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Guard</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.sct.model.stext.stext.Guard#getExpression <em>Expression</em>}</li>
 * </ul>
 *
 * @see org.yakindu.sct.model.stext.stext.StextPackage#getGuard()
 * @model
 * @generated
 */
public interface Guard extends EObject {
	/**
	 * Returns the value of the '<em><b>Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' containment reference.
	 * @see #setExpression(org.yakindu.base.types.Expression)
	 * @see org.yakindu.sct.model.stext.stext.StextPackage#getGuard_Expression()
	 * @model containment="true"
	 * @generated
	 */
	org.yakindu.base.types.Expression getExpression();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.stext.stext.Guard#getExpression <em>Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' containment reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(org.yakindu.base.types.Expression value);

} // Guard
