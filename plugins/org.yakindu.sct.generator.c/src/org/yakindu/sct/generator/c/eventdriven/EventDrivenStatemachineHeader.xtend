package org.yakindu.sct.generator.c.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.StatemachineHeader
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

class EventDrivenStatemachineHeader extends StatemachineHeader {
	@Inject extension EventNaming
	
	override statemachineTypeStructContent(ExecutionFlow it) {
		'''
		«super.statemachineTypeStructContent(it)»
		«eventQueueTypeName» internal_event_queue;
		«eventQueueTypeName» in_event_queue;
		'''
	}
	
	override additionalFunctions(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations configurations) {
		'''
		«eventToInQueueFunction»

		«eventToInternalQueueFunction»
		'''
	}
	
	def eventToInternalQueueFunction() {
		'''
		void add_event_to_queue()
		{
			
		}
		'''
	}
	
	def eventToInQueueFunction() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override includes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«super.includes(it, artifactConfigs)»
		#include "«eventsModule.h»"
		'''
	}
	
}