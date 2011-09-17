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

package org.eclipselabs.mscript.language.internal.il.builtin;

import java.util.List;

import org.eclipselabs.mscript.language.il.builtin.ISignature;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.UnitType;

/**
 * @author Andreas Unger
 *
 */
public class NumSignature implements ISignature {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.builtin.ISignature#evaluateOutputParameterDataTypes(java.util.List)
	 */
	public boolean accepts(List<? extends DataType> inputParameterDataTypes) {
		if (inputParameterDataTypes.size() != 2) {
			return false;
		}
		
		DataType dataType1 = inputParameterDataTypes.get(0);
		DataType dataType2 = inputParameterDataTypes.get(1);
		
		return dataType1 instanceof NumericType && dataType2 instanceof UnitType;
	}

}
