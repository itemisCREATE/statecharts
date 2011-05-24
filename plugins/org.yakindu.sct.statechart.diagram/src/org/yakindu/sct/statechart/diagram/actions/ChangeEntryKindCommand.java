package org.yakindu.sct.statechart.diagram.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.yakindu.model.sct.statechart.Entry;
import org.yakindu.model.sct.statechart.EntryKind;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.editparts.EntryEditPart;

/**
 * Abstract base class for {@link IActionDelegate} that change the entry kind of
 * an Entry.
 * 
 * @author muelder
 * 
 */
public abstract class ChangeEntryKindCommand implements IActionDelegate {

	private Entry entry;

	public abstract EntryKind getEntryKind();

	/**
	 * Unwraps the given selection
	 * 
	 * @param selection
	 * @return
	 */
	public Entry unwrap(ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object firstElement = structuredSelection.getFirstElement();
		if (firstElement == null)
			return null;
		return ((EntryEditPart) firstElement).resolveSemanticElement();
	}

	public void run(IAction action) {
		if (entry == null)
			return;
		SetValueCommand setCommand = new SetValueCommand(new SetRequest(entry,
				StatechartPackage.Literals.ENTRY__KIND, getEntryKind()));
		try {
			setCommand.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
	}

	public void selectionChanged(IAction action, ISelection selection) {
		entry = unwrap(selection);
		if (entry == null)
			return;
		if (entry.getKind().equals(getEntryKind())) {
			action.setEnabled(false);
			action.setChecked(true);
		} else {
			action.setEnabled(true);
			action.setChecked(false);
		}
	}
}
