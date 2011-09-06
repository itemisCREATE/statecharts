package de.itemis.gmf.runtime.commons.actions;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.operations.OperationHistoryActionHandler;
import org.eclipse.ui.operations.RedoActionHandler;

import de.itemis.gmf.runtime.commons.actions.LockableGlobalUndoRedoAction;

public class LockableGlobalRedoAction extends LockableGlobalUndoRedoAction {

	/**
	 * Initializes me with a workbench page.
	 * 
	 * @param workbenchPage
	 *            the page
	 */
	public LockableGlobalRedoAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}

	/**
	 * Initializes me with a workbench part.
	 * 
	 * @param workbenchPart
	 *            the part
	 */
	public LockableGlobalRedoAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);
	}

	public String getActionId() {
		return GlobalActionId.REDO;
	}

	@Override
	protected OperationHistoryActionHandler getOperationHistoryActionHandler(
			IWorkbenchPartSite site, IUndoContext context) {
		return new RedoActionHandler(site, context);
	}
}
