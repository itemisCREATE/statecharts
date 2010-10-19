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

import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.RealType;

/**
 * @author Andreas Unger
 *
 */
public class ValueFactory implements IValueFactory {

	public IRealValue createRealValue(RealType realType, double value) {
		return new RealValue(realType, value);
	}
	
	public IIntegerValue createIntegerValue(IntegerType integerType, long value) {
		return new IntegerValue(integerType, value);
	}
	
	public IBooleanValue createBooleanValue(boolean value) {
		return new BooleanValue(value);
	}
	
}
