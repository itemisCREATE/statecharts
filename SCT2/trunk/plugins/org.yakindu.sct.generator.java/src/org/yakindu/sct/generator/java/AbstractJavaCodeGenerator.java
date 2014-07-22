/**
 * Copyright (c) 2014 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.java;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.jdt.core.JavaCore;
import org.yakindu.sct.generator.core.features.ICoreFeatureConstants;
import org.yakindu.sct.generator.core.impl.GenericJavaBasedGenerator;
import org.yakindu.sct.generator.core.util.ClasspathChanger;
import org.yakindu.sct.generator.core.util.GeneratorUtils;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

abstract public class AbstractJavaCodeGenerator extends GenericJavaBasedGenerator {

	abstract public void generate(Statechart statechart, GeneratorEntry entry);

	private ClasspathChanger classpathChanger = new ClasspathChanger();

	@Override
	public final void runGenerator(Statechart statechart, GeneratorEntry entry) {

		IProject project = GeneratorUtils.getTargetProject(entry);

		if (hasJavaNature(project) && hasClasspath(project)) {
			IProject targetProject = GeneratorUtils.getTargetProject(entry);
			String targetFolderString = getTargetFolderString(entry);
			classpathChanger.addFolderToClassPath(targetProject, targetFolderString);
		}
		generate(statechart, entry);
	}

	public String getTargetFolderString(GeneratorEntry entry) {
		FeatureConfiguration outletConfig = entry.getFeatureConfiguration(ICoreFeatureConstants.OUTLET_FEATURE);
		String projectName = outletConfig.getParameterValue(ICoreFeatureConstants.OUTLET_FEATURE_TARGET_FOLDER)
				.getStringValue();
		return projectName;
	}

	public boolean hasJavaNature(IProject project) {
		Assert.isNotNull(project);
		Assert.isTrue(project.exists());
		try {
			String[] natures = project.getDescription().getNatureIds();
			for (String s : natures) {
				if (s.equals(JavaCore.NATURE_ID))
					return true;
			}
		} catch (CoreException e1) {
			e1.printStackTrace();
		}
		return false;
	}

	public boolean hasClasspath(IProject project) {
		return project.getFile(".classpath").exists();
	}
}
