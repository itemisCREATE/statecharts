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

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipselabs.mscript.language.imperativemodel.Assignment;
import org.eclipselabs.mscript.language.imperativemodel.Compound;
import org.eclipselabs.mscript.language.imperativemodel.ForeachStatement;
import org.eclipselabs.mscript.language.imperativemodel.IfStatement;
import org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration;
import org.eclipselabs.mscript.language.imperativemodel.Statement;
import org.eclipselabs.mscript.language.imperativemodel.util.ImperativeModelSwitch;
import org.eclipselabs.mscript.language.internal.util.EObjectDiagnostic;
import org.eclipselabs.mscript.language.interpreter.value.IBooleanValue;
import org.eclipselabs.mscript.language.interpreter.value.IValue;
import org.eclipselabs.mscript.language.interpreter.value.UninitializedValue;

/**
 * @author Andreas Unger
 *
 */
public class CompoundInterpreter extends ImperativeModelSwitch<Boolean> {

	private IInterpreterContext context;
	
	/**
	 * 
	 */
	public CompoundInterpreter(IInterpreterContext context) {
		this.context = context;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ImperativeModelSwitch#caseCompound(org.eclipselabs.mscript.language.imperativemodel.Compound)
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
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ImperativeModelSwitch#caseLocalVariableDeclaration(org.eclipselabs.mscript.language.imperativemodel.LocalVariableDeclaration)
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
		context.addVariable(variable);
		return true;
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ImperativeModelSwitch#caseIfStatement(org.eclipselabs.mscript.language.imperativemodel.IfStatement)
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
			context.getDiagnostics().add(new EObjectDiagnostic(Diagnostic.ERROR, "Condition expression must be boolean", null));
			return true;
		}
		return doSwitch(ifStatement.getElseStatement());
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ImperativeModelSwitch#caseForeachStatement(org.eclipselabs.mscript.language.imperativemodel.ForeachStatement)
	 */
	@Override
	public Boolean caseForeachStatement(ForeachStatement object) {
		// TODO Auto-generated method stub
		return super.caseForeachStatement(object);
	}
	
	/* (non-Javadoc)
	 * @see org.eclipselabs.mscript.language.imperativemodel.util.ImperativeModelSwitch#caseAssignment(org.eclipselabs.mscript.language.imperativemodel.Assignment)
	 */
	@Override
	public Boolean caseAssignment(Assignment assignment) {
		IValue value = new ExpressionValueEvaluator(context).doSwitch(assignment.getAssignedExpression());
		IVariable variable = context.getVariable(assignment.getTarget());
		variable.setValue(assignment.getStepIndex(), value);
		return true;
	}

}
