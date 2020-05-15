package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

class GeneratorPredicate extends org.yakindu.sct.generator.core.extensions.GeneratorPredicate {
	@Inject protected GenmodelEntries entries
	@Inject protected extension SExecExtensions
		
	override useInEventQueue() {
		entries.getInEventQueueUsed(entry)
	}
	
	def userAllocatesInQueue(ExecutionFlow it) {
		needsInEventQueue && entries.getQueueAllocatedByUser(entry)
	}

	def userAllocatesInternalQueue(ExecutionFlow it) {
		needsInternalEventQueue && entries.getQueueAllocatedByUser(entry)
	}
	
	def needsValueUnion(ExecutionFlow it) {
		hasQueuedEventsWithValue
	}
	
	def useOutEventObservables() {
		entries.getOutEventObservablesUsed(entry)
	}
	
	def useOutEventGetters() {
		entries.getOutEventGettersUsed(entry)
	}
	
	def needsClearOutEventsFunction() {
		useOutEventGetters
	}
}