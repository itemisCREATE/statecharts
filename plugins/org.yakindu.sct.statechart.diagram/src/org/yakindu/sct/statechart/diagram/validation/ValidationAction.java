package org.yakindu.sct.statechart.diagram.validation;

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.yakindu.sct.statechart.diagram.extensions.Extensions;
import org.yakindu.sct.statechart.diagram.extensions.IValidationProvider;
import org.yakindu.sct.statechart.diagram.utils.SemanticHintUtil;

/**
 * 
 * @author muelder
 * 
 */
public class ValidationAction implements IMarkerType {

	private static final String VALIDATOR_EXTENSION_ID = "org.yakindu.sct.statechart.diagram.validation.provider";

	public static void validate(DiagramEditPart diagramEditPart, Diagram view) {
		IFile target = view.eResource() != null ? WorkspaceSynchronizer
				.getFile(view.eResource().getResourceSet().getResources()
						.get(0)) : null;
		if (target != null) {
			try {
				target.deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_ZERO);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		Extensions<IValidationProvider> extensions = new Extensions<IValidationProvider>(
				VALIDATOR_EXTENSION_ID);
		List<IValidationProvider> validationProvider = extensions
				.loadRegisteredProvider();

		if (view.isSetElement() && view.getElement() != null) {
			EObject statechart = view.getElement();
			TreeIterator<EObject> allContents = statechart.eAllContents();
			while (allContents.hasNext()) {
				EObject current = allContents.next();
				for (IValidationProvider provider : validationProvider) {
					if (provider.isProviderFor(current)) {
						Set<IStatus> status = provider.validate(current);
						for (IStatus validationStatus : status) {
							GMFMarkerUtil.createMarker(target,
									validationStatus, diagramEditPart,
									MARKER_TYPE, current);
						}
					}
				}
			}

		}
	}

}
