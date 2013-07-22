package org.yakindu.sct.generator.core.impl;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.xtext.builder.EclipseResourceFileSystemAccess2;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.util.StringInputStream;

public class SimpleResourceFileSystemAccess extends EclipseResourceFileSystemAccess2 {

	
	public void generateFile(String fileName, String outputName, CharSequence contents) {

		OutputConfiguration outputConfig = getOutputConfig(outputName);
		
		IContainer container = getContainer(outputConfig);
		
		if ( !container.exists()) {
			if (outputConfig.isCreateOutputDirectory()) {
				try {
					createContainer(container);
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			} else {
				return;
			}
		}
		
		IFile file = getFile(fileName, outputName);
		CharSequence postProcessedContent = postProcess(fileName, outputName, contents);
		String contentsAsString = postProcessedContent.toString(); 
		if (file.exists()) {
			if (outputConfig.isOverrideExistingResources()) {
				try {
					StringInputStream newContent = getInputStream(contentsAsString, getEncoding(file));
					if (hasContentsChanged(file, newContent)) {
						newContent.reset();
						file.setContents(newContent, true, true, null);
						if (file.isDerived() != outputConfig.isSetDerivedProperty()) {
							setDerived(file, outputConfig.isSetDerivedProperty());
						}
					} 
				} catch (CoreException e) {
					throw new RuntimeException(e);
				}
			}
		} else {
			try {
				ensureParentExists(file);
				file.create(getInputStream(contentsAsString, getEncoding(file)), true, null);
				if (outputConfig.isSetDerivedProperty()) {
					setDerived(file, true);
				}
			} catch (CoreException e) {
				throw new RuntimeException(e);
			}
		}
	}
}
