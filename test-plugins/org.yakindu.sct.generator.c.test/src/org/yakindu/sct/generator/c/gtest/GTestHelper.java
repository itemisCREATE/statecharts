/****************************************************************************
 * Copyright (c) 2008, 2012 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation
 ****************************************************************************/

package org.yakindu.sct.generator.c.gtest;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.yakindu.sct.generator.builder.EclipseContextGeneratorExecutorLookup;
import org.yakindu.sct.generator.c.test.utils.TestFileCopier;
import org.yakindu.sct.generator.core.execution.GeneratorExecutorLookup;
import org.yakindu.sct.generator.core.execution.IGeneratorEntryExecutor;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.inject.util.Modules;

/**
 * @author Andreas Unger - Initial contribution and API
 * @author Markus Mühlbrandt
 *
 */
public class GTestHelper {
	
	/**
	 * @author rbeckmann
	 *
	 */
	public enum Compiler {
		GCC("gcc"), GPLUSPLUS("g++");
		
		protected String command;
		
		Compiler(String command) {
			this.command = command;
		}
		
		public String getCommand() {
			return this.command;
		}
	}
	
	private final Object owner;
	protected Compiler compiler;
	protected TestFileCopier copier;
	
	public GTestHelper(Object owner) {
		this(owner, Compiler.GCC);
	}
	
	public GTestHelper(Object owner, Compiler compiler) {
		this.owner = owner;
		this.compiler = compiler;

		this.copier = new TestFileCopier((p, m) -> {
			p.create(m);
			return p;
		});
	}
	
	public void compile() {
		copyFilesFromBundleToFolder();
		IResource resource = ResourcesPlugin.getWorkspace().getRoot().findMember(getTargetPath());
		File directory = resource.getLocation().toFile();
		List<String> command = createCommand();
		
		long t0 = System.currentTimeMillis();
		getCommandExecutor().execute(command, directory, false);
		long t1 = System.currentTimeMillis();
		System.out.println("Compiling " + directory.getName() + " took " + (t1 - t0) + "ms");
	}
	
	public void generate() {
		IPath targetPath = getTargetPath();
		
		// copy model to JUnit workspace
		copier.copyFileFromBundleToFolder(getModelBundle(), getModelPath(), targetPath);
		
		String sgenFileName = getSgenFileName(getTestProgram());
		copier.copyFileFromBundleToFolder(getTestBundle(), sgenFileName, targetPath);
		
		GeneratorModel model = getGeneratorModel(sgenFileName);
		model.getEntries().get(0).setElementRef(getStatechart());
		
		performFullBuild();
		
		getGeneratorExecutorLookup().execute(model);
	}
	
	protected GeneratorModel getGeneratorModel(String sgenFileName) {
		IPath path = new Path(sgenFileName);
		Resource sgenResource = loadResource(getWorkspaceFileFor(path));
		GeneratorModel model = (GeneratorModel) sgenResource.getContents().get(0);
		return model;
	}
	
	protected List<String> getFilesToCopy() {
		return new ArrayList<>(
				Arrays.asList(owner.getClass().getAnnotation(GTest.class).additionalFilesToCopy()));
	}
	
	protected List<String> getFilesToCompile() {
		return new ArrayList<>(
				Arrays.asList(owner.getClass().getAnnotation(GTest.class).additionalFilesToCompile()));
	}
	
	protected GeneratorExecutorLookup getGeneratorExecutorLookup() {
		return new EclipseContextGeneratorExecutorLookup() {
			@Override
			protected Module getContextModule() {
				return Modules.override(super.getContextModule()).with(new Module() {
					@Override
					public void configure(Binder binder) {
						binder.bind(boolean.class).annotatedWith(Names.named(IGeneratorEntryExecutor.SKIP_VALIDATION))
								.toInstance(true);
					}
				});
			}
		};
	}
	
	protected String getSgenFileName(String testProgram) {
		String sgenFileName = testProgram + ".sgen";
		return sgenFileName;
	}
	
	protected GCCCommandExecutor getCommandExecutor() {
		return new GCCCommandExecutor();
	}
	
	protected void performFullBuild() {
		try {
			ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD, null);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}
	
