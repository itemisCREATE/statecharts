/**
 * Copyright (c) 2019 itemis AG - All rights Reserved
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * 
 * Contributors:
 * 	itemis AG
 * 
 */
package org.yakindu.sct.types.generator

import com.google.inject.Inject
import org.yakindu.base.types.Package
import org.yakindu.sct.generator.core.execution.AbstractGeneratorEntryExecutor
import org.yakindu.sct.generator.core.execution.IGeneratorEntryExecutor
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess
import org.yakindu.sct.model.sgen.GeneratorEntry

/** 
 * @author andreas muelder - Initial contribution and API
 */
class TypesGeneratorEntryExecutor extends AbstractGeneratorEntryExecutor implements IGeneratorEntryExecutor {
	@Inject ITypesGenerator generator

	override protected void execute(ISCTFileSystemAccess access, GeneratorEntry generatorEntry) {
		generator.generate(newArrayList(generatorEntry.getElementRef() as Package), access)
	}
}
