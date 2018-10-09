/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java.eventdriven

import java.util.Set
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.sct.generator.java.Statemachine
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition

/**
 * @author terfloth
 */
class EventDrivenStatemachine extends Statemachine {

	/** Adds imports for the internal event queue if neccessary. */
	override protected imports(ExecutionFlow it, GeneratorEntry entry) {

		val Set<String> importSet = super.imports(it, entry);	
		
		if (hasLocalEvents) {
			importSet += "java.util.Queue"
			importSet += "java.util.LinkedList"
		}
		
		return importSet
	}
	

	protected override generateInEventDefinition(EventDefinition event) '''
		«IF event.type !== null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
			public void raise«event.name.asName»(«event.typeSpecifier.targetLanguageName» value) {
				«event.identifier» = true;
				«event.valueIdentifier» = value;
				runCycle();
			}
			
			protected «event.typeSpecifier.targetLanguageName» get«event.name.asName»Value() {
				«event.getIllegalAccessValidation()»
				return «event.valueIdentifier»;
			}
		«ELSE»
			public void raise«event.name.asName»() {
				«event.identifier» = true;
				runCycle();
			}
		«ENDIF»

	'''

	override protected timingFunctions(ExecutionFlow flow) '''
		«IF flow.timed»
			/**
			* Set the {@link ITimer} for the state machine. It must be set
			* externally on a timed state machine before a run cycle can be correctly
			* executed.
			* 
			* @param timer
			*/
			public void setTimer(ITimer timer) {
				this.timer = timer;
			}

			/**
			* Returns the currently used timer.
			* 
			* @return {@link ITimer}
			*/
			public ITimer getTimer() {
				return timer;
			}
			
			public void timeElapsed(int eventID) {
				timeEvents[eventID] = true;
				runCycle();
			}

		«ENDIF»
	'''

	override protected internalEventFields(ExecutionFlow it) '''
		«IF hasLocalEvents»
			private Queue<Runnable> internalEventQueue = new LinkedList<Runnable>();
		«ENDIF»
		«super.internalEventFields(it)»
	'''

	override protected internalEventRaiser(EventDefinition it) '''
		private void raise«name.asEscapedName»(«IF hasPayload»final «typeSpecifier.targetLanguageName» value«ENDIF») {

			internalEventQueue.add( new Runnable() {
				@Override public void run() {
					«IF hasPayload»«valueIdentifier» = value;«ENDIF»
					«identifier» = true;					
					singleCycle();
				}
			});
		}
	'''

	override protected runCycleFunction(ExecutionFlow it) {
		if(!hasLocalEvents) {
			return super.runCycleFunction(it)
		}
		'''
			public void runCycle() {
				if (!initialized)
					throw new IllegalStateException(
							"The state machine needs to be initialized first by calling the init() function.");
			
				clearOutEvents();
				singleCycle();
				clearEvents();
				
				// process queued events
				while (internalEventQueue.size() > 0) {
					internalEventQueue.poll().run();
					clearEvents();
				}
			}
			
			«it.singleCycle»
		'''
	}
	
	def protected singleCycle(ExecutionFlow it) '''
		protected void singleCycle() {
			for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
				switch (stateVector[nextStateIndex]) {
				«FOR state : flow.states.filter[isLeaf]»
					«IF state.reactMethod !== null»
						case «state.stateName.asEscapedIdentifier»:
							«state.reactMethod.shortName»(true);
							break;
				«ENDIF»
				«ENDFOR»
				default:
					// «getNullStateName()»
				}
			}
		}
	'''

}