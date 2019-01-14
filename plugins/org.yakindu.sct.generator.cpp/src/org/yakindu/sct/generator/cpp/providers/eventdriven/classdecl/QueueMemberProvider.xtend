package org.yakindu.sct.generator.cpp.providers.eventdriven.classdecl

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.providers.ISourceFragment
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.c.CGeneratorConstants.*
import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*
import org.yakindu.sct.generator.cpp.providers.GeneratorContribution
import org.yakindu.sct.generator.cpp.providers.StatemachineClassDeclaration

@GeneratorContribution(StatemachineClassDeclaration.CLASS_PRIVATE_TARGET)
class QueueMemberProvider implements ISourceFragment {
	@Inject extension EventNaming
	@Inject extension EventDrivenPredicate
	
	override get(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		'''
		«IF needsInternalEventQueue»
		std::deque<«eventNamespaceName»::«SCT_EVENT»*> «internalQueue»;
		«ENDIF»
		«IF needsNextEventFunction»
		«eventNamespaceName»::«SCT_EVENT»* «nextEventFctID»();
		«ENDIF»
		«IF needsDispatchEventFunction»
		void «dispatchEventFctID»(«eventNamespaceName»::«SCT_EVENT» * event);
		«ENDIF»
		«IF needsInEventQueue»
		std::deque<«eventNamespaceName»::«SCT_EVENT»*> «inEventQueue»;
		«ENDIF»
		«IF needsRunCycleGuard»
		«BOOL_TYPE» «runCycleGuard»;
		«ENDIF»
		'''
	}
	
	override isNeeded(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		isEventDriven
	}
	
	override orderPriority(ExecutionFlow flow, IGenArtifactConfigurations config) {
		1
	}
	
}