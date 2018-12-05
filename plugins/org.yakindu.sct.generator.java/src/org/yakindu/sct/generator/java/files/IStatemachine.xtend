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
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import static org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess.*

class IStatemachine {
	
	@Inject
	extension org.yakindu.sct.generator.java.Naming 
	
	@Inject
	extension org.yakindu.sct.generator.java.GenmodelEntries
	
	@Inject ICoreLibraryHelper outletFeatureHelper
	 
	def generateIStatemachine(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if(outletFeatureHelper.getSkipLibraryFiles(entry)) {
			return
		}
		if (outletFeatureHelper.getLibraryTargetFolderValue(entry) !== null) {
			// generate into library target folder in case one is specified, as the contents are static
			fsa.generateFile(entry.basePackagePath + '/' + iStatemachine.java,
				LIBRARY_TARGET_FOLDER_OUTPUT, content(entry))
		} else if (outletFeatureHelper.getApiTargetFolderValue(entry) !== null) {
			// generate into API target folder in case one is specified, as it is an interface
			fsa.generateFile(entry.basePackagePath + '/' + iStatemachine.java,
				API_TARGET_FOLDER_OUTPUT, content(entry))
		} else {
			// use default target folder path in case no library or API target folder is specified (the file will be overwritten there)
			fsa.generateFile(entry.basePackagePath + '/' + iStatemachine.java, content(entry))
		}
	}
	
	def private content(GeneratorEntry entry) {
		'''
			«entry.licenseText»
			package «entry.getBasePackageName()»;
			
			/**
			 * Basic interface for state machines.
			 */
			public interface IStatemachine {
			
				/**
				 * Initializes the state machine. Used to initialize internal variables etc.
				 */
				public void init();
			
				/**
				 * Enters the state machine. Sets the state machine into a defined state.
				 */
				public void enter();
			
				/**
				 * Exits the state machine. Leaves the state machine with a defined state.
				 */
				public void exit();
			
				/**
				 * Checks whether the state machine is active. 
				 * A state machine is active if it has been entered. It is inactive if it has not been entered at all or if it has been exited.
				 */
				public boolean isActive();
			
				/**
				 * Checks whether all active states are final. 
				 * If there are no active states then the state machine is considered being incative. In this case this method returns <code>false</code>.
				 */
				public boolean isFinal();
			
				/**
				* Start a run-to-completion cycle.
				*/
				public void runCycle();
			}
		'''
	}
}
