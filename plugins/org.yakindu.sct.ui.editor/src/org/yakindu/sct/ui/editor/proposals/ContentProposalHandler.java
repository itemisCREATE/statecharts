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
package org.yakindu.sct.ui.editor.proposals;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.fieldassist.ContentProposal;
import org.eclipse.jface.fieldassist.IContentProposal;
import org.eclipse.jface.fieldassist.IContentProposalProvider;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;
import org.yakindu.sct.domain.extension.DomainRegistry;
import org.yakindu.sct.domain.extension.IDomainInjectorProvider;
import org.yakindu.sct.ui.editor.StatechartImages;

import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * As a composite instances of this class provide an array of proposals that are assembled from the a set of proposal providers. 
 * 
 * @author terfloth - initial contribution
 */
public class ContentProposalHandler implements IContentProposalProvider {

	@Inject protected Set<IEditProposalProvider> proposalProviders;
	
	protected GraphicalViewer viewer;

	private IControlContentAdapter proposalControlAdapter;

	private ILabelProvider proposalLabelProvider;
	
	
	
	public ContentProposalHandler(GraphicalViewer viewer) {
		super();
		this.viewer = viewer;
		this.proposalControlAdapter = new ProposalControlAdapter();
		this.proposalLabelProvider = new ProposalLabelProvider();
	}


	public IControlContentAdapter getProposalControlAdapter() {
		return proposalControlAdapter;
	}


	public ILabelProvider getProposalLabelProvider() {
		return proposalLabelProvider;
	}

	
	@Override
	public IContentProposal[] getProposals(String contents, int position) {

		intProposalProvidersOnDemand();
		List<IEditProposal> editProposals = collectEditProposals();
		editProposals = sort(editProposals);
					
		return contentProposalsFrom(editProposals);
	}


	protected void intProposalProvidersOnDemand() {
	
		try {
			if (proposalProviders == null) {
				IDomainInjectorProvider injectorProvider = DomainRegistry.getDomainDescriptor(getSelectedView().getElement())
						.getDomainInjectorProvider();
				
				Injector injector = injectorProvider.getEditorInjector();
				injector.injectMembers(this);
			}
		} catch (Throwable t) {
			System.out.println(t);
		}
	
	}


	/**		
	 * Collects all edit proposals from contained poroposal providers.
	 * @return
	 */
	protected List<IEditProposal> collectEditProposals() {
		List<IEditProposal> proposals = new ArrayList<IEditProposal>();
		
		// collect all IEditProposals
		View selectedView = getSelectedView();
		if ( selectedView != null ) {
			if (proposalProviders != null) {
				for (IEditProposalProvider provider : proposalProviders) {
					for (IEditProposal editProposal : provider.getProposals(selectedView)) {
						if (editProposal.isApplicable()) proposals.add(editProposal);
					}
				}
			}
		}
		return proposals;
	}


	/**
	 * @return the first selected view from the graphical viewer or null 
	 */
	protected View getSelectedView() {
		View selectedView = null;
		if ( viewer.getSelectedEditParts().size() > 0 )  {
			if ( viewer.getSelectedEditParts().get(0) instanceof IGraphicalEditPart ){
				selectedView = ((IGraphicalEditPart) viewer.getSelectedEditParts().get(0)).getNotationView();
			}
		}
		return selectedView;
	}


	/**
	 * A hook for sorting the proposals. 
	 * 
	 * @param the original list of proposals
	 * @return A sorted proposal list
	 */
	protected List<IEditProposal> sort(List<IEditProposal> proposals) {
		// currently we do nothing here.
		return proposals;
	}
	
	
	/**
	 * Wraps the edit proposals in jface IContentProposal instances.
	 * @param editProposals
	 * @return
	 */
	protected IContentProposal[] contentProposalsFrom(List<IEditProposal> editProposals) {
		IContentProposal[] contentProposals = new IContentProposal[editProposals.size()];
		
		for (int i= 0; i< editProposals.size(); i++) {
			contentProposals[i] = new EditProposalWrapper(editProposals.get(i));
		}
		
		return contentProposals;
	}
	
	/**
	 * @param id The id of a proposal.
	 * @return The proposal that matches the specified id or null.
	 */
	protected IEditProposal getProposalById(String id) {

		List<IEditProposal> editProposals = collectEditProposals();
		
		if (id != null) {
			for (IEditProposal editProposal : editProposals) {
				if (id.equals(editProposal.getId())) return editProposal;
			}
		}
		
		return null;
	}

	
	/**
	 * 
	 * @author terfloth
	 */
	protected static class EditProposalWrapper extends ContentProposal {
		
		protected IEditProposal wrappedProposal;
		
		public EditProposalWrapper(IEditProposal editProposal) {
			super(editProposal.getId(), editProposal.getLabel(), editProposal.getDescription());
			this.wrappedProposal = editProposal;
		}
		
		public IEditProposal getEditProposal(){
			return wrappedProposal;
		}
		
	}
	
	
	/**
	 * @author terfloth
	 */
	public static class ProposalLabelProvider extends LabelProvider {

		protected Image defaultImage;

		public ProposalLabelProvider() {
			defaultImage = StatechartImages.SUB_STATECHART_PICTOGRAM.image();
		}

		@Override
		public String getText(Object element) {
			if (element instanceof IContentProposal) {
				return ((IContentProposal) element).getLabel();
			}
			return super.getText(element);
		}

		@Override
		public Image getImage(Object element) {
			
			Image image = null;
			if (element instanceof EditProposalWrapper) {
				image = ((EditProposalWrapper) element).getEditProposal().getImage();
			}
			
			return (image != null)? image : defaultImage;
		}

	}

	
	/**
	 * 
	 * @author andreas muelder - Initial contribution and API
	 * 
	 */
	protected class ProposalControlAdapter implements IControlContentAdapter {

		public Rectangle getInsertionBounds(Control control) {
			IFigure figure = ((IGraphicalEditPart) viewer.getSelectedEditParts().get(0)).getFigure();
			org.eclipse.draw2d.geometry.Rectangle bounds = figure.getBounds().getCopy();
			figure.translateToAbsolute(bounds);
			return new Rectangle(bounds.getTopRight().x, bounds.getTopRight().y, 100, 0);
		}

		public void insertControlContents(Control control, String id, int cursorPosition) {
			IEditProposal proposal = getProposalById(id);
			// TODO:Multi selection
			if (proposal.isApplicable()) proposal.apply();
		}

		public String getControlContents(Control control) {
			// Nothing to do
			return null;
		}

		public int getCursorPosition(Control control) {
			// Nothing to do
			return 0;
		}

		public void setCursorPosition(Control control, int index) {
			// Nothing to do
		}

		public void setControlContents(Control control, String contents, int cursorPosition) {
			// Nothing to do
		}

	}

}
