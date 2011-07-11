/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il;

import org.eclipselabs.mscript.typesystem.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Foreach Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.il.ForeachStatement#getIterationVariableDeclaration <em>Iteration Variable Declaration</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.ForeachStatement#getCollectionExpression <em>Collection Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.ForeachStatement#getBody <em>Body</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.il.ILPackage#getForeachStatement()
 * @model
 * @generated
 */
public interface ForeachStatement extends Statement {
	/**
	 * Returns the value of the '<em><b>Iteration Variable Declaration</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iteration Variable Declaration</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration Variable Declaration</em>' containment reference.
	 * @see #setIterationVariableDeclaration(VariableDeclaration)
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getForeachStatement_IterationVariableDeclaration()
	 * @model containment="true"
	 * @generated
	 */
	VariableDeclaration getIterationVariableDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.il.ForeachStatement#getIterationVariableDeclaration <em>Iteration Variable Declaration</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iteration Variable Declaration</em>' containment reference.
	 * @see #getIterationVariableDeclaration()
	 * @generated
	 */
	void setIterationVariableDeclaration(VariableDeclaration value);

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
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getForeachStatement_CollectionExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getCollectionExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.il.ForeachStatement#getCollectionExpression <em>Collection Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Collection Expression</em>' containment reference.
	 * @see #getCollectionExpression()
	 * @generated
	 */
	void setCollectionExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Body</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Body</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Body</em>' containment reference.
	 * @see #setBody(Compound)
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getForeachStatement_Body()
	 * @model containment="true"
	 * @generated
	 */
	Compound getBody();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.il.ForeachStatement#getBody <em>Body</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Body</em>' containment reference.
	 * @see #getBody()
	 * @generated
	 */
	void setBody(Compound value);

} // ForeachStatement
