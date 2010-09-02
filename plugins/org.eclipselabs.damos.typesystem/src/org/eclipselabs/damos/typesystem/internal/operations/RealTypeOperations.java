/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem.internal.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.NumericalType;
import org.eclipselabs.damos.typesystem.OperatorKind;
import org.eclipselabs.damos.typesystem.RealType;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;
import org.eclipselabs.damos.typesystem.Unit;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Real Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.RealType#evaluate(org.eclipselabs.damos.typesystem.OperatorKind, org.eclipselabs.damos.typesystem.DataType) <em>Evaluate</em>}</li>
 *   <li>{@link org.eclipselabs.damos.typesystem.RealType#isAssignableFrom(org.eclipselabs.damos.typesystem.DataType) <em>Is Assignable From</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RealTypeOperations extends DataTypeOperations {
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
		
		if (!(other instanceof NumericalType)) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		NumericalType otherNumericalType = (NumericalType) other;

		Unit unit;
		switch (operator) {
		case ADD:
		case SUBTRACT:
			if (!EcoreUtil.equals(realType.getUnit(), otherNumericalType.getUnit())) {
				return TypeSystemFactory.eINSTANCE.createInvalidDataType();
			}
			unit = (Unit) EcoreUtil.copy(realType.getUnit());
			break;
		case MULTIPLY:
			unit = realType.getUnit().multiply(otherNumericalType.getUnit());
			break;
		case DIVIDE:
			unit = realType.getUnit().divide(otherNumericalType.getUnit());
			break;
		default:
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		
		NumericalType result = TypeSystemFactory.eINSTANCE.createRealType();
		result.setUnit(unit);
		
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  boolean isAssignableFrom(RealType realType, DataType other) {
		if (other instanceof NumericalType) {
			NumericalType otherNumericalType = (NumericalType) other;
			return realType.getUnit().isSameAs(otherNumericalType.getUnit(), false);
		}
		return false;
	}

} // RealTypeOperations