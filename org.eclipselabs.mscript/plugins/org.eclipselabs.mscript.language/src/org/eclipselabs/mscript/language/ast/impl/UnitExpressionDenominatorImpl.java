/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.language.ast.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;
import org.eclipselabs.mscript.language.ast.AstPackage;
import org.eclipselabs.mscript.language.ast.UnitExpressionDenominator;
import org.eclipselabs.mscript.language.ast.UnitExpressionFactor;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Unit Expression Denominator</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.language.ast.impl.UnitExpressionDenominatorImpl#getFactors <em>Factors</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitExpressionDenominatorImpl extends MinimalEObjectImpl.Container implements UnitExpressionDenominator {
	/**
	 * The cached value of the '{@link #getFactors() <em>Factors</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFactors()
	 * @generated
	 * @ordered
	 */
	protected EList<UnitExpressionFactor> factors;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitExpressionDenominatorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return AstPackage.Literals.UNIT_EXPRESSION_DENOMINATOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<UnitExpressionFactor> getFactors() {
		if (factors == null) {
			factors = new EObjectContainmentEList<UnitExpressionFactor>(UnitExpressionFactor.class, this, AstPackage.UNIT_EXPRESSION_DENOMINATOR__FACTORS);
		}
		return factors;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case AstPackage.UNIT_EXPRESSION_DENOMINATOR__FACTORS:
				return ((InternalEList<?>)getFactors()).basicRemove(otherEnd, msgs);
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
			case AstPackage.UNIT_EXPRESSION_DENOMINATOR__FACTORS:
				return getFactors();
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
			case AstPackage.UNIT_EXPRESSION_DENOMINATOR__FACTORS:
				getFactors().clear();
				getFactors().addAll((Collection<? extends UnitExpressionFactor>)newValue);
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
			case AstPackage.UNIT_EXPRESSION_DENOMINATOR__FACTORS:
				getFactors().clear();
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
			case AstPackage.UNIT_EXPRESSION_DENOMINATOR__FACTORS:
				return factors != null && !factors.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //UnitExpressionDenominatorImpl
