/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipselabs.mscript.language.imperativemodel.ComputationBlock;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.VariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computation Block</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.ComputationBlockImpl#getUsedInputs <em>Used Inputs</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.ComputationBlockImpl#getComputedOutputs <em>Computed Outputs</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputationBlockImpl extends BlockImpl implements ComputationBlock {
	/**
	 * The cached value of the '{@link #getUsedInputs() <em>Used Inputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUsedInputs()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclaration> usedInputs;

	/**
	 * The cached value of the '{@link #getComputedOutputs() <em>Computed Outputs</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComputedOutputs()
	 * @generated
	 * @ordered
	 */
	protected EList<VariableDeclaration> computedOutputs;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputationBlockImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ImperativeModelPackage.Literals.COMPUTATION_BLOCK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDeclaration> getUsedInputs() {
		if (usedInputs == null) {
			usedInputs = new EObjectResolvingEList<VariableDeclaration>(VariableDeclaration.class, this, ImperativeModelPackage.COMPUTATION_BLOCK__USED_INPUTS);
		}
		return usedInputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<VariableDeclaration> getComputedOutputs() {
		if (computedOutputs == null) {
			computedOutputs = new EObjectResolvingEList<VariableDeclaration>(VariableDeclaration.class, this, ImperativeModelPackage.COMPUTATION_BLOCK__COMPUTED_OUTPUTS);
		}
		return computedOutputs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ImperativeModelPackage.COMPUTATION_BLOCK__USED_INPUTS:
				return getUsedInputs();
			case ImperativeModelPackage.COMPUTATION_BLOCK__COMPUTED_OUTPUTS:
				return getComputedOutputs();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ImperativeModelPackage.COMPUTATION_BLOCK__USED_INPUTS:
				getUsedInputs().clear();
				getUsedInputs().addAll((Collection<? extends VariableDeclaration>)newValue);
				return;
			case ImperativeModelPackage.COMPUTATION_BLOCK__COMPUTED_OUTPUTS:
				getComputedOutputs().clear();
				getComputedOutputs().addAll((Collection<? extends VariableDeclaration>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ImperativeModelPackage.COMPUTATION_BLOCK__USED_INPUTS:
				getUsedInputs().clear();
				return;
			case ImperativeModelPackage.COMPUTATION_BLOCK__COMPUTED_OUTPUTS:
				getComputedOutputs().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ImperativeModelPackage.COMPUTATION_BLOCK__USED_INPUTS:
				return usedInputs != null && !usedInputs.isEmpty();
			case ImperativeModelPackage.COMPUTATION_BLOCK__COMPUTED_OUTPUTS:
				return computedOutputs != null && !computedOutputs.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComputationBlockImpl
