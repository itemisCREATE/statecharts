package org.yakindu.sct.statechart.diagram.policies;

import java.util.List;

import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.Assert;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.emf.ecore.resource.Resource.Diagnostic;
import org.eclipse.gef.commands.Command;
import org.eclipse.gef.editpolicies.DirectEditPolicy;
import org.eclipse.gef.requests.DirectEditRequest;
import org.eclipse.gmf.runtime.diagram.ui.commands.ICommandProxy;
import org.eclipse.gmf.runtime.diagram.ui.editparts.IGraphicalEditPart;
import org.eclipse.gmf.runtime.emf.type.core.commands.SetValueCommand;
import org.eclipse.gmf.runtime.emf.type.core.requests.SetRequest;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.ui.editor.validation.MarkerCreator;
import org.eclipse.xtext.validation.IDiagnosticConverter;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.Issue.Severity;
import org.yakindu.model.sct.statechart.StatechartPackage;
import org.yakindu.sct.statechart.diagram.validation.GMFMarkerUtil;
import org.yakindu.sct.statechart.diagram.validation.IMarkerType;
import org.yakindu.sct.statechart.diagram.validation.XTextMarkerCreator;

import com.google.inject.Inject;

import de.itemis.xtext.utils.gmf.directedit.IXTextAwareEditPart;
import de.itemis.xtext.utils.gmf.directedit.XTextCellEditor;

/**
 * 
 * @author muelder
 * 
 */
public class ExpressionDirectEditPolicy extends DirectEditPolicy implements
		IMarkerType {

	@Inject
	private IDiagnosticConverter converter;

	@Override
	protected Command getDirectEditCommand(DirectEditRequest request) {
		Assert.isTrue(request.getCellEditor() instanceof XTextCellEditor);
		XTextCellEditor cellEditor = (XTextCellEditor) request.getCellEditor();
		createMarkers(cellEditor.getDiagnostics());
		SetValueCommand command = new SetValueCommand(new SetRequest(getHost()
				.resolveSemanticElement(),
				StatechartPackage.Literals.EXPRESSION_ELEMENT__EXPRESSION,
				cellEditor.getValue()));
		return new ICommandProxy(command);
	}

	private void createMarkers(List<Diagnostic> diagnostics) {
		final IFile target = GMFMarkerUtil.getTargetFile(getHost()
				.getNotationView());
		if (target != null) {
			try {
				target.deleteMarkers(MARKER_TYPE, true, IResource.DEPTH_ZERO);
			} catch (CoreException e) {
				e.printStackTrace();
			}
		}

		final String elementId = getHost().getNotationView().eResource()
				.getURIFragment(getHost().getNotationView());
		IDiagnosticConverter.Acceptor acceptor = new IDiagnosticConverter.Acceptor() {
			
			public void accept(Issue issue) {
				if (issue == null)
					return;
				try {

					XTextMarkerCreator.createMarker(issue, target, MARKER_TYPE,
							elementId);
				} catch (CoreException e) {
					e.printStackTrace();
				}
			}
		};
		for (Diagnostic diagnostic : diagnostics) {
			converter.convertResourceDiagnostic(diagnostic, Severity.ERROR,
					acceptor);
		}
	}

	@Override
	public IGraphicalEditPart getHost() {
		return (IGraphicalEditPart) super.getHost();
	}

	@Override
	protected void showCurrentEditValue(DirectEditRequest request) {
		String value = (String) request.getCellEditor().getValue();
		((IXTextAwareEditPart) getHost()).setLabelText(value);
	}

}
