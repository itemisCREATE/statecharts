/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Markus Muehlbrandt - initial API and implementation
 * 
 */
package de.itemis.gmf.runtime.commons.treelayout.policies;

import java.util.List;

import org.eclipse.draw2d.ColorConstants;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.RoundedRectangle;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.GraphicalEditPart;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.commands.UnexecutableCommand;
import org.eclipse.gef.requests.AlignmentRequest;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gef.requests.CreateRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.LabelEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.XYLayoutEditPolicy;
import org.eclipse.gmf.runtime.diagram.ui.requests.CreateViewAndElementRequest;

import de.itemis.gmf.runtime.commons.treelayout.TreeLayoutConstraint;
import de.itemis.gmf.runtime.commons.treelayout.TreeLayoutUtil;
import de.itemis.gmf.runtime.commons.treelayout.commands.UpdateAnnotationsOnCreationCommand;
import de.itemis.gmf.runtime.commons.treelayout.commands.UpdateAnnotationsOnMoveCommand;

/**
 * 
 * @author Markus Muehlbrandt
 *
 */
public class TreeLayoutEditPolicy extends XYLayoutEditPolicy {

	private IFigure feedbackFigure;

	@Override
	protected Command getCreateCommand(CreateRequest request) {
		final CompoundCommand cmd = new CompoundCommand();
		cmd.add(super.getCreateCommand(request));
		if (request instanceof CreateViewAndElementRequest) {
			final CreateViewAndElementRequest req = (CreateViewAndElementRequest) request;
			if (shouldUpdateAnnotationsOnCreation(req)) {
				cmd.add(new ICommandProxy(
						new UpdateAnnotationsOnCreationCommand(getHost()
								.getEditingDomain(), req)));
			}
		}
		return cmd;
	}

	protected boolean shouldUpdateAnnotationsOnCreation(
			CreateViewAndElementRequest request) {
		return true;
	}

	@Override
	protected Object getConstraintFor(ChangeBoundsRequest request,
			GraphicalEditPart child) {

		if (request instanceof AlignmentRequest) {
			return super.getConstraintFor(request, child);
		}
		final Rectangle rect = (Rectangle) super.getConstraintFor(request,
				child);
		final Rectangle cons = getCurrentConstraintFor(child);
		final int newTreePosition = TreeLayoutUtil.getNewTreeNodePosition(
				request.getLocation(),
				TreeLayoutUtil.getSiblings((IGraphicalEditPart) child));
		if (cons instanceof TreeLayoutConstraint) {
			final TreeLayoutConstraint treeLayoutConstraint = (TreeLayoutConstraint) cons;
			return new TreeLayoutConstraint(rect,
					treeLayoutConstraint.isRoot(), newTreePosition);
		}
		return new TreeLayoutConstraint(rect, false, newTreePosition);
	}

	@Override
	protected Command createChangeConstraintCommand(EditPart child,
			Object constraint) {
		if (constraint instanceof TreeLayoutConstraint) {
			if (((TreeLayoutConstraint) constraint).isRoot()) {
				return UnexecutableCommand.INSTANCE;
			} else {
				return new ICommandProxy(new UpdateAnnotationsOnMoveCommand(
						getHost().getEditingDomain(),
						(IGraphicalEditPart) child,
						(TreeLayoutConstraint) constraint));
			}

		}
		return super.createChangeConstraintCommand(child, constraint);
	}

