package org.yakindu.sct.generator.csharp

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.yakindu.base.expressions.expressions.AssignmentExpression
import org.yakindu.base.expressions.expressions.ConditionalExpression
import org.yakindu.base.expressions.expressions.ElementReferenceExpression
import org.yakindu.base.expressions.expressions.FeatureCall
import org.yakindu.base.expressions.expressions.LogicalRelationExpression
import org.yakindu.base.expressions.expressions.ParenthesizedExpression
import org.yakindu.base.expressions.expressions.PrimitiveValueExpression
import org.yakindu.base.expressions.expressions.RelationalOperator
import org.yakindu.base.expressions.expressions.TypeCastExpression
import org.yakindu.base.types.Declaration
import org.yakindu.base.types.Event
import org.yakindu.base.types.Operation
import org.yakindu.base.types.Property
import org.yakindu.base.types.inferrer.ITypeSystemInferrer
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.base.types.typesystem.ITypeSystem
import org.yakindu.sct.generator.core.templates.ExpressionsGenerator
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.TimeEvent
import org.yakindu.sct.model.stext.stext.ActiveStateReferenceExpression
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression
import org.yakindu.sct.model.stext.stext.OperationDefinition

class CSharpExpressionsGenerator extends ExpressionsGenerator {

	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension ITypeSystem
	@Inject extension ITypeSystemInferrer
	@Inject extension ICodegenTypeSystemAccess

	private var List<TimeEvent> timeEvents;

	def private getTimeEvents(TimeEvent it) {
		if (timeEvents == null) {
			timeEvents = flow.timeEvents
		}
		return timeEvents
	}

	def dispatch CharSequence code(OperationDefinition it) {
		return context + "operationCallback." + name.asEscapedIdentifier;
	}

	override dispatch CharSequence code(PrimitiveValueExpression primValue) {
		primValue.value.code;
	}

	override dispatch CharSequence code(ParenthesizedExpression e) {
		"(" + e.expression.code.toString.trim + ")";
	}

	/* Assignment */
	override dispatch CharSequence code(AssignmentExpression it) {
		varRef.code.toString.trim  + " " +  operator.literal + " " + expression.code.toString.trim
	}

	/* Literals */


//	override dispatch CharSequence code(StringLiteral expression) {
//		"\"" + expression.value.toString().escaped + "\""
//	}


	override dispatch CharSequence code(ConditionalExpression expression) {
		expression.condition.code.toString.trim + ' ? ' + expression.trueCase.code + ' : ' + expression.falseCase.code
	}

	override dispatch CharSequence code(LogicalRelationExpression expression) {
		if (isSame(expression.leftOperand.infer.type, getType(GenericTypeSystem.STRING))) {
			expression.logicalString
		} else
			expression.leftOperand.code.toString.trim + expression.operator.value + expression.rightOperand.code;
	}

	def CharSequence logicalString(LogicalRelationExpression expression) {
		if (expression.operator == RelationalOperator::EQUALS) {
			"(" + expression.leftOperand.code + "== null?" + expression.rightOperand.code + " ==null :" +
				expression.leftOperand.code + ".Equals(" + expression.rightOperand.code + "))"
		} else if (expression.operator == RelationalOperator::NOT_EQUALS) {
			"(" + expression.leftOperand.code + "== null?" + expression.rightOperand.code + " !=null : !" +
				expression.leftOperand.code + ".Equals(" + expression.rightOperand.code + "))"
		}
	}

	def dispatch CharSequence code(ActiveStateReferenceExpression it) {
		"isStateActive(State." + value.stateName.asEscapedIdentifier + ")";
	}

	def dispatch CharSequence code(EventRaisingExpression it) {
		if (value != null) {
			event.definition.context + "raise" + event.definition.name.toFirstUpper + "(" + value.code + ")"
		} else {
			event.definition.context + "raise" + event.definition.name.toFirstUpper + "()"
		}
	}

	def dispatch CharSequence code(EventValueReferenceExpression it) {
		value.definition.context + value.definition.event.valueIdentifier
	}

	def dispatch CharSequence code(ElementReferenceExpression it) '''
		«IF it.reference instanceof OperationDefinition»
			«reference.code»(«FOR arg : expressions SEPARATOR ", "»«arg.code»«ENDFOR»)
		«ELSE»
			«definition.code»«ENDIF»
	'''

	def dispatch CharSequence code(FeatureCall it) '''
		«IF feature instanceof Operation»
			«feature.code»(«FOR arg : expressions SEPARATOR ", "»«arg.code»«ENDFOR»)
		«ELSE»
			«definition.context + definition.name.asEscapedIdentifier»
		«ENDIF»
	'''

	def dispatch CharSequence code(Declaration it) {
		context + name.asEscapedIdentifier
		}

	def dispatch CharSequence code(TimeEvent it) {
		"timeEvents[" + getTimeEvents.indexOf(it) + "]"
	}

	override dispatch CharSequence code(TypeCastExpression it) {
		'''((«type.getTargetLanguageName») «operand.code»)'''
	}

	def dispatch CharSequence getContext(Property it) {
		if (it.const) {
			return getConstContext(it)
		}
		if (scope != null) {
			return scope.interfaceName.asEscapedIdentifier + "."
			}
		return ""
		}
	
	def getConstContext(Property it){
		if (scope != null) {
			return scope.interfaceName + "."
		}else{
			return it.flow.statemachineInterfaceName + "."
		}
	}

	def dispatch CharSequence getContext(Event it) {
		if (scope != null) {
			return scope.interfaceName.asEscapedIdentifier + "."
		}
		return ""
	}

	def dispatch CharSequence getContext(OperationDefinition it) {
		if (scope != null) {
			return scope.interfaceName.asEscapedIdentifier + "."
		}
		return ""
	}

	def dispatch CharSequence getContext(EObject it) {
		return "//ERROR: No context for " + it
	}

}
