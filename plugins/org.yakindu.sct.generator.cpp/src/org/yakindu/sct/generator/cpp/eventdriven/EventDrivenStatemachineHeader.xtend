package org.yakindu.sct.generator.cpp.eventdriven

import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.StatemachineHeader
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

class EventDrivenStatemachineHeader extends StatemachineHeader {
	override protected generatePublicClassmembers(ExecutionFlow it) {
		'''
		«super.generatePublicClassmembers(it)»
		'''
	}
	
	override protected generatePrivateClassmembers(ExecutionFlow it) {
		'''
		private:
			std::deque<SctEvent*> internalEventQueue;
			
			SctEvent* currentEvent;
			
			void internal_raiseEvent(SctEvent * event);
		'''
	}
	
	override includes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		#include <deque>
		#include "«eventClasses.h»"
		«super.includes(it, artifactConfigs)»
		'''
	}
	
	override prototypes(ExecutionFlow it) {
		var prototypes = super.prototypes(it).toString
		return prototypes.replace("void clearInEvents();", "");
	}
	
	override CharSequence protectedInnerClassMembers(StatechartScope scope) {
		'''
		«super.protectedInnerClassMembers(scope)»
		«scope.execution_flow.module()» * parent;
		
		'''
	}
	
	override protected createInterface(StatechartScope scope) '''
		//! Inner class for «scope.simpleName» interface scope.
		class «scope.interfaceName»
		{
			
			public:
				«scope.interfaceName»(«scope.execution_flow.module()» * parent): parent(parent) {}
				«FOR d : scope.declarations»
					«d.functionPrototypes»
				«ENDFOR»
				
			«entry.innerClassVisibility»:
				«protectedInnerClassMembers(scope)»
		};
	'''
	
	def dispatch privateFunctionPrototypes(EventDefinition it) {
		'''
		«IF direction == Direction::LOCAL»
			/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */
			void internal_«asRaiser»(«valueParams»);
		«ELSEIF direction == Direction::IN»
			/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */
			void internal_«asRaiser»(«valueParams»);
		«ENDIF»
		'''
	}
	
}