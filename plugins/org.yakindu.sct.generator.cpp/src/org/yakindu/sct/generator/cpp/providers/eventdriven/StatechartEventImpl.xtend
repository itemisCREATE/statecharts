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
package org.yakindu.sct.generator.cpp.providers.eventdriven

import com.google.inject.Inject
import java.util.List
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.files.StatemachineImplementation
import org.yakindu.sct.generator.cpp.providers.GeneratorContribution
import org.yakindu.sct.generator.cpp.providers.ISourceFragment
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.ImportScope
import org.yakindu.sct.model.stext.stext.StatechartScope

import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

@GeneratorContribution(StatemachineImplementation.SOURCE_TARGET)
class StatechartEventImpl implements ISourceFragment {
	@Inject protected extension EventDrivenPredicate
	
	@Inject protected extension CppNaming
	@Inject protected extension SExecExtensions
	@Inject extension EventNaming eventNaming
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		'''
		«IF needsNextEventFunction»
		«nextEventFunction»
		
		«ENDIF»
		«IF needsDispatchEventFunction»
		«generateInternalDispatchEventFunction»
		
		«generateInterfaceDispatchFunctions»
		«ENDIF»
		'''
	}
	
	override isNeeded(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		isEventDriven
	}
	
	def getNextEventFunction(ExecutionFlow it) {
		val nE = "nextEvent"
		'''
		«SCT_EVENT»* «module»::«nextEventFctID»()
		{
			«SCT_EVENT»* «nE» = 0;
			
			«IF needsInternalEventQueue»
				if(!«internalQueue».empty()) {
					«nE» = «internalQueue».front();
					«internalQueue».pop_front();
				}
			«ENDIF»
			«IF needsInEventQueue»
				«IF needsInternalEventQueue»else «ENDIF»if(!«inEventQueue».empty()) {
					«nE» = «inEventQueue».front();
					«inEventQueue».pop_front();
				}
			«ENDIF»
			
			return «nE»;
		}
		'''
	}	
	
	def generateInterfaceDispatchFunctions(ExecutionFlow it) {
		'''
		«FOR s : statechartScopes»
		«generateInterfaceDispatchFunction(s)»
		«ENDFOR»
		'''
	}

	def dispatch generateInterfaceDispatchFunction(ExecutionFlow it, ImportScope s) {}

	def dispatch generateInterfaceDispatchFunction(ExecutionFlow it, Scope s) {
		val ev = "event"
		'''
			void «module»::«s.interfaceName»::«dispatchEventFctID»(«SCT_EVENT» * «ev»)
			{
				switch(«ev»->name)
				{
					«FOR e : s.queuedEvents»
						case «e.eventEnumMemberName»:
						{
							«IF e.hasValue»
								«e.eventClassName» * e = static_cast<«e.eventClassName»*>(«ev»);
								if(e != 0) {
									internal_«e.asRaiser»(e->value);
								}
							«ELSE»
								internal_«e.asRaiser»();
							«ENDIF»
							break;
						}
					«ENDFOR»
					default:
						break;
				}
			}
			'''
	}

	def generateInternalDispatchEventFunction(ExecutionFlow it) {
		val ev = "event"
		'''	
			void «module»::«dispatchEventFctID»(«SCT_EVENT» * «ev»)
			{
				if(«ev» == 0) {
					return;
				}
				switch(«ev»->name)
				{
					«FOR s : scopes.filter(StatechartScope)»
						«IF !(s instanceof ImportScope)»
							«val events = s.queuedEvents»
							«IF events.size > 0»
								«FOR e : events»
									case «e.eventEnumMemberName»:
								«ENDFOR»
								{
									«s.instance».«dispatchEventFctID»(«ev»);
									break;
								}
							«ENDIF»
						«ENDIF»
					«ENDFOR»
					default:
						break;
				}
			}
		'''
	}
	
	def List<EventDefinition> queuedEvents(Scope it) {
		if(it === null) return emptyList
		declarations.filter(EventDefinition).filter[isQueued].toList
	}
	
}