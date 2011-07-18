/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Range Step Expression</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.RangeStepExpression#getStart <em>Start</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.ast.RangeStepExpression#getEnd <em>End</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.ast.AstPackage#getRangeStepExpression()
 * @model
 * @generated
 */
public interface RangeStepExpression extends StepExpression {
	/**
	 * Returns the value of the '<em><b>Start</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Start</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Start</em>' containment reference.
	 * @see #setStart(StepExpression)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getRangeStepExpression_Start()
	 * @model containment="true"
	 * @generated
	 */
	StepExpression getStart();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.RangeStepExpression#getStart <em>Start</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Start</em>' containment reference.
	 * @see #getStart()
	 * @generated
	 */
	void setStart(StepExpression value);

	/**
	 * Returns the value of the '<em><b>End</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>End</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>End</em>' containment reference.
	 * @see #setEnd(StepExpression)
	 * @see org.eclipselabs.mscript.language.ast.AstPackage#getRangeStepExpression_End()
	 * @model containment="true"
	 * @generated
	 */
	StepExpression getEnd();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.ast.RangeStepExpression#getEnd <em>End</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>End</em>' containment reference.
	 * @see #getEnd()
	 * @generated
	 */
	void setEnd(StepExpression value);

} // RangeStepExpression
