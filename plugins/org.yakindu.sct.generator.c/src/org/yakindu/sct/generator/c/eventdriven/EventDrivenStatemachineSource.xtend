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
package org.yakindu.sct.generator.c.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.StatemachineSource
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

/**
 * @author René Beckmann
 */
class EventDrivenStatemachineSource extends StatemachineSource {
	@Inject extension EventNaming
	@Inject extension StatechartEventsSource events
	
	override content(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) { 
		'''
		«super.content(it, entry, artifactConfigs)»
		
		/*
		 * Helper functions for event driven execution model
		 */
		
		«events.content(it)»
		'''
	}
	
	override protected initFunctionBody(ExecutionFlow it) {
		'''
		«super.initFunctionBody(it)»
		«eventQueueInitFunction»(&(handle->internal_event_queue));
		'''
	}
	
	override functions(ExecutionFlow it) '''
		«super.functions(it)»
		«addToEventQueueFunction»
		
		«addToEventQueueValueFunction»
		
		«dispatchEventFunction»
	'''
	
	override enterFunction(ExecutionFlow it) '''
		void «functionPrefix»enter(«scHandleDecl»)
		{
			«enterSequences.defaultSequence.code»
		}
	'''
	
	override interfaceIncomingEventRaiser(ExecutionFlow it, EventDefinition event) '''
		void «event.asRaiser»(«scHandleDecl»«event.valueParams»)
		{
			«IF event.hasValue»
			«event.valueAccess» = value;
			«ENDIF»
			«event.access» = bool_true;
			
			«functionPrefix»runCycle(«scHandle»);
		}
	'''
	
	def dispatchEventFunction(ExecutionFlow it) '''
		static void «functionPrefix»dispatch_event(«scHandleDecl», const «eventStructTypeName» * event) {
			switch(event->name) {
				«FOR s : scopes.filter(StatechartScope)»
					«FOR e : s.declarations.filter(EventDefinition).filter[direction == Direction::LOCAL]»
					case «e.eventEnumMemberName»:
					{
						«e.access» = bool_true;
						«IF e.hasValue»
						«e.valueAccess» = event->value.«e.eventEnumMemberName»_value;
						«ENDIF»
						break;
					}
					«ENDFOR»
				«ENDFOR»
				default:
					break;
			}
		}
	'''
	
	def addToEventQueueFunction(ExecutionFlow it) '''
	static void «functionPrefix»add_event_to_queue(«scHandleDecl», «eventEnumName» name)
	{
		«eventStructTypeName» event;
		«eventInitFunction»(&event, name);
		«eventQueuePushFunction»(&(handle->internal_event_queue), event);
	}
	'''
	
	def addToEventQueueValueFunction(ExecutionFlow it) '''
	static void «functionPrefix»add_value_event_to_queue(«scHandleDecl», «eventEnumName» name, void * value) 
	{
		«eventStructTypeName» event;
		«valueEventInitFunction»(&event, name, value);
		«eventQueuePushFunction»(&(handle->internal_event_queue), event);
	}
	'''
	
	override runCycleFunction(ExecutionFlow it)  '''
		void «functionPrefix»runCycle(«scHandleDecl»)
		{
			«clearOutEventsFctID»(«scHandle»);
			
			«eventStructTypeName» currentEvent = «eventQueuePopFunction»(&(«scHandle»->internal_event_queue));
			
			do {
				«functionPrefix»dispatch_event(«scHandle», &currentEvent);
				«runCycleForLoop»
				«clearInEventsFctID»(«scHandle»);
			} while((currentEvent = «eventQueuePopFunction»(&(«scHandle»->internal_event_queue))).name != invalid_event);
			
		}
	'''
	
	override raiseTimeEventFunction(ExecutionFlow it) '''
		«IF timed»
			void «raiseTimeEventFctID»(«scHandleDecl», sc_eventid evid)
			{
				if ( ((sc_intptr_t)evid) >= ((sc_intptr_t)&(«scHandle»->timeEvents))
					&&  ((sc_intptr_t)evid) < ((sc_intptr_t)&(«scHandle»->timeEvents)) + sizeof(«timeEventScope.type»))
					{
					*(sc_boolean*)evid = bool_true;
					
					«functionPrefix»runCycle(«scHandle»);
				}		
			}
		«ENDIF»
		'''

	override functionPrototypes(ExecutionFlow it) {
		'''
		«super.functionPrototypes(it)»
		static void «functionPrefix»add_event_to_queue(«scHandleDecl», «eventEnumName» name);
		static void «functionPrefix»dispatch_event(«scHandleDecl», const «eventStructTypeName» * event);
		static void «functionPrefix»add_value_event_to_queue(«scHandleDecl», «eventEnumName» name, void * value);
		'''
	}
}
