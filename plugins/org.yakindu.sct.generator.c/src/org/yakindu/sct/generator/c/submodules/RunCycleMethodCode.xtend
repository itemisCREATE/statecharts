/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c.submodules

import org.yakindu.sct.generator.core.submodules.lifecycle.MicroStepCode
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.generator.c.extensions.Naming
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.extensions.StateVectorExtensions
import org.yakindu.sct.generator.c.types.CLiterals

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService

/**
 * Generates all run cycle related code fragments.
 * 
 * @author aterfloth
 */
class RunCycleMethodCode implements MicroStepCode {

	@Inject protected extension INamingService
	@Inject protected extension Naming
	@Inject protected extension SExecExtensions
	@Inject protected extension StateVectorExtensions
	@Inject protected extension CLiterals
	
	override microStepCode(ExecutionFlow it) '''
		for («scHandle»->«STATEVECTOR_POS» = 0;
			«scHandle»->«STATEVECTOR_POS» < «maxOrthogonalStates»;
			«scHandle»->«STATEVECTOR_POS»++)
			{
				
			switch («scHandle»->«STATEVECTOR»[«scHandle»->«STATEVECTOR_POS»])
			{
			«FOR state : states.filter[isLeaf]»
				«IF state.reactMethod !== null»
					case «state.stateName»:
					{
						«state.reactMethod.shortName»(«scHandle», «TRUE_LITERAL»);
						break;
					}
				«ENDIF»
			«ENDFOR»
			default:
				break;
			}
		}
	'''
	
	
}