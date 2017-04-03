package org.yakindu.sct.generator.java

import org.yakindu.sct.model.sexec.naming.NamingServiceUtilities
import com.google.inject.Inject
import org.yakindu.sct.model.sexec.extensions.SExecExtensions
import org.yakindu.sct.model.sexec.Step

class JavaNamingServiceUtilities extends NamingServiceUtilities {
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
}