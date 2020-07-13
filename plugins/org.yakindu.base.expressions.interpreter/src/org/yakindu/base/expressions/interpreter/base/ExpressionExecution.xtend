package org.yakindu.base.expressions.interpreter.base

import java.util.Map
import org.yakindu.base.base.NamedElement
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.BinaryExpression
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.interpreter.CoreFunction
import org.yakindu.base.types.Expression
import org.yakindu.base.types.Operation
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.sct.model.sruntime.ExecutionEvent

class ExpressionExecution extends BaseExecution implements IInterpreter.Execution {
	
	protected static Map<AssignmentOperator, String> assignFunctionMap = #{
		AssignmentOperator.MULT_ASSIGN -> "*",
		AssignmentOperator.DIV_ASSIGN -> "/",
		AssignmentOperator.MOD_ASSIGN -> "%",
		AssignmentOperator.ADD_ASSIGN -> "+",
		AssignmentOperator.SUB_ASSIGN -> "-",
		AssignmentOperator.LEFT_SHIFT_ASSIGN -> "<<",
		AssignmentOperator.RIGHT_SHIFT_ASSIGN -> ">>",
		AssignmentOperator.AND_ASSIGN -> "&",
		AssignmentOperator.XOR_ASSIGN -> "^",
		AssignmentOperator.OR_ASSIGN -> "|"
	};
	
	protected extension CoreFunctionExecution cf = new CoreFunctionExecution
		
	override provideExecution(Object program) {
		program.execution
	}
	
		
	def dispatch void execution(Object it) {
	}


	def dispatch void execution(PrimitiveValueExpression expr) {
		_return(expr.value.valueLiteral.toString, [
			expr.value.valueLiteral
		])
	}
	
	def dispatch void execution(ParenthesizedExpression expr) {
		expr.expression._exec
		_return[ popValue ]
	}
	

	def dispatch void execution(AssignmentExpression expr) {
		expr.expression._exec
		_value
		expr.varRef._exec
		_execute( expr.operator.literal, [ 
			val f = assignFunctionMap.get(expr.operator)
			val varRef = popValue
			var value = popValue

			if ( expr.operator !== AssignmentOperator.ASSIGN) {
				val varValue = varRef.value
				value = evaluate(f, varValue, value)
			}
			
			varRef.setValue = value
		])
	}
	
	def dispatch void execution(ElementReferenceExpression expr) {
		if (expr.reference instanceof Operation) {
			expr.arguments.forEach[ value._exec ]			
			expr.reference._call
		} else {
			_return [
				resolve(null, expr.reference.symbol)
			]
		}
	}

	def dispatch void execution(FeatureCall expr) {
		expr.owner._exec
		_return [
			popValue.resolve(expr.feature.symbol)
		]
	}

	def dispatch String symbol(Object it) {
		null
	}
	
	def dispatch String symbol(NamedElement it) {
		it.name
	}
	
	def dispatch void execution(BinaryExpression it) {
		binaryExpressionExecution(operator.getName, leftOperand, rightOperand)
	}

	protected def void binaryExpressionExecution(String operator, Expression left, Expression right) {
		left._exec  
		_value
		right._exec 
		_value
		_return (operator, [ 
			val rightValue = popValue
			val leftValue = popValue
			
			evaluate(operator, leftValue, rightValue)
		])
	}
	
	
	def dispatch void execution(LogicalOrExpression expr) {
		expr.leftOperand._exec
		_value
		_execute ('||', [ 
			if (popValue == true) { 
				_return[true]
			}
			else {
				expr.rightOperand._exec
				_value
				_return[popValue]
			}
		])
	}
	

	def dispatch void execution(LogicalAndExpression expr) {
		expr.leftOperand._exec
		_value
		_execute ('&&', [ 
			if (popValue == false) { 
				_return[false]
			}
			else {
				expr.rightOperand._exec
				_value
				_return[popValue]
			}
		])
	}
	
	
	def dispatch void execution(BitwiseAndExpression it) {
		binaryExpressionExecution(CoreFunction.BIT_AND, leftOperand, rightOperand)
	}
	
	def dispatch void execution(BitwiseOrExpression it) {
		binaryExpressionExecution(CoreFunction.BIT_OR, leftOperand, rightOperand)
	}
	
	def dispatch void execution(BitwiseXorExpression it) {
		binaryExpressionExecution(CoreFunction.BIT_XOR, leftOperand, rightOperand)
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
	
	def void _call(Object it) {
		executionCall
	}

	def dispatch void executionCall(Object it) {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")		
	}
	
}