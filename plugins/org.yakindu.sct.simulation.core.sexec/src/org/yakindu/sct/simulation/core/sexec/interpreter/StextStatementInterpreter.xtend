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
import org.eclipse.xtext.util.SimpleAttributeResolver
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Operation
import org.yakindu.sct.model.sgraph.Statement
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.AssignmentExpression
import org.yakindu.sct.model.stext.stext.AssignmentOperator
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.ConditionalExpression
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.FeatureCall
import org.yakindu.sct.model.stext.stext.HexLiteral
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.LogicalAndExpression
import org.yakindu.sct.model.stext.stext.LogicalNotExpression
import org.yakindu.sct.model.stext.stext.LogicalOrExpression
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression
import org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.stext.stext.NumericalUnaryExpression
import org.yakindu.sct.model.stext.stext.ParenthesizedExpression
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.RealLiteral
import org.yakindu.sct.model.stext.stext.ShiftExpression
import org.yakindu.sct.model.stext.stext.StringLiteral
import org.yakindu.sct.model.stext.stext.VariableDefinition
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext

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
	IOperationMockup operationDelegate

	protected ExecutionContext context

	override Object evaluateStatement(Statement statement, ExecutionContext context) {
		this.context = context
		statement.execute()
	}

	def dispatch Object execute(Statement statement) {
		null
	}

	def dispatch Object execute(AssignmentExpression assignment) {
		var scopeVariable = context.getVariable(assignment.varRef.variable.getFullyQualifiedName.toString)
		var result = assignment.expression.execute
		if (assignment.operator == AssignmentOperator::ASSIGN) {
			scopeVariable.value = result
		} else {
			var operator = AbstractStatementInterpreter::assignFunctionMap.get(assignment.operator.getName())
			scopeVariable.value = evaluate(operator, scopeVariable.getValue, result)
		}
		scopeVariable.value
	}

	def dispatch EObject variable(ElementReferenceExpression e) {
		if(e.reference instanceof VariableDefinition) e.reference else null
	}

	def dispatch EObject variable(FeatureCall e) {
		if(e.feature instanceof VariableDefinition) e.feature else null
	}

	def dispatch EObject variable(AssignmentExpression e) {
		return e.varRef.variable as EObject
	}

	def dispatch event(ElementReferenceExpression e) {
		if(e.reference instanceof EventDefinition) e.reference else null
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
				return operationDelegate.execute((expression.reference as Operation),
					parameter.toArray)
			}
		}

		var variableRef = context.getVariable(expression.reference.getFullyQualifiedName.toString)
		if (variableRef != null) {
			return variableRef.getValue
		}
		return context.getEvent(expression.reference.getFullyQualifiedName.toString).raised
	}

	def dispatch Object execute(EventValueReferenceExpression expression) {
		for (event : context.raisedEvents) {
			if (event.fqName.equals(expression.value.qname)) {
				return event.getValue;
			};
		}
		null;
	}

	def name(EObject e) {
		return SimpleAttributeResolver::NAME_RESOLVER.apply(e)
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

	def executeBinaryCoreFunction(Statement leftStatement, Statement rightStatement, String operator) {
		var leftResult = leftStatement.execute()
		var rightResult = rightStatement.execute()
		return evaluate(operator, leftResult, rightResult)
	}

	def executeUnaryCoreFunction(Statement statement, String operator) {
		var result = statement.execute()
		return evaluate(operator, result);
	}

	def dispatch Object execute(FeatureCall call) {
		if (call.operationCall) {
			var parameter = call.args.map(it|execute)
			var operation = call.feature as Operation
			if (operationDelegate.canExecute(operation, parameter)) {
				return operationDelegate.execute(operation, parameter)
			}
		} else if (call.getFeature() instanceof Enumerator) {
			return call.getFeature();
		} else {
			var fqn = call.feature.fqn
			var variableRef = context.getVariable(fqn)
			if (variableRef != null) {
				return variableRef.getValue
			}
			return context.getEvent(fqn).raised
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

}
