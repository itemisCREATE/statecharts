/**
 */
package org.yakindu.base.expressions.expressions;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.ArgumentExpression#getArgs <em>Args</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getArgumentExpression()
 * @model abstract="true"
 * @generated
 */
public interface ArgumentExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Args</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.expressions.expressions.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Args</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Args</em>' containment reference list.
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getArgumentExpression_Args()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArgs();

} // ArgumentExpression
