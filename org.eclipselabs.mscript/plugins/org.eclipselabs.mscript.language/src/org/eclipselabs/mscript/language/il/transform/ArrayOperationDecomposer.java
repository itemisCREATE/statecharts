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
import org.eclipselabs.mscript.computation.core.ComputationContext;
import org.eclipselabs.mscript.computation.core.value.AnyValue;
import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AstFactory;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeOperator;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.VariableReference;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.language.interpreter.IStaticEvaluationContext;
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

	private IStaticEvaluationContext context;
	
	private ArrayExpressionTransformer arrayExpressionTransformer = new ArrayExpressionTransformer();
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.il.transform.IArrayOperationDecomposer#decompose(org.eclipselabs.mscript.language.il.Compound)
	 */
	public void decompose(IStaticEvaluationContext context, Compound compound) {
		this.context = context;
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
	
	private DataType getDataType(Expression expression) {
		return context.getValue(expression).getDataType();
	}
	
	private void setDataType(Expression expression, DataType dataType) {
		context.setValue(expression, new AnyValue(new ComputationContext(), dataType));
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
					DataType leftDataType = getDataType(leftOperand);
					DataType rightDataType = getDataType(rightOperand);
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

			TensorType leftTensorType = (TensorType) getDataType(leftOperand);
			TensorType rightTensorType = (TensorType) getDataType(rightOperand);
			
			DataType resultDataType = leftTensorType.getElementType().evaluate(OperatorKind.MULTIPLY, rightTensorType.getElementType());

			Expression rootExpression = null;
			for (int i = 0; i < TypeSystemUtil.getArraySize(leftTensorType); ++i) {
				MultiplicativeExpression multiplicativeExpression = AstFactory.eINSTANCE.createMultiplicativeExpression();
				setDataType(multiplicativeExpression, EcoreUtil.copy(resultDataType));
				
				VariableReference leftVariableReference = EcoreUtil.copy(leftOperand);
				setDataType(leftVariableReference, EcoreUtil.copy(leftTensorType.getElementType()));
				IntegerLiteral integerLiteral = TypeSystemFactory.eINSTANCE.createIntegerLiteral();
				integerLiteral.setUnit(TypeSystemUtil.createUnit());
				integerLiteral.setValue(i);
				IntegerType integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
				integerType.setUnit(TypeSystemUtil.createUnit());
				setDataType(integerLiteral, integerType);
				leftVariableReference.getArrayIndices().add(integerLiteral);
				
				VariableReference rightVariableReference = EcoreUtil.copy(rightOperand);
				setDataType(rightVariableReference, EcoreUtil.copy(rightTensorType.getElementType()));
				integerLiteral = TypeSystemFactory.eINSTANCE.createIntegerLiteral();
				integerLiteral.setUnit(TypeSystemUtil.createUnit());
				integerLiteral.setValue(i);
				integerType = TypeSystemFactory.eINSTANCE.createIntegerType();
				integerType.setUnit(TypeSystemUtil.createUnit());
				setDataType(integerLiteral, integerType);
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
					setDataType(additiveExpression, EcoreUtil.copy(resultDataType));
					rootExpression = additiveExpression;
				}
			}
			
			parenthesizedExpression.getExpressions().add(rootExpression);

			setDataType(rootExpression, EcoreUtil.copy(resultDataType));
			setDataType(parenthesizedExpression, EcoreUtil.copy(resultDataType));
			
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
