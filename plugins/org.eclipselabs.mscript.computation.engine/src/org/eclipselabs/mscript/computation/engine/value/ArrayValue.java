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

package org.eclipselabs.mscript.computation.engine.value;

import org.eclipselabs.mscript.computation.engine.IComputationContext;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.TensorType;

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
			if (elements.length != dataType.getSize()) {
				throw new IllegalArgumentException("Number of elements must be equal to array size");
			}
			this.elements = elements;
		} else {
			throw new IllegalArgumentException("Multi-dimensional array type not supported");
		}
	}
	
	public IValue get(int... index) {
		if (index.length != 1) {
			throw new IllegalArgumentException("Index array length must be 1");
		}
		return ((IValue[]) elements)[index[0]];
	}

}
