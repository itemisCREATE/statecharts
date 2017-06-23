package org.yakindu.sct.generator.cpp.eventdriven

import org.yakindu.sct.generator.cpp.StatemachineHeader
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition

class EventDrivenStatemachineHeader extends StatemachineHeader {
	
	override protected generatePublicClassmembers(ExecutionFlow it) {
		'''
		«super.generatePublicClassmembers(it)»
		
		«eventEnumDecl»
		
		«generateEventClass»
		'''
	}
	
	def generateEventClass() {
		'''
		template <typename T>
		class SctEvent
		{
			public:
				SctEvent(Events eventName);
				SctEvent(Events eventName, T value);
				~SctEvent();
		};
		'''
	}
	
	def eventEnumDecl(ExecutionFlow it) {
		'''
		typedef enum
		{
			«FOR s : scopes»
				/* Interface «s.interfaceName» */
				«FOR e : s.declarations.filter(EventDefinition) SEPARATOR ","»
				«e.name.asIdentifier»
				«ENDFOR»
			«ENDFOR»
		}
		'''
	}
	
}