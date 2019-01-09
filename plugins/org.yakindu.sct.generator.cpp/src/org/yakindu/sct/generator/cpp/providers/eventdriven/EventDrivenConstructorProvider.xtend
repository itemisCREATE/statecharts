/**
 * Copyright (c) 2018 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.cpp.providers.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.files.StatemachineImplementation
import org.yakindu.sct.generator.cpp.providers.ConstructorProvider
import org.yakindu.sct.generator.cpp.providers.GeneratorContribution
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

@GeneratorContribution(StatemachineImplementation.SOURCE_TARGET)
class EventDrivenConstructorProvider extends ConstructorProvider {
	@Inject protected extension EventDrivenPredicate
	@Inject protected extension CLiterals
	
	override protected initialisationList(ExecutionFlow it) {
		'''
			«IF timed»«timerInstance»(«NULL_LITERAL»),«ENDIF»
			«IF entry.tracingUsed»«tracingInstance»(0),«ENDIF»
			«STATEVECTOR_POS»(0)«FOR s : getInterfaces»,
			«s.instance»(this)«IF s.hasOperations && !entry.useStaticOPC»,
			«s.OCB_Instance»(«NULL_LITERAL»)«ENDIF»«ENDFOR»
		'''
	}
	
	override isNeeded(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		isEventDriven		
	}
	
	override replaces(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		ConstructorProvider
	}
	
}