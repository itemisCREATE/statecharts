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

import java.util.Optional;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.jface.viewers.StyledString.Styler;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.TextStyle;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.util.Strings;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor;
import org.yakindu.sct.generator.genmodel.ui.PathToImageResolver;
import org.yakindu.sct.model.sgen.GeneratorModel;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * @author andreas muelder - Initial contribution and API
 */
public class SGenProposalProvider extends AbstractSGenProposalProvider {

	@Override
	public void completeGeneratorEntry_ContentType(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {

		GeneratorModel generatorModel = EcoreUtil2.getContainerOfType(model, GeneratorModel.class);
		Optional<IGeneratorDescriptor> descriptor = GeneratorExtensions
				.getGeneratorDescriptor(generatorModel.getGeneratorId());
		if (!descriptor.isPresent())
			return;
		ICompletionProposal proposal = createCompletionProposal(descriptor.get().getContentType(), context);
		acceptor.accept(proposal);
	}

	@Override
	public void completeGeneratorModel_GeneratorId(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Iterable<IGeneratorDescriptor> descriptions = GeneratorExtensions.getGeneratorDescriptors();
		for (IGeneratorDescriptor desc : descriptions) {
			ICompletionProposal proposal = createCompletionProposal(desc.getId(),
					new StyledString((desc.getName() != null) ? desc.getName() : "null"),
					PathToImageResolver.toImage(desc.getImagePath()), context);

			if (proposal instanceof ConfigurableCompletionProposal) {
				ConfigurableCompletionProposal configurable = (ConfigurableCompletionProposal) proposal;
				configurable.setAdditionalProposalInfo(desc.getDescription());
			}
			acceptor.accept(proposal);
		}
	}

	@Override
	protected StyledString getStyledDisplayString(EObject element, String qualifiedName, String shortName) {
		if (element instanceof Statechart) {
			return computeStyledString((Statechart) element, qualifiedName, shortName);
		}
		return super.getStyledDisplayString(element, qualifiedName, shortName);
	}

	protected StyledString computeStyledString(Statechart sct, String qualifiedName, String shortName) {
		StyledString firstPart = new StyledString(qualifiedName);
		StyledString secondPart = getPackageImportStyleString(EcoreUtil.getURI(sct));
		return firstPart.append(secondPart);
	}

	protected StyledString getPackageImportStyleString(URI uri) {
		String filePath = uri.isPlatform() ? uri.toPlatformString(true) : uri.toFileString();
		return new StyledString(" - " + filePath, new GreyoutStyler());
	}

	protected ConfigurableCompletionProposal doCreateProposal(String proposal, StyledString displayString, Image image,
			int replacementOffset, int replacementLength) {

		/**
		 * For two equally named statechart references, we only want to show one
		 * proposal, as the linker will only link to one statechart anyways.
		 * That is why we need to override hashCode & equals to work on
		 * replacementString instead of displayString.
		 */
		return new ConfigurableCompletionProposal(proposal, replacementOffset, replacementLength, proposal.length(),
				image, displayString, null, null) {

			@Override
			public int hashCode() {
				String replacementString = getReplacementString();
				return replacementString != null ? replacementString.hashCode() : 31;
			}

			@Override
			public boolean equals(Object obj) {
				if (obj == null)
					return false;
				if (!(obj instanceof ConfigurableCompletionProposal))
					return false;
				String replacementString = ((ConfigurableCompletionProposal) obj).getReplacementString();
				return Strings.equal(replacementString, getReplacementString());
			}
		};
	}

	public static class GreyoutStyler extends Styler {

		@Override
		public void applyStyles(TextStyle textStyle) {
			textStyle.foreground = Display.getDefault().getSystemColor(SWT.COLOR_GRAY);
		}
	}

	@Override
	public void completeFeatureConfiguration_ParameterValues(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.completeFeatureConfiguration_ParameterValues(model, assignment, context, acceptor);
	}
}
