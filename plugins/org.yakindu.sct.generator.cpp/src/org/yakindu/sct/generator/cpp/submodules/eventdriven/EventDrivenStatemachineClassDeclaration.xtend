package org.yakindu.sct.generator.cpp.submodules.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.eventdriven.EventNaming
import org.yakindu.sct.generator.cpp.submodules.StatemachineClassDeclaration
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.cpp.CppGeneratorConstants.*

class EventDrivenStatemachineClassDeclaration extends StatemachineClassDeclaration {
	@Inject extension EventNaming
	@Inject extension EventDrivenPredicate
	
	override generateClass(ExecutionFlow it, extension IGenArtifactConfigurations artifactConfigs) {
		val classDecl = super.generateClass(it, artifactConfigs)
		if(needsInternalEventQueue) 
			classDecl.privateMember('''std::deque<«eventNamespaceName»::«SCT_EVENT»*> «internalQueue»;''')
		if(needsNextEventFunction) 
			classDecl.privateMember('''«eventNamespaceName»::«SCT_EVENT»* «nextEventFctID»();''')
		if(needsDispatchEventFunction) 
			classDecl.privateMember('''void «dispatchEventFctID»(«eventNamespaceName»::«SCT_EVENT» * event);''')
		classDecl
	}
}