package org.yakindu.sct.generator.c.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Event
import org.yakindu.sct.generator.c.Naming
import org.yakindu.sct.generator.c.Navigation
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.naming.INamingService

class EventNaming {
	@Inject extension Naming
	@Inject extension Navigation
	@Inject extension INamingService
	
	def eventEnumMemberName(Event it) {
		'''«scope.functionPrefix»_«name.asIdentifier»'''
	}
	
	def eventEnumName(ExecutionFlow it) {
		'''«module»EventName'''
	}
}