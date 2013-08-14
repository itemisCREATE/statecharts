/**
 * Copyright (c) 2012 committers of YAKINDU and others.
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
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.WrappedException;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RunnableWithResult;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.ui.PlatformUI;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.sct.model.sgraph.resource.AbstractSCTResource;
import org.yakindu.sct.ui.editor.DiagramActivator;

import com.google.inject.Inject;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class SCTValidationJob extends Job implements IMarkerType {

	@Inject
	private IResourceValidator validator;
	@Inject
	private MarkerCreator creator;

	private Resource resource;

	/**
	 * Wrappes the {@link IResourceValidator} validate within a
	 * {@link RunnableWithResult} to execute within a read only transaction
	 * 
	 * @author andreas muelder - Initial contribution and API
	 * 
	 */
	public static class TransactionalValidationRunner extends RunnableWithResult.Impl<List<Issue>> {

		private IResourceValidator validator;
		private Resource resource;
		private CheckMode checkMode;
		private CancelIndicator indicator;

		public TransactionalValidationRunner(IResourceValidator validator, Resource resource, CheckMode checkMode,
				CancelIndicator indicator) {
			this.validator = validator;
			this.resource = resource;
			this.checkMode = checkMode;
			this.indicator = indicator;

		}

		public void run() {
			List<Issue> result = validator.validate(resource, checkMode, indicator);
			setResult(result);
			setStatus(Status.OK_STATUS);
		}
	}

	public SCTValidationJob() {
		super("validation");
	}

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
			TransactionalValidationRunner runner = new TransactionalValidationRunner(validator, resource,
					CheckMode.ALL, new CancelIndicator() {
						public boolean isCanceled() {
							return monitor.isCanceled();

						}
					});
			TransactionalEditingDomain editingDomain = TransactionUtil.getEditingDomain(resource);
			if (editingDomain == null)
				return Status.CANCEL_STATUS;
			editingDomain.runExclusive(runner);
			final List<Issue> issues = runner.getResult();
			if (issues == null)
				return Status.CANCEL_STATUS;
			final IFile target = WorkspaceSynchronizer.getFile(resource);
			refreshMarkers(target, issues, monitor);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new Status(IStatus.ERROR, DiagramActivator.PLUGIN_ID, ex.getMessage());
		}
		return Status.OK_STATUS;
	}

	/**
	 * Updates the markers. Execute the marker update in the UI thread, the
	 * problem markers // will flicker otherwise
	 */
	private void refreshMarkers(final IFile target, final List<Issue> issues, final IProgressMonitor monitor) {
		PlatformUI.getWorkbench().getDisplay().syncExec(new Runnable() {
			public void run() {
				try {
					target.deleteMarkers(SCT_MARKER_TYPE, true, IResource.DEPTH_ZERO);
					for (Issue issue : issues) {
						if (monitor.isCanceled())
							return;
						creator.createMarker(issue, target, SCT_MARKER_TYPE);
					}
				} catch (CoreException e) {
					throw new WrappedException(e);
				}
			}
		});
	}

	/**
	 * relinks the model before validation is executed
	 */
	protected void relinkModel(final IProgressMonitor monitor, final AbstractSCTResource eResource)
			throws ExecutionException {
		AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(
				TransactionUtil.getEditingDomain(eResource), "", null) {
			@Override
			protected CommandResult doExecuteWithResult(IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				eResource.linkSpecificationElements();
				return CommandResult.newOKCommandResult();

			}
		};
		cmd.execute(monitor, null);
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

}
