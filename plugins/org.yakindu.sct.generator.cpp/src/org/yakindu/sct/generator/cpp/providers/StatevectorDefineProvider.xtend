/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.providers

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.CppNaming
import org.yakindu.sct.generator.cpp.files.StatemachineHeader
import org.yakindu.sct.model.sexec.ExecutionFlow

@GeneratorContribution(StatemachineHeader.HEADER_TARGET)
class StatevectorDefineProvider implements ISourceFragment {
	@Inject protected extension CppNaming
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		'''
		/*! Define indices of states in the StateConfVector */
		«FOR state : states»
			#define «state.stateVectorDefine» «state.stateVector.offset»
		«ENDFOR»
		'''
	}
	
	override orderPriority(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		-1
	}
	
}