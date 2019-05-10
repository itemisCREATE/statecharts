/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.statechart.cpp

import org.yakindu.sct.types.generator.cpp.CppTypesGeneratorModule
import org.yakindu.sct.types.generator.statechart.SCTGeneratorModule
import org.yakindu.sct.types.generator.statechart.cpp.artifacts.CppGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.statechart.cpp.naming.CppEventNaming
import org.yakindu.sct.types.generator.statechart.cpp.naming.CppPropertyAccessNaming
import org.yakindu.sct.types.generator.statechart.c.naming.CNamingService

class CppSCTGeneratorModule extends SCTGeneratorModule {

	override getModifications() {
		return #[ //
//			// base modifications
//			PropertyAccessModification,
//			InEventModification,
//			OutEventModification,
//			LocalEventModification,
//			IdentifierModification,
//			
//			// C++ modifications
//			InterfaceRenamingModification,
//			RemoveAnnotationTypeModification,
//			FlattenInnerTypesModification,
//			CTUpperCaseModification,
//			RenameSCTInterfacesModification,
//			ConstructorModification,
//			OCBModification,
//			NextStateIndexModification,
//			InterfaceGetterModification,
//			AliasReplacementModification,
//			CppPropertyAccessModification,			
//			
//			// base modifications
//			TypesReplacementModification
		]
	}

	override bindEventNaming() {
		CppEventNaming
	}

	override bindNamingService() {
		CNamingService
	}

	override bindOutputConfigurator() {
		CppGeneratorArtifactConfigurator
	}

	override bindPropertyAccessNaming() {
		CppPropertyAccessNaming
	}

	override getCoreGeneratorModule() {
		new CppTypesGeneratorModule
	}

}
