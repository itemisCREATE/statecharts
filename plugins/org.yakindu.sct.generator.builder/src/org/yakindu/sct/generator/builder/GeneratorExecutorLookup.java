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
package org.yakindu.sct.generator.builder;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.yakindu.sct.generator.core.GeneratorModule;
import org.yakindu.sct.generator.core.execution.IGenModelExecutor;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor;
import org.yakindu.sct.model.sgen.GeneratorModel;

import com.google.inject.Guice;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class GeneratorExecutorLookup {

	public void executeGenerator(IFile file) {
		final GeneratorModel model = loadGeneratorModel(file);
		Job generatorJob = new Job("Execute SCT Genmodel " + file.getName()) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					execute(model);
				} catch (Exception ex) {
					return new Status(IStatus.ERROR, BuilderActivator.PLUGIN_ID, ex.getMessage(), ex);
				}
				return Status.OK_STATUS;
			}
		};
		generatorJob.setRule(file.getProject().getWorkspace().getRoot());
		generatorJob.schedule();
	}

	protected GeneratorModel loadGeneratorModel(IFile file) {
		Resource resource = loadResource(file);
		if (resource == null || resource.getContents().size() == 0 || resource.getErrors().size() > 0)
			return null;
		final GeneratorModel model = (GeneratorModel) resource.getContents().get(0);
		return model;
	}

	public void execute(GeneratorModel model) {
		final IGenModelExecutor executor = getExecutor(model);
		executor.execute(model);
	}

	protected IGenModelExecutor getExecutor(GeneratorModel model) {
		String generatorId = model.getGeneratorId();
		IGeneratorDescriptor description = GeneratorExtensions.getGeneratorDescriptor(generatorId);
		if (description == null)
			throw new RuntimeException("No generator registered for ID: " + generatorId);
		final IGenModelExecutor executor = description.createExecutor();
		if (executor == null)
			throw new RuntimeException("Failed to create generator instance for ID:" + generatorId);
		GeneratorModule bindings = description.getBindings();
		return executor;
		// IDomainDescriptor domainDescriptor =
		// DomainRegistry.getDomainDescriptor(entry.getElementRef());
		// Module overridesModule = null;
		// if (generator instanceof AbstractSGraphModelGenerator) {
		// overridesModule = ((AbstractSGraphModelGenerator)
		// generator).getOverridesModule(entry);
		// }
		// Injector injector =
		// domainDescriptor.getDomainInjectorProvider().getGeneratorInjector(model.getGeneratorId(),
		// overridesModule);
		// injector.injectMembers(generator);

		// TODO: refactor location for adding type system resource.
		// ITypeSystem typeSystem = injector.getInstance(ITypeSystem.class);
		// if (typeSystem instanceof AbstractTypeSystem) {
		// ResourceSet set = entry.getElementRef().eResource().getResourceSet();
		// set.getResources().add(((AbstractTypeSystem)
		// typeSystem).getResource());
		// EcoreUtil.resolveAll(set);
		// }
		//
		// return generator;
	}

	protected Resource loadResource(IFile file) {
		Resource resource = null;
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		resource = new ResourceSetImpl().getResource(uri, true);
		return resource;
	}

}
