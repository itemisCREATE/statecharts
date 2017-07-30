package org.yakindu.sct.generator.java.eventdriven

import java.util.Set
import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.sct.generator.java.Statemachine
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.stext.stext.EventDefinition

class EventDrivenStatemachine extends Statemachine {

	/** Adds imports for the internal event queue if neccessary. */
	override protected imports(ExecutionFlow it, GeneratorEntry entry) {

		val Set<String> importSet = super.imports(it, entry);	
		
		if (hasInternalEvents) {
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
			* externally on a timed state machine before a run cycle can be correct
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

	override protected internalEventFields(ExecutionFlow flow) '''
		«IF flow.hasInternalEvents»
			private Queue<Runnable> internalEventQueue = new LinkedList<Runnable>();
		«ENDIF»
		«super.internalEventFields(flow)»
	'''

	override protected internalEventRaiser(EventDefinition it) '''
		private void raise«name.asEscapedName»(«IF hasPayload»final «typeSpecifier.targetLanguageName» value«ENDIF») {

			internalEventQueue.add( new Runnable() {
				@Override public void run() {
					«IF hasPayload»«valueIdentifier» = value;«ENDIF»
					«identifier» = true;					
					runCycle();
				}
			});
		}
	'''

	override protected runCycleFunction(ExecutionFlow flow) '''
		public void runCycle() {
			if (!initialized)
				throw new IllegalStateException(
						"The state machine needs to be initialized first by calling the init() function.");
		
			clearOutEvents();
			singleCycle();
			clearEvents();
			
			«IF flow.hasInternalEvents»
			// process queued events
			while (internalEventQueue.size() > 0) {
				internalEventQueue.poll().run();
				singleCycle();
				clearEvents();
			}
			«ENDIF»
		}
		
		«flow.singelCycle»
	'''
	
	def protected singelCycle(ExecutionFlow flow) '''
		protected void singleCycle() {
			for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
				switch (stateVector[nextStateIndex]) {
				«FOR state : flow.states»
					«IF state.reactSequence !== null»
						case «state.stateName.asEscapedIdentifier»:
							«state.reactSequence.functionName»();
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