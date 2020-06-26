/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java.submodules

import com.google.inject.Inject
import org.yakindu.sct.generator.core.submodules.lifecycle.MicroStepCode
import org.yakindu.sct.generator.java.JavaNamingService
import org.yakindu.sct.generator.java.Naming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions

/**
 * 
 * @author Thomas Kutz
 */
class RunCycleMethodCode implements MicroStepCode {
	
	@Inject extension Naming
	@Inject extension JavaNamingService
	@Inject extension SExecExtensions
	
	override microStepCode(ExecutionFlow flow) '''
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
	
}