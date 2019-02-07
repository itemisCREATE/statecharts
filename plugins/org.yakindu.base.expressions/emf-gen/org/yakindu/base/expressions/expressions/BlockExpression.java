/**
 */
package org.yakindu.base.expressions.expressions;

import org.eclipse.emf.common.util.EList;
import org.yakindu.base.types.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Block Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.BlockExpression#getExpressions <em>Expressions</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getBlockExpression()
 * @model
 * @generated
 */
public interface BlockExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Expressions</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expressions</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expressions</em>' containment reference list.
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getBlockExpression_Expressions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getExpressions();

} // BlockExpression
