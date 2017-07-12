package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.cpp.ExpressionCode
import org.yakindu.sct.model.stext.stext.EventRaisingExpression
import org.yakindu.sct.model.stext.stext.EventValueReferenceExpression

class EventDrivenExpressionCode extends ExpressionCode {
	@Inject extension EventNaming eventNaming
	
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
	}
	
	def CharSequence raiseInEvent(EventRaisingExpression it) {
		return super._code(it)
	}
	
	def CharSequence raiseOutEvent(EventRaisingExpression it) {
		return super._code(it)
	}
	
	def CharSequence raiseInternalEvent(EventRaisingExpression it) {
		'''internalEventQueue.push_back(«eventObjectPointer»)'''
	}
	
	def eventObjectPointer(EventRaisingExpression it) {
		val cls = event.definition.event.eventClassName
		val enm = event.definition.event.eventEnumMemberName
		val args = '''«enm»«IF value !== null», «value.code»«ENDIF»'''
		'''new «cls»(«args»)'''
	}
}