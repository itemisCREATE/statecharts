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

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

class TimedStatemachineInterface implements IContentTemplate {
	
	@Inject
	extension CppNaming
	
	@Inject
	extension GenmodelEntries
	
	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		'''
		«entry.licenseText»
		
		#ifndef «timedStatemachineInterface.define»_H_
		#define «timedStatemachineInterface.define»_H_
		
		#include "«typesModule.h»"
		#include "«timerInterface.h»"
		
		/*! \file Interface for state machines which use timed event triggers.
		*/
		class «timedStatemachineInterface» {
			public:
			
				virtual ~«timedStatemachineInterface»() = 0;
				
				/*! Set the ITimerService for the state machine. It must be set
				    externally on a timed state machine before a run cycle can be correct
				    executed.
				*/
				virtual void «SET_TIMER»(«timerInterface»* timerInterface) = 0;
				
				/*! Returns the currently used timer service.
				*/
				virtual «timerInterface»* «GET_TIMER»() = 0;
				
				/*! Callback method if a time event occurred.
				*/
				virtual void «raiseTimeEventFctID»(«EVENT_TYPE» event) = 0;
				
				/*! Method to retrieve the number of time events that can be 
					active at once in this state machine.
				*/
				virtual «INT_TYPE» «numTimeEventsFctID»() = 0;
		};
		
		inline «timedStatemachineInterface»::~«timedStatemachineInterface»() {}
		
		#endif /* «timedStatemachineInterface.define»_H_ */
		'''
	}
}