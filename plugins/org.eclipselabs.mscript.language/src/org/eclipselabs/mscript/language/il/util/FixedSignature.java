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

package org.eclipselabs.mscript.language.il.util;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class FixedSignature implements ISignature {

	private List<DataType> inputDataTypes;
	private List<DataType> outputDataTypes;
	
	public FixedSignature(DataType outputDataType) {
		this(Collections.<DataType>emptyList(), outputDataType);
	}

	public FixedSignature(DataType inputDataType, DataType outputDataType) {
		this(Collections.singletonList(inputDataType), outputDataType);
	}

	public FixedSignature(List<DataType> inputDataTypes, DataType outputDataType) {
		this(inputDataTypes, Collections.singletonList(outputDataType));
	}

	/**
	 * 
	 */
	public FixedSignature(List<DataType> inputDataTypes, List<DataType> outputDataTypes) {
		this.inputDataTypes = inputDataTypes;
		this.outputDataTypes = outputDataTypes;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ISignature#evaluateOutputDataTypes(java.util.List)
	 */
	public List<DataType> evaluateOutputDataTypes(List<DataType> inputDataTypes) {
		if (this.inputDataTypes.size() != inputDataTypes.size()) {
			return null;
		}
		Iterator<DataType> iterator = this.inputDataTypes.iterator();
		for (DataType inputDataType : inputDataTypes) {
			if (!iterator.next().isAssignableFrom(inputDataType)) {
				return null;
			}
		}
		return outputDataTypes;
	}

}
