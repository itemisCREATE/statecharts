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

import java.util.List;

import org.eclipselabs.damos.mscript.DataType;
import org.eclipselabs.damos.mscript.Expression;
import org.eclipselabs.damos.mscript.TensorType;
import org.eclipselabs.damos.mscript.util.TypeUtil;
import org.eclipselabs.mscript.codegen.c.ExpressionGenerator;
import org.eclipselabs.mscript.codegen.c.IExpressionGenerator;
import org.eclipselabs.mscript.codegen.c.IFunctionGenerator;
import org.eclipselabs.mscript.codegen.c.IMscriptGeneratorContext;
import org.eclipselabs.mscript.common.util.PrintAppendable;

/**
 * @author Andreas Unger
 *
 */
public class SumFunctionGenerator implements IFunctionGenerator {

	private final IExpressionGenerator expressionGenerator = new ExpressionGenerator();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IFunctionGenerator#generate(java.util.List)
	 */
	public void generate(IMscriptGeneratorContext context, List<? extends Expression> arguments) {
		PrintAppendable out = new PrintAppendable(context.getAppendable());
		
		Expression argument = arguments.get(0);
		
		DataType dataType = context.getStaticEvaluationContext().getValue(argument).getDataType();
		if (!(dataType instanceof TensorType)) {
			throw new RuntimeException("Target type of sum() method must be tensor type");
		}
		
		TensorType tensorType = (TensorType) dataType;
		
		int arraySize = TypeUtil.getArraySize(tensorType);
		for (int i = 0; i < arraySize; ++i) {
			if (i > 0) {
				out.print(" + ");
			}
			out.print("(");
			expressionGenerator.generate(context, argument);
			out.printf(")[%d]", i);
		}
	}
	
}
