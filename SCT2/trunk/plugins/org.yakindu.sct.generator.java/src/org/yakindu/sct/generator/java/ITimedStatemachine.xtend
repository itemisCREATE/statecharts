/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject

class ITimedStatemachine {
	
	@Inject
	extension Naming 
	
	@Inject
	extension GenmodelEntries
	
	def generateITimedStatemachine(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		fsa.generateFile(entry.basePackagePath + '/' + iTimedStatemachineClass.java, content(entry))
	}
	
	def private content(GeneratorEntry entry) {
		'''
		«entry.licenseText»
		package «entry.getBasePackageName()»;

		/**
		* Interface for state machines which use timed event triggers.
		*/
		public interface ITimedStatemachine {
		
			/**
			* Set the {@link ITimerService} for the state machine. It must be set
			* externally on a timed state machine before a run cycle can be correct
			* executed.
			* 
			* @param timerService
			*/
			public void setTimerService(ITimerService timerService);
		
			/**
			* Returns the currently used timer service.
			* 
			* @return {@link ITimerService}
			*/
			public ITimerService getTimerService();
		
			/**
			* Callback method if a {@link TimeEvent} occurred.
			* 
			* @param timeEvent
			*/
			public void onTimeEventRaised(TimeEvent timeEvent);
		}
		'''
	}
}