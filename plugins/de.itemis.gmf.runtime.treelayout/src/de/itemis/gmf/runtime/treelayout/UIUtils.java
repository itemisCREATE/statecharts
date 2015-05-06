/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	Markus Muehlbrandt - initial API and implementation
 * 
 */
package de.itemis.gmf.runtime.treelayout;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.gmf.runtime.diagram.ui.editparts.DiagramEditPart;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.diagram.ui.resources.editor.parts.DiagramDocumentEditor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Utility class for UI actions.
 * 
 * @author Markus Muehlbrandt
 */
public final class UIUtils {
	private UIUtils() {
		// This class is not intended to be instantiated.
	}

	public static DiagramDocumentEditor getActiveEditor() {
		final IWorkbenchWindow workbenchWindow = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		final IWorkbenchPage workbenchPage = workbenchWindow.getActivePage();
		if (workbenchPage != null) {
			final IEditorPart editor = workbenchPage.getActiveEditor();
			if (editor instanceof DiagramDocumentEditor) {
				return (DiagramDocumentEditor)editor;
			}
		}
		return null;
	}

	public static DiagramEditPart getDiagramEditPart() {
		final DiagramDocumentEditor editor = getActiveEditor();
		if (editor != null) {
			return editor.getDiagramEditPart();
		}
		return null;
	}

	public static IGraphicalEditPart getEditPart(EObject eObject) {
		final DiagramEditPart ep = getActiveEditor().getDiagramEditPart();
		return (IGraphicalEditPart)ep.findEditPart(ep, eObject);
	}
}
