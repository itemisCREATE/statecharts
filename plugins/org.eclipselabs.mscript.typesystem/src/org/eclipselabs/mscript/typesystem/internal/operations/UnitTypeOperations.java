/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.internal.operations;

import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.UnitType;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Unit Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.UnitType#evaluate(org.eclipselabs.mscript.typesystem.OperatorKind, org.eclipselabs.mscript.typesystem.DataType) <em>Evaluate</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.UnitType#evaluatePower(int) <em>Evaluate Power</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class UnitTypeOperations extends DataTypeOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnitTypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  DataType evaluate(UnitType unitType, OperatorKind operator, DataType other) {
		if (!(other instanceof UnitType)) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		switch (operator) {
		case MULTIPLY:
		case DIVIDE:
			return TypeSystemFactory.eINSTANCE.createUnitType();
		case EQUAL_TO:
		case NOT_EQUAL_TO:
			return TypeSystemFactory.eINSTANCE.createBooleanType();
		}
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  DataType evaluatePower(UnitType unitType, int exponent) {
		return TypeSystemFactory.eINSTANCE.createUnitType();
	}

} // UnitTypeOperations