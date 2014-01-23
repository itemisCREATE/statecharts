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
		if (entry.functionPrefix != null) {
			prefix = entry.functionPrefix + separator
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
		if (entry.functionPrefix != null) {
			entry.functionPrefix
		} else {
			""
		}
	}

	override protected prefix(State it, char separator) {
		""
	}

	override protected prefix(TimeEventSpec it, State state, char separator) {
		if (entry.functionPrefix != null) {
			entry.functionPrefix
		} else {
			""
		}
	}

	override isKeyword(String name) {
		var isKeyword = !Arrays::asList(CPP_KEYWORDS).findFirst[it.equalsIgnoreCase(name)].nullOrEmpty
		return isKeyword || super.isKeyword(name)
	}
}
