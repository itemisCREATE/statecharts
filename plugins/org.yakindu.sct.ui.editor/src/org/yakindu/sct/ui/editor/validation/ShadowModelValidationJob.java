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

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIHelperImpl;
import org.eclipse.emf.ecore.xmi.impl.XMISaveImpl;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.yakindu.sct.ui.editor.DiagramActivator;

import com.google.common.collect.Lists;

/**
 * Copies the resource contents to a shadow model that is validated then. Does
 * not block UI during validation but consumes more memory since the whole model
 * is duplicated.
 *
 * @author andreas muelder - Initial contribution and API
 *
 */
public class ShadowModelValidationJob extends ValidationJob {

	@Override
	protected IStatus runInternal(final IProgressMonitor monitor) {
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
				issues.addAll(doValidation(monitor, shadowResource));
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

	protected List<Issue> doValidation(final IProgressMonitor monitor, final Resource shadowResource) {
		return validator.validate(shadowResource, CheckMode.FAST_ONLY, new CancelIndicator() {
			@Override
			public boolean isCanceled() {
				return monitor.isCanceled();
			}
		});
	}

	protected void cloneResource(final IProgressMonitor monitor, final Resource shadowResource)
			throws ExecutionException {
		final ByteArrayOutputStream bout = new ByteArrayOutputStream();
		try {
			TransactionUtil.getEditingDomain(resource).runExclusive(() -> {
				try {
					XMISaveImpl saver = new XMISaveImpl(new XMIHelperImpl((XMLResource) resource));
					saver.save((XMLResource) resource, bout, Collections.emptyMap());
					bout.flush();
				} catch (Throwable tt) {
					tt.printStackTrace();
				}
			});
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			shadowResource.load(new ByteArrayInputStream(bout.toByteArray()), Collections.emptyMap());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
