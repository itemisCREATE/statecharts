/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.internal.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Real Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.RealType#evaluate(org.eclipselabs.mscript.typesystem.OperatorKind, org.eclipselabs.mscript.typesystem.DataType) <em>Evaluate</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.RealType#evaluatePower(int) <em>Evaluate Power</em>}</li>
 *   <li>{@link org.eclipselabs.mscript.typesystem.RealType#isAssignableFrom(org.eclipselabs.mscript.typesystem.DataType) <em>Is Assignable From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RealTypeOperations extends PrimitiveTypeOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RealTypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  DataType evaluate(RealType realType, OperatorKind operator, DataType other) {
		if (operator == OperatorKind.UNARY_MINUS) {
			return (RealType) EcoreUtil.copy(realType);
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
		case ADD:
		case SUBTRACT:
			if (!EcoreUtil.equals(realType.getUnit(), otherNumericType.getUnit())) {
				return TypeSystemFactory.eINSTANCE.createInvalidDataType();
			}
			unit = (Unit) EcoreUtil.copy(realType.getUnit());
			break;
		case MULTIPLY:
			unit = realType.getUnit().multiply(otherNumericType.getUnit());
			break;
		case DIVIDE:
			unit = realType.getUnit().divide(otherNumericType.getUnit());
			break;
		default:
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		
		NumericType result = TypeSystemFactory.eINSTANCE.createRealType();
		result.setUnit(unit);
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  DataType evaluatePower(RealType realType, int exponent) {
		RealType result = TypeSystemFactory.eINSTANCE.createRealType();
		result.setUnit(realType.getUnit().power(exponent));
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean isAssignableFrom(RealType realType, DataType other) {
		if (other instanceof NumericType) {
			NumericType otherNumericType = (NumericType) other;
			return !realType.isSetUnit() || realType.getUnit().isSameAs(otherNumericType.getUnit(), false);
		}
		return false;
	}

} // RealTypeOperations