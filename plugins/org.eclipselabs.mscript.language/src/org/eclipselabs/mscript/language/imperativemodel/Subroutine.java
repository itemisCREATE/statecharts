/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subroutine</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getContext <em>Context</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getInputVariableDeclarations <em>Input Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getOutputVariableDeclarations <em>Output Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getComputationCompounds <em>Computation Compounds</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutine()
 * @model
 * @generated
 */
public interface Subroutine extends EObject {
	/**
	 * Returns the value of the '<em><b>Context</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Context</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Context</em>' containment reference.
	 * @see #setContext(SubroutineContext)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutine_Context()
	 * @model containment="true"
	 * @generated
	 */
	SubroutineContext getContext();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getContext <em>Context</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Context</em>' containment reference.
	 * @see #getContext()
	 * @generated
	 */
	void setContext(SubroutineContext value);

	/**
	 * Returns the value of the '<em><b>Input Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutine_InputVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputVariableDeclaration> getInputVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Output Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutine_OutputVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputVariableDeclaration> getOutputVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Computation Compounds</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.ComputationCompound}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computation Compounds</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computation Compounds</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutine_ComputationCompounds()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComputationCompound> getComputationCompounds();

} // Subroutine
