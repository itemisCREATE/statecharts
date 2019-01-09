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

import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*

class ITimer {
	
	@Inject
	extension Naming 
	
	@Inject
	extension GenmodelEntries
	
	@Inject ICoreLibraryHelper outletFeatureHelper
	
	def generateITimer(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if(outletFeatureHelper.getSkipLibraryFiles(entry)) {
			return
		}
		if (outletFeatureHelper.getLibraryTargetFolderValue(entry) !== null) {
			// generate into library target folder in case one is specified, as the contents are static
			fsa.generateFile(entry.basePackagePath + '/' + iTimer.java,
				LIBRARY_TARGET_FOLDER_OUTPUT, content(entry))
		} else if (outletFeatureHelper.getApiTargetFolderValue(entry) !== null) {
			// generate into API target folder in case one is specified, as it is an interface
			fsa.generateFile(entry.basePackagePath + '/' + iTimer.java,
				API_TARGET_FOLDER_OUTPUT, content(entry))
		} else {
			// use default target folder path in case no library target folder is specified (the file will be overwritten there)
			fsa.generateFile(entry.basePackagePath + '/' + iTimer.java, content(entry))
		}
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