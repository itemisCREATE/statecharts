/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.eclipselabs.mscript.typesystem.internal.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.TensorType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * <!-- begin-user-doc -->
 * A static utility class that provides operations related to '<em><b>Tensor Type</b></em>' model objects.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following operations are supported:
 * <ul>
 *   <li>{@link org.eclipselabs.mscript.typesystem.TensorType#evaluate(org.eclipselabs.mscript.typesystem.OperatorKind, org.eclipselabs.mscript.typesystem.DataType) <em>Evaluate</em>}</li>
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
			return EcoreUtil.copy(tensorType);
		}
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}
	
	private static DataType evaluateElementWise(TensorType tensorType, OperatorKind operator, DataType other) {
		if (other instanceof NumericType) {
			if (operator == OperatorKind.ELEMENT_WISE_MULTIPLY || operator == OperatorKind.ELEMENT_WISE_DIVIDE) {
				return evaluateElementWiseScalar(tensorType, operator, (NumericType) other);
			}
		} else if (other instanceof TensorType) {
			return evaluateElementWiseTensor(tensorType, operator, (TensorType) other);
		}
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}
	
	private static DataType evaluateElementWiseScalar(TensorType tensorType, OperatorKind operator, NumericType other) {
		DataType elementType = tensorType.getElementType().evaluate(operator, other);
		if (elementType instanceof InvalidDataType) {
			return elementType;
		}
		TensorType result = EcoreUtil.copy(tensorType);
		result.setElementType(elementType);
		return result;
	}

	private static DataType evaluateElementWiseTensor(TensorType tensorType, OperatorKind operator, TensorType otherTensorType) {
		if (TypeSystemUtil.equalArrayDimensions(tensorType, otherTensorType)) {
			DataType elementType = tensorType.getElementType().evaluate(operator, otherTensorType.getElementType());
			if (elementType instanceof InvalidDataType) {
				return elementType;
			}
			TensorType result = EcoreUtil.copy(tensorType);
			result.setElementType(elementType);
			return result;
		}
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}
	
	private static DataType evaluateMultiply(TensorType tensorType, DataType other) {
		if (other instanceof NumericType) {
			return evaluateElementWiseScalar(tensorType, OperatorKind.MULTIPLY, (NumericType) other);
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
		if (other instanceof NumericType) {
			return evaluateElementWiseScalar(tensorType, OperatorKind.DIVIDE, (NumericType) other);
		}
		// TODO
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}

} // TensorTypeOperations