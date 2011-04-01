package org.yakindu.sct.statechart.diagram.validation;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
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
public final class GMFMarkerUtil {

	private GMFMarkerUtil() {
		// Not to be instantiated
	}

	public static void createMarker(IFile target, IStatus validationStatus,
			Diagram diagram, String markerType,
			EObject semanticTarget) {
		if (validationStatus.isOK()) {
			return;
		}
		View view = findNotationView(diagram,
				semanticTarget);
		String uriFragment = view.eResource().getURIFragment(view);
		
		addMarker(target, uriFragment,
				EMFCoreUtil.getQualifiedName(semanticTarget, true),
				validationStatus.getMessage(), validationStatus.getSeverity(),
				markerType);

	}

	private static View findNotationView(Diagram diagram,
			EObject semanticElement) {
		List<EObject> allNotationElements = EcoreUtil2
				.eAllContentsAsList(diagram);
		for (EObject eObject : allNotationElements) {
			if (eObject instanceof View
					&& semanticElement.equals(((View) eObject).getElement())) {
				return (View) eObject;
			}
		}
		return null;

	}
	
	public static IFile getTargetFile(View view) {
		IFile target = view.eResource() != null ? WorkspaceSynchronizer
				.getFile(view.eResource().getResourceSet().getResources()
						.get(0)) : null;
		return target;
	}

	private static IMarker addMarker(IFile file, String elementId,
			String location, String message, int statusSeverity,
			String markerType) {
		IMarker marker = null;
		try {
			marker = file.createMarker(markerType);
			marker.setAttribute(IMarker.MESSAGE, message);
			marker.setAttribute(IMarker.LOCATION, location);
			org.eclipse.core.runtime.Assert.isNotNull(elementId);
			org.eclipse.core.runtime.Assert.isTrue(elementId.length() > 0);
			marker.setAttribute(
					org.eclipse.gmf.runtime.common.ui.resources.IMarker.ELEMENT_ID,
			elementId);
			int markerSeverity = IMarker.SEVERITY_INFO;
			if (statusSeverity == IStatus.WARNING) {
				markerSeverity = IMarker.SEVERITY_WARNING;
			} else if (statusSeverity == IStatus.ERROR
					|| statusSeverity == IStatus.CANCEL) {
				markerSeverity = IMarker.SEVERITY_ERROR;
			}
			marker.setAttribute(IMarker.SEVERITY, markerSeverity);
		} catch (CoreException e) {
			e.printStackTrace();
		}
		return marker;
	}

}
