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
import org.yakindu.sct.generator.core.library.IOutletFeatureHelper
import org.yakindu.sct.generator.core.impl.IExecutionFlowGenerator

class TimedStatemachineInterface {
	
	@Inject
	extension Naming
	
	@Inject
	extension GenmodelEntries
	
	@Inject
	protected IOutletFeatureHelper outletFeatureHelper;
	
	def generateITimedStatemachine(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		if (outletFeatureHelper.getLibraryTargetFolderValue(entry) != null)
			fsa.generateFile(timedStatemachineInterface.h, IExecutionFlowGenerator.LIBRARY_TARGET_FOLDER_OUTPUT,
				flow.content(entry))
		else
			fsa.generateFile(timedStatemachineInterface.h, flow.content(entry))
	}
	
	def protected content(ExecutionFlow it, GeneratorEntry entry) {
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
				virtual void «raiseTimeEventFctID»(sc_eventid event) = 0;
		};
		
		inline TimedStatemachineInterface::~TimedStatemachineInterface() {}
		
		#endif /* «timedStatemachineInterface.define»_H_ */
		'''
	}
}