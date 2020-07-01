/**
  Copyright (c) 2018 committers of YAKINDU and others.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  Contributors:
  	René Beckmann - refactored from Statemachine
*/
package org.yakindu.sct.generator.java.submodules

import com.google.inject.Inject
import com.google.inject.Singleton
import java.util.List
import org.yakindu.sct.generator.java.FlowCode
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.Check
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.stext.stext.EventDefinition

@Singleton
class InternalFunctionsGenerator {
	
	@Inject extension Naming
	@Inject extension JavaNamingService
	@Inject extension SExecExtensions
	@Inject extension FlowCode
	@Inject extension EventCode
	@Inject extension MethodGenerator
	
	def internalScopeFunctions (ExecutionFlow flow) '''
		«FOR event : flow.internalScopeEvents»
			«IF event.isInEvent»
				««« shadow event raiser (in event in internal scope) »»»
				«event.inEventRaiser»
			«ELSE»
				«event.internalEventRaiser»
			«ENDIF»
			«IF event.hasValue»
				«event.eventValueGetter»
			«ENDIF»

		«ENDFOR»
		«FOR internal : flow.internalScopes»
			«IF internal.hasOperations»
				public void set«internal.internalOperationCallbackName»(
						«internal.internalOperationCallbackName» operationCallback) {
					this.operationCallback = operationCallback;
				}

			«ENDIF»
		«ENDFOR»
	'''
	
	def functionImplementations(ExecutionFlow it) '''
		«checkFunctions.toImplementation»
		«effectFunctions.toImplementation»
		«entryActionFunctions.toImplementation»
		«exitActionFunctions.toImplementation»
		«enterSequenceFunctions.toImplementation»
		«exitSequenceFunctions.toImplementation»
		«reactFunctions.filter[ f | ! (f.eContainer instanceof ExecutionState)].toList.toImplementation»
		«reactMethods.toImplementation»
	'''
	
	def toImplementation(List<Step> steps) '''
		«FOR s : steps»
			«s.functionImplementation»
		«ENDFOR»
	'''
	
	def dispatch functionImplementation(Check it) '''
		«stepComment»
		private boolean «functionName»() {
			return «code.toString.trim»;
		}

	'''
	
	def dispatch functionImplementation(Step it) '''
		«stepComment»
		private void «functionName»() {
			«code.toString.trim»
		}

	'''
	
	def getIllegalAccessValidation(EventDefinition it) '''
		if (! «name.asEscapedIdentifier» ) 
			throw new IllegalStateException("Illegal event value access. Event «name.asEscapedName» is not raised!");
	'''
}