package org.yakindu.sct.generator.cpp.submodules.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.core.submodules.lifecycle.RunCycle
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.submodules.lifecycle.LifecycleFunctions
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

class EventDrivenRunCycle extends LifecycleFunctions implements RunCycle {
	@Inject extension EventNaming eventNaming
	
	override runCycle(ExecutionFlow it) {
		val cE = "currentEvent"
		if(!hasLocalEvents) {
			return super.runCycle(it)
		}
		'''
			void «module»::«runCycleFctID»()
			{
				«clearOutEventsFctID»();
				
				«SCT_EVENT» * «cE» = «nextEventFctID»();
				
				do
				{
					/* Set event flags as usual */
					«dispatchEventFctID»(«cE»);
					
					«runCycleFunctionForLoop»
					
					/* Delete event from memory */
					delete «cE»;
					«clearInEventsFctID»();
				} while((«cE» = «nextEventFctID»()));
			}
		'''
	}
}