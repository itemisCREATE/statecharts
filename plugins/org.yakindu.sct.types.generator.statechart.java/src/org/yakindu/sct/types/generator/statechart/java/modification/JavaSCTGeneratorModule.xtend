package org.yakindu.sct.types.generator.statechart.java.modification

import org.yakindu.sct.types.generator.statechart.SCTGeneratorModule
import org.yakindu.sct.types.generator.statechart.java.naming.JavaEventNaming
import org.yakindu.sct.types.generator.statechart.java.naming.JavaNamingService
import org.yakindu.sct.types.generator.statechart.java.naming.JavaPropertyAccessNaming

class JavaSCTGeneratorModule extends SCTGeneratorModule {
	
	override bindEventNaming() {
		JavaEventNaming
	}
	
	override bindNamingService() {
		JavaNamingService
	}
	
	override bindOutputConfigurator() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override bindPropertyAccessNaming() {
		JavaPropertyAccessNaming
	}
	
	override getCoreGeneratorModule() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
	override getModifications() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}
	
}