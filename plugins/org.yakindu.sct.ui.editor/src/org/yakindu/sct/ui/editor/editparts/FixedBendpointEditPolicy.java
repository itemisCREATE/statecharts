/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
*
* Contributors:
* 	andreas muelder - itemis AG
*
*/
package org.yakindu.sct.ui.editor.editparts;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.draw2d.geometry.Vector;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.Request;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.editpolicies.GraphicalEditPolicy;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.yakindu.base.gmf.runtime.router.ConnData;
import org.yakindu.base.gmf.runtime.router.RubberBandRoutingSupport;
import org.yakindu.base.xtext.utils.gmf.commands.SetLabelsOffsetOperation;
import org.yakindu.base.xtext.utils.gmf.directedit.ExternalXtextLabelEditPart;
import org.yakindu.base.xtext.utils.gmf.routing.EdgeLabelLocator;
import org.yakindu.sct.ui.editor.commands.SetConnectionBendpointsAndLabelCommmand;

public class FixedBendpointEditPolicy extends GraphicalEditPolicy {

	public static final String ROLE = "Fixed_Bendpoints";

	private boolean connectionStart = true;
	private Rectangle originalBounds = null;

	private RubberBandRoutingSupport router = new RubberBandRoutingSupport();

	private Rectangle origBoundsRel;

	@SuppressWarnings("unchecked")
	public Command createUpdateAllBendpointsCommand() {
		CompoundCommand result = new CompoundCommand();
		List<IGraphicalEditPart> sourceConnections = getHost().getSourceConnections();
		for (IGraphicalEditPart part : sourceConnections) {
			result.add(getBendpointsChangedCommand((ConnectionEditPart) part));
		}
		List<IGraphicalEditPart> targetConnections = getHost().getTargetConnections();
		for (IGraphicalEditPart part : targetConnections) {
			result.add(getBendpointsChangedCommand((ConnectionEditPart) part));
		}
		if (result.size() == 0) {
			return null;
		}
		return result;
	}

	protected void eraseChangeBoundsFeedback(ChangeBoundsRequest request) {
		connectionStart = true;
		router.commitBoxDrag();
	}

	@Override
	public void eraseSourceFeedback(Request request) {
		if (request instanceof ChangeBoundsRequest) {
			eraseChangeBoundsFeedback((ChangeBoundsRequest) request);
		}
	}

	@SuppressWarnings("restriction")
	protected Command getBendpointsChangedCommand(ConnectionEditPart part) {
		Connection connection = part.getConnectionFigure();
		Point ptRef1 = connection.getSourceAnchor().getReferencePoint();
		connection.translateToRelative(ptRef1);

		Point ptRef2 = connection.getTargetAnchor().getReferencePoint();
		connection.translateToRelative(ptRef2);

		TransactionalEditingDomain editingDomain = getHost().getEditingDomain();

		SetConnectionBendpointsAndLabelCommmand sbbCommand = new SetConnectionBendpointsAndLabelCommmand(editingDomain);
		sbbCommand.setEdgeAdapter(new EObjectAdapter((EObject) part.getModel()));
		sbbCommand.setNewPointList(connection.getPoints(), ptRef1, ptRef2);
		sbbCommand.setLabelsToUpdate(part,
				router.getCD(part.getFigure()).convertToPointList(router.getCD(part.getFigure()).initialVisualPoints));

		return new ICommandProxy(sbbCommand);
	}

	@Override
	public Command getCommand(Request request) {
		if (request instanceof ChangeBoundsRequest) {
			return createUpdateAllBendpointsCommand();
		}
		return super.getCommand(request);
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	private List<Connection> getSourceConnections() {
		List<Connection> result = new ArrayList<>();
		List<IGraphicalEditPart> sourceConnections = getHost().getSourceConnections();
		for (IGraphicalEditPart iGraphicalEditPart : sourceConnections) {
			Connection connection = (Connection) iGraphicalEditPart.getFigure();
//			if (connection.getSourceAnchor().getOwner() != getHostFigure()) {
//				continue;
//			}
			result.add(connection);
//			System.out.println(System.identityHashCode(this) + " :: source connection: "
//					+ connection.getSourceAnchor().getOwner().getBounds() + " TO "
//					+ connection.getTargetAnchor().getOwner().getBounds());
		}
		return result;
	}

	private List<Connection> getTargetConnections() {
		List<Connection> result = new ArrayList<>();
		List<IGraphicalEditPart> targetConnections = getHost().getTargetConnections();
		for (IGraphicalEditPart iGraphicalEditPart : targetConnections) {
			Connection connection = (Connection) iGraphicalEditPart.getFigure();
//			if (connection.getTargetAnchor().getOwner() != getHostFigure()) {
//				continue;
//			}
			result.add(connection);
//			System.out.println(System.identityHashCode(this) + " :: target connection: "
//					+ connection.getSourceAnchor().getOwner().getBounds() + " TO "
//					+ connection.getTargetAnchor().getOwner().getBounds());
		}
		return result;
	}

	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		if (request.getEditParts().get(0) != getHost()) {
			// keep all connections in place
			if (connectionStart) {
				originalBounds = getHostFigure().getBounds().getCopy();
				startConnection(originalBounds, getSourceConnections(), getTargetConnections());
				connectionStart = false;
			} else {
				updateConnection(originalBounds);
			}
		} else {
			if (connectionStart) {
				IFigure figure = getHostFigure();
				originalBounds = getHostFigure().getBounds().getCopy();
				origBoundsRel = originalBounds.getCopy();
				figure.translateToAbsolute(originalBounds);
				originalBounds.translate(request.getMoveDelta().getNegated())
						.resize(request.getSizeDelta().getNegated());
				startConnection(originalBounds, getSourceConnections(), getTargetConnections());
				connectionStart = false;
			} else {
				updateConnection(request.getTransformedRectangle(originalBounds.getCopy()));
			}
		}
	}

	private void showLineFeedback(ConnectionEditPart connectionEditPart) {
		List<?> children = connectionEditPart.getChildren();
		Connection connection = connectionEditPart.getConnectionFigure();
		for (Object child : children) {
			if (child instanceof ExternalXtextLabelEditPart) {
				IFigure figure = ((ExternalXtextLabelEditPart) child).getFigure();
				Object currentConstraint = connection.getLayoutManager().getConstraint(figure);
				if (currentConstraint instanceof EdgeLabelLocator) {
					EdgeLabelLocator edgeLabelLocator = (EdgeLabelLocator) currentConstraint;

					ConnData cd = router.getCD(connection);
					PointList initialPoints = cd.convertToPointList(cd.initialVisualPoints);

					edgeLabelLocator.setFeedbackData(initialPoints,
							new Vector(edgeLabelLocator.getOffset().x, edgeLabelLocator.getOffset().y),
							SetLabelsOffsetOperation.isEdgeWithObliqueRoutingStyle(connectionEditPart));

				}
			}
		}
	}

	@Override
	public void showSourceFeedback(Request request) {
		if (request instanceof ChangeBoundsRequest) {
			showChangeBoundsFeedback((ChangeBoundsRequest) request);
			for (Object object : getHost().getSourceConnections()) {
				showLineFeedback((ConnectionEditPart) object);
			}
			for (Object object : getHost().getTargetConnections()) {
				showLineFeedback((ConnectionEditPart) object);
			}
		}
	}

	public void startConnection(Rectangle original, List<Connection> source, List<Connection> target) {
		router.initBoxDrag(original, source, target);
	}

	public void updateConnection(Rectangle newBounds) {
		router.updateBoxDrag(newBounds);
	}
}
