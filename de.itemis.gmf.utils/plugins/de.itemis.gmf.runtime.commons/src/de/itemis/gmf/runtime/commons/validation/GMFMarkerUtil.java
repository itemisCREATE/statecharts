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
package de.itemis.gmf.runtime.commons.validation;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.View;

/**
 * Utility class to create GMF specific {@link IMarker}s
 * 
 * @author andreas muelder
 * 
 */
public final class GMFMarkerUtil {

	private GMFMarkerUtil() {
		// Not to be instantiated
	}

	/**
	 * Creates an marker with additional GMF specific attributes.
	 * 
	 * @param target
	 *            The {@link IResource} where to create the marker
	 * @param validationStatus
	 *            Can be ERROR, WARNING, INFO
	 * @param diagram
	 *            the GMF Notation model diagram
	 * @param markerType
	 *            marker type
	 * @param semanticTarget
	 *            the semantic object where the problem occured
	 */
	public static void createMarker(IFile target, IStatus validationStatus,
			Diagram diagram, String markerType, EObject semanticTarget) {
		if (validationStatus.isOK()) {
			return;
		}
		View view = findNotationView(diagram, semanticTarget);
		if (view == null)
			return;
		String uriFragment = view.eResource().getURIFragment(view);

		addMarker(target, uriFragment,
				EMFCoreUtil.getQualifiedName(semanticTarget, true),
				validationStatus.getMessage(), validationStatus.getSeverity(),
				markerType);

	}

	private static View findNotationView(Diagram diagram,
			EObject semanticElement) {
		TreeIterator<EObject> eAllContents = diagram.eAllContents();
		while (eAllContents.hasNext()) {
			EObject eObject = eAllContents.next();
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
