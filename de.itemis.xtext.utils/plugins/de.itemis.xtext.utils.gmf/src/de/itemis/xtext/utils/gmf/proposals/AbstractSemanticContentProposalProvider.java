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
package de.itemis.xtext.utils.gmf.proposals;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.fieldassist.IContentProposalProvider;

import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSemanticContentProposalProvider implements IContentProposalProvider {

	public static interface IProposalAcceptor {
		public void accept(ISemanticContentProposal proposal);
	}

	public class ListBasedProposalAcceptor implements IProposalAcceptor {
		private List<ISemanticContentProposal> allProposals = new ArrayList<ISemanticContentProposal>();

		public void accept(ISemanticContentProposal proposal) {
			allProposals.add(proposal);
		}

		public List<ISemanticContentProposal> getAllProposals() {
			return allProposals;
		}
	}

	private ListBasedProposalAcceptor acceptor;

	private GraphicalViewer viewer;

	public abstract void createProposals(IProposalAcceptor acceptor);

	public AbstractSemanticContentProposalProvider(GraphicalViewer viewer) {
		this.viewer = viewer;
		acceptor = new ListBasedProposalAcceptor();
		createProposals(acceptor);
	}

	public final ISemanticContentProposal[] getProposals(String contents, int position) {
		// TODO: How to handle multi selection
		final IGraphicalEditPart selectedEditPart = (IGraphicalEditPart) viewer.getSelectedEditParts().get(0);
		Iterable<ISemanticContentProposal> validProposals = Iterables.filter(acceptor.getAllProposals(),
				new Predicate<ISemanticContentProposal>() {
					public boolean apply(ISemanticContentProposal input) {
						return input.getSemanticModification().IsModificationFor(
								(selectedEditPart.resolveSemanticElement()));
					}
				});
		return Iterables.toArray(validProposals, ISemanticContentProposal.class);
	}

	public ISemanticContentProposal getProposal(final String id) {
		return Iterables.find(acceptor.getAllProposals(), new Predicate<ISemanticContentProposal>() {
			public boolean apply(ISemanticContentProposal input) {
				return id.equals(input.getID());
			}
		});
	}
}
