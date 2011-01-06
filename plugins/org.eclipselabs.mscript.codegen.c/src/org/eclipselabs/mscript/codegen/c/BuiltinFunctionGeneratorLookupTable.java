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

import java.util.HashMap;
import java.util.Map;

import org.eclipselabs.mscript.language.il.util.BuiltinFunctionDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinFunctionGeneratorLookupTable {

	private Map<String, IFunctionGenerator> functionGenerators = new HashMap<String, IFunctionGenerator>();
	
	{
		functionGenerators.put(BuiltinFunctionDescriptor.SUM.getName(), new SumFunctionGenerator());
	}
	
	/**
	 * @return the functionGenerators
	 */
	public IFunctionGenerator getFunctionGenerator(String name) {
		return functionGenerators.get(name);
	}
	
}
