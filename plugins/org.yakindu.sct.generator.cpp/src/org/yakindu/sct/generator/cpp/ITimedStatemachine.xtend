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

class ITimedStatemachine {
	
	@Inject
	extension Naming
	
	@Inject
	extension GenmodelEntries
	
	def generateITimedStatemachine(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		fsa.generateFile(iTimedStatemachine.hpp, flow.content(entry) )
	}
	
	def private content(ExecutionFlow it, GeneratorEntry entry) {
		'''
		«entry.licenseText»
		
		#ifndef «iTimedStatemachine.define»_H_
		#define «iTimedStatemachine.define»_H_
		
		#include "«typesModule.hpp»"
		#include "«iTimerService.hpp»"
		
		/*
		* Interface for state machines which use timed event triggers.
		*/
		class ITimedStatemachine {
			public:
				/*
				* Set the ITimerService for the state machine. It must be set
				* externally on a timed state machine before a run cycle can be correct
				* executed.
				*/
				virtual void setTimerService(ITimerService* timerService) = 0;
				
				/*
				* Returns the currently used timer service.
				*/
				virtual ITimerService* getTimerService() = 0;
				
				/*
				* Callback method if a time event occurred.
				*/
				virtual void raiseTimeEvent(sc_eventid event) = 0;
		};
		
		#endif /* «iTimedStatemachine.define»_H_ */
		'''
	}
}