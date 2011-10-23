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

package org.eclipselabs.mscript.codegen.c.internal.util;

import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.NumericType;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext;

/**
 * @author Andreas Unger
 *
 */
public abstract class Caster {

	public void cast(IMscriptGeneratorContext context, DataType expressionDataType, DataType targetDataType) {
		if (targetDataType instanceof NumericType) {
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(targetDataType);
			if (numberFormat instanceof FloatingPointFormat) {
				new CastToFloatingPointHelper(context.getComputationModel(), context.getAppendable(), expressionDataType, (FloatingPointFormat) numberFormat) {
					
					@Override
					protected void writeExpression() {
						Caster.this.writeExpression();
					}
					
				}.cast();
			} else if (numberFormat instanceof FixedPointFormat) {
				FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
				new CastToFixedPointHelper(context.getComputationModel(), context.getAppendable(), expressionDataType, fixedPointFormat.getWordSize(), fixedPointFormat.getFractionLength()) {

					@Override
					protected void writeExpression() {
						Caster.this.writeExpression();
					}
					
				}.cast();
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			writeExpression();
		}
	}
	
	protected abstract void writeExpression();
	
}
