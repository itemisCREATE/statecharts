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

import org.eclipselabs.mscript.codegen.c.IGeneratorContext;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.language.ast.Expression;
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
	
	public static String getCVariableDeclaration(IGeneratorContext context, DataType dataType, String name, boolean reference) {
		StringBuilder cDataType = new StringBuilder();

		if (dataType instanceof ArrayType) {
			ArrayType arrayType = (ArrayType) dataType;

			cDataType.append(getCDataType(context, arrayType.getElementType()));
			cDataType.append(" ");
			if (reference) {
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
			cDataType.append(getCDataType(context, dataType));
			cDataType.append(" ");
			if (reference) {
				cDataType.append("*");
			}
			cDataType.append(name);
		}

		return cDataType.toString();
	}

	public static String getCDataType(IGeneratorContext context, DataType dataType) {
		if (dataType instanceof BooleanType) {
			return "int";
		}
		if (dataType instanceof NumericType) {
			NumberFormat numberFormat = context.getComputationModel().getNumberFormat(dataType);
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
	
	public static void writeLiteral(IGeneratorContext context, DataType dataType, double value) {
		PrintWriter writer = new PrintWriter(context.getWriter());
		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(dataType);
		writer.printf("(%s) ", GeneratorUtil.getCDataType(context, dataType));
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			writer.print(Math.round(value * Math.pow(2, fixedPointFormat.getFractionLength())));
		} else {
			writer.print(value);
		}
	}

	public static void writeLiteral(IGeneratorContext context, DataType dataType, long value) {
		PrintWriter writer = new PrintWriter(context.getWriter());
		NumberFormat numberFormat = context.getComputationModel().getNumberFormat(dataType);
		writer.printf("(%s) ", GeneratorUtil.getCDataType(context, dataType));
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			value <<= fixedPointFormat.getFractionLength();
		}
		writer.print(value);
	}

	public static void castNumericType(IGeneratorContext context, NumberFormat numberFormat, Expression expression) {
		if (numberFormat instanceof FloatingPointFormat) {
			new CastToFloatingPointHelper(context, expression, (FloatingPointFormat) numberFormat).cast();
		} else if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			new CastToFixedPointHelper(context, expression, fixedPointFormat.getWordSize(), fixedPointFormat.getFractionLength()).cast();
		} else {
			throw new IllegalArgumentException();
		}
	}

}
