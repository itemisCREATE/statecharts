package org.yakindu.sct.generator.core;

import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.yakindu.sct.model.sgen.GeneratorEntry;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 *  @author oliver bohl
 * 
 */

public abstract class AbstractSGenGenerator implements ISCTGenerator {
	
	@Inject protected IWorkspaceRoot root;
	@Inject protected JavaIoFileSystemAccess fsa;
	@Inject protected Injector injector;

	protected abstract void generateContent(GeneratorEntry entry,
			JavaIoFileSystemAccess fsa, String targetProjectPath);

	public void generate(GeneratorEntry entry) {
		// Does actually nothing
		// generateInternal(entry);
	}



//	private void generateInternal(GeneratorEntry entry) {
//
//
//		 String targetProject = GeneratorUtils.getTargetProject(entry).toString();
//		 targetProject = targetProject.substring(1);
//		
//		 IProject targetProjectRoot = root.getProject(targetProject);
//		
//		 if(targetProjectRoot.exists() && targetProjectRoot.isOpen()){
//		 String targetFolder =
//		 GeneratorUtils.getTargetFolder(entry).toString();
//		 fsa.setOutputPath(IFileSystemAccess.DEFAULT_OUTPUT, targetFolder);
//		
//		 String targetProjectPath = targetProject.replaceAll("\\.", "/");
//		 generateContent(entry, fsa, targetProjectPath);
//		 }
//	}

}
