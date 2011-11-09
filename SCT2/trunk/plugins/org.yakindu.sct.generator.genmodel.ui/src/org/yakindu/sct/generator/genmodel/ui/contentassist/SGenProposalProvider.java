package org.yakindu.sct.generator.genmodel.ui.contentassist;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions;
import org.yakindu.sct.generator.core.extensions.GeneratorExtensions.GeneratorDescriptor;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SGenProposalProvider extends AbstractSGenProposalProvider {

	@Override
	public void completeGeneratorModel_GeneratorId(EObject model,
			Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		Iterable<GeneratorDescriptor> descriptions = GeneratorExtensions
				.getGeneratorDescriptors();
		for (GeneratorDescriptor desc : descriptions) {
			ICompletionProposal proposal = createCompletionProposal(
					desc.getId(), new StyledString(desc.getName()),
					desc.getImage(), context);
			acceptor.accept(proposal);
		}
	}

}
