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

class ITimerCallback {
	
	@Inject
	extension Naming 
	
	@Inject
	extension GenmodelEntries
	
	def generateITimerCallback(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		fsa.generateFile(entry.basePackagePath + '/' + iTimerCallback.csharp, content(entry))
	}
	
	def private content(GeneratorEntry entry) {
		'''
		«entry.licenseText»
		namespace «entry.getNamespaceName()»
		{

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
				void timeElapsed(int eventID);
			}
		}
		'''
	}
}