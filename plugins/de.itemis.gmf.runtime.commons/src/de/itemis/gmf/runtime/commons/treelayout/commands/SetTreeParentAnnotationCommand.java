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
package de.itemis.gmf.runtime.commons.treelayout.commands;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

import de.itemis.gmf.runtime.commons.treelayout.TreeLayoutUtil;
/**
 * 
 * @author Markus Muehlbrandt
 *
 */
public class SetTreeParentAnnotationCommand extends
		AbstractTransactionalCommand {

	private final View child;

	private final View parent;

	public SetTreeParentAnnotationCommand(View child, View parent) {
		super(TransactionUtil.getEditingDomain(child),
				"SetTreeParentAnnotation", null);
		this.child = child;
		this.parent = parent;
	}

	@Override
	protected CommandResult doExecuteWithResult(IProgressMonitor monitor,
			IAdaptable info) throws ExecutionException {
		TreeLayoutUtil.setTreeNodeParentAnnotation(child, parent);
		return CommandResult.newOKCommandResult();
	}
}
