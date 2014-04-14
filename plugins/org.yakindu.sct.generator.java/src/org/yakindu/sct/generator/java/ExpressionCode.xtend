package org.yakindu.sct.generator.java

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.AdditiveOperator
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.AssignmentOperator
import org.yakindu.base.expressions.expressions.BitwiseAndExpression
import org.yakindu.base.expressions.expressions.BitwiseOrExpression
import org.yakindu.base.expressions.expressions.BitwiseXorExpression
import org.yakindu.base.expressions.expressions.BoolLiteral
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.HexLiteral
import org.yakindu.base.expressions.expressions.IntLiteral
import org.yakindu.base.expressions.expressions.LogicalAndExpression
import org.yakindu.base.expressions.expressions.LogicalNotExpression
import org.yakindu.base.expressions.expressions.LogicalOrExpression
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.MultiplicativeOperator
import org.yakindu.base.expressions.expressions.NumericalAddSubtractExpression
import org.yakindu.base.expressions.expressions.NumericalMultiplyDivideExpression
import org.yakindu.base.expressions.expressions.NumericalUnaryExpression
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RealLiteral
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.expressions.expressions.ShiftExpression
import org.yakindu.base.expressions.expressions.ShiftOperator
import org.yakindu.base.expressions.expressions.StringLiteral
import org.yakindu.base.expressions.expressions.UnaryOperator
import org.yakindu.base.types.ITypeSystem
import org.yakindu.base.types.Operation
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.sgraph.Event
import org.yakindu.sct.model.sgraph.Variable
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer
import org.yakindu.base.expressions.expressions.NullLiteral

class ExpressionCode {

	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension ITypeSystem
	@Inject extension ISTextTypeInferrer

	private var List<TimeEvent> timeEvents;

	def private getTimeEvents(TimeEvent it) {
		if (timeEvents == null) {
			timeEvents = flow.timeEvents
		}
		return timeEvents
	}

	def dispatch String code(EObject it) '''
		//ERROR: Template in ExpressionCode.xtend for class '«getClass().name»' not define.
		//Container: «eContainer?.getClass().name»
	'''

	def dispatch String code(OperationDefinition it) {
		return context + "operationCallback." + name.asEscapedIdentifier;
	}

	def dispatch String code(PrimitiveValueExpression primValue) {
		primValue.value.code;
	}

	def dispatch String code(ParenthesizedExpression e) {
		"(" + e.expression.code + ")";
	}

	/* Assignment */
	def dispatch String code(AssignmentExpression it) {
		varRef.code + operator.code + expression.code
	}

	/* Literals */
	def dispatch String code(BoolLiteral expression) {
		expression.value.toString()
	}

	def dispatch String code(IntLiteral expression) {
		expression.value.toString();
	}

	def dispatch String code(HexLiteral expression) {
		expression.value.toString();
	}

	def dispatch String code(RealLiteral expression) {
		expression.value.toString();
	}
	
	def dispatch String code(NullLiteral expression) {
		'null'
	}

	def dispatch String code(StringLiteral expression) {
		"\"" + expression.value.toString().escaped + "\""
	}

	def String escaped(String it) {
		return it.replace("\"", "\\\"");
	}

	/* Logical Expressions */
	def dispatch String code(LogicalOrExpression expression) {
		expression.leftOperand.code + " || " + expression.rightOperand.code
	}

	def dispatch String code(LogicalAndExpression expression) {
		expression.leftOperand.code + " && " + expression.rightOperand.code
	}

	def dispatch String code(LogicalNotExpression expression) {
		" !" + expression.operand.code
	}

	def dispatch String code(LogicalRelationExpression expression) {
		if (expression.leftOperand.inferType.type.stringType) {
			expression.logicalString
		} else
			expression.leftOperand.code + expression.operator.code + expression.rightOperand.code;
	}

