/****************************************************************************
 * Copyright (c) 2008, 2010 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.computation.core.value;

import org.eclipselabs.mscript.computation.core.IComputationContext;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.TensorType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class VectorValue extends AbstractExplicitDataTypeValue implements IArrayValue {

	private INumericValue[] elements;
	
	/**
	 * @param context
	 * @param dataType
	 */
	public VectorValue(IComputationContext context, TensorType dataType, INumericValue[] elements) {
		super(context, dataType);
		if (!dataType.isVector()) {
			throw new IllegalArgumentException("Tensor type must be vector");
		}
		if (elements.length != TypeSystemUtil.getArraySize(dataType)) {
			throw new IllegalArgumentException("Number of elements must be equal to vector size");
		}
		this.elements = elements;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractExplicitDataTypeValue#getDataType()
	 */
	@Override
	public TensorType getDataType() {
		return (TensorType) super.getDataType();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractValue#doConvert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(DataType dataType) {
		return null;
	}
	
	public INumericValue get(int index) {
		return elements[index];
	}

	public IValue get(int rowIndex, int columnIndex) {
		throw new UnsupportedOperationException();
	}
	
	public INumericValue get(int... indices) {
		if (indices.length != 1) {
			throw new IllegalArgumentException("Index array length must be 1");
		}
		return elements[indices[0]];
	}
	
	public void set(int index, IValue value) {
		if (!(value instanceof INumericValue)) {
			throw new IllegalArgumentException("Value must be numeric");
		}
		elements[index] = (INumericValue) value;
	}
	
	public void set(int rowIndex, int columnIndex, IValue value) {
		throw new UnsupportedOperationException();
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.IArrayValue#set(int[], org.eclipselabs.mscript.computation.core.value.IValue)
	 */
	public void set(int[] indices, IValue value) {
		if (indices.length != 1) {
			throw new IllegalArgumentException("Index array length must be 1");
		}
		if (!(value instanceof INumericValue)) {
			throw new IllegalArgumentException("Value must be numeric");
		}
		elements[indices[0]] = (INumericValue) value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractValue#doMultiply(org.eclipselabs.mscript.computation.core.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doMultiply(IValue other, DataType resultDataType) {
		if (other instanceof INumericValue) {
			INumericValue otherNumericValue = (INumericValue) other;
			INumericValue[] resultElements = new INumericValue[elements.length];
			for (int i = 0; i < elements.length; ++i) {
				IValue resultElement = elements[i].multiply(otherNumericValue);
				if (!(resultElement instanceof INumericValue)) {
					return InvalidValue.SINGLETON;
				}
				resultElements[i] = (INumericValue) resultElement;
			}
			return new VectorValue(getContext(), (TensorType) resultDataType, resultElements);
		} else if (other instanceof VectorValue) {
			VectorValue otherVectorValue = (VectorValue) other;
			if (elements.length != otherVectorValue.elements.length) {
				return InvalidValue.SINGLETON;
			}
			INumericValue result = null;
			for (int i = 0; i < elements.length; ++i) {
				IValue product = elements[i].multiply(otherVectorValue.elements[i]);
				if (!(product instanceof INumericValue)) {
					return InvalidValue.SINGLETON;
				}
				INumericValue numericProduct = (INumericValue) product;
				if (result == null) {
					result = numericProduct;
				} else {
					IValue sum = result.add(numericProduct);
					if (!(sum instanceof INumericValue)) {
						return InvalidValue.SINGLETON;
					}
					result = (INumericValue) sum;
				}
			}
			return result;
		}
		return super.doMultiply(other, resultDataType);
	}
	
}
