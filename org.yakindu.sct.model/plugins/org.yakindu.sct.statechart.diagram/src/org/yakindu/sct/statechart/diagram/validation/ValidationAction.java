package org.yakindu.sct.statechart.diagram.validation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.validation.model.EvaluationMode;
import org.eclipse.emf.validation.service.IBatchValidator;
import org.eclipse.emf.validation.service.ModelValidationService;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.View;

public class ValidationAction implements IMarkerType {

	public static void validate(DiagramEditPart diagramEditPart, View view) {
		IFile target = view.eResource() != null ? WorkspaceSynchronizer.getFile(view.eResource().getResourceSet()
				.getResources().get(0)) : null;
		if (target != null) {
			try {
				target.deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_ZERO);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		
		IBatchValidator validator = (IBatchValidator) ModelValidationService.getInstance().newValidator(
				EvaluationMode.BATCH);
		validator.setIncludeLiveConstraints(true);
		if (view.isSetElement() && view.getElement() != null) {
			IStatus status = validator.validate(view.getElement());
			MarkerUtil.createMarkers(target, status, diagramEditPart, MARKER_TYPE);
		}
	}
}