	def String logicalString(LogicalRelationExpression expression) {
		if (expression.operator == RelationalOperator::EQUALS) {
			expression.leftOperand.code + "== null?" + expression.rightOperand.code + " ==null :" +
				expression.leftOperand.code + ".equals(" + expression.rightOperand.code + ")"
		} else if (expression.operator == RelationalOperator::NOT_EQUALS) {
			expression.leftOperand.code + "== null?" + expression.rightOperand.code + " ==null : !" +
				expression.leftOperand.code + ".equals(" + expression.rightOperand.code + ")"
		}
	}

	def dispatch String code(BitwiseAndExpression expression) {
		expression.leftOperand.code + " & " + expression.rightOperand.code
	}

	def dispatch String code(BitwiseOrExpression expression) {
		expression.leftOperand.code + " | " + expression.rightOperand.code
	}

	def dispatch String code(BitwiseXorExpression expression) {
		expression.leftOperand.code + " ^ " + expression.rightOperand.code
	}

	def dispatch String code(ShiftExpression expression) {
		expression.leftOperand.code + expression.operator.code + expression.rightOperand.code
	}

	def dispatch String code(NumericalAddSubtractExpression expression) {
		expression.leftOperand.code + expression.operator.code + expression.rightOperand.code
	}

	def dispatch String code(NumericalMultiplyDivideExpression expression) {
		expression.leftOperand.code + expression.operator.code + expression.rightOperand.code

	}

	def dispatch String code(NumericalUnaryExpression expression) {
		expression.operator.code + expression.operand.code
	}

	def dispatch String code(ActiveStateReferenceExpression it) {
		"isStateActive(State." + value.stateName.asEscapedIdentifier + ")";
	}

	def dispatch String code(AdditiveOperator operator) {
		operator.literal
	}

	def dispatch String code(ShiftOperator operator) {
		operator.literal
	}

	def dispatch String code(UnaryOperator operator) {
		operator.literal
	}

	def dispatch String code(MultiplicativeOperator operator) {
		operator.literal
	}

	def dispatch String code(RelationalOperator operator) {
		operator.literal
	}

	def dispatch String code(AssignmentOperator operator) {
		operator.literal
	}

	def dispatch String code(EventRaisingExpression it) {
		if (value != null) {
			event.definition.context + "raise" + event.definition.name.toFirstUpper + "(" + value.code + ")"
		} else {
			event.definition.context + "raise" + event.definition.name.toFirstUpper + "()"
		}
	}

	def dispatch String code(EventValueReferenceExpression it) {
		value.definition.context + value.definition.event.valueIdentifier
	}

	def dispatch String code(ElementReferenceExpression it) '''
		«IF operationCall»
			«reference.code»(«FOR arg : args SEPARATOR ", "»«arg.code»«ENDFOR»)
		«ELSE»
			«definition.code»
		«ENDIF»
	'''

	def dispatch String code(FeatureCall it) '''
		«IF feature instanceof Operation»
			«feature.code»(«FOR arg : args SEPARATOR ", "»«arg.code»«ENDFOR»)
		«ELSE»
			«definition.context + definition.name.asEscapedIdentifier»
		«ENDIF»
	'''

	def dispatch String code(Declaration it) {
		context + name.asEscapedIdentifier
	}

	def dispatch String code(TimeEvent it) {
		"timeEvents[" + getTimeEvents.indexOf(it) + "]"
	}

	def dispatch String getContext(Variable it) {
		if (scope != null) {
			return scope.interfaceName.asEscapedIdentifier + "."
		}
		return ""
	}

	def dispatch String getContext(Event it) {
		if (scope != null) {
			return scope.interfaceName.asEscapedIdentifier + "."
		}
		return ""
	}

	def dispatch String getContext(OperationDefinition it) {
		if (scope != null) {
			return scope.interfaceName.asEscapedIdentifier + "."
		}
		return ""
	}

	def dispatch String getContext(EObject it) {
		return "//ERROR: No context for " + it
	}
}
