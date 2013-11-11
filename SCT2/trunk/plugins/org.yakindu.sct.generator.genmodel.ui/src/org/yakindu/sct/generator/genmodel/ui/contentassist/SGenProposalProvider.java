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
package org.yakindu.sct.generator.genmodel.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;
import org.yakindu.sct.model.sgen.GeneratorModel;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenProposalProvider extends AbstractSGenProposalProvider {

	@Override
	public void completeGeneratorEntry_ContentType(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {

		GeneratorModel generatorModel = EcoreUtil2.getContainerOfType(model,
				GeneratorModel.class);
		GeneratorDescriptor descriptor = GeneratorExtensions
				.getGeneratorDescriptorForId(generatorModel.getGeneratorId());
		if (descriptor == null)
			return;
		ICompletionProposal proposal = createCompletionProposal(
				descriptor.getContentType(), context);
		acceptor.accept(proposal);
	}

	@Override
	public void completeGeneratorModel_GeneratorId(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Iterable<GeneratorDescriptor> descriptions = GeneratorExtensions
				.getGeneratorDescriptors();
		for (GeneratorDescriptor desc : descriptions) {
			ICompletionProposal proposal = createCompletionProposal(
					desc.getId(),
					new StyledString((desc.getName() != null) ? desc.getName()
							: "null"), desc.getImage(), context);

			if (proposal instanceof ConfigurableCompletionProposal) {
				ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
				configurable.setAdditionalProposalInfo(desc.getDescription());
			}


			acceptor.accept(proposal);
		}
	}

	@Override
	public void completeFeatureConfiguration_ParameterValues(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeFeatureConfiguration_ParameterValues(model, assignment,
				context, acceptor);
	}
}
