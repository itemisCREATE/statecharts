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
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.RealType;

/**
 * @author Andreas Unger
 *
 */
public class ValueTransformer {

	public IValue transform(IComputationContext context, IValue value) {
		if (value instanceof ISimpleNumericValue) {
			ISimpleNumericValue numericValue = (ISimpleNumericValue) value;
			if (numericValue.getDataType() instanceof RealType) {
				return new ValueConstructor().createRealValue(context, (RealType) value.getDataType(), numericValue.doubleValue());
			}
			if (numericValue.getDataType() instanceof IntegerType) {
				return new ValueConstructor().createIntegerValue(context, (IntegerType) value.getDataType(), numericValue.longValue());
			}
		}
		if (value instanceof VectorValue) {
			VectorValue vectorValue = (VectorValue) value;
			
			INumericValue[] elements = new INumericValue[vectorValue.getDataType().getRowSize()];
			
			for (int i = 0; i < elements.length; ++i) {
				elements[i] = (INumericValue) transform(context, vectorValue.get(i));
			}
			
			return new VectorValue(context, vectorValue.getDataType(), elements);
		}
		return value;
	}
	
}
