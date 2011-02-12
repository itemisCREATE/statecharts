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

package org.eclipselabs.mscript.codegen.c.internal;

import java.io.PrintWriter;
import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.mscript.codegen.c.IFunctionGenerator;
import org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.mscript.codegen.c.internal.util.Caster;
import org.eclipselabs.mscript.codegen.c.util.MscriptGeneratorUtil;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;

/**
 * @author Andreas Unger
 *
 */
public class RoundFunctionGenerator implements IFunctionGenerator {

	private final IExpressionGenerator expressionGenerator = new ExpressionGenerator();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IFunctionGenerator#generate(java.util.List)
	 */
	public void generate(final IMscriptGeneratorContext context, final IVariableAccessStrategy variableAccessStrategy, List<? extends Expression> arguments) {
		final PrintWriter writer = new PrintWriter(context.getWriter());
		
		final Expression argument = arguments.get(0);
		
		final DataType argumentDataType = ILUtil.getDataType(argument);
		if (!(argumentDataType instanceof NumericType)) {
			throw new IllegalArgumentException();
		}
		
		NumericType argumentNumericType = (NumericType) argumentDataType;
		IntegerType resultDataType = TypeSystemFactory.eINSTANCE.createIntegerType();
		resultDataType.setUnit(EcoreUtil.copy(argumentNumericType.getUnit()));
		
		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(argumentDataType);
		
		if (numberFormat instanceof FixedPointFormat) {
			final FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			final int fractionLength = fixedPointFormat.getFractionLength();
			new Caster() {
				
				@Override
				protected void writeExpression() {
					if (fractionLength > 0) {
						writer.print("((");
						expressionGenerator.generate(context, variableAccessStrategy, argument);
						writer.printf(") + %d) & (%s) 0x%x", 1L << fractionLength - 1,
								MscriptGeneratorUtil.getCDataType(context.getComputationModel(), argumentDataType),
								(1L << fixedPointFormat.getWordSize()) - 1 >>> fractionLength << fractionLength);
					} else {
						expressionGenerator.generate(context, variableAccessStrategy, argument);
					}
				}
				
			}.cast(context, argumentDataType, resultDataType);
		} else if (numberFormat instanceof FloatingPointFormat) {
			new Caster() {
				
				@Override
				protected void writeExpression() {
					writer.print("floor((");
					expressionGenerator.generate(context, variableAccessStrategy, argument);
					writer.print(") + 0.5)");
				}
				
			}.cast(context, argumentDataType, resultDataType);
		} else {
			throw new IllegalArgumentException();
		}
	}
	
}
