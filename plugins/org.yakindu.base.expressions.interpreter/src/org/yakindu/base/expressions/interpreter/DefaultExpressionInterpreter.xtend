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
package org.yakindu.base.expressions.interpreter

import com.google.common.collect.Sets
import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.Set
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.ArgumentExpression
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BlockExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.IfExpression
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
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.ReturnExpression
import org.yakindu.base.expressions.expressions.ShiftExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.expressions.expressions.WhileExpression
import org.yakindu.base.expressions.expressions.util.ArgumentSorter
import org.yakindu.base.expressions.util.ExpressionExtensions
import org.yakindu.base.types.EnumerationType
import org.yakindu.base.types.Enumerator
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Type
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.model.sruntime.CompositeSlot
import org.yakindu.sct.model.sruntime.ExecutionContext
import org.yakindu.sct.model.sruntime.ExecutionEvent
import org.yakindu.sct.model.sruntime.ExecutionSlot
import org.yakindu.sct.model.sruntime.ExecutionVariable
import org.yakindu.sct.model.sruntime.ReferenceSlot
import org.yakindu.sct.model.sruntime.SRuntimeFactory

/**
 * 
 * @author andreas muelder - Initial contribution and API 
 * @authos axel terfloth - additions
 * 
 */
@Singleton
class DefaultExpressionInterpreter extends AbstractExpressionInterpreter implements IExpressionInterpreter {

	@Inject
	protected extension ITypeSystem ts;
	@Inject
	protected extension IExecutionSlotResolver resolver

	@Inject(optional=true)
	protected Set<IOperationExecutor> operationExecutors = Sets.newHashSet

	@Inject(optional=true)
	protected ExecutionContext context

	@Inject
	protected extension ExpressionExtensions

	override evaluate(Expression expression, ExecutionContext context) {
		this.context = context
		expression.execute()
	}

	def protected dispatch Object execute(Expression expression) {
		null
	}

	def protected dispatch Object execute(ConditionalExpression expression) {
		if (expression.condition.execute as Boolean) {
			return expression.trueCase.execute
		} else {
			return expression.falseCase.execute
		}
	}

