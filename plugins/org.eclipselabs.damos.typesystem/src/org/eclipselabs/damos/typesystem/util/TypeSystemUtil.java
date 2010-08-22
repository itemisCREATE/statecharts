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

package org.eclipselabs.damos.typesystem.util;

import org.eclipselabs.damos.typesystem.TypeSystemFactory;
import org.eclipselabs.damos.typesystem.UnitFactor;
import org.eclipselabs.damos.typesystem.UnitSymbol;

/**
 * @author Andreas Unger
 *
 */
public class TypeSystemUtil {

	public static UnitFactor createUnitFactor(UnitSymbol symbol, int exponent) {
		UnitFactor factor = TypeSystemFactory.eINSTANCE.createUnitFactor();
		factor.setSymbol(symbol);
		factor.setExponent(exponent);
		return factor;
	}
	
}
