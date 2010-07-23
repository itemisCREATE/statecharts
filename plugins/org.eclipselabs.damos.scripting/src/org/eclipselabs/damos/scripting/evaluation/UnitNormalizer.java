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

package org.eclipselabs.damos.scripting.evaluation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipselabs.damos.scripting.mscript.UnitExpression;
import org.eclipselabs.damos.scripting.mscript.UnitExpressionFactor;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;
import org.eclipselabs.damos.typesystem.Unit;
import org.eclipselabs.damos.typesystem.UnitFactor;
import org.eclipselabs.damos.typesystem.UnitSymbol;
import org.eclipselabs.damos.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class UnitNormalizer {

	private Map<String, List<UnitFactor>> cachedFactorMap;
	
	public Unit normalize(UnitExpression expression) throws InvalidUnitExpressionOperandException {
		Unit unit = TypeSystemFactory.eINSTANCE.createUnit();
		if (expression.getNumerator() != null) {
			for (UnitExpressionFactor factor : expression.getNumerator().getFactors()) {
				normalize(factor, false, unit);
			}
		}
		if (expression.getDenominator() != null) {
			for (UnitExpressionFactor factor : expression.getDenominator().getFactors()) {
				normalize(factor, true, unit);
			}
		}
		return unit;
	}
	
	public void normalize(UnitExpressionFactor factor, boolean reciprocal, Unit unit) throws InvalidUnitExpressionOperandException {
		int scale = 0;
		List<UnitFactor> factors = null;

		String symbolString = factor.getOperand();
		
		if (symbolString.equals("g")) {
			factors = Collections.singletonList(TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1));
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
					factors = Collections.singletonList(TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1));
					scale -= 3;
				} else {
					factors = normalizeSymbol(symbolString.substring(1));
					if (factors == null) {
						if (symbolString.length() < 3 || !symbolString.startsWith("da")) {
							throw new InvalidUnitExpressionOperandException(factor);
						}
						scale = 1;
						if (symbolString.substring(2).equals("g")) {
							factors = Collections.singletonList(TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1));
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
				
		int exponent = 1;
		if (factor.getExponent() != null) {
			exponent = (int) factor.getExponent().getValue();
			if (factor.getExponent().isNegative()) {
				exponent = -exponent;
			}
		}
		
		if (reciprocal) {
			exponent = -exponent;
		}
		
		if (unit != null) {
			unit.setScale(unit.getScale() + scale * exponent);
			addFactorsToUnit(unit, factors, exponent);
		}
	}
	
	protected int getScale(char prefix) {
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
	
	protected void addFactorsToUnit(Unit unit, List<UnitFactor> factors, int exponent) {
		for (UnitFactor factor : factors) {
			UnitFactor existingFactor = unit.getFactor(factor.getSymbol());
			if (existingFactor == null) {
				unit.getFactors().add(TypeSystemUtil.createUnitFactor(factor.getSymbol(), factor.getExponent() * exponent));
			} else {
				existingFactor.setExponent(existingFactor.getExponent() + factor.getExponent() * exponent);
			}
		}

		Collection<UnitFactor> factorsToBeRemoved = new ArrayList<UnitFactor>();
		for (UnitFactor factor : unit.getFactors()) {
			if (factor.getExponent() == 0) {
				factorsToBeRemoved.add(factor);
			}
		}
		unit.getFactors().removeAll(factorsToBeRemoved);
	}

	protected List<UnitFactor> normalizeSymbol(String symbol) {
		return getFactorMap().get(symbol);
	}
	
	protected Map<String, List<UnitFactor>> getFactorMap() {
		if (cachedFactorMap == null) {
			cachedFactorMap = createFactorMap();
		}
		return cachedFactorMap;
	}
	
	protected Map<String, List<UnitFactor>> createFactorMap() {
		Map<String, List<UnitFactor>> factorMap = new HashMap<String, List<UnitFactor>>();
		fillFactorMapWithBaseUnits(factorMap);
		fillFactorMapWithDerivedUnits(factorMap);
		return factorMap;
	}
	
	protected void fillFactorMapWithBaseUnits(Map<String, List<UnitFactor>> factorMap) {
		factorMap.put("m", Collections.singletonList(TypeSystemUtil.createUnitFactor(UnitSymbol.METER, 1)));
		factorMap.put("kg", Collections.singletonList(TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1)));
		factorMap.put("s", Collections.singletonList(TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, 1)));
		factorMap.put("A", Collections.singletonList(TypeSystemUtil.createUnitFactor(UnitSymbol.AMPERE, 1)));
		factorMap.put("K", Collections.singletonList(TypeSystemUtil.createUnitFactor(UnitSymbol.KELVIN, 1)));
		factorMap.put("mol", Collections.singletonList(TypeSystemUtil.createUnitFactor(UnitSymbol.MOLE, 1)));
		factorMap.put("cd", Collections.singletonList(TypeSystemUtil.createUnitFactor(UnitSymbol.CANDELA, 1)));
	}
	
	protected void fillFactorMapWithDerivedUnits(Map<String, List<UnitFactor>> factorMap) {
		factorMap.put("Hz", Collections.singletonList(TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -1)));
		factorMap.put("rad", Arrays.asList(new UnitFactor[] {}));
		factorMap.put("sr", Arrays.asList(new UnitFactor[] {}));
		factorMap.put("N", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, 1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -2)}));
		factorMap.put("Pa", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, -1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -2)}));
		factorMap.put("J", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, 2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -2)}));
		factorMap.put("W", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, 2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -3)}));
		factorMap.put("C", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, 1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.AMPERE, 1)}));
		factorMap.put("V", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, 2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -3),
				TypeSystemUtil.createUnitFactor(UnitSymbol.AMPERE, -1)}));
		factorMap.put("F", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, -2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, -1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, 4),
				TypeSystemUtil.createUnitFactor(UnitSymbol.AMPERE, 2)}));
		factorMap.put("Ohm", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, 2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -3),
				TypeSystemUtil.createUnitFactor(UnitSymbol.AMPERE, -2)}));
		factorMap.put("S", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, -2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, -1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, 3),
				TypeSystemUtil.createUnitFactor(UnitSymbol.AMPERE, 2)}));
		factorMap.put("Wb", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, 2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.AMPERE, -1)}));
		factorMap.put("T", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.AMPERE, -1)}));
		factorMap.put("H", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, 2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.KILOGRAM, 1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.AMPERE, -2)}));
		factorMap.put("lm", Arrays.asList(new UnitFactor[] {TypeSystemUtil.createUnitFactor(UnitSymbol.CANDELA, 1)}));
		factorMap.put("lx", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, -2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.CANDELA, 1)}));
		factorMap.put("Bq", Collections.singletonList(TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -1)));
		factorMap.put("Gy", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, 2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -2)}));
		factorMap.put("Sv", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.METER, 2),
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -2)}));
		factorMap.put("kat", Arrays.asList(new UnitFactor[] {
				TypeSystemUtil.createUnitFactor(UnitSymbol.SECOND, -1),
				TypeSystemUtil.createUnitFactor(UnitSymbol.MOLE, 1)}));
	}
	
}
