package org.yakindu.sct.generator.c

import com.google.inject.Inject
import org.yakindu.base.types.Event
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper

class GeneratorPredicate extends org.yakindu.sct.generator.core.extensions.GeneratorPredicate {
	@Inject protected GenmodelEntries entries
	@Inject protected extension SExecExtensions
	@Inject protected extension ICoreLibraryHelper
		
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
		getOutEventObservablesUsed(entry)
	}
	
	def useOutEventGetters() {
		getOutEventGettersUsed(entry)
	}
	
	def needsClearOutEventsFunction() {
		useOutEventGetters
	}
	
	def needsObservable(Event it) {
		useOutEventObservables && direction === Direction.OUT
	}
}