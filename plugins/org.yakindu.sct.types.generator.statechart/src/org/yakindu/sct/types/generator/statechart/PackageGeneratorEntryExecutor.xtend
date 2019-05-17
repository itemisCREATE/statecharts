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
package org.yakindu.sct.types.generator.statechart

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.types.Package
import org.yakindu.sct.generator.core.execution.AbstractGeneratorEntryExecutor
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess
import org.yakindu.sct.model.sequencer.ModelSequencer
import org.yakindu.sct.model.sgen.GeneratorEntry
import org.yakindu.sct.model.sgraph.Statechart
import org.yakindu.sct.types.generator.ITypesGenerator

class PackageGeneratorEntryExecutor extends AbstractGeneratorEntryExecutor {
	
	@Inject protected ModelSequencer sequencer
	@Inject protected ITypesGenerator generator
	
	override protected execute(ISCTFileSystemAccess access, GeneratorEntry generatorEntry) {
		generator.generate(createPackages(generatorEntry), access) 
	}
	
	def protected Collection<Package> createPackages(GeneratorEntry entry) {
		val elementRef = entry.elementRef
		if(elementRef instanceof Statechart) {
			newArrayList(sequencer.transform(elementRef, null))	
		} else {
			null
		}
	}
}
