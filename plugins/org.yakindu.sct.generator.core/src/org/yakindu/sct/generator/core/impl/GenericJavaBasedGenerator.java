/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.core.impl;

import static org.yakindu.sct.generator.core.features.impl.IGenericJavaFeatureConstants.GENERATOR_CLASS;
import static org.yakindu.sct.generator.core.features.impl.IGenericJavaFeatureConstants.GENERATOR_PROJECT;
import static org.yakindu.sct.generator.core.features.impl.IGenericJavaFeatureConstants.TEMPLATE_FEATURE;

import java.io.File;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.yakindu.sct.generator.core.AbstractWorkspaceGenerator;
import org.yakindu.sct.generator.core.IGeneratorBridge;
import org.yakindu.sct.generator.core.util.GeneratorUtils;
import org.yakindu.sct.model.sexec.ExecutionFlow;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;

/**
 * 
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class GenericJavaBasedGenerator extends AbstractSExecModelGenerator {

	final IGeneratorBridge bridge = new IGeneratorBridge() {

		public void writeToConsole(Throwable t) {
			GenericJavaBasedGenerator.this.writeToConsole(t);
		}

		public void writeToConsole(String s) {
			GenericJavaBasedGenerator.this.writeToConsole(s);
		}

		public FeatureParameterValue getFeatureParameter(GeneratorEntry entry,
				String featureName, String paramName) {
			return GeneratorUtils.getFeatureParameter(entry,
					featureName, paramName);
		}

		public void refreshTargetProject(GeneratorEntry entry) {
			GeneratorUtils.refreshTargetProject(entry);
		}

		public File getTargetProject(GeneratorEntry entry) {
			IProject targetProject = GenericJavaBasedGenerator.this
					.getTargetProject(entry);
			return targetProject.getLocation().toFile();
		}

		public File getTargetFolder(GeneratorEntry entry) {
			return GeneratorUtils.getTargetFolder(entry);
		}
	};

	@Override
	protected void generate(ExecutionFlow flow, GeneratorEntry entry) {
		String templateClass = entry.getFeatureConfiguration(TEMPLATE_FEATURE)
				.getParameterValue(GENERATOR_CLASS).getStringValue();
		IProject project = getLookupRoot(entry);
		final ClassLoader classLoader = new WorkspaceClassLoaderFactory()
				.createClassLoader(project);
		try {
			@SuppressWarnings("unchecked")
			Class<AbstractWorkspaceGenerator> delegateGeneratorClass = (Class<AbstractWorkspaceGenerator>) classLoader
					.loadClass(templateClass);
			AbstractWorkspaceGenerator delegate = delegateGeneratorClass
					.newInstance();
			delegate.setBridge(bridge);
			delegate.generate(flow, entry);
		} catch (Exception e) {
			e.printStackTrace();
			writeToConsole(e);
		}
	}

	/**
	 * resolve the project that defines the lookup path for the XpandFacade
	 * 
	 */
	protected IProject getLookupRoot(GeneratorEntry entry) {
		IProject project = null;
		FeatureConfiguration templateConfig = entry
				.getFeatureConfiguration(TEMPLATE_FEATURE);
		FeatureParameterValue projectName = templateConfig
				.getParameterValue(GENERATOR_PROJECT);
		if (projectName != null) {
			project = ResourcesPlugin.getWorkspace().getRoot()
					.getProject(projectName.getStringValue());
		} else {
			URI uri = entry.getStatechart().eResource().getURI();
			project = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new Path(uri.toPlatformString(true))).getProject();
		}
		return project;
	}

}
