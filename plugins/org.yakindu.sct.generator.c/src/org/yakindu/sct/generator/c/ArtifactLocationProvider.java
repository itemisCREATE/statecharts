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
	
	public ArtifactLocationProvider(ISCTFileSystemAccess sctFsa) {
		this.sctFsa = sctFsa;
	}
	
	protected List<Artifact> generationArtifacts = new ArrayList<Artifact>();
	
	public void addArtifact(String artifactName, String outputConfigName) {
		generationArtifacts.add(new Artifact(artifactName, outputConfigName));
	}

	protected URI getURIForArtifcat(String artifactName) {
		for (Artifact artifact : generationArtifacts) {
			if (artifact.getName().equals(artifactName)) {
				return sctFsa.getURI(artifact.getName(), artifact.getOutputName());
			}
		}
		return null;
	}
	
	public String computeRelativeForPath(String absolutePath, String baseArtifactName) {
		URI baseTarget = getURIForArtifcat(baseArtifactName);
		
		IPath basePath = new Path(baseTarget.toFileString());
		IPath absPath = new Path(absolutePath);
		return absPath.makeRelativeTo(basePath).toOSString();
	}
	
	public String computeRelativeForName(String referencedArtifactName, String baseArtifactName) {
		URI baseUri = getURIForArtifcat(baseArtifactName);
		URI absUri = getURIForArtifcat(referencedArtifactName);
		
		IPath basePath = new Path(baseUri.toFileString());
		IPath absPath = new Path(absUri.toFileString());
		return absPath.makeRelativeTo(basePath).toOSString();
	}
}
