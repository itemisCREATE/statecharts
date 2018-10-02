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

import static org.yakindu.sct.generator.core.GeneratorActivator.PLUGIN_ID;

import java.util.Arrays;
import java.util.Optional;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.MultiStatus;
import org.eclipse.emf.common.util.EList;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomain;
import org.yakindu.sct.domain.extension.IModuleConfigurator;
import org.yakindu.sct.domain.extension.impl.LazyCombiningModule;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;

import com.google.common.collect.Iterables;
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

	public IStatus execute(GeneratorModel model) {
		EList<GeneratorEntry> entries = model.getEntries();
		ExecutionStatus executionStatus = new ExecutionStatus();
		for (GeneratorEntry generatorEntry : entries) {
			final IGeneratorEntryExecutor executor = createExecutor(generatorEntry, model.getGeneratorId());
			IStatus status = executor.execute(generatorEntry);
			executionStatus.merge(status);
		}
		return executionStatus;
	}

	public IGeneratorEntryExecutor createExecutor(GeneratorEntry entry, String generatorId) {
		Optional<IGeneratorDescriptor> description = GeneratorExtensions.getGeneratorDescriptor(generatorId);
		if (!description.isPresent())
			throw new RuntimeException("No generator registered for ID: " + generatorId);
		if (entry.getElementRef() == null || entry.getElementRef().eResource() == null) {
			throw new RuntimeException("Could not resolve reference to model ");
		}
		final IGeneratorEntryExecutor executor = description.get().createExecutor();
		if (executor == null)
			throw new RuntimeException("Failed to create generator instance for ID:" + generatorId);
		Injector injector = createInjector(entry, description.get(), generatorId);
		injector.injectMembers(executor);
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

	private static class ExecutionStatus extends MultiStatus {

		public ExecutionStatus() {
			super(PLUGIN_ID, IStatus.OK, "", null);
		}

		@Override
		public String getMessage() {
			return String.join("\n", Iterables.transform(Arrays.asList(getChildren()), c -> c.getMessage()));
		}

	}
}
