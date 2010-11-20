/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel;

import org.eclipselabs.mscript.language.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Assignment</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Assignment#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Assignment#getStepIndex <em>Step Index</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Assignment#getAssignedExpression <em>Assigned Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getAssignment()
 * @model
 * @generated
 */
public interface Assignment extends Statement {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(VariableDeclaration)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getAssignment_Target()
	 * @model
	 * @generated
	 */
	VariableDeclaration getTarget();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.Assignment#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Step Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Index</em>' attribute.
	 * @see #setStepIndex(int)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getAssignment_StepIndex()
	 * @model
	 * @generated
	 */
	int getStepIndex();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.Assignment#getStepIndex <em>Step Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Index</em>' attribute.
	 * @see #getStepIndex()
	 * @generated
	 */
	void setStepIndex(int value);

	/**
	 * Returns the value of the '<em><b>Assigned Expression</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Assigned Expression</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Assigned Expression</em>' containment reference.
	 * @see #setAssignedExpression(Expression)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getAssignment_AssignedExpression()
	 * @model containment="true"
	 * @generated
	 */
	Expression getAssignedExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.Assignment#getAssignedExpression <em>Assigned Expression</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Assigned Expression</em>' containment reference.
	 * @see #getAssignedExpression()
	 * @generated
	 */
	void setAssignedExpression(Expression value);

} // Assignment
