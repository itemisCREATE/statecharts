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
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
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
import org.yakindu.base.expressions.expressions.PostFixUnaryExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.ShiftExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.TypeCastExpression
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

	override evaluate(Expression statement, ExecutionContext context) {
		this.context = context
		statement.execute()
	}

	def dispatch Object execute(Expression statement) {
		null
	}

	def dispatch Object execute(ConditionalExpression expression) {
		if (expression.condition.execute as Boolean) {
			return expression.trueCase.execute
		} else {
			return expression.falseCase.execute
		}
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

	def dispatch Object execute(PostFixUnaryExpression it) {
		var result = operand.execute
		context.resolve(operand).value = evaluate(operator.getName(), result)
		result
	}

	def executeBinaryCoreFunction(Expression leftStatement, Expression rightStatement, String operator) {
		var leftResult = leftStatement.execute().resolveReference
		var rightResult = rightStatement.execute().resolveReference
		return evaluate(operator, leftResult, rightResult)
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

	protected def Object resolveReference(Object element) {
		if (element instanceof ReferenceSlot) {
			return element.reference
		}
		return element
	}

	def dispatch Object execute(AssignmentExpression assignment) {
		executeAssignment(assignment)
	}

	def dispatch Object execute(TypeCastExpression expression) {
		var operand = expression.operand.execute
		typeCast(operand, expression.type.originType)
	}

	def Object cast(Object value, Type type) {
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
			var operator = assignFunctionMap.get(assignment.operator.getName())
			scopeVariable.value = if (result !== null)
				cast(evaluate(operator, scopeVariable.getValue, result), scopeVariable.type)
			else
				null
		}
		scopeVariable.value
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

	def dispatch Object execute(ElementReferenceExpression expression) {
		executeElementReferenceExpression(expression)
	}

	def executeElementReferenceExpression(ElementReferenceExpression expression) {
		val executionSlot = context.resolve(expression)
		return doExecute(expression.reference, executionSlot, expression)
	}

	def dispatch Object execute(FeatureCall call) {
		executeFeatureCall(call)
	}

	def executeFeatureCall(FeatureCall call) {
		var result = null as Object
		var slot = null as ExecutionSlot
		for (ArgumentExpression exp : call.toCallStack) {
			slot = context.resolve(exp)
			result = doExecute(exp.featureOrReference, slot, exp)
		}
		return result
	}
	
	def dispatch doExecute(EObject feature, Void slot, ArgumentExpression exp) {
		// fall-back
		println("No implementation found for " + exp + " -> returning null")
		null
	}
	
	def dispatch doExecute(EObject feature, ExecutionVariable slot, ArgumentExpression exp) {
		slot.value
	}
	
	def dispatch doExecute(EObject feature, CompositeSlot slot, ArgumentExpression exp) {
		slot
	}
	
	def dispatch doExecute(EObject feature, ExecutionEvent slot, ArgumentExpression exp) {
		slot.raised
	}
	
	def dispatch doExecute(Operation feature, ExecutionEvent slot, ArgumentExpression exp) {
		slot.raised = true
	}
	
	def dispatch doExecute(Operation feature, ExecutionSlot slot, ArgumentExpression exp) {
		val executor = operationExecutors.findFirst[canExecute(exp)]
		if (executor !== null) {
			slot.value = executor.executeOperation(exp)
		}
		return slot.value
	}
	
	def dispatch doExecute(Enumerator feature, Void slot, ArgumentExpression exp) {
		new Long(feature.literalValue)
	}

	def executeUnaryCoreFunction(Expression statement, String operator) {
		var result = statement.execute()
		return evaluate(operator, result);
	}

	def executeOperation(IOperationExecutor executor, ArgumentExpression expression) {
		executor.execute(expression, context)
	}

}
