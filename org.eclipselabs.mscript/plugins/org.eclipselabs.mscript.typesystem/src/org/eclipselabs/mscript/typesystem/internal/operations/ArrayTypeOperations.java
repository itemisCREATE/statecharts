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

import java.util.Iterator;

import org.eclipselabs.mscript.typesystem.ArrayDimension;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

public class ArrayTypeOperations extends DataTypeOperations {

	protected ArrayTypeOperations() {
		super();
	}

	public static boolean isAssignableFrom(ArrayType arrayType, DataType other) {
		if (other instanceof ArrayType) {
			ArrayType otherArrayType = (ArrayType) other;
			if (arrayType.getDimensionality() == otherArrayType.getDimensionality()) {
				Iterator<ArrayDimension> dimensionIterator = arrayType.getDimensions().iterator();
				Iterator<ArrayDimension> otherDimensionIterator = otherArrayType.getDimensions().iterator();
				while (dimensionIterator.hasNext() && otherDimensionIterator.hasNext()) {
					int size = TypeSystemUtil.getArrayDimensionSize(dimensionIterator.next());
					int otherSize = TypeSystemUtil.getArrayDimensionSize(otherDimensionIterator.next());
					if (size >= 0 && size != otherSize) {
						return false;
					}
				}
				return arrayType.getElementType().isAssignableFrom(otherArrayType.getElementType());
			}
		}
		return false;
	}

}
