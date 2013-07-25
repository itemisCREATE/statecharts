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
package de.itemis.xtext.utils.gmf.proposals;

import java.util.Collections;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.operations.IOperationHistory;
import org.eclipse.core.commands.operations.IUndoableOperation;
import org.eclipse.core.commands.operations.OperationHistoryFactory;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.common.core.command.ICommand;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Implementation of {@link ISemanticModification} that wraps the modify call
 * into an {@link ICommand} to execute on an {@link TransactionalEditingDomain}.
 * 
 * 
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public abstract class AbstractSemanticModification implements ISemanticModification {

	protected abstract void internalExecute(final EObject semanticObject, final View view);

	public final void modify(final EObject semanticObject, final View view) {
		AbstractTransactionalCommand refactoringCommand = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(semanticObject), getClass().getName(), Collections.EMPTY_LIST) {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				try {
					internalExecute(semanticObject, view);
				} catch (Exception ex) {
					ex.printStackTrace();
					return CommandResult.newErrorCommandResult(ex);
				}
				return CommandResult.newOKCommandResult();
			}
		};
		executeCommand(refactoringCommand, semanticObject.eResource());
	}

	protected void executeCommand(IUndoableOperation command, Resource resource) {
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();
		try {
			history.execute(command, new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

}
