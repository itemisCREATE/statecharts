/**
 * Copyright (c) 2019 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 * 		committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.python.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.eclipse.core.resources.IFile;
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
import org.yakindu.sct.generator.core.execution.GeneratorExecutorLookup;
import org.yakindu.sct.generator.core.execution.IGeneratorEntryExecutor;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.name.Names;
import com.google.inject.util.Modules;

public class PythonTestHelper {

	private final Object owner;
	protected TestFileCopier copier;

	public PythonTestHelper(Object owner) {
		this.owner = owner;

		this.copier = new TestFileCopier((p, m) -> {
			p.create(m);
			return p;
		});
	}

	public void compile() {
		copyFilesFromBundleToFolder();
	}

	protected List<String> getFilesToCopy() {
		return new ArrayList<>(Arrays.asList(owner.getClass().getAnnotation(PythonTest.class).additionalFilesToCopy()));
	}

	private void copyFilesFromBundleToFolder() {
		IPath targetPath = getTargetPath();
		List<String> testDataFiles = getFilesToCopy();
		getTestDataFiles(testDataFiles);
		for (String file : testDataFiles) {
			IPath fileTargetPath = getTargetPathWithSubfolder(targetPath, file);
			copier.copyFileFromBundleToFolder(getTestBundle(), file, fileTargetPath);
		}
	}

	private IPath getTargetPathWithSubfolder(IPath targetPath, String file) {
		file = file.replace(targetPath.toString(), "");
		file = file.substring(0, file.lastIndexOf("/"));
		return targetPath.append(file);
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

	protected String getSgenFileName(String testProgram) {
		String sgenFileName = testProgram + ".sgen";
		return sgenFileName;
	}

	protected Statechart getStatechart() {
		IPath path = new Path(getTargetPath().toString() + "/" + getModelPath().lastSegment());
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(path);
		Resource resource = loadResource(file);
		return (Statechart) resource.getContents().get(0);
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

	protected Bundle getModelBundle() {
		String bundle = getStatechartBundleAnnotation();
		return Platform.getBundle(bundle);
	}

	protected void performFullBuild() {
		try {
			ResourcesPlugin.getWorkspace().build(IncrementalProjectBuilder.FULL_BUILD, null);
		} catch (CoreException e) {
			throw new RuntimeException(e);
		}
	}

	protected Resource loadResource(IFile file) {
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		Resource resource = new ResourceSetImpl().getResource(uri, true);
		return resource;
	}

	protected GeneratorModel getGeneratorModel(String sgenFileName) {
		IPath path = new Path(sgenFileName);
		Resource sgenResource = loadResource(getWorkspaceFileFor(path));
		GeneratorModel model = (GeneratorModel) sgenResource.getContents().get(0);
		return model;
	}

	protected IFile getWorkspaceFileFor(IPath filePath) {
		return ResourcesPlugin.getWorkspace().getRoot().getFile(getTargetProjectPath().append(filePath));
	}

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
		return owner.getClass().getAnnotation(PythonTest.class).sourceFile();
	}

	protected void getTestDataFiles(Collection<String> files) {
		files.add(getTestSourceFile());
	}

	protected String getTestProgram() {
		return owner.getClass().getAnnotation(PythonTest.class).program();
	}

	protected String getModelAnnotation() {
		return owner.getClass().getAnnotation(PythonTest.class).model();
	}

	protected String getTestBundleAnnotation() {
		return owner.getClass().getAnnotation(PythonTest.class).testBundle();
	}

	protected String getStatechartBundleAnnotation() {
		return owner.getClass().getAnnotation(PythonTest.class).statechartBundle();
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
