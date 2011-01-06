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

package org.eclipselabs.mscript.codegen.c.util;

import java.io.PrintWriter;

import org.eclipselabs.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.mscript.codegen.c.IGeneratorContext;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.typesystem.DataType;

public class CastToFloatingPointHelper extends ComputationModelSwitch<Boolean> {

	private IGeneratorContext context;
	private Expression expression;
	private FloatingPointFormat targetFloatingPointFormat;
	
	private PrintWriter writer;
	private ExpressionGenerator expressionGenerator;
	
	/**
	 * 
	 */
	public CastToFloatingPointHelper(IGeneratorContext context, Expression expression, FloatingPointFormat targetFloatingPointFormat) {
		this.context = context;
		this.expression = expression;
		this.targetFloatingPointFormat = targetFloatingPointFormat;
		writer = new PrintWriter(context.getWriter());
		expressionGenerator = new ExpressionGenerator(context);
	}
	
	public void cast() {
		DataType dataType = ILUtil.getDataType(expression);
		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(dataType);
		doSwitch(numberFormat);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelSwitch#caseFloatingPointFormat(org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat)
	 */
	@Override
	public Boolean caseFloatingPointFormat(FloatingPointFormat floatingPointFormat) {
		if (floatingPointFormat.getKind() == targetFloatingPointFormat.getKind()) {
			expressionGenerator.doSwitch(expression);
		} else {
			writer.printf("((%s) (", getCDataType());
			expressionGenerator.doSwitch(expression);
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
			expressionGenerator.doSwitch(expression);
			writer.printf(") * pow(2, -%d)))", fixedPointFormat.getFractionLength());
		} else {
			writer.printf("((%s) (", getCDataType());
			expressionGenerator.doSwitch(expression);
			writer.print("))");
		}
		return true;
	}
	
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