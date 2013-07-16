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

class TimedStatemachineInterface {
	
	@Inject
	extension Naming
	
	@Inject
	extension GenmodelEntries
	
	def generateITimedStatemachine(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		fsa.generateFile(timedStatemachineInterface.h, flow.content(entry) )
	}
	
	def private content(ExecutionFlow it, GeneratorEntry entry) {
		'''
		«entry.licenseText»
		
		#ifndef «timedStatemachineInterface.define»_H_
		#define «timedStatemachineInterface.define»_H_
		
		#include "«typesModule.h»"
		#include "«timerInterface.h»"
		
		/*
		* Interface for state machines which use timed event triggers.
		*/
		class «timedStatemachineInterface» {
			public:
			
				virtual ~«timedStatemachineInterface»() = 0;
				
				/*
				* Set the ITimerService for the state machine. It must be set
				* externally on a timed state machine before a run cycle can be correct
				* executed.
				*/
				virtual void setTimer(«timerInterface»* timer) = 0;
				
				/*
				* Returns the currently used timer service.
				*/
				virtual «timerInterface»* getTimer() = 0;
				
				/*
				* Callback method if a time event occurred.
				*/
				virtual void «nameOfRaiseTimeEventFunction»(sc_eventid event) = 0;
		};
		
		inline TimedStatemachineInterface::~TimedStatemachineInterface() {}
		
		#endif /* «timedStatemachineInterface.define»_H_ */
		'''
	}
}