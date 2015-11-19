/**
 * Copyright (c) 2013-2015 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.modifications;

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
 * Instances are stateful and refer to the {@link #targetView} property. 
 * Subclasses may add any other number of properties. 
 * 
 * Subclasses have to overwrite the hook methods {@link #check(EObject, View)} 
 * and {@link #execute(EObject, View)}.
 * 
 * @author andreas muelder - Initial contribution and API
 * @author terfloth 
 * 
 */
public abstract class AbstractSemanticModification implements ISemanticModification {

	protected  View targetView;
	
	@Override
	public void setTargetView(View view) {
		targetView = view;
	}

	@Override
	public View getTargetView() {
		return targetView;
	}

	/**
	 * This hook includes the logic, that is required to check if the modification can be applied.
	 * 
	 * @param semanticObject
	 * @param view
	 * @return true if all preconditions for executing the command are valid and else false. 
	 */
	protected abstract boolean check(final EObject semanticObject, final View view);

	/**
	 * This hook method has to execute the concrete modification logic.
	 * 
	 * @param semanticObject
	 * @param view
	 */
	protected abstract void execute(final EObject semanticObject, final View view);

	
	
	@Override
	public boolean isApplicable() {
		
		if (getTargetView() == null) return false;		
		return check(getTargetView().getElement(), getTargetView());
	}

	/**
	 * Executes the modification in a transactional command.
	 */
	public void modify() {
		if (! isApplicable()) throw new IllegalStateException("Modification " + getClass().getSimpleName() + " is not executable.");
		
		final EObject semanticObject = getTargetView().getElement();
		AbstractTransactionalCommand refactoringCommand = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(semanticObject), getClass().getName(), Collections.EMPTY_LIST) {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				try {
					AbstractSemanticModification.this.execute(semanticObject, getTargetView());
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
