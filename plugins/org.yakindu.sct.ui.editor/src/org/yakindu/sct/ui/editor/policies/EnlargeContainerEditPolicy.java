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
package org.yakindu.sct.ui.editor.policies;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Dimension;
import org.eclipse.draw2d.geometry.PrecisionRectangle;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.gef.EditPart;
import org.eclipse.gef.EditPolicy;
import org.eclipse.gef.Request;
import org.eclipse.gef.RequestConstants;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.AbstractEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.commands.SetBoundsCommand;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.l10n.DiagramUIMessages;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.yakindu.base.gmf.runtime.editpolicies.SetPreferredSizeRequest;
import org.yakindu.sct.ui.editor.editparts.FixedBendpointEditPolicy;
import org.yakindu.sct.ui.editor.editparts.RegionEditPart;
import org.yakindu.sct.ui.editor.editparts.StateEditPart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class EnlargeContainerEditPolicy extends AbstractEditPolicy {

	// Key for edit policy installation
	public static final Object ROLE = "ResizeContainer";

	// Space between the border of the container and the moved figure
	public static final int SPACEING = 25;

	private Map<IFigure, Rectangle> boundsCache = new HashMap<IFigure, Rectangle>();

	private List<IGraphicalEditPart> containerHierachy;

	@SuppressWarnings("unchecked")
	@Override
	public Command getCommand(Request request) {
		if (!RequestConstants.REQ_RESIZE.equals(request.getType())
				&& !RequestConstants.REQ_MOVE.equals(request.getType())) {
			return null;
		}

		if (request instanceof SetPreferredSizeRequest) {
			showSourceFeedback(request);
		}

		ChangeBoundsRequest cbr = (ChangeBoundsRequest) request;
		CompoundCommand result = new CompoundCommand();

		// Update Bounds of the container hierarchy
		if (containerHierachy != null) {
			for (IGraphicalEditPart currentContainer : containerHierachy) {
				IFigure figure = currentContainer.getFigure();
				SetBoundsCommand boundsCommand = new SetBoundsCommand(getHost().getEditingDomain(),
						DiagramUIMessages.SetLocationCommand_Label_Resize,
						new EObjectAdapter(currentContainer.getNotationView()), figure.getBounds());
				result.add(new ICommandProxy(boundsCommand));
				FixedBendpointEditPolicy editPolicy = (FixedBendpointEditPolicy) currentContainer
						.getEditPolicy(FixedBendpointEditPolicy.ROLE);
				if (editPolicy != null) {
					Command command = editPolicy.getCommand(cbr);
					result.add(command);
				}

				// Update child bounds of elements that stand in the way...
				List<IGraphicalEditPart> children = currentContainer.getParent().getChildren();
				for (IGraphicalEditPart childPart : children) {
					if (cbr.getEditParts().contains(childPart))
						continue;
					IFigure childFigure = childPart.getFigure();
					if (childPart == currentContainer)
						continue;
					SetBoundsCommand childBoundsCommand = new SetBoundsCommand(getHost().getEditingDomain(),
							DiagramUIMessages.SetLocationCommand_Label_Resize,
							new EObjectAdapter(childPart.getNotationView()), childFigure.getBounds());
					result.add(new ICommandProxy(childBoundsCommand));
				}
			}
		}
		return result;
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	@Override
	public void showSourceFeedback(Request request) {
		if (containerHierachy == null) {
			containerHierachy = collectContainerHierachy();
		}
		if (!RequestConstants.REQ_RESIZE.equals(request.getType())
				&& !RequestConstants.REQ_MOVE.equals(request.getType()))
			return;
		showContainerFeedback((ChangeBoundsRequest) request);
	}

	@Override
	public void eraseSourceFeedback(Request request) {
		boundsCache.clear();
		for (IGraphicalEditPart iGraphicalEditPart : containerHierachy) {
			EditPolicy editPolicy = iGraphicalEditPart.getEditPolicy(FixedBendpointEditPolicy.ROLE);
			if (editPolicy != null) {
				editPolicy.eraseSourceFeedback(request);
			}
		}
		containerHierachy = null;
		super.eraseSourceFeedback(request);
	}

	protected void showContainerFeedback(ChangeBoundsRequest request) {
		for (int level = 1; level <= containerHierachy.size(); level++) {
			IGraphicalEditPart containerEditPart = containerHierachy.get(level - 1);
			IFigure containerFigure = containerEditPart.getFigure();
			Rectangle feedbackBounds = getOriginalBounds(containerFigure);
			containerFigure.getParent().translateToAbsolute(feedbackBounds);
			feedbackBounds = calculateFeedbackBounds(request, feedbackBounds, level, containerFigure);
			containerFigure.translateToRelative(feedbackBounds);
			setBounds(containerFigure, feedbackBounds);
			EditPolicy editPolicy = containerEditPart.getEditPolicy(FixedBendpointEditPolicy.ROLE);
			if (editPolicy != null) {
				editPolicy.showSourceFeedback(request);
			}
		}
	}

	protected List<IGraphicalEditPart> collectContainerHierachy() {
		List<IGraphicalEditPart> result = new ArrayList<IGraphicalEditPart>();
		IGraphicalEditPart containerEditPart = (IGraphicalEditPart) getHost();
		while (containerEditPart != null) {
			containerEditPart = getContainer(containerEditPart);
			if (containerEditPart != null)
				result.add(containerEditPart);
		}
		return result;
	}

	/**
	 * Return a copy of the bounds from the cache
	 * 
	 * @param figure
	 * @return
	 */
	private Rectangle getOriginalBounds(IFigure figure) {
		Rectangle originalContainerBounds = boundsCache.get(figure);
		if (originalContainerBounds == null) {
			originalContainerBounds = figure.getBounds().getCopy();
			boundsCache.put(figure, originalContainerBounds);
		}
		return boundsCache.get(figure).getCopy();
	}

	private IGraphicalEditPart getContainer(IGraphicalEditPart host) {
		IGraphicalEditPart containerEditPart = getParentState(host);
		if (containerEditPart == null) {
			containerEditPart = getParentRegion(host);
			if (containerEditPart == null)
				return null;
		}
		return containerEditPart;
	}

	protected void setBounds(IFigure figure, Rectangle bounds) {
		figure.setBounds(bounds);
		figure.getParent().setConstraint(figure, bounds);
	}

	@SuppressWarnings({ "unchecked" })
	private Rectangle calculateFeedbackBounds(ChangeBoundsRequest request, Rectangle feedbackBounds, int level,
			IFigure containerFigure) {
		Rectangle result = feedbackBounds.getCopy();
		List<IGraphicalEditPart> editParts = request.getEditParts();
		for (IGraphicalEditPart editPart : editParts) {
			PrecisionRectangle transformedRect = new PrecisionRectangle(editPart.getFigure().getBounds());
			editPart.getFigure().translateToAbsolute(transformedRect);
			transformedRect.expand(SPACEING * level, SPACEING * level);
			result.union(transformedRect);
			Dimension preferredSize = containerFigure.getPreferredSize().getCopy();
			editPart.getFigure().translateToAbsolute(preferredSize);
			Dimension max = Dimension.max(result.getSize(), preferredSize);
			result.setSize(max);
			if (result.x < feedbackBounds.x) {
				result.x = feedbackBounds.x;
			}
			if (result.y < feedbackBounds.y) {
				result.y = feedbackBounds.y;
			}
		}
		return result;
	}

	protected IGraphicalEditPart getParentRegion(EditPart part) {
		part = part.getParent();
		while (!(part instanceof RegionEditPart)) {
			part = part.getParent();
			if (part == null)
				return null;
		}
		return (IGraphicalEditPart) part;
	}

	protected IGraphicalEditPart getParentState(EditPart part) {
		part = part.getParent();
		while (!(part instanceof StateEditPart)) {
			part = part.getParent();
			if (part == null)
				return null;
		}
		return (IGraphicalEditPart) part;
	}
}
