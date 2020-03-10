/** 
 * Copyright (c) 2017 committers of YAKINDU and others. 
 * All rights reserved. This program and the accompanying materials 
 * are made available under the terms of the Eclipse Public License v1.0 
 * which accompanies this distribution, and is available at 
 * http://www.eclipse.org/legal/epl-v10.html 
 * Contributors:
 * committers of YAKINDU - initial API and implementation
 *
*/
package org.yakindu.sct.model.stext.ui.contentassist;

import java.util.Arrays;

import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.contentassist.CompletionProposalComputer;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.concurrent.CancelableUnitOfWork;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class AsyncXtextContentAssistProcessor extends XtextContentAssistProcessor {

	@Override
	public ICompletionProposal[] computeCompletionProposals(ITextViewer viewer, int offset) {
		if (getContentProposalProvider() == null)
			return null;

		IXtextDocument document = (IXtextDocument) viewer.getDocument();
		final CancelableCompletionProposalComputer computer = createCompletionProposalComputer(viewer, offset);
		RunnableWithResult<ICompletionProposal[]> runnable = new RunnableWithResult.Impl<ICompletionProposal[]>() {
			@Override
			public void run() {
				setResult(document.priorityReadOnly(new CancelableUnitOfWork<ICompletionProposal[], XtextResource>() {
					@Override
					public ICompletionProposal[] exec(XtextResource state, CancelIndicator cancelIndicator)
							throws Exception {
						computer.setCancelIndicator(cancelIndicator);
						try {
							return computer.exec(state);
						} catch (Throwable t) {
							return new ICompletionProposal[] {};
						}
					}
				}));
			}
		};

		if (Display.getCurrent() == null) {
			Display.getDefault().syncExec(runnable);
		} else {
			runnable.run();
		}
		ICompletionProposal[] result = runnable.getResult();
		Arrays.sort(result, getCompletionProposalComparator());
		result = getCompletionProposalPostProcessor().postProcess(result);
		return result;
	}

	@Override
	protected CancelableCompletionProposalComputer createCompletionProposalComputer(ITextViewer viewer, int offset) {
		return new CancelableCompletionProposalComputer(this, viewer, offset);
	}

	public static class CancelableCompletionProposalComputer extends CompletionProposalComputer {

		private CancelIndicator cancelIndicator;

		public CancelableCompletionProposalComputer(State state, ITextViewer viewer, int offset) {
			super(state, viewer, offset);
		}

		public void setCancelIndicator(CancelIndicator indicator) {
			this.cancelIndicator = indicator;
		}

		@Override
		public boolean canAcceptMoreProposals() {
			if (cancelIndicator == null) {
				return super.canAcceptMoreProposals();
			}
			return !cancelIndicator.isCanceled();
		}

	}
}