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

package org.eclipselabs.mscript.language.il.builtin;

import java.util.Iterator;
import java.util.List;

import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class Signature implements ISignature {

	private List<DataType> inputParameterDataTypes;
	
	/**
	 * 
	 */
	public Signature(List<DataType> inputDataTypes) {
		this.inputParameterDataTypes = inputDataTypes;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ISignature#evaluateOutputDataTypes(java.util.List)
	 */
	public boolean accepts(List<? extends DataType> inputParameterDataTypes) {
		if (this.inputParameterDataTypes == inputParameterDataTypes) {
			return true;
		}
		if (!(this.inputParameterDataTypes != null && inputParameterDataTypes != null && this.inputParameterDataTypes.size() == inputParameterDataTypes.size())) {
			return false;
		}
		Iterator<DataType> iterator = this.inputParameterDataTypes.iterator();
		for (DataType inputDataType : inputParameterDataTypes) {
			if (!iterator.next().isAssignableFrom(inputDataType)) {
				return false;
			}
		}
		return true;
	}

}
