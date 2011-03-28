package de.itemis.xtext.utils.gmf.directedit;

import java.util.List;

import org.eclipse.core.runtime.Assert;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.xtext.parser.IParseResult;

/**
 * The {@link DirectEditPolicy} used for XText Direct Editing.
 * 
 * @author muelder
 * 
 */
public abstract class XTextDirectEditPolicy<T extends EObject> extends DirectEditPolicy {
	
	@SuppressWarnings("unchecked")
	protected Command getDirectEditCommand(DirectEditRequest edit) {
		Assert.isTrue(edit.getCellEditor() instanceof XTextCellEditor);
		XTextCellEditor cellEditor = (XTextCellEditor) edit.getCellEditor();
		//TODO: We have to create Problem Markers for errors 
		@SuppressWarnings("unused")
		List<Diagnostic> diagnostics = cellEditor.getDiagnostics();
		IParseResult result = cellEditor.getParseResult();
		return getDirectEditCommand(edit, (T)result.getRootASTElement());
	}


	protected abstract Command getDirectEditCommand(DirectEditRequest edit,
			T rootASTElement);

	/**
	 * @see DirectEditPolicy#showCurrentEditValue(DirectEditRequest)
	 */
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		((IXTextAwareEditPart) getHost()).setLabelText(value);
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

}
