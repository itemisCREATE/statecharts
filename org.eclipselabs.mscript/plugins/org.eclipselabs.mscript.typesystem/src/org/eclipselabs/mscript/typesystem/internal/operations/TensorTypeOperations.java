/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.typesystem.internal.operations;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.InvalidDataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.TensorType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

public class TensorTypeOperations extends ArrayTypeOperations {

	public static DataType evaluate(TensorType tensorType, OperatorKind operator, DataType other) {
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
		case NEGATE:
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
		
		int rowSize;
		int columnSize;
		
		if (tensorType.isVector()) {
			if (!otherTensorType.isVector() || TypeSystemUtil.getArraySize(tensorType) != TypeSystemUtil.getArraySize(otherTensorType)) {
				return TypeSystemFactory.eINSTANCE.createInvalidDataType();
			}
			rowSize = 1;
			columnSize = 1;
		} else if (tensorType.isMatrix()) {
			if (!otherTensorType.isMatrix() || TypeSystemUtil.getArrayColumnSize(tensorType) !=  TypeSystemUtil.getArrayRowSize(otherTensorType)) {
				return TypeSystemFactory.eINSTANCE.createInvalidDataType();
			}
			rowSize =  TypeSystemUtil.getArrayRowSize(tensorType);
			columnSize = TypeSystemUtil.getArrayColumnSize(otherTensorType);
		} else {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		
		DataType elementType = tensorType.getElementType().evaluate(OperatorKind.MULTIPLY, otherTensorType.getElementType());
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
			return evaluateElementWiseScalar(tensorType, OperatorKind.DIVIDE, (NumericType) other);
		}
		// TODO
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}

}