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

package org.eclipselabs.mscript.typesystem.internal.operations;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.UnitFactor;

/**
 * @author Andreas Unger
 *
 */
public class UnitOperations {
	
	private static final String METER = "m";
	private static final String KILOGRAM = "kg";
	private static final String SECOND = "s";
	private static final String AMPERE = "A";
	private static final String KELVIN = "K";
	private static final String MOLE = "mol";
	private static final String CANDELA = "cd";
	
	private static Map<String, List<UnitFactor>> cachedFactorMap;

	public static Unit getNormalized(Unit unit) {
		Unit result = TypeSystemFactory.eINSTANCE.createUnit();
		result.setNumerator(TypeSystemFactory.eINSTANCE.createUnitNumerator());
		
		try {
			if (unit.getNumerator() != null) {
				for (UnitFactor factor : unit.getNumerator().getFactors()) {
					evaluateFactor(factor, false, result);
				}
			}
			if (unit.getDenominator() != null) {
				for (UnitFactor factor : unit.getDenominator().getFactors()) {
					evaluateFactor(factor, true, result);
				}
			}
		} catch (InvalidUnitExpressionOperandException e) {
			return null;
		}

		return result;
	}

	private static void evaluateFactor(UnitFactor factor, boolean reciprocal, Unit result) throws InvalidUnitExpressionOperandException {
		int scale = 0;
		List<UnitFactor> factors = null;

		String symbolString = factor.getSymbol();
		
		if (symbolString.equals("g")) {
			factors = cachedFactorMap.get(KILOGRAM);
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
					factors = cachedFactorMap.get(KILOGRAM);
					scale -= 3;
				} else {
					factors = normalizeSymbol(symbolString.substring(1));
					if (factors == null) {
						if (symbolString.length() < 3 || !symbolString.startsWith("da")) {
							throw new InvalidUnitExpressionOperandException(factor);
						}
						scale = 1;
						if (symbolString.substring(2).equals("g")) {
							factors = cachedFactorMap.get(KILOGRAM);
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
				
		int exponent = factor.getExponent();
		
		if (reciprocal) {
			exponent = -exponent;
		}
		
		if (result != null) {
			result.setScale(result.getScale() + scale * exponent);
			addFactorsToUnit(result, factors, exponent);
		}
	}
	
	private static int getScale(char prefix) {
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
	
	private static void addFactorsToUnit(Unit unit, List<UnitFactor> factors, int exponent) {
		for (UnitFactor factor : factors) {
			UnitFactor existingFactor = unit.getNumerator().getFactor(factor.getSymbol());
			int newExponent = exponent * factor.getExponent();
			if (existingFactor != null) {
				newExponent += existingFactor.getExponent();
				if (newExponent != 0) {
					existingFactor.setExponent(newExponent);
				} else {
					unit.getNumerator().getFactors().remove(existingFactor);
				}
			} else if (newExponent != 0){
				UnitFactor newFactor = TypeSystemFactory.eINSTANCE.createUnitFactor();
				newFactor.setSymbol(factor.getSymbol());
				newFactor.setExponent(newExponent);
				unit.getNumerator().getFactors().add(newFactor);
			}
		}
	}

	private static List<UnitFactor> normalizeSymbol(String symbol) {
		return getFactorMap().get(symbol);
	}
	
	private static Map<String, List<UnitFactor>> getFactorMap() {
		if (cachedFactorMap == null) {
			cachedFactorMap = createFactorMap();
		}
		return cachedFactorMap;
	}
	
	private static Map<String, List<UnitFactor>> createFactorMap() {
		Map<String, List<UnitFactor>> factorMap = new HashMap<String, List<UnitFactor>>();
		fillFactorMapWithBaseUnits(factorMap);
		fillFactorMapWithDerivedUnits(factorMap);
		return factorMap;
	}
	
	private static void fillFactorMapWithBaseUnits(Map<String, List<UnitFactor>> factorMap) {
		factorMap.put(METER, Collections.singletonList(createUnitFactor(METER, 1)));
		factorMap.put(KILOGRAM, Collections.singletonList(createUnitFactor(KILOGRAM, 1)));
		factorMap.put(SECOND, Collections.singletonList(createUnitFactor(SECOND, 1)));
		factorMap.put(AMPERE, Collections.singletonList(createUnitFactor(AMPERE, 1)));
		factorMap.put(KELVIN, Collections.singletonList(createUnitFactor(KELVIN, 1)));
		factorMap.put(MOLE, Collections.singletonList(createUnitFactor(MOLE, 1)));
		factorMap.put(CANDELA, Collections.singletonList(createUnitFactor(CANDELA, 1)));
	}
	
	private static void fillFactorMapWithDerivedUnits(Map<String, List<UnitFactor>> factorMap) {
		factorMap.put("Hz", Collections.singletonList(createUnitFactor(SECOND, -1)));
		factorMap.put("rad", Arrays.asList(new UnitFactor[] {}));
		factorMap.put("sr", Arrays.asList(new UnitFactor[] {}));
		factorMap.put("N", Arrays.asList(new UnitFactor[] {
				createUnitFactor(KILOGRAM, 1),
				createUnitFactor(METER, 1),
				createUnitFactor(SECOND, -2)}));
		factorMap.put("Pa", Arrays.asList(new UnitFactor[] {
				createUnitFactor(METER, -1),
				createUnitFactor(KILOGRAM, 1),
				createUnitFactor(SECOND, -2)}));
		factorMap.put("J", Arrays.asList(new UnitFactor[] {
				createUnitFactor(METER, 2),
				createUnitFactor(KILOGRAM, 1),
				createUnitFactor(SECOND, -2)}));
		factorMap.put("W", Arrays.asList(new UnitFactor[] {
				createUnitFactor(METER, 2),
				createUnitFactor(KILOGRAM, 1),
				createUnitFactor(SECOND, -3)}));
		factorMap.put("C", Arrays.asList(new UnitFactor[] {
				createUnitFactor(SECOND, 1),
				createUnitFactor(AMPERE, 1)}));
		factorMap.put("V", Arrays.asList(new UnitFactor[] {
				createUnitFactor(METER, 2),
				createUnitFactor(KILOGRAM, 1),
				createUnitFactor(SECOND, -3),
				createUnitFactor(AMPERE, -1)}));
		factorMap.put("F", Arrays.asList(new UnitFactor[] {
				createUnitFactor(METER, -2),
				createUnitFactor(KILOGRAM, -1),
				createUnitFactor(SECOND, 4),
				createUnitFactor(AMPERE, 2)}));
		factorMap.put("Ohm", Arrays.asList(new UnitFactor[] {
				createUnitFactor(METER, 2),
				createUnitFactor(KILOGRAM, 1),
				createUnitFactor(SECOND, -3),
				createUnitFactor(AMPERE, -2)}));
		factorMap.put("S", Arrays.asList(new UnitFactor[] {
				createUnitFactor(METER, -2),
				createUnitFactor(KILOGRAM, -1),
				createUnitFactor(SECOND, 3),
				createUnitFactor(AMPERE, 2)}));
		factorMap.put("Wb", Arrays.asList(new UnitFactor[] {
				createUnitFactor(METER, 2),
				createUnitFactor(KILOGRAM, 1),
				createUnitFactor(SECOND, -2),
				createUnitFactor(AMPERE, -1)}));
		factorMap.put("T", Arrays.asList(new UnitFactor[] {
				createUnitFactor(KILOGRAM, 1),
				createUnitFactor(SECOND, -2),
				createUnitFactor(AMPERE, -1)}));
		factorMap.put("H", Arrays.asList(new UnitFactor[] {
				createUnitFactor(METER, 2),
				createUnitFactor(KILOGRAM, 1),
				createUnitFactor(SECOND, -2),
				createUnitFactor(AMPERE, -2)}));
		factorMap.put("lm", Arrays.asList(new UnitFactor[] {createUnitFactor(CANDELA, 1)}));
		factorMap.put("lx", Arrays.asList(new UnitFactor[] {
				createUnitFactor(METER, -2),
				createUnitFactor(CANDELA, 1)}));
		factorMap.put("Bq", Collections.singletonList(createUnitFactor(SECOND, -1)));
		factorMap.put("Gy", Arrays.asList(new UnitFactor[] {
				createUnitFactor(METER, 2),
				createUnitFactor(SECOND, -2)}));
		factorMap.put("Sv", Arrays.asList(new UnitFactor[] {
				createUnitFactor(METER, 2),
				createUnitFactor(SECOND, -2)}));
		factorMap.put("kat", Arrays.asList(new UnitFactor[] {
				createUnitFactor(SECOND, -1),
				createUnitFactor(MOLE, 1)}));
	}
	
	public static Unit evaluate(Unit unit, OperatorKind operator, Unit other) {
		switch (operator) {
		case ADD:
		case SUBTRACT:
			if (unit.isEquivalentTo(other, false)) {
				if (isLongerThan(unit, other)) {
					return EcoreUtil.copy(other); 
				}
				return EcoreUtil.copy(unit);
			}
			return null;
		case MULTIPLY:
			unit = unit.getNormalized();
			other = other.getNormalized();
			unit.setScale(unit.getScale() + other.getScale());
			for (UnitFactor otherFactor : other.getNumerator().getFactors()) {
				UnitFactor factor = unit.getNumerator().getFactor(otherFactor.getSymbol());
				if (factor != null) {
					factor.setExponent(factor.getExponent() + otherFactor.getExponent());
				} else {
					factor = createUnitFactor(otherFactor.getSymbol(), otherFactor.getExponent());
					unit.getNumerator().getFactors().add(factor);
				}
			}
			return unit;
		case DIVIDE:
			unit = unit.getNormalized();
			other = other.getNormalized();
			unit.setScale(unit.getScale() - other.getScale());
			for (UnitFactor otherFactor : other.getNumerator().getFactors()) {
				UnitFactor factor = unit.getNumerator().getFactor(otherFactor.getSymbol());
				if (factor != null) {
					factor.setExponent(factor.getExponent() - otherFactor.getExponent());
				} else {
					factor = createUnitFactor(otherFactor.getSymbol(), -otherFactor.getExponent());
					unit.getNumerator().getFactors().add(factor);
				}
			}
			return unit;
		case NEGATE:
			return EcoreUtil.copy(unit);
		}
		return null;
	}
	
	public static Unit evaluate(Unit unit, OperatorKind operator, int n) {
		switch (operator) {
		case POWER:
			unit = unit.getNormalized();
			
			unit.setScale(unit.getScale() * n);
			for (UnitFactor factor : unit.getNumerator().getFactors()) {
				factor.setExponent(factor.getExponent() * n);
			}
			
			return unit;
		case ROOT:
			unit = unit.getNormalized();
			
			if (unit.getScale() % n != 0) {
				return null;
			}
			unit.setScale(unit.getScale() / n);
			for (UnitFactor factor : unit.getNumerator().getFactors()) {
				int exponent = factor.getExponent();
				if (exponent % n != 0) {
					return null;
				}
				factor.setExponent(exponent / n);
			}
			
			return unit;
		}
		return null;
	}

	public static boolean isEquivalentTo(Unit unit, Unit other, boolean ignoreScale) {
		unit = unit.getNormalized();
		other = other.getNormalized();
		if (!ignoreScale && unit.getScale() != other.getScale()) {
			return false;
		}
		EList<UnitFactor> factors = unit.getNumerator().getFactors();
		EList<UnitFactor> otherFactors = other.getNumerator().getFactors();
		if (factors.size() != otherFactors.size()) {
			return false;
		}
		for (UnitFactor factor : factors) {
			UnitFactor otherFactor = other.getNumerator().getFactor(factor.getSymbol());
			if (otherFactor == null || otherFactor.getExponent() != factor.getExponent()) {
				return false;
			}
		}
		return true;
	}

	private static boolean isLongerThan(Unit unit, Unit other) {
		int numeratorSize = unit.getNumerator().getFactors().size();
		int denominatorSize = unit.getDenominator() != null ? unit.getDenominator().getFactors().size() : 0;
		int size = numeratorSize + denominatorSize;
		
		int otherNumeratorSize = other.getNumerator().getFactors().size();
		int otherDenominatorSize = other.getDenominator() != null ? other.getDenominator().getFactors().size() : 0;
		int otherSize = otherNumeratorSize + otherDenominatorSize;
		
		if (size < otherSize) {
			return false;
		}
		
		if (size > otherSize) {
			return true;
		}
		
		if (numeratorSize >= otherNumeratorSize) {
			return false;
		}
		
		return true;
	}

	private static UnitFactor createUnitFactor(String symbol, int exponent) {
		UnitFactor factor = TypeSystemFactory.eINSTANCE.createUnitFactor();
		factor.setSymbol(symbol);
		factor.setExponent(exponent);
		return factor;
	}

}
