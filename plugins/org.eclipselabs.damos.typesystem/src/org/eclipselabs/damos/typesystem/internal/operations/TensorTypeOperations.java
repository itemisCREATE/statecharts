/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.damos.typesystem.internal.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.InvalidDataType;
import org.eclipselabs.damos.typesystem.NumericalType;
import org.eclipselabs.damos.typesystem.OperatorKind;
import org.eclipselabs.damos.typesystem.TensorType;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;
import org.eclipselabs.damos.typesystem.util.TypeSystemUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Tensor Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.damos.typesystem.TensorType#evaluate(org.eclipselabs.damos.typesystem.OperatorKind, org.eclipselabs.damos.typesystem.DataType) <em>Evaluate</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TensorTypeOperations extends DataTypeOperations {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TensorTypeOperations() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public static  DataType evaluate(TensorType tensorType, OperatorKind operator, DataType other) {
		switch (operator) {
		case ADD:
			return evaluateElementWise(tensorType, operator, other);
		case SUBTRACT:
			return evaluateElementWise(tensorType, operator, other);
		case MULTIPLY:
			return evaluateMultiply(tensorType, other);
		case DIVIDE:
			return evaluateDivide(tensorType, other);
		case ELEMENT_WISE_MULTIPLY:
			return evaluateElementWise(tensorType, operator, other);
		case ELEMENT_WISE_DIVIDE:
			return evaluateElementWise(tensorType, operator, other);
		case UNARY_MINUS:
			return (TensorType) EcoreUtil.copy(tensorType);
		}
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}
	
	private static DataType evaluateElementWise(TensorType tensorType, OperatorKind operator, DataType other) {
		if (other instanceof NumericalType) {
			if (operator == OperatorKind.ELEMENT_WISE_MULTIPLY || operator == OperatorKind.ELEMENT_WISE_DIVIDE) {
				return evaluateElementWiseScalar(tensorType, operator, (NumericalType) other);
			}
		} else if (other instanceof TensorType) {
			return evaluateElementWiseTensor(tensorType, operator, (TensorType) other);
		}
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}
	
	private static DataType evaluateElementWiseScalar(TensorType tensorType, OperatorKind operator, NumericalType other) {
		DataType elementType = tensorType.getElementType().evaluate(operator, other);
		if (elementType instanceof InvalidDataType) {
			return elementType;
		}
		TensorType result = (TensorType) EcoreUtil.copy(tensorType);
		result.setElementType(elementType);
		return result;
	}

	private static DataType evaluateElementWiseTensor(TensorType tensorType, OperatorKind operator, TensorType otherTensorType) {
		if (TypeSystemUtil.equalArrayDimensions(tensorType, otherTensorType)) {
			DataType elementType = tensorType.getElementType().evaluate(operator, otherTensorType.getElementType());
			if (elementType instanceof InvalidDataType) {
				return elementType;
			}
			TensorType result = (TensorType) EcoreUtil.copy(tensorType);
			result.setElementType(elementType);
			return result;
		}
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}
	
	private static DataType evaluateMultiply(TensorType tensorType, DataType other) {
		if (other instanceof NumericalType) {
			return evaluateElementWiseScalar(tensorType, OperatorKind.MULTIPLY, (NumericalType) other);
		}
		if (!(other instanceof TensorType)) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		TensorType otherTensorType = (TensorType) other;
		if (!tensorType.isMatrix() || !otherTensorType.isMatrix()) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		if (tensorType.getColumnSize() != otherTensorType.getRowSize()) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		
		DataType elementType = tensorType.getElementType().evaluate(OperatorKind.MULTIPLY, otherTensorType.getElementType());
		if (elementType instanceof InvalidDataType) {
			return elementType;
		}

		return TypeSystemUtil.createArrayType(
				elementType,
				tensorType.getRowSize(),
				otherTensorType.getColumnSize());
	}

	private static DataType evaluateDivide(TensorType tensorType, DataType other) {
		if (other instanceof NumericalType) {
			return evaluateElementWiseScalar(tensorType, OperatorKind.DIVIDE, (NumericalType) other);
		}
		// TODO
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}

} // TensorTypeOperations