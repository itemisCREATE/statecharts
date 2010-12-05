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
public class BuiltinFunctionDescriptorLookupTable {

	private Map<String, IFunction> functionDescriptors = new HashMap<String, IFunction>();
	
	{
		functionDescriptors.put(BuiltinFunctionDescriptor.UNIT.getName(), new UnitFunction());
	}
	
	public IFunction getFunction(String name) {
		return functionDescriptors.get(name);
	}
	
}
