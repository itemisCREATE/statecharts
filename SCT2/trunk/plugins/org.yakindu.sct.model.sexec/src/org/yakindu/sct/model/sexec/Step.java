/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec;

import org.eclipse.emf.common.util.EList;
import org.yakindu.base.base.NamedElement;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Step</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.yakindu.sct.model.sexec.Step#getComment <em>Comment</em>}</li>
 *   <li>{@link org.yakindu.sct.model.sexec.Step#getCaller <em>Caller</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.yakindu.sct.model.sexec.SexecPackage#getStep()
 * @model abstract="true"
 * @generated
 */
public interface Step extends NamedElement {
	/**
	 * Returns the value of the '<em><b>Comment</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Comment</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Comment</em>' attribute.
	 * @see #setComment(String)
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getStep_Comment()
	 * @model
	 * @generated
	 */
	String getComment();

	/**
	 * Sets the value of the '{@link org.yakindu.sct.model.sexec.Step#getComment <em>Comment</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Comment</em>' attribute.
	 * @see #getComment()
	 * @generated
	 */
	void setComment(String value);

	/**
	 * Returns the value of the '<em><b>Caller</b></em>' reference list.
	 * The list contents are of type {@link org.yakindu.sct.model.sexec.Call}.
	 * It is bidirectional and its opposite is '{@link org.yakindu.sct.model.sexec.Call#getStep <em>Step</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Caller</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caller</em>' reference list.
	 * @see org.yakindu.sct.model.sexec.SexecPackage#getStep_Caller()
	 * @see org.yakindu.sct.model.sexec.Call#getStep
	 * @model opposite="step"
	 * @generated
	 */
	EList<Call> getCaller();

} // Step
