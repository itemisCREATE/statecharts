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
package org.yakindu.sct.simulation.core.sexec.interpreter

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RealLiteral
import org.yakindu.base.expressions.expressions.ShiftExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Operation
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext
import org.yakindu.base.expressions.expressions.NullLiteral

/**
 * 
 * @author andreas muelder - Initial contribution and API 
 * @authos axel terfloth - additions
 * 
 */
class StextStatementInterpreter extends AbstractStatementInterpreter {

	@Inject
	extension IQualifiedNameProvider provider
	@Inject
	protected IOperationMockup operationDelegate
	@Inject
	extension ExecutionContextHelper helper

	protected ExecutionContext context

	override Object evaluateStatement(Expression statement, ExecutionContext context) {
		this.context = context
		statement.execute()
	}

	def dispatch Object execute(Expression statement) {
		null
	}

	def dispatch Object execute(AssignmentExpression assignment) {
		executeAssignment(assignment)
	}

	def Object executeAssignment(AssignmentExpression assignment) {
		var scopeVariable = context.resolveVariable(assignment.varRef)
		var result = assignment.expression.execute
		if (assignment.operator == AssignmentOperator::ASSIGN) {
			scopeVariable.value = result
		} else {
			var operator = AbstractStatementInterpreter::assignFunctionMap.get(assignment.operator.getName())
			scopeVariable.value = evaluate(operator, scopeVariable.getValue, result)
		}
		scopeVariable.value
	}

	def dispatch event(ElementReferenceExpression e) {
		if(e.reference instanceof EventDefinition ) e.reference else null
	}

	def dispatch event(FeatureCall e) {
		if(e.feature instanceof EventDefinition) e.feature else null
	}

	def dispatch Object execute(EventRaisingExpression eventRaising) {
		var event = context.getEvent(eventRaising.event.event.getFullyQualifiedName.toString)
		if (eventRaising.value != null) {
			event.value = eventRaising.value.execute
		}
		event.raised = true
		null
	}

	def dispatch Object execute(ConditionalExpression expression) {
		if (expression.condition.execute as Boolean) {
			return expression.trueCase.execute
		} else {
			return expression.falseCase.execute
		}
	}

	def dispatch Object execute(ElementReferenceExpression expression) {
		var parameter = expression.args.map(it|execute)
		if (expression.operationCall) {
			if (operationDelegate.canExecute(expression.reference as Operation, parameter.toArray)) {
				return operationDelegate.execute((expression.reference as Operation), parameter.toArray)
			}
		}
		val fqn = expression.reference.getFullyQualifiedName.toString
		var variableRef = context.getVariable(fqn)
		if (variableRef != null) {
			return variableRef.getValue
		}
		val eventRef = context.getEvent(fqn)
		if (eventRef != null) {
			return eventRef.raised
		}
		// reference to an element with complex type is not reflected in an execution variable but in a composite slot
		return context.getSlot(fqn)
	}

	def dispatch Object execute(EventValueReferenceExpression expression) {
		for (event : context.raisedEvents) {
			if (event.fqName.equals(expression.value.qname)) {
				return event.getValue;
			};
		}
		null;
	}

	def dispatch qname(FeatureCall e) {
		return e.feature.getFullyQualifiedName.toString
	}

	def dispatch qname(ElementReferenceExpression e) {
		e.reference.getFullyQualifiedName.toString
	}

	def dispatch Object execute(ActiveStateReferenceExpression expression) {
		var state = expression.value
		return context.allActiveStates.contains(state)
	}

	def dispatch Object execute(LogicalAndExpression expression) {
		var leftResult = execute(expression.leftOperand)
		if (!leftResult as Boolean)
			return false
		var rightResult = execute(expression.rightOperand)
		return leftResult as Boolean && rightResult as Boolean
	}

	def dispatch Object execute(LogicalOrExpression expression) {
		var leftResult = execute(expression.leftOperand)
		if (leftResult as Boolean)
			return true
		var rightResult = execute(expression.rightOperand)
		return leftResult as Boolean || rightResult as Boolean
	}

	def dispatch Object execute(LogicalNotExpression expression) {
		return ! (expression.operand.execute() as Boolean)
	}

	def dispatch Object execute(BitwiseAndExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, CoreFunction::BIT_AND)
	}

	def dispatch Object execute(BitwiseOrExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, CoreFunction::BIT_OR)
	}

	def dispatch Object execute(BitwiseXorExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, CoreFunction::BIT_XOR)
	}

	def dispatch Object execute(LogicalRelationExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.getName())
	}

	def dispatch Object execute(NumericalAddSubtractExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.literal)
	}

	def dispatch Object execute(NumericalMultiplyDivideExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.getName())
	}

	def dispatch Object execute(ShiftExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.getName())
	}

	def dispatch Object execute(NumericalUnaryExpression expression) {
		executeUnaryCoreFunction(expression.operand, expression.operator.getName())
	}

	def executeBinaryCoreFunction(Expression leftStatement, Expression rightStatement, String operator) {
		var leftResult = leftStatement.execute()
		var rightResult = rightStatement.execute()
		return evaluate(operator, leftResult, rightResult)
	}

	def executeUnaryCoreFunction(Expression statement, String operator) {
		var result = statement.execute()
		return evaluate(operator, result);
	}

	def dispatch Object execute(FeatureCall call) {
		executeFeatureCall(call)
	}
	
	def executeFeatureCall(FeatureCall call) {
		if (call.operationCall) {
			var parameter = call.args.map(it|execute)
			if (operationDelegate.canExecute(call, parameter)) {
				return operationDelegate.execute(call, parameter)
			}
		} else if (call.getFeature() instanceof Enumerator) {
			return call.getFeature();
		} else {
			var variableRef = context.resolveVariable(call)
			if (variableRef != null) {
				return variableRef.getValue
			}
			var event = context.resolveEvent(call)
			if (event != null)
				return event.raised
			println("No feature found for " + call.feature.fqn + " -> returning null")
			return null;
		}
		
	}

	def String fqn(EObject obj) {
		obj.getFullyQualifiedName.toString
	}

	def dispatch Object execute(ParenthesizedExpression e) {
		e.expression.execute()
	}

	def dispatch Object execute(PrimitiveValueExpression expression) {
		return expression.value.valueLiteral
	}

	def dispatch valueLiteral(IntLiteral literal) {
		return literal.value
	}

	def dispatch valueLiteral(HexLiteral literal) {
		return literal.value
	}

	def dispatch valueLiteral(BoolLiteral bool) {
		return bool.value
	}

	def dispatch valueLiteral(RealLiteral literal) {
		return literal.value
	}

	def dispatch valueLiteral(StringLiteral literal) {
		return literal.value
	}
	def dispatch valueLiteral(NullLiteral literal) {
		return null
	}

}
