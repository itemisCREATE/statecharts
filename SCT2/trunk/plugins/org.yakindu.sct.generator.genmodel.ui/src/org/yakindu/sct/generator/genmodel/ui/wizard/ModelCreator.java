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
package org.yakindu.sct.generator.genmodel.ui.wizard;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions.LibraryDescriptor;
import org.yakindu.sct.generator.core.features.IDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.SGenFactory;
import org.yakindu.sct.model.sgraph.Statechart;

import com.google.common.collect.Lists;

/**
 * 
 * @author muelder
 * 
 */
public class ModelCreator {

	private final SGenFactory factory = SGenFactory.eINSTANCE;
	private final String generatorId;
	private final List<Statechart> statecharts;

	public ModelCreator(String generatorId, List<Statechart> statecharts) {
		this.generatorId = generatorId;
		this.statecharts = statecharts;
	}

	public GeneratorModel create() {
		GeneratorModel model = factory.createGeneratorModel();
		model.setGeneratorId(generatorId);
		for (Statechart statechart : statecharts) {
			model.getEntries().add(createGeneratorEntry(statechart));
		}
		return model;
	}

	private GeneratorEntry createGeneratorEntry(Statechart statechart) {
		GeneratorEntry entry = factory.createGeneratorEntry();
		entry.setContentType("statechart");
		entry.setElementRef(statechart);
		List<FeatureType> featureTypes = getFeatureTypes(generatorId);
		for (FeatureType featureType : featureTypes) {
			FeatureConfiguration config = createFeatureConfiguration(
					statechart, featureType);
			if (config != null && !config.getParameterValues().isEmpty()) {
				entry.getFeatures().add(config);
			}
		}
		return entry;
	}

	private FeatureConfiguration createFeatureConfiguration(
			Statechart statechart, FeatureType featureType) {
		
		GeneratorDescriptor generatorDescriptor = GeneratorExtensions
				.getGeneratorDescriptorForId(generatorId);
		
		Iterable<LibraryDescriptor> libraryDescriptor = LibraryExtensions
				.getLibraryDescriptors(generatorDescriptor.getLibraryIDs());
		
		for (LibraryDescriptor desc : libraryDescriptor) {
			IDefaultFeatureValueProvider defaultProvider = desc
					.createFeatureValueProvider();
			if (defaultProvider != null
					&& defaultProvider.isProviderFor(featureType.getLibrary())) {
				return defaultProvider.createDefaultFeatureConfiguration(
						featureType, statechart);
			}
		}
		return null;
	}

	public static List<FeatureType> getFeatureTypes(String generatorId) {
		ArrayList<FeatureType> features = Lists.newArrayList();
		
		GeneratorDescriptor generatorDescriptor = GeneratorExtensions
				.getGeneratorDescriptorForId(generatorId);
		
		Iterable<LibraryDescriptor> libraryDescriptor = LibraryExtensions
				.getLibraryDescriptors(generatorDescriptor.getLibraryIDs());
		
		for (LibraryDescriptor desc : libraryDescriptor) {
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(desc.getURI(), true);
			FeatureTypeLibrary lib = (FeatureTypeLibrary) resource
					.getContents().get(0);
			EList<FeatureType> types = lib.getTypes();
			// Only add the required features to the default model
			for (FeatureType featureType : types) {
				if (!featureType.isOptional())
					features.add(featureType);
			}
		}
		return features;
	}
}
