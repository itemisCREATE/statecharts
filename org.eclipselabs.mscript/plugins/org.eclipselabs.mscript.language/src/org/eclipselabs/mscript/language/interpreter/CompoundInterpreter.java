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

import org.eclipselabs.mscript.computation.core.value.IArrayValue;
import org.eclipselabs.mscript.computation.core.value.IBooleanValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.UninitializedValue;
import org.eclipselabs.mscript.language.il.Assignment;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ForeachStatement;
import org.eclipselabs.mscript.language.il.IfStatement;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.Statement;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.typesystem.ArrayType;

/**
 * @author Andreas Unger
 *
 */
public class CompoundInterpreter implements ICompoundInterpreter {

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.interpreter.ICompoundInterpreter#execute(org.eclipselabs.mscript.language.interpreter.IInterpreterContext, org.eclipselabs.mscript.language.il.Compound)
	 */
	public void execute(IInterpreterContext context, Compound compound) {
		new CompoundInterpreterSwitch(context).doSwitch(compound);
	}
	
	private static class CompoundInterpreterSwitch extends ILSwitch<Boolean> {
		
		private IInterpreterContext context;
		
		private IExpressionValueEvaluator expressionValueEvaluator = new ExpressionValueEvaluator();

		/**
		 * 
		 */
		public CompoundInterpreterSwitch(IInterpreterContext context) {
			this.context = context;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseCompound(org.eclipselabs.mscript.language.imperativemodel.Compound)
		 */
		@Override
		public Boolean caseCompound(Compound compound) {
			context.enterScope();
			for (Statement statement : compound.getStatements()) {
				doSwitch(statement);
			}
			context.leaveScope();
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseAssignment(org.eclipselabs.mscript.language.imperativemodel.Assignment)
		 */
		@Override
		public Boolean caseAssignment(Assignment assignment) {
			IValue value = expressionValueEvaluator.evaluate(context, assignment.getAssignedExpression());
			IVariable variable = context.getVariable(assignment.getTarget());
			variable.setValue(assignment.getStepIndex(), value);
			return true;
		}
	
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseIfStatement(org.eclipselabs.mscript.language.imperativemodel.IfStatement)
		 */
		@Override
		public Boolean caseIfStatement(IfStatement ifStatement) {
			IValue conditionValue = expressionValueEvaluator.evaluate(context, ifStatement.getCondition());
			if (conditionValue instanceof IBooleanValue) {
				IBooleanValue booleanConditionValue = (IBooleanValue) conditionValue;
				if (booleanConditionValue.booleanValue()) {
					return doSwitch(ifStatement.getThenStatement());
				}
			} else {
				throw new RuntimeException("Condition expression must be boolean");
			}
			return doSwitch(ifStatement.getElseStatement());
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseForeachStatement(org.eclipselabs.mscript.language.imperativemodel.ForeachStatement)
		 */
		@Override
		public Boolean caseForeachStatement(ForeachStatement foreachStatement) {
			IValue value = expressionValueEvaluator.evaluate(context, foreachStatement.getCollectionExpression());
	
			if (!(value.getDataType() instanceof ArrayType)) {
				throw new RuntimeException("Collection type must be array type");
			}
			
			ArrayType arrayType = (ArrayType) value.getDataType();
			if (arrayType.getDimensionality() != 1) {
				throw new RuntimeException("Array dimensionality must be 1");
			}
			
			if (!(value instanceof IArrayValue)) {
				throw new RuntimeException("Value must be array value");
			}
			
			IArrayValue arrayValue = (IArrayValue) value;
			
			int size = arrayType.getSize();
			
			VariableDeclaration iterationVariableDeclaration = foreachStatement.getIterationVariableDeclaration();
			for (int i = 0; i < size; ++i) {
				context.enterScope();
				IVariable variable = new Variable(iterationVariableDeclaration, 1);
				variable.setValue(0, arrayValue.get(i));
				context.addVariable(variable);
				doSwitch(foreachStatement.getBody());
				context.leaveScope();
			}
	
			return true;
		}
		
		/* (non-Javadoc)
		 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration)
		 */
		@Override
		public Boolean caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
			IValue value;
			if (localVariableDeclaration.getInitializer() != null) {
				value = expressionValueEvaluator.evaluate(context, localVariableDeclaration.getInitializer());
			} else {
				value = new UninitializedValue(context.getComputationContext());
			}
			IVariable variable = new Variable(localVariableDeclaration, 1);
			variable.setValue(0, value);
			context.addVariable(variable);
			return true;
		}

	}
	
}
