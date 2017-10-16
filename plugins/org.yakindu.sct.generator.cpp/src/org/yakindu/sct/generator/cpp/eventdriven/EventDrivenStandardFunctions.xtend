/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	rbeckmann - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.cpp.eventdriven

import org.yakindu.sct.generator.cpp.classes.members.StandardFunctionProvider
import org.yakindu.sct.generator.core.language.factory.IStandardFunctionProvider
import org.yakindu.sct.model.sexec.ExecutionFlow

/**
 * @author rbeckmann
 *
 */
class EventDrivenStandardFunctions extends StandardFunctionProvider implements IStandardFunctionProvider {
	override runCycle(ExecutionFlow it) {
		val runCycle = super.runCycle(it)
		runCycle.content = '''
			clearOutEvents();
						
			SctEvent * currentEvent = getNextEvent();
			
			do
			{
				/* Set event flags as usual */
				dispatch_event(currentEvent);
				
				for (stateConfVectorPosition = 0;
								stateConfVectorPosition < «orthogonalStatesConst»;
								stateConfVectorPosition++)
				{
					
				switch (stateConfVector[stateConfVectorPosition])
				{
				«FOR state : flow.states»
					«IF state.reactSequence !== null»
					case «state.shortName.asEscapedIdentifier» :
					{
						«state.reactSequence.shortName»();
						break;
					}
					«ENDIF»
				«ENDFOR»
				default:
					break;
				}
			}
				
				/* Delete event from memory */
				delete currentEvent;
				clearInEvents();
			} while((currentEvent = getNextEvent()));
		'''
		runCycle
	}
	
	override raiseTimeEvent(ExecutionFlow it) {
		val raiseTimeEvent = super.raiseTimeEvent(it)
		raiseTimeEvent.content = '''
		if ((evid >= (sc_eventid)«timeEventsInstance») && (evid < (sc_eventid)(&«timeEventsInstance»[«timeEventsCountConst»])))
		{
			*(sc_boolean*)evid = true;
			runCycle();
		}
		'''
		raiseTimeEvent
	}
	
}