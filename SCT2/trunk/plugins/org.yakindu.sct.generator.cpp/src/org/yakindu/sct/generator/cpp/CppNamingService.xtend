/**
  Copyright (c) 2014-2015 committers of YAKINDU Statechart Tools.
  All rights reserved. This program and the accompanying materials
  are made available under the terms of the Eclipse Public License v1.0
  which accompanies this distribution, and is available at
  http://www.eclipse.org/legal/epl-v10.html
  
  Contributors:
  	Markus Mühlbrandt - Initial contribution and API
*/

package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import java.util.Arrays
import org.yakindu.sct.generator.c.CNamingService
import org.yakindu.sct.generator.c.GenmodelEntries
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.stext.TimeEventSpec

import static org.yakindu.sct.generator.cpp.CppKeywords.*

class CppNamingService extends CNamingService {

	@Inject extension GenmodelEntries

	@Inject extension SExecExtensions

	@Inject
	new(GeneratorEntry entry) {
		super(entry)
	}

	override protected prefix(Step it, char separator) {
		var prefix = ""
		if (!entry.statemachinePrefix.nullOrEmpty) {
			prefix = entry.statemachinePrefix + separator
		}
		switch (it) {
			case isCheckFunction: prefix + "check"
			case isEntryAction: prefix + "enact"
			case isExitAction: prefix + "exact"
			case isEffect: prefix + "effect"
			case isEnterSequence: prefix + "enseq"
			case isDeepEnterSequence: prefix + "dhenseq"
			case isShallowEnterSequence: prefix + "shenseq"
			case isExitSequence: prefix + "exseq"
			case isReactSequence: prefix + "react"
			default: ""
		}
	}

	override protected prefix(ExecutionState it, char separator) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			""
		} else {
			entry.statemachinePrefix
		}
	}

	override protected prefix(State it, char separator) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			""
		} else {
			entry.statemachinePrefix
		}
	}

	override protected prefix(TimeEventSpec it, State state, char separator) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			""
		} else {
			entry.statemachinePrefix
		}
	}

	override isKeyword(String name) {
		var isKeyword = !Arrays::asList(CPP_KEYWORDS).findFirst[it.equalsIgnoreCase(name)].nullOrEmpty
		return isKeyword || super.isKeyword(name)
	}
}
