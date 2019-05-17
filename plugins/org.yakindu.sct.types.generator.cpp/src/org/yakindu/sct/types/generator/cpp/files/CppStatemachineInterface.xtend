/**
 *   Copyright (c) 2013 committers of YAKINDU and others.
 *   All rights reserved. This program and the accompanying materials
 *   are made available under the terms of the Eclipse Public License v1.0
 *   which accompanies this distribution, and is available at
 *   http://www.eclipse.org/legal/epl-v10.html
 *   Contributors:
 *   	Markus Mühlbrandt - Initial contribution and API
 */
package org.yakindu.sct.types.generator.cpp.files

class CppStatemachineInterface {

	def createStatemachineInterface() {
		'''
			//TODO licence text
			//TODO Include guard start
			
			/*! \file Basic interface for state machines.
			 */
			class StatemachineInterface
			{
				public:
				
					virtual ~StatemachineInterface() = 0;
					
					/*! Initializes the state machine. Used to initialize internal variables etc.
					*/
					//TODO: checkUnimplOcbs
				
					/*! Enters the state machine. Sets the state machine into a defined state.
					*/
			/*! Initializes the state machine. Used to initialize internal variables etc.
			*/
			virtual void init() = 0;
			
			/*! Enters the state machine. Sets the state machine into a defined state.
			*/
			virtual void enter() = 0;
			
			/*! Exits the state machine. Leaves the state machine with a defined state.
			*/
			virtual void exit() = 0;
			
			/*! Start a run-to-completion cycle.
			*/
			virtual void runCycle() = 0;
			
			/*! Checks whether the state machine is active. 
				A state machine is active if it has been entered. It is inactive if it has not been entered at all or if it has been exited.
			*/	
			virtual	sc_boolean isActive() = 0;
			
			/*! Checks if all active states are final. 
				If there are no active states then the state machine is considered being inactive. In this case this method returns false.
			*/
			virtual sc_boolean isFinal() = 0;
			};
			
			inline StatemachineInterface::~StatemachineInterface() {}
			
			//TODO: Include guard end
		'''
	}
}
