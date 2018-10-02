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
package org.yakindu.sct.generator.c.submodules.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.EventNaming
import org.yakindu.sct.generator.c.extensions.Naming
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope
import org.yakindu.sct.generator.c.ISourceFragment

/**
 * @author René Beckmann
 */
class EventDrivenStatemachineSourceFragment implements ISourceFragment {
	@Inject extension SExecExtensions
	@Inject extension Naming
	@Inject protected extension ICodegenTypeSystemAccess
	@Inject extension EventNaming
	
	override implementations(ExecutionFlow it, GeneratorEntry entry, extension IGenArtifactConfigurations artifactConfigs) '''
		«IF hasLocalEvents»
		«eventFunctions»
		
		«eventQueueFunctions»
		
		«addToEventQueueFunction»
		
		«addToEventQueueValueFunction»
		
		«dispatchEventFunction»
		«ENDIF»
	'''
	
	def dispatchEventFunction(ExecutionFlow it) '''
		static void «functionPrefix»dispatch_event(«scHandleDecl», const «internalEventStructTypeName» * event) {
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
		«internalEventStructTypeName» event;
		«eventInitFunction»(&event, name);
		«eventQueuePushFunction»(&(handle->internal_event_queue), event);
	}
	'''
	
	def addToEventQueueValueFunction(ExecutionFlow it) '''
	«IF hasLocalEventsWithValue»
	static void «functionPrefix»add_value_event_to_queue(«scHandleDecl», «eventEnumName» name, void * value) 
	{
		«internalEventStructTypeName» event;
		«valueEventInitFunction»(&event, name, value);
		«eventQueuePushFunction»(&(handle->internal_event_queue), event);
	}
	«ENDIF»
	'''
	
	def eventFunctions(ExecutionFlow it) {
		'''
			static void «eventInitFunction»(«internalEventStructTypeName» * ev, «eventEnumName» name)
			{
				ev->name = name;
				«IF hasLocalEventsWithValue»
					ev->has_value = false;
				«ENDIF»
			}
			«IF hasLocalEventsWithValue»
				
				static void «valueEventInitFunction»(«internalEventStructTypeName» * ev, «eventEnumName» name, void * value)
				{
					ev->name = name;
					ev->has_value = true;
					
					switch(name)
					{
						«FOR e : localEvents.filter[hasValue]»
							case «e.eventEnumMemberName»:
								ev->value.«e.eventEnumMemberName»_value = *((«e.typeSpecifier.targetLanguageName»*)value);
								break;
						«ENDFOR»
						default:
							break;
					}
				}
			«ENDIF»
		'''
	}
	
	def eventQueueFunctions(ExecutionFlow it) {
		'''
			static void «eventQueueInitFunction»(«eventQueueTypeName» * eq)
			{
				eq->push_index = 0;
				eq->pop_index = 0;
				eq->size = 0;
			}
			
			static sc_integer «eventQueueSizeFunction»(«eventQueueTypeName» * eq)
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
					
					if(eq->pop_index < «bufferSize» - 1) {
						eq->pop_index++;
					} 
					else {
						eq->pop_index = 0;
					}
					eq->size--;
				}
				return event;
			}
			
			static sc_boolean «eventQueuePushFunction»(«eventQueueTypeName» * eq, «internalEventStructTypeName» ev)
			{
				if(«eventQueueSizeFunction»(eq) == «bufferSize») {
					return false;
				}
				else {
					eq->events[eq->push_index] = ev;
					
					if(eq->push_index < «bufferSize» - 1) {
						eq->push_index++;
					}
					else {
						eq->push_index = 0;
					}
					eq->size++;
					
					return true;
				}
			}
		'''
	}
	
	override declarations(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		''''''
	}
	
	override fileComment(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		''''''
	}
	
	override includes(ExecutionFlow flow, GeneratorEntry entry, IGenArtifactConfigurations artifactConfigs) {
		''''''
	}
	
}
