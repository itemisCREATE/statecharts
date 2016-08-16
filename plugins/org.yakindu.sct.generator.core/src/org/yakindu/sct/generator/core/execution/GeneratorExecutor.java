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
import org.eclipse.emf.ecore.resource.ResourceSet;
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
 * @author markus mÃ¼hlbrandt - added executeGenerator for generator models
 */
public class GeneratorExecutor {

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
}
