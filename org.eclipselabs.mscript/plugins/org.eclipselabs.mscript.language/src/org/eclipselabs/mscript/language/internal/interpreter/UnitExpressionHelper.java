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

package org.eclipselabs.mscript.language.internal.interpreter;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipselabs.mscript.language.ast.UnitExpression;
import org.eclipselabs.mscript.language.ast.UnitExpressionFactor;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.UnitFactor;
import org.eclipselabs.mscript.typesystem.UnitSymbol;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class UnitExpressionHelper {

	private Map<String, List<UnitFactor>> cachedFactorMap;
	
	public Unit evaluate(UnitExpression expression) throws InvalidUnitExpressionOperandException {
		Unit unit = TypeSystemUtil.createUnit();
		if (expression.getNumerator() != null) {
			for (UnitExpressionFactor factor : expression.getNumerator().getFactors()) {
				evaluateFactor(factor, false, unit);
			}
		}
		if (expression.getDenominator() != null) {
			for (UnitExpressionFactor factor : expression.getDenominator().getFactors()) {
				evaluateFactor(factor, true, unit);
			}
		}
		return unit;
	}
	
	private void evaluateFactor(UnitExpressionFactor factor, boolean reciprocal, Unit unit) throws InvalidUnitExpressionOperandException {
		int scale = 0;
		List<UnitFactor> factors = null;

		String symbolString = factor.getOperand();
		
		if (symbolString.equals("g")) {
			factors = Collections.singletonList(createUnitFactor(UnitSymbol.KILOGRAM, 1));
			scale = -3;
		} else {
			factors = normalizeSymbol(symbolString);
			if (factors == null) {
				if (symbolString.length() < 2) {
					throw new InvalidUnitExpressionOperandException(factor);
				}
				if (symbolString.substring(1).equals("g")) {
					scale = getScale(symbolString.charAt(0));
					if (scale == 0) {
						throw new InvalidUnitExpressionOperandException(factor);
					}
					factors = Collections.singletonList(createUnitFactor(UnitSymbol.KILOGRAM, 1));
					scale -= 3;
				} else {
					factors = normalizeSymbol(symbolString.substring(1));
					if (factors == null) {
						if (symbolString.length() < 3 || !symbolString.startsWith("da")) {
							throw new InvalidUnitExpressionOperandException(factor);
						}
						scale = 1;
						if (symbolString.substring(2).equals("g")) {
							factors = Collections.singletonList(createUnitFactor(UnitSymbol.KILOGRAM, 1));
							scale -= 3;
						} else {
							factors = normalizeSymbol(symbolString.substring(2));
							if (factors == null) {
								throw new InvalidUnitExpressionOperandException(factor);
							}
						}
					} else {
						scale = getScale(symbolString.charAt(0));
						if (scale == 0) {
							throw new InvalidUnitExpressionOperandException(factor);
						}
					}
				}
			}
		}
				
		// TODO: use factor.isSetExponent() after switching to imported Ecore model
		int exponent = factor.getExponent();
		if (exponent == 0) {
			exponent = 1;
		}
		
		if (reciprocal) {
			exponent = -exponent;
		}
		
		if (unit != null) {
			unit.setScale(unit.getScale() + scale * exponent);
			addFactorsToUnit(unit, factors, exponent);
		}
	}
	
	private int getScale(char prefix) {
		switch (prefix) {
		case 'Y':
			return 24; 
		case 'Z':
			return 21;
		case 'E':
			return 18;
		case 'P':
			return 15;
		case 'T':
			return 12;
		case 'G':
			return 9;
		case 'M':
			return 6;
		case 'k':
			return 3;
		case 'h':
			return 2;
		case 'd':
			return -1;
		case 'c':
			return -2;
		case 'm':
			return -3;
		case 'u':
			return -6;
		case 'n':
			return -9;
		case 'p':
			return -12;
		case 'f':
			return -15;
		case 'a':
			return -18;
		case 'z':
			return -21;
		case 'y':
			return -24;
		}
		return 0;
	}
	
	private void addFactorsToUnit(Unit unit, List<UnitFactor> factors, int exponent) {
		for (UnitFactor factor : factors) {
			UnitFactor existingFactor = unit.getFactor(factor.getSymbol());
			existingFactor.setExponent(existingFactor.getExponent() + exponent * factor.getExponent());
		}
	}

	private List<UnitFactor> normalizeSymbol(String symbol) {
		return getFactorMap().get(symbol);
	}
	
	private Map<String, List<UnitFactor>> getFactorMap() {
		if (cachedFactorMap == null) {
			cachedFactorMap = createFactorMap();
		}
		return cachedFactorMap;
	}
	
	private Map<String, List<UnitFactor>> createFactorMap() {
		Map<String, List<UnitFactor>> factorMap = new HashMap<String, List<UnitFactor>>();
		fillFactorMapWithBaseUnits(factorMap);
		fillFactorMapWithDerivedUnits(factorMap);
		return factorMap;
	}
	
	private void fillFactorMapWithBaseUnits(Map<String, List<UnitFactor>> factorMap) {
		factorMap.put("m", Collections.singletonList(createUnitFactor(UnitSymbol.METER, 1)));
		factorMap.put("kg", Collections.singletonList(createUnitFactor(UnitSymbol.KILOGRAM, 1)));
		factorMap.put("s", Collections.singletonList(createUnitFactor(UnitSymbol.SECOND, 1)));
		factorMap.put("A", Collections.singletonList(createUnitFactor(UnitSymbol.AMPERE, 1)));
		factorMap.put("K", Collections.singletonList(createUnitFactor(UnitSymbol.KELVIN, 1)));
		factorMap.put("mol", Collections.singletonList(createUnitFactor(UnitSymbol.MOLE, 1)));
		factorMap.put("cd", Collections.singletonList(createUnitFactor(UnitSymbol.CANDELA, 1)));
	}
	
	private void fillFactorMapWithDerivedUnits(Map<String, List<UnitFactor>> factorMap) {
		factorMap.put("Hz", Collections.singletonList(createUnitFactor(UnitSymbol.SECOND, -1)));
		factorMap.put("rad", Arrays.asList(new UnitFactor[] {}));
		factorMap.put("sr", Arrays.asList(new UnitFactor[] {}));
		factorMap.put("N", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.KILOGRAM, 1),
				createUnitFactor(UnitSymbol.METER, 1),
				createUnitFactor(UnitSymbol.SECOND, -2)}));
		factorMap.put("Pa", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.METER, -1),
				createUnitFactor(UnitSymbol.KILOGRAM, 1),
				createUnitFactor(UnitSymbol.SECOND, -2)}));
		factorMap.put("J", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.METER, 2),
				createUnitFactor(UnitSymbol.KILOGRAM, 1),
				createUnitFactor(UnitSymbol.SECOND, -2)}));
		factorMap.put("W", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.METER, 2),
				createUnitFactor(UnitSymbol.KILOGRAM, 1),
				createUnitFactor(UnitSymbol.SECOND, -3)}));
		factorMap.put("C", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.SECOND, 1),
				createUnitFactor(UnitSymbol.AMPERE, 1)}));
		factorMap.put("V", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.METER, 2),
				createUnitFactor(UnitSymbol.KILOGRAM, 1),
				createUnitFactor(UnitSymbol.SECOND, -3),
				createUnitFactor(UnitSymbol.AMPERE, -1)}));
		factorMap.put("F", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.METER, -2),
				createUnitFactor(UnitSymbol.KILOGRAM, -1),
				createUnitFactor(UnitSymbol.SECOND, 4),
				createUnitFactor(UnitSymbol.AMPERE, 2)}));
		factorMap.put("Ohm", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.METER, 2),
				createUnitFactor(UnitSymbol.KILOGRAM, 1),
				createUnitFactor(UnitSymbol.SECOND, -3),
				createUnitFactor(UnitSymbol.AMPERE, -2)}));
		factorMap.put("S", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.METER, -2),
				createUnitFactor(UnitSymbol.KILOGRAM, -1),
				createUnitFactor(UnitSymbol.SECOND, 3),
				createUnitFactor(UnitSymbol.AMPERE, 2)}));
		factorMap.put("Wb", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.METER, 2),
				createUnitFactor(UnitSymbol.KILOGRAM, 1),
				createUnitFactor(UnitSymbol.SECOND, -2),
				createUnitFactor(UnitSymbol.AMPERE, -1)}));
		factorMap.put("T", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.KILOGRAM, 1),
				createUnitFactor(UnitSymbol.SECOND, -2),
				createUnitFactor(UnitSymbol.AMPERE, -1)}));
		factorMap.put("H", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.METER, 2),
				createUnitFactor(UnitSymbol.KILOGRAM, 1),
				createUnitFactor(UnitSymbol.SECOND, -2),
				createUnitFactor(UnitSymbol.AMPERE, -2)}));
		factorMap.put("lm", Arrays.asList(new UnitFactor[] {createUnitFactor(UnitSymbol.CANDELA, 1)}));
		factorMap.put("lx", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.METER, -2),
				createUnitFactor(UnitSymbol.CANDELA, 1)}));
		factorMap.put("Bq", Collections.singletonList(createUnitFactor(UnitSymbol.SECOND, -1)));
		factorMap.put("Gy", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.METER, 2),
				createUnitFactor(UnitSymbol.SECOND, -2)}));
		factorMap.put("Sv", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.METER, 2),
				createUnitFactor(UnitSymbol.SECOND, -2)}));
		factorMap.put("kat", Arrays.asList(new UnitFactor[] {
				createUnitFactor(UnitSymbol.SECOND, -1),
				createUnitFactor(UnitSymbol.MOLE, 1)}));
	}
	
	private static UnitFactor createUnitFactor(UnitSymbol symbol, int exponent) {
		UnitFactor factor = TypeSystemFactory.eINSTANCE.createUnitFactor();
		factor.setSymbol(symbol);
		factor.setExponent(exponent);
		return factor;
	}

}
