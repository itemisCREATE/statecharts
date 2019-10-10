/**
* Copyright (c) 2019 itemis AG - All rights Reserved
* Unauthorized copying of this file, via any medium is strictly prohibited
* 
* Contributors:
* 	andreas muelder - itemis AG
*
*/
package org.yakindu.sct.ui.editor.editparts;

import java.util.List;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.IFigure;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.Rectangle;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.commands.CompoundCommand;
import org.eclipse.gef.requests.ChangeBoundsRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ResizableEditPolicyEx;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.notation.Edge;
import org.yakindu.base.gmf.runtime.router.RubberBandRoutingSupport;

import com.google.common.collect.Lists;

public class FixedBendpointEditPolicy extends ResizableEditPolicyEx {

	public static final String ROLE = "Fixed_Bendpoints";
	
	private boolean connectionStart = true;
	private Rectangle originalBounds = null;

	private RubberBandRoutingSupport router = new RubberBandRoutingSupport();

	@Override
	protected void showChangeBoundsFeedback(ChangeBoundsRequest request) {
		if (connectionStart) {
			IFigure figure = getHostFigure();
			originalBounds = getHostFigure().getBounds().getCopy();
			figure.getParent().translateToAbsolute(originalBounds);
			startConnection(originalBounds, getAllTransitions());
			connectionStart = false;
		} else {
			updateConnection(request.getTransformedRectangle(originalBounds.getCopy()));
		}
	}

	@Override
	protected void eraseChangeBoundsFeedback(ChangeBoundsRequest request) {
		connectionStart = true;
		router.commitBoxDrag();
	}

	@SuppressWarnings("unchecked")
	private List<Connection> getAllTransitions() {
		List<Connection> result = Lists.newArrayList();
		List<IGraphicalEditPart> sourceConnections = getHost().getSourceConnections();
		for (IGraphicalEditPart iGraphicalEditPart : sourceConnections) {
			result.add((Connection) iGraphicalEditPart.getFigure());
		}
		List<IGraphicalEditPart> targetConnections = getHost().getTargetConnections();
		for (IGraphicalEditPart iGraphicalEditPart : targetConnections) {
			result.add((Connection) iGraphicalEditPart.getFigure());
		}
		return result;
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	public void startConnection(Rectangle original, List<Connection> connections) {
		router.initBoxDrag(original, connections);
	}

	public void updateConnection(Rectangle newBounds) {
		router.updateBoxDrag(newBounds);
	}

	@Override
	protected Command getMoveCommand(ChangeBoundsRequest request) {
		return createUpdateAllBendpointsCommand();
	}

	@Override
	protected Command getResizeCommand(ChangeBoundsRequest request) {
		return createUpdateAllBendpointsCommand();
	}

	@SuppressWarnings("unchecked")
	private Command createUpdateAllBendpointsCommand() {
		CompoundCommand result = new CompoundCommand();
		List<IGraphicalEditPart> sourceConnections = getHost().getSourceConnections();
		for (IGraphicalEditPart part : sourceConnections) {
			result.add(getBendpointsChangedCommand((Connection) part.getFigure(), (Edge) part.getModel()));
		}
		List<IGraphicalEditPart> targetConnections = getHost().getTargetConnections();
		for (IGraphicalEditPart part : targetConnections) {
			result.add(getBendpointsChangedCommand((Connection) part.getFigure(), (Edge) part.getModel()));
		}
		return result;
	}

	@SuppressWarnings("restriction")
	protected Command getBendpointsChangedCommand(Connection connection, Edge edge) {
		Point ptRef1 = connection.getSourceAnchor().getReferencePoint();
		connection.translateToRelative(ptRef1);

		Point ptRef2 = connection.getTargetAnchor().getReferencePoint();
		connection.translateToRelative(ptRef2);

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();

		SetConnectionBendpointsCommand sbbCommand = new SetConnectionBendpointsCommand(editingDomain);
		sbbCommand.setEdgeAdapter(new EObjectAdapter(edge));
		sbbCommand.setNewPointList(connection.getPoints(), ptRef1, ptRef2);

		return new ICommandProxy(sbbCommand);
	}

}
