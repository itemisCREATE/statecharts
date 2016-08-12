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
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.types.typesystem.AbstractTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomainDescriptor;
import org.yakindu.sct.generator.core.ISCTGenerator;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor;
import org.yakindu.sct.generator.core.impl.AbstractSGraphModelGenerator;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;

import com.google.inject.Injector;
import com.google.inject.Module;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * @author holger willebrandt - refactoring
 * @author markus mühlbrandt - added executeGenerator for generator models
 */
public class GeneratorExecutor {

	public void executeGenerator(IFile file) {
		Resource resource = loadResource(file);
		if (resource == null || resource.getContents().size() == 0 || resource.getErrors().size() > 0)
			return;
		final GeneratorModel model = (GeneratorModel) resource.getContents().get(0);


		Job generatorJob = new Job("Execute SCT Genmodel " + file.getName()) {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				executeGenerator(model);
				return Status.OK_STATUS;
			}
		};
		generatorJob.setRule(file.getProject().getWorkspace().getRuleFactory().buildRule());
		generatorJob.schedule();
	}

	public void executeGenerator(GeneratorModel model) {

		final EList<GeneratorEntry> entries = model.getEntries();

		for (GeneratorEntry generatorEntry : entries) {
			final ISCTGenerator generator = getGenerator(model, generatorEntry);
			generator.generate(generatorEntry);
		}
	}

	protected ISCTGenerator getGenerator(GeneratorModel model, GeneratorEntry entry) {
		String generatorId = model.getGeneratorId();
		IGeneratorDescriptor description = GeneratorExtensions.getGeneratorDescriptor(generatorId);
		if (description == null)
			throw new RuntimeException("No generator registered for ID: " + generatorId);
		final ISCTGenerator generator = description.createGenerator();
		if (generator == null)
			throw new RuntimeException("Failed to create Generator instance for ID:" + generatorId);
		IDomainDescriptor domainDescriptor = DomainRegistry.getDomainDescriptor(entry.getElementRef());
		Module overridesModule = null;
		if (generator instanceof AbstractSGraphModelGenerator) {
			overridesModule = ((AbstractSGraphModelGenerator) generator).getOverridesModule(entry);
		}
		Injector injector = domainDescriptor.getDomainInjectorProvider().getGeneratorInjector(model.getGeneratorId(),
				overridesModule);
		injector.injectMembers(generator);
		
		// TODO: refactor location for adding type system resource.
		ITypeSystem typeSystem = injector.getInstance(ITypeSystem.class);
		if (typeSystem instanceof AbstractTypeSystem) {
			ResourceSet set = entry.getElementRef().eResource().getResourceSet();
			set.getResources().add(((AbstractTypeSystem) typeSystem).getResource());
			EcoreUtil.resolveAll(set);
		}

		return generator;
	}

	protected Resource loadResource(IFile file) {
		Resource resource = null;
		URI uri = URI.createPlatformResourceURI(file.getFullPath().toString(), true);
		resource = new ResourceSetImpl().getResource(uri, true);
		return resource;
	}

}
