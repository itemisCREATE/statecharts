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
import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;

import de.itemis.xtext.utils.gmf.resource.InjectMembersResource;

/**
 * Executes the Validation and creates Problem Markers on the resource.
 * 
 * @author andreas muelder
 * 
 */
public class ValidationAction implements IMarkerType {

	/**
	 * Perform the validation as a job to avoid blocking the UI Thread.
	 */
	public static void validate(DiagramEditPart diagramEditPart,
			final Diagram view) {

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
