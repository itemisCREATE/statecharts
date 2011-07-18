package de.itemis.xtext.utils.jface.viewers.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IFileEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public final class ActiveProjectResolver implements
		RunnableWithResult<IProject> {

	IProject activeProject = null;

	public void run() {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
		if (activePage != null) {
			IEditorInput editorInput = activePage.getActiveEditor()
					.getEditorInput();
			if (editorInput instanceof IFileEditorInput) {
				IFileEditorInput input = (IFileEditorInput) editorInput;
				activeProject = input.getFile().getProject();
			}
		}
	}

	public IProject getResult() {
		return activeProject;
	}
}