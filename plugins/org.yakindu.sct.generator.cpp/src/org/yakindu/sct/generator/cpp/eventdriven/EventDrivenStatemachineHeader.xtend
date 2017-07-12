package org.yakindu.sct.generator.cpp.eventdriven

import com.google.inject.Inject
import java.util.List
import org.yakindu.base.types.Direction
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.StatemachineHeader
import org.yakindu.sct.model.sexec.ExecutionFlow
import org.yakindu.sct.model.stext.stext.EventDefinition
import org.yakindu.sct.model.stext.stext.StatechartScope

class EventDrivenStatemachineHeader extends StatemachineHeader {
	@Inject extension EventNaming
	
	override protected generatePublicClassmembers(ExecutionFlow it) {
		'''
		«super.generatePublicClassmembers(it)»
		'''
	}
	
	override protected generatePrivateClassmembers(ExecutionFlow it) {
		'''
		private:
			std::deque<«eventNamespaceName»::SctEvent*> internalEventQueue;
			
			«eventNamespaceName»::SctEvent* getNextEvent();
			
			void dispatch_event(«eventNamespaceName»::SctEvent * event);
		'''
	}
	
	override includes(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		'''
		#include <deque>
		#include "«eventClasses.h»"
		«super.includes(it, artifactConfigs)»
		'''
	}
	
	override CharSequence protectedInnerClassMembers(StatechartScope scope) {
		'''
		«super.protectedInnerClassMembers(scope)»
		«scope.execution_flow.module()» * parent;
		void dispatch_event(«scope.flow.eventNamespaceName»::SctEvent * event);
		
		'''
	}
	
	override protected createInterface(StatechartScope it) {
		val List<String> toInit = newArrayList
		for( e : declarations.filter(EventDefinition)) {
			toInit.add('''«e.name.asIdentifier.raised»(false)''')
			if (e.hasValue) {
				toInit.add('''«e.name.asIdentifier.value»()''')
			}
		}
		toInit.add("parent(parent)")
		return '''
			//! Inner class for «simpleName» interface scope.
			class «interfaceName»
			{
				
				public:
					«interfaceName»(«execution_flow.module()» * parent): 
					«FOR init : toInit SEPARATOR ","»
						«init»
					«ENDFOR»
					{}
					«FOR d : declarations»
						«d.functionPrototypes»
					«ENDFOR»
					
				«entry.innerClassVisibility»:
					«protectedInnerClassMembers»
			};
		'''
	}
	
	def dispatch privateFunctionPrototypes(EventDefinition it) {
		'''
		«IF direction == Direction::LOCAL»
			/*! Raises the in event '«name»' that is defined in the «scope.scopeDescription». */
			void internal_«asRaiser»(«valueParams»);
		«ENDIF»
		'''
	}
	
}