package org.yakindu.base.expressions.interpreter.base

import org.yakindu.base.expressions.expressions.BinaryExpression
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.DoubleLiteral
import org.yakindu.base.expressions.expressions.FloatLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.NullLiteral
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.interpreter.CoreFunction
import org.yakindu.base.expressions.interpreter.base.IInterpreter.Context
import org.yakindu.base.types.Expression

class ExpressionExecution extends BaseExecution implements IInterpreter.Execution {
	
	protected extension CoreFunctionExecution cf = new CoreFunctionExecution
		
	override provideExecution(Object program) {
		program.execution
	}
	
		
	def dispatch void execution(Object it) {
	}


	def dispatch void execution(PrimitiveValueExpression expr) {
		_return([
			expr.value.valueLiteral
		])
	}
	
	def dispatch void execution(ParenthesizedExpression expr) {
		expr.expression._exec
		_return[ popValue ]
	}
	

	def dispatch void execution(BinaryExpression it) {
		binaryExpressionExecution(operator.getName, leftOperand, rightOperand)
	}

	protected def void binaryExpressionExecution(String operator, Expression left, Expression right) {
		left._exec
		right._exec
		_return [ 
			val rightValue = popValue
			val leftValue = popValue
			
			evaluate(operator, leftValue, rightValue)
		]		
	}
	
	
	def dispatch void execution(LogicalOrExpression expr) {
		expr.leftOperand._exec
		_execute [ 
			if (popValue == true) { 
				_return[true]
			}
			else {
				expr.rightOperand._exec
				_return[popValue]
			}
			null
		]
	}
	

	def dispatch void execution(LogicalAndExpression expr) {
		expr.leftOperand._exec
		_execute [ 
			if (popValue == false) { 
				_return[false]
			}
			else {
				expr.rightOperand._exec
				_return[popValue]
			}
			null
		]
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
	
	
	
}