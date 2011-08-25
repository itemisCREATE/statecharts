package org.yakindu.sct.ui.navigator;

import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.navigator.ILinkHelper;

public class NavigatorLinkHelper implements ILinkHelper {

	public NavigatorLinkHelper() {
	}
	
	
//	private static IEditorInput getEditorInput(Diagram diagram) {
//		Resource diagramResource = diagram.eResource();
//		for (Iterator<EObject> it = diagramResource.getContents().iterator(); it.hasNext();) {
//			EObject nextEObject = (EObject)it.next();
//			if (nextEObject == diagram) {
//				return new FileEditorInput(WorkspaceSynchronizer.getFile(diagramResource));
//			}
//			if (nextEObject instanceof Diagram) {
//				break;
//			}
//		}
//		URI uri = EcoreUtil.getURI(diagram);
//		String editorName = uri.lastSegment() + "#" + diagram.eResource().getContents().indexOf(diagram);
//		IEditorInput editorInput = new URIEditorInput(uri, editorName);
//		return editorInput;
//	}

	public IStructuredSelection findSelection(IEditorInput anInput) {
//		IEditorPart activeEditor = ActiveEditorResolver.getActiveEditor();
//		if(activeEditor instanceof DiagramDocumentEditor){
//			Diagram diagram = ((DiagramDocumentEditor) activeEditor)
//					.getDiagram();
//			IFile file = WorkspaceSynchronizer.getFile(diagram.eResource());
//			if (file != null) {
//				DomainNavigatorItem item = new DomainNavigatorItem(diagram, file, false);
//				return new StructuredSelection(item);
//			}
//		}
		return StructuredSelection.EMPTY;
	}

	public void activateEditor(IWorkbenchPage aPage, IStructuredSelection aSelection) {
//		if (aSelection == null || aSelection.isEmpty()) {
//			return;
//		}
//		if (false == aSelection.getFirstElement() instanceof AbstractNavigatorItem) {
//			return;
//		}
//
//		AbstractNavigatorItem abstractNavigatorItem = (AbstractNavigatorItem)aSelection.getFirstElement();
//		View navigatorView = null;
//		if (abstractNavigatorItem instanceof NavigatorItem) {
//			navigatorView = ((NavigatorItem)abstractNavigatorItem).getView();
//		} else if (abstractNavigatorItem instanceof NavigatorGroup) {
//			NavigatorGroup navigatorGroup = (NavigatorGroup)abstractNavigatorItem;
//			if (navigatorGroup.getParent() instanceof NavigatorItem) {
//				navigatorView = ((NavigatorItem)navigatorGroup.getParent()).getView();
//			}
//		}
//		if (navigatorView == null) {
//			return;
//		}
//		IEditorInput editorInput = getEditorInput(navigatorView.getDiagram());
//		IEditorPart editor = aPage.findEditor(editorInput);
//		if (editor == null) {
//			return;
//		}
//		aPage.bringToTop(editor);
//		if (editor instanceof DiagramEditor) {
//			DiagramEditor diagramEditor = (DiagramEditor)editor;
//			ResourceSet diagramEditorResourceSet = diagramEditor.getEditingDomain().getResourceSet();
//			EObject selectedView = diagramEditorResourceSet.getEObject(EcoreUtil.getURI(navigatorView), true);
//			if (selectedView == null) {
//				return;
//			}
//			GraphicalViewer graphicalViewer = (GraphicalViewer)diagramEditor
//					.getAdapter(GraphicalViewer.class);
//			EditPart selectedEditPart = (EditPart)graphicalViewer.getEditPartRegistry().get(selectedView);
//			if (selectedEditPart != null) {
//				graphicalViewer.select(selectedEditPart);
//			}
//		}
	}

}
