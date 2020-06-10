/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java.files

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

class ITimer {
	
	@Inject extension Naming 
	@Inject extension GenmodelEntries
	@Inject extension OutputConfigProvider
	@Inject extension ICoreLibraryHelper
	
	def generateITimer(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if (entry.skipLibraryFiles) {
			return
		}
		val fileName = entry.basePackagePath + '/' + iTimer.java
		fsa.generateFile(fileName, entry.libraryOutputConfig, content(entry))
	}

	def content(GeneratorEntry entry) {
		content(entry.licenseText, entry.basePackageName)
	}
	
	def content(String licenceText, String basePackage) {
		'''
			«licenceText»
			package «basePackage»;
			
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
				public void setTimer(ITimerCallback callback, int eventID, long time, boolean isPeriodic);
			
				/**
				 * Unset a time event.
				 * 
				 * @param callback
				 * 			: The target callback for which the time event has to be unset.
				 * 
				 * @param eventID
				 * 			: The time event id.
				 */
				public void unsetTimer(ITimerCallback callback, int eventID);
			}
		'''
	}
}