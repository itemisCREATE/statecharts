/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.test;

import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor;
import org.yakindu.sct.generator.core.extensions.ILibraryDescriptor;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.generator.genmodel.resource.FeatureResourceDescription;
import org.yakindu.sct.generator.genmodel.test.util.SGenInjectorProvider;
import org.yakindu.sct.generator.genmodel.ui.help.SGenUserHelpDocumentationProvider;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureParameter;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.SGenPackage;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Checks if all Generator Features have a corresponding documentation section
 * in the user guide.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@RunWith(XtextRunner.class)
@InjectWith(SGenInjectorProvider.class)
public class HelpIntegrationTest {

	private static final String YAKINDU_JAVA = "yakindu::java";
	private static final String YAKINDU_C = "yakindu::c";
	private static final String YAKINDU_CPP = "yakindu::cpp";
		
	@Inject
	private SGenUserHelpDocumentationProvider documentationProvider;
	@Inject
	private XtextResourceSet resourceSet;
	@Inject
	private Injector injector;

	@Test
	public void checkJavaGeneratorFeatureDocumentation() {
		checkGeneratorFeatureDocumentation(YAKINDU_JAVA);
	}

	@Test
	public void checkCGeneratorFeatureDocumentation() {
		checkGeneratorFeatureDocumentation(YAKINDU_C);
	}

	@Test
	public void checkCppGeneratorFeatureDocumentation() {
		checkGeneratorFeatureDocumentation(YAKINDU_CPP);
	}
	
	@Test
	public void checkDocumentedFeaturesExist() {
		List<String> features = getDocumentedFeatures();
		ArrayList<String> generators = new ArrayList<String>(
				Arrays.asList(YAKINDU_JAVA, YAKINDU_C, YAKINDU_CPP));
		for (String generator : generators) {
			Iterable<IEObjectDescription> allElements = getAllElements(generator);
			for (IEObjectDescription desc : allElements) {
				if (desc.getEClass() != SGenPackage.Literals.FEATURE_TYPE)
					continue;
				EObject o = desc.getEObjectOrProxy();
				String name = null;
				if (o instanceof FeatureConfiguration) {
					FeatureType type = ((FeatureConfiguration) o).getType();
					if (type != null) {
						name = type.getName();
					}
				} else if (o instanceof FeatureType) {
					FeatureType type = (FeatureType) o;
					if (type != null) {
						name = type.getName();
					}
				} else if (o instanceof FeatureParameter) {
					FeatureType type = ((FeatureParameter) o).getFeatureType();
					if (type != null) {
						name = type.getName();
					}
				}
				if (name != null)
					name = name.toLowerCase();
				if (name != null && features.contains(name)) {
					features.remove(name);
				}
			}
		}

		if (features.size() > 0) {
			fail("There are documented features that are not implemented: " + Arrays.toString(features.toArray()));
		}
	}
	
	private void checkGeneratorFeatureDocumentation(String generator)
	{
		List<String> missingDocumentation = getFeaturesWithoutDocumentation(generator);
		if (missingDocumentation.size() > 0) {
			fail("Missing generator feature(s) documentation for generator "
					+ generator + ": " + missingDocumentation);
		}
	}
	
	private List<String> getDocumentedFeatures() {
		return documentationProvider.getDocumentedFeatures();
	}
	
	private Iterable<IEObjectDescription> getAllElements(String generatorId) {
		Optional<IGeneratorDescriptor> generatorDescriptor = GeneratorExtensions
				.getGeneratorDescriptor(generatorId);
		if(!generatorDescriptor.isPresent())
			return Collections.emptyList();
		Iterable<ILibraryDescriptor> libraryDescriptor = LibraryExtensions
				.getLibraryDescriptors(generatorDescriptor.get().getLibraryIDs());
		
		Iterable<IEObjectDescription> allElements = Lists.newArrayList();
		for (ILibraryDescriptor desc : libraryDescriptor) {
			Resource library = resourceSet.getResource(desc.getURI(), true);
			FeatureResourceDescription description = new FeatureResourceDescription(
					library);
			injector.injectMembers(description);
			allElements = Iterables.concat(allElements,
					description.getExportedObjects());
		}
		
		return allElements;
	}

	private List<String> getFeaturesWithoutDocumentation(String generatorId) {
		Iterable<IEObjectDescription> allElements = getAllElements(generatorId);
		List<String> missingDocumentation = Lists.newArrayList();
		for (IEObjectDescription desc : allElements) {
			if (desc.getEClass() != SGenPackage.Literals.FEATURE_TYPE)
				continue;
			EObject eObjectOrProxy = desc.getEObjectOrProxy();
			String documentation = documentationProvider
					.getDocumentation(eObjectOrProxy);
			if (documentation == null
					|| SGenUserHelpDocumentationProvider.EMPTY_DOCUMENTATION
							.equals(documentation)) {
				missingDocumentation.add(desc.getName().toString());
			}
		}
		return missingDocumentation;
	}

}
