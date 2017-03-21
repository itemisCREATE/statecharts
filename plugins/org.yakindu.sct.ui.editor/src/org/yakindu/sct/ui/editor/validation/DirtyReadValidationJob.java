/**
 * Copyright (c) 2017 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.validation;

import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.ui.editor.DiagramActivator;

import com.google.common.collect.Lists;

/**
 * This validates the model without a read transaction (dirty read) Potentially
 * thrown exceptions are catched and ignores, results are not processed then.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DirtyReadValidationJob extends ValidationJob {

	@Override
	public IStatus run(final IProgressMonitor monitor) {
		try {
			if (!resource.isLoaded())
				return Status.CANCEL_STATUS;
			if (resource instanceof AbstractSCTResource) {
				relinkModel(monitor, (AbstractSCTResource) resource);
			}
			if (monitor.isCanceled())
				return Status.CANCEL_STATUS;
			List<Issue> result = Lists.newArrayList();
			try {
				result.addAll(validator.validate(resource, CheckMode.FAST_ONLY, new CancelIndicator() {
					@Override
					public boolean isCanceled() {
						return monitor.isCanceled();
					}
				}));
			} catch (Throwable t) {
				// Exceptions may occur, for example
				// ConcurrentModificationException due to running outside of a
				// transaction. Just cancel the job, it is rescheduled then.
				return Status.CANCEL_STATUS;
			}
			if (!result.isEmpty())
				validationIssueProcessor.processIssues(result, monitor);

		} catch (Throwable ex) {
			return new Status(IStatus.ERROR, DiagramActivator.PLUGIN_ID, ex.getMessage());
		}
		return Status.OK_STATUS;
	}

	protected void relinkModel(final IProgressMonitor monitor, final AbstractSCTResource eResource)
			throws ExecutionException {
		AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(eResource),
				"", null) {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				eResource.linkSpecificationElements();
				return CommandResult.newOKCommandResult();

			}
		};
		cmd.execute(monitor, null);
	}

}
