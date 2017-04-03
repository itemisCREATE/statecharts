package org.yakindu.sct.generator.c

import org.yakindu.sct.model.sexec.naming.NamingServiceUtilities
import org.yakindu.sct.model.sexec.Step
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.stext.TimeEventSpec
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sexec.ExecutionFlow

class CNamingServiceUtilities extends NamingServiceUtilities{
	@Inject extension SExecExtensions
	@Inject extension GenmodelEntries
	@Inject var GeneratorEntry entry
	
	override public prefix(Step it, char separator) {
		var prefix = flow.name.toFirstLower
		if (entry.statemachinePrefix != null) {
			prefix = entry.statemachinePrefix
		}
		switch (it) {
			case isCheckFunction: prefix + separator + "check"
			case isEntryAction: prefix + separator + "enact"
			case isExitAction: prefix + separator + "exact"
			case isEffect: prefix + separator + "effect"
			case isEnterSequence: prefix + separator + "enseq"
			case isDeepEnterSequence: prefix + separator + "dhenseq"
			case isShallowEnterSequence: prefix + separator + "shenseq"
			case isExitSequence: prefix + separator + "exseq"
			case isReactSequence: prefix + separator + "react"
			default: ""
		}
	}
	
	override public prefix(ExecutionState it, char separator) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			super.prefix(it, separator).toFirstUpper			
		} else {
			entry.statemachinePrefix
		}
	}
	
	override public prefix(State it, char separator) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			super.prefix(it, separator).toFirstUpper
		} else {
			entry.statemachinePrefix
		}
	}
	
	override public prefix(TimeEventSpec it, ExecutionFlow flow, NamedElement element, char separator) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			super.prefix(it, flow, element, separator).toFirstLower
		} else {
			entry.statemachinePrefix
		}
	}
}