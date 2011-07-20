package de.itemis.xtext.utils.jface.viewers.util;

import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

public final class ActiveEditorResolver implements
		RunnableWithResult<IEditorPart> {

	IEditorPart activeEditor = null;

	public void run() {
		IWorkbenchWindow activeWorkbenchWindow = PlatformUI.getWorkbench()
				.getActiveWorkbenchWindow();
		IWorkbenchPage activePage = activeWorkbenchWindow.getActivePage();
		if (activePage != null) {
			activeEditor = activePage.getActiveEditor();
		}
	}

	public IEditorPart getResult() {
		return activeEditor;
	}
}