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

package org.eclipselabs.mscript.computation.engine.value;

import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.computation.engine.IComputationContext;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.RealType;

/**
 * @author Andreas Unger
 *
 */
public class ValueConstructor implements IValueConstructor {

	public ISimpleNumericValue createRealValue(IComputationContext context, RealType realType, double value) {
		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(realType);
		if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			switch (floatingPointFormat.getKind()) {
			case BINARY64:
				return new Binary64Value(context, realType, floatingPointFormat, value);
			default:
				throw new IllegalArgumentException();
			}
		}
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			FixedPointValue fixedPointValue = new FixedPointValue(context, realType, fixedPointFormat, 0);
			FixedPointOperation fixedPointOperation = ComputationModelUtil.getFixedPointOperation(fixedPointFormat,
					FixedPointOperationKind.CONSTRUCT);
			FixedPointValue.initializeValue(context, fixedPointValue, fixedPointOperation, value);
			return fixedPointValue;
		}
		throw new IllegalArgumentException();
	}
	
	public ISimpleNumericValue createIntegerValue(IComputationContext context, IntegerType integerType, long value) {
		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(integerType);
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			FixedPointValue integerValue = new FixedPointValue(context, integerType, fixedPointFormat, 0);
			FixedPointOperation fixedPointOperation = ComputationModelUtil.getFixedPointOperation(fixedPointFormat,
					FixedPointOperationKind.CONSTRUCT);
			FixedPointValue.initializeValue(context, integerValue, fixedPointOperation, value);
			return integerValue;
		}
		throw new IllegalArgumentException();
	}
	
	public IBooleanValue createBooleanValue(IComputationContext context, boolean value) {
		return new BooleanValue(context, value);
	}
	
}
