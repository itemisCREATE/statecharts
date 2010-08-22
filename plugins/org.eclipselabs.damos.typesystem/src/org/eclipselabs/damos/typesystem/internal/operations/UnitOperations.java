/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem.internal.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.typesystem.Unit;
import org.eclipselabs.damos.typesystem.UnitFactor;
import org.eclipselabs.damos.typesystem.UnitSymbol;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Unit</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.Unit#getFactor(org.eclipselabs.damos.typesystem.UnitSymbol) <em>Get Factor</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.Unit#multiply(org.eclipselabs.damos.typesystem.Unit) <em>Multiply</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.Unit#divide(org.eclipselabs.damos.typesystem.Unit) <em>Divide</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.Unit#power(int) <em>Power</em>}</li>
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
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  Unit multiply(Unit unit, Unit other) {
		Unit result = (Unit) EcoreUtil.copy(unit);
		result.setScale(result.getScale() + other.getScale());
		for (UnitFactor otherFactor : other.getFactors()) {
			UnitFactor factor = result.getFactor(otherFactor.getSymbol());
			if (factor != null) {
				factor.setExponent(factor.getExponent() + otherFactor.getExponent());
			} else {
				factor = (UnitFactor) EcoreUtil.copy(otherFactor);
				result.getFactors().add(factor);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  Unit divide(Unit unit, Unit other) {
		Unit result = (Unit) EcoreUtil.copy(unit);
		result.setScale(result.getScale() - other.getScale());
		for (UnitFactor otherFactor : other.getFactors()) {
			UnitFactor factor = result.getFactor(otherFactor.getSymbol());
			if (factor != null) {
				factor.setExponent(factor.getExponent() - otherFactor.getExponent());
			} else {
				factor = (UnitFactor) EcoreUtil.copy(otherFactor);
				factor.setExponent(-factor.getExponent());
				result.getFactors().add(factor);
			}
		}
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  Unit power(Unit unit, int exponent) {
		Unit result = (Unit) EcoreUtil.copy(unit);
		result.setScale(result.getScale() * exponent);
		for (UnitFactor factor : result.getFactors()) {
			factor.setExponent(factor.getExponent() * exponent);
		}
		return result;
	}

} // UnitOperations