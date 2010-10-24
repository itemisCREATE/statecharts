/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel;

import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.EquationDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.Equation#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.Equation#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.Equation#getSides <em>Sides</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.Equation#getLeftHandSide <em>Left Hand Side</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.Equation#getRightHandSide <em>Right Hand Side</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquation()
 * @model
 * @generated
 */
public interface Equation extends EObject {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.Function#getEquations <em>Equations</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' container reference.
	 * @see #setFunction(Function)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquation_Function()
	 * @see org.eclipselabs.mscript.language.functionmodel.Function#getEquations
	 * @model opposite="equations" required="true" transient="false"
	 * @generated
	 */
	Function getFunction();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.Equation#getFunction <em>Function</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' container reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(Function value);

	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(EquationDefinition)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquation_Definition()
	 * @model required="true"
	 * @generated
	 */
	EquationDefinition getDefinition();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.Equation#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(EquationDefinition value);

	/**
	 * Returns the value of the '<em><b>Sides</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.functionmodel.EquationSide}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.EquationSide#getEquation <em>Equation</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Sides</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Sides</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquation_Sides()
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationSide#getEquation
	 * @model opposite="equation" containment="true" lower="2" upper="2"
	 * @generated
	 */
	EList<EquationSide> getSides();

	/**
	 * Returns the value of the '<em><b>Left Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Left Hand Side</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Left Hand Side</em>' reference.
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquation_LeftHandSide()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EquationSide getLeftHandSide();

	/**
	 * Returns the value of the '<em><b>Right Hand Side</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Right Hand Side</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Right Hand Side</em>' reference.
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquation_RightHandSide()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	EquationSide getRightHandSide();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean leftHandSideIsSingleVariableReference(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Equation
