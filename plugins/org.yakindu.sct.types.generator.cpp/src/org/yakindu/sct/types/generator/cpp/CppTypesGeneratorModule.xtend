/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator.cpp

import org.yakindu.sct.types.generator.cpp.artifacts.DefaultCppGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.module.TypesGeneratorModule

class CppTypesGeneratorModule extends TypesGeneratorModule {

	override bindExpressions() {
		CppExpressions
	}

	override bindTargetPlatform() {
		CppTargetPlatform
	}

	override getModifications() {
		return #[
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

	override bindOutputConfigurator() {
		DefaultCppGeneratorArtifactConfigurator
	}

	override bindITypesGenerator() {
		CppTypesGenerator
	}

}
