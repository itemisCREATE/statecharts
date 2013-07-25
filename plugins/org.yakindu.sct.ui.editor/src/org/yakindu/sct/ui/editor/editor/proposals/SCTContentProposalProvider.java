/**
 * Copyright (c) 2013 committers of YAKINDU and others.
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

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.Platform;
import org.eclipse.gef.GraphicalViewer;
import org.yakindu.sct.ui.editor.StatechartImages;

import de.itemis.xtext.utils.gmf.proposals.AbstractSemanticContentProposalProvider;
import de.itemis.xtext.utils.gmf.proposals.ISemanticContentProposal;
import de.itemis.xtext.utils.gmf.proposals.ISemanticModification;
import de.itemis.xtext.utils.gmf.proposals.SemanticContentProposal;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTContentProposalProvider extends AbstractSemanticContentProposalProvider {

	private static final String PROPOSAL_EXTENSION = "org.yakindu.sct.ui.editor.proposals";

	private static final String ID = "id";

	private static final String LABEL = "label";

	private static final String DESCRIPTION = "description";

	private static final String MODIFICATION = "modification";

	public SCTContentProposalProvider(GraphicalViewer viewer) {
		super(viewer);
	}

	@Override
	public void createProposals(IProposalAcceptor acceptor) {
		List<ISemanticContentProposal> registeredProposals;
		try {
			registeredProposals = getRegisteredProposals();
			for (ISemanticContentProposal proposal : registeredProposals) {
				acceptor.accept(proposal);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<ISemanticContentProposal> getRegisteredProposals() throws Exception {
		List<ISemanticContentProposal> result = new ArrayList<ISemanticContentProposal>();
		IConfigurationElement[] configurationElements = Platform.getExtensionRegistry().getConfigurationElementsFor(
				PROPOSAL_EXTENSION);
		for (IConfigurationElement configurationElement : configurationElements) {
			String id = configurationElement.getAttribute(ID);
			String label = configurationElement.getAttribute(LABEL);
			String description = configurationElement.getAttribute(DESCRIPTION);
			ISemanticModification modification = (ISemanticModification) configurationElement
					.createExecutableExtension(MODIFICATION);
			// TODO: Move image to extension point
			SemanticContentProposal proposal = new SemanticContentProposal(id, label, description,
					StatechartImages.SUB_STATECHART_PICTOGRAM.image(), modification);
			result.add(proposal);
		}
		return result;
	}

}
