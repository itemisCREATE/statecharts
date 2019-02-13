package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import org.yakindu.base.expressions.expressions.EventRaisingExpression
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.cpp.EventRaisingCode

class EventDrivenEventRaisingCode extends EventRaisingCode {
	@Inject protected extension EventNaming
	
	override raiseEvent(EventRaisingExpression it, CharSequence valueCode) {
		switch (event.definition.event.direction) {
			case Direction::IN: {
				return raiseInEvent(valueCode)
			}
			case Direction::OUT: {
				return raiseOutEvent(valueCode)
			}
			case Direction::LOCAL: {
				return raiseInternalEvent(valueCode)
			}
		}
	}
	
	def protected CharSequence raiseInEvent(EventRaisingExpression it, CharSequence valueCode) {
		return super.raiseEvent(it, valueCode)
	}
	
	def protected CharSequence raiseOutEvent(EventRaisingExpression it, CharSequence valueCode) {
		return super.raiseEvent(it, valueCode)
	}
	
	def protected CharSequence raiseInternalEvent(EventRaisingExpression it, CharSequence valueCode) {
		'''«internalQueue».push_back(«eventObjectPointer(valueCode)»)'''
	}
	
	def protected eventObjectPointer(EventRaisingExpression it, CharSequence valueCode) {
		val cls = event.definition.event.eventClassName
		val enm = event.definition.event.eventEnumMemberName
		val args = '''«enm»«IF value !== null», «valueCode»«ENDIF»'''
		'''new «cls»(«args»)'''
	}
	
}