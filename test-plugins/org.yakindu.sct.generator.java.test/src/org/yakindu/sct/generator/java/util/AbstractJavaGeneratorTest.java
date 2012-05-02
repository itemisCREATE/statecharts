/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.tools.Diagnostic;
import javax.tools.DiagnosticCollector;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileObject;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.junit.Assert;
import org.junit.Before;
import org.yakindu.sct.generator.core.util.GeneratorUtils;
import org.yakindu.sct.generator.java.JavaSCTGenerator;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.SGenFactory;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractJavaGeneratorTest {

	private static final String SRC_GEN = "src-gen";
	private static final String TARGET_PROJECT = "targetProject";
	private static final String CONTENT_TYPE = "statechart";
	private static final String OUTLET_FEATURE = "Outlet";
	private static final String TARGET_FOLDER = "targetFolder";

	@Inject
	protected JavaSCTGenerator generator;
	private JavaCompiler compiler;

	@Before
	public void setup() {
		compiler = ToolProvider.getSystemJavaCompiler();
	}

	public List<Diagnostic<? extends JavaFileObject>> generateAndCompile(
			Statechart statechart) throws Exception {
		Assert.assertNotNull("No JDK 1.06 found", compiler);
		GeneratorEntry entry = createGeneratorEntry("JavaGeneratorProject",
				SRC_GEN);
		entry.setElementRef(statechart);
		IProject targetProject = GeneratorUtils.getTargetProject(entry);
		targetProject.delete(true, new NullProgressMonitor());
		generator.generate(entry);
		IFolder folder = targetProject.getFolder(SRC_GEN);
		Iterable<File> javaSourceFiles = getJavaSourceFiles(folder);
		return compile(javaSourceFiles);
	}

	private List<Diagnostic<? extends JavaFileObject>> compile(
			Iterable<File> ioFiles) throws IOException {
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(
				null, null, null);
		try {
			Iterable<? extends JavaFileObject> compilationUnits = fileManager
					.getJavaFileObjectsFromFiles(ioFiles);
			DiagnosticCollector<JavaFileObject> diagnostics = new DiagnosticCollector<JavaFileObject>();
			compiler.getTask(null, fileManager, diagnostics, null, null,
					compilationUnits).call();
			return diagnostics.getDiagnostics();
		} finally {
			fileManager.close();
		}
	}

	private GeneratorEntry createGeneratorEntry(String targetProject,
			String targetFolder) {
		GeneratorEntry entry = SGenFactory.eINSTANCE.createGeneratorEntry();
		entry.setContentType(CONTENT_TYPE);
		FeatureConfiguration config = SGenFactory.eINSTANCE
				.createFeatureConfiguration();
		FeatureType type = SGenFactory.eINSTANCE.createFeatureType();
		type.setName(OUTLET_FEATURE);
		config.setType(type);
		FeatureParameterValue project = SGenFactory.eINSTANCE
				.createFeatureParameterValue();
		FeatureParameter projectParameter = SGenFactory.eINSTANCE
				.createFeatureParameter();
		projectParameter.setName(TARGET_PROJECT);
		project.setParameter(projectParameter);
		project.setValue(targetProject);
		config.getParameterValues().add(project);
		FeatureParameterValue targetFolderValue = SGenFactory.eINSTANCE
				.createFeatureParameterValue();
		FeatureParameter targetParameter = SGenFactory.eINSTANCE
				.createFeatureParameter();
		targetParameter.setName(TARGET_FOLDER);
		targetFolderValue.setParameter(targetParameter);
		targetFolderValue.setValue(targetFolder);
		config.getParameterValues().add(targetFolderValue);
		entry.getFeatures().add(config);
		return entry;
	}

	private Iterable<File> getJavaSourceFiles(IResource folder)
			throws CoreException {
		List<IFile> files = new ArrayList<IFile>();
		getFilesToCompile(folder, files);
		List<File> ioFiles = new ArrayList<File>();
		for (IFile iFile : files) {
			ioFiles.add(iFile.getRawLocation().makeAbsolute().toFile());
		}
		return ioFiles;
	}

	private void getFilesToCompile(IResource resource, List<IFile> toAdd)
			throws CoreException {
		if (resource instanceof IFolder) {
			IResource[] members = ((IFolder) resource).members();
			for (IResource iResource : members) {
				getFilesToCompile(iResource, toAdd);
			}
		} else if (resource instanceof IFile) {
			if (resource.getFileExtension().equals("java")) {
				toAdd.add((IFile) resource);
			}
		}
	}

}
