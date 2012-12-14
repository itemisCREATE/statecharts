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

class ITimerService {
	
	@Inject
	extension Naming 
	
	@Inject
	extension GenmodelEntries
	
	def generateITimerService(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		fsa.generateFile(entry.basePackagePath + '/' + iTimerServiceClass.java, content(entry))
	}
	
	def private content(GeneratorEntry entry) {
		'''
		«entry.licenseText»
		package «entry.getBasePackageName()»;

		/**
		 * Interface a timer service has to implement. Use to implement your own timer
		 * service. A timer service has to be added to a timed state machine.
		 * 
		 */
		public interface ITimerService {
		
			/**
			 * Starts the timing for a given {@link TimeEvent}.
			 * 
			 * @param event
			 *            : The TimeEvent the timer service should throw if timed out.
			 * @param time
			 *            : Time in milliseconds after the given time event should be
			 *            triggered
			 * @param cycleStartTime
			 *            : The absolute start time in milliseconds at which the last
			 *            run cycle was called. Can be used to produce a more accurate
			 *            timing behavior.
			 */
			public void setTimer(TimeEvent event, long time, long cycleStartTime);
		
			/**
			 * Unset the given {@link TimeEvent}. Use to unset cyclic repeated time
			 * events.
			 * 
			 * @param event
			 */
			public void resetTimer(TimeEvent event);
		
			/**
			 * Cancel timer service. Use this to end possible timing threads and free
			 * memory resources.
			 */
			public void cancel();
		
			/**
			 * Returns the system time in milliseconds.
			 * 
			 * @return the difference, measured in milliseconds, between the current
			 *         time and a defined point of time in the past.
			 */
			public long getSystemTimeMillis();
		}
		'''
	}
}