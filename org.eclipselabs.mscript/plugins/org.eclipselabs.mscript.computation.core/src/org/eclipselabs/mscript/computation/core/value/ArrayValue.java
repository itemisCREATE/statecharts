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

package org.eclipselabs.mscript.computation.core.value;

import org.eclipselabs.mscript.computation.core.IComputationContext;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.TensorType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class ArrayValue extends AbstractExplicitDataTypeValue implements IArrayValue {

	private Object elements;
	
	/**
	 * @param context
	 * @param dataType
	 */
	public ArrayValue(IComputationContext context, ArrayType dataType, IValue[] elements) {
		super(context, dataType);
		if (dataType instanceof TensorType) {
			throw new IllegalArgumentException("Array type must not be tensor type");
		}
		if (dataType.getDimensionality() == 1) {
			if (elements.length != TypeSystemUtil.getArraySize(dataType)) {
				throw new IllegalArgumentException("Number of elements must be equal to array size");
			}
			this.elements = elements;
		} else {
			throw new IllegalArgumentException("Multi-dimensional array type not supported");
		}
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractExplicitDataTypeValue#getDataType()
	 */
	@Override
	public ArrayType getDataType() {
		return (ArrayType) super.getDataType();
	}
	
	public IValue get(int index) {
		return ((IValue[]) elements)[index];
	}

	public IValue get(int rowIndex, int columnIndex) {
		throw new UnsupportedOperationException();
	}

	public IValue get(int... indices) {
		if (indices.length != 1) {
			throw new IllegalArgumentException("Index array length must be 1");
		}
		return ((IValue[]) elements)[indices[0]];
	}

	public void set(int index, IValue value) {
		((IValue[]) elements)[index] = value;
	}

	public void set(int rowIndex, int columnIndex, IValue value) {
		throw new UnsupportedOperationException();
	}

	public void set(int[] indices, IValue value) {
		if (indices.length != 1) {
			throw new IllegalArgumentException("Index array length must be 1");
		}
		((IValue[]) elements)[indices[0]] = value;
	}

}
