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

package org.eclipselabs.mscript.codegen.c.util;

import java.io.PrintWriter;

import org.eclipselabs.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.mscript.codegen.c.internal.util.CastToFixedPointHelper;
import org.eclipselabs.mscript.codegen.c.internal.util.CastToFloatingPointHelper;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.typesystem.ArrayDimension;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.BooleanType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class GeneratorUtil {
	
	public static String getCVariableDeclaration(ComputationModel computationModel, DataType dataType, String name, boolean pointer) {
		StringBuilder cDataType = new StringBuilder();

		if (dataType instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) dataType;

			cDataType.append(getCDataType(computationModel, arrayType.getElementType()));
			cDataType.append(" ");
			if (pointer) {
				cDataType.append("*");
			}
			cDataType.append(name);
			cDataType.append("[");
			
			boolean first = true;
			for (ArrayDimension arrayDimension : arrayType.getDimensions()) {
				if (first) {
					first = false;
				} else {
					cDataType.append(", ");
				}
				cDataType.append(arrayDimension.getSize());
			}
			
			cDataType.append("]");
		} else {
			cDataType.append(getCDataType(computationModel, dataType));
			cDataType.append(" ");
			if (pointer) {
				cDataType.append("*");
			}
			cDataType.append(name);
		}

		return cDataType.toString();
	}

	public static String getCDataType(ComputationModel computationModel, DataType dataType) {
		if (dataType instanceof BooleanType) {
			return "int";
		}
		if (dataType instanceof NumericType) {
			NumberFormat numberFormat = computationModel.getNumberFormat(dataType);
			if (numberFormat instanceof FloatingPointFormat) {
				FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
				switch (floatingPointFormat.getKind()) {
				case BINARY32:
					return "float";
				case BINARY64:
					return "double";
				}
			} else if (numberFormat instanceof FixedPointFormat) {
				FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
				return String.format("int%d_t", fixedPointFormat.getWordSize());
			}
		}
		throw new IllegalArgumentException();
	}
	
	public static String getLiteralString(ComputationModel computationModel, DataType dataType, double value) {
		NumberFormat numberFormat = computationModel.getNumberFormat(dataType);
		String cDataType = getCDataType(computationModel, dataType);
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			return String.format("(%s) %d", cDataType, Math.round(value * Math.pow(2, fixedPointFormat.getFractionLength())));
		}
		return String.format("(%s) %s", cDataType, Double.toString(value));
	}

	public static String getLiteralString(ComputationModel computationModel, DataType dataType, long value) {
		NumberFormat numberFormat = computationModel.getNumberFormat(dataType);
		String cDataType = getCDataType(computationModel, dataType);
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			value <<= fixedPointFormat.getFractionLength();
		}
		return String.format("(%s) %d", cDataType, value);
	}

	public static void cast(IMscriptGeneratorContext context, final String expression, DataType expressionDataType, DataType targetDataType) {
		if (targetDataType instanceof NumericType) {
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(targetDataType);
			if (numberFormat instanceof FloatingPointFormat) {
				new CastToFloatingPointHelper(context, expressionDataType, (FloatingPointFormat) numberFormat) {
					
					@Override
					protected void writeExpression() {
						new PrintWriter(getContext().getWriter()).print(expression);
					}
					
				}.cast();
			} else if (numberFormat instanceof FixedPointFormat) {
				FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
				new CastToFixedPointHelper(context, expressionDataType, fixedPointFormat.getWordSize(), fixedPointFormat.getFractionLength()) {

					@Override
					protected void writeExpression() {
						new PrintWriter(getContext().getWriter()).print(expression);
					}
					
				}.cast();
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			new PrintWriter(context.getWriter()).print(expression);
		}
	}

	public static void cast(IMscriptGeneratorContext context, IVariableAccessStrategy variableAccessStrategy, Expression expression, DataType targetDataType) {
		if (targetDataType instanceof NumericType) {
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(targetDataType);
			castNumericType(context, variableAccessStrategy, numberFormat, expression);
		} else {
			new ExpressionGenerator(context, variableAccessStrategy).doSwitch(expression);
		}
	}

	public static void castNumericType(final IMscriptGeneratorContext context, final IVariableAccessStrategy variableAccessStrategy, NumberFormat numberFormat, final Expression expression) {
		DataType expressionDataType = ILUtil.getDataType(expression);
		if (numberFormat instanceof FloatingPointFormat) {
			new CastToFloatingPointHelper(context, expressionDataType, (FloatingPointFormat) numberFormat) {
				
				@Override
				protected void writeExpression() {
					new ExpressionGenerator(context, variableAccessStrategy).doSwitch(expression);
				}
				
			}.cast();
		} else if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			new CastToFixedPointHelper(context, expressionDataType, fixedPointFormat.getWordSize(), fixedPointFormat.getFractionLength()) {

				@Override
				protected void writeExpression() {
					new ExpressionGenerator(context, variableAccessStrategy).doSwitch(expression);
				}
				
			}.cast();
		} else {
			throw new IllegalArgumentException();
		}
	}

}
