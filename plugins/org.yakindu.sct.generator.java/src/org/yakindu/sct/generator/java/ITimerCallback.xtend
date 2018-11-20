/**
 *   Copyright (c) 2012 committers of YAKINDU and others.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *   	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*;
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper

class ITimerCallback {

	@Inject
	extension Naming

	@Inject
	extension GenmodelEntries

	@Inject ICoreLibraryHelper outletFeatureHelper

	def generateITimerCallback(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if(outletFeatureHelper.getSkipLibraryFiles(entry)) {
			return
		}
		if (outletFeatureHelper.getLibraryTargetFolderValue(entry) !== null) {
			// generate into library target folder in case one is specified, as the contents are static
			fsa.generateFile(entry.basePackagePath + '/' + iTimerCallback.java, LIBRARY_TARGET_FOLDER_OUTPUT,
				content(entry))
		} else if (outletFeatureHelper.getApiTargetFolderValue(entry) !== null) {
			// generate into API target folder in case one is specified, as it is an interface
			fsa.generateFile(entry.basePackagePath + '/' + iTimerCallback.java, API_TARGET_FOLDER_OUTPUT,
				content(entry))
		} else {
			// use default target folder path in case no library or API target folder is specified (the file will be overwritten there)
			fsa.generateFile(entry.basePackagePath + '/' + iTimerCallback.java, content(entry))
		}
	}
	
	def content(GeneratorEntry entry) {
		content(entry.licenseText, entry.basePackageName)
	}
	
	def content(String licenseText, String basePackageName) {
		'''
			«licenseText»
			package «basePackageName»;
			
			/**
			* Interface for state machines which use timed event triggers.
			*/
			public interface ITimerCallback {
				
				/**
				* Callback method if a time event occurred.
				* 
				* @param eventID
				* 			:The id of the occurred event.
				*/
				public void timeElapsed(int eventID);
			}
		'''
	}
}
