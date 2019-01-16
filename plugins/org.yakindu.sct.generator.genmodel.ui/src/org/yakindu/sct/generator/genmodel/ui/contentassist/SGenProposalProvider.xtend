/** 
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.genmodel.ui.contentassist

import java.util.Optional
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.eclipse.jface.text.contentassist.ICompletionProposal
import org.eclipse.jface.viewers.StyledString
import org.eclipse.jface.viewers.StyledString.Styler
import org.eclipse.swt.SWT
import org.eclipse.swt.graphics.Image
import org.eclipse.swt.graphics.TextStyle
import org.eclipse.swt.widgets.Display
import org.eclipse.xtext.Assignment
import org.eclipse.xtext.EcoreUtil2
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor
import org.eclipse.xtext.util.Strings
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions
import org.yakindu.sct.generator.core.extensions.IGeneratorDescriptor
import org.yakindu.sct.generator.genmodel.ui.PathToImageResolver
import org.yakindu.sct.model.sgen.GeneratorModel
import org.yakindu.sct.model.sgraph.Statechart

/** 
 * @author andreas muelder - Initial contribution and API
 */
class SGenProposalProvider extends AbstractSGenProposalProvider {

	override void completeGeneratorEntry_ContentType(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		var GeneratorModel generatorModel = EcoreUtil2.getContainerOfType(model, GeneratorModel)
		var Optional<IGeneratorDescriptor> descriptor = GeneratorExtensions.getGeneratorDescriptor(
			generatorModel.getGeneratorId())
		if(!descriptor.isPresent()) return;
		var ICompletionProposal proposal = createCompletionProposal(descriptor.get().getContentType(), context)
		acceptor.accept(proposal)
	}

	override void completeGeneratorModel_GeneratorId(EObject model, Assignment assignment, ContentAssistContext context,
		ICompletionProposalAcceptor acceptor) {
		var Iterable<IGeneratorDescriptor> descriptions = GeneratorExtensions.getGeneratorDescriptors()
		for (IGeneratorDescriptor desc : descriptions) {
			var ICompletionProposal proposal = createCompletionProposal(desc.getId(),
				new StyledString(if((desc.getName() !== null)) desc.getName() else "null"),
				PathToImageResolver.toImage(desc.getImagePath()), context)
			if (proposal instanceof ConfigurableCompletionProposal) {
				var ConfigurableCompletionProposal configurable = proposal
				configurable.setAdditionalProposalInfo(desc.getDescription())
			}
			acceptor.accept(proposal)
		}
	}

	override protected StyledString getStyledDisplayString(EObject element, String qualifiedName, String shortName) {
		if (element instanceof Statechart) {
			return computeStyledString(element, qualifiedName, shortName)
		}
		return super.getStyledDisplayString(element, qualifiedName, shortName)
	}

	def protected StyledString computeStyledString(Statechart sct, String qualifiedName, String shortName) {
		var StyledString firstPart = new StyledString(qualifiedName)
		var StyledString secondPart = getPackageImportStyleString(EcoreUtil.getURI(sct))
		return firstPart.append(secondPart)
	}

	def protected StyledString getPackageImportStyleString(URI uri) {
		var String filePath = if(uri.isPlatform()) uri.toPlatformString(true) else uri.toFileString()
		return new StyledString(''' - «filePath»''', new GreyoutStyler())
	}

	override protected ConfigurableCompletionProposal doCreateProposal(String proposal, StyledString displayString,
		Image image, int replacementOffset, int replacementLength) {
		/** 
		 * For two equally named statechart references, we only want to show one
		 * proposal, as the linker will only link to one statechart anyways.
		 * That is why we need to override hashCode & equals to work on
		 * replacementString instead of displayString.
		 */
		return new ConfigurableCompletionProposal(proposal, replacementOffset, replacementLength, proposal.length(),
			image, displayString, null, null) {
			override int hashCode() {
				var String replacementString = getReplacementString()
				return if(replacementString !== null) replacementString.hashCode() else 31
			}

			override boolean equals(Object obj) {
				if(obj === null) return false
				if(!(obj instanceof ConfigurableCompletionProposal)) return false
				var String replacementString = ((obj as ConfigurableCompletionProposal)).getReplacementString()
				return Strings.equal(replacementString, getReplacementString())
			}
		}
	}

	static class GreyoutStyler extends Styler {
		override void applyStyles(TextStyle textStyle) {
			textStyle.foreground = Display.getDefault().getSystemColor(SWT.COLOR_GRAY)
		}
	}
}
