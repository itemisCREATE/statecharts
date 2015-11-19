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

class IStatemachine {
	
	@Inject
	extension Naming 
	
	@Inject
	extension GenmodelEntries
	
	def generateIStatemachine(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		fsa.generateFile(entry.basePackagePath + '/' + iStatemachine.csharp, content(entry))
	}
	
	def private content(GeneratorEntry entry) {
		'''
		«entry.licenseText»
		namespace «entry.getNamespaceName()»
		{

			/**
			 * Basic interface for statemachines.
			 */
			public interface IStatemachine {
			
				/**
				 * Initializes the statemachine. Use to init internal variables etc.
				 */
				void init();
			
				/**
				 * Enters the statemachine. Sets the statemachine in a defined state.
				 */
				void enter();
			
				/**
				 * Exits the statemachine. Leaves the statemachine with a defined state.
				 */
				void exit();
			
				/**
				 * Checks if the statemachine is active. 
				 * A statemachine is active if it was entered. It is inactive if it has not been entered at all or if it was exited.
				 */
				bool isActive();
			
				/**
				 * Checks if all active states are final. 
				 * If there are no active states then the statemachine is considered as incative and this method returns false.
				 */
				bool isFinal();
			
				/**
				* Start a run-to-completion cycle.
				*/
				void runCycle();
			}
		}
		'''
	}
}