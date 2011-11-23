/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.scoping;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.impl.DefaultGlobalScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions.LibraryDescriptor;
import org.yakindu.sct.generator.genmodel.resource.FeatureResourceDescription;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.SGenPackage;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenGlobalScopeProvider extends DefaultGlobalScopeProvider {

	@Inject
	private ResourceSet resourceSet;

	@Inject
	private Injector injector;

	@Override
	protected IScope getScope(Resource resource, boolean ignoreCase,
			final EClass type, Predicate<IEObjectDescription> filter) {
		IScope defaultScope = super
				.getScope(resource, ignoreCase, type, filter);
		Iterable<IEObjectDescription> allElements = defaultScope
				.getAllElements();
		// get the generator id
		GeneratorModel generatorModel = (GeneratorModel) EcoreUtil
				.getObjectByType(resource.getContents(),
						SGenPackage.Literals.GENERATOR_MODEL);
		Assert.isNotNull(generatorModel);
		String generatorId = generatorModel.getGeneratorId();

		Iterable<LibraryDescriptor> libraryDescriptor = LibraryExtensions
				.getLibraryDescriptor(generatorId);
		for (LibraryDescriptor desc : libraryDescriptor) {
			Resource library = resourceSet.getResource(desc.getURI(), true);
			FeatureResourceDescription description = new FeatureResourceDescription(
					library);
			injector.injectMembers(description);
			allElements = Iterables.concat(allElements,
					description.getExportedObjectsByType(type));
		}
		return new SimpleScope(allElements);
	}
}
