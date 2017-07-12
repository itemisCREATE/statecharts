package org.yakindu.sct.generator.c.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.ExpressionCode
import org.yakindu.sct.model.stext.stext.EventRaisingExpression

class EventDrivenExpressionCode extends ExpressionCode {
	@Inject extension EventNaming
	
	override dispatch CharSequence code(EventRaisingExpression it) {
		'''
		«IF event.definition.event.direction == Direction::OUT»
			«IF value !== null»
				«event.definition.event.valueAccess» = «value.code»;
			«ENDIF»
			«event.definition.event.access» = bool_true
		«ELSE»
			«flow.eventStructTypeName» event;
			«IF value !== null»
			«event.definition.event.typeSpecifier.targetLanguageName» value = «value.code»;
			«flow.valueEventInitFunction»(&event, «event.definition.event.eventEnumMemberName»«IF value !== null», &value«ENDIF»);
			«ELSE»
			«flow.eventInitFunction»(&event, «event.definition.event.eventEnumMemberName»);
			«ENDIF»
			«flow.eventQueuePushFunction»(&event);
		«ENDIF»
		'''
	}
}