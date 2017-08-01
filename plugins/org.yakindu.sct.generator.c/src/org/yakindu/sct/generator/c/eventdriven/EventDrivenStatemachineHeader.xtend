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
		'''
	}
	
	override includes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		«super.includes(it, artifactConfigs)»
		#include "«eventsModule.h»"
		'''
	}
	
	override protected functions(ExecutionFlow it) {
		super.functions(it).toString.replace('''const «scHandleDecl», sc_eventid evid''','''«scHandleDecl», sc_eventid evid''')
	}
	
}