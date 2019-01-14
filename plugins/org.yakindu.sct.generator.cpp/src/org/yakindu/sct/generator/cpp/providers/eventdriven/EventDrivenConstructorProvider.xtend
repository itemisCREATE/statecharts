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
package org.yakindu.sct.generator.cpp.providers.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.files.StatemachineImplementation
import org.yakindu.sct.generator.cpp.providers.ConstructorProvider
import org.yakindu.sct.generator.cpp.providers.GeneratorContribution
import org.yakindu.sct.model.sexec.ExecutionFlow

@GeneratorContribution(StatemachineImplementation.SOURCE_TARGET)
class EventDrivenConstructorProvider extends ConstructorProvider {
	@Inject protected extension EventDrivenPredicate
	@Inject protected extension EventNaming
	@Inject protected extension CLiterals
	
	override protected initialisationList(ExecutionFlow it) {
		val toInit = super.initialisationList(it)
		val ifaceInstances = interfaces.map[instance].toList
		toInit.replaceAll[ p |
			if(ifaceInstances.contains(p.key)) {
				pair(p.key, "this")
			} else {
				p
			}
		]
		if(needsRunCycleGuard) {
			toInit.add(runCycleGuard, "false")
		}
		toInit
	}
	
	override isNeeded(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		isEventDriven		
	}
	
	override replaces(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		ConstructorProvider
	}
	
}