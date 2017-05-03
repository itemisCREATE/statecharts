/**
 */
package org.yakindu.base.expressions.expressions;

import org.yakindu.base.types.AnnotationType;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Annotation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.Annotation#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getAnnotation()
 * @model
 * @generated
 */
public interface Annotation extends ArgumentExpression {
	/**
	 * Returns the value of the '<em><b>Type</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' reference.
	 * @see #setType(AnnotationType)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getAnnotation_Type()
	 * @model
	 * @generated
	 */
	AnnotationType getType();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.Annotation#getType <em>Type</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' reference.
	 * @see #getType()
	 * @generated
	 */
	void setType(AnnotationType value);

} // Annotation
