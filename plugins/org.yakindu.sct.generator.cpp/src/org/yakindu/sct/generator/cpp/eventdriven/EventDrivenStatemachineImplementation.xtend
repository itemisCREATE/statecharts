package org.yakindu.sct.generator.cpp.eventdriven

import org.yakindu.sct.generator.cpp.StatemachineImplementation
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.sgen.GeneratorEntry

class EventDrivenStatemachineImplementation extends StatemachineImplementation {
	
	override additionalFunctions(ExecutionFlow it, GeneratorEntry entry) {
		'''
		«internalRaiseEventFunction»
		'''
	}
	
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
	
	override constructorDefinition(ExecutionFlow it) '''
		«module»::«module»() :
			«FOR s : getInterfaces SEPARATOR ","»
			«s.instance»(this)
			«ENDFOR»
		{
			«constructorBody(it)»
		}
	'''
	
	override initFunction(ExecutionFlow it) {
		val init = super.initFunction(it).toString
		
		return init.replace("clearInEvents();\n", "")
	}
	
	override constructorBody(ExecutionFlow it)
		'''
		«super.constructorBody(it)»
		
		'''
	
	override clearInEventsFunction(ExecutionFlow it) {
		''''''
	}
	
	def internalRaiseEventFunction(ExecutionFlow it) {
		'''
		void «module»::internal_raiseEvent(SctEvent * event)
		{
			switch(event->name)
			{
				«FOR s : scopes»
					«FOR e : s.declarations.filter(EventDefinition)»
						case «e.eventEnumMemberName»:
					«ENDFOR»
							«s.instance».internal_raiseEvent(event);
							break;
				«ENDFOR»
				default:
					break;
			}
		}
		'''
	}	
}