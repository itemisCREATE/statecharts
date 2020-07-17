/**
 * Copyright (c) 2017-2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.c.submodules.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.CGeneratorConstants
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.ISourceFragment
import org.yakindu.sct.generator.c.extensions.EventNaming
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

/**
 * @author René Beckmann
 * @author axel terfloth
 */
class EventDrivenStatemachineSourceFragment implements ISourceFragment {
	@Inject extension SExecExtensions
	@Inject extension Naming
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject extension EventNaming
	@Inject protected extension CLiterals
	@Inject extension GeneratorPredicate
	
	override implementations(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) '''
		«IF needsQueues»
		«eventQueueFunctions»
		«eventInit»
		«ENDIF»
		«IF hasQueuedEventsWithoutValue»
		
		«addToEventQueueFunction»
		«ENDIF»
		«IF needsDispatchEventFunction»
		
		«dispatchEventFunction»
		«ENDIF»
		«IF needsNextEventFunction»
		
		«nextEventFunction»
		
		«dispatchNextEventFunction»
		«ENDIF»
		«IF hasQueuedEventsWithValue»
		
		«valueEventInit»
		
		«addToEventQueueValueFunction»
		«ENDIF»
	'''
	
	override declarations(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		'''
		«IF needsQueues»
			static void «eventQueueInitFunction»(«eventQueueTypeName» * eq, «internalEventStructTypeName» *buffer, «INT_TYPE» capacity);
			static «CGeneratorConstants.INT_TYPE» «eventQueueSizeFunction»(«eventQueueTypeName» * eq);
			static «internalEventStructTypeName» «eventQueuePopFunction»(«eventQueueTypeName» * eq);
			static void «eventInitFunction»(«internalEventStructTypeName» * ev, «eventEnumName» name);
		«ENDIF»
		«IF needsQueues && hasEvents»
			static «CGeneratorConstants.BOOL_TYPE» «eventQueuePushFunction»(«eventQueueTypeName» * eq, «internalEventStructTypeName» ev);
		«ENDIF»
		«IF hasQueuedEventsWithoutValue»
			static void «addToQueueFctID»(«eventQueueTypeName» * eq, «eventEnumName» name);
		«ENDIF»
		«IF needsDispatchEventFunction»
			static void «dispatchEventFctID»(«scHandleDecl», const «internalEventStructTypeName» * event);
		«ENDIF»
		«IF needsNextEventFunction»
			static «internalEventStructTypeName» «nextEventFctID»(«scHandleDecl»);
			static void «dispatchNextEventFctID»(«scHandleDecl»);
		«ENDIF»
		
		«IF hasQueuedEventsWithValue»
			static void «valueEventInitFunction»(«internalEventStructTypeName» * ev, «eventEnumName» name, void * value);
			static void «addToQueueValueFctID»(«eventQueueTypeName» * eq, «eventEnumName» name, void * value);
		«ENDIF»
		'''
	}
	
	def dispatchEventFunction(ExecutionFlow it) '''
		static void «dispatchEventFctID»(«scHandleDecl», const «internalEventStructTypeName» * event) {
			switch(event->name) {
				«FOR e : queuedEvents»
					case «e.eventEnumMemberName»:
					{
						«e.access» = «TRUE_LITERAL»;
						«IF e.hasValue»
						«e.valueAccess» = event->value.«e.eventValueUnionMemberName»;
						«ENDIF»
						break;
					}
				«ENDFOR»
				default:
					break;
			}
		}
	'''
	
	def addToEventQueueFunction(ExecutionFlow it) '''
		static void «addToQueueFctID»(«eventQueueTypeName» * eq, «eventEnumName» name)
		{
			«internalEventStructTypeName» event;
			«eventInitFunction»(&event, name);
			«eventQueuePushFunction»(eq, event);
		}
	'''
	
	def addToEventQueueValueFunction(ExecutionFlow it) '''
		static void «addToQueueValueFctID»(«eventQueueTypeName» * eq, «eventEnumName» name, void * value)
		{
			«internalEventStructTypeName» event;
			«valueEventInitFunction»(&event, name, value);
			«eventQueuePushFunction»(eq, event);
		}
	'''
	
