/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Computation Compound</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.ComputationCompound#getInputs <em>Inputs</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.ComputationCompound#getOutputs <em>Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getComputationCompound()
 * @model
 * @generated
 */
public interface ComputationCompound extends Compound {
	/**
	 * Returns the value of the '<em><b>Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration}.
	 * It is bidirectional and its opposite is '{@link org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration#getFeedingCompounds <em>Feeding Compounds</em>}'.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Inputs</em>' reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getComputationCompound_Inputs()
	 * @see org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration#getFeedingCompounds
	 * @model opposite="feedingCompounds"
	 * @generated
	 */
	EList<InputVariableDeclaration> getInputs();

	/**
	 * Returns the value of the '<em><b>Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.OutputVariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Outputs</em>' reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getComputationCompound_Outputs()
	 * @model
	 * @generated
	 */
	EList<OutputVariableDeclaration> getOutputs();

} // ComputationCompound
