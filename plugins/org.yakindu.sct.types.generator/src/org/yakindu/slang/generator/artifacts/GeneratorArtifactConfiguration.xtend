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

import java.text.MessageFormat
import java.util.List
import java.util.Set
import org.eclipse.core.runtime.IPath
import org.eclipse.core.runtime.Path
import org.eclipse.emf.common.util.URI
import org.eclipse.xtend.lib.annotations.Accessors
import org.yakindu.base.types.Declaration
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess

/**
 * The container of a {@link Set&lt;{@link GeneratorArtifact}&lt;?&gt;&gt;. Also offers certain helper methods to 
 * obtain relative paths, URIs and so on. 
 * 
 */
class GeneratorArtifactConfiguration {
	
	static final String MSG_LOCATION_NOT_FOUND = "Artifact location for {0} not configured";
	
	@Accessors(PUBLIC_GETTER) protected ISCTFileSystemAccess fileSystemAccess
	@Accessors(PUBLIC_GETTER) protected Set<GeneratorArtifact<?>> generatorArtifacts = newHashSet
	
	new(ISCTFileSystemAccess fileSystemAccess) {
		this.fileSystemAccess = fileSystemAccess
	}
	
	def GeneratorArtifact<List<Declaration>> configure(String artifactName, String outputConfigName, List<Declaration> content, boolean skip) {
		val ga = new GeneratorArtifact(this, artifactName, outputConfigName, content, skip)
		generatorArtifacts.add(ga);
		ga
	}
	
	def GeneratorArtifact<CharSequence> configure(String artifactName, String outputConfigName, CharSequence content, boolean skip) {
		val ga = new GeneratorArtifact(this, artifactName, outputConfigName, content, skip)
		generatorArtifacts.add(ga);
		ga
	}
	
	def GeneratorArtifact<?> configure(String artifactName, String outputConfigName, Object content, boolean skip) {
		val ga = new GeneratorArtifact(this, artifactName, outputConfigName, content, skip)
		generatorArtifacts.add(ga);
		ga
	}
	
	def GeneratorArtifact<?> getConfiguration(String artifactName) {
		generatorArtifacts.findFirst[name == artifactName]
	}
	
	def void generateFile(GeneratorArtifact<?> artifact, CharSequence generatedContent) {
		if(artifact.outputConfiguration === null) {
			fileSystemAccess.generateFile(artifact.name, generatedContent)
		} else {
			fileSystemAccess.generateFile(artifact.name, artifact.outputConfiguration, generatedContent)
		}
	}
	
	def protected URI getOutputFolder(String artifactName) {
		getConfiguration(artifactName).outputFolder
	}

	def protected URI getURI(String artifactName) {
		getConfiguration(artifactName).URI
	}
	
	def protected URI getOutputFolder(GeneratorArtifact<?> artifact) {
		if(artifact !== null) {
			getURI("", artifact.outputConfiguration)
		} else {
			null			
		}
	}

	def protected URI getURI(GeneratorArtifact<?> artifact) {
		if(artifact !== null) {
			getURI(artifact.name, artifact.outputConfiguration)
		} else {
			null			
		}
	}
	
	def getURI(String path, String outputConfiguration) {
		if(outputConfiguration === null) {
			fileSystemAccess.getURI(path)
		} else {
			fileSystemAccess.getURI(path, outputConfiguration)
		}
	}

	/**
	 * @param target
	 *            either target artifact name or absolute target path which will
	 *            be transformed to a relative path based on
	 *            <code>fromArtifact</code> location
	 * @param fromArtifact
	 *            artifact name whose location is used as base for relative path
	 *            computation
	 * @return the relative path from <code>fromArtifact</code> to
	 *         <code>toTarget</code>
	 */
	def String relativeTo(GeneratorArtifact<?> target, GeneratorArtifact<?> fromArtifact) {
		val baseUri = getOutputFolder(fromArtifact);
		if (baseUri === null) {
			throw new IllegalArgumentException(MessageFormat.format(MSG_LOCATION_NOT_FOUND, fromArtifact));
		}

		val targetPath = new Path(target.name);
		if (targetPath.isAbsolute()) {
			return relativePath(target.name, relative(baseUri));
		}

		val URI absUri = getURI(target);
		if (absUri !== null) {
			return relativePath(relative(absUri), relative(baseUri));
		}
		throw new IllegalArgumentException(MessageFormat.format(MSG_LOCATION_NOT_FOUND, target));
	}

	def protected String relative(URI uri) {
		if (uri.isFile()) {
			return uri.toFileString();
		} else if (uri.isPlatform()) {
			return uri.toPlatformString(true);
		}
		throw new IllegalArgumentException("Unknown URI " + uri);
	}

	def protected String relativePath(String to, String from) {
		val IPath basePath = new Path(from);
		val IPath toPath = new Path(to);
		return toPath.makeRelativeTo(basePath).toOSString();
	}

	
}
