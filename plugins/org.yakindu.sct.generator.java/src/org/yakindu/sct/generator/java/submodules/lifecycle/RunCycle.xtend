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
import org.yakindu.sct.model.stext.lib.StatechartAnnotations

class RunCycle implements org.yakindu.sct.generator.core.submodules.lifecycle.RunCycle {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension FlowCode
	@Inject protected extension StateVectorExtensions
	@Inject protected extension GenmodelEntries
	@Inject protected extension Synchronized
	@Inject protected extension StatechartAnnotations
	
	override runCycle(ExecutionFlow flow) '''
		public «sync»void runCycle() {
			if (!initialized)
				throw new IllegalStateException(
						"The state machine needs to be initialized first by calling the init() function.");
			clearOutEvents();
			«IF flow.statechart.isSuperStep»
			«superStepLoop(flow.runCycleForLoop)»
			«ELSE»
			«flow.runCycleForLoop»
			«ENDIF»
			clearEvents();
		}
	'''
	
	def protected runCycleForLoop(ExecutionFlow flow) '''
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
	'''
	
	def protected superStepLoop(CharSequence microStep) '''
		do {
			stateVectorChanged = false;
			«microStep»
		} while(stateVectorChanged);
	'''
		
	
}