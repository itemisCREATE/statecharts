package org.yakindu.sct.generator.java.submodules.eventdriven

import org.yakindu.base.types.typesystem.GenericTypeSystem
import org.yakindu.sct.generator.java.submodules.EventCode
import org.yakindu.sct.model.stext.stext.EventDefinition

class EventDrivenEventCode extends EventCode {
	override generateInEventDefinition(EventDefinition event) '''
		«IF event.type !== null && !isSame(event.type, getType(GenericTypeSystem.VOID))»
			public void raise«event.name.asName»(«event.typeSpecifier.targetLanguageName» value) {
				«event.identifier» = true;
				«event.valueIdentifier» = value;
				runCycle();
			}
			
			protected «event.typeSpecifier.targetLanguageName» get«event.name.asName»Value() {
				«event.getIllegalAccessValidation()»
				return «event.valueIdentifier»;
			}
		«ELSE»
			public void raise«event.name.asName»() {
				«event.identifier» = true;
				runCycle();
			}
		«ENDIF»

	'''
}