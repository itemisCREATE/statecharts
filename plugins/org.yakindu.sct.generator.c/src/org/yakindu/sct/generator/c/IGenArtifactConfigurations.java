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

import com.google.inject.ImplementedBy;

/**
 * Holds the configuration of generation artifacts. A configuration comprises
 * the artifact's name, its output configuration name and a template defining
 * the artifact's contents.
 * 
 * @author thomas kutz - Initial API and contribution
 *
 */
@ImplementedBy(DefaultGenArtifactConfigurations.class)
public interface IGenArtifactConfigurations {

	/**
	 * Adds a configuration for a generation artifact.
	 */
	void configure(String artifactName, String outputConfigName, IContentTemplate contentTemplate);

	/**
	 * Adds a configuration for a generation artifact.
	 */
	void configure(String artifactName, String outputConfigName, IContentTemplate contentTemplate, boolean skip);

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

	public static class GenArtifactConfiguration {

		private String outputName;
		private String name;
		private IContentTemplate contentTemplate;
		
		private boolean skip;

		public GenArtifactConfiguration(String name, String outputConfigName, IContentTemplate contentTemplate, boolean skip) {
			this.name = name;
			this.outputName = outputConfigName;
			this.contentTemplate = contentTemplate;
			this.skip = skip;
		}

		public String getName() {
			return name;
		}

		public String getOutputName() {
			return outputName;
		}

		public IContentTemplate getContentTemplate() {
			return contentTemplate;
		}
		
		public boolean getSkip() {
			return skip;
		}
	}

}
