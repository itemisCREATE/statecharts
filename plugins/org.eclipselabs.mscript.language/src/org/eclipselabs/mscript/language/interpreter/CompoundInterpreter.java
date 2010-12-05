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

import org.eclipselabs.mscript.language.il.Assignment;
import org.eclipselabs.mscript.language.il.Compound;
import org.eclipselabs.mscript.language.il.ForeachStatement;
import org.eclipselabs.mscript.language.il.IfStatement;
import org.eclipselabs.mscript.language.il.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.il.Statement;
import org.eclipselabs.mscript.language.il.util.ILSwitch;
import org.eclipselabs.mscript.language.interpreter.value.IBooleanValue;
import org.eclipselabs.mscript.language.interpreter.value.IValue;
import org.eclipselabs.mscript.language.interpreter.value.UninitializedValue;

/**
 * @author Andreas Unger
 *
 */
public class CompoundInterpreter extends ILSwitch<Boolean> {

	private IInterpreterContext context;
	
	/**
	 * 
	 */
	public CompoundInterpreter(IInterpreterContext context) {
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
		IValue value = new ExpressionValueEvaluator(context).doSwitch(assignment.getAssignedExpression());
		IVariable variable = context.getScope().findInEnclosingScopes(assignment.getTarget());
		variable.setValue(assignment.getStepIndex(), value);
		return true;
	}

	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseIfStatement(org.eclipselabs.mscript.language.imperativemodel.IfStatement)
	 */
	@Override
	public Boolean caseIfStatement(IfStatement ifStatement) {
		IValue conditionValue = new ExpressionValueEvaluator(context).doSwitch(ifStatement.getCondition());
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
	public Boolean caseForeachStatement(ForeachStatement object) {
		// TODO Auto-generated method stub
		return super.caseForeachStatement(object);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ILSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration)
	 */
	@Override
	public Boolean caseLocalVariableDeclaration(LocalVariableDeclaration localVariableDeclaration) {
		IValue value;
		if (localVariableDeclaration.getInitializer() != null) {
			value = new ExpressionValueEvaluator(context).doSwitch(localVariableDeclaration.getInitializer());
		} else {
			value = new UninitializedValue();
		}
		IVariable variable = new Variable(localVariableDeclaration, 1);
		variable.setValue(0, value);
		context.getScope().add(variable);
		return true;
	}

}
