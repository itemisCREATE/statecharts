/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.internal.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Integer Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.IntegerType#evaluate(org.eclipselabs.mscript.typesystem.OperatorKind, org.eclipselabs.mscript.typesystem.DataType) <em>Evaluate</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.IntegerType#evaluatePower(int) <em>Evaluate Power</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.IntegerType#isAssignableFrom(org.eclipselabs.mscript.typesystem.DataType) <em>Is Assignable From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntegerTypeOperations extends PrimitiveTypeOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IntegerTypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  DataType evaluate(IntegerType integerType, OperatorKind operator, DataType other) {
		if (operator == OperatorKind.UNARY_MINUS) {
			return EcoreUtil.copy(integerType);
		}
		
		if (!(other instanceof NumericType)) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		NumericType otherNumericType = (NumericType) other;

		Unit unit;
		switch (operator) {
		case LESS_THAN:
		case LESS_THAN_OR_EQUAL_TO:
		case GREATER_THAN:
		case GREATER_THAN_OR_EQUAL_TO:
		case EQUAL_TO:
		case NOT_EQUAL_TO:
			return TypeSystemFactory.eINSTANCE.createBooleanType();
		case ADDITION:
		case SUBTRACTION:
			if (!EcoreUtil.equals(integerType.getUnit(), otherNumericType.getUnit())) {
				return TypeSystemFactory.eINSTANCE.createInvalidDataType();
			}
			unit = EcoreUtil.copy(integerType.getUnit());
			break;
		case MULTIPLICATION:
			unit = integerType.getUnit().multiply(otherNumericType.getUnit());
			break;
		case DIVISION:
			unit = integerType.getUnit().divide(otherNumericType.getUnit());
			break;
		default:
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		
		NumericType result;
		if (otherNumericType instanceof IntegerType && operator != OperatorKind.DIVISION) {
			result = TypeSystemFactory.eINSTANCE.createIntegerType();
		} else {
			result = TypeSystemFactory.eINSTANCE.createRealType();
		}
		result.setUnit(unit);
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  DataType evaluatePower(IntegerType integerType, int exponent) {
		IntegerType result = TypeSystemFactory.eINSTANCE.createIntegerType();
		result.setUnit(integerType.getUnit().power(exponent));
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean isAssignableFrom(IntegerType integerType, DataType other) {
		if (other instanceof IntegerType) {
			IntegerType otherIntegerType = (IntegerType) other;
			return !integerType.isSetUnit() || integerType.getUnit().isSameAs(otherIntegerType.getUnit(), false);
		}
		return false;
	}

} // IntegerTypeOperations