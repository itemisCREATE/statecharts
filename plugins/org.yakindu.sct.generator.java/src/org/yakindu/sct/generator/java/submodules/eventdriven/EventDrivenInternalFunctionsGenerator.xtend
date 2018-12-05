package org.yakindu.sct.generator.java.submodules.eventdriven

import org.yakindu.sct.generator.java.submodules.InternalFunctionsGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow

class EventDrivenInternalFunctionsGenerator extends InternalFunctionsGenerator {
	override internalEventFields(ExecutionFlow it) '''
		«IF hasLocalEvents»
			private Queue<Runnable> internalEventQueue = new LinkedList<Runnable>();
		«ENDIF»
		«super.internalEventFields(it)»
	'''
}