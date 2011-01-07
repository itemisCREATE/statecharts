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
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;


/**
 * @author Andreas Unger
 *
 */
public class BooleanValue extends AbstractValue implements IBooleanValue {
	
	private boolean value;

	/**
	 * 
	 */
	public BooleanValue(IComputationContext context, boolean value) {
		super(context);
		this.value = value;
	}
	
	public boolean booleanValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.value.IValue#getDataType()
	 */
	public DataType getDataType() {
		return TypeSystemUtil.BOOLEAN_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#convert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	public IValue doConvert(DataType dataType) {
		return this;
	}
		
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doEqualTo(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doEqualTo(IValue other, DataType resultDataType) {
		return new BooleanValue(getContext(), value == ((BooleanValue) other).value);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doNotEqualTo(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doNotEqualTo(IValue other, DataType resultDataType) {
		return new BooleanValue(getContext(), value != ((BooleanValue) other).value);
	}

}
