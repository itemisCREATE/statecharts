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

class IsActive implements org.yakindu.sct.generator.core.submodules.lifecycle.IsActive {
	@Inject protected extension Naming
	@Inject protected extension JavaNamingService
	@Inject protected extension SExecExtensions
	@Inject protected extension FlowCode
	@Inject protected extension StateVectorExtensions
	@Inject protected extension GenmodelEntries
	@Inject protected extension Synchronized
	
	override isActive(ExecutionFlow flow) '''
		/**
		 * @see IStatemachine#isActive()
		 */
		public «sync»boolean isActive() {
			return «FOR i : 0 ..< flow.stateVector.size SEPARATOR '||'»stateVector[«i»] != State.«nullStateName»«ENDFOR»;
		}

	'''
	
}