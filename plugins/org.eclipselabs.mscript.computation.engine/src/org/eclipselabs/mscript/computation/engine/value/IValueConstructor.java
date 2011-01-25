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
import org.eclipselabs.mscript.typesystem.NumericType;

/**
 * @author Andreas Unger
 *
 */
public interface IValueConstructor {

	ISimpleNumericValue construct(IComputationContext context, NumericType numericType, double value);
	ISimpleNumericValue construct(IComputationContext context, NumericType numericType, long value);
	IBooleanValue construct(IComputationContext context, boolean value);
	
}
