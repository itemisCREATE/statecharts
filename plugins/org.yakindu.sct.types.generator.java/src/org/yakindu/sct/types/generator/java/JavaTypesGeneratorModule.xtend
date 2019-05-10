/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	itemis AG
*
*/
package org.yakindu.sct.types.generator.java

import com.yakindu.sct.types.slang.generator.java.JavaSlangGenerator
import com.yakindu.sct.types.slang.generator.java.JavaTargetPlatform
import org.yakindu.sct.types.generator.modification.library.AliasReplacementModification
import org.yakindu.sct.types.generator.modification.library.FlattenInnerTypesModification
import org.yakindu.sct.types.generator.modification.library.IdentifierModification
import org.yakindu.sct.types.generator.modification.library.TypesReplacementModification
import org.yakindu.sct.types.generator.module.TypesGeneratorModule

class JavaTypesGeneratorModule extends TypesGeneratorModule {
	
	override bindITypesGenerator() {
		JavaSlangGenerator
	}
	
	override bindEventNaming() {
		JavaEventNaming
	}
	
	override getModifications() {
		#[
			// base modifications
			PropertyAccessModification,
			PropertyReferenceModification,
			InEventModification,
			OutEventModification,
			LocalEventModification,
			
			// Java modifications
			NamingConventionModification,
			
			/**
			 * after NamingConventionModification to avoid underscores in names that would be keywords
			 */
			IdentifierModification,
			
			ReplaceIntegerWithLongModification, // restores API compatibility
			UnwrapInternalInterfaceModification,
			DefaultInterfacePropertyAccessModification,
			InitializeInterfacePropertiesModification,
			FlattenInnerTypesModification,
			InterfaceLiftingModification,
			OperationCallbackModification,
			AliasReplacementModification,
		
			
			/**
			 * after ReplaceIntegerWithLongModification to ensure interface properties/operations use long type instead of int
			 */
			TypesReplacementModification 
			
		]
	}
	
	override bindExpressions() {
		JavaExpressions
	}
	
	override bindTargetPlatform() {
		JavaTargetPlatform
	}
	
	override bindNamingService() {
		JavaNamingService
	}
	
	override bindPropertyAccessNaming() {
		JavaPropertyAccessNaming
	}
	
	override bindOutputConfigurator() {
		JavaGeneratorArtifactConfigurator
	}
	
}
