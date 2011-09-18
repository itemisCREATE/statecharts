/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;

import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ForStatement#getDeclaredIterationVariable <em>Declared Iteration Variable</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ForStatement#getIterationVariable <em>Iteration Variable</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ForStatement#getCollectionExpression <em>Collection Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ForStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.ForStatement#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getForStatement()
 * @model
 * @generated
 */
public interface ForStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Declared Iteration Variable</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declared Iteration Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declared Iteration Variable</em>' containment reference.
	 * @see #setDeclaredIterationVariable(IterationVariable)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getForStatement_DeclaredIterationVariable()
	 * @model containment="true"
	 * @generated
	 */
	IterationVariable getDeclaredIterationVariable();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ForStatement#getDeclaredIterationVariable <em>Declared Iteration Variable</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declared Iteration Variable</em>' containment reference.
	 * @see #getDeclaredIterationVariable()
	 * @generated
	 */
	void setDeclaredIterationVariable(IterationVariable value);

	/**
	 * Returns the value of the '<em><b>Iteration Variable</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iteration Variable</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration Variable</em>' reference.
	 * @see #setIterationVariable(CallableElement)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getForStatement_IterationVariable()
	 * @model
	 * @generated
	 */
	CallableElement getIterationVariable();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ForStatement#getIterationVariable <em>Iteration Variable</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iteration Variable</em>' reference.
	 * @see #getIterationVariable()
	 * @generated
	 */
	void setIterationVariable(CallableElement value);

	/**
	 * Returns the value of the '<em><b>Collection Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Collection Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Collection Expression</em>' containment reference.
	 * @see #setCollectionExpression(Expression)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getForStatement_CollectionExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getCollectionExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ForStatement#getCollectionExpression <em>Collection Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Expression</em>' containment reference.
	 * @see #getCollectionExpression()
	 * @generated
	 */
	void setCollectionExpression(Expression value);

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
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getForStatement_Condition()
	 * @model containment="true"
	 * @generated
	 */
	Expression getCondition();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ForStatement#getCondition <em>Condition</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Condition</em>' containment reference.
	 * @see #getCondition()
	 * @generated
	 */
	void setCondition(Expression value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Statement)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getForStatement_Body()
	 * @model containment="true"
	 * @generated
	 */
	Statement getBody();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.ForStatement#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Statement value);

} // ForStatement
