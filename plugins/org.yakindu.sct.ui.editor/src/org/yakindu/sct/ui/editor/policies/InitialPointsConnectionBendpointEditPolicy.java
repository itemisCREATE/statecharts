/*******************************************************************************
 * Copyright (c) 2015 THALES GLOBAL SERVICES.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Obeo - initial API and implementation
 *******************************************************************************/
package org.yakindu.sct.ui.editor.policies;

import org.eclipse.draw2d.Connection;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gef.ConnectionEditPart;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.requests.BendpointRequest;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editpolicies.ConnectionBendpointEditPolicy;
import org.eclipse.gmf.runtime.emf.core.util.EObjectAdapter;
import org.eclipse.gmf.runtime.gef.ui.internal.editpolicies.LineMode;
import org.eclipse.gmf.runtime.notation.Edge;
import org.yakindu.base.xtext.utils.gmf.routing.InitialPointsOfRequestDataManager;
import org.yakindu.sct.ui.editor.commands.SetConnectionBendpointsAndLabelCommmand;

/**
 * Mostly copied from
 * org.eclipse.sirius.diagram.ui.internal.edit.policies.SiriusConnectionBendpointEditPolicy
 *
 */
@SuppressWarnings("restriction")
public class InitialPointsConnectionBendpointEditPolicy extends ConnectionBendpointEditPolicy {

	private InitialPointsOfRequestDataManager initialPointsManager = new InitialPointsOfRequestDataManager();
	
	public InitialPointsConnectionBendpointEditPolicy(LineMode lineSegMode) {
		super(lineSegMode);
	}

	public InitialPointsConnectionBendpointEditPolicy() {
		super(LineMode.OBLIQUE);
	}

	@Override
	protected Command getBendpointsChangedCommand(BendpointRequest request) {
		PointList originalPoints = InitialPointsOfRequestDataManager.getOriginalPoints(request);
		Command result = super.getBendpointsChangedCommand(request);
		if (result instanceof ICommandProxy) {
			ICommand iCommand = ((ICommandProxy) result).getICommand();
			if (iCommand instanceof SetConnectionBendpointsAndLabelCommmand) {
				((SetConnectionBendpointsAndLabelCommmand) iCommand).setLabelsToUpdate(
						(org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart) getHost(), originalPoints);
			}
		}
		return result;
	}

	@Override
	protected Command getBendpointsChangedCommand(Connection connection, Edge edge) {
		Point ptRef1 = connection.getSourceAnchor().getReferencePoint();
		getConnection().translateToRelative(ptRef1);

		Point ptRef2 = connection.getTargetAnchor().getReferencePoint();
		getConnection().translateToRelative(ptRef2);

		TransactionalEditingDomain editingDomain = ((IGraphicalEditPart) getHost()).getEditingDomain();

		SetConnectionBendpointsAndLabelCommmand sbbCommand = new SetConnectionBendpointsAndLabelCommmand(editingDomain);
		sbbCommand.setEdgeAdapter(new EObjectAdapter(edge));
		sbbCommand.setNewPointList(connection.getPoints(), ptRef1, ptRef2);

		return new ICommandProxy(sbbCommand);
	}

	@Override
	protected void showMoveBendpointFeedback(BendpointRequest request) {
		initialPointsManager.storeInitialPointsInRequest(request, (ConnectionEditPart) getHost());
		super.showMoveBendpointFeedback(request);
	}

	@Override
	protected void showCreateBendpointFeedback(BendpointRequest request) {
		initialPointsManager.storeInitialPointsInRequest(request, (ConnectionEditPart) getHost());
		super.showCreateBendpointFeedback(request);
	}

	@Override
	protected void eraseConnectionFeedback(BendpointRequest request, boolean removeFeedbackFigure) {
		super.eraseConnectionFeedback(request, removeFeedbackFigure);
		if (removeFeedbackFigure) {
			initialPointsManager.eraseInitialPoints(getConnection());
		}
	}

	@Override
	protected void showMoveLineSegFeedback(BendpointRequest request) {
		initialPointsManager.storeInitialPointsInRequest(request, (ConnectionEditPart) getHost());
		super.showMoveLineSegFeedback(request);
	}

}
