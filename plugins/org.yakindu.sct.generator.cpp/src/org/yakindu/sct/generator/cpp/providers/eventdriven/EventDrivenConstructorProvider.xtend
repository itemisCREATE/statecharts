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
import org.yakindu.sct.generator.c.types.CLiterals
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.providers.ConstructorProvider
import org.yakindu.sct.model.sexec.ExecutionFlow

class EventDrivenConstructorProvider extends ConstructorProvider {
	@Inject protected extension EventDrivenPredicate
	@Inject protected extension EventNaming
	@Inject protected extension CLiterals
	
	override protected initialisationList(ExecutionFlow it) {
		val toInit = super.initialisationList(it)
		val ifaceInstances = interfaces.map[instance].toList
		toInit.replaceAll[ p |
			if(ifaceInstances.contains(p.key)) {
				pair(p.key, "sc_null")
			} else {
				p
			}
		]
		if(needsRunCycleGuard) {
			toInit.add(runCycleGuard, "false")
		}
		toInit
	}
	
	override protected constructorBody(ExecutionFlow it) {
		var toConstructorBody = super.constructorBody(it)
		val ifaceInstances = interfaces.map[instance].toList
		val ifaceInitialization = '''
			«FOR ifaceInstance : ifaceInstances»
				«ifaceInstance» = this;
			«ENDFOR»
		'''
		toConstructorBody + ifaceInitialization
	}
	
}