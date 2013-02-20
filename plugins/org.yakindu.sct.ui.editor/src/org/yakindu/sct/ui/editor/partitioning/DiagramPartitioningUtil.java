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
package org.yakindu.sct.ui.editor.partitioning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.core.DiagramEditingDomainFactory;
import org.eclipse.gmf.runtime.diagram.ui.parts.IDiagramEditorInput;
import org.eclipse.gmf.runtime.notation.Diagram;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.Style;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.yakindu.sct.model.sgraph.CompositeElement;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class DiagramPartitioningUtil {

	/** GMFs notation {@link Style} id **/
	public static final String INLINE_STYLE = "isInline";

	private static final String DOMAIN_ID = "StatechartDomain";

	private DiagramPartitioningUtil() {
	}

	/**
	 * Returns the Shared Editing Domain that is used for all Editors acting on
	 * the same {@link IResource}
	 * 
	 * @return the {@link TransactionalEditingDomain}
	 */
	public static synchronized TransactionalEditingDomain getSharedDomain() {
		TransactionalEditingDomain editingDomain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain(DOMAIN_ID);
		if (editingDomain == null) {
			editingDomain = DiagramEditingDomainFactory.getInstance().createEditingDomain();
			editingDomain.setID(DOMAIN_ID);
			TransactionalEditingDomain.Registry.INSTANCE.add(DOMAIN_ID, editingDomain);
		}
		return editingDomain;
	}

	/**
	 * Returns the {@link Diagram} that contains a given semantic element.
	 */
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

	/**
	 * Returns the Subdiagram for a given {@link State} or {@link Statechart}
	 * 
	 */
	public static Diagram getSubDiagram(CompositeElement element) {
		Resource eResource = element.eResource();
		Collection<Diagram> objects = EcoreUtil.getObjectsByType(eResource.getContents(),
				NotationPackage.Literals.DIAGRAM);
		for (Diagram diagram : objects) {
			if (EcoreUtil.equals(diagram.getElement(), element))
				return diagram;
		}
		return null;
	}

	/**
	 * Opens the {@link StatechartDiagramEditor} for a fiven {@link IFile}
	 * 
	 */
	public static void openEditor(IFile file) {
		try {
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
			final IWorkbenchPage wbPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			wbPage.openEditor(new FileEditorInput(file), desc.getId());
		} catch (PartInitException e) {
			e.printStackTrace();
		}

	}

	/**
	 * Opens a subdiagram for a given {@link Diagram}
	 */
	public static IEditorPart openEditor(Diagram diagramToOpen) {
		IFile file = WorkspaceSynchronizer.getFile(diagramToOpen.eResource());
		try {
			IEditorDescriptor desc = PlatformUI.getWorkbench().getEditorRegistry().getDefaultEditor(file.getName());
			final IWorkbenchPage wbPage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
			if (diagramToOpen.getElement() instanceof Statechart) {
				return wbPage.openEditor(new FileEditorInput(file), desc.getId());
			} else if (diagramToOpen.getElement() instanceof State) {
				return wbPage.openEditor(new DiagramEditorInput(diagramToOpen), desc.getId());
			}
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Forces the user to close all opened editors for subdiagrams that are
	 * inlined.
	 * 
	 * @return true if all editors were closed, false otherwise
	 */
	public static boolean closeSubdiagramEditors(State state) {
		Diagram diagram = DiagramPartitioningUtil.getSubDiagram(state);
		if (diagram == null)
			return true;
		IWorkbenchPage activePage = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getActivePage();
		IEditorReference[] refs = activePage.getEditorReferences();
		for (IEditorReference ref : refs) {
			try {
				if (ref.getEditorInput() instanceof IDiagramEditorInput) {
					IDiagramEditorInput diagramInput = (IDiagramEditorInput) ref.getEditorInput();
					if (diagramInput.getDiagram().equals(diagram)) {
						boolean close = MessageDialog.openQuestion(new Shell(), "Close subdiagram editor?",
								"The subdiagram is still open in another editor. Do you want to close it?");
						if (close) {
							activePage.closeEditor(ref.getEditor(false), false);
						}
						return close;
					}
				}
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	public static List<Diagram> getDiagramContainerHierachy(Diagram diagram) {
		List<Diagram> result = new ArrayList<Diagram>();
		result.add(diagram);
		while (diagram.getElement() instanceof State) {
			diagram = DiagramPartitioningUtil.getDiagramContaining((State) diagram.getElement());
			result.add(diagram);
		}
		Collections.reverse(result);
		return result;
	}

	public static List<Diagram> getSubDiagramHierachy(Diagram diagram) {
		List<Diagram> result = new ArrayList<Diagram>();
		result.add(diagram);
		while (diagram.getElement() instanceof State) {
			diagram = DiagramPartitioningUtil.getSubDiagram((CompositeElement) diagram.getElement());
			result.add(diagram);
		}
		Collections.reverse(result);
		return result;
	}
}
