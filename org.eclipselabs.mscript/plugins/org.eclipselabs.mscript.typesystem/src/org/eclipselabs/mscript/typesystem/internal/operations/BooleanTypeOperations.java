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

import org.eclipselabs.mscript.typesystem.BooleanType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;


public class BooleanTypeOperations extends PrimitiveTypeOperations {

	public static DataType evaluate(BooleanType booleanType, OperatorKind operator, DataType other) {
		if (operator == OperatorKind.LOGICAL_NOT) {
			return TypeSystemFactory.eINSTANCE.createBooleanType();
		}
		if (other instanceof BooleanType) {
			switch (operator) {
			case EQUAL_TO:
			case NOT_EQUAL_TO:
			case LOGICAL_AND:
			case LOGICAL_OR:
			case IMPLIES:
				return TypeSystemFactory.eINSTANCE.createBooleanType();
			}
		}
		return TypeSystemFactory.eINSTANCE.createInvalidDataType();
	}

	public static boolean isAssignableFrom(BooleanType booleanType, DataType other) {
		return other instanceof BooleanType;
	}

}
