package de.itemis.xtext.utils.jface.viewers.util;

import org.eclipse.core.resources.IProject;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IFileEditorInput;

public final class ActiveProjectResolver implements
		RunnableWithResult<IProject> {

	IProject activeProject = null;

	public void run() {
		final ActiveEditorResolver resolver = new ActiveEditorResolver();
		resolver.run();
		final IEditorPart activeEditor = resolver.getResult();

		if (activeEditor != null) {
			IEditorInput editorInput = activeEditor.getEditorInput();
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