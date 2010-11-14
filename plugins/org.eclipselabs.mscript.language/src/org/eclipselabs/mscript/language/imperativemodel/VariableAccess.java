/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel;

import org.eclipselabs.mscript.language.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Access</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.VariableAccess#getAccessedDeclaration <em>Accessed Declaration</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.VariableAccess#getStepIndex <em>Step Index</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getVariableAccess()
 * @model
 * @generated
 */
public interface VariableAccess extends Expression {
	/**
	 * Returns the value of the '<em><b>Accessed Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Accessed Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Accessed Declaration</em>' reference.
	 * @see #setAccessedDeclaration(VariableDeclaration)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getVariableAccess_AccessedDeclaration()
	 * @model required="true"
	 * @generated
	 */
	VariableDeclaration getAccessedDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.VariableAccess#getAccessedDeclaration <em>Accessed Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Accessed Declaration</em>' reference.
	 * @see #getAccessedDeclaration()
	 * @generated
	 */
	void setAccessedDeclaration(VariableDeclaration value);

	/**
	 * Returns the value of the '<em><b>Step Index</b></em>' attribute.
	 * The default value is <code>"0"</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Step Index</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Step Index</em>' attribute.
	 * @see #setStepIndex(int)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getVariableAccess_StepIndex()
	 * @model default="0"
	 * @generated
	 */
	int getStepIndex();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.VariableAccess#getStepIndex <em>Step Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Index</em>' attribute.
	 * @see #getStepIndex()
	 * @generated
	 */
	void setStepIndex(int value);

} // VariableAccess
