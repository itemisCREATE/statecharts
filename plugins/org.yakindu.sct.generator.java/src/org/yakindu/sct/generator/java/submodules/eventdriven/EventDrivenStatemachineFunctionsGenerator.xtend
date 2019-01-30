package org.yakindu.sct.generator.java.submodules.eventdriven

import org.yakindu.sct.generator.java.submodules.StatemachineFunctionsGenerator
import org.yakindu.sct.model.sexec.ExecutionFlow

class EventDrivenStatemachineFunctionsGenerator extends StatemachineFunctionsGenerator {
	override createConstructor(ExecutionFlow flow) '''
		public «flow.statemachineClassName»() {
			«FOR scope : flow.interfaceScopes»
			«scope.interfaceName.asEscapedIdentifier» = new «scope.getInterfaceImplName»(this);
			«ENDFOR»
		}

	'''
}