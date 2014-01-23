package org.yakindu.sct.generator.c

import com.google.inject.Inject
import java.util.Arrays
import java.util.Map
import org.yakindu.base.base.NamedElement
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sexec.ExecutionState
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.DefaultNamingService
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.State
import org.yakindu.sct.model.stext.stext.TimeEventSpec

import static org.yakindu.sct.generator.c.CKeywords.*

class CNamingService extends DefaultNamingService {
	
	@Inject
	extension GenmodelEntries
	
	@Inject
	extension SExecExtensions
	
	var protected GeneratorEntry entry
	
	@Inject
	new (GeneratorEntry entry) {
		this.entry = entry
	}
	
	override Map<NamedElement, String> getShortNameMap(ExecutionFlow flow) {
		if (entry.identifierLength != null) {
			maxLength = entry.identifierLength
		}
		
		if (entry.separator != null) {
			separator = entry.separator.charAt(0)
		}
		
		return super.getShortNameMap(flow)
	}
	
	override protected prefix(Step it, char separator) {
		var prefix = flow.name.toFirstLower
		if (entry.functionPrefix != null) {
			prefix = entry.functionPrefix
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
	
	override protected prefix(ExecutionState it, char separator) {
		if (entry.functionPrefix != null) {
			entry.functionPrefix
		} else {
			super.prefix(it, separator).toFirstUpper
		}
	}
	
	override protected prefix(TimeEventSpec it, State state, char separator) {
		if (entry.functionPrefix != null) {
			entry.functionPrefix
		} else {
			super.prefix(it, state, separator).toFirstLower
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