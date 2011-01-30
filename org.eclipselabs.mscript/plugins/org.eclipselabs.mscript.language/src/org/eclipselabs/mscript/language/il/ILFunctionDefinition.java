/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il;

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
 *   <li>{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#isStateful <em>Stateful</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getTemplateVariableDeclarations <em>Template Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getInputVariableDeclarations <em>Input Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getOutputVariableDeclarations <em>Output Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getInstanceVariableDeclarations <em>Instance Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getInitializationCompound <em>Initialization Compound</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getComputationCompounds <em>Computation Compounds</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.il.ILPackage#getILFunctionDefinition()
 * @model
 * @generated
 */
public interface ILFunctionDefinition extends EObject {
	/**
	 * Returns the value of the '<em><b>Stateful</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Stateful</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Stateful</em>' attribute.
	 * @see #setStateful(boolean)
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getILFunctionDefinition_Stateful()
	 * @model required="true"
	 * @generated
	 */
	boolean isStateful();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#isStateful <em>Stateful</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Stateful</em>' attribute.
	 * @see #isStateful()
	 * @generated
	 */
	void setStateful(boolean value);

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getILFunctionDefinition_Name()
	 * @model required="true"
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Template Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.il.TemplateVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getILFunctionDefinition_TemplateVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<TemplateVariableDeclaration> getTemplateVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Input Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.il.InputVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getILFunctionDefinition_InputVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<InputVariableDeclaration> getInputVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Output Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.il.OutputVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Output Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getILFunctionDefinition_OutputVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<OutputVariableDeclaration> getOutputVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Instance Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.il.InstanceVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Instance Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Instance Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getILFunctionDefinition_InstanceVariableDeclarations()
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
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getILFunctionDefinition_InitializationCompound()
	 * @model containment="true"
	 * @generated
	 */
	Compound getInitializationCompound();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.il.ILFunctionDefinition#getInitializationCompound <em>Initialization Compound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialization Compound</em>' containment reference.
	 * @see #getInitializationCompound()
	 * @generated
	 */
	void setInitializationCompound(Compound value);

	/**
	 * Returns the value of the '<em><b>Computation Compounds</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.il.ComputationCompound}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computation Compounds</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computation Compounds</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getILFunctionDefinition_ComputationCompounds()
	 * @model containment="true"
	 * @generated
	 */
	EList<ComputationCompound> getComputationCompounds();

} // ILFunction
