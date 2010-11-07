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
 * A representation of the model object '<em><b>Variable Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getFunction <em>Function</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getName <em>Name</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getKind <em>Kind</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getSteps <em>Steps</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableReference()
 * @model
 * @generated
 */
public interface VariableReference extends EObject {
	/**
	 * Returns the value of the '<em><b>Function</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.Function#getVariableReferences <em>Variable References</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Function</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Function</em>' container reference.
	 * @see #setFunction(Function)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableReference_Function()
	 * @see org.eclipselabs.mscript.language.functionmodel.Function#getVariableReferences
	 * @model opposite="variableReferences" required="true" transient="false"
	 * @generated
	 */
	Function getFunction();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getFunction <em>Function</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Function</em>' container reference.
	 * @see #getFunction()
	 * @generated
	 */
	void setFunction(Function value);

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
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableReference_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getName <em>Name</em>}' attribute.
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
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableReference_Kind()
	 * @model
	 * @generated
	 */
	VariableKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(VariableKind value);

	/**
	 * Returns the value of the '<em><b>Steps</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.functionmodel.VariableStep}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.VariableStep#getReference <em>Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Steps</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Steps</em>' reference list.
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableReference_Steps()
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableStep#getReference
	 * @model opposite="reference"
	 * @generated
	 */
	EList<VariableStep> getSteps();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model indexRequired="true" initialRequired="true"
	 * @generated
	 */
	VariableStep getStep(int index, boolean initial);

} // VariableReference
