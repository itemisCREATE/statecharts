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

package org.eclipselabs.mscript.language.interpreter.value;

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class AnyValue extends AbstractExplicitDataTypeValue {

	/**
	 * @param dataType
	 */
	public AnyValue(DataType dataType) {
		super(dataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doConvert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doConvert(DataType dataType) {
		return new AnyValue(EcoreUtil.copy(dataType));
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doAdd(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doAdd(IValue other, DataType resultDataType) {
		return new AnyValue(resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doSubtract(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doSubtract(IValue other, DataType resultDataType) {
		return new AnyValue(resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doMultiply(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doMultiply(IValue other, DataType resultDataType) {
		return new AnyValue(resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doDivide(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doDivide(IValue other, DataType resultDataType) {
		return new AnyValue(resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doElementWiseMultiply(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doElementWiseMultiply(IValue other, DataType resultDataType) {
		return new AnyValue(resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doElementWiseDivide(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doElementWiseDivide(IValue other, DataType resultDataType) {
		return new AnyValue(resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doUnaryMinus(org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doUnaryMinus(DataType resultDataType) {
		return new AnyValue(resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doLessThan(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doLessThan(IValue other, DataType resultDataType) {
		return new AnyValue(resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doLessThanOrEqualTo(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doLessThanOrEqualTo(IValue other, DataType resultDataType) {
		return new AnyValue(resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doGreaterThan(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doGreaterThan(IValue other, DataType resultDataType) {
		return new AnyValue(resultDataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doGreaterThanOrEqualTo(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doGreaterThanOrEqualTo(IValue other, DataType resultDataType) {
		return new AnyValue(resultDataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doEqualTo(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doEqualTo(IValue other, DataType resultDataType) {
		return new AnyValue(resultDataType);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.AbstractValue#doNotEqualTo(org.eclipselabs.mscript.interpreter.value.IValue, org.eclipselabs.mscript.typesystem.DataType)
	 */
	@Override
	protected IValue doNotEqualTo(IValue other, DataType resultDataType) {
		return new AnyValue(resultDataType);
	}

}
