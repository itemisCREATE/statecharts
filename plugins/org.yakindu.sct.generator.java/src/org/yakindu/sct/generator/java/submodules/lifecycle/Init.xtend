package org.yakindu.sct.generator.java.submodules.lifecycle

import com.google.inject.Inject
import org.yakindu.sct.generator.java.FlowCode
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions

class Init implements org.yakindu.sct.generator.core.submodules.lifecycle.Init {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension FlowCode
	@Inject protected extension StateVectorExtensions
	@Inject protected extension GenmodelEntries
	
	override init(ExecutionFlow flow) '''
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
				stateVector[i] = State.«nullStateName»;
			}
			«IF flow.hasHistory»
			for (int i = 0; i < «flow.historyVector.size»; i++) {
				historyVector[i] = State.«nullStateName»;
			}
			«ENDIF»
			clearEvents();
			clearOutEvents();
			«flow.initSequence.code»
		}

	'''
	
}