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

import org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch;
import org.eclipselabs.mscript.typesystem.DataType;

public abstract class CastToFloatingPointHelper extends ComputationModelSwitch<Boolean> {

	private IMscriptGeneratorContext context;
	private DataType expressionDataType;
	private FloatingPointFormat targetFloatingPointFormat;
	
	private PrintWriter writer;
	
	/**
	 * 
	 */
	public CastToFloatingPointHelper(IMscriptGeneratorContext context, DataType expressionDataType, FloatingPointFormat targetFloatingPointFormat) {
		this.context = context;
		this.expressionDataType = expressionDataType;
		this.targetFloatingPointFormat = targetFloatingPointFormat;
		writer = new PrintWriter(context.getWriter());
	}
	
	protected IMscriptGeneratorContext getContext() {
		return context;
	}
	
	public void cast() {
		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(expressionDataType);
		doSwitch(numberFormat);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch#caseFloatingPointFormat(org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat)
	 */
	@Override
	public Boolean caseFloatingPointFormat(FloatingPointFormat floatingPointFormat) {
		if (floatingPointFormat.getKind() == targetFloatingPointFormat.getKind()) {
			writeExpression();
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
		if (fixedPointFormat.getFractionLength() > 0) {
			writer.printf("((%s) ((", getCDataType());
			writeExpression();
			writer.printf(") * pow(2, -%d)))", fixedPointFormat.getFractionLength());
		} else {
			writer.printf("((%s) (", getCDataType());
			writeExpression();
			writer.print("))");
		}
		return true;
	}
	
	protected abstract void writeExpression();

	private String getCDataType() {
		switch (targetFloatingPointFormat.getKind()) {
		case BINARY32:
			return "float";
		case BINARY64:
			return "double";
		default:
			throw new IllegalArgumentException();
		}
	}
	
}