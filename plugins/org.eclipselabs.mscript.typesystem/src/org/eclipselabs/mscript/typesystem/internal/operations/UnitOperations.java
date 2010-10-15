/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.internal.operations;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.UnitFactor;
import org.eclipselabs.mscript.typesystem.UnitSymbol;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Unit</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.Unit#getFactor(org.eclipselabs.mscript.typesystem.UnitSymbol) <em>Get Factor</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.Unit#multiply(org.eclipselabs.mscript.typesystem.Unit) <em>Multiply</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.Unit#divide(org.eclipselabs.mscript.typesystem.Unit) <em>Divide</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.Unit#power(int) <em>Power</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.Unit#isSameAs(org.eclipselabs.mscript.typesystem.Unit, boolean) <em>Is Same As</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  UnitFactor getFactor(Unit unit, UnitSymbol symbol) {
		for (UnitFactor factor : unit.getFactors()) {
			if (factor.getSymbol() == symbol) {
				return factor;
			}
		}
		throw new IllegalArgumentException();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  Unit multiply(Unit unit, Unit other) {
		Unit result = EcoreUtil.copy(unit);
		result.setScale(result.getScale() + other.getScale());
		for (UnitFactor otherFactor : other.getFactors()) {
			UnitFactor factor = result.getFactor(otherFactor.getSymbol());
			factor.setExponent(factor.getExponent() + otherFactor.getExponent());
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  Unit divide(Unit unit, Unit other) {
		Unit result = EcoreUtil.copy(unit);
		result.setScale(result.getScale() - other.getScale());
		for (UnitFactor otherFactor : other.getFactors()) {
			UnitFactor factor = result.getFactor(otherFactor.getSymbol());
			factor.setExponent(factor.getExponent() - otherFactor.getExponent());
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  Unit power(Unit unit, int exponent) {
		Unit result = EcoreUtil.copy(unit);
		result.setScale(result.getScale() * exponent);
		for (UnitFactor factor : result.getFactors()) {
			factor.setExponent(factor.getExponent() * exponent);
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	@SuppressWarnings("unchecked")
	public static  boolean isSameAs(Unit unit, Unit other, boolean ignoreScale) {
		if (ignoreScale) {
			return new EqualityHelper().equals(
					(List<EObject>) (List<?>) unit.getFactors(),
					(List<EObject>) (List<?>) other.getFactors());
		}
		return EcoreUtil.equals(unit, other); 
	}

} // UnitOperations