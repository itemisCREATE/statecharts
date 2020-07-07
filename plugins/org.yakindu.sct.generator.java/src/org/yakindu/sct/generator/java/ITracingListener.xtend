/** 
 * Copyright (c) 2015 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.java

import com.google.inject.Inject
import org.eclipse.xtext.generator.IFileSystemAccess
import org.yakindu.sct.generator.core.library.ICoreLibraryHelper
import org.yakindu.sct.generator.java.util.StringHelper
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*

class ITracingListener {
	@Inject extension Naming
	@Inject extension GenmodelEntries
	
	@Inject ICoreLibraryHelper outletFeatureHelper

	def generateTracing(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if(outletFeatureHelper.getSkipLibraryFiles(entry)) {
			return
		}
		if (outletFeatureHelper.getLibraryTargetFolderValue(entry) !== null) {
			// generate into library target folder in case one is specified, as the contents are static
			fsa.generateFile(entry.basePackage.toPath + '/' + traceInterface.java,
				LIBRARY_TARGET_FOLDER_OUTPUT, content(entry))
		} else if (outletFeatureHelper.getApiTargetFolderValue(entry) !== null) {
			// generate into API target folder in case one is specified, as it is an interface
			fsa.generateFile(entry.basePackage.toPath + '/' + traceInterface.java,
				API_TARGET_FOLDER_OUTPUT, content(entry))
		} else {
			// use default target folder path in case no library or API target folder is specified (the file will be overwritten there)
			fsa.generateFile(entry.basePackage.toPath + '/' + traceInterface.java, content(entry))
		}
	}
	
	def content(GeneratorEntry entry) {
		content(entry.licenseText, entry.basePackage)
	}

	def private content(String licenceText, String basePackage) '''
	«licenceText»
	package «basePackage»;
	
	/**
	 * Tracing interface for state machines.
	 * Must be implemented if tracing feature is used.
	 * Multiple listeners can be added to and removed from the state machine.
	 */
	public interface «traceInterface»<T> {
		
		/**
		 * «stateEnteredTraceFunctionID.toFirstUpper» will be called if any state has been entered.
		 */
		void «stateEnteredTraceFunctionID»(T state);
		
		/**
		* «stateExitedTraceFunctionID.toFirstUpper» will be called if any state has been exited.
		*/
		void «stateExitedTraceFunctionID»(T state);
	}
	'''
}
