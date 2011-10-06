package de.itemis.xtext.utils.jface.fieldassist;

import org.eclipse.jface.fieldassist.ContentProposalAdapter;

/**
 * This interface is used to listen to additional notifications from a
 * {@link CompletionProposalAdapter}.
 *
 */
public interface ICompletionProposalListener {
	/**
	 * A completion proposal popup has been opened.
	 * 
	 * @param adapter
	 *            the CompletionProposalAdapter which is adapting content proposal
	 *            behavior to a control
	 */
	public void proposalPopupOpened(ContentProposalAdapter adapter);

	/**
	 * A completion proposal popup has been closed.
	 * 
	 * @param adapter
	 *            the CompletionProposalAdapter which is adapting content proposal
	 *            behavior to a control
	 */
	public void proposalPopupClosed(ContentProposalAdapter adapter);
}