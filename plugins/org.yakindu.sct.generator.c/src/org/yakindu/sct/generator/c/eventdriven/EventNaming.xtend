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
		'''«module»_event_name'''.toString.toLowerCase
	}
	
	def eventValueUnionName(ExecutionFlow it) {
		'''«module»_event_value'''.toString.toLowerCase
	}
	
	def eventStructTypeName(ExecutionFlow it) {
		'''«name»_event'''.toString.toLowerCase
	}
	
	def eventQueueTypeName(ExecutionFlow it) {
		'''«name»_eventqueue'''.toString.toLowerCase
	}
	
	def eventInitFunction(ExecutionFlow it) {
		'''«eventStructTypeName»_init'''
	}
	
	def eventQueueInitFunction(ExecutionFlow it) {
		'''«eventQueueTypeName»_init'''
	}
	
	def eventQueueSizeFunction(ExecutionFlow it) {
		'''«eventQueueTypeName»_size'''
	}
	
	def eventQueuePopFunction(ExecutionFlow it) {
		'''«eventQueueTypeName»_pop'''
	}
	
	def eventQueuePushFunction(ExecutionFlow it) {
		'''«eventQueueTypeName»_push'''
	}
	
	def bufferSize(ExecutionFlow it) {
		'''«name»_eventqueue_buffersize'''.toString.toUpperCase
	}
}