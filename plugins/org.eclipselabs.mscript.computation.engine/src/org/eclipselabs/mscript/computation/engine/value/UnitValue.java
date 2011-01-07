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
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;


/**
 * @author Andreas Unger
 *
 */
public class UnitValue extends AbstractValue {

	private Unit value;
	
	/**
	 * 
	 */
	public UnitValue(IComputationContext context, Unit value) {
		super(context);
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public Unit getValue() {
		return value;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.execution.value.IValue#getDataType()
	 */
	public DataType getDataType() {
		return TypeSystemUtil.UNIT_TYPE;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doConvert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(DataType dataType) {
		return this;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doMultiply(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doMultiply(IValue other, DataType resultDataType) {
		if (other instanceof Unit) {
			return new UnitValue(getContext(), value.multiply(((UnitValue) other).value));
		}
		return InvalidValue.SINGLETON;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doDivide(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doDivide(IValue other, DataType resultDataType) {
		if (other instanceof Unit) {
			return new UnitValue(getContext(), value.divide(((UnitValue) other).value));
		}
		return InvalidValue.SINGLETON;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doEqualTo(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doEqualTo(IValue other, DataType resultDataType) {
		UnitValue otherUnitValue = (UnitValue) other;
		if (value == null && otherUnitValue.value == null) {
			return new BooleanValue(getContext(), true);
		}
		if (value == null || otherUnitValue == null) {
			return new BooleanValue(getContext(), false);
		}
		return new BooleanValue(getContext(), value.isSameAs(otherUnitValue.value, false));
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doNotEqualTo(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doNotEqualTo(IValue other, DataType resultDataType) {
		UnitValue otherUnitValue = (UnitValue) other;
		if (value == null && otherUnitValue.value == null) {
			return new BooleanValue(getContext(), false);
		}
		if (value == null || otherUnitValue == null) {
			return new BooleanValue(getContext(), true);
		}
		return new BooleanValue(getContext(), !value.isSameAs(otherUnitValue.value, false));
	}
	
}
