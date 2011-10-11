/**
 * Copyright (c) 2011 committers of YAKINDU and others.
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

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.ISchedulingRule;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.progress.IWorkbenchSiteProgressService;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;
import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorTracker;

/**
 * Executes the Validation and creates Problem Markers on the resource.
 * 
 * @author andreas muelder
 * 
 */
public class ValidationAction implements IMarkerType {

	private static ISchedulingRule IDENTITY_RULE = new ISchedulingRule() {
		public boolean contains(ISchedulingRule rule) {
			return rule == this;
		}

		public boolean isConflicting(ISchedulingRule rule) {
			return rule == this;
		}
	};

	/**
	 * Perform the validation as a job to avoid blocking the UI Thread.
	 */
	public static void validate(DiagramEditPart diagramEditPart,
			final Diagram view) {

		final IEditorPart editor = ActiveEditorTracker
				.getLastEditor(StatechartDiagramEditor.ID);
		if (editor == null) {
			// should actually never happen..
			return;
		}
		final IWorkbenchSiteProgressService service = (IWorkbenchSiteProgressService) editor
				.getSite().getService(IWorkbenchSiteProgressService.class);
		Job job = new Job("Diagram validation") {
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				monitor.beginTask("Validating diagram...", 4);
				monitor.worked(1);
				try {
					doValidate(view);
				} catch (Exception e) {
					e.printStackTrace();
				}
				monitor.done();
				return Status.OK_STATUS;
			}
		};
		job.setRule(IDENTITY_RULE);
		service.schedule(job);
	}

	public static void doValidate(Diagram view) {
		IFile target = GMFMarkerUtil.getTargetFile(view);
		if (target != null) {
			try {
				target.deleteMarkers(DIAGRAM_MARKER_TYPE, true,
						IResource.DEPTH_ZERO);
				target.deleteMarkers(XTEXT_MARKER_TYPE, true,
						IResource.DEPTH_ZERO);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		// // Ecore constraints
		Diagnostic diagnostic = Diagnostician.INSTANCE.validate(view
				.getElement());
		List<Diagnostic> children = diagnostic.getChildren();
		for (Diagnostic child : children) {
			GMFMarkerUtil.createMarker(target,
					BasicDiagnostic.toIStatus(child), view,
					DIAGRAM_MARKER_TYPE, (EObject) child.getData().get(0));
		}

		// Diagnosticans from the InjectMembersResoruce
		if (view.eResource() instanceof InjectMembersResource) {
			InjectMembersResource resource = (InjectMembersResource) view
					.eResource();
			List<Diagnostic> diagnostics = resource.getDiagnostics();
			for (Diagnostic child : diagnostics) {
				GMFMarkerUtil.createMarker(target,
						BasicDiagnostic.toIStatus(child), view,
						XTEXT_MARKER_TYPE, (EObject) child.getData().get(0));
			}
		}
	}

}
