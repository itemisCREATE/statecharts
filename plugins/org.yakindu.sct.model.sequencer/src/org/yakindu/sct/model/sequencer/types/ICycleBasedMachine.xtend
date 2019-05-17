package org.yakindu.sct.model.sequencer.types

import com.google.inject.Inject
import com.google.inject.Singleton
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
import org.yakindu.base.types.typesystem.ITypeSystem

@Singleton
class ICycleBasedMachine {
	extension TypesFactory factory = TypesFactory.eINSTANCE
	
 	@Inject extension TypeBuilder
 	@Inject extension ITypeSystem tSystem
 	
 	public static val String NAME = "ICycleBasedStatemachine"
 
 
 	def create createPackage scrPackage() {
 		it => [
 			name = "sct"
 		]	
 	}
 	
 	def create createComplexType cycleBasedMachineType() {
		it => [
			name = NAME
			features += createRunCycleMethod
		]
		abstract = true
		scrPackage.member += it
	}

	
	def createRunCycleMethod() {
		_op("runCycle", tSystem.getType(ITypeSystem.VOID))
	}
}