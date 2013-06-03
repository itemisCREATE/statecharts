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
package org.yakindu.sct.generator.genmodel.ui.templates;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.Template;
import org.eclipse.jface.text.templates.TemplateContext;
import org.eclipse.jface.text.templates.TemplateProposal;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateAcceptor;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;
import org.eclipse.xtext.ui.editor.templates.DefaultTemplateProposalProvider;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.generator.core.extensions.LibraryExtensions.LibraryDescriptor;
import org.yakindu.sct.generator.genmodel.services.SGenGrammarAccess;
import org.yakindu.sct.model.sgen.FeatureType;
import org.yakindu.sct.model.sgen.FeatureTypeLibrary;
import org.yakindu.sct.model.sgen.GeneratorModel;

import com.google.inject.Inject;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenTemplateProposalProvider extends
		DefaultTemplateProposalProvider {

	@Inject
	private SGenGrammarAccess gaccess;
	@Inject
	private SGenProposalCreator creator;

	private final ContextTypeIdHelper helper;

	@Inject
	public SGenTemplateProposalProvider(TemplateStore templateStore,
			ContextTypeRegistry registry, ContextTypeIdHelper helper) {
		super(templateStore, registry, helper);
		this.helper = helper;
	}

	@Override
	protected void createTemplates(TemplateContext templateContext,
			ContentAssistContext context, ITemplateAcceptor acceptor) {
		super.createTemplates(templateContext, context, acceptor);

		String id = helper.getId(gaccess.getFeatureConfigurationRule());
		if (templateContext.getContextType().getId().equals(id)) {
			createFeatureConfigurationTemplates(templateContext, context,
					acceptor);
		}
	}

	private void createFeatureConfigurationTemplates(
			TemplateContext templateContext, ContentAssistContext context,
			ITemplateAcceptor acceptor) {
		GeneratorModel model = (GeneratorModel) EcoreUtil2
				.getRootContainer(context.getCurrentModel());


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
				Template template = new Template(featureType.getName()
						+ " feature", "Creates feature "
						+ featureType.getName(), featureType.getName(),
						creator.createProposal(featureType,
								desc.createFeatureValueProvider(),
								context.getCurrentModel()), false);
				TemplateProposal proposal = createProposal(template,
						templateContext, context, getImage(template),
						getRelevance(template));
				acceptor.accept(proposal);
			}
		}
	}
}
