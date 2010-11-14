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
 * A representation of the model object '<em><b>Computation Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.ComputationBlock#getUsedInputs <em>Used Inputs</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.ComputationBlock#getComputedOutputs <em>Computed Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getComputationBlock()
 * @model
 * @generated
 */
public interface ComputationBlock extends Block {
	/**
	 * Returns the value of the '<em><b>Used Inputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Used Inputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Used Inputs</em>' reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getComputationBlock_UsedInputs()
	 * @model
	 * @generated
	 */
	EList<VariableDeclaration> getUsedInputs();

	/**
	 * Returns the value of the '<em><b>Computed Outputs</b></em>' reference list.
	 * The list contents are of type {@link org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Computed Outputs</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Computed Outputs</em>' reference list.
	 * @see org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage#getComputationBlock_ComputedOutputs()
	 * @model
	 * @generated
	 */
	EList<VariableDeclaration> getComputedOutputs();

} // ComputationBlock
