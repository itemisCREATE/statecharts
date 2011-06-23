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

package org.eclipselabs.mscript.computation.core.value;

import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;


/**
 * @author Andreas Unger
 *
 */
public class InvalidValue extends AbstractValue {
	
	public static final InvalidValue SINGLETON = new InvalidValue();
	
	/**
	 * 
	 */
	public InvalidValue() {
		super(null);
	}

	public DataType getDataType() {
		return TypeSystemUtil.INVALID_DATA_TYPE;
	}
	
	@Override
	protected IValue doConvert(DataType dataType) {
		return this;
	}

}
