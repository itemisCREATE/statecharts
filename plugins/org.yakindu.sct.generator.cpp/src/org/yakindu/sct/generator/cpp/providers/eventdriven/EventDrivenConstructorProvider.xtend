package org.yakindu.sct.generator.cpp.providers.eventdriven

import com.google.inject.Inject
import org.yakindu.sct.generator.c.IGenArtifactConfigurations
import org.yakindu.sct.generator.cpp.eventdriven.EventDrivenPredicate
import org.yakindu.sct.generator.cpp.files.StatemachineImplementation
import org.yakindu.sct.generator.cpp.providers.ConstructorProvider
import org.yakindu.sct.generator.cpp.providers.GeneratorContribution
import org.yakindu.sct.model.sexec.ExecutionFlow

import static org.yakindu.sct.generator.c.CGeneratorConstants.*

@GeneratorContribution(StatemachineImplementation.SOURCE_TARGET)
class EventDrivenConstructorProvider extends ConstructorProvider {
	@Inject protected extension EventDrivenPredicate
	
	override protected initialisationList(ExecutionFlow it) {
		'''
			«IF timed»«timerInstance»(«NULL_STRING»),«ENDIF»
			«IF entry.tracingUsed»«tracingInstance»(0),«ENDIF»
			«STATEVECTOR_POS»(0)«FOR s : getInterfaces»,
			«s.instance»(this)«IF s.hasOperations && !entry.useStaticOPC»,
			«s.OCB_Instance»(«NULL_STRING»)«ENDIF»«ENDFOR»
		'''
	}
	
	override isNeeded(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		isEventDriven		
	}
	
	override replaces(ExecutionFlow it, IGenArtifactConfigurations artifactConfigs) {
		ConstructorProvider
	}
	
}