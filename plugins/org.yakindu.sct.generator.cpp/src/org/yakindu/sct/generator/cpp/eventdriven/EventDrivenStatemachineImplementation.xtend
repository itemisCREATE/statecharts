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
package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.cpp.files.StatemachineImplementation
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.ImportScope
import org.yakindu.sct.model.stext.stext.StatechartScope

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

/**
 * @author René Beckmann - Initial contribution and API
 */
class EventDrivenStatemachineImplementation extends StatemachineImplementation {
	@Inject extension EventNaming eventNaming
	
	override additionalFunctions(ExecutionFlow it) {
		if(!hasLocalEvents) return ''''''
		'''
		«nextEventFunction»
		
		«generateInternalDispatchEventFunction»
		
		«generateInterfaceDispatchFunctions»
		'''
	}
	
	override protected usingNamespaces(ExecutionFlow it) {
		if(!hasLocalEvents) return ''''''
		'''using namespace «eventNamespaceName»;'''
	}
	
	override protected initialisationList(ExecutionFlow it) {
		'''
			«IF timed»«timerInstance»(«NULL_STRING»),«ENDIF»
			«IF entry.tracingUsed»«tracingInstance»(0),«ENDIF»
			«STATEVECTOR_POS»(0)«FOR s : getInterfaces»,
			«s.instance»(this)«IF s.hasOperations && !entry.useStaticOPC»,
			«s.OCB_Instance»(«NULL_STRING»)«ENDIF»«ENDFOR»
		'''
	}
	
	
	override raiseTimeEventFunction(ExecutionFlow it) '''
		void «module»::«raiseTimeEventFctID»(«EVENT_TYPE» evid)
		{
			if ((evid >= («EVENT_TYPE»)«timeEventsInstance») && (evid < («EVENT_TYPE»)(&«timeEventsInstance»[«timeEventsCountConst»])))
			{
				*(«BOOL_TYPE»*)evid = true;
				«runCycleFctID»();
			}
		}
	'''
	
	override runCycleFunction(ExecutionFlow it) {
		val cE = "currentEvent"
		if(!hasLocalEvents) {
			return super.runCycleFunction(it)
		}
		'''
			void «module»::«runCycleFctID»()
			{
				«clearOutEventsFctID»();
				
				«SCT_EVENT» * «cE» = «nextEventFctID»();
				
				do
				{
					/* Set event flags as usual */
					«dispatchEventFctID»(«cE»);
					
					«runCycleFunctionForLoop»
					
					/* Delete event from memory */
					delete «cE»;
					«clearInEventsFctID»();
				} while((«cE» = «nextEventFctID»()));
			}
		'''
	}
	
	def getNextEventFunction(ExecutionFlow it) {
		val nE = "nextEvent"
		'''
		«SCT_EVENT»* «module»::«nextEventFctID»()
		{
			«SCT_EVENT»* «nE» = 0;
			
			if(!«internalQueue».empty()) {
				«nE» = «internalQueue».front();
				«internalQueue».pop_front();
			}
			
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
					«FOR e : s.localEvents»
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
							«val localEvents = s.declarations.filter(EventDefinition).filter[direction == Direction.LOCAL]»
							«IF localEvents.size > 0»
								«FOR e : localEvents»
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
}
