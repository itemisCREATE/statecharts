/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.il.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.il.ComputationCompound;
import org.eclipselabs.mscript.language.il.ILPackage;
import org.eclipselabs.mscript.language.il.InputVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.InputVariableDeclarationImpl#getFeedingCompounds <em>Feeding Compounds</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.language.il.impl.InputVariableDeclarationImpl#isDirectFeedthrough <em>Direct Feedthrough</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InputVariableDeclarationImpl extends StatefulVariableDeclarationImpl implements InputVariableDeclaration {
	/**
	 * The cached value of the '{@link #getFeedingCompounds() <em>Feeding Compounds</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFeedingCompounds()
	 * @generated
	 * @ordered
	 */
	protected EList<ComputationCompound> feedingCompounds;

	/**
	 * The default value of the '{@link #isDirectFeedthrough() <em>Direct Feedthrough</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isDirectFeedthrough()
	 * @generated
	 * @ordered
	 */
	protected static final boolean DIRECT_FEEDTHROUGH_EDEFAULT = false;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected InputVariableDeclarationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ILPackage.Literals.INPUT_VARIABLE_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputationCompound> getFeedingCompounds() {
		if (feedingCompounds == null) {
			feedingCompounds = new EObjectWithInverseResolvingEList.ManyInverse<ComputationCompound>(ComputationCompound.class, this, ILPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS, ILPackage.COMPUTATION_COMPOUND__INPUTS);
		}
		return feedingCompounds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isDirectFeedthrough() {
		for (ComputationCompound compound : getFeedingCompounds()) {
			if (!compound.getOutputs().isEmpty()) {
				return true;
			}
		}
		return false;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ILPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getFeedingCompounds()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ILPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS:
				return ((InternalEList<?>)getFeedingCompounds()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ILPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS:
				return getFeedingCompounds();
			case ILPackage.INPUT_VARIABLE_DECLARATION__DIRECT_FEEDTHROUGH:
				return isDirectFeedthrough();
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
			case ILPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS:
				getFeedingCompounds().clear();
				getFeedingCompounds().addAll((Collection<? extends ComputationCompound>)newValue);
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
			case ILPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS:
				getFeedingCompounds().clear();
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
			case ILPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS:
				return feedingCompounds != null && !feedingCompounds.isEmpty();
			case ILPackage.INPUT_VARIABLE_DECLARATION__DIRECT_FEEDTHROUGH:
				return isDirectFeedthrough() != DIRECT_FEEDTHROUGH_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

} //InputVariableDeclarationImpl
