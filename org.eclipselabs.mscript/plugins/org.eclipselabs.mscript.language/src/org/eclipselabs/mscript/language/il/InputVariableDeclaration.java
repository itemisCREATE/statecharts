/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il;

import org.eclipse.emf.common.util.EList;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Input Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.il.InputVariableDeclaration#getFeedingCompounds <em>Feeding Compounds</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.InputVariableDeclaration#isDirectFeedthrough <em>Direct Feedthrough</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.il.ILPackage#getInputVariableDeclaration()
 * @model
 * @generated
 */
public interface InputVariableDeclaration extends StatefulVariableDeclaration {

	/**
	 * Returns the value of the '<em><b>Feeding Compounds</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.il.ComputationCompound}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.il.ComputationCompound#getInputs <em>Inputs</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Feeding Compounds</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Feeding Compounds</em>' reference list.
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getInputVariableDeclaration_FeedingCompounds()
	 * @see org.eclipselabs.mscript.language.il.ComputationCompound#getInputs
	 * @model opposite="inputs"
	 * @generated
	 */
	EList<ComputationCompound> getFeedingCompounds();

	/**
	 * Returns the value of the '<em><b>Direct Feedthrough</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Direct Feedthrough</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Direct Feedthrough</em>' attribute.
	 * @see org.eclipselabs.mscript.language.il.ILPackage#getInputVariableDeclaration_DirectFeedthrough()
	 * @model required="true" transient="true" changeable="false" volatile="true" derived="true"
	 * @generated
	 */
	boolean isDirectFeedthrough();
} // InputVariableDeclaration
