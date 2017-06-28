package org.yakindu.sct.generator.cpp.eventdriven

import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.cpp.ExpressionCode
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression

class EventDrivenExpressionCode extends ExpressionCode {
	override dispatch CharSequence code(EventRaisingExpression it) {
		switch (event.definition.event.direction) {
			case Direction::IN: {
				return raiseInEvent
			}
			case Direction::OUT: {
				return raiseOutEvent
			}
			case Direction::LOCAL: {
				return raiseInternalEvent
			}
		}
		val cls = event.definition.event.eventClassName
		val enm = event.definition.event.eventEnumMemberName
		val args = '''«enm»«IF value !== null», «value.code»«ENDIF»'''
		val newEvent = '''new «cls»(«args»)'''
		'''raise_event(«newEvent»);'''
	}
	
	def CharSequence raiseInEvent(EventRaisingExpression it) {
		'''internalEventQueue.push_back(«eventObjectPointer»);'''
	}
	def CharSequence raiseOutEvent(EventRaisingExpression it) {
		return super._code(it)
	}
	
	def CharSequence raiseInternalEvent(EventRaisingExpression it) {
		'''internalEventQueue.push_front(«eventObjectPointer»);'''
	}
	
	def eventObjectPointer(EventRaisingExpression it) {
		val cls = event.definition.event.eventClassName
		val enm = event.definition.event.eventEnumMemberName
		val args = '''«enm»«IF value !== null», «value.code»«ENDIF»'''
		'''new «cls»(«args»)'''
	}
	
	override dispatch CharSequence code(EventValueReferenceExpression it) 
	'''«value.definition.event.valueAccess»'''
}