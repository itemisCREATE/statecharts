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
import org.yakindu.sct.types.generator.cpp.modifications.CTUpperCaseModification
import org.yakindu.sct.types.generator.cpp.modifications.ConstructorModification
import org.yakindu.sct.types.generator.cpp.modifications.InterfaceGetterModification
import org.yakindu.sct.types.generator.modification.library.AliasReplacementModification
import org.yakindu.sct.types.generator.modification.library.IdentifierModification
import org.yakindu.sct.types.generator.modification.library.RemoveAnnotationTypeModification
import org.yakindu.sct.types.generator.modification.library.TypesReplacementModification
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
			// base modifications
			IdentifierModification,
			
			// C++ modifications
			RemoveAnnotationTypeModification,
			CTUpperCaseModification,
			ConstructorModification,
			InterfaceGetterModification,
			AliasReplacementModification,
			
			// base modifications
			TypesReplacementModification
		]
	}

	override bindOutputConfigurator() {
		DefaultCppGeneratorArtifactConfigurator
	}

	override bindITypesGenerator() {
		CppTypesGenerator
	}

}
