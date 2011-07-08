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

package org.eclipselabs.mscript.language.interpreter;

import org.eclipse.emf.ecore.EClass;
import org.eclipselabs.mscript.language.ast.ArrayDimensionSpecification;
import org.eclipselabs.mscript.language.ast.ArrayTypeSpecifier;
import org.eclipselabs.mscript.language.ast.BooleanTypeSpecifier;
import org.eclipselabs.mscript.language.ast.DataTypeSpecifier;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.IntegerTypeSpecifier;
import org.eclipselabs.mscript.language.ast.NumericTypeSpecifier;
import org.eclipselabs.mscript.language.ast.RealTypeSpecifier;
import org.eclipselabs.mscript.language.ast.StringTypeSpecifier;
import org.eclipselabs.mscript.language.ast.TensorTypeSpecifier;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.internal.interpreter.InvalidUnitExpressionOperandException;
import org.eclipselabs.mscript.language.internal.interpreter.UnitExpressionHelper;
import org.eclipselabs.mscript.typesystem.ArrayDimension;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.TypeSystemPackage;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeSpecifierEvaluator implements IDataTypeSpecifierEvaluator {

	private static final DataTypeSpecifierEvaluatorSwitch SWITCH = new DataTypeSpecifierEvaluatorSwitch();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.IDataTypeSpecifierEvaluator#evaluate(org.eclipselabs.mscript.language.interpreter.IInterpreterContext, org.eclipselabs.mscript.language.ast.DataTypeSpecifier)
	 */
	public DataType evaluate(IInterpreterContext interpreterContext, DataTypeSpecifier dataTypeSpecifier) {
		return SWITCH.doSwitch(dataTypeSpecifier);
	}
	
	private static class DataTypeSpecifierEvaluatorSwitch extends AstSwitch<DataType> {

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseRealTypeSpecifier(org.eclipselabs.mscript.language.ast.RealTypeSpecifier)
		 */
		@Override
		public DataType caseRealTypeSpecifier(RealTypeSpecifier realTypeSpecifier) {
			return createNumericType(TypeSystemPackage.eINSTANCE.getRealType(), realTypeSpecifier);
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerTypeSpecifier(org.eclipselabs.mscript.language.ast.IntegerTypeSpecifier)
		 */
		@Override
		public DataType caseIntegerTypeSpecifier(IntegerTypeSpecifier integerTypeSpecifier) {
			return createNumericType(TypeSystemPackage.eINSTANCE.getIntegerType(), integerTypeSpecifier);
		}
		
		private DataType createNumericType(EClass eClass, NumericTypeSpecifier numericTypeSpecifier) {
			NumericType numericType = (NumericType) TypeSystemFactory.eINSTANCE.create(eClass);
			if (numericTypeSpecifier.getUnit() != null) {
				if (numericTypeSpecifier.getUnit().getNumerator() != null) {
					try {
						numericType.setUnit(new UnitExpressionHelper().evaluate(numericTypeSpecifier.getUnit()));
					} catch (InvalidUnitExpressionOperandException e) {
						return TypeSystemFactory.eINSTANCE.createInvalidDataType();
					}
				}
			} else {
				numericType.setUnit(TypeSystemUtil.createUnit());
			}
			
			return numericType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanTypeSpecifier(org.eclipselabs.mscript.language.ast.BooleanTypeSpecifier)
		 */
		@Override
		public DataType caseBooleanTypeSpecifier(BooleanTypeSpecifier booleanTypeSpecifier) {
			return TypeSystemFactory.eINSTANCE.createBooleanType();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringTypeSpecifier(org.eclipselabs.mscript.language.ast.StringTypeSpecifier)
		 */
		@Override
		public DataType caseStringTypeSpecifier(StringTypeSpecifier stringTypeSpecifier) {
			return TypeSystemFactory.eINSTANCE.createStringType();
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseArrayTypeSpecifier(org.eclipselabs.mscript.language.ast.ArrayTypeSpecifier)
		 */
		@Override
		public DataType caseArrayTypeSpecifier(ArrayTypeSpecifier arrayTypeSpecifier) {
			ArrayType arrayType = TypeSystemFactory.eINSTANCE.createArrayType();
			initializeArrayType(arrayType, arrayTypeSpecifier);
			return arrayType;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseTensorTypeSpecifier(org.eclipselabs.mscript.language.ast.TensorTypeSpecifier)
		 */
		@Override
		public DataType caseTensorTypeSpecifier(TensorTypeSpecifier tensorTypeSpecifier) {
			ArrayType arrayType = TypeSystemFactory.eINSTANCE.createTensorType();
			initializeArrayType(arrayType, tensorTypeSpecifier);
			return arrayType;
		}
	
		private void initializeArrayType(ArrayType arrayType, ArrayTypeSpecifier arrayTypeSpecifier) {
			for (ArrayDimensionSpecification arrayDimensionSpecification : arrayTypeSpecifier.getDimensions()) {
				ArrayDimension arrayDimension = TypeSystemFactory.eINSTANCE.createArrayDimension();
				if (arrayDimensionSpecification.getSize() != null && arrayDimensionSpecification.getSize() instanceof IntegerLiteral) {
					IntegerLiteral integerLiteral = (IntegerLiteral) arrayDimensionSpecification.getSize();
					arrayDimension.setSize((int) integerLiteral.getValue());
				} else {
					arrayDimension.setSize(-1);
				}
				arrayType.getDimensions().add(arrayDimension);
			}
			arrayType.setElementType(doSwitch(arrayTypeSpecifier.getElementType()));
		}

	}
	
}
