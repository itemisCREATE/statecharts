/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.submodules.eventdriven

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.generator.c.extensions.EventNaming
import org.yakindu.sct.generator.c.submodules.APIGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.c.CGeneratorConstants.INTPTR_TYPE
import static org.yakindu.sct.generator.c.CGeneratorConstants.BOOL_TYPE
import org.yakindu.sct.generator.c.types.CLiterals

/**
 * @author rbeckmann
 * @author axel terfloth
 *
 */
@Singleton // Guice
class EventDrivenAPIGenerator extends APIGenerator {
	@Inject protected extension EventNaming
	@Inject protected extension CLiterals
	
	override protected initFunctionBody(ExecutionFlow it) {
		'''
		«super.initFunctionBody(it)»
		«IF hasLocalEvents»
		«eventQueueInitFunction»(&(«scHandle»->«internalQueue»));
		«ENDIF»
		'''
	}
	
	override runCycle(ExecutionFlow it)  {
		if(!hasLocalEvents) {
			return super.runCycle(it)
		} else {
			'''
				«runCycleSignature»
				{
					«clearOutEventsFctID»(«scHandle»);
					
					«internalEventStructTypeName» currentEvent = «eventQueuePopFunction»(&(«scHandle»->internal_event_queue));
					
					do {
						«dispatchEventFctID»(«scHandle», &currentEvent);
						«runCycleForLoop»
						«clearInEventsFctID»(«scHandle»);
					} while((currentEvent = «eventQueuePopFunction»(&(«scHandle»->«internalQueue»))).name != «invalidEventEnumName»);
					
				}
			'''
		}
	}
	
	override raiseTimeEvent(ExecutionFlow it) '''
		«IF timed»
			«raiseTimeEventSignature»
			{
				if ( ((«INTPTR_TYPE»)evid) >= ((«INTPTR_TYPE»)&(«scHandle»->timeEvents))
					&&  ((«INTPTR_TYPE»)evid) < ((«INTPTR_TYPE»)&(«scHandle»->timeEvents)) + (unsigned)sizeof(«timeEventScope.type»))
				{
					*(«BOOL_TYPE»*)evid = «TRUE_LITERAL»;
					
					«runCycleFctID»(«scHandle»);
				}
			}
		«ENDIF»
		'''
}