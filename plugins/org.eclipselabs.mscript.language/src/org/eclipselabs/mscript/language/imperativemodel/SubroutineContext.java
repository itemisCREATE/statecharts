/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipselabs.mscript.language.ast.StateVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Subroutine Context</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getTemplateVariableDeclarations <em>Template Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getStateVariableDeclarations <em>State Variable Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getCircularBufferDeclarations <em>Circular Buffer Declarations</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getInitializationCompound <em>Initialization Compound</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutineContext()
 * @model
 * @generated
 */
public interface SubroutineContext extends EObject {
	/**
	 * Returns the value of the '<em><b>Template Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.TemplateVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Template Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Template Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutineContext_TemplateVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<TemplateVariableDeclaration> getTemplateVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>State Variable Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.ast.StateVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>State Variable Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>State Variable Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutineContext_StateVariableDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<StateVariableDeclaration> getStateVariableDeclarations();

	/**
	 * Returns the value of the '<em><b>Circular Buffer Declarations</b></em>' containment reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.CircularBufferDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Circular Buffer Declarations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Circular Buffer Declarations</em>' containment reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutineContext_CircularBufferDeclarations()
	 * @model containment="true"
	 * @generated
	 */
	EList<CircularBufferDeclaration> getCircularBufferDeclarations();

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
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getSubroutineContext_InitializationCompound()
	 * @model containment="true"
	 * @generated
	 */
	Compound getInitializationCompound();

	/**
	 * Sets the value of the '{@link org.eclipselabs.mscript.language.imperativemodel.SubroutineContext#getInitializationCompound <em>Initialization Compound</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Initialization Compound</em>' containment reference.
	 * @see #getInitializationCompound()
	 * @generated
	 */
	void setInitializationCompound(Compound value);

} // SubroutineContext
