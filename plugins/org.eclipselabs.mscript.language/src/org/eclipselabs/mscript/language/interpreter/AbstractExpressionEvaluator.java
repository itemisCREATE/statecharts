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

import org.eclipselabs.mscript.language.ast.AdditiveExpression;
import org.eclipselabs.mscript.language.ast.AdditiveExpressionPart;
import org.eclipselabs.mscript.language.ast.AdditiveOperator;
import org.eclipselabs.mscript.language.ast.Expression;
import org.eclipselabs.mscript.language.ast.ExpressionList;
import org.eclipselabs.mscript.language.ast.MatrixConstructionOperator;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpression;
import org.eclipselabs.mscript.language.ast.MultiplicativeExpressionPart;
import org.eclipselabs.mscript.language.ast.MultiplicativeOperator;
import org.eclipselabs.mscript.language.ast.ParenthesizedExpression;
import org.eclipselabs.mscript.language.ast.util.AstSwitch;

/**
 * @author Andreas Unger
 *
 */
public abstract class AbstractExpressionEvaluator<T> extends AstSwitch<T> {
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseAdditiveExpression(org.eclipselabs.mscript.language.ast.AdditiveExpression)
	 */
	@Override
	public T caseAdditiveExpression(AdditiveExpression addSubtractExpression) {
		T result = doSwitch(addSubtractExpression.getLeftOperand());
		for (AdditiveExpressionPart part : addSubtractExpression.getRightParts()) {
			result = addSubtract(result, doSwitch(part.getOperand()), part.getOperator());
		}
		return result;
	}
	
	protected T addSubtract(T operand1, T operand2, AdditiveOperator operator) {
		switch (operator) {
		case ADDITION:
			return add(operand1, operand2);
		case SUBTRACTION:
			return subtract(operand1, operand2);
		}
		throw new IllegalArgumentException();
	}
	
	protected abstract T add(T addend1, T addend2);
	
	protected abstract T subtract(T minuend, T subtrahend);
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseMultiplicativeExpression(org.eclipselabs.mscript.language.ast.MultiplicativeExpression)
	 */
	@Override
	public T caseMultiplicativeExpression(MultiplicativeExpression multiplyDivideExpression) {
		T result = doSwitch(multiplyDivideExpression.getLeftOperand());
		for (MultiplicativeExpressionPart part : multiplyDivideExpression.getRightParts()) {
			result = multiplyDivide(result, doSwitch(part.getOperand()), part.getOperator());
		}
		return result;
	}
	
	protected T multiplyDivide(T operand1, T operand2, MultiplicativeOperator operator) {
		switch (operator) {
		case MULTIPLICATION:
			return multiply(operand1, operand2);
		case DIVISION:
			return divide(operand1, operand2);
		case ELEMENT_WISE_MULTIPLICATION:
			return elementWiseMultiply(operand1, operand2);
		case ELEMENT_WISE_DIVISION:
			return elementWiseDivide(operand1, operand2);
		}
		throw new IllegalArgumentException();
	}
	
	protected abstract T multiply(T factor1, T factor2);
	
	protected abstract T divide(T dividend, T divisor);
	
	protected abstract T elementWiseMultiply(T factor1, T factor2);

	protected abstract T elementWiseDivide(T dividend, T divisor);
	
	public T caseMatrixConstructionOperator(MatrixConstructionOperator matrixConstructionOperator) {
		int rowSize = matrixConstructionOperator.getExpressionLists().size();
		int columnSize = -1;
		
		for (ExpressionList expressionList : matrixConstructionOperator.getExpressionLists()) {
			if (columnSize == -1) {
				columnSize = expressionList.getExpressions().size();
			} else if (columnSize < expressionList.getExpressions().size()) {
				columnSize = expressionList.getExpressions().size();
			}
		}
		
		@SuppressWarnings("unchecked")
		T[][] matrix = (T[][]) new Object[rowSize][columnSize];

		int row = 0;
		for (ExpressionList expressionList : matrixConstructionOperator.getExpressionLists()) {
			int column = 0;
			for (Expression expression : expressionList.getExpressions()) {
				matrix[row][column] = doSwitch(expression);
				++column;
			}
			++row;
		}
		
		return processMatrix(matrix, rowSize, columnSize);
	}
	
	protected abstract T processMatrix(T[][] matrix, int rowSize, int columnSize);
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.ast.util.AstSwitch#caseParenthesizedExpression(org.eclipselabs.mscript.language.ast.ParenthesizedExpression)
	 */
	@Override
	public T caseParenthesizedExpression(ParenthesizedExpression parenthesizedExpression) {
		return doSwitch(parenthesizedExpression.getExpressions().get(0));
	}
	
}
