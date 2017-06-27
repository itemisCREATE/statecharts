package org.yakindu.sct.generator.cpp.eventdriven

import org.yakindu.sct.generator.cpp.ExpressionCode
import org.yakindu.sct.model.stext.stext.EventRaisingExpression

class EventDrivenExpressionCode extends ExpressionCode {
	override dispatch CharSequence code(EventRaisingExpression it) {
		'''
		«IF value !== null»
			InternalEventQueue.push_back(«event.definition.event.eventClassName»(«value.code»))
		«ELSE»
			InternalEventQueue.push_back(«event.definition.event.eventClassName»)
		«ENDIF»
		'''
	}
}