/**
 * Copyright (c) 2016 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.runner;

import static org.yakindu.sct.generator.runner.lib.IGenericJavaFeatureConstants.CONFIGURATION_MODULE;
import static org.yakindu.sct.generator.runner.lib.IGenericJavaFeatureConstants.GENERATOR_CLASS;
import static org.yakindu.sct.generator.runner.lib.IGenericJavaFeatureConstants.GENERATOR_PROJECT;
import static org.yakindu.sct.generator.runner.lib.IGenericJavaFeatureConstants.TEMPLATE_FEATURE;

import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.yakindu.sct.commons.WorkspaceClassLoaderFactory;
import org.yakindu.sct.generator.core.IExecutionFlowGenerator;
import org.yakindu.sct.generator.core.ISCTGenerator;
import org.yakindu.sct.generator.core.ISGraphGenerator;
import org.yakindu.sct.generator.core.execution.AbstractGeneratorEntryExecutor;
import org.yakindu.sct.generator.core.filesystem.ISCTFileSystemAccess;
import org.yakindu.sct.model.sexec.transformation.IModelSequencer;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameterValue;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class WorkspaceGeneratorExecutor extends AbstractGeneratorEntryExecutor {

	@Inject(optional = true)
	private IModelSequencer sequencer;

	@Override
	protected void execute(ISCTFileSystemAccess access, GeneratorEntry entry) {
		ISCTGenerator codeGenerator = createInstance(entry, getTemplateClassName(entry));
		Module bindings = getBindings(entry);
		if (bindings != null) {
			Injector injector = Guice.createInjector(bindings);
			injector.injectMembers(codeGenerator);
		}
		
		if (codeGenerator instanceof ISGraphGenerator) {
			((ISGraphGenerator) codeGenerator).generate((Statechart) entry.getElementRef(), entry, access);
		} else if (codeGenerator instanceof IExecutionFlowGenerator) {
			((IExecutionFlowGenerator) codeGenerator).generate(sequencer.transform((Statechart) entry.getElementRef()),
					entry, access);
		}
	}

	@SuppressWarnings("unchecked")
	protected <T> T createInstance(GeneratorEntry entry, String className) {
		try {
			IProject project = getLookupRoot(entry);
			final ClassLoader classLoader = new WorkspaceClassLoaderFactory().createClassLoader(project,
					getClass().getClassLoader());
			return (T) classLoader.loadClass(className).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	protected Module getBindings(GeneratorEntry entry) {
		FeatureConfiguration featureConfiguration = entry.getFeatureConfiguration(TEMPLATE_FEATURE);
		if (featureConfiguration != null) {
			FeatureParameterValue parameterValue = featureConfiguration.getParameterValue(CONFIGURATION_MODULE);
			if (parameterValue != null) {
				String moduleClassName = parameterValue.getStringValue();
				if (moduleClassName != null)
					return createInstance(entry, moduleClassName);
			}
		}
		return null;
	}

	protected String getTemplateClassName(GeneratorEntry entry) {
		return entry.getFeatureConfiguration(TEMPLATE_FEATURE).getParameterValue(GENERATOR_CLASS).getStringValue();
	}

	protected IProject getLookupRoot(GeneratorEntry entry) {
		IProject project = null;
		FeatureConfiguration templateConfig = entry.getFeatureConfiguration(TEMPLATE_FEATURE);
		FeatureParameterValue projectName = templateConfig.getParameterValue(GENERATOR_PROJECT);
		if (projectName != null) {
			project = ResourcesPlugin.getWorkspace().getRoot().getProject(projectName.getStringValue());
		} else {
			URI uri = entry.getElementRef().eResource().getURI();
			project = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)))
					.getProject();
		}
		return project;
	}

}
