/**
 * Copyright (c) 2011 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.generator.builder.action;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.dialogs.ErrorDialog;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IObjectActionDelegate;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.generator.builder.BuilderActivator;
import org.yakindu.sct.generator.builder.GenModelLoader;
import org.yakindu.sct.generator.core.GeneratorActivator;
import org.yakindu.sct.generator.core.execution.GeneratorExecutor;
import org.yakindu.sct.model.sgen.GeneratorModel;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class GenerateModelAction implements IObjectActionDelegate {

	private ISelection selection;

	public GenerateModelAction() {
	}

	public void run(IAction action) {
		IFile file = unwrap();

		if (hasError(file)) {
			Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
			ErrorDialog.openError(shell, "Generator Error", "Cannot execute Generator",
					new Status(IStatus.ERROR, GeneratorActivator.PLUGIN_ID, "The file contains errors"));
			return;
		}
		final GeneratorModel model = GenModelLoader.load(file);
		if (model != null) {
			Job generatorJob = new Job("Execute SCT Genmodel " + file.getName()) {
				@Override
				protected IStatus run(IProgressMonitor monitor) {
					new GeneratorExecutor().executeGenerator(model);
					return Status.OK_STATUS;
				}
			};
			generatorJob.setRule(file.getProject().getWorkspace().getRuleFactory().buildRule());
			generatorJob.schedule();

		}
	}

	private boolean hasError(IFile file) {
		IMarker[] findMarkers = null;
		try {
			findMarkers = file.findMarkers(IMarker.PROBLEM, true, IResource.DEPTH_INFINITE);
			for (IMarker iMarker : findMarkers) {
				Integer attribute = (Integer) iMarker.getAttribute(IMarker.SEVERITY);
				if (attribute.intValue() == IMarker.SEVERITY_ERROR) {
					return true;
				}
			}
		} catch (CoreException e) {
			BuilderActivator.getDefault().getLog().log(new Status(IStatus.WARNING, BuilderActivator.PLUGIN_ID,
					"Error in determine, if file contains errors", e));
		}

		ResourceSet rs = new ResourceSetImpl();

		try {
			Resource resource = rs.getResource(URI.createPlatformResourceURI(file.getFullPath().toString(), true),
					true);
			if (resource == null)
				return false;
			if (!resource.getErrors().isEmpty()) {
				return true;
			}
			if (!resource.getContents().isEmpty()) {
				Diagnostic diagnostic = Diagnostician.INSTANCE.validate(resource.getContents().get(0));
				if (diagnostic.getSeverity() == Diagnostic.ERROR) {
					return true;
				}
			}
		} catch (RuntimeException e) {
			BuilderActivator.getDefault().getLog()
					.log(new Status(IStatus.WARNING, BuilderActivator.PLUGIN_ID, "Error in opening resource", e));
		}
		return false;
	}

	private IFile unwrap() {
		if (selection instanceof StructuredSelection) {
			Object firstElement = ((StructuredSelection) selection).getFirstElement();
			if (firstElement instanceof IFile) {
				return (IFile) firstElement;
			}
		}
		return null;
	}

	public void selectionChanged(IAction action, ISelection selection) {
		this.selection = selection;
	}

	public void setActivePart(IAction action, IWorkbenchPart targetPart) {
		// Nothing to do
	}

}
