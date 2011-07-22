package de.itemis.xtext.utils.jface.viewers.util;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.edit.domain.EditingDomain;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;

/**
 * Utility operations to access the currently active (i.e. open) editor as well
 * as its underlying emf resource.
 * 
 * @author nyssen
 * 
 */
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

	public static final IEditorPart getActiveEditor() {
		ActiveEditorResolver activeEditorResolver = new ActiveEditorResolver();
		Display.getDefault().syncExec(activeEditorResolver);
		return activeEditorResolver.getResult();
	}

	public static final Resource getActiveEditorResource() {
		IEditorPart editor = getActiveEditor();

		EditingDomain domain = null;
		if (editor instanceof IEditingDomainProvider) {
			domain = ((IEditingDomainProvider) editor).getEditingDomain();
		} else if (editor.getAdapter(IEditingDomainProvider.class) != null) {
			domain = ((IEditingDomainProvider) editor
					.getAdapter(IEditingDomainProvider.class))
					.getEditingDomain();
		} else if (editor.getAdapter(EditingDomain.class) != null) {
			domain = (EditingDomain) editor.getAdapter(EditingDomain.class);
		}
		if (domain == null) {
			return null;
		}

		EList<Resource> resources = domain.getResourceSet().getResources();
		if (resources.size() != 1) {
			throw new IllegalStateException(
					"Different resources in resource set , don't know which to use...");
		}
		return resources.get(0);

	}
}