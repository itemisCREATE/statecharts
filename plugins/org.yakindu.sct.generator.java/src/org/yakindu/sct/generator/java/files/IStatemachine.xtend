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

class IStatemachine {
	
	@Inject extension Naming 
	@Inject extension GenmodelEntries
	@Inject extension OutputConfigProvider
	@Inject extension ICoreLibraryHelper
	 
	def generateIStatemachine(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if (entry.skipLibraryFiles) {
			return
		}
		val fileName = entry.libraryPackage.toPath + '/' + iStatemachine.java
		fsa.generateFile(fileName, entry.libraryOutputConfig, content(entry))
	}
	
	def private content(GeneratorEntry it) {
		'''
			«licenseText»
			package «libraryPackage»;
			
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
