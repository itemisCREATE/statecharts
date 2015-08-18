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
package org.yakindu.base.xtext.utils.gmf.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.View;

/**
 * EXPERIMENTAL !!
 * 
 * Recalculates the {@link IdentityAnchor}s to recalculate connection anchors
 * when a node is resized
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class AdjustIdentityAnchorCommand extends AbstractTransactionalCommand {

	private ChangeBoundsRequest request;
	private List<IGraphicalEditPart> editParts;

	@SuppressWarnings("unchecked")
	public AdjustIdentityAnchorCommand(TransactionalEditingDomain domain, ChangeBoundsRequest request) {
		super(domain, "Adjusting anchors", null);
		this.request = request;
		editParts = request.getEditParts();

	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		for (EditPart editPart : editParts) {
			adjustAnchors(editPart);
		}
		return CommandResult.newOKCommandResult();
	}

	@SuppressWarnings("unchecked")
	private void adjustAnchors(EditPart editPart) {
		if (editPart instanceof IGraphicalEditPart) {
			View view = ((IGraphicalEditPart) editPart).getNotationView();
			EList<Edge> targetEdges = view.getTargetEdges();
			for (Edge edge : targetEdges) {
				Anchor targetAnchor = edge.getTargetAnchor();
				if (targetAnchor instanceof IdentityAnchor) {
					PrecisionPoint anchorPoint = BaseSlidableAnchor.parseTerminalString(((IdentityAnchor) targetAnchor)
							.getId());
					IFigure figure = ((IGraphicalEditPart) editPart).getFigure();
					Dimension sizeBefore = figure.getBounds().getSize();
					float widthFactor = (float) (sizeBefore.width() + request.getSizeDelta().width())
							/ (float) sizeBefore.width();
					float heightFactor = (float) (sizeBefore.height() + request.getSizeDelta().height())
							/ (float) sizeBefore.height();
					PrecisionPoint newPoint = new PrecisionPoint(anchorPoint.preciseX() / widthFactor,
							anchorPoint.preciseY() / heightFactor);
					((IdentityAnchor) targetAnchor).setId(composeTerminalString(newPoint));
				}
			}
		}

	}

	// Copied from BaseSlideableAnchor
	final private static char TERMINAL_START_CHAR = '(';
	final private static char TERMINAL_DELIMITER_CHAR = ',';
	final private static char TERMINAL_END_CHAR = ')';

	protected String composeTerminalString(PrecisionPoint p) {
		StringBuffer s = new StringBuffer(24);
		s.append(TERMINAL_START_CHAR); // 1 char
		s.append(p.preciseX()); // 10 chars
		s.append(TERMINAL_DELIMITER_CHAR); // 1 char
		s.append(p.preciseY()); // 10 chars
		s.append(TERMINAL_END_CHAR); // 1 char
		return s.toString(); // 24 chars max (+1 for safety, i.e. for string
								// termination)
	}

}
