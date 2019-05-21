/**
* Copyright (c) 2017 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	Johannes Dicks - itemis AG
*
*/
package org.yakindu.base.expressions.ui.contentassist;

import org.apache.log4j.Logger;
import org.eclipse.jface.text.BadLocationException;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor.Delegate;

/**
 * String adjusting Acceptor, which removes the last " of a completion proposal,
 * if the document continues with one.
 * 
 * @author Johannes Dicks
 */
public class StringProposalDelegate extends Delegate {

	private static final Logger LOG = Logger.getLogger(StringProposalDelegate.class);

	org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext ctx;

	public StringProposalDelegate(ICompletionProposalAcceptor delegate,
			org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext ctx) {
		super(delegate);
		this.ctx = ctx;
	}

	@Override
	public void accept(ICompletionProposal proposal) {
		if (proposal instanceof ConfigurableCompletionProposal) {
			ConfigurableCompletionProposal configurableCompletionProposal = (ConfigurableCompletionProposal) proposal;
			int endPos = configurableCompletionProposal.getReplacementOffset()
					+ configurableCompletionProposal.getReplacementLength();
			if (ctx.getDocument() != null && ctx.getDocument().getLength() > endPos) {
				// We are not at the end of the file
				try {
					if ("\"".equals(ctx.getDocument().get(endPos, 1))) {
						configurableCompletionProposal
								.setReplacementLength(configurableCompletionProposal.getReplacementLength() - 1);
						configurableCompletionProposal
								.setReplacementString(configurableCompletionProposal.getReplacementString().substring(0,
										configurableCompletionProposal.getReplacementString().length() - 1));
					}
				} catch (BadLocationException e) {
					LOG.debug("Skipped propsal adjustment.", e);
				}
			}
		}
		super.accept(proposal);
	}
}