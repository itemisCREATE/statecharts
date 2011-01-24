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

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.AdditiveOperator;
import org.eclipselabs.mscript.language.ast.AstFactory;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.IntegerLiteral;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart;
import org.eclipselabs.mscript.language.ast.MultiplicativeOperator;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.typesystem.DataType;
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
			List<MultiplicativeExpressionPart> rightParts = multiplicativeExpression.getRightParts();
			
			// TODO: Implement better support for vector multiplication expressions
			if (rightParts.size() == 1 && rightParts.get(0).getOperator() == MultiplicativeOperator.MULTIPLICATION) {
				Expression leftOperand = multiplicativeExpression.getLeftOperand();
				Expression rightOperand = rightParts.get(0).getOperand();
				if (leftOperand instanceof VariableReference && rightOperand instanceof VariableReference) {
					DataType leftDataType = ILUtil.getDataType(multiplicativeExpression.getLeftOperand());
					DataType rightDataType = ILUtil.getDataType(rightParts.get(0).getOperand());
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
			
			DataType resultDataType = leftTensorType.getElementType().evaluate(OperatorKind.MULTIPLICATION, rightTensorType.getElementType());

			AdditiveExpression additiveExpression = AstFactory.eINSTANCE.createAdditiveExpression();
			parenthesizedExpression.getExpressions().add(additiveExpression);

			for (int i = 0; i < leftTensorType.getSize(); ++i) {
				MultiplicativeExpression multiplicativeExpression = AstFactory.eINSTANCE.createMultiplicativeExpression();
				ILUtil.setDataType(multiplicativeExpression, EcoreUtil.copy(resultDataType));
				
				VariableReference leftVariableReference = EcoreUtil.copy(leftOperand);
				ILUtil.setDataType(leftVariableReference, EcoreUtil.copy(leftTensorType.getElementType()));
				IntegerLiteral integerLiteral = AstFactory.eINSTANCE.createIntegerLiteral();
				integerLiteral.setValue(i);
				IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
				integerType.setUnit(TypeSystemUtil.createUnit());
				ILUtil.setDataType(integerLiteral, integerType);
				leftVariableReference.getArrayIndices().add(integerLiteral);
				
				VariableReference rightVariableReference = EcoreUtil.copy(rightOperand);
				ILUtil.setDataType(rightVariableReference, EcoreUtil.copy(rightTensorType.getElementType()));
				integerLiteral = AstFactory.eINSTANCE.createIntegerLiteral();
				integerLiteral.setValue(i);
				integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
				integerType.setUnit(TypeSystemUtil.createUnit());
				ILUtil.setDataType(integerLiteral, integerType);
				rightVariableReference.getArrayIndices().add(integerLiteral);

				multiplicativeExpression.setLeftOperand(leftVariableReference);
				MultiplicativeExpressionPart rightPart = AstFactory.eINSTANCE.createMultiplicativeExpressionPart();
				rightPart.setOperator(MultiplicativeOperator.MULTIPLICATION);
				rightPart.setOperand(rightVariableReference);
				multiplicativeExpression.getRightParts().add(rightPart);
				
				if (i == 0) {
					additiveExpression.setLeftOperand(multiplicativeExpression);
				} else {
					AdditiveExpressionPart rightAdditiveExpressionPart = AstFactory.eINSTANCE.createAdditiveExpressionPart();
					rightAdditiveExpressionPart.setOperator(AdditiveOperator.ADDITION);
					rightAdditiveExpressionPart.setOperand(multiplicativeExpression);
					additiveExpression.getRightParts().add(rightAdditiveExpressionPart);
				}
			}
			
			ILUtil.setDataType(additiveExpression, EcoreUtil.copy(resultDataType));
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
