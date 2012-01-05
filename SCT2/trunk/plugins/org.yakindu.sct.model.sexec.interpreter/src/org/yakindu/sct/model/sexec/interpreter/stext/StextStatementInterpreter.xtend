/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.model.sexec.interpreter.stext

import org.yakindu.sct.model.sexec.interpreter.IStatementInterpreter
import org.yakindu.sct.simulation.core.IExecutionContext
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.LogicalAndExpression
import org.yakindu.sct.model.stext.stext.LogicalOrExpression
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression
import org.yakindu.sct.model.stext.stext.RelationalOperator
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.RealLiteral
import org.yakindu.sct.simulation.core.ScopeVariable
import org.yakindu.sct.simulation.core.ScopeEvent
import org.yakindu.sct.model.stext.stext.Assignment
import org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.stext.stext.EventRaising
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression
import org.yakindu.sct.model.stext.stext.ConditionalExpression
import org.yakindu.sct.model.stext.stext.EventRaisedReferenceExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.LogicalNotExpression
import org.yakindu.sct.model.stext.stext.NumericalUnaryExpression
import org.yakindu.sct.model.stext.stext.OperationCall
import org.yakindu.sct.model.stext.stext.ShiftExpression
import org.yakindu.sct.model.stext.stext.AssignmentOperator
import org.yakindu.sct.simulation.core.runtime.IExecutionContext
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.stext.stext.InterfaceScope
import org.yakindu.sct.model.stext.stext.InternalScope
import org.yakindu.sct.model.sgraph.Scope
import com.google.inject.Inject
import org.yakindu.sct.model.stext.naming.StextNameProvider
import org.yakindu.sct.model.stext.stext.HexLiteral

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @authos axel terfloth - additions
 * 
 */
class StextStatementInterpreter extends AbstractStatementInterpreter {
	
	@Inject
	extension StextNameProvider provider 
	
	IExecutionContext context
	
	override Object evaluateStatement(Statement statement,
			IExecutionContext context){
		this.context = context
		statement.execute()
	}

	def dispatch execute(Assignment assignment){
		var scopeVariable = context.getVariable(assignment.varRef.qualifiedName.toString)
		var result = assignment.expression.execute
		if(assignment.operator == AssignmentOperator::ASSIGN){
			context.setVariableValue(scopeVariable.getName, result)
		}else{
			var operator = AbstractStatementInterpreter::assignFunctionMap.get(assignment.operator.name)
			context.setVariableValue(scopeVariable.name, evaluate(operator, scopeVariable.getValue,result))
		}
		null		
	}
	
	def dispatch execute(EventRaising eventRaising){
		if(eventRaising.value != null){
			context.raiseEvent(eventRaising.event.qualifiedName.toString, eventRaising.value.execute)
		}else {
			context.raiseEvent(eventRaising.event.qualifiedName.toString, null)
		}
		null
	}
	
	def dispatch execute(ConditionalExpression expression){
		if(expression.condition.execute as Boolean ){
			return expression.trueCase.execute
		}else{
			return expression.falseCase.execute
		}
	} 
	
	def dispatch execute(ElementReferenceExpression expression){
		var variableRef = context.getVariable(expression.value.qualifiedName.toString)
		if(variableRef != null){
			return variableRef.getValue
		}
		return context.isEventRaised(expression.value.qualifiedName.toString)
	}
	
	def dispatch execute(EventValueReferenceExpression expression){
		for(event : context.raisedEvents){
			if(event.getName.equals(expression.value.name)){
				return event.getValue
			}
		}
		null;
	}
	
	def dispatch execute(ActiveStateReferenceExpression expression){
		for(activeState : context.allActiveStates){
			if(activeState == expression.value){
				return true;
			}
		}
		return false;
	}
	
	def dispatch execute(LogicalAndExpression expression){
		var leftResult = execute(expression.leftOperand)
		if(!leftResult as Boolean)
			return false
		var rightResult = execute(expression.rightOperand)
		return leftResult as Boolean && rightResult as Boolean
	}
	
	def dispatch execute(LogicalOrExpression expression){
		var leftResult = execute(expression.leftOperand)
		if(leftResult as Boolean)
			return true
		var rightResult = execute(expression.rightOperand)
		return leftResult as Boolean || rightResult as Boolean
	}
	
	def dispatch execute(LogicalNotExpression expression){
		return ! (expression.operand.execute() as Boolean)
	}
	def dispatch execute(BitwiseAndExpression expression){
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, CoreFunction::BIT_AND)
	}
	def dispatch execute(BitwiseOrExpression expression){
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, CoreFunction::BIT_OR)
	}
	def dispatch execute(BitwiseXorExpression expression){
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, CoreFunction::BIT_XOR)		
	}
	def dispatch execute(LogicalRelationExpression expression){
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.name)
	}
	def dispatch execute(NumericalAddSubtractExpression expression){
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.name)
	}
	def dispatch execute(NumericalMultiplyDivideExpression expression){
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.name)
	}
	def dispatch execute(ShiftExpression expression){
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.name)
	}
	def dispatch execute(NumericalUnaryExpression expression){
		executeUnaryCoreFunction(expression.operand, expression.operator.name)
	}	
	
	def executeBinaryCoreFunction(Statement leftStatement, Statement rightStatement, String operator){
		var leftResult = leftStatement.execute()
		var rightResult = rightStatement.execute()
		return evaluate(operator, leftResult,rightResult)
	}
	
	def executeUnaryCoreFunction(Statement statement, String operator){
		var result = statement.execute()
		return evaluate(operator, result); 
	}
	
	def dispatch execute(OperationCall call){
		context.call(call.operation.name)
		null
	}
	
	def dispatch execute(PrimitiveValueExpression expression){
		return expression.value.valueLiteral
	}
	
	def dispatch valueLiteral(IntLiteral literal){
		return literal.value
	} 
	
	def dispatch valueLiteral(HexLiteral literal){
		return literal.value
	} 
	
	def dispatch valueLiteral(BoolLiteral bool){
		return bool.value
	}
	
	def dispatch valueLiteral(RealLiteral literal){
		return literal.value
	}
		
}