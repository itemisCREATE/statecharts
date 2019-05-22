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
import org.yakindu.sct.types.generator.c.modifications.ExtractConstantsModification
import org.yakindu.sct.types.generator.c.modifications.ExtractForLoopInitializers
import org.yakindu.sct.types.generator.c.modifications.ExtractOperationsModification
import org.yakindu.sct.types.generator.c.modifications.FlattenComplexTypesModification
import org.yakindu.sct.types.generator.c.modifications.RemoveInitialValueModification
import org.yakindu.sct.types.generator.c.modifications.RenameComplexTypes
import org.yakindu.sct.types.generator.c.modifications.RenameOperationsModification
import org.yakindu.sct.types.generator.c.modifications.RenamePackageModification
import org.yakindu.sct.types.generator.c.modifications.RenameStateEnumModification
import org.yakindu.sct.types.generator.c.modifications.ReorderComplexTypesModification
import org.yakindu.sct.types.generator.c.naming.CEventNaming
import org.yakindu.sct.types.generator.modification.library.AliasReplacementModification
import org.yakindu.sct.types.generator.modification.library.IdentifierModification
import org.yakindu.sct.types.generator.modification.library.RemoveAnnotationTypeModification
import org.yakindu.sct.types.generator.modification.library.RemoveUnusedTypesModification
import org.yakindu.sct.types.generator.modification.library.TypesReplacementModification
import org.yakindu.sct.types.generator.modification.library.event.InEventModification
import org.yakindu.sct.types.generator.modification.library.event.LocalEventModification
import org.yakindu.sct.types.generator.modification.library.event.OutEventModification
import org.yakindu.sct.types.generator.module.TypesGeneratorModule

class CTypesGeneratorModule extends TypesGeneratorModule {

	override bindITypesGenerator() {
		CTypesGenerator
	}

	override getModifications() {
		return #[
			// base modifications
			IdentifierModification,
			InEventModification,
			OutEventModification,
			LocalEventModification,
			// c specific modifcations
			RemoveInitialValueModification,
			FlattenComplexTypesModification,
			ExtractOperationsModification,
			ExtractConstantsModification,
			RemoveAnnotationTypeModification,
			RenameOperationsModification,
			RemoveUnusedTypesModification,
			RenamePackageModification,
			ReorderComplexTypesModification,
			RenameComplexTypes,
			RenameStateEnumModification,
			AliasReplacementModification,
			// base modification
			TypesReplacementModification,
			ExtractForLoopInitializers
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
	
	override bindEventNaming() {
		CEventNaming
	}

}
