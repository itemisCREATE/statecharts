package org.yakindu.sct.generator.cpp.eventdriven

import java.util.List
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.StatemachineHeader
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.sgraph.Scope
import org.yakindu.sct.model.stext.stext.EventDefinition

class EventDrivenStatemachineHeader extends StatemachineHeader {
	override protected generatePublicClassmembers(ExecutionFlow it) {
		'''
		«super.generatePublicClassmembers(it)»
			«eventEnumDecl»
			
			«generateEventClass»
		'''
	}
	
	override protected generatePrivateClassmembers(ExecutionFlow it) {
		'''
		private:
			std::deque<SctEvent> InternalEventQueue;
		'''
	}
	
	def generateEventClass(ExecutionFlow it) {
		'''
		class SctEvent
		{
			public:
				SctEvent(«eventEnumName» eventName);
				~SctEvent();
		};
				
		template <typename T>
		class ValuedSctEvent : public SctEvent
		{
			public:
				ValuedSctEvent(«eventEnumName» eventName, T value);
				~ValuedSctEvent();
		};
		
		'''
	}
	
	
	
	def eventEnumMemberName(Scope s, EventDefinition it) {
		'''«s.interfaceName»_«name.asIdentifier»'''
	}
	
	def eventEnumName(ExecutionFlow it) {
		'''«module»EventName'''
	}
	
	def eventEnumDecl(ExecutionFlow it) {
		val List<String> eds = newArrayList
		for(s : scopes) {
			eds.addAll(s.declarations.filter(EventDefinition).map[ed | eventEnumMemberName(s, ed).toString])
		}
		'''
		typedef enum
		{
			«FOR e : eds SEPARATOR ","»
				«e»
			«ENDFOR»
		} «eventEnumName»;
		
		'''
	}
	
	override includes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		#include <deque>
		«super.includes(it, artifactConfigs)»
		'''
	}
	
}