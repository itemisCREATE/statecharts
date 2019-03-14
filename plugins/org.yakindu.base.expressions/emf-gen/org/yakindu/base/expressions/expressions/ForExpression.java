/**
 */
package org.yakindu.base.expressions.expressions;

import org.eclipse.emf.common.util.EList;

import org.yakindu.base.types.Expression;
import org.yakindu.base.types.Property;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link org.yakindu.base.expressions.expressions.ForExpression#getBody <em>Body</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.ForExpression#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.ForExpression#getVarInits <em>Var Inits</em>}</li>
 *   <li>{@link org.yakindu.base.expressions.expressions.ForExpression#getVarUpdates <em>Var Updates</em>}</li>
 * </ul>
 *
 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getForExpression()
 * @model
 * @generated
 */
public interface ForExpression extends Expression {
	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Expression)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getForExpression_Body()
	 * @model containment="true"
	 * @generated
	 */
	Expression getBody();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.ForExpression#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Expression value);

	/**
	 * Returns the value of the '<em><b>Condition</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Condition</em>' containment reference.
	 * @see #setCondition(Expression)
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getForExpression_Condition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link org.yakindu.base.expressions.expressions.ForExpression#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Var Inits</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Inits</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Inits</em>' containment reference list.
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getForExpression_VarInits()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getVarInits();

	/**
	 * Returns the value of the '<em><b>Var Updates</b></em>' containment reference list.
	 * The list contents are of type {@link org.yakindu.base.types.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Var Updates</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Var Updates</em>' containment reference list.
	 * @see org.yakindu.base.expressions.expressions.ExpressionsPackage#getForExpression_VarUpdates()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getVarUpdates();

} // ForExpression
