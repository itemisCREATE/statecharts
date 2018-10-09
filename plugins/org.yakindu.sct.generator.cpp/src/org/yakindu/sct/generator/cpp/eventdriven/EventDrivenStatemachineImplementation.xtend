/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.cpp.StatemachineImplementation
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.ImportScope
import org.yakindu.sct.model.stext.stext.StatechartScope

/*
 * To restore the event queue for in events, revert commit 235659d
 */
/**
 * @author René Beckmann - Initial contribution and API
 */
class EventDrivenStatemachineImplementation extends StatemachineImplementation {
	@Inject extension EventNaming eventNaming
	
	override additionalFunctions(ExecutionFlow it) {
		if(!hasLocalEvents) return ''''''
		'''
		«nextEventFunction»
		
		«generateInternalDispatchEventFunction»
		
		«generateInterfaceDispatchFunctions»
		'''
	}
	
	override protected usingNamespaces(ExecutionFlow it) {
		if(!hasLocalEvents) return ''''''
		'''using namespace «eventNamespaceName»;'''
	}
	
	override protected initialisationList(ExecutionFlow it) {
		'''
			«IF timed»«timerInstance»(null),«ENDIF»
			stateConfVectorPosition(0)«FOR s : getInterfaces»,
			«s.instance»(this)«IF s.hasOperations && !entry.useStaticOPC»,
			«s.OCB_Instance»(null)«ENDIF»«ENDFOR»
		'''
	}
	
	
	override raiseTimeEventFunction(ExecutionFlow it) '''
		void «module»::«raiseTimeEventFctID»(sc_eventid evid)
		{
			if ((evid >= (sc_eventid)«timeEventsInstance») && (evid < (sc_eventid)(&«timeEventsInstance»[«timeEventsCountConst»])))
			{
				*(sc_boolean*)evid = true;
				runCycle();
			}
		}
	'''
	
	override runCycleFunction(ExecutionFlow it) {
		if(!hasLocalEvents) {
			return super.runCycleFunction(it)
		}
		'''
			void «module»::runCycle()
			{
				clearOutEvents();
				
				SctEvent * currentEvent = getNextEvent();
				
				do
				{
					/* Set event flags as usual */
					dispatch_event(currentEvent);
					
					«runCycleFunctionForLoop»
					
					/* Delete event from memory */
					delete currentEvent;
					clearInEvents();
				} while((currentEvent = getNextEvent()));
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
			}
			
			return nextEvent;
		}
		'''
	}	
	
	def generateInterfaceDispatchFunctions(ExecutionFlow it) {
		'''
		«FOR s : statechartScopes»
		«generateInterfaceDispatchFunction(s)»
		«ENDFOR»
		'''
	}

	def dispatch generateInterfaceDispatchFunction(ExecutionFlow it, ImportScope s) {}

	def dispatch generateInterfaceDispatchFunction(ExecutionFlow it, Scope s) {
		'''
			void «module»::«s.interfaceName»::dispatch_event(SctEvent * event)
			{
				switch(event->name)
				{
					«FOR e : s.localEvents»
						case «e.eventEnumMemberName»:
						{
							«IF e.hasValue»
								«e.eventClassName» * e = static_cast<«e.eventClassName»*>(event);
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
				if(event == 0) {
					return;
				}
				switch(event->name)
				{
					«FOR s : scopes.filter(StatechartScope)»
						«IF !(s instanceof ImportScope)»
							«val localEvents = s.declarations.filter(EventDefinition).filter[direction == Direction.LOCAL]»
							«IF localEvents.size > 0»
								«FOR e : localEvents»
									case «e.eventEnumMemberName»:
								«ENDFOR»
								{
									«s.instance».dispatch_event(event);
									break;
								}
							«ENDIF»
						«ENDIF»
					«ENDFOR»
					default:
						break;
				}
			}
		'''
	}
}
