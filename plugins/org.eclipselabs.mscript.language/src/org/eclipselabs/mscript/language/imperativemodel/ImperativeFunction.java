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
 * A representation of the model object '<em><b>Imperative Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.ImperativeFunction#getConstantDeclarations <em>Constant Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.ImperativeFunction#getInputVariableDeclarations <em>Input Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.ImperativeFunction#getOutputVariableDeclarations <em>Output Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.ImperativeFunction#getInstanceVariableDeclarations <em>Instance Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.ImperativeFunction#getInitializationCompound <em>Initialization Compound</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.ImperativeFunction#getComputationCompounds <em>Computation Compounds</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getImperativeFunction()
 * @model
 * @generated
 */
public interface ImperativeFunction extends EObject {
	/**
	 * Returns the value of the '<em><b>Constant Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.ConstantDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Constant Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Constant Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getImperativeFunction_ConstantDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<ConstantDeclaration> getConstantDeclarations();

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
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getImperativeFunction_InputVariableDeclarations()
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
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getImperativeFunction_OutputVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputVariableDeclaration> getOutputVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Instance Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.InstanceVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getImperativeFunction_InstanceVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<InstanceVariableDeclaration> getInstanceVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Initialization Compound</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initialization Compound</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initialization Compound</em>' containment reference.
	 * @see #setInitializationCompound(Compound)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getImperativeFunction_InitializationCompound()
	 * @model containment="true"
	 * @generated
	 */
	Compound getInitializationCompound();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.ImperativeFunction#getInitializationCompound <em>Initialization Compound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialization Compound</em>' containment reference.
	 * @see #getInitializationCompound()
	 * @generated
	 */
	void setInitializationCompound(Compound value);

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
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getImperativeFunction_ComputationCompounds()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComputationCompound> getComputationCompounds();

} // ImperativeFunction
