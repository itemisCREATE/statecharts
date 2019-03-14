/**
 * Copyright (c) 2018-2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	andreas muelder - itemis AG
 *  thomas kutz - itemis AG
 *  axel terfloth - itemis AG
 */
package org.yakindu.sct.model.sexec.transformation.ng

import com.google.inject.Inject
import javax.inject.Singleton
import org.yakindu.base.types.TypesFactory
import org.yakindu.sct.model.sexec.transformation.TypeBuilder
import org.yakindu.base.types.typesystem.ITypeSystem

/**
 * Creates the IStatemachine interface type and its methods.
 *  
 * @author andreas muelder - Initial contribution and API
 * @author thomas kutz
 * @author axel terfloth
 * 
 */
@Singleton class IStatemachine {

	extension TypesFactory factory = TypesFactory.eINSTANCE
 	@Inject extension TypeBuilder tBuilder
 	@Inject extension ITypeSystem tSystem
 	
 	public static val String NAME = "IStatemachine"
 
 
 	def create createPackage scrPackage() {
 		it => [
 			name = "sct"
 		]	
 	}
 	
 	def create createComplexType statemachineInterfaceType() {
		it => [
			name = NAME
			// Implicit operations
			features += createInitMethod
			features += createEnterMethod
			features += createExitMethod
			features += createIsActiveMethod
			features += createIsFinalMethod
			features += createRunCycleMethod
		]
		
		scrPackage.member += it
	}

	def createInitMethod() {
		_op("init", tSystem.getType(ITypeSystem.VOID))
	}

	def createEnterMethod() {
		_op("enter", tSystem.getType(ITypeSystem.VOID))
	}
	
	def createExitMethod() {
		_op("exit", tSystem.getType(ITypeSystem.VOID))
	}
	
	def createIsActiveMethod() {
		_op("isActive", tSystem.getType(ITypeSystem.BOOLEAN))
	}
	
	def createIsFinalMethod() {
		_op("isFinal", tSystem.getType(ITypeSystem.BOOLEAN))
	}
	
	def createRunCycleMethod() {
		_op("runCycle", tSystem.getType(ITypeSystem.BOOLEAN))
	}
	
}