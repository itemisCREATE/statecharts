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

class IsStateActive implements org.yakindu.sct.generator.core.submodules.lifecycle.IsStateActive {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension FlowCode
	@Inject protected extension StateVectorExtensions
	@Inject protected extension GenmodelEntries
	@Inject protected extension Synchronized
	
	override isStateActive(ExecutionFlow flow) '''
		/**
		* Returns true if the given state is currently active otherwise false.
		*/
		public «sync»boolean isStateActive(State state) {

			switch (state) {
			«FOR s : flow.states»
			case «s.stateName»:
				return «IF s.leaf»stateVector[«s.stateVector.offset»] == State.«s.stateName»«ELSE»stateVector[«s.stateVector.offset»].ordinal() >= State.
						«s.stateName».ordinal()&& stateVector[«s.stateVector.offset»].ordinal() <= State.«s.subStates.last.stateName».ordinal()«ENDIF»;
			«ENDFOR»
			default:
				return false;
			}
		}

	'''
	
}