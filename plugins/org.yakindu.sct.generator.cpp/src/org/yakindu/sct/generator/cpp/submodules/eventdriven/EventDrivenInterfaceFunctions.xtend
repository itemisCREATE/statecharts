/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.submodules.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.GeneratorPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.submodules.InterfaceFunctions
import org.yakindu.sct.model.sexec.naming.INamingService
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

class EventDrivenInterfaceFunctions extends InterfaceFunctions {
	@Inject protected extension INamingService
	@Inject protected extension GeneratorPredicate
	@Inject protected extension EventNaming
	
	override CharSequence protectedInnerClassMembers(StatechartScope it) {
		'''
		«super.protectedInnerClassMembers(it)»
		«IF needsDispatchEventFunction(flow)»
		void «it.flow.dispatchEventFctID»(«it.flow.eventNamespaceName»::«SCT_EVENT» * event);
		«ENDIF»
		'''
	}
	
	override dispatch privateFunctionPrototypes(EventDefinition it) {
		'''
		«IF it.isQueued»
			/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */
			void internal_«asRaiser»(«valueParams»);
		«ENDIF»
		'''
	}
}