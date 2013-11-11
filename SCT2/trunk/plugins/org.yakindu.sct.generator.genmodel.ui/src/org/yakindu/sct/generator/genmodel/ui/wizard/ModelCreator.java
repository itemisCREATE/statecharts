/**
 * Copyright (c) 2013 committers of YAKINDU and others.
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
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions.LibraryDescriptor;
import org.yakindu.sct.generator.core.features.IDefaultFeatureValueProvider;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgen.SGenFactory;

import com.google.common.collect.Lists;

/**
 * 
 * @author muelder
 * @author oliver bohl
 */
public class ModelCreator {

	private final SGenFactory factory = SGenFactory.eINSTANCE;
	private final GeneratorDescriptor descriptor;

	private final List<EObject> eobjects;

	public ModelCreator(GeneratorDescriptor selectedGenerator, List<EObject> objects) {
		this.descriptor = selectedGenerator;
		this.eobjects = objects;
	}

	public GeneratorModel create() {
		GeneratorModel model = factory.createGeneratorModel();
		model.setGeneratorId(descriptor.getId());
		for (EObject object : eobjects) {
			model.getEntries().add(createGeneratorEntry(object));
		}
		return model;
	}

	private GeneratorEntry createGeneratorEntry(EObject eobject) {
		GeneratorEntry entry = factory.createGeneratorEntry();
		entry.setContentType(descriptor.getContentType());
		entry.setElementRef(eobject);
		List<FeatureType> featureTypes = getFeatureTypes(descriptor);
		for (FeatureType featureType : featureTypes) {
			FeatureConfiguration config = createFeatureConfiguration(eobject, featureType);
			if (config != null && !config.getParameterValues().isEmpty()) {
				entry.getFeatures().add(config);
			}
		}
		return entry;
	}

	private FeatureConfiguration createFeatureConfiguration(EObject object, FeatureType featureType) {
		Iterable<LibraryDescriptor> libraryDescriptor = LibraryExtensions.getLibraryDescriptors(descriptor
				.getLibraryIDs());
		for (LibraryDescriptor desc : libraryDescriptor) {
			IDefaultFeatureValueProvider defaultProvider = desc.createFeatureValueProvider();
			if (defaultProvider != null && defaultProvider.isProviderFor(featureType.getLibrary())) {
				return defaultProvider.createDefaultFeatureConfiguration(featureType, object);
			}
		}
		return null;
	}

	public static List<FeatureType> getFeatureTypes(GeneratorDescriptor descriptor) {
		ArrayList<FeatureType> features = Lists.newArrayList();
		Iterable<LibraryDescriptor> libraryDescriptor = LibraryExtensions.getLibraryDescriptors(descriptor
				.getLibraryIDs());
		for (LibraryDescriptor desc : libraryDescriptor) {
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(desc.getURI(), true);
			FeatureTypeLibrary lib = (FeatureTypeLibrary) resource.getContents().get(0);
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
