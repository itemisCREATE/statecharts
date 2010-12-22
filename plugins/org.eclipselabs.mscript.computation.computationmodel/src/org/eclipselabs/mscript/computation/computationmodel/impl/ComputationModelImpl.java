/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.computation.computationmodel.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.EObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModelPackage;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormatMapping;
import org.eclipselabs.mscript.computation.computationmodel.internal.operations.ComputationModelOperations;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Computation Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelImpl#getNumberFormats <em>Number Formats</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.computation.computationmodel.impl.ComputationModelImpl#getNumberFormatMappings <em>Number Format Mappings</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ComputationModelImpl extends EObjectImpl implements ComputationModel {
	/**
	 * The cached value of the '{@link #getNumberFormats() <em>Number Formats</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberFormats()
	 * @generated
	 * @ordered
	 */
	protected EList<NumberFormat> numberFormats;

	/**
	 * The cached value of the '{@link #getNumberFormatMappings() <em>Number Format Mappings</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNumberFormatMappings()
	 * @generated
	 * @ordered
	 */
	protected EList<NumberFormatMapping> numberFormatMappings;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComputationModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ComputationModelPackage.Literals.COMPUTATION_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NumberFormat> getNumberFormats() {
		if (numberFormats == null) {
			numberFormats = new EObjectContainmentEList<NumberFormat>(NumberFormat.class, this, ComputationModelPackage.COMPUTATION_MODEL__NUMBER_FORMATS);
		}
		return numberFormats;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<NumberFormatMapping> getNumberFormatMappings() {
		if (numberFormatMappings == null) {
			numberFormatMappings = new EObjectContainmentEList<NumberFormatMapping>(NumberFormatMapping.class, this, ComputationModelPackage.COMPUTATION_MODEL__NUMBER_FORMAT_MAPPINGS);
		}
		return numberFormatMappings;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NumberFormat getNumberFormat(DataType dataType) {
		return ComputationModelOperations.getNumberFormat(this, dataType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ComputationModelPackage.COMPUTATION_MODEL__NUMBER_FORMATS:
				return ((InternalEList<?>)getNumberFormats()).basicRemove(otherEnd, msgs);
			case ComputationModelPackage.COMPUTATION_MODEL__NUMBER_FORMAT_MAPPINGS:
				return ((InternalEList<?>)getNumberFormatMappings()).basicRemove(otherEnd, msgs);
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
			case ComputationModelPackage.COMPUTATION_MODEL__NUMBER_FORMATS:
				return getNumberFormats();
			case ComputationModelPackage.COMPUTATION_MODEL__NUMBER_FORMAT_MAPPINGS:
				return getNumberFormatMappings();
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
			case ComputationModelPackage.COMPUTATION_MODEL__NUMBER_FORMATS:
				getNumberFormats().clear();
				getNumberFormats().addAll((Collection<? extends NumberFormat>)newValue);
				return;
			case ComputationModelPackage.COMPUTATION_MODEL__NUMBER_FORMAT_MAPPINGS:
				getNumberFormatMappings().clear();
				getNumberFormatMappings().addAll((Collection<? extends NumberFormatMapping>)newValue);
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
			case ComputationModelPackage.COMPUTATION_MODEL__NUMBER_FORMATS:
				getNumberFormats().clear();
				return;
			case ComputationModelPackage.COMPUTATION_MODEL__NUMBER_FORMAT_MAPPINGS:
				getNumberFormatMappings().clear();
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
			case ComputationModelPackage.COMPUTATION_MODEL__NUMBER_FORMATS:
				return numberFormats != null && !numberFormats.isEmpty();
			case ComputationModelPackage.COMPUTATION_MODEL__NUMBER_FORMAT_MAPPINGS:
				return numberFormatMappings != null && !numberFormatMappings.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //ComputationModelImpl
