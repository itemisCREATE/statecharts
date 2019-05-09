/** 
 * Copyright (c) 2019 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.sequencer.types

import com.google.inject.Inject
import javax.inject.Singleton
import org.yakindu.base.types.TypeBuilder
import org.yakindu.base.types.TypesFactory
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
	
 	@Inject extension TypeBuilder
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
			features += createInitMethod
			features += createEnterMethod
			features += createExitMethod
			features += createIsActiveMethod
			features += createIsFinalMethod
			features += createRunCycleMethod
		]
		abstract = true
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
		_op("runCycle", tSystem.getType(ITypeSystem.VOID))
	}
	
}
