package org.yakindu.sct.generator.c

import com.google.inject.Inject
import java.util.Arrays
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.NamingServiceUtilities
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.stext.TimeEventSpec

import static org.yakindu.sct.generator.c.CKeywords.*

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
	
	override public prefix(TimeEventSpec it, NamedElement element) {
		if (entry.statemachinePrefix.nullOrEmpty) {
			super.prefix(it, element).toFirstLower
		} else {
			entry.statemachinePrefix
		}
	}
	
	override asEscapedIdentifier(String it) {
		var s = it
		if (s.isKeyword) {
			s = s + separator +'ID'
		}
		return s.asIdentifier
	}
	
	override boolean isKeyword(String name) {
		return !Arrays::asList(C_KEYWORDS).findFirst[it.equalsIgnoreCase(name)].nullOrEmpty
	}
}