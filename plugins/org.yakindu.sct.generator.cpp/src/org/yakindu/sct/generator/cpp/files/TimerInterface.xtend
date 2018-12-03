/**
  Copyright (c) 2013 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Mühlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.cpp.files

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IContentTemplate
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.extensions.GenmodelEntries
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

class TimerInterface implements IContentTemplate {
	
	@Inject
	extension CppNaming
	
	@Inject
	extension GenmodelEntries
	
	override content(ExecutionFlow it, GeneratorEntry entry, IGenArtifactConfigurations locations) {
		'''
		«entry.licenseText»
		
		#ifndef «timerInterface.define»_H_
		#define «timerInterface.define»_H_
		
		#include "sc_types.h"
		
		//forward declaration of TimedStatemachineInterface to avoid cyclic dependency
		class TimedStatemachineInterface;
		
		/*! \file Basic interface for state machines.
		 */
		class «timerInterface»
		{
			public:
				
				virtual ~«timerInterface»() = 0;
			
				/*! Starts the timing for a time event.
				 */ 
				virtual void «SET_TIMER»(«timedStatemachineInterface»* statemachine, «EVENT_TYPE» event, «INT_TYPE» time_ms, «BOOL_TYPE» isPeriodic) = 0;
				
				/*! Unsets the given time event.
				 */
				virtual void «UNSET_TIMER»(«timedStatemachineInterface»* statemachine, «EVENT_TYPE» event) = 0;
			
				/*! Cancel timer service. Use this to end possible timing threads and free
				 	 memory resources.
				 */
				virtual void cancel() = 0;
		};
		
		inline «timerInterface»::~«timerInterface»() {}
		
		#endif /* «timerInterface.define»_H_ */
		'''
	}
}