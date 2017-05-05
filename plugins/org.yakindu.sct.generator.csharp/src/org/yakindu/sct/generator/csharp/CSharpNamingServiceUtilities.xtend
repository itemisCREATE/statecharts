package org.yakindu.sct.generator.csharp

import com.google.inject.Inject
import java.util.Arrays
import org.yakindu.sct.model.sexec.Step
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.naming.NamingServiceUtilities


class CSharpNamingServiceUtilities extends NamingServiceUtilities implements CSharpKeywords {
	@Inject extension SExecExtensions
	
	override public prefix(Step it, char separator) {
		switch (it) {
			case isCheckFunction: "check"
			case isEntryAction: "entryAction"
			case isExitAction: "exitAction"
			case isEffect: "effect"
			case isEnterSequence: "enterSequence"
			case isDeepEnterSequence: "deepEnterSequence"
			case isShallowEnterSequence: "shallowEnterSequence"
			case isExitSequence: "exitSequence"
			case isReactSequence: "react"
			default: ""
		}
	}
	
	override boolean isKeyword(String name) {
		return !Arrays::asList(KEYWORDS).findFirst[it.equalsIgnoreCase(name)].nullOrEmpty
	}
}