package org.yakindu.sct.generator.java

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.types.Operation
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.sgraph.Declaration
import org.yakindu.sct.model.sgraph.Event
import org.yakindu.sct.model.sgraph.Variable
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.AdditiveOperator
import org.yakindu.sct.model.stext.stext.AssignmentExpression
import org.yakindu.sct.model.stext.stext.AssignmentOperator
import org.yakindu.sct.model.stext.stext.BitwiseAndExpression
import org.yakindu.sct.model.stext.stext.BitwiseOrExpression
import org.yakindu.sct.model.stext.stext.BitwiseXorExpression
import org.yakindu.sct.model.stext.stext.BoolLiteral
import org.yakindu.sct.model.stext.stext.ElementReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.FeatureCall
import org.yakindu.sct.model.stext.stext.HexLiteral
import org.yakindu.sct.model.stext.stext.IntLiteral
import org.yakindu.sct.model.stext.stext.LogicalAndExpression
import org.yakindu.sct.model.stext.stext.LogicalNotExpression
import org.yakindu.sct.model.stext.stext.LogicalOrExpression
import org.yakindu.sct.model.stext.stext.LogicalRelationExpression
import org.yakindu.sct.model.stext.stext.MultiplicativeOperator
import org.yakindu.sct.model.stext.stext.NumericalAddSubtractExpression
import org.yakindu.sct.model.stext.stext.NumericalMultiplyDivideExpression
import org.yakindu.sct.model.stext.stext.NumericalUnaryExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition
import org.yakindu.sct.model.stext.stext.ParenthesizedExpression
import org.yakindu.sct.model.stext.stext.PrimitiveValueExpression
import org.yakindu.sct.model.stext.stext.RealLiteral
import org.yakindu.sct.model.stext.stext.RelationalOperator
import org.yakindu.sct.model.stext.stext.ShiftExpression
import org.yakindu.sct.model.stext.stext.ShiftOperator
import org.yakindu.sct.model.stext.stext.StringLiteral
import org.yakindu.sct.model.stext.stext.UnaryOperator
import org.yakindu.sct.model.stext.types.ISTextTypeSystem
import org.yakindu.sct.model.stext.types.ISTextTypeInferrer
import java.util.List

class ExpressionCode {
	
	@Inject extension Naming 
	@Inject extension Navigation
	@Inject extension ISTextTypeSystem
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
		}
		else
			expression.leftOperand.code + expression.operator.code + expression.rightOperand.code;
	}
	
	def String logicalString(LogicalRelationExpression expression) {
		if (expression.operator == RelationalOperator::EQUALS) {
			expression.leftOperand.code + "== null?" + expression.rightOperand.code + " ==null :" + expression.leftOperand.code+".equals("+expression.rightOperand.code+")"
		}
		else if(expression.operator == RelationalOperator::NOT_EQUALS) {
			expression.leftOperand.code + "== null?" + expression.rightOperand.code + " ==null : !" + expression.leftOperand.code+".equals("+expression.rightOperand.code+")"
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
		"isStateActive(State." + value.stateName.asEscapedIdentifier +")";
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
			event.definition.context+"raise"+event.definition.name.toFirstUpper+"("+value.code+")"			
		}
		else {
			event.definition.context+"raise"+event.definition.name.toFirstUpper+"()"
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
		if (scope!=null) {
			return scope.interfaceName.asEscapedIdentifier + "."
		}
		return ""
	}
	
	def dispatch String getContext(EObject it) {
		return "//ERROR: No context for " + it
	}
}