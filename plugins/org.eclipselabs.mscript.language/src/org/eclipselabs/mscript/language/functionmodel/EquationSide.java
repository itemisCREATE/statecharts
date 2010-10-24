/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equation Side</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.EquationSide#getEquation <em>Equation</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.EquationSide#getExpression <em>Expression</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.EquationSide#getParts <em>Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquationSide()
 * @model
 * @generated
 */
public interface EquationSide extends EObject {
	/**
	 * Returns the value of the '<em><b>Equation</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.Equation#getSides <em>Sides</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equation</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equation</em>' container reference.
	 * @see #setEquation(Equation)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquationSide_Equation()
	 * @see org.eclipselabs.mscript.language.functionmodel.Equation#getSides
	 * @model opposite="sides" required="true" transient="false"
	 * @generated
	 */
	Equation getEquation();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.EquationSide#getEquation <em>Equation</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Equation</em>' container reference.
	 * @see #getEquation()
	 * @generated
	 */
	void setEquation(Equation value);

	/**
	 * Returns the value of the '<em><b>Expression</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Expression</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Expression</em>' reference.
	 * @see #setExpression(Expression)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquationSide_Expression()
	 * @model required="true"
	 * @generated
	 */
	Expression getExpression();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.EquationSide#getExpression <em>Expression</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Expression</em>' reference.
	 * @see #getExpression()
	 * @generated
	 */
	void setExpression(Expression value);

	/**
	 * Returns the value of the '<em><b>Parts</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.functionmodel.EquationPart}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.EquationPart#getSide <em>Side</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Parts</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Parts</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquationSide_Parts()
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationPart#getSide
	 * @model opposite="side" containment="true"
	 * @generated
	 */
	EList<EquationPart> getParts();

} // EquationSide
