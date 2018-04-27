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
package org.yakindu.sct.generator.c.extensions

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.ExecutionFlow

/**
 * @author rbeckmann
 *
 */
class EventDrivenInternalFunctionsGenerator extends InternalFunctionsGenerator {
	@Inject extension EventNaming
	
	override functionPrototypes(ExecutionFlow it) {
		'''
		«super.functionPrototypes(it)»
		«IF hasLocalEvents»
		static void «eventQueueInitFunction»(«eventQueueTypeName» * eq);
		static sc_integer «eventQueueSizeFunction»(«eventQueueTypeName» * eq);
		static «eventStructTypeName» «eventQueuePopFunction»(«eventQueueTypeName» * eq);
		static sc_boolean «eventQueuePushFunction»(«eventQueueTypeName» * eq, «eventStructTypeName» ev);

		static void «functionPrefix»dispatch_event(«scHandleDecl», const «eventStructTypeName» * event);

		static void «eventInitFunction»(«eventStructTypeName» * ev, «eventEnumName» name);
		static void «functionPrefix»add_event_to_queue(«scHandleDecl», «eventEnumName» name);
		«IF hasLocalEventsWithValue»

		static void «valueEventInitFunction»(«eventStructTypeName» * ev, «eventEnumName» name, void * value);
		static void «functionPrefix»add_value_event_to_queue(«scHandleDecl», «eventEnumName» name, void * value);
		«ENDIF»
		«ENDIF»
		'''
	}
}