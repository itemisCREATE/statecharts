/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem.internal.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.IntegerType;
import org.eclipselabs.damos.typesystem.NumericalType;
import org.eclipselabs.damos.typesystem.OperatorKind;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;
import org.eclipselabs.damos.typesystem.Unit;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Integer Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.IntegerType#evaluate(org.eclipselabs.damos.typesystem.OperatorKind, org.eclipselabs.damos.typesystem.DataType) <em>Evaluate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IntegerTypeOperations extends DataTypeOperations {
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
			return (IntegerType) EcoreUtil.copy(integerType);
		}
		
		if (!(other instanceof NumericalType)) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		NumericalType otherNumericalType = (NumericalType) other;

		Unit unit;
		switch (operator) {
		case ADD:
		case SUBTRACT:
			if (!EcoreUtil.equals(integerType.getUnit(), otherNumericalType.getUnit())) {
				return TypeSystemFactory.eINSTANCE.createInvalidDataType();
			}
			unit = (Unit) EcoreUtil.copy(integerType.getUnit());
			break;
		case MULTIPLY:
			unit = integerType.getUnit().multiply(otherNumericalType.getUnit());
			break;
		case DIVIDE:
			unit = integerType.getUnit().divide(otherNumericalType.getUnit());
			break;
		default:
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		
		NumericalType result;
		if (otherNumericalType instanceof IntegerType && operator != OperatorKind.DIVIDE) {
			result = TypeSystemFactory.eINSTANCE.createIntegerType();
		} else {
			result = TypeSystemFactory.eINSTANCE.createRealType();
		}
		result.setUnit(unit);
		
		return result;
	}

} // IntegerTypeOperations