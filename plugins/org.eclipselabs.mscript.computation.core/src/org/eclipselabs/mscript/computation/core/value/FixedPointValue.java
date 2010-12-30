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

import java.math.BigInteger;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperation;
import org.eclipselabs.mscript.computation.computationmodel.FixedPointOperationKind;
import org.eclipselabs.mscript.computation.computationmodel.FloatingPointFormat;
import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.computation.core.IComputationContext;
import org.eclipselabs.mscript.computation.core.OverflowInfo;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public class FixedPointValue extends AbstractRealValue {

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

	/* (non-Javadoc)
	 * @see org.eclipselabs.damos.evaluation.INumericalValue#doubleValue()
	 */
	public double doubleValue() {
		return rawValue * Math.pow(2, -getNumberFormat().getFractionLength());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#getNumberFormat()
	 */
	@Override
	protected FixedPointFormat getNumberFormat() {
		return (FixedPointFormat) super.getNumberFormat();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doConvert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(DataType dataType) {
//		if (dataType instanceof IntegerType) {
//			return new FixedPointValue(getContext(), EcoreUtil.copy((IntegerType) dataType), rawValue);
//		}
//		if (dataType instanceof RealType) {
//			return new Binary64Value(getContext(), EcoreUtil.copy((RealType) dataType), rawValue);
//		}
		return InvalidValue.SINGLETON;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doAdd(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected AbstractRealValue basicAdd(AbstractRealValue other, NumericType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		
		if (getNumberFormat().getWordSize() > 32) {
			BigInteger result = BigInteger.valueOf(rawValue).add(BigInteger.valueOf(otherFixedPointValue.rawValue));
			return createValue(resultDataType, result, FixedPointOperationKind.ADD);
		}

		long result = rawValue + otherFixedPointValue.rawValue;
		return createValue(resultDataType, result, FixedPointOperationKind.ADD);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicSubtract(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.NumericType)
	 */
	@Override
	protected AbstractRealValue basicSubtract(AbstractRealValue other, NumericType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		
		if (getNumberFormat().getWordSize() > 32) {
			BigInteger result = BigInteger.valueOf(rawValue).add(BigInteger.valueOf(otherFixedPointValue.rawValue));
			return createValue(resultDataType, result, FixedPointOperationKind.SUBTRACT);
		}

		long result = rawValue - otherFixedPointValue.rawValue;
		return createValue(resultDataType, result, FixedPointOperationKind.SUBTRACT);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicMultiply(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.NumericType)
	 */
	@Override
	protected AbstractRealValue basicMultiply(AbstractRealValue other, NumericType resultDataType) {
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
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicDivide(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.NumericType)
	 */
	@Override
	protected AbstractRealValue basicDivide(AbstractRealValue other, NumericType resultDataType) {
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
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicUnaryMinus(org.eclipselabs.mscript.typesystem.NumericType)
	 */
	@Override
	protected AbstractRealValue basicUnaryMinus(NumericType resultDataType) {
		return new FixedPointValue(getContext(), getDataType(), getNumberFormat(), -rawValue);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicLessThan(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue basicLessThan(AbstractRealValue other, DataType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue < otherFixedPointValue.rawValue);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicLessThanOrEqualTo(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue basicLessThanOrEqualTo(AbstractRealValue other, DataType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue <= otherFixedPointValue.rawValue);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicGreaterThan(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue basicGreaterThan(AbstractRealValue other, DataType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue > otherFixedPointValue.rawValue);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicGreaterThanOrEqualTo(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue basicGreaterThanOrEqualTo(AbstractRealValue other, DataType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue >= otherFixedPointValue.rawValue);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicEqualTo(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue basicEqualTo(AbstractRealValue other, DataType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue == otherFixedPointValue.rawValue);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractRealValue#basicNotEqualToOrEqualTo(org.eclipselabs.mscript.computation.core.value.AbstractRealValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue basicNotEqualToOrEqualTo(AbstractRealValue other, DataType resultDataType) {
		FixedPointValue otherFixedPointValue = (FixedPointValue) other;
		return new BooleanValue(getContext(), rawValue != otherFixedPointValue.rawValue);
	}
	
	protected AbstractRealValue cast(NumberFormat numberFormat) {
		if (EcoreUtil.equals(numberFormat, getNumberFormat())) {
			return this;
		}
		
		if (numberFormat instanceof FloatingPointFormat) {
			FloatingPointFormat floatingPointFormat = (FloatingPointFormat) numberFormat;
			switch (floatingPointFormat.getKind()) {
			case BINARY32:
				// TODO;
				break;
			case BINARY64:
				return castToBinary64(floatingPointFormat);
			}
		}
		
		if (numberFormat instanceof FixedPointFormat) {
			FixedPointFormat fixedPointFormat = (FixedPointFormat) numberFormat;
			return castToFixedPoint(fixedPointFormat);
		}

		return null;
	}

	private AbstractRealValue castToBinary64(FloatingPointFormat floatingPointFormat) {
		double value = rawValue * Math.pow(2, -getNumberFormat().getFractionLength());
		return new Binary64Value(getContext(), getDataType(), floatingPointFormat, value);
	}

	/**
	 * @param fixedPointFormat
	 * @return
	 */
	private AbstractRealValue castToFixedPoint(FixedPointFormat fixedPointFormat) {
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

		if (truncatedShiftedRawValue != rawValue) {
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
		
		return new FixedPointValue(getContext(), getDataType(), fixedPointFormat, newRawValue);
	}
	
	private long truncate(long value, int wordSize) {
		int shift = Long.SIZE - wordSize;
		return value << shift >> shift;
	}
	
	private AbstractRealValue createValue(NumericType dataType, BigInteger rawValue, FixedPointOperationKind fixedPointOperationKind) {
		if (rawValue.compareTo(LONG_MIN_VALUE) < 0 || rawValue.compareTo(LONG_MAX_VALUE) > 0) {
			getContext().getOverflowMonitor().handleOverflow(new OverflowInfo());
		}
		return createValue(dataType, rawValue.longValue(), fixedPointOperationKind);
	}
	
	private AbstractRealValue createValue(NumericType dataType, long rawValue, FixedPointOperationKind fixedPointOperationKind) {
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
