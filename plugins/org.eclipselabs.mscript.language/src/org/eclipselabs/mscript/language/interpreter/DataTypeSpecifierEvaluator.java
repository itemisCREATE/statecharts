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
import org.eclipselabs.mscript.language.ast.BooleanTypeSpecifier;
import org.eclipselabs.mscript.language.ast.DataTypeSpecifier;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.IntegerTypeSpecifier;
import org.eclipselabs.mscript.language.ast.NumericTypeSpecifier;
import org.eclipselabs.mscript.language.ast.RealTypeSpecifier;
import org.eclipselabs.mscript.language.ast.StringTypeSpecifier;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.internal.interpreter.InvalidUnitExpressionOperandException;
import org.eclipselabs.mscript.language.internal.interpreter.UnitExpressionHelper;
import org.eclipselabs.mscript.typesystem.ArrayDimension;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.NumericType;
import org.eclipselabs.mscript.typesystem.TensorType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.TypeSystemPackage;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class DataTypeSpecifierEvaluator extends AstSwitch<DataType> {
	
//	private IEvaluationContext context;
	
	/**
	 * 
	 */
	public DataTypeSpecifierEvaluator(IInterpreterContext context) {
//		this.context = context;
	}
	
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
		
		if (numericTypeSpecifier.getDimensions() != null) {
			TensorType tensorType = TypeSystemFactory.eINSTANCE.createTensorType();
			initializeArrayType(tensorType, numericTypeSpecifier, numericType);
			return tensorType;
		}
		
		return numericType;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseBooleanTypeSpecifier(org.eclipselabs.mscript.language.ast.BooleanTypeSpecifier)
	 */
	@Override
	public DataType caseBooleanTypeSpecifier(BooleanTypeSpecifier booleanTypeSpecifier) {
		return TypeSystemUtil.BOOLEAN_TYPE;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseStringTypeSpecifier(org.eclipselabs.mscript.language.ast.StringTypeSpecifier)
	 */
	@Override
	public DataType caseStringTypeSpecifier(StringTypeSpecifier object) {
		return TypeSystemUtil.STRING_TYPE;
	}

	private void initializeArrayType(ArrayType arrayType, DataTypeSpecifier dataTypeSpecifier, DataType elementType) {
		for (ArrayDimensionSpecification arrayDimensionSpecification : dataTypeSpecifier.getDimensions()) {
			ArrayDimension arrayDimension = TypeSystemFactory.eINSTANCE.createArrayDimension();
			if (arrayDimensionSpecification.getSize() != null && arrayDimensionSpecification.getSize() instanceof IntegerLiteral) {
				IntegerLiteral integerLiteral = (IntegerLiteral) arrayDimensionSpecification.getSize();
				arrayDimension.setSize((int) integerLiteral.getValue());
			}
			arrayType.getDimensions().add(arrayDimension);
		}
		arrayType.setElementType(elementType);
	}

}
