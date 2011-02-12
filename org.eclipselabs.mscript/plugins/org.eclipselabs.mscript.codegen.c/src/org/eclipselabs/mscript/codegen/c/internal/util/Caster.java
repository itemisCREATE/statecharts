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

import org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public abstract class Caster {

	public void cast(IMscriptGeneratorContext context, DataType expressionDataType, DataType targetDataType) {
		if (targetDataType instanceof NumericType) {
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(targetDataType);
			if (numberFormat instanceof FloatingPointFormat) {
				new CastToFloatingPointHelper(context, expressionDataType, (FloatingPointFormat) numberFormat) {
					
					@Override
					protected void writeExpression() {
						Caster.this.writeExpression();
					}
					
				}.cast();
			} else if (numberFormat instanceof FixedPointFormat) {
				FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
				new CastToFixedPointHelper(context, expressionDataType, fixedPointFormat.getWordSize(), fixedPointFormat.getFractionLength()) {

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
