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
import org.yakindu.sct.generator.c.submodules.InternalFunctionsGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow

/**
 * @author rbeckmann
 *
 */
@Singleton // Guice
class EventDrivenInternalFunctionsGenerator extends InternalFunctionsGenerator {
	@Inject extension EventNaming
	
	override functionPrototypes(ExecutionFlow it) {
		'''
		«super.functionPrototypes(it)»
		«IF hasLocalEvents»
		static void «eventQueueInitFunction»(«eventQueueTypeName» * eq);
		static sc_integer «eventQueueSizeFunction»(«eventQueueTypeName» * eq);
		static «internalEventStructTypeName» «eventQueuePopFunction»(«eventQueueTypeName» * eq);
		static sc_boolean «eventQueuePushFunction»(«eventQueueTypeName» * eq, «internalEventStructTypeName» ev);

		static void «functionPrefix»dispatch_event(«scHandleDecl», const «internalEventStructTypeName» * event);

		static void «eventInitFunction»(«internalEventStructTypeName» * ev, «eventEnumName» name);
		static void «functionPrefix»add_event_to_queue(«scHandleDecl», «eventEnumName» name);
		«IF hasLocalEventsWithValue»

		static void «valueEventInitFunction»(«internalEventStructTypeName» * ev, «eventEnumName» name, void * value);
		static void «functionPrefix»add_value_event_to_queue(«scHandleDecl», «eventEnumName» name, void * value);
		«ENDIF»
		«ENDIF»
		'''
	}
}