package org.yakindu.sct.generator.cpp.eventdriven

import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.StatemachineHeader
import org.yakindu.sct.model.sexec.ExecutionFlow

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
	
}