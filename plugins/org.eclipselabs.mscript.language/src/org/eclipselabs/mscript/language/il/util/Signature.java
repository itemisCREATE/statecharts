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
public class Signature implements ISignature {

	private DataType targetDataType;
	private List<DataType> inputParameterDataTypes;
	private List<DataType> outputParameterDataTypes;
	
	public Signature(DataType targetDataType, List<DataType> inputDataTypes, DataType outputDataType) {
		this(targetDataType, inputDataTypes, Collections.singletonList(outputDataType));
	}

	/**
	 * 
	 */
	public Signature(DataType targetDataType, List<DataType> inputDataTypes, List<DataType> outputDataTypes) {
		this.targetDataType = targetDataType;
		this.inputParameterDataTypes = inputDataTypes;
		this.outputParameterDataTypes = outputDataTypes;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ISignature#evaluateOutputDataTypes(java.util.List)
	 */
	public List<DataType> evaluateOutputParameterDataTypes(DataType targetDataType, List<DataType> inputParameterDataTypes) {
		if (!(this.targetDataType == targetDataType || this.targetDataType != null && targetDataType != null && this.targetDataType.isAssignableFrom(targetDataType))) {
			return null;
		}
		if (this.inputParameterDataTypes == inputParameterDataTypes) {
			return outputParameterDataTypes;
		}
		if (!(this.inputParameterDataTypes != null && inputParameterDataTypes != null && this.inputParameterDataTypes.size() == inputParameterDataTypes.size())) {
			return null;
		}
		Iterator<DataType> iterator = this.inputParameterDataTypes.iterator();
		for (DataType inputDataType : inputParameterDataTypes) {
			if (!iterator.next().isAssignableFrom(inputDataType)) {
				return null;
			}
		}
		return outputParameterDataTypes;
	}

}
