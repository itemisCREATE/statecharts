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

import org.yakindu.sct.types.generator.c.artifacts.DefaultCGeneratorArtifactConfigurator
import org.yakindu.sct.types.generator.c.modifications.ExtractOperationsModification
import org.yakindu.sct.types.generator.c.modifications.FlattenComplexTypesModification
import org.yakindu.sct.types.generator.c.modifications.RemoveUnusedTypesModification
import org.yakindu.sct.types.generator.c.modifications.RenameComplexTypes
import org.yakindu.sct.types.generator.c.modifications.RenameOperationsModification
import org.yakindu.sct.types.generator.c.modifications.RenamePackageModification
import org.yakindu.sct.types.generator.c.modifications.RenameStateEnumModification
import org.yakindu.sct.types.generator.c.modifications.ReorderComplexTypesModification
import org.yakindu.sct.types.generator.modification.library.IdentifierModification
import org.yakindu.sct.types.generator.modification.library.RemoveAnnotationTypeModification
import org.yakindu.sct.types.generator.modification.library.TypesReplacementModification
import org.yakindu.sct.types.generator.module.TypesGeneratorModule
import org.yakindu.sct.types.generator.c.modifications.ExtractConstantsModification

class CTypesGeneratorModule extends TypesGeneratorModule {

	override bindITypesGenerator() {
		CTypesGenerator
	}
	
	override getModifications() {
		return #[
			// base modifications
			IdentifierModification,
			
			// c specific modifcations
			FlattenComplexTypesModification,
			ExtractOperationsModification,
			ExtractConstantsModification,
			RemoveAnnotationTypeModification,
			RemoveUnusedTypesModification,
			RenamePackageModification,
			RenameOperationsModification,
			ReorderComplexTypesModification,
			RenameComplexTypes,
			RenameStateEnumModification,
			
			// base modification
			TypesReplacementModification
			
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
