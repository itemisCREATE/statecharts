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

class StatemachineInterface {
	
	@Inject
	extension Naming
	
	@Inject
	extension GenmodelEntries
	
	def generateIStatemachine(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		fsa.generateFile(statemachineInterface.h, flow.content(entry) )
	}
	
	def private content(ExecutionFlow it, GeneratorEntry entry) {
		'''
		«entry.licenseText»
		
		#ifndef «statemachineInterface.define»_H_
		#define «statemachineInterface.define»_H_
		
		/*
		 * Basic interface for statemachines.
		 */
		class «statemachineInterface» {
			public:
			
				virtual ~«statemachineInterface»() = 0;
				
				/*
				* Initializes the statemachine. Use to init internal variables etc.
				*/
				virtual void init() = 0;
			
				/*
				* Enters the statemachine. Sets the statemachine in a defined state.
				*/
				virtual void enter() = 0;
			
				/*
				* Exits the statemachine. Leaves the statemachine with a defined state.
				*/
				virtual void exit() = 0;
			
				/*
				* Start a run-to-completion cycle.
				*/
				virtual void runCycle() = 0;
		};
		
		inline StatemachineInterface::~StatemachineInterface() {}
		
		#endif /* «statemachineInterface.define»_H_ */
		'''
	}
}