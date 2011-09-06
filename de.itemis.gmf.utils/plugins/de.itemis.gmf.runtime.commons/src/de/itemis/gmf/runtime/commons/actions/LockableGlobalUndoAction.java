package de.itemis.gmf.runtime.commons.actions;

import org.eclipse.core.commands.operations.IUndoContext;
import org.eclipse.gmf.runtime.common.ui.action.global.GlobalActionId;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchPartSite;
import org.eclipse.ui.operations.OperationHistoryActionHandler;
import org.eclipse.ui.operations.UndoActionHandler;

import de.itemis.gmf.runtime.commons.actions.LockableGlobalUndoRedoAction;

public class LockableGlobalUndoAction extends LockableGlobalUndoRedoAction {
	
	/**
	 * Initializes me with a workbench page.
	 * 
	 * @param workbenchPage
	 *            the page
	 */
	public LockableGlobalUndoAction(IWorkbenchPage workbenchPage) {
		super(workbenchPage);
	}

	/**
	 * Initializes me with a workbench part.
	 * 
	 * @param workbenchPart
	 *            the part
	 */
	public LockableGlobalUndoAction(IWorkbenchPart workbenchPart) {
		super(workbenchPart);
	}

	public String getActionId() {
		return GlobalActionId.UNDO;
	}

	@Override
	protected OperationHistoryActionHandler getOperationHistoryActionHandler(
			IWorkbenchPartSite site, IUndoContext context) {
		return new UndoActionHandler(site, context);
	}
}
