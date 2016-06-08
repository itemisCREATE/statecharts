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
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.refactoring.utils.RefactoringHelper;

/**
 * Base abstract class for all refactorings providing some default
 * implementations. Concrete subclasses are responsible for implementing the
 * refactoring logic which is applied on the refactoring's context objects.
 * 
 * @author thomas kutz - Initial contribution and API
 * 
 */
public abstract class AbstractRefactoring<T extends Object> implements IRefactoring<T> {

	private List<T> contextObjects;

	public void setContextObjects(List<T> contextObject) {
		this.contextObjects = contextObject;
	}

	public List<T> getContextObjects() {
		return contextObjects;
	}

	public T getContextObject() {
		return getContextObjects().iterator().next();
	}

	/**
	 * Helper providing several convenience methods to access and modify model
	 * element.
	 */
	protected RefactoringHelper helper = new RefactoringHelper();

	public boolean isExecutable() {
		return getContextObjects() != null && getContextObjects().size() > 0;
	}

	/**
	 * Returns the resource which is affected by this refactoring. Default
	 * implementation returns the resource of the first context object.
	 * 
	 * @return resource
	 */
	protected Resource getResource() {
		T firstContextObject = getContextObject();
		if (firstContextObject instanceof EObject) {
			return ((EObject) firstContextObject).eResource();
		}
		return null;
	}

	/**
	 * Wraps an {@link AbstractTransactionalCommand} around the refactoring
	 * logic.
	 */
	public void execute() {
		if (!isExecutable()) {
			return;
		}

		AbstractTransactionalCommand refactoringCommand = new AbstractTransactionalCommand(getEditingDomain(),
				getCommandLabel(), getAffectedFiles()) {

			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				try {
					internalExecute();
				} catch (Exception ex) {
					return CommandResult.newErrorCommandResult(ex);
				}
				return CommandResult.newOKCommandResult();
			}

			@Override
			protected IStatus doUndo(IProgressMonitor monitor, IAdaptable info) throws ExecutionException {
				if (internalDoUndo())
					return super.doUndo(monitor, info);
				return Status.CANCEL_STATUS;
			}

		};
		executeCommand(refactoringCommand);
	}

	protected void executeCommand(AbstractTransactionalCommand refactoringCommand) {
		executeCommand(refactoringCommand, getResource());
	}

	protected boolean internalDoUndo() {
		return true;
	}

	/**
	 * Is called within {@link IRefactoring#execute()} method.
	 */
	protected abstract void internalExecute();

	/**
	 * Getter for the editing domain of the resource used in this refactoring.
	 * 
	 * @return editing domain
	 */
	protected TransactionalEditingDomain getEditingDomain() {
		return TransactionUtil.getEditingDomain(getResource());
	}

	/**
	 * Returns a list of files affected by this refactoring.
	 * 
	 * @return list of affected files
	 */
	protected List<?> getAffectedFiles() {
		return Collections.EMPTY_LIST;
	}

	/**
	 * Returns the label of this refactoring's command.
	 * 
	 * @return command label
	 */
	protected String getCommandLabel() {
		return "Refactoring Command";
	}

	/**
	 * Executes the specified command and handles enabling and disabling of the
	 * resource's serializer.
	 * 
	 * @param command
	 *            the command to execute
	 * @param resource
	 *            the resource used for enabling/disabling its serializer
	 */
	public static void executeCommand(IUndoableOperation command, Resource resource) {
		executeCommand(command, resource, true);
	}

	public static void executeCommand(IUndoableOperation command, Resource resource, boolean serialize) {
		IOperationHistory history = OperationHistoryFactory.getOperationHistory();

		if (resource instanceof AbstractSCTResource) {
			// enable serializer
			((AbstractSCTResource) resource).setSerializerEnabled(serialize);
			try {
				history.execute(command, new NullProgressMonitor(), null);
			} catch (ExecutionException e) {
				e.printStackTrace();
			} finally {
				// disable serializer
				((AbstractSCTResource) resource).setSerializerEnabled(false);
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
