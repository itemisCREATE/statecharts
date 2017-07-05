package org.yakindu.sct.generator.c.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.StatemachineSource
import org.yakindu.sct.model.sexec.ExecutionFlow

class EventDrivenStatemachineSource extends StatemachineSource {
	@Inject extension EventNaming
	override protected initFunctionBody(ExecutionFlow it) {
		'''
		«super.initFunctionBody(it)»
		«eventQueueInitFunction»(&(handle.eventqueue));
		'''
	}
}