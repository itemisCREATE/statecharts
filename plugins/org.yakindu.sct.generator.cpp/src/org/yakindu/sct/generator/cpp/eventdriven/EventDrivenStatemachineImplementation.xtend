package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import java.util.List
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.cpp.StatemachineImplementation
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

class EventDrivenStatemachineImplementation extends StatemachineImplementation {
	@Inject extension EventNaming eventNaming
	
	override additionalFunctions(ExecutionFlow it) {
		'''
		«nextEventFunction»
		
		«generateInternalDispatchEventFunction»
		
		«generateInterfaceDispatchFunctions»
		'''
	}
	
	override protected usingNamespaces(ExecutionFlow it) {
		'''using namespace «eventNamespaceName»;'''
	}
	
	
	override runCycleFunction(ExecutionFlow it) { 
	'''
		void «module»::runCycle()
		{
			clearOutEvents();
			
			while(SctEvent * currentEvent = getNextEvent())
			{
				/* Set event flags as usual */
				dispatch_event(currentEvent);
				
				«runCycleFunctionForLoop»
				
				/* Delete event from memory */
				delete currentEvent;
				clearInEvents();
			}
		}
	'''
	}
	
	def getNextEventFunction(ExecutionFlow it) {
		'''
		SctEvent* «module»::getNextEvent()
		{
			SctEvent* nextEvent = 0;
			
			if(!internalEventQueue.empty()) {
				nextEvent = internalEventQueue.front();
				internalEventQueue.pop_front();
			} else if(!inEventQueue.empty()) {
				nextEvent = inEventQueue.front();
				inEventQueue.pop_front();
			}
			
			return nextEvent;
		}
		'''
	}
	
	override constructorDefinition(ExecutionFlow it) {
	val List<String> toInit = newArrayList
	toInit.addAll(getInterfaces.map[instance].map[i|'''«i»(this)'''])
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
				«FOR s : scopes.filter(StatechartScope)»
					«FOR e : s.declarations.filter(EventDefinition).filter[direction == Direction::IN || direction == Direction::LOCAL]»
						case «e.eventEnumMemberName»:
					«ENDFOR»
					{
							«s.instance».dispatch_event(event);
							break;
					}
				«ENDFOR»
				«IF timed»
				case «timeEventEnumName»:
					«raiseTimeEventFctID»_internal(event);
					break;
				«ENDIF»
				default:
					break;
			}
		}
		'''
	}
	
	override raiseTimeEventFunction(ExecutionFlow it) { '''
		void «module»::«raiseTimeEventFctID»(sc_eventid evid)
		{
			inEventQueue.push_back(new «eventNamespaceName»::TimedSctEvent(evid));
		}
		'''
	}
	
	def internalRaiseTimeEventFunction(ExecutionFlow it) { '''
		void «module»::«raiseTimeEventFctID»_internal(TimedSctEvent * event) {
			sc_eventid evid = event->evid;
			if ((evid >= (sc_eventid)«timeEventsInstance») && (evid < (sc_eventid)(&«timeEventsInstance»[«timeEventsCountConst»])))
			{
				*(sc_boolean*)evid = true;
			}
		}
		'''
	}		
}