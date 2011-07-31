/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Descriptor</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getFunctionDescriptor <em>Function Descriptor</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getSteps <em>Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableDescriptor()
 * @model
 * @generated
 */
public interface VariableDescriptor extends EObject {
	/**
	 * Returns the value of the '<em><b>Function Descriptor</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor#getVariableDescriptors <em>Variable Descriptors</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function Descriptor</em>' container reference.
	 * @see #setFunctionDescriptor(FunctionDescriptor)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableDescriptor_FunctionDescriptor()
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionDescriptor#getVariableDescriptors
	 * @model opposite="variableDescriptors" required="true" transient="false"
	 * @generated
	 */
	FunctionDescriptor getFunctionDescriptor();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getFunctionDescriptor <em>Function Descriptor</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function Descriptor</em>' container reference.
	 * @see #getFunctionDescriptor()
	 * @generated
	 */
	void setFunctionDescriptor(FunctionDescriptor value);

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
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableDescriptor_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Kind</b></em>' attribute.
	 * The literals are from the enumeration {@link org.eclipselabs.mscript.language.functionmodel.VariableKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableKind
	 * @see #setKind(VariableKind)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableDescriptor_Kind()
	 * @model
	 * @generated
	 */
	VariableKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.VariableDescriptor#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(VariableKind value);

	/**
	 * Returns the value of the '<em><b>Steps</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.functionmodel.VariableStep}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.VariableStep#getDescriptor <em>Descriptor</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableDescriptor_Steps()
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableStep#getDescriptor
	 * @model opposite="descriptor" containment="true"
	 * @generated
	 */
	EList<VariableStep> getSteps();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model indexRequired="true" initialRequired="true" derivativeRequired="true"
	 * @generated
	 */
	VariableStep getStep(int index, boolean initial, boolean derivative);

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	VariableStep getMinimumStep();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation" required="true"
	 * @generated
	 */
	VariableStep getMaximumStep();

} // VariableDescriptor
