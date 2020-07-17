/**
 *   Copyright (c) 2012 committers of YAKINDU and others.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *   	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java.files

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

class ITimerCallback {

	@Inject extension Naming 
	@Inject extension GenmodelEntries
	@Inject extension OutputConfigProvider
	@Inject extension ICoreLibraryHelper

	def generateITimerCallback(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if (entry.skipLibraryFiles) {
			return
		}
		val fileName = entry.libraryPackage.toPath + '/' + iTimerCallback.java
		fsa.generateFile(fileName, entry.libraryOutputConfig, content(entry))
	}
	
	def content(GeneratorEntry entry) {
		content(entry.licenseText, entry.libraryPackage)
	}
	
	def content(String licenseText, String pkg) {
		'''
			«licenseText»
			package «pkg»;
			
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
