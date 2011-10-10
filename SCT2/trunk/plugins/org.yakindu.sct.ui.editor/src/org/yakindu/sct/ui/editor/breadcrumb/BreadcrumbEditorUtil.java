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
package org.yakindu.sct.ui.editor.breadcrumb;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.yakindu.sct.ui.editor.editor.StatechartDiagramEditor;

import de.itemis.xtext.utils.jface.viewers.util.ActiveEditorTracker;

/**
 * 
 * @author andreas muelder - Initial contribution and API
 * 
 */
public class BreadcrumbEditorUtil {

	public static void openEditor(IFile file) throws ExecutionException {
		if (!file.exists()) {
			return;
		}
		IEditorPart result = ActiveEditorTracker.getLastActiveEditor();
		List<IFile> newHistory = new ArrayList<IFile>();
		if (result instanceof BreadcrumbDiagramEditor) {
			List<IFile> history = ((BreadcrumbDiagramEditor) result)
					.getHistory();
			newHistory.addAll(history);
		} else {
			IEditorInput editorInput = result.getEditorInput();
			if (editorInput instanceof IFileEditorInput)
				newHistory.add(((IFileEditorInput) editorInput).getFile());
		}

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
	}
}
