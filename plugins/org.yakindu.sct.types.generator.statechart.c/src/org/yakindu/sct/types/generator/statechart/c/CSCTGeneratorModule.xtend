package org.yakindu.sct.types.generator.statechart.c

import org.yakindu.sct.types.generator.c.CTypesGenerator
import org.yakindu.sct.types.generator.statechart.c.artifacts.CGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.statechart.c.naming.CEventNaming
import org.yakindu.sct.types.generator.statechart.c.naming.CNamingService
import org.yakindu.sct.types.generator.statechart.c.naming.CPropertyAccessNaming
import org.yakindu.sct.types.generator.statechart.core.SCTGeneratorModule

class CSCTGeneratorModule extends SCTGeneratorModule {
	
	override bindEventNaming() {
		CEventNaming
	}
	
	override bindPropertyAccessNaming() {
		CPropertyAccessNaming
	}
	
	override getModifications() {
		#[]
	}
	
	override bindOutputConfigurator() {
		CGeneratorArtifactConfigurator
	}
	
	override bindNamingService() {
		CNamingService
	}
	
	override bindGenerator() {
		CTypesGenerator
	}
	
	
	
}