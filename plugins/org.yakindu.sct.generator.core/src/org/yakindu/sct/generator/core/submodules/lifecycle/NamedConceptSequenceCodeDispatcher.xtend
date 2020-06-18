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
package org.yakindu.sct.generator.core.submodules.lifecycle

import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.Sequence
import org.yakindu.sct.model.sexec.transformation.ng.RunCycleMethod
import com.google.inject.Inject

/**
 * Instances of this class dispatches the generation of named sequences representing state machine concepts 
 * to specific code generator modules.
 * 
 * @author aterfloth 
 */
class NamedConceptSequenceCodeDispatcher implements NamedConceptSequenceCode {
	
	@Inject extension MicroStepCode
	 
	override stateMachineConceptCode(ExecutionFlow flow, Sequence s) {
		switch (s.name) {
			case RunCycleMethod.MICRO_STEP :
				return flow.microStepCode
			default : 
				return ''''''
		}		
	}
}