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

package org.eclipselabs.mscript.language.interpreter;

import java.util.List;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.language.interpreter.value.IValue;
import org.eclipselabs.mscript.language.interpreter.value.UnitValue;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class UnitFunction implements IFunction {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IBuiltinFunctionBehavior#execute(org.eclipselabs.mscript.language.imperativemodel.BuiltinFunctionCall)
	 */
	public IValue call(List<Expression> arguments) {
		Expression expression = arguments.get(0);
		DataType dataType = ILUtil.getDataType(expression);
		if (dataType instanceof NumericType) {
			NumericType numericType = (NumericType) dataType;
			return new UnitValue(EcoreUtil.copy(numericType.getUnit()));
		}
		return null;
	}
	
}
