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
package org.yakindu.sct.ui.editor.pictogram;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.workspace.util.WorkspaceSynchronizer;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.handlers.HandlerUtil;
import org.yakindu.sct.model.sgraph.State;
import org.yakindu.sct.model.sgraph.Statechart;
import org.yakindu.sct.ui.editor.editor.BreadcrumbDiagramEditor;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;
import org.yakindu.sct.ui.editor.editor.TrackingFileEditorInput;

import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorResolver;

/**
 * Opens the selected Statechart for a SubmachineState in a new/existing editor.
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class OpenSubstatechartHandler extends AbstractHandler {

	public Object execute(ExecutionEvent event) throws ExecutionException {
		State selectedState = getSelectedSubmachineState(event);
		if (selectedState == null)
			return null;
		Statechart substatechart = selectedState.getSubstatechart();
		Resource eResource = substatechart.eResource();
		ActiveEditorResolver resolver = new ActiveEditorResolver();
		Display.getDefault().syncExec(resolver);
		IEditorPart result = resolver.getResult();
		List<IFile> newHistory = new ArrayList<IFile>();
		if(result instanceof BreadcrumbDiagramEditor){
			List<IFile> history = ((BreadcrumbDiagramEditor) result).getHistory();
			newHistory.addAll(history);
		} else{
			IEditorInput editorInput = result.getEditorInput();
			if(editorInput instanceof IFileEditorInput)
			newHistory.add(((IFileEditorInput) editorInput).getFile());
		}

		IFile file = WorkspaceSynchronizer.getFile(eResource);
		newHistory.add(file);
		TrackingFileEditorInput fileEditorInput = new TrackingFileEditorInput(
				file);
		fileEditorInput.setHistory(newHistory);

		final IWorkbenchPage page = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow().getActivePage();

		try {
			page.openEditor(fileEditorInput, StatechartDiagramEditor.ID);
		} catch (PartInitException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static State getSelectedSubmachineState(final ExecutionEvent event) {
		IGraphicalEditPart editPart = getSelectedEditPart(event);
		if (editPart == null)
			return null;
		EObject semanticElement = editPart.resolveSemanticElement();
		if (!(semanticElement instanceof State))
			return null;
		return (State) semanticElement;
	}

	public static IGraphicalEditPart getSelectedEditPart(
			final ExecutionEvent event) {
		final ISelection selection = HandlerUtil.getCurrentSelection(event);
		if (selection != null && selection instanceof IStructuredSelection
				&& !((IStructuredSelection) selection).isEmpty()) {

			final Object next = ((IStructuredSelection) selection).iterator()
					.next();
			if (next instanceof IGraphicalEditPart) {
				return (IGraphicalEditPart) next;
			}
		}
		return null;
	}
}
