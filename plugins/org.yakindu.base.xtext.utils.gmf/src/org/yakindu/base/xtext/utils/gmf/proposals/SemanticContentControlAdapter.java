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
package org.yakindu.base.xtext.utils.gmf.proposals;

import org.eclipse.draw2d.IFigure;
import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.fieldassist.IControlContentAdapter;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.widgets.Control;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SemanticContentControlAdapter implements IControlContentAdapter {

	private AbstractSemanticContentProposalProvider provider;
	private GraphicalViewer viewer;

	public SemanticContentControlAdapter(AbstractSemanticContentProposalProvider provider, GraphicalViewer viewer) {
		this.provider = provider;
		this.viewer = viewer;
	}

	public Rectangle getInsertionBounds(Control control) {
		IFigure figure = ((IGraphicalEditPart) viewer.getSelectedEditParts().get(0)).getFigure();
		org.eclipse.draw2d.geometry.Rectangle bounds = figure.getBounds().getCopy();
		figure.translateToAbsolute(bounds);
		return new Rectangle(bounds.getTopRight().x, bounds.getTopRight().y, 100, 0);
	}

	public void insertControlContents(Control control, String id, int cursorPosition) {
		ISemanticContentProposal proposal = provider.getProposal(id);
		// TODO:Multi selection
		IGraphicalEditPart editPart = (IGraphicalEditPart) viewer.getSelectedEditParts().get(0);
		proposal.getSemanticModification().modify(editPart.getNotationView());
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
