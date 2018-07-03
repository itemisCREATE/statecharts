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
package org.yakindu.base.xtext.utils.gmf.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.draw2d.geometry.PointList;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.diagram.ui.editparts.ConnectionEditPart;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;

/**
 * This class allows to update edge label Node position.
 *
 * @author <a href="mailto:laurent.redor@obeo.fr">Laurent Redor</a>
 */
public class SetLabelsOffsetCommand extends AbstractTransactionalCommand {

	/** Operation to delegate the job concerning the labels. */
	private SetLabelsOffsetOperation setLabelsOperation;

	/**
	 * Default constructor.
	 *
	 * @param editingDomain
	 *            the editing domain through which model changes are made
	 */
	public SetLabelsOffsetCommand(TransactionalEditingDomain editingDomain) {
		super(editingDomain, "Set Label offset", null);
		setLabelsOperation = new SetLabelsOffsetOperation();
	}

	/**
	 * Method to set the newPointList.
	 *
	 * @param newPointList
	 *            The new points list
	 */
	public void setNewPointList(PointList newPointList) {
		setLabelsOperation.setNewPointList(newPointList);
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
		setLabelsOperation.updateGMFLabelsOffset();
		return CommandResult.newOKCommandResult();
	}

	/**
	 * Set labels to update according to a connectionEditPart (all labels of this
	 * connection will be update). <BR>
	 * This method must be called after having called the
	 * {@link #setNewPointList(PointList)} method.
	 *
	 * @param connectionEditPart
	 *            The connection from which to get the potential three labels to
	 *            update
	 */
	public void setLabelsToUpdate(ConnectionEditPart connectionEditPart) {
		setLabelsOperation.setLabelsToUpdate(connectionEditPart);
	}

	/**
	 * Set labels to update according to a connectionEditPart (all labels of this
	 * connection will be update). This method must be used if the edge figure is
	 * updated (through feedback) during the move. Indeed, in this case, we can not
	 * use the figure to retrieve the old points.<BR>
	 * This method must be called after having called the
	 * {@link #setNewPointList(PointList)} method.
	 *
	 * @param connectionEditPart
	 *            The connection from which to get the potential three labels to
	 *            update
	 * @param originalPoints
	 *            The points of the edge before the move.
	 */
	public void setLabelsToUpdate(ConnectionEditPart connectionEditPart, PointList originalPoints) {
		setLabelsOperation.setLabelsToUpdate(connectionEditPart, originalPoints);
	}
}
