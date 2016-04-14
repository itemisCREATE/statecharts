package org.yakindu.sct.generator.c;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;

public class ArtifactLocationProvider {

	private ISCTFileSystemAccess sctFsa;

	public static class Artifact {
		
		private String outputName;
		private String name;
		
		public Artifact(String name, String outputConfigName) {
			this.name = name;
			this.outputName = outputConfigName;
		}

		public String getName() {
			return name;
		}

		public String getOutputName() {
			return outputName;
		}
	}
	
	public ArtifactLocationProvider() {}
	
	public ArtifactLocationProvider(ISCTFileSystemAccess sctFsa) {
		this.sctFsa = sctFsa;
	}
	
	protected List<Artifact> generationArtifacts = new ArrayList<Artifact>();
	
	public void addArtifact(String artifactName, String outputConfigName) {
		generationArtifacts.add(new Artifact(artifactName, outputConfigName));
	}

	protected URI getURI(String artifactName) {
		for (Artifact artifact : generationArtifacts) {
			if (artifact.getName().equals(artifactName)) {
				return getURI(artifact);
			}
		}
		return null;
	}

	protected URI getURI(Artifact artifact) {
		if (sctFsa != null) {
			return sctFsa.getURI(artifact.getName(), artifact.getOutputName());
		}
		return null;
	}
	
	public String getRelativePath(String target, String baseArtifactName) {
		URI baseUri = getURI(baseArtifactName);
		if (baseUri == null) {
			// throw new IllegalArgumentException("Artifact location for "+baseArtifactName+" not configured");
			return target;
		}
		
		Path targetPath = new Path(target);
		if (targetPath.isAbsolute()) {
			return relativePath(target, baseUri.toFileString());
		}
		
		URI absUri = getURI(target);
		if (absUri != null) {
			return relativePath(absUri.toFileString(), baseUri.toFileString());
		}
		// throw new IllegalArgumentException("Artifact location for "+target+" not configured");
		return target;
	}
	
	protected String relativePath(String absolute, String base) {
		IPath basePath = new Path(base);
		IPath absPath = new Path(absolute);
		return absPath.makeRelativeTo(basePath).toOSString();
	}
}
