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
import org.yakindu.sct.generator.c.Navigation
import org.yakindu.sct.generator.core.types.ICodegenTypeSystemAccess
import org.yakindu.sct.model.sexec.ExecutionFlow

/**
 * @author René Beckmann
 */
class StatechartEventsSource {
	@Inject extension Navigation
	@Inject extension EventNaming
	@Inject protected extension ICodegenTypeSystemAccess
	
	def content(ExecutionFlow it) {
		'''
		«eventFunctions»
		
		«eventQueueFunctions»
		'''
	}
	
	def eventFunctions(ExecutionFlow it) {
		'''
		void «eventInitFunction»(«eventStructTypeName» * ev, «eventEnumName» name)
		{
			ev->name = name;
			ev->has_value = false;
		}
		
		void «valueEventInitFunction»(«eventStructTypeName» * ev, «eventEnumName» name, void * value)
		{
			ev->name = name;
			ev->has_value = true;
			
			switch(name)
			{
				«FOR e : getAllEvents.filter[hasValue]»
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
		void «eventQueueInitFunction»(«eventQueueTypeName» * eq)
		{
			eq->push_index = 0;
			eq->pop_index = 0;
			eq->size = 0;
		}
		
		sc_integer «eventQueueSizeFunction»(«eventQueueTypeName» * eq)
		{
			return eq->size;
		}
		
		«eventStructTypeName» «eventQueuePopFunction»(«eventQueueTypeName» * eq)
		{
			«eventStructTypeName» event;
			if(«eventQueueSizeFunction»(eq) <= 0) {
				«eventInitFunction»(&event, invalid_event);
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
		
		sc_boolean «eventQueuePushFunction»(«eventQueueTypeName» * eq, «eventStructTypeName» ev)
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
	
}