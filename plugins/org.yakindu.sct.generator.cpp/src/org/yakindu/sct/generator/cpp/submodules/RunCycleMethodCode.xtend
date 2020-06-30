/**
 * Copyright (c) 2020 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.submodules

import com.google.inject.Inject
import org.yakindu.sct.generator.core.submodules.lifecycle.MicroStepCode
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.INamingService

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

/**
 * @autho rherrmann
 */
class RunCycleMethodCode implements MicroStepCode {
	@Inject extension CppNaming
	@Inject extension SExecExtensions
	@Inject extension INamingService

	override microStepCode(ExecutionFlow it) 
		'''
		for («STATEVECTOR_POS» = 0;
			«STATEVECTOR_POS» < «orthogonalStatesConst»;
			«STATEVECTOR_POS»++)
			{
				
			switch («STATEVECTOR»[«STATEVECTOR_POS»])
			{
			«FOR state : states.filter[isLeaf]»
				«IF state.reactMethod !== null»
					case «state.shortName.asEscapedIdentifier» :
					{
						«state.reactMethod.shortName»(true);
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
