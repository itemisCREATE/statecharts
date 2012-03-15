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
import static org.yakindu.sct.generator.core.features.impl.IGenericJavaFeatureConstants.CONFIGURATION_MODULE;
import static org.yakindu.sct.generator.core.features.impl.IGenericJavaFeatureConstants.TEMPLATE_FEATURE;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.util.Strings;
import org.yakindu.sct.generator.core.AbstractWorkspaceGenerator;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Guice;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 * 
 * 
 * @author holger willebrandt - Initial contribution and API
 */
public class GenericJavaBasedGenerator extends AbstractSExecModelGenerator {

	@Override
	protected com.google.inject.Injector createInjector(GeneratorEntry entry) {
		return Guice.createInjector(createModule(entry));
	}

	@Override
	protected Module createModule(GeneratorEntry entry) {
		Module defaultModule = super.createModule(entry);

		String overridingModuleClass = entry
				.getFeatureConfiguration(TEMPLATE_FEATURE)
				.getParameterValue(CONFIGURATION_MODULE).getStringValue();
		if (!Strings.isEmpty(overridingModuleClass)) {
			try {
				Class<?> moduleClass = getClassLoader(entry).loadClass(
						overridingModuleClass);
				if (Module.class.isAssignableFrom(moduleClass)) {
					Module module = (Module) moduleClass.newInstance();
					defaultModule = Modules.override(defaultModule)
							.with(module);
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				writeToConsole("Overriding module not found: "
						+ overridingModuleClass);
			} catch (InstantiationException e) {
				e.printStackTrace();
				writeToConsole("Module can't be instantiated : "
						+ overridingModuleClass);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				writeToConsole("Access to module denied: "
						+ overridingModuleClass);
			}
		}
		return defaultModule;
	}

	protected ClassLoader getClassLoader(GeneratorEntry entry) {
		IProject project = getLookupRoot(entry);
		final ClassLoader classLoader = new WorkspaceClassLoaderFactory()
				.createClassLoader(project);
		return classLoader;
	}

	@Override
	public void runGenerator(Statechart flow, GeneratorEntry entry) {
		String templateClass = entry.getFeatureConfiguration(TEMPLATE_FEATURE)
				.getParameterValue(GENERATOR_CLASS).getStringValue();
		final ClassLoader classLoader = getClassLoader(entry);
		try {
			Class<?> delegateGeneratorClass = (Class<?>) classLoader
					.loadClass(templateClass);
			Object delegate = getInjector(entry).getInstance(
					delegateGeneratorClass);
			if (delegate instanceof AbstractWorkspaceGenerator) {
				((AbstractWorkspaceGenerator) delegate).setBridge(bridge);
			}
			if (delegate instanceof IExecutionFlowGenerator) {
				IExecutionFlowGenerator flowGenerator = (IExecutionFlowGenerator) delegate;
				flowGenerator.generate(createExecutionFlow(flow, entry), entry);
			}
			if (delegate instanceof ISGraphGenerator) {
				ISGraphGenerator graphGenerator = (ISGraphGenerator) delegate;
				graphGenerator.generate(flow, entry);
			}
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
