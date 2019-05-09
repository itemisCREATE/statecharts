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
package org.yakindu.slang.generator.artifacts

import java.util.List
import org.eclipse.xtend.lib.annotations.Accessors
import org.eclipse.xtext.generator.IFileSystemAccess

/**
 * A single artifact the generator should produce. Will usually become a file.
 * Holds generic content - can be a List&lt;Declaration&gt; or directly a CharSequence that should be copied to the file directly.
 * The handling of the content is the responsibility of the generator.
 */
class GeneratorArtifact<T> {
	/** The name of the artifact - usually the name of the resulting file. */
	@Accessors protected String name;
	/** The output configuration name to be used in the {@link IFileSystemAccess}. */
	@Accessors protected String outputConfiguration;
	/** A list of generic dependencies. Handling this is the generator's responsibility. */
	@Accessors protected List<Dependency<?>> dependencies = newArrayList;
	/** The actual content that should go into the artifact. */
	@Accessors protected T content;
	/** Whether to skip generating this artifact. */
	@Accessors protected boolean skip;
	/** The parent {@link GeneratorArtifactConfiguration} that owns this artifact. */
	@Accessors(PUBLIC_GETTER) protected GeneratorArtifactConfiguration generatorConfiguration;
	
	/** Create an artifact with no output configuration and skip=false. */
	new(GeneratorArtifactConfiguration parent, String name, T content) {
		this(parent, name, null, content)
	}
	
	/** Create an artifact with skip=false. */
	new(GeneratorArtifactConfiguration parent, String name, String outputConfiguration, T content) {
		this(parent, name, outputConfiguration, content, false)
	}
	
	new(GeneratorArtifactConfiguration parent, String name, String outputConfiguration, T content, boolean skip) {
		this.generatorConfiguration = parent;
		this.name = name
		this.outputConfiguration = outputConfiguration
		this.content = content
		this.skip = false
	}
	
	def dispatch void addDependency(CharSequence it) {
		this.dependencies.add(Dependency.create(this, it))
	}
	
	def dispatch void addDependency(GeneratorArtifact<?> it) {
		this.dependencies.add(Dependency.create(this, it))
	}
	
	def void addDependencies(Object... dependencies) {
		dependencies.forEach[this.addDependency(it)]
	}
	
	def isNotEmpty() {
		content.isNotEmpty
	}
	
	def protected dispatch isNotEmpty(Void it) {
		false
	}
	
	def protected dispatch isNotEmpty(Object it) {
		true
	}
	
	def protected dispatch isNotEmpty(Iterable<?> it) {
		!it.empty
	}
	
	def protected dispatch isNotEmpty(CharSequence it) {
		!toString.nullOrEmpty
	}
}
