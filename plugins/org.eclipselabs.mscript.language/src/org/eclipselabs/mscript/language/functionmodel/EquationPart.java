/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.functionmodel;

import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.FeatureCall;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Equation Part</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.EquationPart#getSide <em>Side</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.EquationPart#getFeatureCall <em>Feature Call</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.functionmodel.EquationPart#getVariableReference <em>Variable Reference</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquationPart()
 * @model
 * @generated
 */
public interface EquationPart extends EObject {
	/**
	 * Returns the value of the '<em><b>Side</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.EquationSide#getParts <em>Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Side</em>' container reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Side</em>' container reference.
	 * @see #setSide(EquationSide)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquationPart_Side()
	 * @see org.eclipselabs.mscript.language.functionmodel.EquationSide#getParts
	 * @model opposite="parts" transient="false"
	 * @generated
	 */
	EquationSide getSide();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.EquationPart#getSide <em>Side</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Side</em>' container reference.
	 * @see #getSide()
	 * @generated
	 */
	void setSide(EquationSide value);

	/**
	 * Returns the value of the '<em><b>Variable Reference</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.functionmodel.VariableReference#getUsingEquationParts <em>Using Equation Parts</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Variable Reference</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Reference</em>' reference.
	 * @see #setVariableReference(VariableReference)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquationPart_VariableReference()
	 * @see org.eclipselabs.mscript.language.functionmodel.VariableReference#getUsingEquationParts
	 * @model opposite="usingEquationParts" required="true"
	 * @generated
	 */
	VariableReference getVariableReference();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.EquationPart#getVariableReference <em>Variable Reference</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Reference</em>' reference.
	 * @see #getVariableReference()
	 * @generated
	 */
	void setVariableReference(VariableReference value);

	/**
	 * Returns the value of the '<em><b>Feature Call</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feature Call</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feature Call</em>' reference.
	 * @see #setFeatureCall(FeatureCall)
	 * @see org.eclipselabs.mscript.language.functionmodel.FunctionModelPackage#getEquationPart_FeatureCall()
	 * @model required="true"
	 * @generated
	 */
	FeatureCall getFeatureCall();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.functionmodel.EquationPart#getFeatureCall <em>Feature Call</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Feature Call</em>' reference.
	 * @see #getFeatureCall()
	 * @generated
	 */
	void setFeatureCall(FeatureCall value);

} // EquationPart
