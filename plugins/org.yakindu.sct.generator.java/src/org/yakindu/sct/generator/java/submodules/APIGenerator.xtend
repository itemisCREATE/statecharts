package org.yakindu.sct.generator.java.submodules

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.sct.generator.java.FlowCode
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions

@Singleton
class APIGenerator {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension FlowCode
	@Inject protected extension StateVectorExtensions
	
	def init(ExecutionFlow flow) '''
		public void init() {
			this.initialized = true;
			«IF flow.timed»
			if (timer == null) {
				throw new IllegalStateException("timer not set.");
			}
			«ENDIF»
			«IF flow.internalScope !== null && flow.internalScope.hasOperations»
				if (this.operationCallback == null) {
					throw new IllegalStateException("Operation callback for internal must be set.");	
				}
			«ENDIF»
			«FOR scope : flow.interfaceScopes»
				«IF scope.hasOperations»
					if (this.«scope.interfaceName.asEscapedIdentifier».operationCallback == null) {
						throw new IllegalStateException("Operation callback for interface «scope.interfaceName.asEscapedIdentifier» must be set.");
					}
					
				«ENDIF»
			«ENDFOR»
			for (int i = 0; i < «flow.stateVector.size»; i++) {
				stateVector[i] = State.$NullState$;
			}
			«IF flow.hasHistory»
			for (int i = 0; i < «flow.historyVector.size»; i++) {
				historyVector[i] = State.$NullState$;
			}
			«ENDIF»
			clearEvents();
			clearOutEvents();
			«flow.initSequence.code»
		}

	'''
	
	def isStateActive(ExecutionFlow flow) '''
		/**
		* Returns true if the given state is currently active otherwise false.
		*/
		public boolean isStateActive(State state) {

			switch (state) {
			«FOR s : flow.states»
			case «s.stateName.asEscapedIdentifier»:
				return «IF s.leaf»stateVector[«s.stateVector.offset»] == State.«s.stateName.asEscapedIdentifier»«ELSE»stateVector[«s.stateVector.offset»].ordinal() >= State.
						«s.stateName.asEscapedIdentifier».ordinal()&& stateVector[«s.stateVector.offset»].ordinal() <= State.«s.subStates.last.stateName.asEscapedIdentifier».ordinal()«ENDIF»;
			«ENDFOR»
			default:
				return false;
			}
		}

	'''
	
	def isActive(ExecutionFlow flow) '''
		/**
		 * @see IStatemachine#isActive()
		 */
		public boolean isActive() {
			return «FOR i : 0 ..< flow.stateVector.size SEPARATOR '||'»stateVector[«i»] != State.«nullStateName»«ENDFOR»;
		}

	'''

	def isFinal(ExecutionFlow flow) {
		val finalStateImpactVector = flow.finalStateImpactVector

		'''
			/** 
			«IF !finalStateImpactVector.isCompletelyCovered»
			* Always returns 'false' since this state machine can never become final.
			*
			«ENDIF»
			* @see IStatemachine#isFinal()
			*/
			public boolean isFinal() {
		''' +

		// only if the impact vector is completely covered by final states the state machine
		// can become final

			{if (finalStateImpactVector.isCompletelyCovered) {
			'''	return «FOR i : 0 ..<finalStateImpactVector.size SEPARATOR ' && '»(«FOR fs : finalStateImpactVector.get(i) SEPARATOR ' || '»stateVector[«i»] == «
								IF fs.stateVector.offset == i
									»State.«fs.stateName.asEscapedIdentifier»«
								ELSE
									»State.«nullStateName»«
								ENDIF»«
							ENDFOR»)«ENDFOR»;
		'''} else {
		'''	return false;
		'''} }
		
		+ '''}
		'''
	}

	def timingFunctions(ExecutionFlow flow) '''
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
			}

		«ENDIF»
	'''
	
	def runCycle(ExecutionFlow flow) '''
		public void runCycle() {
			if (!initialized)
				throw new IllegalStateException(
						"The state machine needs to be initialized first by calling the init() function.");
			clearOutEvents();
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
			clearEvents();
		}
	'''
	
	def enter(ExecutionFlow it) '''
		public void enter() {
			if (!initialized) {
				throw new IllegalStateException(
						"The state machine needs to be initialized first by calling the init() function.");
			}
			«IF timed»
			if (timer == null) {
				throw new IllegalStateException("timer not set.");
			}
			«ENDIF»
			«enterSequences.defaultSequence.code»
		}

	'''
	
	def exit(ExecutionFlow it) '''
		public void exit() {
			«exitSequence.code»
		}

	'''
	
	def interfaceAccessors(ExecutionFlow flow) '''
		«FOR scope : flow.interfaceScopes»
			public «scope.interfaceName» get«scope.interfaceName»() {
				return «scope.interfaceName.toFirstLower()»;
			}

		«ENDFOR»
	'''
}