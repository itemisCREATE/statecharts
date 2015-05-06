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
package de.itemis.gmf.runtime.treelayout.commands;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

import de.itemis.gmf.runtime.treelayout.TreeLayoutUtil;

/**
 * 
 * @author Markus Muehlbrandt
 *
 */
public class SetTreeNodesPositionAnnotationCommand extends
		AbstractTransactionalCommand {

	private final List<View> viewElements;

	public SetTreeNodesPositionAnnotationCommand(
			TransactionalEditingDomain domain, List<View> viewElements) {
		super(domain, "SetTreeNodesPositionAnnotationCommand", null);
		this.viewElements = viewElements;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {

		if (viewElements != null) {
			TreeLayoutUtil.setTreeNodesPositionAnnotation(viewElements);
			return CommandResult.newOKCommandResult();
		}

		return CommandResult
				.newErrorCommandResult("SetTreeNodesPositionAnnotationCommand: viewElements is null!");
	}
}
