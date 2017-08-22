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
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.xtext.naming.IQualifiedNameProvider
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.Expression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.ShiftExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Type
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.simulation.core.sruntime.CompositeSlot
import org.yakindu.sct.simulation.core.sruntime.ExecutionContext
import org.yakindu.sct.simulation.core.sruntime.ExecutionEvent
import org.yakindu.sct.simulation.core.sruntime.ExecutionVariable
import org.yakindu.sct.simulation.core.sruntime.ReferenceSlot
import org.yakindu.base.types.Event

/**
 * 
 * @author andreas muelder - Initial contribution and API 
 * @authos axel terfloth - additions
 * 
 */
class StextStatementInterpreter extends AbstractStatementInterpreter {

	@Inject
	extension IQualifiedNameProvider provider
	@Inject(optional=true)
	protected IOperationMockup operationDelegate
	@Inject(optional=true)
	protected extension IEventRaiser eventRaiser	
	@Inject
	protected extension IExecutionSlotResolver resolver
	@Inject
	protected extension ITypeSystem ts;

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

	def dispatch Object execute(TypeCastExpression expression) {
		var operand = expression.operand.execute
		typeCast(operand, expression.type.originType)
	}

	def Object cast(Object value, Type type){
		typeCast(value, type.originType)
	}

	def protected dispatch Object typeCast(Long value, Type type) {
		if(type instanceof EnumerationType) return value
		if(ts.isSuperType(type, ts.getType(GenericTypeSystem.INTEGER))) return value
		if(ts.isSuperType(type, ts.getType(GenericTypeSystem.REAL))) return Double.valueOf(value)
		throw new IllegalArgumentException("unknown type " + type.name)
	}

	def protected dispatch Object typeCast(Float value, Type type) {
		if(ts.isSuperType(type, ts.getType(GenericTypeSystem.INTEGER))) return value.longValue
		if(ts.isSuperType(type, ts.getType(GenericTypeSystem.REAL))) return Double.valueOf(value)
		throw new IllegalArgumentException("Invalid cast from Float to " + type.name)
	}

	def protected dispatch Object typeCast(Double value, Type type) {
		if(ts.isSuperType(type, ts.getType(ITypeSystem.INTEGER))) return value.longValue
		if(ts.isSuperType(type, ts.getType(ITypeSystem.REAL))) return Double.valueOf(value)
		throw new IllegalArgumentException("Invalid cast from Double to " + type.name)
	}

	def protected dispatch Object typeCast(Boolean value, Type type) {
		if(ts.isSuperType(type, ts.getType(ITypeSystem.BOOLEAN))) return value
		throw new IllegalArgumentException("Invalid cast from Boolean to " + type.name)
	}

	def protected dispatch Object typeCast(String value, Type type) {
		if(ts.isSuperType(type, ts.getType(ITypeSystem.STRING))) return value
		throw new IllegalArgumentException("Invalid cast from String to " + type.name)
	}

	def protected dispatch Object typeCast(Enumerator value, Type type) {
		if(ts.isSuperType(type, value.owningEnumeration)) return value
		throw new IllegalArgumentException("Invalid cast from Enumerator to " + type.name)
	}

	def protected dispatch Object typeCast(Object value, Type type) {
		if(ts.isSame(type, ts.getType(ITypeSystem.ANY))) return value
		return value
	}

	def Object executeAssignment(AssignmentExpression assignment) {
		var scopeVariable = context.resolve(assignment.varRef)
		var result = assignment.expression.execute
		if(result instanceof Enumerator) result = result.literalValue

		if (assignment.operator == AssignmentOperator::ASSIGN) {
			// Strong typing, use the type of the scopeVariable instead of using new runtime type
			scopeVariable.value = if(result !== null) cast(result, scopeVariable.type) else null
		} else {
			var operator = AbstractStatementInterpreter::assignFunctionMap.get(assignment.operator.getName())
			scopeVariable.value = if (result !== null)
				cast(evaluate(operator, scopeVariable.getValue, result), scopeVariable.type)
			else
				null
		}
		scopeVariable.value
	}

