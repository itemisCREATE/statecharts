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
package org.yakindu.sct.generator.cpp.submodules.eventdriven

import com.google.inject.Inject
import org.yakindu.base.types.Declaration
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.submodules.EventCode
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

/**
 * @author René Beckmann - Initial contribution and API
 */
class EventDrivenEventCode extends EventCode {
	@Inject extension EventNaming eventNaming
	@Inject extension EventDrivenPredicate
	
	
	override generateEvents(ExecutionFlow it, StatechartScope scope)
		'''
			«FOR event : scope.incomingEvents»
				«event.generateEvent»
			«ENDFOR»
			«FOR event : scope.outgoingEvents»
				«event.generateEvent»
			«ENDFOR»
			«FOR event : scope.localEvents»
				«event.generateEvent»
			«ENDFOR»
		'''
	
	def generateEvent(EventDefinition it)
		'''
			«it.generateEventComment(statechartScope)»
			«IF it.needsRaiser»
				«generateInterfaceEventRaiser(flow, it, statechartScope)»
				«IF it.isQueued»«generateInternalInterfaceEventRaiser(flow, it, statechartScope)»«ENDIF»
				«IF statechartScope.defaultInterface»«generateDefaultInterfaceEventRaiser(flow, it, statechartScope)»«ENDIF»
			«ENDIF»
			«IF it.needsRaised»
				«generateInterfaceEventRaised(flow, it, statechartScope)»
				«IF statechartScope.defaultInterface»«generateDefaultInterfaceEventRaised(flow, it, statechartScope)»«ENDIF»
				«IF it.hasValue»
					«generateEventValueGetter(flow, it, statechartScope)»
					«IF statechartScope.defaultInterface»«generateEventGetter(flow, it, statechartScope)»«ENDIF»
				«ENDIF»
			«ENDIF»
		'''
	
	
	protected def CharSequence generateInternalInterfaceEventRaiser(ExecutionFlow it, EventDefinition event, StatechartScope scope)
		'''
		void «module»::«scope.interfaceName»::internal_«event.asRaiser»(«event.valueParams»)
		{
			«IF event.hasValue»
				«event.localValueAccess» = value;
			«ENDIF»
			«event.localAccess» = true;
		}
	'''
	
	protected override CharSequence generateInterfaceEventRaiser(ExecutionFlow it, EventDefinition event, StatechartScope scope) {
		if( event.isQueued ) 
			event.generateInterfaceEventRaiserQueued 
		else 
			event.generateInterfaceEventRaiser
	}

	protected def generateInterfaceEventRaiserQueued(EventDefinition it) 
		'''
			void «flow.module»::«scope.interfaceName»::«it.asRaiser»(«it.valueParams»)
			{
				«IF it.hasValue»
				parent->«queue».push_back(new «event.eventClassName»(«event.eventEnumMemberName», value));
				«ELSE»
				parent->«queue».push_back(new «event.eventClassName»(«event.eventEnumMemberName»));
				«ENDIF»
				parent->«flow.runCycleFctID»();
			}
		'''

	protected def generateInterfaceEventRaiser(EventDefinition it) 
		'''
			void «flow.module»::«scope.interfaceName»::«it.asRaiser»(«it.valueParams»)
			{
				«IF it.hasValue»
				«event.localValueAccess» = value;
				«ENDIF»
				«event.localAccess» = true;
				
				parent->«flow.runCycleFctID»();
			}
		'''
	
	override CharSequence generateEventComment(EventDefinition it, StatechartScope scope)
		'''/* Functions for event «name» in interface «scope.interfaceName» */'''
		
	def statechartScope(Declaration it) {
		if (it.scope instanceof StatechartScope) it.scope as StatechartScope
		else null
	}
	
	def queue(EventDefinition it) {
		return 
			if 		( isLocalEvent ) internalQueue 
			else if	( isInEvent )	 inEventQueue 
			else 					 null
	}
}
