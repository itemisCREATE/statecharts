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

package org.eclipselabs.mscript.language.interpreter.builtin;

import org.eclipselabs.mscript.language.il.builtin.BuiltinFunctionDescriptor;

/**
 * @author Andreas Unger
 *
 */
public class BuiltinFunctionLookupTable implements IBuiltinFunctionLookupTable {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.builtin.IBuiltinFunctionLookupTable#getFunction(org.eclipselabs.mscript.language.il.builtin.BuiltinFunctionDescriptor)
	 */
	public IFunction getFunction(BuiltinFunctionDescriptor descriptor) {
		switch (descriptor) {
		case UNIT:
			return new UnitFunction();
		}
		return null;
	}
	
}
