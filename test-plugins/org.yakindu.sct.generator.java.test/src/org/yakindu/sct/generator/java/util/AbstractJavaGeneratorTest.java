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

import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.jdt.core.IJavaModelMarker;
import org.yakindu.sct.generator.core.util.GeneratorUtils;
import org.yakindu.sct.generator.java.JavaCodeGenerator;
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
	protected JavaCodeGenerator generator;

	public IMarker[] generateAndCompile(Statechart statechart) throws Exception {
		GeneratorEntry entry = createGeneratorEntry(statechart.getName(),
				SRC_GEN);
		entry.setElementRef(statechart);
		IProject targetProject = GeneratorUtils.getTargetProject(entry);
		targetProject.delete(true, new NullProgressMonitor());
		generator.generate(entry);
		targetProject.getWorkspace().build(
				IncrementalProjectBuilder.INCREMENTAL_BUILD, null);
		targetProject = GeneratorUtils.getTargetProject(entry);
		if (!targetProject.exists()) {
			targetProject.create(new NullProgressMonitor());
			targetProject.open(new NullProgressMonitor());
		}
		targetProject.build(IncrementalProjectBuilder.INCREMENTAL_BUILD,
				new NullProgressMonitor());
		IMarker[] markers = targetProject.findMarkers(
				IJavaModelMarker.JAVA_MODEL_PROBLEM_MARKER, true,
				IResource.DEPTH_INFINITE);
		return markers;
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

}
