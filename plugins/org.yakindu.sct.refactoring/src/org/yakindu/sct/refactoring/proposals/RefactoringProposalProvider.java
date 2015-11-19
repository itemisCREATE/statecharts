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
package org.yakindu.sct.refactoring.proposals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gmf.runtime.notation.View;
import org.yakindu.sct.ui.editor.proposals.IEditProposal;
import org.yakindu.sct.ui.editor.proposals.IEditProposalProvider;
import org.yakindu.sct.ui.editor.proposals.ModificationBasedEditProposal;

/**
 * This provider implementation provides the rafactorings as proposals.
 *  
 * @author terfloth
 */
public class RefactoringProposalProvider implements IEditProposalProvider {

	@Override
	public List<IEditProposal> getProposals(View view) {
		List<IEditProposal> proposals = new ArrayList<IEditProposal>();

		proposals.add(new ModificationBasedEditProposal(
				new ExtractSubdiagramModification(view), 
				"Refactoring - Extract Subdiagram", 
				"Extracts all sub regions into a sub diagram.<br> " +
				"Direct transitions into the diagram will be substituted by entries and outgoing transitions will be substituted using exit nodes. " +
				"<i>Sub diagrams are opened seperately</i>." , 
				null));
		proposals.add(new ModificationBasedEditProposal(
				new InlineSubdiagramModification(view), 
				"Refactoring - Inline Subdiagram", 
				"Inlines the existing subdiagram. The region includes an initial state.", 
				null));
		
		return proposals;
	}

}
