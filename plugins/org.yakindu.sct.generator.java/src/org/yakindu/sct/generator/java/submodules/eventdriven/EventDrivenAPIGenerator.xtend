/**
  Copyright (c) 2018 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	René Beckmann - refactored from Statemachine
*/
package org.yakindu.sct.generator.java.submodules.eventdriven

import org.yakindu.sct.generator.java.submodules.APIGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow

class EventDrivenAPIGenerator extends APIGenerator {
	override timingFunctions(ExecutionFlow flow) '''
		«IF flow.timed»
			/**
			* Set the {@link ITimer} for the state machine. It must be set
			* externally on a timed state machine before a run cycle can be correctly
			* executed.
			* 
			* @param timer
			*/
			public void setTimer(ITimer timer) {
				this.timer = timer;
			}

			/**
			* Returns the currently used timer.
			* 
			* @return {@link ITimer}
			*/
			public ITimer getTimer() {
				return timer;
			}
			
			public void timeElapsed(int eventID) {
				timeEvents[eventID] = true;
				runCycle();
			}

		«ENDIF»
	'''
	
	override runCycle(ExecutionFlow it) {
		if(!hasLocalEvents) {
			return super.runCycle(it)
		}
		'''
			public void runCycle() {
				if (!initialized)
					throw new IllegalStateException(
							"The state machine needs to be initialized first by calling the init() function.");
			
				clearOutEvents();
				singleCycle();
				clearEvents();
				
				// process queued events
				while (internalEventQueue.size() > 0) {
					internalEventQueue.poll().run();
					clearEvents();
				}
			}
			
			«it.singleCycle»
		'''
	}
	
	def protected singleCycle(ExecutionFlow it) '''
		protected void singleCycle() {
			for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
				switch (stateVector[nextStateIndex]) {
				«FOR state : flow.states.filter[isLeaf]»
					«IF state.reactMethod !== null»
						case «state.stateName.asEscapedIdentifier»:
							«state.reactMethod.shortName»(true);
							break;
				«ENDIF»
				«ENDFOR»
				default:
					// «getNullStateName()»
				}
			}
		}
	'''
}