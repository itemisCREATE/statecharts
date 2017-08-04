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
import org.yakindu.sct.generator.cpp.EventCode
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

/**
 * @author René Beckmann - Initial contribution and API
 */
class EventDrivenEventCode extends EventCode {
	@Inject extension EventNaming eventNaming
	
	
	override generateEvents(ExecutionFlow it, StatechartScope scope)
		'''
			«FOR event : scope.incomingEvents»
					«generateEventComment(event, scope)»
					«generateInterfaceEventRaiser(it, event, scope)»
					«IF scope.defaultInterface»
						«generateDefaultInterfaceEventRaiser(it, event, scope)»
					«ENDIF»
			«ENDFOR»
			«FOR event : scope.outgoingEvents»
				«generateEventComment(event, scope)»
				«generateInterfaceEventRaised(it, event, scope)»
				«IF scope.defaultInterface»
					«generateDefaultInterfaceEventRaised(it, event, scope)»
				«ENDIF»
				«IF event.hasValue»
					«generateEventValueGetter(it, event, scope)»
					«IF scope.defaultInterface»
						«generateEventGetter(it, event, scope)»
					«ENDIF»
				«ENDIF»
			«ENDFOR»
			«FOR event : scope.localEvents»
				«generateEventComment(event, scope)»
				«generateInterfaceEventRaiser(it, event, scope)»
				«generateInternalInterfaceEventRaiser(it, event, scope)»
				«generateInterfaceEventRaised(it, event, scope)»
				«IF event.hasValue» 
					«generateEventValueGetter(it, event, scope)»
				«ENDIF»
			«ENDFOR»
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
		if(event.direction == Direction::IN) {
			'''
			void «module»::«scope.interfaceName»::«event.asRaiser»(«event.valueParams»)
			{
				«IF event.hasValue»
				«event.localValueAccess» = value;
				«ENDIF»
				«event.localAccess» = true;
				
				parent->runCycle();
			}
			'''
		} else if(event.direction == Direction::LOCAL) {
			'''
				void «module»::«scope.interfaceName»::«event.asRaiser»(«event.valueParams»)
				{
					«IF event.hasValue»
					parent->internalEventQueue.push_back(new «event.eventClassName»(«event.eventEnumMemberName», value));
					«ELSE»
					parent->internalEventQueue.push_back(new «event.eventClassName»(«event.eventEnumMemberName»));
					«ENDIF»
					parent->runCycle();
				}
			'''
		}
	}
	
	override CharSequence generateEventComment(EventDefinition it, StatechartScope scope)
		'''/* Functions for event «name» in interface «scope.interfaceName» */'''
}