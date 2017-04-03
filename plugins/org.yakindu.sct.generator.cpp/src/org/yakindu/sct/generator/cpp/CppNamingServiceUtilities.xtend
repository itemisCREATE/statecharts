package org.yakindu.sct.generator.cpp

import com.google.inject.Inject
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.generator.c.GenmodelEntries
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.naming.NamingServiceUtilities
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.base.base.NamedElement

class CppNamingServiceUtilities extends NamingServiceUtilities {
	@Inject extension SExecExtensions
	@Inject extension GenmodelEntries
	@Inject var GeneratorEntry entry
	
	override public prefix(Step it, char separator) {
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

	override public prefix(ExecutionState it, char separator) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			""
		} else {
			entry.statemachinePrefix
		}
	}

	override public prefix(State it, char separator) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			""
		} else {
			entry.statemachinePrefix
		}
	}

	override public prefix(TimeEventSpec it, NamedElement element, char separator) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			""
		} else {
			entry.statemachinePrefix
		}
	}
}