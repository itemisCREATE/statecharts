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
import org.eclipselabs.damos.typesystem.ArrayDimension;
import org.eclipselabs.damos.typesystem.ArrayType;
import org.eclipselabs.damos.typesystem.DataType;
import org.eclipselabs.damos.typesystem.NumericalType;
import org.eclipselabs.damos.typesystem.TensorType;
import org.eclipselabs.damos.typesystem.TypeSystemFactory;
import org.eclipselabs.damos.typesystem.Unit;
import org.eclipselabs.damos.typesystem.UnitFactor;
import org.eclipselabs.damos.typesystem.UnitSymbol;

/**
 * @author Andreas Unger
 *
 */
public class TypeSystemUtil {
	
	public static ArrayType createArrayType(DataType elementDataType, int... sizes) {
		if (elementDataType instanceof NumericalType) {
			throw new IllegalArgumentException();
		}
		ArrayType arrayType = TypeSystemFactory.eINSTANCE.createArrayType();
		arrayType.setElementType(elementDataType);
		initializeArrayDimensions(arrayType, sizes);
		return arrayType;
	}
	
	public static TensorType createTensorType(NumericalType elementDataType, int... sizes) {
		if (!(elementDataType instanceof NumericalType)) {
			throw new IllegalArgumentException();
		}
		TensorType tensorType = TypeSystemFactory.eINSTANCE.createTensorType();
		tensorType.setElementType(elementDataType);
		initializeArrayDimensions(tensorType, sizes);
		if (!elementDataType.isSetUnit()) {
			initializeTensorUnits(tensorType);
		}
		return tensorType;
	}
	
	private static void initializeArrayDimensions(ArrayType arrayType, int... sizes) {
		for (int size : sizes) {
			ArrayDimension dimension = TypeSystemFactory.eINSTANCE.createArrayDimension();
			dimension.setToIndex(size);
			arrayType.getDimensions().add(dimension);
		}
	}

	private static void initializeTensorUnits(TensorType tensorType) {
		tensorType.getUnits().clear();
		if (tensorType.getDimensionality() > 0) {
			int size = 1;
			for (ArrayDimension dimension : tensorType.getDimensions()) {
				size *= dimension.getSize();
			}
			for (int i = 0; i < size; ++i) {
				tensorType.getUnits().add(createUnit());
			}
		}
	}

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
	
	public static DataType getCommonDataType(DataType dataType1, DataType dataType2) {
		if (dataType1.isAssignableFrom(dataType2)) {
			return dataType1;
		} else if (dataType2.isAssignableFrom(dataType1)) {
			return dataType2;
		}
		return null;
	}
			
}
