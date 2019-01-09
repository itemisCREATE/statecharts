/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.providers.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.files.StatemachineHeader
import org.yakindu.sct.generator.cpp.providers.GeneratorContribution
import org.yakindu.sct.generator.cpp.providers.StatemachineClassDeclaration
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*
import static org.yakindu.sct.generator.c.CGeneratorConstants.*

@GeneratorContribution(StatemachineHeader.HEADER_TARGET)
class EventDrivenStatemachineClassDeclaration extends StatemachineClassDeclaration {
	@Inject extension EventNaming
	@Inject extension EventDrivenPredicate
	
	
	override generateClass(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		val classDecl = super.generateClass(it, artifactConfigs)
		if(needsInternalEventQueue) 
			classDecl.privateMember('''std::deque<«eventNamespaceName»::«SCT_EVENT»*> «internalQueue»;''')
		if(needsNextEventFunction) 
			classDecl.privateMember('''«eventNamespaceName»::«SCT_EVENT»* «nextEventFctID»();''')
		if(needsDispatchEventFunction) 
			classDecl.privateMember('''void «dispatchEventFctID»(«eventNamespaceName»::«SCT_EVENT» * event);''')
		if(needsInEventQueue) {
			classDecl.privateMember('''std::deque<«eventNamespaceName»::«SCT_EVENT»*> «inEventQueue»;''')
			classDecl.privateMember('''«BOOL_TYPE» «runCycleGuard»;''')
		}
		classDecl
	}
	
	override isNeeded(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		isEventDriven
	}
	
	override replaces(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		StatemachineClassDeclaration
	}
	
}
