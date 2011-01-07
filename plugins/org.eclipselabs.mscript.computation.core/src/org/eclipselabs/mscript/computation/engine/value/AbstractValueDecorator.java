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

import java.util.List;

import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractValueDecorator implements IValue {

	private IValue decoratedValue;
	
	/**
	 * 
	 */
	public AbstractValueDecorator(IValue decoratedValue) {
		this.decoratedValue = decoratedValue;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#getDataType()
	 */
	public DataType getDataType() {
		return decoratedValue.getDataType();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#convert(org.eclipselabs.mscript.typesystem.DataType)
	 */
	public IValue convert(DataType dataType) {
		return decoratedValue.convert(dataType);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#add(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue add(IValue other) {
		return decoratedValue.add(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#subtract(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue subtract(IValue other) {
		return decoratedValue.subtract(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#multiply(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue multiply(IValue other) {
		return decoratedValue.multiply(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#divide(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue divide(IValue other) {
		return decoratedValue.divide(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#elementWiseMultiply(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue elementWiseMultiply(IValue other) {
		return decoratedValue.elementWiseMultiply(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#elementWiseDivide(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue elementWiseDivide(IValue other) {
		return decoratedValue.elementWiseDivide(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#power(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue power(IValue other) {
		return decoratedValue.power(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#unaryMinus()
	 */
	public IValue unaryMinus() {
		return decoratedValue.unaryMinus();
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#lessThan(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue lessThan(IValue other) {
		return decoratedValue.lessThan(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#lessThanOrEqualTo(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue lessThanOrEqualTo(IValue other) {
		return decoratedValue.lessThanOrEqualTo(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#greaterThan(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue greaterThan(IValue other) {
		return decoratedValue.greaterThan(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#greaterThanOrEqualTo(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue greaterThanOrEqualTo(IValue other) {
		return decoratedValue.greaterThanOrEqualTo(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#equalTo(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue equalTo(IValue other) {
		return decoratedValue.equalTo(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#notEqualTo(org.eclipselabs.mscript.interpreter.value.IValue)
	 */
	public IValue notEqualTo(IValue other) {
		return decoratedValue.notEqualTo(other);
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.interpreter.value.IValue#getProperty(java.lang.String, java.util.List)
	 */
	public IValue getProperty(String name, List<IValue> arguments) {
		return decoratedValue.getProperty(name, arguments);
	}

}
