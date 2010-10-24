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
import org.eclipselabs.mscript.language.ast.FunctionDefinition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.Function#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.Function#getEquations <em>Equations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.Function#getVariableReferences <em>Variable References</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends EObject {
	/**
	 * Returns the value of the '<em><b>Definition</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Definition</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Definition</em>' reference.
	 * @see #setDefinition(FunctionDefinition)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getFunction_Definition()
	 * @model required="true"
	 * @generated
	 */
	FunctionDefinition getDefinition();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.Function#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(FunctionDefinition value);

	/**
	 * Returns the value of the '<em><b>Equations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.functionmodel.Equation}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.Equation#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getFunction_Equations()
	 * @see org.eclipselabs.mscript.language.functionmodel.Equation#getFunction
	 * @model opposite="function" containment="true"
	 * @generated
	 */
	EList<Equation> getEquations();

	/**
	 * Returns the value of the '<em><b>Variable References</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.functionmodel.VariableReference}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getFunction <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable References</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable References</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getFunction_VariableReferences()
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReference#getFunction
	 * @model opposite="function" containment="true"
	 * @generated
	 */
	EList<VariableReference> getVariableReferences();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean equationExistsForEachOutput(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean equationExistsForEachStep(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean hasNoDuplicateEquations(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Function
