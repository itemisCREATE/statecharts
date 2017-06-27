package org.yakindu.sct.generator.cpp.eventdriven

import org.yakindu.sct.generator.cpp.StatemachineImplementation
import org.yakindu.sct.model.sexec.ExecutionFlow

class EventDrivenStatemachineImplementation extends StatemachineImplementation {
	override runCycleFunction(ExecutionFlow it) { 
	'''
		void «module»::runCycle()
		{
			while(!internalEventQueue.empty())
			{
				currentEvent = internalEventQueue.front();
				internalEventQueue.pop_front();
				
				for (stateConfVectorPosition = 0;
					stateConfVectorPosition < «orthogonalStatesConst»;
					stateConfVectorPosition++)
					{
						
					switch (stateConfVector[stateConfVectorPosition])
					{
					«FOR state : states»
						«IF state.reactSequence!=null»
						case «state.shortName.asEscapedIdentifier» :
						{
							«state.reactSequence.shortName»();
							break;
						}
						«ENDIF»
					«ENDFOR»
					default:
						break;
					}
				}
			}
		}
	'''
	}
	
	override clearInEventsFunction(ExecutionFlow it) {
		''''''
	}	
}