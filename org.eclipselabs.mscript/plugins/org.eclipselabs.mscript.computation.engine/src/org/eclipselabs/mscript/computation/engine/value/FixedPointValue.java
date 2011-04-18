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

import java.math.BigInteger;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.computation.engine.IComputationContext;
import org.eclipselabs.mscript.computation.engine.OverflowInfo;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;

/**
 * @author Andreas Unger
 *
 */
public class FixedPointValue extends AbstractNumericValue implements ISimpleNumericValue {

	private long rawValue;
	
	private static final BigInteger LONG_MIN_VALUE = BigInteger.valueOf(Long.MIN_VALUE);
	private static final BigInteger LONG_MAX_VALUE = BigInteger.valueOf(Long.MAX_VALUE);
	
	public FixedPointValue(IComputationContext context, NumericType dataType, FixedPointFormat numberFormat, long rawValue) {
		super(context, dataType, numberFormat);
		this.rawValue = rawValue;
	}

	protected long getRawValue() {
		return rawValue;
	}

	public double doubleValue() {
		return rawValue * Math.pow(2, -getNumberFormat().getFractionLength());
	}
	
	public long longValue() {
		return rawValue >> getNumberFormat().getFractionLength();
	}
	
	@Override
	protected FixedPointFormat getNumberFormat() {
		return (FixedPointFormat) super.getNumberFormat();
	}

	@Override
	protected IValue doConvert(DataType dataType) {
		NumberFormat numberFormat = getContext().getComputationModel().getNumberFormat(dataType);
		if (EcoreUtil.equals(numberFormat, getNumberFormat())) {
			return new FixedPointValue(getContext(), (NumericType) dataType, getNumberFormat(), rawValue);
		}
		return doCast((NumericType) dataType, numberFormat);
	}
	
	@Override
	protected AbstractNumericValue basicAdd(AbstractNumericValue other, NumericType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		
		if (getNumberFormat().getWordSize() > 32) {
			BigInteger result = BigInteger.valueOf(rawValue).add(BigInteger.valueOf(otherFixedPointValue.rawValue));
			return createValue(resultDataType, result, FixedPointOperationKind.ADD);
		}

		long result = rawValue + otherFixedPointValue.rawValue;
		return createValue(resultDataType, result, FixedPointOperationKind.ADD);
	}

	@Override
	protected AbstractNumericValue basicSubtract(AbstractNumericValue other, NumericType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		
		if (getNumberFormat().getWordSize() > 32) {
			BigInteger result = BigInteger.valueOf(rawValue).add(BigInteger.valueOf(otherFixedPointValue.rawValue));
			return createValue(resultDataType, result, FixedPointOperationKind.SUBTRACT);
		}

		long result = rawValue - otherFixedPointValue.rawValue;
		return createValue(resultDataType, result, FixedPointOperationKind.SUBTRACT);
	}
	
	@Override
	protected AbstractNumericValue basicMultiply(AbstractNumericValue other, NumericType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		
		long result;
		
		if (getNumberFormat().getWordSize() > 32) {
			BigInteger bigResult = BigInteger.valueOf(rawValue).multiply(BigInteger.valueOf(otherFixedPointValue.rawValue));
			if (bigResult.compareTo(LONG_MIN_VALUE) < 0 || bigResult.compareTo(LONG_MAX_VALUE) > 0) {
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			}
			result = bigResult.longValue();
		} else {
			result = rawValue * otherFixedPointValue.rawValue;
		}

		FixedPointOperation fixedPointOperation = ComputationModelUtil.getFixedPointOperation(getNumberFormat(), FixedPointOperationKind.MULTIPLY);
		
		long truncatedResult = truncate(result, fixedPointOperation.getIntermediateWordSize());
		if (truncatedResult != result) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		
		truncatedResult >>= getNumberFormat().getFractionLength();
		
		return createValue(resultDataType, truncatedResult, FixedPointOperationKind.MULTIPLY);
	}
	
