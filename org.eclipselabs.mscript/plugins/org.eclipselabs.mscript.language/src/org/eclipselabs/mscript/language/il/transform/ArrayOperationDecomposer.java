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

package org.eclipselabs.mscript.language.il.transform;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AstFactory;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeOperator;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.typesystem.DataType;
import org.eclipselabs.mscript.typesystem.Expression;
import org.eclipselabs.mscript.typesystem.IntegerLiteral;
import org.eclipselabs.mscript.typesystem.IntegerType;
import org.eclipselabs.mscript.typesystem.OperatorKind;
import org.eclipselabs.mscript.typesystem.TensorType;
import org.eclipselabs.mscript.typesystem.TypeSystemFactory;
import org.eclipselabs.mscript.typesystem.util.TypeSystemUtil;

/**
 * @author Andreas Unger
 *
 */
public class ArrayOperationDecomposer extends ILSwitch<Boolean> implements IArrayOperationDecomposer {

	private ArrayExpressionTransformer arrayExpressionTransformer = new ArrayExpressionTransformer();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IArrayOperationDecomposer#decompose(org.eclipselabs.mscript.language.il.Compound)
	 */
	public void decompose(Compound compound) {
		doSwitch(compound);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.util.ILSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
	 */
	@Override
	public Boolean defaultCase(EObject object) {
		if (object instanceof Expression) {
			arrayExpressionTransformer.doSwitch(object);
		} else {
			for (EObject child : object.eContents()) {
				doSwitch(child);
			}
		}
		return true;
	}

	private class ArrayExpressionTransformer extends AstSwitch<Boolean> {
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
		 */
		@Override
		public Boolean caseMultiplicativeExpression(MultiplicativeExpression multiplicativeExpression) {
			// TODO: Implement better support for vector multiplication expressions
			if (multiplicativeExpression.getOperator() == MultiplicativeOperator.MULTIPLY) {
				Expression leftOperand = multiplicativeExpression.getLeftOperand();
				Expression rightOperand = multiplicativeExpression.getRightOperand();
				if (leftOperand instanceof VariableReference && rightOperand instanceof VariableReference) {
					DataType leftDataType = ILUtil.getDataType(leftOperand);
					DataType rightDataType = ILUtil.getDataType(rightOperand);
					if (leftDataType instanceof TensorType && rightDataType instanceof TensorType) {
						TensorType leftTensorType = (TensorType) leftDataType;
						TensorType rightTensorType = (TensorType) rightDataType;
						if (leftTensorType.isVector() && rightTensorType.isVector()) {
							Expression transformedExpression = createVectorMultiplicationExpression((VariableReference) leftOperand, (VariableReference) rightOperand);
							EcoreUtil.replace(multiplicativeExpression, transformedExpression);
						}
					}
				}
			}
			return super.caseMultiplicativeExpression(multiplicativeExpression);
		}
		
		private Expression createVectorMultiplicationExpression(VariableReference leftOperand, VariableReference rightOperand) {			
			ParenthesizedExpression parenthesizedExpression = AstFactory.eINSTANCE.createParenthesizedExpression();

			TensorType leftTensorType = (TensorType) ILUtil.getDataType(leftOperand);
			TensorType rightTensorType = (TensorType) ILUtil.getDataType(rightOperand);
			
			DataType resultDataType = leftTensorType.getElementType().evaluate(OperatorKind.MULTIPLY, rightTensorType.getElementType());

			Expression rootExpression = null;
			for (int i = 0; i < TypeSystemUtil.getArraySize(leftTensorType); ++i) {
				MultiplicativeExpression multiplicativeExpression = AstFactory.eINSTANCE.createMultiplicativeExpression();
				ILUtil.setDataType(multiplicativeExpression, EcoreUtil.copy(resultDataType));
				
				VariableReference leftVariableReference = EcoreUtil.copy(leftOperand);
				ILUtil.setDataType(leftVariableReference, EcoreUtil.copy(leftTensorType.getElementType()));
				IntegerLiteral integerLiteral = TypeSystemFactory.eINSTANCE.createIntegerLiteral();
				integerLiteral.setUnit(TypeSystemUtil.createUnit());
				integerLiteral.setValue(i);
				IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
				integerType.setUnit(TypeSystemUtil.createUnit());
				ILUtil.setDataType(integerLiteral, integerType);
				leftVariableReference.getArrayIndices().add(integerLiteral);
				
				VariableReference rightVariableReference = EcoreUtil.copy(rightOperand);
				ILUtil.setDataType(rightVariableReference, EcoreUtil.copy(rightTensorType.getElementType()));
				integerLiteral = TypeSystemFactory.eINSTANCE.createIntegerLiteral();
				integerLiteral.setUnit(TypeSystemUtil.createUnit());
				integerLiteral.setValue(i);
				integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
				integerType.setUnit(TypeSystemUtil.createUnit());
				ILUtil.setDataType(integerLiteral, integerType);
				rightVariableReference.getArrayIndices().add(integerLiteral);

				multiplicativeExpression.setOperator(MultiplicativeOperator.MULTIPLY);
				multiplicativeExpression.setLeftOperand(leftVariableReference);
				multiplicativeExpression.setRightOperand(rightVariableReference);
				
				if (rootExpression == null) {
					rootExpression = multiplicativeExpression;
				} else {
					AdditiveExpression additiveExpression = AstFactory.eINSTANCE.createAdditiveExpression();
					additiveExpression.setLeftOperand(rootExpression);
					additiveExpression.setRightOperand(multiplicativeExpression);
					ILUtil.setDataType(additiveExpression, EcoreUtil.copy(resultDataType));
					rootExpression = additiveExpression;
				}
			}
			
			parenthesizedExpression.getExpressions().add(rootExpression);

			ILUtil.setDataType(rootExpression, EcoreUtil.copy(resultDataType));
			ILUtil.setDataType(parenthesizedExpression, EcoreUtil.copy(resultDataType));
			
			return parenthesizedExpression;
		}

		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#defaultCase(org.eclipse.emf.ecore.EObject)
		 */
		@Override
		public Boolean defaultCase(EObject object) {
			for (EObject child : object.eContents()) {
				doSwitch(child);
			}
			return true;
		}
		
	}
	
}
