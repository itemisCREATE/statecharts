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

package org.eclipselabs.mscript.typesystem.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil.EqualityHelper;
import org.eclipselabs.mscript.typesystem.ArrayDimension;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericalType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;
import org.eclipselabs.mscript.typesystem.UnitFactor;
import org.eclipselabs.mscript.typesystem.UnitSymbol;

/**
 * @author Andreas Unger
 *
 */
public class TypeSystemUtil {
	
	public static final DataType INVALID_DATA_TYPE = TypeSystemFactory.eINSTANCE.createInvalidDataType();
	public static final DataType BOOLEAN_TYPE = TypeSystemFactory.eINSTANCE.createBooleanType();
	public static final DataType STRING_TYPE = TypeSystemFactory.eINSTANCE.createStringType();
	
	
	public static ArrayType createArrayType(DataType elementType, int... sizes) {
		ArrayType arrayType = doCreateArrayType(elementType);
		initializeArrayDimensions(arrayType, sizes);
		return arrayType;
	}
	
	private static ArrayType doCreateArrayType(DataType elementType) {
		ArrayType arrayType;
		if (elementType instanceof NumericalType) {
			arrayType = TypeSystemFactory.eINSTANCE.createTensorType();
		} else {
			arrayType = TypeSystemFactory.eINSTANCE.createArrayType();
		}
		arrayType.setElementType(elementType);
		return arrayType;
	}
	
	private static void initializeArrayDimensions(ArrayType arrayType, int... sizes) {
		for (int size : sizes) {
			ArrayDimension dimension = TypeSystemFactory.eINSTANCE.createArrayDimension();
			dimension.setToIndex(size);
			arrayType.getDimensions().add(dimension);
		}
	}

	@SuppressWarnings("unchecked")
	public static boolean equalArrayDimensions(ArrayType arrayType1, ArrayType arrayType2) {
		return new EqualityHelper().equals(
				(List<EObject>) (List<?>) arrayType1.getDimensions(),
				(List<EObject>) (List<?>) arrayType2.getDimensions());
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
		
	public static DataType getLeftHandDataType(DataType dataType1, DataType dataType2) {
		if (dataType1.isAssignableFrom(dataType2)) {
			return dataType1;
		} else if (dataType2.isAssignableFrom(dataType1)) {
			return dataType2;
		}
		return null;
	}
				
}
