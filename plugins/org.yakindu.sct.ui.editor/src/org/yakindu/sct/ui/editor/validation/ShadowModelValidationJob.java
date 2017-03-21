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
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.EcoreUtil.Copier;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.common.core.command.CommandResult;
import org.eclipse.gmf.runtime.emf.commands.core.command.AbstractTransactionalCommand;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.sct.ui.editor.DiagramActivator;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * Copies the resource contents to a shadow model that is validated then. Does
 * not block UI during validation but consumes more memory since the whole model
 * is duplicated.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class ShadowModelValidationJob extends ValidationJob {

	@Inject
	private ResourceCopier copier;

	@Override
	public IStatus runInternal(final IProgressMonitor monitor) {
		ResourceSet set = new ResourceSetImpl();
		try {
			if (!resource.isLoaded())
				return Status.CANCEL_STATUS;
			final Resource shadowResource = set.createResource(resource.getURI());
			cloneResource(monitor, shadowResource);
			if (monitor.isCanceled())
				return Status.CANCEL_STATUS;

			final List<Issue> issues = Lists.newArrayList();
			try {
				issues.addAll(validator.validate(shadowResource, CheckMode.FAST_ONLY, new CancelIndicator() {
					public boolean isCanceled() {
						return monitor.isCanceled();
					}
				}));
			} catch (Throwable ex) {
				return Status.CANCEL_STATUS;
			}

			validationIssueProcessor.processIssues(issues, monitor);

		} catch (Exception ex) {
			ex.printStackTrace();
			return new Status(IStatus.ERROR, DiagramActivator.PLUGIN_ID, ex.getMessage());
		}
		return Status.OK_STATUS;
	}

	private void cloneResource(final IProgressMonitor monitor, final Resource shadowResource)
			throws ExecutionException {
		AbstractTransactionalCommand cmd = new AbstractTransactionalCommand(TransactionUtil.getEditingDomain(resource),
				"", null) {
			@Override
			protected CommandResult doExecuteWithResult(final IProgressMonitor monitor, IAdaptable info)
					throws ExecutionException {
				try {
					copier.cloneResource(resource, shadowResource);
				} catch (Throwable t) {
					return CommandResult.newErrorCommandResult(t.getMessage());
				}
				return CommandResult.newOKCommandResult();
			}
		};
		cmd.execute(monitor, null);
	}

	public static class ResourceCopier extends Copier {

		private static final long serialVersionUID = 1L;

		public void cloneResource(Resource original, Resource clone) {
			clone.setURI(original.getURI());
			clone.getContents().addAll(super.copyAll(original.getContents()));
			copyReferences();
			copyXMIIds(original, clone);
		}

		protected void copyXMIIds(Resource original, Resource clone) {
			if (original instanceof XMLResource) {
				TreeIterator<EObject> iterator = original.getAllContents();
				TreeIterator<EObject> cloneIterator = clone.getAllContents();
				while (iterator.hasNext()) {
					EObject next = iterator.next();
					EObject nextClone = cloneIterator.next();
					if (next.eClass() != nextClone.eClass()) {
						throw new IllegalStateException("Models are out of sync!");
					}
					((XMLResource) clone).setID(nextClone, ((XMLResource) original).getID(next));
				}
			}
		}
	}
}
