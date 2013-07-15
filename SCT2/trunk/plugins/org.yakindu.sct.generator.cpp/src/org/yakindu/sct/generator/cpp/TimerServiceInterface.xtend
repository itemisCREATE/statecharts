/**
  Copyright (c) 2013 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Mühlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.cpp

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject
import org.yakindu.sct.generator.c.GenmodelEntries

class TimerServiceInterface {
	
	@Inject
	extension Naming
	
	@Inject
	extension GenmodelEntries
	
	def generateITimerService(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		fsa.generateFile(timerServiceInterface.hpp, flow.content(entry) )
	}
	
	def private content(ExecutionFlow it, GeneratorEntry entry) {
		'''
		«entry.licenseText»
		
		#ifndef «timerServiceInterface.define»_H_
		#define «timerServiceInterface.define»_H_
		
		#include "«timedStatemachineInterface.hpp»"
		
		/*
		 * Basic interface for statemachines.
		 */
		class «timerServiceInterface» {
			public:
			
				virtual ~«timerServiceInterface»() = 0;
			
				/*
				 * Starts the timing for a time event.
				 */ 
				virtual void setTimer(«timedStatemachineInterface»* statemachine, sc_eventid event, sc_integer time, sc_boolean isPeriodic) = 0;
				
				/*
				 * Unsets the given time event.
				 */
				virtual void unsetTimer(«timedStatemachineInterface»* statemachine, sc_eventid event) = 0;
			
				/*
				 * Cancel timer service. Use this to end possible timing threads and free
				 * memory resources.
				 */
				virtual void cancel() = 0;
		};
		
		#endif /* «timerServiceInterface.define»_H_ */
		'''
	}
}