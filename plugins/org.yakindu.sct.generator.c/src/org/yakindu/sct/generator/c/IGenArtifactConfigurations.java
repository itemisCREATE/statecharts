/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.c;

import java.util.List;

import org.yakindu.sct.generator.c.GenArtifactConfigurations.GenArtifactConfiguration;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;

/**
 * Holds the configuration of generation artifacts. A configuration comprises
 * the artifact's name, its output configuration name and a template defining
 * the artifact's contents.
 * 
 * @author thomas kutz - Initial API and contribution
 *
 */
public interface IGenArtifactConfigurations {

	/**
	 * Used as key in Guice to mark a default configuration instance
	 */
	String DEFAULT = "DefaultGenArtifactConfigurations";

	/**
	 * A file system access is needed to define the target location of a
	 * generation artifact. Without this, relative paths via
	 * {@link getRelativePath(String, String)} will not work.
	 */
	void setFileSystemAccess(ISCTFileSystemAccess sctFsa);

	/**
	 * Adds a configuration for a generation artifact.
	 */
	void configure(String artifactName, String outputConfigName, IContentTemplate contentTemplate);

	/**
	 * @return all stored configurations
	 */
	List<GenArtifactConfiguration> getConfigurations();

	/**
	 * Computes the relative path from a base artifact to a target which can be
	 * an artifact name or an absolute path. For the former case, the artifact
	 * configuration needs to be stored beforehand.
	 */
	String relativeTo(String target, String fromArtifact);

}
