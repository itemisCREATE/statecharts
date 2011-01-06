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

package org.eclipselabs.mscript.codegen.c;

import java.io.PrintWriter;
import java.util.List;

import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.TensorType;

/**
 * @author Andreas Unger
 *
 */
public class SumFunctionGenerator implements IFunctionGenerator {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IFunctionGenerator#generate(java.util.List)
	 */
	public void generate(IGeneratorContext context, List<Expression> arguments) {
		ExpressionGenerator expressionGenerator = new ExpressionGenerator(context);
		PrintWriter writer = new PrintWriter(context.getWriter());
		
		Expression argument = arguments.get(0);
		
		DataType dataType = ILUtil.getDataType(argument);
		if (!(dataType instanceof TensorType)) {
			throw new RuntimeException("Target type of sum() method must be tensor type");
		}
		
		TensorType tensorType = (TensorType) dataType;
		
		for (int i = 0; i < tensorType.getSize(); ++i) {
			if (i > 0) {
				writer.print(" + ");
			}
			writer.print("(");
			expressionGenerator.doSwitch(argument);
			writer.printf(")[%d]", i);
		}
	}
	
}
