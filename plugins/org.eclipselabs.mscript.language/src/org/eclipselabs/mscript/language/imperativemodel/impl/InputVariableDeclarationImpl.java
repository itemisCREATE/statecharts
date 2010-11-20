/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.imperativemodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.imperativemodel.ComputationCompound;
import org.eclipselabs.mscript.language.imperativemodel.ImperativeModelPackage;
import org.eclipselabs.mscript.language.imperativemodel.InputVariableDeclaration;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Input Variable Declaration</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.imperativemodel.impl.InputVariableDeclarationImpl#getFeedingCompounds <em>Feeding Compounds</em>}</li>
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
		return ImperativeModelPackage.Literals.INPUT_VARIABLE_DECLARATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ComputationCompound> getFeedingCompounds() {
		if (feedingCompounds == null) {
			feedingCompounds = new EObjectWithInverseResolvingEList.ManyInverse<ComputationCompound>(ComputationCompound.class, this, ImperativeModelPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS, ImperativeModelPackage.COMPUTATION_COMPOUND__INPUTS);
		}
		return feedingCompounds;
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
			case ImperativeModelPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS:
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
			case ImperativeModelPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS:
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
			case ImperativeModelPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS:
				return getFeedingCompounds();
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
			case ImperativeModelPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS:
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
			case ImperativeModelPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS:
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
			case ImperativeModelPackage.INPUT_VARIABLE_DECLARATION__FEEDING_COMPOUNDS:
				return feedingCompounds != null && !feedingCompounds.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //InputVariableDeclarationImpl
