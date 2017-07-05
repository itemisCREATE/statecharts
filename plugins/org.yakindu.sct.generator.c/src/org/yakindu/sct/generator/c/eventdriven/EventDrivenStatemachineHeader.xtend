package org.yakindu.sct.generator.c.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.StatemachineHeader
import org.yakindu.sct.model.sexec.ExecutionFlow

class EventDrivenStatemachineHeader extends StatemachineHeader {
	@Inject extension EventNaming
	
	override statemachineTypeStructContent(ExecutionFlow it) {
		'''
		«super.statemachineTypeStructContent(it)»
		«eventQueueTypeName» eventqueue;
		'''
	}
	
	override includes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«super.includes(it, artifactConfigs)»
		#include "«eventsModule.h»"
		'''
	}
	
}