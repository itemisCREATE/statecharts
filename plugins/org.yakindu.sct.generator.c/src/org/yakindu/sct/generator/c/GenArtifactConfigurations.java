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

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;

/**
 * 
 * @author thomas kutz - Initial API and contribution
 *
 */
public class GenArtifactConfigurations implements IGenArtifactConfigurations {

	private static final String MSG_FSA_NOT_CONFIGURED = "File system access needs to be configured before artifact locations can be computed.";
	private static final String MSG_LOCATION_NOT_FOUND = "Artifact location for {0} not configured";
	private ISCTFileSystemAccess sctFsa;

	public static class GenArtifactConfiguration {
		
		private String outputName;
		private String name;
		private IContentTemplate contentTemplate;
		
		public GenArtifactConfiguration(String name, String outputConfigName, IContentTemplate contentTemplate) {
			this.name = name;
			this.outputName = outputConfigName;
			this.contentTemplate = contentTemplate;
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
	}
	
	/**
	 * Default instance which does not compute any relative paths and hence does not need to be configured in any way.
	 * This is useful when an API needs to be served but relative path computation is not relevant.
	 */
	public static final IGenArtifactConfigurations DEFAULT = new GenArtifactConfigurations() {
		/**
		 * As default behavior, this will always return the target path/artifact instead of a relative path.
		 */
		public String relativeTo(String target, String fromArtifact) {
			return target;
		};
	};
	
	@Override
	public void setFileSystemAccess(ISCTFileSystemAccess sctFsa) {
		this.sctFsa = sctFsa;
	}
	
	protected List<GenArtifactConfiguration> generationArtifacts = new ArrayList<GenArtifactConfiguration>();
	
	@Override
	public List<GenArtifactConfiguration> getConfigurations() {
		return generationArtifacts;
	}
	
	@Override
	public void configure(String artifactName, String outputConfigName, IContentTemplate contentTemplate) {
		generationArtifacts.add(new GenArtifactConfiguration(artifactName, outputConfigName, contentTemplate));
	}

	protected URI getOutputFolder(String artifactName) {
		checkFSA();
		for (GenArtifactConfiguration artifact : generationArtifacts) {
			if (artifact.getName().equals(artifactName)) {
				return sctFsa.getURI("", artifact.getOutputName());
			}
		}
		return null;
	}
	
	protected URI getURI(String artifactName) {
		checkFSA();
		for (GenArtifactConfiguration artifact : generationArtifacts) {
			if (artifact.getName().equals(artifactName)) {
				return sctFsa.getURI(artifact.getName(), artifact.getOutputName());
			}
		}
		return null;
	}

	private void checkFSA() {
		if (sctFsa == null)
			throw new IllegalStateException(MSG_FSA_NOT_CONFIGURED);
	}
	
	/**
	 * @param target either target artifact name or absolute target path which will be transformed to a relative path based on <code>fromArtifact</code> location
	 * @param fromArtifact artifact name whose location is used as base for relative path computation
	 * @return the relative path from <code>fromArtifact</code> to <code>toTarget</code>
	 */
	@Override
	public String relativeTo(String target, String fromArtifact) {
		URI baseUri = getOutputFolder(fromArtifact);
		if (baseUri == null) {
			throw new IllegalArgumentException(MessageFormat.format(MSG_LOCATION_NOT_FOUND, fromArtifact));
		}
		
		Path targetPath = new Path(target);
		if (targetPath.isAbsolute()) {
			return relativePath(target, relative(baseUri));
		}
		
		URI absUri = getURI(target);
		if (absUri != null) {
			return relativePath(relative(absUri), relative(baseUri));
		}
		throw new IllegalArgumentException(MessageFormat.format(MSG_LOCATION_NOT_FOUND, target));
	}
	
	protected String relative(URI uri){
		if(uri.isFile()){
			return uri.toFileString();
		}
		else if(uri.isPlatform()){
			return uri.toPlatformString(true);
		}
		throw new IllegalArgumentException("Unknown URI " + uri);
	}
	
	protected String relativePath(String to, String from) {
		IPath basePath = new Path(from);
		IPath toPath = new Path(to);
		return toPath.makeRelativeTo(basePath).toOSString();
	}

}
