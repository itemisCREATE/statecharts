package org.yakindu.sct.generator.c.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.ExpressionCode
import org.yakindu.sct.model.stext.stext.EventRaisingExpression

class EventDrivenExpressionCode extends ExpressionCode {
	@Inject extension EventNaming
	
	protected static int valueVarIndex = 0
	
	override dispatch CharSequence code(EventRaisingExpression it) {
		val valueVarName = '''value_«valueVarIndex++»'''
		'''
		«IF event.definition.event.direction != Direction::LOCAL»
			«IF value !== null»
				«event.definition.event.valueAccess» = «value.code»;
			«ENDIF»
			«event.definition.event.access» = bool_true«ELSE»
			«IF value !== null»
			«event.definition.event.typeSpecifier.targetLanguageName» «valueVarName» = «value.code»;
			«functionPrefix(flow)»add_value_event_to_queue(«scHandle», «event.definition.event.eventEnumMemberName», «valueVarName»)
			«ELSE»
			«functionPrefix(flow)»add_event_to_queue(«scHandle», «event.definition.event.eventEnumMemberName»)«ENDIF»«ENDIF»'''
	}
}