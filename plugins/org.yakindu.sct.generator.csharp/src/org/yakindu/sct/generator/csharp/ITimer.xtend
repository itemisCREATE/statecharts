/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.csharp

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject

class ITimer {
	
	@Inject
	extension Naming 
	
	@Inject
	extension GenmodelEntries
	
	def generateITimer(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		fsa.generateFile(entry.basePackagePath + '/' + iTimer.csharp, content(entry))
	}
	
	def private content(GeneratorEntry entry) {
		'''
		«entry.licenseText»
		using «entry.getNamespaceName()»;
		
		namespace «entry.getNamespaceName()»
		{

			/**
			 * Interface a timer has to implement. Use to implement your own timer
			 * service.
			 * 
			 */
			public interface ITimer {
			
				/**
				 * Starts the timing for a given time event id.
				 * 
				 * @param callback
				 * 			  : The target callback where the time event has to be raised.
				 * 
				 * @param eventID
				 *            : The eventID the timer should use if timed out.
				 *            
				 * @param time
				 *            : Time in milliseconds after the given time event should be
				 *            triggered
				 *            
				 * @param isPeriodic
				 * 			  : Set to true if the time event should be triggered periodically
				 */
				void setTimer(ITimerCallback callback, int eventID, long time, bool isPeriodic);
			
				/**
				 * Unset a time event.
				 * 
				 * @param callback
				 * 			: The target callback for which the time event has to be unset.
				 * 
				 * @param eventID
				 * 			: The time event id.
				 */
				void unsetTimer(ITimerCallback callback, int eventID);
			}
		}
		'''
	}
}