	def eventInit(ExecutionFlow it) {
		'''
		static void «eventInitFunction»(«internalEventStructTypeName» * ev, «eventEnumName» name)
		{
			ev->name = name;
			«IF hasQueuedEventsWithValue»
				ev->has_value = «FALSE_LITERAL»;
			«ENDIF»
		}
		'''
	}
	
	def valueEventInit(ExecutionFlow it) {
		'''
		static void «valueEventInitFunction»(«internalEventStructTypeName» * ev, «eventEnumName» name, void * value)
		{
			ev->name = name;
			ev->has_value = «TRUE_LITERAL»;
			
			switch(name)
			{
				«FOR e : queuedEventsWithValue»
					case «e.eventEnumMemberName»:
						ev->value.«e.eventEnumMemberName»_value = *((«e.typeSpecifier.targetLanguageName»*)value);
						break;
				«ENDFOR»
				default:
					break;
			}
		}
		'''
	}
	
	def eventQueueFunctions(ExecutionFlow it) {
		'''
			static void «eventQueueInitFunction»(«eventQueueTypeName» * eq, «internalEventStructTypeName» *buffer, «INT_TYPE» capacity)
			{
				eq->events = buffer;
				eq->capacity = capacity;
				eq->push_index = 0;
				eq->pop_index = 0;
				eq->size = 0;
			}
			
			static «INT_TYPE» «eventQueueSizeFunction»(«eventQueueTypeName» * eq)
			{
				return eq->size;
			}
			
			static «internalEventStructTypeName» «eventQueuePopFunction»(«eventQueueTypeName» * eq)
			{
				«internalEventStructTypeName» event;
				if(«eventQueueSizeFunction»(eq) <= 0) {
					«eventInitFunction»(&event, «invalidEventEnumName(it)»);
				}
				else {
					event = eq->events[eq->pop_index];
					
					if(eq->pop_index < eq->capacity - 1) {
						eq->pop_index++;
					} 
					else {
						eq->pop_index = 0;
					}
					eq->size--;
				}
				return event;
			}
			«IF hasEvents»
				static «BOOL_TYPE» «eventQueuePushFunction»(«eventQueueTypeName» * eq, «internalEventStructTypeName» ev)
				{
					if(«eventQueueSizeFunction»(eq) == eq->capacity) {
						return «FALSE_LITERAL»;
					}
					else {
						eq->events[eq->push_index] = ev;
						
						if(eq->push_index < eq->capacity - 1) {
							eq->push_index++;
						}
						else {
							eq->push_index = 0;
						}
						eq->size++;
						
						return «TRUE_LITERAL»;
					}
				}
			«ENDIF»
		'''
	}
	
	def nextEventFunction(ExecutionFlow it) {
		'''
		static «internalEventStructTypeName» «nextEventFctID»(«scHandleDecl»)
		{
			«internalEventStructTypeName» next_event;
			«eventInitFunction»(&next_event, «invalidEventEnumName(it)»);
			«IF needsInternalEventQueue»
			if(«eventQueueSizeFunction»(&(«scHandle»->«internalQueue»)) > 0) {
				next_event = «eventQueuePopFunction»(&(«scHandle»->«internalQueue»));
			}
			«ENDIF»
			«IF needsInEventQueue»
			«IF needsInternalEventQueue»else «ENDIF»if(«eventQueueSizeFunction»(&(«scHandle»->«inEventQueue»)) > 0) {
				next_event = «eventQueuePopFunction»(&(«scHandle»->«inEventQueue»));
			}
			«ENDIF»
			return next_event;
		}
		'''
	}
	
	def dispatchNextEventFunction(ExecutionFlow it) {
		'''
		static void «dispatchNextEventFctID»(«scHandleDecl»)
		{
			«internalEventStructTypeName» nextEvent;
			nextEvent = «nextEventFctID»(«scHandle»);
			«dispatchEventFctID»(«scHandle», &nextEvent);
		}
		'''
	}
	

	override fileComment(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		''''''
	}
	
	override includes(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		''''''
	}
	
}
