package org.yakindu.sct.statechart.diagram.validation;

import java.util.List;
import java.util.Set;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.notation.Diagram;

import com.google.inject.internal.Lists;

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
		List<IValidationProvider> validationProvider = getValidationProvider();

		if (view.isSetElement() && view.getElement() != null) {
			EObject statechart = view.getElement();
			TreeIterator<EObject> allContents = statechart.eAllContents();
			while (allContents.hasNext()) {
				EObject current = allContents.next();
				for (IValidationProvider provider : validationProvider) {
					if (provider.isProviderFor(current)) {
						Set<IStatus> status = provider.validate(current);
						for (IStatus validationStatus : status) {
							GMFMarkerUtil.createMarker(target, validationStatus,
									diagramEditPart, MARKER_TYPE, current);
						}
					}
				}
			}

		}

		// IBatchValidator validator = (IBatchValidator)
		// ModelValidationService.getInstance().newValidator(
		// EvaluationMode.BATCH);
		// validator.setIncludeLiveConstraints(true);
		// if (view.isSetElement() && view.getElement() != null) {
		// IStatus status = validator.validate(view.getElement());
		// MarkerUtil.createMarkers(target, status, diagramEditPart,
		// MARKER_TYPE);
		// }

	}

	private static List<IValidationProvider> providers;

	private static List<IValidationProvider> getValidationProvider() {
		if (providers != null)
			return providers;
		providers = Lists.newArrayList();
		IConfigurationElement[] configurationElements = Platform
				.getExtensionRegistry().getConfigurationElementsFor(
						VALIDATOR_EXTENSION_ID);
		for (IConfigurationElement configurationElement : configurationElements) {
			System.out.println("Getting configuration element "
					+ configurationElement);
			try {
				IValidationProvider provider = (IValidationProvider) configurationElement
						.createExecutableExtension("class");
				providers.add(provider);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}
		return providers;
	}

}
