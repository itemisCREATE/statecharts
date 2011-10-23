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
import org.eclipselabs.damos.mscript.computationmodel.ComputationModel;
import org.eclipselabs.damos.mscript.computationmodel.FixedPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.FloatingPointFormat;
import org.eclipselabs.damos.mscript.computationmodel.NumberFormat;
import org.eclipselabs.damos.mscript.computationmodel.util.ComputationModelSwitch;
import org.eclipselabs.mscript.common.util.PrintAppendable;

public abstract class CastToFloatingPointHelper extends ComputationModelSwitch<Boolean> {

	private ComputationModel computationModel;
	private PrintAppendable out;

	private DataType expressionDataType;
	private FloatingPointFormat targetFloatingPointFormat;
	
	/**
	 * 
	 */
	public CastToFloatingPointHelper(ComputationModel computationModel, Appendable appendable, DataType expressionDataType, FloatingPointFormat targetFloatingPointFormat) {
		this.computationModel = computationModel;
		this.expressionDataType = expressionDataType;
		this.targetFloatingPointFormat = targetFloatingPointFormat;
		out = new PrintAppendable(appendable);
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
		if (floatingPointFormat.getKind() == targetFloatingPointFormat.getKind()) {
			writeExpression();
		} else {
			out.printf("((%s) (", getCDataType());
			writeExpression();
			out.print("))");
		}
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch#caseFixedPointFormat(org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat)
	 */
	@Override
	public Boolean caseFixedPointFormat(FixedPointFormat fixedPointFormat) {
		if (fixedPointFormat.getFractionLength() > 0) {
			out.printf("((%s) ((", getCDataType());
			writeExpression();
			out.printf(") * pow(2, -%d)))", fixedPointFormat.getFractionLength());
		} else {
			out.printf("((%s) (", getCDataType());
			writeExpression();
			out.print("))");
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