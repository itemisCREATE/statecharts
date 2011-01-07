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

package org.eclipselabs.mscript.computation.engine.value;

import org.eclipselabs.mscript.computation.engine.IComputationContext;
import org.eclipselabs.mscript.typesystem.DataType;


/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractExplicitDataTypeValue extends AbstractValue {
	
	private DataType dataType;
	
	/**
	 * 
	 */
	public AbstractExplicitDataTypeValue(IComputationContext context, DataType dataType) {
		super(context);
		this.dataType = dataType;
	}
	
	public DataType getDataType() {
		return dataType;
	}
	
}
