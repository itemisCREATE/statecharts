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

import org.eclipselabs.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.mscript.codegen.c.IFunctionGenerator;
import org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.mscript.codegen.c.IVariableAccessStrategy;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.Expression;
import org.eclipselabs.mscript.typesystem.TensorType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class SumFunctionGenerator implements IFunctionGenerator {

	private final IExpressionGenerator expressionGenerator = new ExpressionGenerator();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IFunctionGenerator#generate(java.util.List)
	 */
	public void generate(IMscriptGeneratorContext context, IVariableAccessStrategy variableAccessStrategy, List<? extends Expression> arguments) {
		PrintWriter writer = new PrintWriter(context.getWriter());
		
		Expression argument = arguments.get(0);
		
		DataType dataType = ILUtil.getDataType(argument);
		if (!(dataType instanceof TensorType)) {
			throw new RuntimeException("Target type of sum() method must be tensor type");
		}
		
		TensorType tensorType = (TensorType) dataType;
		
		int arraySize = TypeSystemUtil.getArraySize(tensorType);
		for (int i = 0; i < arraySize; ++i) {
			if (i > 0) {
				writer.print(" + ");
			}
			writer.print("(");
			expressionGenerator.generate(context, variableAccessStrategy, argument);
			writer.printf(")[%d]", i);
		}
	}
	
}
