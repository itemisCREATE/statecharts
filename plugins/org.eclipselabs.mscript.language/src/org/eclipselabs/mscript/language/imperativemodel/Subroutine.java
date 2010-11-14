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
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getTemplateVariableDeclarations <em>Template Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getInputVariableDeclarations <em>Input Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getOutputVariableDeclarations <em>Output Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getStateVariableDeclarations <em>State Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getInitializationBlock <em>Initialization Block</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getComputationBlocks <em>Computation Blocks</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutine()
 * @model
 * @generated
 */
public interface Subroutine extends EObject {
	/**
	 * Returns the value of the '<em><b>Template Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutine_TemplateVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableDeclaration> getTemplateVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Input Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration}.
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
	EList<VariableDeclaration> getInputVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Output Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutine_OutputVariableDeclarations()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<VariableDeclaration> getOutputVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>State Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutine_StateVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<VariableDeclaration> getStateVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Initialization Block</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialization Block</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialization Block</em>' containment reference.
	 * @see #setInitializationBlock(Block)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutine_InitializationBlock()
	 * @model containment="true"
	 * @generated
	 */
	Block getInitializationBlock();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.Subroutine#getInitializationBlock <em>Initialization Block</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialization Block</em>' containment reference.
	 * @see #getInitializationBlock()
	 * @generated
	 */
	void setInitializationBlock(Block value);

	/**
	 * Returns the value of the '<em><b>Computation Blocks</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.ComputationBlock}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computation Blocks</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computation Blocks</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutine_ComputationBlocks()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComputationBlock> getComputationBlocks();

} // Subroutine
