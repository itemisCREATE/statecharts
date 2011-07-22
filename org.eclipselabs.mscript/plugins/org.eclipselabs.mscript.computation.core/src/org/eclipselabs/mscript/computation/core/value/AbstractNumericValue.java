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

import org.eclipselabs.mscript.computation.computationmodel.NumberFormat;
import org.eclipselabs.mscript.computation.computationmodel.util.ComputationModelUtil;
import org.eclipselabs.mscript.computation.core.IComputationContext;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractNumericValue extends AbstractExplicitDataTypeValue implements INumericValue {

	private NumberFormat numberFormat;
	
	public AbstractNumericValue(IComputationContext context, NumericType dataType, NumberFormat numberFormat) {
		super(context, dataType);
		this.numberFormat = numberFormat;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.computation.core.value.AbstractExplicitDataTypeValue#getDataType()
	 */
	@Override
	public NumericType getDataType() {
		return (NumericType) super.getDataType();
	}

	protected NumberFormat getNumberFormat() {
		return numberFormat;
	}
	
	protected IValue doAdd(IValue other, DataType resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat resultNumberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		
		AbstractNumericValue leftOperand = cast(resultNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(resultNumberFormat);
		
		return leftOperand.basicAdd(rightOperand, (NumericType) resultDataType);
	}

	protected abstract AbstractNumericValue basicAdd(AbstractNumericValue other, NumericType resultDataType);
	
	protected IValue doSubtract(IValue other, DataType resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat resultNumberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		
		AbstractNumericValue leftOperand = cast(resultNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(resultNumberFormat);
		
		return leftOperand.basicSubtract(rightOperand, (NumericType) resultDataType);
	}

	protected abstract AbstractNumericValue basicSubtract(AbstractNumericValue other, NumericType resultDataType);

	protected IValue doMultiply(IValue other, DataType resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat resultNumberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		
		AbstractNumericValue leftOperand = cast(resultNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(resultNumberFormat);
		
		return leftOperand.basicMultiply(rightOperand, (NumericType) resultDataType);
	}

	protected abstract AbstractNumericValue basicMultiply(AbstractNumericValue other, NumericType resultDataType);

	protected IValue doDivide(IValue other, DataType resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat resultNumberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		
		AbstractNumericValue leftOperand = cast(resultNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(resultNumberFormat);
		
		return leftOperand.basicDivide(rightOperand, (NumericType) resultDataType);
	}

	protected abstract AbstractNumericValue basicDivide(AbstractNumericValue other, NumericType resultDataType);

	protected IValue doNegate(DataType resultDataType) {
		NumberFormat resultNumberFormat = getContext().getComputationModel().getNumberFormat(resultDataType);
		
		AbstractNumericValue operand = cast(resultNumberFormat);
		
		return operand.basicUnaryMinus((NumericType) resultDataType);
	}

	protected abstract AbstractNumericValue basicUnaryMinus(NumericType resultDataType);
	
	protected IValue doLessThan(IValue other, DataType resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat widestNumberFormat = getWidestNumberFormat(other);
		
		AbstractNumericValue leftOperand = cast(widestNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(widestNumberFormat);

		return leftOperand.basicLessThan(rightOperand, resultDataType);
	}

	protected abstract IValue basicLessThan(AbstractNumericValue other, DataType resultDataType);

	protected IValue doLessThanOrEqualTo(IValue other, DataType resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat widestNumberFormat = getWidestNumberFormat(other);
		
		AbstractNumericValue leftOperand = cast(widestNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(widestNumberFormat);

		return leftOperand.basicLessThanOrEqualTo(rightOperand, resultDataType);
	}

	protected abstract IValue basicLessThanOrEqualTo(AbstractNumericValue other, DataType resultDataType);

	protected IValue doGreaterThan(IValue other, DataType resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat widestNumberFormat = getWidestNumberFormat(other);
		
		AbstractNumericValue leftOperand = cast(widestNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(widestNumberFormat);

		return leftOperand.basicGreaterThan(rightOperand, resultDataType);
	}

	protected abstract IValue basicGreaterThan(AbstractNumericValue other, DataType resultDataType);

	protected IValue doGreaterThanOrEqualTo(IValue other, DataType resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat widestNumberFormat = getWidestNumberFormat(other);
		
		AbstractNumericValue leftOperand = cast(widestNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(widestNumberFormat);

		return leftOperand.basicGreaterThanOrEqualTo(rightOperand, resultDataType);
	}

	protected abstract IValue basicGreaterThanOrEqualTo(AbstractNumericValue other, DataType resultDataType);

	protected IValue doEqualTo(IValue other, DataType resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat widestNumberFormat = getWidestNumberFormat(other);
		
		AbstractNumericValue leftOperand = cast(widestNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(widestNumberFormat);

		return leftOperand.basicEqualTo(rightOperand, resultDataType);
	}

	protected abstract IValue basicEqualTo(AbstractNumericValue other, DataType resultDataType);

	protected IValue doNotEqualTo(IValue other, DataType resultDataType) {
		AbstractNumericValue otherRealValue = (AbstractNumericValue) other;
		NumberFormat widestNumberFormat = getWidestNumberFormat(other);
		
		AbstractNumericValue leftOperand = cast(widestNumberFormat);
		AbstractNumericValue rightOperand = otherRealValue.cast(widestNumberFormat);

		return leftOperand.basicNotEqualTo(rightOperand, resultDataType);
	}

	protected abstract IValue basicNotEqualTo(AbstractNumericValue other, DataType resultDataType);

	protected abstract AbstractNumericValue cast(NumberFormat numberFormat);

	/**
	 * @param other
	 * @return
	 */
	private NumberFormat getWidestNumberFormat(IValue other) {
		DataType dataType1 = TypeSystemUtil.getLeftHandDataType(getDataType(), other.getDataType());
		DataType dataType2 = TypeSystemUtil.getLeftHandDataType(other.getDataType(), getDataType());
		
		NumberFormat numberFormat1 = getContext().getComputationModel().getNumberFormat(dataType1);
		NumberFormat numberFormat2 = getContext().getComputationModel().getNumberFormat(dataType2);
	
		return ComputationModelUtil.getWidestNumberFormat(numberFormat1, numberFormat2);
	}
	
}
