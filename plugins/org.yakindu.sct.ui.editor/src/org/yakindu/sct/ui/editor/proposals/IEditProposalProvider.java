package org.yakindu.sct.ui.editor.proposals;

import java.util.List;

import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * @author terfloth - initial implementation
 */
public interface IEditProposalProvider {
	
	public List<IEditProposal> getProposals(View view);
	
}
