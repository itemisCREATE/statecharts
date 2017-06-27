package org.yakindu.sct.generator.cpp.eventdriven

import org.yakindu.sct.generator.cpp.ExpressionCode
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression

class EventDrivenExpressionCode extends ExpressionCode {
	override dispatch CharSequence code(EventRaisingExpression it) {
		val cls = event.definition.event.eventClassName
		val enm = event.definition.event.eventEnumMemberName
		'''
		«IF value !== null»internalEventQueue.push_back(new «cls»(«enm», «value.code»))«ELSE»
			internalEventQueue.push_back(new «event.definition.event.eventClassName»(«enm»))«ENDIF»'''
	}
	
	override dispatch CharSequence code(EventValueReferenceExpression it) 
	'''«value.definition.event.valueAccess»'''
}