	protected IFile getWorkspaceFileFor(IPath filePath) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getTargetProjectPath().append(filePath));
	}
	
	protected Statechart getStatechart() {
		IPath path = new Path(getTargetPath().toString() + "/" + getModelPath().lastSegment());
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		Resource resource = loadResource(file);
		return (Statechart) resource.getContents().get(0);
	}
	
	protected Resource loadResource(IFile file) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Resource resource = new ResourceSetImpl().getResource(uri, true);
		return resource;
	}
	
	protected Bundle getModelBundle() {
		String bundle = getStatechartBundleAnnotation();
		return Platform.getBundle(bundle);
	}
	
	private void copyFilesFromBundleToFolder() {
		IPath targetPath = getTargetPath();
		List<String> testDataFiles = getFilesToCopy();
		getTestDataFiles(testDataFiles);
		for (String file : testDataFiles) {
			copier.copyFileFromBundleToFolder(getTestBundle(), file, targetPath);
		}
	}
	
	protected List<String> createCommand() {
		String gTestDirectory = getGTestDirectory();
		
		List<String> includes = new ArrayList<>();
		getIncludes(includes);
		
		List<String> sourceFiles = getFilesToCompile();
		getSourceFiles(sourceFiles);

		File targetPath = ResourcesPlugin.getWorkspace().getRoot().findMember(getTargetPath()).getLocation().toFile();

		 CompileGTestCommand gTestCommand = new CompileGTestCommand()
				.compiler(getCompilerCommand())
				.program(getFileName(getTestProgram()))
				.includes(includes)
				.sources(sourceFiles)
				.directory(gTestDirectory)
				//.makefileDir(targetPath.toString())
				.mainLib(getMainLib())
				//.wPedantic()
			 	.wAll()				
			 	.wExtra()
			 	.wError()
			 	.wConversion();
		 if(compiler == Compiler.GCC) {
			 gTestCommand.wnoUnusedParameter(); // ignore unused parameter flag
			 gTestCommand.wnoUnusedFunction(); // ignore unused functions flag
		 }
		return gTestCommand.build();
	}
	
	/**
	 * @return
	 */
	protected String getCompilerCommand() {
		return this.compiler.getCommand();
	}
	
	protected String getMainLib() {
		return "gtest_main";
	}
	
	/**
	 * @return
	 */
	static public String getGTestDirectory() {
		String gTestDirectory = System.getenv("GTEST_DIR");
		return gTestDirectory;
	}
	
	protected String getFileName(String path) {
		return new Path(path).lastSegment();
	}
	
	protected IPath getTargetPath() {
		return getTargetProjectPath().append(new Path(getTestProgram()).removeLastSegments(1));
	}
	
	protected IPath getModelPath() {
		return new Path(getModelAnnotation());
	}
	
	protected void getIncludes(Collection<String> includes) {
	}
	
	protected void getSourceFiles(Collection<String> files) {
		files.add(getFileName(getTestSourceFile()));
	}
	
	protected String getTestSourceFile() {
		return owner.getClass().getAnnotation(GTest.class).sourceFile();
	}
	
	protected void getTestDataFiles(Collection<String> files) {
		files.add(getTestSourceFile());
	}
	
	protected String getTestProgram() {
		return owner.getClass().getAnnotation(GTest.class).program();
	}
	
	protected String getModelAnnotation() {
		return owner.getClass().getAnnotation(GTest.class).model();
	}
	
	protected String getTestBundleAnnotation() {
		return owner.getClass().getAnnotation(GTest.class).testBundle();
	}
	
	protected String getStatechartBundleAnnotation() {
		return owner.getClass().getAnnotation(GTest.class).statechartBundle();
	}
	
	protected IPath getTargetProjectPath() {
		return new Path(getTestBundleAnnotation());
	}

	
	protected Bundle getTestBundle() {
		Bundle bundle = getAnnotatedTestBundle();
		if (bundle == null) {
			return FrameworkUtil.getBundle(owner.getClass());
		}
		return bundle;
	}
	
	protected Bundle getAnnotatedTestBundle() {
		String testProject = getTestBundleAnnotation();
		if (!testProject.isEmpty()) {
			Bundle testBundle = Platform.getBundle(testProject);
			if (testBundle != null) {
				return testBundle;
			}
		}
		return null;
	}
	

	
}
