package org.yakindu.sct.ui.editor.providers;

import org.eclipse.gmf.runtime.common.ui.util.IWorkbenchPartDescriptor;
import org.eclipse.gmf.runtime.diagram.ui.providers.DiagramContributionItemProvider;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.actions.ActionFactory;

import de.itemis.gmf.runtime.commons.actions.LockableGlobalRedoAction;
import de.itemis.gmf.runtime.commons.actions.LockableGlobalUndoAction;

public class StatechartDiagramContributionItemProvider extends
		DiagramContributionItemProvider {
	
	@Override
	protected IAction createAction(String actionId,
			IWorkbenchPartDescriptor partDescriptor) {
		IWorkbenchPage workbenchPage = partDescriptor.getPartPage();
		if (actionId.equals(ActionFactory.UNDO.getId()))
			return new LockableGlobalUndoAction(workbenchPage);
		if (actionId.equals(ActionFactory.REDO.getId()))
			return new LockableGlobalRedoAction(workbenchPage);
		return super.createAction(actionId, partDescriptor);
	}
}