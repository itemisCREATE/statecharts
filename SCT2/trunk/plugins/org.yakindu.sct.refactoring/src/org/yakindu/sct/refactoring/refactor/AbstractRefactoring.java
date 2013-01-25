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
package org.yakindu.sct.refactoring.refactor;

import java.util.Collections;
import java.util.List;

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
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.yakindu.sct.model.stext.resource.impl.StextResource;
import org.yakindu.sct.refactoring.utils.RefactoringHelper;

/**
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public abstract class AbstractRefactoring<T extends EObject> implements
		IRefactoring<T> {

	private List<T> contextObjects;

	public void setContextObjects(List<T> contextObject) {
		this.contextObjects = contextObject;
	}

	public List<T> getContextObjects() {
		return contextObjects;
	}

	protected T getContextObject() {
		return getContextObjects().iterator().next();
	}

	@Override
	public boolean isExecutable() {
		return getContextObjects() != null && getContextObjects().size() > 0;
	}

	protected Resource getResource() {
		return getContextObjects().iterator().next().eResource();
	}

	protected RefactoringHelper helper = new RefactoringHelper();

	@Override
	public void execute() {
		if (!isExecutable()) {
			return;
		}

		AbstractTransactionalCommand refactoringCommand = new AbstractTransactionalCommand(
				getEditingDomain(), getCommandLabel(), getAffectedFiles()) {

			@Override
			protected CommandResult doExecuteWithResult(
					IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				internalExecute();
				return CommandResult.newOKCommandResult();
			}

		};
		executeCommand(refactoringCommand, getResource());
	}

	protected abstract void internalExecute();

	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(getResource());
	}

	protected List<?> getAffectedFiles() {
		return Collections.EMPTY_LIST;
	}

	protected String getCommandLabel() {
		return "Refactoring Command";
	}

	protected void executeCommand(IUndoableOperation command, Resource resource) {
		IOperationHistory history = OperationHistoryFactory
				.getOperationHistory();

		if (resource instanceof StextResource) {
			// enable serializer
			((StextResource) resource).setSerializerEnabled(true);
			try {
				history.execute(command, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				// disable serializer
				((StextResource) resource).setSerializerEnabled(false);
			}
		} else {
			try {
				history.execute(command, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		}
	}
}
