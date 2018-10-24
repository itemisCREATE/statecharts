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
import org.yakindu.sct.generator.c.CGeneratorConstants

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
		static «CGeneratorConstants.INT_TYPE» «eventQueueSizeFunction»(«eventQueueTypeName» * eq);
		static «internalEventStructTypeName» «eventQueuePopFunction»(«eventQueueTypeName» * eq);
		static «CGeneratorConstants.BOOL_TYPE» «eventQueuePushFunction»(«eventQueueTypeName» * eq, «internalEventStructTypeName» ev);

		static void «dispatchEventFctID»(«scHandleDecl», const «internalEventStructTypeName» * event);

		static void «eventInitFunction»(«internalEventStructTypeName» * ev, «eventEnumName» name);
		static void «addToQueueFctID»(«scHandleDecl», «eventEnumName» name);
		«IF hasLocalEventsWithValue»

		static void «valueEventInitFunction»(«internalEventStructTypeName» * ev, «eventEnumName» name, void * value);
		static void «addToQueueValueFctID»(«scHandleDecl», «eventEnumName» name, void * value);
		«ENDIF»
		«ENDIF»
		'''
	}
}