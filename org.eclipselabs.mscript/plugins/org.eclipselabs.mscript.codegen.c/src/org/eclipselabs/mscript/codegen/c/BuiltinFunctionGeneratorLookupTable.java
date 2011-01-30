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

import org.eclipselabs.mscript.language.il.builtin.BuiltinFunctionDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinFunctionGeneratorLookupTable implements IBuiltinFunctionGeneratorLookupTable {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.codegen.c.IBuiltinFunctionGeneratorLookupTable#getFunctionGenerator(org.eclipselabs.mscript.language.il.builtin.BuiltinFunctionDescriptor)
	 */
	public IFunctionGenerator getFunctionGenerator(BuiltinFunctionDescriptor builtinFunctionDescriptor) {
		return null;
	}
	
}
