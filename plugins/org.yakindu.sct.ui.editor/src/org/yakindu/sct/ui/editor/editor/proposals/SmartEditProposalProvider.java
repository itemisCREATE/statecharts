/**
 * Copyright (c) 2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.editor.proposals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.proposals.IEditProposal;
import org.yakindu.sct.ui.editor.proposals.IEditProposalProvider;
import org.yakindu.sct.ui.editor.proposals.ModificationBasedEditProposal;

/**
 * This provider implementation provides the standard high level editing operations.
 *  
 * The first add an new outgoing transition with a new target state. Teh second adds a subregion with entry and initial state.
 *  
 * @author terfloth
 */
public class SmartEditProposalProvider implements IEditProposalProvider {

	@Override
	public List<IEditProposal> getProposals(View view) {
		List<IEditProposal> proposals = new ArrayList<IEditProposal>();

		proposals.add(new ModificationBasedEditProposal(new AddOutgoingStateModification(view), "Add outgoing state", "Adds a new outgoing transition to a new sibling state." , null));
		proposals.add(new ModificationBasedEditProposal(new AddCompositeModification(view), "Add sub region", "Adds a new region to this state. This region includes an initial state.", null));
		
		return proposals;
	}

}
