package org.yakindu.base.xtext.utils.jface.fieldassist;

/**
 * This interface is used to listen to additional notifications from a
 * {@link CompletionProposalAdapter}.
 * 
 * @author patrick.koenemann@itemis.de
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
	public void proposalPopupOpened(CompletionProposalAdapter adapter);

	/**
	 * A completion proposal popup has been closed.
	 * 
	 * @param adapter
	 *            the CompletionProposalAdapter which is adapting content proposal
	 *            behavior to a control
	 */
	public void proposalPopupClosed(CompletionProposalAdapter adapter);
}