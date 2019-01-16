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
package org.yakindu.sct.generator.cpp.providers.eventdriven.classdecl

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.providers.ISourceFragment
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

class QueueMemberProvider implements ISourceFragment {
	@Inject extension EventNaming
	@Inject extension EventDrivenPredicate

	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		'''
			«IF needsInternalEventQueue»
				std::deque<«eventNamespaceName»::«SCT_EVENT»*> «internalQueue»;
			«ENDIF»
			«IF needsNextEventFunction»
				«eventNamespaceName»::«SCT_EVENT»* «nextEventFctID»();
			«ENDIF»
			«IF needsDispatchEventFunction»
				void «dispatchEventFctID»(«eventNamespaceName»::«SCT_EVENT» * event);
			«ENDIF»
			«IF needsInEventQueue»
				std::deque<«eventNamespaceName»::«SCT_EVENT»*> «inEventQueue»;
			«ENDIF»
			«IF needsRunCycleGuard»
				«BOOL_TYPE» «runCycleGuard»;
			«ENDIF»
		'''
	}
}
