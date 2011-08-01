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
import java.io.Writer;

import org.eclipselabs.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.mscript.codegen.c.internal.util.CastToFixedPointHelper;
import org.eclipselabs.mscript.codegen.c.internal.util.CastToFloatingPointHelper;
import org.eclipselabs.mscript.computation.computationmodel.ComputationModel;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.typesystem.ArrayDimension;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.BooleanType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.Expression;
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class MscriptGeneratorUtil {
	
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

	public static String getIndexCDataType(ComputationModel computationModel, long maximumIndex) {
		if (maximumIndex <= 0xffL) {
			return "uint_fast8_t";
		}
		if (maximumIndex <= 0xffffL) {
			return "uint_fast16_t";
		}
		if (maximumIndex <= 0xffffffffL) {
			return "uint_fast32_t";
		}
		return "uint_fast64_t";
	}

	public static String getCDataType(ComputationModel computationModel, DataType dataType) {
		if (dataType instanceof BooleanType) {
			return "uint_fast8_t";
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

	public static void cast(IMscriptGeneratorContext context, String expression, DataType expressionDataType, DataType targetDataType) {
		cast(context.getComputationModel(), context.getWriter(), expression, expressionDataType, targetDataType);
	}
	
	public static void cast(ComputationModel computationModel, final Writer writer, final String expression, DataType expressionDataType, DataType targetDataType) {
		if (targetDataType instanceof NumericType) {
			NumberFormat numberFormat = computationModel.getNumberFormat(targetDataType);
			if (numberFormat instanceof FloatingPointFormat) {
				new CastToFloatingPointHelper(computationModel, writer, expressionDataType, (FloatingPointFormat) numberFormat) {
					
					@Override
					protected void writeExpression() {
						new PrintWriter(writer).print(expression);
					}
					
				}.cast();
			} else if (numberFormat instanceof FixedPointFormat) {
				FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
				new CastToFixedPointHelper(computationModel, writer, expressionDataType, fixedPointFormat.getWordSize(), fixedPointFormat.getFractionLength()) {

					@Override
					protected void writeExpression() {
						new PrintWriter(writer).print(expression);
					}
					
				}.cast();
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			new PrintWriter(writer).print(expression);
		}
	}

	public static void cast(IMscriptGeneratorContext context, IVariableAccessStrategy variableAccessStrategy, Expression expression, DataType targetDataType) {
		if (targetDataType instanceof NumericType) {
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(targetDataType);
			castNumericType(context, variableAccessStrategy, numberFormat, expression);
		} else {
			new ExpressionGenerator().generate(context, variableAccessStrategy, expression);
		}
	}

	public static void castNumericType(final IMscriptGeneratorContext context, final IVariableAccessStrategy variableAccessStrategy, NumberFormat numberFormat, final Expression expression) {
		DataType expressionDataType = context.getStaticEvaluationContext().getValue(expression).getDataType();
		if (numberFormat instanceof FloatingPointFormat) {
			new CastToFloatingPointHelper(context.getComputationModel(), context.getWriter(), expressionDataType, (FloatingPointFormat) numberFormat) {
				
				@Override
				protected void writeExpression() {
					new ExpressionGenerator().generate(context, variableAccessStrategy, expression);
				}
				
			}.cast();
		} else if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			new CastToFixedPointHelper(context.getComputationModel(), context.getWriter(), expressionDataType, fixedPointFormat.getWordSize(), fixedPointFormat.getFractionLength()) {

				@Override
				protected void writeExpression() {
					new ExpressionGenerator().generate(context, variableAccessStrategy, expression);
				}
				
			}.cast();
		} else {
			throw new IllegalArgumentException();
		}
	}

}
