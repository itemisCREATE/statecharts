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

import org.eclipselabs.mscript.computation.core.value.IBooleanValue;
import org.eclipselabs.mscript.computation.core.value.IValue;
import org.eclipselabs.mscript.computation.core.value.UninitializedValue;
import org.eclipselabs.mscript.computation.core.value.VectorValue;
import org.eclipselabs.mscript.language.il.Assignment;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ForeachStatement;
import org.eclipselabs.mscript.language.il.IfStatement;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.Statement;
import org.eclipselabs.mscript.language.il.VariableDeclaration;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.language.il.util.ILUtil;
import org.eclipselabs.mscript.typesystem.ArrayType;
import org.eclipselabs.mscript.typesystem.DataType;

/**
 * @author Andreas Unger
 *
 */
public class CompoundInterpreter extends ILSwitch<Boolean> {

	private IInterpreterContext context;
	
	private ExpressionValueEvaluator expressionValueEvaluator;
	
	/**
	 * 
	 */
	public CompoundInterpreter(IInterpreterContext context) {
		this.context = context;
		expressionValueEvaluator = new ExpressionValueEvaluator(context);
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
		IValue value = expressionValueEvaluator.doSwitch(assignment.getAssignedExpression());
		IVariable variable = context.getScope().findInEnclosingScopes(assignment.getTarget());
		variable.setValue(assignment.getStepIndex(), value.convert(assignment.getTarget().getType()));
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseIfStatement(org.eclipselabs.mscript.language.imperativemodel.IfStatement)
	 */
	@Override
	public Boolean caseIfStatement(IfStatement ifStatement) {
		IValue conditionValue = expressionValueEvaluator.doSwitch(ifStatement.getCondition());
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
		DataType collectionType = ILUtil.getDataType(foreachStatement.getCollectionExpression());
		if (!(collectionType instanceof ArrayType)) {
			throw new RuntimeException("Collection type must be array type");
		}
		
		ArrayType arrayType = (ArrayType) collectionType;
		if (arrayType.getDimensionality() != 1) {
			throw new RuntimeException("Array dimensionality must be 1");
		}
		
		IValue value = expressionValueEvaluator.doSwitch(foreachStatement.getCollectionExpression());
		
		if (!(value instanceof VectorValue)) {
			throw new RuntimeException("Value must be tensor value");
		}
		
		VectorValue tensorValue = (VectorValue) value;
		
		int size = arrayType.getDimensions().get(0).getSize();
		
		VariableDeclaration iterationVariableDeclaration = foreachStatement.getIterationVariableDeclaration();
		for (int i = 0; i < size; ++i) {
			context.enterScope();
			IVariable variable = new Variable(iterationVariableDeclaration, 1);
			variable.setValue(0, tensorValue.get(i).convert(iterationVariableDeclaration.getType()));
			context.getScope().add(variable);
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
			value = expressionValueEvaluator.doSwitch(localVariableDeclaration.getInitializer()).convert(localVariableDeclaration.getType());
		} else {
			value = new UninitializedValue(context.getComputationContext());
		}
		IVariable variable = new Variable(localVariableDeclaration, 1);
		variable.setValue(0, value);
		context.getScope().add(variable);
		return true;
	}

}
