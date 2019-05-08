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
package org.yakindu.slang.generator

import com.google.inject.Inject
import java.util.Collection
import org.yakindu.base.types.Package
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess
import org.yakindu.slang.generator.artifacts.GeneratorArtifact
import org.yakindu.slang.generator.artifacts.IGeneratorArtifactConfigurator
import org.yakindu.slang.generator.modification.ModificationExecutor

/**
 * The base implementation of {@link ISlangGenerator}.
 * An instance of this class should be obtained via injection (see {@link SlangGeneratorModule}), because it needs a
 * {@link ModificationExecutor} and a {@link IGeneratorArtifactConfigurator} to adapt the model contents
 * and to decide where the actual files should go.
 */
abstract class AbstractSlangGenerator implements ISlangGenerator {
	@Inject protected ModificationExecutor modificationExecutor
	@Inject protected IGeneratorArtifactConfigurator configurator
	
	override final generate(Collection<Package> packages, ISCTFileSystemAccess fileSystemAccess) {
		modificationExecutor.modify(packages)
		val artifactConfiguration = configurator.configure(packages, fileSystemAccess)
		artifactConfiguration.generatorArtifacts.filter[isNotEmpty].forEach[
			generate
		]
	}
	
	def protected void generate(GeneratorArtifact<?> artifact);
	
}
