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
import org.yakindu.sct.types.generator.statechart.c.naming.CNamingService
import org.yakindu.sct.types.generator.statechart.cpp.artifacts.CppGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.statechart.cpp.modifications.CppNextStateIndexModification
import org.yakindu.sct.types.generator.statechart.cpp.modifications.CppPropertyAccessModification
import org.yakindu.sct.types.generator.statechart.cpp.modifications.InterfaceRenamingModification
import org.yakindu.sct.types.generator.statechart.cpp.modifications.OCBModification
import org.yakindu.sct.types.generator.statechart.cpp.modifications.RenameSCTInterfacesModification
import org.yakindu.sct.types.generator.statechart.cpp.naming.CppEventNaming
import org.yakindu.sct.types.generator.statechart.cpp.naming.CppPropertyAccessNaming
import org.yakindu.sct.types.generator.statechart.modification.library.FlattenInnerTypesModification
import org.yakindu.sct.types.generator.statechart.modification.library.PropertyAccessModification
import org.yakindu.sct.types.generator.statechart.modification.library.event.InEventModification
import org.yakindu.sct.types.generator.statechart.modification.library.event.LocalEventModification
import org.yakindu.sct.types.generator.statechart.modification.library.event.OutEventModification
import org.yakindu.sct.types.generator.statechart.modification.library.APIOperationsModification
import org.yakindu.sct.types.generator.statechart.cpp.modifications.CreateDefaultPackage

class CppSCTGeneratorModule extends SCTGeneratorModule {

	override getModifications() {
		return #[ 
			// base modifications
			PropertyAccessModification,
			InEventModification,
			OutEventModification,
			LocalEventModification,
			APIOperationsModification,
			
			// C++ modifications
			CreateDefaultPackage,
			InterfaceRenamingModification,
			RenameSCTInterfacesModification,
			FlattenInnerTypesModification,
			OCBModification,
			CppNextStateIndexModification,
			CppPropertyAccessModification
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
		CppTypesGeneratorModule
	}

}
