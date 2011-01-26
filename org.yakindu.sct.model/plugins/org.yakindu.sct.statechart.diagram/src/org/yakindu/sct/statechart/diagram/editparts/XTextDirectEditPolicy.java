package org.yakindu.sct.statechart.diagram.editparts;

import org.eclipse.core.runtime.Assert;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.yakindu.sct.statechart.diagram.xtext.integration.IXTextAwareEditPart;
import org.yakindu.sct.statechart.diagram.xtext.integration.XTextCellEditor;

/**
 * The {@link DirectEditPolicy} used for XText Direct Editing.
 * 
 * @author muelder
 * 
 */
public class XTextDirectEditPolicy extends DirectEditPolicy {

	protected Command getDirectEditCommand(DirectEditRequest edit) {
		Assert.isTrue(edit.getCellEditor() instanceof XTextCellEditor);
		XTextCellEditor cellEditor = (XTextCellEditor) edit.getCellEditor();
		String value = (String) cellEditor.getValue();
		if (value == null)
			return null;

		IGraphicalEditPart editPart = getHost();
		Assert.isTrue(editPart instanceof IXTextAwareEditPart);
		IXTextAwareEditPart xTextEditPart = (IXTextAwareEditPart) editPart;

		SetRequest request = new SetRequest(editPart.resolveSemanticElement(),
				xTextEditPart.getTextFeature(), value);
		SetValueCommand setCommand = new SetValueCommand(request);
		return new ICommandProxy(setCommand);
	}

	/**
	 * @see DirectEditPolicy#showCurrentEditValue(DirectEditRequest)
	 */
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		((IXTextAwareEditPart) getHost()).getLabel().setText(value);
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

}
