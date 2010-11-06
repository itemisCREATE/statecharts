package org.yakindu.sct.statechart.diagram.validation;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.validation.model.IConstraintStatus;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.xtext.EcoreUtil2;

/**
 * Utility class to create GMF specific {@link IMarker}s
 * 
 * @author Andreas Muelder <a
 *         href="mailto:andreas.muelder@itemis.de">andreas.muelder@itemis.de</a>
 * 
 */
public final class MarkerUtil {

	private MarkerUtil() {
		// Not to be instantiated
	}

	public static void createMarkers(IFile target, IStatus validationStatus, DiagramEditPart diagramEditPart,
			String markerType) {
		if (validationStatus.isOK()) {
			return;
		}

		IStatus[] children = validationStatus.getChildren();
		for (IStatus child : children) {
			IConstraintStatus nextStatus = (IConstraintStatus) child;
			View view = findNotationView(diagramEditPart.getDiagramView(), nextStatus.getTarget());
			addMarker(target, view.eResource().getURIFragment(view),
					EMFCoreUtil.getQualifiedName(nextStatus.getTarget(), true), nextStatus.getMessage(),
					nextStatus.getSeverity(), markerType);
		}

	}

	private static View findNotationView(Diagram diagram, EObject semanticElement) {
		List<EObject> allNotationElements = EcoreUtil2.eAllContentsAsList(diagram);
		for (EObject eObject : allNotationElements) {
			if (eObject instanceof View && semanticElement.equals(((View) eObject).getElement())) {
				return (View) eObject;
			}
		}
		return null;

	}

	private static IMarker addMarker(IFile file, String elementId, String location, String message, int statusSeverity,
			String markerType) {
		System.out.println("Element id is " + elementId);
		IMarker marker = null;
		try {
			marker = file.createMarker(markerType);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.LOCATION, location);
			marker.setAttribute(org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID, elementId);
			int markerSeverity = IMarker.SEVERITY_INFO;
			if (statusSeverity == IStatus.WARNING) {
				markerSeverity = IMarker.SEVERITY_WARNING;
			} else if (statusSeverity == IStatus.ERROR || statusSeverity == IStatus.CANCEL) {
				markerSeverity = IMarker.SEVERITY_ERROR;
			}
			marker.setAttribute(IMarker.SEVERITY, markerSeverity);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return marker;
	}

}
