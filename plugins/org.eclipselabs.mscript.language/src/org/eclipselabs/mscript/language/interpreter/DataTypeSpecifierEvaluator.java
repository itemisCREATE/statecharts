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

import org.eclipselabs.mscript.language.ast.BooleanTypeSpecifier;
import org.eclipselabs.mscript.language.ast.IntegerTypeSpecifier;
import org.eclipselabs.mscript.language.ast.RealTypeSpecifier;
import org.eclipselabs.mscript.language.ast.StringTypeSpecifier;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.internal.interpreter.InvalidUnitExpressionOperandException;
import org.eclipselabs.mscript.language.internal.interpreter.UnitExpressionHelper;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.RealType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
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
		RealType realType = (RealType) TypeSystemFactory.eINSTANCE.createRealType();
		if (realTypeSpecifier.getUnit() != null) {
			if (!realTypeSpecifier.getUnit().isUnspecified()) {
				try {
					realType.setUnit(new UnitExpressionHelper().evaluate(realTypeSpecifier.getUnit()));
				} catch (InvalidUnitExpressionOperandException e) {
					return TypeSystemFactory.eINSTANCE.createInvalidDataType();
				}
			}
		} else {
			realType.setUnit(TypeSystemUtil.createUnit());
		}
		return realType;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseIntegerTypeSpecifier(org.eclipselabs.mscript.language.ast.IntegerTypeSpecifier)
	 */
	@Override
	public DataType caseIntegerTypeSpecifier(IntegerTypeSpecifier integerTypeSpecifier) {
		IntegerType integerType = (IntegerType) TypeSystemFactory.eINSTANCE.createIntegerType();
		if (integerTypeSpecifier.getUnit() != null) {
			if (!integerTypeSpecifier.getUnit().isUnspecified()) {
				try {
					integerType.setUnit(new UnitExpressionHelper().evaluate(integerTypeSpecifier.getUnit()));
				} catch (InvalidUnitExpressionOperandException e) {
					return TypeSystemFactory.eINSTANCE.createInvalidDataType();
				}
			}
		} else {
			integerType.setUnit(TypeSystemUtil.createUnit());
		}
		return integerType;
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

}
