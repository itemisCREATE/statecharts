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
package org.yakindu.sct.ui.editor.proposals;

import java.util.List;

import org.eclipse.gef.GraphicalViewer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.parts.DirectEditKeyHandler;
import org.eclipse.jface.bindings.keys.KeyStroke;
import org.eclipse.jface.fieldassist.ContentProposalAdapter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.graphics.Point;
import org.eclipse.swt.widgets.Composite;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
@SuppressWarnings("restriction")
public class ContentProposalViewerKeyHandler extends DirectEditKeyHandler {

	private ContentProposalHandler proposalHandler;

	private ContentProposalAdapter adapter;

	protected static final KeyStroke keyStroke = KeyStroke.getInstance(SWT.CTRL, SWT.SPACE);

	public ContentProposalViewerKeyHandler(GraphicalViewer viewer) {
		super(viewer);
		createProposalHandler();
		createContentAdpater();
	}

	protected void createProposalHandler() {
		proposalHandler = new ContentProposalHandler(getViewer());
	}

	protected void createContentAdpater() {
//		SemanticContentControlAdapter controlAdapter = new SemanticContentControlAdapter(proposalProvider, getViewer());
		adapter = new ContentProposalAdapter((Composite) getViewer().getControl(), proposalHandler.getProposalControlAdapter(), proposalHandler,
				keyStroke, null);
		adapter.setLabelProvider(proposalHandler.getProposalLabelProvider());
		adapter.setPropagateKeys(true);
		// TODO: If not set, the adapter uses the full width of the
		// GraphicalViewer as initial bounds
		adapter.setPopupSize(new Point(400, 150));
	}

	
	@Override
	public boolean keyPressed(KeyEvent e) {
		if (getCurrentSelection() == null)
			return super.keyPressed(e);
		if ((e.character == ' ') && ((e.stateMask & SWT.CTRL) != 0)) {
			// Do not execute super - the default ctrl key binding is a
			// deselection of the current selected element for whatever
			// reason
			return true;
		}
		return super.keyPressed(e);
	}

	@SuppressWarnings("unchecked")
	protected IGraphicalEditPart getCurrentSelection() {
		List<IGraphicalEditPart> selectedEditParts = getViewer().getSelectedEditParts();
		if (selectedEditParts.size() == 1) {
			IGraphicalEditPart editPart = (IGraphicalEditPart) selectedEditParts.get(0);
			return editPart;
		}
		return null;

	}
}
