package org.yakindu.sct.generator.cpp.submodules.eventdriven

import org.yakindu.sct.generator.cpp.submodules.TimingFunctions
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

class EventDrivenTimingFunctions extends TimingFunctions {
	override raiseTimeEventFunction(ExecutionFlow it) '''
		void «module»::«raiseTimeEventFctID»(«EVENT_TYPE» evid)
		{
			if ((evid >= («EVENT_TYPE»)«timeEventsInstance») && (evid < («EVENT_TYPE»)(&«timeEventsInstance»[«timeEventsCountConst»])))
			{
				*(«BOOL_TYPE»*)evid = true;
				«runCycleFctID»();
			}
		}
	'''
}