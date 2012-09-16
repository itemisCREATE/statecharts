package org.yakindu.sct.ui.editor.utils;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.Path;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.ui.IEditorDescriptor;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.part.FileEditorInput;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.ui.editor.XtextEditor;

public class InteractionUtil {

	public InteractionUtil() {
		// TODO Auto-generated constructor stub
	}

	static public void openElement(EObject obj) {
		if (obj != null) {
			URI uri = EcoreUtil.getURI(obj);
			IFile file = ResourcesPlugin.getWorkspace().getRoot()
					.getFile(new Path(uri.toPlatformString(true)));
			IEditorPart editor = null;
			try {
				IEditorDescriptor desc = PlatformUI.getWorkbench()
						.getEditorRegistry().getDefaultEditor(file.getName());

				final IWorkbenchPage wbPage = PlatformUI.getWorkbench()
						.getActiveWorkbenchWindow().getActivePage();
				editor = wbPage.openEditor(new FileEditorInput(file),
						desc.getId());

				if (editor instanceof XtextEditor) {
					INode node = NodeModelUtils.findActualNodeFor(obj);
					if (node != null) {
						((XtextEditor) editor).selectAndReveal(
								node.getOffset(), node.getLength());
					}
				}

				// BreadcrumbEditorUtil.openEditor(file);
			} catch (PartInitException e) {
				e.printStackTrace();
			}
		}
	}

}
