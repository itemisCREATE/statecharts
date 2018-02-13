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
import org.eclipse.draw2d.PositionConstants;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PrecisionPoint;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.handles.HandleBounds;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramRootEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.draw2d.ui.figures.BaseSlidableAnchor;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.gef.ui.figures.SlidableAnchor;
import org.eclipse.gmf.runtime.notation.Anchor;
import org.eclipse.gmf.runtime.notation.Edge;
import org.eclipse.gmf.runtime.notation.IdentityAnchor;
import org.eclipse.gmf.runtime.notation.NotationFactory;
import org.eclipse.gmf.runtime.notation.View;

/**
 * 
 * Recalculates the {@link IdentityAnchor}s to recalculate connection anchors
 * when a node is resized
 * 
 * Parts are copied from Sirius ShiftEdgeIdentityAnchorOperation
 * 
 */
public class AdjustIdentityAnchorCommand extends AbstractTransactionalCommand {

	final private static char TERMINAL_START_CHAR = '(';
	final private static char TERMINAL_DELIMITER_CHAR = ',';
	final private static char TERMINAL_END_CHAR = ')';

	private final static PrecisionPoint DEFAULT_POINT = new PrecisionPoint(0.5d, 0.5d);

	private ChangeBoundsRequest request;

	private Dimension futureSize;

	private PrecisionPoint delta;

	public AdjustIdentityAnchorCommand(TransactionalEditingDomain domain, ChangeBoundsRequest request) {
		super(domain, "Adjusting anchors", null);
		this.request = request;

	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		@SuppressWarnings("unchecked")
		List<IGraphicalEditPart> editParts = request.getEditParts();
		for (IGraphicalEditPart editPart : editParts) {
			adjustAnchors(editPart);
		}
		return CommandResult.newOKCommandResult();
	}

	@SuppressWarnings("unchecked")
	protected void adjustAnchors(IGraphicalEditPart editPart) {
		if (editPart instanceof IGraphicalEditPart) {
			View view = ((IGraphicalEditPart) editPart).getNotationView();
			List<Edge> targetEdges = view.getTargetEdges();
			for (Edge edge : targetEdges) {
				handleEdge(edge, editPart, false);
			}
			List<Edge> sourceEdges = view.getSourceEdges();
			for (Edge edge : sourceEdges) {
				handleEdge(edge, editPart, true);
			}
		}
	}

	private void handleEdge(Edge edge, EditPart editPart, boolean sourceAnchor) {
		Anchor anchorToModify;
		if (sourceAnchor) {
			anchorToModify = edge.getSourceAnchor();
		} else {
			anchorToModify = edge.getTargetAnchor();
		}
		String terminalString = composeTerminalString(DEFAULT_POINT);
		if (anchorToModify instanceof IdentityAnchor) {
			terminalString = ((IdentityAnchor) anchorToModify).getId();
		}
		PrecisionPoint anchorPoint = BaseSlidableAnchor.parseTerminalString(terminalString);
		PrecisionPoint newPoint = computeNewAnchor(anchorPoint, editPart);
		String newTerminalString = new SlidableAnchor(null, newPoint).getTerminal();
		if (anchorToModify instanceof IdentityAnchor) {
			((IdentityAnchor) anchorToModify).setId(newTerminalString);
		} else if (anchorToModify == null) {
			// Create a new one
			IdentityAnchor newAnchor = NotationFactory.eINSTANCE.createIdentityAnchor();
			newAnchor.setId(newTerminalString);
			if (sourceAnchor) {
				edge.setSourceAnchor(newAnchor);
			} else {
				edge.setTargetAnchor(newAnchor);
			}
		}
	}

	protected double getScale(EditPart part) {
		double scale = 1.0;
		if (part.getRoot() instanceof DiagramRootEditPart) {
			DiagramRootEditPart rootEditPart = (DiagramRootEditPart) part.getRoot();
			scale = rootEditPart.getZoomManager().getZoom();
		}
		return scale;
	}

	private PrecisionPoint computeNewAnchor(PrecisionPoint currentAnchorPoint, EditPart editPart) {

		double scale = getScale(editPart);
		IFigure figure = ((IGraphicalEditPart) editPart).getFigure();
		Rectangle bounds = figure.getBounds();
		if (figure instanceof HandleBounds) {
			bounds = ((HandleBounds) figure).getHandleBounds();
		}

		Point currentRelativePoint = getAnchorRelativePoint(currentAnchorPoint, bounds);

		if (futureSize != null && delta != null) {
			// In case of border node, the real location is computed earlier
			// (according to BorderItemLocator). The corresponding futureSize
			// and delta are used instead of the request data.
			return new PrecisionPoint(((double) (currentRelativePoint.x - delta.x)) / futureSize.width,
					((double) (currentRelativePoint.y - delta.y)) / futureSize.height);
		} else {

			double logicalWidthDelta = request.getSizeDelta().width / scale;
			double logicalHeightDelta = request.getSizeDelta().height / scale;

			int direction = request.getResizeDirection();

			double newRelativeX = computeNewXRelativeLocation(direction, currentRelativePoint, logicalWidthDelta);
			double newRelativeY = computeNewYRelativeLocation(direction, currentRelativePoint, logicalHeightDelta);

			return new PrecisionPoint(newRelativeX / (bounds.width() + logicalWidthDelta),
					newRelativeY / (bounds.height() + logicalHeightDelta));
		}
	}

	protected Point getAnchorRelativePoint(PrecisionPoint currentAnchorPoint, Rectangle bounds) {
		return new PrecisionPoint(bounds.width() * currentAnchorPoint.preciseX(),
				bounds.height() * currentAnchorPoint.preciseY());
	}

	private double computeNewXRelativeLocation(int direction, Point currentRelativePoint, double logicalWidthDelta) {

		if (direction == PositionConstants.NORTH_WEST || direction == PositionConstants.WEST
				|| direction == PositionConstants.SOUTH_WEST) {
			return currentRelativePoint.preciseX() + logicalWidthDelta;
		} else {

			return currentRelativePoint.preciseX();
		}
	}

	protected double computeNewYRelativeLocation(int direction, Point currentRelativePoint, double logicalHeightDelta) {

		if (direction == PositionConstants.NORTH_WEST || direction == PositionConstants.NORTH
				|| direction == PositionConstants.NORTH_EAST) {
			return currentRelativePoint.preciseY() + logicalHeightDelta;
		} else {
			return currentRelativePoint.preciseY();
		}
	}

	protected String composeTerminalString(PrecisionPoint p) {
		StringBuffer s = new StringBuffer(24);
		s.append(TERMINAL_START_CHAR);
		s.append(p.preciseX());
		s.append(TERMINAL_DELIMITER_CHAR);
		s.append(p.preciseY());
		s.append(TERMINAL_END_CHAR);
		return s.toString();
	}
}
