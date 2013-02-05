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
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class BreadcrumbViewerUtil {

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
		IFile file = WorkspaceSynchronizer.getFile(diagramToOpen.eResource());
		try {
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
			final IWorkbenchPage wbPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			if (diagramToOpen.getElement() instanceof Statechart) {
				wbPage.openEditor(new FileEditorInput(file), desc.getId());
			} else if (diagramToOpen.getElement() instanceof State) {
				wbPage.openEditor(new DiagramEditorInput(diagramToOpen), desc.getId());
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
	}
}
