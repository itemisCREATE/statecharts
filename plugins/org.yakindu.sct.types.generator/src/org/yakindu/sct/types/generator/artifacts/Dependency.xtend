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
package org.yakindu.sct.types.generator.artifacts

import org.eclipse.xtend.lib.annotations.Accessors

abstract class Dependency<T> {
	@Accessors(PUBLIC_GETTER) GeneratorArtifact<?> owner
	@Accessors protected T dependency
	
	new(GeneratorArtifact<?> owner, T dependency) {
		this.owner = owner
		this.dependency = dependency
	}
	
	def static dispatch create(GeneratorArtifact<?> owner, GeneratorArtifact<?> dependency) {
		new ArtifactDependency(owner, dependency)
	}
	
	def static dispatch create(GeneratorArtifact<?> owner, CharSequence dependency) {
		new StaticDependency(owner, dependency)
	}
	
	/** Dependency to another GeneratorArtifact. */
	static class ArtifactDependency extends Dependency<GeneratorArtifact<?>> {
		new(GeneratorArtifact<?> owner, GeneratorArtifact<?> dependency) {
			super(owner, dependency)
		}
	}
	
	/** CharSequence based dependency, e.g. "string.h" or "java.lang.List" */
	static class StaticDependency extends Dependency<CharSequence> {
		new(GeneratorArtifact<?> owner, CharSequence dependency) {
			super(owner, dependency)
		}
	}
}
