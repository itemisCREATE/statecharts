package org.yakindu.sct.generator.cpp.eventdriven

import java.util.List
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.cpp.StatemachineImplementation
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition

class EventDrivenStatemachineImplementation extends StatemachineImplementation {
	
	override additionalFunctions(ExecutionFlow it, GeneratorEntry entry) {
		'''
		«generateInternalDispatchEventFunction»
		
		«generateInterfaceDispatchFunctions»
		'''
	}
	
	override enterFunction(ExecutionFlow it) '''
		void «module»::enter()
		{
			«enterSequences.defaultSequence.code»
			runCycle();
		}
	'''
	
	override runCycleFunction(ExecutionFlow it) { 
	'''
		void «module»::runCycle()
		{
			clearOutEvents();
			
			while(!internalEventQueue.empty())
			{
				/* Take event from front of queue and remove it */
				currentEvent = internalEventQueue.front();
				internalEventQueue.pop_front();
				/* Set event flags as usual */
				dispatch_event(currentEvent);
				
				«runCycleFunctionForLoop»
				
				/* Delete event from memory */
				delete currentEvent;
			}
		}
	'''
	}
	
	override constructorDefinition(ExecutionFlow it) {
	val List<String> toInit = newArrayList
	toInit.addAll(getInterfaces.map[instance].map[i|'''«i»(this)'''])
	toInit.add("currentEvent(0)")
	'''
		«module»::«module»() :
			«FOR init : toInit SEPARATOR ","»
				«init»
			«ENDFOR»
		{
			«constructorBody(it)»
		}
	'''
	}
	
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
	
	
	def generateInterfaceDispatchFunctions(ExecutionFlow it) {
		'''
		«FOR s : statechartScopes»
		«generateInterfaceDispatchFunction(s)»
		«ENDFOR»
		'''
	}
	
	def generateInterfaceDispatchFunction(ExecutionFlow it, Scope s) {
		'''
		void «module»::«s.interfaceName»::dispatch_event(SctEvent * event)
		{
			switch(event->name)
			{
				«FOR e: s.declarations.filter(EventDefinition).filter[direction == Direction::IN || direction == Direction::LOCAL]»
					case «e.eventEnumMemberName»:
					{
						«IF e.hasValue»
						«e.eventClassName» * e = dynamic_cast<«e.eventClassName»*>(event);
						if(e != 0) {
							internal_«e.asRaiser»(e->value);
						}
						«ELSE»
						internal_«e.asRaiser»();
						«ENDIF»
						break;
					}
				«ENDFOR»
				default:
					break;
			}
		}
		'''
	}
	
	def generateInternalDispatchEventFunction(ExecutionFlow it) {
		'''
		void «module»::dispatch_event(SctEvent * event)
		{
			switch(event->name)
			{
				«FOR s : scopes»
					«FOR e : s.declarations.filter(EventDefinition).filter[direction == Direction::IN || direction == Direction::LOCAL]»
						case «e.eventEnumMemberName»:
					«ENDFOR»
					{
							«s.instance».dispatch_event(event);
							break;
					}
				«ENDFOR»
				default:
					break;
			}
		}
		'''
	}	
}