	def dispatch Object execute(EventRaisingExpression eventRaising) {
		var event = context.resolve(eventRaising.event)

		if (event instanceof ExecutionEvent) {
			
			val value = eventRaising.value?.execute	
		
			if (eventRaiser !== null) event.raise(value) 
		}
		
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
		executeElementReferenceExpression(expression)
	}

	def dispatch Object execute(EventValueReferenceExpression expression) {
		for (event : context.raisedEvents) {
			val executionSlot = context.resolve(expression.value)
			if (executionSlot instanceof ExecutionEvent && executionSlot.fqName == event.fqName) {
				return event.getValue;
			};
		}
		throw new UndefinedValueException("Undefined value of event '" + expression.value.eventName + "'\n" + "Event values only exist in the same cycle in which the event was raised.")
	}
	
	def dispatch protected getEventName(Expression it){
		return "null"
	}
	
	def dispatch protected getEventName(ElementReferenceExpression it){
		if(reference instanceof Event){
			return (reference as Event).name
		}
		return "null"
	}
	
	def dispatch protected getEventName(FeatureCall it){
		if(feature instanceof Event){
			return (feature as Event).name
		}
		return "null"
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
		var leftResult = leftStatement.execute().resolveReference
		var rightResult = rightStatement.execute().resolveReference
		return evaluate(operator, leftResult, rightResult)
	}

	protected def Object resolveReference(Object element) {
		if (element instanceof ReferenceSlot) {
			return element.reference
		}
		return element
	}

	def executeUnaryCoreFunction(Expression statement, String operator) {
		var result = statement.execute()
		return evaluate(operator, result);
	}

	def dispatch Object execute(FeatureCall call) {
		executeFeatureCall(call)
	}
	
	def executeElementReferenceExpression(ElementReferenceExpression expression){
		var parameter = expression.expressions.map(it|execute)
		if (expression.operationCall || expression.reference instanceof OperationDefinition) {
			if (operationDelegate !== null &&
				operationDelegate.canExecute(expression.reference as Operation, parameter.toArray)) {
				return (expression.reference as Operation).execute(parameter.toArray)
			}
		}
		// for enumeration types return the literal value
		if (expression.reference instanceof Enumerator) {
			return new Long((expression.reference as Enumerator).literalValue)
		}

		val executionSlot = context.resolve(expression)
		if (executionSlot instanceof ExecutionVariable)
			return executionSlot.getValue
		if (executionSlot instanceof ExecutionEvent)
			return (executionSlot as ExecutionEvent).raised

		// reference to an element with complex type is not reflected in an execution variable but in a composite slot
		// TODO hide reference mechanism in resolver
		if (executionSlot instanceof CompositeSlot)
			return executionSlot

		return null
	}

	def executeFeatureCall(FeatureCall call) {
		if (call.operationCall || call.feature instanceof OperationDefinition) {
			var parameter = call.expressions.map(it|execute)
			if (call.feature instanceof Operation) {
				var Operation operation = call.feature as Operation
				if (operationDelegate !== null && operationDelegate.canExecute(operation, parameter)) {
					return operation.execute(parameter)
				}
			}

		} else if (call.getFeature() instanceof Enumerator) {
			return new Long((call.getFeature() as Enumerator).literalValue)
		}

		var slot = context.resolve(call)
		if (slot instanceof ExecutionVariable) {
			return slot.getValue
		}
		if (slot instanceof CompositeSlot) {
			return slot
		}
		if (slot instanceof ExecutionEvent) {
			if (call.feature instanceof Operation) {
				(slot as ExecutionEvent).raised = true
			}

			return (slot as ExecutionEvent).raised
		}

		println("No feature found for " + call.feature.fqn + " -> returning null")
		return null;
	}

	def execute(Operation it, List<Object> params) {
		operationDelegate.execute(it, params)
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
		return literal.value as long
	}

	def dispatch valueLiteral(BoolLiteral bool) {
		return bool.value
	}

	def dispatch valueLiteral(DoubleLiteral literal) {
		return literal.value
	}

	def dispatch valueLiteral(FloatLiteral literal) {
		return literal.value
	}

	def dispatch valueLiteral(StringLiteral literal) {
		return literal.value
	}

	def dispatch valueLiteral(NullLiteral literal) {
		return null
	}
	
	protected static class UndefinedValueException extends IllegalStateException {
	
		new(String message) {
			super(message)
		}
	
	}

}
