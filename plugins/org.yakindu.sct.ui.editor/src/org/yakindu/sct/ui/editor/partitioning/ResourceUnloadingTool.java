/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.yakindu.sct.ui.editor.partitioning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.ui.URIEditorInput;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.emf.transaction.util.TransactionUtil;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.emf.core.util.EMFCoreUtil;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.PlatformUI;

public class ResourceUnloadingTool {

	public static void unloadEditorInput(ResourceSet resourceSet, IEditorInput editorInput) {
		final EList<Resource> resources = resourceSet.getResources();
		final List<Resource> resourcesToUnload = new ArrayList<Resource>(resources);
		IEditorReference[] editorReferences;
		try {
			editorReferences = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage()
					.getEditorReferences();
		} catch (final NullPointerException exc) {
			// Workbench is not yet created or being disposed, so do nothing
			// see bug http://code.google.com/p/gmftools/issues/detail?id=9
			return;
		}
		for (final IEditorReference openEditorReference : editorReferences) {
			try {
				final IEditorInput openEditorInput = openEditorReference.getEditorInput();
				if (openEditorInput != editorInput) {
					final IEditorPart openEditor = openEditorReference.getEditor(false);
					if (openEditor instanceof IEditingDomainProvider) {
						final IEditingDomainProvider openDiagramEditor = (IEditingDomainProvider) openEditor;
						final ResourceSet diagramResourceSet = openDiagramEditor.getEditingDomain().getResourceSet();
						if (diagramResourceSet == resourceSet) {
							final Resource diagramResource = getDiagramResource(diagramResourceSet, openEditorInput);
							if(diagramResource == null)
								continue;
							resourcesToUnload.remove(diagramResource);
							final Collection<?> imports = EMFCoreUtil.getImports(diagramResource);
							resourcesToUnload.removeAll(imports);
						}
					}
				}
			} catch (final Exception exc) {
				exc.printStackTrace();
			}
		}
		try {
			TransactionUtil.getEditingDomain(resourceSet).runExclusive(new Runnable() {
				@Override
				public void run() {
					for (final Resource resourceToUnload : resourcesToUnload) {
						try {
							resourceToUnload.unload();
							resources.remove(resourceToUnload);
						} catch (final Throwable t) {
							t.printStackTrace();
						}
					}

				}
			});
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static Resource getDiagramResource(ResourceSet resourceSet, IEditorInput editorInput) {
		Resource diagramResource = null;
		if (editorInput instanceof URIEditorInput) {
			final URI resourceURI = ((URIEditorInput) editorInput).getURI().trimFragment();
			diagramResource = resourceSet.getResource(resourceURI, false);
		} else if (editorInput instanceof IDiagramEditorInput) {
			final Diagram diagram = ((IDiagramEditorInput) editorInput).getDiagram();
			diagramResource = diagram.eResource();
		} else if (editorInput instanceof IFileEditorInput) {
			final URI resourceURI = URI.createPlatformResourceURI(((IFileEditorInput) editorInput).getFile()
					.getFullPath().toString(), true);
			diagramResource = resourceSet.getResource(resourceURI, false);
		}
		return diagramResource;
	}

}
