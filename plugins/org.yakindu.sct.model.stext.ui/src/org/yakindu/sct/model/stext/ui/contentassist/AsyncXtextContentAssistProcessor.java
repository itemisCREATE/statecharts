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

import org.eclipse.jface.text.ITextViewer;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.CompletionProposalComputer;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;

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
		CompletionProposalComputer computer = createCompletionProposalComputer(viewer, offset);
		ICompletionProposal[] result = document.readOnly(computer);
		Arrays.sort(result, getCompletionProposalComparator());
		result = getCompletionProposalPostProcessor().postProcess(result);
		return result;
	}

}