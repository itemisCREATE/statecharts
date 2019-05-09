/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.types.generator.c

import org.yakindu.sct.types.generator.TypesGeneratorModule
import org.yakindu.sct.types.generator.c.artifacts.DefaultCGeneratorArtifactConfigurator

class CTypesGeneratorModule extends TypesGeneratorModule {

	override bindISlangGenerator() {
		CTypesGenerator
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
//			// c specific modifcations
//			FlattenComplexTypesModification,
//			RenameInterfacesModification,
//			ExtractOperationsModification,
//			RemoveAnnotationTypeModification,
//			RemoveUnusedTypesModification,
//			NextStateIndexModification,
//			RenamePackageModification,
//			RenameOperationsModification,
//			ReorderComplexTypesModification,
//			RenameComplexTypes,
//			RenameStateEnumModification,
//			
//			// base modification
//			TypesReplacementModification
			
		]
	}
	
	override bindExpressions() {
		CExpressions
	}
	
	override bindTargetPlatform() {
		CTargetPlatform
	}
	
	override bindOutputConfigurator() {
		DefaultCGeneratorArtifactConfigurator
	}
	
}
