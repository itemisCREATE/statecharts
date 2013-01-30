/**
 * Copyright (c) 2012 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 * 	committers of YAKINDU - initial API and implementation
 * 
 */
package org.yakindu.sct.ui.editor.breadcrumb;

import java.util.Collection;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.gmf.runtime.diagram.ui.parts.DiagramEditorInput;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class BreadcrumbViewerUtil {

	// TODO: Performance
	public static Diagram getDiagramContaining(EObject element) {
		Resource eResource = element.eResource();
		Collection<Diagram> objects = EcoreUtil.getObjectsByType(eResource.getContents(),
				NotationPackage.Literals.DIAGRAM);
		for (Diagram diagram : objects) {
			TreeIterator<EObject> eAllContents = diagram.eAllContents();
			while (eAllContents.hasNext()) {
				EObject next = eAllContents.next();
				if (next instanceof View) {
					if (EcoreUtil.equals(((View) next).getElement(), element)) {
						return ((View) next).getDiagram();
					}
				}
			}
		}
		return null;
	}

	// TODO: Performance
	public static Diagram getSubDiagram(EObject element) {
		Resource eResource = element.eResource();
		Collection<Diagram> objects = EcoreUtil.getObjectsByType(eResource.getContents(),
				NotationPackage.Literals.DIAGRAM);
		for (Diagram diagram : objects) {
			if (EcoreUtil.equals(diagram.getElement(), element))
				return diagram;
		}
		return null;
	}

	public static void openEditor(Diagram diagramToOpen) {
		URI uri = EcoreUtil.getURI(diagramToOpen);
		IFile file = ResourcesPlugin.getWorkspace().getRoot().getFile(new Path(uri.toPlatformString(true)));
		try {
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());

			final IWorkbenchPage wbPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			wbPage.openEditor(new DiagramEditorInput(diagramToOpen), desc.getId());
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
}
