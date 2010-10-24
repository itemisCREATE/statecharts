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
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getStep <em>Step</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#isInitial <em>Initial</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getUsingEquationParts <em>Using Equation Parts</em>}</li>
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
	 * The literals are from the enumeration {@link org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Kind</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Kind</em>' attribute.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind
	 * @see #setKind(VariableReferenceKind)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableReference_Kind()
	 * @model
	 * @generated
	 */
	VariableReferenceKind getKind();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getKind <em>Kind</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Kind</em>' attribute.
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReferenceKind
	 * @see #getKind()
	 * @generated
	 */
	void setKind(VariableReferenceKind value);

	/**
	 * Returns the value of the '<em><b>Step</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step</em>' attribute.
	 * @see #setStep(int)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableReference_Step()
	 * @model
	 * @generated
	 */
	int getStep();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getStep <em>Step</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step</em>' attribute.
	 * @see #getStep()
	 * @generated
	 */
	void setStep(int value);

	/**
	 * Returns the value of the '<em><b>Initial</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Initial</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Initial</em>' attribute.
	 * @see #setInitial(boolean)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableReference_Initial()
	 * @model
	 * @generated
	 */
	boolean isInitial();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#isInitial <em>Initial</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initial</em>' attribute.
	 * @see #isInitial()
	 * @generated
	 */
	void setInitial(boolean value);

	/**
	 * Returns the value of the '<em><b>Using Equation Parts</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.functionmodel.EquationPart}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.EquationPart#getVariableReference <em>Variable Reference</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Using Equation Parts</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Using Equation Parts</em>' reference list.
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getVariableReference_UsingEquationParts()
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationPart#getVariableReference
	 * @model opposite="variableReference"
	 * @generated
	 */
	EList<EquationPart> getUsingEquationParts();

} // VariableReference
