/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation 
 ****************************************************************************/

package org.eclipselabs.mscript.typesystem;

/**
 * @author Andreas Unger
 *
 */
public class IntegerData extends NumericData {

	private final long value;

	/**
	 * 
	 */
	public IntegerData(long value) {
		this(value, false);
	}

	/**
	 * 
	 */
	public IntegerData(long value, boolean complex) {
		super(complex);
		this.value = value;
	}
	
	/**
	 * @return the value
	 */
	public long longValue() {
		return value;
	}
	
	public static IntegerData valueOf(String s) {
		boolean complex = s.endsWith("i") || s.endsWith("j");
		if (complex) {
			s = s.substring(0, s.length() - 1);
		}
		return new IntegerData(Long.parseLong(s), complex);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = Long.toString(value);
		if (isComplex()) {
			s += "i";
		}
		return s;
	}
	
}
