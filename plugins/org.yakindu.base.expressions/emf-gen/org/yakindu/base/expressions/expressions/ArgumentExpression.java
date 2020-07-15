/**
 */
package org.yakindu.base.expressions.expressions;

import org.eclipse.emf.common.util.EList;
import org.yakindu.base.types.Argument;
import org.yakindu.base.types.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Argument Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.ArgumentExpression#getArguments <em>Arguments</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getArgumentExpression()
 * @model abstract="true"
 * @generated
 */
public interface ArgumentExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Arguments</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Argument}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Arguments</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Arguments</em>' containment reference list.
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getArgumentExpression_Arguments()
	 * @model containment="true"
	 * @generated
	 */
	EList<Argument> getArguments();

	/**
	 * <!-- begin-user-doc -->
	 * 
	 * This method is deprecated. Use {@link ArgumentExpression#getExpressions()} instead.
	 * 
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated NOT
	 */
	@Deprecated
	EList<Expression> getArgs();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	EList<Expression> getExpressions();

} // ArgumentExpression
