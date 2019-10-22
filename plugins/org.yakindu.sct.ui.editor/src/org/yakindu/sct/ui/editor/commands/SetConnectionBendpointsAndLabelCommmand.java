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
package org.yakindu.sct.ui.editor.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.draw2d.ConnectionAnchor;
import org.eclipse.draw2d.geometry.Point;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.diagram.ui.internal.commands.SetConnectionBendpointsCommand;
import org.yakindu.base.xtext.utils.gmf.commands.SetLabelsOffsetOperation;

/**
 * This class allows to update edge label Node position when updating
 * bendpoints.
 *
 * @author <a href="mailto:laurent.fasani@obeo.fr">Laurent Fasani</a>
 *
 */
@SuppressWarnings("restriction")
public class SetConnectionBendpointsAndLabelCommmand extends SetConnectionBendpointsCommand {

	/** Operation to delegate the job concerning the labels. */
	private SetLabelsOffsetOperation setLabelsOperation;

	/**
	 * Default constructor.
	 *
	 * @param editingDomain the editing domain through which model changes are made
	 */
	public SetConnectionBendpointsAndLabelCommmand(TransactionalEditingDomain editingDomain) {
		super(editingDomain);
		setLabelsOperation = new SetLabelsOffsetOperation();
	}

	@Override
	protected IStatus doExecute(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		setLabelsOperation.updateGMFLabelsOffset();
		return super.doExecute(monitor, info);
	}

	/**
	 * Set labels to update according to a connectionEditPart (all labels of this
	 * connection will be update). <BR>
	 * This method must be called after having called the
	 * {@link #setNewPointList(PointList, org.eclipse.draw2d.ConnectionAnchor, org.eclipse.draw2d.ConnectionAnchor)}
	 * of {@link #setNewPointList(PointList, Point, Point)} method.
	 *
	 * @param connectionEditPart The connection from which to get the potential
	 *                           three labels to update
	 */
	public void setLabelsToUpdate(ConnectionEditPart connectionEditPart) {
		setLabelsOperation.setLabelsToUpdate(connectionEditPart);
		setLabelsOperation.setNewPointList(connectionEditPart.getConnectionFigure().getPoints());
	}

	/**
	 * Set labels to update according to a connectionEditPart (all labels of this
	 * connection will be update). This method must be used if the edge figure is
	 * updated (through feedback) during the move. Indeed, in this case, we can not
	 * use the figure to retrieve the old points.<BR>
	 * This method must be called after having called the
	 * {@link #setNewPointList(PointList, org.eclipse.draw2d.ConnectionAnchor, org.eclipse.draw2d.ConnectionAnchor)}
	 * of {@link #setNewPointList(PointList, Point, Point)} method.
	 *
	 * @param connectionEditPart The connection from which to get the potential
	 *                           three labels to update
	 * @param originalPoints     The points of the edge before the move.
	 */
	public void setLabelsToUpdate(ConnectionEditPart connectionEditPart, PointList originalPoints) {
		setLabelsOperation.setLabelsToUpdate(connectionEditPart, originalPoints);
	}

	@Override
	public void setNewPointList(PointList newPointList, ConnectionAnchor sourceAnchor, ConnectionAnchor targetAnchor) {
		super.setNewPointList(newPointList, sourceAnchor, targetAnchor);
		setLabelsOperation.setNewPointList(newPointList);
	}

	@Override
	public void setNewPointList(PointList newPointList, Point sourceRefPoint, Point targetRefPoint) {
		super.setNewPointList(newPointList, sourceRefPoint, targetRefPoint);
		setLabelsOperation.setNewPointList(newPointList);
	}
}
