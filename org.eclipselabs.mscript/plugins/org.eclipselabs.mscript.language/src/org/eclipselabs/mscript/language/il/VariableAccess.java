/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.il.VariableAccess#getTarget <em>Target</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.VariableAccess#getStepIndex <em>Step Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.il.ILPackage#getVariableAccess()
 * @model abstract="true"
 * @generated
 */
public interface VariableAccess extends EObject {
	/**
	 * Returns the value of the '<em><b>Target</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Target</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Target</em>' reference.
	 * @see #setTarget(VariableDeclaration)
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getVariableAccess_Target()
	 * @model
	 * @generated
	 */
	VariableDeclaration getTarget();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.il.VariableAccess#getTarget <em>Target</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Target</em>' reference.
	 * @see #getTarget()
	 * @generated
	 */
	void setTarget(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Step Index</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Index</em>' attribute.
	 * @see #setStepIndex(int)
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getVariableAccess_StepIndex()
	 * @model
	 * @generated
	 */
	int getStepIndex();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.il.VariableAccess#getStepIndex <em>Step Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Index</em>' attribute.
	 * @see #getStepIndex()
	 * @generated
	 */
	void setStepIndex(int value);

} // VariableAccess
