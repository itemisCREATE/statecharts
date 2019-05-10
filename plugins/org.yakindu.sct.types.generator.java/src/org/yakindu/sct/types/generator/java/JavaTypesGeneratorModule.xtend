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
package org.yakindu.sct.types.generator.java

import org.yakindu.sct.types.generator.java.artifacts.DefaultJavaGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.java.modifications.NamingConventionModification
import org.yakindu.sct.types.generator.java.modifications.ReplaceIntegerWithLongModification
import org.yakindu.sct.types.generator.modification.library.AliasReplacementModification
import org.yakindu.sct.types.generator.modification.library.FlattenInnerTypesModification
import org.yakindu.sct.types.generator.modification.library.IdentifierModification
import org.yakindu.sct.types.generator.modification.library.TypesReplacementModification
import org.yakindu.sct.types.generator.module.TypesGeneratorModule

class JavaTypesGeneratorModule extends TypesGeneratorModule {
	
	override bindITypesGenerator() {
		JavaTypesGenerator
	}
	
	override getModifications() {
		#[
			// Java modifications
			NamingConventionModification,
			
			/**
			 * after NamingConventionModification to avoid underscores in names that would be keywords
			 */
			IdentifierModification,
			
			ReplaceIntegerWithLongModification, // restores API compatibility
			FlattenInnerTypesModification,
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
	
	override bindOutputConfigurator() {
		DefaultJavaGeneratorArtifactConfigurator
	}
	
}
