/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel;

import org.eclipse.emf.common.util.EList;
import org.eclipselabs.mscript.language.ast.Expression;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Variable Reference</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.VariableReference#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.VariableReference#getStepIndex <em>Step Index</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.VariableReference#getArrayIndices <em>Array Indices</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getVariableReference()
 * @model
 * @generated
 */
public interface VariableReference extends Expression {
	/**
	 * Returns the value of the '<em><b>Declaration</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Declaration</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Declaration</em>' reference.
	 * @see #setDeclaration(VariableDeclaration)
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getVariableReference_Declaration()
	 * @model required="true"
	 * @generated
	 */
	VariableDeclaration getDeclaration();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.VariableReference#getDeclaration <em>Declaration</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Declaration</em>' reference.
	 * @see #getDeclaration()
	 * @generated
	 */
	void setDeclaration(VariableDeclaration value);

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
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getVariableReference_StepIndex()
	 * @model default="0"
	 * @generated
	 */
	int getStepIndex();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.VariableReference#getStepIndex <em>Step Index</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Step Index</em>' attribute.
	 * @see #getStepIndex()
	 * @generated
	 */
	void setStepIndex(int value);

	/**
	 * Returns the value of the '<em><b>Array Indices</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.Expression}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Array Indices</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Array Indices</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getVariableReference_ArrayIndices()
	 * @model containment="true"
	 * @generated
	 */
	EList<Expression> getArrayIndices();

} // VariableReference
