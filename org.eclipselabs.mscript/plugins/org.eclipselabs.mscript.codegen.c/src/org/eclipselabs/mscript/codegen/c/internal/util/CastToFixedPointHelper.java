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

import java.io.PrintWriter;
import java.io.Writer;

import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch;
import org.eclipselabs.mscript.typesystem.DataType;

public abstract class CastToFixedPointHelper extends ComputationModelSwitch<Boolean> {

	private ComputationModel computationModel;
	private PrintWriter writer;

	private DataType expressionDataType;
	private int wordSize;
	private int fractionLength;
	
	/**
	 * 
	 */
	public CastToFixedPointHelper(ComputationModel computationModel, Writer writer, DataType expressionDataType, int wordSize, int fractionLength) {
		this.computationModel = computationModel;
		this.writer = new PrintWriter(writer);
		this.expressionDataType = expressionDataType;
		this.wordSize = wordSize;
		this.fractionLength = fractionLength;
	}
	
	public void cast() {
		NumberFormat numberFormat = computationModel.getNumberFormat(expressionDataType);
		doSwitch(numberFormat);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch#caseFloatingPointFormat(org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat)
	 */
	@Override
	public Boolean caseFloatingPointFormat(FloatingPointFormat floatingPointFormat) {
		if (fractionLength > 0) {
			writer.printf("((%s) floor((", getCDataType());
			writeExpression();
			writer.printf(") * pow(2, %d) + 0.5))", fractionLength);
		} else {
			writer.printf("((%s) (", getCDataType());
			writeExpression();
			writer.print("))");
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch#caseFixedPointFormat(org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat)
	 */
	@Override
	public Boolean caseFixedPointFormat(FixedPointFormat fixedPointFormat) {
		if (wordSize != fixedPointFormat.getWordSize()) {
			if (fractionLength < fixedPointFormat.getFractionLength()) {
				writer.printf("(%s) ((", getCDataType());
			} else {
				writer.printf("((%s) (", getCDataType());
			}
		}
		if (fractionLength != fixedPointFormat.getFractionLength()) {
			if (wordSize == fixedPointFormat.getWordSize()) {
				writer.print("((");
			}
			writeExpression();
			if (fractionLength > fixedPointFormat.getFractionLength()) {
				writer.printf(") << %d)", fractionLength - fixedPointFormat.getFractionLength());
			} else {
				writer.printf(") >> %d)", fixedPointFormat.getFractionLength() - fractionLength);
			}
		} else {
			writeExpression();
			if (wordSize != fixedPointFormat.getWordSize()) {
				writer.print("))");
			}
		}
		return true;
	}
	
	protected abstract void writeExpression();
	
	private String getCDataType() {
		return String.format("int%d_t", wordSize);
	}
	
}