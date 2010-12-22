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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.computation.core.IComputationContext;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class Binary64Value extends AbstractRealValue {

	private double value;
	
	public Binary64Value(IComputationContext context, NumericType dataType, FloatingPointFormat numberFormat, double value) {
		super(context, dataType, numberFormat);
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.INumericalValue#doubleValue()
	 */
	public double doubleValue() {
		return value;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#getNumberFormat()
	 */
	@Override
	protected FloatingPointFormat getNumberFormat() {
		return (FloatingPointFormat) super.getNumberFormat();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doConvert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(DataType dataType) {
//		if (dataType instanceof RealType) {
//			return new Binary64Value(getContext(), EcoreUtil.copy((RealType) dataType), value);
//		}
		return InvalidValue.SINGLETON;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicAdd(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.NumericType)
	 */
	@Override
	protected AbstractRealValue basicAdd(AbstractRealValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value + otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicSubtract(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.NumericType)
	 */
	@Override
	protected AbstractRealValue basicSubtract(AbstractRealValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value - otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicMultiply(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.NumericType)
	 */
	@Override
	protected AbstractRealValue basicMultiply(AbstractRealValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value * otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicDivide(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.NumericType)
	 */
	@Override
	protected AbstractRealValue basicDivide(AbstractRealValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value / otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicUnaryMinus(org.eclipselabs.mscript.typesystem.NumericType)
	 */
	@Override
	protected AbstractRealValue basicUnaryMinus(NumericType resultDataType) {
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), -value);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicLessThan(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue basicLessThan(AbstractRealValue other, DataType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value < otherBinary64Value.value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicLessThanOrEqualTo(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue basicLessThanOrEqualTo(AbstractRealValue other, DataType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value <= otherBinary64Value.value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicGreaterThan(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue basicGreaterThan(AbstractRealValue other, DataType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value > otherBinary64Value.value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicGreaterThanOrEqualTo(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue basicGreaterThanOrEqualTo(AbstractRealValue other, DataType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value >= otherBinary64Value.value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicEqualTo(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue basicEqualTo(AbstractRealValue other, DataType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value == otherBinary64Value.value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicNotEqualToOrEqualTo(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue basicNotEqualToOrEqualTo(AbstractRealValue other, DataType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value != otherBinary64Value.value);
	}
	
	protected AbstractRealValue cast(NumberFormat numberFormat) {
		if (EcoreUtil.equals(numberFormat, getNumberFormat())) {
			return this;
		}
		
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			FixedPointValue fixedPointValue = new FixedPointValue(getContext(), getDataType(), fixedPointFormat, 0);
			FixedPointOperation fixedPointOperation = ComputationModelUtil.getFixedPointOperation(fixedPointFormat,
					FixedPointOperationKind.CAST);
			FixedPointValue.initializeValue(getContext(), fixedPointValue, fixedPointOperation, value);
			return fixedPointValue;
		}

		return null;
	}

}
