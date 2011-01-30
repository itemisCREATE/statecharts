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
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor#getDefinition <em>Definition</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor#getEquationDescriptors <em>Equation Descriptors</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor#getVariableDescriptors <em>Variable Descriptors</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getFunctionDescriptor()
 * @model
 * @generated
 */
public interface FunctionDescriptor extends EObject {
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
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getFunctionDescriptor_Definition()
	 * @model required="true"
	 * @generated
	 */
	FunctionDefinition getDefinition();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor#getDefinition <em>Definition</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Definition</em>' reference.
	 * @see #getDefinition()
	 * @generated
	 */
	void setDefinition(FunctionDefinition value);

	/**
	 * Returns the value of the '<em><b>Equation Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.functionmodel.EquationDescriptor}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.EquationDescriptor#getFunctionDescriptor <em>Function Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Equations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Equation Descriptors</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getFunctionDescriptor_EquationDescriptors()
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationDescriptor#getFunctionDescriptor
	 * @model opposite="functionDescriptor" containment="true"
	 * @generated
	 */
	EList<EquationDescriptor> getEquationDescriptors();

	/**
	 * Returns the value of the '<em><b>Variable Descriptors</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getFunctionDescriptor <em>Function Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Descriptors</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Descriptors</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getFunctionDescriptor_VariableDescriptors()
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getFunctionDescriptor
	 * @model opposite="functionDescriptor" containment="true"
	 * @generated
	 */
	EList<VariableDescriptor> getVariableDescriptors();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model nameRequired="true"
	 * @generated
	 */
	VariableDescriptor getVariableDescriptor(String name);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean hasNoDuplicateEquations(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean hasNoCyclicEquations(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean hasEquationsForEachOutput(DiagnosticChain diagnostics, Map<Object, Object> context);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true"
	 * @generated
	 */
	boolean hasEquationsForEachVariableStep(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Function
