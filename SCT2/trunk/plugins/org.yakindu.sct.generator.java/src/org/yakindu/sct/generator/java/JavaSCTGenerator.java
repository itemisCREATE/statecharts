/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.java;

import static org.yakindu.sct.generator.core.features.ICoreFeatureConstants.OUTLET_FEATURE_TARGET_FOLDER;
import static org.yakindu.sct.generator.core.util.GeneratorUtils.getOutletFeatureConfiguration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFolder;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IProjectDescription;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.jdt.core.IClasspathEntry;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.launching.JavaRuntime;
import org.eclipse.xpand2.output.JavaBeautifier;
import org.eclipse.xpand2.output.PostProcessor;
import org.yakindu.sct.generator.core.ISCTGenerator;
import org.yakindu.sct.generator.core.impl.AbstractXpandBasedCodeGenerator;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

/**
 * Implementation of {@link ISCTGenerator} interface registered via extension
 * point
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class JavaSCTGenerator extends AbstractXpandBasedCodeGenerator {

	@Override
	public String getTemplatePath() {
		return "org::yakindu::sct::generator::java::templates::Main::main";
	}

	/**
	 * For Java Generators, we want to create a Project with Java Nature and add
	 * the target folder to the classpath
	 */
	protected void createProject(IProject project, GeneratorEntry entry) {
		super.createProject(project, entry);

		FeatureConfiguration outletConfig = getOutletFeatureConfiguration(entry);
		FeatureParameterValue targetFolder = outletConfig
				.getParameterValue(OUTLET_FEATURE_TARGET_FOLDER);

		try {
			IProjectDescription description = project.getDescription();
			description.setNatureIds(new String[] { JavaCore.NATURE_ID });
			project.setDescription(description, new NullProgressMonitor());
			IJavaProject javaProject = JavaCore.create(project);
			// Create bin folder
			IFolder binDir = project.getFolder("bin");
			IPath binPath = binDir.getFullPath();
			javaProject.setOutputLocation(binPath, null);
			// Set up classpath with default JRE runtime and the target folder
			javaProject.setRawClasspath(
					getClasspathEntries(project.getName(),
							targetFolder.getStringValue()), null);
		} catch (CoreException ex) {
			ex.printStackTrace();
		}
	}

	protected IClasspathEntry[] getClasspathEntries(String projectName,
			String targetFolder) {
		List<IClasspathEntry> entries = new ArrayList<IClasspathEntry>();
		entries.add(JavaRuntime.getDefaultJREContainerEntry());
		IPath sourceFolderPath = new Path(projectName).makeAbsolute().append(
				targetFolder);
		entries.add(JavaCore.newSourceEntry(sourceFolderPath));
		return entries.toArray(new IClasspathEntry[] {});
	}
	
	@Override
	protected Set<PostProcessor> getPostProcessors() {
		Set<PostProcessor> set = new HashSet<PostProcessor>();
		set.add(new JavaBeautifier());
		return set;
	}

}
