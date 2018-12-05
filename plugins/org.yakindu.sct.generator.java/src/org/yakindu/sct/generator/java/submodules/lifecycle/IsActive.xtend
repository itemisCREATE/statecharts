package org.yakindu.sct.generator.java.submodules.lifecycle

import com.google.inject.Inject
import org.yakindu.sct.generator.java.FlowCode
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions

class IsActive implements org.yakindu.sct.generator.core.submodules.lifecycle.IsActive {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension FlowCode
	@Inject protected extension StateVectorExtensions
	@Inject protected extension GenmodelEntries
	
	override isActive(ExecutionFlow flow) '''
		/**
		 * @see IStatemachine#isActive()
		 */
		public boolean isActive() {
			return «FOR i : 0 ..< flow.stateVector.size SEPARATOR '||'»stateVector[«i»] != State.«nullStateName»«ENDFOR»;
		}

	'''
	
}