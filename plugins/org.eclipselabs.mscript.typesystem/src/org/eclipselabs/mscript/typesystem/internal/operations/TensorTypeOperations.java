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
public class TensorTypeOperations extends ArrayTypeOperations {
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
		case ADDITION:
			return evaluateElementWise(tensorType, operator, other);
		case SUBTRACTION:
			return evaluateElementWise(tensorType, operator, other);
		case MULTIPLICATION:
			return evaluateMultiply(tensorType, other);
		case DIVISION:
			return evaluateDivide(tensorType, other);
		case ELEMENT_WISE_MULTIPLICATION:
			return evaluateElementWise(tensorType, operator, other);
		case ELEMENT_WISE_DIVISION:
			return evaluateElementWise(tensorType, operator, other);
		case UNARY_MINUS:
			return EcoreUtil.copy(tensorType);
		}
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}
	
	private static DataType evaluateElementWise(TensorType tensorType, OperatorKind operator, DataType other) {
		if (other instanceof NumericType) {
			if (operator == OperatorKind.ELEMENT_WISE_MULTIPLICATION || operator == OperatorKind.ELEMENT_WISE_DIVISION) {
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
			return evaluateElementWiseScalar(tensorType, OperatorKind.MULTIPLICATION, (NumericType) other);
		}
		if (!(other instanceof TensorType)) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		
		TensorType otherTensorType = (TensorType) other;
		
		int rowSize;
		int columnSize;
		
		if (tensorType.isVector()) {
			if (!otherTensorType.isVector() || tensorType.getSize() != otherTensorType.getSize()) {
				return TypeSystemFactory.eINSTANCE.createInvalidDataType();
			}
			rowSize = 1;
			columnSize = 1;
		} else if (tensorType.isMatrix()) {
			if (!otherTensorType.isMatrix() || tensorType.getColumnSize() != otherTensorType.getRowSize()) {
				return TypeSystemFactory.eINSTANCE.createInvalidDataType();
			}
			rowSize = tensorType.getRowSize();
			columnSize = otherTensorType.getColumnSize();
		} else {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		
		DataType elementType = tensorType.getElementType().evaluate(OperatorKind.MULTIPLICATION, otherTensorType.getElementType());
		if (elementType instanceof InvalidDataType) {
			return elementType;
		}
		
		if (rowSize == 1 && columnSize == 1) {
			return elementType;
		}

		return TypeSystemUtil.createArrayType(
				elementType,
				rowSize,
				columnSize);
	}
	
	private static DataType evaluateDivide(TensorType tensorType, DataType other) {
		if (other instanceof NumericType) {
			return evaluateElementWiseScalar(tensorType, OperatorKind.DIVISION, (NumericType) other);
		}
		// TODO
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}

} // TensorTypeOperations