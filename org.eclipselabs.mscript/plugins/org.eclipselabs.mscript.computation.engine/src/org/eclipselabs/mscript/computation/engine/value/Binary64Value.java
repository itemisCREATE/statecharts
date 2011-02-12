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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.computation.engine.IComputationContext;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;

/**
 * @author Andreas Unger
 *
 */
public class Binary64Value extends AbstractNumericValue implements ISimpleNumericValue {

	private double value;
	
	public Binary64Value(IComputationContext context, NumericType dataType, FloatingPointFormat numberFormat, double value) {
		super(context, dataType, numberFormat);
		this.value = value;
	}
	
	public double doubleValue() {
		return value;
	}
	
	public long longValue() {
		return (long) value;
	}
	
	@Override
	protected FloatingPointFormat getNumberFormat() {
		return (FloatingPointFormat) super.getNumberFormat();
	}

	@Override
	protected IValue doConvert(DataType dataType) {
		NumberFormat numberFormat = getContext().getComputationModel().getNumberFormat(dataType);
		if (EcoreUtil.equals(numberFormat, getNumberFormat())) {
			return new Binary64Value(getContext(), (NumericType) dataType, getNumberFormat(), value);
		}
		return doCast((NumericType) dataType, numberFormat);
	}
	
	@Override
	protected AbstractNumericValue basicAdd(AbstractNumericValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value + otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}

	@Override
	protected AbstractNumericValue basicSubtract(AbstractNumericValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value - otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}
	
	@Override
	protected AbstractNumericValue basicMultiply(AbstractNumericValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value * otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}
	
	@Override
	protected AbstractNumericValue basicDivide(AbstractNumericValue other, NumericType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		double result = value / otherBinary64Value.value;
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), result);
	}
	
	@Override
	protected AbstractNumericValue basicUnaryMinus(NumericType resultDataType) {
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), -value);
	}

	@Override
	protected IValue basicLessThan(AbstractNumericValue other, DataType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value < otherBinary64Value.value);
	}
	
	@Override
	protected IValue basicLessThanOrEqualTo(AbstractNumericValue other, DataType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value <= otherBinary64Value.value);
	}
	
	@Override
	protected IValue basicGreaterThan(AbstractNumericValue other, DataType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value > otherBinary64Value.value);
	}
	
	@Override
	protected IValue basicGreaterThanOrEqualTo(AbstractNumericValue other, DataType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value >= otherBinary64Value.value);
	}
	
	@Override
	protected IValue basicEqualTo(AbstractNumericValue other, DataType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value == otherBinary64Value.value);
	}
	
	@Override
	protected IValue basicNotEqualToOrEqualTo(AbstractNumericValue other, DataType resultDataType) {
		Binary64Value otherBinary64Value = (Binary64Value) other;
		return new BooleanValue(getContext(), value != otherBinary64Value.value);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.engine.value.ISimpleNumericValue#round()
	 */
	public IValue round() {
		IntegerType resultDataType = TypeSystemFactory.eINSTANCE.createIntegerType();
		resultDataType.setUnit(EcoreUtil.copy(getDataType().getUnit()));
		
		NumberFormat numberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		return new Binary64Value(getContext(), resultDataType, getNumberFormat(), Math.round(value)).cast(numberFormat);
	}
	
	protected AbstractNumericValue cast(NumberFormat numberFormat) {
		if (EcoreUtil.equals(numberFormat, getNumberFormat())) {
			return this;
		}
		return doCast(getDataType(), numberFormat);
	}

	protected AbstractNumericValue doCast(NumericType numericType, NumberFormat numberFormat) {
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			FixedPointValue fixedPointValue = new FixedPointValue(getContext(), numericType, fixedPointFormat, 0);
			FixedPointOperation fixedPointOperation = ComputationModelUtil.getFixedPointOperation(fixedPointFormat,
					FixedPointOperationKind.CAST);
			FixedPointValue.initializeValue(getContext(), fixedPointValue, fixedPointOperation, value);
			return fixedPointValue;
		}
		return null;
	}

}
