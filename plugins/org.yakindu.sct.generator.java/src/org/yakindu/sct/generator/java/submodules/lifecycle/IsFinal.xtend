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
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions

class IsFinal implements org.yakindu.sct.generator.core.submodules.lifecycle.IsFinal {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension FlowCode
	@Inject protected extension StateVectorExtensions
	@Inject protected extension GenmodelEntries
	@Inject protected extension Synchronized
	
	override isFinal(ExecutionFlow flow) {
		val finalStateImpactVector = flow.finalStateImpactVector

		'''
			/** 
			«IF !finalStateImpactVector.isCompletelyCovered»
			* Always returns 'false' since this state machine can never become final.
			*
			«ENDIF»
			* @see IStatemachine#isFinal()
			*/
			public «sync»boolean isFinal() {
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
	
}