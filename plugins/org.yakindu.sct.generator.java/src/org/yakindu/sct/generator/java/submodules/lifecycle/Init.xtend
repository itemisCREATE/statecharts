/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.java.submodules.lifecycle

import com.google.inject.Inject
import org.yakindu.sct.generator.java.FlowCode
import org.yakindu.sct.generator.java.GenmodelEntries
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.generator.java.features.Synchronized
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.concepts.EventProcessing
import org.yakindu.sct.model.sexec.concepts.ExecutionGuard
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions

class Init implements org.yakindu.sct.generator.core.submodules.lifecycle.Init {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension FlowCode
	@Inject protected extension StateVectorExtensions
	@Inject protected extension GenmodelEntries
	@Inject protected extension Synchronized
	@Inject protected extension EventProcessing
	@Inject protected extension ExecutionGuard
	
	override init(ExecutionFlow flow) '''
		public «sync»void init() {
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
					if (this.«scope.interfaceVariableName».operationCallback == null) {
						throw new IllegalStateException("Operation callback for interface «scope.interfaceName» must be set.");
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
			
			«flow._clearInEvents.code»
			«flow._clearInternalEvents.code»
			«flow._clearOutEvents.code»
			
			«flow.initSequence.code»
			
			«flow._initIsExecuting.code»
		}

	'''
	
}