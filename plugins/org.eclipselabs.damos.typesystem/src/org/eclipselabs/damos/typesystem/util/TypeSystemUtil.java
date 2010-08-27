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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;
import org.eclipselabs.damos.typesystem.Unit;
import org.eclipselabs.damos.typesystem.UnitFactor;
import org.eclipselabs.damos.typesystem.UnitSymbol;

/**
 * @author Andreas Unger
 *
 */
public class TypeSystemUtil {
	
	public static Unit createUnit() {
		return createUnit(0);
	}

	public static Unit createUnit(UnitSymbol... symbols) {
		return createUnit(0, symbols);
	}
	
	public static Unit createUnit(int scale) {
		Unit unit = TypeSystemFactory.eINSTANCE.createUnit();
		unit.setScale(scale);
		for (UnitSymbol symbol : UnitSymbol.VALUES) {
			UnitFactor factor = TypeSystemFactory.eINSTANCE.createUnitFactor();
			factor.setSymbol(symbol);
			unit.getFactors().add(factor);
		}
		return unit;
	}
	
	public static Unit createUnit(int scale, UnitSymbol... symbols) {
		Unit unit = createUnit(scale);
		for (UnitSymbol symbol : symbols) {
			UnitFactor factor = unit.getFactor(symbol);
			factor.setExponent(factor.getExponent() + 1);
		}
		return unit;
	}
	
	@SuppressWarnings("unchecked")
	public static boolean equals(Unit unit1, Unit unit2, boolean ignoreScale) {
		if (ignoreScale) {
			return new EqualityHelper().equals(
					(List<EObject>) (List<?>) unit1.getFactors(),
					(List<EObject>) (List<?>) unit2.getFactors());
		}
		return EcoreUtil.equals(unit1, unit2); 
	}
		
}
