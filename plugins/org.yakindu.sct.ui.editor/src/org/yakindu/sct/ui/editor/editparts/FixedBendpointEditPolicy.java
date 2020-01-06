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
import org.eclipse.gmf.runtime.diagram.ui.requests.RequestConstants;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.yakindu.base.gmf.runtime.router.ConnData;
import org.yakindu.base.gmf.runtime.router.RelativeBendpointUtil;
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
	private RelativeBendpointUtil relbpUtil = new RelativeBendpointUtil();

	public Command createUpdateAllBendpointsCommand() {
		CompoundCommand result = new CompoundCommand();
		for (ConnectionEditPart part : getAllConnectionParts()) {
			result.add(getBendpointsChangedCommand(part));
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

	@SuppressWarnings("unchecked")
	public List<ConnectionEditPart> getAllConnectionParts() {
		List<ConnectionEditPart> conns = new ArrayList<>();
		conns.addAll(getHost().getSourceConnections());
		conns.addAll(getHost().getTargetConnections());
		return conns;
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
		sbbCommand.setLabelsToUpdate(part, getInitialPoints(connection));

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

	private PointList getInitialPoints(Connection connection) {
		ConnData cd = router.getCD(connection);
		if (cd != null) {
			return relbpUtil.convertToPointList(cd.initialVisualPoints);
		}
		return connection.getPoints();
	}

	private List<Connection> getSourceConnections() {
		List<Connection> result = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<IGraphicalEditPart> sourceConnections = getHost().getSourceConnections();
		for (IGraphicalEditPart iGraphicalEditPart : sourceConnections) {
			Connection connection = (Connection) iGraphicalEditPart.getFigure();
			result.add(connection);
		}
		return result;
	}

	private List<Connection> getTargetConnections() {
		List<Connection> result = new ArrayList<>();
		@SuppressWarnings("unchecked")
		List<IGraphicalEditPart> targetConnections = getHost().getTargetConnections();
		for (IGraphicalEditPart iGraphicalEditPart : targetConnections) {
			Connection connection = (Connection) iGraphicalEditPart.getFigure();
			result.add(connection);
		}
		return result;
	}

	private void justKeepConnectionsInPlace(ChangeBoundsRequest request) {
//		System.out.println("keeping them in place...");
		if (connectionStart) {
			IFigure figure = getHostFigure();
			originalBounds = getHostFigure().getBounds().getCopy();
			figure.translateToAbsolute(originalBounds);
			originalBounds.translate(request.getMoveDelta().getNegated()).resize(request.getSizeDelta().getNegated());
			router.initBoxDrag(originalBounds, getSourceConnections(), getTargetConnections());
			connectionStart = false;
		}
		// XXX: always pass in original bounds so that initial locations are forced
		router.updateBoxDrag(originalBounds);
	}

	private void routeInResponseToBoxDrag(ChangeBoundsRequest request) {
		if (connectionStart) {
			IFigure figure = getHostFigure();
			originalBounds = getHostFigure().getBounds().getCopy();
			figure.translateToAbsolute(originalBounds);
			originalBounds.translate(request.getMoveDelta().getNegated()).resize(request.getSizeDelta().getNegated());
			router.initBoxDrag(originalBounds, getSourceConnections(), getTargetConnections());
			connectionStart = false;
		}
		router.updateBoxDrag(request.getTransformedRectangle(originalBounds));
	}

	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		if (request.getEditParts().get(0) != getHost()) {
			// XXX: policy is also called for composites
			justKeepConnectionsInPlace(request);
		} else {
			routeInResponseToBoxDrag(request);
		}
	}

	private void showLineFeedback(ConnectionEditPart connectionEditPart) {
		// XXX: copied from InitialPointsOfRequestDataManager
		List<?> children = connectionEditPart.getChildren();
		Connection connection = connectionEditPart.getConnectionFigure();
		for (Object child : children) {
			if (child instanceof ExternalXtextLabelEditPart) {
				IFigure figure = ((ExternalXtextLabelEditPart) child).getFigure();
				Object currentConstraint = connection.getLayoutManager().getConstraint(figure);
				if (currentConstraint instanceof EdgeLabelLocator) {
					EdgeLabelLocator edgeLabelLocator = (EdgeLabelLocator) currentConstraint;
					edgeLabelLocator.setFeedbackData(getInitialPoints(connection),
							new Vector(edgeLabelLocator.getOffset().x, edgeLabelLocator.getOffset().y),
							SetLabelsOffsetOperation.isEdgeWithObliqueRoutingStyle(connectionEditPart));
				}
			}
		}
	}

	@Override
	public void showSourceFeedback(Request request) {
		if (RequestConstants.REQ_DROP.equals(request.getType())) {
//			router.abortBoxDrag();
			return;
		}
		if (request instanceof ChangeBoundsRequest) {
			ChangeBoundsRequest cbr = ((ChangeBoundsRequest) request);
//			System.out.println("CBR " + cbr.getMoveDelta() + ", " + cbr.getSizeDelta());
			showChangeBoundsFeedback((ChangeBoundsRequest) request);
			for (ConnectionEditPart cep : getAllConnectionParts()) {
				showLineFeedback(cep);
			}
		}
	}
}