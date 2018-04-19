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
package org.yakindu.sct.generator.core.execution;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.yakindu.base.types.typesystem.AbstractTypeSystem;
import org.yakindu.base.types.typesystem.ITypeSystem;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.domain.extension.IModuleConfigurator;
import org.yakindu.sct.domain.extension.impl.LazyCombiningModule;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

/**
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public class GeneratorExecutorLookup {

	protected Module getContextModule() {
		return new Module() {
			@Override
			public void configure(Binder binder) {
			}
		};
	}

	public void execute(GeneratorModel model) {
		EList<GeneratorEntry> entries = model.getEntries();
		for (GeneratorEntry generatorEntry : entries) {
			final IGeneratorEntryExecutor executor = createExecutor(generatorEntry, model.getGeneratorId());
			executor.execute(generatorEntry);
		}
	}

	public IGeneratorEntryExecutor createExecutor(GeneratorEntry entry, String generatorId) {
		IGeneratorDescriptor description = GeneratorExtensions.getGeneratorDescriptor(generatorId);
		if (description == null)
			throw new RuntimeException("No generator registered for ID: " + generatorId);
		final IGeneratorEntryExecutor executor = description.createExecutor();
		if (executor == null)
			throw new RuntimeException("Failed to create generator instance for ID:" + generatorId);
		Injector injector = createInjector(entry, description, generatorId);
		injector.injectMembers(executor);
		ITypeSystem typeSystem = injector.getInstance(ITypeSystem.class);
		if (entry.getElementRef() == null || entry.getElementRef().eResource() == null) {
			throw new RuntimeException("Could not resolve reference to model ");
		}
		if (typeSystem instanceof AbstractTypeSystem) {
			ResourceSet set = entry.getElementRef().eResource().getResourceSet();
			Resource typeSystemResource = ((AbstractTypeSystem) typeSystem).getResource();
			if (set != null && typeSystemResource != null && !set.getResources().contains(typeSystemResource)) {
				set.getResources().add(typeSystemResource);

				// XXX: avoid resolving the whole resource set, because there might
				// be models with different domains, we have to ensure that just the
				// models related to the current entry are resolved
				EcoreUtil.resolveAll(entry);
				EcoreUtil.resolveAll(entry.getElementRef());
				EcoreUtil.resolveAll(typeSystemResource);
			}
		}

		return executor;
	}

	protected Injector createInjector(GeneratorEntry entry, IGeneratorDescriptor description, String generatorId) {
		Module generatorSpecificModule = description.getBindings(entry);
		Module executionContextModule = getContextModule();
		Module domainModule = getDomainGeneratorModule(entry, generatorId);
		Module combined = Modules.override(Modules.combine(generatorSpecificModule, executionContextModule))
				.with(domainModule);
		return Guice.createInjector(combined);
	}

	protected Module getDomainGeneratorModule(GeneratorEntry entry, String generatorId) {
		IModuleConfigurator configurator = new GeneratorEntryModuleConfigurator(entry);
		Module module = DomainRegistry.getDomain(entry.getElementRef()).getModule(IDomain.FEATURE_GENERATOR,
				generatorId);
		if (module instanceof LazyCombiningModule) {
			((LazyCombiningModule) module).applyConfigurator(configurator);
		}
		return module;
	}
}
