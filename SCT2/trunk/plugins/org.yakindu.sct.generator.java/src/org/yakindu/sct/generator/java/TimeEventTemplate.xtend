/**
  Copyright (c) 2012 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	Markus Muehlbrandt - Initial contribution and API
 */
package org.yakindu.sct.generator.java

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.eclipse.xtext.generator.IFileSystemAccess
import com.google.inject.Inject

class TimeEventTemplate {
	
	@Inject
	extension Naming 
	
	@Inject
	extension GenmodelEntries
	
	def generateTimeEvent(ExecutionFlow flow, GeneratorEntry entry, IFileSystemAccess fsa) {
		fsa.generateFile(entry.basePackagePath + '/' + timeEventClass.java, content(entry))
	}
	
	def private content(GeneratorEntry entry) {
		'''
		«entry.licenseText»
		package «entry.getBasePackageName()»;

		/**
		 * Event that reflects a time event. It's internally used by
		 * {@link ITimedStatemachine}.
		 * 
		 * @author muehlbrandt
		 * 
		 * @param <T>
		 */
		public class TimeEvent {
		
			private boolean periodic;
		
			private ITimedStatemachine statemachine;
			
			int index;
		
			/**
			 * Constructor for a time event.
			 * 
			 * @param periodic
			 *            : Set to {@code true} if event should be repeated
			 *            periodically.
			 * 
			 * @param index
			 *            : Index position within the state machine's timeEvent array.
			 */
			public TimeEvent(boolean periodic, int index) {
				this.periodic = periodic;
				this.index = index;
			}
		
			/**
			 * Returns the state machine reference of the event.
			 * 
			 */
			public ITimedStatemachine getStatemachine() {
				return statemachine;
			}
		
			/**
			 * Sets the state machine reference of the event.
			 * 
			 * @param statemachine
			 */
			public void setStatemachine(ITimedStatemachine statemachine) {
				this.statemachine = statemachine;
			}
		
			public boolean isPeriodic() {
				return periodic;
			}
		
			public int getIndex() {
				return index;
			}
		}
		'''
	}
}