	@Override
	protected void showLayoutTargetFeedback(Request request) {
		if (request instanceof ChangeBoundsRequest) {
			final ChangeBoundsRequest changeBoundsRequest = (ChangeBoundsRequest) request;
			if (!changeBoundsRequest.getEditParts().isEmpty()
					&& !(changeBoundsRequest.getEditParts().get(0) instanceof LabelEditPart)) {

				final IGraphicalEditPart editPart = (IGraphicalEditPart) changeBoundsRequest
						.getEditParts().get(0);

				final List<IGraphicalEditPart> siblingList = TreeLayoutUtil
						.getSiblings(editPart);

				if (!siblingList.isEmpty()) {
					final int newTreePosition = TreeLayoutUtil
							.getNewTreeNodePosition(
									changeBoundsRequest.getLocation(),
									TreeLayoutUtil.getSiblings(editPart));
					Point point;
					if (newTreePosition == 0) {
						// top end
						point = getFeedBackFigurePoint(editPart.getFigure(),
								siblingList, 0, 0);
					} else if (newTreePosition == siblingList.size()) {
						// Bottom end
						point = getFeedBackFigurePoint(editPart.getFigure(),
								siblingList, siblingList.size(),
								siblingList.size());
					} else {
						// Between siblings
						point = getFeedBackFigurePoint(editPart.getFigure(),
								siblingList, newTreePosition - 1,
								newTreePosition);
					}

					final Rectangle bounds = getFeedbackFigureBounds();
					siblingList.get(0).getFigure().translateToAbsolute(bounds);
					bounds.setLocation(point);
					getFeedbackFigure().setBounds(bounds);
					getFeedbackFigure().translateToRelative(
							getFeedbackFigure().getBounds());
					getFeedbackLayer().add(getFeedbackFigure());
					getFeedbackLayer().repaint();
				}
			}
		}
	}

	@Override
	protected void eraseLayoutTargetFeedback(Request request) {
		super.eraseLayoutTargetFeedback(request);
		getFeedbackLayer().getChildren().remove(getFeedbackFigure());
		getFeedbackLayer().repaint();
	}

	/**
	 * Calculates FeedbackfigurePoint in absolute coordinates
	 * 
	 * @param childFigure
	 * @param siblingList
	 * @param lowerIndex
	 * @param upperIndex
	 * @return
	 */
	private Point getFeedBackFigurePoint(IFigure childFigure,
			List<IGraphicalEditPart> siblingList, int lowerIndex, int upperIndex) {
		final Point point = new Point();

		IFigure topFigure;
		IFigure bottomFigure;

		if (lowerIndex == siblingList.size()) {
			topFigure = siblingList.get(lowerIndex - 1).getFigure();
			bottomFigure = siblingList.get(upperIndex - 1).getFigure();
		} else {
			topFigure = siblingList.get(lowerIndex).getFigure();
			bottomFigure = siblingList.get(upperIndex).getFigure();
		}

		final Rectangle absTopFigBounds = topFigure.getBounds().getCopy();
		topFigure.translateToAbsolute(absTopFigBounds);

		final Rectangle absBottomFigBounds = bottomFigure.getBounds().getCopy();
		bottomFigure.translateToAbsolute(absBottomFigBounds);

		final Rectangle feedbackFigBounds = getFeedbackFigureBounds();
		topFigure.translateToAbsolute(feedbackFigBounds);

		point.x = absTopFigBounds.x
				- (feedbackFigBounds.width - absTopFigBounds.width) / 2;

		if (lowerIndex == 0 && upperIndex == 0) {
			// Top end
			point.y = absTopFigBounds.y
					+ (absBottomFigBounds.y - absTopFigBounds.y) / 2 - 5;
		} else if (lowerIndex == siblingList.size()
				&& upperIndex == siblingList.size()) {
			// bottom end
			point.y = absTopFigBounds.y
					+ (absBottomFigBounds.y - absTopFigBounds.y) / 2
					+ absBottomFigBounds.height + 5;
		} else {
			point.y = absTopFigBounds.y
					+ (absBottomFigBounds.y - absTopFigBounds.y) / 2
					+ absBottomFigBounds.height / 2;
		}
		return point;
	}

	private IFigure getFeedbackFigure() {
		if (feedbackFigure == null) {
			final RoundedRectangle pl = new RoundedRectangle();
			pl.setForegroundColor(ColorConstants.black);
			pl.setBackgroundColor(ColorConstants.black);
			pl.setBounds(getFeedbackFigureBounds());
			feedbackFigure = pl;
		}
		return feedbackFigure;
	}

	private Rectangle getFeedbackFigureBounds() {
		return new Rectangle(0, 0, 120, 2);
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}
}