	def protected dispatch Object execute(BitwiseAndExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, CoreFunction::BIT_AND)
	}

	def protected dispatch Object execute(BitwiseOrExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, CoreFunction::BIT_OR)
	}

	def protected dispatch Object execute(BitwiseXorExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, CoreFunction::BIT_XOR)
	}

	def protected dispatch Object execute(LogicalRelationExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.getName())
	}

	def protected dispatch Object execute(NumericalAddSubtractExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.literal)
	}

	def protected dispatch Object execute(NumericalMultiplyDivideExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.getName())
	}

	def protected dispatch Object execute(ShiftExpression expression) {
		executeBinaryCoreFunction(expression.leftOperand, expression.rightOperand, expression.operator.getName())
	}

	def protected dispatch Object execute(NumericalUnaryExpression expression) {
		executeUnaryCoreFunction(expression.operand, expression.operator.getName())
	}

	def protected dispatch Object execute(PostFixUnaryExpression it) {
		var result = operand.execute
		val slot = context.resolve(operand).orElseThrow(SlotResolutionExceptionSupplier.forContext(operand))

		slot.value = evaluate(operator.getName(), result)
		result
	}

	def protected executeBinaryCoreFunction(Expression leftExpression, Expression rightExpression, String operator) {
		var leftResult = leftExpression.execute().resolveReference
		var rightResult = rightExpression.execute().resolveReference
		return evaluate(operator, leftResult, rightResult)
	}

	def protected dispatch Object execute(LogicalAndExpression expression) {
		var leftResult = execute(expression.leftOperand)
		if (!leftResult as Boolean)
			return false
		var rightResult = execute(expression.rightOperand)
		return leftResult as Boolean && rightResult as Boolean
	}

	def protected dispatch Object execute(LogicalOrExpression expression) {
		var leftResult = execute(expression.leftOperand)
		if (leftResult as Boolean)
			return true
		var rightResult = execute(expression.rightOperand)
		return leftResult as Boolean || rightResult as Boolean
	}

	def protected dispatch Object execute(AssignmentExpression assignment) {
		executeAssignment(assignment)
	}

	def protected dispatch Object execute(LogicalNotExpression expression) {
		return ! (expression.operand.execute() as Boolean)
	}

	def protected Object resolveReference(Object element) {
		if (element instanceof ReferenceSlot) {
			return element.reference
		}
		return element
	}

	def protected dispatch Object execute(TypeCastExpression expression) {
		var operand = expression.operand.execute
		typeCast(operand, expression.type.originType)
	}

	def protected Object cast(Object value, Type type) {
		if (type !== null) {
			typeCast(value, type.originType)
		} else {
			value
		}
	}

	def protected dispatch Object execute(WhileExpression exp) {
		var condition = evaluate(exp.condition, context) as Boolean
		var Object result = null
		while (condition) {
			result = exp.body.execute
			condition = evaluate(exp.condition, context) as Boolean
		}
		return result
	}

	def protected dispatch Object execute(IfExpression exp) {
		var condition = evaluate(exp.condition, context) as Boolean
		return if(condition) evaluate(exp.then, context) else evaluate(exp.^else, context)
	}

	def protected dispatch Object execute(ReturnExpression it) {
		return it.expression.execute
	}

	def protected dispatch Object execute(BlockExpression it) {
		var Object result = null
		for (exp : expressions) {
			result = evaluate(exp, context)
		}
		result
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
		if(ts.isAny(type)) return value
		return value
	}

	def protected Object executeAssignment(AssignmentExpression assignment) {
		var scopeVariable = context.resolve(assignment.varRef).orElseThrow(
			SlotResolutionExceptionSupplier.forContext(assignment.varRef))

		var result = assignment.expression.execute
		if (result instanceof Enumerator)
			result = result.literalValue

		if (assignment.operator == AssignmentOperator::ASSIGN) {
			// Strong typing, use the type of the scopeVariable instead of using new runtime type
			scopeVariable.value = if(result !== null) cast(result, scopeVariable.type) else null
		} else {
			var operator = assignFunctionMap.get(assignment.operator.getName())
			scopeVariable.value = if (result !== null)
				cast(evaluate(operator, scopeVariable.value, result), scopeVariable.type)
			else
				null
		}
		scopeVariable.value
	}

	def protected dispatch Object execute(ParenthesizedExpression e) {
		e.expression.execute()
	}

	def protected dispatch Object execute(PrimitiveValueExpression expression) {
		return expression.value.valueLiteral
	}

	def protected dispatch valueLiteral(IntLiteral literal) {
		return literal.value as long
	}

	def protected dispatch valueLiteral(BoolLiteral bool) {
		return bool.value
	}

	def protected dispatch valueLiteral(DoubleLiteral literal) {
		return literal.value
	}

	def protected dispatch valueLiteral(FloatLiteral literal) {
		return literal.value
	}

	def protected dispatch valueLiteral(StringLiteral literal) {
		return literal.value
	}

	def protected dispatch valueLiteral(NullLiteral literal) {
		return null
	}

	def protected dispatch Object execute(ElementReferenceExpression expression) {
		executeElementReferenceExpression(expression)
	}

	def protected executeElementReferenceExpression(ElementReferenceExpression expression) {
		val slot = context.resolve(expression)
		return doExecute(expression.reference, slot.orElse(null), expression)
	}

	def protected dispatch Object execute(FeatureCall call) {
		executeFeatureCall(call)
	}

	def protected executeFeatureCall(FeatureCall call) {
		var Object result
		for (ArgumentExpression exp : call.toCallStack) {
			val slot = context.resolve(exp)
			result = doExecute(exp.featureOrReference, slot.orElse(null), exp)
		}
		return result
	}

	def protected dispatch doExecute(EObject feature, Void slot, ArgumentExpression exp) {
		println("No implementation found for " + exp + " -> returning null")
		null
	}

	def protected dispatch doExecute(EObject feature, ExecutionVariable slot, ArgumentExpression exp) {
		slot.value
	}

	def protected dispatch doExecute(EObject feature, CompositeSlot slot, ArgumentExpression exp) {
		slot
	}

	def protected dispatch doExecute(EObject feature, ExecutionEvent slot, ArgumentExpression exp) {
		slot.raised
	}

	def protected dispatch doExecute(Operation feature, ExecutionEvent slot, ArgumentExpression exp) {
		slot.raised = true
	}

	def protected dispatch doExecute(Operation operation, Void slot, ArgumentExpression exp) {
		if (operation.body !== null) {
			return operation.executeOperationBody(exp)
		}
		val executor = operationExecutors.findFirst[canExecute(exp)]
		if (executor !== null) {
			return executor.executeOperation(exp)
		}
	}

	def protected dispatch doExecute(Operation operation, ExecutionSlot slot, ArgumentExpression exp) {
		if (operation.body !== null) {
			return operation.executeOperationBody(exp)
		}
		val executor = operationExecutors.findFirst[canExecute(exp)]
		if (executor !== null) {
			slot.value = executor.executeOperation(exp)
		}
		return slot.value
	}

	def protected executeOperationBody(Operation operation, ArgumentExpression exp) {
		val callStack = context.slots.findFirst[name == "callStack"] as CompositeSlot
		val argumentExpression = ArgumentSorter.getOrderedExpressions(exp.arguments, operation)
		// TODO This wont work with different operations calling each other with same name of parameters
		argumentExpression.forEach [ e, i | 
			val slot = resolver.resolve(context, e)
			if (slot.present) {
				callStack.getSlots += SRuntimeFactory.eINSTANCE.createReferenceSlot => [
					reference = slot.get
					name = operation.parameters.get(i).name
					fqName = operation.parameters.get(i).name
				]
			} else {
				callStack.slots += SRuntimeFactory.eINSTANCE.createExecutionVariable => [
					name = operation.parameters.get(argumentExpression.indexOf(e)).name
					value = e.execute
				]
			}

		]
		val result =  operation.body.execute
		callStack.slots.clear
		return result
	}

	def protected dispatch doExecute(Enumerator feature, Void slot, ArgumentExpression exp) {
		new Long(feature.literalValue)
	}

	def protected dispatch doExecute(Type feature, Void slot, ArgumentExpression exp) {
		null
	}

	def protected executeUnaryCoreFunction(Expression expression, String operator) {
		var result = expression.execute()
		return evaluate(operator, result);
	}

	def protected executeOperation(IOperationExecutor executor, ArgumentExpression expression) {
		executor.execute(expression, context)
	}

}
