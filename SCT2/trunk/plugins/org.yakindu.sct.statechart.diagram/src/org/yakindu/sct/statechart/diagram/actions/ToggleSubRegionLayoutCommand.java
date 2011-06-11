package org.yakindu.sct.statechart.diagram.actions;

import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.gmf.runtime.notation.BooleanValueStyle;
import org.eclipse.gmf.runtime.notation.NotationPackage;
import org.eclipse.gmf.runtime.notation.View;
import org.eclipse.jface.action.IAction;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IActionDelegate;
import org.yakindu.sct.statechart.diagram.editparts.StateEditPart;

/**
 * Action that toggles the alignment flag in the notation view element
 * 
 * @author andreas muelder
 * 
 */
public class ToggleSubRegionLayoutCommand implements IActionDelegate {

	private View view;

	public void run(IAction arg0) {
		BooleanValueStyle style = (BooleanValueStyle) view
				.getStyle(NotationPackage.Literals.BOOLEAN_VALUE_STYLE);
		SetValueCommand setCommand = new SetValueCommand(new SetRequest(style,
				NotationPackage.Literals.BOOLEAN_VALUE_STYLE__BOOLEAN_VALUE,
				!style.isBooleanValue()));
		try {
			setCommand.execute(new NullProgressMonitor(), null);
		} catch (ExecutionException e) {
			e.printStackTrace();
		}

	}

	protected View unwrap(ISelection selection) {
		IStructuredSelection structuredSelection = (IStructuredSelection) selection;
		Object firstElement = structuredSelection.getFirstElement();
		if (firstElement == null)
			return null;
		return ((StateEditPart) firstElement).getNotationView();
	}

	public void selectionChanged(IAction arg0, ISelection selection) {
		view = unwrap(selection);
	}

}
