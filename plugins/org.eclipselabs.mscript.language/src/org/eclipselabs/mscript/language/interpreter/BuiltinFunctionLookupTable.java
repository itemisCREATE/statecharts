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

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.mscript.language.il.util.BuiltinFunctionDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinFunctionLookupTable {

	private Map<String, IFunction> functions = new HashMap<String, IFunction>();
	
	{
		functions.put(BuiltinFunctionDescriptor.UNIT.getName(), new UnitFunction());
//		functions.put(BuiltinFunctionDescriptor.SUM.getName(), new SumFunction());
	}
	
	public IFunction getFunction(String name) {
		return functions.get(name);
	}
	
}
