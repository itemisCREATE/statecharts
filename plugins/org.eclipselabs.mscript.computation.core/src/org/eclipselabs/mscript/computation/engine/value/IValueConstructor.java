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
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.RealType;

/**
 * @author Andreas Unger
 *
 */
public interface IValueConstructor {

	ISimpleNumericValue createRealValue(IComputationContext context, RealType realType, double value);
	ISimpleNumericValue createIntegerValue(IComputationContext context, IntegerType integerType, long value);
	IBooleanValue createBooleanValue(IComputationContext context, boolean value);
	
}
