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
import org.yakindu.sct.types.generator.cpp.modifications.ComplexTypeUpperCaseModification
import org.yakindu.sct.types.generator.cpp.modifications.ConstMemberModification
import org.yakindu.sct.types.generator.cpp.modifications.ConstructorModification
import org.yakindu.sct.types.generator.cpp.modifications.InterfaceGetterModification
import org.yakindu.sct.types.generator.cpp.modifications.RemoveInitialValuesModification
import org.yakindu.sct.types.generator.modification.library.AliasReplacementModification
import org.yakindu.sct.types.generator.modification.library.IdentifierModification
import org.yakindu.sct.types.generator.modification.library.RemoveAnnotationTypeModification
import org.yakindu.sct.types.generator.modification.library.TypesReplacementModification
import org.yakindu.sct.types.generator.modification.library.event.InEventModification
import org.yakindu.sct.types.generator.modification.library.event.LocalEventModification
import org.yakindu.sct.types.generator.modification.library.event.OutEventModification
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
			InEventModification,
			OutEventModification,
			LocalEventModification,
			
			// C++ modifications
			RemoveAnnotationTypeModification,
			ComplexTypeUpperCaseModification,
			ConstMemberModification,
			ConstructorModification,
			InterfaceGetterModification,
			AliasReplacementModification,
			
			// base modifications
			TypesReplacementModification,
			RemoveInitialValuesModification
		]
	}

	override bindOutputConfigurator() {
		DefaultCppGeneratorArtifactConfigurator
	}

	override bindITypesGenerator() {
		CppTypesGenerator
	}
	
	override bindEventNaming() {
		throw new UnsupportedOperationException("TODO: auto-generated method stub")
	}

}
