/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.generator.genmodel.ui.quickfix;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.model.edit.IModificationContext;
import org.eclipse.xtext.ui.editor.model.edit.ISemanticModification;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.Fix;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions.LibraryDescriptor;
import org.yakindu.sct.generator.genmodel.validation.SGenJavaValidator;
import org.yakindu.sct.model.sgen.FeatureConfiguration;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorEntry;
import org.yakindu.sct.model.sgen.GeneratorModel;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenQuickfixProvider extends DefaultQuickfixProvider {

	@Fix(SGenJavaValidator.CODE_REQUIRED_FEATURE)
	public void AddRequiredFeature(final Issue issue,
			IssueResolutionAcceptor acceptor) {
		acceptor.accept(issue, "Add feature " + issue.getData()[0],
				"Adds the feature " + issue.getData()[0], null,
				new ISemanticModification() {
					public void apply(EObject element,
							IModificationContext context) throws Exception {
						FeatureConfiguration config = getDefaultFeatureConfiguration(
								issue, element);
						if (config != null) {
							GeneratorEntry entry = (GeneratorEntry) element;
							entry.getFeatures().add(config);
						}
					}
				});
	}

	private FeatureConfiguration getDefaultFeatureConfiguration(
			final Issue issue, EObject element) {
		GeneratorModel model = (GeneratorModel) EcoreUtil2
				.getRootContainer(element);
		
		GeneratorDescriptor generatorDescriptor = GeneratorExtensions
				.getGeneratorDescriptorForId(model.getGeneratorId());
		
		Iterable<LibraryDescriptor> libraryDescriptor = LibraryExtensions
				.getLibraryDescriptors(generatorDescriptor.getLibraryIDs());
		for (LibraryDescriptor desc : libraryDescriptor) {
			ResourceSet set = new ResourceSetImpl();
			Resource resource = set.getResource(desc.getURI(), true);
			FeatureTypeLibrary lib = (FeatureTypeLibrary) resource
					.getContents().get(0);
			EList<FeatureType> types = lib.getTypes();

			for (FeatureType featureType : types) {
				if (featureType.getName().equals(issue.getData()[0])) {
					return desc.createFeatureValueProvider()
							.createDefaultFeatureConfiguration(featureType,
									element);
				}
			}
		}
		return null;
	}

}
