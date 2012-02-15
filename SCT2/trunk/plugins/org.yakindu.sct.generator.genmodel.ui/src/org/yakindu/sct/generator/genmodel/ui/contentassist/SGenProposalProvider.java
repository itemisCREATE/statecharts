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

import java.util.ArrayList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;

import com.google.common.collect.Lists;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class SGenProposalProvider extends AbstractSGenProposalProvider {
	@Override
	public void completeGeneratorModel_GeneratorId(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Iterable<GeneratorDescriptor> descriptions = GeneratorExtensions
				.getGeneratorDescriptors();
		for (GeneratorDescriptor desc : descriptions) {
			//FIXME NullPointerCheck: desc could be Null
			ICompletionProposal proposal = createCompletionProposal(
					desc.getId(), new StyledString((desc.getName()!=null) ? desc.getName() : "null"),
					desc.getImage(), context);
			acceptor.accept(proposal);
		}
	}

	public void createProposals(ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.createProposals(context, acceptor);

	}

	protected boolean isKeywordWorthyToPropose(Keyword keyword) {
		if (keyword.getValue().length() == 1) {
			ArrayList<String> whiteList = Lists.newArrayList("{", "}", "=");
			if (whiteList.contains(keyword.getValue()))
				return true;
		}
		return super.isKeywordWorthyToPropose(keyword);
	}
}
