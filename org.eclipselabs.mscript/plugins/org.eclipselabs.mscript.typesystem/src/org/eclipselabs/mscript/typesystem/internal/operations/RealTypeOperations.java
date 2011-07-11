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

import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.Unit;

public class RealTypeOperations extends PrimitiveTypeOperations {

	public static DataType evaluate(RealType realType, OperatorKind operator, DataType other) {
		if (operator == OperatorKind.NEGATE) {
			return EcoreUtil.copy(realType);
		}
		
		if (!(other instanceof NumericType)) {
			return TypeSystemFactory.eINSTANCE.createInvalidDataType();
		}
		NumericType otherNumericType = (NumericType) other;

		switch (operator) {
		case LESS_THAN:
		case LESS_THAN_OR_EQUAL_TO:
		case GREATER_THAN:
		case GREATER_THAN_OR_EQUAL_TO:
		case EQUAL_TO:
		case NOT_EQUAL_TO:
			return TypeSystemFactory.eINSTANCE.createBooleanType();
		case ADD:
		case SUBTRACT:
		case MULTIPLY:
		case DIVIDE:
			Unit unit = realType.getUnit().evaluate(operator, otherNumericType.getUnit());
			if (unit != null) {
				NumericType result = TypeSystemFactory.eINSTANCE.createRealType();
				result.setUnit(unit);
				return result;
			}
			break;
		}

		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}

	public static DataType evaluate(RealType realType, OperatorKind operator, int n) {
		RealType result = TypeSystemFactory.eINSTANCE.createRealType();
		result.setUnit(realType.getUnit().evaluate(operator, n));
		return result;
	}

	public static boolean isAssignableFrom(RealType realType, DataType other) {
		if (other instanceof NumericType) {
			NumericType otherNumericType = (NumericType) other;
			return realType.getUnit().isWildcard() || realType.getUnit().isEquivalentTo(otherNumericType.getUnit(), false);
		}
		return false;
	}

}