	@Override
	protected AbstractNumericValue basicDivide(AbstractNumericValue other, NumericType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;

		long result;
		
		if (getNumberFormat().getWordSize() > 32) {
			BigInteger bigResult = BigInteger.valueOf(rawValue).shiftLeft(getNumberFormat().getFractionLength());
			if (bigResult.compareTo(LONG_MIN_VALUE) < 0 || bigResult.compareTo(LONG_MAX_VALUE) > 0) {
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			}
			result = bigResult.longValue();
		} else {
			result = rawValue << getNumberFormat().getFractionLength();
		}

		FixedPointOperation fixedPointOperation = ComputationModelUtil.getFixedPointOperation(getNumberFormat(), FixedPointOperationKind.DIVIDE);
		
		long truncatedResult = truncate(result, fixedPointOperation.getIntermediateWordSize());
		if (truncatedResult != result) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		
		truncatedResult /= otherFixedPointValue.rawValue;
		
		return createValue(resultDataType, truncatedResult, FixedPointOperationKind.DIVIDE);
	}
	
	@Override
	protected AbstractNumericValue basicUnaryMinus(NumericType resultDataType) {
		return new FixedPointValue(getContext(), getDataType(), getNumberFormat(), -rawValue);
	}
	
	@Override
	protected IValue basicLessThan(AbstractNumericValue other, DataType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue < otherFixedPointValue.rawValue);
	}
	
	@Override
	protected IValue basicLessThanOrEqualTo(AbstractNumericValue other, DataType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue <= otherFixedPointValue.rawValue);
	}
	
	@Override
	protected IValue basicGreaterThan(AbstractNumericValue other, DataType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue > otherFixedPointValue.rawValue);
	}
	
	@Override
	protected IValue basicGreaterThanOrEqualTo(AbstractNumericValue other, DataType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue >= otherFixedPointValue.rawValue);
	}
	
	@Override
	protected IValue basicEqualTo(AbstractNumericValue other, DataType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue == otherFixedPointValue.rawValue);
	}
	
	@Override
	protected IValue basicNotEqualTo(AbstractNumericValue other, DataType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue != otherFixedPointValue.rawValue);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.engine.value.ISimpleNumericValue#round()
	 */
	public IValue round() {
		/*
		 *  TODO: This needs to be reworked
		 */
		
		IntegerType resultDataType = TypeSystemFactory.eINSTANCE.createIntegerType();
		resultDataType.setUnit(EcoreUtil.copy(getDataType().getUnit()));
		
		FixedPointValue value;

		int fractionLength = getNumberFormat().getFractionLength();
		if (fractionLength == 0) {
			value = this;
		} else {
			long resultRawValue = rawValue + (1L << fractionLength - 1); // + 0.5
			long truncatedResult = truncate(resultRawValue, getNumberFormat().getWordSize());
			if (truncatedResult != resultRawValue) {
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			}
			value = new FixedPointValue(getContext(), resultDataType, getNumberFormat(), truncatedResult >> fractionLength << fractionLength);
		}
		
		return value.cast(getContext().getComputationModel().getNumberFormat(resultDataType));
	}
	
	protected AbstractNumericValue cast(NumberFormat numberFormat) {
		if (EcoreUtil.equals(numberFormat, getNumberFormat())) {
			return this;
		}
		return doCast(getDataType(), numberFormat);
	}
	
	private AbstractNumericValue doCast(NumericType numericType, NumberFormat numberFormat) {
		if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			switch (floatingPointFormat.getKind()) {
			case BINARY32:
				// TODO;
				break;
			case BINARY64:
				return castToBinary64(numericType, floatingPointFormat);
			}
		}
		
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			return castToFixedPoint(numericType, fixedPointFormat);
		}

		return null;
	}

	private AbstractNumericValue castToBinary64(NumericType numericType, FloatingPointFormat floatingPointFormat) {
		double value = rawValue * Math.pow(2, -getNumberFormat().getFractionLength());
		return new Binary64Value(getContext(), numericType, floatingPointFormat, value);
	}

	/**
	 * @param fixedPointFormat
	 * @return
	 */
	private AbstractNumericValue castToFixedPoint(NumericType numericType, FixedPointFormat fixedPointFormat) {
		FixedPointOperation operation = ComputationModelUtil.getFixedPointOperation(getNumberFormat(), FixedPointOperationKind.CAST);
		
		long truncatedRawValue = truncate(rawValue, operation.getIntermediateWordSize());
		
		if (truncatedRawValue != rawValue) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		
		long shiftedRawValue;

		int shift = fixedPointFormat.getFractionLength() - getNumberFormat().getFractionLength();
		if (shift < 0) {
			shiftedRawValue = truncatedRawValue >> -shift;
		} else if (shift > 0) {
			shiftedRawValue = truncatedRawValue << shift;
		} else {
			shiftedRawValue = truncatedRawValue;
		}
		
		long truncatedShiftedRawValue = truncate(shiftedRawValue, operation.getIntermediateWordSize());

		if (truncatedShiftedRawValue != shiftedRawValue) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		
		long minValue = -(1L << fixedPointFormat.getWordSize() - 1);
		long maxValue = (1L << fixedPointFormat.getWordSize() - 1) - 1;
		
		long newRawValue;
		
		if (operation.isSaturate()) {
			if (truncatedShiftedRawValue < minValue) {
				newRawValue = minValue;
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			} else if (truncatedShiftedRawValue > maxValue) {
				newRawValue = maxValue;
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			} else {
				newRawValue = truncatedShiftedRawValue;
			}
		} else {
			newRawValue = truncate(truncatedShiftedRawValue, fixedPointFormat.getWordSize());
			if (newRawValue != truncatedShiftedRawValue) {
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			}
		}
		
		return new FixedPointValue(getContext(), numericType, fixedPointFormat, newRawValue);
	}
	
	private long truncate(long value, int wordSize) {
		int shift = Long.SIZE - wordSize;
		return value << shift >> shift;
	}
	
	private AbstractNumericValue createValue(NumericType dataType, BigInteger rawValue, FixedPointOperationKind fixedPointOperationKind) {
		if (rawValue.compareTo(LONG_MIN_VALUE) < 0 || rawValue.compareTo(LONG_MAX_VALUE) > 0) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		return createValue(dataType, rawValue.longValue(), fixedPointOperationKind);
	}
	
	private AbstractNumericValue createValue(NumericType dataType, long rawValue, FixedPointOperationKind fixedPointOperationKind) {
		FixedPointOperation operation = ComputationModelUtil.getFixedPointOperation(getNumberFormat(), fixedPointOperationKind);

		long truncatedRawValue = truncate(rawValue, operation.getIntermediateWordSize());
		
		if (truncatedRawValue != rawValue) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		
		long minValue = -(1L << getNumberFormat().getWordSize() - 1);
		long maxValue = (1L << getNumberFormat().getWordSize() - 1) - 1;
		
		long newRawValue;
		
		if (operation.isSaturate()) {
			if (truncatedRawValue < minValue) {
				newRawValue = minValue;
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			} else if (truncatedRawValue > maxValue) {
				newRawValue = maxValue;
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			} else {
				newRawValue = truncatedRawValue;
			}
		} else {
			newRawValue = truncate(truncatedRawValue, getNumberFormat().getWordSize());
			if (newRawValue != truncatedRawValue) {
				getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
			}
		}

		return new FixedPointValue(getContext(), dataType, getNumberFormat(), newRawValue);
	}
	
	static void initializeValue(IComputationContext context, FixedPointValue fixedPointValue, FixedPointOperation operation, double value) {
		FixedPointFormat fixedPointFormat = fixedPointValue.getNumberFormat();
		int wordSize = fixedPointFormat.getWordSize();
		
		double scalingFactor;
		if (fixedPointFormat.getFractionLength() > 0) {
			scalingFactor = Math.pow(2, fixedPointFormat.getFractionLength());
		} else {
			scalingFactor = 1.0;
		}
		
		double scaledValue = Math.round(value * scalingFactor);
		
		double minValue = -Math.pow(2, wordSize - 1);
		double maxValue = Math.pow(2, wordSize - 1) - 1;
		
		long rawValue;

		if (scaledValue < minValue) {
			context.getOverflowMonitor().handleOverflow(new OverflowInfo());
			rawValue = -(1L << wordSize - 1);
		} else if (scaledValue > maxValue) {
			context.getOverflowMonitor().handleOverflow(new OverflowInfo());
			rawValue = (1L << wordSize - 1) - 1;
		} else {
			rawValue = (long) scaledValue;
		}
		
		fixedPointValue.rawValue = rawValue;
	}
	
}
