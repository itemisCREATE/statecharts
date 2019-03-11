/**
  Copyright (c) 2018 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	René Beckmann - refactored from Statemachine
*/
package org.yakindu.sct.generator.java.submodules

import com.google.inject.Inject
import org.yakindu.sct.generator.java.features.Synchronized
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

class TimingFunctions {
	@Inject protected extension SExecExtensions
	@Inject protected extension Synchronized
	
	def timingFunctions(ExecutionFlow flow) '''
		«IF flow.timed»
			/**
			* Set the {@link ITimer} for the state machine. It must be set
			* externally on a timed state machine before a run cycle can be correctly
			* executed.
			* 
			* @param timer
			*/
			public «sync»void setTimer(ITimer timer) {
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
			
			public «sync»void timeElapsed(int eventID) {
				timeEvents[eventID] = true;
			}

		«ENDIF»
	'''
}