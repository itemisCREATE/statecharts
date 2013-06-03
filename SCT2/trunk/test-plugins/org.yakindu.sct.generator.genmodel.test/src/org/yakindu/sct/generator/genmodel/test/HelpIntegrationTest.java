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

import static junit.framework.Assert.fail;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.junit4.InjectWith;
import org.eclipse.xtext.junit4.XtextRunner;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions.LibraryDescriptor;
import org.yakindu.sct.generator.genmodel.resource.FeatureResourceDescription;
import org.yakindu.sct.generator.genmodel.test.util.SGenInjectorProvider;
import org.yakindu.sct.generator.genmodel.ui.help.SGenUserHelpDocumentationProvider;
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
	private static final String YAKINDU_GENERIC = "yakindu::generic";
	private static final String YAKINDU_XPAND = "yakindu::xpand";
	@Inject
	private IEObjectDocumentationProvider documentationProvider;
	@Inject
	private XtextResourceSet resourceSet;
	@Inject
	private Injector injector;

	@Test
	public void checkJavaGeneratorFeatureDocumentation() {
		List<String> missingDocumentation = getFeaturesWithoutDocumentation(YAKINDU_JAVA);
		if (missingDocumentation.size() > 0) {
			fail("Missing generator feature(s) documentation for generator "
					+ YAKINDU_JAVA + ": " + missingDocumentation);
		}
	}

	@Test
	public void checkCGeneratorFeatureDocumentation() {
		List<String> missingDocumentation = getFeaturesWithoutDocumentation(YAKINDU_C);
		if (missingDocumentation.size() > 0) {
			fail("Missing generator feature(s) documentation for generator "
					+ YAKINDU_C + ": " + missingDocumentation);
		}
	}

	@Test
	public void checkCppGeneratorFeatureDocumentation() {
		List<String> missingDocumentation = getFeaturesWithoutDocumentation(YAKINDU_CPP);
		if (missingDocumentation.size() > 0) {
			fail("Missing generator feature(s) documentation for generator "
					+ YAKINDU_CPP + ": " + missingDocumentation);
		}

	}

	@Test
	public void checkGenericGeneratorFeatureDocumentation() {
		List<String> missingDocumentation = getFeaturesWithoutDocumentation(YAKINDU_GENERIC);
		if (missingDocumentation.size() > 0) {
			fail("Missing generator feature(s) documentation for generator "
					+ YAKINDU_GENERIC + ": " + missingDocumentation);
		}

	}

	@Test
	public void checkXpandGeneratorFeatureDocumentation() {
		List<String> missingDocumentation = getFeaturesWithoutDocumentation(YAKINDU_XPAND);
		if (missingDocumentation.size() > 0) {
			fail("Missing generator feature(s) documentation for generator "
					+ YAKINDU_XPAND + ": " + missingDocumentation);
		}

	}

	private List<String> getFeaturesWithoutDocumentation(String generatorId) {
		
		GeneratorDescriptor generatorDescriptor = GeneratorExtensions
				.getGeneratorDescriptorForId(generatorId);
		
		Iterable<LibraryDescriptor> libraryDescriptor = LibraryExtensions
				.getLibraryDescriptors(generatorDescriptor.getLibraryIDs());
		
		Iterable<IEObjectDescription> allElements = Lists.newArrayList();
		for (LibraryDescriptor desc : libraryDescriptor) {
			Resource library = resourceSet.getResource(desc.getURI(), true);
			FeatureResourceDescription description = new FeatureResourceDescription(
					library);
			injector.injectMembers(description);
			allElements = Iterables.concat(allElements,
					description.getExportedObjects());
		}
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
